package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTLegend extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLegend.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlegenda54ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLegend newInstance() {
            return (CTLegend) XmlBeans.getContextTypeLoader().newInstance(CTLegend.type, null);
        }

        public static CTLegend newInstance(XmlOptions xmlOptions) {
            return (CTLegend) XmlBeans.getContextTypeLoader().newInstance(CTLegend.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLegend.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(File file) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(file, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(file, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(inputStream, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(inputStream, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(Reader reader) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(reader, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(reader, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(String str) throws XmlException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(str, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(str, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(URL url) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(url, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(url, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLegend.type, xmlOptions);
        }

        public static CTLegend parse(Node node) throws XmlException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(node, CTLegend.type, (XmlOptions) null);
        }

        public static CTLegend parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLegend) XmlBeans.getContextTypeLoader().parse(node, CTLegend.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTLayout addNewLayout();

    CTLegendEntry addNewLegendEntry();

    CTLegendPos addNewLegendPos();

    CTBoolean addNewOverlay();

    CTShapeProperties addNewSpPr();

    CTTextBody addNewTxPr();

    CTExtensionList getExtLst();

    CTLayout getLayout();

    CTLegendEntry getLegendEntryArray(int i);

    CTLegendEntry[] getLegendEntryArray();

    List<CTLegendEntry> getLegendEntryList();

    CTLegendPos getLegendPos();

    CTBoolean getOverlay();

    CTShapeProperties getSpPr();

    CTTextBody getTxPr();

    CTLegendEntry insertNewLegendEntry(int i);

    boolean isSetExtLst();

    boolean isSetLayout();

    boolean isSetLegendPos();

    boolean isSetOverlay();

    boolean isSetSpPr();

    boolean isSetTxPr();

    void removeLegendEntry(int i);

    void setExtLst(CTExtensionList cTExtensionList);

    void setLayout(CTLayout cTLayout);

    void setLegendEntryArray(int i, CTLegendEntry cTLegendEntry);

    void setLegendEntryArray(CTLegendEntry[] cTLegendEntryArr);

    void setLegendPos(CTLegendPos cTLegendPos);

    void setOverlay(CTBoolean cTBoolean);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTxPr(CTTextBody cTTextBody);

    int sizeOfLegendEntryArray();

    void unsetExtLst();

    void unsetLayout();

    void unsetLegendPos();

    void unsetOverlay();

    void unsetSpPr();

    void unsetTxPr();
}
