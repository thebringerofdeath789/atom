package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class DirectView extends ImageView {
    public DirectView(Context context) {
        super(context);
        init(context);
    }

    public DirectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        setImageResource(C1965R.mipmap.img_direct_view);
    }

    public void setAngle(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 360) {
            i = 360;
        }
        setRotation(i);
    }
}