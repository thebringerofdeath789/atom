package org.apache.poi.xslf.usermodel;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

/* loaded from: classes5.dex */
public class DrawingParagraph {
    private final CTTextParagraph p;

    public DrawingParagraph(CTTextParagraph cTTextParagraph) {
        this.p = cTTextParagraph;
    }

    public CharSequence getText() {
        StringBuilder sb = new StringBuilder();
        XmlCursor newCursor = this.p.newCursor();
        newCursor.selectPath("./*");
        while (newCursor.toNextSelection()) {
            XmlObject object = newCursor.getObject();
            if (object instanceof CTRegularTextRun) {
                sb.append(((CTRegularTextRun) object).getT());
            } else if (object instanceof CTTextLineBreak) {
                sb.append('\n');
            }
        }
        newCursor.dispose();
        return sb;
    }
}
