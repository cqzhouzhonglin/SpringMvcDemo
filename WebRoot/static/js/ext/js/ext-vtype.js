// 自定义vtype动态验证
Ext.apply(Ext.form.VTypes, {
			// 年龄
			"age" : function(_v) {
				if (/^\d+$/.test(_v)) {
					var _age = parseInt(_v);
					if (_age < 200)
						return true;
				} else
					return false;
			},
			'ageText' : '年龄格式出错！！格式例如：20',

			// 手机
			"mobile" : function(_v) {
				return /^(13[0-9]{9})$|(18[0-9]{9})$|(15[0-9]{9})$/.test(_v);
			},
			"mobileText" : "该输入项目必须是手机号码格式，例如：13485135075",
			"mobileMask" : /[0-9]/i,

			// 密码验证
			"repetition" : function(val, field) { // 返回true，则验证通过，否则验证失败
				if (field.repetition) { // 如果表单有使用repetition配置，repetition配置是一个JSON对象，该对象提供了一个名为targetCmpId的字段，该字段指定了需要进行比较的另一个组件ID。
					var cmp = Ext.getCmp(field.repetition.targetCmpId); // 通过targetCmpId的字段查找组件
					if (Ext.isEmpty(cmp)) { // 如果组件（表单）不存在，提示错误
						Ext.MessageBox.show({
									title : '错误',
									msg : '发生异常错误，指定的组件未找到',
									icon : Ext.Msg.ERROR,
									buttons : Ext.Msg.OK
								});
						return false;
					}
					if (val == cmp.getValue()) { // 取得目标组件（表单）的值，与宿主表单的值进行比较。
						return true;
					} else {
						return false;
					}
				}
			},
			"repetitionText" : '两次输入密码不一至,请修改！'
		});