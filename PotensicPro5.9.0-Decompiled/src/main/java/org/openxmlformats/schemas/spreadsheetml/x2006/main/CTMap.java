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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTMap extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMap.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmap023btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTMap newInstance() {
            return (CTMap) XmlBeans.getContextTypeLoader().newInstance(CTMap.type, null);
        }

        public static CTMap newInstance(XmlOptions xmlOptions) {
            return (CTMap) XmlBeans.getContextTypeLoader().newInstance(CTMap.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMap.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMap.type, xmlOptions);
        }

        public static CTMap parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMap.type, xmlOptions);
        }

        public static CTMap parse(File file) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(file, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(file, CTMap.type, xmlOptions);
        }

        public static CTMap parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(inputStream, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(inputStream, CTMap.type, xmlOptions);
        }

        public static CTMap parse(Reader reader) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(reader, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(reader, CTMap.type, xmlOptions);
        }

        public static CTMap parse(String str) throws XmlException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(str, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(str, CTMap.type, xmlOptions);
        }

        public static CTMap parse(URL url) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(url, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(url, CTMap.type, xmlOptions);
        }

        public static CTMap parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMap.type, xmlOptions);
        }

        public static CTMap parse(Node node) throws XmlException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(node, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMap) XmlBeans.getContextTypeLoader().parse(node, CTMap.type, xmlOptions);
        }
    }

    CTDataBinding addNewDataBinding();

    boolean getAppend();

    boolean getAutoFit();

    CTDataBinding getDataBinding();

    long getID();

    String getName();

    boolean getPreserveFormat();

    boolean getPreserveSortAFLayout();

    String getRootElement();

    String getSchemaID();

    boolean getShowImportExportValidationErrors();

    boolean isSetDataBinding();

    void setAppend(boolean z);

    void setAutoFit(boolean z);

    void setDataBinding(CTDataBinding cTDataBinding);

    void setID(long j);

    void setName(String str);

    void setPreserveFormat(boolean z);

    void setPreserveSortAFLayout(boolean z);

    void setRootElement(String str);

    void setSchemaID(String str);

    void setShowImportExportValidationErrors(boolean z);

    void unsetDataBinding();

    XmlBoolean xgetAppend();

    XmlBoolean xgetAutoFit();

    XmlUnsignedInt xgetID();

    XmlString xgetName();

    XmlBoolean xgetPreserveFormat();

    XmlBoolean xgetPreserveSortAFLayout();

    XmlString xgetRootElement();

    XmlString xgetSchemaID();

    XmlBoolean xgetShowImportExportValidationErrors();

    void xsetAppend(XmlBoolean xmlBoolean);

    void xsetAutoFit(XmlBoolean xmlBoolean);

    void xsetID(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(XmlString xmlString);

    void xsetPreserveFormat(XmlBoolean xmlBoolean);

    void xsetPreserveSortAFLayout(XmlBoolean xmlBoolean);

    void xsetRootElement(XmlString xmlString);

    void xsetSchemaID(XmlString xmlString);

    void xsetShowImportExportValidationErrors(XmlBoolean xmlBoolean);
}
