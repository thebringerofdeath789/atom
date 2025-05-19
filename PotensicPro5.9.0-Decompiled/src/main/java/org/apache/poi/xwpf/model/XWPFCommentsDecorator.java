package org.apache.poi.xwpf.model;

import org.apache.poi.xwpf.usermodel.XWPFComment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;

/* loaded from: classes5.dex */
public class XWPFCommentsDecorator extends XWPFParagraphDecorator {
    private StringBuffer commentText;

    public XWPFCommentsDecorator(XWPFParagraphDecorator xWPFParagraphDecorator) {
        this(xWPFParagraphDecorator.paragraph, xWPFParagraphDecorator);
    }

    public XWPFCommentsDecorator(XWPFParagraph xWPFParagraph, XWPFParagraphDecorator xWPFParagraphDecorator) {
        super(xWPFParagraph, xWPFParagraphDecorator);
        this.commentText = new StringBuffer();
        for (CTMarkupRange cTMarkupRange : xWPFParagraph.getCTP().getCommentRangeStartArray()) {
            XWPFComment commentByID = xWPFParagraph.getDocument().getCommentByID(cTMarkupRange.getId().toString());
            if (commentByID != null) {
                this.commentText.append("\tComment by " + commentByID.getAuthor() + ": " + commentByID.getText());
            }
        }
    }

    public String getCommentText() {
        return this.commentText.toString();
    }

    @Override // org.apache.poi.xwpf.model.XWPFParagraphDecorator
    public String getText() {
        return super.getText() + ((Object) this.commentText);
    }
}
