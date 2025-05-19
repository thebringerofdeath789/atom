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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Public extends XmlToken {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.Public$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$Public;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Public == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.Public");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Public = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Public;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("publicf3catype");
    }

    public static final class Factory {
        public static Public newValue(Object obj) {
            return (Public) Public.type.newValue(obj);
        }

        public static Public newInstance() {
            return (Public) XmlBeans.getContextTypeLoader().newInstance(Public.type, null);
        }

        public static Public newInstance(XmlOptions xmlOptions) {
            return (Public) XmlBeans.getContextTypeLoader().newInstance(Public.type, xmlOptions);
        }

        public static Public parse(String str) throws XmlException {
            return (Public) XmlBeans.getContextTypeLoader().parse(str, Public.type, (XmlOptions) null);
        }

        public static Public parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Public) XmlBeans.getContextTypeLoader().parse(str, Public.type, xmlOptions);
        }

        public static Public parse(File file) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(file, Public.type, (XmlOptions) null);
        }

        public static Public parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(file, Public.type, xmlOptions);
        }

        public static Public parse(URL url) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(url, Public.type, (XmlOptions) null);
        }

        public static Public parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(url, Public.type, xmlOptions);
        }

        public static Public parse(InputStream inputStream) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(inputStream, Public.type, (XmlOptions) null);
        }

        public static Public parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(inputStream, Public.type, xmlOptions);
        }

        public static Public parse(Reader reader) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(reader, Public.type, (XmlOptions) null);
        }

        public static Public parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Public) XmlBeans.getContextTypeLoader().parse(reader, Public.type, xmlOptions);
        }

        public static Public parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Public) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Public.type, (XmlOptions) null);
        }

        public static Public parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Public) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Public.type, xmlOptions);
        }

        public static Public parse(Node node) throws XmlException {
            return (Public) XmlBeans.getContextTypeLoader().parse(node, Public.type, (XmlOptions) null);
        }

        public static Public parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Public) XmlBeans.getContextTypeLoader().parse(node, Public.type, xmlOptions);
        }

        public static Public parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Public) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Public.type, (XmlOptions) null);
        }

        public static Public parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Public) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Public.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Public.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Public.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
