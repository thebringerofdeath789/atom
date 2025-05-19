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
public interface CTAdjustHandleList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTAdjustHandleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctadjusthandlelistfdb0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAdjustHandleList newInstance() {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().newInstance(CTAdjustHandleList.type, null);
        }

        public static CTAdjustHandleList newInstance(XmlOptions xmlOptions) {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().newInstance(CTAdjustHandleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAdjustHandleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(File file) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(file, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(file, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(Reader reader) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(reader, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(reader, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(String str) throws XmlException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(str, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(str, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(URL url) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(url, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(url, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(Node node) throws XmlException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(node, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjustHandleList) XmlBeans.getContextTypeLoader().parse(node, CTAdjustHandleList.type, xmlOptions);
        }
    }

    CTPolarAdjustHandle addNewAhPolar();

    CTXYAdjustHandle addNewAhXY();

    CTPolarAdjustHandle getAhPolarArray(int i);

    CTPolarAdjustHandle[] getAhPolarArray();

    List<CTPolarAdjustHandle> getAhPolarList();

    CTXYAdjustHandle getAhXYArray(int i);

    CTXYAdjustHandle[] getAhXYArray();

    List<CTXYAdjustHandle> getAhXYList();

    CTPolarAdjustHandle insertNewAhPolar(int i);

    CTXYAdjustHandle insertNewAhXY(int i);

    void removeAhPolar(int i);

    void removeAhXY(int i);

    void setAhPolarArray(int i, CTPolarAdjustHandle cTPolarAdjustHandle);

    void setAhPolarArray(CTPolarAdjustHandle[] cTPolarAdjustHandleArr);

    void setAhXYArray(int i, CTXYAdjustHandle cTXYAdjustHandle);

    void setAhXYArray(CTXYAdjustHandle[] cTXYAdjustHandleArr);

    int sizeOfAhPolarArray();

    int sizeOfAhXYArray();
}
