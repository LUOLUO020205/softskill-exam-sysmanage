/**
 * ajax请求命令类
 */
Command = {
    Request: function () {//请求（有加载层）
        if (!arguments[0] || !arguments[1]) {
            throw new Error("首个url参数及回调函数是必须的");
        }
        var url = arguments[0];
        var callback = arguments[1];
        var datas = arguments[2] ? arguments[2] : {};
        datas['trand'] = new Date().getTime();
        var type = arguments[3] ? arguments[3] : "POST";
        var dataType = arguments[4] ? arguments[4] : "JSON";
        var async = true;
        if(arguments.length >=5 && arguments[5] !=null) {
        	async = arguments[5];
        }
        var contentType = arguments[6] ? arguments[6]:'application/x-www-form-urlencoded; charset=UTF-8';
        var errorCallback = arguments[7];
        var completeCallback = arguments[8];
        var jsonString = arguments[9];
        if(jsonString!=null){
        	datas = JSON.stringify(datas);
        }
        var index = Layer.Load();
        
        $.ajax({
            url: url,
            dataType: dataType,
            contentType: contentType,
            type: type,
            async: async,
            data: datas,
            success: function (data) { Layer.Close(index); callback(data); },
            error: function (xhr,errorText,errorType) { 
            	Layer.Close(index); 
            	console.log("请求异常: errorStatus:" + xhr.status + ",errorType:" + errorType + ",errorText："+errorText);           	          	
            	if(errorCallback != null) { //失败调用回调
            		errorCallback(xhr,errorText,errorType);
        		}
            	else {
            		Layer.ShowMsg("网络不通，请检查网络后重试!");
            	}            		
            }, 
            complete:function(XMLHttpRequest,textStatus){  
            	if(completeCallback != null) { //完成后调用回调
            		completeCallback(XMLHttpRequest,textStatus);
            	} 
            	else {
            		 //通过XMLHttpRequest取得响应头，sessionstatus，  
                    var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");   
                    var hasXss=XMLHttpRequest.getResponseHeader("hasXss");
                    var requestTooOften=XMLHttpRequest.getResponseHeader("requestTooOften");
                    if(sessionstatus=="timeout"){  
                    	Layer.ShowMsg("由于您长时间未操作,登录已失效,请重新登录");
                    	if($("#basePath") != null && $("#basePath") != undefined) {
                    		parent.location.href = $("#basePath").val() + "/login/logout.jsp";
                    	}                    
                    }  
                    if(textStatus=='timeout'){ 
                    	Layer.ShowMsg("网络超时！");
                    }            	
                    if(hasXss=='true'){
                    	Layer.ShowMsg("参数带有敏感词 请重新输入");
                    }
                    
                    if(requestTooOften=='true'){
                    	Layer.ShowMsg("请求过于频繁");
                    }
                    
            	}
            }  
        });
    },  
    RequestHush: function () {//没有加载层，静默加载
        if (!arguments[0] || !arguments[1]) {
            throw new Error("首个url参数及回调函数是必须的");
        }
        var url = arguments[0];
        var callback = arguments[1];
        var datas = arguments[2] ? arguments[2] : {};
        datas['trand'] = new Date().getTime();
        var type = arguments[3] ? arguments[3] : "POST";
        var dataType = arguments[4] ? arguments[4] : "JSON";
        var async = true;
        if(arguments.length >=5 && arguments[5] !=null) {
        	async = arguments[5];
        }
        var contentType = arguments[6] ? arguments[6]:'application/x-www-form-urlencoded; charset=UTF-8';        
        var errorCallback = arguments[7];
        var completeCallback = arguments[8];
        if(typeof callback != "function"){
            var temp=callback;
            callback=datas;
            datas=temp;
        }        
        $.ajax({
            url: url,
            dataType: dataType,
            contentType: contentType,
            type: type,
            async: async,
            data: datas,
            success: function (data) { callback(data); },
            error: function (data) { if(errorCallback != null) { errorCallback(data);} }, //失败调用回调
            complete:function(XMLHttpRequest,textStatus) { //完成后调用回调
            	if(completeCallback != null) { 
            		completeCallback(XMLHttpRequest,textStatus);
            	} 
            }
        });
    }
};


Layer = {
    Load: function() {
       return layer.load(1, { shade: 0.1 });
    },
    //打开弹出DIV
    ShowPopDiv: function(title, content, area, scrollbar) {
    	if(area == null) {
    		area = ['600px', '400px'];
    	}
    	if(scrollbar == null) {
    		scrollbar = true;
    	}
    	return layer.open({title: title, type : 1, content: content, area: area, scrollbar: scrollbar, skin: 'layui-layer-rim' });
    },  
    //打开弹出Iframe
    ShowIframe: function(title, content, area, scrollbar) {
    	if(area == null) {
    		area = ['600px', '400px'];
    	}
    	if(scrollbar == null) {
    		scrollbar = true;
    	}    	
    	return layer.open({title: title, type : 2, content: content, area: area, scrollbar: scrollbar, skin: 'layui-layer-rim' });
    },     
    Show: function(content) {
        layer.open({ content: content, btn: ['确定'], shade: 0.1, shadeClose: false });
    },
    Show2: function(content) {
        layer.open({ content: content, shade: false, shadeClose: false });
    }, 
    Show3: function(content,fun) {
    	layer.open({ content: content, btn: ['确定'], shade: 0.1, shadeClose: false,closeBtn :0,
			yes : function(){
				fun();
			}});
    }, 
    ShowMsg: function(content) {
        layer.msg(content, { shade: 0.1, time: 2000 }); //2秒后自动关闭
    },    
    TimeMsg: function(content, delay, offset) {
    	if(offset==null || offset==""){
    		offset = "auto";
    	}
        layer.msg(content, { shade: 0.1, time: delay, offset: offset});
    },
    TimeMsgNoShade: function(content, delay) {
        layer.msg(content, { shade: false, time: delay });
    },    
    Msg: function(content) {
        layer.msg(content, { shade: 0.1 }); 
    },
    MsgNoShade: function(content) {
        window.parent.layer.msg(content, { shade: false });
    },
    CloseLast: function() {
    	layer.close(layer.index);////如果你想关闭最新弹出的层，直接获取layer.index即可
    },    
    Close: function(index) {
    	layer.close(index);
    },
    CloseAll: function() {
        layer.closeAll();
    },
    Error: function() {
    	layer.open({ title: ['发生错误'], content: '发生了错误，请稍后再试' });
    },
    ExpError: function(title, content) {
        layer.open({ title: title, content: content });
    },
    Alert: function(title, content) {
        if (title.length < 1)
            title = "发生错误";
        if (content.length < 1)
            content = "对不起发生错误";
        layer.open({ title: title, content: content, style: 'color:#aaaa11;' });
    },
    Confirm: function(content, func) {
    	var index = -100;
    	index = layer.open({
            content: content,
            btn: ['确定', '取消'],
            yes: function() {
                func();
                layer.close(index);
            },
            no: function() {}
        });
    },
};
