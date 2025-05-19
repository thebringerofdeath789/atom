package com.lib.bean;

import jxl.Cell;
import jxl.CellFeatures;
import jxl.CellType;
import jxl.format.CellFormat;

/* loaded from: classes2.dex */
public class ExcelCell implements Cell {
    private final Cell cell;
    private LanguageWriter languageWriter;

    public ExcelCell(Cell cell) {
        this.cell = cell;
    }

    public LanguageWriter getLanguage() {
        return this.languageWriter;
    }

    public void setLanguage(LanguageWriter languageWriter) {
        this.languageWriter = languageWriter;
    }

    @Override // jxl.Cell
    public int getRow() {
        return this.cell.getRow();
    }

    @Override // jxl.Cell
    public int getColumn() {
        return this.cell.getColumn();
    }

    @Override // jxl.Cell
    public CellType getType() {
        return this.cell.getType();
    }

    @Override // jxl.Cell
    public boolean isHidden() {
        return this.cell.isHidden();
    }

    @Override // jxl.Cell
    public String getContents() {
        return this.cell.getContents();
    }

    @Override // jxl.Cell
    public CellFormat getCellFormat() {
        return this.cell.getCellFormat();
    }

    @Override // jxl.Cell
    public CellFeatures getCellFeatures() {
        return this.cell.getCellFeatures();
    }
}
