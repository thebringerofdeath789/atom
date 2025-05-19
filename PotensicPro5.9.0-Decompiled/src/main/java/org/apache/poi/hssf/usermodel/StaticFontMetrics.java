package org.apache.poi.hssf.usermodel;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes5.dex */
final class StaticFontMetrics {
    private static Map<String, FontDetails> fontDetailsMap = new HashMap();
    private static Properties fontMetricsProps;

    StaticFontMetrics() {
    }

    public static FontDetails getFontDetails(Font font) {
        String str;
        InputStream resourceAsStream;
        if (fontMetricsProps == null) {
            InputStream inputStream = null;
            try {
                try {
                    fontMetricsProps = new Properties();
                    try {
                        str = System.getProperty("font.metrics.filename");
                    } catch (SecurityException unused) {
                        str = null;
                    }
                    if (str != null) {
                        File file = new File(str);
                        if (!file.exists()) {
                            throw new FileNotFoundException("font_metrics.properties not found at path " + file.getAbsolutePath());
                        }
                        resourceAsStream = new FileInputStream(file);
                    } else {
                        resourceAsStream = FontDetails.class.getResourceAsStream("/font_metrics.properties");
                        if (resourceAsStream == null) {
                            throw new FileNotFoundException("font_metrics.properties not found in classpath");
                        }
                    }
                    fontMetricsProps.load(resourceAsStream);
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Could not load font metrics: " + e.getMessage());
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
        String name = font.getName();
        String str2 = font.isPlain() ? "plain" : "";
        if (font.isBold()) {
            str2 = str2 + TtmlNode.BOLD;
        }
        if (font.isItalic()) {
            str2 = str2 + TtmlNode.ITALIC;
        }
        if (fontMetricsProps.get(FontDetails.buildFontHeightProperty(name)) == null && fontMetricsProps.get(FontDetails.buildFontHeightProperty(name + "." + str2)) != null) {
            name = name + "." + str2;
        }
        if (fontDetailsMap.get(name) == null) {
            FontDetails create = FontDetails.create(name, fontMetricsProps);
            fontDetailsMap.put(name, create);
            return create;
        }
        return fontDetailsMap.get(name);
    }
}
