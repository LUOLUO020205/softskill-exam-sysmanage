/**
 * 动态的生成页码标签
 * add by lifeng
 * @param pageIndex 当前第几页
 * @param pageSize 每页显示条数
 * @param recordCount 总记录数
 * @param ajaxFunction 异步获取获取列表并显示到页面中的方法名，
 * 		例如方法为getCMICMailListAjax(pageIndex,pageSize,url2);
 * 		那么ajaxFunction为：getCMICMailListAjax
 * 		注意:该方法有且仅有三个参数，分别为:pageIndex(第几页),pageSize(每页显示条数),url(异步请求的url，同getCMICMailListAjax方法中的url)
 * @param url 请求的url
 * @returns 封装好的翻页内容html
 */
function fillPages(pageIndex,pageSize,recordCount,ajaxFunction,url){
	//console.log("fillPages--pageIndex:"+pageIndex+"--pageSize:"+pageSize+"--recordCount"+recordCount+"--ajaxFunction:"+ajaxFunction+"--url:"+url);
	var totalPage = 0;
	var resEle = "";
	var str = "";
	if(recordCount>0){
		totalPage = parseInt((recordCount - 1) /pageSize) + 1;//计算总页数
		if(pageIndex == 1){//首页
			str += "<span class='pages_i'>&lt;</span>&nbsp";
			//计算中间页码
			str += calcPage(totalPage,pageIndex,pageSize,ajaxFunction,url);
			//下一页需不需要a标签
			if(pageIndex == totalPage){
				//只有一页
				str += "<span class='pages_i'>&gt;</span>";
			}else{
				str += "<a class='pages_i' href='javascript:"+ ajaxFunction +"("+(pageIndex+1)+","+pageSize+",\""+url+"\");'>&gt;</a>";
			}
		}else if(pageIndex == totalPage){//尾页
			str += "<a class='pages_i' href='javascript:"+ ajaxFunction +"("+(pageIndex-1)+","+pageSize+",\""+url+"\");'>&lt;</a>&nbsp;";
			//计算中间的页码
			str += calcPage(totalPage,pageIndex,pageSize,ajaxFunction,url);
			str += "<span class='pages_i' href='javascript:;'>&gt;</span>";
		}else{//中间
			str += "<a class='pages_i' href='javascript:"+ ajaxFunction +"("+(pageIndex-1)+","+pageSize+",\""+url+"\");'>&lt;</a>&nbsp;";
			str += calcPage(totalPage,pageIndex,pageSize,ajaxFunction,url);
			str += "<a class='pages_i' href='javascript:"+ ajaxFunction +"("+(pageIndex+1)+","+pageSize+",\""+url+"\");'>&gt;</a>";
		}
		
		/**拼接其他的信息*/
		var ajaxFunctionId = ajaxFunction;
		//如果方法名中包含"."则截取
		if(ajaxFunction.indexOf(".")!=-1){
			ajaxFunctionId = ajaxFunction.substring(ajaxFunction.indexOf(".")+1,ajaxFunction.length);
		}
		//
		resEle += '<span class="pages_tips">共 '+recordCount+' 条记录，每页显示</span>';
		resEle += '<div class="downSelectWrap" id="'+ajaxFunctionId+'_id">';
		resEle += '<div class="numIconWrap">';
		resEle += '    <span class="toggleNum">'+pageSize+'</span>';
		resEle += '    <i>&nbsp;</i>';
		resEle += '</div>';
		resEle += '<ul class="manyNum">';
		resEle += '    <li>20</li>';
		resEle += '    <li>30</li>';
		resEle += '    <li>50</li>';
		resEle += '</ul>';
		resEle += '</div>&nbsp;&nbsp;';
		resEle += str;
		//js代码
		resEle += "<script type='text/javascript'>";
		resEle += "$(function () {";
		resEle += "    $('#"+ajaxFunctionId+"_id').comBox({";
		resEle += "		ev: 'click',";
		resEle += "		evObj: '.numIconWrap',";
		resEle += "		changeObj: '.toggleNum',";
		resEle += "		showObj: '.manyNum'";
		resEle += "    });	";
		resEle += "    $('#"+ajaxFunctionId+"_id .manyNum li').bind('click',function(){";
		resEle += " 	var page_size = $(this).html();";
		resEle +=       ajaxFunction+"(1,page_size,'"+url+"');";
		resEle += "    });";
		resEle += "})";
		resEle += "</script>";
		
	}
	return resEle;
}

/**
 * 计算中间页的方法
 */
function calcPage(totalPage,pageIndex,pageSize,ajaxFunction,url){
	var str = "";
	//判断总页数
	if(totalPage <=6){
		for (var i = 1; i <= totalPage; i++) {
			if(pageIndex == i){
				str += "<span class='pages_i on'>"+ i +"</span>&nbsp;";
			}else{
				str += "<a class='pages_i' href='javascript:"+ ajaxFunction +"("+i+","+pageSize+",\""+url+"\");'>"+ i +"</a>&nbsp;";
			}
		}
	}else{
		//靠首页近一些
		if(pageIndex<=3){
			for (var i = 1; i <= 5; i++) {
				if(pageIndex == i){
					str += "<span class='pages_i on'>"+ i +"</span>&nbsp;";
				}else{
					str += '<a class="pages_i" href="javascript:'+ ajaxFunction +'('+i+','+pageSize+',\''+url+'\');">'+ i +'</a>&nbsp;';
				}
			}
			str += "...";
			str += '<a class="pages_i" href="javascript:'+ ajaxFunction +'('+totalPage+','+pageSize+',\''+url+'\');">'+ totalPage +'</a>&nbsp;';
		}else if(pageIndex + 2 >= totalPage){//靠近尾页近一些
			str += '<a class="pages_i" href="javascript:'+ ajaxFunction +'('+1+','+pageSize+',\''+url+'\');">1</a>&nbsp;';
			str += "...";
			for (var i = totalPage-4; i <= totalPage; i++) {
				if(pageIndex == i){
					str += "<span class='pages_i on'>"+ i +"</span>&nbsp;";
				}else{
					str += '<a class="pages_i" href="javascript:'+ ajaxFunction +'('+i+','+pageSize+',\''+url+'\');">'+ i +'</a>&nbsp;';
				}
			}
		}else{//在中间
			str += '<a class="pages_i" href="javascript:'+ ajaxFunction +'('+1+','+pageSize+',\''+url+'\');">1</a>&nbsp;';
			str += "...";
			for (var i = pageIndex - 2; i <= pageIndex + 2; i++){
				if(pageIndex == i){
					str += "<span class='pages_i on'>"+ i +"</span>&nbsp;";
				}else{
					str += '<a class="pages_i" href="javascript:'+ ajaxFunction +'('+i+','+pageSize+',\''+url+'\');">'+ i +'</a>&nbsp;';
				}
			}
			str += "...";
			str += '<a class="pages_i" href="javascript:'+ ajaxFunction +'('+totalPage+','+pageSize+',\''+url+'\');">'+ totalPage +'</a>&nbsp;';
		}
	}
	return str;
}
