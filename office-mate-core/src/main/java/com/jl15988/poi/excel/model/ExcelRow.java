package com.jl15988.poi.excel.model;

import com.jl15988.poi.model.CssStyle;
import com.jl15988.poi.model.HtmlElement;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * Excel行
 *
 * @author Jalon
 * @since 2024/12/29 10:48
 **/
public class ExcelRow {

    /**
     * 所属sheet
     */
    private ExcelSheet excelSheet;

    /**
     * 行
     */
    private Row row;

    /**
     * 行html内容
     */
    private HtmlElement htmlElement;

    /**
     * 行样式
     */
    private CssStyle cssStyle;

    /**
     * 单元格
     */
    private List<ExcelCell> cells;

    /**
     * 行索引
     */
    private int rowIndex;
}
