package org.apache.poi.xslf.usermodel;

/* loaded from: classes5.dex */
public interface XSLFShapeContainer extends Iterable<XSLFShape> {
    void clear();

    XSLFAutoShape createAutoShape();

    XSLFConnectorShape createConnector();

    XSLFFreeformShape createFreeform();

    XSLFGroupShape createGroup();

    XSLFPictureShape createPicture(int i);

    XSLFTextBox createTextBox();

    XSLFShape[] getShapes();

    boolean removeShape(XSLFShape xSLFShape);
}
