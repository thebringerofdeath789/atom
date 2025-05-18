package com.camera.state;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.camera.CameraInterface;

/* loaded from: classes.dex */
public interface State {
    void cancle(SurfaceHolder surfaceHolder, float f);

    void capture();

    void confirm();

    void flash(String str);

    void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback);

    void record(Surface surface, float f);

    void restart();

    void start(SurfaceHolder surfaceHolder, float f);

    void stop();

    void stopRecord(boolean z, long j);

    void swtich(SurfaceHolder surfaceHolder, float f);

    void zoom(float f, int i);
}