package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPlaceholder extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPlaceholder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctplaceholder9efctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPlaceholder newInstance() {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().newInstance(CTPlaceholder.type, null);
        }

        public static CTPlaceholder newInstance(XmlOptions xmlOptions) {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().newInstance(CTPlaceholder.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPlaceholder.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(File file) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(file, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(file, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(inputStream, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(inputStream, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(Reader reader) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(reader, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(reader, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(String str) throws XmlException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(str, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(str, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(URL url) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(url, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(url, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(Node node) throws XmlException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(node, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPlaceholder) XmlBeans.getContextTypeLoader().parse(node, CTPlaceholder.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTExtensionListModify getExtLst();

    boolean getHasCustomPrompt();

    long getIdx();

    STDirection$Enum getOrient();

    STPlaceholderSize$Enum getSz();

    STPlaceholderType.Enum getType();

    boolean isSetExtLst();

    boolean isSetHasCustomPrompt();

    boolean isSetIdx();

    boolean isSetOrient();

    boolean isSetSz();

    boolean isSetType();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHasCustomPrompt(boolean z);

    void setIdx(long j);

    void setOrient(STDirection$Enum sTDirection$Enum);

    void setSz(STPlaceholderSize$Enum sTPlaceholderSize$Enum);

    void setType(STPlaceholderType.Enum r1);

    void unsetExtLst();

    void unsetHasCustomPrompt();

    void unsetIdx();

    void unsetOrient();

    void unsetSz();

    void unsetType();

    XmlBoolean xgetHasCustomPrompt();

    XmlUnsignedInt xgetIdx();

    STDirection xgetOrient();

    STPlaceholderSize xgetSz();

    STPlaceholderType xgetType();

    void xsetHasCustomPrompt(XmlBoolean xmlBoolean);

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetOrient(STDirection sTDirection);

    void xsetSz(STPlaceholderSize sTPlaceholderSize);

    void xsetType(STPlaceholderType sTPlaceholderType);
}
