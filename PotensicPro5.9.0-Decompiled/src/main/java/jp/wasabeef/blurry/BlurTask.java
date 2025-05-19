package jp.wasabeef.blurry;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
class BlurTask {
    private static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();
    private final Bitmap bitmap;
    private final Callback callback;
    private final WeakReference<Context> contextWeakRef;
    private final BlurFactor factor;

    public interface Callback {
        void done(Bitmap bitmap);
    }

    public BlurTask(View view, BlurFactor blurFactor, Callback callback) {
        this.factor = blurFactor;
        this.callback = callback;
        this.contextWeakRef = new WeakReference<>(view.getContext());
        view.setDrawingCacheEnabled(true);
        view.destroyDrawingCache();
        view.setDrawingCacheQuality(524288);
        this.bitmap = view.getDrawingCache();
    }

    public BlurTask(Context context, Bitmap bitmap, BlurFactor blurFactor, Callback callback) {
        this.factor = blurFactor;
        this.callback = callback;
        this.contextWeakRef = new WeakReference<>(context);
        this.bitmap = bitmap;
    }

    public void execute() {
        THREAD_POOL.execute(new Runnable() { // from class: jp.wasabeef.blurry.BlurTask.1
            @Override // java.lang.Runnable
            public void run() {
                final Context context = (Context) BlurTask.this.contextWeakRef.get();
                if (BlurTask.this.callback != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: jp.wasabeef.blurry.BlurTask.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BlurTask.this.callback.done(Blur.of(context, BlurTask.this.bitmap, BlurTask.this.factor));
                        }
                    });
                }
            }
        });
    }
}
