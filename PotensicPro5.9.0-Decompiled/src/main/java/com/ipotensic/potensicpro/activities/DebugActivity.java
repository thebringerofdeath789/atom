package com.ipotensic.potensicpro.activities;

import android.os.Bundle;
import android.view.View;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.potensicpro.databinding.ActivityDebugBinding;
import com.ipotensic.potensicpro.view.dialog.AppLogDialog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/ipotensic/potensicpro/activities/DebugActivity;", "Lcom/ipotensic/baselib/base/BaseActivity;", "()V", "viewBinding", "Lcom/ipotensic/potensicpro/databinding/ActivityDebugBinding;", "getViewBinding", "()Lcom/ipotensic/potensicpro/databinding/ActivityDebugBinding;", "setViewBinding", "(Lcom/ipotensic/potensicpro/databinding/ActivityDebugBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class DebugActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    public ActivityDebugBinding viewBinding;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final ActivityDebugBinding getViewBinding() {
        ActivityDebugBinding activityDebugBinding = this.viewBinding;
        if (activityDebugBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        return activityDebugBinding;
    }

    public final void setViewBinding(ActivityDebugBinding activityDebugBinding) {
        Intrinsics.checkParameterIsNotNull(activityDebugBinding, "<set-?>");
        this.viewBinding = activityDebugBinding;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDebugBinding inflate = ActivityDebugBinding.inflate(getLayoutInflater());
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ActivityDebugBinding.inflate(layoutInflater)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        setContentView(inflate.getRoot());
        ActivityDebugBinding activityDebugBinding = this.viewBinding;
        if (activityDebugBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityDebugBinding.btnAppLog.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.DebugActivity$onCreate$1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                new AppLogDialog(DebugActivity.this).show();
            }
        });
        ActivityDebugBinding activityDebugBinding2 = this.viewBinding;
        if (activityDebugBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityDebugBinding2.btnBack.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.DebugActivity$onCreate$2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                DebugActivity.this.finish();
            }
        });
    }
}
