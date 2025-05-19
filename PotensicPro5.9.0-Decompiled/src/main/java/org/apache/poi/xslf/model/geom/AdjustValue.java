package org.apache.poi.xslf.model.geom;

import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;

/* loaded from: classes5.dex */
public class AdjustValue extends Guide {
    public AdjustValue(CTGeomGuide cTGeomGuide) {
        super(cTGeomGuide.getName(), cTGeomGuide.getFmla());
    }

    @Override // org.apache.poi.xslf.model.geom.Guide, org.apache.poi.xslf.model.geom.Formula
    public double evaluate(Context context) {
        Guide adjustValue = context.getAdjustValue(getName());
        if (adjustValue != null) {
            return adjustValue.evaluate(context);
        }
        return super.evaluate(context);
    }
}
