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
public interface CTAlphaModulateFixedEffect extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTAlphaModulateFixedEffect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctalphamodulatefixedeffect9769type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAlphaModulateFixedEffect newInstance() {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().newInstance(CTAlphaModulateFixedEffect.type, null);
        }

        public static CTAlphaModulateFixedEffect newInstance(XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().newInstance(CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAlphaModulateFixedEffect.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(File file) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(file, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(file, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(inputStream, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(inputStream, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(Reader reader) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(reader, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(reader, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(String str) throws XmlException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(str, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(str, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(URL url) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(url, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(url, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(Node node) throws XmlException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(node, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAlphaModulateFixedEffect) XmlBeans.getContextTypeLoader().parse(node, CTAlphaModulateFixedEffect.type, xmlOptions);
        }
    }

    int getAmt();

    boolean isSetAmt();

    void setAmt(int i);

    void unsetAmt();

    STPositivePercentage xgetAmt();

    void xsetAmt(STPositivePercentage sTPositivePercentage);
}
