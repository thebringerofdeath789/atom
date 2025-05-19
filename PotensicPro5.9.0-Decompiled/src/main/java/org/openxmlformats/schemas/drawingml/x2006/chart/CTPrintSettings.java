package org.openxmlformats.schemas.drawingml.x2006.chart;

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

/* loaded from: classes2.dex */
public interface CTPrintSettings extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPrintSettings.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctprintsettings61b6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPrintSettings newInstance() {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().newInstance(CTPrintSettings.type, null);
        }

        public static CTPrintSettings newInstance(XmlOptions xmlOptions) {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().newInstance(CTPrintSettings.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPrintSettings.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(File file) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(file, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(file, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(inputStream, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(inputStream, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(Reader reader) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(reader, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(reader, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(String str) throws XmlException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(str, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(str, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(URL url) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(url, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(url, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPrintSettings.type, xmlOptions);
        }

        public static CTPrintSettings parse(Node node) throws XmlException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(node, CTPrintSettings.type, (XmlOptions) null);
        }

        public static CTPrintSettings parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPrintSettings) XmlBeans.getContextTypeLoader().parse(node, CTPrintSettings.type, xmlOptions);
        }
    }

    CTHeaderFooter addNewHeaderFooter();

    CTRelId addNewLegacyDrawingHF();

    CTPageMargins addNewPageMargins();

    CTPageSetup addNewPageSetup();

    CTHeaderFooter getHeaderFooter();

    CTRelId getLegacyDrawingHF();

    CTPageMargins getPageMargins();

    CTPageSetup getPageSetup();

    boolean isSetHeaderFooter();

    boolean isSetLegacyDrawingHF();

    boolean isSetPageMargins();

    boolean isSetPageSetup();

    void setHeaderFooter(CTHeaderFooter cTHeaderFooter);

    void setLegacyDrawingHF(CTRelId cTRelId);

    void setPageMargins(CTPageMargins cTPageMargins);

    void setPageSetup(CTPageSetup cTPageSetup);

    void unsetHeaderFooter();

    void unsetLegacyDrawingHF();

    void unsetPageMargins();

    void unsetPageSetup();
}
