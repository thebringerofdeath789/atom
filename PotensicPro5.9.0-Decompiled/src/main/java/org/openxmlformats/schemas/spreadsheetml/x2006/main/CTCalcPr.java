package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCalcPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCalcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcalcprd480type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCalcPr newInstance() {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().newInstance(CTCalcPr.type, null);
        }

        public static CTCalcPr newInstance(XmlOptions xmlOptions) {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().newInstance(CTCalcPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCalcPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(File file) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(file, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(file, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(Reader reader) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(reader, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(reader, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(String str) throws XmlException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(str, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(str, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(URL url) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(url, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(url, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCalcPr.type, xmlOptions);
        }

        public static CTCalcPr parse(Node node) throws XmlException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(node, CTCalcPr.type, (XmlOptions) null);
        }

        public static CTCalcPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcPr) XmlBeans.getContextTypeLoader().parse(node, CTCalcPr.type, xmlOptions);
        }
    }

    boolean getCalcCompleted();

    long getCalcId();

    STCalcMode.Enum getCalcMode();

    boolean getCalcOnSave();

    boolean getConcurrentCalc();

    long getConcurrentManualCount();

    boolean getForceFullCalc();

    boolean getFullCalcOnLoad();

    boolean getFullPrecision();

    boolean getIterate();

    long getIterateCount();

    double getIterateDelta();

    STRefMode$Enum getRefMode();

    boolean isSetCalcCompleted();

    boolean isSetCalcId();

    boolean isSetCalcMode();

    boolean isSetCalcOnSave();

    boolean isSetConcurrentCalc();

    boolean isSetConcurrentManualCount();

    boolean isSetForceFullCalc();

    boolean isSetFullCalcOnLoad();

    boolean isSetFullPrecision();

    boolean isSetIterate();

    boolean isSetIterateCount();

    boolean isSetIterateDelta();

    boolean isSetRefMode();

    void setCalcCompleted(boolean z);

    void setCalcId(long j);

    void setCalcMode(STCalcMode.Enum r1);

    void setCalcOnSave(boolean z);

    void setConcurrentCalc(boolean z);

    void setConcurrentManualCount(long j);

    void setForceFullCalc(boolean z);

    void setFullCalcOnLoad(boolean z);

    void setFullPrecision(boolean z);

    void setIterate(boolean z);

    void setIterateCount(long j);

    void setIterateDelta(double d);

    void setRefMode(STRefMode$Enum sTRefMode$Enum);

    void unsetCalcCompleted();

    void unsetCalcId();

    void unsetCalcMode();

    void unsetCalcOnSave();

    void unsetConcurrentCalc();

    void unsetConcurrentManualCount();

    void unsetForceFullCalc();

    void unsetFullCalcOnLoad();

    void unsetFullPrecision();

    void unsetIterate();

    void unsetIterateCount();

    void unsetIterateDelta();

    void unsetRefMode();

    XmlBoolean xgetCalcCompleted();

    XmlUnsignedInt xgetCalcId();

    STCalcMode xgetCalcMode();

    XmlBoolean xgetCalcOnSave();

    XmlBoolean xgetConcurrentCalc();

    XmlUnsignedInt xgetConcurrentManualCount();

    XmlBoolean xgetForceFullCalc();

    XmlBoolean xgetFullCalcOnLoad();

    XmlBoolean xgetFullPrecision();

    XmlBoolean xgetIterate();

    XmlUnsignedInt xgetIterateCount();

    XmlDouble xgetIterateDelta();

    STRefMode xgetRefMode();

    void xsetCalcCompleted(XmlBoolean xmlBoolean);

    void xsetCalcId(XmlUnsignedInt xmlUnsignedInt);

    void xsetCalcMode(STCalcMode sTCalcMode);

    void xsetCalcOnSave(XmlBoolean xmlBoolean);

    void xsetConcurrentCalc(XmlBoolean xmlBoolean);

    void xsetConcurrentManualCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetForceFullCalc(XmlBoolean xmlBoolean);

    void xsetFullCalcOnLoad(XmlBoolean xmlBoolean);

    void xsetFullPrecision(XmlBoolean xmlBoolean);

    void xsetIterate(XmlBoolean xmlBoolean);

    void xsetIterateCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetIterateDelta(XmlDouble xmlDouble);

    void xsetRefMode(STRefMode sTRefMode);
}
