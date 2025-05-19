package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaStringEnumEntry;

/* loaded from: classes5.dex */
public class SchemaStringEnumEntryImpl implements SchemaStringEnumEntry {
    private String _enumName;
    private int _int;
    private String _string;

    public SchemaStringEnumEntryImpl(String str, int i, String str2) {
        this._string = str;
        this._int = i;
        this._enumName = str2;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public String getString() {
        return this._string;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public int getIntValue() {
        return this._int;
    }

    @Override // org.apache.xmlbeans.SchemaStringEnumEntry
    public String getEnumName() {
        return this._enumName;
    }
}
