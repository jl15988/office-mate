package com.jl15988.poi.model;

import java.util.HashMap;
import java.util.Map;

/**
 * html style
 *
 * @author Jalon
 * @since 2024/12/1 19:06
 **/
public class HtmlStyle {

    private final Map<String, CssStyle> styleMap = new HashMap<String, CssStyle>();

    public Map<String, CssStyle> getStyles() {
        return styleMap;
    }

    public void addStyle(final String name, final CssStyle style) {
        styleMap.put(name, style);
    }

    public HtmlStyle getStyle(final String name) {
        styleMap.get(name);
        return this;
    }

    public HtmlStyle removeStyle(final String name) {
        styleMap.remove(name);
        return this;
    }

    public HtmlStyle clearStyles() {
        styleMap.clear();
        return this;
    }

    public String toHtmlString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<style type=\"text/css\" rel=\"stylesheet\">");
        styleMap.forEach((name, cssStyle) -> {
            stringBuilder.append(name).append("{").append(cssStyle.toHtmlString()).append("}");
        });
        stringBuilder.append("</style>");
        return stringBuilder.toString();
    }
}
