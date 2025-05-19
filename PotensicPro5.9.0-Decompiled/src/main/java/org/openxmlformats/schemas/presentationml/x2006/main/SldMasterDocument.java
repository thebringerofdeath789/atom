package org.openxmlformats.schemas.presentationml.x2006.main;

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

/* loaded from: classes6.dex */
public interface SldMasterDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SldMasterDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sldmaster5156doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldMasterDocument newInstance() {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().newInstance(SldMasterDocument.type, null);
        }

        public static SldMasterDocument newInstance(XmlOptions xmlOptions) {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().newInstance(SldMasterDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SldMasterDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(File file) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(file, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(file, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(Reader reader) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(reader, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(reader, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(String str) throws XmlException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(str, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(str, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(URL url) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(url, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(url, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(Node node) throws XmlException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(node, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SldMasterDocument) XmlBeans.getContextTypeLoader().parse(node, SldMasterDocument.type, xmlOptions);
        }
    }

    CTSlideMaster addNewSldMaster();

    CTSlideMaster getSldMaster();

    void setSldMaster(CTSlideMaster cTSlideMaster);
}
