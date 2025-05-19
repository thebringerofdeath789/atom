package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;

/* loaded from: classes5.dex */
public class XWPFComment {
    protected String author;
    protected String id;
    protected StringBuffer text = new StringBuffer();

    public XWPFComment(CTComment cTComment, XWPFDocument xWPFDocument) {
        this.id = cTComment.getId().toString();
        this.author = cTComment.getAuthor();
        for (CTP ctp : cTComment.getPArray()) {
            this.text.append(new XWPFParagraph(ctp, xWPFDocument).getText());
        }
    }

    public String getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getText() {
        return this.text.toString();
    }
}
