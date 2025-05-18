package com.ipotensic.baselib.dispatcher;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class EventDispatcher {
    private static final String TAG = "EventDispatcher";
    private static volatile EventDispatcher instance;
    private final Set<OnEventListener> callbacks = new LinkedHashSet();

    public interface OnEventListener {
        void onEvent(EventID eventID, Event event);
    }

    private EventDispatcher() {
    }

    public static EventDispatcher get() {
        if (instance == null) {
            synchronized (EventDispatcher.class) {
                if (instance == null) {
                    EventDispatcher eventDispatcher = new EventDispatcher();
                    instance = eventDispatcher;
                    return eventDispatcher;
                }
            }
        }
        return instance;
    }

    /* renamed from: com.ipotensic.baselib.dispatcher.EventDispatcher$1 */
    class AnonymousClass1 implements LifecycleEventObserver {
        final /* synthetic */ OnEventListener val$eventListener;
        final /* synthetic */ Lifecycle val$lifecycle;

        AnonymousClass1(OnEventListener onEventListener, Lifecycle lifecycle) {
            r2 = onEventListener;
            r3 = lifecycle;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                EventDispatcher.this.unRegisterEvent(r2);
                r3.removeObserver(this);
            }
        }
    }

    public void registerEvent(Lifecycle lifecycle, OnEventListener onEventListener) {
        this.callbacks.add(onEventListener);
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.ipotensic.baselib.dispatcher.EventDispatcher.1
            final /* synthetic */ OnEventListener val$eventListener;
            final /* synthetic */ Lifecycle val$lifecycle;

            AnonymousClass1(OnEventListener onEventListener2, Lifecycle lifecycle2) {
                r2 = onEventListener2;
                r3 = lifecycle2;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    EventDispatcher.this.unRegisterEvent(r2);
                    r3.removeObserver(this);
                }
            }
        });
    }

    public void registerEvent(OnEventListener onEventListener) {
        this.callbacks.add(onEventListener);
    }

    public void unRegisterEvent(OnEventListener onEventListener) {
        this.callbacks.remove(onEventListener);
    }

    public void sendEvent(EventID eventID) {
        sendEvent(new Event(eventID));
    }

    public void sendEvent(EventID eventID, Object obj) {
        Event event = new Event(eventID);
        event.obj = obj;
        sendEvent(event);
    }

    public void sendEvent(Event event) {
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.dispatcher.-$$Lambda$EventDispatcher$El2syKrqNpkOr90tbeYdOpl0lyc
            public final /* synthetic */ Event f$1;

            public /* synthetic */ $$Lambda$EventDispatcher$El2syKrqNpkOr90tbeYdOpl0lyc(Event event2) {
                r2 = event2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                EventDispatcher.this.lambda$sendEvent$0$EventDispatcher(r2);
            }
        });
    }

    public /* synthetic */ void lambda$sendEvent$0$EventDispatcher(Event event) {
        try {
            Iterator<OnEventListener> it = this.callbacks.iterator();
            while (it.hasNext()) {
                OnEventListener next = it.next();
                try {
                    next.onEvent(event.id, event);
                } catch (Exception e) {
                    String obj = next != null ? next.toString() : "";
                    if (event != null) {
                        DDLog.e(TAG, "\u6d88\u606f\u5206\u53d1\u5f02\u5e38, id = " + event.id + " ;\u5f02\u5e38\u4fe1\u606f = " + obj, e);
                    } else {
                        DDLog.e(TAG, "\u6d88\u606f\u5206\u53d1\u5f02\u5e38, event = null ;\u5f02\u5e38\u4fe1\u606f = " + obj, e);
                    }
                }
            }
        } catch (Exception e2) {
            DDLog.e(TAG, "\u6d88\u606f\u5916\u90e8\u5206\u53d1\u5f02\u5e38: ", e2);
        }
    }

    public <T> T getController(Class<T> cls) {
        Iterator<OnEventListener> it = this.callbacks.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }
}