/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午10:31:16
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午10:31:16   zhouhong       new file.
 * </pre>
 */
public final class DateUtils {
    /**
     * 按照yyyy-MM-dd格式获取当前日期
     * 
     * @return
     */
    public static Date getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式获取系统当前时间
     * 
     * @param format
     * @param date
     */
    public static Date getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式获取系统当前时间
     * 
     * @param format
     * @param date
     */
    public static Date getTime(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按照指定格式将字符串转换为日期
     * 
     * @param format
     * @param date
     */
    public static Date getDate(String format, String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            if (StringUtils.isNotEmpty(source)) {
                return dateFormat.parse(source);
            } else {
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将yyyy-MM-dd格式的字符串转换为日期类型
     * 
     * @param source
     * @return
     */
    public static Date getDate(String source) {
        if (source != null) {
            return getDate("yyyy-MM-dd", source);
        } else {
            return null;
        }
    }

    /**
     * 将日期转换为字符串类型
     * 
     * @return
     */
    public static String date2Char(Date date) {
        try {
            if (date != null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                return format.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将日期转换为字符串类型的时间
     * 
     * @return
     */
    public static String time2Char(Date date) {
        try {
            if (date != null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return format.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将日期转换为字符串类型的时间
     * 
     * @return
     */
    public static String time2Char2(Date date) {
        try {
            if (date != null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH点mm分");
                return format.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取两个日期相差的天数
     * 
     * @param date1 起始日期
     * @param date2 截止日期
     * @return
     */
    public static Integer getDays(Date start, Date end) {
        try {
            if (start == null || end == null) {
                return null;
            }
            SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = f1.parse(f1.format(start));
            Date d2 = f2.parse(f2.format(end));
            int days = (int) ((d2.getTime() - d1.getTime()) / (60000 * 60 * 24));
            return days;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("get days is error");
        }
    }

    /**
     * 按照指定的格式返回当前日期的字符串表是形式
     * 
     * @param format
     * @return
     */
    public static String getDateForChar(String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按照yyyy-MM-dd格式返回当前日期的字符串表是形式
     * 
     * @return
     */
    public static String getDateForChar() {
        return getDateForChar("yyyy-MM-dd");
    }

    /**
     * 为原日期添加指定的天数并返回添加后的日期，如果天数为负数则在原日期的基础上减去指定的天数
     * 
     * @param source
     * @param days
     * @return
     */
    public static Date addDays(Date source, int days) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            format.parse(format.format(source));
            Calendar calendar = format.getCalendar();
            calendar.add(Calendar.DAY_OF_YEAR, days);
            return calendar.getTime();
        } catch (Exception e) {
            throw new RuntimeException("add days is error.");
        }
    }

    /**
     * 为原日期添加指定的年数并返回添加后的日期，如果年数为负数则在原日期的基础上减去指定的年数
     * 
     * @param source
     * @param days
     * @return
     */
    public static Date addYear(Date source, int year) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            format.parse(format.format(source));
            Calendar calendar = format.getCalendar();
            calendar.add(Calendar.YEAR, year);
            return calendar.getTime();
        } catch (Exception e) {
            throw new RuntimeException("add days is error.");
        }
    }

    /**
     * 取出剩余天数
     * 
     * @param startDate 开始时间
     * @param overDate 结束时间
     * @return day 
     */
    public static long getOverDayNum(Date startDate, Date overDate) {
        long day = 0;
        day = overDate.getTime() - startDate.getTime();
        day = day / 1000 / 60 / 60 / 24;

        return day;
    }

    /**
     * 取出当前年
     * @return
     */
    public static String getYear() {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        return year.toString();
    }

    /**
     * 取出当前月
     * @return
     */
    public static String getMonth() {
        Calendar cal = Calendar.getInstance();
        Integer month = cal.get(Calendar.MONTH) + 1;
        return month.toString();
    }

    /**
     * 取出当前日
     * @return
     */
    public static String getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        Integer day = cal.get(Calendar.DAY_OF_MONTH);
        return day.toString();
    }

    /**
     * 取得指定日期为星期几 
     * @param date
     * @return 返回1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六
     */
    public static int getDayofWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
     * @return
     */
    public static String getTimeNum() {
        return new Long(new Date().getTime()).toString();
    }

    /**
     * 取两个日期之间的所有日期
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     * @throws ParseException
     */
    public static List<Date> getBetweenDate(String startDate, String endDate) throws ParseException {
        List<Date> list = new ArrayList<Date>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
        gc1.setTime(sdf.parse(startDate));
        gc2.setTime(sdf.parse(endDate));
        do {
            GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
            String DateStr = gc3.get(Calendar.YEAR) + "-" + (gc3.get(Calendar.MONTH) + 1) + "- "
                    + gc3.get(Calendar.DAY_OF_MONTH);
            list.add(getDate(DateStr));
            gc1.add(Calendar.DAY_OF_MONTH, 1);
        } while (!gc1.after(gc2));
        return list;
    }

    /**
     * 将日期增加天数
     * @param date
     * @param dayNum
     * @return
     */
    public static Date dateAddDay(Date date, int dayNum) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, dayNum);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        return date;
    }

    /**
     * 将日期减天数
     * @param date
     * @param dayNum
     * @return
     */
    public static Date dateDecDay(Date date, int dayNum) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -dayNum);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        return date;
    }

    /**
     * 取两个时间之间的豪秒数
     * @return
     */
    public static Long getBetweenMillis(Date startTime, Date endTime) {
        Long i = endTime.getTime() - startTime.getTime();
        return i;
    }

    public static void main(String[] args) throws Exception {
        // List<Date> list=getBetweenDate("2009-12-29", "2009-12-5");
        // for(Date d:list)
        // {
        // System.out.println(date2Char(d));
        // }
        // int i=getDayofWeek(new Date());
        // System.out.println(i);

        // System.out.println(date2Char(dateAddDay(new Date(),10)));
        // System.out.println(date2Char(dateDecDay(new Date(),100)));

        // System.out.println(time2Char2(new Date()));
        // Date start=new Date();
        // Thread.sleep(10*1000);
        // Date end=new Date();
        // System.out.println(getBetweenMin(start,end));
        // Thread.sleep(millis)
        // System.out.println(10000/(60*1000));
    }
}
