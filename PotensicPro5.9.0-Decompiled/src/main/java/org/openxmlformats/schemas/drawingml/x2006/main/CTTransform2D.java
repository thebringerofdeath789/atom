package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTransform2D extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTransform2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttransform2d5deftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTransform2D newInstance() {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().newInstance(CTTransform2D.type, null);
        }

        public static CTTransform2D newInstance(XmlOptions xmlOptions) {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().newInstance(CTTransform2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTransform2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(File file) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(file, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(file, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(Reader reader) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(reader, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(reader, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(String str) throws XmlException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(str, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(str, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(URL url) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(url, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(url, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTransform2D.type, xmlOptions);
        }

        public static CTTransform2D parse(Node node) throws XmlException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(node, CTTransform2D.type, (XmlOptions) null);
        }

        public static CTTransform2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTransform2D) XmlBeans.getContextTypeLoader().parse(node, CTTransform2D.type, xmlOptions);
        }
    }

    CTPositiveSize2D addNewExt();

    CTPoint2D addNewOff();

    CTPositiveSize2D getExt();

    boolean getFlipH();

    boolean getFlipV();

    CTPoint2D getOff();

    int getRot();

    boolean isSetExt();

    boolean isSetFlipH();

    boolean isSetFlipV();

    boolean isSetOff();

    boolean isSetRot();

    void setExt(CTPositiveSize2D cTPositiveSize2D);

    void setFlipH(boolean z);

    void setFlipV(boolean z);

    void setOff(CTPoint2D cTPoint2D);

    void setRot(int i);

    void unsetExt();

    void unsetFlipH();

    void unsetFlipV();

    void unsetOff();

    void unsetRot();

    XmlBoolean xgetFlipH();

    XmlBoolean xgetFlipV();

    STAngle xgetRot();

    void xsetFlipH(XmlBoolean xmlBoolean);

    void xsetFlipV(XmlBoolean xmlBoolean);

    void xsetRot(STAngle sTAngle);
}
