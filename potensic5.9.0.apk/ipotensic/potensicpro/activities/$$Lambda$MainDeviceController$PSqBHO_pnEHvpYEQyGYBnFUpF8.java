package com.ipotensic.potensicpro.activities;

import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.potensicpro.R;

/* compiled from: lambda */
/* renamed from: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$PSq-BHO_pnEHvpYEQyGYBnFUpF8 */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$MainDeviceController$PSqBHO_pnEHvpYEQyGYBnFUpF8 implements OnLayoutInflatedListener {
    public static final /* synthetic */ $$Lambda$MainDeviceController$PSqBHO_pnEHvpYEQyGYBnFUpF8 INSTANCE = ;

    private /* synthetic */ $$Lambda$MainDeviceController$PSqBHO_pnEHvpYEQyGYBnFUpF8() {
    }

    @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
    public final void onLayoutInflated(View view, Controller controller) {
        ((TextView) view.findViewById(R.id.tv_view)).setText(R.string.guide_homepage_flight_log_tips);
    }
}