Ext.define('AM.view.MainMenuTree', {
	extend : 'Ext.tree.Panel',
	alias : 'widget.mainmenutree',
	initComponent : function() {
		var me = this;
		Ext.apply(this, {
			title : '系统功能',
			border : false,
			enableDD : false,
			split : true,
			width : 212,
			minSize : 130,
			maxSize : 300,
			//rootVisible : true,
			containerScroll : true,
			collapsible : true,
			autoScroll : true,
			tools : [ 
			/*          {
				type : 'refresh',
				tooltip : '刷新',
				handler : function(event, toolEl, panelHeader) {
					alert(me.getStore());
					me.getStore().load();
				}
			},*/ {
				type : 'expand',
				tooltip : '展开',
				handler : function() {
					me.expandAll();
				}
			}, {
				type : 'collapse',
				tooltip : '收起',
				handler : function() {
					me.collapseAll();
				}
			} ],
			listeners : {
				'afterrender' : function() {
				}
			},
			store : 'Main'
		});
		this.callParent(arguments);
	}
});