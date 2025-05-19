package org.apache.poi.ss.format;

import java.awt.Color;

/* loaded from: classes5.dex */
public class CellFormatResult {
    public final boolean applies;
    public final String text;
    public final Color textColor;

    public CellFormatResult(boolean z, String str, Color color) {
        this.applies = z;
        this.text = str;
        this.textColor = z ? color : null;
    }
}
