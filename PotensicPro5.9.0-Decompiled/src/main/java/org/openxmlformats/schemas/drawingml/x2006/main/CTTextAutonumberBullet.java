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
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTextAutonumberBullet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextAutonumberBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextautonumberbulletd602type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextAutonumberBullet newInstance() {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().newInstance(CTTextAutonumberBullet.type, null);
        }

        public static CTTextAutonumberBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().newInstance(CTTextAutonumberBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextAutonumberBullet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(File file) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(file, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(file, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(Reader reader) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(reader, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(reader, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(String str) throws XmlException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(str, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(str, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(URL url) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(url, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(url, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(Node node) throws XmlException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(node, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAutonumberBullet) XmlBeans.getContextTypeLoader().parse(node, CTTextAutonumberBullet.type, xmlOptions);
        }
    }

    int getStartAt();

    STTextAutonumberScheme.Enum getType();

    boolean isSetStartAt();

    void setStartAt(int i);

    void setType(STTextAutonumberScheme.Enum r1);

    void unsetStartAt();

    STTextBulletStartAtNum xgetStartAt();

    STTextAutonumberScheme xgetType();

    void xsetStartAt(STTextBulletStartAtNum sTTextBulletStartAtNum);

    void xsetType(STTextAutonumberScheme sTTextAutonumberScheme);
}
