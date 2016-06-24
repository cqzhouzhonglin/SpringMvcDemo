Ext.define('AM.store.Main', {
	extend : 'Ext.data.TreeStore',
	model : 'AM.model.Main',
	root : {
		text : '税务地图管理平台',
		expanded : false,
		id:'-1'
	},
	proxy : {
		type : 'ajax',
		url : 'Function_queryFunction.action',
		reader : {
			type : 'json',
			root : 'data'
		}
	},
	listeners : {
		'beforeexpand' : function(node, eOpts) {
			// 点击父亲节点的菜单会将节点的id通过ajax请求，将到后台
			this.proxy.extraParams = {
				'function.parentId' : node.raw.id,
				'form.bean.functionType':'4'
			};
		}
	},
	autoLoad : true
});
