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
<input type="hidden" id="url" value="${ctx}/exam-place/list">

<div id="main">
    <div class="sort_switch">
        <ul id="TabsNav">
            <li class="selected"><a href="#">知识点列表</a></li>
        </ul>
    </div>

<%--    <div class="operation_content">
      <button id="btn_add_examPlace" class="input_button1" onclick="openAddPage();">新增</button>
    </div>--%>

    <div class="operation_content">
        所属章节名称： <input class="input_text1" type="text" name="cChapterNameSearchkey" id="cChapterNameSearchkey"/>
        知识点名称： <input class="input_text1" type="text" name="cEpNameSearchkey" id="cEpNameSearchkey"/>
        <button id="btn_add_examPlace" class="input_button1" onclick="getList(1,20,'${ctx}/exam-place/list');">查询</button>
    </div>

    <div class="sort_content">
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%"><strong>知识点编号</strong></td>
                <td width="20%"><strong>知识点名称</strong></td>
                <td width="20%"><strong>所属章节名称</strong></td>
                <td width="15%"><strong>创建时间</strong></td>
                <td width="15%"><strong>更新时间</strong></td>
                <td width="20%"><strong>操作</strong></td>
            </tr>
<%--            <tbody id="">--%>
<%--            <c:forEach items="${list}" var="entity">--%>
<%--                <tr>--%>
<%--                    <td>${entity.cEpId}</td>--%>
<%--                    <td>${entity.cEpName}</td>--%>
<%--                    <td>${entity.cChName}</td>--%>
<%--                    <td><fmt:formatDate value="${entity.cCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
<%--                    <td><fmt:formatDate value="${entity.cUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
<%--                    <td><a href="edit?cEpId=${entity.cEpId}">编辑</a> | <a href="delete?cEpId=${entity.cEpId}">删除</a> | <a href="${ctx}/question/add?cEpId=${entity.cEpId}&cChId=${entity.cChId}">新增试题</a> </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>
        </table>
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0" id="ListBodyId">
        </table>
        <script type="text/html" id="ListTemp">
            {{# if(d !=null && d.data !=null && d.data.length>0){ }}
            {{# $(d.data).each(function(i,e){  }}
            <tr>
                <td width="10%">{{(e.cEpId==null?"":e.cEpId)}}</td>
                <td width="20%">{{(e.cEpName==null?"":e.cEpName)}}</td>
                <td width="20%">{{(e.cChName==null?"":e.cChName)}}</td>'
                <td width="15%">{{(e.cCreateTime==null?"":e.cCreateTime)}}</td>
                <td width="15%">{{(e.cUpdateTime==null?"":e.cUpdateTime)}}</td>
                <td class="caozuo" width="20%" style="text-align: left;">
                    <a class="edit" href="${ctx}/exam-place/edit?cEpId={{e.cEpId}}">编辑</a> |
                    <a class="delete" href="${ctx}/exam-place/delete?cEpId={{e.cEpId}}">删除</a> |
                    <a class="delete" href="${ctx}/question/add?cEpId={{e.cEpId}}&cChId={{e.cChId}}">新增试题</a>
                </td>
            </tr>
            {{# })} }}
        </script>
    </div>
    <div class="page" id="pagesDiv" style="display: none"></div>
</div>
</body>
</html>
