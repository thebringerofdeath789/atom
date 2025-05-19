package com.ipotensic.kernel.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes2.dex */
public abstract class SimpleLifeCycle implements LifecycleEventObserver {
    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    /* renamed from: com.ipotensic.kernel.utils.SimpleLifeCycle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
        if (i == 1) {
            onCreate();
            return;
        }
        if (i == 2) {
            onResume();
        } else if (i == 3) {
            onPause();
        } else {
            if (i != 4) {
                return;
            }
            onDestroy();
        }
    }
}
