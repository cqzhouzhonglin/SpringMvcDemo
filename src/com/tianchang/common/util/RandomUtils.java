/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.common.util;

import java.util.Random;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午10:30:19
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午10:30:19   zhouhong       new file.
 * </pre>
 */
public final class RandomUtils {
    /**
     * 随机生成六位数
     * @return
     */
    public static int getRandom() {
        int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < 6; i++)
            result = result * 10 + array[i];
        return result;
    }

    public static String getRandom(int lenght) {
        String[] randomValues = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f",
                "g", "h", "i", "j", "k", "l", "m", "n", "u", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "U", "t", "s", "o", "x", "v", "p", "q", "r", "w", "y", "z", "T", "S", "O", "X", "V", "P", "Q", "R", "W",
                "Y", "Z" };
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < lenght; i++) {
            Double number = Math.random() * (randomValues.length - 1);
            str.append(randomValues[number.intValue()]);
        }
        return str.toString();
    }

    /**
     * 生成六位密码
     * @return
     */
    public static String getRandomPassword() {
        return RandomUtils.getRandom(6);
    }

    public static void main(String[] args) {
        System.out.println(RandomUtils.getRandomPassword());
    }
}
