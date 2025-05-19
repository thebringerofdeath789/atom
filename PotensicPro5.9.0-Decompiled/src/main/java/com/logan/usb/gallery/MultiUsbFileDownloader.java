package com.logan.usb.gallery;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.logan.camera.RemoteFile;
import com.logan.camera.data.MediaInfoData;
import com.logan.camera.data.UsbFileLenData;
import com.logan.camera.listeners.IMediaInfoCallback;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MultiUsbFileDownloader {
    private OnFileDownloadListener fileDownloadListener;
    private DownloadListener itemDownloadListener;
    private List<RemoteFile> remoteFiles;
    private final long GET_MEDIA_INFO_TIMEOUT = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private int downloadIndex = 0;
    private final Runnable mediaInfoRunnable = new Runnable() { // from class: com.logan.usb.gallery.MultiUsbFileDownloader.3
        @Override // java.lang.Runnable
        public void run() {
            if (UsbGalleryManager.getInstance().isEnterGallery()) {
                MultiUsbFileDownloader.this.checkMediaInfo();
            }
        }
    };

    public void download(List<RemoteFile> list, DownloadListener downloadListener, OnFileDownloadListener onFileDownloadListener) {
        this.remoteFiles = list;
        this.itemDownloadListener = downloadListener;
        this.fileDownloadListener = onFileDownloadListener;
        DDLog.e("需要下载文件的数量:" + list.size());
        Iterator<RemoteFile> it = list.iterator();
        while (it.hasNext()) {
            DDLog.e("图库需下载的文件：" + it.next().getFileName());
        }
        checkMediaInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMediaInfo() {
        for (int i = 0; i < this.remoteFiles.size(); i++) {
            RemoteFile remoteFile = this.remoteFiles.get(i);
            if (remoteFile.getUsbFileLenData() == null) {
                getMediaInfo(remoteFile);
                return;
            }
        }
        downloadNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadNext() {
        RemoteFile next = getNext();
        if (next == null) {
            DDLog.e("图库下载完成");
            this.fileDownloadListener.onAllDone();
        } else {
            DDLog.e("图库下载下一个：" + next.getFileName());
            download(next);
        }
    }

    private RemoteFile getNext() {
        File file;
        for (int i = 0; i < this.remoteFiles.size(); i++) {
            RemoteFile remoteFile = this.remoteFiles.get(i);
            if (!remoteFile.isDownloaded()) {
                DDLog.e("图库下载第" + i + "个");
                this.downloadIndex = i;
                return remoteFile;
            }
            DDLog.e("图库下载第" + i + "个:已下载...");
            if (this.downloadIndex < i) {
                this.downloadIndex = i;
                if (remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO) {
                    file = new File(remoteFile.getUsbLrvPath());
                } else {
                    file = new File(remoteFile.getUsbPhotoPath());
                }
                this.itemDownloadListener.onDownloadStart();
                this.itemDownloadListener.onDownloadEnd(file.getAbsolutePath());
            }
        }
        return null;
    }

    private void download(RemoteFile remoteFile) {
        File file;
        if (remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO) {
            file = new File(remoteFile.getUsbLrvPath());
        } else {
            file = new File(remoteFile.getUsbPhotoPath());
        }
        UsbGalleryManager.getInstance().downloadFile(remoteFile, file, new DownloadListener() { // from class: com.logan.usb.gallery.MultiUsbFileDownloader.1
            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadStart() {
                MultiUsbFileDownloader.this.itemDownloadListener.onDownloadStart();
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadProgress(float f, long j) {
                MultiUsbFileDownloader.this.itemDownloadListener.onDownloadProgress(f, j);
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadEnd(String str) {
                MultiUsbFileDownloader.this.itemDownloadListener.onDownloadEnd(str);
                MultiUsbFileDownloader.this.downloadNext();
                PhoneConfig.mainHandler.removeCallbacks(MultiUsbFileDownloader.this.mediaInfoRunnable);
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadEnd(String str, String str2) {
                MultiUsbFileDownloader.this.itemDownloadListener.onDownloadEnd(str, str2);
                MultiUsbFileDownloader.this.downloadNext();
                PhoneConfig.mainHandler.removeCallbacks(MultiUsbFileDownloader.this.mediaInfoRunnable);
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadError(Exception exc) {
                MultiUsbFileDownloader.this.itemDownloadListener.onDownloadError(exc);
                MultiUsbFileDownloader.this.fileDownloadListener.onRequestFailed();
                PhoneConfig.mainHandler.removeCallbacks(MultiUsbFileDownloader.this.mediaInfoRunnable);
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void notEnoughSpace() {
                MultiUsbFileDownloader.this.itemDownloadListener.notEnoughSpace();
            }
        });
    }

    private void getMediaInfo(final RemoteFile remoteFile) {
        PhoneConfig.mainHandler.removeCallbacks(this.mediaInfoRunnable);
        PhoneConfig.mainHandler.postDelayed(this.mediaInfoRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        UsbGalleryManager.getInstance().getFileDetail(remoteFile, new IMediaInfoCallback() { // from class: com.logan.usb.gallery.MultiUsbFileDownloader.2
            @Override // com.logan.camera.listeners.IMediaInfoCallback
            public void onCallback(MediaInfoData mediaInfoData) {
                if (mediaInfoData != null) {
                    PhoneConfig.mainHandler.removeCallbacks(MultiUsbFileDownloader.this.mediaInfoRunnable);
                    UsbFileLenData usbFileLenData = new UsbFileLenData();
                    if (remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO) {
                        usbFileLenData.setLrv_len(mediaInfoData.getLrv_filesize());
                    } else {
                        usbFileLenData.setLen(mediaInfoData.getFilesize());
                    }
                    remoteFile.setUsbFileLenData(usbFileLenData);
                    MultiUsbFileDownloader.this.checkMediaInfo();
                }
            }
        });
    }
}
