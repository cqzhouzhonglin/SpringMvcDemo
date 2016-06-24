/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午10:23:49
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午10:23:49   zhouhong       new file.
 * </pre>
 */
public final class WebUtils {
    /**
     * 取得带相同前缀的Request Parameters.
     * 
     * 返回的结果Parameter名已去除前缀.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getParametersStartingWith(HttpServletRequest request, String prefix) {
        return org.springframework.web.util.WebUtils.getParametersStartingWith(request, prefix);
    }
}
