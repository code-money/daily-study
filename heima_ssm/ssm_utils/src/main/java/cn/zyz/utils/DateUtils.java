package cn.zyz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-05-31 00:12
 **/

public class DateUtils {
    //日期转换成字符串
    public static String dateToStr(Date date,String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    //字符串转日期
    public static Date strToDate(String string,String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(string);
        return date;
    }
}



