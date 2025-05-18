package com.ipotensic.kernel.activitys;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.utils.MediaStoreUtil;
import com.ipotensic.kernel.view.DownloadFileDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.dialog.MediaInfoDialog;
import com.ipotensic.kernel.view.photoview.PhotoView;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.OnResponseListener;
import com.logan.camera.RemoteFile;
import com.logan.camera.RemoteFileManager;
import com.logan.camera.data.BaseData;
import com.logan.camera.data.MediaInfoData;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.usb.gallery.UsbGalleryManager;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class PhotoViewerActivity extends BaseActivity implements EventDispatcher.OnEventListener {
    private ImageButton btnDownload;
    private ImageButton btnInfo;
    private ImageButton btnShare;
    private CyclePagerAdapter cycleAdapter;
    private DownloadFileDialog downloadDialog;
    private ImageView ivBroken;
    protected ConstraintLayout layoutBottom;
    protected ConstraintLayout layoutTop;
    private LooperViewPager mCycleViewPager;
    private TextView tvCurPageNum;
    private final String TAG = "图片加载";
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private int curIndex = 0;
    private boolean isNeedShare = false;
    private boolean isFirstLoaded = false;
    private boolean isDownloading = false;
    private boolean hasDelete = false;

    @Override // com.ipotensic.baselib.base.BaseActivity
    public boolean isNewFullScreenPage() {
        return true;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.curIndex = getIntent().getIntExtra("position", 0);
        DDLog.m1685e("图片加载", ":" + this.curIndex);
        setContentView(C1965R.layout.activity_photo_viewer);
        this.layoutTop = (ConstraintLayout) findViewById(C1965R.id.layout_top);
        this.layoutBottom = (ConstraintLayout) findViewById(C1965R.id.layout_bottom);
        this.tvCurPageNum = (TextView) findViewById(C1965R.id.tv_cur_page_num);
        this.btnDownload = (ImageButton) findViewById(C1965R.id.btn_download);
        this.ivBroken = (ImageView) findViewById(C1965R.id.iv_broken);
        findViewById(C1965R.id.btn_back).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PhotoViewerActivity.this.finishActivity();
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C1965R.id.btn_media_info);
        this.btnInfo = imageButton;
        imageButton.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PhotoViewerActivity.this.showMediaInfo();
            }
        });
        findViewById(C1965R.id.btn_download).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PermissionUtil.requestStoragePermissionInDownloadWithDialog(PhotoViewerActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.3.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        PhotoViewerActivity.this.download();
                    }
                });
            }
        });
        findViewById(C1965R.id.btn_delete).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PhotoViewerActivity.this.delete();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1965R.id.btn_media_share);
        this.btnShare = imageButton2;
        imageButton2.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.5
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PermissionUtil.requestStoragePermissionInShareWithDialog(PhotoViewerActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.5.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        PhotoViewerActivity.this.share();
                    }
                });
            }
        });
        this.mCycleViewPager = (LooperViewPager) findViewById(C1965R.id.loop_viewpager);
        refreshViewPager();
        EventDispatcher.get().registerEvent(getLifecycle(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshViewPager() {
        LooperViewPager looperViewPager = this.mCycleViewPager;
        CyclePagerAdapter cyclePagerAdapter = new CyclePagerAdapter(this);
        this.cycleAdapter = cyclePagerAdapter;
        looperViewPager.setAdapter(cyclePagerAdapter);
        this.mCycleViewPager.setCurrentItem(this.curIndex);
        this.mCycleViewPager.setCanTouch(RemoteFileManager.getInstance().getPhotoList().size() > 1);
        this.mCycleViewPager.setOnPageChangeListener(new LooperViewPager.OnPageChangeListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.6
            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                DDLog.m1685e("图片加载", "onPageScrolled:" + i);
                if (PhotoViewerActivity.this.isFirstLoaded) {
                    return;
                }
                PhotoViewerActivity.this.isFirstLoaded = true;
                PhotoViewerActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PhotoViewerActivity.this.loadImageForUsb();
                        } catch (Exception e) {
                            DDLog.m1685e("图片加载", "图片加载报错1:" + e.getMessage());
                        }
                    }
                });
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DDLog.m1685e("图片加载", "onPageSelected：" + i);
                PhotoViewerActivity.this.curIndex = i;
                PhotoViewerActivity.this.tvCurPageNum.setText((i + 1) + InternalZipConstants.ZIP_FILE_SEPARATOR + RemoteFileManager.getInstance().getPhotoList().size());
                if (UsbConfig.isUsbConnected) {
                    try {
                        if (PhotoViewerActivity.this.isFirstLoaded) {
                            PhotoViewerActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.6.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        PhotoViewerActivity.this.loadImageForUsb();
                                    } catch (Exception e) {
                                        DDLog.m1692w("图片加载", "图片加载错误2：" + e.getMessage());
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        DDLog.m1692w("图片加载", "图片加载报错:" + e.getMessage());
                    }
                }
            }
        });
        this.tvCurPageNum.setText((this.curIndex + 1) + InternalZipConstants.ZIP_FILE_SEPARATOR + RemoteFileManager.getInstance().getPhotoList().size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImageForUsb() throws Exception {
        if (UsbConfig.isUsbConnected && !this.isDownloading) {
            this.isDownloading = true;
            setFileDownloaded(false);
            RemoteFile remoteFile = RemoteFileManager.getInstance().getPhotoList().get(this.curIndex);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = -1;
            while (true) {
                if (i >= this.mCycleViewPager.getChildCount()) {
                    break;
                }
                PhotoView photoView = (PhotoView) this.mCycleViewPager.getChildAt(i);
                if (photoView.getMark() == this.curIndex) {
                    DDLog.m1685e("图片加载", "图片 j curIndex:" + this.curIndex);
                    arrayList.add(Integer.valueOf(i));
                    i2 = i;
                } else {
                    photoView.setImageDrawable(null);
                }
                i++;
            }
            DDLog.m1692w("图片加载", "图片 j:" + i2);
            if (i2 == -1) {
                this.isDownloading = false;
                return;
            }
            final PhotoView photoView2 = (PhotoView) this.mCycleViewPager.getChildAt(i2);
            final PhotoView photoView3 = arrayList.size() == 2 ? (PhotoView) this.mCycleViewPager.getChildAt(((Integer) arrayList.get(0)).intValue()) : null;
            DDLog.m1692w("图片加载", "图片 photoView:" + photoView2);
            if (remoteFile == null || photoView2 == null || !remoteFile.isFromUsb()) {
                this.isDownloading = false;
                return;
            }
            if (remoteFile.isBroken()) {
                setFileDownloaded(false);
                this.isDownloading = false;
                this.ivBroken.setVisibility(0);
                DDLog.m1692w("图片加载", "图片  破损图片 load image 0:" + remoteFile.getUsbPhotoPath());
                ViewUtils.setViewEnableWithAlpha(this.btnDownload, false);
                ViewUtils.setViewEnableWithAlpha(this.btnInfo, false);
                ViewUtils.setViewEnableWithAlpha(this.btnShare, false);
                return;
            }
            this.ivBroken.setVisibility(8);
            ViewUtils.setViewEnableWithAlpha(this.btnDownload, true);
            ViewUtils.setViewEnableWithAlpha(this.btnInfo, true);
            ViewUtils.setViewEnableWithAlpha(this.btnShare, true);
            if (remoteFile.isFromUsb()) {
                if (remoteFile.isDownloaded()) {
                    DDLog.m1692w("图片加载", "图片 load image 0:" + remoteFile.getUsbPhotoPath());
                    showPhoto(remoteFile.getUsbPhotoPath(), photoView2);
                    showPhoto(remoteFile.getUsbPhotoPath(), photoView3);
                    setFileDownloaded(true);
                    this.isDownloading = false;
                    return;
                }
            } else if (remoteFile.getLocalPath() != null) {
                DDLog.m1692w("图片加载", "图片 load image 1:" + remoteFile.getLocalPath());
                showPhoto(remoteFile.getLocalPath(), photoView2);
                showPhoto(remoteFile.getLocalPath(), photoView3);
                setFileDownloaded(true);
                this.isDownloading = false;
                return;
            }
            showLoadingDialog();
            this.loadingDialog.setCanceledOnTouchOutside(false);
            DDLog.m1685e("图片加载", "图片下载:" + remoteFile.toString());
            RemoteFileManager.getInstance().download(remoteFile, LocalFileManager.getInstance().getMediaDir(), new DownloadListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.7
                @Override // com.ipotensic.baselib.okhttp.DownloadListener
                public void onDownloadProgress(float f, long j) {
                }

                @Override // com.ipotensic.baselib.okhttp.DownloadListener
                public void onDownloadStart() {
                }

                @Override // com.ipotensic.baselib.okhttp.DownloadListener
                public void onDownloadEnd(final String str) {
                    PhotoViewerActivity.this.isDownloading = false;
                    PhotoViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DDLog.m1692w("图片加载", "图片下载成功：" + str);
                            if (PhotoViewerActivity.this.isFinishing()) {
                                return;
                            }
                            PhotoViewerActivity.this.dismissLoadingDialog();
                            PhotoViewerActivity.this.setFileDownloaded(true);
                            PhotoViewerActivity.this.showPhoto(str, photoView2);
                            PhotoViewerActivity.this.showPhoto(str, photoView3);
                            MediaStoreUtil.refreshAlbum(PhotoViewerActivity.this, new File(str));
                        }
                    });
                }

                @Override // com.ipotensic.baselib.okhttp.DownloadListener
                public void onDownloadEnd(final String str, String str2) {
                    PhotoViewerActivity.this.isDownloading = false;
                    PhotoViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PhotoViewerActivity.this.isFinishing()) {
                                return;
                            }
                            DDLog.m1692w("图片加载", "图片下载成功：" + str);
                            PhotoViewerActivity.this.dismissLoadingDialog();
                            PhotoViewerActivity.this.setFileDownloaded(true);
                            PhotoViewerActivity.this.showPhoto(str, photoView2);
                            PhotoViewerActivity.this.showPhoto(str, photoView3);
                            MediaStoreUtil.refreshAlbum(PhotoViewerActivity.this, new File(str));
                        }
                    });
                }

                @Override // com.ipotensic.baselib.okhttp.DownloadListener
                public void onDownloadError(Exception exc) {
                    PhotoViewerActivity.this.isDownloading = false;
                    DDLog.m1685e("图片加载", "图片下载失败：" + exc.getMessage());
                    PhotoViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.7.3
                        @Override // java.lang.Runnable
                        public void run() {
                            PhotoViewerActivity.this.dismissLoadingDialog();
                        }
                    });
                }

                @Override // com.ipotensic.baselib.okhttp.DownloadListener
                public void notEnoughSpace() {
                    PhotoViewerActivity.this.isDownloading = false;
                    DDLog.m1685e("图片加载", "图片下载失败：没有足够空间");
                    PhotoViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.7.4
                        @Override // java.lang.Runnable
                        public void run() {
                            PhotoViewerActivity.this.dismissLoadingDialog();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPhoto(String str, PhotoView photoView) {
        if (photoView == null) {
            return;
        }
        Glide.with((FragmentActivity) this).load(str).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(photoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("hasDelete", this.hasDelete);
        setResult(-1, intent);
        finish();
        overridePendingTransition(0, C1965R.anim.trans_out_bottom_gallery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void share() {
        File file;
        RemoteFile remoteFile = RemoteFileManager.getInstance().getPhotoList().get(this.curIndex);
        if (remoteFile.isDownloaded()) {
            if ((!isFinishing() && PhoneConfig.isConnectFlightWifi()) || NetworkUtils.getNetworkState(this) < 0) {
                new GeneralDialog(this, getResources().getString(C1965R.string.txt_dialog_make_sure_internet_title), getResources().getString(C1965R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.8
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }
                }).show();
                return;
            }
            if (remoteFile.isFromUsb()) {
                file = new File(remoteFile.getUsbPhotoPath());
            } else {
                file = new File(LocalFileManager.getInstance().getMediaDir(), remoteFile.getFileName());
            }
            DDLog.m1685e("图片加载", "file name:" + file.getAbsolutePath());
            new Share2.Builder(this).setContentType(ShareContentType.IMAGE).setIsSingle(true).setShareFileUri(FileUtil.getFileUri(this, ShareContentType.FILE, file)).setTitle("SHARE WITH FRIENDS").build().shareBySystem();
            return;
        }
        this.isNeedShare = true;
        download();
    }

    /* renamed from: com.ipotensic.kernel.activitys.PhotoViewerActivity$9 */
    class C20549 implements GeneralDialog.ClickConfirmListener {
        C20549() {
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            PhotoViewerActivity.this.showLoadingDialog();
            PhotoViewerActivity.this.mCycleViewPager.setCanTouch(false);
            PhoneConfig.threadPool.execute(new AnonymousClass1());
        }

        /* renamed from: com.ipotensic.kernel.activitys.PhotoViewerActivity$9$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    RemoteFileManager.getInstance().deleteFile(RemoteFileManager.getInstance().getPhotoList().get(PhotoViewerActivity.this.curIndex), new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.9.1.1
                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestFailed(int i, Exception exc) {
                        }

                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestSuccess(int i, BaseData baseData) {
                            PhotoViewerActivity.this.hasDelete = true;
                            PhotoViewerActivity.this.isFirstLoaded = false;
                            RemoteFileManager.getInstance().getPhotoList().remove(PhotoViewerActivity.this.curIndex);
                            PhotoViewerActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.9.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DDLog.m1685e("图片加载", "删除成功");
                                    int size = RemoteFileManager.getInstance().getPhotoList().size();
                                    if (size <= 0) {
                                        PhotoViewerActivity.this.finishActivity();
                                    } else {
                                        PhotoViewerActivity.this.curIndex %= size;
                                        if (PhotoViewerActivity.this.curIndex < 0) {
                                            PhotoViewerActivity.this.curIndex = 0;
                                        }
                                        PhotoViewerActivity.this.refreshViewPager();
                                    }
                                    PhotoViewerActivity.this.dismissLoadingDialog();
                                    PhotoViewerActivity.this.mCycleViewPager.setCanTouch(true);
                                    ToastUtil.showImageTop(PhotoViewerActivity.this, PhotoViewerActivity.this.getString(C1965R.string.toast_delete_success), C1965R.mipmap.icon_toast_successful);
                                }
                            });
                        }
                    });
                    PhotoViewerActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.9.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            PhotoViewerActivity.this.cycleAdapter.notifyDataSetChanged();
                            PhotoViewerActivity.this.dismissLoadingDialog();
                        }
                    });
                } catch (Exception e) {
                    DDLog.m1685e("图片加载", "删除错误:" + e.getMessage());
                    PhotoViewerActivity.this.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.9.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            PhotoViewerActivity.this.dismissLoadingDialog();
                            PhotoViewerActivity.this.mCycleViewPager.setCanTouch(true);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        new GeneralDialog((Context) this, getString(C1965R.string.dialog_delete_this_file), getString(C1965R.string.dialog_delete_file_describe), (String) null, (String) null, false, 2, (GeneralDialog.ClickConfirmListener) new C20549()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileDownloaded(boolean z) {
        this.btnDownload.setImageResource(z ? C1965R.mipmap.img_mark_already_downloaded : C1965R.mipmap.icon_btn_download);
        RemoteFileManager.getInstance().getPhotoList().get(this.curIndex).setDownloaded(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download() {
        if (RemoteFileManager.getInstance().getPhotoList() == null || RemoteFileManager.getInstance().getPhotoList().size() <= 0) {
            return;
        }
        if (RemoteFileManager.getInstance().getPhotoList().get(this.curIndex).isDownloaded()) {
            ToastUtil.toast(this, getString(C1965R.string.dialog_file_is_downloaded));
            return;
        }
        DownloadFileDialog downloadFileDialog = new DownloadFileDialog(this, 1, new DownloadFileDialog.CancelListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.10
            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void onDownloadError(String str) {
            }

            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void onCancelClicked() {
                PhotoViewerActivity.this.showLoadingDialog();
                RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.10.1
                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestSuccess(int i, BaseData baseData) {
                        PhotoViewerActivity.this.dismissLoadingDialog();
                    }

                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestFailed(int i, Exception exc) {
                        PhotoViewerActivity.this.dismissLoadingDialog();
                    }
                });
            }

            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void onDownloadFinished() {
                PhotoViewerActivity.this.setFileDownloaded(true);
                if (PhotoViewerActivity.this.isNeedShare) {
                    PhotoViewerActivity.this.isNeedShare = false;
                    PhotoViewerActivity.this.share();
                }
                MediaStoreUtil.refreshAlbum(PhotoViewerActivity.this, new File(LocalFileManager.getInstance().getMediaDir(), RemoteFileManager.getInstance().getPhotoList().get(PhotoViewerActivity.this.curIndex).getFileName()));
            }

            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void noEnoughMemory() {
                PhotoViewerActivity.this.showLoadingDialog();
                RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.10.2
                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestSuccess(int i, BaseData baseData) {
                        PhotoViewerActivity.this.dismissLoadingDialog();
                    }

                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestFailed(int i, Exception exc) {
                        PhotoViewerActivity.this.dismissLoadingDialog();
                    }
                });
            }
        });
        this.downloadDialog = downloadFileDialog;
        downloadFileDialog.show();
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RemoteFileManager.getInstance().download(RemoteFileManager.getInstance().getPhotoList().get(PhotoViewerActivity.this.curIndex), LocalFileManager.getInstance().getMediaDir(), PhotoViewerActivity.this.downloadDialog.getDownloadListener());
                } catch (Exception e) {
                    DDLog.m1685e("图片加载", "下载出错：" + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMediaInfo() {
        final RemoteFile remoteFile = RemoteFileManager.getInstance().getPhotoList().get(this.curIndex);
        IMediaInfoCallback iMediaInfoCallback = new IMediaInfoCallback() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.12
            @Override // com.logan.camera.listeners.IMediaInfoCallback
            public void onCallback(final MediaInfoData mediaInfoData) {
                PhotoViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mediaInfoData != null) {
                            if (!remoteFile.isFromUsb()) {
                                mediaInfoData.setWidth(RemoteFileManager.getInstance().getPhotoList().get(PhotoViewerActivity.this.curIndex).getWidth());
                                mediaInfoData.setHeight(RemoteFileManager.getInstance().getPhotoList().get(PhotoViewerActivity.this.curIndex).getHeight());
                            }
                            MediaInfoDialog mediaInfoDialog = new MediaInfoDialog(PhotoViewerActivity.this);
                            mediaInfoDialog.setMediaInfo(mediaInfoData);
                            mediaInfoDialog.show();
                            return;
                        }
                        ToastUtil.toast(PhotoViewerActivity.this, PhotoViewerActivity.this.getString(C1965R.string.file_system_error));
                    }
                });
            }
        };
        if (remoteFile.isFromUsb()) {
            UsbGalleryManager.getInstance().getFileDetail(remoteFile, iMediaInfoCallback);
        } else {
            CameraCtrlPresenter.getInstance().getMediaInfo(remoteFile.getRemotePath(), iMediaInfoCallback);
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.PhotoViewerActivity$15 */
    static /* synthetic */ class C204615 {
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
        int i = C204615.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
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
            ToastUtil.toast(this, getString(C1965R.string.sd_insertion));
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
        ToastUtil.toast(this, getString(C1965R.string.sd_pullout));
        new Handler().postDelayed(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.13
            @Override // java.lang.Runnable
            public void run() {
                PhotoViewerActivity.this.finishActivity();
            }
        }, 2500L);
    }

    private class CyclePagerAdapter extends PagerAdapter {
        private Context context;
        private int mChildCount;
        private LinkedList<View> mViewCache;
        private View.OnClickListener photoClickListener;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private CyclePagerAdapter(PhotoViewerActivity photoViewerActivity) {
            this.photoClickListener = new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.CyclePagerAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PhotoViewerActivity.this.layoutTop.setVisibility(PhotoViewerActivity.this.layoutTop.getVisibility() == 0 ? 8 : 0);
                    PhotoViewerActivity.this.layoutBottom.setVisibility(PhotoViewerActivity.this.layoutBottom.getVisibility() != 0 ? 0 : 8);
                }
            };
            this.mViewCache = new LinkedList<>();
            this.context = photoViewerActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.mChildCount = getCount();
            try {
                super.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            PhotoViewerActivity.this.mCycleViewPager.setCanTouch(RemoteFileManager.getInstance().getPhotoList().size() > 1);
            return RemoteFileManager.getInstance().getPhotoList().size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int i = this.mChildCount;
            if (i > 0) {
                this.mChildCount = i - 1;
                return -2;
            }
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, final int i) {
            View removeFirst;
            DDLog.m1692w("图片加载", "图片 instantiate item:" + i);
            View view = null;
            try {
                if (this.mViewCache.size() == 0) {
                    removeFirst = new PhotoView(this.context);
                } else {
                    removeFirst = this.mViewCache.removeFirst();
                }
                view = removeFirst;
                final PhotoView photoView = (PhotoView) view;
                photoView.setMark(i);
                photoView.setOnClickListener(this.photoClickListener);
                RemoteFile remoteFile = RemoteFileManager.getInstance().getPhotoList().get(i);
                PhotoViewerActivity.this.setFileDownloaded(RemoteFileManager.getInstance().getPhotoList().get(PhotoViewerActivity.this.curIndex).isDownloaded());
                if (!remoteFile.isFromUsb()) {
                    if (remoteFile.isDownloaded() && remoteFile.getLocalPath() != null) {
                        Glide.with(this.context).load(remoteFile.getLocalPath()).into(photoView);
                    } else {
                        Glide.with(this.context).load(remoteFile.getDownloadUrl()).asBitmap().into((BitmapTypeRequest<String>) new SimpleTarget<Bitmap>() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.CyclePagerAdapter.1
                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
                                onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
                            }

                            @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                            public void onLoadStarted(Drawable drawable) {
                                super.onLoadStarted(drawable);
                                if (PhotoViewerActivity.this.curIndex == i) {
                                    PhotoViewerActivity.this.showLoadingDialog();
                                }
                            }

                            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                                if (i > RemoteFileManager.getInstance().getPhotoList().size() - 1) {
                                    return;
                                }
                                if (PhotoViewerActivity.this.curIndex == i) {
                                    PhotoViewerActivity.this.dismissLoadingDialog();
                                }
                                RemoteFileManager.getInstance().getPhotoList().get(i).setWidth(bitmap.getWidth());
                                RemoteFileManager.getInstance().getPhotoList().get(i).setHeight(bitmap.getHeight());
                                photoView.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
                viewGroup.addView(view);
            } catch (Exception unused) {
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof View) {
                View view = (View) obj;
                viewGroup.removeView(view);
                this.mViewCache.add(view);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishActivity();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.PhotoViewerActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Glide.get(PhotoViewerActivity.this).clearDiskCache();
                } catch (Exception unused) {
                }
            }
        });
        try {
            Glide.get(this).clearMemory();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }
}