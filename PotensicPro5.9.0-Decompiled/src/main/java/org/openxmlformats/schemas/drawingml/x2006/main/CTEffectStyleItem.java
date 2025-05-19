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
public interface CTEffectStyleItem extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTEffectStyleItem.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cteffectstyleitem05c4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTEffectStyleItem newInstance() {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().newInstance(CTEffectStyleItem.type, null);
        }

        public static CTEffectStyleItem newInstance(XmlOptions xmlOptions) {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().newInstance(CTEffectStyleItem.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEffectStyleItem.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(File file) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(file, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(file, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(inputStream, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(inputStream, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(Reader reader) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(reader, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(reader, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(String str) throws XmlException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(str, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(str, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(URL url) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(url, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(url, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEffectStyleItem.type, xmlOptions);
        }

        public static CTEffectStyleItem parse(Node node) throws XmlException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(node, CTEffectStyleItem.type, (XmlOptions) null);
        }

        public static CTEffectStyleItem parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleItem) XmlBeans.getContextTypeLoader().parse(node, CTEffectStyleItem.type, xmlOptions);
        }
    }

    CTEffectContainer addNewEffectDag();

    CTEffectList addNewEffectLst();

    CTScene3D addNewScene3D();

    CTShape3D addNewSp3D();

    CTEffectContainer getEffectDag();

    CTEffectList getEffectLst();

    CTScene3D getScene3D();

    CTShape3D getSp3D();

    boolean isSetEffectDag();

    boolean isSetEffectLst();

    boolean isSetScene3D();

    boolean isSetSp3D();

    void setEffectDag(CTEffectContainer cTEffectContainer);

    void setEffectLst(CTEffectList cTEffectList);

    void setScene3D(CTScene3D cTScene3D);

    void setSp3D(CTShape3D cTShape3D);

    void unsetEffectDag();

    void unsetEffectLst();

    void unsetScene3D();

    void unsetSp3D();
}
