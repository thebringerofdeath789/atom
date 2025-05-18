package com.ipotensic.baselib.utils;

import android.content.Context;
import android.media.MediaPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;

/* loaded from: classes2.dex */
public class SoundMediaPlayer {
    private static volatile SoundMediaPlayer instance;
    private MediaPlayer mediaPlayer;
    private int playingId = -1;

    private SoundMediaPlayer() {
    }

    public static SoundMediaPlayer get() {
        if (instance == null) {
            synchronized (SoundMediaPlayer.class) {
                if (instance == null) {
                    SoundMediaPlayer soundMediaPlayer = new SoundMediaPlayer();
                    instance = soundMediaPlayer;
                    return soundMediaPlayer;
                }
            }
        }
        return instance;
    }

    public synchronized void play(Context context, int i, final MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.mediaPlayer.release();
            } catch (Exception unused) {
            }
        }
        try {
            this.playingId = i;
            MediaPlayer create = MediaPlayer.create(context, i);
            this.mediaPlayer = create;
            create.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.baselib.utils.SoundMediaPlayer.1
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    if (SoundMediaPlayer.this.mediaPlayer != null) {
                        try {
                            SoundMediaPlayer.this.mediaPlayer.stop();
                            SoundMediaPlayer.this.mediaPlayer.release();
                        } catch (Exception unused2) {
                        }
                    }
                    onCompletionListener.onCompletion(mediaPlayer2);
                }
            });
            this.mediaPlayer.start();
            DDLog.m1684e("播放成功");
        } catch (Exception e) {
            DDLog.m1684e("播放失败:" + e.getMessage());
        }
    }

    public synchronized boolean isPlaying() {
        boolean z;
        MediaPlayer mediaPlayer;
        z = false;
        try {
            if (this.playingId != -1 && (mediaPlayer = this.mediaPlayer) != null) {
                if (mediaPlayer.isPlaying()) {
                    z = true;
                }
            }
        } catch (Exception unused) {
            return false;
        }
        return z;
    }

    public int getPlayingId() {
        return this.playingId;
    }

    public synchronized void stop() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.baselib.utils.SoundMediaPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                SoundMediaPlayer soundMediaPlayer;
                synchronized (SoundMediaPlayer.class) {
                    try {
                        try {
                            if (SoundMediaPlayer.this.mediaPlayer != null) {
                                SoundMediaPlayer.this.mediaPlayer.stop();
                                SoundMediaPlayer.this.mediaPlayer.release();
                            }
                            SoundMediaPlayer.this.mediaPlayer = null;
                            soundMediaPlayer = SoundMediaPlayer.this;
                        } catch (Exception e) {
                            DDLog.m1684e("释放失败:" + e.getMessage());
                            SoundMediaPlayer.this.mediaPlayer = null;
                            soundMediaPlayer = SoundMediaPlayer.this;
                        }
                        soundMediaPlayer.playingId = -1;
                    } catch (Throwable th) {
                        SoundMediaPlayer.this.mediaPlayer = null;
                        SoundMediaPlayer.this.playingId = -1;
                        throw th;
                    }
                }
            }
        });
    }
}