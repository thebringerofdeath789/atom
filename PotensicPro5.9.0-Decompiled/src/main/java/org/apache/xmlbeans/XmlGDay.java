package org.apache.xmlbeans;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface XmlGDay extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gDay");

    Calendar calendarValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    GDate getGDateValue();

    int getIntValue();

    int intValue();

    void set(int i);

    void set(Calendar calendar);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);

    void setIntValue(int i);

    public static final class Factory {
        public static XmlGDay newInstance() {
            return (XmlGDay) XmlBeans.getContextTypeLoader().newInstance(XmlGDay.type, null);
        }

        public static XmlGDay newInstance(XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().newInstance(XmlGDay.type, xmlOptions);
        }

        public static XmlGDay newValue(Object obj) {
            return (XmlGDay) XmlGDay.type.newValue(obj);
        }

        public static XmlGDay parse(String str) throws XmlException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(str, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(str, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(File file) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(file, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(file, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(URL url) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(url, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(url, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(Reader reader) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(Node node) throws XmlException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(node, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(node, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGDay.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGDay.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGDay.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
