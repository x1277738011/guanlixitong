package data;

public class ChangeString {

    public static String ISOToGBK(String str) {
        if (str != null) {
            try {
                str = new String(str.getBytes("gb2312"), "GBK");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;

    }

    public static String GBKToISO(String str) {
        if (str != null) {
            try {
                str = new String(str.getBytes("GBK"), "gb2312");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;

    }
}