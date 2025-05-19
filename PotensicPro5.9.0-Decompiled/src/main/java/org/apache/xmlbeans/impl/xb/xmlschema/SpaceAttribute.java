package org.apache.xmlbeans.impl.xb.xmlschema;

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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface SpaceAttribute extends XmlObject {
    public static final SchemaType type;

    Space.Enum getSpace();

    boolean isSetSpace();

    void setSpace(Space.Enum r1);

    void unsetSpace();

    Space xgetSpace();

    void xsetSpace(Space space);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute$Space;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("space9344attrtypetype");
    }

    public interface Space extends XmlNCName {
        public static final Enum DEFAULT;
        public static final int INT_DEFAULT = 1;
        public static final int INT_PRESERVE = 2;
        public static final Enum PRESERVE;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute$Space == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute$Space");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute$Space = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute$Space;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("spaceb986attrtype");
            DEFAULT = Enum.forString("default");
            PRESERVE = Enum.forString("preserve");
        }

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_DEFAULT = 1;
            static final int INT_PRESERVE = 2;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("default", 1), new Enum("preserve", 2)});

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
            public static Space newValue(Object obj) {
                return (Space) Space.type.newValue(obj);
            }

            public static Space newInstance() {
                return (Space) XmlBeans.getContextTypeLoader().newInstance(Space.type, null);
            }

            public static Space newInstance(XmlOptions xmlOptions) {
                return (Space) XmlBeans.getContextTypeLoader().newInstance(Space.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static SpaceAttribute newInstance() {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.type, null);
        }

        public static SpaceAttribute newInstance(XmlOptions xmlOptions) {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(String str) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(str, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(str, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(File file) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(file, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(file, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(URL url) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(url, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(url, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(Reader reader) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(reader, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(reader, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(Node node) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(node, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(node, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SpaceAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SpaceAttribute.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SpaceAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
