package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface NotesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(NotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("notes4a02doctype");

    public static final class Factory {
        private Factory() {
        }

        public static NotesDocument newInstance() {
            return (NotesDocument) XmlBeans.getContextTypeLoader().newInstance(NotesDocument.type, null);
        }

        public static NotesDocument newInstance(XmlOptions xmlOptions) {
            return (NotesDocument) XmlBeans.getContextTypeLoader().newInstance(NotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NotesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(File file) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(file, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(file, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(Reader reader) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(reader, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(reader, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(String str) throws XmlException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(str, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(str, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(URL url) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(url, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(url, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NotesDocument.type, xmlOptions);
        }

        public static NotesDocument parse(Node node) throws XmlException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(node, NotesDocument.type, (XmlOptions) null);
        }

        public static NotesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NotesDocument) XmlBeans.getContextTypeLoader().parse(node, NotesDocument.type, xmlOptions);
        }
    }

    CTNotesSlide addNewNotes();

    CTNotesSlide getNotes();

    void setNotes(CTNotesSlide cTNotesSlide);
}
