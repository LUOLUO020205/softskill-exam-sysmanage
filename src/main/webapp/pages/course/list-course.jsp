﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
<input type="hidden" id="url" value="${ctx}/course/list">

<div id="main">
    <div class="sort_switch">
        <ul id="TabsNav">
            <li class="selected"><a href="#">课程记录 </a></li>
        </ul>
    </div>

    <div class="operation_content">
        课程名称： <input class="input_text1" type="text" name="cCourseNameSearchkey" id="cCourseNameSearchkey"/>
        <button id="btn_search_course" class="input_button1" onclick="getList(1,20,'${ctx}/course/list');">查询</button>
        <button id="btn_add_course" class="input_button1" onclick="window.location.href='${ctx}/pages/course/add-course.jsp'" >新增</button>
    </div>


    <div class="sort_content">
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%"><strong>课程编号</strong></td>
                <td width="20%"><strong>课程名称</strong></td>
                <td width="15%"><strong>创建时间</strong></td>
                <td width="15%"><strong>更新时间</strong></td>
                <td width="40%"><strong>操作</strong></td>
            </tr>
        </table>
        <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0" id="ListBodyId">
        </table>
        <script type="text/html" id="ListTemp">
            {{# if(d !=null && d.data !=null && d.data.length>0){ }}
            {{# $(d.data).each(function(i,e){  }}
            {{# var a = e.cCreateTime;  }}
            <tr>
                <td width="10%">{{(e.cCourseId==null?"":e.cCourseId)}}</td>
                <td width="20%">{{(e.cCourseName==null?"":e.cCourseName)}}</td>
                <td width="15%">{{(e.cCreateTime==null?"":e.cCreateTime)}}</td>
                <td width="15%">{{(e.cUpdateTime==null?"":e.cUpdateTime)}}</td>
                <td class="caozuo" width="40%" style="text-align: left;">
                    <a class="edit" href="${ctx}/course/edit?cCourseId={{e.cCourseId}}">编辑</a> |
                    <a class="delete" href="${ctx}/course/delete?cCourseId={{e.cCourseId}}">删除</a>
                </td>
            </tr>
            {{# })} }}
        </script>
    </div>
    <div class="page" id="pagesDiv" style="display: none"></div>
</div>
</body>
</html>
