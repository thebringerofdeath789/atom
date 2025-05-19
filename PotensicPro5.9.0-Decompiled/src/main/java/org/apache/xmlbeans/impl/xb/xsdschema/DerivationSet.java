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
public interface DerivationSet extends XmlAnySimpleType {
    public static final SchemaType type;

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("derivationset037atype");
    }

    public interface Member extends XmlToken {
        public static final Enum ALL;
        public static final int INT_ALL = 1;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$Member");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anoned75type");
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
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2 == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$Member2");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2 = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon9394type");
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
        public static DerivationSet newValue(Object obj) {
            return (DerivationSet) DerivationSet.type.newValue(obj);
        }

        public static DerivationSet newInstance() {
            return (DerivationSet) XmlBeans.getContextTypeLoader().newInstance(DerivationSet.type, null);
        }

        public static DerivationSet newInstance(XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().newInstance(DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(String str) throws XmlException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(str, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(str, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(File file) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(file, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(file, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(URL url) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(url, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(url, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(InputStream inputStream) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(Reader reader) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(reader, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(reader, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(Node node) throws XmlException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(node, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(node, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationSet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationSet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationSet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
