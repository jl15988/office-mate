package com.jl15988.poi.model;

import com.jl15988.poi.enums.HtmlTagEnum;
import com.jl15988.poi.utils.StrUtil;
import lombok.Getter;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * html元素，默认元素为 div
 *
 * @author Jalon
 * @since 2024/11/30 19:51
 **/
@Getter
public class HtmlElement {

    private final String uid;

    // id
    private String id;

    // 标签名称
    private final String tagName;

    // 内容
    private String content;

    // class
    private final HtmlClasses classes = new HtmlClasses();

    // 样式
    private final CssStyle style = new CssStyle();

    // 属性
    private final HtmlAttributes attributes = new HtmlAttributes();

    // 子元素
    private final HtmlElements children = new HtmlElements();

    public HtmlElement(HtmlTagEnum tagName) {
        this.tagName = tagName.getName();
        this.uid = UUID.randomUUID().toString();
    }

    public HtmlElement(String tagName) {
        this.tagName = tagName;
        this.uid = UUID.randomUUID().toString();
    }

    public HtmlElement() {
        this(HtmlTagEnum.DIV);
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public HtmlElement setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 判断是否某个标签
     *
     * @param tagName 标签名称
     */
    public boolean isTag(String tagName) {
        return getTagName().equals(tagName);
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public HtmlElement setContent(String content) {
        this.content = content;
        return this;
    }

    public HtmlElement buildClass(Consumer<HtmlClasses> consumer) {
        consumer.accept(this.classes);
        return this;
    }

    /**
     * 判断是否包含某个class
     *
     * @param className class名
     */
    public boolean hasClass(String className) {
        return this.classes.hasClass(className);
    }

    /**
     * 判断是否包含某几个class
     *
     * @param classes class名
     */
    public boolean hasClasses(String... classes) {
        return this.classes.hasClass(classes);
    }

    public HtmlElement buildStyle(Consumer<CssStyle> consumer) {
        consumer.accept(this.style);
        return this;
    }

    /**
     * 判断是否包含某个style
     *
     * @param name style名
     */
    public boolean hasStyle(String name) {
        return this.style.hasStyle(name);
    }

    /**
     * 判断是否包含某个style，包括值
     *
     * @param name  style名
     * @param value style值
     */
    public boolean hasStyle(String name, Object value) {
        return this.style.hasStyle(name, value);
    }

    /**
     * 判断是否包含某几个style
     *
     * @param names style名
     */
    public boolean hasStyles(String... names) {
        return this.style.hasStyle(names);
    }

    public HtmlElement buildAttribute(Consumer<HtmlAttributes> consumer) {
        consumer.accept(this.attributes);
        return this;
    }

    /**
     * 判断是否包含某个属性
     *
     * @param name 属性名
     */
    public boolean hasAttribute(String name) {
        return this.attributes.hasAttr(name);
    }

    /**
     * 判断是否包含某几个属性
     *
     * @param attributes 属性名
     */
    public boolean hasAttributes(String... attributes) {
        return this.attributes.hasAttr(attributes);
    }

    /**
     * 判断是否包含某个属性，包括值
     *
     * @param name  属性名
     * @param value 属性值
     */
    public boolean hasAttribute(String name, String value) {
        return this.attributes.hasAttr(name, value);
    }

    public HtmlElement buildChild(Consumer<HtmlElements> consumer) {
        consumer.accept(this.children);
        return this;
    }

    /**
     * 转为html字符串
     *
     * @return html字符串
     */
    public String toHtmlString() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean hasTag = StrUtil.isNotBlank(tagName) || HtmlTagEnum.STRING.equals(tagName);

        if (hasTag) {
            stringBuilder.append("<").append(tagName);
            if (id != null && !id.isEmpty()) {
                stringBuilder.append(" ").append("id=\"").append(id).append("\"");
            }

            if (!this.classes.isEmpty()) {
                stringBuilder.append(" class=\"").append(this.classes.toHtmlString()).append("\"");
            }

            if (!this.style.isEmpty()) {
                stringBuilder.append(" ").append("style=\"").append(this.style.toHtmlString()).append("\"");
            }

            if (!this.attributes.isEmpty()) {
                stringBuilder.append(" ").append(this.attributes.toHtmlString());
            }
            stringBuilder.append(">");
        }

        if (content != null) {
            stringBuilder.append(content);
        } else {
            if (!this.children.isEmpty()) {
                stringBuilder.append(this.children.toHtmlString());
            }
        }

        if (hasTag) {
            stringBuilder.append("</").append(tagName).append(">");
        }

        return stringBuilder.toString();
    }

    public boolean equals(HtmlElement other) {
        return this.getUid().equals(other.getUid());
    }
}
