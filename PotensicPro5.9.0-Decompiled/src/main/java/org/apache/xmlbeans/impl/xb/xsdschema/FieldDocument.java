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
public interface FieldDocument extends XmlObject {
    public static final SchemaType type;

    Field addNewField();

    Field getField();

    void setField(Field field);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field$Xpath;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("field3f9bdoctype");
    }

    public interface Field extends Annotated {
        public static final SchemaType type;

        String getXpath();

        void setXpath(String str);

        Xpath xgetXpath();

        void xsetXpath(Xpath xpath);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument$Field");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("field12f5elemtype");
        }

        public interface Xpath extends XmlToken {
            public static final SchemaType type;

            static {
                Class cls;
                if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field$Xpath == null) {
                    cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument$Field$Xpath");
                    AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field$Xpath = cls;
                } else {
                    cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field$Xpath;
                }
                type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("xpath7f90attrtype");
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
            public static Field newInstance() {
                return (Field) XmlBeans.getContextTypeLoader().newInstance(Field.type, null);
            }

            public static Field newInstance(XmlOptions xmlOptions) {
                return (Field) XmlBeans.getContextTypeLoader().newInstance(Field.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static FieldDocument newInstance() {
            return (FieldDocument) XmlBeans.getContextTypeLoader().newInstance(FieldDocument.type, null);
        }

        public static FieldDocument newInstance(XmlOptions xmlOptions) {
            return (FieldDocument) XmlBeans.getContextTypeLoader().newInstance(FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(String str) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(str, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(str, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(File file) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(file, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(file, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(URL url) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(url, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(url, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(Reader reader) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(reader, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(reader, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(Node node) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(node, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(node, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FieldDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FieldDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FieldDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
