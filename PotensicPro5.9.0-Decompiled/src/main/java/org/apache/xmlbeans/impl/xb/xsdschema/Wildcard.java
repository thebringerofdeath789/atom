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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Wildcard extends Annotated {
    public static final SchemaType type;

    Object getNamespace();

    ProcessContents.Enum getProcessContents();

    boolean isSetNamespace();

    boolean isSetProcessContents();

    void setNamespace(Object obj);

    void setProcessContents(ProcessContents.Enum r1);

    void unsetNamespace();

    void unsetProcessContents();

    NamespaceList xgetNamespace();

    ProcessContents xgetProcessContents();

    void xsetNamespace(NamespaceList namespaceList);

    void xsetProcessContents(ProcessContents processContents);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.Wildcard$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard$ProcessContents;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.Wildcard");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("wildcarde0b9type");
    }

    public interface ProcessContents extends XmlNMTOKEN {
        public static final int INT_LAX = 2;
        public static final int INT_SKIP = 1;
        public static final int INT_STRICT = 3;
        public static final Enum LAX;
        public static final Enum SKIP;
        public static final Enum STRICT;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard$ProcessContents == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.Wildcard$ProcessContents");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard$ProcessContents = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard$ProcessContents;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("processcontents864aattrtype");
            SKIP = Enum.forString("skip");
            LAX = Enum.forString("lax");
            STRICT = Enum.forString("strict");
        }

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_LAX = 2;
            static final int INT_SKIP = 1;
            static final int INT_STRICT = 3;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("skip", 1), new Enum("lax", 2), new Enum("strict", 3)});

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
            public static ProcessContents newValue(Object obj) {
                return (ProcessContents) ProcessContents.type.newValue(obj);
            }

            public static ProcessContents newInstance() {
                return (ProcessContents) XmlBeans.getContextTypeLoader().newInstance(ProcessContents.type, null);
            }

            public static ProcessContents newInstance(XmlOptions xmlOptions) {
                return (ProcessContents) XmlBeans.getContextTypeLoader().newInstance(ProcessContents.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static Wildcard newInstance() {
            return (Wildcard) XmlBeans.getContextTypeLoader().newInstance(Wildcard.type, null);
        }

        public static Wildcard newInstance(XmlOptions xmlOptions) {
            return (Wildcard) XmlBeans.getContextTypeLoader().newInstance(Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(String str) throws XmlException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(str, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(str, Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(File file) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(file, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(file, Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(URL url) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(url, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(url, Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(InputStream inputStream) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(inputStream, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(inputStream, Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(Reader reader) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(reader, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(reader, Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(Node node) throws XmlException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(node, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(node, Wildcard.type, xmlOptions);
        }

        public static Wildcard parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Wildcard.type, (XmlOptions) null);
        }

        public static Wildcard parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Wildcard) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Wildcard.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Wildcard.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Wildcard.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
