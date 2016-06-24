/*
 * 主页面底部
 */
Ext.define('AM.view.MainMenuFooter', {
	 extend: 'Ext.toolbar.Toolbar',
	    xtype: 'mainmenufooter',
	    style: {
	        background: '#2a3f5d'
	    },
	    frame: false,
	    border: false,
	    height: 30,
	    initComponent: function () {
	        var me = this;
	        Ext.applyIf(me, {
	            items: [{
	                xtype: 'tbtext',
	                style: {
	                    color: '#FFF',
	                    fontSize: '14px',
	                    textAlign: 'right',
	                    fontWeight: 'bold'
	                },
	                flex: 2,
	                id: 'southText',
	                text: '©天畅伟业科技有限公司' + Ext.Date.format(new Date(), 'Y') //+ appconfig.admin_copyright
	            }, '->' ,
	            
	           Ext.create('luter.ux.TrayClock', {
	                flex: 1,
	                style: {
	                    color: '#FFF',
	                    padding: '0px 0px 0px  0px',
	                    fontWeight: 'bold',
	                    textAlign: 'right',
	                    fontSize: '12px'
	                }
	            })
	            
	            ]
	        });
	        me.callParent(arguments);
	    }
});
