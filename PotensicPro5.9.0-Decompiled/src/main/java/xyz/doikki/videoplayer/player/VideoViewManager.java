package xyz.doikki.videoplayer.player;

import android.app.Application;
import java.util.LinkedHashMap;
import xyz.doikki.videoplayer.util.L;

/* loaded from: classes6.dex */
public class VideoViewManager {
    private static VideoViewConfig sConfig;
    private static VideoViewManager sInstance;
    private LinkedHashMap<String, VideoView> mVideoViews = new LinkedHashMap<>();
    private boolean mPlayOnMobileNetwork = getConfig().mPlayOnMobileNetwork;

    private VideoViewManager() {
    }

    public static void setConfig(VideoViewConfig videoViewConfig) {
        if (sConfig == null) {
            synchronized (VideoViewConfig.class) {
                if (sConfig == null) {
                    if (videoViewConfig == null) {
                        videoViewConfig = VideoViewConfig.newBuilder().build();
                    }
                    sConfig = videoViewConfig;
                }
            }
        }
    }

    public static VideoViewConfig getConfig() {
        setConfig(null);
        return sConfig;
    }

    public boolean playOnMobileNetwork() {
        return this.mPlayOnMobileNetwork;
    }

    public void setPlayOnMobileNetwork(boolean z) {
        this.mPlayOnMobileNetwork = z;
    }

    public static VideoViewManager instance() {
        if (sInstance == null) {
            synchronized (VideoViewManager.class) {
                if (sInstance == null) {
                    sInstance = new VideoViewManager();
                }
            }
        }
        return sInstance;
    }

    public void add(VideoView videoView, String str) {
        if (!(videoView.getContext() instanceof Application)) {
            L.w("The Context of this VideoView is not an Application Context,you must remove it after release,or it will lead to memory leek.");
        }
        VideoView videoView2 = get(str);
        if (videoView2 != null) {
            videoView2.release();
            remove(str);
        }
        this.mVideoViews.put(str, videoView);
    }

    public VideoView get(String str) {
        return this.mVideoViews.get(str);
    }

    public void remove(String str) {
        this.mVideoViews.remove(str);
    }

    public void removeAll() {
        this.mVideoViews.clear();
    }

    public void releaseByTag(String str) {
        releaseByTag(str, true);
    }

    public void releaseByTag(String str, boolean z) {
        VideoView videoView = get(str);
        if (videoView != null) {
            videoView.release();
            if (z) {
                remove(str);
            }
        }
    }

    public boolean onBackPress(String str) {
        VideoView videoView = get(str);
        if (videoView == null) {
            return false;
        }
        return videoView.onBackPressed();
    }
}
