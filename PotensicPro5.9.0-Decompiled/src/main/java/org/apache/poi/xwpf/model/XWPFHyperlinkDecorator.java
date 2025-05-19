package org.apache.poi.xwpf.model;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

@Deprecated
/* loaded from: classes5.dex */
public class XWPFHyperlinkDecorator extends XWPFParagraphDecorator {
    private StringBuffer hyperlinkText;

    public XWPFHyperlinkDecorator(XWPFParagraphDecorator xWPFParagraphDecorator, boolean z) {
        this(xWPFParagraphDecorator.paragraph, xWPFParagraphDecorator, z);
    }

    public XWPFHyperlinkDecorator(XWPFParagraph xWPFParagraph, XWPFParagraphDecorator xWPFParagraphDecorator, boolean z) {
        super(xWPFParagraph, xWPFParagraphDecorator);
        this.hyperlinkText = new StringBuffer();
        for (CTHyperlink cTHyperlink : this.paragraph.getCTP().getHyperlinkArray()) {
            for (CTR ctr : cTHyperlink.getRArray()) {
                for (CTText cTText : ctr.getTArray()) {
                    this.hyperlinkText.append(cTText.getStringValue());
                }
            }
            if (z && this.paragraph.getDocument().getHyperlinkByID(cTHyperlink.getId()) != null) {
                this.hyperlinkText.append(" <" + this.paragraph.getDocument().getHyperlinkByID(cTHyperlink.getId()).getURL() + ">");
            }
        }
    }

    @Override // org.apache.poi.xwpf.model.XWPFParagraphDecorator
    public String getText() {
        return super.getText() + ((Object) this.hyperlinkText);
    }
}
