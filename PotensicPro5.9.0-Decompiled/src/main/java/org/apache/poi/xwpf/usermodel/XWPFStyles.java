package org.apache.poi.xwpf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* loaded from: classes5.dex */
public class XWPFStyles extends POIXMLDocumentPart {
    private CTStyles ctStyles;
    private XWPFDefaultParagraphStyle defaultParaStyle;
    private XWPFDefaultRunStyle defaultRunStyle;
    private XWPFLatentStyles latentStyles;
    private List<XWPFStyle> listStyle;

    public XWPFStyles(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, OpenXML4JException {
        super(packagePart, packageRelationship);
        this.listStyle = new ArrayList();
    }

    public XWPFStyles() {
        this.listStyle = new ArrayList();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            setStyles(StylesDocument.Factory.parse(getPackagePart().getInputStream()).getStyles());
            this.latentStyles = new XWPFLatentStyles(this.ctStyles.getLatentStyles(), this);
        } catch (XmlException e) {
            throw new POIXMLException("Unable to read styles", e);
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        if (this.ctStyles == null) {
            throw new IllegalStateException("Unable to write out styles that were never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTStyles.type.getName().getNamespaceURI(), "styles"));
        HashMap hashMap = new HashMap();
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", InternalZipConstants.READ_MODE);
        hashMap.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctStyles.save(outputStream, xmlOptions);
        outputStream.close();
    }

    protected void ensureDocDefaults() {
        if (!this.ctStyles.isSetDocDefaults()) {
            this.ctStyles.addNewDocDefaults();
        }
        CTDocDefaults docDefaults = this.ctStyles.getDocDefaults();
        if (!docDefaults.isSetPPrDefault()) {
            docDefaults.addNewPPrDefault();
        }
        if (!docDefaults.isSetRPrDefault()) {
            docDefaults.addNewRPrDefault();
        }
        CTPPrDefault pPrDefault = docDefaults.getPPrDefault();
        CTRPrDefault rPrDefault = docDefaults.getRPrDefault();
        if (!pPrDefault.isSetPPr()) {
            pPrDefault.addNewPPr();
        }
        if (!rPrDefault.isSetRPr()) {
            rPrDefault.addNewRPr();
        }
        this.defaultRunStyle = new XWPFDefaultRunStyle(rPrDefault.getRPr());
        this.defaultParaStyle = new XWPFDefaultParagraphStyle(pPrDefault.getPPr());
    }

    public void setStyles(CTStyles cTStyles) {
        this.ctStyles = cTStyles;
        for (CTStyle cTStyle : cTStyles.getStyleArray()) {
            this.listStyle.add(new XWPFStyle(cTStyle, this));
        }
        if (this.ctStyles.isSetDocDefaults()) {
            CTDocDefaults docDefaults = this.ctStyles.getDocDefaults();
            if (docDefaults.isSetRPrDefault() && docDefaults.getRPrDefault().isSetRPr()) {
                this.defaultRunStyle = new XWPFDefaultRunStyle(docDefaults.getRPrDefault().getRPr());
            }
            if (docDefaults.isSetPPrDefault() && docDefaults.getPPrDefault().isSetPPr()) {
                this.defaultParaStyle = new XWPFDefaultParagraphStyle(docDefaults.getPPrDefault().getPPr());
            }
        }
    }

    public boolean styleExist(String str) {
        Iterator<XWPFStyle> it = this.listStyle.iterator();
        while (it.hasNext()) {
            if (it.next().getStyleId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void addStyle(XWPFStyle xWPFStyle) {
        this.listStyle.add(xWPFStyle);
        this.ctStyles.addNewStyle();
        this.ctStyles.setStyleArray(this.ctStyles.sizeOfStyleArray() - 1, xWPFStyle.getCTStyle());
    }

    public XWPFStyle getStyle(String str) {
        for (XWPFStyle xWPFStyle : this.listStyle) {
            if (xWPFStyle.getStyleId().equals(str)) {
                return xWPFStyle;
            }
        }
        return null;
    }

    public int getNumberOfStyles() {
        return this.listStyle.size();
    }

    public List<XWPFStyle> getUsedStyleList(XWPFStyle xWPFStyle) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(xWPFStyle);
        return getUsedStyleList(xWPFStyle, arrayList);
    }

    private List<XWPFStyle> getUsedStyleList(XWPFStyle xWPFStyle, List<XWPFStyle> list) {
        XWPFStyle style = getStyle(xWPFStyle.getBasisStyleID());
        if (style != null && !list.contains(style)) {
            list.add(style);
            getUsedStyleList(style, list);
        }
        XWPFStyle style2 = getStyle(xWPFStyle.getLinkStyleID());
        if (style2 != null && !list.contains(style2)) {
            list.add(style2);
            getUsedStyleList(style2, list);
        }
        XWPFStyle style3 = getStyle(xWPFStyle.getNextStyleID());
        if (style3 != null && !list.contains(style3)) {
            list.add(style2);
            getUsedStyleList(style2, list);
        }
        return list;
    }

    protected CTLanguage getCTLanguage() {
        ensureDocDefaults();
        if (this.defaultRunStyle.getRPr().isSetLang()) {
            return this.defaultRunStyle.getRPr().getLang();
        }
        return this.defaultRunStyle.getRPr().addNewLang();
    }

    public void setSpellingLanguage(String str) {
        CTLanguage cTLanguage = getCTLanguage();
        cTLanguage.setVal(str);
        cTLanguage.setBidi(str);
    }

    public void setEastAsia(String str) {
        getCTLanguage().setEastAsia(str);
    }

    public void setDefaultFonts(CTFonts cTFonts) {
        ensureDocDefaults();
        this.defaultRunStyle.getRPr().setRFonts(cTFonts);
    }

    public XWPFStyle getStyleWithSameName(XWPFStyle xWPFStyle) {
        for (XWPFStyle xWPFStyle2 : this.listStyle) {
            if (xWPFStyle2.hasSameName(xWPFStyle)) {
                return xWPFStyle2;
            }
        }
        return null;
    }

    public XWPFDefaultRunStyle getDefaultRunStyle() {
        ensureDocDefaults();
        return this.defaultRunStyle;
    }

    public XWPFDefaultParagraphStyle getDefaultParagraphStyle() {
        ensureDocDefaults();
        return this.defaultParaStyle;
    }

    public XWPFLatentStyles getLatentStyles() {
        return this.latentStyles;
    }
}
