Ext.define('AM.model.Main', {
	extend : 'Ext.data.Model',
	fields : [ 
	{
		name: 'id',
		type: 'string'
	},
	{
		name : 'text',
		type : 'string'
	},
	{
		name : 'leaf',
		type : 'bool'
	},
	{
		name : 'panel',
		type : 'string'
		
	},
	{
		name : 'controllerName',
		type : 'string'
	}
	]
});