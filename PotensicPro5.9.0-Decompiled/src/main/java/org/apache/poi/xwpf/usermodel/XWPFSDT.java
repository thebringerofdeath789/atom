package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;

/* loaded from: classes5.dex */
public class XWPFSDT extends AbstractXWPFSDT implements IBodyElement, IRunBody, ISDTContents, IRunElement {
    private final ISDTContent content;

    public XWPFSDT(CTSdtRun cTSdtRun, IBody iBody) {
        super(cTSdtRun.getSdtPr(), iBody);
        this.content = new XWPFSDTContent(cTSdtRun.getSdtContent(), iBody, this);
    }

    public XWPFSDT(CTSdtBlock cTSdtBlock, IBody iBody) {
        super(cTSdtBlock.getSdtPr(), iBody);
        this.content = new XWPFSDTContent(cTSdtBlock.getSdtContent(), iBody, this);
    }

    @Override // org.apache.poi.xwpf.usermodel.AbstractXWPFSDT
    public ISDTContent getContent() {
        return this.content;
    }
}
