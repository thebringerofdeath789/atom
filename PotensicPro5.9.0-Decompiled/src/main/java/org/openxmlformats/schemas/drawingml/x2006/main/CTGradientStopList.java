package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTGradientStopList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGradientStopList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgradientstoplist7eabtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGradientStopList newInstance() {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().newInstance(CTGradientStopList.type, null);
        }

        public static CTGradientStopList newInstance(XmlOptions xmlOptions) {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().newInstance(CTGradientStopList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGradientStopList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(File file) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(file, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(file, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(inputStream, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(inputStream, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(Reader reader) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(reader, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(reader, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(String str) throws XmlException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(str, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(str, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(URL url) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(url, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(url, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(Node node) throws XmlException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(node, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStopList) XmlBeans.getContextTypeLoader().parse(node, CTGradientStopList.type, xmlOptions);
        }
    }

    CTGradientStop addNewGs();

    CTGradientStop getGsArray(int i);

    CTGradientStop[] getGsArray();

    List<CTGradientStop> getGsList();

    CTGradientStop insertNewGs(int i);

    void removeGs(int i);

    void setGsArray(int i, CTGradientStop cTGradientStop);

    void setGsArray(CTGradientStop[] cTGradientStopArr);

    int sizeOfGsArray();
}
