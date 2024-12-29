package com.jl15988.poi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jalon
 * @since 2024/11/29 17:52
 **/
public class HtmlElements {

    private final List<HtmlElement> elementList = new ArrayList<>();

    public HtmlElements add(HtmlElement element) {
        this.elementList.add(element);
        return this;
    }

    public HtmlElements add(HtmlElements elements) {
        this.elementList.addAll(elements.elementList);
        return this;
    }

    public HtmlElements remove(HtmlElement element) {
        this.elementList.remove(element);
        return this;
    }

    public boolean isEmpty() {
        return this.elementList.isEmpty();
    }

    public String toHtmlString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elementList.size(); i++) {
            sb.append(elementList.get(i).toHtmlString());
        }
        return sb.toString();
    }
}
