package org.apache.xmlbeans.impl.xb.xsdschema;

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
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface FormChoice extends XmlNMTOKEN {
    public static final int INT_QUALIFIED = 1;
    public static final int INT_UNQUALIFIED = 2;
    public static final Enum QUALIFIED;
    public static final Enum UNQUALIFIED;
    public static final SchemaType type;

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.FormChoice$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$FormChoice;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FormChoice == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.FormChoice");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FormChoice = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$FormChoice;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("formchoicef2aetype");
        QUALIFIED = Enum.forString("qualified");
        UNQUALIFIED = Enum.forString("unqualified");
    }

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_QUALIFIED = 1;
        static final int INT_UNQUALIFIED = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("qualified", 1), new Enum("unqualified", 2)});

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
        public static FormChoice newValue(Object obj) {
            return (FormChoice) FormChoice.type.newValue(obj);
        }

        public static FormChoice newInstance() {
            return (FormChoice) XmlBeans.getContextTypeLoader().newInstance(FormChoice.type, null);
        }

        public static FormChoice newInstance(XmlOptions xmlOptions) {
            return (FormChoice) XmlBeans.getContextTypeLoader().newInstance(FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(String str) throws XmlException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(str, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(str, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(File file) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(file, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(file, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(URL url) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(url, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(url, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(InputStream inputStream) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(inputStream, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(inputStream, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(Reader reader) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(reader, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(reader, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(Node node) throws XmlException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(node, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(node, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (FormChoice) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FormChoice.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FormChoice.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FormChoice.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
