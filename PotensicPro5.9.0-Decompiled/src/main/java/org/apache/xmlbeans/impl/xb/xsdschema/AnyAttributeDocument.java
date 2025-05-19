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
public interface AnyAttributeDocument extends XmlObject {
    public static final SchemaType type;

    Wildcard addNewAnyAttribute();

    Wildcard getAnyAttribute();

    void setAnyAttribute(Wildcard wildcard);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AnyAttributeDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyAttributeDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyAttributeDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyAttributeDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anyattribute23b3doctype");
    }

    public static final class Factory {
        public static AnyAttributeDocument newInstance() {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().newInstance(AnyAttributeDocument.type, null);
        }

        public static AnyAttributeDocument newInstance(XmlOptions xmlOptions) {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().newInstance(AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(String str) throws XmlException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(str, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(str, AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(File file) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(file, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(file, AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(URL url) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(url, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(url, AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(Reader reader) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(reader, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(reader, AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(Node node) throws XmlException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(node, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(node, AnyAttributeDocument.type, xmlOptions);
        }

        public static AnyAttributeDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnyAttributeDocument.type, (XmlOptions) null);
        }

        public static AnyAttributeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AnyAttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnyAttributeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnyAttributeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnyAttributeDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
