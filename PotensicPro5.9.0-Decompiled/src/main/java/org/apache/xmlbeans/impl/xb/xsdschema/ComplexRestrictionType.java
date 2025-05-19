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
public interface ComplexRestrictionType extends RestrictionType {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexRestrictionType;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexRestrictionType == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexRestrictionType = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexRestrictionType;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complexrestrictiontype1b7dtype");
    }

    public static final class Factory {
        public static ComplexRestrictionType newInstance() {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().newInstance(ComplexRestrictionType.type, null);
        }

        public static ComplexRestrictionType newInstance(XmlOptions xmlOptions) {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().newInstance(ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(String str) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(str, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(str, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(File file) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(file, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(file, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(URL url) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(url, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(url, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(InputStream inputStream) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(Reader reader) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(Node node) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(node, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(node, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexRestrictionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexRestrictionType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexRestrictionType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
