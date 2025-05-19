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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTRst extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRst.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctrsta472type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRst newInstance() {
            return (CTRst) XmlBeans.getContextTypeLoader().newInstance(CTRst.type, null);
        }

        public static CTRst newInstance(XmlOptions xmlOptions) {
            return (CTRst) XmlBeans.getContextTypeLoader().newInstance(CTRst.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRst.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRst.type, xmlOptions);
        }

        public static CTRst parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRst.type, xmlOptions);
        }

        public static CTRst parse(File file) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(file, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(file, CTRst.type, xmlOptions);
        }

        public static CTRst parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(inputStream, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(inputStream, CTRst.type, xmlOptions);
        }

        public static CTRst parse(Reader reader) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(reader, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(reader, CTRst.type, xmlOptions);
        }

        public static CTRst parse(String str) throws XmlException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(str, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(str, CTRst.type, xmlOptions);
        }

        public static CTRst parse(URL url) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(url, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(url, CTRst.type, xmlOptions);
        }

        public static CTRst parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRst.type, xmlOptions);
        }

        public static CTRst parse(Node node) throws XmlException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(node, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRst) XmlBeans.getContextTypeLoader().parse(node, CTRst.type, xmlOptions);
        }
    }

    CTPhoneticPr addNewPhoneticPr();

    CTRElt addNewR();

    CTPhoneticRun addNewRPh();

    CTPhoneticPr getPhoneticPr();

    CTRElt getRArray(int i);

    CTRElt[] getRArray();

    List<CTRElt> getRList();

    CTPhoneticRun getRPhArray(int i);

    CTPhoneticRun[] getRPhArray();

    List<CTPhoneticRun> getRPhList();

    String getT();

    CTRElt insertNewR(int i);

    CTPhoneticRun insertNewRPh(int i);

    boolean isSetPhoneticPr();

    boolean isSetT();

    void removeR(int i);

    void removeRPh(int i);

    void setPhoneticPr(CTPhoneticPr cTPhoneticPr);

    void setRArray(int i, CTRElt cTRElt);

    void setRArray(CTRElt[] cTREltArr);

    void setRPhArray(int i, CTPhoneticRun cTPhoneticRun);

    void setRPhArray(CTPhoneticRun[] cTPhoneticRunArr);

    void setT(String str);

    int sizeOfRArray();

    int sizeOfRPhArray();

    void unsetPhoneticPr();

    void unsetT();

    STXstring xgetT();

    void xsetT(STXstring sTXstring);
}
