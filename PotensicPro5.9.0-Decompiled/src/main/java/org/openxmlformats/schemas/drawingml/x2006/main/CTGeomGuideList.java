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
public interface CTGeomGuideList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGeomGuideList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgeomguidelist364ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomGuideList newInstance() {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().newInstance(CTGeomGuideList.type, null);
        }

        public static CTGeomGuideList newInstance(XmlOptions xmlOptions) {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().newInstance(CTGeomGuideList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGeomGuideList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(File file) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(file, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(file, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(inputStream, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(inputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(Reader reader) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(reader, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(reader, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(String str) throws XmlException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(str, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(str, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(URL url) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(url, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(url, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(Node node) throws XmlException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(node, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuideList) XmlBeans.getContextTypeLoader().parse(node, CTGeomGuideList.type, xmlOptions);
        }
    }

    CTGeomGuide addNewGd();

    CTGeomGuide getGdArray(int i);

    CTGeomGuide[] getGdArray();

    List<CTGeomGuide> getGdList();

    CTGeomGuide insertNewGd(int i);

    void removeGd(int i);

    void setGdArray(int i, CTGeomGuide cTGeomGuide);

    void setGdArray(CTGeomGuide[] cTGeomGuideArr);

    int sizeOfGdArray();
}
