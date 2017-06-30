package Util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chairyfish on 2017/6/28.
 */
public class TimeUtil {

    public static String getDate(){
        Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }

    public static Timestamp getTimeStamp(){
        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());
        return now;
    }

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THUR", "FRI", "SAT"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static int getWeekOfDateNum(Date dt) {
        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THUR", "FRI", "SAT"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return w;
    }

}
