//菜单信息
var menu_info = [{
	title: '预约审核',
}, {
	title: '订单审核',
}];
//		{
//	title: '提现审核',
//	content: '<p>暂无描述</p>'
//},{
//	title: '解除订单',
//	content: '<p>暂无描述</p>'
//},{
//	title: '预约点增减',
//	content: '<p>暂无描述</p>'
//},{
//	title: '车型增减',
//	content: '<p>暂无描述</p>'
//},{
//	title: '订单核算',
//	content: '<p>暂无描述</p>'
//}];
//TAB页信息
tab_info = [{
	title: '预约审核',
	href: '../pages/reservation/reservationReview.jsp'
}, {
	title: '订单审核',
	href: '../pages/order/order.jsp'
}, 
//{
//	title: '提现审核',
//	href: '../pages/deposit/depositList.jsp'
//},{
//	title: '解除订单',
//	href: '../pages/order/orderRelease.jsp'
//},{
//	title: '预约点增减',
////	href: '../pages/reservationPoint/list.html'
//},{
//	title: '车型增减',
////	href: '../pages/orderModels/list.html'
//},{
//	title: '订单核算',
////	href: '../pages/orderAccount/list.html'
//}
];

//定义菜单项当前状态，默认未选中
var menu_selected = [false, false, false, false, false, false, false];

$('#accordion').accordion({
	onSelect:function(title,index){
		
		if(!menu_selected[index]){
			// 设置为选中状态
			menu_selected[index] = true;
			
			var tab = tab_info[index];
			$('#tabs').tabs('add', {
				title: tab.title,
				href: tab.href,
				closable: true,
				index : index +1
			});
		}else {
			// 已选中菜单多次点击时，忽略
			$('#tabs').tabs('select', index + 1);
		}
	},
	onUnselect: function(title, index) {
//		console.log('onUnselect' + index + '-' + title);
	},
	onClose: function(title, index) {
//		console.log('onClose' + index + '-' + title);
	}
});


for(var i in menu_info){
	var menu = menu_info[i];
	$('#accordion').accordion('add',{
		title:menu.title,
		content:menu.content,
		selected:false,
		bodyCls: 'index-common-padding'
	});
}