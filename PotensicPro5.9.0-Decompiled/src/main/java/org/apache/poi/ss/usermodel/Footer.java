package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public interface Footer extends HeaderFooter {
    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getCenter();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getLeft();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getRight();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setCenter(String str);

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setLeft(String str);

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setRight(String str);
}
