package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTFillStyleList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFillStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfillstylelist959dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFillStyleList newInstance() {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().newInstance(CTFillStyleList.type, null);
        }

        public static CTFillStyleList newInstance(XmlOptions xmlOptions) {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().newInstance(CTFillStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFillStyleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(File file) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(file, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(file, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(Reader reader) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(String str) throws XmlException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(str, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(str, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(URL url) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(url, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(url, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(Node node) throws XmlException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(node, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFillStyleList) XmlBeans.getContextTypeLoader().parse(node, CTFillStyleList.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    CTBlipFillProperties getBlipFillArray(int i);

    CTBlipFillProperties[] getBlipFillArray();

    List<CTBlipFillProperties> getBlipFillList();

    CTGradientFillProperties getGradFillArray(int i);

    CTGradientFillProperties[] getGradFillArray();

    List<CTGradientFillProperties> getGradFillList();

    CTGroupFillProperties getGrpFillArray(int i);

    CTGroupFillProperties[] getGrpFillArray();

    List<CTGroupFillProperties> getGrpFillList();

    CTNoFillProperties getNoFillArray(int i);

    CTNoFillProperties[] getNoFillArray();

    List<CTNoFillProperties> getNoFillList();

    CTPatternFillProperties getPattFillArray(int i);

    CTPatternFillProperties[] getPattFillArray();

    List<CTPatternFillProperties> getPattFillList();

    CTSolidColorFillProperties getSolidFillArray(int i);

    CTSolidColorFillProperties[] getSolidFillArray();

    List<CTSolidColorFillProperties> getSolidFillList();

    CTBlipFillProperties insertNewBlipFill(int i);

    CTGradientFillProperties insertNewGradFill(int i);

    CTGroupFillProperties insertNewGrpFill(int i);

    CTNoFillProperties insertNewNoFill(int i);

    CTPatternFillProperties insertNewPattFill(int i);

    CTSolidColorFillProperties insertNewSolidFill(int i);

    void removeBlipFill(int i);

    void removeGradFill(int i);

    void removeGrpFill(int i);

    void removeNoFill(int i);

    void removePattFill(int i);

    void removeSolidFill(int i);

    void setBlipFillArray(int i, CTBlipFillProperties cTBlipFillProperties);

    void setBlipFillArray(CTBlipFillProperties[] cTBlipFillPropertiesArr);

    void setGradFillArray(int i, CTGradientFillProperties cTGradientFillProperties);

    void setGradFillArray(CTGradientFillProperties[] cTGradientFillPropertiesArr);

    void setGrpFillArray(int i, CTGroupFillProperties cTGroupFillProperties);

    void setGrpFillArray(CTGroupFillProperties[] cTGroupFillPropertiesArr);

    void setNoFillArray(int i, CTNoFillProperties cTNoFillProperties);

    void setNoFillArray(CTNoFillProperties[] cTNoFillPropertiesArr);

    void setPattFillArray(int i, CTPatternFillProperties cTPatternFillProperties);

    void setPattFillArray(CTPatternFillProperties[] cTPatternFillPropertiesArr);

    void setSolidFillArray(int i, CTSolidColorFillProperties cTSolidColorFillProperties);

    void setSolidFillArray(CTSolidColorFillProperties[] cTSolidColorFillPropertiesArr);

    int sizeOfBlipFillArray();

    int sizeOfGradFillArray();

    int sizeOfGrpFillArray();

    int sizeOfNoFillArray();

    int sizeOfPattFillArray();

    int sizeOfSolidFillArray();
}
