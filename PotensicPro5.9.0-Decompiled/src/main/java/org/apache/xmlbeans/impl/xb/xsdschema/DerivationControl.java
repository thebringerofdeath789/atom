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
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface DerivationControl extends XmlNMTOKEN {
    public static final Enum EXTENSION;
    public static final int INT_EXTENSION = 2;
    public static final int INT_LIST = 4;
    public static final int INT_RESTRICTION = 3;
    public static final int INT_SUBSTITUTION = 1;
    public static final int INT_UNION = 5;
    public static final Enum LIST;
    public static final Enum RESTRICTION;
    public static final Enum SUBSTITUTION;
    public static final Enum UNION;
    public static final SchemaType type;

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("derivationcontrola5dftype");
        SUBSTITUTION = Enum.forString("substitution");
        EXTENSION = Enum.forString("extension");
        RESTRICTION = Enum.forString("restriction");
        LIST = Enum.forString(XmlErrorCodes.LIST);
        UNION = Enum.forString(XmlErrorCodes.UNION);
    }

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EXTENSION = 2;
        static final int INT_LIST = 4;
        static final int INT_RESTRICTION = 3;
        static final int INT_SUBSTITUTION = 1;
        static final int INT_UNION = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("substitution", 1), new Enum("extension", 2), new Enum("restriction", 3), new Enum(XmlErrorCodes.LIST, 4), new Enum(XmlErrorCodes.UNION, 5)});

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
        public static DerivationControl newValue(Object obj) {
            return (DerivationControl) DerivationControl.type.newValue(obj);
        }

        public static DerivationControl newInstance() {
            return (DerivationControl) XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, null);
        }

        public static DerivationControl newInstance(XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(String str) throws XmlException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(str, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(str, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(File file) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(file, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(file, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(URL url) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(url, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(url, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(InputStream inputStream) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(Reader reader) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(reader, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(reader, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(Node node) throws XmlException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(node, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(node, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationControl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationControl.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationControl.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
