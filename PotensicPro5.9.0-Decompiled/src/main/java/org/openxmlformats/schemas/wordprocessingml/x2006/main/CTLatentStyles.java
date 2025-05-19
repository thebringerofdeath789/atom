package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTLatentStyles extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLatentStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlatentstyles2e3atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLatentStyles newInstance() {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().newInstance(CTLatentStyles.type, null);
        }

        public static CTLatentStyles newInstance(XmlOptions xmlOptions) {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().newInstance(CTLatentStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLatentStyles.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(File file) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(file, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(file, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(Reader reader) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(reader, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(reader, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(String str) throws XmlException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(str, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(str, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(URL url) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(url, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(url, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLatentStyles.type, xmlOptions);
        }

        public static CTLatentStyles parse(Node node) throws XmlException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(node, CTLatentStyles.type, (XmlOptions) null);
        }

        public static CTLatentStyles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLatentStyles) XmlBeans.getContextTypeLoader().parse(node, CTLatentStyles.type, xmlOptions);
        }
    }

    CTLsdException addNewLsdException();

    BigInteger getCount();

    STOnOff.Enum getDefLockedState();

    STOnOff.Enum getDefQFormat();

    STOnOff.Enum getDefSemiHidden();

    BigInteger getDefUIPriority();

    STOnOff.Enum getDefUnhideWhenUsed();

    CTLsdException getLsdExceptionArray(int i);

    CTLsdException[] getLsdExceptionArray();

    List<CTLsdException> getLsdExceptionList();

    CTLsdException insertNewLsdException(int i);

    boolean isSetCount();

    boolean isSetDefLockedState();

    boolean isSetDefQFormat();

    boolean isSetDefSemiHidden();

    boolean isSetDefUIPriority();

    boolean isSetDefUnhideWhenUsed();

    void removeLsdException(int i);

    void setCount(BigInteger bigInteger);

    void setDefLockedState(STOnOff.Enum r1);

    void setDefQFormat(STOnOff.Enum r1);

    void setDefSemiHidden(STOnOff.Enum r1);

    void setDefUIPriority(BigInteger bigInteger);

    void setDefUnhideWhenUsed(STOnOff.Enum r1);

    void setLsdExceptionArray(int i, CTLsdException cTLsdException);

    void setLsdExceptionArray(CTLsdException[] cTLsdExceptionArr);

    int sizeOfLsdExceptionArray();

    void unsetCount();

    void unsetDefLockedState();

    void unsetDefQFormat();

    void unsetDefSemiHidden();

    void unsetDefUIPriority();

    void unsetDefUnhideWhenUsed();

    STDecimalNumber xgetCount();

    STOnOff xgetDefLockedState();

    STOnOff xgetDefQFormat();

    STOnOff xgetDefSemiHidden();

    STDecimalNumber xgetDefUIPriority();

    STOnOff xgetDefUnhideWhenUsed();

    void xsetCount(STDecimalNumber sTDecimalNumber);

    void xsetDefLockedState(STOnOff sTOnOff);

    void xsetDefQFormat(STOnOff sTOnOff);

    void xsetDefSemiHidden(STOnOff sTOnOff);

    void xsetDefUIPriority(STDecimalNumber sTDecimalNumber);

    void xsetDefUnhideWhenUsed(STOnOff sTOnOff);
}
