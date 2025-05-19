package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

/* loaded from: classes5.dex */
public class DrawingTextBody {
    private final CTTextBody textBody;

    public DrawingTextBody(CTTextBody cTTextBody) {
        this.textBody = cTTextBody;
    }

    public DrawingParagraph[] getParagraphs() {
        CTTextParagraph[] pArray = this.textBody.getPArray();
        int length = pArray.length;
        DrawingParagraph[] drawingParagraphArr = new DrawingParagraph[length];
        for (int i = 0; i < length; i++) {
            drawingParagraphArr[i] = new DrawingParagraph(pArray[i]);
        }
        return drawingParagraphArr;
    }
}
