package org.apache.poi.hssf.usermodel;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/* loaded from: classes5.dex */
public class DummyGraphics2d extends Graphics2D {
    private Graphics2D g2D;
    BufferedImage img;

    public DummyGraphics2d() {
        BufferedImage bufferedImage = new BufferedImage(1000, 1000, 2);
        this.img = bufferedImage;
        this.g2D = bufferedImage.getGraphics();
    }

    public void addRenderingHints(Map<?, ?> map) {
        System.out.println("addRenderingHinds(Map):");
        System.out.println("  hints = " + map);
        this.g2D.addRenderingHints(map);
    }

    public void clip(Shape shape) {
        System.out.println("clip(Shape):");
        System.out.println("  s = " + shape);
        this.g2D.clip(shape);
    }

    public void draw(Shape shape) {
        System.out.println("draw(Shape):");
        System.out.println("s = " + shape);
        this.g2D.draw(shape);
    }

    public void drawGlyphVector(GlyphVector glyphVector, float f, float f2) {
        System.out.println("drawGlyphVector(GlyphVector, float, float):");
        System.out.println("g = " + glyphVector);
        System.out.println("x = " + f);
        System.out.println("y = " + f2);
        this.g2D.drawGlyphVector(glyphVector, f, f2);
    }

    public void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i, int i2) {
        System.out.println("drawImage(BufferedImage, BufferedImageOp, x, y):");
        System.out.println("img = " + bufferedImage);
        System.out.println("op = " + bufferedImageOp);
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        this.g2D.drawImage(bufferedImage, bufferedImageOp, i, i2);
    }

    public boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver) {
        System.out.println("drawImage(Image,AfflineTransform,ImageObserver):");
        System.out.println("img = " + image);
        System.out.println("xform = " + affineTransform);
        System.out.println("obs = " + imageObserver);
        return this.g2D.drawImage(image, affineTransform, imageObserver);
    }

    public void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform) {
        System.out.println("drawRenderableImage(RenderableImage, AfflineTransform):");
        System.out.println("img = " + renderableImage);
        System.out.println("xform = " + affineTransform);
        this.g2D.drawRenderableImage(renderableImage, affineTransform);
    }

    public void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform) {
        System.out.println("drawRenderedImage(RenderedImage, AffineTransform):");
        System.out.println("img = " + renderedImage);
        System.out.println("xform = " + affineTransform);
        this.g2D.drawRenderedImage(renderedImage, affineTransform);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, float f, float f2) {
        System.out.println("drawString(AttributedCharacterIterator):");
        System.out.println("iterator = " + attributedCharacterIterator);
        System.out.println("x = " + f);
        System.out.println("y = " + f2);
        this.g2D.drawString(attributedCharacterIterator, f, f2);
    }

    public void drawString(String str, float f, float f2) {
        System.out.println("drawString(s,x,y):");
        System.out.println("s = " + str);
        System.out.println("x = " + f);
        System.out.println("y = " + f2);
        this.g2D.drawString(str, f, f2);
    }

    public void fill(Shape shape) {
        System.out.println("fill(Shape):");
        System.out.println("s = " + shape);
        this.g2D.fill(shape);
    }

    public Color getBackground() {
        System.out.println("getBackground():");
        return this.g2D.getBackground();
    }

    public Composite getComposite() {
        System.out.println("getComposite():");
        return this.g2D.getComposite();
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        System.out.println("getDeviceConfiguration():");
        return this.g2D.getDeviceConfiguration();
    }

    public FontRenderContext getFontRenderContext() {
        System.out.println("getFontRenderContext():");
        return this.g2D.getFontRenderContext();
    }

    public Paint getPaint() {
        System.out.println("getPaint():");
        return this.g2D.getPaint();
    }

    public Object getRenderingHint(RenderingHints.Key key) {
        System.out.println("getRenderingHint(RenderingHints.Key):");
        System.out.println("hintKey = " + key);
        return this.g2D.getRenderingHint(key);
    }

    public RenderingHints getRenderingHints() {
        System.out.println("getRenderingHints():");
        return this.g2D.getRenderingHints();
    }

    public Stroke getStroke() {
        System.out.println("getStroke():");
        return this.g2D.getStroke();
    }

    public AffineTransform getTransform() {
        System.out.println("getTransform():");
        return this.g2D.getTransform();
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean z) {
        System.out.println("hit(Rectangle, Shape, onStroke):");
        System.out.println("rect = " + rectangle);
        System.out.println("s = " + shape);
        System.out.println("onStroke = " + z);
        return this.g2D.hit(rectangle, shape, z);
    }

    public void rotate(double d) {
        System.out.println("rotate(theta):");
        System.out.println("theta = " + d);
        this.g2D.rotate(d);
    }

    public void rotate(double d, double d2, double d3) {
        System.out.println("rotate(double,double,double):");
        System.out.println("theta = " + d);
        System.out.println("x = " + d2);
        System.out.println("y = " + d3);
        this.g2D.rotate(d, d2, d3);
    }

    public void scale(double d, double d2) {
        System.out.println("scale(double,double):");
        System.out.println("sx = " + d);
        System.out.println("sy");
        this.g2D.scale(d, d2);
    }

    public void setBackground(Color color) {
        System.out.println("setBackground(Color):");
        System.out.println("color = " + color);
        this.g2D.setBackground(color);
    }

    public void setComposite(Composite composite) {
        System.out.println("setComposite(Composite):");
        System.out.println("comp = " + composite);
        this.g2D.setComposite(composite);
    }

    public void setPaint(Paint paint) {
        System.out.println("setPain(Paint):");
        System.out.println("paint = " + paint);
        this.g2D.setPaint(paint);
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        System.out.println("setRenderingHint(RenderingHints.Key, Object):");
        System.out.println("hintKey = " + key);
        System.out.println("hintValue = " + obj);
        this.g2D.setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map<?, ?> map) {
        System.out.println("setRenderingHints(Map):");
        System.out.println("hints = " + map);
        this.g2D.setRenderingHints(map);
    }

    public void setStroke(Stroke stroke) {
        System.out.println("setStroke(Stoke):");
        System.out.println("s = " + stroke);
        this.g2D.setStroke(stroke);
    }

    public void setTransform(AffineTransform affineTransform) {
        System.out.println("setTransform():");
        System.out.println("Tx = " + affineTransform);
        this.g2D.setTransform(affineTransform);
    }

    public void shear(double d, double d2) {
        System.out.println("shear(shx, dhy):");
        System.out.println("shx = " + d);
        System.out.println("shy = " + d2);
        this.g2D.shear(d, d2);
    }

    public void transform(AffineTransform affineTransform) {
        System.out.println("transform(AffineTransform):");
        System.out.println("Tx = " + affineTransform);
        this.g2D.transform(affineTransform);
    }

    public void translate(double d, double d2) {
        System.out.println("translate(double, double):");
        System.out.println("tx = " + d);
        System.out.println("ty = " + d2);
        this.g2D.translate(d, d2);
    }

    public void clearRect(int i, int i2, int i3, int i4) {
        System.out.println("clearRect(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.clearRect(i, i2, i3, i4);
    }

    public void clipRect(int i, int i2, int i3, int i4) {
        System.out.println("clipRect(int, int, int, int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.clipRect(i, i2, i3, i4);
    }

    public void copyArea(int i, int i2, int i3, int i4, int i5, int i6) {
        System.out.println("copyArea(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.copyArea(i, i2, i3, i4, i5, i6);
    }

    public Graphics create() {
        System.out.println("create():");
        return this.g2D.create();
    }

    public Graphics create(int i, int i2, int i3, int i4) {
        System.out.println("create(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        return this.g2D.create(i, i2, i3, i4);
    }

    public void dispose() {
        System.out.println("dispose():");
        this.g2D.dispose();
    }

    public void draw3DRect(int i, int i2, int i3, int i4, boolean z) {
        System.out.println("draw3DRect(int,int,int,int,boolean):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        System.out.println("raised = " + z);
        this.g2D.draw3DRect(i, i2, i3, i4, z);
    }

    public void drawArc(int i, int i2, int i3, int i4, int i5, int i6) {
        System.out.println("drawArc(int,int,int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        System.out.println("startAngle = " + i5);
        System.out.println("arcAngle = " + i6);
        this.g2D.drawArc(i, i2, i3, i4, i5, i6);
    }

    public void drawBytes(byte[] bArr, int i, int i2, int i3, int i4) {
        System.out.println("drawBytes(byte[],int,int,int,int):");
        System.out.println("data = " + bArr);
        System.out.println("offset = " + i);
        System.out.println("length = " + i2);
        System.out.println("x = " + i3);
        System.out.println("y = " + i4);
        this.g2D.drawBytes(bArr, i, i2, i3, i4);
    }

    public void drawChars(char[] cArr, int i, int i2, int i3, int i4) {
        System.out.println("drawChars(data,int,int,int,int):");
        System.out.println("data = " + cArr.toString());
        System.out.println("offset = " + i);
        System.out.println("length = " + i2);
        System.out.println("x = " + i3);
        System.out.println("y = " + i4);
        this.g2D.drawChars(cArr, i, i2, i3, i4);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        System.out.println("drawImage(Image,int,int,int,int,int,int,int,int,ImageObserver):");
        System.out.println("img = " + image);
        System.out.println("dx1 = " + i);
        System.out.println("dy1 = " + i2);
        System.out.println("dx2 = " + i3);
        System.out.println("dy2 = " + i4);
        System.out.println("sx1 = " + i5);
        System.out.println("sy1 = " + i6);
        System.out.println("sx2 = " + i7);
        System.out.println("sy2 = " + i8);
        System.out.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, i5, i6, i7, i8, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        System.out.println("drawImage(Image,int,int,int,int,int,int,int,int,Color,ImageObserver):");
        System.out.println("img = " + image);
        System.out.println("dx1 = " + i);
        System.out.println("dy1 = " + i2);
        System.out.println("dx2 = " + i3);
        System.out.println("dy2 = " + i4);
        System.out.println("sx1 = " + i5);
        System.out.println("sy1 = " + i6);
        System.out.println("sx2 = " + i7);
        System.out.println("sy2 = " + i8);
        System.out.println("bgcolor = " + color);
        System.out.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, i5, i6, i7, i8, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, Color color, ImageObserver imageObserver) {
        System.out.println("drawImage(Image,int,int,Color,ImageObserver):");
        System.out.println("img = " + image);
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("bgcolor = " + color);
        System.out.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver) {
        System.out.println("drawImage(Image,int,int,observer):");
        System.out.println("img = " + image);
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, Color color, ImageObserver imageObserver) {
        System.out.println("drawImage(Image,int,int,int,int,Color,ImageObserver):");
        System.out.println("img = " + image);
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        System.out.println("bgcolor = " + color);
        System.out.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, ImageObserver imageObserver) {
        System.out.println("drawImage(Image,int,int,width,height,observer):");
        System.out.println("img = " + image);
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        System.out.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, imageObserver);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        System.out.println("drawLine(int,int,int,int):");
        System.out.println("x1 = " + i);
        System.out.println("y1 = " + i2);
        System.out.println("x2 = " + i3);
        System.out.println("y2 = " + i4);
        this.g2D.drawLine(i, i2, i3, i4);
    }

    public void drawOval(int i, int i2, int i3, int i4) {
        System.out.println("drawOval(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.drawOval(i, i2, i3, i4);
    }

    public void drawPolygon(Polygon polygon) {
        System.out.println("drawPolygon(Polygon):");
        System.out.println("p = " + polygon);
        this.g2D.drawPolygon(polygon);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i) {
        System.out.println("drawPolygon(int[],int[],int):");
        System.out.println("xPoints = " + iArr);
        System.out.println("yPoints = " + iArr2);
        System.out.println("nPoints = " + i);
        this.g2D.drawPolygon(iArr, iArr2, i);
    }

    public void drawPolyline(int[] iArr, int[] iArr2, int i) {
        System.out.println("drawPolyline(int[],int[],int):");
        System.out.println("xPoints = " + iArr);
        System.out.println("yPoints = " + iArr2);
        System.out.println("nPoints = " + i);
        this.g2D.drawPolyline(iArr, iArr2, i);
    }

    public void drawRect(int i, int i2, int i3, int i4) {
        System.out.println("drawRect(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.drawRect(i, i2, i3, i4);
    }

    public void drawRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        System.out.println("drawRoundRect(int,int,int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        System.out.println("arcWidth = " + i5);
        System.out.println("arcHeight = " + i6);
        this.g2D.drawRoundRect(i, i2, i3, i4, i5, i6);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2) {
        System.out.println("drawString(AttributedCharacterIterator,int,int):");
        System.out.println("iterator = " + attributedCharacterIterator);
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        this.g2D.drawString(attributedCharacterIterator, i, i2);
    }

    public void drawString(String str, int i, int i2) {
        System.out.println("drawString(str,int,int):");
        System.out.println("str = " + str);
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        this.g2D.drawString(str, i, i2);
    }

    public void fill3DRect(int i, int i2, int i3, int i4, boolean z) {
        System.out.println("fill3DRect(int,int,int,int,boolean):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        System.out.println("raised = " + z);
        this.g2D.fill3DRect(i, i2, i3, i4, z);
    }

    public void fillArc(int i, int i2, int i3, int i4, int i5, int i6) {
        System.out.println("fillArc(int,int,int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        System.out.println("startAngle = " + i5);
        System.out.println("arcAngle = " + i6);
        this.g2D.fillArc(i, i2, i3, i4, i5, i6);
    }

    public void fillOval(int i, int i2, int i3, int i4) {
        System.out.println("fillOval(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.fillOval(i, i2, i3, i4);
    }

    public void fillPolygon(Polygon polygon) {
        System.out.println("fillPolygon(Polygon):");
        System.out.println("p = " + polygon);
        this.g2D.fillPolygon(polygon);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i) {
        System.out.println("fillPolygon(int[],int[],int):");
        System.out.println("xPoints = " + iArr);
        System.out.println("yPoints = " + iArr2);
        System.out.println("nPoints = " + i);
        this.g2D.fillPolygon(iArr, iArr2, i);
    }

    public void fillRect(int i, int i2, int i3, int i4) {
        System.out.println("fillRect(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.fillRect(i, i2, i3, i4);
    }

    public void fillRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        System.out.println("fillRoundRect(int,int,int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.fillRoundRect(i, i2, i3, i4, i5, i6);
    }

    public void finalize() {
        System.out.println("finalize():");
        this.g2D.finalize();
        super.finalize();
    }

    public Shape getClip() {
        System.out.println("getClip():");
        return this.g2D.getClip();
    }

    public Rectangle getClipBounds() {
        System.out.println("getClipBounds():");
        return this.g2D.getClipBounds();
    }

    public Rectangle getClipBounds(Rectangle rectangle) {
        System.out.println("getClipBounds(Rectangle):");
        System.out.println("r = " + rectangle);
        return this.g2D.getClipBounds(rectangle);
    }

    public Rectangle getClipRect() {
        System.out.println("getClipRect():");
        return this.g2D.getClipRect();
    }

    public Color getColor() {
        System.out.println("getColor():");
        return this.g2D.getColor();
    }

    public Font getFont() {
        System.out.println("getFont():");
        return this.g2D.getFont();
    }

    public FontMetrics getFontMetrics() {
        System.out.println("getFontMetrics():");
        return this.g2D.getFontMetrics();
    }

    public FontMetrics getFontMetrics(Font font) {
        System.out.println("getFontMetrics():");
        return this.g2D.getFontMetrics(font);
    }

    public boolean hitClip(int i, int i2, int i3, int i4) {
        System.out.println("hitClip(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        return this.g2D.hitClip(i, i2, i3, i4);
    }

    public void setClip(Shape shape) {
        System.out.println("setClip(Shape):");
        System.out.println("clip = " + shape);
        this.g2D.setClip(shape);
    }

    public void setClip(int i, int i2, int i3, int i4) {
        System.out.println("setClip(int,int,int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        System.out.println("width = " + i3);
        System.out.println("height = " + i4);
        this.g2D.setClip(i, i2, i3, i4);
    }

    public void setColor(Color color) {
        System.out.println("setColor():");
        System.out.println("c = " + color);
        this.g2D.setColor(color);
    }

    public void setFont(Font font) {
        System.out.println("setFont(Font):");
        System.out.println("font = " + font);
        this.g2D.setFont(font);
    }

    public void setPaintMode() {
        System.out.println("setPaintMode():");
        this.g2D.setPaintMode();
    }

    public void setXORMode(Color color) {
        System.out.println("setXORMode(Color):");
        System.out.println("c1 = " + color);
        this.g2D.setXORMode(color);
    }

    public String toString() {
        System.out.println("toString():");
        return this.g2D.toString();
    }

    public void translate(int i, int i2) {
        System.out.println("translate(int,int):");
        System.out.println("x = " + i);
        System.out.println("y = " + i2);
        this.g2D.translate(i, i2);
    }
}
