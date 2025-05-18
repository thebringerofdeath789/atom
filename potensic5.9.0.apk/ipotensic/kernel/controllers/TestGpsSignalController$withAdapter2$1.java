package com.ipotensic.kernel.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ipotensic.baselib.views.recyclerview.RvCommonAdapter;
import com.ipotensic.kernel.databinding.ItemGpsDebugLayoutBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TestGpsSignalController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0015J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0014\u00a8\u0006\r"}, d2 = {"com/ipotensic/kernel/controllers/TestGpsSignalController$withAdapter2$1", "Lcom/ipotensic/baselib/views/recyclerview/RvCommonAdapter;", "", "Lcom/ipotensic/kernel/databinding/ItemGpsDebugLayoutBinding;", "convert", "", "holder", "data", "position", "", "initView", "parent", "Landroid/view/ViewGroup;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TestGpsSignalController$withAdapter2$1 extends RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> {
    final /* synthetic */ List $signalIdList;
    final /* synthetic */ List $signalList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestGpsSignalController$withAdapter2$1(List list, List list2, Context context, List list3) {
        super(context, list3);
        signalIdList = list;
        signalList = list2;
    }

    @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
    public /* bridge */ /* synthetic */ void convert(ItemGpsDebugLayoutBinding itemGpsDebugLayoutBinding, Byte b, int i) {
        convert(itemGpsDebugLayoutBinding, b.byteValue(), i);
    }

    protected void convert(ItemGpsDebugLayoutBinding holder, byte data, int position) {
        int findId;
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        TextView textView = holder.tvCarrierRatio;
        Intrinsics.checkExpressionValueIsNotNull(textView, "holder.tvCarrierRatio");
        StringBuilder append = new StringBuilder().append("\u536b\u661f\u53f7:");
        findId = TestGpsSignalController.this.findId(signalIdList, position);
        textView.setText(append.append(findId).toString());
        TextView textView2 = holder.tvCarrierRatioValue;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.tvCarrierRatioValue");
        textView2.setText("\u8f7d\u566a\u6bd4:" + ((int) data));
    }

    @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
    protected ItemGpsDebugLayoutBinding initView(ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        ItemGpsDebugLayoutBinding inflate = ItemGpsDebugLayoutBinding.inflate(LayoutInflater.from(TestGpsSignalController.this.getContext()), parent, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemGpsDebugLayoutBindin\u2026(context), parent, false)");
        return inflate;
    }
}