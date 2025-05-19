package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface AllNNI extends XmlAnySimpleType {
    public static final SchemaType type;

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AllNNI$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllNNI");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("allnni78cbtype");
    }

    public interface Member extends XmlNMTOKEN {
        public static final int INT_UNBOUNDED = 1;
        public static final Enum UNBOUNDED;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllNNI$Member");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0330type");
            UNBOUNDED = Enum.forString("unbounded");
        }

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_UNBOUNDED = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("unbounded", 1)});

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
        public static AllNNI newValue(Object obj) {
            return (AllNNI) AllNNI.type.newValue(obj);
        }

        public static AllNNI newInstance() {
            return (AllNNI) XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, null);
        }

        public static AllNNI newInstance(XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(String str) throws XmlException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(str, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(str, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(File file) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(file, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(file, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(URL url) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(url, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(url, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(InputStream inputStream) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(inputStream, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(inputStream, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(Reader reader) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(reader, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(reader, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(Node node) throws XmlException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(node, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(node, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllNNI.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllNNI.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllNNI.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
