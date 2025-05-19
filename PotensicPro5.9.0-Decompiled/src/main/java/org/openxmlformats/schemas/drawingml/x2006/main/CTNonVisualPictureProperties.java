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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTNonVisualPictureProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNonVisualPictureProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnonvisualpicturepropertiesee3ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualPictureProperties newInstance() {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualPictureProperties.type, null);
        }

        public static CTNonVisualPictureProperties newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualPictureProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(File file) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(String str) throws XmlException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(URL url) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(Node node) throws XmlException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualPictureProperties) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualPictureProperties.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTPictureLocking addNewPicLocks();

    CTOfficeArtExtensionList getExtLst();

    CTPictureLocking getPicLocks();

    boolean getPreferRelativeResize();

    boolean isSetExtLst();

    boolean isSetPicLocks();

    boolean isSetPreferRelativeResize();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setPicLocks(CTPictureLocking cTPictureLocking);

    void setPreferRelativeResize(boolean z);

    void unsetExtLst();

    void unsetPicLocks();

    void unsetPreferRelativeResize();

    XmlBoolean xgetPreferRelativeResize();

    void xsetPreferRelativeResize(XmlBoolean xmlBoolean);
}
