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
public interface BlockSet extends XmlAnySimpleType {
    public static final SchemaType type;

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.BlockSet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2$Item;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("blockset815etype");
    }

    public interface Member extends XmlToken {
        public static final Enum ALL;
        public static final int INT_ALL = 1;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet$Member");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0683type");
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
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2 == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet$Member2");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2 = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonc904type");
        }

        public interface Item extends DerivationControl {
            public static final DerivationControl.Enum EXTENSION;
            public static final int INT_EXTENSION = 2;
            public static final int INT_RESTRICTION = 3;
            public static final int INT_SUBSTITUTION = 1;
            public static final DerivationControl.Enum RESTRICTION;
            public static final DerivationControl.Enum SUBSTITUTION;
            public static final SchemaType type;

            static {
                Class cls;
                if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2$Item == null) {
                    cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.BlockSet$Member2$Item");
                    AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2$Item = cls;
                } else {
                    cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$BlockSet$Member2$Item;
                }
                type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon421ctype");
                EXTENSION = DerivationControl.EXTENSION;
                RESTRICTION = DerivationControl.RESTRICTION;
                SUBSTITUTION = DerivationControl.SUBSTITUTION;
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
        public static BlockSet newValue(Object obj) {
            return (BlockSet) BlockSet.type.newValue(obj);
        }

        public static BlockSet newInstance() {
            return (BlockSet) XmlBeans.getContextTypeLoader().newInstance(BlockSet.type, null);
        }

        public static BlockSet newInstance(XmlOptions xmlOptions) {
            return (BlockSet) XmlBeans.getContextTypeLoader().newInstance(BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(String str) throws XmlException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(str, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(str, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(File file) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(file, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(file, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(URL url) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(url, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(url, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(InputStream inputStream) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(inputStream, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(inputStream, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(Reader reader) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(reader, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(reader, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(Node node) throws XmlException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(node, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(node, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (BlockSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, BlockSet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BlockSet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BlockSet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
