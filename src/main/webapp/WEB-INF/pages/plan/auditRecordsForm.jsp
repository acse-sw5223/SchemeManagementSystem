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
								schemeNo: {
					required : true
				},
				schemeAuditDate: {
					required : true
				},
				cchemeReviewComments: {
					required : true
				},
				schemeReviewer: {
					required : true
				},
			},
			messages : {
				schemeNo: {
					required : "方案编号必填"
				},
				schemeAuditDate: {
					required : "审核日期必填"
				},
				cchemeReviewComments: {
					required : "审核意见必填"
				},
				schemeReviewer: {
					required : "审核人必填"
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
			<li><a href="${adminPath}/auditRecords?method=list">列表</a></li>
			<li class="active"><a href="${adminPath}/auditRecords?method=form&id=${auditRecordsBean.id}">添加</a></li>
		</ul>
		<br />
		<form class="form-horizontal" id="submitForm" role="form" action="${adminPath}/auditRecords?method=save" method="post">
			<input type="hidden" name="id" value="${auditRecordsBean.id}">
			 
			 <div class="form-group">
			 	<label for="schemeNo" class="col-sm-3 control-label">方案编号<b style="color: red;">*</b></label>
			 	<div class="col-sm-5">
		 			<input type="text" class="form-control" id="schemeNo" name="schemeNo" placeholder="请输入方案编号" value="${auditRecordsBean.schemeNo}">
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













































































