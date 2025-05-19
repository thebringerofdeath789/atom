package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface UnionDocument extends XmlObject {
    public static final SchemaType type;

    Union addNewUnion();

    Union getUnion();

    void setUnion(Union union);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union$MemberTypes;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("union5866doctype");
    }

    public interface Union extends Annotated {
        public static final SchemaType type;

        LocalSimpleType addNewSimpleType();

        List getMemberTypes();

        LocalSimpleType getSimpleTypeArray(int i);

        LocalSimpleType[] getSimpleTypeArray();

        LocalSimpleType insertNewSimpleType(int i);

        boolean isSetMemberTypes();

        void removeSimpleType(int i);

        void setMemberTypes(List list);

        void setSimpleTypeArray(int i, LocalSimpleType localSimpleType);

        void setSimpleTypeArray(LocalSimpleType[] localSimpleTypeArr);

        int sizeOfSimpleTypeArray();

        void unsetMemberTypes();

        MemberTypes xgetMemberTypes();

        void xsetMemberTypes(MemberTypes memberTypes);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument$Union");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("union498belemtype");
        }

        public interface MemberTypes extends XmlAnySimpleType {
            public static final SchemaType type;

            List getListValue();

            List listValue();

            void set(List list);

            void setListValue(List list);

            List xgetListValue();

            List xlistValue();

            static {
                Class cls;
                if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union$MemberTypes == null) {
                    cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument$Union$MemberTypes");
                    AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union$MemberTypes = cls;
                } else {
                    cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union$MemberTypes;
                }
                type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("membertypes2404attrtype");
            }

            public static final class Factory {
                public static MemberTypes newValue(Object obj) {
                    return (MemberTypes) MemberTypes.type.newValue(obj);
                }

                public static MemberTypes newInstance() {
                    return (MemberTypes) XmlBeans.getContextTypeLoader().newInstance(MemberTypes.type, null);
                }

                public static MemberTypes newInstance(XmlOptions xmlOptions) {
                    return (MemberTypes) XmlBeans.getContextTypeLoader().newInstance(MemberTypes.type, xmlOptions);
                }

                private Factory() {
                }
            }
        }

        public static final class Factory {
            public static Union newInstance() {
                return (Union) XmlBeans.getContextTypeLoader().newInstance(Union.type, null);
            }

            public static Union newInstance(XmlOptions xmlOptions) {
                return (Union) XmlBeans.getContextTypeLoader().newInstance(Union.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static UnionDocument newInstance() {
            return (UnionDocument) XmlBeans.getContextTypeLoader().newInstance(UnionDocument.type, null);
        }

        public static UnionDocument newInstance(XmlOptions xmlOptions) {
            return (UnionDocument) XmlBeans.getContextTypeLoader().newInstance(UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(String str) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(str, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(str, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(File file) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(file, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(file, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(URL url) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(url, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(url, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(Reader reader) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(reader, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(reader, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(Node node) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(node, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(node, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UnionDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UnionDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UnionDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
