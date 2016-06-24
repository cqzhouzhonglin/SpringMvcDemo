Ext.application({
	name : "AM",// 命名空间
	appFolder : 'manage/ext_app/app',// 文件目录
	launch : function() {// 启动方法
		Ext.create('Ext.container.Viewport', {
			layout : 'border',// 自适应
			items : [{
						region : 'north',
						xtype : 'mainmenuheader'
					}, {
						region : 'west',
						xtype : 'mainmenutree',
						dockedItems : [{
							xtype : 'toolbar',
							layout : {
								pack : 'center'
							},
							dock : 'bottom',
							items : [{
								iconCls : 'icon-password',
								text : '修改密码',
								textAlign : 'center',
								itemId : 'changepassword',
								tooltip : '修改您的密码',
								handler : function() {
									var activeForm = null;
									var activeWindow = null;
									activeForm = Ext.create('Ext.form.Panel', {
										width : 400,
										fieldDefaults : {
											labelAlign : 'right',
											labelWidth : 100,
											margin : 4,
											width : 380,
											msgTarget : 'under'
										},
										items : [{
													xtype : 'textfield',
													inputType : 'password',
													id : 'oldpassword',
													name : 'oldpassword',
													fieldLabel : '原密码',
													allowBlank : false,
													blankText : '原密码不能为空'
												}, {
													xtype : 'textfield',
													inputType : 'password',
													id : 'newpassword',
													name : 'newpassword',
													fieldLabel : '新密码',
													allowBlank : false,
													blankText : '新密码不能为空'
												}, {
													xtype : 'textfield',
													vtype : "repassword",
													inputType : 'password',
													id : 'renewpassword',
													name : 'renewpassword',
													fieldLabel : '确认密码',
													allowBlank : false,
													blankText : '确认密码不能为空',
													vtype : 'repetition',
													repetition : {
														targetCmpId : 'newpassword'
													}
												}]

									});
									activeWindow = Ext.create(
											'Ext.window.Window', {
												title : '修改密码',
												autoScroll : true,
												modal : true,
												items : [activeForm],
												buttons : [{
													text : '确定',
													handler : function() {
														var form = activeForm
																.getForm();
														if (form.isValid()) {
															var oldpassword = Ext
																	.getCmp('oldpassword')
																	.getValue();
															var newpassword = Ext
																	.getCmp('newpassword')
																	.getValue();
															Ext.Ajax.request({
																url : 'UserInfo_updatePassword.action',
																params : {
																	'oldpassword' : oldpassword,
																	'newpassword' : newpassword
																},
																success : function(
																		response) {
																	var msg = Ext
																			.decode(response.responseText);
																	if (msg.code == 200) {
																		Ext.Msg
																				.alert(
																						"提示信息",
																						"修改成功密码重新登录!",
																						function() {
																							relogin();
																						});

																	} else {
																		Ext.Msg
																				.alert(
																						"提示信息",
																						msg.message);
																	}
																}
															})
														}

													}
												}, {
													text : '关闭',
													handler : function() {
														activeWindow.close();
													}
												}]
											});
									activeWindow.show();
								}
							}]
						}]
					}, {
						region : 'center',
						xtype : 'mainmenutabpanel',
						activeTab : 0,
						layout : 'fit',
						closeAction : 'destroy'
					}, {
						region : 'south',
						xtype : 'mainmenufooter'

					}]
		});
	},
	controllers : ['MainMenu']
});
/**
 * 注销
 */
function relogin() {
	Ext.Ajax.request({
		url : '${pageContext.request.contextPath }/Login_loginOut.action',
		success : function(response) {
			location.href = '${pageContext.request.contextPath }/Login_toIndex.action';
		}
	});
}