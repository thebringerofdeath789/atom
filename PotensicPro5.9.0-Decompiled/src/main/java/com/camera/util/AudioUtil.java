package com.camera.util;

import android.content.Context;
import android.media.AudioManager;

/* loaded from: classes.dex */
public class AudioUtil {
    public static void setAudioManage(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        audioManager.setStreamMute(1, true);
        audioManager.setStreamMute(3, true);
        audioManager.setStreamVolume(4, 0, 0);
        audioManager.setStreamVolume(8, 0, 0);
        audioManager.setStreamVolume(5, 0, 0);
        audioManager.setStreamVolume(2, 0, 0);
    }
}
