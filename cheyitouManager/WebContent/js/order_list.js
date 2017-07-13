$(function(){
	fLoadTable();
})
function fLoadTable(){
		$('#order_datagrid').datagrid({
			url : '../order/page',
	        fit : true,
	        fitColumns : true,
	        rownumbers : true,
	        pagination : true,
	        singleSelect : true,
	        checkOnSelect: true, 
	        selectOnCheck: false,
	        border : false,
	        striped : true,
	        toolbar : [{
	            text : '审核成功',
	            iconCls : 'icon-add',
	            handler : function() {
	                OrderData(5);
	            }
	        },'-', {
	            text : '审核失败',
	            iconCls : 'icon-add',
	            handler : function() {
	            	OrderData(4);
	            }
	        },'-', {
	            text : '导出',
	            iconCls : 'icon-add',
	            handler : function() {
	            	ExcelData();
	            }
	        }],
	        columns : [ [  {
	            field : 'id',
	            title : 'id',
	            checkbox:true
	        },{
	            field : 'orderNum',
	            width :	5,
	            title : '订单号',
	            align : 'center',
	        }, {
	            field : 'mobilePhone',
	            width : 5,
	            title : '账号',
	            align : 'center'
	        }, {
	            field : 'getModified',
	            width : 10,
	            title : '完成提交时间',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.getModified){
	            		var da = row.getModified;
	            	    da = new Date(da);
	            	    var year = da.getFullYear();
	            	    var month = da.getMonth()+1;
	            	    var date = da.getDate();
	            	   return ([year,month,date].join('-'));
					}
	            }
	        },{
	            field : 'images',
	            width : 10,
	            title : '资质图片',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	return row.frontImg+","+row.backImg+","+row.sideImg;
	            }
	        },{
	            field : 'status',
	            width : 5,
	            title : '状态',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.status=="3"){
	            		return "审核中";
	            	}
	            	if(row.status=="4"){
	            		return "审核失败";
	            	}
	            	if(row.status=="5"){
	            		return "审核成功";
	            	}
	            	return "";
	            }
	        },{
	            field : '操作',
	            width : 10,
	            title : '操作',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.status=="3"){
	            		var btn = '<input id = "pass" onclick="Operate('+row.id+','+true+')" type="button" value="通过">'+"-"+'<input id = "noPass" onclick="Operate('+row.id+','+false+')" type="button" value="未通过">';
	 	                return btn;
	            	}
	                return "";
	            }
	        } ] ],
	    });
	};
	function searchData(){
		$('#order_datagrid').datagrid('load',{
			startTime : $('#sTime').datebox('getValue'),
			endTime : $('#eTime').datebox('getValue')
		});
	};
	function OrderData(status){
		$('#order_datagrid').datagrid('load',{
			status:status
		});
	};
	function Operate(id,flag){
		$.ajax({
			method : 'POST',
	        url : '../order/operate',
	        async : false,
	        dataType : 'json',
			data:{'id':id,'flag':flag},
			success:function(data){
				if(data.flag==true){
					layer.msg('成功');
					window.location.reload();
				}else{
					layer.msg('失败');
				}
			},
			error:function(){
				layer.msg('error')
			}
		})
	};
	function ExcelData(){
		var url="../order/excel";
        window.open(url);
	};