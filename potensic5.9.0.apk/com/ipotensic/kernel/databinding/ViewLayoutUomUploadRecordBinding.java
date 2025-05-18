package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public abstract class ViewLayoutUomUploadRecordBinding extends ViewDataBinding {
    public final ImageView ivClose;
    public final RelativeLayout layoutTop;
    public final ExpandableListView listView;
    public final TextView tvNone;
    public final TextView tvTips;

    protected ViewLayoutUomUploadRecordBinding(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, ExpandableListView expandableListView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivClose = imageView;
        this.layoutTop = relativeLayout;
        this.listView = expandableListView;
        this.tvNone = textView;
        this.tvTips = textView2;
    }

    public static ViewLayoutUomUploadRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutUomUploadRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutUomUploadRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_uom_upload_record, viewGroup, z, obj);
    }

    public static ViewLayoutUomUploadRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutUomUploadRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutUomUploadRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_uom_upload_record, null, false, obj);
    }

    public static ViewLayoutUomUploadRecordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutUomUploadRecordBinding bind(View view, Object obj) {
        return (ViewLayoutUomUploadRecordBinding) bind(obj, view, C1965R.layout.view_layout_uom_upload_record);
    }
}