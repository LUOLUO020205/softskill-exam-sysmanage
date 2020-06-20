<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新增章节</title>
    <script type="text/javascript">
        function notNull() {
            if ($("#cChName").val()==""
                ||$("#cCourseSortnum").val()=="") {
                alert("章节名称或排序值不能为空！");
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>

<body>
<form method="post" action="${ctx}/chapter/saveOrUpdate">
    <div id="main">
        <div class="sort_switch">
            <ul id="TabsNav">
                <li class="selected"><a href="#">新增章节</a></li>
            </ul>
        </div>
        <div id="tagContent0" class="sort_content">
            <div class="currency_area hue9">
                <div class="the_content">
                    <table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0"
                           cellpadding="0">
                        <tbody>
                        <input type="hidden" id="cChId" name="cChId" value="${model.cChId}"/>
                        <tr>
                            <td width="15%" class="title1">所属课程：</td>
                            <td class="left">
                                <select class="select_text" id="cCourseId" name="cCourseId">
                                     <c:forEach items="${courseList}" var="course">
                                         <option value="${course.cCourseId}"
                                                 <c:if test="${model.cCourseId==course.cCourseId}">selected="selected"</c:if>
                                         >${course.cCourseName}</option>
                                     </c:forEach>
                                </select>
                            </td>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%" class="title1">章节名称：</td>
                            <td class="left">
                                <input class="input_text1" type="text" name="cChName" id="cChName" value="${model.cChName}" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%" class="title1">章节排序（数字）：</td>
                            <td class="left">
                                <input class="input_text1" type="text" name="cCourseSortnum" id="cCourseSortnum" value="${model.cCourseSortnum}" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>

            <div class="fun_area" style="text-align:center;"><input type="submit" value="确 定" class="input_button1" onclick="return notNull()"/>
            </div>

        </div>
    </div>
</form>

</body>
</html>
