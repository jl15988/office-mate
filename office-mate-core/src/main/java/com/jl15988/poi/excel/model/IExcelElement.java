package com.jl15988.poi.excel.model;

import com.jl15988.poi.model.CssStyle;
import com.jl15988.poi.model.HtmlElement;

/**
 * @author Jalon
 * @since 2024/12/29 12:22
 **/
public interface IExcelElement<T> {

    /**
     * 获取html内容
     */
    HtmlElement getHtml();

    /**
     * 获取样式值
     */
    CssStyle getStyle();

    /**
     * 设置样式
     *
     * @param cssStyle 样式
     */
    T setStyle(CssStyle cssStyle);

    /**
     * 添加样式
     *
     * @param styleName 样式名
     * @param value     值
     */
    T addStyle(String styleName, Object value);

    /**
     * 添加样式
     *
     * @param cssStyle css样式
     */
    T addStyle(CssStyle cssStyle);

    /**
     * 移除某个样式
     *
     * @param styleName 样式名
     */
    T removeStyle(String styleName);

    /**
     * 判断是否有某个样式
     *
     * @param styleName 样式名
     */
    default boolean hasStyle(String styleName) {
        return getStyle().hasStyle(styleName);
    }

    /**
     * 判断是否有某几个样式
     *
     * @param names 样式名
     */
    default boolean hasStyles(String... names) {
        return getStyle().hasStyle(names);
    }

    /**
     * 判断是否有某个样式，包括值
     *
     * @param styleName 样式名
     * @param value     值
     */
    default boolean hasStyle(String styleName, Object value) {
        return this.getStyle().hasStyle(styleName, value);
    }
}
