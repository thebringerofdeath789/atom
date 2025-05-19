package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTrackChange extends CTMarkup {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTrackChange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttrackchangec317type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrackChange newInstance() {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().newInstance(CTTrackChange.type, null);
        }

        public static CTTrackChange newInstance(XmlOptions xmlOptions) {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().newInstance(CTTrackChange.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTrackChange.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(File file) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(file, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(file, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(inputStream, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(inputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(Reader reader) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(reader, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(reader, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(String str) throws XmlException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(str, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(str, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(URL url) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(url, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(url, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(Node node) throws XmlException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(node, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTrackChange) XmlBeans.getContextTypeLoader().parse(node, CTTrackChange.type, xmlOptions);
        }
    }

    String getAuthor();

    Calendar getDate();

    boolean isSetDate();

    void setAuthor(String str);

    void setDate(Calendar calendar);

    void unsetDate();

    STString xgetAuthor();

    STDateTime xgetDate();

    void xsetAuthor(STString sTString);

    void xsetDate(STDateTime sTDateTime);
}
