package xyz.doikki.videoplayer.player;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
final class AudioFocusHelper implements AudioManager.OnAudioFocusChangeListener {
    private AudioManager mAudioManager;
    private WeakReference<VideoView> mWeakVideoView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mStartRequested = false;
    private boolean mPausedForLoss = false;
    private int mCurrentFocus = 0;

    AudioFocusHelper(VideoView videoView) {
        this.mWeakVideoView = new WeakReference<>(videoView);
        this.mAudioManager = (AudioManager) videoView.getContext().getApplicationContext().getSystemService("audio");
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(final int i) {
        if (this.mCurrentFocus == i) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: xyz.doikki.videoplayer.player.AudioFocusHelper.1
            @Override // java.lang.Runnable
            public void run() {
                AudioFocusHelper.this.handleAudioFocusChange(i);
            }
        });
        this.mCurrentFocus = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAudioFocusChange(int i) {
        VideoView videoView = this.mWeakVideoView.get();
        if (videoView == null) {
            return;
        }
        if (i == -3) {
            if (!videoView.isPlaying() || videoView.isMute()) {
                return;
            }
            videoView.setVolume(0.1f, 0.1f);
            return;
        }
        if (i == -2 || i == -1) {
            if (videoView.isPlaying()) {
                this.mPausedForLoss = true;
                videoView.pause();
                return;
            }
            return;
        }
        if (i == 1 || i == 2) {
            if (this.mStartRequested || this.mPausedForLoss) {
                videoView.start();
                this.mStartRequested = false;
                this.mPausedForLoss = false;
            }
            if (videoView.isMute()) {
                return;
            }
            videoView.setVolume(1.0f, 1.0f);
        }
    }

    void requestFocus() {
        AudioManager audioManager;
        if (this.mCurrentFocus == 1 || (audioManager = this.mAudioManager) == null) {
            return;
        }
        if (1 == audioManager.requestAudioFocus(this, 3, 1)) {
            this.mCurrentFocus = 1;
        } else {
            this.mStartRequested = true;
        }
    }

    void abandonFocus() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            return;
        }
        this.mStartRequested = false;
        audioManager.abandonAudioFocus(this);
    }
}
