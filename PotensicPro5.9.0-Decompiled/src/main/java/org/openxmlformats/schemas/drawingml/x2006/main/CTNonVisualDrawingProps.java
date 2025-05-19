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
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTNonVisualDrawingProps extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNonVisualDrawingProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnonvisualdrawingprops8fb0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualDrawingProps newInstance() {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualDrawingProps.type, null);
        }

        public static CTNonVisualDrawingProps newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(File file) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(String str) throws XmlException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(URL url) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(Node node) throws XmlException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualDrawingProps.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTHyperlink addNewHlinkClick();

    CTHyperlink addNewHlinkHover();

    String getDescr();

    CTOfficeArtExtensionList getExtLst();

    boolean getHidden();

    CTHyperlink getHlinkClick();

    CTHyperlink getHlinkHover();

    long getId();

    String getName();

    boolean isSetDescr();

    boolean isSetExtLst();

    boolean isSetHidden();

    boolean isSetHlinkClick();

    boolean isSetHlinkHover();

    void setDescr(String str);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setHidden(boolean z);

    void setHlinkClick(CTHyperlink cTHyperlink);

    void setHlinkHover(CTHyperlink cTHyperlink);

    void setId(long j);

    void setName(String str);

    void unsetDescr();

    void unsetExtLst();

    void unsetHidden();

    void unsetHlinkClick();

    void unsetHlinkHover();

    XmlString xgetDescr();

    XmlBoolean xgetHidden();

    STDrawingElementId xgetId();

    XmlString xgetName();

    void xsetDescr(XmlString xmlString);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetId(STDrawingElementId sTDrawingElementId);

    void xsetName(XmlString xmlString);
}
