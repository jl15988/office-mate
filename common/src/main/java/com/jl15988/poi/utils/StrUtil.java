package com.jl15988.poi.utils;

/**
 * 字符串工具类
 *
 * @author Jalon
 * @since 2024/12/29 15:00
 **/
public class StrUtil {

    /**
     * 判断字符串是否为空
     *
     * @param cs 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param cs 字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断字符串是否为空
     *
     * @param cs 字符串
     * @return 是否为空
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen = length(cs);
        if (strLen != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param cs 字符串
     * @return 是否不为空
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 获取字符串长度
     *
     * @param cs 字符串
     * @return 长度
     */
    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }
}
