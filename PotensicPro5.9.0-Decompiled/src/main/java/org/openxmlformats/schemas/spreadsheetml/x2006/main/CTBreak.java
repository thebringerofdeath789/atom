package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTBreak extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbreak815etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBreak newInstance() {
            return (CTBreak) XmlBeans.getContextTypeLoader().newInstance(CTBreak.type, null);
        }

        public static CTBreak newInstance(XmlOptions xmlOptions) {
            return (CTBreak) XmlBeans.getContextTypeLoader().newInstance(CTBreak.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBreak.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(File file) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(file, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(file, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(inputStream, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(inputStream, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(Reader reader) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(reader, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(reader, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(String str) throws XmlException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(str, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(str, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(URL url) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(url, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(url, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBreak.type, xmlOptions);
        }

        public static CTBreak parse(Node node) throws XmlException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(node, CTBreak.type, (XmlOptions) null);
        }

        public static CTBreak parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBreak) XmlBeans.getContextTypeLoader().parse(node, CTBreak.type, xmlOptions);
        }
    }

    long getId();

    boolean getMan();

    long getMax();

    long getMin();

    boolean getPt();

    boolean isSetId();

    boolean isSetMan();

    boolean isSetMax();

    boolean isSetMin();

    boolean isSetPt();

    void setId(long j);

    void setMan(boolean z);

    void setMax(long j);

    void setMin(long j);

    void setPt(boolean z);

    void unsetId();

    void unsetMan();

    void unsetMax();

    void unsetMin();

    void unsetPt();

    XmlUnsignedInt xgetId();

    XmlBoolean xgetMan();

    XmlUnsignedInt xgetMax();

    XmlUnsignedInt xgetMin();

    XmlBoolean xgetPt();

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetMan(XmlBoolean xmlBoolean);

    void xsetMax(XmlUnsignedInt xmlUnsignedInt);

    void xsetMin(XmlUnsignedInt xmlUnsignedInt);

    void xsetPt(XmlBoolean xmlBoolean);
}
