package org.apache.poi.xssf.model;

import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

@Internal
/* loaded from: classes5.dex */
public abstract class ParagraphPropertyFetcher<T> {
    private int _level;
    private T _value;

    public abstract boolean fetch(CTTextParagraphProperties cTTextParagraphProperties);

    public T getValue() {
        return this._value;
    }

    public void setValue(T t) {
        this._value = t;
    }

    public ParagraphPropertyFetcher(int i) {
        this._level = i;
    }

    public boolean fetch(CTShape cTShape) {
        XmlObject[] selectPath = cTShape.selectPath("declare namespace xdr='http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//xdr:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
        if (selectPath.length == 1) {
            return fetch((CTTextParagraphProperties) selectPath[0]);
        }
        return false;
    }
}
