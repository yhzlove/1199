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


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="<%=path %>/hplus/favicon.ico"> 
    <link href="<%=path %>/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/hplus/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    
	<script src="<%=path %>/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/hplus/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="<%=path %>/hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="<%=path %>/hplus/js/demo/bootstrap-table-demo.min.js"></script>
    
    <script src="<%=path %>/hplus/js/plugins/layer/layer-v2.4/layer.js?v=2.4"></script>
  </head>
  
  <body class="gray-bg">
  	<div class="wrapper wrapper-content animated fadeInRight">
  		<input type="button" class="btn btn-primary marR10" value="新增测试" id="adduser">
  		<input type="button" class="btn btn-primary marR10" value="新增测试_v" id="adduser_v"><br/>
  		ID:<input type="text" value="" id="userId">
  		用户名:<input type="text" value="" id="userName">
  		账号:<input type="text" value="" id="loginName">
  		<button type="button" style="margin-left:50px" onclick="loadData()" id="btn_query" class="btn btn-primary">查询</button>
		<table id="table">
		    <thead>
		    <tr>
		    	<th data-field="id">ID</th>
		        <th data-field="name">name</th>
		        <th data-field="parentId">parentId</th>
		        <th data-field="parentName">parentName</th>
		        <th data-field="resKey">resKey</th>
		        <th data-field="type">type</th>
		        <th data-field="resUrl">resUrl</th>
		        <th data-field="level">level</th>
		        <th data-field="icon">icon</th>
		        <th data-field="ishide">ishide</th>
		        <th data-field="description">description</th>
		    </tr>
		    </thead>
		</table>    
		
    </div>
    <script type="text/javascript">
    	
		var addpage = null;
		$(function () {
			/* 
				bootstrapTable不支持树形表格
				jqGrid支持子表格及树形表格  
			*/
		    $('#table').bootstrapTable({
		       	sidePagination: "server" ,//服务端处理分页
		        url:"<%=request.getContextPath()%>/resources/reslists",
		        pagination: true, //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
		        pageList: [5,10],
		        pageSize:10,
 				pageNumber:1,
 				queryParams:function queryParams(params) {
				            return {
				            	limit: params.limit,   //页面大小
            					offset: params.offset,  //页码
				            };
				        },
				 
		    });
		    $("#adduser").click(function(){
		    	var url = "<%=path%>/user/useradd";
		    	addpage = layer.open({
				            type: 2,
				            title: '很多时候，我们想最大化看，比如像这个页面。',
				            shadeClose: true,
				            shade: false,
				            maxmin: true, //开启最大化最小化按钮
				            area: ['650px', '350px'],
				            content: url
				   });
			})
			$("#adduser_v").click(function(){
		    	var url = "<%=path%>/user/useradd_v";
		    	addpage = layer.open({
				            type: 2,
				            title: '很多时候，我们想最大化看，比如像这个页面。',
				            shadeClose: true,
				            shade: false,
				            maxmin: true, //开启最大化最小化按钮
				            area: ['650px', '350px'],
				            content: url
				   });
// 		    	layer.open({
// 				    type: 2,
// 				    title: false,
// 				    closeBtn: false,
// 				    shade: [0],
// 				    area: ['340px', '215px'],
// 				    offset: 'rb', //右下角弹出
// 				    time: 2000, //2秒后自动关闭
// 				    shift: 2,
// 				    content: ['http://www.zi-han.net', 'no'], //iframe的url，no代表不显示滚动条
// 				    end: function(){ //此处用于演示
// 				        parent.layer.open({
// 				            type: 2,
// 				            title: '很多时候，我们想最大化看，比如像这个页面。',
// 				            shadeClose: true,
// 				            shade: false,
// 				            maxmin: true, //开启最大化最小化按钮
// 				            area: ['1150px', '650px'],
// 				            content: 'http://www.zi-han.net'
// 				        });
// 				    }
// 				});
			});
    	});
    	//刷新页面数据
    	function loadData(){
// 			$.ajax({
// 	             type: "POST",
// 	             url: "<%=request.getContextPath()%>/user/listJSON",
// 	             dataType: "json",
// 	             success: function(data){
// 	             	console.log(data);
// 	             	console.log(data.lstUsers);
// 					$('#table').bootstrapTable('destroy').bootstrapTable({
// 						data: data.lstUsers1
// 					});
// 	             },
// 	             error:function(){
// 	             	alert("error");
// 	             }
//          	});
			
			$('#table').bootstrapTable('refresh');
		
    	}
    </script>
    
  </body>
</html>
