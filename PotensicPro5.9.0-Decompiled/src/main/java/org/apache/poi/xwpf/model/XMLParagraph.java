package org.apache.poi.xwpf.model;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;

/* loaded from: classes5.dex */
public class XMLParagraph {
    protected CTP paragraph;

    public XMLParagraph(CTP ctp) {
        this.paragraph = ctp;
    }

    public CTP getCTP() {
        return this.paragraph;
    }
}
