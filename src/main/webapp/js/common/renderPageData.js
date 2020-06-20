/**
 * 表格数据管理
 */

/** 
 * 分页模板的渲染方法 
 * @param templateId 分页需要渲染的模板的id 
 * @param resultContentId 模板渲染后显示在页面的内容的容器id 
 * @param data 服务器返回的json对象 
 */ 
function renderTemplate(templateId, resultContentId, data){ 
	
	
	//繁体转换
    var arr = JSON.stringify(data.data);
    var items = data.items;
    if(arr!=null){
        data["data"] = $.parseJSON(arr);
    }else if(items!=null){
    	data["items"] = $.parseJSON(items);
    }
	//结束
    var tempContent = $("#"+templateId).html();
    if(tempContent != null ) {
    	if(resultContentId != null && resultContentId != "") {
    	    laytpl(tempContent).render(data, function (html) {
   	    	 $("#"+resultContentId).html(html); 
    	    });    		
    	}
    }
    else {
    	Layer.Alert("提示：","模板配置为空，请确认！");
    }
    	
}; 

/** 
 * tablepage 分页封装 
 * @param url 向服务器请求分页的url链接地址 
 * @param requestParams 分页查询请求的ajax参数 
 * @param pageParams 页面附加的参数，譬如basePath等,若没有需要可以传null 
 * @param pageCallback 页面返回查询数据结果以便其它用处以免重复查询数据源，如果不需要返回数据结果传null即可
 * @param templateId 分页需要渲染的模板的id 
 * @param resultContentId 模板渲染后显示在页面的内容的容器id 
 * @param pageDivId 分页控件Div层的id 
 * @param colnum 数据列表的列数，空记录时显示使用，可为空
 */ 
function renderPageData(url, requestParams, pageParams, pageCallback, templateId, resultContentId, pageDivId, ajaxFunction, colnum){ 
    if(requestParams == null){ 
    	requestParams = {"pageIndex" : 1,"pageSize" : 20};
	}
    $("#"+resultContentId).html(""); 
	var callback = function (data) {			
		if (data.pageModel.items != null && data.pageModel.items.length > 0) {	
		    if(pageParams == null){ 
		    	pageParams = { };
			}
			pageParams["data"] = data.pageModel.items; 
			renderTemplate(templateId, resultContentId, pageParams);   
			if(pageDivId != null && pageDivId != "" && ajaxFunction != null){
				var pageEle = fillPages(data.pageModel.pageIndex, data.pageModel.pageSize,data.pageModel.recordCount, ajaxFunction, url);
				$("#"+pageDivId).html(pageEle);
			}
		}
		else { 
			$("#"+pageDivId).html("");
			if(colnum != null && colnum > 0) {
				$("#"+resultContentId).html('<tr><td colspan="'+colnum+'" style="text-align: center;">未查询到符合条件的数据</td></tr>');
			}
			else {
				Layer.ShowMsg("未查询到符合条件的数据");
			}				
		}
		if(pageCallback != null) {
			pageCallback(data);
		}
	};	 
	Command.Request(url, callback, requestParams);		
}



