package org.apache.poi.xslf.usermodel;

import java.net.URI;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;

/* loaded from: classes5.dex */
public class XSLFHyperlink {
    final CTHyperlink _link;
    final XSLFTextRun _r;

    XSLFHyperlink(CTHyperlink cTHyperlink, XSLFTextRun xSLFTextRun) {
        this._r = xSLFTextRun;
        this._link = cTHyperlink;
    }

    @Internal
    public CTHyperlink getXmlObject() {
        return this._link;
    }

    public void setAddress(String str) {
        this._link.setId(this._r.getParentParagraph().getParentShape().getSheet().getPackagePart().addExternalRelationship(str, XSLFRelation.HYPERLINK.getRelation()).getId());
    }

    public void setAddress(XSLFSlide xSLFSlide) {
        this._link.setId(this._r.getParentParagraph().getParentShape().getSheet().getPackagePart().addRelationship(xSLFSlide.getPackagePart().getPartName(), TargetMode.INTERNAL, XSLFRelation.SLIDE.getRelation()).getId());
        this._link.setAction("ppaction://hlinksldjump");
    }

    @Internal
    public URI getTargetURI() {
        XSLFSheet sheet = this._r.getParentParagraph().getParentShape().getSheet();
        return sheet.getPackagePart().getRelationship(this._link.getId()).getTargetURI();
    }
}
