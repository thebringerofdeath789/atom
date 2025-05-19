package org.apache.xmlbeans;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface XmlDate extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_date");

    Calendar calendarValue();

    Date dateValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    Date getDateValue();

    GDate getGDateValue();

    void set(Calendar calendar);

    void set(Date date);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setDateValue(Date date);

    void setGDateValue(GDate gDate);

    public static final class Factory {
        public static XmlDate newInstance() {
            return (XmlDate) XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, null);
        }

        public static XmlDate newInstance(XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, xmlOptions);
        }

        public static XmlDate newValue(Object obj) {
            return (XmlDate) XmlDate.type.newValue(obj);
        }

        public static XmlDate parse(String str) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(str, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(str, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(File file) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(file, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(file, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(URL url) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(url, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(url, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(Reader reader) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(reader, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(reader, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(Node node) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(node, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(node, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDate.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
