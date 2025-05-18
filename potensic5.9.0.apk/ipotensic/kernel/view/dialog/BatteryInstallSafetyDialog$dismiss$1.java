package com.ipotensic.kernel.view.dialog;

import com.bumptech.glide.Glide;
import kotlin.Metadata;

/* compiled from: BatteryInstallSafetyDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class BatteryInstallSafetyDialog$dismiss$1 implements Runnable {
    BatteryInstallSafetyDialog$dismiss$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Glide.get(BatteryInstallSafetyDialog.this.getContext()).clearMemory();
            Glide.get(BatteryInstallSafetyDialog.this.getContext()).clearDiskCache();
        } catch (Exception unused) {
        }
    }
}