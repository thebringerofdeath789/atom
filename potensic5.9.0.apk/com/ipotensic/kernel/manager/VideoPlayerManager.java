package com.ipotensic.kernel.manager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.kernel.C1965R;
import xyz.doikki.videocontroller.StandardVideoController;
import xyz.doikki.videocontroller.component.CompleteView;
import xyz.doikki.videocontroller.component.DIYVodControlView;
import xyz.doikki.videocontroller.component.GestureView;
import xyz.doikki.videoplayer.exo.ExoMediaSourceHelper;
import xyz.doikki.videoplayer.ijk.IjkPlayerFactory;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public class VideoPlayerManager {
    private BaseActivity activity;
    private ImageView btnBack;
    private ImageView btnDelete;
    private ImageView btnDownload;
    private ImageView btnInfo;
    private ImageView btnPrepareStartPlay;
    private ImageView btnShare;
    private boolean isServerVideo = false;
    private OnVideoPlayerListener playerListener;
    private String thumbPath;
    private TextView tvTitle;
    private VideoView videoPlayer;
    private LooperViewPager viewPager;

    public interface OnVideoPlayerListener {
        void onClickBack();

        void onClickDelete();

        void onClickDownload();

        void onClickShare();

        void onClickStartPlay();

        void onPlayError(int i);

        void onShowInfo();
    }

    public VideoPlayerManager(BaseActivity baseActivity, VideoView videoView, String str, OnVideoPlayerListener onVideoPlayerListener) {
        this.activity = baseActivity;
        this.videoPlayer = videoView;
        this.playerListener = onVideoPlayerListener;
        this.thumbPath = str;
        setPlayer();
    }

    public void setPlayer() {
        StandardVideoController standardVideoController = new StandardVideoController(this.activity);
        standardVideoController.removeAllControlComponent();
        standardVideoController.setEnableOrientation(false);
        standardVideoController.addControlComponent(new CompleteView(this.activity));
        standardVideoController.addControlComponent(new GestureView(this.activity));
        DIYVodControlView dIYVodControlView = new DIYVodControlView(this.activity);
        dIYVodControlView.setVisibility(0);
        this.viewPager = (LooperViewPager) dIYVodControlView.findViewById(C1965R.id.loop_viewpager);
        this.btnBack = (ImageView) dIYVodControlView.findViewById(C1965R.id.btn_back);
        this.btnInfo = (ImageView) dIYVodControlView.findViewById(C1965R.id.btn_info);
        this.btnShare = (ImageView) dIYVodControlView.findViewById(C1965R.id.btn_share);
        this.btnDownload = (ImageView) dIYVodControlView.findViewById(C1965R.id.btn_download);
        this.btnDelete = (ImageView) dIYVodControlView.findViewById(C1965R.id.btn_delete);
        this.tvTitle = (TextView) dIYVodControlView.findViewById(C1965R.id.tv_code_title);
        this.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.manager.VideoPlayerManager.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayerManager.this.playerListener != null) {
                    VideoPlayerManager.this.playerListener.onClickBack();
                }
            }
        });
        this.btnDownload.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.manager.VideoPlayerManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayerManager.this.playerListener != null) {
                    VideoPlayerManager.this.playerListener.onClickDownload();
                }
            }
        });
        this.btnInfo.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.manager.VideoPlayerManager.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayerManager.this.playerListener != null) {
                    VideoPlayerManager.this.playerListener.onShowInfo();
                }
            }
        });
        this.btnDelete.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.manager.VideoPlayerManager.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DDLog.m1684e("删除:");
                if (VideoPlayerManager.this.playerListener != null) {
                    VideoPlayerManager.this.playerListener.onClickDelete();
                }
            }
        });
        this.btnShare.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.manager.VideoPlayerManager.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayerManager.this.playerListener != null) {
                    VideoPlayerManager.this.playerListener.onClickShare();
                }
            }
        });
        this.btnInfo.setVisibility(4);
        this.btnShare.setVisibility(4);
        this.btnDownload.setVisibility(4);
        this.btnDelete.setVisibility(4);
        standardVideoController.addControlComponent(dIYVodControlView);
        standardVideoController.setGestureEnabled(true);
        this.videoPlayer.setVideoController(standardVideoController);
        this.videoPlayer.addOnStateChangeListener(new VideoView.OnStateChangeListener() { // from class: com.ipotensic.kernel.manager.VideoPlayerManager.6
            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayerStateChanged(int i) {
            }

            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayStateChanged(int i) {
                DDLog.m1684e("player state:" + i);
                if (i == -1 && VideoPlayerManager.this.isServerVideo) {
                    ToastUtil.toast(VideoPlayerManager.this.activity, VideoPlayerManager.this.activity.getResources().getString(C1965R.string.please_check_the_network));
                }
            }
        });
        this.videoPlayer.setPlayerFactory(IjkPlayerFactory.create());
    }

    public LooperViewPager getViewPager() {
        return this.viewPager;
    }

    public void setLocalVideo() {
        this.btnDownload.setVisibility(4);
    }

    public void setServerVideo() {
        this.isServerVideo = true;
        this.btnInfo.setVisibility(4);
        this.btnShare.setVisibility(4);
        this.btnDownload.setVisibility(4);
        this.btnDelete.setVisibility(4);
    }

    public void setDownloadedUI() {
        this.btnDownload.setImageResource(C1965R.mipmap.img_mark_already_downloaded);
    }

    public void startPlay(String str, String str2, boolean z) {
        if (str != null) {
            this.tvTitle.setText(str);
        }
        DDLog.m1684e("播放地址:" + str2);
        this.videoPlayer.setUrl(str2);
        ExoMediaSourceHelper.isServerVideo = z;
        this.videoPlayer.start();
    }

    public void onResume() {
        VideoView videoView = this.videoPlayer;
        if (videoView != null) {
            videoView.resume();
        }
    }

    public void onPause() {
        VideoView videoView = this.videoPlayer;
        if (videoView != null) {
            videoView.pause();
        }
    }

    public void onDestroy() {
        VideoView videoView = this.videoPlayer;
        if (videoView != null) {
            videoView.release();
        }
    }

    public boolean onBackPressed() {
        VideoView videoView = this.videoPlayer;
        return videoView == null || !videoView.onBackPressed();
    }
}