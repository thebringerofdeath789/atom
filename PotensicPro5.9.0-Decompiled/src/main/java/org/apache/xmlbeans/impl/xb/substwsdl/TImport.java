package org.apache.xmlbeans.impl.xb.substwsdl;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface TImport extends XmlObject {
    public static final SchemaType type;

    String getLocation();

    String getNamespace();

    void setLocation(String str);

    void setNamespace(String str);

    XmlAnyURI xgetLocation();

    XmlAnyURI xgetNamespace();

    void xsetLocation(XmlAnyURI xmlAnyURI);

    void xsetNamespace(XmlAnyURI xmlAnyURI);

    /* renamed from: org.apache.xmlbeans.impl.xb.substwsdl.TImport$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$substwsdl$TImport;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$substwsdl$TImport == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.substwsdl.TImport");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$substwsdl$TImport = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$substwsdl$TImport;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("timport22datype");
    }

    public static final class Factory {
        public static TImport newInstance() {
            return (TImport) XmlBeans.getContextTypeLoader().newInstance(TImport.type, null);
        }

        public static TImport newInstance(XmlOptions xmlOptions) {
            return (TImport) XmlBeans.getContextTypeLoader().newInstance(TImport.type, xmlOptions);
        }

        public static TImport parse(String str) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(str, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(str, TImport.type, xmlOptions);
        }

        public static TImport parse(File file) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(file, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(file, TImport.type, xmlOptions);
        }

        public static TImport parse(URL url) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(url, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(url, TImport.type, xmlOptions);
        }

        public static TImport parse(InputStream inputStream) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(inputStream, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(inputStream, TImport.type, xmlOptions);
        }

        public static TImport parse(Reader reader) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(reader, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(reader, TImport.type, xmlOptions);
        }

        public static TImport parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TImport.type, xmlOptions);
        }

        public static TImport parse(Node node) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(node, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(node, TImport.type, xmlOptions);
        }

        public static TImport parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TImport.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TImport.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TImport.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
