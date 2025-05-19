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
public interface ExplicitGroup extends Group {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ExplicitGroup;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ExplicitGroup == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ExplicitGroup = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ExplicitGroup;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("explicitgroup4efatype");
    }

    public static final class Factory {
        public static ExplicitGroup newInstance() {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().newInstance(ExplicitGroup.type, null);
        }

        public static ExplicitGroup newInstance(XmlOptions xmlOptions) {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().newInstance(ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(String str) throws XmlException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(str, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(str, ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(File file) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(file, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(file, ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(URL url) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(url, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(url, ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(inputStream, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(inputStream, ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(Reader reader) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(reader, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(reader, ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(Node node) throws XmlException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(node, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(node, ExplicitGroup.type, xmlOptions);
        }

        public static ExplicitGroup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ExplicitGroup.type, (XmlOptions) null);
        }

        public static ExplicitGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ExplicitGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ExplicitGroup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ExplicitGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
