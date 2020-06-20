$(function(){
    var pageIndex = $("#pageIndex").val();
    var pageSize = $("#pageSize").val();
    var url = $("#url").val();
    getList(pageIndex,pageSize,url);
});

/**
 * 查询列表
 * @param pageIndex
 * @param pageSize
 * @param url
 * @returns
 */
function  getList(pageIndex, pageSize, url) {
    $("#pagesDiv").show();
    var requestParams = {"pageIndex" : pageIndex,"pageSize" : pageSize};
    var fields = $("#main input,#main select").serializeArray();
    $.each(fields, function(index, content){
        if(!requestParams.hasOwnProperty(content.name)|| requestParams[content.name]==null || requestParams[content.name]=="" ){
            requestParams[content.name] = content.value;
        }
    });
    // console.log(requestParams);
    var callback = function (data) {
        // console.log(data);
    };
    renderPageData(url, requestParams, null, callback, "ListTemp", "ListBodyId", "pagesDiv", "getList", 10);
    //调试用
    // $.ajax({
    //     type: "POST",
    //     url: url,
    //     data: requestParams,
    //     dataType: "json",
    //     success: function(data){
    //         console.log(data);
    //     }
    // });

}


