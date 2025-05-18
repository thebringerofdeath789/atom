package com.logan.uom;

import androidx.lifecycle.Observer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: UomHandler.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m2338d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, m2339k = 3, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
final class UomHandler$sortiesListener$1<T> implements Observer<Integer> {
    final /* synthetic */ UomHandler this$0;

    UomHandler$sortiesListener$1(UomHandler uomHandler) {
        this.this$0 = uomHandler;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Integer num) {
        ArrayList arrayList;
        if (num != null) {
            num.intValue();
            arrayList = this.this$0.sortiesRecords;
            arrayList.clear();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UomHandler$sortiesListener$1$$special$$inlined$let$lambda$1(null, this), 3, null);
        }
    }
}