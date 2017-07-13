$('#dg_project').datagrid({
        data : "",
        fit : true,
        fitColumns : true,
        rownumbers : true,
        pagination : true,
        singleSelect : true,
        border : false,
        striped : true,
        toolbar : [ {
            text : '全部通过',
            iconCls : 'icon-add',
            handler : function() {
                newProject();
            }
        }, '-', {
            text : '全部不通过',
            iconCls : 'icon-edit',
            handler : function() {
                editProject();
            }
        }, '-', {
            text : '提交',
            iconCls : 'icon-remove',
            handler : function() {
                removeProject();
            }
        } ,'-', {
            text : '未审核',
            iconCls : 'icon-add',
            handler : function() {
                newProject();
            }
        },'-', {
            text : '已审核',
            iconCls : 'icon-add',
            handler : function() {
                newProject();
            }
        }],
        columns : [ [ {
            field : 'unid',
            title : 'UNID',
            hidden : true
        }, {
            field : 'orderNum',
            width : 20,
            title : '订单号',
            align : 'center',
        }, {
            field : 'Account',
            width : 15,
            title : '账号',
            align : 'center'
        }, {
            field : 'name',
            width : 15,
            title : '联系人',
            align : 'center'
        }, {
            field : 'project_content_way',
            width : 15,
            title : '预约点',
            align : 'center'
        }, {
            field : 'orderTime',
            width : 15,
            title : '预约时间',
            align : 'center'
        },{
            field : 'carType',
            width : 15,
            title : '车型',
            align : 'center'
        },{
            field : 'machine_num',
            width : 15,
            title : '行驶证号',
            align : 'center'
        },{
            field : 'machine_function',
            width : 30,
            title : '操作',
            align : 'center',
            formatter : function(value, row, index) {
                var btn = '<a class="editcls"></a>';
                return btn;
            }
        } ] ],
        onLoadSuccess : function(data) {
            $('.editcls').linkbutton({
                text : '编辑',
                plain : false,
                iconCls : 'icon-a_edit',
                onClick : function() {
                    editMachine();
                }
            });
        }
    });