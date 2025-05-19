package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface SingleXmlCellsDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SingleXmlCellsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("singlexmlcells33bfdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SingleXmlCellsDocument newInstance() {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().newInstance(SingleXmlCellsDocument.type, null);
        }

        public static SingleXmlCellsDocument newInstance(XmlOptions xmlOptions) {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().newInstance(SingleXmlCellsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SingleXmlCellsDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(File file) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(file, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(file, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(Reader reader) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(reader, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(reader, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(String str) throws XmlException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(str, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(str, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(URL url) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(url, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(url, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(Node node) throws XmlException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(node, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SingleXmlCellsDocument) XmlBeans.getContextTypeLoader().parse(node, SingleXmlCellsDocument.type, xmlOptions);
        }
    }

    CTSingleXmlCells addNewSingleXmlCells();

    CTSingleXmlCells getSingleXmlCells();

    void setSingleXmlCells(CTSingleXmlCells cTSingleXmlCells);
}
