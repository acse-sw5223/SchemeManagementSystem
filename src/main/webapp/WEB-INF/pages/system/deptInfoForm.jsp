<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<%@ include file="/views/include/head.jsp"%>
<%@ include file="/views/include/validation.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#submitForm").validate({
			rules : {
								deptName: {
					required : true
				},
			},
			messages : {
				deptName: {
					required : "部门名称必填"
				},
			}
		})
	});
</script>

<style type="text/css">
	.error{  color:red; }
</style>
</head>

<body>
	<div class="container-fluid">

		<ul class="nav nav-tabs">
			<li><a href="${adminPath}/deptInfo?method=list">列表</a></li>
			<li class="active"><a href="${adminPath}/deptInfo?method=form&id=${deptInfoBean.id}">添加</a></li>
		</ul>
		<br />
		<form class="form-horizontal" id="submitForm" role="form" action="${adminPath}/deptInfo?method=save" method="post">
			<input type="hidden" name="id" value="${deptInfoBean.id}">
			 
			 <div class="form-group">
			 	<label for="deptName" class="col-sm-3 control-label">部门名称<b style="color: red;">*</b></label>
			 	<div class="col-sm-5">
		 			<input type="text" class="form-control" id="deptName" name="deptName" placeholder="请输入部门名称" value="${deptInfoBean.deptName}">
		    	</div>
			 </div>
			 <div class="form-group">
			 	<label for="deptDesc" class="col-sm-3 control-label">部门描述</label>
			 	<div class="col-sm-5">
		 			<textarea rows="3" class="form-control" id="deptDesc" name="deptDesc" required>${deptInfoBean.deptDesc}</textarea>
		    	</div>
			 </div>
			  

			 <div class="form-group">
			    <label for="sort" class="col-sm-3 control-label"></label>
			    <div class="col-sm-5">
			      	<input type="submit" class="btn btn-success btn-sm" value="保存">
			      	<input type="button" class="btn btn-default btn-sm" value="返回" onclick="history.go(-1)">
			    </div>
			 </div>
		</form>
	</div>
</body>
</html>













































































