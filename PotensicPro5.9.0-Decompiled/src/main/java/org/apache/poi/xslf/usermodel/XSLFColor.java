package org.apache.poi.xslf.usermodel;

import com.google.android.exoplayer2.audio.AacUtil;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.nntp.NNTPReply;
import org.apache.commons.net.telnet.TelnetCommand;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.usermodel.HSSFShapeTypes;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.w3c.dom.Node;

@Internal
/* loaded from: classes5.dex */
public class XSLFColor {
    static final Map<String, Color> presetColors;
    private Color _color;
    private CTSchemeColor _phClr;
    private XmlObject _xmlObject;

    public XSLFColor(XmlObject xmlObject, XSLFTheme xSLFTheme, CTSchemeColor cTSchemeColor) {
        this._xmlObject = xmlObject;
        this._phClr = cTSchemeColor;
        this._color = toColor(xmlObject, xSLFTheme);
    }

    @Internal
    public XmlObject getXmlObject() {
        return this._xmlObject;
    }

    public Color getColor() {
        Color color = this._color;
        if (color == null) {
            return null;
        }
        return applyColorTransform(color);
    }

    private Color applyColorTransform(Color color) {
        if (getAlpha() != -1) {
            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.round(r0 * 255 * 0.01f));
        }
        int lumOff = getLumOff();
        int lumMod = getLumMod();
        if (lumMod != -1 || lumOff != -1) {
            if (lumMod == -1) {
                lumMod = 100;
            }
            if (lumOff == -1) {
                lumOff = 0;
            }
            color = modulateLuminanace(color, lumMod, lumOff);
        }
        int shade = getShade();
        if (shade != -1) {
            color = shade(color, shade);
        }
        int tint = getTint();
        return tint != -1 ? tint(color, tint) : color;
    }

    Color toColor(XmlObject xmlObject, XSLFTheme xSLFTheme) {
        Color color;
        Color color2 = null;
        for (XmlObject xmlObject2 : xmlObject.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            if (xmlObject2 instanceof CTHslColor) {
                CTHslColor cTHslColor = (CTHslColor) xmlObject2;
                color2 = Color.getHSBColor(cTHslColor.getHue2() / 60000.0f, cTHslColor.getSat2() / 100000.0f, cTHslColor.getLum2() / 100000.0f);
            } else if (xmlObject2 instanceof CTPresetColor) {
                color2 = presetColors.get(((CTPresetColor) xmlObject2).getVal().toString());
            } else if (xmlObject2 instanceof CTSchemeColor) {
                String str = ((CTSchemeColor) xmlObject2).getVal().toString();
                CTSchemeColor cTSchemeColor = this._phClr;
                if (cTSchemeColor != null) {
                    str = cTSchemeColor.getVal().toString();
                }
                CTColor cTColor = xSLFTheme.getCTColor(str);
                if (cTColor != null) {
                    color2 = toColor(cTColor, null);
                }
            } else if (xmlObject2 instanceof CTScRgbColor) {
                CTScRgbColor cTScRgbColor = (CTScRgbColor) xmlObject2;
                color2 = new Color((cTScRgbColor.getR() * 255) / AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, (cTScRgbColor.getG() * 255) / AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, (cTScRgbColor.getB() * 255) / AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
            } else {
                if (xmlObject2 instanceof CTSRgbColor) {
                    byte[] val = ((CTSRgbColor) xmlObject2).getVal();
                    color = new Color(val[0] & 255, val[1] & 255, val[2] & 255);
                } else if (xmlObject2 instanceof CTSystemColor) {
                    CTSystemColor cTSystemColor = (CTSystemColor) xmlObject2;
                    if (cTSystemColor.isSetLastClr()) {
                        byte[] lastClr = cTSystemColor.getLastClr();
                        color = new Color(lastClr[0] & 255, lastClr[1] & 255, lastClr[2] & 255);
                    } else {
                        cTSystemColor.getVal().toString();
                        color = Color.black;
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected color choice: " + xmlObject2.getClass());
                }
                color2 = color;
            }
        }
        return color2;
    }

    private int getPercentageValue(String str) {
        Node namedItem;
        Node namedItem2;
        String str2 = "declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' $this//a:" + str;
        CTSchemeColor cTSchemeColor = this._phClr;
        if (cTSchemeColor != null) {
            XmlObject[] selectPath = cTSchemeColor.selectPath(str2);
            if (selectPath.length == 1 && (namedItem2 = selectPath[0].getDomNode().getAttributes().getNamedItem("val")) != null) {
                return Integer.parseInt(namedItem2.getNodeValue()) / 1000;
            }
        }
        XmlObject[] selectPath2 = this._xmlObject.selectPath(str2);
        if (selectPath2.length != 1 || (namedItem = selectPath2[0].getDomNode().getAttributes().getNamedItem("val")) == null) {
            return -1;
        }
        return Integer.parseInt(namedItem.getNodeValue()) / 1000;
    }

    private int getAngleValue(String str) {
        Node namedItem;
        Node namedItem2;
        String str2 = "declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' $this//a:" + str;
        if (this._phClr != null) {
            XmlObject[] selectPath = this._xmlObject.selectPath(str2);
            if (selectPath.length == 1 && (namedItem2 = selectPath[0].getDomNode().getAttributes().getNamedItem("val")) != null) {
                return Integer.parseInt(namedItem2.getNodeValue()) / 60000;
            }
        }
        XmlObject[] selectPath2 = this._xmlObject.selectPath(str2);
        if (selectPath2.length != 1 || (namedItem = selectPath2[0].getDomNode().getAttributes().getNamedItem("val")) == null) {
            return -1;
        }
        return Integer.parseInt(namedItem.getNodeValue()) / 60000;
    }

    int getAlpha() {
        return getPercentageValue("alpha");
    }

    int getAlphaMod() {
        return getPercentageValue("alphaMod");
    }

    int getAlphaOff() {
        return getPercentageValue("alphaOff");
    }

    int getHue() {
        return getAngleValue("hue");
    }

    int getHueMod() {
        return getPercentageValue("hueMod");
    }

    int getHueOff() {
        return getPercentageValue("hueOff");
    }

    int getLum() {
        return getPercentageValue("lum");
    }

    int getLumMod() {
        return getPercentageValue("lumMod");
    }

    int getLumOff() {
        return getPercentageValue("lumOff");
    }

    int getSat() {
        return getPercentageValue("sat");
    }

    int getSatMod() {
        return getPercentageValue("satMod");
    }

    int getSatOff() {
        return getPercentageValue("satOff");
    }

    int getRed() {
        return getPercentageValue("red");
    }

    int getRedMod() {
        return getPercentageValue("redMod");
    }

    int getRedOff() {
        return getPercentageValue("redOff");
    }

    int getGreen() {
        return getPercentageValue("green");
    }

    int getGreenMod() {
        return getPercentageValue("greenMod");
    }

    int getGreenOff() {
        return getPercentageValue("greenOff");
    }

    int getBlue() {
        return getPercentageValue("blue");
    }

    int getBlueMod() {
        return getPercentageValue("blueMod");
    }

    int getBlueOff() {
        return getPercentageValue("blueOff");
    }

    int getShade() {
        return getPercentageValue("shade");
    }

    int getTint() {
        return getPercentageValue("tint");
    }

    private static Color modulateLuminanace(Color color, int i, int i2) {
        if (i2 > 0) {
            return new Color((int) Math.round((((255 - color.getRed()) * (100.0d - i)) / 100.0d) + color.getRed()), (int) Math.round((((255 - color.getGreen()) * i2) / 100.0d) + color.getGreen()), (int) Math.round((((255 - color.getBlue()) * i2) / 100.0d) + color.getBlue()), color.getAlpha());
        }
        return new Color((int) Math.round((color.getRed() * i) / 100.0d), (int) Math.round((color.getGreen() * i) / 100.0d), (int) Math.round((color.getBlue() * i) / 100.0d), color.getAlpha());
    }

    private static Color shade(Color color, int i) {
        return new Color((int) (color.getRed() * i * 0.01d), (int) (color.getGreen() * i * 0.01d), (int) (color.getBlue() * i * 0.01d), color.getAlpha());
    }

    private static Color tint(Color color, int i) {
        float f = i / 100.0f;
        float f2 = (1.0f - f) * 255.0f;
        return new Color(Math.round((color.getRed() * f) + f2), Math.round((color.getGreen() * f) + f2), Math.round((f * color.getBlue()) + f2));
    }

    static {
        HashMap hashMap = new HashMap();
        presetColors = hashMap;
        hashMap.put("aliceBlue", new Color(240, TelnetCommand.EL, 255));
        hashMap.put("antiqueWhite", new Color(250, 235, FTPReply.NAME_SYSTEM_TYPE));
        hashMap.put("aqua", new Color(0, 255, 255));
        hashMap.put("aquamarine", new Color(127, 255, FTPReply.DIRECTORY_STATUS));
        hashMap.put("azure", new Color(240, 255, 255));
        hashMap.put("beige", new Color(TelnetCommand.AO, TelnetCommand.AO, 220));
        hashMap.put("bisque", new Color(255, 228, HSSFShapeTypes.ActionButtonBeginning));
        hashMap.put("black", new Color(0, 0, 0));
        hashMap.put("blanchedAlmond", new Color(255, 235, NNTPReply.CLOSING_CONNECTION));
        hashMap.put("blue", new Color(0, 0, 255));
        hashMap.put("blueViolet", new Color(138, 43, FTPReply.CLOSING_DATA_CONNECTION));
        hashMap.put("brown", new Color(165, 42, 42));
        hashMap.put("burlyWood", new Color(NNTPReply.ARTICLE_RETRIEVED_BODY_FOLLOWS, 184, 135));
        hashMap.put("cadetBlue", new Color(95, 158, 160));
        hashMap.put("chartreuse", new Color(127, 255, 0));
        hashMap.put("chocolate", new Color(210, 105, 30));
        hashMap.put("coral", new Color(255, 127, 80));
        hashMap.put("cornflowerBlue", new Color(100, 149, TelnetCommand.SUSP));
        hashMap.put("crimson", new Color(220, 20, 60));
        hashMap.put("cyan", new Color(0, 255, 255));
        hashMap.put("deepPink", new Color(255, 20, 147));
        hashMap.put("deepSkyBlue", new Color(0, 191, 255));
        hashMap.put("dimGray", new Color(105, 105, 105));
        hashMap.put("dkBlue", new Color(0, 0, 139));
        hashMap.put("dkCyan", new Color(0, 139, 139));
        hashMap.put("dkGoldenrod", new Color(184, 134, 11));
        hashMap.put("dkGray", new Color(169, 169, 169));
        hashMap.put("dkGreen", new Color(0, 100, 0));
        hashMap.put("dkKhaki", new Color(189, 183, 107));
        hashMap.put("dkMagenta", new Color(139, 0, 139));
        hashMap.put("dkOliveGreen", new Color(85, 107, 47));
        hashMap.put("dkOrange", new Color(255, 140, 0));
        hashMap.put("dkOrchid", new Color(153, 50, 204));
        hashMap.put("dkRed", new Color(139, 0, 0));
        hashMap.put("dkSalmon", new Color(UnknownRecord.BITMAP_00E9, 150, 122));
        hashMap.put("dkSeaGreen", new Color(143, 188, 139));
        hashMap.put("dkSlateBlue", new Color(72, 61, 139));
        hashMap.put("dkSlateGray", new Color(47, 79, 79));
        hashMap.put("dkTurquoise", new Color(0, 206, 209));
        hashMap.put("dkViolet", new Color(148, 0, 211));
        hashMap.put("dodgerBlue", new Color(30, 144, 255));
        hashMap.put("firebrick", new Color(178, 34, 34));
        hashMap.put("floralWhite", new Color(255, 250, 240));
        hashMap.put("forestGreen", new Color(34, 139, 34));
        hashMap.put("fuchsia", new Color(255, 0, 255));
        hashMap.put("gainsboro", new Color(220, 220, 220));
        hashMap.put("ghostWhite", new Color(TelnetCommand.EL, TelnetCommand.EL, 255));
        hashMap.put("gold", new Color(255, FTPReply.NAME_SYSTEM_TYPE, 0));
        hashMap.put("goldenrod", new Color(218, 165, 32));
        hashMap.put("gray", new Color(128, 128, 128));
        hashMap.put("green", new Color(0, 128, 0));
        hashMap.put("greenYellow", new Color(173, 255, 47));
        hashMap.put("honeydew", new Color(240, 255, 240));
        hashMap.put("hotPink", new Color(255, 105, 180));
        hashMap.put("indianRed", new Color(NNTPReply.CLOSING_CONNECTION, 92, 92));
        hashMap.put("indigo", new Color(75, 0, 130));
        hashMap.put("ivory", new Color(255, 255, 240));
        hashMap.put("khaki", new Color(240, 230, 140));
        hashMap.put("lavender", new Color(230, 230, 250));
        hashMap.put("lavenderBlush", new Color(255, 240, TelnetCommand.AO));
        hashMap.put("lawnGreen", new Color(124, TelnetCommand.WONT, 0));
        hashMap.put("lemonChiffon", new Color(255, 250, NNTPReply.CLOSING_CONNECTION));
        hashMap.put("lime", new Color(0, 255, 0));
        hashMap.put("limeGreen", new Color(50, NNTPReply.CLOSING_CONNECTION, 50));
        hashMap.put("linen", new Color(250, 240, 230));
        hashMap.put("ltBlue", new Color(173, 216, 230));
        hashMap.put("ltCoral", new Color(240, 128, 128));
        hashMap.put("ltCyan", new Color(224, 255, 255));
        hashMap.put("ltGoldenrodYellow", new Color(250, 250, 120));
        hashMap.put("ltGray", new Color(211, 211, 211));
        hashMap.put("ltGreen", new Color(144, TelnetCommand.ABORT, 144));
        hashMap.put("ltPink", new Color(255, 182, 193));
        hashMap.put("ltSalmon", new Color(255, 160, 122));
        hashMap.put("ltSeaGreen", new Color(32, 178, 170));
        hashMap.put("ltSkyBlue", new Color(135, 206, 250));
        hashMap.put("ltSlateGray", new Color(119, 136, 153));
        hashMap.put("ltSteelBlue", new Color(176, HSSFShapeTypes.ActionButtonBeginning, NNTPReply.ARTICLE_RETRIEVED_BODY_FOLLOWS));
        hashMap.put("ltYellow", new Color(255, 255, 224));
        hashMap.put("magenta", new Color(255, 0, 255));
        hashMap.put("maroon", new Color(128, 0, 0));
        hashMap.put("medAquamarine", new Color(102, NNTPReply.CLOSING_CONNECTION, 170));
        hashMap.put("medBlue", new Color(0, 0, NNTPReply.CLOSING_CONNECTION));
        hashMap.put("medOrchid", new Color(186, 85, 211));
        hashMap.put("medPurple", new Color(147, 112, 219));
        hashMap.put("medSeaGreen", new Color(60, 179, 113));
        hashMap.put("medSlateBlue", new Color(123, 104, TelnetCommand.ABORT));
        hashMap.put("medSpringGreen", new Color(0, 250, 154));
        hashMap.put("medTurquoise", new Color(72, 209, 204));
        hashMap.put("medVioletRed", new Color(199, 21, 133));
        hashMap.put("midnightBlue", new Color(25, 25, 112));
        hashMap.put("mintCream", new Color(TelnetCommand.AO, 255, 250));
        hashMap.put("mistyRose", new Color(255, 228, FTPReply.DATA_CONNECTION_OPEN));
        hashMap.put("moccasin", new Color(255, 228, 181));
        hashMap.put("navajoWhite", new Color(255, NNTPReply.ARTICLE_RETRIEVED_BODY_FOLLOWS, 173));
        hashMap.put("navy", new Color(0, 0, 128));
        hashMap.put("oldLace", new Color(TelnetCommand.DO, TelnetCommand.AO, 230));
        hashMap.put("olive", new Color(128, 128, 0));
        hashMap.put("oliveDrab", new Color(107, 142, 35));
        hashMap.put("orange", new Color(255, 165, 0));
        hashMap.put("orangeRed", new Color(255, 69, 0));
        hashMap.put("orchid", new Color(218, 112, 214));
        hashMap.put("paleGoldenrod", new Color(TelnetCommand.ABORT, 232, 170));
        hashMap.put("paleGreen", new Color(152, 251, 152));
        hashMap.put("paleTurquoise", new Color(175, TelnetCommand.ABORT, TelnetCommand.ABORT));
        hashMap.put("paleVioletRed", new Color(219, 112, 147));
        hashMap.put("papayaWhip", new Color(255, 239, FTPReply.FILE_STATUS));
        hashMap.put("peachPuff", new Color(255, 218, 185));
        hashMap.put("peru", new Color(NNTPReply.CLOSING_CONNECTION, 133, 63));
        hashMap.put("pink", new Color(255, 192, 203));
        hashMap.put("plum", new Color(221, 160, 221));
        hashMap.put("powderBlue", new Color(176, 224, 230));
        hashMap.put("purple", new Color(128, 0, 128));
        hashMap.put("red", new Color(255, 0, 0));
        hashMap.put("rosyBrown", new Color(188, 143, 143));
        hashMap.put("royalBlue", new Color(65, 105, FTPReply.DATA_CONNECTION_OPEN));
        hashMap.put("saddleBrown", new Color(139, 69, 19));
        hashMap.put("salmon", new Color(250, 128, 114));
        hashMap.put("sandyBrown", new Color(244, 164, 96));
        hashMap.put("seaGreen", new Color(46, 139, 87));
        hashMap.put("seaShell", new Color(255, TelnetCommand.AO, TelnetCommand.ABORT));
        hashMap.put("sienna", new Color(160, 82, 45));
        hashMap.put("silver", new Color(192, 192, 192));
        hashMap.put("skyBlue", new Color(135, 206, 235));
        hashMap.put("slateBlue", new Color(106, 90, NNTPReply.CLOSING_CONNECTION));
        hashMap.put("slateGray", new Color(112, 128, 144));
        hashMap.put("snow", new Color(255, 250, 250));
        hashMap.put("springGreen", new Color(0, 255, 127));
        hashMap.put("steelBlue", new Color(70, 130, 180));
        hashMap.put("tan", new Color(210, 180, 140));
        hashMap.put("teal", new Color(0, 128, 128));
        hashMap.put("thistle", new Color(216, 191, 216));
        hashMap.put("tomato", new Color(255, 99, 71));
        hashMap.put("turquoise", new Color(64, 224, 208));
        hashMap.put("violet", new Color(TelnetCommand.ABORT, 130, TelnetCommand.ABORT));
        hashMap.put("wheat", new Color(TelnetCommand.AO, NNTPReply.ARTICLE_RETRIEVED_BODY_FOLLOWS, 179));
        hashMap.put("white", new Color(255, 255, 255));
        hashMap.put("whiteSmoke", new Color(TelnetCommand.AO, TelnetCommand.AO, TelnetCommand.AO));
        hashMap.put("yellow", new Color(255, 255, 0));
        hashMap.put("yellowGreen", new Color(154, NNTPReply.CLOSING_CONNECTION, 50));
    }
}
