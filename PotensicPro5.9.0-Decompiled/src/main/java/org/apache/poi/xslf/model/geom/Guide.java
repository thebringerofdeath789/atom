package org.apache.poi.xslf.model.geom;

import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;

/* loaded from: classes5.dex */
public class Guide extends Formula {
    private Expression expr;
    private String fmla;
    private String name;

    public Guide(CTGeomGuide cTGeomGuide) {
        this(cTGeomGuide.getName(), cTGeomGuide.getFmla());
    }

    public Guide(String str, String str2) {
        this.name = str;
        this.fmla = str2;
        this.expr = ExpressionParser.parse(str2);
    }

    @Override // org.apache.poi.xslf.model.geom.Formula
    String getName() {
        return this.name;
    }

    String getFormula() {
        return this.fmla;
    }

    @Override // org.apache.poi.xslf.model.geom.Formula
    public double evaluate(Context context) {
        return this.expr.evaluate(context);
    }
}
