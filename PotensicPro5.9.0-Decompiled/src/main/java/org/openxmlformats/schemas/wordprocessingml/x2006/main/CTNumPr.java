package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* loaded from: classes6.dex */
public interface CTNumPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNumPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnumpr16aatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumPr newInstance() {
            return (CTNumPr) XmlBeans.getContextTypeLoader().newInstance(CTNumPr.type, null);
        }

        public static CTNumPr newInstance(XmlOptions xmlOptions) {
            return (CTNumPr) XmlBeans.getContextTypeLoader().newInstance(CTNumPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(File file) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(file, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(file, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(Reader reader) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(reader, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(reader, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(String str) throws XmlException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(str, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(str, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(URL url) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(url, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(url, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumPr.type, xmlOptions);
        }

        public static CTNumPr parse(Node node) throws XmlException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(node, CTNumPr.type, (XmlOptions) null);
        }

        public static CTNumPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumPr) XmlBeans.getContextTypeLoader().parse(node, CTNumPr.type, xmlOptions);
        }
    }

    CTDecimalNumber addNewIlvl();

    CTTrackChange addNewIns();

    CTDecimalNumber addNewNumId();

    CTTrackChangeNumbering addNewNumberingChange();

    CTDecimalNumber getIlvl();

    CTTrackChange getIns();

    CTDecimalNumber getNumId();

    CTTrackChangeNumbering getNumberingChange();

    boolean isSetIlvl();

    boolean isSetIns();

    boolean isSetNumId();

    boolean isSetNumberingChange();

    void setIlvl(CTDecimalNumber cTDecimalNumber);

    void setIns(CTTrackChange cTTrackChange);

    void setNumId(CTDecimalNumber cTDecimalNumber);

    void setNumberingChange(CTTrackChangeNumbering cTTrackChangeNumbering);

    void unsetIlvl();

    void unsetIns();

    void unsetNumId();

    void unsetNumberingChange();
}
