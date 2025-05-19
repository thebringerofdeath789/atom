package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTWorkbookProtection extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTWorkbookProtection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctworkbookprotection56bctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTWorkbookProtection newInstance() {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().newInstance(CTWorkbookProtection.type, null);
        }

        public static CTWorkbookProtection newInstance(XmlOptions xmlOptions) {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().newInstance(CTWorkbookProtection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTWorkbookProtection.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(File file) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(file, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(file, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(inputStream, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(inputStream, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(Reader reader) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(reader, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(reader, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(String str) throws XmlException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(str, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(str, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(URL url) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(url, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(url, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(Node node) throws XmlException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(node, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookProtection) XmlBeans.getContextTypeLoader().parse(node, CTWorkbookProtection.type, xmlOptions);
        }
    }

    boolean getLockRevision();

    boolean getLockStructure();

    boolean getLockWindows();

    byte[] getRevisionsPassword();

    byte[] getWorkbookPassword();

    boolean isSetLockRevision();

    boolean isSetLockStructure();

    boolean isSetLockWindows();

    boolean isSetRevisionsPassword();

    boolean isSetWorkbookPassword();

    void setLockRevision(boolean z);

    void setLockStructure(boolean z);

    void setLockWindows(boolean z);

    void setRevisionsPassword(byte[] bArr);

    void setWorkbookPassword(byte[] bArr);

    void unsetLockRevision();

    void unsetLockStructure();

    void unsetLockWindows();

    void unsetRevisionsPassword();

    void unsetWorkbookPassword();

    XmlBoolean xgetLockRevision();

    XmlBoolean xgetLockStructure();

    XmlBoolean xgetLockWindows();

    STUnsignedShortHex xgetRevisionsPassword();

    STUnsignedShortHex xgetWorkbookPassword();

    void xsetLockRevision(XmlBoolean xmlBoolean);

    void xsetLockStructure(XmlBoolean xmlBoolean);

    void xsetLockWindows(XmlBoolean xmlBoolean);

    void xsetRevisionsPassword(STUnsignedShortHex sTUnsignedShortHex);

    void xsetWorkbookPassword(STUnsignedShortHex sTUnsignedShortHex);
}
