/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.common.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;


/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午10:36:51
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午10:36:51   zhouhong       new file.
 * </pre>
 */
public class EncryptionUtils {
    // 使用简单的MD5加密方式
    public static String md5(String password) {
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        md5.setEncodeHashAsBase64(false);
        String pwd = md5.encodePassword(password, null);
        return pwd;
    }

    // 使用MD5再加全局加密盐加密的方式加密
    public static String md5_SystemWideSaltSource(String password, String salt) {
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        md5.setEncodeHashAsBase64(false);
        String pwd = md5.encodePassword(password, salt);
        return pwd;
    }

    // 使用SHA-256的哈希算法(SHA)加密
    public static String sha_256(String password) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
        sha.setEncodeHashAsBase64(false);
        String pwd = sha.encodePassword(password, null);
        return pwd;
    }

    // 使用SHA-256的哈希算法(SHA)加密
    public static String sha_SHA_256(String password, String sh) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
        sha.setEncodeHashAsBase64(false);
        String pwd = sha.encodePassword(password, sh);
        return pwd;
    }

    public static void main(String[] args) {
        // System.out.println(sha_256("测试"));
        // System.out.println("30ce6eb647692a8a6ed30580021b8d772cfd128a9b664f965cdc17c0e6597543".length());
        // System.out.println(md5_SystemWideSaltSource("000000", "admin"));
        // System.out.println(sha_SHA_256("000000","aa"));

        String userName = "bususer";
        String pwd = EncryptionUtils.sha_SHA_256("1", userName);
        System.out.println(pwd);
        System.out.println(EncryptionUtils.sha_SHA_256("", userName));
    }
}
