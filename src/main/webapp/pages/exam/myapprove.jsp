<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>

    <link rel="stylesheet" href="${ctx}/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/main.css" type="text/css"/>


</head>

<body>

<div id="main">

    <div class="sort_switch">
        <ul id="TabsNav">
            <li class="selected"><a href="#">我的待办 </a></li>
        </ul>
    </div>

    <div class="sort_content">
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <td width="20%"><strong>任务发起者</strong></td>
                <td width="15%"><strong>创建时间</strong></td>
                <td width="15%"><strong>截止时间</strong></td>
                <td><strong>操作</strong></td>
            </tr>
            </thead>
            <tbody id="">
            <c:forEach items="${taskVOList}" var="taskVo">
                <tr>
                    <td>${taskVo.taskId}</td>
                    <td>${taskVo.createTime}</td>
                    <td>${taskVo.dueDate}</td>
                    <td><a href="${ctx}/approveTask/${taskVo.taskId}">审批</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>

</body>

</html>
