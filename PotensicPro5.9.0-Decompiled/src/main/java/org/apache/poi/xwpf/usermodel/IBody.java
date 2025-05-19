package org.apache.poi.xwpf.usermodel;

import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* loaded from: classes5.dex */
public interface IBody {
    List<IBodyElement> getBodyElements();

    XWPFParagraph getParagraph(CTP ctp);

    XWPFParagraph getParagraphArray(int i);

    List<XWPFParagraph> getParagraphs();

    POIXMLDocumentPart getPart();

    BodyType getPartType();

    XWPFTable getTable(CTTbl cTTbl);

    XWPFTable getTableArray(int i);

    XWPFTableCell getTableCell(CTTc cTTc);

    List<XWPFTable> getTables();

    XWPFDocument getXWPFDocument();

    XWPFParagraph insertNewParagraph(XmlCursor xmlCursor);

    XWPFTable insertNewTbl(XmlCursor xmlCursor);

    void insertTable(int i, XWPFTable xWPFTable);
}
