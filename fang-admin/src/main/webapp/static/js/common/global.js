// 声明对话框
$(function() {
	window.alertDialog = $('<div id="alertDialog" title="操作提示"></div>').dialog({
	    modal: true,
	    autoOpen: false,
	    buttons: {
	    	'确认':function(){
	    		alertDialog.html('').dialog('close');
	    	}
	    },
	    width: 300
	});
	
	Date.prototype.format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
});

function query(pageIndex, url) {
	if (url == null || url == "") {
        return;
    }
    
    if (pageIndex == null || pageIndex == "") {
    	//获取当前查询页数
        var currentPage = $('.fr').find('a.current');
        pageIndex = $(currentPage).html();
        if (pageIndex == null || pageIndex == "") {
	    	pageIndex = 1;
	    }
    }
    
    var pageSize = $("#" + "page-pageSize" + name).val();
    if (pageSize == null || pageSize == "") {
        pageSize = 20;
    }
    
    var param = getQueryConidtion(pageIndex, pageSize);
    common.getHtmlContent(encodeURI(url), param, 'dataDiv');
}

function gotoPage(totalPage, url) {
    if (url == null || url == "") {
        return;
    }
    var num = $("#" + "goto" + name).val();
    num = $.trim(num);
    if(num > totalPage) {
    	num = totalPage;
    }
    query(num, url);
}