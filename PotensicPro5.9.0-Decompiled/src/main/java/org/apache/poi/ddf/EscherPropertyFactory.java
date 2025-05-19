package org.apache.poi.ddf;

import com.google.common.primitives.Shorts;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public final class EscherPropertyFactory {
    public List<EscherProperty> createProperties(byte[] bArr, int i, short s) {
        int length;
        ArrayList<EscherProperty> arrayList = new ArrayList();
        for (int i2 = 0; i2 < s; i2++) {
            short s2 = LittleEndian.getShort(bArr, i);
            int i3 = LittleEndian.getInt(bArr, i + 2);
            short s3 = (short) (s2 & 16383);
            boolean z = (s2 & ShortCompanionObject.MIN_VALUE) != 0;
            int i4 = s2 & Shorts.MAX_POWER_OF_TWO;
            byte propertyType = EscherProperties.getPropertyType(s3);
            if (propertyType == 1) {
                arrayList.add(new EscherBoolProperty(s2, i3));
            } else if (propertyType == 2) {
                arrayList.add(new EscherRGBProperty(s2, i3));
            } else if (propertyType == 3) {
                arrayList.add(new EscherShapePathProperty(s2, i3));
            } else if (!z) {
                arrayList.add(new EscherSimpleProperty(s2, i3));
            } else if (propertyType == 5) {
                arrayList.add(new EscherArrayProperty(s2, new byte[i3]));
            } else {
                arrayList.add(new EscherComplexProperty(s2, new byte[i3]));
            }
            i += 6;
        }
        for (EscherProperty escherProperty : arrayList) {
            if (escherProperty instanceof EscherComplexProperty) {
                if (escherProperty instanceof EscherArrayProperty) {
                    length = ((EscherArrayProperty) escherProperty).setArrayData(bArr, i);
                } else {
                    byte[] complexData = ((EscherComplexProperty) escherProperty).getComplexData();
                    System.arraycopy(bArr, i, complexData, 0, complexData.length);
                    length = complexData.length;
                }
                i += length;
            }
        }
        return arrayList;
    }
}
