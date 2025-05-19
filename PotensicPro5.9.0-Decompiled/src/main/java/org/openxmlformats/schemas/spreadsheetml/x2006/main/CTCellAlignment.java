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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STHorizontalAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignment;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCellAlignment extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCellAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcellalignmentb580type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCellAlignment newInstance() {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().newInstance(CTCellAlignment.type, null);
        }

        public static CTCellAlignment newInstance(XmlOptions xmlOptions) {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().newInstance(CTCellAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCellAlignment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(File file) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(file, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(file, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(Reader reader) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(reader, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(reader, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(String str) throws XmlException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(str, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(str, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(URL url) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(url, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(url, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(Node node) throws XmlException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(node, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCellAlignment) XmlBeans.getContextTypeLoader().parse(node, CTCellAlignment.type, xmlOptions);
        }
    }

    STHorizontalAlignment.Enum getHorizontal();

    long getIndent();

    boolean getJustifyLastLine();

    long getReadingOrder();

    int getRelativeIndent();

    boolean getShrinkToFit();

    long getTextRotation();

    STVerticalAlignment.Enum getVertical();

    boolean getWrapText();

    boolean isSetHorizontal();

    boolean isSetIndent();

    boolean isSetJustifyLastLine();

    boolean isSetReadingOrder();

    boolean isSetRelativeIndent();

    boolean isSetShrinkToFit();

    boolean isSetTextRotation();

    boolean isSetVertical();

    boolean isSetWrapText();

    void setHorizontal(STHorizontalAlignment.Enum r1);

    void setIndent(long j);

    void setJustifyLastLine(boolean z);

    void setReadingOrder(long j);

    void setRelativeIndent(int i);

    void setShrinkToFit(boolean z);

    void setTextRotation(long j);

    void setVertical(STVerticalAlignment.Enum r1);

    void setWrapText(boolean z);

    void unsetHorizontal();

    void unsetIndent();

    void unsetJustifyLastLine();

    void unsetReadingOrder();

    void unsetRelativeIndent();

    void unsetShrinkToFit();

    void unsetTextRotation();

    void unsetVertical();

    void unsetWrapText();

    STHorizontalAlignment xgetHorizontal();

    XmlUnsignedInt xgetIndent();

    XmlBoolean xgetJustifyLastLine();

    XmlUnsignedInt xgetReadingOrder();

    XmlInt xgetRelativeIndent();

    XmlBoolean xgetShrinkToFit();

    XmlUnsignedInt xgetTextRotation();

    STVerticalAlignment xgetVertical();

    XmlBoolean xgetWrapText();

    void xsetHorizontal(STHorizontalAlignment sTHorizontalAlignment);

    void xsetIndent(XmlUnsignedInt xmlUnsignedInt);

    void xsetJustifyLastLine(XmlBoolean xmlBoolean);

    void xsetReadingOrder(XmlUnsignedInt xmlUnsignedInt);

    void xsetRelativeIndent(XmlInt xmlInt);

    void xsetShrinkToFit(XmlBoolean xmlBoolean);

    void xsetTextRotation(XmlUnsignedInt xmlUnsignedInt);

    void xsetVertical(STVerticalAlignment sTVerticalAlignment);

    void xsetWrapText(XmlBoolean xmlBoolean);
}
