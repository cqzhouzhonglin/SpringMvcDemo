/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.common.util;

import java.io.IOException;
import java.io.Reader;

import oracle.sql.CLOB;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午10:25:51
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午10:25:51   zhouhong       new file.
 * </pre>
 */
public final class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String emptyConvert(String str, String str1) {
        return isNotEmpty(str) ? str : str1;
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 处理数据库 clob
     * @param clob
     * @return
     */
    public static String CLOBtoString(CLOB clob) {
        Reader inStream = null;
        String data = "";
        try {
            inStream = clob.getCharacterStream();
            char[] c = new char[(int) clob.length()];
            inStream.read(c);
            data = new String(c);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
