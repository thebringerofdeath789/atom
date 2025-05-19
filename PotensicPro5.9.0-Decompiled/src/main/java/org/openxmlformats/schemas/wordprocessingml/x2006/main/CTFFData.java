package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTFFData extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFFData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctffdataaa7etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFFData newInstance() {
            return (CTFFData) XmlBeans.getContextTypeLoader().newInstance(CTFFData.type, null);
        }

        public static CTFFData newInstance(XmlOptions xmlOptions) {
            return (CTFFData) XmlBeans.getContextTypeLoader().newInstance(CTFFData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFFData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(File file) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(file, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(file, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(inputStream, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(inputStream, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(Reader reader) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(reader, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(reader, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(String str) throws XmlException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(str, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(str, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(URL url) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(url, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(url, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(Node node) throws XmlException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(node, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFFData) XmlBeans.getContextTypeLoader().parse(node, CTFFData.type, xmlOptions);
        }
    }

    CTOnOff addNewCalcOnExit();

    CTFFCheckBox addNewCheckBox();

    CTFFDDList addNewDdList();

    CTOnOff addNewEnabled();

    CTMacroName addNewEntryMacro();

    CTMacroName addNewExitMacro();

    CTFFHelpText addNewHelpText();

    CTFFName addNewName();

    CTFFStatusText addNewStatusText();

    CTFFTextInput addNewTextInput();

    CTOnOff getCalcOnExitArray(int i);

    CTOnOff[] getCalcOnExitArray();

    List<CTOnOff> getCalcOnExitList();

    CTFFCheckBox getCheckBoxArray(int i);

    CTFFCheckBox[] getCheckBoxArray();

    List<CTFFCheckBox> getCheckBoxList();

    CTFFDDList getDdListArray(int i);

    CTFFDDList[] getDdListArray();

    List<CTFFDDList> getDdListList();

    CTOnOff getEnabledArray(int i);

    CTOnOff[] getEnabledArray();

    List<CTOnOff> getEnabledList();

    CTMacroName getEntryMacroArray(int i);

    CTMacroName[] getEntryMacroArray();

    List<CTMacroName> getEntryMacroList();

    CTMacroName getExitMacroArray(int i);

    CTMacroName[] getExitMacroArray();

    List<CTMacroName> getExitMacroList();

    CTFFHelpText getHelpTextArray(int i);

    CTFFHelpText[] getHelpTextArray();

    List<CTFFHelpText> getHelpTextList();

    CTFFName getNameArray(int i);

    CTFFName[] getNameArray();

    List<CTFFName> getNameList();

    CTFFStatusText getStatusTextArray(int i);

    CTFFStatusText[] getStatusTextArray();

    List<CTFFStatusText> getStatusTextList();

    CTFFTextInput getTextInputArray(int i);

    CTFFTextInput[] getTextInputArray();

    List<CTFFTextInput> getTextInputList();

    CTOnOff insertNewCalcOnExit(int i);

    CTFFCheckBox insertNewCheckBox(int i);

    CTFFDDList insertNewDdList(int i);

    CTOnOff insertNewEnabled(int i);

    CTMacroName insertNewEntryMacro(int i);

    CTMacroName insertNewExitMacro(int i);

    CTFFHelpText insertNewHelpText(int i);

    CTFFName insertNewName(int i);

    CTFFStatusText insertNewStatusText(int i);

    CTFFTextInput insertNewTextInput(int i);

    void removeCalcOnExit(int i);

    void removeCheckBox(int i);

    void removeDdList(int i);

    void removeEnabled(int i);

    void removeEntryMacro(int i);

    void removeExitMacro(int i);

    void removeHelpText(int i);

    void removeName(int i);

    void removeStatusText(int i);

    void removeTextInput(int i);

    void setCalcOnExitArray(int i, CTOnOff cTOnOff);

    void setCalcOnExitArray(CTOnOff[] cTOnOffArr);

    void setCheckBoxArray(int i, CTFFCheckBox cTFFCheckBox);

    void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr);

    void setDdListArray(int i, CTFFDDList cTFFDDList);

    void setDdListArray(CTFFDDList[] cTFFDDListArr);

    void setEnabledArray(int i, CTOnOff cTOnOff);

    void setEnabledArray(CTOnOff[] cTOnOffArr);

    void setEntryMacroArray(int i, CTMacroName cTMacroName);

    void setEntryMacroArray(CTMacroName[] cTMacroNameArr);

    void setExitMacroArray(int i, CTMacroName cTMacroName);

    void setExitMacroArray(CTMacroName[] cTMacroNameArr);

    void setHelpTextArray(int i, CTFFHelpText cTFFHelpText);

    void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr);

    void setNameArray(int i, CTFFName cTFFName);

    void setNameArray(CTFFName[] cTFFNameArr);

    void setStatusTextArray(int i, CTFFStatusText cTFFStatusText);

    void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr);

    void setTextInputArray(int i, CTFFTextInput cTFFTextInput);

    void setTextInputArray(CTFFTextInput[] cTFFTextInputArr);

    int sizeOfCalcOnExitArray();

    int sizeOfCheckBoxArray();

    int sizeOfDdListArray();

    int sizeOfEnabledArray();

    int sizeOfEntryMacroArray();

    int sizeOfExitMacroArray();

    int sizeOfHelpTextArray();

    int sizeOfNameArray();

    int sizeOfStatusTextArray();

    int sizeOfTextInputArray();
}
