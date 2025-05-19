package org.apache.poi.poifs.property;

import org.apache.poi.poifs.filesystem.POIFSDocument;

/* loaded from: classes5.dex */
public class DocumentProperty extends Property {
    private POIFSDocument _document;

    @Override // org.apache.poi.poifs.property.Property
    public boolean isDirectory() {
        return false;
    }

    @Override // org.apache.poi.poifs.property.Property
    protected void preWrite() {
    }

    public DocumentProperty(String str, int i) {
        this._document = null;
        setName(str);
        setSize(i);
        setNodeColor((byte) 1);
        setPropertyType((byte) 2);
    }

    protected DocumentProperty(int i, byte[] bArr, int i2) {
        super(i, bArr, i2);
        this._document = null;
    }

    public void setDocument(POIFSDocument pOIFSDocument) {
        this._document = pOIFSDocument;
    }

    public POIFSDocument getDocument() {
        return this._document;
    }

    @Override // org.apache.poi.poifs.property.Property
    public boolean shouldUseSmallBlocks() {
        return super.shouldUseSmallBlocks();
    }

    public void updateSize(int i) {
        setSize(i);
    }
}
