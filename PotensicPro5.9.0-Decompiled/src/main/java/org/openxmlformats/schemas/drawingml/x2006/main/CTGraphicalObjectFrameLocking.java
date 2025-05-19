package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTGraphicalObjectFrameLocking extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrameLocking.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgraphicalobjectframelocking42adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrameLocking newInstance() {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectFrameLocking.type, null);
        }

        public static CTGraphicalObjectFrameLocking newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameLocking.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(File file) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(String str) throws XmlException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(Node node) throws XmlException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameLocking) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getNoChangeAspect();

    boolean getNoDrilldown();

    boolean getNoGrp();

    boolean getNoMove();

    boolean getNoResize();

    boolean getNoSelect();

    boolean isSetExtLst();

    boolean isSetNoChangeAspect();

    boolean isSetNoDrilldown();

    boolean isSetNoGrp();

    boolean isSetNoMove();

    boolean isSetNoResize();

    boolean isSetNoSelect();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setNoChangeAspect(boolean z);

    void setNoDrilldown(boolean z);

    void setNoGrp(boolean z);

    void setNoMove(boolean z);

    void setNoResize(boolean z);

    void setNoSelect(boolean z);

    void unsetExtLst();

    void unsetNoChangeAspect();

    void unsetNoDrilldown();

    void unsetNoGrp();

    void unsetNoMove();

    void unsetNoResize();

    void unsetNoSelect();

    XmlBoolean xgetNoChangeAspect();

    XmlBoolean xgetNoDrilldown();

    XmlBoolean xgetNoGrp();

    XmlBoolean xgetNoMove();

    XmlBoolean xgetNoResize();

    XmlBoolean xgetNoSelect();

    void xsetNoChangeAspect(XmlBoolean xmlBoolean);

    void xsetNoDrilldown(XmlBoolean xmlBoolean);

    void xsetNoGrp(XmlBoolean xmlBoolean);

    void xsetNoMove(XmlBoolean xmlBoolean);

    void xsetNoResize(XmlBoolean xmlBoolean);

    void xsetNoSelect(XmlBoolean xmlBoolean);
}
