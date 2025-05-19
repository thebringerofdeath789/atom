package org.apache.poi.ss.formula.function;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
final class FunctionDataBuilder {
    private final Map _functionDataByIndex;
    private final Map _functionDataByName;
    private int _maxFunctionIndex = -1;
    private final Set _mutatingFunctionIndexes = new HashSet();

    public FunctionDataBuilder(int i) {
        int i2 = (i * 3) / 2;
        this._functionDataByName = new HashMap(i2);
        this._functionDataByIndex = new HashMap(i2);
    }

    public void add(int i, String str, int i2, int i3, byte b, byte[] bArr, boolean z) {
        FunctionMetadata functionMetadata = new FunctionMetadata(i, str, i2, i3, b, bArr);
        Integer valueOf = Integer.valueOf(i);
        if (i > this._maxFunctionIndex) {
            this._maxFunctionIndex = i;
        }
        FunctionMetadata functionMetadata2 = (FunctionMetadata) this._functionDataByName.get(str);
        if (functionMetadata2 != null) {
            if (!z || !this._mutatingFunctionIndexes.contains(valueOf)) {
                throw new RuntimeException("Multiple entries for function name '" + str + "'");
            }
            this._functionDataByIndex.remove(Integer.valueOf(functionMetadata2.getIndex()));
        }
        FunctionMetadata functionMetadata3 = (FunctionMetadata) this._functionDataByIndex.get(valueOf);
        if (functionMetadata3 != null) {
            if (!z || !this._mutatingFunctionIndexes.contains(valueOf)) {
                throw new RuntimeException("Multiple entries for function index (" + i + ")");
            }
            this._functionDataByName.remove(functionMetadata3.getName());
        }
        if (z) {
            this._mutatingFunctionIndexes.add(valueOf);
        }
        this._functionDataByIndex.put(valueOf, functionMetadata);
        this._functionDataByName.put(str, functionMetadata);
    }

    public FunctionMetadataRegistry build() {
        int size = this._functionDataByName.size();
        FunctionMetadata[] functionMetadataArr = new FunctionMetadata[size];
        this._functionDataByName.values().toArray(functionMetadataArr);
        FunctionMetadata[] functionMetadataArr2 = new FunctionMetadata[this._maxFunctionIndex + 1];
        for (int i = 0; i < size; i++) {
            FunctionMetadata functionMetadata = functionMetadataArr[i];
            functionMetadataArr2[functionMetadata.getIndex()] = functionMetadata;
        }
        return new FunctionMetadataRegistry(functionMetadataArr2, this._functionDataByName);
    }
}
