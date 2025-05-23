package org.w3c.dom.html;

/* loaded from: classes6.dex */
public interface HTMLTableElement extends HTMLElement {
    HTMLElement createCaption();

    HTMLElement createTFoot();

    HTMLElement createTHead();

    void deleteCaption();

    void deleteRow(int i);

    void deleteTFoot();

    void deleteTHead();

    String getAlign();

    String getBgColor();

    String getBorder();

    HTMLTableCaptionElement getCaption();

    String getCellPadding();

    String getCellSpacing();

    String getFrame();

    HTMLCollection getRows();

    String getRules();

    String getSummary();

    HTMLCollection getTBodies();

    HTMLTableSectionElement getTFoot();

    HTMLTableSectionElement getTHead();

    String getWidth();

    HTMLElement insertRow(int i);

    void setAlign(String str);

    void setBgColor(String str);

    void setBorder(String str);

    void setCaption(HTMLTableCaptionElement hTMLTableCaptionElement);

    void setCellPadding(String str);

    void setCellSpacing(String str);

    void setFrame(String str);

    void setRules(String str);

    void setSummary(String str);

    void setTFoot(HTMLTableSectionElement hTMLTableSectionElement);

    void setTHead(HTMLTableSectionElement hTMLTableSectionElement);

    void setWidth(String str);
}
