package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.logan.rtsp.OnYuvListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class H264Player {
    public static YuvData currentYuvData;
    private static int fps;
    private static Thread renderThread;
    private static long time1;
    private static final Set<OnYuvListener> yuvCallbacks;
    private static ConcurrentLinkedQueue<YuvData> yuvFrames;
    private static int yuvNum;

    public static native int decode(byte[] bArr, int i);

    public static native void destroy();

    public static native void flush();

    public static native int init(boolean z, byte[] bArr, int i);

    public static native void pause();

    public static native void resume();

    static {
        System.loadLibrary("rtsp");
        yuvCallbacks = new CopyOnWriteArraySet();
        yuvNum = 0;
        fps = 0;
        time1 = 0L;
        currentYuvData = null;
        renderThread = null;
        yuvFrames = new ConcurrentLinkedQueue<>();
    }

    public static void addYuvListener(OnYuvListener onYuvListener) {
        Set<OnYuvListener> set = yuvCallbacks;
        if (set.contains(onYuvListener)) {
            return;
        }
        set.add(onYuvListener);
    }

    public static void removeYuvListener(OnYuvListener onYuvListener) {
        yuvCallbacks.remove(onYuvListener);
    }

    public static void clearCallbacks() {
        yuvCallbacks.clear();
    }

    public static void onYuvCallback(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        yuvNum++;
        if (time1 > System.currentTimeMillis()) {
            time1 = 0L;
        }
        if (System.currentTimeMillis() - time1 >= 1000) {
            DDLog.w(" real fps:" + yuvNum);
            fps = yuvNum;
            yuvNum = 0;
            time1 = System.currentTimeMillis();
        }
        if (yuvFrames.size() > 20) {
            DDLog.e("clear yuvframes");
            yuvFrames.clear();
        }
        YuvData yuvData = new YuvData(bArr, bArr2, bArr3, i, i2);
        yuvFrames.offer(yuvData);
        currentYuvData = yuvData;
        if (renderThread == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.logan.h264.H264Player.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    YuvData yuvData2;
                    while (true) {
                        if (H264Player.yuvFrames.size() > 0 && (yuvData2 = (YuvData) H264Player.yuvFrames.poll()) != null) {
                            Iterator it = H264Player.yuvCallbacks.iterator();
                            while (it.hasNext()) {
                                ((OnYuvListener) it.next()).onYuv(yuvData2.width, yuvData2.height, yuvData2.Y, yuvData2.U, yuvData2.V);
                            }
                        }
                        if (H264Player.yuvFrames.size() > 10) {
                            j = 5;
                        } else if (H264Player.yuvFrames.size() > 6) {
                            j = 10;
                        } else if (H264Player.yuvFrames.size() > 4) {
                            j = 20;
                        } else {
                            j = H264Player.yuvFrames.size() > 2 ? 30L : 45L;
                        }
                        try {
                            Thread.sleep(j);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            renderThread = thread;
            thread.start();
        }
    }

    public static class YuvData {
        public byte[] U;
        public byte[] V;
        public byte[] Y;
        public int height;
        public int width;

        public YuvData(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
            this.Y = bArr;
            this.U = bArr2;
            this.V = bArr3;
            this.width = i;
            this.height = i2;
        }
    }
}
