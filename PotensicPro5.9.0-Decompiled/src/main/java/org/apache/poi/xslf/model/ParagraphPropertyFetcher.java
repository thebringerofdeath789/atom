package org.apache.poi.xslf.model;

import org.apache.poi.xslf.usermodel.XSLFSimpleShape;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* loaded from: classes5.dex */
public abstract class ParagraphPropertyFetcher<T> extends PropertyFetcher<T> {
    int _level;

    public abstract boolean fetch(CTTextParagraphProperties cTTextParagraphProperties);

    public ParagraphPropertyFetcher(int i) {
        this._level = i;
    }

    @Override // org.apache.poi.xslf.model.PropertyFetcher
    public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
        XmlObject[] selectPath = xSLFSimpleShape.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
        if (selectPath.length == 1) {
            return fetch((CTTextParagraphProperties) selectPath[0]);
        }
        return false;
    }
}
