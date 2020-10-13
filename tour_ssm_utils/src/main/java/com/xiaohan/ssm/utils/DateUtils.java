package com.xiaohan.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/10
 */
public class DateUtils {

    // 日期转换成字符串
    public static String date2String(Date date, String str){
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        String format = sdf.format(date);
        return format;
    }
    // 字符串转换成日期
    public static Date string2Date(String str, String patt) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}
