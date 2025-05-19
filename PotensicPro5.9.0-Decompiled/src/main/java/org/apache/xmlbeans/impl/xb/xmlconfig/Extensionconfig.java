package org.apache.xmlbeans.impl.xb.xmlconfig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Extensionconfig extends XmlObject {
    public static final SchemaType type;

    Interface addNewInterface();

    PrePostSet addNewPrePostSet();

    Object getFor();

    Interface getInterfaceArray(int i);

    Interface[] getInterfaceArray();

    PrePostSet getPrePostSet();

    Interface insertNewInterface(int i);

    boolean isSetFor();

    boolean isSetPrePostSet();

    void removeInterface(int i);

    void setFor(Object obj);

    void setInterfaceArray(int i, Interface r2);

    void setInterfaceArray(Interface[] interfaceArr);

    void setPrePostSet(PrePostSet prePostSet);

    int sizeOfInterfaceArray();

    void unsetFor();

    void unsetPrePostSet();

    JavaNameList xgetFor();

    void xsetFor(JavaNameList javaNameList);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$Interface;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$PrePostSet;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("extensionconfig2ac2type");
    }

    public interface Interface extends XmlObject {
        public static final SchemaType type;

        String getName();

        String getStaticHandler();

        boolean isSetName();

        void setName(String str);

        void setStaticHandler(String str);

        void unsetName();

        XmlString xgetName();

        XmlString xgetStaticHandler();

        void xsetName(XmlString xmlString);

        void xsetStaticHandler(XmlString xmlString);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$Interface == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig$Interface");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$Interface = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$Interface;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("interface02a7elemtype");
        }

        public static final class Factory {
            public static Interface newInstance() {
                return (Interface) XmlBeans.getContextTypeLoader().newInstance(Interface.type, null);
            }

            public static Interface newInstance(XmlOptions xmlOptions) {
                return (Interface) XmlBeans.getContextTypeLoader().newInstance(Interface.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public interface PrePostSet extends XmlObject {
        public static final SchemaType type;

        String getStaticHandler();

        void setStaticHandler(String str);

        XmlString xgetStaticHandler();

        void xsetStaticHandler(XmlString xmlString);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$PrePostSet == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig$PrePostSet");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$PrePostSet = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Extensionconfig$PrePostSet;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("prepostset5c9delemtype");
        }

        public static final class Factory {
            public static PrePostSet newInstance() {
                return (PrePostSet) XmlBeans.getContextTypeLoader().newInstance(PrePostSet.type, null);
            }

            public static PrePostSet newInstance(XmlOptions xmlOptions) {
                return (PrePostSet) XmlBeans.getContextTypeLoader().newInstance(PrePostSet.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static Extensionconfig newInstance() {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.type, null);
        }

        public static Extensionconfig newInstance(XmlOptions xmlOptions) {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(String str) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(str, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(str, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(File file) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(file, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(file, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(URL url) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(url, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(url, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(InputStream inputStream) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(Reader reader) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(reader, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(reader, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(Node node) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(node, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(node, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Extensionconfig.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Extensionconfig.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Extensionconfig.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
