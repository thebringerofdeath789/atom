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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTStyleMatrix extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTStyleMatrix.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctstylematrix1903type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyleMatrix newInstance() {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().newInstance(CTStyleMatrix.type, null);
        }

        public static CTStyleMatrix newInstance(XmlOptions xmlOptions) {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().newInstance(CTStyleMatrix.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStyleMatrix.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(File file) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(file, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(file, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(inputStream, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(inputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(Reader reader) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(reader, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(reader, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(String str) throws XmlException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(str, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(str, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(URL url) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(url, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(url, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(Node node) throws XmlException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(node, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrix) XmlBeans.getContextTypeLoader().parse(node, CTStyleMatrix.type, xmlOptions);
        }
    }

    CTBackgroundFillStyleList addNewBgFillStyleLst();

    CTEffectStyleList addNewEffectStyleLst();

    CTFillStyleList addNewFillStyleLst();

    CTLineStyleList addNewLnStyleLst();

    CTBackgroundFillStyleList getBgFillStyleLst();

    CTEffectStyleList getEffectStyleLst();

    CTFillStyleList getFillStyleLst();

    CTLineStyleList getLnStyleLst();

    String getName();

    boolean isSetName();

    void setBgFillStyleLst(CTBackgroundFillStyleList cTBackgroundFillStyleList);

    void setEffectStyleLst(CTEffectStyleList cTEffectStyleList);

    void setFillStyleLst(CTFillStyleList cTFillStyleList);

    void setLnStyleLst(CTLineStyleList cTLineStyleList);

    void setName(String str);

    void unsetName();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
