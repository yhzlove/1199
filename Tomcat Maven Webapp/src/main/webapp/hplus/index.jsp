<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>H+ 后台主题UI框架 - 主页</title>

    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="<%=path %>/hplus/favicon.ico">
    <link href="<%=path %>/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/hplus/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
<!--         左侧导航开始 -->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        
                        <div class="logo-element">H+</div>
                    </li>
                    <c:forEach var="key" items="${list}" varStatus="s">
                    	
                    	<li>
                    		<c:if test="${empty key.children}">
                    			<a class="J_menuItem" href="layouts.html">
									<i class="fa fa-columns"></i> 
									<span class="nav-label">${key.name}</span>
								</a>
                    		</c:if>
                    		
                    		<c:if test="${not empty key.children}">
                    		
                    			<a href= "#">
		                    		<i class="fa fa-home"></i>
		                    		<span class="nav-label">${key.name}</span>
		                    		<span class="fa arrow"></span>
		                    	</a>
		                    	
		                    	<!-- 第二层 -->
		                    	<ul class="nav nav-second-level">
		                    	
		                    	<c:forEach var="second" items="${key.children}">
		                    		<c:if test="${empty second.children}">
		                    			<li>
		                                	<a class="J_menuItem" href="<%=path %>/user/list" >${second.name}</a>
		                            	</li>
		                    		</c:if>
		                    		<c:if test="${ not empty second.children}">
			                            <li>
			                                <a href="#">${second.name} <span class="fa arrow"></span></a>
			                                
			                                <!-- 第三层 -->
		                                	<ul class="nav nav-third-level">
		                                		<c:forEach var="third" items="${second.children}">
				                                    <li>
				                                    	<a class="J_menuItem" href="form_webuploader.html">${third.name}</a>
				                                    </li>
				                                 </c:forEach>
			                                </ul>
			                                
			                            </li>
		                    		</c:if>
		                    	</c:forEach>
		                    	</ul>
                    		</c:if>
	                    	
	                    </li>
                    </c:forEach>
                    
                    <li>
                    	<a href= "#">
                    		<!-- 图标 -->
                    		<i class="fa fa-home"></i>
                    		<span class="nav-label">系统管理</span>
                    		<!-- > -->
                    		<span class="fa arrow"></span>
                    	</a>
                    	<!-- 第二层 -->
                    	<ul class="nav nav-second-level">
                    		<li>
                                <a class="J_menuItem" href="<%=path %>/user/list" >用户管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="index_v1.html" >角色管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="index_v2.html" >菜单管理</a>
                            </li>
                    	</ul>
                    </li>
                    <li>
                    	<a href= "#">
                    		<!-- 图标 -->
                    		<i class="fa fa-home"></i>
                    		<span class="nav-label">系统管理</span>
                    		<!-- > -->
                    		<span class="fa arrow"></span>
                    	</a>
                    	<!-- 第二层 -->
                    	<ul class="nav nav-second-level">
                    		<li>
                                <a class="J_menuItem" href="<%=path %>/user/list" >用户管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="index_v1.html" >角色管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="index_v1.html" >菜单管理</a>
                            </li>
                    	</ul>
                    </li>
                    
                </ul>
            </div>
        </nav>
<!--         左侧导航结束 -->
<!--         右侧部分开始 -->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="http://www.zi-han.net/theme/hplus/search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        
                        <li class="dropdown hidden-xs">
                            <a class="right-sidebar-toggle" aria-expanded="false">
                                <i class="fa fa-tasks"></i> 主题
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="<%=path %>/index.jsp">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_v148b2.html?v=4.0" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
            <div class="footer">
                <div class="pull-right">&copy; 2014-2015 <a href="http://www.zi-han.net/" target="_blank">zihan's blog</a>
                </div>
            </div>
       </div>
<!--         右侧部分结束 -->
<!--         右侧边栏开始 -->

<!--         右侧边栏结束 -->
<!--         mini聊天窗口开始 -->
     </div>
    <script src="<%=path %>/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=path %>/hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/layer/layer.min.js"></script>
    <script src="<%=path %>/hplus/js/hplus.min.js?v=4.1.0"></script>
    <script type="text/javascript" src="<%=path %>/hplus/js/contabs.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/pace/pace.min.js"></script>
</body>


</html>
