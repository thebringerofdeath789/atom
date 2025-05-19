package org.openxmlformats.schemas.drawingml.x2006.chart;

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

/* loaded from: classes2.dex */
public interface CTStrData extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTStrData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctstrdatad58btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTStrData newInstance() {
            return (CTStrData) XmlBeans.getContextTypeLoader().newInstance(CTStrData.type, null);
        }

        public static CTStrData newInstance(XmlOptions xmlOptions) {
            return (CTStrData) XmlBeans.getContextTypeLoader().newInstance(CTStrData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStrData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(File file) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(file, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(file, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(inputStream, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(inputStream, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(Reader reader) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(reader, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(reader, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(String str) throws XmlException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(str, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(str, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(URL url) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(url, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(url, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStrData.type, xmlOptions);
        }

        public static CTStrData parse(Node node) throws XmlException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(node, CTStrData.type, (XmlOptions) null);
        }

        public static CTStrData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStrData) XmlBeans.getContextTypeLoader().parse(node, CTStrData.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTStrVal addNewPt();

    CTUnsignedInt addNewPtCount();

    CTExtensionList getExtLst();

    CTStrVal getPtArray(int i);

    CTStrVal[] getPtArray();

    CTUnsignedInt getPtCount();

    List<CTStrVal> getPtList();

    CTStrVal insertNewPt(int i);

    boolean isSetExtLst();

    boolean isSetPtCount();

    void removePt(int i);

    void setExtLst(CTExtensionList cTExtensionList);

    void setPtArray(int i, CTStrVal cTStrVal);

    void setPtArray(CTStrVal[] cTStrValArr);

    void setPtCount(CTUnsignedInt cTUnsignedInt);

    int sizeOfPtArray();

    void unsetExtLst();

    void unsetPtCount();
}
