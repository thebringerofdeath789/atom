package org.openxmlformats.schemas.xpackage.x2006.relationships;

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

/* loaded from: classes6.dex */
public interface CTRelationships extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRelationships.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctrelationshipse33ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRelationships newInstance() {
            return (CTRelationships) XmlBeans.getContextTypeLoader().newInstance(CTRelationships.type, null);
        }

        public static CTRelationships newInstance(XmlOptions xmlOptions) {
            return (CTRelationships) XmlBeans.getContextTypeLoader().newInstance(CTRelationships.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelationships.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(File file) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(file, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(file, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(Reader reader) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(reader, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(reader, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(String str) throws XmlException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(str, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(str, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(URL url) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(url, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(url, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelationships.type, xmlOptions);
        }

        public static CTRelationships parse(Node node) throws XmlException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(node, CTRelationships.type, (XmlOptions) null);
        }

        public static CTRelationships parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationships) XmlBeans.getContextTypeLoader().parse(node, CTRelationships.type, xmlOptions);
        }
    }

    CTRelationship addNewRelationship();

    CTRelationship getRelationshipArray(int i);

    CTRelationship[] getRelationshipArray();

    List<CTRelationship> getRelationshipList();

    CTRelationship insertNewRelationship(int i);

    void removeRelationship(int i);

    void setRelationshipArray(int i, CTRelationship cTRelationship);

    void setRelationshipArray(CTRelationship[] cTRelationshipArr);

    int sizeOfRelationshipArray();
}
