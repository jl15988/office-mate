package com.jl15988.poi.excel.model;

import com.jl15988.poi.model.CssStyle;
import com.jl15988.poi.model.HtmlElement;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Excel单元格
 *
 * @author Jalon
 * @since 2024/12/29 10:49
 **/
public class ExcelCell implements IExcelElement<ExcelCell> {

    /**
     * 所属行
     */
    private final ExcelRow excelRow;

    /**
     * 单元格
     */
    private final Cell cell;

    /**
     * 单元格内容
     */
    private String value;

    /**
     * 单元格的html内容
     */
    private final HtmlElement html;

    /**
     * 单元格样式
     */
    private final CssStyle style;

    public ExcelCell(ExcelRow excelRow, Cell cell) {
        this.excelRow = excelRow;
        this.cell = cell;
        this.html = new HtmlElement("td");
        this.style = new CssStyle();
    }

    @Override
    public HtmlElement getHtml() {
        return this.html;
    }

    @Override
    public CssStyle getStyle() {
        return this.style;
    }

    @Override
    public ExcelCell setStyle(CssStyle cssStyle) {
        this.style.clear();
        if (cssStyle == null) {
            return this;
        }
        this.style.addAll(cssStyle);
        return this;
    }

    @Override
    public ExcelCell addStyle(String styleName, Object value) {
        return null;
    }

    @Override
    public ExcelCell addStyle(CssStyle cssStyle) {
        return null;
    }

    @Override
    public ExcelCell removeStyle(String styleName) {
        return null;
    }
}
