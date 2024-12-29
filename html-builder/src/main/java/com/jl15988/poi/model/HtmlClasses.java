package com.jl15988.poi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Html class
 *
 * @author Jalon
 * @since 2024/12/29 13:36
 **/
public class HtmlClasses {

    public final List<String> classList = new ArrayList<>();

    public HtmlClasses add(String className) {
        this.classList.add(className);
        return this;
    }

    public boolean hasClass(String className) {
        return this.classList.contains(className);
    }

    public boolean hasClass(String... className) {
        List<String> classList = Arrays.asList(className);
        return this.classList.stream().anyMatch(classList::contains);
    }

    public HtmlClasses remove(String className) {
        this.classList.remove(className);
        return this;
    }

    public boolean isEmpty() {
        return this.classList.isEmpty();
    }

    public String toHtmlString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < classList.size(); i++) {
            sb.append(classList.get(i));
            if (i < classList.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
