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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCalcCell extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCalcCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcalccellb960type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCalcCell newInstance() {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().newInstance(CTCalcCell.type, null);
        }

        public static CTCalcCell newInstance(XmlOptions xmlOptions) {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().newInstance(CTCalcCell.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCalcCell.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(File file) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(file, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(file, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(Reader reader) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(reader, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(reader, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(String str) throws XmlException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(str, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(str, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(URL url) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(url, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(url, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCalcCell.type, xmlOptions);
        }

        public static CTCalcCell parse(Node node) throws XmlException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(node, CTCalcCell.type, (XmlOptions) null);
        }

        public static CTCalcCell parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcCell) XmlBeans.getContextTypeLoader().parse(node, CTCalcCell.type, xmlOptions);
        }
    }

    boolean getA();

    int getI();

    boolean getL();

    String getR();

    boolean getS();

    boolean getT();

    boolean isSetA();

    boolean isSetI();

    boolean isSetL();

    boolean isSetS();

    boolean isSetT();

    void setA(boolean z);

    void setI(int i);

    void setL(boolean z);

    void setR(String str);

    void setS(boolean z);

    void setT(boolean z);

    void unsetA();

    void unsetI();

    void unsetL();

    void unsetS();

    void unsetT();

    XmlBoolean xgetA();

    XmlInt xgetI();

    XmlBoolean xgetL();

    STCellRef xgetR();

    XmlBoolean xgetS();

    XmlBoolean xgetT();

    void xsetA(XmlBoolean xmlBoolean);

    void xsetI(XmlInt xmlInt);

    void xsetL(XmlBoolean xmlBoolean);

    void xsetR(STCellRef sTCellRef);

    void xsetS(XmlBoolean xmlBoolean);

    void xsetT(XmlBoolean xmlBoolean);
}
