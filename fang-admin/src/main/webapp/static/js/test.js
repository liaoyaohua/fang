var test = {};

test.save = function() {
	
};

function getQueryConidtion(pageIndex, pageSize) {
	// 活动名称
	var param = "pageIndex=" + pageIndex + "&pageSize=" + pageSize;
    var name = jQuery("#name").val();
    if (name != null && name != "") {
    	param += "&name=" + name;
    }
    var status = jQuery("#status").val();
    param += "&status=" + status;
	return param;
}