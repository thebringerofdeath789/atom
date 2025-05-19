package org.apache.poi.xslf.usermodel;

import aavax.xml.namespace.QName;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* loaded from: classes5.dex */
public class XSLFTheme extends POIXMLDocumentPart {
    private Map<String, CTColor> _schemeColors;
    private CTOfficeStyleSheet _theme;

    XSLFTheme() {
        this._theme = CTOfficeStyleSheet.Factory.newInstance();
    }

    public XSLFTheme(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        this._theme = ThemeDocument.Factory.parse(getPackagePart().getInputStream()).getTheme();
        initialize();
    }

    public void importTheme(XSLFTheme xSLFTheme) {
        this._theme = xSLFTheme.getXmlObject();
        this._schemeColors = xSLFTheme._schemeColors;
    }

    private void initialize() {
        CTColorScheme clrScheme = this._theme.getThemeElements().getClrScheme();
        this._schemeColors = new HashMap(12);
        for (XmlObject xmlObject : clrScheme.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            CTColor cTColor = (CTColor) xmlObject;
            this._schemeColors.put(cTColor.getDomNode().getLocalName(), cTColor);
        }
    }

    void initColorMap(CTColorMapping cTColorMapping) {
        Map<String, CTColor> map = this._schemeColors;
        map.put("bg1", map.get(cTColorMapping.getBg1().toString()));
        Map<String, CTColor> map2 = this._schemeColors;
        map2.put("bg2", map2.get(cTColorMapping.getBg2().toString()));
        Map<String, CTColor> map3 = this._schemeColors;
        map3.put("tx1", map3.get(cTColorMapping.getTx1().toString()));
        Map<String, CTColor> map4 = this._schemeColors;
        map4.put("tx2", map4.get(cTColorMapping.getTx2().toString()));
    }

    public String getName() {
        return this._theme.getName();
    }

    public void setName(String str) {
        this._theme.setName(str);
    }

    CTColor getCTColor(String str) {
        return this._schemeColors.get(str);
    }

    @Internal
    public CTOfficeStyleSheet getXmlObject() {
        return this._theme;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected final void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        HashMap hashMap = new HashMap();
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        xmlOptions.setSaveSyntheticDocumentElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "theme"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        getXmlObject().save(outputStream, xmlOptions);
        outputStream.close();
    }

    public String getMajorFont() {
        return this._theme.getThemeElements().getFontScheme().getMajorFont().getLatin().getTypeface();
    }

    public String getMinorFont() {
        return this._theme.getThemeElements().getFontScheme().getMinorFont().getLatin().getTypeface();
    }

    CTTextParagraphProperties getDefaultParagraphStyle() {
        XmlObject[] selectPath = this._theme.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:objectDefaults/a:spDef/a:lstStyle/a:defPPr");
        if (selectPath.length == 1) {
            return (CTTextParagraphProperties) selectPath[0];
        }
        return null;
    }
}
