package com.sxzhwts.ticket.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 作者：fcy on 2018/4/18 16:14
 */

public class TimesUtils {
    public static String parse2HM(long date) {
        Date date1 = new Date( date*1000);
        GregorianCalendar gc = new GregorianCalendar();//标准日历系统类
        gc.setTime(date1);
        return new SimpleDateFormat(" HH:mm").format(gc.getTime());
    }
    public static String parse2YHM(long date) {
        Date date1 = new Date( date*1000);
        GregorianCalendar gc = new GregorianCalendar();//标准日历系统类
        gc.setTime(date1);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(gc.getTime());
    }
    /**
     *
     * @param date
     * @return
     */
    public static String parseYMd(Date date) {
        GregorianCalendar gc = new GregorianCalendar();//标准日历系统类
        gc.setTime(date);
        return new SimpleDateFormat("yyyy-MM-dd").format(gc.getTime());
    }
    /**
     * 日期:+-
     */
    public static Date dayOperation(Date date, int ndays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, ndays);
        return cal.getTime();
    }
    /**
     * 月份:+-
     */
    public static Date monthOperation(Date date, int nmonths) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, nmonths);
        return cal.getTime();
    }
}
