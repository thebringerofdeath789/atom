package org.apache.poi.xslf.usermodel;

import com.google.android.exoplayer2.audio.AacUtil;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.opc.PackagePart;

/* loaded from: classes5.dex */
public class XSLFImageRenderer {
    public boolean drawImage(Graphics2D graphics2D, XSLFPictureData xSLFPictureData, Rectangle2D rectangle2D) {
        return drawImage(graphics2D, xSLFPictureData, rectangle2D, null);
    }

    public boolean drawImage(Graphics2D graphics2D, XSLFPictureData xSLFPictureData, Rectangle2D rectangle2D, Insets insets) {
        Insets insets2;
        boolean z;
        if (insets == null) {
            insets2 = new Insets(0, 0, 0, 0);
            z = false;
        } else {
            insets2 = insets;
            z = true;
        }
        try {
            BufferedImage read = ImageIO.read(xSLFPictureData.getPackagePart().getInputStream());
            if (read == null) {
                return false;
            }
            int width = read.getWidth();
            int height = read.getHeight();
            double d = width;
            double width2 = rectangle2D.getWidth() / ((((AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND - insets2.left) - insets2.right) / 100000.0d) * d);
            double d2 = height;
            double height2 = rectangle2D.getHeight() / ((((AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND - insets2.top) - insets2.bottom) / 100000.0d) * d2);
            AffineTransform affineTransform = new AffineTransform(width2, 0.0d, 0.0d, height2, rectangle2D.getX() - (((d * width2) * insets2.left) / 100000.0d), rectangle2D.getY() - (((d2 * height2) * insets2.top) / 100000.0d));
            Shape clip = graphics2D.getClip();
            if (z) {
                graphics2D.clip(rectangle2D.getBounds2D());
            }
            graphics2D.drawRenderedImage(read, affineTransform);
            graphics2D.setClip(clip);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public BufferedImage readImage(PackagePart packagePart) throws IOException {
        return ImageIO.read(packagePart.getInputStream());
    }
}
