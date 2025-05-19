package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabTlc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTheme;

/* loaded from: classes5.dex */
public class TOC {
    CTSdtBlock block;

    public TOC() {
        this(CTSdtBlock.Factory.newInstance());
    }

    public TOC(CTSdtBlock cTSdtBlock) {
        this.block = cTSdtBlock;
        CTSdtPr addNewSdtPr = cTSdtBlock.addNewSdtPr();
        addNewSdtPr.addNewId().setVal(new BigInteger("4844945"));
        addNewSdtPr.addNewDocPartObj().addNewDocPartGallery().setVal("Table of contents");
        CTRPr addNewRPr = cTSdtBlock.addNewSdtEndPr().addNewRPr();
        CTFonts addNewRFonts = addNewRPr.addNewRFonts();
        addNewRFonts.setAsciiTheme(STTheme.MINOR_H_ANSI);
        addNewRFonts.setEastAsiaTheme(STTheme.MINOR_H_ANSI);
        addNewRFonts.setHAnsiTheme(STTheme.MINOR_H_ANSI);
        addNewRFonts.setCstheme(STTheme.MINOR_BIDI);
        addNewRPr.addNewB().setVal(STOnOff.OFF);
        addNewRPr.addNewBCs().setVal(STOnOff.OFF);
        addNewRPr.addNewColor().setVal("auto");
        addNewRPr.addNewSz().setVal(new BigInteger("24"));
        addNewRPr.addNewSzCs().setVal(new BigInteger("24"));
        CTP addNewP = cTSdtBlock.addNewSdtContent().addNewP();
        addNewP.setRsidR("00EF7E24".getBytes());
        addNewP.setRsidRDefault("00EF7E24".getBytes());
        addNewP.addNewPPr().addNewPStyle().setVal("TOCHeading");
        addNewP.addNewR().addNewT().setStringValue("Table of Contents");
    }

    @Internal
    public CTSdtBlock getBlock() {
        return this.block;
    }

    public void addRow(int i, String str, int i2, String str2) {
        CTP addNewP = this.block.getSdtContent().addNewP();
        addNewP.setRsidR("00EF7E24".getBytes());
        addNewP.setRsidRDefault("00EF7E24".getBytes());
        CTPPr addNewPPr = addNewP.addNewPPr();
        addNewPPr.addNewPStyle().setVal("TOC" + i);
        CTTabStop addNewTab = addNewPPr.addNewTabs().addNewTab();
        addNewTab.setVal(STTabJc.RIGHT);
        addNewTab.setLeader(STTabTlc.DOT);
        addNewTab.setPos(new BigInteger("8290"));
        addNewPPr.addNewRPr().addNewNoProof();
        CTR addNewR = addNewP.addNewR();
        addNewR.addNewRPr().addNewNoProof();
        addNewR.addNewT().setStringValue(str);
        CTR addNewR2 = addNewP.addNewR();
        addNewR2.addNewRPr().addNewNoProof();
        addNewR2.addNewTab();
        CTR addNewR3 = addNewP.addNewR();
        addNewR3.addNewRPr().addNewNoProof();
        addNewR3.addNewFldChar().setFldCharType(STFldCharType.BEGIN);
        CTR addNewR4 = addNewP.addNewR();
        addNewR4.addNewRPr().addNewNoProof();
        CTText addNewInstrText = addNewR4.addNewInstrText();
        addNewInstrText.setSpace(SpaceAttribute.Space.PRESERVE);
        addNewInstrText.setStringValue(" PAGEREF _Toc" + str2 + " \\h ");
        addNewP.addNewR().addNewRPr().addNewNoProof();
        CTR addNewR5 = addNewP.addNewR();
        addNewR5.addNewRPr().addNewNoProof();
        addNewR5.addNewFldChar().setFldCharType(STFldCharType.SEPARATE);
        CTR addNewR6 = addNewP.addNewR();
        addNewR6.addNewRPr().addNewNoProof();
        addNewR6.addNewT().setStringValue(Integer.valueOf(i2).toString());
        CTR addNewR7 = addNewP.addNewR();
        addNewR7.addNewRPr().addNewNoProof();
        addNewR7.addNewFldChar().setFldCharType(STFldCharType.END);
    }
}
