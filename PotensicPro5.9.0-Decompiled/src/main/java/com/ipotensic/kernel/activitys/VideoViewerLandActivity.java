package com.ipotensic.kernel.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.manager.VideoLoopManager;
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
import java.util.ArrayList;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class VideoViewerLandActivity extends BaseActivity implements EventDispatcher.OnEventListener {
    private ImageView btnBack;
    private ImageButton btnDelete;
    private ImageButton btnDownload;
    private ImageButton btnMediaInfo;
    private ImageButton btnShare;
    private Serializable data;
    private ArrayList dataList;
    private DownloadFileDialog downloadDialog;
    private ConstraintLayout layoutBottom;
    protected ConstraintLayout layoutMain;
    private ConstraintLayout layoutTop;
    private MediaInfoData mediaInfoData;
    private MediaInfoDialog mediaInfoDialog;
    private String path;
    private int position;
    private String title;
    private TextView tvCurPageNum;
    private TextView tvShowTips;
    private TextView tvTips;
    private LooperViewPager viewPager;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isServerVideo = false;
    private boolean isLocalVideo = false;
    protected boolean isLandActivity = true;
    private boolean hasDelete = false;
    IMediaInfoCallback callback = new IMediaInfoCallback() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.11
        @Override // com.logan.camera.listeners.IMediaInfoCallback
        public void onCallback(MediaInfoData mediaInfoData) {
            if (mediaInfoData != null) {
                VideoViewerLandActivity.this.mediaInfoData = mediaInfoData;
                DDLog.e("mediainfo:" + mediaInfoData.toString());
            }
        }
    };
    private final VideoLoopManager.OnPageLoopListener pagerChangeListener = new VideoLoopManager.OnPageLoopListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.12
        @Override // com.ipotensic.kernel.manager.VideoLoopManager.OnPageLoopListener
        public void onPageChanged(int i, int i2) {
            try {
                DDLog.e("curIndex:" + i);
                DDLog.e("mediaInfoData:" + VideoViewerLandActivity.this.mediaInfoData);
                VideoViewerLandActivity.this.handler.removeCallbacks(VideoViewerLandActivity.this.tipsDismissRunnable);
                VideoViewerLandActivity.this.handler.post(VideoViewerLandActivity.this.tipsDismissRunnable);
                VideoViewerLandActivity.this.position = i;
                VideoViewerLandActivity videoViewerLandActivity = VideoViewerLandActivity.this;
                videoViewerLandActivity.data = (Serializable) videoViewerLandActivity.dataList.get(i);
                VideoViewerLandActivity.this.initData();
                if (VideoViewerLandActivity.this.isLandActivity) {
                    VideoViewerLandActivity.this.tvCurPageNum.setText((i + 1) + InternalZipConstants.ZIP_FILE_SEPARATOR + i2);
                    VideoViewerLandActivity videoViewerLandActivity2 = VideoViewerLandActivity.this;
                    videoViewerLandActivity2.setFileDownloaded((RemoteFile) videoViewerLandActivity2.data);
                } else if (VideoViewerLandActivity.this.mediaInfoData != null) {
                    VideoViewerLandActivity.this.tvCurPageNum.setTextSize(2, 16.0f);
                    VideoViewerLandActivity.this.tvCurPageNum.setText(VideoViewerLandActivity.this.mediaInfoData.getCreatetime());
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.ipotensic.kernel.manager.VideoLoopManager.OnPageLoopListener
        public void onClickPlay(final Serializable serializable) {
            if (serializable instanceof LocalFile) {
                VideoViewerLandActivity.this.toPlay(serializable);
            } else if (VideoViewerLandActivity.this.data instanceof RemoteFile) {
                if (((RemoteFile) VideoViewerLandActivity.this.data).isFromUsb()) {
                    VideoViewerLandActivity.this.download(new OnResultListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.12.1
                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onFailed(Exception exc) {
                        }

                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onSuccess(Object obj) {
                            VideoViewerLandActivity.this.toPlay(serializable);
                        }
                    });
                } else {
                    VideoViewerLandActivity.this.toPlay(serializable);
                }
            }
        }

        @Override // com.ipotensic.kernel.manager.VideoLoopManager.OnPageLoopListener
        public void onScreenFull() {
            VideoViewerLandActivity.this.layoutTop.setVisibility(VideoViewerLandActivity.this.layoutTop.getVisibility() == 0 ? 8 : 0);
            VideoViewerLandActivity.this.layoutBottom.setVisibility(VideoViewerLandActivity.this.layoutBottom.getVisibility() != 0 ? 0 : 8);
            VideoViewerLandActivity.this.handler.removeCallbacks(VideoViewerLandActivity.this.tipsDismissRunnable);
            VideoViewerLandActivity.this.handler.post(VideoViewerLandActivity.this.tipsDismissRunnable);
        }
    };
    private final Runnable tipsDismissRunnable = new Runnable() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.14
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VideoViewerLandActivity.this.isFinishing()) {
                    return;
                }
                VideoViewerLandActivity.this.tvTips.setVisibility(8);
            } catch (Exception unused) {
            }
        }
    };

    @Override // com.ipotensic.baselib.base.BaseActivity
    public boolean isNewFullScreenPage() {
        return true;
    }

    static /* synthetic */ int access$910(VideoViewerLandActivity videoViewerLandActivity) {
        int i = videoViewerLandActivity.position;
        videoViewerLandActivity.position = i - 1;
        return i;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_viewer);
        initIntent();
        initView();
        VideoLoopManager.get().init(this, this.viewPager, this.dataList, this.position, this.pagerChangeListener);
        EventDispatcher.get().registerEvent(getLifecycle(), this);
    }

    private void initIntent() {
        this.isServerVideo = getIntent().getBooleanExtra("isServerVideo", false);
        this.isLocalVideo = getIntent().getBooleanExtra("isLocalVideo", false);
        this.position = getIntent().getIntExtra("position", 0);
        Serializable serializableExtra = getIntent().getSerializableExtra("data");
        if (serializableExtra instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) serializableExtra;
            this.dataList = arrayList;
            int size = arrayList.size();
            int i = this.position;
            if (size > i) {
                this.data = (Serializable) this.dataList.get(i);
            }
        }
    }

    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.btn_back);
        this.btnBack = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoViewerLandActivity.this.finishActivity();
            }
        });
        this.viewPager = (LooperViewPager) findViewById(R.id.loop_viewpager);
        this.tvCurPageNum = (TextView) findViewById(R.id.tv_cur_page_num);
        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_media_info);
        this.btnMediaInfo = imageButton;
        imageButton.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                VideoViewerLandActivity.this.showMediaInfo();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.btn_media_share);
        this.btnShare = imageButton2;
        imageButton2.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                VideoViewerLandActivity.this.share();
            }
        });
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.btn_download);
        this.btnDownload = imageButton3;
        imageButton3.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (VideoViewerLandActivity.this.data instanceof RemoteFile) {
                    if (!((RemoteFile) VideoViewerLandActivity.this.data).isDownloaded()) {
                        VideoViewerLandActivity.this.download(null);
                    } else {
                        VideoViewerLandActivity videoViewerLandActivity = VideoViewerLandActivity.this;
                        ToastUtil.toast(videoViewerLandActivity, videoViewerLandActivity.getString(R.string.dialog_file_is_downloaded));
                    }
                }
            }
        });
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.btn_delete);
        this.btnDelete = imageButton4;
        imageButton4.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.5
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                VideoViewerLandActivity.this.delete();
            }
        });
        if (!this.isLandActivity) {
            this.btnMediaInfo.setVisibility(4);
            this.tvCurPageNum.setTextColor(getColor(R.color.colorBlack));
            this.btnBack.setImageResource(R.mipmap.img_arrow_left_black);
            this.btnShare.setImageResource(R.mipmap.img_btn_media_share);
            this.btnDownload.setImageResource(R.mipmap.img_btn_media_info);
            this.btnDownload.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.6
                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    VideoViewerLandActivity.this.showMediaInfo();
                }
            });
        }
        this.layoutMain = (ConstraintLayout) findViewById(R.id.layout_main);
        this.layoutTop = (ConstraintLayout) findViewById(R.id.layout_top);
        this.layoutBottom = (ConstraintLayout) findViewById(R.id.layout_bottom);
        this.layoutMain.setBackgroundColor(getResources().getColor(this.isLandActivity ? R.color.colorBlack : R.color.colorWhite));
        this.layoutTop.setBackgroundColor(getResources().getColor(this.isLandActivity ? R.color.colorSeventyPercent_gallery_tab : R.color.colorWhite));
        this.layoutBottom.setBackgroundColor(getResources().getColor(this.isLandActivity ? R.color.colorSeventyPercent_gallery_tab : R.color.colorWhite));
        this.tvShowTips = (TextView) findViewById(R.id.tvShowTips);
        this.tvTips = (TextView) findViewById(R.id.tvTips);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download(final OnResultListener onResultListener) {
        Serializable serializable = this.data;
        if (serializable instanceof RemoteFile) {
            if (!((RemoteFile) serializable).isDownloaded()) {
                PermissionUtil.requestStoragePermissionInDownloadWithDialog(this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.7
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        VideoViewerLandActivity videoViewerLandActivity = VideoViewerLandActivity.this;
                        VideoPlayerUtils.download(videoViewerLandActivity, (RemoteFile) videoViewerLandActivity.data, VideoViewerLandActivity.this.downloadDialog, new VideoPlayerUtils.OnDownloadListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.7.1
                            @Override // com.ipotensic.kernel.utils.VideoPlayerUtils.OnDownloadListener
                            public void onDownloadFailed() {
                            }

                            @Override // com.ipotensic.kernel.utils.VideoPlayerUtils.OnDownloadListener
                            public void onDownloadSuccess() {
                                VideoViewerLandActivity.this.setFileDownloaded((RemoteFile) VideoViewerLandActivity.this.data);
                                UsbGalleryManager.getInstance().getFileDetail((RemoteFile) VideoViewerLandActivity.this.data, VideoViewerLandActivity.this.callback);
                                if (onResultListener != null) {
                                    onResultListener.onSuccess(true);
                                }
                                ToastUtil.showImageTop(VideoViewerLandActivity.this, VideoViewerLandActivity.this.getResources().getString(R.string.toast_download_success), R.mipmap.icon_toast_successful);
                            }
                        });
                    }
                });
            } else if (onResultListener != null) {
                onResultListener.onSuccess(true);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.VideoViewerLandActivity$8, reason: invalid class name */
    class AnonymousClass8 implements OnResultListener<Boolean> {
        @Override // com.ipotensic.baselib.okhttp.OnResultListener
        public void onFailed(Exception exc) {
        }

        AnonymousClass8() {
        }

        @Override // com.ipotensic.baselib.okhttp.OnResultListener
        public void onSuccess(Boolean bool) {
            if (bool.booleanValue()) {
                VideoViewerLandActivity.this.hasDelete = true;
                if (!(VideoViewerLandActivity.this.data instanceof LocalFile)) {
                    if (VideoViewerLandActivity.this.data instanceof RemoteFile) {
                        VideoViewerLandActivity.this.dataList.remove(VideoViewerLandActivity.this.position);
                        if (VideoViewerLandActivity.this.dataList.size() <= 0) {
                            VideoViewerLandActivity.this.finishActivity();
                            return;
                        }
                        VideoViewerLandActivity.access$910(VideoViewerLandActivity.this);
                        if (VideoViewerLandActivity.this.position < 0) {
                            VideoViewerLandActivity.this.position = 0;
                        }
                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.8.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ToastUtil.showImageTop(VideoViewerLandActivity.this, VideoViewerLandActivity.this.getString(R.string.toast_delete_success), R.mipmap.icon_toast_successful);
                                VideoLoopManager.get().init(VideoViewerLandActivity.this, VideoViewerLandActivity.this.viewPager, VideoViewerLandActivity.this.dataList, VideoViewerLandActivity.this.position, VideoViewerLandActivity.this.pagerChangeListener);
                                VideoViewerLandActivity.this.dismissLoadingDialog();
                            }
                        });
                        return;
                    }
                    return;
                }
                VideoViewerLandActivity.this.showLoadingDialog();
                PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (true) {
                            if (i >= LocalFileManager.getInstance().getVideoListNoHead().size()) {
                                break;
                            }
                            if (LocalFileManager.getInstance().getVideoListNoHead().get(i).getAbsPath().equals(((LocalFile) VideoViewerLandActivity.this.data).getAbsPath())) {
                                LocalFileManager.getInstance().getVideoListNoHead().remove(i);
                                break;
                            }
                            i++;
                        }
                        VideoViewerLandActivity.this.dataList = LocalFileManager.getInstance().getVideoListNoHead();
                        if (VideoViewerLandActivity.this.dataList.size() <= 0) {
                            VideoViewerLandActivity.this.finishActivity();
                            return;
                        }
                        VideoViewerLandActivity.access$910(VideoViewerLandActivity.this);
                        if (VideoViewerLandActivity.this.position < 0) {
                            VideoViewerLandActivity.this.position = 0;
                        }
                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ToastUtil.showImageTop(VideoViewerLandActivity.this, VideoViewerLandActivity.this.getString(R.string.toast_delete_success), R.mipmap.icon_toast_successful);
                                VideoLoopManager.get().init(VideoViewerLandActivity.this, VideoViewerLandActivity.this.viewPager, VideoViewerLandActivity.this.dataList, VideoViewerLandActivity.this.position, VideoViewerLandActivity.this.pagerChangeListener);
                                VideoViewerLandActivity.this.dismissLoadingDialog();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        AnonymousClass8 anonymousClass8 = new AnonymousClass8();
        Serializable serializable = this.data;
        if (serializable instanceof LocalFile) {
            VideoPlayerUtils.deleteLocalFile(this, (LocalFile) serializable, anonymousClass8);
        } else if (serializable instanceof RemoteFile) {
            if (((RemoteFile) serializable).isFromUsb()) {
                VideoPlayerUtils.deleteUsbRemoteFile(this, (RemoteFile) this.data, this.position, anonymousClass8);
            } else {
                VideoPlayerUtils.deleteRemoteFile(this, (RemoteFile) this.data, this.position, anonymousClass8);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.VideoViewerLandActivity$9, reason: invalid class name */
    class AnonymousClass9 implements PermissionUtil.OnPermissionListener {
        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass9() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            if (VideoViewerLandActivity.this.data instanceof LocalFile) {
                VideoPlayerUtils.share(VideoViewerLandActivity.this, new File(((LocalFile) VideoViewerLandActivity.this.data).getAbsPath()));
                return;
            }
            if (VideoViewerLandActivity.this.data instanceof RemoteFile) {
                if (((RemoteFile) VideoViewerLandActivity.this.data).isDownloaded()) {
                    if (((RemoteFile) VideoViewerLandActivity.this.data).isFromUsb()) {
                        VideoPlayerUtils.share(VideoViewerLandActivity.this, new File(((RemoteFile) VideoViewerLandActivity.this.data).getUsbLrvPath()));
                        return;
                    } else {
                        VideoPlayerUtils.share(VideoViewerLandActivity.this, new File(LocalFileManager.getInstance().getMediaDir(), ((RemoteFile) VideoViewerLandActivity.this.data).getFileName()));
                        return;
                    }
                }
                VideoViewerLandActivity.this.download(new OnResultListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.9.1
                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onFailed(Exception exc) {
                    }

                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onSuccess(Object obj) {
                        PermissionUtil.requestStoragePermissionInShareWithDialog(VideoViewerLandActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.9.1.1
                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onDenied() {
                            }

                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onDeniedWithNeverAsk(String... strArr) {
                            }

                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onGrant() {
                                File file;
                                if (((RemoteFile) VideoViewerLandActivity.this.data).isFromUsb()) {
                                    file = new File(((RemoteFile) VideoViewerLandActivity.this.data).getUsbLrvPath());
                                } else {
                                    file = new File(LocalFileManager.getInstance().getMediaDir(), ((RemoteFile) VideoViewerLandActivity.this.data).getLrvFileName());
                                }
                                VideoPlayerUtils.share(VideoViewerLandActivity.this, file);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void share() {
        PermissionUtil.requestStoragePermissionInShareWithDialog(this, new AnonymousClass9());
    }

    /* renamed from: com.ipotensic.kernel.activitys.VideoViewerLandActivity$16, reason: invalid class name */
    static /* synthetic */ class AnonymousClass16 {
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
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_INSERT_TIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        int i = AnonymousClass16.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (this.isLocalVideo || ((Boolean) event.obj).booleanValue()) {
                return;
            }
            finishActivity();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            ToastUtil.toast(this, getString(R.string.sd_insertion));
        } else {
            if (this.isLocalVideo) {
                return;
            }
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
                this.handler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.10
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoViewerLandActivity.this.finishActivity();
                    }
                }, 2500L);
            } catch (Exception unused) {
            }
        }
    }

    protected void initData() {
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
                    this.path = this.path.substring(0, r0.length() - 3) + "LRV";
                }
            }
            if (!((RemoteFile) this.data).isFromUsb()) {
                UsbGalleryManager.getInstance().getFileDetail((RemoteFile) this.data, this.callback);
                CameraCtrlPresenter.getInstance().getMediaInfo(((RemoteFile) this.data).getRemotePath(), this.callback);
            }
        }
        DDLog.i("video play path:" + this.path);
        Serializable serializable2 = this.data;
        if (!(serializable2 instanceof LocalFile) && ((RemoteFile) serializable2).isFromUsb()) {
            UsbGalleryManager.getInstance().getFileDetail((RemoteFile) this.data, this.callback);
            if (((RemoteFile) this.data).isDownloaded() || ((RemoteFile) this.data).isDownloaded()) {
                setFileDownloaded((RemoteFile) this.data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toPlay(Serializable serializable) {
        Intent intent = new Intent(this, (Class<?>) VideoDisplayActivity.class);
        intent.putExtra("data", serializable);
        intent.putExtra("position", this.position);
        intent.putExtra("isLocalVideo", serializable instanceof LocalFile);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_in_bottom_gallery, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileDownloaded(RemoteFile remoteFile) {
        this.btnDownload.setImageResource(remoteFile.isDownloaded() ? R.mipmap.img_mark_already_downloaded : R.mipmap.icon_btn_download);
        remoteFile.setDownloaded(remoteFile.isDownloaded());
        if (remoteFile.isDownloaded()) {
            this.tvShowTips.setVisibility(0);
            this.tvShowTips.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.13
                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    VideoViewerLandActivity.this.tvTips.setVisibility(0);
                    VideoViewerLandActivity.this.handler.removeCallbacks(VideoViewerLandActivity.this.tipsDismissRunnable);
                    VideoViewerLandActivity.this.handler.postDelayed(VideoViewerLandActivity.this.tipsDismissRunnable, 3000L);
                }
            });
        } else {
            this.tvShowTips.setVisibility(8);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("position", this.position);
        intent.putExtra("hasDelete", this.hasDelete);
        setResult(-1, intent);
        finish();
        if (this.data instanceof RemoteFile) {
            overridePendingTransition(0, R.anim.trans_out_bottom_gallery);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.VideoViewerLandActivity.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Glide.get(VideoViewerLandActivity.this).clearDiskCache();
                } catch (Exception unused) {
                }
            }
        });
        try {
            Glide.get(this).clearMemory();
        } catch (Exception unused) {
        }
        VideoLoopManager.get().release();
        super.onDestroy();
    }
}
