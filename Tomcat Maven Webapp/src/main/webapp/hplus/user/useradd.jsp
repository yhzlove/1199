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
    <link href="<%=path %>/hplus/ss/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/plugins/steps/jquery.steps.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
	
	<script src="<%=path %>/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/hplus/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/hplus/js/plugins/staps/jquery.steps.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/validate/messages_zh.min.js"></script>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox">
                    
                    <div class="ibox-content">
                        <h2>
                                带验证的表单向导
                            </h2>
                        <p>
                            下面这个示例展示了如何在表单向导中使用 jQuery Validation 插件
                        </p>

                        <form id="form" action="http://www.zi-han.net/theme/hplus/form_wizard.html#" class="wizard-big">
                            <h1>账户</h1>
                            <fieldset>
                                <h2>账户信息</h2>
                                <div class="row">
                                    <div class="col-sm-8">
                                        <div class="form-group">
                                            <label>用户名 *</label>
                                            <input id="userName" name="userName" type="text" class="form-control required">
                                        </div>
                                        <div class="form-group">
                                            <label>密码 *</label>
                                            <input id="password" name="password" type="text" class="form-control required">
                                        </div>
                                        <div class="form-group">
                                            <label>确认密码 *</label>
                                            <input id="confirm" name="confirm" type="text" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="text-center">
                                            <div style="margin-top: 20px">
                                                <i class="fa fa-sign-in" style="font-size: 180px;color: #e5e5e5 "></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </fieldset>
                            <h1>个人资料</h1>
                            <fieldset>
                                <h2>个人资料信息</h2>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>姓名 *</label>
                                            <input id="name" name="name" type="text" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Email *</label>
                                            <input id="email" name="email" type="text" class="form-control required email">
                                        </div>
                                        <div class="form-group">
                                            <label>地址 *</label>
                                            <input id="address" name="address" type="text" class="form-control">
                                        </div>
                                    </div>
                                </div>
                            </fieldset>

                            <h1>警告</h1>
                            <fieldset>
                                <div class="text-center" style="margin-top: 120px">
                                    <h2>你是火星人 :-)</h2>
                                </div>
                            </fieldset>

                            <h1>完成</h1>
                            <fieldset>
                                <h2>条款</h2>
                                <input id="acceptTerms" name="acceptTerms" type="checkbox" class="required">
                                <label for="acceptTerms">我同意注册条款</label>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    
    <script>
        $(document).ready(function(){
        $("#form").steps({
        	bodyTag:"fieldset",
        	onStepChanging:function(event,currentIndex,newIndex){
        		if(currentIndex>newIndex){
        			return true
        		}
        		if(newIndex===3&&Number($("#age").val())<18){
        			return false
        		}
        		var form=$(this);
        		if(currentIndex<newIndex){
        			$(".body:eq("+newIndex+") label.error",form).remove();
        			$(".body:eq("+newIndex+") .error",form).removeClass("error")
        		}
        		form.validate().settings.ignore=":disabled,:hidden";
        		return form.valid()
        	},
        	onStepChanged:function(event,currentIndex,priorIndex){
	        	if(currentIndex===2&&Number($("#age").val())>=18){
	        		$(this).steps("next")
	        	}
	        	if(currentIndex===2&&priorIndex===3){
	        		$(this).steps("previous")
	        	}
        	},
        	onFinishing:function(event,currentIndex){
        		var form=$(this);
        		form.validate().settings.ignore=":disabled";
        		return form.valid()
        	},
        	onFinished:function(event,currentIndex){
        		var form=$(this);
        		form.submit()
        	}
        }).validate({
        	errorPlacement:function(error,element){
        		element.before(error)
        	},
        	rules:{
        		confirm:{
        			equalTo:"#password"
        		}
        	}
        })
       });
    </script>
</body>


</html>