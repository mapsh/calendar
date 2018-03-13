package com.mapsh.calendar;

import android.support.annotation.IntRange;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author mapsh
 */
class CalendarUtils {

    /**
     * @param month 月份
     * @param year  年份
     * @return 返回月份有多少天
     */
    static int getDaysInMonth(@IntRange(from = Calendar.JANUARY, to = Calendar.DECEMBER) int month, @IntRange(from = 1970) int year) {
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                return 31;
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                return 30;
            case Calendar.FEBRUARY:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }

    /**
     * 判断年份是否为闰年
     * 判断闰年的条件， 能被4整除同时不能被100整除，或者能被400整除
     */
    private static boolean isLeapYear(@IntRange(from = 1970) int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }


    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(date1);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(date2);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
                && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
    }

}
