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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface LocalElement extends Element {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.LocalElement$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$LocalElement;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalElement == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.LocalElement");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalElement = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalElement;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localelement2ce2type");
    }

    public static final class Factory {
        public static LocalElement newInstance() {
            return (LocalElement) XmlBeans.getContextTypeLoader().newInstance(LocalElement.type, null);
        }

        public static LocalElement newInstance(XmlOptions xmlOptions) {
            return (LocalElement) XmlBeans.getContextTypeLoader().newInstance(LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(String str) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(str, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(str, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(File file) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(file, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(file, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(URL url) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(url, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(url, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(InputStream inputStream) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(inputStream, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(inputStream, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(Reader reader) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(reader, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(reader, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(Node node) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(node, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(node, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalElement.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalElement.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
