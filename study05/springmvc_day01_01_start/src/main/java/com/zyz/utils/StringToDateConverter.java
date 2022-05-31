package com.zyz.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-27 18:45
 **/

public class StringToDateConverter implements Converter<String,Date> {


    /**
     *
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        if (source==null){
            throw new RuntimeException("请传入数据");
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("转换错误");
        }
    }
}



