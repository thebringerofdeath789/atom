package com.ipotensic.kernel.activitys;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.MyGridLayoutManager;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.MediaStoreUtil;
import com.ipotensic.kernel.view.DownloadFileDialog;
import com.ipotensic.kernel.view.NoShakeListener;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.OnResponseListener;
import com.logan.camera.RemoteFile;
import com.logan.camera.RemoteFileManager;
import com.logan.camera.data.BaseData;
import com.logan.usb.AOAEngine;
import com.logan.usb.gallery.OnFileDownloadListener;
import com.logan.usb.gallery.UsbGalleryManager;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class GalleryActivity extends BaseActivity implements EventDispatcher.OnEventListener {
    private BaseAdapter adapter;
    private ImageButton btnDelete;
    private ImageButton btnDownload;
    private ImageView btnReturn;
    private DownloadFileDialog downloadDialog;
    private ImageView imgNone;
    private ConstraintLayout layoutBottom;
    private ConstraintLayout layoutGalleryMain;
    private MyGridLayoutManager layoutManager;
    private View linePhotosTabBottom;
    private View lineVideosTabBottom;
    private List<RemoteFile> list;
    private RecyclerView recyclerView;
    private TextView tvPhotos;
    private TextView tvSelect;
    private TextView tvVideos;
    private final int LOADING_TIMEOUT = 20000;
    private volatile boolean isDownloadCanceled = false;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    public final int REQUEST_CODE_REFRESH_DATA = 100;
    private boolean deleteSuccess = false;
    private boolean isFirstLoadFinish = false;
    private List<RemoteFile> selectList = new ArrayList();
    private MediaType curType = MediaType.TYPE_VIDEOS;
    private boolean isSelectMode = false;
    private OnItemClickListener itemClickListener = new NoShakeListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.10
        @Override // com.ipotensic.kernel.view.NoShakeListener
        public void onSingleClick(int i) {
            if (i >= GalleryActivity.this.list.size()) {
                return;
            }
            if (GalleryActivity.this.curType == MediaType.TYPE_VIDEOS) {
                if (((RemoteFile) GalleryActivity.this.list.get(i)).isFromUsb()) {
                    Intent intent = new Intent(GalleryActivity.this, (Class<?>) VideoViewerLandActivity.class);
                    intent.putExtra("data", (ArrayList) GalleryActivity.this.list);
                    intent.putExtra("position", i);
                    intent.putExtra("isLocalVideo", false);
                    GalleryActivity.this.startActivityForResult(intent, 100);
                    GalleryActivity.this.overridePendingTransition(R.anim.trans_in_bottom_gallery, 0);
                    return;
                }
                Intent intent2 = new Intent(GalleryActivity.this, (Class<?>) VideoViewerLandActivity.class);
                intent2.putExtra("data", (ArrayList) GalleryActivity.this.list);
                intent2.putExtra("position", i);
                intent2.putExtra("isLocalVideo", false);
                GalleryActivity.this.startActivityForResult(intent2, 100);
                GalleryActivity.this.overridePendingTransition(R.anim.trans_in_bottom_gallery, 0);
                return;
            }
            Intent intent3 = new Intent(GalleryActivity.this, (Class<?>) PhotoViewerLandActivity.class);
            intent3.putExtra("data", (Serializable) GalleryActivity.this.list.get(i));
            intent3.putExtra("position", i);
            GalleryActivity.this.startActivityForResult(intent3, 100);
            GalleryActivity.this.overridePendingTransition(R.anim.trans_in_bottom_gallery, 0);
        }
    };
    private ArrayList<RemoteFile> localFiles = new ArrayList<>();
    private DialogInterface.OnDismissListener loadingDialogListener = new DialogInterface.OnDismissListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.19
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (GalleryActivity.this.deleteSuccess) {
                GalleryActivity galleryActivity = GalleryActivity.this;
                ToastUtil.showImageTop(galleryActivity, galleryActivity.getResources().getString(R.string.toast_delete_success), R.mipmap.icon_toast_successful);
                GalleryActivity.this.deleteSuccess = false;
            }
        }
    };
    private final Runnable loadTimeoutRunnable = new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.22
        @Override // java.lang.Runnable
        public void run() {
            try {
                GalleryActivity.this.dismissLoadingDialog();
                GalleryActivity galleryActivity = GalleryActivity.this;
                ToastUtil.toast(galleryActivity, galleryActivity.getString(R.string.txt_load_gallery_failed));
            } catch (Exception unused) {
            }
        }
    };

    private enum MediaType {
        TYPE_VIDEOS,
        TYPE_PHOTOS
    }

    public interface OnItemClickListener {
        void onItemClicked(int i);
    }

    @Override // com.ipotensic.baselib.base.BaseActivity
    public boolean isNewFullScreenPage() {
        return true;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_layout_gallery);
        initView();
        requestData();
        EventDispatcher.get().registerEvent(getLifecycle(), this);
    }

    private void initView() {
        this.layoutBottom = (ConstraintLayout) findViewById(R.id.layout_bottom);
        this.lineVideosTabBottom = findViewById(R.id.line_videos_tab_bottom);
        this.linePhotosTabBottom = findViewById(R.id.line_photos_tab_bottom);
        this.imgNone = (ImageView) findViewById(R.id.img_none);
        this.layoutGalleryMain = (ConstraintLayout) findViewById(R.id.layout_gallery_main);
        ImageView imageView = (ImageView) findViewById(R.id.btn_return);
        this.btnReturn = imageView;
        imageView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                GalleryActivity.this.finishActivity();
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_select);
        this.tvSelect = textView;
        textView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                GalleryActivity.this.isSelectMode = !r2.isSelectMode;
                GalleryActivity galleryActivity = GalleryActivity.this;
                galleryActivity.setSelectUI(galleryActivity.isSelectMode);
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_download);
        this.btnDownload = imageButton;
        imageButton.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PermissionUtil.requestStoragePermissionInDownloadWithDialog(GalleryActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.3.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        if (GalleryActivity.this.isSelectMode) {
                            if (UsbConfig.isUsbConnected) {
                                GalleryActivity.this.downloadFromUsb();
                            } else {
                                GalleryActivity.this.download();
                            }
                        }
                    }
                });
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.btn_delete);
        this.btnDelete = imageButton2;
        imageButton2.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (GalleryActivity.this.isSelectMode) {
                    GalleryActivity.this.delete();
                }
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.tv_videos);
        this.tvVideos = textView2;
        textView2.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.5
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                GalleryActivity.this.setIndicatorUI(MediaType.TYPE_VIDEOS);
            }
        });
        TextView textView3 = (TextView) findViewById(R.id.tv_photos);
        this.tvPhotos = textView3;
        textView3.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.6
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                GalleryActivity.this.setIndicatorUI(MediaType.TYPE_PHOTOS);
            }
        });
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        MyGridLayoutManager myGridLayoutManager = new MyGridLayoutManager(this, 6);
        this.layoutManager = myGridLayoutManager;
        this.recyclerView.setLayoutManager(myGridLayoutManager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                DDLog.e("visible item downlad 1");
                if (i != 0 || GalleryActivity.this.adapter == null) {
                    return;
                }
                try {
                    GalleryActivity.this.adapter.downloadThumbnail();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (GalleryActivity.this.isFirstLoadFinish) {
                    return;
                }
                GalleryActivity.this.isFirstLoadFinish = true;
                if (GalleryActivity.this.adapter != null) {
                    DDLog.e("visible item downlad 3");
                    try {
                        GalleryActivity.this.adapter.downloadThumbnail();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        this.recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.8
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                DDLog.e("visible item downlad 4");
                if (GalleryActivity.this.isFirstLoadFinish) {
                    return;
                }
                GalleryActivity.this.isFirstLoadFinish = true;
                if (GalleryActivity.this.adapter != null) {
                    DDLog.e("visible item downlad 3");
                    try {
                        GalleryActivity.this.adapter.downloadThumbnail();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getVisibleItems() {
        int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
            return null;
        }
        return new int[]{findFirstVisibleItemPosition, findLastVisibleItemPosition + 1};
    }

    private void requestData() {
        DDLog.e("\u56fe\u5e93 request data");
        showLoadingDialog();
        this.loadingDialog.setCanceledOnTouchOutside(false);
        this.mainHandler.removeCallbacks(this.loadTimeoutRunnable);
        this.mainHandler.postDelayed(this.loadTimeoutRunnable, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        RemoteFileManager.getInstance().getFileList(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.9
            @Override // com.logan.camera.OnResponseListener
            public void onRequestSuccess(int i, BaseData baseData) {
                GalleryActivity.this.mainHandler.removeCallbacks(GalleryActivity.this.loadTimeoutRunnable);
                GalleryActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i2 = 0; i2 < RemoteFileManager.getInstance().getPhotoList().size(); i2++) {
                            DDLog.e("\u56fe\u5e93 photo file:" + RemoteFileManager.getInstance().getPhotoList().get(i2).toString());
                        }
                        for (int i3 = 0; i3 < RemoteFileManager.getInstance().getVideoList().size(); i3++) {
                            DDLog.e("\u56fe\u5e93 video file:" + RemoteFileManager.getInstance().getVideoList().get(i3).toString());
                        }
                        GalleryActivity.this.dismissLoadingDialog();
                        GalleryActivity.this.refreshList();
                    }
                });
            }

            @Override // com.logan.camera.OnResponseListener
            public void onRequestFailed(int i, Exception exc) {
                GalleryActivity.this.dismissLoadingDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshList() {
        BaseAdapter baseAdapter = new BaseAdapter();
        this.adapter = baseAdapter;
        baseAdapter.setOnItemClickListener(this.itemClickListener);
        this.recyclerView.setAdapter(this.adapter);
        DDLog.e("visible item refresh 1");
        this.adapter.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNone() {
        List<RemoteFile> list = this.list;
        if (list == null || list.size() == 0) {
            this.imgNone.setVisibility(0);
            if (this.curType == MediaType.TYPE_VIDEOS) {
                this.imgNone.setImageResource(R.mipmap.img_none_remote_video);
            } else {
                this.imgNone.setImageResource(R.mipmap.img_none_remote_pic);
            }
            this.tvSelect.setTextColor(getResources().getColor(R.color.colorWhite));
            this.tvSelect.setText(getResources().getString(R.string.main_media_select));
            this.tvSelect.setEnabled(false);
            this.tvSelect.setClickable(false);
            return;
        }
        this.imgNone.setVisibility(8);
        this.tvSelect.setEnabled(true);
        this.tvSelect.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAllDelete() {
        List<RemoteFile> list = this.list;
        if (list == null || list.size() == 0) {
            setSelectUI(false);
            this.isSelectMode = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        setResult(-1, new Intent());
        this.isDownloadCanceled = true;
        finish();
        overridePendingTransition(0, R.anim.trans_out_bottom_gallery);
        UsbGalleryManager.getInstance().setQuitGalleryFlag();
        if (!PhoneConfig.isConnectFlightWifi()) {
            RemoteFileManager.getInstance().cancelDownload(new OnResponseListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.11
                @Override // com.logan.camera.OnResponseListener
                public void onRequestFailed(int i, Exception exc) {
                }

                @Override // com.logan.camera.OnResponseListener
                public void onRequestSuccess(int i, Object obj) {
                }
            });
        }
        if (UsbConfig.isUsbConnected) {
            UsbGalleryManager.getInstance().quitGallery(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.12
                @Override // com.logan.camera.OnResponseListener
                public void onRequestFailed(int i, Exception exc) {
                }

                @Override // com.logan.camera.OnResponseListener
                public void onRequestSuccess(int i, BaseData baseData) {
                    PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Thread.sleep(100L);
                                AOAEngine.getInstance().resetCameraBuffer();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorUI(MediaType mediaType) {
        if (this.curType == mediaType) {
            return;
        }
        this.tvVideos.setTextColor(getResources().getColor(mediaType == MediaType.TYPE_VIDEOS ? R.color.colorWhite : R.color.color_gallery_top_title));
        this.tvPhotos.setTextColor(getResources().getColor(mediaType == MediaType.TYPE_PHOTOS ? R.color.colorWhite : R.color.color_gallery_top_title));
        this.curType = mediaType;
        if (mediaType == MediaType.TYPE_VIDEOS) {
            this.imgNone.setImageResource(R.mipmap.img_none_remote_video);
            this.lineVideosTabBottom.setVisibility(0);
            this.linePhotosTabBottom.setVisibility(8);
        } else {
            this.imgNone.setImageResource(R.mipmap.img_none_remote_pic);
            this.lineVideosTabBottom.setVisibility(8);
            this.linePhotosTabBottom.setVisibility(0);
        }
        if (this.isSelectMode) {
            this.isSelectMode = false;
            setSelectUI(false);
        }
        BaseAdapter baseAdapter = this.adapter;
        if (baseAdapter != null) {
            baseAdapter.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectUI(boolean z) {
        BaseAdapter baseAdapter;
        this.tvSelect.setText(getString(z ? R.string.dialog_cancel : R.string.main_media_select));
        this.btnDelete.setImageResource(R.mipmap.icon_btn_media_delete_disable);
        this.btnDownload.setImageResource(R.mipmap.icon_btn_download_disable);
        if (z) {
            AnimationUtil.transInBottom(this.layoutBottom);
        } else {
            AnimationUtil.transOutBottom(this.layoutBottom);
        }
        if (z || (baseAdapter = this.adapter) == null) {
            return;
        }
        baseAdapter.cancelSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download() {
        List<RemoteFile> list = this.list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.localFiles.clear();
        checkDownloaded();
        final int size = this.list.size();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (this.list.get(i3).isSelected()) {
                i++;
                if (this.list.get(i3).isDownloaded()) {
                    i2++;
                }
            }
        }
        if (i == i2 && i != 0) {
            ToastUtil.toast(this, getString(i2 == 1 ? R.string.dialog_file_is_downloaded : R.string.dialog_files_are_downloaded));
            return;
        }
        this.isDownloadCanceled = false;
        if (i > 0) {
            DownloadFileDialog downloadFileDialog = new DownloadFileDialog(this, i - i2, new DownloadFileDialog.CancelListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.13
                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onCancelClicked() {
                    GalleryActivity.this.showLoadingDialog();
                    RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.13.1
                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestSuccess(int i4, BaseData baseData) {
                            GalleryActivity.this.isDownloadCanceled = true;
                            GalleryActivity.this.dismissLoadingDialog();
                        }

                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestFailed(int i4, Exception exc) {
                            GalleryActivity.this.dismissLoadingDialog();
                        }
                    });
                    GalleryActivity.this.hasDownloadedRefresh();
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onDownloadFinished() {
                    GalleryActivity.this.checkDownloaded();
                    GalleryActivity.this.downloadFinished();
                    GalleryActivity.this.hasDownloadedRefresh();
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onDownloadError(String str) {
                    GalleryActivity.this.checkDownloaded();
                    GalleryActivity.this.hasDownloadedRefresh();
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void noEnoughMemory() {
                    GalleryActivity.this.showLoadingDialog();
                    RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.13.2
                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestSuccess(int i4, BaseData baseData) {
                            GalleryActivity.this.dismissLoadingDialog();
                        }

                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestFailed(int i4, Exception exc) {
                            GalleryActivity.this.dismissLoadingDialog();
                        }
                    });
                    GalleryActivity.this.hasDownloadedRefresh();
                }
            });
            this.downloadDialog = downloadFileDialog;
            downloadFileDialog.show();
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    for (int i4 = 0; i4 < size && !GalleryActivity.this.isDownloadCanceled; i4++) {
                        try {
                            RemoteFile remoteFile = (RemoteFile) GalleryActivity.this.list.get(i4);
                            if (remoteFile.isSelected() && !remoteFile.isDownloaded()) {
                                RemoteFileManager.getInstance().download(remoteFile, LocalFileManager.getInstance().getMediaDir(), new DownloadListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.14.1
                                    @Override // com.ipotensic.baselib.okhttp.DownloadListener
                                    public void onDownloadStart() {
                                        GalleryActivity.this.downloadDialog.getDownloadListener().onDownloadStart();
                                    }

                                    @Override // com.ipotensic.baselib.okhttp.DownloadListener
                                    public void onDownloadProgress(float f, long j) {
                                        GalleryActivity.this.downloadDialog.getDownloadListener().onDownloadProgress(f, j);
                                    }

                                    @Override // com.ipotensic.baselib.okhttp.DownloadListener
                                    public void onDownloadEnd(String str) {
                                        GalleryActivity.this.downloadDialog.getDownloadListener().onDownloadEnd(str);
                                    }

                                    @Override // com.ipotensic.baselib.okhttp.DownloadListener
                                    public void onDownloadEnd(String str, String str2) {
                                        GalleryActivity.this.downloadDialog.getDownloadListener().onDownloadEnd(str, str2);
                                    }

                                    @Override // com.ipotensic.baselib.okhttp.DownloadListener
                                    public void onDownloadError(Exception exc) {
                                        GalleryActivity.this.downloadDialog.getDownloadListener().onDownloadError(exc);
                                    }

                                    @Override // com.ipotensic.baselib.okhttp.DownloadListener
                                    public void notEnoughSpace() {
                                        GalleryActivity.this.downloadDialog.getDownloadListener().notEnoughSpace();
                                    }
                                });
                                GalleryActivity.this.localFiles.add(remoteFile);
                            }
                        } catch (Exception e) {
                            DDLog.e("\u4e0b\u8f7d\u6587\u4ef6\u51fa\u9519\uff1a" + e.getMessage());
                            return;
                        }
                    }
                    GalleryActivity.this.isDownloadCanceled = false;
                    DDLog.e("\u56fe\u5e93\u4e0b\u8f7d\u7ed3\u675f1");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFromUsb() {
        List<RemoteFile> list = this.list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.localFiles.clear();
        int size = this.list.size();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (this.list.get(i3).isSelected()) {
                i++;
                if (this.list.get(i3).isDownloaded()) {
                    i2++;
                } else {
                    this.localFiles.add(this.list.get(i3));
                }
            }
        }
        if (i <= 0) {
            return;
        }
        checkDownloaded();
        if (i == i2 && i != 0) {
            ToastUtil.toast(this, getString(i2 == 1 ? R.string.dialog_file_is_downloaded : R.string.dialog_files_are_downloaded));
            return;
        }
        this.isDownloadCanceled = false;
        if (i > 0) {
            DownloadFileDialog downloadFileDialog = new DownloadFileDialog(this, i - i2, new DownloadFileDialog.CancelListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.15
                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onCancelClicked() {
                    GalleryActivity.this.showLoadingDialog();
                    RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.15.1
                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestSuccess(int i4, BaseData baseData) {
                            GalleryActivity.this.isDownloadCanceled = true;
                            DDLog.e("\u56fe\u5e93notify");
                            GalleryActivity.this.dismissLoadingDialog();
                        }

                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestFailed(int i4, Exception exc) {
                            GalleryActivity.this.dismissLoadingDialog();
                        }
                    });
                    GalleryActivity.this.hasDownloadedRefresh();
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onDownloadFinished() {
                    GalleryActivity.this.checkDownloaded();
                    GalleryActivity.this.downloadFinished();
                    GalleryActivity.this.hasDownloadedRefresh();
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onDownloadError(String str) {
                    GalleryActivity.this.checkDownloaded();
                    GalleryActivity.this.hasDownloadedRefresh();
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void noEnoughMemory() {
                    GalleryActivity.this.showLoadingDialog();
                    RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.15.2
                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestSuccess(int i4, BaseData baseData) {
                            GalleryActivity.this.dismissLoadingDialog();
                        }

                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestFailed(int i4, Exception exc) {
                            GalleryActivity.this.dismissLoadingDialog();
                        }
                    });
                    GalleryActivity.this.hasDownloadedRefresh();
                }
            });
            this.downloadDialog = downloadFileDialog;
            downloadFileDialog.show();
            try {
                RemoteFileManager.getInstance().downloadMultiFileForUsb(this.localFiles, this.downloadDialog.getDownloadListener(), new OnFileDownloadListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.16
                    @Override // com.logan.usb.gallery.OnFileDownloadListener
                    public void onItemDownloaded(int i4) {
                    }

                    @Override // com.logan.usb.gallery.OnFileDownloadListener
                    public void onRequestFailed() {
                        GalleryActivity.this.isDownloadCanceled = false;
                        DDLog.e("\u56fe\u5e93\u4e0b\u8f7d\u7ed3\u675f2");
                    }

                    @Override // com.logan.usb.gallery.OnFileDownloadListener
                    public void onAllDone() {
                        GalleryActivity.this.isDownloadCanceled = false;
                        DDLog.e("\u56fe\u5e93\u4e0b\u8f7d\u7ed3\u675f3");
                    }
                });
            } catch (Exception e) {
                DDLog.e("\u4e0b\u8f7d\u5931\u8d25:" + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFinished() {
        ArrayList<RemoteFile> arrayList = this.localFiles;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.17
            @Override // java.lang.Runnable
            public void run() {
                File file;
                for (int i = 0; i < GalleryActivity.this.localFiles.size(); i++) {
                    RemoteFile remoteFile = (RemoteFile) GalleryActivity.this.localFiles.get(i);
                    if (remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_PHOTO) {
                        if (remoteFile.isFromUsb()) {
                            file = new File(remoteFile.getUsbPhotoPath());
                        } else {
                            file = new File(LocalFileManager.getInstance().getMediaDir(), remoteFile.getFileName());
                        }
                    } else if (remoteFile.isFromUsb()) {
                        file = new File(remoteFile.getUsbLrvPath());
                    } else {
                        file = new File(LocalFileManager.getInstance().getMediaDir(), remoteFile.getFileName());
                    }
                    MediaStoreUtil.refreshAlbum(GalleryActivity.this, file);
                }
                GalleryActivity.this.localFiles.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        List<RemoteFile> list = this.list;
        if (list == null || list.size() <= 0 || !hasPicSelected()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (RemoteFile remoteFile : this.list) {
            if (remoteFile.isSelected()) {
                arrayList.add(remoteFile);
                atomicBoolean.set(remoteFile.isFromUsb());
            }
        }
        if (arrayList.size() > 0) {
            new GeneralDialog((Context) this, getString(R.string.dialog_delete_these_files), getString(R.string.dialog_delete_file_describe), (String) null, (String) null, false, 2, (GeneralDialog.ClickConfirmListener) new AnonymousClass18(atomicBoolean, arrayList)).show();
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.GalleryActivity$18, reason: invalid class name */
    class AnonymousClass18 implements GeneralDialog.ClickConfirmListener {
        final /* synthetic */ AtomicBoolean val$isUsb;
        final /* synthetic */ List val$needDeleteFiles;

        AnonymousClass18(AtomicBoolean atomicBoolean, List list) {
            this.val$isUsb = atomicBoolean;
            this.val$needDeleteFiles = list;
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            GalleryActivity.this.showLoadingDialog();
            GalleryActivity.this.loadingDialog.setOnDismissListener(GalleryActivity.this.loadingDialogListener);
            if (this.val$isUsb.get()) {
                RemoteFileManager.getInstance().deleteUsbFiles(this.val$needDeleteFiles, new OnResponseListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.18.1
                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestFailed(int i, Exception exc) {
                    }

                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestSuccess(int i, Object obj) {
                        DDLog.e("\u5220\u9664\u6210\u529f \u5f00\u59cb\u79fb\u9664\u8fdc\u7aef\u6587\u4ef6");
                        Iterator it = GalleryActivity.this.list.iterator();
                        while (it.hasNext()) {
                            RemoteFile remoteFile = (RemoteFile) it.next();
                            Iterator it2 = AnonymousClass18.this.val$needDeleteFiles.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                if (((RemoteFile) it2.next()).getFileName().equals(remoteFile.getFileName())) {
                                    GalleryActivity.this.deleteSuccess = true;
                                    it.remove();
                                    break;
                                }
                            }
                        }
                        GalleryActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.18.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DDLog.e("\u5220\u9664\u6210\u529f \u5f00\u59cb\u5237\u65b0\u754c\u9762");
                                GalleryActivity.this.adapter.notifyDataSetChanged();
                                GalleryActivity.this.checkNone();
                                GalleryActivity.this.checkAllDelete();
                                GalleryActivity.this.adapter.clearSelectList();
                                GalleryActivity.this.dismissLoadingDialog();
                            }
                        });
                    }
                });
            } else {
                PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.18.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final Iterator it = GalleryActivity.this.list.iterator();
                            while (it.hasNext()) {
                                RemoteFile remoteFile = (RemoteFile) it.next();
                                if (remoteFile.isSelected()) {
                                    RemoteFileManager.getInstance().deleteFile(remoteFile, new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.18.2.1
                                        @Override // com.logan.camera.OnResponseListener
                                        public void onRequestFailed(int i, Exception exc) {
                                        }

                                        @Override // com.logan.camera.OnResponseListener
                                        public void onRequestSuccess(int i, BaseData baseData) {
                                            DDLog.e("\u5220\u9664\u6210\u529f");
                                            try {
                                                it.remove();
                                                GalleryActivity.this.deleteSuccess = true;
                                            } catch (Exception unused) {
                                            }
                                        }
                                    });
                                }
                            }
                            GalleryActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.18.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    GalleryActivity.this.adapter.notifyDataSetChanged();
                                    GalleryActivity.this.checkNone();
                                    GalleryActivity.this.checkAllDelete();
                                    GalleryActivity.this.adapter.clearSelectList();
                                    GalleryActivity.this.dismissLoadingDialog();
                                }
                            });
                        } catch (Exception e) {
                            DDLog.i("\u5220\u9664\u9519\u8bef:" + e.getMessage());
                            GalleryActivity.this.deleteSuccess = false;
                            GalleryActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.18.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    GalleryActivity.this.dismissLoadingDialog();
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDownloaded() {
        if (this.curType == MediaType.TYPE_VIDEOS) {
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).isFromUsb()) {
                    try {
                        this.list.get(i).setDownloaded(this.list.get(i).isDelete());
                    } catch (Exception unused) {
                    }
                } else {
                    this.list.get(i).setDownloaded(new File(LocalFileManager.getInstance().getMediaDir(), this.list.get(i).getFileName()).exists());
                }
            }
        } else {
            for (int i2 = 0; i2 < this.list.size(); i2++) {
                if (this.list.get(i2).isFromUsb()) {
                    this.list.get(i2).setDownloaded(this.list.get(i2).isDownloaded());
                } else {
                    this.list.get(i2).setDownloaded(new File(LocalFileManager.getInstance().getMediaDir(), this.list.get(i2).getFileName()).exists());
                }
            }
        }
        BaseAdapter baseAdapter = this.adapter;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
        if (this.list != null) {
            for (int i3 = 0; i3 < this.list.size(); i3++) {
                DDLog.e("checkdownload:" + this.list.get(i3).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hasDownloadedRefresh() {
        BaseAdapter baseAdapter = this.adapter;
        if (baseAdapter != null) {
            baseAdapter.cancelSelected();
        }
    }

    private boolean hasPicSelected() {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    protected class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
        private OnItemClickListener listener;

        protected BaseAdapter() {
        }

        public void refresh() {
            DDLog.e("visible item refresh");
            GalleryActivity.this.isFirstLoadFinish = false;
            refreshData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void downloadThumbnail() throws Exception {
            int[] visibleItems = GalleryActivity.this.getVisibleItems();
            if (visibleItems == null) {
                return;
            }
            DDLog.e("visible item :" + visibleItems[0] + "," + visibleItems[1]);
            if (UsbConfig.isUsbConnected) {
                if ((GalleryActivity.this.curType == MediaType.TYPE_VIDEOS && isNeedDownloadThumbnail(RemoteFileManager.getInstance().getVideoList(), visibleItems[0], visibleItems[1])) || (GalleryActivity.this.curType == MediaType.TYPE_PHOTOS && isNeedDownloadThumbnail(RemoteFileManager.getInstance().getPhotoList(), visibleItems[0], visibleItems[1]))) {
                    GalleryActivity.this.showLoadingDialog();
                    GalleryActivity.this.loadingDialog.setCanceledOnTouchOutside(false);
                    RemoteFileManager.getInstance().getUsbThumbnail(GalleryActivity.this.curType == MediaType.TYPE_VIDEOS ? FileTypeEnum.TYPE_VIDEO : FileTypeEnum.TYPE_PHOTO, GalleryActivity.this.curType == MediaType.TYPE_VIDEOS ? RemoteFileManager.getInstance().getVideoList() : RemoteFileManager.getInstance().getPhotoList(), visibleItems[0], visibleItems[1], new OnFileDownloadListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.BaseAdapter.1
                        @Override // com.logan.usb.gallery.OnFileDownloadListener
                        public void onItemDownloaded(final int i) {
                            GalleryActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.BaseAdapter.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (GalleryActivity.this.isFinishing()) {
                                        return;
                                    }
                                    BaseAdapter.this.notifyItemChanged(i);
                                }
                            });
                        }

                        @Override // com.logan.usb.gallery.OnFileDownloadListener
                        public void onRequestFailed() {
                            GalleryActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.BaseAdapter.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (GalleryActivity.this.isFinishing()) {
                                        return;
                                    }
                                    GalleryActivity.this.checkDownloaded();
                                    GalleryActivity.this.dismissLoadingDialog();
                                }
                            });
                        }

                        @Override // com.logan.usb.gallery.OnFileDownloadListener
                        public void onAllDone() {
                            GalleryActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.BaseAdapter.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (GalleryActivity.this.isFinishing()) {
                                        return;
                                    }
                                    GalleryActivity.this.checkDownloaded();
                                    GalleryActivity.this.dismissLoadingDialog();
                                }
                            });
                        }
                    });
                }
            }
        }

        private void refreshData() {
            GalleryActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.BaseAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (GalleryActivity.this.curType == MediaType.TYPE_VIDEOS) {
                        GalleryActivity.this.list = RemoteFileManager.getInstance().getVideoList();
                    } else {
                        GalleryActivity.this.list = RemoteFileManager.getInstance().getPhotoList();
                    }
                    GalleryActivity.this.checkDownloaded();
                    BaseAdapter.this.notifyDataSetChanged();
                    GalleryActivity.this.checkNone();
                }
            });
        }

        private boolean isNeedDownloadThumbnail(List<RemoteFile> list, int i, int i2) {
            if (list != null && list.size() != 0) {
                while (i < i2) {
                    if (list.get(i).getThumbnailUrl() == null) {
                        return true;
                    }
                    i++;
                }
            }
            return false;
        }

        public void cancelSelected() {
            int size = GalleryActivity.this.list.size();
            for (int i = 0; i < size; i++) {
                RemoteFile remoteFile = (RemoteFile) GalleryActivity.this.list.get(i);
                if (remoteFile.isSelected()) {
                    remoteFile.setSelected(false);
                    notifyItemChanged(i);
                }
            }
            clearSelectList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new BaseViewHolder(LayoutInflater.from(GalleryActivity.this).inflate(R.layout.view_remote_file_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(BaseViewHolder baseViewHolder, final int i) {
            if (i >= GalleryActivity.this.list.size()) {
                return;
            }
            final RemoteFile remoteFile = (RemoteFile) GalleryActivity.this.list.get(i);
            baseViewHolder.imgThumbnail.setScaleType(ImageView.ScaleType.CENTER_CROP);
            DDLog.e("\u663e\u793a\u7f29\u7565\u56fe:" + remoteFile.toString());
            if (remoteFile.isBroken()) {
                Glide.with((FragmentActivity) GalleryActivity.this).load(Integer.valueOf(R.mipmap.img_bg_thumbnail_broken_small)).error(R.mipmap.img_none_remote_pic).skipMemoryCache(true).centerCrop().diskCacheStrategy(DiskCacheStrategy.NONE).thumbnail(0.2f).into(baseViewHolder.imgThumbnail);
            } else if (remoteFile.getThumbnailUrl() == null) {
                baseViewHolder.imgThumbnail.setImageResource(R.mipmap.img_none_remote_pic);
            } else {
                Glide.with((FragmentActivity) GalleryActivity.this).load(remoteFile.getThumbnailUrl()).listener((RequestListener<? super String, GlideDrawable>) new RequestListener<String, GlideDrawable>() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.BaseAdapter.3
                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onResourceReady(GlideDrawable glideDrawable, String str, Target<GlideDrawable> target, boolean z, boolean z2) {
                        return false;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onException(Exception exc, String str, Target<GlideDrawable> target, boolean z) {
                        DDLog.e("\u52a0\u8f7d\u62a5\u9519 glide:" + remoteFile.getThumbnailUrl() + " ,  \u6570\u636e\u957f\u5ea6 :" + new File(remoteFile.getThumbnailUrl()).length());
                        return false;
                    }
                }).error(R.mipmap.img_none_remote_pic).skipMemoryCache(true).centerCrop().diskCacheStrategy(DiskCacheStrategy.NONE).thumbnail(0.2f).into(baseViewHolder.imgThumbnail);
            }
            baseViewHolder.videoIcon.setVisibility(GalleryActivity.this.curType == MediaType.TYPE_VIDEOS ? 0 : 8);
            baseViewHolder.selectIcon.setVisibility(remoteFile.isSelected() ? 0 : 4);
            baseViewHolder.imgThumbnail.setAlpha(remoteFile.isSelected() ? 0.5f : 1.0f);
            baseViewHolder.itemView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.BaseAdapter.4
                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    if (i >= GalleryActivity.this.list.size()) {
                        return;
                    }
                    if (GalleryActivity.this.isSelectMode) {
                        RemoteFile remoteFile2 = (RemoteFile) GalleryActivity.this.list.get(i);
                        remoteFile2.setSelected(!remoteFile2.isSelected());
                        BaseAdapter.this.notifyItemChanged(i);
                        BaseAdapter.this.refreshDeleteAndDownloadBtn(remoteFile2);
                        return;
                    }
                    if (BaseAdapter.this.listener != null) {
                        BaseAdapter.this.listener.onItemClicked(i);
                    }
                }
            });
            baseViewHolder.imgDownloaded.setVisibility(((RemoteFile) GalleryActivity.this.list.get(i)).isDownloaded() ? 0 : 8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (GalleryActivity.this.list == null) {
                return 0;
            }
            return GalleryActivity.this.list.size();
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.listener = onItemClickListener;
        }

        public void clearSelectList() {
            if (GalleryActivity.this.selectList != null) {
                GalleryActivity.this.selectList.clear();
                GalleryActivity.this.btnDelete.setImageResource(R.mipmap.icon_btn_media_delete_disable);
                GalleryActivity.this.btnDownload.setImageResource(R.mipmap.icon_btn_download_disable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void refreshDeleteAndDownloadBtn(RemoteFile remoteFile) {
            if (GalleryActivity.this.selectList != null) {
                if (remoteFile.isSelected()) {
                    GalleryActivity.this.selectList.add(remoteFile);
                } else {
                    GalleryActivity.this.selectList.remove(remoteFile);
                }
                if (GalleryActivity.this.selectList.size() > 0) {
                    GalleryActivity.this.btnDelete.setImageResource(R.mipmap.icon_btn_media_delete);
                    GalleryActivity.this.btnDownload.setImageResource(R.mipmap.img_mark_already_downloaded);
                    Iterator it = GalleryActivity.this.selectList.iterator();
                    while (it.hasNext()) {
                        if (!((RemoteFile) it.next()).isDownloaded()) {
                            GalleryActivity.this.btnDownload.setImageResource(R.mipmap.icon_btn_download);
                            return;
                        }
                    }
                    return;
                }
                GalleryActivity.this.btnDelete.setImageResource(R.mipmap.icon_btn_media_delete_disable);
                GalleryActivity.this.btnDownload.setImageResource(R.mipmap.icon_btn_download_disable);
            }
        }
    }

    private class BaseViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDownloaded;
        ImageView imgThumbnail;
        ImageView selectIcon;
        ImageView videoIcon;

        private BaseViewHolder(View view) {
            super(view);
            this.imgThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);
            this.selectIcon = (ImageView) view.findViewById(R.id.iv_select_icon);
            this.videoIcon = (ImageView) view.findViewById(R.id.iv_video_icon);
            this.imgDownloaded = (ImageView) view.findViewById(R.id.img_already_downloaded);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            refreshList();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.isDownloadCanceled = true;
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Glide.get(GalleryActivity.this).clearDiskCache();
                } catch (Exception e) {
                    DDLog.e("\u9000\u51fa GalleryActivity\u51fa\u9519:" + e.getMessage());
                }
            }
        });
        try {
            Glide.get(this).clearMemory();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finishActivity();
    }

    /* renamed from: com.ipotensic.kernel.activitys.GalleryActivity$23, reason: invalid class name */
    static /* synthetic */ class AnonymousClass23 {
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
        int i = AnonymousClass23.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (((Boolean) event.obj).booleanValue()) {
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
            return;
        }
        CameraConfig.get().setSdState(0);
        DownloadFileDialog downloadFileDialog = this.downloadDialog;
        if (downloadFileDialog != null && downloadFileDialog.isShowing()) {
            this.downloadDialog.dismiss();
        }
        if (this.loadingDialog != null && this.loadingDialog.isShowing()) {
            this.loadingDialog.dismiss();
        }
        ToastUtil.toast(this, getString(R.string.sd_pullout));
        this.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.activitys.GalleryActivity.21
            @Override // java.lang.Runnable
            public void run() {
                GalleryActivity.this.finishActivity();
            }
        }, 2500L);
    }
}