package jxl.biff.formula;

/* loaded from: classes4.dex */
abstract class ParseItem {
    private ParseItem parent;
    private boolean volatileFunction = false;
    private boolean alternateCode = false;

    abstract void adjustRelativeCellReferences(int i, int i2);

    abstract void columnInserted(int i, int i2, boolean z);

    abstract void columnRemoved(int i, int i2, boolean z);

    abstract byte[] getBytes();

    abstract void getString(StringBuffer stringBuffer);

    abstract void rowInserted(int i, int i2, boolean z);

    abstract void rowRemoved(int i, int i2, boolean z);

    protected void setParent(ParseItem parseItem) {
        this.parent = parseItem;
    }

    protected void setVolatile() {
        this.volatileFunction = true;
        ParseItem parseItem = this.parent;
        if (parseItem == null || parseItem.isVolatile()) {
            return;
        }
        this.parent.setVolatile();
    }

    final boolean isVolatile() {
        return this.volatileFunction;
    }

    protected void setAlternateCode() {
        this.alternateCode = true;
    }

    protected final boolean useAlternateCode() {
        return this.alternateCode;
    }
}
