package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTColorMappingOverride extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTColorMappingOverride.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcolormappingoverridea2b2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColorMappingOverride newInstance() {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().newInstance(CTColorMappingOverride.type, null);
        }

        public static CTColorMappingOverride newInstance(XmlOptions xmlOptions) {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().newInstance(CTColorMappingOverride.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColorMappingOverride.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(File file) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(file, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(file, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(InputStream inputStream) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(inputStream, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(inputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(Reader reader) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(reader, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(reader, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(String str) throws XmlException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(str, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(str, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(URL url) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(url, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(url, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(Node node) throws XmlException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(node, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMappingOverride) XmlBeans.getContextTypeLoader().parse(node, CTColorMappingOverride.type, xmlOptions);
        }
    }

    CTEmptyElement addNewMasterClrMapping();

    CTColorMapping addNewOverrideClrMapping();

    CTEmptyElement getMasterClrMapping();

    CTColorMapping getOverrideClrMapping();

    boolean isSetMasterClrMapping();

    boolean isSetOverrideClrMapping();

    void setMasterClrMapping(CTEmptyElement cTEmptyElement);

    void setOverrideClrMapping(CTColorMapping cTColorMapping);

    void unsetMasterClrMapping();

    void unsetOverrideClrMapping();
}
