<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div class="easyui-layout" data-options="fit:true">
	<!-- 65=2+24*2+5*3 -->
	<div data-options="region:'north'" style="height:65px;padding:5px 10px;">
		<div style="float:right;margin-right:550px;">
			<a id="button_form_dosearch"  onclick="searchData()" class="easyui-linkbutton" data-options="iconCls:'icon-search',iconAlign:'left'">查询</a>
		</div>
		<div>
			<input id="startTime" class="easyui-datebox" label="开始日期:" labelPosition="left" style="width:250px;">
			<input id="endTime" class="easyui-datebox" label="结束日期:" labelPosition="right" style="width:250px;">
		</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'">
				<table id="dg_project" class="easyui-datagrid" 
				data-options="rownumbers:true,striped:true,border:false,fit:true,fitColumns:true,pagination:true,remoteSort:false">
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="../js/r_list.js"></script>
</body>
</html>