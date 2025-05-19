package org.apache.poi.xwpf.model;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/* loaded from: classes5.dex */
public abstract class XWPFParagraphDecorator {
    protected XWPFParagraphDecorator nextDecorator;
    protected XWPFParagraph paragraph;

    public XWPFParagraphDecorator(XWPFParagraph xWPFParagraph) {
        this(xWPFParagraph, null);
    }

    public XWPFParagraphDecorator(XWPFParagraph xWPFParagraph, XWPFParagraphDecorator xWPFParagraphDecorator) {
        this.paragraph = xWPFParagraph;
        this.nextDecorator = xWPFParagraphDecorator;
    }

    public String getText() {
        XWPFParagraphDecorator xWPFParagraphDecorator = this.nextDecorator;
        if (xWPFParagraphDecorator != null) {
            return xWPFParagraphDecorator.getText();
        }
        return this.paragraph.getText();
    }
}
