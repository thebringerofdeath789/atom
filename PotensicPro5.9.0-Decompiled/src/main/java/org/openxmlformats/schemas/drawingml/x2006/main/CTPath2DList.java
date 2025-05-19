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
public interface CTPath2DList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPath2DList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpath2dlistb010type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DList newInstance() {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().newInstance(CTPath2DList.type, null);
        }

        public static CTPath2DList newInstance(XmlOptions xmlOptions) {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().newInstance(CTPath2DList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(File file) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(file, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(file, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(String str) throws XmlException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(str, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(str, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(URL url) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(url, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(url, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(Node node) throws XmlException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(node, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DList) XmlBeans.getContextTypeLoader().parse(node, CTPath2DList.type, xmlOptions);
        }
    }

    CTPath2D addNewPath();

    CTPath2D getPathArray(int i);

    CTPath2D[] getPathArray();

    List<CTPath2D> getPathList();

    CTPath2D insertNewPath(int i);

    void removePath(int i);

    void setPathArray(int i, CTPath2D cTPath2D);

    void setPathArray(CTPath2D[] cTPath2DArr);

    int sizeOfPathArray();
}
