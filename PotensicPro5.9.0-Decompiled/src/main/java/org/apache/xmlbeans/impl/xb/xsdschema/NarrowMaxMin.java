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
public interface NarrowMaxMin extends LocalElement {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MaxOccurs;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MinOccurs;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("narrowmaxmin926atype");
    }

    public interface MinOccurs extends XmlNonNegativeInteger {
        public static final SchemaType type;

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MinOccurs == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin$MinOccurs");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MinOccurs = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MinOccurs;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minoccurs1acbattrtype");
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
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MaxOccurs == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin$MaxOccurs");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MaxOccurs = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NarrowMaxMin$MaxOccurs;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxoccursd85dattrtype");
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
        public static NarrowMaxMin newInstance() {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.type, null);
        }

        public static NarrowMaxMin newInstance(XmlOptions xmlOptions) {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(String str) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(str, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(str, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(File file) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(file, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(file, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(URL url) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(url, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(url, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(InputStream inputStream) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(inputStream, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(inputStream, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(Reader reader) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(reader, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(reader, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(Node node) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(node, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(node, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NarrowMaxMin.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NarrowMaxMin.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NarrowMaxMin.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
