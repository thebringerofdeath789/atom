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
public interface CTRelativeRect extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRelativeRect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctrelativerecta4ebtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRelativeRect newInstance() {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().newInstance(CTRelativeRect.type, null);
        }

        public static CTRelativeRect newInstance(XmlOptions xmlOptions) {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().newInstance(CTRelativeRect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelativeRect.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(File file) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(file, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(file, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(Reader reader) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(reader, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(reader, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(String str) throws XmlException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(str, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(str, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(URL url) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(url, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(url, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(Node node) throws XmlException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(node, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRelativeRect) XmlBeans.getContextTypeLoader().parse(node, CTRelativeRect.type, xmlOptions);
        }
    }

    int getB();

    int getL();

    int getR();

    int getT();

    boolean isSetB();

    boolean isSetL();

    boolean isSetR();

    boolean isSetT();

    void setB(int i);

    void setL(int i);

    void setR(int i);

    void setT(int i);

    void unsetB();

    void unsetL();

    void unsetR();

    void unsetT();

    STPercentage xgetB();

    STPercentage xgetL();

    STPercentage xgetR();

    STPercentage xgetT();

    void xsetB(STPercentage sTPercentage);

    void xsetL(STPercentage sTPercentage);

    void xsetR(STPercentage sTPercentage);

    void xsetT(STPercentage sTPercentage);
}
