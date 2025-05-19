package com.ipotensic.kernel.guide;

import android.view.View;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.kernel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.net.telnet.TelnetCommand;

/* compiled from: SettingRelativeGuide.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BU\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/ipotensic/kernel/guide/SettingRelativeGuide;", "Lcom/ipotensic/baselib/guide/model/RelativeGuide;", TtmlNode.TAG_LAYOUT, "", "gravity", "padding", "left", "top", "right", "bottom", "resId", "(IIIIIIILjava/lang/Integer;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onLayoutInflated", "", "view", "Landroid/view/View;", "controller", "Lcom/ipotensic/baselib/guide/core/Controller;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SettingRelativeGuide extends RelativeGuide {
    private Integer resId;

    public SettingRelativeGuide(int i, int i2) {
        this(i, i2, 0, 0, 0, 0, 0, null, TelnetCommand.WONT, null);
    }

    public SettingRelativeGuide(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0, 0, 0, null, TelnetCommand.EL, null);
    }

    public SettingRelativeGuide(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, 0, 0, null, 240, null);
    }

    public SettingRelativeGuide(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 0, null, 224, null);
    }

    public SettingRelativeGuide(int i, int i2, int i3, int i4, int i5, int i6) {
        this(i, i2, i3, i4, i5, i6, 0, null, 192, null);
    }

    public SettingRelativeGuide(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(i, i2, i3, i4, i5, i6, i7, null, 128, null);
    }

    public /* synthetic */ SettingRelativeGuide(int i, int i2, int i3, int i4, int i5, int i6, int i7, Integer num, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7, (i8 & 128) != 0 ? (Integer) null : num);
    }

    public final Integer getResId() {
        return this.resId;
    }

    public final void setResId(Integer num) {
        this.resId = num;
    }

    public SettingRelativeGuide(int i, int i2, int i3, int i4, int i5, int i6, int i7, Integer num) {
        super(i, i2, i3, i4, i5, i6, i7);
        this.resId = num;
    }

    @Override // com.ipotensic.baselib.guide.model.RelativeGuide
    protected void onLayoutInflated(View view, Controller controller) {
        TextView textView = view != null ? (TextView) view.findViewById(R.id.tv_view) : null;
        Integer num = this.resId;
        if (num != null) {
            int intValue = num.intValue();
            if (textView != null) {
                textView.setText(intValue);
            }
        }
    }
}
