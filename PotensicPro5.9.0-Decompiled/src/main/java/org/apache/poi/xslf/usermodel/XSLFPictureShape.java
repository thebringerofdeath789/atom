package org.apache.poi.xslf.usermodel;

import aavax.xml.namespace.QName;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URI;
import javax.imageio.ImageIO;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;

/* loaded from: classes5.dex */
public class XSLFPictureShape extends XSLFSimpleShape {
    private XSLFPictureData _data;

    XSLFPictureShape(CTPicture cTPicture, XSLFSheet xSLFSheet) {
        super(cTPicture, xSLFSheet);
    }

    static CTPicture prototype(int i, String str) {
        CTPicture newInstance = CTPicture.Factory.newInstance();
        CTPictureNonVisual addNewNvPicPr = newInstance.addNewNvPicPr();
        CTNonVisualDrawingProps addNewCNvPr = addNewNvPicPr.addNewCNvPr();
        addNewCNvPr.setName("Picture " + i);
        addNewCNvPr.setId(i + 1);
        addNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
        addNewNvPicPr.addNewNvPr();
        CTBlipFillProperties addNewBlipFill = newInstance.addNewBlipFill();
        addNewBlipFill.addNewBlip().setEmbed(str);
        addNewBlipFill.addNewStretch().addNewFillRect();
        CTPresetGeometry2D addNewPrstGeom = newInstance.addNewSpPr().addNewPrstGeom();
        addNewPrstGeom.setPrst(STShapeType.RECT);
        addNewPrstGeom.addNewAvLst();
        return newInstance;
    }

    public void resize() {
        try {
            BufferedImage read = ImageIO.read(new ByteArrayInputStream(getPictureData().getData()));
            setAnchor(new Rectangle2D.Double(0.0d, 0.0d, read.getWidth(), read.getHeight()));
        } catch (Exception unused) {
            setAnchor(new Rectangle(50, 50, 200, 200));
        }
    }

    public boolean isExternalLinkedPicture() {
        return getBlipId() == null && getBlipLink() != null;
    }

    public XSLFPictureData getPictureData() {
        if (this._data == null) {
            String blipId = getBlipId();
            if (blipId == null) {
                return null;
            }
            PackagePart packagePart = getSheet().getPackagePart();
            PackageRelationship relationship = packagePart.getRelationship(blipId);
            if (relationship != null) {
                try {
                    this._data = new XSLFPictureData(packagePart.getRelatedPart(relationship), relationship);
                } catch (Exception e) {
                    throw new POIXMLException(e);
                }
            }
        }
        return this._data;
    }

    public URI getPictureLink() {
        String blipLink;
        PackageRelationship relationship;
        if (getBlipId() != null || (blipLink = getBlipLink()) == null || (relationship = getSheet().getPackagePart().getRelationship(blipLink)) == null) {
            return null;
        }
        return relationship.getTargetURI();
    }

    private CTBlip getBlip() {
        return ((CTPicture) getXmlObject()).getBlipFill().getBlip();
    }

    private String getBlipLink() {
        String link = getBlip().getLink();
        if (link.isEmpty()) {
            return null;
        }
        return link;
    }

    private String getBlipId() {
        String embed = getBlip().getEmbed();
        if (embed.isEmpty()) {
            return null;
        }
        return embed;
    }

    public Insets getBlipClip() {
        CTRelativeRect srcRect = ((CTPicture) getXmlObject()).getBlipFill().getSrcRect();
        if (srcRect == null) {
            return null;
        }
        return new Insets(srcRect.getT(), srcRect.getL(), srcRect.getB(), srcRect.getR());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public void drawContent(Graphics2D graphics2D) {
        XSLFPictureData pictureData = getPictureData();
        if (pictureData == null) {
            return;
        }
        XSLFImageRenderer xSLFImageRenderer = (XSLFImageRenderer) graphics2D.getRenderingHint(XSLFRenderingHint.IMAGE_RENDERER);
        if (xSLFImageRenderer == null) {
            xSLFImageRenderer = new XSLFImageRenderer();
        }
        xSLFImageRenderer.drawImage(graphics2D, pictureData, new RenderableShape(this).getAnchor(graphics2D), getBlipClip());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFPictureShape xSLFPictureShape = (XSLFPictureShape) xSLFShape;
        String importBlip = getSheet().importBlip(xSLFPictureShape.getBlipId(), xSLFPictureShape.getSheet().getPackagePart());
        CTPicture cTPicture = (CTPicture) getXmlObject();
        CTBlip blip = cTPicture.getBlipFill().getBlip();
        blip.setEmbed(importBlip);
        CTApplicationNonVisualDrawingProps nvPr = cTPicture.getNvPicPr().getNvPr();
        if (nvPr.isSetCustDataLst()) {
            nvPr.unsetCustDataLst();
        }
        if (blip.isSetExtLst()) {
            for (CTOfficeArtExtension cTOfficeArtExtension : blip.getExtLst().getExtArray()) {
                XmlObject[] selectPath = cTOfficeArtExtension.selectPath("declare namespace a14='http://schemas.microsoft.com/office/drawing/2010/main' $this//a14:imgProps/a14:imgLayer");
                if (selectPath != null && selectPath.length == 1) {
                    XmlCursor newCursor = selectPath[0].newCursor();
                    newCursor.setAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed"), getSheet().importBlip(newCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed")), xSLFPictureShape.getSheet().getPackagePart()));
                    newCursor.dispose();
                }
            }
        }
    }
}
