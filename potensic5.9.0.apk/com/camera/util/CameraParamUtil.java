package com.camera.util;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.WindowManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CameraParamUtil {
    private static final String TAG = "JCameraView";
    private static CameraParamUtil cameraParamUtil;
    private CameraSizeComparator sizeComparator = new CameraSizeComparator();

    private CameraParamUtil() {
    }

    public static CameraParamUtil getInstance() {
        CameraParamUtil cameraParamUtil2 = cameraParamUtil;
        if (cameraParamUtil2 != null) {
            return cameraParamUtil2;
        }
        CameraParamUtil cameraParamUtil3 = new CameraParamUtil();
        cameraParamUtil = cameraParamUtil3;
        return cameraParamUtil3;
    }

    public Camera.Size getPreviewSize(List<Camera.Size> list, int i, float f) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i && equalRate(next, f)) {
                Log.i(TAG, "MakeSure Preview :w = " + next.width + " h = " + next.height);
                break;
            }
            i2++;
        }
        if (i2 == list.size()) {
            return getBestSize(list, f);
        }
        return list.get(i2);
    }

    public Camera.Size getPictureSize(List<Camera.Size> list, int i, float f) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i && equalRate(next, f)) {
                Log.i(TAG, "MakeSure Picture :w = " + next.width + " h = " + next.height);
                break;
            }
            i2++;
        }
        if (i2 == list.size()) {
            return getBestSize(list, f);
        }
        return list.get(i2);
    }

    private Camera.Size getBestSize(List<Camera.Size> list, float f) {
        float f2 = 100.0f;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Camera.Size size = list.get(i2);
            float f3 = f - (size.width / size.height);
            if (Math.abs(f3) < f2) {
                f2 = Math.abs(f3);
                i = i2;
            }
        }
        return list.get(i);
    }

    private boolean equalRate(Camera.Size size, float f) {
        return ((double) Math.abs((((float) size.width) / ((float) size.height)) - f)) <= 0.2d;
    }

    public boolean isSupportedFocusMode(List<String> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                Log.i(TAG, "FocusMode supported " + str);
                return true;
            }
        }
        Log.i(TAG, "FocusMode not supported " + str);
        return false;
    }

    public boolean isSupportedPictureFormats(List<Integer> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i == list.get(i2).intValue()) {
                Log.i(TAG, "Formats supported " + i);
                return true;
            }
        }
        Log.i(TAG, "Formats not supported " + i);
        return false;
    }

    private class CameraSizeComparator implements Comparator<Camera.Size> {
        private CameraSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            if (size.width == size2.width) {
                return 0;
            }
            return size.width > size2.width ? 1 : -1;
        }
    }

    public int getCameraDisplayOrientation(Context context, int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }
}