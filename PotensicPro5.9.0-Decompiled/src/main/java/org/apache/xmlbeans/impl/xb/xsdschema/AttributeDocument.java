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
public interface AttributeDocument extends XmlObject {
    public static final SchemaType type;

    TopLevelAttribute addNewAttribute();

    TopLevelAttribute getAttribute();

    void setAttribute(TopLevelAttribute topLevelAttribute);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributeedb9doctype");
    }

    public static final class Factory {
        public static AttributeDocument newInstance() {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeDocument.type, null);
        }

        public static AttributeDocument newInstance(XmlOptions xmlOptions) {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(String str) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(File file) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(URL url) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(Reader reader) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(Node node) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
