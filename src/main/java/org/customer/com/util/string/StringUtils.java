package org.customer.com.util.string;

public class StringUtils {
    public static String str(String st) {
        try {
            return new String(st.getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
