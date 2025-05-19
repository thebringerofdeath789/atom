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
public interface CTScaling extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTScaling.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctscaling1dfftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTScaling newInstance() {
            return (CTScaling) XmlBeans.getContextTypeLoader().newInstance(CTScaling.type, null);
        }

        public static CTScaling newInstance(XmlOptions xmlOptions) {
            return (CTScaling) XmlBeans.getContextTypeLoader().newInstance(CTScaling.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScaling.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(File file) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(file, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(file, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(InputStream inputStream) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(inputStream, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(inputStream, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(Reader reader) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(reader, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(reader, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(String str) throws XmlException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(str, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(str, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(URL url) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(url, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(url, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScaling.type, xmlOptions);
        }

        public static CTScaling parse(Node node) throws XmlException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(node, CTScaling.type, (XmlOptions) null);
        }

        public static CTScaling parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTScaling) XmlBeans.getContextTypeLoader().parse(node, CTScaling.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTLogBase addNewLogBase();

    CTDouble addNewMax();

    CTDouble addNewMin();

    CTOrientation addNewOrientation();

    CTExtensionList getExtLst();

    CTLogBase getLogBase();

    CTDouble getMax();

    CTDouble getMin();

    CTOrientation getOrientation();

    boolean isSetExtLst();

    boolean isSetLogBase();

    boolean isSetMax();

    boolean isSetMin();

    boolean isSetOrientation();

    void setExtLst(CTExtensionList cTExtensionList);

    void setLogBase(CTLogBase cTLogBase);

    void setMax(CTDouble cTDouble);

    void setMin(CTDouble cTDouble);

    void setOrientation(CTOrientation cTOrientation);

    void unsetExtLst();

    void unsetLogBase();

    void unsetMax();

    void unsetMin();

    void unsetOrientation();
}
