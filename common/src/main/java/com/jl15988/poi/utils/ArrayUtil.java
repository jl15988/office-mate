package com.jl15988.poi.utils;

/**
 * 数组工具类
 *
 * @author Jalon
 * @since 2024/12/29 18:29
 **/
public class ArrayUtil {

    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否不为空
     *
     * @param array 数组
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }
}
