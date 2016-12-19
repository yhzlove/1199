package com.y.AOP.logAop;  
  
//import com.model.Log;  
//import com.model.User;  
//import com.service.LogService;  
//import com.util.DateUtil;  
//import com.util.JSONUtil;  
//import com.util.SpringContextHolder;  
//import com.util.WebConstants;  
import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.annotation.*;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;  
import org.springframework.web.context.request.RequestContextHolder;  
import org.springframework.web.context.request.ServletRequestAttributes;  

import com.y.AOP.annotation.SystemControllerLog;
import com.y.AOP.annotation.SystemServiceLog;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;  

import java.lang.reflect.Method;  
  
/** 
 * 切点类 
 * @Aspect 来定义一个切面；
 * @Component是配合<context:component-scan/>，不然扫描不到；声明这是一个组件
 * @Order定义了该切面切入的顺序，因为在同一个切点，可能同时存在多个切面，那么在这多个切面之间就存在一个执行顺序的问题。
 * 该例子是一个切换数据源的切面，那么他应该在 事务处理 切面之前执行，所以我们使用 @Order(0) 来确保先切换数据源，然后加入事务处理。
 * @Order的参数越小，优先级越高，默认的优先级最低：
 * 
 */
@Aspect  
@Component
public  class SystemLogAspect {  
    
    //本地异常日志记录对象  
     private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);  
  
    //Controller层切点  
    @Pointcut("@annotation(com.y.AOP.annotation.SystemControllerLog)")  
     public  void controllerAspect() {  
    }  
    
    @Pointcut("@annotation(com.y.AOP.annotation.SystemServiceLog)")  
    public  void serviceAspect() {  
   } 
    /**
     * Spring 切面可应用的 5 种通知类型：
     * 	Before——在方法调用之前调用通知
     *	After——在方法完成之后调用通知，无论方法执行成功与否
     *	After-returning——在方法执行成功之后调用通知
     *	After-throwing——在方法抛出异常后进行通知
     *	Around——通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为
     */
    @Before("controllerAspect()")  
     public  void doBefore(JoinPoint joinPoint) {  
 
            System.out.println("---------=====Before前置通知开始=====----------");  
 
    }
    
    @After("controllerAspect()")  
    public  void doAfter(JoinPoint joinPoint) {  

           System.out.println("---------=====After前置通知开始=====----------");  

    }
    
//    @Around("controllerAspect()")  
//    public  void doAround(JoinPoint joinPoint) {  
//
//           System.out.println("---------=====Around通知=====----------");  
//
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /** 
     * 异常通知 用于拦截service层记录异常日志 
     * 
     * @param joinPoint 
     * @param e 
     */  
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")  
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {  
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();  
        //读取session中的用户  
        //User user = (User) session.getAttribute(WebConstants.CURRENT_USER);  
        //获取请求ip  
        String ip = request.getRemoteAddr();  
        //获取用户请求方法的参数并序列化为JSON格式字符串  
        String params = "";  
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
             for ( int i = 0; i < joinPoint.getArgs().length; i++) {  
                //params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";  
            }  
        }  
         try {  
              /*========控制台输出=========*/  
            System.out.println("=====异常通知开始=====");  
            System.out.println("异常代码:" + e.getClass().getName());  
            System.out.println("异常信息:" + e.getMessage());  
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));  
            //System.out.println("请求人:" + user.getName());  
            System.out.println("请求IP:" + ip);  
            System.out.println("请求参数:" + params);  
               /*==========数据库日志=========*/  
//            Log log = SpringContextHolder.getBean("logxx");  
//            log.setDescription(getServiceMthodDescription(joinPoint));  
//            log.setExceptionCode(e.getClass().getName());  
//            log.setType("1");  
//            log.setExceptionDetail(e.getMessage());  
//            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
//            log.setParams(params);  
//            log.setCreateBy(user);  
//            log.setCreateDate(DateUtil.getCurrentDate());  
//            log.setRequestIp(ip);  
//            //保存数据库  
//            logService.add(log);  
            System.out.println("=====异常通知结束=====");  
        }  catch (Exception ex) {  
            //记录本地异常日志  
            logger.error("==异常通知异常==");  
            logger.error("异常信息:{}", ex.getMessage());  
        }  
         /*==========记录本地异常日志==========*/  
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);  
  
    }  
  
  
    /** 
     * 获取注解中对方法的描述信息 用于service层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public  static String getServiceMthodDescription(JoinPoint joinPoint)  
             throws Exception {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();  
        String description = "";  
         for (Method method : methods) {  
             if (method.getName().equals(methodName)) {  
                Class[] clazzs = method.getParameterTypes();  
                 if (clazzs.length == arguments.length) {  
                    description = method.getAnnotation(SystemServiceLog. class).description();  
                     break;  
                }  
            }  
        }  
         return description;  
    }  
  
    /** 
     * 获取注解中对方法的描述信息 用于Controller层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();  
        String description = "";  
         for (Method method : methods) {  
             if (method.getName().equals(methodName)) {  
                Class[] clazzs = method.getParameterTypes();  
                 if (clazzs.length == arguments.length) {  
                    description = method.getAnnotation(SystemControllerLog. class).description();  
                     break;  
                }  
            }  
        }  
         return description;  
    }  
}  