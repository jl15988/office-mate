package com.jl15988.poi.model;

import com.jl15988.poi.utils.CssUtil;
import com.jl15988.poi.utils.MapUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * css 样式
 *
 * @author Jalon
 * @since 2024/12/3 16:02
 **/
public class CssStyle {

    // 样式 Map
    private final Map<String, Object> styleMap = new HashMap<>();

    /**
     * 获取样式 Map
     */
    public Map<String, Object> getMap() {
        return this.styleMap;
    }

    /**
     * 获取样式值
     *
     * @param name 样式名
     */
    public Object get(String name) {
        return this.styleMap.get(name);
    }

    /**
     * 获取样式值，如果没有则返回默认值
     *
     * @param name         样式名
     * @param defaultValue 默认值
     */
    public Object getOrDefault(String name, Object defaultValue) {
        return this.styleMap.getOrDefault(name, defaultValue);
    }

    /**
     * 设置样式
     *
     * @param name  样式名
     * @param value 值
     */
    public CssStyle set(String name, Object value) {
        this.styleMap.put(name, value);
        return this;
    }

    /**
     * 设置样式
     *
     * @param condition 条件
     * @param name      样式名
     * @param value     值
     */
    public CssStyle set(boolean condition, String name, Object value) {
        MapUtil.putIf(this.styleMap, condition, name, value);
        return this;
    }

    /**
     * 设置样式，如果值不为空
     *
     * @param name  样式名
     * @param value 值
     */
    public CssStyle setIfExists(String name, Object value) {
        MapUtil.putIfNotBlank(this.styleMap, name, value);
        return this;
    }

    /**
     * 添加样式
     *
     * @param cssStyle 样式
     */
    public CssStyle addAll(CssStyle cssStyle) {
        if (Objects.nonNull(cssStyle)) {
            this.styleMap.putAll(cssStyle.styleMap);
        }
        return this;
    }

    /**
     * 判断是否包含某个样式
     *
     * @param name 样式名
     */
    public boolean hasStyle(String name) {
        return this.styleMap.containsKey(name);
    }

    /**
     * 判断是否包含某个样式，包括值
     *
     * @param name  样式名
     * @param value 样式值
     */
    public boolean hasStyle(String name, Object value) {
        return MapUtil.has(this.styleMap, name, value);
    }

    /**
     * 判断是否包含某几个样式
     *
     * @param names 样式名
     */
    public boolean hasStyle(String... names) {
        return MapUtil.hasKeys(this.styleMap, names);
    }

    /**
     * 移除某个样式
     *
     * @param name 样式名
     */
    public CssStyle remove(String name) {
        this.styleMap.remove(name);
        return this;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return this.styleMap.isEmpty();
    }

    /**
     * 清空样式
     */
    public CssStyle clear() {
        this.styleMap.clear();
        return this;
    }

    /**
     * 转为 css 字符串
     */
    public String toHtmlString() {
        return CssUtil.mapToCssString(this.styleMap);
    }
}
