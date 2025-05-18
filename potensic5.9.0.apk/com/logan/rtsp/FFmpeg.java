package com.logan.rtsp;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.exoplayer2.util.MimeTypes;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.SPHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class FFmpeg {
    public static final int FORMAT_NONE = -1;
    public static final int FORMAT_NV12 = 1;
    public static final int FORMAT_NV21 = 2;
    public static final int FORMAT_YUV420P = 4;
    public static final int FORMAT_YV12 = 3;
    public static final int PLAYER_ERROR = -1;
    public static final int PLAYER_HARD_DECODE_ERROR = -2;
    public static final int PLAYER_NONE = -100;
    public static final int PLAYER_PREVIEW_FINISH = 1;
    public static final int PLAYER_PREVIEW_START = 0;
    private static int fps;
    private static boolean isForceSoftEncode;
    public static boolean isSave;
    public static int playerState;
    private static OnFFmpegPlayerStateListener stateListener;
    private static long time1;
    private static OnYuvListener yuvListener;

    public interface OnFFmpegPlayerStateListener {
        void onPlayerState(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerState {
    }

    public static native String getJniPackageName();

    public static native int init();

    public static void onH264Callback(byte[] bArr) {
    }

    private static native int play(String str);

    public static native void release();

    private static native void setHardDecode(boolean z, int i);

    public static native void stop();

    static {
        try {
            System.loadLibrary("rtsp");
        } catch (Exception unused) {
        }
        isForceSoftEncode = false;
        playerState = -100;
        isSave = false;
        fps = 0;
        time1 = 0L;
    }

    public static void startPlay(String str, OnYuvListener onYuvListener) {
        yuvListener = onYuvListener;
        init();
        if (!isForceSoftEncode && SPHelper.getInstance().isHardDecode() && isH264DecoderSupport()) {
            setHardDecode(true, getColorFormat());
        } else {
            setHardDecode(false, -1);
        }
        play(str);
    }

    public static void onStateCallback(int i) {
        playerState = i;
        OnFFmpegPlayerStateListener onFFmpegPlayerStateListener = stateListener;
        if (onFFmpegPlayerStateListener != null) {
            onFFmpegPlayerStateListener.onPlayerState(i);
        }
        if (i == -2 || (i == -1 && SPHelper.getInstance().isHardDecode())) {
            isForceSoftEncode = true;
        }
    }

    public static void onYuvCallback(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        fps++;
        if (time1 > System.currentTimeMillis()) {
            time1 = 0L;
        }
        if (System.currentTimeMillis() - time1 >= 1000) {
            DDLog.m1691w("bitmap real fps:" + fps);
            fps = 0;
            time1 = System.currentTimeMillis();
        }
        OnYuvListener onYuvListener = yuvListener;
        if (onYuvListener != null) {
            onYuvListener.onYuv(i, i2, bArr, bArr2, bArr3);
        }
    }

    public static void onRgbCallback(byte[] bArr, int i, int i2) {
        DDLog.m1684e("avpacket:" + ParseUtil.byteToHexString(bArr, 100));
    }

    public static void onBitrate(int i) {
        DDLog.m1684e("码率：" + i);
    }

    public static void setFFmpegPlayerStateListener(OnFFmpegPlayerStateListener onFFmpegPlayerStateListener) {
        stateListener = onFFmpegPlayerStateListener;
    }

    public static boolean isH264DecoderSupport() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            String name = MediaCodecList.getCodecInfoAt(i).getName();
            DDLog.m1687i("name:" + name);
            if (name.toLowerCase().contains("decoder") && name.toLowerCase().contains("avc")) {
                return getColorFormat() != -1;
            }
        }
        return false;
    }

    private static int[] getMediaCodecList() {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount && mediaCodecInfo == null; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                boolean z = false;
                for (int i2 = 0; i2 < supportedTypes.length && !z; i2++) {
                    if (supportedTypes[i2].equals(MimeTypes.VIDEO_H264)) {
                        z = true;
                    }
                }
                if (z) {
                    mediaCodecInfo = codecInfoAt;
                }
            }
        }
        return mediaCodecInfo.getCapabilitiesForType(MimeTypes.VIDEO_H264).colorFormats;
    }

    public static int getColorFormat() {
        for (int i : getMediaCodecList()) {
            if (i == 39) {
                return 2;
            }
            switch (i) {
                case 19:
                    return 4;
                case 20:
                    return 3;
                case 21:
                    return 1;
                default:
            }
        }
        return -1;
    }
}