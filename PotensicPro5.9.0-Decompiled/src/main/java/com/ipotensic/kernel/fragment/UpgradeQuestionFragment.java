package com.ipotensic.kernel.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.FragmentUpgradeQuestionBinding;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpgradeQuestionFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ipotensic/kernel/fragment/UpgradeQuestionFragment;", "Lcom/ipotensic/baselib/base/BaseKFragment;", "Lcom/ipotensic/kernel/databinding/FragmentUpgradeQuestionBinding;", "()V", "getLayoutId", "", "initData", "", "initListener", "initObserver", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class UpgradeQuestionFragment extends BaseKFragment<FragmentUpgradeQuestionBinding> {
    private static final String TAG = "UpgradeQuestionFragment";
    private HashMap _$_findViewCache;

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

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return R.layout.fragment_upgrade_question;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        DDLog.e(TAG, "initData");
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        getMBind().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.UpgradeQuestionFragment$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentActivity it = UpgradeQuestionFragment.this.getActivity();
                if (it != null) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    Fragment findFragmentById = it.getSupportFragmentManager().findFragmentById(R.id.fragment_upgrade_question);
                    if (findFragmentById != null) {
                        it.getSupportFragmentManager().beginTransaction().remove(findFragmentById).commit();
                    }
                }
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
        DDLog.e(TAG, "initObserver");
    }
}
