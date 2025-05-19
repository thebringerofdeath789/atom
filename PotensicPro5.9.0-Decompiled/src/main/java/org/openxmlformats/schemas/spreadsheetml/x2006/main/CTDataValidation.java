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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTDataValidation extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDataValidation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdatavalidation9d0ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDataValidation newInstance() {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().newInstance(CTDataValidation.type, null);
        }

        public static CTDataValidation newInstance(XmlOptions xmlOptions) {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().newInstance(CTDataValidation.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataValidation.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(File file) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(file, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(file, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(Reader reader) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(reader, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(reader, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(String str) throws XmlException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(str, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(str, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(URL url) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(url, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(url, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataValidation.type, xmlOptions);
        }

        public static CTDataValidation parse(Node node) throws XmlException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(node, CTDataValidation.type, (XmlOptions) null);
        }

        public static CTDataValidation parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDataValidation) XmlBeans.getContextTypeLoader().parse(node, CTDataValidation.type, xmlOptions);
        }
    }

    boolean getAllowBlank();

    String getError();

    STDataValidationErrorStyle.Enum getErrorStyle();

    String getErrorTitle();

    String getFormula1();

    String getFormula2();

    STDataValidationImeMode$Enum getImeMode();

    STDataValidationOperator.Enum getOperator();

    String getPrompt();

    String getPromptTitle();

    boolean getShowDropDown();

    boolean getShowErrorMessage();

    boolean getShowInputMessage();

    List getSqref();

    STDataValidationType.Enum getType();

    boolean isSetAllowBlank();

    boolean isSetError();

    boolean isSetErrorStyle();

    boolean isSetErrorTitle();

    boolean isSetFormula1();

    boolean isSetFormula2();

    boolean isSetImeMode();

    boolean isSetOperator();

    boolean isSetPrompt();

    boolean isSetPromptTitle();

    boolean isSetShowDropDown();

    boolean isSetShowErrorMessage();

    boolean isSetShowInputMessage();

    boolean isSetType();

    void setAllowBlank(boolean z);

    void setError(String str);

    void setErrorStyle(STDataValidationErrorStyle.Enum r1);

    void setErrorTitle(String str);

    void setFormula1(String str);

    void setFormula2(String str);

    void setImeMode(STDataValidationImeMode$Enum sTDataValidationImeMode$Enum);

    void setOperator(STDataValidationOperator.Enum r1);

    void setPrompt(String str);

    void setPromptTitle(String str);

    void setShowDropDown(boolean z);

    void setShowErrorMessage(boolean z);

    void setShowInputMessage(boolean z);

    void setSqref(List list);

    void setType(STDataValidationType.Enum r1);

    void unsetAllowBlank();

    void unsetError();

    void unsetErrorStyle();

    void unsetErrorTitle();

    void unsetFormula1();

    void unsetFormula2();

    void unsetImeMode();

    void unsetOperator();

    void unsetPrompt();

    void unsetPromptTitle();

    void unsetShowDropDown();

    void unsetShowErrorMessage();

    void unsetShowInputMessage();

    void unsetType();

    XmlBoolean xgetAllowBlank();

    STXstring xgetError();

    STDataValidationErrorStyle xgetErrorStyle();

    STXstring xgetErrorTitle();

    STFormula xgetFormula1();

    STFormula xgetFormula2();

    STDataValidationImeMode xgetImeMode();

    STDataValidationOperator xgetOperator();

    STXstring xgetPrompt();

    STXstring xgetPromptTitle();

    XmlBoolean xgetShowDropDown();

    XmlBoolean xgetShowErrorMessage();

    XmlBoolean xgetShowInputMessage();

    STSqref xgetSqref();

    STDataValidationType xgetType();

    void xsetAllowBlank(XmlBoolean xmlBoolean);

    void xsetError(STXstring sTXstring);

    void xsetErrorStyle(STDataValidationErrorStyle sTDataValidationErrorStyle);

    void xsetErrorTitle(STXstring sTXstring);

    void xsetFormula1(STFormula sTFormula);

    void xsetFormula2(STFormula sTFormula);

    void xsetImeMode(STDataValidationImeMode sTDataValidationImeMode);

    void xsetOperator(STDataValidationOperator sTDataValidationOperator);

    void xsetPrompt(STXstring sTXstring);

    void xsetPromptTitle(STXstring sTXstring);

    void xsetShowDropDown(XmlBoolean xmlBoolean);

    void xsetShowErrorMessage(XmlBoolean xmlBoolean);

    void xsetShowInputMessage(XmlBoolean xmlBoolean);

    void xsetSqref(STSqref sTSqref);

    void xsetType(STDataValidationType sTDataValidationType);
}
