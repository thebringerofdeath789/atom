package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTManualLayout extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTManualLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmanuallayout872ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTManualLayout newInstance() {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().newInstance(CTManualLayout.type, null);
        }

        public static CTManualLayout newInstance(XmlOptions xmlOptions) {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().newInstance(CTManualLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTManualLayout.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(File file) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(file, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(file, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(InputStream inputStream) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(Reader reader) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(reader, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(reader, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(String str) throws XmlException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(str, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(str, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(URL url) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(url, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(url, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(Node node) throws XmlException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(node, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTManualLayout) XmlBeans.getContextTypeLoader().parse(node, CTManualLayout.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTDouble addNewH();

    CTLayoutMode addNewHMode();

    CTLayoutTarget addNewLayoutTarget();

    CTDouble addNewW();

    CTLayoutMode addNewWMode();

    CTDouble addNewX();

    CTLayoutMode addNewXMode();

    CTDouble addNewY();

    CTLayoutMode addNewYMode();

    CTExtensionList getExtLst();

    CTDouble getH();

    CTLayoutMode getHMode();

    CTLayoutTarget getLayoutTarget();

    CTDouble getW();

    CTLayoutMode getWMode();

    CTDouble getX();

    CTLayoutMode getXMode();

    CTDouble getY();

    CTLayoutMode getYMode();

    boolean isSetExtLst();

    boolean isSetH();

    boolean isSetHMode();

    boolean isSetLayoutTarget();

    boolean isSetW();

    boolean isSetWMode();

    boolean isSetX();

    boolean isSetXMode();

    boolean isSetY();

    boolean isSetYMode();

    void setExtLst(CTExtensionList cTExtensionList);

    void setH(CTDouble cTDouble);

    void setHMode(CTLayoutMode cTLayoutMode);

    void setLayoutTarget(CTLayoutTarget cTLayoutTarget);

    void setW(CTDouble cTDouble);

    void setWMode(CTLayoutMode cTLayoutMode);

    void setX(CTDouble cTDouble);

    void setXMode(CTLayoutMode cTLayoutMode);

    void setY(CTDouble cTDouble);

    void setYMode(CTLayoutMode cTLayoutMode);

    void unsetExtLst();

    void unsetH();

    void unsetHMode();

    void unsetLayoutTarget();

    void unsetW();

    void unsetWMode();

    void unsetX();

    void unsetXMode();

    void unsetY();

    void unsetYMode();
}
