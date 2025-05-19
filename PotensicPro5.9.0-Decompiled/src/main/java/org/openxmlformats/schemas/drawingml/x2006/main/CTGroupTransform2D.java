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
public interface CTGroupTransform2D extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGroupTransform2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgrouptransform2d411atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupTransform2D newInstance() {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().newInstance(CTGroupTransform2D.type, null);
        }

        public static CTGroupTransform2D newInstance(XmlOptions xmlOptions) {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().newInstance(CTGroupTransform2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupTransform2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(File file) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(file, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(file, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(Reader reader) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(reader, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(reader, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(String str) throws XmlException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(str, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(str, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(URL url) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(url, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(url, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(Node node) throws XmlException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(node, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupTransform2D) XmlBeans.getContextTypeLoader().parse(node, CTGroupTransform2D.type, xmlOptions);
        }
    }

    CTPositiveSize2D addNewChExt();

    CTPoint2D addNewChOff();

    CTPositiveSize2D addNewExt();

    CTPoint2D addNewOff();

    CTPositiveSize2D getChExt();

    CTPoint2D getChOff();

    CTPositiveSize2D getExt();

    boolean getFlipH();

    boolean getFlipV();

    CTPoint2D getOff();

    int getRot();

    boolean isSetChExt();

    boolean isSetChOff();

    boolean isSetExt();

    boolean isSetFlipH();

    boolean isSetFlipV();

    boolean isSetOff();

    boolean isSetRot();

    void setChExt(CTPositiveSize2D cTPositiveSize2D);

    void setChOff(CTPoint2D cTPoint2D);

    void setExt(CTPositiveSize2D cTPositiveSize2D);

    void setFlipH(boolean z);

    void setFlipV(boolean z);

    void setOff(CTPoint2D cTPoint2D);

    void setRot(int i);

    void unsetChExt();

    void unsetChOff();

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
