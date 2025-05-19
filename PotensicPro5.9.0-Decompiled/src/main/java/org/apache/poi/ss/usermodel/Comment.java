package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public interface Comment {
    String getAuthor();

    ClientAnchor getClientAnchor();

    int getColumn();

    int getRow();

    RichTextString getString();

    boolean isVisible();

    void setAuthor(String str);

    void setColumn(int i);

    void setRow(int i);

    void setString(RichTextString richTextString);

    void setVisible(boolean z);
}
