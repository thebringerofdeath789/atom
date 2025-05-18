package com.ipotensic.kernel.fragment;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewLayoutUomUploadRecordBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.logan.uom.bean.UomRecord;
import com.logan.uom.enums.UomState;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: UomUploadRecordFragment.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J.\u0010\u0010\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t`\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R8\u0010\u0006\u001a,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0007j\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m2338d2 = {"Lcom/ipotensic/kernel/fragment/UomUploadRecordFragment;", "Lcom/ipotensic/baselib/base/BaseKFragment;", "Lcom/ipotensic/kernel/databinding/ViewLayoutUomUploadRecordBinding;", "()V", "kernelViewModel", "Lcom/ipotensic/kernel/model/KernelViewModel;", "recordList", "Ljava/util/ArrayList;", "Lcom/logan/uom/bean/UomRecord;", "Lkotlin/collections/ArrayList;", "getLayoutId", "", "initData", "", "initListener", "initObserver", "testData", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class UomUploadRecordFragment extends BaseKFragment<ViewLayoutUomUploadRecordBinding> {
    private HashMap _$_findViewCache;
    private KernelViewModel kernelViewModel;
    private ArrayList<ArrayList<UomRecord>> recordList;

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ KernelViewModel access$getKernelViewModel$p(UomUploadRecordFragment uomUploadRecordFragment) {
        KernelViewModel kernelViewModel = uomUploadRecordFragment.kernelViewModel;
        if (kernelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kernelViewModel");
        }
        return kernelViewModel;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return C1965R.layout.view_layout_uom_upload_record;
    }

    private final ArrayList<ArrayList<UomRecord>> testData() {
        ArrayList<ArrayList<UomRecord>> arrayList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            ArrayList<UomRecord> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 <= 10; i2++) {
                arrayList2.add(new UomRecord(UomState.NORMAL_UPLOAD.name(), System.currentTimeMillis() + (i * 1000) + i2, i + 1000));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(KernelViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProvider(requir…nelViewModel::class.java)");
        this.kernelViewModel = (KernelViewModel) viewModel;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new UomUploadRecordFragment$initData$1(this, null), 2, null);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        getMBind().ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.UomUploadRecordFragment$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UomUploadRecordFragment.access$getKernelViewModel$p(UomUploadRecordFragment.this).getUomUploadRecord().setValue(false);
            }
        });
    }
}