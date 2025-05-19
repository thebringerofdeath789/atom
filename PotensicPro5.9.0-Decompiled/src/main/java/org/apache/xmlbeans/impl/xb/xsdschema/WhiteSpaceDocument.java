package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface WhiteSpaceDocument extends XmlObject {
    public static final SchemaType type;

    WhiteSpace addNewWhiteSpace();

    WhiteSpace getWhiteSpace();

    void setWhiteSpace(WhiteSpace whiteSpace);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace$Value;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("whitespaced2c6doctype");
    }

    public interface WhiteSpace extends Facet {
        public static final SchemaType type;

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument$WhiteSpace");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("whitespace97ffelemtype");
        }

        public interface Value extends XmlNMTOKEN {
            public static final Enum COLLAPSE;
            public static final int INT_COLLAPSE = 3;
            public static final int INT_PRESERVE = 1;
            public static final int INT_REPLACE = 2;
            public static final Enum PRESERVE;
            public static final Enum REPLACE;
            public static final SchemaType type;

            StringEnumAbstractBase enumValue();

            void set(StringEnumAbstractBase stringEnumAbstractBase);

            static {
                Class cls;
                if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace$Value == null) {
                    cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument$WhiteSpace$Value");
                    AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace$Value = cls;
                } else {
                    cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$WhiteSpaceDocument$WhiteSpace$Value;
                }
                type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("value8186attrtype");
                PRESERVE = Enum.forString("preserve");
                REPLACE = Enum.forString("replace");
                COLLAPSE = Enum.forString("collapse");
            }

            public static final class Enum extends StringEnumAbstractBase {
                static final int INT_COLLAPSE = 3;
                static final int INT_PRESERVE = 1;
                static final int INT_REPLACE = 2;
                private static final long serialVersionUID = 1;
                public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("preserve", 1), new Enum("replace", 2), new Enum("collapse", 3)});

                public static Enum forString(String str) {
                    return (Enum) table.forString(str);
                }

                public static Enum forInt(int i) {
                    return (Enum) table.forInt(i);
                }

                private Enum(String str, int i) {
                    super(str, i);
                }

                private Object readResolve() {
                    return forInt(intValue());
                }
            }

            public static final class Factory {
                public static Value newValue(Object obj) {
                    return (Value) Value.type.newValue(obj);
                }

                public static Value newInstance() {
                    return (Value) XmlBeans.getContextTypeLoader().newInstance(Value.type, null);
                }

                public static Value newInstance(XmlOptions xmlOptions) {
                    return (Value) XmlBeans.getContextTypeLoader().newInstance(Value.type, xmlOptions);
                }

                private Factory() {
                }
            }
        }

        public static final class Factory {
            public static WhiteSpace newInstance() {
                return (WhiteSpace) XmlBeans.getContextTypeLoader().newInstance(WhiteSpace.type, null);
            }

            public static WhiteSpace newInstance(XmlOptions xmlOptions) {
                return (WhiteSpace) XmlBeans.getContextTypeLoader().newInstance(WhiteSpace.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static WhiteSpaceDocument newInstance() {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.type, null);
        }

        public static WhiteSpaceDocument newInstance(XmlOptions xmlOptions) {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().newInstance(WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(String str) throws XmlException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(str, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(str, WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(File file) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(file, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(file, WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(URL url) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(url, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(url, WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(Reader reader) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(reader, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(reader, WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(Node node) throws XmlException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(node, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(node, WhiteSpaceDocument.type, xmlOptions);
        }

        public static WhiteSpaceDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, WhiteSpaceDocument.type, (XmlOptions) null);
        }

        public static WhiteSpaceDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (WhiteSpaceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, WhiteSpaceDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, WhiteSpaceDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, WhiteSpaceDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
