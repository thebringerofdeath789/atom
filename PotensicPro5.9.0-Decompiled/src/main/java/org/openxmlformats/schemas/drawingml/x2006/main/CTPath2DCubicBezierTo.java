package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTPath2DCubicBezierTo extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPath2DCubicBezierTo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpath2dcubicbezierto5a1etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DCubicBezierTo newInstance() {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().newInstance(CTPath2DCubicBezierTo.type, null);
        }

        public static CTPath2DCubicBezierTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().newInstance(CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DCubicBezierTo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(File file) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(file, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(file, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(String str) throws XmlException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(str, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(str, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(URL url) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(url, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(url, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(Node node) throws XmlException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(node, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DCubicBezierTo) XmlBeans.getContextTypeLoader().parse(node, CTPath2DCubicBezierTo.type, xmlOptions);
        }
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPtArray(int i);

    CTAdjPoint2D[] getPtArray();

    List<CTAdjPoint2D> getPtList();

    CTAdjPoint2D insertNewPt(int i);

    void removePt(int i);

    void setPtArray(int i, CTAdjPoint2D cTAdjPoint2D);

    void setPtArray(CTAdjPoint2D[] cTAdjPoint2DArr);

    int sizeOfPtArray();
}
