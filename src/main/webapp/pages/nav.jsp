<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>

    <link rel="stylesheet" href="${ctx}/css/style.css?v=${vn}" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/nav.css?v=${vn}" type="text/css"/>
    <script type="text/javascript" src="${ctx}/js/common/add.js?v=${vn}"></script>

</head>

<body>
<div class="admin_memu">
    <input type="hidden" value="${ctx}" id="ctx" />
    <ul id="nav">
        <li><a href="#" onclick="clickNav(this);return false;" class="parent" id="15"><h5><strong>功能</strong></h5></a>
            <ul id="opt_15" class="child_area">
                <li class="last"><a href="${ctx}/pages/course/list-course.jsp" target="mainFrame"><h6>课程维护</h6></a></li>
                <li class="last"><a href="${ctx}/pages/chapter/list-chapter.jsp" target="mainFrame"><h6>章节维护</h6></a></li>
                <li class="last"><a href="${ctx}/pages/exam-place/list-examPlace.jsp" target="mainFrame"><h6>知识点维护</h6></a></li>
                <li class="last"><a href="${ctx}/pages/question/list-question.jsp" target="mainFrame"><h6>试题维护</h6></a></li>
            </ul>
        </li>
    </ul>
</div>

</body>
<script>

    window.onload = function () {

    };

    function clickNav(a) {
        var childUl = document.getElementById("opt_" + a.id);
        if (childUl.style.display == "block" || childUl.style.display == "") {
            childUl.style.display = "none";
        } else {
            childUl.style.display = "block";
        }
    }

</script>
</html>
