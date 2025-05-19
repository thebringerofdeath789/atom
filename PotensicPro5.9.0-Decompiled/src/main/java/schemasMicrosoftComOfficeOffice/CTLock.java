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
public interface CTLock extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLock.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlock6b8etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLock newInstance() {
            return (CTLock) XmlBeans.getContextTypeLoader().newInstance(CTLock.type, null);
        }

        public static CTLock newInstance(XmlOptions xmlOptions) {
            return (CTLock) XmlBeans.getContextTypeLoader().newInstance(CTLock.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLock.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLock.type, xmlOptions);
        }

        public static CTLock parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLock.type, xmlOptions);
        }

        public static CTLock parse(File file) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(file, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(file, CTLock.type, xmlOptions);
        }

        public static CTLock parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(inputStream, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(inputStream, CTLock.type, xmlOptions);
        }

        public static CTLock parse(Reader reader) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(reader, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(reader, CTLock.type, xmlOptions);
        }

        public static CTLock parse(String str) throws XmlException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(str, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(str, CTLock.type, xmlOptions);
        }

        public static CTLock parse(URL url) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(url, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(url, CTLock.type, xmlOptions);
        }

        public static CTLock parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLock.type, xmlOptions);
        }

        public static CTLock parse(Node node) throws XmlException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(node, CTLock.type, (XmlOptions) null);
        }

        public static CTLock parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLock) XmlBeans.getContextTypeLoader().parse(node, CTLock.type, xmlOptions);
        }
    }

    STTrueFalse$Enum getAdjusthandles();

    STTrueFalse$Enum getAspectratio();

    STTrueFalse$Enum getCropping();

    STExt.Enum getExt();

    STTrueFalse$Enum getGrouping();

    STTrueFalse$Enum getPosition();

    STTrueFalse$Enum getRotation();

    STTrueFalse$Enum getSelection();

    STTrueFalse$Enum getShapetype();

    STTrueFalse$Enum getText();

    STTrueFalse$Enum getUngrouping();

    STTrueFalse$Enum getVerticies();

    boolean isSetAdjusthandles();

    boolean isSetAspectratio();

    boolean isSetCropping();

    boolean isSetExt();

    boolean isSetGrouping();

    boolean isSetPosition();

    boolean isSetRotation();

    boolean isSetSelection();

    boolean isSetShapetype();

    boolean isSetText();

    boolean isSetUngrouping();

    boolean isSetVerticies();

    void setAdjusthandles(STTrueFalse$Enum sTTrueFalse$Enum);

    void setAspectratio(STTrueFalse$Enum sTTrueFalse$Enum);

    void setCropping(STTrueFalse$Enum sTTrueFalse$Enum);

    void setExt(STExt.Enum r1);

    void setGrouping(STTrueFalse$Enum sTTrueFalse$Enum);

    void setPosition(STTrueFalse$Enum sTTrueFalse$Enum);

    void setRotation(STTrueFalse$Enum sTTrueFalse$Enum);

    void setSelection(STTrueFalse$Enum sTTrueFalse$Enum);

    void setShapetype(STTrueFalse$Enum sTTrueFalse$Enum);

    void setText(STTrueFalse$Enum sTTrueFalse$Enum);

    void setUngrouping(STTrueFalse$Enum sTTrueFalse$Enum);

    void setVerticies(STTrueFalse$Enum sTTrueFalse$Enum);

    void unsetAdjusthandles();

    void unsetAspectratio();

    void unsetCropping();

    void unsetExt();

    void unsetGrouping();

    void unsetPosition();

    void unsetRotation();

    void unsetSelection();

    void unsetShapetype();

    void unsetText();

    void unsetUngrouping();

    void unsetVerticies();

    STTrueFalse xgetAdjusthandles();

    STTrueFalse xgetAspectratio();

    STTrueFalse xgetCropping();

    STExt xgetExt();

    STTrueFalse xgetGrouping();

    STTrueFalse xgetPosition();

    STTrueFalse xgetRotation();

    STTrueFalse xgetSelection();

    STTrueFalse xgetShapetype();

    STTrueFalse xgetText();

    STTrueFalse xgetUngrouping();

    STTrueFalse xgetVerticies();

    void xsetAdjusthandles(STTrueFalse sTTrueFalse);

    void xsetAspectratio(STTrueFalse sTTrueFalse);

    void xsetCropping(STTrueFalse sTTrueFalse);

    void xsetExt(STExt sTExt);

    void xsetGrouping(STTrueFalse sTTrueFalse);

    void xsetPosition(STTrueFalse sTTrueFalse);

    void xsetRotation(STTrueFalse sTTrueFalse);

    void xsetSelection(STTrueFalse sTTrueFalse);

    void xsetShapetype(STTrueFalse sTTrueFalse);

    void xsetText(STTrueFalse sTTrueFalse);

    void xsetUngrouping(STTrueFalse sTTrueFalse);

    void xsetVerticies(STTrueFalse sTTrueFalse);
}
