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
public interface SimpleExplicitGroup extends ExplicitGroup {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.SimpleExplicitGroup$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExplicitGroup;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExplicitGroup == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleExplicitGroup");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExplicitGroup = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExplicitGroup;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpleexplicitgroup428ctype");
    }

    public static final class Factory {
        public static SimpleExplicitGroup newInstance() {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().newInstance(SimpleExplicitGroup.type, null);
        }

        public static SimpleExplicitGroup newInstance(XmlOptions xmlOptions) {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().newInstance(SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(String str) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(str, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(str, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(File file) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(file, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(file, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(URL url) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(url, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(url, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(Reader reader) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(reader, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(reader, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(Node node) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(node, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(node, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleExplicitGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleExplicitGroup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleExplicitGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
