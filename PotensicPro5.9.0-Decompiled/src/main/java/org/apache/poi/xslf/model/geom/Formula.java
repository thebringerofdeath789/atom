package org.apache.poi.xslf.model.geom;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes5.dex */
public abstract class Formula {
    static Map<String, Formula> builtInFormulas;

    abstract double evaluate(Context context);

    String getName() {
        return null;
    }

    static {
        HashMap hashMap = new HashMap();
        builtInFormulas = hashMap;
        hashMap.put("3cd4", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.1
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return 1.62E7d;
            }
        });
        builtInFormulas.put("3cd8", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.2
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return 8100000.0d;
            }
        });
        builtInFormulas.put("5cd8", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.3
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return 1.62E7d;
            }
        });
        builtInFormulas.put("7cd8", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.4
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return 1.62E7d;
            }
        });
        builtInFormulas.put("b", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.5
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return shapeAnchor.getY() + shapeAnchor.getHeight();
            }
        });
        builtInFormulas.put("cd2", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.6
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return 1.08E7d;
            }
        });
        builtInFormulas.put("cd4", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.7
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return 5400000.0d;
            }
        });
        builtInFormulas.put("cd8", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.8
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return 2700000.0d;
            }
        });
        builtInFormulas.put("hc", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.9
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return shapeAnchor.getX() + (shapeAnchor.getWidth() / 2.0d);
            }
        });
        builtInFormulas.put("h", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.10
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getHeight();
            }
        });
        builtInFormulas.put("hd2", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.11
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getHeight() / 2.0d;
            }
        });
        builtInFormulas.put("hd3", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.12
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getHeight() / 3.0d;
            }
        });
        builtInFormulas.put("hd4", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.13
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getHeight() / 4.0d;
            }
        });
        builtInFormulas.put("hd5", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.14
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getHeight() / 5.0d;
            }
        });
        builtInFormulas.put("hd6", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.15
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getHeight() / 6.0d;
            }
        });
        builtInFormulas.put("hd8", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.16
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getHeight() / 8.0d;
            }
        });
        builtInFormulas.put("l", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.17
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getX();
            }
        });
        builtInFormulas.put("ls", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.18
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.max(shapeAnchor.getWidth(), shapeAnchor.getHeight());
            }
        });
        builtInFormulas.put(InternalZipConstants.READ_MODE, new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.19
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return shapeAnchor.getX() + shapeAnchor.getWidth();
            }
        });
        builtInFormulas.put("ss", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.20
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.min(shapeAnchor.getWidth(), shapeAnchor.getHeight());
            }
        });
        builtInFormulas.put("ssd2", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.21
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.min(shapeAnchor.getWidth(), shapeAnchor.getHeight()) / 2.0d;
            }
        });
        builtInFormulas.put("ssd4", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.22
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.min(shapeAnchor.getWidth(), shapeAnchor.getHeight()) / 4.0d;
            }
        });
        builtInFormulas.put("ssd6", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.23
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.min(shapeAnchor.getWidth(), shapeAnchor.getHeight()) / 6.0d;
            }
        });
        builtInFormulas.put("ssd8", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.24
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.min(shapeAnchor.getWidth(), shapeAnchor.getHeight()) / 8.0d;
            }
        });
        builtInFormulas.put("ssd16", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.25
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.min(shapeAnchor.getWidth(), shapeAnchor.getHeight()) / 16.0d;
            }
        });
        builtInFormulas.put("ssd32", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.26
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return Math.min(shapeAnchor.getWidth(), shapeAnchor.getHeight()) / 32.0d;
            }
        });
        builtInFormulas.put("t", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.27
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getY();
            }
        });
        builtInFormulas.put("vc", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.28
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                Rectangle2D shapeAnchor = context.getShapeAnchor();
                return shapeAnchor.getY() + (shapeAnchor.getHeight() / 2.0d);
            }
        });
        builtInFormulas.put("w", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.29
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth();
            }
        });
        builtInFormulas.put("wd2", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.30
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 2.0d;
            }
        });
        builtInFormulas.put("wd3", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.31
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 3.0d;
            }
        });
        builtInFormulas.put("wd4", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.32
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 4.0d;
            }
        });
        builtInFormulas.put("wd5", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.33
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 5.0d;
            }
        });
        builtInFormulas.put("wd6", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.34
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 6.0d;
            }
        });
        builtInFormulas.put("wd8", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.35
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 8.0d;
            }
        });
        builtInFormulas.put("wd10", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.36
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 10.0d;
            }
        });
        builtInFormulas.put("wd32", new Formula() { // from class: org.apache.poi.xslf.model.geom.Formula.37
            @Override // org.apache.poi.xslf.model.geom.Formula
            double evaluate(Context context) {
                return context.getShapeAnchor().getWidth() / 32.0d;
            }
        });
    }
}
