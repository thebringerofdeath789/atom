package com.ipotensic.kernel.utils;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.MediaFileUtils;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.DownloadFileDialog;
import com.ipotensic.kernel.view.dialog.DeleteMediaDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.OnResponseListener;
import com.logan.camera.RemoteFile;
import com.logan.camera.RemoteFileManager;
import com.logan.camera.data.BaseData;
import com.logan.camera.data.MediaInfoData;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* loaded from: classes2.dex */
public class VideoPlayerUtils {
    public static final int REQUEST_CODE_SHARE = 101;

    public interface OnDownloadListener {
        void onDownloadFailed();

        void onDownloadSuccess();
    }

    public static MediaInfoData parseLocalVideoMeta(LocalFile localFile) {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaInfoData mediaInfoData = new MediaInfoData();
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e) {
                e = e;
                mediaMetadataRetriever = null;
            } catch (Throwable th) {
                th = th;
                try {
                    mediaMetadataRetriever2.release();
                } catch (IOException unused) {
                }
                throw th;
            }
            try {
                File file = new File(localFile.getAbsPath());
                DDLog.e("mediainfo file path:" + localFile.getAbsPath());
                mediaInfoData.setFilename(file.getName());
                mediaInfoData.setFilesize(file.length());
                mediaInfoData.setCreatetime(FormatUtil.formatCreateTime(file.lastModified()));
                mediaMetadataRetriever.setDataSource(localFile.getAbsPath());
                mediaInfoData.setFiletime((int) (localFile.getDuration() / 1000));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaInfoData.setWidth(Integer.parseInt(extractMetadata));
                mediaInfoData.setHeight(Integer.parseInt(extractMetadata2));
                mediaInfoData.setFps(getFps(localFile.getAbsPath()));
            } catch (Exception e2) {
                e = e2;
                DDLog.e("\u83b7\u53d6\u89c6\u9891\u4fe1\u606f\u51fa\u95191111 \uff1a" + e.getMessage());
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused2) {
                }
                mediaInfoData = null;
                return mediaInfoData;
            }
            try {
                mediaMetadataRetriever.release();
            } catch (IOException unused3) {
            }
            return mediaInfoData;
        } catch (Throwable th2) {
            th = th2;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            mediaMetadataRetriever2.release();
            throw th;
        }
    }

    public static int getFps(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        int i = 30;
        try {
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                for (int i2 = 0; i2 < trackCount; i2++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                    if (trackFormat.getString(IMediaFormat.KEY_MIME).startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                        i = trackFormat.getInteger("frame-rate");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            mediaExtractor.release();
        }
    }

    public static void share(BaseActivity baseActivity, File file) {
        if (PhoneConfig.isConnectFlightWifi() || NetworkUtils.getNetworkState(baseActivity) < 0) {
            new GeneralDialog(baseActivity, baseActivity.getResources().getString(R.string.txt_dialog_make_sure_internet_title), baseActivity.getResources().getString(R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.1
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }
            }).show();
        } else {
            new Share2.Builder(baseActivity).setContentType(ShareContentType.VIDEO).setTitle("SHARE WITH FRIENDS").setIsSingle(true).setOnActivityResult(101).setShareFileUri(FileUtil.getFileUri(baseActivity, ShareContentType.FILE, file)).build().shareBySystem();
        }
    }

    public static void download(final BaseActivity baseActivity, final RemoteFile remoteFile, DownloadFileDialog downloadFileDialog, final OnDownloadListener onDownloadListener) {
        if (remoteFile.isDownloaded()) {
            if (onDownloadListener != null) {
                onDownloadListener.onDownloadSuccess();
                return;
            } else {
                ToastUtil.toast(baseActivity, baseActivity.getString(R.string.dialog_file_is_downloaded));
                return;
            }
        }
        DownloadFileDialog downloadFileDialog2 = new DownloadFileDialog(baseActivity, 1, new DownloadFileDialog.CancelListener() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.2
            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void onCancelClicked() {
                BaseActivity.this.showLoadingDialog();
                RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.2.1
                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestSuccess(int i, BaseData baseData) {
                        if (onDownloadListener != null) {
                            onDownloadListener.onDownloadFailed();
                        }
                        BaseActivity.this.dismissLoadingDialog();
                    }

                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestFailed(int i, Exception exc) {
                        BaseActivity.this.dismissLoadingDialog();
                    }
                });
            }

            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void onDownloadFinished() {
                File file;
                if (remoteFile.isFromUsb()) {
                    file = new File(remoteFile.getUsbLrvPath());
                } else {
                    file = new File(LocalFileManager.getInstance().getMediaDir(), remoteFile.getLrvFileName());
                }
                MediaStoreUtil.refreshAlbum(BaseActivity.this, file);
                OnDownloadListener onDownloadListener2 = onDownloadListener;
                if (onDownloadListener2 != null) {
                    onDownloadListener2.onDownloadSuccess();
                }
            }

            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void onDownloadError(String str) {
                DDLog.e("\u89c6\u9891\u4e0b\u8f7d\uff1a", str);
                OnDownloadListener onDownloadListener2 = onDownloadListener;
                if (onDownloadListener2 != null) {
                    onDownloadListener2.onDownloadFailed();
                }
            }

            @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
            public void noEnoughMemory() {
                OnDownloadListener onDownloadListener2 = onDownloadListener;
                if (onDownloadListener2 != null) {
                    onDownloadListener2.onDownloadFailed();
                }
                BaseActivity.this.showLoadingDialog();
                RemoteFileManager.getInstance().cancelDownload(new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.2.2
                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestSuccess(int i, BaseData baseData) {
                        BaseActivity.this.dismissLoadingDialog();
                    }

                    @Override // com.logan.camera.OnResponseListener
                    public void onRequestFailed(int i, Exception exc) {
                        BaseActivity.this.dismissLoadingDialog();
                    }
                });
            }
        });
        downloadFileDialog2.setShowDownloadSuccess(false);
        downloadFileDialog2.show();
        final DownloadListener downloadListener = downloadFileDialog2.getDownloadListener();
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RemoteFileManager.getInstance().download(RemoteFile.this, LocalFileManager.getInstance().getMediaDir(), downloadListener);
                } catch (Exception e) {
                    DDLog.e("\u4e0b\u8f7d\u51fa\u9519\uff1a" + e.getMessage());
                }
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.utils.VideoPlayerUtils$4, reason: invalid class name */
    class AnonymousClass4 implements GeneralDialog.ClickConfirmListener {
        final /* synthetic */ BaseActivity val$baseActivity;
        final /* synthetic */ int val$position;
        final /* synthetic */ RemoteFile val$remoteFile;
        final /* synthetic */ OnResultListener val$resultListener;

        AnonymousClass4(BaseActivity baseActivity, RemoteFile remoteFile, int i, OnResultListener onResultListener) {
            this.val$baseActivity = baseActivity;
            this.val$remoteFile = remoteFile;
            this.val$position = i;
            this.val$resultListener = onResultListener;
        }

        /* renamed from: com.ipotensic.kernel.utils.VideoPlayerUtils$4$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    RemoteFileManager.getInstance().deleteFile(AnonymousClass4.this.val$remoteFile, new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.4.1.1
                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestSuccess(int i, BaseData baseData) {
                            RemoteFileManager.getInstance().getVideoList().remove(AnonymousClass4.this.val$position);
                            if (AnonymousClass4.this.val$baseActivity == null || AnonymousClass4.this.val$baseActivity.isFinishing()) {
                                return;
                            }
                            AnonymousClass4.this.val$baseActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.4.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4.this.val$baseActivity.dismissLoadingDialog();
                                    if (AnonymousClass4.this.val$resultListener != null) {
                                        AnonymousClass4.this.val$resultListener.onSuccess(true);
                                    }
                                }
                            });
                        }

                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestFailed(int i, final Exception exc) {
                            if (AnonymousClass4.this.val$baseActivity == null || AnonymousClass4.this.val$baseActivity.isFinishing()) {
                                return;
                            }
                            AnonymousClass4.this.val$baseActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.4.1.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4.this.val$baseActivity.dismissLoadingDialog();
                                    if (AnonymousClass4.this.val$resultListener != null) {
                                        AnonymousClass4.this.val$resultListener.onFailed(exc);
                                    }
                                }
                            });
                        }
                    });
                } catch (Exception e) {
                    DDLog.e("\u5220\u9664\u9519\u8bef:" + e.getMessage());
                    if (AnonymousClass4.this.val$resultListener != null) {
                        AnonymousClass4.this.val$resultListener.onFailed(e);
                    }
                }
            }
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            this.val$baseActivity.showLoadingDialog();
            PhoneConfig.threadPool.execute(new AnonymousClass1());
        }
    }

    public static void deleteUsbRemoteFile(BaseActivity baseActivity, RemoteFile remoteFile, int i, OnResultListener onResultListener) {
        new GeneralDialog((Context) baseActivity, baseActivity.getString(R.string.dialog_delete_this_file), baseActivity.getString(R.string.dialog_delete_file_describe), (String) null, (String) null, false, 2, (GeneralDialog.ClickConfirmListener) new AnonymousClass4(baseActivity, remoteFile, i, onResultListener)).show();
    }

    /* renamed from: com.ipotensic.kernel.utils.VideoPlayerUtils$5, reason: invalid class name */
    class AnonymousClass5 implements GeneralDialog.ClickConfirmListener {
        final /* synthetic */ BaseActivity val$baseActivity;
        final /* synthetic */ int val$position;
        final /* synthetic */ RemoteFile val$remoteFile;
        final /* synthetic */ OnResultListener val$resultListener;

        AnonymousClass5(BaseActivity baseActivity, RemoteFile remoteFile, int i, OnResultListener onResultListener) {
            this.val$baseActivity = baseActivity;
            this.val$remoteFile = remoteFile;
            this.val$position = i;
            this.val$resultListener = onResultListener;
        }

        /* renamed from: com.ipotensic.kernel.utils.VideoPlayerUtils$5$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    RemoteFileManager.getInstance().deleteFile(AnonymousClass5.this.val$remoteFile, new OnResponseListener<BaseData>() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.5.1.1
                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestFailed(int i, Exception exc) {
                        }

                        @Override // com.logan.camera.OnResponseListener
                        public void onRequestSuccess(int i, BaseData baseData) {
                            RemoteFileManager.getInstance().getVideoList().remove(AnonymousClass5.this.val$position);
                            if (AnonymousClass5.this.val$baseActivity == null || AnonymousClass5.this.val$baseActivity.isFinishing()) {
                                return;
                            }
                            AnonymousClass5.this.val$baseActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.5.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass5.this.val$baseActivity.dismissLoadingDialog();
                                    if (AnonymousClass5.this.val$resultListener != null) {
                                        AnonymousClass5.this.val$resultListener.onSuccess(true);
                                    }
                                }
                            });
                        }
                    });
                } catch (Exception e) {
                    DDLog.e("\u5220\u9664\u9519\u8bef:" + e.getMessage());
                    if (AnonymousClass5.this.val$baseActivity == null || AnonymousClass5.this.val$baseActivity.isFinishing()) {
                        return;
                    }
                    AnonymousClass5.this.val$baseActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.5.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5.this.val$baseActivity.dismissLoadingDialog();
                            if (AnonymousClass5.this.val$resultListener != null) {
                                AnonymousClass5.this.val$resultListener.onFailed(e);
                            }
                        }
                    });
                }
            }
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            this.val$baseActivity.showLoadingDialog();
            PhoneConfig.threadPool.execute(new AnonymousClass1());
        }
    }

    public static void deleteRemoteFile(BaseActivity baseActivity, RemoteFile remoteFile, int i, OnResultListener onResultListener) {
        new GeneralDialog((Context) baseActivity, baseActivity.getString(R.string.dialog_delete_this_file), baseActivity.getString(R.string.dialog_delete_file_describe), (String) null, (String) null, false, 2, (GeneralDialog.ClickConfirmListener) new AnonymousClass5(baseActivity, remoteFile, i, onResultListener)).show();
    }

    public static void deleteLocalFile(final BaseActivity baseActivity, final LocalFile localFile, final OnResultListener onResultListener) {
        new DeleteMediaDialog(baseActivity, baseActivity.getString(R.string.dialog_delete_this_file), new DeleteMediaDialog.DeleteMediaListener() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.6
            @Override // com.ipotensic.kernel.view.dialog.DeleteMediaDialog.DeleteMediaListener
            public void delete() {
                if (Build.VERSION.SDK_INT >= 30) {
                    ArrayList<LocalFile> arrayList = new ArrayList<>();
                    arrayList.add(LocalFile.this);
                    LocalFileManager.getInstance().deleteFiles(baseActivity, arrayList, new MediaFileUtils.OnDeleteResultListener() { // from class: com.ipotensic.kernel.utils.VideoPlayerUtils.6.1
                        @Override // com.ipotensic.baselib.utils.MediaFileUtils.OnDeleteResultListener
                        public void onResult(boolean z) {
                            if (z) {
                                VideoPlayerUtils.refreshUIAfterDelete(LocalFile.this);
                            }
                            if (onResultListener != null) {
                                onResultListener.onSuccess(Boolean.valueOf(z));
                            }
                        }
                    });
                } else {
                    boolean deleteFile = LocalFileManager.getInstance().deleteFile(LocalFile.this);
                    VideoPlayerUtils.refreshUIAfterDelete(LocalFile.this);
                    OnResultListener onResultListener2 = onResultListener;
                    if (onResultListener2 != null) {
                        onResultListener2.onSuccess(Boolean.valueOf(deleteFile));
                    }
                }
            }
        }).show();
    }

    public static void refreshUIAfterDelete(LocalFile localFile) {
        ArrayList<LocalFile> videoList = LocalFileManager.getInstance().getVideoList();
        for (int i = 0; i < videoList.size(); i++) {
            if (videoList.get(i).getAbsPath() != null && videoList.get(i).getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO && videoList.get(i).getAbsPath().equals(localFile.getAbsPath())) {
                DDLog.e("remove photo file list");
                LocalFileManager.getInstance().getVideoList().remove(i);
                removeHead();
                return;
            }
        }
    }

    public static void removeHead() {
        Iterator<LocalFile> it = LocalFileManager.getInstance().getVideoList().iterator();
        while (it.hasNext()) {
            LocalFile next = it.next();
            if (next.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                int indexOf = LocalFileManager.getInstance().getVideoList().indexOf(next);
                if (indexOf == LocalFileManager.getInstance().getVideoList().size() - 1) {
                    it.remove();
                } else {
                    int i = indexOf + 1;
                    if (i <= LocalFileManager.getInstance().getVideoList().size() - 1 && LocalFileManager.getInstance().getVideoList().get(i).getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                        it.remove();
                    }
                }
            }
        }
    }
}