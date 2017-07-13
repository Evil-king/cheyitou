<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>主页——Complex Layout</title>
	<link rel="stylesheet" type="text/css" href="../jeasyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jeasyui/themes/color.css">
	<link rel="stylesheet" type="text/css" href="../jeasyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../jeasyui/demo.css">
	<script type="text/javascript" src="../jeasyui/jquery.min.js"></script>
	<script type="text/javascript" src="../jeasyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../jeasyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../layer/layer.js"></script>
	
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;padding:10px">车易投管理后台</div>
	
	<div data-options="region:'west',split:true,title:'菜单导航'" style="width:200px;padding:10px;">
		<div id="accordion" class="easyui-accordion" style="width:500px;height:300px;" data-options="fit:true"></div>
	</div>
	
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;padding:10px;">south region</div>
	
	<div data-options="region:'center',title:'Center'">
	   <div id="tabs" class="easyui-tabs" style="width:700px;height:250px" data-options="fit:true,border:false,plain:true">
	   		<div title="首页"  style="padding:10px">
	   			<p><h3>欢迎进入车易投管理后台</h3></p>
	   		</div>
	   </div>
	</div>
	
	<script type="text/javascript" src="../js/index.js"></script>
</body>

</html>