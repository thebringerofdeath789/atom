package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;

/* loaded from: classes5.dex */
public final class XSLFSlide extends XSLFSheet {
    private XSLFComments _comments;
    private XSLFSlideLayout _layout;
    private XSLFNotes _notes;
    private final CTSlide _slide;

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "sld";
    }

    XSLFSlide() {
        CTSlide prototype = prototype();
        this._slide = prototype;
        setCommonSlideData(prototype.getCSld());
    }

    XSLFSlide(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        CTSlide sld = SldDocument.Factory.parse(getPackagePart().getInputStream()).getSld();
        this._slide = sld;
        setCommonSlideData(sld.getCSld());
    }

    private static CTSlide prototype() {
        CTSlide newInstance = CTSlide.Factory.newInstance();
        CTGroupShape addNewSpTree = newInstance.addNewCSld().addNewSpTree();
        CTGroupShapeNonVisual addNewNvGrpSpPr = addNewSpTree.addNewNvGrpSpPr();
        CTNonVisualDrawingProps addNewCNvPr = addNewNvGrpSpPr.addNewCNvPr();
        addNewCNvPr.setId(1L);
        addNewCNvPr.setName("");
        addNewNvGrpSpPr.addNewCNvGrpSpPr();
        addNewNvGrpSpPr.addNewNvPr();
        CTGroupTransform2D addNewXfrm = addNewSpTree.addNewGrpSpPr().addNewXfrm();
        CTPoint2D addNewOff = addNewXfrm.addNewOff();
        addNewOff.setX(0L);
        addNewOff.setY(0L);
        CTPositiveSize2D addNewExt = addNewXfrm.addNewExt();
        addNewExt.setCx(0L);
        addNewExt.setCy(0L);
        CTPoint2D addNewChOff = addNewXfrm.addNewChOff();
        addNewChOff.setX(0L);
        addNewChOff.setY(0L);
        CTPositiveSize2D addNewChExt = addNewXfrm.addNewChExt();
        addNewChExt.setCx(0L);
        addNewChExt.setCy(0L);
        newInstance.addNewClrMapOvr().addNewMasterClrMapping();
        return newInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTSlide getXmlObject() {
        return this._slide;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFSlideLayout getMasterSheet() {
        return getSlideLayout();
    }

    public XSLFSlideLayout getSlideLayout() {
        if (this._layout == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
                    this._layout = (XSLFSlideLayout) pOIXMLDocumentPart;
                }
            }
        }
        XSLFSlideLayout xSLFSlideLayout = this._layout;
        if (xSLFSlideLayout != null) {
            return xSLFSlideLayout;
        }
        throw new IllegalArgumentException("SlideLayout was not found for " + toString());
    }

    public XSLFSlideMaster getSlideMaster() {
        return getSlideLayout().getSlideMaster();
    }

    public XSLFComments getComments() {
        if (this._comments == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFComments) {
                    this._comments = (XSLFComments) pOIXMLDocumentPart;
                }
            }
        }
        XSLFComments xSLFComments = this._comments;
        if (xSLFComments == null) {
            return null;
        }
        return xSLFComments;
    }

    public XSLFNotes getNotes() {
        if (this._notes == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFNotes) {
                    this._notes = (XSLFNotes) pOIXMLDocumentPart;
                }
            }
        }
        XSLFNotes xSLFNotes = this._notes;
        if (xSLFNotes == null) {
            return null;
        }
        return xSLFNotes;
    }

    public String getTitle() {
        XSLFTextShape textShapeByType = getTextShapeByType(Placeholder.TITLE);
        return textShapeByType == null ? "" : textShapeByType.getText();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getSlideLayout().getSlideMaster().getTheme();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._slide.getCSld().getBg();
        if (bg != null) {
            return new XSLFBackground(bg, this);
        }
        return getMasterSheet().getBackground();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public boolean getFollowMasterGraphics() {
        return !this._slide.isSetShowMasterSp() || this._slide.getShowMasterSp();
    }

    public void setFollowMasterGraphics(boolean z) {
        this._slide.setShowMasterSp(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public void draw(Graphics2D graphics2D) {
        XSLFBackground background = getBackground();
        if (background != null) {
            background.draw(graphics2D);
        }
        super.draw(graphics2D);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFSlide importContent(XSLFSheet xSLFSheet) {
        super.importContent(xSLFSheet);
        XSLFBackground background = getBackground();
        if (background != null) {
            CTBackground cTBackground = (CTBackground) background.getXmlObject();
            if (cTBackground.isSetBgPr() && cTBackground.getBgPr().isSetBlipFill()) {
                CTBlip blip = cTBackground.getBgPr().getBlipFill().getBlip();
                blip.setEmbed(importBlip(blip.getEmbed(), xSLFSheet.getPackagePart()));
            }
        }
        return this;
    }
}
