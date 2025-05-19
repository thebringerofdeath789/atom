package org.apache.poi.xslf.model;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* loaded from: classes5.dex */
public abstract class CharacterPropertyFetcher<T> extends ParagraphPropertyFetcher<T> {
    public boolean isFetchingFromMaster;

    public abstract boolean fetch(CTTextCharacterProperties cTTextCharacterProperties);

    public CharacterPropertyFetcher(int i) {
        super(i);
        this.isFetchingFromMaster = false;
    }

    @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
    public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
        if (cTTextParagraphProperties.isSetDefRPr()) {
            return fetch(cTTextParagraphProperties.getDefRPr());
        }
        return false;
    }
}
