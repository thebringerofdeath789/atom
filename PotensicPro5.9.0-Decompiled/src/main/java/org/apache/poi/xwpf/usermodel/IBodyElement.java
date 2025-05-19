package org.apache.poi.xwpf.usermodel;

import org.apache.poi.POIXMLDocumentPart;

/* loaded from: classes5.dex */
public interface IBodyElement {
    IBody getBody();

    BodyElementType getElementType();

    POIXMLDocumentPart getPart();

    BodyType getPartType();
}
