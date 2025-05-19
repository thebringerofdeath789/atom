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
public interface KeyDocument extends XmlObject {
    public static final SchemaType type;

    Keybase addNewKey();

    Keybase getKey();

    void setKey(Keybase keybase);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$KeyDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("key5d16doctype");
    }

    public static final class Factory {
        public static KeyDocument newInstance() {
            return (KeyDocument) XmlBeans.getContextTypeLoader().newInstance(KeyDocument.type, null);
        }

        public static KeyDocument newInstance(XmlOptions xmlOptions) {
            return (KeyDocument) XmlBeans.getContextTypeLoader().newInstance(KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(String str) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(str, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(str, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(File file) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(file, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(file, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(URL url) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(url, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(url, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(Reader reader) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(Node node) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(node, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(node, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
