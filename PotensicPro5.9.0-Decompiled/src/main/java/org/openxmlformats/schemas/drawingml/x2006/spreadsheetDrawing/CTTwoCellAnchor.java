package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTwoCellAnchor extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTwoCellAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttwocellanchor1e8dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTwoCellAnchor newInstance() {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().newInstance(CTTwoCellAnchor.type, null);
        }

        public static CTTwoCellAnchor newInstance(XmlOptions xmlOptions) {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().newInstance(CTTwoCellAnchor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTwoCellAnchor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(File file) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(file, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(file, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(inputStream, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(inputStream, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(Reader reader) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(reader, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(reader, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(String str) throws XmlException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(str, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(str, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(URL url) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(url, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(url, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(Node node) throws XmlException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(node, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTwoCellAnchor) XmlBeans.getContextTypeLoader().parse(node, CTTwoCellAnchor.type, xmlOptions);
        }
    }

    CTAnchorClientData addNewClientData();

    CTConnector addNewCxnSp();

    CTMarker addNewFrom();

    CTGraphicalObjectFrame addNewGraphicFrame();

    CTGroupShape addNewGrpSp();

    CTPicture addNewPic();

    CTShape addNewSp();

    CTMarker addNewTo();

    CTAnchorClientData getClientData();

    CTConnector getCxnSp();

    STEditAs.Enum getEditAs();

    CTMarker getFrom();

    CTGraphicalObjectFrame getGraphicFrame();

    CTGroupShape getGrpSp();

    CTPicture getPic();

    CTShape getSp();

    CTMarker getTo();

    boolean isSetCxnSp();

    boolean isSetEditAs();

    boolean isSetGraphicFrame();

    boolean isSetGrpSp();

    boolean isSetPic();

    boolean isSetSp();

    void setClientData(CTAnchorClientData cTAnchorClientData);

    void setCxnSp(CTConnector cTConnector);

    void setEditAs(STEditAs.Enum r1);

    void setFrom(CTMarker cTMarker);

    void setGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame);

    void setGrpSp(CTGroupShape cTGroupShape);

    void setPic(CTPicture cTPicture);

    void setSp(CTShape cTShape);

    void setTo(CTMarker cTMarker);

    void unsetCxnSp();

    void unsetEditAs();

    void unsetGraphicFrame();

    void unsetGrpSp();

    void unsetPic();

    void unsetSp();

    STEditAs xgetEditAs();

    void xsetEditAs(STEditAs sTEditAs);
}
