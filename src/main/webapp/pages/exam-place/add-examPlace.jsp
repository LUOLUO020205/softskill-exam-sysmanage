<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新增知识点</title>
    <script type="text/javascript">
        function notNull() {
            if ($("#cEpName").val()=="") {
                alert("知识点名称不能为空！");
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>

<body>
<form method="post" action="${ctx}/exam-place/saveOrUpdate">
    <div id="main">
        <div class="sort_switch">
            <ul id="TabsNav">
                <li class="selected"><a href="#">新增知识点</a></li>
            </ul>
        </div>
        <div id="tagContent0" class="sort_content">
            <div class="currency_area hue9">
                <div class="the_content">
                    <table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0"
                                    cellpadding="0">
                            <tbody>
                            <input type="hidden" id="cChId" name="cChId" value="${model.cChId}"/>
                            <input type="hidden" id="cEpId" name="cEpId" value="${model.cEpId}"/>
                            <tr>
                                <td width="15%" class="title1">知识点名称：</td>
                                <td class="left">
                                    <input class="input_text1" type="text" name="cEpName" id="cEpName" value="${model.cEpName}" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"/>
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
