package Util;

import java.io.UnsupportedEncodingException;

/**
 * Created by chairyfish on 2017/6/28.
 */
public class EncodingUtil {
    public static String getUTF8(String origin) {
        String correct = "";
        try {
            correct = new String(origin.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return correct;
    }
}
