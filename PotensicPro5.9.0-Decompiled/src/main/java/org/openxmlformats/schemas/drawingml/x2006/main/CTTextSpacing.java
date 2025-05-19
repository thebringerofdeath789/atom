package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTextSpacing extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextSpacing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextspacingef87type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacing newInstance() {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().newInstance(CTTextSpacing.type, null);
        }

        public static CTTextSpacing newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().newInstance(CTTextSpacing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextSpacing.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(File file) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(file, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(file, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(Reader reader) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(reader, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(reader, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(String str) throws XmlException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(str, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(str, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(URL url) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(url, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(url, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(Node node) throws XmlException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(node, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacing) XmlBeans.getContextTypeLoader().parse(node, CTTextSpacing.type, xmlOptions);
        }
    }

    CTTextSpacingPercent addNewSpcPct();

    CTTextSpacingPoint addNewSpcPts();

    CTTextSpacingPercent getSpcPct();

    CTTextSpacingPoint getSpcPts();

    boolean isSetSpcPct();

    boolean isSetSpcPts();

    void setSpcPct(CTTextSpacingPercent cTTextSpacingPercent);

    void setSpcPts(CTTextSpacingPoint cTTextSpacingPoint);

    void unsetSpcPct();

    void unsetSpcPts();
}
