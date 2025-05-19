package org.apache.xmlbeans.impl.xb.xmlconfig;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Qnametargetenum extends XmlToken {
    public static final Enum ACCESSOR_ATTRIBUTE;
    public static final Enum ACCESSOR_ELEMENT;
    public static final Enum DOCUMENT_TYPE;
    public static final int INT_ACCESSOR_ATTRIBUTE = 4;
    public static final int INT_ACCESSOR_ELEMENT = 3;
    public static final int INT_DOCUMENT_TYPE = 2;
    public static final int INT_TYPE = 1;
    public static final Enum TYPE;
    public static final SchemaType type;

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetenum$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetenum;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetenum == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetenum");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetenum = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetenum;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("qnametargetenum9f8ftype");
        TYPE = Enum.forString("type");
        DOCUMENT_TYPE = Enum.forString("document-type");
        ACCESSOR_ELEMENT = Enum.forString("accessor-element");
        ACCESSOR_ATTRIBUTE = Enum.forString("accessor-attribute");
    }

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ACCESSOR_ATTRIBUTE = 4;
        static final int INT_ACCESSOR_ELEMENT = 3;
        static final int INT_DOCUMENT_TYPE = 2;
        static final int INT_TYPE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("type", 1), new Enum("document-type", 2), new Enum("accessor-element", 3), new Enum("accessor-attribute", 4)});

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
        public static Qnametargetenum newValue(Object obj) {
            return (Qnametargetenum) Qnametargetenum.type.newValue(obj);
        }

        public static Qnametargetenum newInstance() {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().newInstance(Qnametargetenum.type, null);
        }

        public static Qnametargetenum newInstance(XmlOptions xmlOptions) {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().newInstance(Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(String str) throws XmlException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(str, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(str, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(File file) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(file, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(file, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(URL url) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(url, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(url, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(InputStream inputStream) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(inputStream, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(inputStream, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(Reader reader) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(reader, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(reader, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(Node node) throws XmlException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(node, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(node, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Qnametargetenum) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnametargetenum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnametargetenum.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnametargetenum.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
