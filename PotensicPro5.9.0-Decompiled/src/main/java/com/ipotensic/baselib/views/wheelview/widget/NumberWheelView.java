package com.ipotensic.baselib.views.wheelview.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class NumberWheelView extends WheelView {
    public NumberWheelView(Context context) {
        super(context);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.ipotensic.baselib.views.wheelview.widget.WheelView
    protected List<?> generatePreviewData() {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @Override // com.ipotensic.baselib.views.wheelview.widget.WheelView
    @Deprecated
    public void setData(List<?> list) {
        if (isInEditMode()) {
            super.setData(generatePreviewData());
            return;
        }
        throw new UnsupportedOperationException("Use setRange instead");
    }

    public void setRange(int i, int i2, int i3) {
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        ArrayList arrayList = new ArrayList((max - min) / i3);
        while (min <= max) {
            arrayList.add(Integer.valueOf(min));
            min += i3;
        }
        super.setData(arrayList);
    }

    public void setRange(float f, float f2, float f3) {
        float min = Math.min(f, f2);
        float max = Math.max(f, f2);
        ArrayList arrayList = new ArrayList((int) ((max - min) / f3));
        while (min <= max) {
            arrayList.add(Float.valueOf(min));
            min += f3;
        }
        super.setData(arrayList);
    }
}
