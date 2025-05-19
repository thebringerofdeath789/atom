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
public interface SimpleContentDocument extends XmlObject {
    public static final SchemaType type;

    SimpleContent addNewSimpleContent();

    SimpleContent getSimpleContent();

    void setSimpleContent(SimpleContent simpleContent);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument$SimpleContent;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplecontent8acedoctype");
    }

    public interface SimpleContent extends Annotated {
        public static final SchemaType type;

        SimpleExtensionType addNewExtension();

        SimpleRestrictionType addNewRestriction();

        SimpleExtensionType getExtension();

        SimpleRestrictionType getRestriction();

        boolean isSetExtension();

        boolean isSetRestriction();

        void setExtension(SimpleExtensionType simpleExtensionType);

        void setRestriction(SimpleRestrictionType simpleRestrictionType);

        void unsetExtension();

        void unsetRestriction();

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument$SimpleContent == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument$SimpleContent");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument$SimpleContent = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleContentDocument$SimpleContent;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplecontent9a5belemtype");
        }

        public static final class Factory {
            public static SimpleContent newInstance() {
                return (SimpleContent) XmlBeans.getContextTypeLoader().newInstance(SimpleContent.type, null);
            }

            public static SimpleContent newInstance(XmlOptions xmlOptions) {
                return (SimpleContent) XmlBeans.getContextTypeLoader().newInstance(SimpleContent.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static SimpleContentDocument newInstance() {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.type, null);
        }

        public static SimpleContentDocument newInstance(XmlOptions xmlOptions) {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(String str) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(str, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(str, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(File file) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(file, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(file, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(URL url) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(url, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(url, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(Reader reader) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(reader, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(reader, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(Node node) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(node, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(node, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleContentDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleContentDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleContentDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
