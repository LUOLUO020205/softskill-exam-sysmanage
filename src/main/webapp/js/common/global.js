
/**
  网站常用的jq插件
**/

(function ($) {    //下拉菜单效果
    $.fn.comBox = function (options) {
        var defaults = {
            ev: 'click',  //默认事件
            evObj: '.numIconWrap',  //鼠标点击显示的区域
            changeObj: '.toggleNum',//改变文字区域
            showObj: '.manyNum' //可选择的文字区域 
        }
        opts = $.extend(defaults, options);

        return this.each(function () {
            var _this = $(this),
				obj = _this.find(opts.evObj),
				changeTxtObj = obj.find(opts.changeObj),
				optVal = _this.find(opts.evObj),
				showUlObj = _this.find(opts.showObj),
				oli = showUlObj.find('li');

            obj.on(opts.ev, function () {  //显示隐藏的的选项指
                showUlObj.toggle();
                _this.addClass('maxIndex');
            })

            oli.on(opts.ev, function () {   //取值
                var txt = $(this).text();
				var txt_val = $(this).attr("data");
                changeTxtObj.hasClass("inputTxt") ? changeTxtObj.attr("value", txt) : changeTxtObj.text(txt);
                $(this).addClass('active').siblings().removeClass('active');
				if($(this).parent().parent().find("input").length > 0){
					$(this).parent().parent().find("input").val(txt_val);
				}
                _this.removeClass('maxIndex');
                showUlObj.hide();
                
            })

        })
    }
})(jQuery);





























