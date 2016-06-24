/*
 *系统主页面TabPanel面板
 */
Ext.define('AM.view.MainMenuTabPanel', {
	extend : 'Ext.tab.Panel',
	alias : 'widget.mainmenutabpanel',
	initComponent : function() {
		var me = this;
		Ext.apply(me, {
			border : false,
			id : 'mainmenutabpanel',
			defaults : {
				autoScroll : true,
				border : false
			},
			activeTab : 0,
			border : true,
			items : [{
	            title: '首页',
	            bodyPadding: 10,
	            html : '<center><h1>欢迎使用税务地图管理系统</h1></center>'
	        }]
		});
		this.callParent(arguments);
	}
});
