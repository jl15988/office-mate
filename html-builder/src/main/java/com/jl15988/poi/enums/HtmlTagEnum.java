package com.jl15988.poi.enums;

import lombok.Getter;

/**
 * html标签枚举
 *
 * @author Jalon
 * @since 2024/12/1 19:55
 **/
@Getter
public enum HtmlTagEnum {

    HTML,
    HEAD,
    BODY,
    TITLE,
    META,
    LINK,
    STYLE,
    SCRIPT,
    STRING,
    DIV,
    SPAN,
    P,
    A,
    IMG,
    TABLE,
    TR,
    TH,
    TD,
    UL,
    OL,
    LI,
    HR,
    BR,
    FORM,
    INPUT,
    SELECT,
    OPTION,
    TEXTAREA,
    BUTTON,
    LABEL,
    IFRAME,
    CANVAS,
    SVG,
    PATH,
    H1,
    H2,
    H3,
    H4,
    H5,
    H6;

    public String getName() {
        return name().toLowerCase();
    }

    public boolean equals(String name) {
        return name().equalsIgnoreCase(name);
    }
}