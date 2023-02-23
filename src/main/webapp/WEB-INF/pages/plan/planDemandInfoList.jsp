<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<%@ include file="/views/include/head.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
	function page(n){
		$("#pageNo").val(n);
		$("#searchForm").submit();
       	return false;
       }
</script>
</head>

<body>
	<div class="container-fluid">
		<ul class="nav nav-tabs">
			<li class="active"><a href="${adminPath}/planDemandInfo?method=list">列表</a></li>
			<c:if test="${login.role != '3'}">
			<li><a href="${adminPath}/planDemandInfo?method=form">添加</a></li>
			</c:if>
		</ul>
		<br />
		<c:if test="">
			<div class="alert alert-warning alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <strong>提示!</strong> ${msg}
			</div>
		</c:if>
		<form class="form-inline" id="searchForm" action="${adminPath}/planDemandInfo?method=list" method="post">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo }">
			
				<div class="form-group">
				<label for="requirementItemNo">需求项编号</label>
					<input type="text" class="form-control" name="requirementItemNo" id="requirementItemNo" placeholder="请输入需求项编号" value="${requirementItemNo}">
				</div>
				<div class="form-group">
				<label for="experimentName">实验名</label>
					<input type="text" class="form-control" name="experimentName" id="experimentName" placeholder="请输入实验名" value="${experimentName}">
				</div>
			<div class="form-group">
				<label for="applicantDepartment">申请人部门</label>
				<select class="form-control" id="applicantDepartment" name="applicantDepartment">
					<option value="">-请选择-</option>
					<c:forEach items="${fns:getTableData('sys_dept_info', 'id', 'dept_name')}" var="item">
						<option value="${item.value}" <c:if test="${applicantDepartment == item.value}">selected</c:if> >${item.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="nameOfApplicant">申请人姓名</label>
				<select class="form-control" id="nameOfApplicant" name="nameOfApplicant">
					<option value="">-请选择-</option>
					<c:forEach items="${fns:getTableData('db_user', 'id', 'name')}" var="item">
						<option value="${item.value}" <c:if test="${nameOfApplicant == item.value}">selected</c:if> >${item.name}</option>
					</c:forEach>
				</select>
			</div>
			
			<button type="submit" class="btn btn-primary btn-sm">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				查询
			</button>
		</form>
		<br />
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>需求项编号</th>
					<th>实验名</th>
					<th>实验描述</th>
					<th>初审日期</th>
					<th>初审员</th>
					<th>申请人部门</th>
					<th>申请人姓名</th>
					<th>申请日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list }" var="planDemandInfo" varStatus="num">
					<tr>
						<td>${num.index+1+page.pageSize*(page.pageNo-1) }</td>
						
						<td>
							${planDemandInfo.requirementItemNo}
						</td>
						<td>
							${planDemandInfo.experimentName}
						</td>
						<td>
							${planDemandInfo.experimentalDescription}
						</td>
						<td>
							<fmt:formatDate value="${planDemandInfo.dateOfPreliminaryReview}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							${planDemandInfo.preliminaryExaminer}
						</td>
						<td>
							${fns:getTableDataByPk("sys_dept_info", "id", planDemandInfo.applicantDepartment, "dept_name")}
						</td>
						<td>
							${fns:getTableDataByPk("db_user", "id", planDemandInfo.nameOfApplicant, "name")}
						</td>
						<td>
							<fmt:formatDate value="${planDemandInfo.applicationDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						
						
						<td>
							<a href="${adminPath }/bookMakes?method=list&requirementItemNo=${planDemandInfo.id}">
								<button class="btn btn-primary btn-xs">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									方案制定书
								</button>
							</a>
							<c:if test="${login.role != '3'}">
							<a href="${adminPath }/planDemandInfo?method=form&id=${planDemandInfo.id}">
								<button class="btn btn-primary btn-xs">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
							</a>
							<a href="${adminPath }/planDemandInfo?method=delete&id=${planDemandInfo.id}" onclick="return confirm('确认要删除吗？', this.href)">
								<button class="btn btn-danger btn-xs">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									删除
								</button>
							</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		<%@ include file="/views/include/pageinfo.jsp"%>
	</div>
</body>
</html>






































