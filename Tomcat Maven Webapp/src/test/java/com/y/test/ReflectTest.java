package com.y.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO java反射测试
		Model model = new Model();
		model.setId(12323);
		model.setName("adsafds");
		model.setPass("asfdsafsa");// 给对象赋值
		ReflectTest fd = new ReflectTest();
		fd.getField(model);
		System.out.println("---------------------");
		fd.getField1(model);
	}

	private void getField(Object model) {
		try {
			java.lang.reflect.Method[] method = model.getClass()
					.getDeclaredMethods();// 获取对象所有方法
			for (java.lang.reflect.Method m : method) {
				System.out.println(m.getName());
				if (m.getName().startsWith("get")) {// 获取get方法
					Object o = m.invoke(model);// 执行
					if (o == null || "".equals(o.toString())) {
						System.out.println("aaa");
					} else {
						System.out.println(o.toString());// 输出相应的属性值
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void getField1(Object model) throws IllegalArgumentException, IllegalAccessException {
		java.lang.reflect.Field[] fields = model.getClass().getDeclaredFields();
		for (java.lang.reflect.Field f : fields) {
			System.out.println(f.getName());
			String name = f.getName(); // 获取属性的名字
			Object value = getFieldValueByName(name,model);
			if (value != null && !"".equals(value)) {
				// 注意下面这句，不设置true的话，不能修改private类型变量的值
				f.setAccessible(true);
				f.set(model, value);
			}
		}
	}
	
	
	/** 
	* 使用反射根据属性名称获取属性值  
	*  
	* @param  fieldName 属性名称 
	* @param  o 操作对象 
	* @return Object 属性值 
	*/  
	  
	private Object getFieldValueByName(String fieldName, Object o)   
	{      
	   try   
	   {      
	       String firstLetter = fieldName.substring(0, 1).toUpperCase();      
	       String getter = "get" + firstLetter + fieldName.substring(1);      
	       Method method = o.getClass().getMethod(getter, new Class[] {});      
	       Object value = method.invoke(o, new Object[] {});      
	       return value;      
	   } catch (Exception e)   
	   {      
	       System.out.println("属性不存在");      
	       return null;      
	   }      
	}    
}
