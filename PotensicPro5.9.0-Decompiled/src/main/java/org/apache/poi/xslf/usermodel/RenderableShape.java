package org.apache.poi.xslf.usermodel;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.Internal;
import org.apache.poi.xslf.model.PropertyFetcher;
import org.apache.poi.xslf.model.geom.Context;
import org.apache.poi.xslf.model.geom.CustomGeometry;
import org.apache.poi.xslf.model.geom.Guide;
import org.apache.poi.xslf.model.geom.IAdjustableShape;
import org.apache.poi.xslf.model.geom.Outline;
import org.apache.poi.xslf.model.geom.Path;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;

@Internal
/* loaded from: classes5.dex */
class RenderableShape {
    public static final Color NO_PAINT = new Color(255, 255, 255, 0);
    private XSLFSimpleShape _shape;

    public RenderableShape(XSLFSimpleShape xSLFSimpleShape) {
        this._shape = xSLFSimpleShape;
    }

    public Paint selectPaint(Graphics2D graphics2D, XmlObject xmlObject, CTSchemeColor cTSchemeColor, PackagePart packagePart) {
        XSLFTheme theme = this._shape.getSheet().getTheme();
        if (xmlObject instanceof CTNoFillProperties) {
            return NO_PAINT;
        }
        if (xmlObject instanceof CTSolidColorFillProperties) {
            return new XSLFColor((CTSolidColorFillProperties) xmlObject, theme, cTSchemeColor).getColor();
        }
        if (xmlObject instanceof CTBlipFillProperties) {
            return createTexturePaint((CTBlipFillProperties) xmlObject, graphics2D, packagePart);
        }
        if (xmlObject instanceof CTGradientFillProperties) {
            Rectangle2D anchor = getAnchor(graphics2D);
            CTGradientFillProperties cTGradientFillProperties = (CTGradientFillProperties) xmlObject;
            if (cTGradientFillProperties.isSetLin()) {
                return createLinearGradientPaint(graphics2D, cTGradientFillProperties, anchor, theme, cTSchemeColor);
            }
            if (cTGradientFillProperties.isSetPath()) {
                CTPathShadeProperties path = cTGradientFillProperties.getPath();
                if (path.getPath() == STPathShadeType.CIRCLE) {
                    return createRadialGradientPaint(cTGradientFillProperties, anchor, theme, cTSchemeColor);
                }
                if (path.getPath() == STPathShadeType.SHAPE) {
                    return toRadialGradientPaint(cTGradientFillProperties, anchor, theme, cTSchemeColor);
                }
            }
        }
        return null;
    }

