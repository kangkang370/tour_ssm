package com.xiaohan.ssm.utils;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.beans.PropertyEditor;
import java.util.Date;

/**
 * @description: 日期与字符串转换
 * @author: 小韩同学
 * @date: 2020/10/11
 */
public class DateStringEditor extends PropertiesEditor{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date = DateUtils.string2Date(text, "yyyy-MM-dd HH:mm");
            super.setValue(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
