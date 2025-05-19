package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STOnOff extends XmlString {
    public static final int INT_FALSE = 2;
    public static final int INT_OFF = 4;
    public static final int INT_ON = 3;
    public static final int INT_TRUE = 1;
    public static final int INT_X_0 = 5;
    public static final int INT_X_1 = 6;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STOnOff.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stonofffcd2type");
    public static final Enum TRUE = Enum.forString(BooleanUtils.TRUE);
    public static final Enum FALSE = Enum.forString("false");
    public static final Enum ON = Enum.forString("on");
    public static final Enum OFF = Enum.forString("off");
    public static final Enum X_0 = Enum.forString(SessionDescription.SUPPORTED_SDP_VERSION);
    public static final Enum X_1 = Enum.forString("1");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FALSE = 2;
        static final int INT_OFF = 4;
        static final int INT_ON = 3;
        static final int INT_TRUE = 1;
        static final int INT_X_0 = 5;
        static final int INT_X_1 = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(BooleanUtils.TRUE, 1), new Enum("false", 2), new Enum("on", 3), new Enum("off", 4), new Enum(SessionDescription.SUPPORTED_SDP_VERSION, 5), new Enum("1", 6)});

        private Enum(String str, int i) {
            super(str, i);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    public static final class Factory {
        private Factory() {
        }

        public static STOnOff newInstance() {
            return (STOnOff) XmlBeans.getContextTypeLoader().newInstance(STOnOff.type, null);
        }

        public static STOnOff newInstance(XmlOptions xmlOptions) {
            return (STOnOff) XmlBeans.getContextTypeLoader().newInstance(STOnOff.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STOnOff.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STOnOff.type, xmlOptions);
        }

        public static STOnOff newValue(Object obj) {
            return (STOnOff) STOnOff.type.newValue(obj);
        }

        public static STOnOff parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(File file) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(file, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(file, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(InputStream inputStream) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(inputStream, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(inputStream, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(Reader reader) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(reader, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(reader, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(String str) throws XmlException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(str, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(str, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(URL url) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(url, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(url, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(Node node) throws XmlException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(node, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STOnOff) XmlBeans.getContextTypeLoader().parse(node, STOnOff.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
