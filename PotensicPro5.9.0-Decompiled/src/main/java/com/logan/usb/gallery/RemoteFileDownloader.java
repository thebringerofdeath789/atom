package com.logan.usb.gallery;

import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.logan.camera.OnResponseListener;
import com.logan.camera.RemoteFile;
import com.logan.camera.data.DownloadData;
import com.logan.usb.AOAEngine;
import com.logan.usb.UsbCameraHandler;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.io.File;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes3.dex */
public class RemoteFileDownloader {
    private RandomAccessFile downloadFile;
    private DownloadListener downloadListener;
    private String fileName;
    private File local;
    private RemoteFile remoteFile;
    private long totalLen;
    private final int FILE_DOWNLOAD_TIMEOUT = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;
    private final int PROGRESS_REFRESH_UNIT = 200;
    private final int UNIT_DOWNLOAD_TIMEOUT = 1000;
    private final long DOWNLOAD_UNIT = 102400;
    private boolean isReDownload = false;
    private boolean isCancel = false;
    private int progress = -1;
    private long lastRefreshTime = 0;
    private final Runnable unitTimeout = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDownloader.5
        @Override // java.lang.Runnable
        public void run() {
            if (RemoteFileDownloader.this.isCancel || RemoteFileDownloader.this.isReDownload) {
                return;
            }
            try {
                long filePointer = RemoteFileDownloader.this.downloadFile.getFilePointer();
                DDLog.e("图库超时重新下载:" + filePointer);
                RemoteFileDownloader.this.download(filePointer);
                PhoneConfig.mainHandler.postDelayed(RemoteFileDownloader.this.unitTimeout, 1000L);
            } catch (Exception e) {
                DDLog.e("图库超时下载失败:" + e.getMessage());
            }
        }
    };
    private final Runnable offsetErrorRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDownloader.6
        @Override // java.lang.Runnable
        public void run() {
            if (RemoteFileDownloader.this.isCancel || !RemoteFileDownloader.this.isReDownload) {
                return;
            }
            try {
                long filePointer = RemoteFileDownloader.this.downloadFile.getFilePointer();
                DDLog.e("图库大小对不上重新下载:" + filePointer);
                RemoteFileDownloader.this.download(filePointer);
                PhoneConfig.mainHandler.postDelayed(RemoteFileDownloader.this.offsetErrorRunnable, 1000L);
            } catch (Exception e) {
                DDLog.e("图库大小对不上下载失败:" + e.getMessage());
            }
        }
    };
    private final Runnable timeoutRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDownloader.7
        @Override // java.lang.Runnable
        public void run() {
            UsbGalleryManager.getInstance().interruptDownloadFile(new OnResponseListener() { // from class: com.logan.usb.gallery.RemoteFileDownloader.7.1
                @Override // com.logan.camera.OnResponseListener
                public void onRequestFailed(int i, Exception exc) {
                }

                @Override // com.logan.camera.OnResponseListener
                public void onRequestSuccess(int i, Object obj) {
                }
            });
        }
    };

    public void downloadFile(RemoteFile remoteFile, File file, DownloadListener downloadListener) throws Exception {
        this.remoteFile = remoteFile;
        this.downloadFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        this.local = file;
        this.downloadListener = downloadListener;
        this.totalLen = remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_PHOTO ? remoteFile.getUsbFileLenData().getLen() : remoteFile.getUsbFileLenData().getLrv_len();
        this.fileName = remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_PHOTO ? remoteFile.getFileName() : remoteFile.getLrvFileName();
        download(0L);
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteFileDownloader.this.downloadListener.onDownloadStart();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download(long j) {
        byte[] longToBytesLittle;
        byte[] longToBytesLittle2 = ParseUtil.longToBytesLittle(j);
        long j2 = j + 102400;
        long j3 = this.totalLen;
        if (j2 >= j3) {
            longToBytesLittle = ParseUtil.longToBytesLittle(j3 - j);
        } else {
            longToBytesLittle = ParseUtil.longToBytesLittle(102400L);
        }
        UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{27}, longToBytesLittle2, longToBytesLittle, this.fileName.getBytes()));
    }

    public void onReceiveData(byte[] bArr) {
        if (this.isCancel || this.downloadFile == null || this.downloadListener == null) {
            DDLog.e("图库 lrvFile:" + this.downloadFile);
            DDLog.e("图库 lvrDownloadListener:" + this.downloadListener);
            return;
        }
        try {
            DownloadData downloadData = new DownloadData(bArr);
            final long filePointer = this.downloadFile.getFilePointer();
            if (downloadData.getOffset() != filePointer) {
                if (this.isReDownload) {
                    return;
                }
                DDLog.e("图库下载失败 从 " + filePointer + " 位置重新下载");
                this.isReDownload = true;
                PhoneConfig.mainHandler.post(this.offsetErrorRunnable);
                return;
            }
            PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
            PhoneConfig.mainHandler.removeCallbacks(this.unitTimeout);
            PhoneConfig.mainHandler.removeCallbacks(this.offsetErrorRunnable);
            this.isReDownload = false;
            this.downloadFile.write(downloadData.getPayload());
            long payloadLen = downloadData.getPayloadLen() + filePointer;
            final int i = (int) ((100 * payloadLen) / this.totalLen);
            if (i != this.progress) {
                this.progress = i;
                if (System.currentTimeMillis() - this.lastRefreshTime >= 200) {
                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDownloader.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RemoteFileDownloader.this.downloadListener.onDownloadProgress(i, RemoteFileDownloader.this.totalLen);
                                DDLog.e("图库LRV下载长度:" + filePointer + ",总长度:" + RemoteFileDownloader.this.totalLen);
                            } catch (Exception unused) {
                            }
                        }
                    });
                    this.lastRefreshTime = System.currentTimeMillis();
                }
            }
            if (downloadData.isFileEnd()) {
                try {
                    final String absolutePath = this.local.getAbsolutePath();
                    this.downloadFile.close();
                    DDLog.e("图库下载成功");
                    this.remoteFile.setDownloaded(true);
                    this.remoteFile.setLocalPath(this.local.getAbsolutePath());
                    this.downloadFile = null;
                    this.local = null;
                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDownloader.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RemoteFileDownloader.this.downloadListener != null) {
                                RemoteFileDownloader.this.downloadListener.onDownloadEnd(absolutePath);
                            }
                        }
                    });
                    return;
                } catch (Exception unused) {
                    DDLog.e("");
                    return;
                }
            }
            if (downloadData.isUnitEnd()) {
                DDLog.e("图库本次传输结束");
                download(payloadLen);
                PhoneConfig.mainHandler.postDelayed(this.timeoutRunnable, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
                PhoneConfig.mainHandler.postDelayed(this.unitTimeout, 1000L);
                return;
            }
            PhoneConfig.mainHandler.postDelayed(this.timeoutRunnable, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
            PhoneConfig.mainHandler.postDelayed(this.unitTimeout, 1000L);
        } catch (Exception e) {
            DDLog.e("图库下载报错:" + e.getMessage());
        }
    }

    public void setCancel() {
        this.isCancel = true;
        try {
            RandomAccessFile randomAccessFile = this.downloadFile;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.downloadFile = null;
            }
            File file = this.local;
            if (file != null) {
                DDLog.e("是否删除文件:" + file.delete());
            }
        } catch (Exception unused) {
        }
    }

    public void cancelDownload() {
        this.isCancel = true;
        this.downloadFile = null;
        this.local = null;
        this.isReDownload = false;
        AOAEngine.getInstance().resetCameraBuffer();
        PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
        PhoneConfig.mainHandler.removeCallbacks(this.unitTimeout);
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDownloader.4
            @Override // java.lang.Runnable
            public void run() {
                if (RemoteFileDownloader.this.downloadListener != null) {
                    RemoteFileDownloader.this.downloadListener.onDownloadError(new Exception("cancelDownload"));
                }
            }
        });
    }
}
