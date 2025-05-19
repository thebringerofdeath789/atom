package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTLineJoinRound extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLineJoinRound.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlinejoinround7be1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineJoinRound newInstance() {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().newInstance(CTLineJoinRound.type, null);
        }

        public static CTLineJoinRound newInstance(XmlOptions xmlOptions) {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().newInstance(CTLineJoinRound.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLineJoinRound.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(File file) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(file, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(file, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(inputStream, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(inputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(Reader reader) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(reader, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(reader, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(String str) throws XmlException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(str, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(str, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(URL url) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(url, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(url, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(Node node) throws XmlException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(node, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineJoinRound) XmlBeans.getContextTypeLoader().parse(node, CTLineJoinRound.type, xmlOptions);
        }
    }
}
