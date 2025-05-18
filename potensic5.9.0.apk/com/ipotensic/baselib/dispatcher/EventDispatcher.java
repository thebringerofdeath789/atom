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

    public void registerEvent(final Lifecycle lifecycle, final OnEventListener onEventListener) {
        this.callbacks.add(onEventListener);
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.ipotensic.baselib.dispatcher.EventDispatcher.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    EventDispatcher.this.unRegisterEvent(onEventListener);
                    lifecycle.removeObserver(this);
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

    public void sendEvent(final Event event) {
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.dispatcher.-$$Lambda$EventDispatcher$El2syKrqNpkOr90tbeYdOpl0lyc
            @Override // java.lang.Runnable
            public final void run() {
                EventDispatcher.this.lambda$sendEvent$0$EventDispatcher(event);
            }
        });
    }

    public /* synthetic */ void lambda$sendEvent$0$EventDispatcher(Event event) {
        try {
            Iterator<OnEventListener> it = this.callbacks.iterator();
            while (it.hasNext()) {
                OnEventListener next = it.next();
                try {
                    next.onEvent(event.f2115id, event);
                } catch (Exception e) {
                    String obj = next != null ? next.toString() : "";
                    if (event != null) {
                        DDLog.m1686e(TAG, "消息分发异常, id = " + event.f2115id + " ;异常信息 = " + obj, e);
                    } else {
                        DDLog.m1686e(TAG, "消息分发异常, event = null ;异常信息 = " + obj, e);
                    }
                }
            }
        } catch (Exception e2) {
            DDLog.m1686e(TAG, "消息外部分发异常: ", e2);
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