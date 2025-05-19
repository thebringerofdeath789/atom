package org.apache.poi.poifs.property;

import org.apache.poi.poifs.storage.SmallDocumentBlock;

/* loaded from: classes5.dex */
public final class RootProperty extends DirectoryProperty {
    private static final String NAME = "Root Entry";

    @Override // org.apache.poi.poifs.property.Property
    public String getName() {
        return "Root Entry";
    }

    RootProperty() {
        super("Root Entry");
        setNodeColor((byte) 1);
        setPropertyType((byte) 5);
        setStartBlock(-2);
    }

    protected RootProperty(int i, byte[] bArr, int i2) {
        super(i, bArr, i2);
    }

    @Override // org.apache.poi.poifs.property.Property
    public void setSize(int i) {
        super.setSize(SmallDocumentBlock.calcSize(i));
    }
}
