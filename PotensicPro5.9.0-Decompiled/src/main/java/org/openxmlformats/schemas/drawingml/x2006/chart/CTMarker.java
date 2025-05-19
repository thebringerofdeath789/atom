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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTMarker extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMarker.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmarkera682type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarker newInstance() {
            return (CTMarker) XmlBeans.getContextTypeLoader().newInstance(CTMarker.type, null);
        }

        public static CTMarker newInstance(XmlOptions xmlOptions) {
            return (CTMarker) XmlBeans.getContextTypeLoader().newInstance(CTMarker.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarker.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(File file) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(file, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(file, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(Reader reader) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(reader, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(reader, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(String str) throws XmlException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(str, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(str, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(URL url) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(url, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(url, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(Node node) throws XmlException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(node, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMarker) XmlBeans.getContextTypeLoader().parse(node, CTMarker.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTMarkerSize addNewSize();

    CTShapeProperties addNewSpPr();

    CTMarkerStyle addNewSymbol();

    CTExtensionList getExtLst();

    CTMarkerSize getSize();

    CTShapeProperties getSpPr();

    CTMarkerStyle getSymbol();

    boolean isSetExtLst();

    boolean isSetSize();

    boolean isSetSpPr();

    boolean isSetSymbol();

    void setExtLst(CTExtensionList cTExtensionList);

    void setSize(CTMarkerSize cTMarkerSize);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setSymbol(CTMarkerStyle cTMarkerStyle);

    void unsetExtLst();

    void unsetSize();

    void unsetSpPr();

    void unsetSymbol();
}
