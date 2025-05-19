package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* loaded from: classes5.dex */
public class DrawingTextPlaceholder extends DrawingTextBody {
    private final CTPlaceholder placeholder;

    public DrawingTextPlaceholder(CTTextBody cTTextBody, CTPlaceholder cTPlaceholder) {
        super(cTTextBody);
        this.placeholder = cTPlaceholder;
    }

    public String getPlaceholderType() {
        return this.placeholder.getType().toString();
    }

    public STPlaceholderType.Enum getPlaceholderTypeEnum() {
        return this.placeholder.getType();
    }

    public boolean isPlaceholderCustom() {
        return this.placeholder.getHasCustomPrompt();
    }
}
