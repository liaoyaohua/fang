var confirmDialog = function(opts) {
    var _this = this;
    this.dialog = $('<div class="confirm-dialog" title="删除" style="display:none;"></div>').dialog({
        modal: true,
        autoOpen: false,
        buttons: {
            '确认': function() {
            	_this.data.callback();
            },
            '取消': function() {
            	_this.dialog.html('').dialog('close');
            }
        }
    });
};
confirmDialog.prototype.open = function(msg, data) {
    this.data = data;
    this.dialog.html(msg).dialog('open');
};
confirmDialog.prototype.close = function() {
    this.data = {};
    this.dialog.html('').dialog('close');
};
var confirm = new confirmDialog({
    confirm: function() {
        this.close();
    },
    cancel: function() {
        this.close();
    }
});

var EditDialog = function() {
    this.editDialog = $('<div id="editDialog" title="编辑"></div>').append($('#dialogContent').html()).dialog({
        modal: true,
        autoOpen: false,
        width: 450
    });
};
EditDialog.prototype.open = function() {
	this.editDialog.dialog('open');
};
EditDialog.prototype.close = function() {
	this.editDialog.dialog('close');
};
var editDialog = new EditDialog();
