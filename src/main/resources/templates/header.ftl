<!DOCTYPE html>
<html>
<head>
	<style>
		body {
			font-family: 나눔고딕, Nanum Gothic, NanumGothic, Dotum, AppleGothic, sans-serif;
		}

		{{#width}}
		@page { size: A4 landscape;}
		{{/width}}
		.page-break {
			display: block;
			clear: both;
			page-break-after: always;
		}

		.vertical-align {
			display: flex;
			align-items: center;
		}

		.text-left {
			text-align: left;
		}
		.text-right {
			text-align: right;
		}
		.text-center {
			text-align: center;
		}
		.text-justify {
			text-align: justify;
		}
		.text-nowrap {
			white-space: nowrap;
		}
		.text-lowercase {
			text-transform: lowercase;
		}
		.text-uppercase {
			text-transform: uppercase;
		}
		.text-capitalize {
			text-transform: capitalize;
		}

		/*table {
			width: 100%;
			border: 1px solid #444444;
			border-collapse: collapse;
		}
		th, td {
			border: 1px solid #444444;
			padding: 10px;
		}*/

		/* nuli : https://nuli.navercorp.com/sharing/ui/patternTable*/
		/* UI Object */
		.tbl_list,.tbl_list th,.tbl_list td{border:0}
		.tbl_list{width:100%;border-bottom:2px solid #dcdcdc;font-size:12px;text-align:center;border-collapse:collapse}
		.tbl_list caption{display:none}
		.tbl_list tfoot{background-color:#f5f7f9;font-weight:bold}
		.tbl_list th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-size:12px;font-weight:bold}
		.tbl_list td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
		.tbl_list td.ranking{font-weight:bold}

		.tbl_view,.tbl_view th,.tbl_view td{border:0}
		.tbl_view{width:100%;border-bottom:1px solid #dddee2;font-family:'돋움',dotum;font-size:12px;table-layout:fixed}
		.tbl_view caption{display:none}
		.tbl_view th{padding:8px 0 5px 20px;border-top:1px solid #dddee2;background:#f1f1f3;color:#666;font-weight:bold;text-align:left;vertical-align:top}
		.tbl_view td{padding:8px 5px 5px 12px;border-top:1px solid #dddee2;line-height:16px;vertical-align:top}
		/* //UI Object */
	</style>
</head>
<body>
