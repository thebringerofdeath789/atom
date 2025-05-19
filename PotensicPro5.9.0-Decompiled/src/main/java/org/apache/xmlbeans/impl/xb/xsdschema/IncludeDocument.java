package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface IncludeDocument extends XmlObject {
    public static final SchemaType type;

    Include addNewInclude();

    Include getInclude();

    void setInclude(Include include);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument$Include;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("includeaf6ddoctype");
    }

    public interface Include extends Annotated {
        public static final SchemaType type;

        String getSchemaLocation();

        void setSchemaLocation(String str);

        XmlAnyURI xgetSchemaLocation();

        void xsetSchemaLocation(XmlAnyURI xmlAnyURI);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument$Include == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument$Include");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument$Include = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$IncludeDocument$Include;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("include59d9elemtype");
        }

        public static final class Factory {
            public static Include newInstance() {
                return (Include) XmlBeans.getContextTypeLoader().newInstance(Include.type, null);
            }

            public static Include newInstance(XmlOptions xmlOptions) {
                return (Include) XmlBeans.getContextTypeLoader().newInstance(Include.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static IncludeDocument newInstance() {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().newInstance(IncludeDocument.type, null);
        }

        public static IncludeDocument newInstance(XmlOptions xmlOptions) {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().newInstance(IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(String str) throws XmlException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(str, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(str, IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(File file) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(file, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(file, IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(URL url) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(url, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(url, IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(Reader reader) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(reader, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(reader, IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(Node node) throws XmlException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(node, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(node, IncludeDocument.type, xmlOptions);
        }

        public static IncludeDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, IncludeDocument.type, (XmlOptions) null);
        }

        public static IncludeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (IncludeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, IncludeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, IncludeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, IncludeDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
