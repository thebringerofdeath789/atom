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
public interface CTScRgbColor extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTScRgbColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctscrgbcolorf3e1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTScRgbColor newInstance() {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().newInstance(CTScRgbColor.type, null);
        }

        public static CTScRgbColor newInstance(XmlOptions xmlOptions) {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().newInstance(CTScRgbColor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScRgbColor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(File file) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(file, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(file, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(inputStream, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(inputStream, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(Reader reader) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(reader, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(reader, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(String str) throws XmlException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(str, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(str, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(URL url) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(url, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(url, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScRgbColor.type, xmlOptions);
        }

        public static CTScRgbColor parse(Node node) throws XmlException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(node, CTScRgbColor.type, (XmlOptions) null);
        }

        public static CTScRgbColor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTScRgbColor) XmlBeans.getContextTypeLoader().parse(node, CTScRgbColor.type, xmlOptions);
        }
    }

    CTPositiveFixedPercentage addNewAlpha();

    CTPositivePercentage addNewAlphaMod();

    CTFixedPercentage addNewAlphaOff();

    CTPercentage addNewBlue();

    CTPercentage addNewBlueMod();

    CTPercentage addNewBlueOff();

    CTComplementTransform addNewComp();

    CTGammaTransform addNewGamma();

    CTGrayscaleTransform addNewGray();

    CTPercentage addNewGreen();

    CTPercentage addNewGreenMod();

    CTPercentage addNewGreenOff();

    CTPositiveFixedAngle addNewHue();

    CTPositivePercentage addNewHueMod();

    CTAngle addNewHueOff();

    CTInverseTransform addNewInv();

    CTInverseGammaTransform addNewInvGamma();

    CTPercentage addNewLum();

    CTPercentage addNewLumMod();

    CTPercentage addNewLumOff();

    CTPercentage addNewRed();

    CTPercentage addNewRedMod();

    CTPercentage addNewRedOff();

    CTPercentage addNewSat();

    CTPercentage addNewSatMod();

    CTPercentage addNewSatOff();

    CTPositiveFixedPercentage addNewShade();

    CTPositiveFixedPercentage addNewTint();

    CTPositiveFixedPercentage getAlphaArray(int i);

    CTPositiveFixedPercentage[] getAlphaArray();

    List<CTPositiveFixedPercentage> getAlphaList();

    CTPositivePercentage getAlphaModArray(int i);

    CTPositivePercentage[] getAlphaModArray();

    List<CTPositivePercentage> getAlphaModList();

    CTFixedPercentage getAlphaOffArray(int i);

    CTFixedPercentage[] getAlphaOffArray();

    List<CTFixedPercentage> getAlphaOffList();

    int getB();

    CTPercentage getBlueArray(int i);

    CTPercentage[] getBlueArray();

    List<CTPercentage> getBlueList();

    CTPercentage getBlueModArray(int i);

    CTPercentage[] getBlueModArray();

    List<CTPercentage> getBlueModList();

    CTPercentage getBlueOffArray(int i);

    CTPercentage[] getBlueOffArray();

    List<CTPercentage> getBlueOffList();

    CTComplementTransform getCompArray(int i);

    CTComplementTransform[] getCompArray();

    List<CTComplementTransform> getCompList();

    int getG();

    CTGammaTransform getGammaArray(int i);

    CTGammaTransform[] getGammaArray();

    List<CTGammaTransform> getGammaList();

    CTGrayscaleTransform getGrayArray(int i);

    CTGrayscaleTransform[] getGrayArray();

    List<CTGrayscaleTransform> getGrayList();

    CTPercentage getGreenArray(int i);

    CTPercentage[] getGreenArray();

    List<CTPercentage> getGreenList();

    CTPercentage getGreenModArray(int i);

    CTPercentage[] getGreenModArray();

    List<CTPercentage> getGreenModList();

    CTPercentage getGreenOffArray(int i);

    CTPercentage[] getGreenOffArray();

    List<CTPercentage> getGreenOffList();

    CTPositiveFixedAngle getHueArray(int i);

    CTPositiveFixedAngle[] getHueArray();

    List<CTPositiveFixedAngle> getHueList();

    CTPositivePercentage getHueModArray(int i);

    CTPositivePercentage[] getHueModArray();

    List<CTPositivePercentage> getHueModList();

    CTAngle getHueOffArray(int i);

    CTAngle[] getHueOffArray();

    List<CTAngle> getHueOffList();

    CTInverseTransform getInvArray(int i);

    CTInverseTransform[] getInvArray();

    CTInverseGammaTransform getInvGammaArray(int i);

    CTInverseGammaTransform[] getInvGammaArray();

    List<CTInverseGammaTransform> getInvGammaList();

    List<CTInverseTransform> getInvList();

    CTPercentage getLumArray(int i);

    CTPercentage[] getLumArray();

    List<CTPercentage> getLumList();

    CTPercentage getLumModArray(int i);

    CTPercentage[] getLumModArray();

    List<CTPercentage> getLumModList();

    CTPercentage getLumOffArray(int i);

    CTPercentage[] getLumOffArray();

    List<CTPercentage> getLumOffList();

    int getR();

    CTPercentage getRedArray(int i);

    CTPercentage[] getRedArray();

    List<CTPercentage> getRedList();

    CTPercentage getRedModArray(int i);

    CTPercentage[] getRedModArray();

    List<CTPercentage> getRedModList();

    CTPercentage getRedOffArray(int i);

    CTPercentage[] getRedOffArray();

    List<CTPercentage> getRedOffList();

    CTPercentage getSatArray(int i);

    CTPercentage[] getSatArray();

    List<CTPercentage> getSatList();

    CTPercentage getSatModArray(int i);

    CTPercentage[] getSatModArray();

    List<CTPercentage> getSatModList();

    CTPercentage getSatOffArray(int i);

    CTPercentage[] getSatOffArray();

    List<CTPercentage> getSatOffList();

    CTPositiveFixedPercentage getShadeArray(int i);

    CTPositiveFixedPercentage[] getShadeArray();

    List<CTPositiveFixedPercentage> getShadeList();

    CTPositiveFixedPercentage getTintArray(int i);

    CTPositiveFixedPercentage[] getTintArray();

    List<CTPositiveFixedPercentage> getTintList();

    CTPositiveFixedPercentage insertNewAlpha(int i);

    CTPositivePercentage insertNewAlphaMod(int i);

    CTFixedPercentage insertNewAlphaOff(int i);

    CTPercentage insertNewBlue(int i);

    CTPercentage insertNewBlueMod(int i);

    CTPercentage insertNewBlueOff(int i);

    CTComplementTransform insertNewComp(int i);

    CTGammaTransform insertNewGamma(int i);

    CTGrayscaleTransform insertNewGray(int i);

    CTPercentage insertNewGreen(int i);

    CTPercentage insertNewGreenMod(int i);

    CTPercentage insertNewGreenOff(int i);

    CTPositiveFixedAngle insertNewHue(int i);

    CTPositivePercentage insertNewHueMod(int i);

    CTAngle insertNewHueOff(int i);

    CTInverseTransform insertNewInv(int i);

    CTInverseGammaTransform insertNewInvGamma(int i);

    CTPercentage insertNewLum(int i);

    CTPercentage insertNewLumMod(int i);

    CTPercentage insertNewLumOff(int i);

    CTPercentage insertNewRed(int i);

    CTPercentage insertNewRedMod(int i);

    CTPercentage insertNewRedOff(int i);

    CTPercentage insertNewSat(int i);

    CTPercentage insertNewSatMod(int i);

    CTPercentage insertNewSatOff(int i);

    CTPositiveFixedPercentage insertNewShade(int i);

    CTPositiveFixedPercentage insertNewTint(int i);

    void removeAlpha(int i);

    void removeAlphaMod(int i);

    void removeAlphaOff(int i);

    void removeBlue(int i);

    void removeBlueMod(int i);

    void removeBlueOff(int i);

    void removeComp(int i);

    void removeGamma(int i);

    void removeGray(int i);

    void removeGreen(int i);

    void removeGreenMod(int i);

    void removeGreenOff(int i);

    void removeHue(int i);

    void removeHueMod(int i);

    void removeHueOff(int i);

    void removeInv(int i);

    void removeInvGamma(int i);

    void removeLum(int i);

    void removeLumMod(int i);

    void removeLumOff(int i);

    void removeRed(int i);

    void removeRedMod(int i);

    void removeRedOff(int i);

    void removeSat(int i);

    void removeSatMod(int i);

    void removeSatOff(int i);

    void removeShade(int i);

    void removeTint(int i);

    void setAlphaArray(int i, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setAlphaArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    void setAlphaModArray(int i, CTPositivePercentage cTPositivePercentage);

    void setAlphaModArray(CTPositivePercentage[] cTPositivePercentageArr);

    void setAlphaOffArray(int i, CTFixedPercentage cTFixedPercentage);

    void setAlphaOffArray(CTFixedPercentage[] cTFixedPercentageArr);

    void setB(int i);

    void setBlueArray(int i, CTPercentage cTPercentage);

    void setBlueArray(CTPercentage[] cTPercentageArr);

    void setBlueModArray(int i, CTPercentage cTPercentage);

    void setBlueModArray(CTPercentage[] cTPercentageArr);

    void setBlueOffArray(int i, CTPercentage cTPercentage);

    void setBlueOffArray(CTPercentage[] cTPercentageArr);

    void setCompArray(int i, CTComplementTransform cTComplementTransform);

    void setCompArray(CTComplementTransform[] cTComplementTransformArr);

    void setG(int i);

    void setGammaArray(int i, CTGammaTransform cTGammaTransform);

    void setGammaArray(CTGammaTransform[] cTGammaTransformArr);

    void setGrayArray(int i, CTGrayscaleTransform cTGrayscaleTransform);

    void setGrayArray(CTGrayscaleTransform[] cTGrayscaleTransformArr);

    void setGreenArray(int i, CTPercentage cTPercentage);

    void setGreenArray(CTPercentage[] cTPercentageArr);

    void setGreenModArray(int i, CTPercentage cTPercentage);

    void setGreenModArray(CTPercentage[] cTPercentageArr);

    void setGreenOffArray(int i, CTPercentage cTPercentage);

    void setGreenOffArray(CTPercentage[] cTPercentageArr);

    void setHueArray(int i, CTPositiveFixedAngle cTPositiveFixedAngle);

    void setHueArray(CTPositiveFixedAngle[] cTPositiveFixedAngleArr);

    void setHueModArray(int i, CTPositivePercentage cTPositivePercentage);

    void setHueModArray(CTPositivePercentage[] cTPositivePercentageArr);

    void setHueOffArray(int i, CTAngle cTAngle);

    void setHueOffArray(CTAngle[] cTAngleArr);

    void setInvArray(int i, CTInverseTransform cTInverseTransform);

    void setInvArray(CTInverseTransform[] cTInverseTransformArr);

    void setInvGammaArray(int i, CTInverseGammaTransform cTInverseGammaTransform);

    void setInvGammaArray(CTInverseGammaTransform[] cTInverseGammaTransformArr);

    void setLumArray(int i, CTPercentage cTPercentage);

    void setLumArray(CTPercentage[] cTPercentageArr);

    void setLumModArray(int i, CTPercentage cTPercentage);

    void setLumModArray(CTPercentage[] cTPercentageArr);

    void setLumOffArray(int i, CTPercentage cTPercentage);

    void setLumOffArray(CTPercentage[] cTPercentageArr);

    void setR(int i);

    void setRedArray(int i, CTPercentage cTPercentage);

    void setRedArray(CTPercentage[] cTPercentageArr);

    void setRedModArray(int i, CTPercentage cTPercentage);

    void setRedModArray(CTPercentage[] cTPercentageArr);

    void setRedOffArray(int i, CTPercentage cTPercentage);

    void setRedOffArray(CTPercentage[] cTPercentageArr);

    void setSatArray(int i, CTPercentage cTPercentage);

    void setSatArray(CTPercentage[] cTPercentageArr);

    void setSatModArray(int i, CTPercentage cTPercentage);

    void setSatModArray(CTPercentage[] cTPercentageArr);

    void setSatOffArray(int i, CTPercentage cTPercentage);

    void setSatOffArray(CTPercentage[] cTPercentageArr);

    void setShadeArray(int i, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setShadeArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    void setTintArray(int i, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setTintArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    int sizeOfAlphaArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaOffArray();

    int sizeOfBlueArray();

    int sizeOfBlueModArray();

    int sizeOfBlueOffArray();

    int sizeOfCompArray();

    int sizeOfGammaArray();

    int sizeOfGrayArray();

    int sizeOfGreenArray();

    int sizeOfGreenModArray();

    int sizeOfGreenOffArray();

    int sizeOfHueArray();

    int sizeOfHueModArray();

    int sizeOfHueOffArray();

    int sizeOfInvArray();

    int sizeOfInvGammaArray();

    int sizeOfLumArray();

    int sizeOfLumModArray();

    int sizeOfLumOffArray();

    int sizeOfRedArray();

    int sizeOfRedModArray();

    int sizeOfRedOffArray();

    int sizeOfSatArray();

    int sizeOfSatModArray();

    int sizeOfSatOffArray();

    int sizeOfShadeArray();

    int sizeOfTintArray();

    STPercentage xgetB();

    STPercentage xgetG();

    STPercentage xgetR();

    void xsetB(STPercentage sTPercentage);

    void xsetG(STPercentage sTPercentage);

    void xsetR(STPercentage sTPercentage);
}
