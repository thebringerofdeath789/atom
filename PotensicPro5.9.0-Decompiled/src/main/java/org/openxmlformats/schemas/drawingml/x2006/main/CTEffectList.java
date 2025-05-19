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
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTEffectList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTEffectList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cteffectlist6featype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEffectList newInstance() {
            return (CTEffectList) XmlBeans.getContextTypeLoader().newInstance(CTEffectList.type, null);
        }

        public static CTEffectList newInstance(XmlOptions xmlOptions) {
            return (CTEffectList) XmlBeans.getContextTypeLoader().newInstance(CTEffectList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEffectList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(File file) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(file, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(file, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(inputStream, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(inputStream, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(Reader reader) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(reader, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(reader, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(String str) throws XmlException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(str, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(str, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(URL url) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(url, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(url, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(Node node) throws XmlException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(node, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectList) XmlBeans.getContextTypeLoader().parse(node, CTEffectList.type, xmlOptions);
        }
    }

    CTBlurEffect addNewBlur();

    CTFillOverlayEffect addNewFillOverlay();

    CTGlowEffect addNewGlow();

    CTInnerShadowEffect addNewInnerShdw();

    CTOuterShadowEffect addNewOuterShdw();

    CTPresetShadowEffect addNewPrstShdw();

    CTReflectionEffect addNewReflection();

    CTSoftEdgesEffect addNewSoftEdge();

    CTBlurEffect getBlur();

    CTFillOverlayEffect getFillOverlay();

    CTGlowEffect getGlow();

    CTInnerShadowEffect getInnerShdw();

    CTOuterShadowEffect getOuterShdw();

    CTPresetShadowEffect getPrstShdw();

    CTReflectionEffect getReflection();

    CTSoftEdgesEffect getSoftEdge();

    boolean isSetBlur();

    boolean isSetFillOverlay();

    boolean isSetGlow();

    boolean isSetInnerShdw();

    boolean isSetOuterShdw();

    boolean isSetPrstShdw();

    boolean isSetReflection();

    boolean isSetSoftEdge();

    void setBlur(CTBlurEffect cTBlurEffect);

    void setFillOverlay(CTFillOverlayEffect cTFillOverlayEffect);

    void setGlow(CTGlowEffect cTGlowEffect);

    void setInnerShdw(CTInnerShadowEffect cTInnerShadowEffect);

    void setOuterShdw(CTOuterShadowEffect cTOuterShadowEffect);

    void setPrstShdw(CTPresetShadowEffect cTPresetShadowEffect);

    void setReflection(CTReflectionEffect cTReflectionEffect);

    void setSoftEdge(CTSoftEdgesEffect cTSoftEdgesEffect);

    void unsetBlur();

    void unsetFillOverlay();

    void unsetGlow();

    void unsetInnerShdw();

    void unsetOuterShdw();

    void unsetPrstShdw();

    void unsetReflection();

    void unsetSoftEdge();
}
