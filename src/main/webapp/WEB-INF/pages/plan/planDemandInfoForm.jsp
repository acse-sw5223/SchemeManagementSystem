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
								requirementItemNo: {
					required : true
				},
				experimentName: {
					required : true
				},
				experimentalDescription: {
					required : true
				},
			},
			messages : {
				requirementItemNo: {
					required : "需求项编号必填"
				},
				experimentName: {
					required : "实验名必填"
				},
				experimentalDescription: {
					required : "实验描述必填"
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
			<li><a href="${adminPath}/planDemandInfo?method=list">列表</a></li>
			<li class="active"><a href="${adminPath}/planDemandInfo?method=form&id=${planDemandInfoBean.id}">添加</a></li>
		</ul>
		<br />
		<form class="form-horizontal" id="submitForm" role="form" action="${adminPath}/planDemandInfo?method=save" method="post">
			<input type="hidden" name="id" value="${planDemandInfoBean.id}">

			 <div class="form-group">
			 	<label for="experimentName" class="col-sm-3 control-label">实验名<b style="color: red;">*</b></label>
			 	<div class="col-sm-5">
		 			<input type="text" class="form-control" id="experimentName" name="experimentName" placeholder="请输入实验名" value="${planDemandInfoBean.experimentName}">
		    	</div>
			 </div>
			 <div class="form-group">
			 	<label for="experimentalDescription" class="col-sm-3 control-label">实验描述<b style="color: red;">*</b></label>
			 	<div class="col-sm-5">
		 			<textarea rows="3" class="form-control" id="experimentalDescription" name="experimentalDescription" >${planDemandInfoBean.experimentalDescription}</textarea>
		    	</div>
			 </div>
			 <div class="form-group">
			 	<label for="dateOfPreliminaryReview" class="col-sm-3 control-label">初审日期</label>
			 	<div class="col-sm-5">
		 			<input id="dateOfPreliminaryReview" name="dateOfPreliminaryReview" type="text" readonly="readonly" maxlength="20" class="form-control Wdate"
					value="<fmt:formatDate value="${planDemandInfoBean.dateOfPreliminaryReview}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
		    	</div>
			 </div>
			 <div class="form-group">
			 	<label for="preliminaryExaminer" class="col-sm-3 control-label">初审员</label>
			 	<div class="col-sm-5">
		 			<input type="text" class="form-control" id="preliminaryExaminer" name="preliminaryExaminer" placeholder="请输入初审员" value="${planDemandInfoBean.preliminaryExaminer}">
		    	</div>
			 </div>
			 <div class="form-group">
			 	<label for="applicantDepartment" class="col-sm-3 control-label">申请人部门</label>
			 	<div class="col-sm-5">
					<select class="form-control" id="applicantDepartment" name="applicantDepartment">
						<option value="">-请选择-</option>
                <c:forEach items="${fns:getTableData('sys_dept_info', 'id', 'dept_name')}" var="item">
						<option value="${item.value}" <c:if test="${planDemandInfoBean.applicantDepartment == item.value}">selected</c:if> >${item.name}</option>
						</c:forEach>
					</select>       
		    	</div>
			 </div>
			 <div class="form-group">
			 	<label for="nameOfApplicant" class="col-sm-3 control-label">申请人姓名</label>
			 	<div class="col-sm-5">
					<select class="form-control" id="nameOfApplicant" name="nameOfApplicant">
						<option value="">-请选择-</option>
                <c:forEach items="${fns:getTableData('db_user', 'id', 'name')}" var="item">
						<option value="${item.value}" <c:if test="${planDemandInfoBean.nameOfApplicant == item.value}">selected</c:if> >${item.name}</option>
						</c:forEach>
					</select>       
		    	</div>
			 </div>
			 <div class="form-group">
			 	<label for="applicationDate" class="col-sm-3 control-label">申请日期</label>
			 	<div class="col-sm-5">
		 			<input id="applicationDate" name="applicationDate" type="text" readonly="readonly" maxlength="20" class="form-control Wdate"
					value="<fmt:formatDate value="${planDemandInfoBean.applicationDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
		    	</div>
			 </div>
			  

			 <div class="form-group">
			    <label class="col-sm-3 control-label"></label>
			    <div class="col-sm-5">
			      	<input type="submit" class="btn btn-success btn-sm" value="保存">
			      	<input type="button" class="btn btn-default btn-sm" value="返回" onclick="history.go(-1)">
			    </div>
			 </div>
		</form>
	</div>
</body>
</html>













































































