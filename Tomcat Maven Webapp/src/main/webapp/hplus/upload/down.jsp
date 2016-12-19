<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 文件上传</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
	<script src="<%=path %>/hplus/js/jquery.min.js?v=2.1.4"></script>
</head>

<body>
	<div>
		1.Spring mvc 下载文件
	</div>
	 <h1>springMVC字节流输入上传文件</h1>   
    <form name="userForm1" action="<%=path %>/Upload/download"  method="post">  
        <input type="text" name="fileName" value="" >  
        <input type="submit" value="下载" >  
    </form>   
    <br>  
    <br>  
    <hr align="left" width="60%" color="#FF0000" size="3">  
    <br>  
    <br>  
     <h1>springMVC包装类上传文件</h1>   
    <form name="userForm2" action="<%=path %>/Upload/upload2" enctype="multipart/form-data" method="post"">  
        <div id="newUpload2">  
            <input type="file" name="file">  
        </div>  
        <input type="button" id="btn_add2" value="增加一行" >  
        <input type="submit" value="上传" >  
          
          
    </form>   
</body>
<script type="text/javascript">  
    i = 1;  
    j = 1;  
    $(document).ready(function(){  
          
        $("#btn_add1").click(function(){  
            document.getElementById("newUpload1").innerHTML+='<div id="div_'+i+'"><input  name="file" type="file"  /><input type="button" value="删除"  onclick="del_1('+i+')"/></div>';  
              i = i + 1;  
        });  
          
        $("#btn_add2").click(function(){  
            document.getElementById("newUpload2").innerHTML+='<div id="div_'+j+'"><input  name="file_'+j+'" type="file"  /><input type="button" value="删除"  onclick="del_2('+j+')"/></div>';  
              j = j + 1;  
        });  
    });  
  
    function del_1(o){  
     document.getElementById("newUpload1").removeChild(document.getElementById("div_"+o));  
    }  
      
    function del_2(o){  
         document.getElementById("newUpload2").removeChild(document.getElementById("div_"+o));  
    }  
  
</script>  

</html>