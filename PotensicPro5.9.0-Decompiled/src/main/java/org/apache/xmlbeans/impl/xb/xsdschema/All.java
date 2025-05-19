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
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface All extends ExplicitGroup {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.All$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$All;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.All");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all3c04type");
    }

    public interface MinOccurs extends XmlNonNegativeInteger {
        public static final SchemaType type;

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.All$MinOccurs");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minoccurs9283attrtype");
        }

        public static final class Factory {
            public static MinOccurs newValue(Object obj) {
                return (MinOccurs) MinOccurs.type.newValue(obj);
            }

            public static MinOccurs newInstance() {
                return (MinOccurs) XmlBeans.getContextTypeLoader().newInstance(MinOccurs.type, null);
            }

            public static MinOccurs newInstance(XmlOptions xmlOptions) {
                return (MinOccurs) XmlBeans.getContextTypeLoader().newInstance(MinOccurs.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public interface MaxOccurs extends AllNNI {
        public static final SchemaType type;

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        Object getObjectValue();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        SchemaType instanceType();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        void objectSet(Object obj);

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        Object objectValue();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        void setObjectValue(Object obj);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.All$MaxOccurs");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxoccurse8b1attrtype");
        }

        public static final class Factory {
            public static MaxOccurs newValue(Object obj) {
                return (MaxOccurs) MaxOccurs.type.newValue(obj);
            }

            public static MaxOccurs newInstance() {
                return (MaxOccurs) XmlBeans.getContextTypeLoader().newInstance(MaxOccurs.type, null);
            }

            public static MaxOccurs newInstance(XmlOptions xmlOptions) {
                return (MaxOccurs) XmlBeans.getContextTypeLoader().newInstance(MaxOccurs.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static All newInstance() {
            return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, null);
        }

        public static All newInstance(XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, xmlOptions);
        }

        public static All parse(String str) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(str, All.type, (XmlOptions) null);
        }

        public static All parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(str, All.type, xmlOptions);
        }

        public static All parse(File file) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(file, All.type, (XmlOptions) null);
        }

        public static All parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(file, All.type, xmlOptions);
        }

        public static All parse(URL url) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(url, All.type, (XmlOptions) null);
        }

        public static All parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(url, All.type, xmlOptions);
        }

        public static All parse(InputStream inputStream) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(inputStream, All.type, (XmlOptions) null);
        }

        public static All parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(inputStream, All.type, xmlOptions);
        }

        public static All parse(Reader reader) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(reader, All.type, (XmlOptions) null);
        }

        public static All parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(reader, All.type, xmlOptions);
        }

        public static All parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, All.type, (XmlOptions) null);
        }

        public static All parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, All.type, xmlOptions);
        }

        public static All parse(Node node) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(node, All.type, (XmlOptions) null);
        }

        public static All parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(node, All.type, xmlOptions);
        }

        public static All parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLInputStream, All.type, (XmlOptions) null);
        }

        public static All parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLInputStream, All.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, All.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, All.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
