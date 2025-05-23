package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class CompletableAndThenCompletable extends Completable {
    final CompletableSource next;
    final CompletableSource source;

    public CompletableAndThenCompletable(CompletableSource source, CompletableSource next) {
        this.source = source;
        this.next = next;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        this.source.subscribe(new SourceObserver(observer, this.next));
    }

    static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;
        final CompletableObserver actualObserver;
        final CompletableSource next;

        SourceObserver(CompletableObserver actualObserver, CompletableSource next) {
            this.actualObserver = actualObserver;
            this.next = next;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d)) {
                this.actualObserver.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.actualObserver.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.next.subscribe(new NextObserver(this, this.actualObserver));
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    static final class NextObserver implements CompletableObserver {
        final CompletableObserver downstream;
        final AtomicReference<Disposable> parent;

        NextObserver(AtomicReference<Disposable> parent, CompletableObserver downstream) {
            this.parent = parent;
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.replace(this.parent, d);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }
    }
}
