package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.io.Serializable;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public enum NotificationLite {
    COMPLETE;

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object o) {
        return o;
    }

    public static <T> Object next(T value) {
        return value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        ErrorNotification(Throwable e) {
            this.e = e;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return Objects.equals(this.e, ((ErrorNotification) obj).e);
            }
            return false;
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final Subscription upstream;

        SubscriptionNotification(Subscription s) {
            this.upstream = s;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable upstream;

        DisposableNotification(Disposable d) {
            this.upstream = d;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable e) {
        return new ErrorNotification(e);
    }

    public static Object subscription(Subscription s) {
        return new SubscriptionNotification(s);
    }

    public static Object disposable(Disposable d) {
        return new DisposableNotification(d);
    }

    public static boolean isComplete(Object o) {
        return o == COMPLETE;
    }

    public static boolean isError(Object o) {
        return o instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object o) {
        return o instanceof SubscriptionNotification;
    }

    public static boolean isDisposable(Object o) {
        return o instanceof DisposableNotification;
    }

    public static Throwable getError(Object o) {
        return ((ErrorNotification) o).e;
    }

    public static Subscription getSubscription(Object o) {
        return ((SubscriptionNotification) o).upstream;
    }

    public static Disposable getDisposable(Object o) {
        return ((DisposableNotification) o).upstream;
    }

    public static <T> boolean accept(Object o, Subscriber<? super T> s) {
        if (o == COMPLETE) {
            s.onComplete();
            return true;
        }
        if (o instanceof ErrorNotification) {
            s.onError(((ErrorNotification) o).e);
            return true;
        }
        s.onNext(o);
        return false;
    }

    public static <T> boolean accept(Object o, Observer<? super T> observer) {
        if (o == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (o instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) o).e);
            return true;
        }
        observer.onNext(o);
        return false;
    }

    public static <T> boolean acceptFull(Object o, Subscriber<? super T> s) {
        if (o == COMPLETE) {
            s.onComplete();
            return true;
        }
        if (o instanceof ErrorNotification) {
            s.onError(((ErrorNotification) o).e);
            return true;
        }
        if (o instanceof SubscriptionNotification) {
            s.onSubscribe(((SubscriptionNotification) o).upstream);
            return false;
        }
        s.onNext(o);
        return false;
    }

    public static <T> boolean acceptFull(Object o, Observer<? super T> observer) {
        if (o == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (o instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) o).e);
            return true;
        }
        if (o instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) o).upstream);
            return false;
        }
        observer.onNext(o);
        return false;
    }
}
