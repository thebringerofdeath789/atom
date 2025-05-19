package org.apache.poi.xslf.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

/* loaded from: classes5.dex */
public class PPTX2PNG {
    static void usage() {
        System.out.println("Usage: PPTX2PNG [options] <pptx file>");
        System.out.println("Options:");
        System.out.println("    -scale <float>   scale factor");
        System.out.println("    -slide <integer> 1-based index of a slide to render");
    }

    public static void main(String[] strArr) throws Exception {
        int i;
        if (strArr.length == 0) {
            usage();
            return;
        }
        float f = 1.0f;
        String str = null;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (i4 < strArr.length) {
            if (strArr[i4].startsWith("-")) {
                if ("-scale".equals(strArr[i4])) {
                    i4++;
                    f = Float.parseFloat(strArr[i4]);
                } else if ("-slide".equals(strArr[i4])) {
                    i4++;
                    i3 = Integer.parseInt(strArr[i4]);
                }
            } else {
                str = strArr[i4];
            }
            i4++;
        }
        if (str == null) {
            usage();
            return;
        }
        System.out.println("Processing " + str);
        XMLSlideShow xMLSlideShow = new XMLSlideShow(OPCPackage.open(str));
        Dimension pageSize = xMLSlideShow.getPageSize();
        int i5 = (int) (pageSize.width * f);
        int i6 = (int) (pageSize.height * f);
        XSLFSlide[] slides = xMLSlideShow.getSlides();
        int i7 = 0;
        while (i7 < slides.length) {
            if (i3 == i2 || i3 == i7 + 1) {
                String title = slides[i7].getTitle();
                int i8 = i7 + 1;
                System.out.println("Rendering slide " + i8 + (title == null ? "" : ": " + title));
                BufferedImage bufferedImage = new BufferedImage(i5, i6, 1);
                Graphics2D createGraphics = bufferedImage.createGraphics();
                createGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                createGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                createGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                createGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                createGraphics.setColor(Color.white);
                createGraphics.clearRect(0, 0, i5, i6);
                double d = f;
                createGraphics.scale(d, d);
                slides[i7].draw(createGraphics);
                int lastIndexOf = str.lastIndexOf(".");
                StringBuilder sb = new StringBuilder();
                i = -1;
                if (lastIndexOf == -1) {
                    lastIndexOf = str.length();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(sb.append(str.substring(0, lastIndexOf)).append("-").append(i8).append(".png").toString());
                ImageIO.write(bufferedImage, ContentTypes.EXTENSION_PNG, fileOutputStream);
                fileOutputStream.close();
            } else {
                i = i2;
            }
            i7++;
            i2 = i;
        }
        System.out.println("Done");
    }
}
