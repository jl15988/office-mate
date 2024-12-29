package com.jl15988.poi.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Html属性
 *
 * @author Jalon
 * @since 2024/12/29 13:32
 **/
public class HtmlAttributes {

    public final Map<String, String> attrMap = new HashMap<>();

    public String get(String name) {
        return this.attrMap.get(name);
    }

    public HtmlAttributes set(String name, String value) {
        this.attrMap.put(name, value);
        return this;
    }

    public HtmlAttributes set(boolean condition, String name, String value) {
        if (condition) {
            return set(name, value);
        }
        return this;
    }

    public HtmlAttributes setIfExists(String name, String value) {
        if (value != null) {
            if (value.isEmpty()) {
                return this;
            }
            return set(name, value);
        }
        return this;
    }

    public HtmlAttributes add(HtmlAttributes htmlAttributes) {
        if (htmlAttributes != null) {
            this.attrMap.putAll(htmlAttributes.attrMap);
        }
        return this;
    }

    public boolean hasAttr(String name) {
        return this.attrMap.containsKey(name);
    }

    public boolean hasAttr(String name, String value) {
        if (!this.attrMap.containsKey(name)) {
            return false;
        }
        return this.attrMap.get(name).equals(value);
    }

    public boolean hasAttr(String... names) {
        List<String> nameList = Arrays.asList(names);
        return this.attrMap.keySet().stream().anyMatch(nameList::contains);
    }

    public HtmlAttributes remove(String name) {
        this.attrMap.remove(name);
        return this;
    }

    public boolean isEmpty() {
        return this.attrMap.isEmpty();
    }

    public String toHtmlString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.attrMap.forEach((k, v) -> {
            stringBuilder.append(k).append("=").append("\"").append(v).append("\"").append(" ");
        });
        return stringBuilder.toString();
    }
}
