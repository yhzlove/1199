package com.y.web.controller;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;  
import java.io.UnsupportedEncodingException;  
import java.math.BigDecimal;
import java.net.URLDecoder;  
import java.util.Date;  
import java.util.Iterator;  
  





import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.swing.filechooser.FileNameExtensionFilter;  
  





import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.multipart.MultipartFile;  
import org.springframework.web.multipart.MultipartHttpServletRequest;  
import org.springframework.web.multipart.commons.CommonsMultipartFile;  
import org.springframework.web.multipart.commons.CommonsMultipartResolver;  
import org.springframework.web.servlet.ModelAndView;  

@Controller
@RequestMapping("/Upload/")
public class UploadController {
	
	 @RequestMapping("/upload1"   )  
	    public String addUser(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request){  
	          
		 	System.out.println(request.getParameter("t"));//能够获取到参数值
	        for(int i = 0;i<files.length;i++){  
	            System.out.println("fileName---------->" + files[i].getOriginalFilename());  
	          
	            if(!files[i].isEmpty()){  
	                int pre = (int) System.currentTimeMillis();  
	                try {  
	                    //拿到输出流，同时重命名上传的文件  
	                	String path = request.getSession().getServletContext().getRealPath("/");
	                	path = path+"/"+ new Date().getTime() + files[i].getOriginalFilename();
	                    FileOutputStream os = new FileOutputStream(path);  
	                    //拿到上传文件的输入流  
	                    //FileInputStream in = (FileInputStream) files[i].getInputStream(); //Exception  异常信息 
	                    InputStream in = files[i].getInputStream();  
	                      
	                    //以写字节的方式写文件  
	                    int b = 0;  
	                    while((b=in.read()) != -1){  
	                        os.write(b);  
	                    }  
	                    os.flush();  
	                    os.close();  
	                    in.close();  
	                    int finaltime = (int) System.currentTimeMillis();  
	                    System.out.println(finaltime - pre);  
	                      
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                    System.out.println("上传出错");  
	                }  
	        }  
	        }  
	        return "/success";  
	    }  
	      
	 /*
	     * 采用file.Transto 来保存上传的文件
	     */
//	    @RequestMapping("fileUpload2")
//	    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
//	         long  startTime=System.currentTimeMillis();
//	        System.out.println("fileName："+file.getOriginalFilename());
//	        String path="D:/"+new Date().getTime()+file.getOriginalFilename();
//	         
//	        File newFile=new File(path);
//	        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
//	        file.transferTo(newFile);
//	        long  endTime=System.currentTimeMillis();
//	        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
//	        return "/success"; 
//	    }
	    @RequestMapping("/upload2"  )  
	    public String upload2(HttpServletRequest request) throws IllegalStateException, IOException {  
	        //创建一个通用的多部分解析器  
	    	//ServletContext servletContext = request.getSession().getServletContext();//ShiroHttpSession
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){  
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //取得request中的所有文件名  
	            Iterator<String> iter = multiRequest.getFileNames();  
	            while(iter.hasNext()){  
	                //记录上传过程起始时的时间，用来计算上传时间  
	                int pre = (int) System.currentTimeMillis();  
	                //取得上传文件  
	                MultipartFile file = multiRequest.getFile(iter.next());  
	                if(file != null){  
	                    //取得当前上传文件的文件名称  
	                    String myFileName = file.getOriginalFilename();  
	                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
	                    if(myFileName.trim() !=""){  
	                        System.out.println(myFileName);  
	                        //重命名上传后的文件名  
	                        //String fileName = "demoUpload\\" + file.getOriginalFilename();  
	                        //定义上传路径  
	                        //String path = "D:/" + fileName;  
	                        String path = request.getSession().getServletContext().getRealPath("/");
	                        path = path+"/hplus/upload/uploadFile/"+myFileName;
	                        System.out.println(path);
	                        File localFile = new File(path);  
	                        file.transferTo(localFile);  
	                    }  
	                }  
	                //记录上传该文件后的时间  
	                int finaltime = (int) System.currentTimeMillis();  
	                System.out.println(finaltime - pre);  
	            }  
	              
	        }  
	        //return "/success";  
	        return null;  
	    }  
	      
	    @RequestMapping("/toUpload" )   
	    public String toUpload() {  
	          
	        return "/upload/upload";  
	    }  
	     
	    
	    @RequestMapping("/download")
		public String download(String fileName, HttpServletRequest request,
				HttpServletResponse response) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachment;fileName="
					+ fileName);
			try {
				String path = Thread.currentThread().getContextClassLoader()
						.getResource("").getPath()
						+ "download";//这个download目录为啥建立在classes下的
				System.out.println(path);
				System.out.println(File.separator);//windows是\，unix是/
				path = request.getSession().getServletContext().getRealPath("/");
                path = path+"/hplus/upload/uploadFile/";
				File file = new File(path + File.separator + fileName);
				InputStream inputStream = new FileInputStream(file);

				OutputStream os = response.getOutputStream();
				byte[] b = new byte[2048];
				int length;
				while ((length = inputStream.read(b)) > 0) {
					os.write(b, 0, length);
				}

				 // 这里主要关闭。
				os.close();

				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	            //  返回值要注意，要不然就出现下面这句错误！
	            //java+getOutputStream() has already been called for this response
			return null;
		}
	    
	    
	    public static void main(String[] args) {
	    	String str= "500222658978.45489";
	    	float f = Float.valueOf(str);
	    	System.out.println(f);
	    	BigDecimal bd = new BigDecimal(f);  
	    	System.out.println(bd.toPlainString());
		}
	}

