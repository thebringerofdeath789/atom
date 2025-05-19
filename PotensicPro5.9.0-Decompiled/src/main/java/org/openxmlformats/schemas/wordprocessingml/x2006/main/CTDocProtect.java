package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgClass;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STCryptProv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTDocProtect extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDocProtect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdocprotectc611type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocProtect newInstance() {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().newInstance(CTDocProtect.type, null);
        }

        public static CTDocProtect newInstance(XmlOptions xmlOptions) {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().newInstance(CTDocProtect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocProtect.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(File file) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(file, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(file, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(Reader reader) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(reader, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(reader, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(String str) throws XmlException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(str, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(str, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(URL url) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(url, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(url, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocProtect.type, xmlOptions);
        }

        public static CTDocProtect parse(Node node) throws XmlException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(node, CTDocProtect.type, (XmlOptions) null);
        }

        public static CTDocProtect parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDocProtect) XmlBeans.getContextTypeLoader().parse(node, CTDocProtect.type, xmlOptions);
        }
    }

    byte[] getAlgIdExt();

    String getAlgIdExtSource();

    STAlgClass.Enum getCryptAlgorithmClass();

    BigInteger getCryptAlgorithmSid();

    STAlgType.Enum getCryptAlgorithmType();

    String getCryptProvider();

    STCryptProv.Enum getCryptProviderType();

    byte[] getCryptProviderTypeExt();

    String getCryptProviderTypeExtSource();

    BigInteger getCryptSpinCount();

    STDocProtect.Enum getEdit();

    STOnOff.Enum getEnforcement();

    STOnOff.Enum getFormatting();

    byte[] getHash();

    byte[] getSalt();

    boolean isSetAlgIdExt();

    boolean isSetAlgIdExtSource();

    boolean isSetCryptAlgorithmClass();

    boolean isSetCryptAlgorithmSid();

    boolean isSetCryptAlgorithmType();

    boolean isSetCryptProvider();

    boolean isSetCryptProviderType();

    boolean isSetCryptProviderTypeExt();

    boolean isSetCryptProviderTypeExtSource();

    boolean isSetCryptSpinCount();

    boolean isSetEdit();

    boolean isSetEnforcement();

    boolean isSetFormatting();

    boolean isSetHash();

    boolean isSetSalt();

    void setAlgIdExt(byte[] bArr);

    void setAlgIdExtSource(String str);

    void setCryptAlgorithmClass(STAlgClass.Enum r1);

    void setCryptAlgorithmSid(BigInteger bigInteger);

    void setCryptAlgorithmType(STAlgType.Enum r1);

    void setCryptProvider(String str);

    void setCryptProviderType(STCryptProv.Enum r1);

    void setCryptProviderTypeExt(byte[] bArr);

    void setCryptProviderTypeExtSource(String str);

    void setCryptSpinCount(BigInteger bigInteger);

    void setEdit(STDocProtect.Enum r1);

    void setEnforcement(STOnOff.Enum r1);

    void setFormatting(STOnOff.Enum r1);

    void setHash(byte[] bArr);

    void setSalt(byte[] bArr);

    void unsetAlgIdExt();

    void unsetAlgIdExtSource();

    void unsetCryptAlgorithmClass();

    void unsetCryptAlgorithmSid();

    void unsetCryptAlgorithmType();

    void unsetCryptProvider();

    void unsetCryptProviderType();

    void unsetCryptProviderTypeExt();

    void unsetCryptProviderTypeExtSource();

    void unsetCryptSpinCount();

    void unsetEdit();

    void unsetEnforcement();

    void unsetFormatting();

    void unsetHash();

    void unsetSalt();

    STLongHexNumber xgetAlgIdExt();

    STString xgetAlgIdExtSource();

    STAlgClass xgetCryptAlgorithmClass();

    STDecimalNumber xgetCryptAlgorithmSid();

    STAlgType xgetCryptAlgorithmType();

    STString xgetCryptProvider();

    STCryptProv xgetCryptProviderType();

    STLongHexNumber xgetCryptProviderTypeExt();

    STString xgetCryptProviderTypeExtSource();

    STDecimalNumber xgetCryptSpinCount();

    STDocProtect xgetEdit();

    STOnOff xgetEnforcement();

    STOnOff xgetFormatting();

    XmlBase64Binary xgetHash();

    XmlBase64Binary xgetSalt();

    void xsetAlgIdExt(STLongHexNumber sTLongHexNumber);

    void xsetAlgIdExtSource(STString sTString);

    void xsetCryptAlgorithmClass(STAlgClass sTAlgClass);

    void xsetCryptAlgorithmSid(STDecimalNumber sTDecimalNumber);

    void xsetCryptAlgorithmType(STAlgType sTAlgType);

    void xsetCryptProvider(STString sTString);

    void xsetCryptProviderType(STCryptProv sTCryptProv);

    void xsetCryptProviderTypeExt(STLongHexNumber sTLongHexNumber);

    void xsetCryptProviderTypeExtSource(STString sTString);

    void xsetCryptSpinCount(STDecimalNumber sTDecimalNumber);

    void xsetEdit(STDocProtect sTDocProtect);

    void xsetEnforcement(STOnOff sTOnOff);

    void xsetFormatting(STOnOff sTOnOff);

    void xsetHash(XmlBase64Binary xmlBase64Binary);

    void xsetSalt(XmlBase64Binary xmlBase64Binary);
}
