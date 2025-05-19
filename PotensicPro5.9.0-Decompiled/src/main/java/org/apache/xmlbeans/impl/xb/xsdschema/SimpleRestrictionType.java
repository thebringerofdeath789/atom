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
public interface SimpleRestrictionType extends RestrictionType {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleRestrictionType;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleRestrictionType == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleRestrictionType = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleRestrictionType;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplerestrictiontypeeab1type");
    }

    public static final class Factory {
        public static SimpleRestrictionType newInstance() {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().newInstance(SimpleRestrictionType.type, null);
        }

        public static SimpleRestrictionType newInstance(XmlOptions xmlOptions) {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().newInstance(SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(String str) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(str, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(str, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(File file) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(file, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(file, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(URL url) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(url, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(url, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(Reader reader) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(Node node) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(node, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(node, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleRestrictionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleRestrictionType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleRestrictionType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
