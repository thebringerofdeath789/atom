package org.apache.xmlbeans.impl.xb.xmlschema;

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
public interface BaseAttribute extends XmlObject {
    public static final SchemaType type;

    String getBase();

    boolean isSetBase();

    void setBase(String str);

    void unsetBase();

    XmlAnyURI xgetBase();

    void xsetBase(XmlAnyURI xmlAnyURI);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlschema$BaseAttribute;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$BaseAttribute == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$BaseAttribute = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$BaseAttribute;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("basece23attrtypetype");
    }

    public static final class Factory {
        public static BaseAttribute newInstance() {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().newInstance(BaseAttribute.type, null);
        }

        public static BaseAttribute newInstance(XmlOptions xmlOptions) {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().newInstance(BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(String str) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(str, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(str, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(File file) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(file, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(file, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(URL url) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(url, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(url, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(Reader reader) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(reader, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(reader, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(Node node) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(node, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(node, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, BaseAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BaseAttribute.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BaseAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
