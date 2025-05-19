package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPaneState;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPane extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPane.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpaneaab1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPane newInstance() {
            return (CTPane) XmlBeans.getContextTypeLoader().newInstance(CTPane.type, null);
        }

        public static CTPane newInstance(XmlOptions xmlOptions) {
            return (CTPane) XmlBeans.getContextTypeLoader().newInstance(CTPane.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPane.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPane.type, xmlOptions);
        }

        public static CTPane parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPane.type, xmlOptions);
        }

        public static CTPane parse(File file) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(file, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(file, CTPane.type, xmlOptions);
        }

        public static CTPane parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(inputStream, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(inputStream, CTPane.type, xmlOptions);
        }

        public static CTPane parse(Reader reader) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(reader, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(reader, CTPane.type, xmlOptions);
        }

        public static CTPane parse(String str) throws XmlException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(str, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(str, CTPane.type, xmlOptions);
        }

        public static CTPane parse(URL url) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(url, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(url, CTPane.type, xmlOptions);
        }

        public static CTPane parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPane.type, xmlOptions);
        }

        public static CTPane parse(Node node) throws XmlException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(node, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPane) XmlBeans.getContextTypeLoader().parse(node, CTPane.type, xmlOptions);
        }
    }

    STPane.Enum getActivePane();

    STPaneState.Enum getState();

    String getTopLeftCell();

    double getXSplit();

    double getYSplit();

    boolean isSetActivePane();

    boolean isSetState();

    boolean isSetTopLeftCell();

    boolean isSetXSplit();

    boolean isSetYSplit();

    void setActivePane(STPane.Enum r1);

    void setState(STPaneState.Enum r1);

    void setTopLeftCell(String str);

    void setXSplit(double d);

    void setYSplit(double d);

    void unsetActivePane();

    void unsetState();

    void unsetTopLeftCell();

    void unsetXSplit();

    void unsetYSplit();

    STPane xgetActivePane();

    STPaneState xgetState();

    STCellRef xgetTopLeftCell();

    XmlDouble xgetXSplit();

    XmlDouble xgetYSplit();

    void xsetActivePane(STPane sTPane);

    void xsetState(STPaneState sTPaneState);

    void xsetTopLeftCell(STCellRef sTCellRef);

    void xsetXSplit(XmlDouble xmlDouble);

    void xsetYSplit(XmlDouble xmlDouble);
}
