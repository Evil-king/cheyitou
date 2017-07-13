$(function(){
	fLoadTable();
})
	function fLoadTable(){
		$('#dg_project').datagrid({
			url :'../reservation/page',
	        fit : true,
	        fitColumns : true,
	        rownumbers : true,
	        pagination : true,
	        singleSelect : true,
	        border : false,
	        striped : true,
	        toolbar : [{
	            text : '审核中未前往',
	            iconCls : 'icon-add',
	            handler : function() {
	            	ReviewData(1);
	            }
	        },'-', {
	            text : '前往审核',
	            iconCls : 'icon-add',
	            handler : function() {
	            	ReviewData(4);
	            }
	        },'-', {
	            text : '审核成功',
	            iconCls : 'icon-add',
	            handler : function() {
	            	ReviewData(2);
	            }
	        },'-', {
	            text : '审核失败',
	            iconCls : 'icon-add',
	            handler : function() {
	            	ReviewData(3);
	            }
	        }],
	        columns : [ [ {
	            field : 'id',
	            title : 'id',
	            hidden : true
	        }, {
	            field : 'orderNum',
	            width :	5,
	            title : '订单号',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.status=="1"){
	            		return "";
					}
	            	if(row.status=="4"){
						return "";
					}
	            	if(row.status=="2"){
	            		return row.orderNum;
	            	}
	            }
	        }, {
	            field : 'mobilePhone',
	            width : 5,
	            title : '账号',
	            align : 'center'
	        }, {
	            field : 'address',
	            width : 10,
	            title : '预约点',
	            align : 'center'
	        }, {
	            field : 'orderTime',
	            width : 5,
	            title : '预约时间',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.orderTime){
	            		var da = row.orderTime;
	            	    da = new Date(da);
	            	    var year = da.getFullYear();
	            	    var month = da.getMonth()+1;
	            	    var date = da.getDate();
	            	   return ([year,month,date].join('-'));
					}
	            }
	        },{
	            field : 'carType',
	            width : 5,
	            title : '车型',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.carType=="1"){
	            		return "出租车";
					}
	            	if(row.carType=="0"){
	            		return "私家车";
					}
	            }
	        },{
	            field : 'drivingLicense',
	            width : 5,
	            title : '行驶证',
	            align : 'center'
	        },{
	            field : 'drverCard',
	            width : 5,
	            title : '驾驶证',
	            align : 'center'
	        },{
	            field : 'status',
	            width : 5,
	            title : '状态',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.status=="4"){
	            		return "前往审核";
	            	}
	            	if(row.status=="1"){
	            		return "审核中";
	            	}
	            	if(row.status=="2"){
	            		return "审核成功";
	            	}
	            	if(row.status=="3"){
	            		return "审核失败";
	            	}
	                return "";
	            }
	        },{
	            field : '操作',
	            width : 10,
	            title : '操作',
	            align : 'center',
	            formatter : function(value, row, index) {
	            	if(row.status=="1"){
	            		var btn = '<input id = "pass" onclick="operating('+row.id+','+true+','+row.status+')" type="button" value="通过">'+"-"+'<input id = "noPass" onclick="operating('+row.id+','+false+','+row.status+')" type="button" value="未通过">';
	 	                return btn;
	            	}
	            	if(row.status=="4"){
	            		 var btn = '<input id = "pass" onclick="operating('+row.id+','+true+','+row.status+')" type="button" value="允许">'+"-"+'<input id = "noPass" onclick="operating('+row.id+','+false+','+row.status+')" type="button" value="不允许">';
	 	                return btn;
	            	}
	                return "";
	            }
	        } ] ],
	    });
	};
	function searchData(){
		$('#dg_project').datagrid('load', {  
			startTime : $('#startTime').datebox('getValue'),
	         endTime : $('#endTime').datebox('getValue')
        });  
	};
	//工具栏中四种状态
	function ReviewData(status){
		$('#dg_project').datagrid('load', {  
			status : status,
        }); 
	};
	//操作
	function operating(id,flag,status){
		$.ajax({
	        method : 'POST',
	        url : '../reservation/toOperat',
	        async : false,
	        dataType : 'json',
			data:{'id':id,'flag':flag,'status':status},
	        success : function(data) {
	        	if(data.flag==true){
					layer.msg('成功');
					window.location.reload();
				}else{
					layer.msg('失败');
				}
	        },
	        error : function() {
				layer.msg('error');
	        }
	    });
	};