Ext.define('AM.controller.MainMenu', {
	extend : 'Ext.app.Controller',
	views : [ 'MainMenuHeader', 'MainMenuTabPanel', 'MainMenuTree','MainMenuFooter' ],
	stores : [ 'Main' ],
	models : [],
	init : function() {
		this.control({
			'mainmenutree' : {
				'itemclick' : function(v, record) {
					var id = record.get('id');
					var text = record.get('text');
					var leaf = record.get('leaf');
					var panel = record.get('panel');
					if (leaf == true && panel != "") {
						if(!Ext.ClassManager.isCreated(record.get('controllerName'))){
							this.getApplication().getController(record.get('controllerName'));
						}
						var tabpanel = Ext.getCmp('mainmenutabpanel');
						var newtab = tabpanel.getComponent('newtab' + id);// 通过itemId取值
						if (!newtab) {
							tabpanel.add({
								closable : true,//是否可关闭
								title : text,
								itemId : 'newtab' + id,
								layout : 'fit',
								items : {
									xtype:panel,
									itemId:panel
								}
							});
						}
						tabpanel.setActiveTab('newtab' + id);// 激活tab,让其处于选中状态
					}
				}
			}
		});
		
	}
});
