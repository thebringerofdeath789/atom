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
public interface CTPictureLocking extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPictureLocking.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpicturelockinga414type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureLocking newInstance() {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().newInstance(CTPictureLocking.type, null);
        }

        public static CTPictureLocking newInstance(XmlOptions xmlOptions) {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().newInstance(CTPictureLocking.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPictureLocking.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(File file) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(file, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(file, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(inputStream, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(inputStream, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(Reader reader) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(reader, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(reader, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(String str) throws XmlException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(str, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(str, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(URL url) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(url, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(url, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPictureLocking.type, xmlOptions);
        }

        public static CTPictureLocking parse(Node node) throws XmlException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(node, CTPictureLocking.type, (XmlOptions) null);
        }

        public static CTPictureLocking parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureLocking) XmlBeans.getContextTypeLoader().parse(node, CTPictureLocking.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getNoAdjustHandles();

    boolean getNoChangeArrowheads();

    boolean getNoChangeAspect();

    boolean getNoChangeShapeType();

    boolean getNoCrop();

    boolean getNoEditPoints();

    boolean getNoGrp();

    boolean getNoMove();

    boolean getNoResize();

    boolean getNoRot();

    boolean getNoSelect();

    boolean isSetExtLst();

    boolean isSetNoAdjustHandles();

    boolean isSetNoChangeArrowheads();

    boolean isSetNoChangeAspect();

    boolean isSetNoChangeShapeType();

    boolean isSetNoCrop();

    boolean isSetNoEditPoints();

    boolean isSetNoGrp();

    boolean isSetNoMove();

    boolean isSetNoResize();

    boolean isSetNoRot();

    boolean isSetNoSelect();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setNoAdjustHandles(boolean z);

    void setNoChangeArrowheads(boolean z);

    void setNoChangeAspect(boolean z);

    void setNoChangeShapeType(boolean z);

    void setNoCrop(boolean z);

    void setNoEditPoints(boolean z);

    void setNoGrp(boolean z);

    void setNoMove(boolean z);

    void setNoResize(boolean z);

    void setNoRot(boolean z);

    void setNoSelect(boolean z);

    void unsetExtLst();

    void unsetNoAdjustHandles();

    void unsetNoChangeArrowheads();

    void unsetNoChangeAspect();

    void unsetNoChangeShapeType();

    void unsetNoCrop();

    void unsetNoEditPoints();

    void unsetNoGrp();

    void unsetNoMove();

    void unsetNoResize();

    void unsetNoRot();

    void unsetNoSelect();

    XmlBoolean xgetNoAdjustHandles();

    XmlBoolean xgetNoChangeArrowheads();

    XmlBoolean xgetNoChangeAspect();

    XmlBoolean xgetNoChangeShapeType();

    XmlBoolean xgetNoCrop();

    XmlBoolean xgetNoEditPoints();

    XmlBoolean xgetNoGrp();

    XmlBoolean xgetNoMove();

    XmlBoolean xgetNoResize();

    XmlBoolean xgetNoRot();

    XmlBoolean xgetNoSelect();

    void xsetNoAdjustHandles(XmlBoolean xmlBoolean);

    void xsetNoChangeArrowheads(XmlBoolean xmlBoolean);

    void xsetNoChangeAspect(XmlBoolean xmlBoolean);

    void xsetNoChangeShapeType(XmlBoolean xmlBoolean);

    void xsetNoCrop(XmlBoolean xmlBoolean);

    void xsetNoEditPoints(XmlBoolean xmlBoolean);

    void xsetNoGrp(XmlBoolean xmlBoolean);

    void xsetNoMove(XmlBoolean xmlBoolean);

    void xsetNoResize(XmlBoolean xmlBoolean);

    void xsetNoRot(XmlBoolean xmlBoolean);

    void xsetNoSelect(XmlBoolean xmlBoolean);
}
