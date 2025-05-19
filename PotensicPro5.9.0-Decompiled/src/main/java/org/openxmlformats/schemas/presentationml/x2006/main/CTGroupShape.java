package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTGroupShape extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGroupShape.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgroupshape5b43type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupShape newInstance() {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().newInstance(CTGroupShape.type, null);
        }

        public static CTGroupShape newInstance(XmlOptions xmlOptions) {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().newInstance(CTGroupShape.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupShape.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(File file) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(file, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(file, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(Reader reader) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(reader, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(reader, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(String str) throws XmlException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(str, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(str, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(URL url) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(url, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(url, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(Node node) throws XmlException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(node, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShape) XmlBeans.getContextTypeLoader().parse(node, CTGroupShape.type, xmlOptions);
        }
    }

    CTConnector addNewCxnSp();

    CTExtensionListModify addNewExtLst();

    CTGraphicalObjectFrame addNewGraphicFrame();

    CTGroupShape addNewGrpSp();

    CTGroupShapeProperties addNewGrpSpPr();

    CTGroupShapeNonVisual addNewNvGrpSpPr();

    CTPicture addNewPic();

    CTShape addNewSp();

    CTConnector getCxnSpArray(int i);

    CTConnector[] getCxnSpArray();

    List<CTConnector> getCxnSpList();

    CTExtensionListModify getExtLst();

    CTGraphicalObjectFrame getGraphicFrameArray(int i);

    CTGraphicalObjectFrame[] getGraphicFrameArray();

    List<CTGraphicalObjectFrame> getGraphicFrameList();

    CTGroupShape getGrpSpArray(int i);

    CTGroupShape[] getGrpSpArray();

    List<CTGroupShape> getGrpSpList();

    CTGroupShapeProperties getGrpSpPr();

    CTGroupShapeNonVisual getNvGrpSpPr();

    CTPicture getPicArray(int i);

    CTPicture[] getPicArray();

    List<CTPicture> getPicList();

    CTShape getSpArray(int i);

    CTShape[] getSpArray();

    List<CTShape> getSpList();

    CTConnector insertNewCxnSp(int i);

    CTGraphicalObjectFrame insertNewGraphicFrame(int i);

    CTGroupShape insertNewGrpSp(int i);

    CTPicture insertNewPic(int i);

    CTShape insertNewSp(int i);

    boolean isSetExtLst();

    void removeCxnSp(int i);

    void removeGraphicFrame(int i);

    void removeGrpSp(int i);

    void removePic(int i);

    void removeSp(int i);

    void setCxnSpArray(int i, CTConnector cTConnector);

    void setCxnSpArray(CTConnector[] cTConnectorArr);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setGraphicFrameArray(int i, CTGraphicalObjectFrame cTGraphicalObjectFrame);

    void setGraphicFrameArray(CTGraphicalObjectFrame[] cTGraphicalObjectFrameArr);

    void setGrpSpArray(int i, CTGroupShape cTGroupShape);

    void setGrpSpArray(CTGroupShape[] cTGroupShapeArr);

    void setGrpSpPr(CTGroupShapeProperties cTGroupShapeProperties);

    void setNvGrpSpPr(CTGroupShapeNonVisual cTGroupShapeNonVisual);

    void setPicArray(int i, CTPicture cTPicture);

    void setPicArray(CTPicture[] cTPictureArr);

    void setSpArray(int i, CTShape cTShape);

    void setSpArray(CTShape[] cTShapeArr);

    int sizeOfCxnSpArray();

    int sizeOfGraphicFrameArray();

    int sizeOfGrpSpArray();

    int sizeOfPicArray();

    int sizeOfSpArray();

    void unsetExtLst();
}