    private Paint createTexturePaint(CTBlipFillProperties cTBlipFillProperties, Graphics2D graphics2D, PackagePart packagePart) {
        CTBlip blip = cTBlipFillProperties.getBlip();
        PackageRelationship relationship = packagePart.getRelationship(blip.getEmbed());
        if (relationship == null) {
            return null;
        }
        XSLFImageRenderer xSLFImageRenderer = graphics2D != null ? (XSLFImageRenderer) graphics2D.getRenderingHint(XSLFRenderingHint.IMAGE_RENDERER) : null;
        if (xSLFImageRenderer == null) {
            xSLFImageRenderer = new XSLFImageRenderer();
        }
        try {
            BufferedImage readImage = xSLFImageRenderer.readImage(packagePart.getRelatedPart(relationship));
            if (blip.sizeOfAlphaModFixArray() > 0) {
                AlphaComposite alphaComposite = AlphaComposite.getInstance(3, blip.getAlphaModFixArray(0).getAmt() / 100000.0f);
                if (graphics2D != null) {
                    graphics2D.setComposite(alphaComposite);
                }
            }
            if (readImage != null) {
                return new TexturePaint(readImage, new Rectangle2D.Double(0.0d, 0.0d, readImage.getWidth(), readImage.getHeight()));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Paint createLinearGradientPaint(Graphics2D graphics2D, CTGradientFillProperties cTGradientFillProperties, Rectangle2D rectangle2D, XSLFTheme xSLFTheme, CTSchemeColor cTSchemeColor) {
        double ang = cTGradientFillProperties.getLin().getAng() / 60000;
        CTGradientStop[] gsArray = cTGradientFillProperties.getGsLst().getGsArray();
        Arrays.sort(gsArray, new Comparator<CTGradientStop>() { // from class: org.apache.poi.xslf.usermodel.RenderableShape.1
            @Override // java.util.Comparator
            public int compare(CTGradientStop cTGradientStop, CTGradientStop cTGradientStop2) {
                return Integer.valueOf(cTGradientStop.getPos()).compareTo(Integer.valueOf(cTGradientStop2.getPos()));
            }
        });
        int length = gsArray.length;
        Color[] colorArr = new Color[length];
        float[] fArr = new float[gsArray.length];
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(Math.toRadians(ang), (rectangle2D.getWidth() / 2.0d) + rectangle2D.getX(), (rectangle2D.getHeight() / 2.0d) + rectangle2D.getY());
        Point2D transform = rotateInstance.transform(new Point2D.Double((rectangle2D.getX() + (rectangle2D.getWidth() / 2.0d)) - (Math.sqrt((rectangle2D.getHeight() * rectangle2D.getHeight()) + (rectangle2D.getWidth() * rectangle2D.getWidth())) / 2.0d), rectangle2D.getY() + (rectangle2D.getHeight() / 2.0d)), (Point2D) null);
        Point2D transform2 = rotateInstance.transform(new Point2D.Double(rectangle2D.getX() + rectangle2D.getWidth(), rectangle2D.getY() + (rectangle2D.getHeight() / 2.0d)), (Point2D) null);
        snapToAnchor(transform, rectangle2D);
        snapToAnchor(transform2, rectangle2D);
        for (int i = 0; i < gsArray.length; i++) {
            colorArr[i] = new XSLFColor(gsArray[i], xSLFTheme, cTSchemeColor).getColor();
            fArr[i] = r10.getPos() / 100000.0f;
        }
        AffineTransform affineTransform = new AffineTransform();
        if (cTGradientFillProperties.isSetRotWithShape() || !cTGradientFillProperties.getRotWithShape()) {
            double rotation = this._shape.getRotation();
            if (rotation != 0.0d) {
                double x = rectangle2D.getX() + (rectangle2D.getWidth() / 2.0d);
                double y = rectangle2D.getY() + (rectangle2D.getHeight() / 2.0d);
                affineTransform.translate(x, y);
                affineTransform.rotate(Math.toRadians(-rotation));
                affineTransform.translate(-x, -y);
            }
        }
        try {
            Class<?> cls = Class.forName("java.awt.LinearGradientPaint");
            Class<?> cls2 = Class.forName("java.awt.MultipleGradientPaint$CycleMethod");
            Class<?> cls3 = Class.forName("java.awt.MultipleGradientPaint$ColorSpaceType");
            return (Paint) cls.getConstructor(Point2D.class, Point2D.class, float[].class, Color[].class, cls2, cls3, AffineTransform.class).newInstance(transform, transform2, fArr, colorArr, Enum.valueOf(cls2, "NO_CYCLE"), Enum.valueOf(cls3, "SRGB"), affineTransform);
        } catch (ClassNotFoundException unused) {
            return new GradientPaint(transform, colorArr[0], transform2, colorArr[length - 1]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Paint toRadialGradientPaint(CTGradientFillProperties cTGradientFillProperties, Rectangle2D rectangle2D, XSLFTheme xSLFTheme, CTSchemeColor cTSchemeColor) {
        CTGradientStop[] gsArray = cTGradientFillProperties.getGsLst().getGsArray();
        Arrays.sort(gsArray, new Comparator<CTGradientStop>() { // from class: org.apache.poi.xslf.usermodel.RenderableShape.2
            @Override // java.util.Comparator
            public int compare(CTGradientStop cTGradientStop, CTGradientStop cTGradientStop2) {
                return Integer.valueOf(cTGradientStop.getPos()).compareTo(Integer.valueOf(cTGradientStop2.getPos()));
            }
        });
        gsArray[1].setPos(50000);
        CTGradientFillProperties newInstance = CTGradientFillProperties.Factory.newInstance();
        newInstance.set(cTGradientFillProperties);
        newInstance.getGsLst().setGsArray(new CTGradientStop[]{gsArray[0], gsArray[1]});
        return createRadialGradientPaint(newInstance, rectangle2D, xSLFTheme, cTSchemeColor);
    }

    private static Paint createRadialGradientPaint(CTGradientFillProperties cTGradientFillProperties, Rectangle2D rectangle2D, XSLFTheme xSLFTheme, CTSchemeColor cTSchemeColor) {
        CTGradientStop[] gsArray = cTGradientFillProperties.getGsLst().getGsArray();
        Point2D.Double r0 = new Point2D.Double(rectangle2D.getX() + (rectangle2D.getWidth() / 2.0d), rectangle2D.getY() + (rectangle2D.getHeight() / 2.0d));
        float max = (float) Math.max(rectangle2D.getWidth(), rectangle2D.getHeight());
        Arrays.sort(gsArray, new Comparator<CTGradientStop>() { // from class: org.apache.poi.xslf.usermodel.RenderableShape.3
            @Override // java.util.Comparator
            public int compare(CTGradientStop cTGradientStop, CTGradientStop cTGradientStop2) {
                return Integer.valueOf(cTGradientStop.getPos()).compareTo(Integer.valueOf(cTGradientStop2.getPos()));
            }
        });
        int length = gsArray.length;
        Color[] colorArr = new Color[length];
        float[] fArr = new float[gsArray.length];
        for (int i = 0; i < gsArray.length; i++) {
            colorArr[i] = new XSLFColor(gsArray[i], xSLFTheme, cTSchemeColor).getColor();
            fArr[i] = r7.getPos() / 100000.0f;
        }
        try {
            return (Paint) Class.forName("java.awt.RadialGradientPaint").getConstructor(Point2D.class, Float.TYPE, float[].class, Color[].class).newInstance(r0, Float.valueOf(max), fArr, colorArr);
        } catch (ClassNotFoundException unused) {
            return new GradientPaint(new Point2D.Double(rectangle2D.getX(), rectangle2D.getY()), colorArr[0], r0, colorArr[length - 1]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void snapToAnchor(Point2D point2D, Rectangle2D rectangle2D) {
        if (point2D.getX() < rectangle2D.getX()) {
            point2D.setLocation(rectangle2D.getX(), point2D.getY());
        } else if (point2D.getX() > rectangle2D.getX() + rectangle2D.getWidth()) {
            point2D.setLocation(rectangle2D.getX() + rectangle2D.getWidth(), point2D.getY());
        }
        if (point2D.getY() < rectangle2D.getY()) {
            point2D.setLocation(point2D.getX(), rectangle2D.getY());
        } else if (point2D.getY() > rectangle2D.getY() + rectangle2D.getHeight()) {
            point2D.setLocation(point2D.getX(), rectangle2D.getY() + rectangle2D.getHeight());
        }
    }

    Paint getPaint(Graphics2D graphics2D, XmlObject xmlObject, CTSchemeColor cTSchemeColor) {
        Paint paint = null;
        for (XmlObject xmlObject2 : xmlObject.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            paint = selectPaint(graphics2D, xmlObject2, cTSchemeColor, this._shape.getSheet().getPackagePart());
            if (paint != null) {
                break;
            }
        }
        if (paint == NO_PAINT) {
            return null;
        }
        return paint;
    }

    Paint getFillPaint(final Graphics2D graphics2D) {
        CTShapeStyle spStyle;
        XmlObject xmlObject;
        PropertyFetcher<Paint> propertyFetcher = new PropertyFetcher<Paint>() { // from class: org.apache.poi.xslf.usermodel.RenderableShape.4
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
                CTShapeProperties spPr = xSLFSimpleShape.getSpPr();
                if (spPr.isSetNoFill()) {
                    setValue(RenderableShape.NO_PAINT);
                    return true;
                }
                Paint paint = RenderableShape.this.getPaint(graphics2D, spPr, null);
                if (paint == null) {
                    return false;
                }
                setValue(paint);
                return true;
            }
        };
        this._shape.fetchShapeProperty(propertyFetcher);
        Paint value = propertyFetcher.getValue();
        if (value == null && (spStyle = this._shape.getSpStyle()) != null) {
            CTStyleMatrixReference fillRef = spStyle.getFillRef();
            int idx = (int) fillRef.getIdx();
            CTSchemeColor schemeClr = fillRef.getSchemeClr();
            XSLFSheet sheet = this._shape.getSheet();
            XSLFTheme theme = sheet.getTheme();
            if (idx >= 1 && idx <= 999) {
                xmlObject = theme.getXmlObject().getThemeElements().getFmtScheme().getFillStyleLst().selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)[idx - 1];
            } else {
                xmlObject = idx >= 1001 ? theme.getXmlObject().getThemeElements().getFmtScheme().getBgFillStyleLst().selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)[idx - 1001] : null;
            }
            if (xmlObject != null) {
                value = selectPaint(graphics2D, xmlObject, schemeClr, sheet.getPackagePart());
            }
        }
        if (value == NO_PAINT) {
            return null;
        }
        return value;
    }

    public Paint getLinePaint(final Graphics2D graphics2D) {
        CTShapeStyle spStyle;
        PropertyFetcher<Paint> propertyFetcher = new PropertyFetcher<Paint>() { // from class: org.apache.poi.xslf.usermodel.RenderableShape.5
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
                CTLineProperties ln = xSLFSimpleShape.getSpPr().getLn();
                if (ln == null) {
                    return false;
                }
                if (ln.isSetNoFill()) {
                    setValue(RenderableShape.NO_PAINT);
                    return true;
                }
                Paint paint = RenderableShape.this.getPaint(graphics2D, ln, null);
                if (paint == null) {
                    return false;
                }
                setValue(paint);
                return true;
            }
        };
        this._shape.fetchShapeProperty(propertyFetcher);
        Paint value = propertyFetcher.getValue();
        if (value == null && (spStyle = this._shape.getSpStyle()) != null) {
            CTStyleMatrixReference lnRef = spStyle.getLnRef();
            int idx = (int) lnRef.getIdx();
            CTSchemeColor schemeClr = lnRef.getSchemeClr();
            if (idx > 0) {
                value = getPaint(graphics2D, this._shape.getSheet().getTheme().getXmlObject().getThemeElements().getFmtScheme().getLnStyleLst().selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)[idx - 1], schemeClr);
            }
        }
        if (value == NO_PAINT) {
            return null;
        }
        return value;
    }

    private static float[] getDashPattern(LineDash lineDash, float f) {
        switch (AnonymousClass7.$SwitchMap$org$apache$poi$xslf$usermodel$LineDash[lineDash.ordinal()]) {
            case 1:
                return new float[]{f, f};
            case 2:
                float f2 = f * 2.0f;
                return new float[]{f2, f2};
            case 3:
                return new float[]{3.0f * f, f * 4.0f};
            case 4:
                float f3 = 3.0f * f;
                return new float[]{4.0f * f, f3, f, f3};
            case 5:
                return new float[]{8.0f * f, f * 3.0f};
            case 6:
                float f4 = 3.0f * f;
                return new float[]{8.0f * f, f4, f, f4};
            case 7:
                float f5 = 3.0f * f;
                return new float[]{8.0f * f, f5, f, f5, f, f5};
            default:
                return null;
        }
    }

    public Stroke applyStroke(Graphics2D graphics2D) {
        float lineWidth = (float) this._shape.getLineWidth();
        if (lineWidth == 0.0f) {
            lineWidth = 0.25f;
        }
        float f = lineWidth;
        LineDash lineDash = this._shape.getLineDash();
        float[] dashPattern = lineDash != null ? getDashPattern(lineDash, f) : null;
        LineCap lineCap = this._shape.getLineCap();
        int i = 1;
        if (lineCap != null) {
            int i2 = AnonymousClass7.$SwitchMap$org$apache$poi$xslf$usermodel$LineCap[lineCap.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    i = 2;
                }
            }
            BasicStroke basicStroke = new BasicStroke(f, i, 1, Math.max(1.0f, f), dashPattern, 0.0f);
            graphics2D.setStroke(basicStroke);
            return basicStroke;
        }
        i = 0;
        BasicStroke basicStroke2 = new BasicStroke(f, i, 1, Math.max(1.0f, f), dashPattern, 0.0f);
        graphics2D.setStroke(basicStroke2);
        return basicStroke2;
    }

    /* renamed from: org.apache.poi.xslf.usermodel.RenderableShape$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$LineCap;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$LineDash;

        static {
            int[] iArr = new int[LineCap.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$LineCap = iArr;
            try {
                iArr[LineCap.ROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineCap[LineCap.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[LineDash.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$LineDash = iArr2;
            try {
                iArr2[LineDash.SYS_DOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDash[LineDash.SYS_DASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDash[LineDash.DASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDash[LineDash.DASH_DOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDash[LineDash.LG_DASH.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDash[LineDash.LG_DASH_DOT.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDash[LineDash.LG_DASH_DOT_DOT.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public void render(Graphics2D graphics2D) {
        Collection<Outline> computeOutlines = computeOutlines(graphics2D);
        XSLFShadow shadow = this._shape.getShadow();
        Paint fillPaint = getFillPaint(graphics2D);
        Paint linePaint = getLinePaint(graphics2D);
        applyStroke(graphics2D);
        if (shadow != null) {
            for (Outline outline : computeOutlines) {
                if (outline.getPath().isFilled()) {
                    if (fillPaint != null) {
                        shadow.fill(graphics2D, outline.getOutline());
                    } else if (linePaint != null) {
                        shadow.draw(graphics2D, outline.getOutline());
                    }
                }
            }
        }
        if (fillPaint != null) {
            for (Outline outline2 : computeOutlines) {
                if (outline2.getPath().isFilled()) {
                    graphics2D.setPaint(fillPaint);
                    graphics2D.fill(outline2.getOutline());
                }
            }
        }
        this._shape.drawContent(graphics2D);
        if (linePaint != null) {
            for (Outline outline3 : computeOutlines) {
                if (outline3.getPath().isStroked()) {
                    graphics2D.setPaint(linePaint);
                    graphics2D.draw(outline3.getOutline());
                }
            }
        }
    }

    private Collection<Outline> computeOutlines(Graphics2D graphics2D) {
        ArrayList arrayList = new ArrayList();
        CustomGeometry geometry = this._shape.getGeometry();
        if (geometry == null) {
            return arrayList;
        }
        Rectangle2D anchor = getAnchor(graphics2D);
        Iterator<Path> it = geometry.iterator();
        while (it.hasNext()) {
            Path next = it.next();
            GeneralPath path = next.getPath(new Context(geometry, new Rectangle2D.Double(0.0d, 0.0d, next.getW() == -1 ? anchor.getWidth() * 12700.0d : next.getW(), next.getH() == -1 ? anchor.getHeight() * 12700.0d : next.getH()), new IAdjustableShape() { // from class: org.apache.poi.xslf.usermodel.RenderableShape.6
                @Override // org.apache.poi.xslf.model.geom.IAdjustableShape
                public Guide getAdjustValue(String str) {
                    CTPresetGeometry2D prstGeom = RenderableShape.this._shape.getSpPr().getPrstGeom();
                    if (prstGeom == null || !prstGeom.isSetAvLst()) {
                        return null;
                    }
                    for (CTGeomGuide cTGeomGuide : prstGeom.getAvLst().getGdArray()) {
                        if (cTGeomGuide.getName().equals(str)) {
                            return new Guide(cTGeomGuide);
                        }
                    }
                    return null;
                }
            }));
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.translate(anchor.getX(), anchor.getY());
            affineTransform.scale(next.getW() != -1 ? anchor.getWidth() / next.getW() : 7.874015748031496E-5d, next.getH() != -1 ? anchor.getHeight() / next.getH() : 7.874015748031496E-5d);
            arrayList.add(new Outline(affineTransform.createTransformedShape(path), next));
        }
        return arrayList;
    }

    public Rectangle2D getAnchor(Graphics2D graphics2D) {
        AffineTransform affineTransform;
        Rectangle2D anchor = this._shape.getAnchor();
        return (graphics2D == null || (affineTransform = (AffineTransform) graphics2D.getRenderingHint(XSLFRenderingHint.GROUP_TRANSFORM)) == null) ? anchor : affineTransform.createTransformedShape(anchor).getBounds2D();
    }
}
