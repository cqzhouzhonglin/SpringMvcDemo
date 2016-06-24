Ext.define('AM.view.MainMenuHeader', {
	extend : 'Ext.Container',
	alias : 'widget.mainmenuheader',
	initComponent : function() {
		var background = '';
		Ext.apply(this, {
			cls : 'app-header',
			bodyStyle: background,
			height : 100,
			layout : {
				type : 'hbox',//布局方式
				pack : 'end',//子项的位置(左右)
				align : 'bottom'//子项的位置(上下)
			}
		});
		this.items = [ {
			  xtype: 'tbtext',
              style: {
                  color: '#FFF',
                  fontSize: '16px',
                  padding: '0px 15px 5px 0px',
                  fontWeight: 'bold'
              },
              text:'欢迎您:'
		}, {
			xtype : 'button',
			 style: {
                 padding: '0px 0px 5px 0px'
             },
			text : '<font color=white size=2>注销</font>',
			itemId : 'logout',
			cls : 'mybtn',
			tooltip : '退出登陆并返回登陆页面',
			handler : function() {
				Ext.Ajax.request({
					url :'${pageContext.request.contextPath }/Login_loginOut.action',
					success : function(response) {
						location.href='${pageContext.request.contextPath }/Login_toIndex.action';
					}
				});
				
			}
		}];
		this.callParent(arguments);
	}
});
