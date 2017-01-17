package com.zpaas.utils;

/**
 * 等于比较工具类
 * @author ZhangJunyong
 *
 */
public class EqualUtil {

    public static boolean isEqual(Long a, Long b) {
        return a.compareTo(b) == 0;
    }

    public static boolean isEqual(long a, long b) {
        return isEqual(Long.valueOf(a), Long.valueOf(b));
    }

    public static boolean isEqual(Long a, long b) {
        return isEqual(a, Long.valueOf(b));
    }

    public static boolean isEqual(Integer a, Integer b) {
        return a.compareTo(b) == 0;
    }

    public static boolean isEqual(Integer a, int b) {
        return a.compareTo(Integer.valueOf(b)) == 0;
    }

    public static boolean isEqual(int a, int b) {
        return a == b;
    }

    public static boolean isEqual(String a, String b) {
        return a.equals(b);
    }

}
