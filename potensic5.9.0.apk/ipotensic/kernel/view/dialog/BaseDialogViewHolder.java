package com.ipotensic.kernel.view.dialog;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDialogViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J#\u0010\t\u001a\u0004\u0018\u0001H\n\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0019J\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/BaseDialogViewHolder;", "", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "getConvertView", "()Landroid/view/View;", "views", "Landroid/util/SparseArray;", "getView", "T", "viewId", "", "(I)Landroid/view/View;", "setBackgroundColor", "", "colorId", "setBackgroundResource", "resId", "setOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setText", "text", "Landroid/text/SpannableString;", "", "setTextColor", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class BaseDialogViewHolder {
    private final View convertView;
    private final SparseArray<View> views;

    public BaseDialogViewHolder(View convertView) {
        Intrinsics.checkParameterIsNotNull(convertView, "convertView");
        this.convertView = convertView;
        this.views = new SparseArray<>();
    }

    public final View getConvertView() {
        return this.convertView;
    }

    public final <T extends View> T getView(int viewId) {
        T t = (T) this.views.get(viewId);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.convertView.findViewById(viewId);
        this.views.put(viewId, t2);
        return t2;
    }

    public final void setText(int viewId, String text) {
        View view = getView(viewId);
        if (view == null) {
            Intrinsics.throwNpe();
        }
        ((TextView) view).setText(text);
    }

    public final void setText(int viewId, SpannableString text) {
        View view = getView(viewId);
        if (view == null) {
            Intrinsics.throwNpe();
        }
        TextView textView = (TextView) view;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(text);
    }

    public final void setTextColor(int viewId, int colorId) {
        View view = getView(viewId);
        if (view == null) {
            Intrinsics.throwNpe();
        }
        ((TextView) view).setTextColor(colorId);
    }

    public final void setBackgroundResource(int viewId, int resId) {
        View view = getView(viewId);
        if (view == null) {
            Intrinsics.throwNpe();
        }
        view.setBackgroundResource(resId);
    }

    public final void setBackgroundColor(int viewId, int colorId) {
        View view = getView(viewId);
        if (view == null) {
            Intrinsics.throwNpe();
        }
        view.setBackgroundColor(colorId);
    }

    public final void setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view == null) {
            Intrinsics.throwNpe();
        }
        view.setOnClickListener(listener);
    }
}