/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.supper.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午9:22:13
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午9:22:13   zhouhong       new file.
 * </pre>
 */
public abstract class SupperController {
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 输出字符串
     * 
     * @param str
     */
    protected void outString(String str, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json; charset=UTF-8");
            out = response.getWriter();
            out.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 输出json字符串 
     * 
     * @param str
     */
    protected void outJson(String json, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json; charset=UTF-8");
            out = response.getWriter();
            out.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 输出json Boolean
     * 
     * @param flag true或false
     */
    protected void outJsonForRs(Boolean flag, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json; charset=UTF-8");
            out = response.getWriter();
            out.write("{\"rs\":" + flag + "}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 输出json Boolean
     * 
     * @param flag true或false
     * @param msg 提示内容
     */
    protected void outJsonForRs(Boolean flag, String msg, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json; charset=UTF-8");
            out = response.getWriter();
            out.write("{rs:" + flag + ",msg:\'" + msg + "'}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 输出json字符串
     * 
     * @param flag
     */
    protected void outJsonForRs(String rs, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json; charset=UTF-8");
            out = response.getWriter();
            out.write("{\"rs\":" + rs + "}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     *输出json Boolean
     * 
     * @param flag
     */
    protected void outJsonForSuccess(Boolean flag, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json; charset=UTF-8");
            out = response.getWriter();
            out.write("{\"success\":" + flag + "}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     *输出json Boolean
     * 
     * @param flag
     */
    protected void outJsonForSuccessParam(Boolean flag, String param, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json; charset=UTF-8");
            out = response.getWriter();
            out.write("{\"success\":" + flag + "," + param + "}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
