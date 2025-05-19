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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface ConfigDocument extends XmlObject {
    public static final SchemaType type;

    Config addNewConfig();

    Config getConfig();

    void setConfig(Config config);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument$Config;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("config4185doctype");
    }

    public interface Config extends XmlObject {
        public static final SchemaType type;

        Extensionconfig addNewExtension();

        Nsconfig addNewNamespace();

        Qnameconfig addNewQname();

        Usertypeconfig addNewUsertype();

        Extensionconfig getExtensionArray(int i);

        Extensionconfig[] getExtensionArray();

        Nsconfig getNamespaceArray(int i);

        Nsconfig[] getNamespaceArray();

        Qnameconfig getQnameArray(int i);

        Qnameconfig[] getQnameArray();

        Usertypeconfig getUsertypeArray(int i);

        Usertypeconfig[] getUsertypeArray();

        Extensionconfig insertNewExtension(int i);

        Nsconfig insertNewNamespace(int i);

        Qnameconfig insertNewQname(int i);

        Usertypeconfig insertNewUsertype(int i);

        void removeExtension(int i);

        void removeNamespace(int i);

        void removeQname(int i);

        void removeUsertype(int i);

        void setExtensionArray(int i, Extensionconfig extensionconfig);

        void setExtensionArray(Extensionconfig[] extensionconfigArr);

        void setNamespaceArray(int i, Nsconfig nsconfig);

        void setNamespaceArray(Nsconfig[] nsconfigArr);

        void setQnameArray(int i, Qnameconfig qnameconfig);

        void setQnameArray(Qnameconfig[] qnameconfigArr);

        void setUsertypeArray(int i, Usertypeconfig usertypeconfig);

        void setUsertypeArray(Usertypeconfig[] usertypeconfigArr);

        int sizeOfExtensionArray();

        int sizeOfNamespaceArray();

        int sizeOfQnameArray();

        int sizeOfUsertypeArray();

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument$Config == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument$Config");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument$Config = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$ConfigDocument$Config;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("configf467elemtype");
        }

        public static final class Factory {
            public static Config newInstance() {
                return (Config) XmlBeans.getContextTypeLoader().newInstance(Config.type, null);
            }

            public static Config newInstance(XmlOptions xmlOptions) {
                return (Config) XmlBeans.getContextTypeLoader().newInstance(Config.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static ConfigDocument newInstance() {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.type, null);
        }

        public static ConfigDocument newInstance(XmlOptions xmlOptions) {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(String str) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(str, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(str, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(File file) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(file, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(file, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(URL url) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(url, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(url, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(Reader reader) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(reader, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(reader, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(Node node) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(node, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(node, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ConfigDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ConfigDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ConfigDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
