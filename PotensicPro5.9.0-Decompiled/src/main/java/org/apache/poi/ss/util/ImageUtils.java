package org.apache.poi.ss.util;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class ImageUtils {
    public static final int PIXEL_DPI = 96;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) ImageUtils.class);

    public static Dimension getImageDimension(InputStream inputStream, int i) {
        Dimension dimension = new Dimension();
        if (i == 5 || i == 6 || i == 7) {
            try {
                ImageInputStream createImageInputStream = ImageIO.createImageInputStream(inputStream);
                try {
                    ImageReader imageReader = (ImageReader) ImageIO.getImageReaders(createImageInputStream).next();
                    try {
                        imageReader.setInput(createImageInputStream);
                        BufferedImage read = imageReader.read(0);
                        int[] resolution = getResolution(imageReader);
                        if (resolution[0] == 0) {
                            resolution[0] = 96;
                        }
                        if (resolution[1] == 0) {
                            resolution[1] = 96;
                        }
                        dimension.width = (read.getWidth() * 96) / resolution[0];
                        dimension.height = (read.getHeight() * 96) / resolution[1];
                    } finally {
                        imageReader.dispose();
                    }
                } finally {
                    createImageInputStream.close();
                }
            } catch (IOException e) {
                logger.log(5, (Throwable) e);
            }
        } else {
            logger.log(5, "Only JPEG, PNG and DIB pictures can be automatically sized");
        }
        return dimension;
    }

    public static int[] getResolution(ImageReader imageReader) throws IOException {
        Element element = (Element) imageReader.getImageMetadata(0).getAsTree("javax_imageio_1.0");
        NodeList elementsByTagName = element.getElementsByTagName("HorizontalPixelSize");
        int i = 96;
        int parseFloat = (elementsByTagName == null || elementsByTagName.getLength() != 1) ? 96 : (int) (25.4d / Float.parseFloat(((Element) elementsByTagName.item(0)).getAttribute("value")));
        NodeList elementsByTagName2 = element.getElementsByTagName("VerticalPixelSize");
        if (elementsByTagName2 != null && elementsByTagName2.getLength() == 1) {
            i = (int) (25.4d / Float.parseFloat(((Element) elementsByTagName2.item(0)).getAttribute("value")));
        }
        return new int[]{parseFloat, i};
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009b, code lost:
    
        if (r2 < 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.awt.Dimension setPreferredSize(org.apache.poi.ss.usermodel.Picture r18, double r19, double r21) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.util.ImageUtils.setPreferredSize(org.apache.poi.ss.usermodel.Picture, double, double):java.awt.Dimension");
    }

    public static Dimension getDimensionFromAnchor(Picture picture) {
        double dx1;
        double dx2;
        double dy1;
        double dy2;
        ClientAnchor clientAnchor = picture.getClientAnchor();
        boolean z = clientAnchor instanceof HSSFClientAnchor;
        Sheet sheet = picture.getSheet();
        short col1 = clientAnchor.getCol1();
        int i = col1 + 1;
        double columnWidthInPixels = sheet.getColumnWidthInPixels(col1);
        if (z) {
            dx1 = columnWidthInPixels * (1.0d - (clientAnchor.getDx1() / 1024.0d));
        } else {
            dx1 = columnWidthInPixels - (clientAnchor.getDx1() / 9525);
        }
        while (i < clientAnchor.getCol2()) {
            dx1 += sheet.getColumnWidthInPixels(i);
            i++;
        }
        if (z) {
            dx2 = (sheet.getColumnWidthInPixels(i) * clientAnchor.getDx2()) / 1024.0d;
        } else {
            dx2 = clientAnchor.getDx2() / 9525;
        }
        double d = dx1 + dx2;
        int row1 = clientAnchor.getRow1();
        int i2 = row1 + 1;
        double rowHeightInPixels = getRowHeightInPixels(sheet, row1);
        if (z) {
            dy1 = rowHeightInPixels * (1.0d - (clientAnchor.getDy1() / 256.0d));
        } else {
            dy1 = rowHeightInPixels - (clientAnchor.getDy1() / 9525);
        }
        while (i2 < clientAnchor.getRow2()) {
            dy1 += getRowHeightInPixels(sheet, i2);
            i2++;
        }
        if (z) {
            dy2 = dy1 + ((getRowHeightInPixels(sheet, i2) * clientAnchor.getDy2()) / 256.0d);
        } else {
            dy2 = dy1 + (clientAnchor.getDy2() / 9525);
        }
        return new Dimension(((int) d) * 9525, ((int) dy2) * 9525);
    }

    private static double getRowHeightInPixels(Sheet sheet, int i) {
        return Units.toEMU(sheet.getRow(i) == null ? sheet.getDefaultRowHeightInPoints() : r1.getHeightInPoints()) / 9525;
    }
}
