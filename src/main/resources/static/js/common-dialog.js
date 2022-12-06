/**
 * ダイアログ表示オブジェクト
 */
export let CommonDialog = {
	/**
	 * ダイアログを表示する.
	 * @param title タイトル.
	 * @param okCallback 決定コールバック.
	 * @param cancelCallback キャンセルコールバック.
	 * @param options オプション.
	 */
	alert: function (title, message, okCallback, cancelCallback, options) {
		if (title) {
			$('#dialog-title-label').text(title);
		}

		if (message) {
			$('#dialog-body').html(message);
		}
		
		$('#dialog').modal('show');

		// remove the event listeners when the dialog is dismissed
		$("#dialog").on("hide.bs.modal", function () {    
			$("#dialog-cancel").off("click");
			$("#dialog-ok").off("click");
		});

		$('#dialog-cancel').hide();

		$('#dialog-ok').click(function () {
			$('#dialog').modal('hide');
			if (okCallback) {
				okCallback();
			}
		});
	},
	/**
	 * ダイアログを表示する.
	 * @param title タイトル.
	 * @param okCallback 決定コールバック.
	 * @param cancelCallback キャンセルコールバック.
	 * @param options オプション.
	 */
	confirm: function (title, message, okCallback, cancelCallback, options) {

		$('#dialog').modal('show').off('click.confirm');
		$('#dialog-cancel').show();

		if (title) {
			$('#dialog-title-label').text(title);
		}

		if (message) {
			$('#dialog-body').html(message);
		}

		// remove the event listeners when the dialog is dismissed
		$("#dialog").on("hide.bs.modal", function () {    
			$("#dialog-cancel").off("click");
			$("#dialog-ok").off("click");
		});


		$('#dialog-ok').click(function () {
			$('#dialog').modal('hide');
			if (okCallback) {
				okCallback();
			}
		});

		$('#dialog-cancel').click(function () {
			$('#dialog').modal('hide');
			if (cancelCallback) {
				cancelCallback();
			}
		});
	},
};