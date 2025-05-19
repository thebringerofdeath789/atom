package org.apache.poi.xslf.usermodel;

import java.awt.RenderingHints;
import org.apache.poi.util.Internal;

/* loaded from: classes5.dex */
public class XSLFRenderingHint extends RenderingHints.Key {
    public static final int TEXT_AS_CHARACTERS = 1;
    public static final int TEXT_AS_SHAPES = 2;
    public static final XSLFRenderingHint GSAVE = new XSLFRenderingHint(1);
    public static final XSLFRenderingHint GRESTORE = new XSLFRenderingHint(2);
    public static final XSLFRenderingHint IMAGE_RENDERER = new XSLFRenderingHint(3);
    public static final XSLFRenderingHint TEXT_RENDERING_MODE = new XSLFRenderingHint(4);

    @Internal
    static final XSLFRenderingHint GROUP_TRANSFORM = new XSLFRenderingHint(5);
    public static final XSLFRenderingHint FONT_HANDLER = new XSLFRenderingHint(6);

    public boolean isCompatibleValue(Object obj) {
        return true;
    }

    public XSLFRenderingHint(int i) {
        super(i);
    }
}
