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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface SelectorDocument extends XmlObject {
    public static final SchemaType type;

    Selector addNewSelector();

    Selector getSelector();

    void setSelector(Selector selector);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector$Xpath;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("selectorcb44doctype");
    }

    public interface Selector extends Annotated {
        public static final SchemaType type;

        String getXpath();

        void setXpath(String str);

        Xpath xgetXpath();

        void xsetXpath(Xpath xpath);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument$Selector");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("selector233felemtype");
        }

        public interface Xpath extends XmlToken {
            public static final SchemaType type;

            static {
                Class cls;
                if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector$Xpath == null) {
                    cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument$Selector$Xpath");
                    AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector$Xpath = cls;
                } else {
                    cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SelectorDocument$Selector$Xpath;
                }
                type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("xpath6f9aattrtype");
            }

            public static final class Factory {
                public static Xpath newValue(Object obj) {
                    return (Xpath) Xpath.type.newValue(obj);
                }

                public static Xpath newInstance() {
                    return (Xpath) XmlBeans.getContextTypeLoader().newInstance(Xpath.type, null);
                }

                public static Xpath newInstance(XmlOptions xmlOptions) {
                    return (Xpath) XmlBeans.getContextTypeLoader().newInstance(Xpath.type, xmlOptions);
                }

                private Factory() {
                }
            }
        }

        public static final class Factory {
            public static Selector newInstance() {
                return (Selector) XmlBeans.getContextTypeLoader().newInstance(Selector.type, null);
            }

            public static Selector newInstance(XmlOptions xmlOptions) {
                return (Selector) XmlBeans.getContextTypeLoader().newInstance(Selector.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static SelectorDocument newInstance() {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.type, null);
        }

        public static SelectorDocument newInstance(XmlOptions xmlOptions) {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().newInstance(SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(String str) throws XmlException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(str, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(str, SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(File file) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(file, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(file, SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(URL url) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(url, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(url, SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(Reader reader) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(reader, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(reader, SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(Node node) throws XmlException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(node, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(node, SelectorDocument.type, xmlOptions);
        }

        public static SelectorDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SelectorDocument.type, (XmlOptions) null);
        }

        public static SelectorDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SelectorDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SelectorDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SelectorDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SelectorDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
