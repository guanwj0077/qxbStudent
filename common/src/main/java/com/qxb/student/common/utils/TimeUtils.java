package com.qxb.student.common.utils;

/**
 * @author winky
 * @date 2018/8/3
 */
public class TimeUtils {

    public static String intervalStr(long time) {
        String strTime;/*返回的时间*/

        long m = 60L;/*1分钟  刚刚*/
        long m1 = 1800L;/*30分钟*/
        long h = 3600L;/*1小时*/
        long d1 = 43200L;/* 3600*12 半天  */
        long d = 86400L;/*1天*/
        long y2 = 1296000L;/*86400*15 半月*/
        long y = 2592000L;/*一个月*/
        long n1 = 15552000;/*半年*/
        long n = 31104000;/*一年*/

        long str = (System.currentTimeMillis() - time) / 1000;

        if (str < m) {
            return "刚刚";
        }
        if (str > m && str <= m1) {
            return str / m + "分钟前";
            // return "1分钟前";
        }
        if (str > m1 && str <= h) {
            return "半小时前";
        }
        if (str > h && str <= d1) {
            return str / h + "小时前";
            // return "1小时前";
        }
        if (str > d1 && str <= d) {
            return "半天前";
        }
        if (str > d && str <= y2) {
            return str / d + "天前";
        }
        if (str > y2 && str <= y) {
            return "半个月前";
        }
        if (str > y && str <= n1) {
            return str / y + "月前";
        }
        if (str > n1 && str <= n) {
            return "半年前";
        }
        if (str > n) {
            return str / n + "年前";
        }
        return "";
    }
}
