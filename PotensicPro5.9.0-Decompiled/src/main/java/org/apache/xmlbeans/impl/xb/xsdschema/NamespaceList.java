package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface NamespaceList extends XmlAnySimpleType {
    public static final SchemaType type;

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item$Member;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("namespacelist10cctype");
    }

    public interface Member extends XmlToken {
        public static final Enum ANY;
        public static final int INT_ANY = 1;
        public static final int INT_OTHER = 2;
        public static final Enum OTHER;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonfac7type");
            ANY = Enum.forString("##any");
            OTHER = Enum.forString("##other");
        }

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ANY = 1;
            static final int INT_OTHER = 2;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("##any", 1), new Enum("##other", 2)});

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
            public static Member newValue(Object obj) {
                return (Member) Member.type.newValue(obj);
            }

            public static Member newInstance() {
                return (Member) XmlBeans.getContextTypeLoader().newInstance(Member.type, null);
            }

            public static Member newInstance(XmlOptions xmlOptions) {
                return (Member) XmlBeans.getContextTypeLoader().newInstance(Member.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public interface Member2 extends XmlAnySimpleType {
        public static final SchemaType type;

        List getListValue();

        List listValue();

        void set(List list);

        void setListValue(List list);

        List xgetListValue();

        List xlistValue();

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2 == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member2");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2 = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anona0e6type");
        }

        public interface Item extends XmlAnySimpleType {
            public static final SchemaType type;

            Object getObjectValue();

            SchemaType instanceType();

            void objectSet(Object obj);

            Object objectValue();

            void setObjectValue(Object obj);

            static {
                Class cls;
                if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item == null) {
                    cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member2$Item");
                    AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item = cls;
                } else {
                    cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item;
                }
                type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon16cetype");
            }

            public interface Member extends XmlToken {
                public static final int INT_LOCAL = 2;
                public static final int INT_TARGET_NAMESPACE = 1;
                public static final Enum LOCAL;
                public static final Enum TARGET_NAMESPACE;
                public static final SchemaType type;

                StringEnumAbstractBase enumValue();

                void set(StringEnumAbstractBase stringEnumAbstractBase);

                static {
                    Class cls;
                    if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item$Member == null) {
                        cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList$Member2$Item$Member");
                        AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item$Member = cls;
                    } else {
                        cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamespaceList$Member2$Item$Member;
                    }
                    type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0c73type");
                    TARGET_NAMESPACE = Enum.forString("##targetNamespace");
                    LOCAL = Enum.forString("##local");
                }

                public static final class Enum extends StringEnumAbstractBase {
                    static final int INT_LOCAL = 2;
                    static final int INT_TARGET_NAMESPACE = 1;
                    private static final long serialVersionUID = 1;
                    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("##targetNamespace", 1), new Enum("##local", 2)});

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
                    public static Member newValue(Object obj) {
                        return (Member) Member.type.newValue(obj);
                    }

                    public static Member newInstance() {
                        return (Member) XmlBeans.getContextTypeLoader().newInstance(Member.type, null);
                    }

                    public static Member newInstance(XmlOptions xmlOptions) {
                        return (Member) XmlBeans.getContextTypeLoader().newInstance(Member.type, xmlOptions);
                    }

                    private Factory() {
                    }
                }
            }

            public static final class Factory {
                public static Item newValue(Object obj) {
                    return (Item) Item.type.newValue(obj);
                }

                public static Item newInstance() {
                    return (Item) XmlBeans.getContextTypeLoader().newInstance(Item.type, null);
                }

                public static Item newInstance(XmlOptions xmlOptions) {
                    return (Item) XmlBeans.getContextTypeLoader().newInstance(Item.type, xmlOptions);
                }

                private Factory() {
                }
            }
        }

        public static final class Factory {
            public static Member2 newValue(Object obj) {
                return (Member2) Member2.type.newValue(obj);
            }

            public static Member2 newInstance() {
                return (Member2) XmlBeans.getContextTypeLoader().newInstance(Member2.type, null);
            }

            public static Member2 newInstance(XmlOptions xmlOptions) {
                return (Member2) XmlBeans.getContextTypeLoader().newInstance(Member2.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static NamespaceList newValue(Object obj) {
            return (NamespaceList) NamespaceList.type.newValue(obj);
        }

        public static NamespaceList newInstance() {
            return (NamespaceList) XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, null);
        }

        public static NamespaceList newInstance(XmlOptions xmlOptions) {
            return (NamespaceList) XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(String str) throws XmlException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(str, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(str, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(File file) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(file, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(file, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(URL url) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(url, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(url, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(InputStream inputStream) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(inputStream, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(inputStream, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(Reader reader) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(reader, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(reader, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(Node node) throws XmlException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(node, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(node, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NamespaceList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespaceList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespaceList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespaceList.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
