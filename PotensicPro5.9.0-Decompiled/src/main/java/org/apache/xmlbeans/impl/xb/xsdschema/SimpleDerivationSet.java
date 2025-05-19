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
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface SimpleDerivationSet extends XmlAnySimpleType {
    public static final SchemaType type;

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2$Item;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplederivationsetf70ctype");
    }

    public interface Member extends XmlToken {
        public static final Enum ALL;
        public static final int INT_ALL = 1;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet$Member");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon38c7type");
            ALL = Enum.forString("#all");
        }

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ALL = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("#all", 1)});

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
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2 == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet$Member2");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2 = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon8ba6type");
        }

        public interface Item extends DerivationControl {
            public static final int INT_LIST = 4;
            public static final int INT_RESTRICTION = 3;
            public static final int INT_UNION = 5;
            public static final DerivationControl.Enum LIST;
            public static final DerivationControl.Enum RESTRICTION;
            public static final DerivationControl.Enum UNION;
            public static final SchemaType type;

            static {
                Class cls;
                if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2$Item == null) {
                    cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet$Member2$Item");
                    AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2$Item = cls;
                } else {
                    cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleDerivationSet$Member2$Item;
                }
                type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonf38etype");
                LIST = DerivationControl.LIST;
                UNION = DerivationControl.UNION;
                RESTRICTION = DerivationControl.RESTRICTION;
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
        public static SimpleDerivationSet newValue(Object obj) {
            return (SimpleDerivationSet) SimpleDerivationSet.type.newValue(obj);
        }

        public static SimpleDerivationSet newInstance() {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.type, null);
        }

        public static SimpleDerivationSet newInstance(XmlOptions xmlOptions) {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(String str) throws XmlException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(str, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(str, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(File file) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(file, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(file, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(URL url) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(url, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(url, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(Reader reader) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(reader, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(reader, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(Node node) throws XmlException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(node, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(node, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SimpleDerivationSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleDerivationSet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleDerivationSet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleDerivationSet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
