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
public interface OpenAttrs extends XmlObject {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.OpenAttrs$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$OpenAttrs;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$OpenAttrs == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.OpenAttrs");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$OpenAttrs = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$OpenAttrs;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("openattrs2d4dtype");
    }

    public static final class Factory {
        public static OpenAttrs newInstance() {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().newInstance(OpenAttrs.type, null);
        }

        public static OpenAttrs newInstance(XmlOptions xmlOptions) {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().newInstance(OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(String str) throws XmlException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(str, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(str, OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(File file) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(file, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(file, OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(URL url) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(url, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(url, OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(InputStream inputStream) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(inputStream, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(inputStream, OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(Reader reader) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(reader, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(reader, OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(Node node) throws XmlException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(node, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(node, OpenAttrs.type, xmlOptions);
        }

        public static OpenAttrs parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OpenAttrs.type, (XmlOptions) null);
        }

        public static OpenAttrs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (OpenAttrs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OpenAttrs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OpenAttrs.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OpenAttrs.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
