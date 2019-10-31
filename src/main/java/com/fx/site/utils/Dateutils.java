package com.fx.site.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @auther: mabaofeng
 * @date: 2019/10/31 14:17
 * @description:
 */
public class Dateutils {

    /**
     * 获取 fastDateFormat 实例
     *
     * @param patten
     * @return
     */
    public static FastDateFormat getFastDateFormat(String patten) {
        return FastDateFormat.getInstance(patten);
    }

    /**
     * 将unixTime 转成日期字符串
     *
     * @param unixTime
     * @param patten
     * @return
     */
    public static String formatDateByUnixTime(Integer unixTime, String patten) {
        Date unixDate = new Date(unixTime * 1000L);
        return getFastDateFormat(patten).format(unixDate);
    }

    /**
     * 将字符串转成日期
     *
     * @param dateStr
     * @param patten
     * @return
     * @throws ParseException
     */
    public static Date dateFormat(String dateStr, String patten) throws ParseException {
        return getFastDateFormat(patten).parse(dateStr);
    }
}
