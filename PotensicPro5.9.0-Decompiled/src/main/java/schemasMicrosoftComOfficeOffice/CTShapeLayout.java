package schemasMicrosoftComOfficeOffice;

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
import schemasMicrosoftComVml.STExt;

/* loaded from: classes6.dex */
public interface CTShapeLayout extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTShapeLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctshapelayoutbda4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapeLayout newInstance() {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().newInstance(CTShapeLayout.type, null);
        }

        public static CTShapeLayout newInstance(XmlOptions xmlOptions) {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().newInstance(CTShapeLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShapeLayout.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(File file) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(file, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(file, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(Reader reader) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(reader, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(reader, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(String str) throws XmlException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(str, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(str, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(URL url) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(url, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(url, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShapeLayout.type, xmlOptions);
        }

        public static CTShapeLayout parse(Node node) throws XmlException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(node, CTShapeLayout.type, (XmlOptions) null);
        }

        public static CTShapeLayout parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeLayout) XmlBeans.getContextTypeLoader().parse(node, CTShapeLayout.type, xmlOptions);
        }
    }

    CTIdMap addNewIdmap();

    CTRegroupTable addNewRegrouptable();

    CTRules addNewRules();

    STExt.Enum getExt();

    CTIdMap getIdmap();

    CTRegroupTable getRegrouptable();

    CTRules getRules();

    boolean isSetExt();

    boolean isSetIdmap();

    boolean isSetRegrouptable();

    boolean isSetRules();

    void setExt(STExt.Enum r1);

    void setIdmap(CTIdMap cTIdMap);

    void setRegrouptable(CTRegroupTable cTRegroupTable);

    void setRules(CTRules cTRules);

    void unsetExt();

    void unsetIdmap();

    void unsetRegrouptable();

    void unsetRules();

    STExt xgetExt();

    void xsetExt(STExt sTExt);
}
