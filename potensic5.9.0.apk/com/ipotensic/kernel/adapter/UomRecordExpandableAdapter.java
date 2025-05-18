package com.ipotensic.kernel.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewItemUomRecordChildBinding;
import com.ipotensic.kernel.databinding.ViewItemUomRecordMainBinding;
import com.logan.uom.bean.UomRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;

/* compiled from: UomRecordExpandableAdapter.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012,\u0010\u0004\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007`\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR7\u0010\u0004\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, m2338d2 = {"Lcom/ipotensic/kernel/adapter/UomRecordExpandableAdapter;", "Landroid/widget/BaseExpandableListAdapter;", "context", "Landroid/content/Context;", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "Lcom/logan/uom/bean/UomRecord;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getList", "()Ljava/util/ArrayList;", "getChild", "", "groupPosition", "", "childPosition", "getChildId", "", "getChildView", "Landroid/view/View;", "isLastChild", "", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getGroup", "getGroupCount", "getGroupId", "getGroupView", "isExpanded", "hasStableIds", "isChildSelectable", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class UomRecordExpandableAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final ArrayList<ArrayList<UomRecord>> list;

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public UomRecordExpandableAdapter(Context context, ArrayList<ArrayList<UomRecord>> list) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.context = context;
        this.list = list;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList<ArrayList<UomRecord>> getList() {
        return this.list;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.list.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int groupPosition) {
        return this.list.get(groupPosition).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int groupPosition) {
        ArrayList<UomRecord> arrayList = this.list.get(groupPosition);
        Intrinsics.checkExpressionValueIsNotNull(arrayList, "list[groupPosition]");
        return arrayList;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int groupPosition, int childPosition) {
        UomRecord uomRecord = this.list.get(groupPosition).get(childPosition);
        Intrinsics.checkExpressionValueIsNotNull(uomRecord, "list[groupPosition][childPosition]");
        return uomRecord;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Object next;
        Object next2;
        ArrayList<UomRecord> arrayList = this.list.get(groupPosition);
        Intrinsics.checkExpressionValueIsNotNull(arrayList, "list[groupPosition]");
        ViewItemUomRecordMainBinding inflate = ViewItemUomRecordMainBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ViewItemUomRecordMainBin…utInflater.from(context))");
        ArrayList<UomRecord> arrayList2 = arrayList;
        Iterator<T> it = arrayList2.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long uomStateChangedTime = ((UomRecord) next).getUomStateChangedTime();
                do {
                    Object next3 = it.next();
                    long uomStateChangedTime2 = ((UomRecord) next3).getUomStateChangedTime();
                    if (uomStateChangedTime < uomStateChangedTime2) {
                        next = next3;
                        uomStateChangedTime = uomStateChangedTime2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        UomRecord uomRecord = (UomRecord) next;
        long uomStateChangedTime3 = uomRecord != null ? uomRecord.getUomStateChangedTime() : 0L;
        Iterator<T> it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                long uomStateChangedTime4 = ((UomRecord) next2).getUomStateChangedTime();
                do {
                    Object next4 = it2.next();
                    long uomStateChangedTime5 = ((UomRecord) next4).getUomStateChangedTime();
                    if (uomStateChangedTime4 > uomStateChangedTime5) {
                        next2 = next4;
                        uomStateChangedTime4 = uomStateChangedTime5;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        UomRecord uomRecord2 = (UomRecord) next2;
        long uomStateChangedTime6 = uomRecord2 != null ? uomRecord2.getUomStateChangedTime() : 0L;
        TextView textView = inflate.tvTitle;
        Intrinsics.checkExpressionValueIsNotNull(textView, "viewBinding.tvTitle");
        textView.setText("CST " + FormatUtil.formatCreateTime4(uomStateChangedTime6) + " ~ CST " + FormatUtil.formatCreateTime4(uomStateChangedTime3));
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(inflate.tvTitle, (Drawable) null, (Drawable) null, AppCompatResources.getDrawable(this.context, isExpanded ? C1965R.mipmap.button_arrow_unfold : C1965R.mipmap.button_arrow_next), (Drawable) null);
        TextView root = inflate.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "viewBinding.root");
        return root;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        UomRecord uomRecord = this.list.get(groupPosition).get(childPosition);
        Intrinsics.checkExpressionValueIsNotNull(uomRecord, "list[groupPosition][childPosition]");
        UomRecord uomRecord2 = uomRecord;
        ViewItemUomRecordChildBinding inflate = ViewItemUomRecordChildBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ViewItemUomRecordChildBi…utInflater.from(context))");
        TextView textView = inflate.tvState;
        Intrinsics.checkExpressionValueIsNotNull(textView, "viewBinding.tvState");
        textView.setText(this.context.getString(uomRecord2.getUomStateEnum().getStrId()));
        inflate.tvState.setTextColor(this.context.getColor(uomRecord2.getUomStateEnum().getColorId()));
        TextView textView2 = inflate.tvTime;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "viewBinding.tvTime");
        textView2.setText("CST " + FormatUtil.formatCreateTime4(uomRecord2.getUomStateChangedTime()));
        RelativeLayout root = inflate.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "viewBinding.root");
        return root;
    }
}