/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午10:29:30
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午10:29:30   zhouhong       new file.
 * </pre>
 */
public final class DoubleUtils {
    /**
     * 将double以科学记数法表示的数据（0.123E5）表示的数据转换成不用科学记数法表示的数据(12,300)
     * @param num
     * @return
     */
    public static String double2String(double num) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(30);
        return nf.format(num);
    }

    /**
     * 将double以科学记数法表示的数据（1.2345678E3）表示的数据转换成不用科学记数法表示的数据并且规定小数保留两位四舍五入,(1234.57)
     * @param value
     * @return
     */
    public static String double2String2(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        String strValue = df.format(value);
        return strValue;
    }
}
