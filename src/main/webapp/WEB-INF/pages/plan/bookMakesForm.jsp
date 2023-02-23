<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="/views/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>主页</title>
    <%@ include file="/views/include/head.jsp" %>
    <%@ include file="/views/include/validation.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submitForm").validate({
                rules: {
                    schemeNo: {
                        required: true
                    },
                    schemeDescription: {
                        required: true
                    },
                    schemeProgramRules: {
                        required: true
                    },
                    requirementItemNo: {
                        required: true
                    },
                },
                messages: {
                    schemeNo: {
                        required: "方案编号必填"
                    },
                    schemeDescription: {
                        required: "方案描述必填"
                    },
                    schemeProgramRules: {
                        required: "方案细则必填"
                    },
                    requirementItemNo: {
                        required: "需求编号必填"
                    },
                }
            })
        });
    </script>

    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>

<body>
<div class="container-fluid">

    <ul class="nav nav-tabs">
        <li><a href="${adminPath}/bookMakes?method=list&requirementItemNo=${bookMakesBean.requirementItemNo}">制定书列表</a>
        </li>

        <c:if test="${bookMakesBean.id == null}">
            <li class="active"><a
                    href="${adminPath}/bookMakes?method=form&id=${bookMakesBean.id}&requirementItemNo=${bookMakesBean.requirementItemNo}">新增制定书</a>
            </li>
        </c:if>
        <c:if test="${bookMakesBean.id != null}">
            <li class="active"><a
                    href="${adminPath}/bookMakes?method=form&id=${bookMakesBean.id}&requirementItemNo=${bookMakesBean.requirementItemNo}">修改制定书</a>
            </li>
            <li><a href="${adminPath}/bookMakes?method=fixList&schemeNo=${bookMakesBean.schemeNo}">修改记录</a></li>
            <li><a href="${adminPath}/auditRecords?method=list&schemeNo=${bookMakesBean.schemeNo}">审核记录</a></li>
        </c:if>
    </ul>
    <br/>
    <c:if test="${bookMakesBean.id == null || bookMakesBean.planStatus == '0' || bookMakesBean.planStatus == '2'}">
        <form class="form-horizontal" id="submitForm" role="form" action="${adminPath}/bookMakes?method=save"
              method="post">
            <input type="hidden" name="id" value="${bookMakesBean.id}">
            <input type="hidden" name="schemeNo" value="${bookMakesBean.schemeNo}">
            <div class="form-group">
                <label for="requirementItemNo" class="col-sm-3 control-label">需求编号<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                    <select class="form-control" id="requirementItemNo" name="requirementItemNo">
                        <option value="">-请选择-</option>
                        <c:forEach items="${fns:getTableData('plan_demand_info', 'id', 'experiment_name')}" var="item">
                            <option value="${item.value}"
                                    <c:if test="${bookMakesBean.requirementItemNo == item.value}">selected</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="schemeDescription" class="col-sm-3 control-label">方案描述<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                <textarea rows="3" class="form-control" id="schemeDescription"
                          name="schemeDescription">${bookMakesBean.schemeDescription}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="schemeProgramRules" class="col-sm-3 control-label">方案细则<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                <textarea rows="10" class="form-control" id="schemeProgramRules"
                          name="schemeProgramRules">${bookMakesBean.schemeProgramRules}</textarea>
                </div>
            </div>
            <div class="form-group" style="display: none">
                <label for="schemeFormulator" class="col-sm-3 control-label">制定员<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                    <select class="form-control" id="schemeFormulator" name="schemeFormulator">
                        <option value="">-请选择-</option>
                        <c:forEach items="${fns:getTableData('db_user', 'id', 'name')}" var="item">
                            <option value="${item.value}"
                                    <c:if test="${bookMakesBean.schemeFormulator == item.value}">selected</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
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
    </c:if>

    <c:if test="${bookMakesBean.id != null && bookMakesBean.planStatus != '0' && bookMakesBean.planStatus != '2'}">
        <form class="form-horizontal" id="submitForm" role="form" action="${adminPath}/auditRecords?method=save"
              method="post">
            <input type="hidden" name="id" value="${bookMakesBean.id}">
            <input type="hidden" name="schemeNo" value="${bookMakesBean.schemeNo}">
            <div class="form-group">
                <label for="requirementItemNo" class="col-sm-3 control-label">需求编号<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                    <select class="form-control" name="requirementItemNo" disabled>
                        <option value="">-请选择-</option>
                        <c:forEach items="${fns:getTableData('plan_demand_info', 'id', 'experiment_name')}" var="item">
                            <option value="${item.value}"
                                    <c:if test="${bookMakesBean.requirementItemNo == item.value}">selected</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="schemeDescription" class="col-sm-3 control-label">方案描述<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                <textarea rows="3" class="form-control" disabled
                          name="schemeDescription">${bookMakesBean.schemeDescription}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="schemeProgramRules" class="col-sm-3 control-label">方案细则<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                <textarea rows="10" class="form-control" disabled
                          name="schemeProgramRules">${bookMakesBean.schemeProgramRules}</textarea>
                </div>
            </div>
            <div class="form-group" style="display: none">
                <label for="schemeFormulator" class="col-sm-3 control-label">制定员<b style="color: red;">*</b></label>
                <div class="col-sm-5">
                    <select class="form-control" name="schemeFormulator" disabled>
                        <option value="">-请选择-</option>
                        <c:forEach items="${fns:getTableData('db_user', 'id', 'name')}" var="item">
                            <option value="${item.value}"
                                    <c:if test="${bookMakesBean.schemeFormulator == item.value}">selected</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <c:if test="${bookMakesBean.planStatus != '4'}">

                <div class="form-group">
                    <label for="schemeDescription" class="col-sm-3 control-label">审批结果<b
                            style="color: red;">*</b></label>
                    <div class="col-sm-5">
                        <c:forEach items="${fns:dictList('audit_status')}" var="dict">
                            <label class="radio-inline">
                                <input type="radio" name="auditStatus" value="${dict.dictValue}"
                                       checked> ${dict.dictLabel}
                            </label>
                        </c:forEach>
                    </div>
                </div>

                <div class="form-group">
                    <label for="schemeDescription" class="col-sm-3 control-label">审批意见<b
                            style="color: red;">*</b></label>
                    <div class="col-sm-5">
                        <textarea rows="3" class="form-control" name="cchemeReviewComments"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"></label>
                    <div class="col-sm-5">
                        <input type="submit" class="btn btn-success btn-sm" value="保存">
                        <input type="button" class="btn btn-default btn-sm" value="返回" onclick="history.go(-1)">
                    </div>
                </div>
            </c:if>
        </form>
    </c:if>
</div>
</body>
</html>













































































