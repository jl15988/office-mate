package com.jl15988.poi.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * Map工具类
 *
 * @author Jalon
 * @since 2024/12/29 18:08
 **/
public class MapUtil {

    /**
     * 判断Map是否包含指定键值对
     *
     * @param map   Map
     * @param key   键
     * @param value 值
     * @return 是否包含
     */
    public static <K, V> boolean has(Map<K, V> map, K key, V value) {
        if (map.containsKey(key)) {
            return map.get(key).equals(value);
        }
        return false;
    }

    /**
     * 判断Map是否包含指定键
     *
     * @param map  Map
     * @param keys 键数组
     * @return 是否包含所有键
     */
    @SafeVarargs
    public static <K, V> boolean hasKeys(Map<K, V> map, K... keys) {
        for (K k : keys) {
            if (!map.containsKey(k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断Map是否包含指定键
     *
     * @param map  Map
     * @param keys 键集合
     * @return 是否包含所有键
     */
    public static <K, V> boolean hasKeys(Map<K, V> map, Iterable<K> keys) {
        for (K k : keys) {
            if (!map.containsKey(k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断Map是否包含指定键
     *
     * @param map  Map
     * @param keys 键迭代器
     * @return 是否包含所有键
     */
    public static <K, V> boolean hasKeys(Map<K, V> map, Iterator<K> keys) {
        while (keys.hasNext()) {
            if (!map.containsKey(keys.next())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断Map是否包含keysMap中键
     *
     * @param map     Map
     * @param keysMap Map2
     * @return 是否包含所有键
     */
    public static <K, V> boolean hasKeys(Map<K, V> map, Map<K, V> keysMap) {
        for (K k : keysMap.keySet()) {
            if (!map.containsKey(k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 向Map中添加键值对，如果条件为真
     *
     * @param map       Map
     * @param condition 条件
     * @param key       键
     * @param value     值
     * @param <K>       键类型
     * @param <V>       值类型
     */
    public static <K, V> void putIf(Map<K, V> map, boolean condition, K key, V value) {
        if (condition) {
            map.put(key, value);
        }
    }

    /**
     * 向Map中添加键值对，如果值不为空
     *
     * @param map   Map
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     */
    public static <K, V> void putIfNotNull(Map<K, V> map, K key, V value) {
        if (value != null) {
            map.put(key, value);
        }
    }

    /**
     * 向Map中添加键值对，如果值不为空（字符串、集合、Map、数组）
     *
     * @param map   Map
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     */
    public static <K, V> void putIfNotEmpty(Map<K, V> map, K key, V value) {
        if (value != null) {
            if (value instanceof String && StrUtil.isEmpty((String) value)) {
                return;
            } else if (value instanceof Iterable && CollUtil.isEmpty((Iterable<?>) value)) {
                return;
            } else if (value instanceof Iterator && CollUtil.isEmpty((Iterator<?>) value)) {
                return;
            } else if (value instanceof Map && map.isEmpty()) {
                return;
            } else if (value instanceof Object[] && ArrayUtil.isEmpty((Object[]) value)) {
                return;
            }
            map.put(key, value);
        }
    }

    /**
     * 向Map中添加键值对，如果值不为空字符
     *
     * @param map   Map
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     */
    public static <K, V> void putIfNotBlank(Map<K, V> map, K key, V value) {
        if (value != null) {
            if (value instanceof CharSequence && StrUtil.isBlank((CharSequence) value)) {
                return;
            }
            map.put(key, value);
        }
    }
}
