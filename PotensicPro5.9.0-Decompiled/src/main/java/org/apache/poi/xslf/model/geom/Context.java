package org.apache.poi.xslf.model.geom;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public class Context {
    final Rectangle2D _anchor;
    final Map<String, Double> _ctx = new HashMap();
    final IAdjustableShape _props;

    public Context(CustomGeometry customGeometry, Rectangle2D rectangle2D, IAdjustableShape iAdjustableShape) {
        this._props = iAdjustableShape;
        this._anchor = rectangle2D;
        Iterator<Guide> it = customGeometry.adjusts.iterator();
        while (it.hasNext()) {
            evaluate(it.next());
        }
        Iterator<Guide> it2 = customGeometry.guides.iterator();
        while (it2.hasNext()) {
            evaluate(it2.next());
        }
    }

    public Rectangle2D getShapeAnchor() {
        return this._anchor;
    }

    public Guide getAdjustValue(String str) {
        return this._props.getAdjustValue(str);
    }

    public double getValue(String str) {
        if (str.matches("(\\+|-)?\\d+")) {
            return Double.parseDouble(str);
        }
        Formula formula = Formula.builtInFormulas.get(str);
        if (formula != null) {
            return formula.evaluate(this);
        }
        if (!this._ctx.containsKey(str)) {
            throw new RuntimeException("undefined variable: " + str);
        }
        return this._ctx.get(str).doubleValue();
    }

    public double evaluate(Formula formula) {
        double evaluate = formula.evaluate(this);
        String name = formula.getName();
        if (name != null) {
            this._ctx.put(name, Double.valueOf(evaluate));
        }
        return evaluate;
    }
}
