/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午10:48:03
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午10:48:03   zhouhong       new file.
 * </pre>
 */
public class DateJsonValueProcessor implements JsonValueProcessor {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static DateJsonValueProcessor dateJsonValueProcessor = null;

    private DateJsonValueProcessor() {
    }

    public static DateJsonValueProcessor getInstance() {
        if (null == dateJsonValueProcessor) {
            dateJsonValueProcessor = new DateJsonValueProcessor();
        }
        return dateJsonValueProcessor;
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    private Object process(Object value) {
        if (value == null) {
            return "";
        } else {
            return dateFormat.format((Timestamp) value);
        }
    }

}
