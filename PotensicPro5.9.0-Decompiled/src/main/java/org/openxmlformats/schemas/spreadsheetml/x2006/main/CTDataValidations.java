package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTDataValidations extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDataValidations.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdatavalidationse46ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDataValidations newInstance() {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().newInstance(CTDataValidations.type, null);
        }

        public static CTDataValidations newInstance(XmlOptions xmlOptions) {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().newInstance(CTDataValidations.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataValidations.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(File file) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(file, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(file, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(Reader reader) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(reader, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(reader, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(String str) throws XmlException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(str, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(str, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(URL url) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(url, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(url, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataValidations.type, xmlOptions);
        }

        public static CTDataValidations parse(Node node) throws XmlException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(node, CTDataValidations.type, (XmlOptions) null);
        }

        public static CTDataValidations parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDataValidations) XmlBeans.getContextTypeLoader().parse(node, CTDataValidations.type, xmlOptions);
        }
    }

    CTDataValidation addNewDataValidation();

    long getCount();

    CTDataValidation getDataValidationArray(int i);

    CTDataValidation[] getDataValidationArray();

    List<CTDataValidation> getDataValidationList();

    boolean getDisablePrompts();

    long getXWindow();

    long getYWindow();

    CTDataValidation insertNewDataValidation(int i);

    boolean isSetCount();

    boolean isSetDisablePrompts();

    boolean isSetXWindow();

    boolean isSetYWindow();

    void removeDataValidation(int i);

    void setCount(long j);

    void setDataValidationArray(int i, CTDataValidation cTDataValidation);

    void setDataValidationArray(CTDataValidation[] cTDataValidationArr);

    void setDisablePrompts(boolean z);

    void setXWindow(long j);

    void setYWindow(long j);

    int sizeOfDataValidationArray();

    void unsetCount();

    void unsetDisablePrompts();

    void unsetXWindow();

    void unsetYWindow();

    XmlUnsignedInt xgetCount();

    XmlBoolean xgetDisablePrompts();

    XmlUnsignedInt xgetXWindow();

    XmlUnsignedInt xgetYWindow();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetDisablePrompts(XmlBoolean xmlBoolean);

    void xsetXWindow(XmlUnsignedInt xmlUnsignedInt);

    void xsetYWindow(XmlUnsignedInt xmlUnsignedInt);
}
