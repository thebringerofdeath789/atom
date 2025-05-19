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
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTScatterSer extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTScatterSer.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctscatterser2f7atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTScatterSer newInstance() {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().newInstance(CTScatterSer.type, null);
        }

        public static CTScatterSer newInstance(XmlOptions xmlOptions) {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().newInstance(CTScatterSer.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScatterSer.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(File file) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(file, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(file, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(InputStream inputStream) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(inputStream, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(inputStream, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(Reader reader) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(reader, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(reader, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(String str) throws XmlException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(str, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(str, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(URL url) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(url, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(url, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScatterSer.type, xmlOptions);
        }

        public static CTScatterSer parse(Node node) throws XmlException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(node, CTScatterSer.type, (XmlOptions) null);
        }

        public static CTScatterSer parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterSer) XmlBeans.getContextTypeLoader().parse(node, CTScatterSer.type, xmlOptions);
        }
    }

    CTDLbls addNewDLbls();

    CTDPt addNewDPt();

    CTErrBars addNewErrBars();

    CTExtensionList addNewExtLst();

    CTUnsignedInt addNewIdx();

    CTMarker addNewMarker();

    CTUnsignedInt addNewOrder();

    CTBoolean addNewSmooth();

    CTShapeProperties addNewSpPr();

    CTTrendline addNewTrendline();

    CTSerTx addNewTx();

    CTAxDataSource addNewXVal();

    CTNumDataSource addNewYVal();

    CTDLbls getDLbls();

    CTDPt getDPtArray(int i);

    CTDPt[] getDPtArray();

    List<CTDPt> getDPtList();

    CTErrBars getErrBarsArray(int i);

    CTErrBars[] getErrBarsArray();

    List<CTErrBars> getErrBarsList();

    CTExtensionList getExtLst();

    CTUnsignedInt getIdx();

    CTMarker getMarker();

    CTUnsignedInt getOrder();

    CTBoolean getSmooth();

    CTShapeProperties getSpPr();

    CTTrendline getTrendlineArray(int i);

    CTTrendline[] getTrendlineArray();

    List<CTTrendline> getTrendlineList();

    CTSerTx getTx();

    CTAxDataSource getXVal();

    CTNumDataSource getYVal();

    CTDPt insertNewDPt(int i);

    CTErrBars insertNewErrBars(int i);

    CTTrendline insertNewTrendline(int i);

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetMarker();

    boolean isSetSmooth();

    boolean isSetSpPr();

    boolean isSetTx();

    boolean isSetXVal();

    boolean isSetYVal();

    void removeDPt(int i);

    void removeErrBars(int i);

    void removeTrendline(int i);

    void setDLbls(CTDLbls cTDLbls);

    void setDPtArray(int i, CTDPt cTDPt);

    void setDPtArray(CTDPt[] cTDPtArr);

    void setErrBarsArray(int i, CTErrBars cTErrBars);

    void setErrBarsArray(CTErrBars[] cTErrBarsArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIdx(CTUnsignedInt cTUnsignedInt);

    void setMarker(CTMarker cTMarker);

    void setOrder(CTUnsignedInt cTUnsignedInt);

    void setSmooth(CTBoolean cTBoolean);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTrendlineArray(int i, CTTrendline cTTrendline);

    void setTrendlineArray(CTTrendline[] cTTrendlineArr);

    void setTx(CTSerTx cTSerTx);

    void setXVal(CTAxDataSource cTAxDataSource);

    void setYVal(CTNumDataSource cTNumDataSource);

    int sizeOfDPtArray();

    int sizeOfErrBarsArray();

    int sizeOfTrendlineArray();

    void unsetDLbls();

    void unsetExtLst();

    void unsetMarker();

    void unsetSmooth();

    void unsetSpPr();

    void unsetTx();

    void unsetXVal();

    void unsetYVal();
}
