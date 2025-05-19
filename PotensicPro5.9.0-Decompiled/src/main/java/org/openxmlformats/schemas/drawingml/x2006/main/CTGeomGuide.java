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
public interface CTGeomGuide extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGeomGuide.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgeomguidef191type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomGuide newInstance() {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().newInstance(CTGeomGuide.type, null);
        }

        public static CTGeomGuide newInstance(XmlOptions xmlOptions) {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().newInstance(CTGeomGuide.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGeomGuide.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(File file) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(file, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(file, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(inputStream, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(inputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(Reader reader) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(reader, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(reader, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(String str) throws XmlException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(str, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(str, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(URL url) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(url, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(url, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(Node node) throws XmlException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(node, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuide) XmlBeans.getContextTypeLoader().parse(node, CTGeomGuide.type, xmlOptions);
        }
    }

    String getFmla();

    String getName();

    void setFmla(String str);

    void setName(String str);

    STGeomGuideFormula xgetFmla();

    STGeomGuideName xgetName();

    void xsetFmla(STGeomGuideFormula sTGeomGuideFormula);

    void xsetName(STGeomGuideName sTGeomGuideName);
}
