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
public interface CTFFCheckBox extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFFCheckBox.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctffcheckboxf3a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFFCheckBox newInstance() {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().newInstance(CTFFCheckBox.type, null);
        }

        public static CTFFCheckBox newInstance(XmlOptions xmlOptions) {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().newInstance(CTFFCheckBox.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFFCheckBox.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(File file) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(file, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(file, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(inputStream, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(inputStream, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(Reader reader) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(reader, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(reader, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(String str) throws XmlException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(str, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(str, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(URL url) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(url, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(url, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(Node node) throws XmlException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(node, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFFCheckBox) XmlBeans.getContextTypeLoader().parse(node, CTFFCheckBox.type, xmlOptions);
        }
    }

    CTOnOff addNewChecked();

    CTOnOff addNewDefault();

    CTHpsMeasure addNewSize();

    CTOnOff addNewSizeAuto();

    CTOnOff getChecked();

    CTOnOff getDefault();

    CTHpsMeasure getSize();

    CTOnOff getSizeAuto();

    boolean isSetChecked();

    boolean isSetDefault();

    boolean isSetSize();

    boolean isSetSizeAuto();

    void setChecked(CTOnOff cTOnOff);

    void setDefault(CTOnOff cTOnOff);

    void setSize(CTHpsMeasure cTHpsMeasure);

    void setSizeAuto(CTOnOff cTOnOff);

    void unsetChecked();

    void unsetDefault();

    void unsetSize();

    void unsetSizeAuto();
}
