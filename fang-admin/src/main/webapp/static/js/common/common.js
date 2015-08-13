var common = {
	getHtmlContent: function(url, param, id) {
		$.ajax({
			url: url,
			type: "POST",
			cache: false,
			async: true,
			dataType: "html",
			data: param,
			success: function(data, textStatus) {
				$('#' + id).html(data);
			}
		});
	},
	
	deleteContent: function(url, id) {
		$.ajax({
			url: url,
			type: "POST",
			cache: false,
			async: true,
			dataType: "json",
			data: param,
			success: function(data, textStatus) {
				// 打开对话框
	            alertDialog.html("操作成功").dialog('open');
			},
			error: function () {
	        	// 打开对话框
	            alertDialog.html("操作失败").dialog('open');
	        }
		});
	}
}
	
