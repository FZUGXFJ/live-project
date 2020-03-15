package fzu.gxfj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtil {

    public static java.sql.Timestamp d2t(java.util.Date d) {
        if (null == d)
            return null;
        return new java.sql.Timestamp(d.getTime());
    }

    public static java.util.Date t2d(java.sql.Timestamp t) {
        if (null == t)
            return null;
        return new java.util.Date(t.getTime());
    }

    /**
     *  将日期类转换成字符串
     * @param d 要转换的日期
     * @param format 转化的格式 如 yyyy-MM-dd hh:mm:ss
     * @return 返回字符串形式的日期
     */
    public static String d2s(java.util.Date d, String format)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(d);
    }

    /**
     *  将日期类转换成字符串
     * @param d 要转换的日期
     * @return 返回字符串形式的日期
     */
    public static String d2s(java.util.Date d)
    {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.format(d);
}

    public static Date s2d(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}


