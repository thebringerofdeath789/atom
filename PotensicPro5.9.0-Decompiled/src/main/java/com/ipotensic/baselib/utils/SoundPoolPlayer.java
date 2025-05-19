package com.ipotensic.baselib.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.R;

/* loaded from: classes2.dex */
public class SoundPoolPlayer {
    public static int CAPTURE_VOICE_ID;
    public static int CONTROLLER_DISCONNECT_ID;
    public static int COUNTDOWN_ONE;
    public static int COUNTDOWN_THREE;
    public static int COUNTDOWN_TWO;
    public static int FLY_CTRL_DISCONNECT_ID;
    public static int GPS_INTERFERENCE_ID;
    public static int LOSE_CONTROL_VOICE_ID;
    public static int ONE_LEVEL_NO_POWER_VOICE_ID;
    public static int RECONNECT_VOICE_ID;
    public static int RECORD_VOICE_ID;
    public static int SHORT_VIDEO_GO;
    public static int TWO_LEVEL_NO_POWER_VOICE_ID;
    private static volatile SoundPoolPlayer instance;
    private Context context;
    private SoundPool mSoundPool;

    private SoundPoolPlayer() {
    }

    public static SoundPoolPlayer getInstance() {
        if (instance == null) {
            synchronized (SoundPoolPlayer.class) {
                if (instance == null) {
                    SoundPoolPlayer soundPoolPlayer = new SoundPoolPlayer();
                    instance = soundPoolPlayer;
                    return soundPoolPlayer;
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.context = context;
        SoundPool soundPool = this.mSoundPool;
        if (soundPool != null) {
            try {
                soundPool.release();
            } catch (Exception unused) {
            }
            this.mSoundPool = null;
        }
        SoundPool soundPool2 = new SoundPool(10, 3, 0);
        this.mSoundPool = soundPool2;
        CAPTURE_VOICE_ID = soundPool2.load(context, R.raw.capture_tips, 1);
        RECORD_VOICE_ID = this.mSoundPool.load(context, R.raw.record_tips, 1);
        LOSE_CONTROL_VOICE_ID = this.mSoundPool.load(context, R.raw.lose_control_tips, 1);
        RECONNECT_VOICE_ID = this.mSoundPool.load(context, R.raw.reconnect_tips, 1);
        ONE_LEVEL_NO_POWER_VOICE_ID = this.mSoundPool.load(context, R.raw.one_level_no_power, 1);
        TWO_LEVEL_NO_POWER_VOICE_ID = this.mSoundPool.load(context, R.raw.two_level_no_power, 1);
        CONTROLLER_DISCONNECT_ID = this.mSoundPool.load(context, R.raw.sound_controller_disconnect, 1);
        FLY_CTRL_DISCONNECT_ID = this.mSoundPool.load(context, R.raw.sound_fly_ctrl_disconnect, 1);
        GPS_INTERFERENCE_ID = this.mSoundPool.load(context, R.raw.gps_interference_tips, 1);
        COUNTDOWN_ONE = this.mSoundPool.load(context, R.raw.audio_countdown_one, 1);
        COUNTDOWN_TWO = this.mSoundPool.load(context, R.raw.audio_countdown_two, 1);
        COUNTDOWN_THREE = this.mSoundPool.load(context, R.raw.audio_countdown_three, 1);
        SHORT_VIDEO_GO = this.mSoundPool.load(context, R.raw.audio_short_video_go, 1);
    }

    public void playVoice(Context context, int i) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            float streamVolume = audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
            this.mSoundPool.play(i, streamVolume, streamVolume, 0, 0, 1.0f);
        } catch (Exception e) {
            DDLog.e("播放失败:" + e.getMessage());
        }
    }

    public void playRaw(Context context, int i) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            float streamVolume = audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
            this.mSoundPool.play(this.mSoundPool.load(context, i, 1), streamVolume, streamVolume, 0, 0, 1.0f);
        } catch (Exception e) {
            DDLog.e("播放失败:" + e.getMessage());
        }
    }

    public void release() {
        SoundPool soundPool = this.mSoundPool;
        if (soundPool != null) {
            soundPool.release();
            this.mSoundPool = null;
        }
    }
}
