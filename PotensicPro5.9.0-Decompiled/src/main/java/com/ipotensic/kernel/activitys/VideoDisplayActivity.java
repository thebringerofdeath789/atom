package com.ipotensic.kernel.activitys;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.manager.VideoPlayerManager;
import com.ipotensic.kernel.utils.VideoPlayerUtils;
import com.ipotensic.kernel.view.DownloadFileDialog;
import com.ipotensic.kernel.view.dialog.MediaInfoDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.RemoteFile;
import com.logan.camera.data.MediaInfoData;
import com.logan.camera.enums.CameraModel;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.usb.gallery.UsbGalleryManager;
import java.io.File;
import java.io.Serializable;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public class VideoDisplayActivity extends BaseActivity implements EventDispatcher.OnEventListener {
    private Serializable data;
    private DownloadFileDialog downloadDialog;
    protected LinearLayout layoutMain;
    private MediaInfoData mediaInfoData;
    private MediaInfoDialog mediaInfoDialog;
    private String path;
    private VideoPlayerManager playerManager;
    private int position;
    private String title;
    private final int TOP_PADDING = 80;
    private boolean deleteSuccess = false;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isServerVideo = false;
    private boolean isLocalVideo = false;
    IMediaInfoCallback callback = new IMediaInfoCallback() { // from class: com.ipotensic.kernel.activitys.VideoDisplayActivity.3
        @Override // com.logan.camera.listeners.IMediaInfoCallback
        public void onCallback(MediaInfoData mediaInfoData) {
            if (mediaInfoData != null) {
                VideoDisplayActivity.this.mediaInfoData = mediaInfoData;
                DDLog.e("mediainfo:" + mediaInfoData.toString());
            }
        }
    };
    VideoPlayerManager.OnVideoPlayerListener playerListener = new AnonymousClass4();

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(false);
        setContentView(R.layout.activity_test_player);
        initIntent();
        this.layoutMain = (LinearLayout) findViewById(R.id.layout_main);
        if (this.isLocalVideo) {
            setRequestedOrientation(-1);
        }
        configOrientation();
        VideoView videoView = (VideoView) findViewById(R.id.player);
        Serializable serializable = this.data;
        VideoPlayerManager videoPlayerManager = new VideoPlayerManager(this, videoView, serializable instanceof LocalFile ? ((LocalFile) serializable).getAbsPath() : ((RemoteFile) serializable).getThumbnailUrl(), this.playerListener);
        this.playerManager = videoPlayerManager;
        if (this.isServerVideo) {
            videoPlayerManager.setServerVideo();
        }
        if (this.isLocalVideo) {
            this.playerManager.setLocalVideo();
        }
        init(getIntent());
        EventDispatcher.get().registerEvent(getLifecycle(), this);
    }

    private void initIntent() {
        this.isServerVideo = getIntent().getBooleanExtra("isServerVideo", false);
        this.isLocalVideo = getIntent().getBooleanExtra("isLocalVideo", false);
        this.position = getIntent().getIntExtra("position", 0);
        this.data = getIntent().getSerializableExtra("data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download(final OnResultListener onResultListener) {
        VideoPlayerUtils.download(this, (RemoteFile) this.data, this.downloadDialog, new VideoPlayerUtils.OnDownloadListener() { // from class: com.ipotensic.kernel.activitys.VideoDisplayActivity.1
            @Override // com.ipotensic.kernel.utils.VideoPlayerUtils.OnDownloadListener
            public void onDownloadFailed() {
            }

            @Override // com.ipotensic.kernel.utils.VideoPlayerUtils.OnDownloadListener
            public void onDownloadSuccess() {
                VideoDisplayActivity videoDisplayActivity = VideoDisplayActivity.this;
                videoDisplayActivity.setFileDownloaded((RemoteFile) videoDisplayActivity.data);
                VideoDisplayActivity.this.playerManager.startPlay(VideoDisplayActivity.this.title, VideoDisplayActivity.this.path, VideoDisplayActivity.this.isServerVideo);
                UsbGalleryManager.getInstance().getFileDetail((RemoteFile) VideoDisplayActivity.this.data, VideoDisplayActivity.this.callback);
                OnResultListener onResultListener2 = onResultListener;
                if (onResultListener2 != null) {
                    onResultListener2.onSuccess(true);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.activitys.VideoDisplayActivity$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_PULL_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        int i = AnonymousClass5.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (this.isLocalVideo || ((Boolean) event.obj).booleanValue()) {
                return;
            }
            finishActivity();
            return;
        }
        if (i == 2 && !this.isLocalVideo) {
            try {
                CameraConfig.get().setSdState(0);
                DownloadFileDialog downloadFileDialog = this.downloadDialog;
                if (downloadFileDialog != null && downloadFileDialog.isShowing()) {
                    this.downloadDialog.dismiss();
                }
                if (this.loadingDialog != null && this.loadingDialog.isShowing()) {
                    this.loadingDialog.dismiss();
                }
                ToastUtil.toast(this, getString(R.string.sd_pullout));
                this.handler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.activitys.VideoDisplayActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoDisplayActivity.this.finishActivity();
                    }
                }, 1000L);
            } catch (Exception unused) {
            }
        }
    }

    protected void init(Intent intent) {
        Serializable serializable = this.data;
        if (serializable instanceof LocalFile) {
            DDLog.e("fileTime:" + ((LocalFile) this.data).getDuration());
            this.path = ((LocalFile) this.data).getAbsPath();
            File file = new File(((LocalFile) this.data).getAbsPath());
            if (file.exists()) {
                this.title = file.getName();
            } else {
                DDLog.w("文件不存在");
            }
            this.mediaInfoData = VideoPlayerUtils.parseLocalVideoMeta((LocalFile) this.data);
        } else if (serializable instanceof RemoteFile) {
            this.path = ((RemoteFile) serializable).getDownloadUrl();
            if (((RemoteFile) this.data).isFromUsb()) {
                this.path = ((RemoteFile) this.data).getUsbLrvPath();
            } else if (((RemoteFile) this.data).isDownloaded()) {
                if (((RemoteFile) this.data).getLocalPath() != null) {
                    this.path = ((RemoteFile) this.data).getLocalPath();
                } else {
                    this.path = new File(LocalFileManager.getInstance().getMediaDir(), ((RemoteFile) this.data).getFileName()).getAbsolutePath();
                }
                setFileDownloaded((RemoteFile) this.data);
            }
            if (((RemoteFile) this.data).isFromUsb()) {
                this.title = ((RemoteFile) this.data).getFileName();
            } else {
                this.title = ((RemoteFile) this.data).getFileName();
                if (!this.isServerVideo && CameraConfig.get().getCameraModel() == CameraModel.MODEL_59) {
                    this.path = this.path.substring(0, r4.length() - 3) + "LRV";
                }
            }
            if (!((RemoteFile) this.data).isFromUsb()) {
                UsbGalleryManager.getInstance().getFileDetail((RemoteFile) this.data, this.callback);
                CameraCtrlPresenter.getInstance().getMediaInfo(((RemoteFile) this.data).getRemotePath(), this.callback);
            }
        }
        DDLog.i("video play path:" + this.path);
        Serializable serializable2 = this.data;
        if (serializable2 instanceof LocalFile) {
            this.playerManager.startPlay(this.title, this.path, this.isServerVideo);
            return;
        }
        if (((RemoteFile) serializable2).isFromUsb()) {
            UsbGalleryManager.getInstance().getFileDetail((RemoteFile) this.data, this.callback);
            if (((RemoteFile) this.data).isDownloaded() || ((RemoteFile) this.data).isDownloaded()) {
                setFileDownloaded((RemoteFile) this.data);
                this.playerManager.startPlay(this.title, this.path, this.isServerVideo);
                return;
            }
            return;
        }
        this.playerManager.startPlay(this.title, this.path, this.isServerVideo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileDownloaded(RemoteFile remoteFile) {
        this.playerManager.setDownloadedUI();
        remoteFile.setDownloaded(true);
    }

    protected void showMediaInfo() {
        if (this.mediaInfoData != null) {
            if (getResources().getConfiguration().orientation == 2) {
                this.mediaInfoDialog = new MediaInfoDialog(this);
            } else if (getResources().getConfiguration().orientation == 1) {
                this.mediaInfoDialog = new MediaInfoDialog(this, 1);
            }
            this.mediaInfoDialog.setMediaInfo(this.mediaInfoData);
            this.mediaInfoDialog.show();
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.VideoDisplayActivity$4, reason: invalid class name */
    class AnonymousClass4 implements VideoPlayerManager.OnVideoPlayerListener {
        AnonymousClass4() {
        }

        @Override // com.ipotensic.kernel.manager.VideoPlayerManager.OnVideoPlayerListener
        public void onClickBack() {
            VideoDisplayActivity.this.finishActivity();
        }

        @Override // com.ipotensic.kernel.manager.VideoPlayerManager.OnVideoPlayerListener
        public void onClickStartPlay() {
            VideoDisplayActivity.this.download(null);
        }

        @Override // com.ipotensic.kernel.manager.VideoPlayerManager.OnVideoPlayerListener
        public void onClickDownload() {
            if (VideoDisplayActivity.this.data instanceof RemoteFile) {
                PermissionUtil.requestStoragePermissionInDownloadWithDialog(VideoDisplayActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.kernel.activitys.VideoDisplayActivity.4.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        VideoDisplayActivity.this.download(null);
                    }
                });
            }
        }

        @Override // com.ipotensic.kernel.manager.VideoPlayerManager.OnVideoPlayerListener
        public void onClickDelete() {
            OnResultListener onResultListener = new OnResultListener() { // from class: com.ipotensic.kernel.activitys.VideoDisplayActivity.4.2
                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onFailed(Exception exc) {
                }

                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onSuccess(Object obj) {
                    ToastUtil.showPositionBottom(VideoDisplayActivity.this, VideoDisplayActivity.this.getString(R.string.toast_delete_success), R.mipmap.icon_toast_successful);
                }
            };
            if (!(VideoDisplayActivity.this.data instanceof LocalFile)) {
                if (VideoDisplayActivity.this.data instanceof RemoteFile) {
                    if (((RemoteFile) VideoDisplayActivity.this.data).isFromUsb()) {
                        VideoDisplayActivity videoDisplayActivity = VideoDisplayActivity.this;
                        VideoPlayerUtils.deleteUsbRemoteFile(videoDisplayActivity, (RemoteFile) videoDisplayActivity.data, VideoDisplayActivity.this.position, onResultListener);
                        return;
                    } else {
                        VideoDisplayActivity videoDisplayActivity2 = VideoDisplayActivity.this;
                        VideoPlayerUtils.deleteRemoteFile(videoDisplayActivity2, (RemoteFile) videoDisplayActivity2.data, VideoDisplayActivity.this.position, onResultListener);
                        return;
                    }
                }
                return;
            }
            VideoDisplayActivity videoDisplayActivity3 = VideoDisplayActivity.this;
            VideoPlayerUtils.deleteLocalFile(videoDisplayActivity3, (LocalFile) videoDisplayActivity3.data, onResultListener);
        }

        /* renamed from: com.ipotensic.kernel.activitys.VideoDisplayActivity$4$3, reason: invalid class name */
        class AnonymousClass3 implements PermissionUtil.OnPermissionListener {
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            AnonymousClass3() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                if (VideoDisplayActivity.this.data instanceof LocalFile) {
                    VideoPlayerUtils.share(VideoDisplayActivity.this, new File(((LocalFile) VideoDisplayActivity.this.data).getAbsPath()));
                    return;
                }
                if (VideoDisplayActivity.this.data instanceof RemoteFile) {
                    if (((RemoteFile) VideoDisplayActivity.this.data).isDownloaded()) {
                        if (((RemoteFile) VideoDisplayActivity.this.data).isFromUsb()) {
                            VideoPlayerUtils.share(VideoDisplayActivity.this, new File(((RemoteFile) VideoDisplayActivity.this.data).getUsbLrvPath()));
                            return;
                        } else {
                            VideoPlayerUtils.share(VideoDisplayActivity.this, new File(LocalFileManager.getInstance().getMediaDir(), ((RemoteFile) VideoDisplayActivity.this.data).getFileName()));
                            return;
                        }
                    }
                    VideoDisplayActivity.this.download(new OnResultListener() { // from class: com.ipotensic.kernel.activitys.VideoDisplayActivity.4.3.1
                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onFailed(Exception exc) {
                        }

                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onSuccess(Object obj) {
                            File file;
                            if (((RemoteFile) VideoDisplayActivity.this.data).isFromUsb()) {
                                file = new File(((RemoteFile) VideoDisplayActivity.this.data).getUsbLrvPath());
                            } else {
                                file = new File(LocalFileManager.getInstance().getMediaDir(), ((RemoteFile) VideoDisplayActivity.this.data).getLrvFileName());
                            }
                            VideoPlayerUtils.share(VideoDisplayActivity.this, file);
                            PermissionUtil.requestStoragePermissionInShareWithDialog(VideoDisplayActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.kernel.activitys.VideoDisplayActivity.4.3.1.1
                                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                                public void onDenied() {
                                }

                                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                                public void onDeniedWithNeverAsk(String... strArr) {
                                }

                                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                                public void onGrant() {
                                    File file2;
                                    if (((RemoteFile) VideoDisplayActivity.this.data).isFromUsb()) {
                                        file2 = new File(((RemoteFile) VideoDisplayActivity.this.data).getUsbLrvPath());
                                    } else {
                                        file2 = new File(LocalFileManager.getInstance().getMediaDir(), ((RemoteFile) VideoDisplayActivity.this.data).getLrvFileName());
                                    }
                                    VideoPlayerUtils.share(VideoDisplayActivity.this, file2);
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.ipotensic.kernel.manager.VideoPlayerManager.OnVideoPlayerListener
        public void onClickShare() {
            PermissionUtil.requestStoragePermissionInShareWithDialog(VideoDisplayActivity.this, new AnonymousClass3());
        }

        @Override // com.ipotensic.kernel.manager.VideoPlayerManager.OnVideoPlayerListener
        public void onShowInfo() {
            VideoDisplayActivity.this.showMediaInfo();
        }

        @Override // com.ipotensic.kernel.manager.VideoPlayerManager.OnVideoPlayerListener
        public void onPlayError(int i) {
            if (i == -1 && VideoDisplayActivity.this.isServerVideo) {
                VideoDisplayActivity videoDisplayActivity = VideoDisplayActivity.this;
                ToastUtil.toast(videoDisplayActivity, videoDisplayActivity.getResources().getString(R.string.please_check_the_network));
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configOrientation();
    }

    private void configOrientation() {
        if (getResources().getConfiguration().orientation == 2) {
            this.layoutMain.setPadding(0, 0, 0, 0);
            setFullscreen();
            DDLog.e("横屏");
        } else {
            DDLog.e("竖屏");
            this.layoutMain.setPadding(0, 80, 0, 0);
            setStateBarShow(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("position", this.position);
        setResult(-1, intent);
        finish();
        if (this.data instanceof RemoteFile) {
            overridePendingTransition(0, R.anim.trans_out_bottom_gallery);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.playerManager.onResume();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.playerManager.onPause();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.playerManager.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.playerManager.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
