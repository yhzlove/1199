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


    <title>H+ 后台主题UI框架 - 表单向导</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="<%=path %>/hplus/favicon.ico"> 
    <link href="<%=path %>/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/hplus/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/plugins/steps/jquery.steps.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
	
	<script src="<%=path %>/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/hplus/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/hplus/js/plugins/staps/jquery.steps.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/validate/messages_zh.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/from/jquery.form.js?v=3.51.0"></script>
    <script src="<%=path %>/hplus/js/plugins/layer/layer-v2.4/layer.js?v=2.4"></script>
    <script src="<%=path %>/hplus/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/validate/messages_zh.min.js"></script>
</head>

<body class="gray-bg">
    <div class="ibox-content">
           <form class="form-horizontal m-t" id="signupForm" action="<%=request.getContextPath()%>/user/addEntity">
               <div class="form-group">
                   <label class="col-sm-3 control-label">用户名：</label>
                   <div class="col-sm-8">
                       <input id="userName" name="userName" class="form-control" type="text" required="true" minlength=2>
                       <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>
                   </div>
               </div>
               
               <div class="form-group">
                   <label class="col-sm-3 control-label">登入名：</label>
                   <div class="col-sm-8">
                       <input id="loginName" name="loginName" class="form-control" type="text" required="true" minlength=2 >
                   </div>
               </div>
               <div class="form-group">
                   <label class="col-sm-3 control-label">密码：</label>
                   <div class="col-sm-8">
                       <input id="password" name="password" class="form-control" type="password">
                   </div>
               </div>
               
               <div class="form-group">
                   <label class="col-sm-3 control-label">确认密码：</label>
                   <div class="col-sm-8">
                       <input id="confirm_password" name="confirm_password" class="form-control" type="password">
                       <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>
                   </div>
               </div>
               
<!--                <div class="form-group"> -->
<!--                    <label class="col-sm-3 control-label">E-mail：</label> -->
<!--                    <div class="col-sm-8"> -->
<!--                        <input id="email" name="email" class="form-control" type="email"> -->
<!--                    </div> -->
<!--                </div> -->
<!--                <div class="form-group"> -->
<!--                    <div class="col-sm-8 col-sm-offset-3"> -->
<!--                        <div class="checkbox"> -->
<!--                            <label> -->
<!--                                <input type="checkbox" class="checkbox" id="agree" name="agree"> 我已经认真阅读并同意《H+使用协议》 -->
<!--                            </label> -->
<!--                        </div> -->
<!--                    </div> -->
<!--                </div> -->
               <div class="form-group">
                   <div class="col-sm-8 col-sm-offset-3">
                       <button class="btn btn-primary" type="submit">提交</button>
                   </div>
               </div>
           </form>
      </div>
    
</body>
<script>
$.validator.setDefaults({
    submitHandler: function() {
      alert("提交事件!");
      fromAjax();
    }
});
$(function () {
//     $("#signupForm").validate();
    $("#signupForm").validate(
		{
			rules:{
// 				username:{required:!0,minlength:2},
// 				loginName:{required:!0,minlength:2},
				loginName:{
					remote:"<%=request.getContextPath()%>/user/validateUserName"
				},
				password:{required:!0,minlength:5},
				confirm_password:{required:!0,minlength:5,equalTo:"#password"},
// 				email:{required:!0,email:!0},
// 				topic:{required:"#newsletter:checked",minlength:2},
// 				agree:"required"
			},
			messages:{
				userName:{required:"请输入您的用户名",minlength:"用户名必须两个字符以上"},
				loginName:{required:"请输入您的登入名",minlength:"登入名必须两个字符以上",remote: "用户名已被占用"},
				password:{required:"请输入您的密码",minlength:"密码必须5个字符以上"},
				confirm_password:{required:"请再次输入密码",minlength:"密码必须5个字符以上",equalTo:"两次输入的密码不一致"},
// 				email:"请输入您的E-mail",
// 				agree:{required:"必须同意协议后才能注册",element:"#agree-error"}
			}
		});
});

function fromAjax(){

	$("#signupForm").ajaxSubmit({
		type : "post",
		dataType : "json",
		success: function(data){  
                     //alert( "success");
                     console.log(data);
                     
                     if (data.success) {
						layer.confirm('添加成功!是否关闭窗口?', function(index) {
							parent.loadData();
							//parent.layer.close(parent.layer.getFrameIndex(window.name));
							parent.layer.close(parent.addpage);
							return false;
						});
						//$("#form")[0].reset();
					} else {
						layer.alert('添加失败！', 3);
					}
                 },
         error:function (e){
         	alert(0)
         }
	});
}
</script>

</html>