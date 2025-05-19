package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTConnectorNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTConnectorNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctconnectornonvisual0f45type");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnectorNonVisual newInstance() {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTConnectorNonVisual.type, null);
        }

        public static CTConnectorNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTConnectorNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConnectorNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(File file) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(String str) throws XmlException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(URL url) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(Node node) throws XmlException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectorNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTConnectorNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualConnectorProperties addNewCNvCxnSpPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualConnectorProperties getCNvCxnSpPr();

    CTNonVisualDrawingProps getCNvPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvCxnSpPr(CTNonVisualConnectorProperties cTNonVisualConnectorProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
