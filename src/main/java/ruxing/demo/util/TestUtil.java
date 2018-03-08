package ruxing.demo.util;

import java.util.Date;

/**
 * Created by ruxing on 09/03/2017.
 */
public class TestUtil {

    public static long getTimeIntervalSec(Date firstDate, Date lastDate){
        if (null == firstDate || null == lastDate) {
            return -1;
        }
        long intervalMilli = lastDate.getTime() - firstDate.getTime();
        return  intervalMilli /1000;
    }

}
