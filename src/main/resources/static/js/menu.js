import { CommonDialog } from './common-dialog.js';

var sampleData;
var transcationId;

$(document).ready(function() {
	$('[name=left-menu]').click(function() {
		$('[name=left-menu]').each(function(index) {
			$(this).removeClass("active");
		});
		$(this).addClass("active");
	});

	createTable();

	$("#add").click(function() {
		CommonDialog.confirm(
			"確認",
			"操作してよろしいでしょうか.",
			add,
			null,
			null);
	});

	$("body").on("click", '.btn-update', function() {
		transcationId = $(this).attr("id");
		CommonDialog.confirm(
			"確認",
			"操作してよろしいでしょうか.",
			operate,
			null,
			null);
	});
});

function add() {
	$.ajax({
		type: "POST",
		url: "/transcation",
		async: false,
	}).done(function(data) {
		createTable();
	});
}

function operate() {
	$.ajax({
		type: "PUT",
		url: "/transcation",
		async: false,
		data: { id: transcationId }
	}).done(function(data) {
		createTable();
	});
}

function createTable() {

	$('#example').DataTable().clear().destroy();

	$.ajax({
		type: "GET",
		url: "/transcation",
		async: false,
		//data: { name: "John", location: "Boston" }
	}).done(function(data) {
		sampleData = data;
	});

	$('#example').DataTable({
		"language": {
			"url": "//cdn.datatables.net/plug-ins/1.10.22/i18n/Japanese.json"
		},
		lengthMenu: [
			[5,  10, 25, 50, -1],
			[5, 10, 25, 50, 'All'],
		],
		"scrollY": "390px",
		"scrollCollapse": true,
		"pageLength": 5,
		data: sampleData,
		columns: [
			{
				data: null, render: function(data, type, row) {
					// Combine the first and last names into a single table field
					return '' + data.id;
				}
			},
			{
				data: null, render: function(data, type, row) {
					if (data.status == 1) {
						return '依頼会社-現調・出図';
					} else if (data.status == 2) {
						return '協力会社-管割図作成';
					} else if (data.status == 3) {
						return '製作会社-材料調達';
					} else if (data.status == 4) {
						return '検査機関-検査';
					} else if (data.status == 5) {
						return '検査機関-証明書発行';
					} else if (data.status == 6) {
						return '製作会社-出荷準備';
					} else if (data.status == 7) {
						return '協力会社-承認';
					} else if (data.status == 8) {
						return '依頼会社-承認';
					} else if (data.status == 9) {
						return '製作会社-出荷';
					} else if (data.status == 10) {
						return '協力会社-搬入・荷受確認';
					} else if (data.status == 11) {
						return '依頼会社-社内検査';
					} else if (data.status == 12) {
						return '依頼会社-立会検査';
					} else if (data.status == 13) {
						return '完了';
					}
				}
			},
			{
				data: null, render: function(data, type, row) {
					if (data.todoCompanyType == "A") {
						return '依頼会社';
					} else if (data.todoCompanyType == "B") {
						return '協力会社';
					} else if (data.todoCompanyType == "C") {
						return '製作会社';
					} else if (data.todoCompanyType == "D") {
						return '検査機関';
					} else {
						return '-';
					}
				}
			},
			{
				data: null, render: function(data, type, row) {
					if (data.createdAt) {
						return data.createdAt.substring(0, 10);
					} else {
						return '-'
					}
				}
			},
			{
				data: null, render: function(data, type, row) {
					if (data.updatedAt) {
						return data.updatedAt.substring(0, 10);
					} else {
						return '-'
					}
				}
			},
			{
				sortable: false,
				"render": function(data, type, full, meta) {
					if ($('input[name="companyType"]').val() == full.todoCompanyType) {
						return '<button type="button" id=' + full.id + ' class="btn btn-primary btn-update text-nowrap" > <i class="bi bi-arrow-right-square-fill"></i>操作</button>';
					} else {
						return '<button disabled type="button" id=' + full.id + ' class="btn btn-primary btn-update text-nowrap" > <i class="bi bi-arrow-right-square-fill"></i>操作</button>';
					}

				}
			},

		],
		columnDefs: [
			{ width: "10%", targets: 0 },
			{ width: "30%", targets: 1 },
			{ width: "20%", targets: 2 },
			{ width: "20%", targets: 3 },
			{ width: "10%", targets: 4 },
		],
		fixedColumns: true
	});

}