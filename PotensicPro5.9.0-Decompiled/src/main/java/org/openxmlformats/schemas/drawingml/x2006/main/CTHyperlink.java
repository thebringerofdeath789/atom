package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTHyperlink extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHyperlink.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cthyperlink4457type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHyperlink newInstance() {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().newInstance(CTHyperlink.type, null);
        }

        public static CTHyperlink newInstance(XmlOptions xmlOptions) {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().newInstance(CTHyperlink.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHyperlink.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(File file) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(file, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(file, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(inputStream, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(inputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(Reader reader) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(reader, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(reader, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(String str) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(str, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(str, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(URL url) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(url, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(url, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(Node node) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(node, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(node, CTHyperlink.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTEmbeddedWAVAudioFile addNewSnd();

    String getAction();

    boolean getEndSnd();

    CTOfficeArtExtensionList getExtLst();

    boolean getHighlightClick();

    boolean getHistory();

    String getId();

    String getInvalidUrl();

    CTEmbeddedWAVAudioFile getSnd();

    String getTgtFrame();

    String getTooltip();

    boolean isSetAction();

    boolean isSetEndSnd();

    boolean isSetExtLst();

    boolean isSetHighlightClick();

    boolean isSetHistory();

    boolean isSetId();

    boolean isSetInvalidUrl();

    boolean isSetSnd();

    boolean isSetTgtFrame();

    boolean isSetTooltip();

    void setAction(String str);

    void setEndSnd(boolean z);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setHighlightClick(boolean z);

    void setHistory(boolean z);

    void setId(String str);

    void setInvalidUrl(String str);

    void setSnd(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile);

    void setTgtFrame(String str);

    void setTooltip(String str);

    void unsetAction();

    void unsetEndSnd();

    void unsetExtLst();

    void unsetHighlightClick();

    void unsetHistory();

    void unsetId();

    void unsetInvalidUrl();

    void unsetSnd();

    void unsetTgtFrame();

    void unsetTooltip();

    XmlString xgetAction();

    XmlBoolean xgetEndSnd();

    XmlBoolean xgetHighlightClick();

    XmlBoolean xgetHistory();

    STRelationshipId xgetId();

    XmlString xgetInvalidUrl();

    XmlString xgetTgtFrame();

    XmlString xgetTooltip();

    void xsetAction(XmlString xmlString);

    void xsetEndSnd(XmlBoolean xmlBoolean);

    void xsetHighlightClick(XmlBoolean xmlBoolean);

    void xsetHistory(XmlBoolean xmlBoolean);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetInvalidUrl(XmlString xmlString);

    void xsetTgtFrame(XmlString xmlString);

    void xsetTooltip(XmlString xmlString);
}
