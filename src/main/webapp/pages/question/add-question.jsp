<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新增试题</title>
    <script type="text/javascript">

        function notNull() {
            if ($("#cQuesTitle").val()=="") {
                alert("问题标题不能为空！");
                return false;
            }
            if ($("#cQoContent1").val()==""
                ||$("#cQoContent2").val()==""
                ||$("#cQoContent3").val()==""
                ||$("#cQoContent4").val()=="") {
                alert("选项不能为空！");
                return false;
            }
            if ($("input[name='cCorrectOptionId']:checked").val()==undefined) {
                alert("正确选项不能为空！");
                return false;
            }
            return true;
        }

        $(function(){
            $("#judgeQuestionResultDiv").css("display","none");
        });
    </script>
</head>

<body>
<form method="post" action="${ctx}/question/saveOrUpdate">
    <div id="main">
        <div class="sort_switch">
            <ul id="TabsNav">
                <li class="selected"><a href="#">新增试题</a></li>
            </ul>
        </div>
        <div id="tagContent0" class="sort_content">
            <div class="currency_area hue9">
                <div class="the_content">
                    <table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0"
                                    cellpadding="0">
                            <tbody>
                            <input type="hidden" id="cQuesId" name="cQuesId" value="${model.cQuesId}"/>
                            <input type="hidden" id="cChId" name="cChId" value="${model.cChId}"/>
                            <input type="hidden" id="cEpId" name="cEpId" value="${model.cEpId}"/>
                            <tr>
                                <td width="15%" class="title1">问题标题：</td>
                                <td class="left">
                                    <input class="input_text2" type="text" name="cQuesTitle" id="cQuesTitle" value="${model.cQuesTitle}" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"/>
                                </td>
                            </tr>
                            <tr>
                                <td width="15%" class="title1">问题类型：</td>
                                <td class="left">
                                    <input class="ui-icon-radio-on"  type="radio" name="cQuesType" id="cQuesTypeA" value="0"
                                           <c:if test="${model.cQuesType=='0'||model.cQuesType==null}">checked="checked"</c:if>/>选择题
                                    <input class="ui-icon-radio-off" type="radio" name="cQuesType" id="cQuesTypeB" value="1"
                                           <c:if test="${model.cQuesType=='1'}">checked="checked"</c:if>/>判断正误题
                                    <input class="ui-icon-radio-off" type="radio" name="cQuesType" id="cQuesTypeC" value="2"
                                           <c:if test="${model.cQuesType=='2'}">checked="checked"</c:if>/>案例题
                                </td>
                            </tr>
                            <tr>
                                <td width="15%" class="title1">是否英语题：</td>
                                <td class="left">
                                    <input class="ui-icon-radio-on"  type="radio" name="cIsEnglish" id="cIsEnglishA" value="0"
                                           <c:if test="${model.cIsEnglish=='0'||model.cIsEnglish==null}">checked="checked"</c:if>/>否
                                    <input class="ui-icon-radio-off" type="radio" name="cIsEnglish" id="cIsEnglishB" value="1"
                                           <c:if test="${model.cIsEnglish=='1'}">checked="checked"</c:if>/>是
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!--答案区：选择题-->
                <div class="the_content" id="optionQuestionResultDiv">
                    <table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0"
                           cellpadding="0">
                        <tbody>
                        <c:forEach items="${list}" var="item" varStatus="vs"> <!--编辑场景-->
                            <tr>
                                <td width="15%" class="title1"><input type="radio" name="cCorrectOptionId" id="cCorrectOptionId${vs.index}" value="${vs.index}"
                                        <c:if test="${item.cQoId==model.cCorrectOptionId}">checked="checked"</c:if>
                                />选项${vs.index+1}：</td>
                                <td class="left">
                                    <input type="hidden" name="cQoIds" id="cQoId${vs.index}" value="${item.cQoId}"/>
                                    <textarea class="textarea_text" name="cQoContents" id="cQoContent${vs.index}">${item.cQoContent}</textarea>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty list}"> <!--新增场景-->
                            <tr>
                                <!--这里的选项不按照A、B、C、D保存-->
                                <td width="15%" class="title1"><input type="radio" name="cCorrectOptionId" id="cCorrectOptionId1" value="0"/>选项1：</td>
                                <td class="left">
                                    <textarea class="textarea_text" name="cQoContents" id="cQoContent1" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="15%" class="title1"><input type="radio" name="cCorrectOptionId" id="cCorrectOptionId2" value="1"/>选项2：</td>
                                <td class="left">
                                    <textarea class="textarea_text" name="cQoContents" id="cQoContent2" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="15%" class="title1"><input type="radio" name="cCorrectOptionId" id="cCorrectOptionId3" value="2"/>选项3：</td>
                                <td class="left">
                                    <textarea class="textarea_text" name="cQoContents" id="cQoContent3" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="15%" class="title1"><input type="radio" name="cCorrectOptionId" id="cCorrectOptionId4" value="3"/>选项4：</td>
                                <td class="left">
                                    <textarea class="textarea_text" name="cQoContents" id="cQoContent4"  onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"></textarea>
                                </td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
                <!--答案区：判断题-->
                <div class="the_content" id="judgeQuestionResultDiv">
                    <table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0"
                           cellpadding="0">
                        <tbody>
                            <tr>
                                <td width="15%" class="title1">答案：</td>
                                <td class="left">
                                    <input class="ui-icon-radio-on"   type="radio" name="cCorrectValue" id="cCorrectValue1" value="1" checked="checked"/>正确
                                    <input class="ui-icon-radio-off"  type="radio" name="cCorrectValue" id="cCorrectValue2" value="0"/>错误
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!--答案区：判断题-->
                <div class="the_content" id="subjectiveQuestionResultDiv">
                    <table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0"
                           cellpadding="0">
                        <tbody>
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
