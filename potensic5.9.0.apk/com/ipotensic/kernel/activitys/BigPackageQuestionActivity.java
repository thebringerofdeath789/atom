package com.ipotensic.kernel.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.kernel.C1965R;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: BigPackageQuestionActivity.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, m2338d2 = {"Lcom/ipotensic/kernel/activitys/BigPackageQuestionActivity;", "Lcom/ipotensic/baselib/base/BaseActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class BigPackageQuestionActivity extends BaseActivity {
    private HashMap _$_findViewCache;

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

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1965R.layout.activity_big_package_question);
        ((ImageButton) findViewById(C1965R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.BigPackageQuestionActivity$onCreate$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BigPackageQuestionActivity.this.finish();
            }
        });
    }
}