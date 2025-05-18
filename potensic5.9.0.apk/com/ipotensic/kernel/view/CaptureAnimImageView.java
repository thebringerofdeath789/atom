package com.ipotensic.kernel.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.MapVideoController;
import com.ipotensic.kernel.controllers.PreviewController;

/* loaded from: classes2.dex */
public class CaptureAnimImageView extends ImageView {
    public CaptureAnimImageView(Context context) {
        super(context);
    }

    public CaptureAnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void test(Activity activity, final View view) {
        final Bitmap decodeResource = BitmapFactory.decodeResource(activity.getResources(), C1965R.mipmap.icon_main_bg);
        activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.view.CaptureAnimImageView.1
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 != null) {
                    CaptureAnimImageView.this.show(decodeResource, view2);
                }
            }
        });
    }

    public void capture(final Activity activity, MapVideoController mapVideoController, final View view) {
        if (!mapVideoController.isMapMode() && SPHelper.getInstance().getFirstPhotoOrVideo()) {
            SPHelper.getInstance().setFirstPhotoOrVideo(false);
            if (mapVideoController != null) {
                mapVideoController.captureFrame(new PreviewController.onFrameCaptureListener() { // from class: com.ipotensic.kernel.view.CaptureAnimImageView.2
                    @Override // com.ipotensic.kernel.controllers.PreviewController.onFrameCaptureListener
                    public void onFrame(final Bitmap bitmap) {
                        activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.view.CaptureAnimImageView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (view != null) {
                                    CaptureAnimImageView.this.show(bitmap, view);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show(Bitmap bitmap, View view) {
        clearAnimation();
        setScaleX(1.0f);
        setScaleY(1.0f);
        setX(0.0f);
        setY(0.0f);
        setImageBitmap(bitmap);
        setVisibility(0);
        postDelayed(new RunnableC25243(view), 100L);
    }

    /* renamed from: com.ipotensic.kernel.view.CaptureAnimImageView$3 */
    class RunnableC25243 implements Runnable {
        final /* synthetic */ View val$endView;

        RunnableC25243(View view) {
            this.val$endView = view;
        }

        /* renamed from: com.ipotensic.kernel.view.CaptureAnimImageView$3$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CaptureAnimImageView.this.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.view.CaptureAnimImageView.3.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RunnableC25243.this.val$endView.getGlobalVisibleRect(new Rect());
                        CaptureAnimImageView.this.animate().scaleX(0.05f).scaleY(0.05f).translationXBy((r0.left + (RunnableC25243.this.val$endView.getWidth() / 2)) - CaptureAnimImageView.this.getPivotX()).translationYBy((r0.top + (RunnableC25243.this.val$endView.getHeight() / 2)) - CaptureAnimImageView.this.getPivotY()).setDuration(300L).withEndAction(new Runnable() { // from class: com.ipotensic.kernel.view.CaptureAnimImageView.3.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CaptureAnimImageView.this.setVisibility(8);
                            }
                        }).start();
                    }
                }, 200L);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            CaptureAnimImageView.this.animate().scaleX(0.4f).scaleY(0.4f).setDuration(300L).withEndAction(new AnonymousClass1()).start();
        }
    }
}