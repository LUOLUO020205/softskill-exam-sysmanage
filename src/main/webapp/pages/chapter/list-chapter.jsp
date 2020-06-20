<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <script type="text/javascript" src="${ctx}/js/common/defaultLoad.js?v=${vn}"></script>
</head>
<body>

<%--页面值，无需作为ajax参数--%>
<input type="hidden" id="pageIndex" value="1">
<input type="hidden" id="pageSize" value="20">
<input type="hidden" id="url" value="${ctx}/chapter/list">

<div id="main">

    <%--页面值，需作为ajax参数--%>
    <input type="hidden" id="couseId" name="couseId" value="1">

    <div class="sort_switch">
        <ul id="TabsNav">
            <li class="selected"><a href="#">章节列表</a></li>
        </ul>
    </div>

    <div class="operation_content">
        所属课程名称： <input class="input_text1" type="text" name="cCourseNameSearchkey" id="cCourseNameSearchkey"/>
        章节名称： <input class="input_text1" type="text" name="cChapterNameSearchkey" id="cChapterNameSearchkey"/>
        <button id="btn_search_chapter" class="input_button1" onclick="getList(1,20,'${ctx}/chapter/list');">查询</button>
        <button id="btn_add_chapter" class="input_button1" onclick="window.location.href='${ctx}/chapter/add'">新增</button>
    </div>

    <div class="sort_content">
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%"><strong>章节编号</strong></td>
                <td width="15%"><strong>章节名称</strong></td>
                <td width="15%"><strong>所属课程名称</strong></td>
                <td width="10%"><strong>章节排序</strong></td>
                <td width="15%"><strong>创建时间</strong></td>
                <td width="15%"><strong>更新时间</strong></td>
                <td width="20%"><strong>操作</strong></td>
            </tr>
        </table>
<%--            <tbody id="">--%>
<%--            <c:forEach items="${list}" var="entity">--%>
<%--                <tr>--%>
<%--                    <td>${entity.cChId}</td>--%>
<%--                    <td>${entity.cChName}</td>--%>
<%--                    <td>${entity.cCourseSortnum}</td>--%>
<%--                    <td><fmt:formatDate value="${entity.cCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>--%>
<%--                    <td><fmt:formatDate value="${entity.cUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>--%>
<%--                    <td><a href="edit?cChId=${entity.cChId}">编辑</a> | <a href="delete?cChId=${entity.cChId}">删除</a> | <a href="${ctx}/exam-place/add?cChId=${entity.cChId}">新增知识点</a></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0" id="ListBodyId">
        </table>
        <script type="text/html" id="ListTemp">
            {{# if(d !=null && d.data !=null && d.data.length>0){ }}
            {{# $(d.data).each(function(i,e){  }}
            {{# var createTime =  e.cCreateTime;}}
            <tr>
                <td width="10%">{{(e.cChId==null?"":e.cChId)}}</td>
                <td width="15%">{{(e.cChName==null?"":e.cChName)}}</td>
                <td width="15%">{{(e.cCrName==null?"":e.cCrName)}}</td>
                <td width="10%">{{(e.cCourseSortnum==null?"":e.cCourseSortnum)}}</td>'
                <td width="15%">{{(e.cCreateTime==null?"":e.cCreateTime)}}</td>
                <td width="15%">{{(e.cUpdateTime==null?"":e.cUpdateTime)}}</td>
                <td class="caozuo" width="20%" style="text-align: left;">
                    <a class="edit" href="${ctx}/chapter/edit?cChId={{e.cChId}}">编辑</a> |
                    <a class="delete" href="${ctx}/chapter/delete?cChId={{e.cChId}}">删除</a> |
                    <a class="add" href="${ctx}/exam-place/add?cChId={{e.cChId}}">新增知识点</a>
                </td>
            </tr>
            {{# })} }}
        </script>
    </div>

    <div class="page" id="pagesDiv" style="display: none"></div>
</div>
</body>
</html>
