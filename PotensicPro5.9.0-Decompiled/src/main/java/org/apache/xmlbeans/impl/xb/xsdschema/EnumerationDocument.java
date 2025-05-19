package org.apache.xmlbeans.impl.xb.xsdschema;

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
public interface EnumerationDocument extends XmlObject {
    public static final SchemaType type;

    NoFixedFacet addNewEnumeration();

    NoFixedFacet getEnumeration();

    void setEnumeration(NoFixedFacet noFixedFacet);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$EnumerationDocument;

        static /* synthetic */ Class class$(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError().initCause(e);
            }
        }
    }

    static {
        Class cls;
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$EnumerationDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$EnumerationDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$EnumerationDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("enumeration052edoctype");
    }

    public static final class Factory {
        public static EnumerationDocument newInstance() {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().newInstance(EnumerationDocument.type, null);
        }

        public static EnumerationDocument newInstance(XmlOptions xmlOptions) {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().newInstance(EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(String str) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(str, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(str, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(File file) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(file, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(file, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(URL url) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(url, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(url, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(Reader reader) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(reader, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(reader, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(Node node) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(node, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(node, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EnumerationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EnumerationDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EnumerationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
