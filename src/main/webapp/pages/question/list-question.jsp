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
<input type="hidden" id="url" value="${ctx}/question/list">

<div id="main">
    <div class="sort_switch">
        <ul id="TabsNav">
            <li class="selected"><a href="#">试题列表</a></li>
        </ul>
    </div>

<%--    <div class="operation_content">
      <button id="btn_add_examPlace" class="input_button1" onclick="openAddPage();">新增</button>
    </div>--%>

    <div class="operation_content">
        所属章节名称： <input class="input_text1" type="text" name="cChapterNameSearchkey" id="cChapterNameSearchkey"/>
        所属知识点名称： <input class="input_text1" type="text" name="cEpNameSearchkey" id="cEpNameSearchkey"/>
        试题名称： <input class="input_text1" type="text" name="cQNameSearchkey" id="cQNameSearchkey"/>
        <button id="btn_add_question" class="input_button1" onclick="getList(1,20,'${ctx}/question/list');">查询</button>
    </div>

    <div class="sort_content">
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0">
            <tr>
                <td width="8%"><strong>试题编号</strong></td>
                <td width="35%"><strong>试题标题正文</strong></td>
                <td width="15%"><strong>所属知识点名称</strong></td>
                <td width="15%"><strong>所属章节名称</strong></td>
                <td width="15%"><strong>最后更新时间</strong></td>
                <td width="12%"><strong>操作</strong></td>
            </tr>
<%--            <tbody id="">--%>
<%--            <c:forEach items="${list}" var="entity">--%>
<%--                <tr>--%>
<%--                    <td>${entity.cQuesId}</td>--%>
<%--                    <td>${entity.cQuesTitle}</td>--%>
<%--                    <td><fmt:formatDate value="${entity.cUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
<%--                    <td><a href="edit?cQuesId=${entity.cQuesId}">编辑</a> | <a href="delete?cQuesId=${entity.cQuesId}">删除</a></td>--%>
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
                <td width="8%">{{(e.cQuesId==null?"":e.cQuesId)}}</td>
                <td width="35%">{{(e.cQuesTitle==null?"":e.cQuesTitle)}}</td>
                <td width="15%">{{(e.cEpName==null?"":e.cEpName)}}</td>
                <td width="15%">{{(e.cChName==null?"":e.cChName)}}</td>
                <td width="15%">{{(e.cUpdateTime==null?"":e.cUpdateTime)}}</td>'
                <td class="caozuo" width="12%" style="text-align: left;">
                    <a class="edit" href="${ctx}/question/edit?cQuesId={{e.cQuesId}}">编辑</a> |
                    <a class="delete" href="${ctx}/question/delete?cQuesId={{e.cQuesId}}">删除</a>
                </td>
            </tr>
            {{# })} }}
        </script>
    </div>
    <div class="page" id="pagesDiv" style="display: none"></div>
</div>
</body>
</html>
