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
public interface CTOfficeArtExtensionList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTOfficeArtExtensionList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctofficeartextensionlista211type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeArtExtensionList newInstance() {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().newInstance(CTOfficeArtExtensionList.type, null);
        }

        public static CTOfficeArtExtensionList newInstance(XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().newInstance(CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtensionList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(File file) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(file, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(file, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(inputStream, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(inputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(Reader reader) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(reader, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(reader, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(String str) throws XmlException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(str, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(str, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(URL url) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(url, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(url, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(Node node) throws XmlException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(node, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtensionList) XmlBeans.getContextTypeLoader().parse(node, CTOfficeArtExtensionList.type, xmlOptions);
        }
    }

    CTOfficeArtExtension addNewExt();

    CTOfficeArtExtension getExtArray(int i);

    CTOfficeArtExtension[] getExtArray();

    List<CTOfficeArtExtension> getExtList();

    CTOfficeArtExtension insertNewExt(int i);

    void removeExt(int i);

    void setExtArray(int i, CTOfficeArtExtension cTOfficeArtExtension);

    void setExtArray(CTOfficeArtExtension[] cTOfficeArtExtensionArr);

    int sizeOfExtArray();
}
