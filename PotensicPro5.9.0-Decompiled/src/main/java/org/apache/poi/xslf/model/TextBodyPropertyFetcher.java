package org.apache.poi.xslf.model;

import org.apache.poi.xslf.usermodel.XSLFSimpleShape;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;

/* loaded from: classes5.dex */
public abstract class TextBodyPropertyFetcher<T> extends PropertyFetcher<T> {
    public abstract boolean fetch(CTTextBodyProperties cTTextBodyProperties);

    @Override // org.apache.poi.xslf.model.PropertyFetcher
    public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
        XmlObject[] selectPath = xSLFSimpleShape.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txBody/a:bodyPr");
        if (selectPath.length == 1) {
            return fetch((CTTextBodyProperties) selectPath[0]);
        }
        return false;
    }
}
