package org.apache.poi.hssf.usermodel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public class EscherGraphics extends Graphics {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) EscherGraphics.class);
    private Color background;
    private HSSFShapeGroup escherGroup;
    private Font font;
    private Color foreground;
    private float verticalPixelsPerPoint;
    private float verticalPointsPerPixel;
    private HSSFWorkbook workbook;

    public void dispose() {
    }

    public Rectangle getClipBounds() {
        return null;
    }

    public void setClip(Shape shape) {
    }

    public EscherGraphics(HSSFShapeGroup hSSFShapeGroup, HSSFWorkbook hSSFWorkbook, Color color, float f) {
        this.verticalPointsPerPixel = 1.0f;
        this.background = Color.white;
        this.escherGroup = hSSFShapeGroup;
        this.workbook = hSSFWorkbook;
        this.verticalPointsPerPixel = f;
        this.verticalPixelsPerPoint = 1.0f / f;
        this.font = new Font(HSSFFont.FONT_ARIAL, 0, 10);
        this.foreground = color;
    }

    EscherGraphics(HSSFShapeGroup hSSFShapeGroup, HSSFWorkbook hSSFWorkbook, Color color, Font font, float f) {
        this.verticalPointsPerPixel = 1.0f;
        this.background = Color.white;
        this.escherGroup = hSSFShapeGroup;
        this.workbook = hSSFWorkbook;
        this.foreground = color;
        this.font = font;
        this.verticalPointsPerPixel = f;
        this.verticalPixelsPerPoint = 1.0f / f;
    }

    public void clearRect(int i, int i2, int i3, int i4) {
        Color color = this.foreground;
        setColor(this.background);
        fillRect(i, i2, i3, i4);
        setColor(color);
    }

    public void clipRect(int i, int i2, int i3, int i4) {
        if (logger.check(5)) {
            logger.log(5, "clipRect not supported");
        }
    }

    public void copyArea(int i, int i2, int i3, int i4, int i5, int i6) {
        if (logger.check(5)) {
            logger.log(5, "copyArea not supported");
        }
    }

    public Graphics create() {
        return new EscherGraphics(this.escherGroup, this.workbook, this.foreground, this.font, this.verticalPointsPerPixel);
    }

    public void drawArc(int i, int i2, int i3, int i4, int i5, int i6) {
        if (logger.check(5)) {
            logger.log(5, "drawArc not supported");
        }
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        if (!logger.check(5)) {
            return true;
        }
        logger.log(5, "drawImage not supported");
        return true;
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        if (!logger.check(5)) {
            return true;
        }
        logger.log(5, "drawImage not supported");
        return true;
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, Color color, ImageObserver imageObserver) {
        return drawImage(image, i, i2, i + i3, i2 + i4, 0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, ImageObserver imageObserver) {
        return drawImage(image, i, i2, i + i3, i2 + i4, 0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, Color color, ImageObserver imageObserver) {
        return drawImage(image, i, i2, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver) {
        return drawImage(image, i, i2, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        drawLine(i, i2, i3, i4, 0);
    }

    public void drawLine(int i, int i2, int i3, int i4, int i5) {
        HSSFSimpleShape createShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3, i4));
        createShape.setShapeType(20);
        createShape.setLineWidth(i5);
        createShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    public void drawOval(int i, int i2, int i3, int i4) {
        HSSFSimpleShape createShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3 + i, i4 + i2));
        createShape.setShapeType(3);
        createShape.setLineWidth(0);
        createShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        createShape.setNoFill(true);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i) {
        int findBiggest = findBiggest(iArr);
        int findBiggest2 = findBiggest(iArr2);
        int findSmallest = findSmallest(iArr);
        int findSmallest2 = findSmallest(iArr2);
        HSSFPolygon createPolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(findSmallest, findSmallest2, findBiggest, findBiggest2));
        createPolygon.setPolygonDrawArea(findBiggest - findSmallest, findBiggest2 - findSmallest2);
        createPolygon.setPoints(addToAll(iArr, -findSmallest), addToAll(iArr2, -findSmallest2));
        createPolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        createPolygon.setLineWidth(0);
        createPolygon.setNoFill(true);
    }

    private int[] addToAll(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = iArr[i2] + i;
        }
        return iArr2;
    }

    public void drawPolyline(int[] iArr, int[] iArr2, int i) {
        if (logger.check(5)) {
            logger.log(5, "drawPolyline not supported");
        }
    }

    public void drawRect(int i, int i2, int i3, int i4) {
        if (logger.check(5)) {
            logger.log(5, "drawRect not supported");
        }
    }

    public void drawRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        if (logger.check(5)) {
            logger.log(5, "drawRoundRect not supported");
        }
    }

    public void drawString(String str, int i, int i2) {
        Font font;
        if (str == null || str.equals("")) {
            return;
        }
        if (this.font.getName().equals("SansSerif")) {
            font = new Font(HSSFFont.FONT_ARIAL, this.font.getStyle(), (int) (this.font.getSize() / this.verticalPixelsPerPoint));
        } else {
            font = new Font(this.font.getName(), this.font.getStyle(), (int) (this.font.getSize() / this.verticalPixelsPerPoint));
        }
        int stringWidth = (StaticFontMetrics.getFontDetails(font).getStringWidth(str) * 8) + 12;
        int size = ((int) ((this.font.getSize() / this.verticalPixelsPerPoint) + 6.0f)) * 2;
        float size2 = this.font.getSize();
        float f = this.verticalPixelsPerPoint;
        int i3 = (int) (i2 - ((size2 / f) + (f * 2.0f)));
        HSSFTextbox createTextbox = this.escherGroup.createTextbox(new HSSFChildAnchor(i, i3, stringWidth + i, size + i3));
        createTextbox.setNoFill(true);
        createTextbox.setLineStyle(-1);
        HSSFRichTextString hSSFRichTextString = new HSSFRichTextString(str);
        hSSFRichTextString.applyFont(matchFont(font));
        createTextbox.setString(hSSFRichTextString);
    }

    private HSSFFont matchFont(Font font) {
        HSSFColor findColor = this.workbook.getCustomPalette().findColor((byte) this.foreground.getRed(), (byte) this.foreground.getGreen(), (byte) this.foreground.getBlue());
        if (findColor == null) {
            findColor = this.workbook.getCustomPalette().findSimilarColor((byte) this.foreground.getRed(), (byte) this.foreground.getGreen(), (byte) this.foreground.getBlue());
        }
        boolean z = (font.getStyle() & 1) != 0;
        boolean z2 = (font.getStyle() & 2) != 0;
        HSSFFont findFont = this.workbook.findFont(z ? (short) 700 : (short) 0, findColor.getIndex(), (short) (font.getSize() * 20), font.getName(), z2, false, (short) 0, (byte) 0);
        if (findFont == null) {
            findFont = this.workbook.createFont();
            findFont.setBoldweight(z ? (short) 700 : (short) 0);
            findFont.setColor(findColor.getIndex());
            findFont.setFontHeight((short) (font.getSize() * 20));
            findFont.setFontName(font.getName());
            findFont.setItalic(z2);
            findFont.setStrikeout(false);
            findFont.setTypeOffset((short) 0);
            findFont.setUnderline((byte) 0);
        }
        return findFont;
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2) {
        if (logger.check(5)) {
            logger.log(5, "drawString not supported");
        }
    }

    public void fillArc(int i, int i2, int i3, int i4, int i5, int i6) {
        if (logger.check(5)) {
            logger.log(5, "fillArc not supported");
        }
    }

    public void fillOval(int i, int i2, int i3, int i4) {
        HSSFSimpleShape createShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3 + i, i4 + i2));
        createShape.setShapeType(3);
        createShape.setLineStyle(-1);
        createShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        createShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        createShape.setNoFill(false);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i) {
        int findBiggest = findBiggest(iArr);
        int findBiggest2 = findBiggest(iArr2);
        int findSmallest = findSmallest(iArr);
        int findSmallest2 = findSmallest(iArr2);
        HSSFPolygon createPolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(findSmallest, findSmallest2, findBiggest, findBiggest2));
        createPolygon.setPolygonDrawArea(findBiggest - findSmallest, findBiggest2 - findSmallest2);
        createPolygon.setPoints(addToAll(iArr, -findSmallest), addToAll(iArr2, -findSmallest2));
        createPolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        createPolygon.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    private int findBiggest(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    private int findSmallest(int[] iArr) {
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public void fillRect(int i, int i2, int i3, int i4) {
        HSSFSimpleShape createShape = this.escherGroup.createShape(new HSSFChildAnchor(i, i2, i3 + i, i4 + i2));
        createShape.setShapeType(1);
        createShape.setLineStyle(-1);
        createShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        createShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    public void fillRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        if (logger.check(5)) {
            logger.log(5, "fillRoundRect not supported");
        }
    }

    public Shape getClip() {
        return getClipBounds();
    }

    public Rectangle getClipRect() {
        return getClipBounds();
    }

    public Color getColor() {
        return this.foreground;
    }

    public Font getFont() {
        return this.font;
    }

    public FontMetrics getFontMetrics(Font font) {
        return Toolkit.getDefaultToolkit().getFontMetrics(font);
    }

    public void setClip(int i, int i2, int i3, int i4) {
        setClip(new Rectangle(i, i2, i3, i4));
    }

    public void setColor(Color color) {
        this.foreground = color;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setPaintMode() {
        if (logger.check(5)) {
            logger.log(5, "setPaintMode not supported");
        }
    }

    public void setXORMode(Color color) {
        if (logger.check(5)) {
            logger.log(5, "setXORMode not supported");
        }
    }

    public void translate(int i, int i2) {
        if (logger.check(5)) {
            logger.log(5, "translate not supported");
        }
    }

    public Color getBackground() {
        return this.background;
    }

    public void setBackground(Color color) {
        this.background = color;
    }

    HSSFShapeGroup getEscherGraphics() {
        return this.escherGroup;
    }
}
