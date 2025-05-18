package com.logan.usb.gallery;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.logan.camera.JsonParser;
import com.logan.camera.OnResponseListener;
import com.logan.camera.RemoteFile;
import com.logan.camera.data.MediaInfoData;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.usb.UsbCameraHandler;
import com.logan.usb.gallery.RemoteFileDelete;
import com.logan.usb.gallery.RemoteFileListLoader;
import com.logan.usb.utils.FileReceiver;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class UsbGalleryManager {
    public static volatile UsbGalleryManager manager;
    private RemoteFileDownloader downloadFile;
    private OnResponseListener enterGalleryListener;
    private RemoteFileDelete fileDelete;
    private RemoteFileThumbLoader fileThumbLoader;
    private OnResponseListener getFileLengthListener;
    private OnResponseListener interruptDownloadFileListener;
    private OnResponseListener interruptGetFileThumbnailListener;
    private FileReceiver mediaFileReceiver;
    private IMediaInfoCallback mediaInfoCallback;
    private MultiUsbFileDownloader multiUsbFileDownloader;
    private OnResponseListener quitGalleryListener;
    private RemoteFileListLoader remoteFileListLoader;
    private FileTypeEnum requestDetailFileType;
    private boolean stopReceive = false;
    private boolean isCancel = false;
    private AtomicBoolean isEnterGallery = new AtomicBoolean(false);
    private final Object getFileNameLock = new Object();

    private UsbGalleryManager() {
    }

    public static UsbGalleryManager getInstance() {
        if (manager == null) {
            synchronized (UsbGalleryManager.class) {
                if (manager == null) {
                    UsbGalleryManager usbGalleryManager = new UsbGalleryManager();
                    manager = usbGalleryManager;
                    return usbGalleryManager;
                }
            }
        }
        return manager;
    }

    public void getFileList(RemoteFileListLoader.OnFileListListener onFileListListener) {
        RemoteFileListLoader remoteFileListLoader = new RemoteFileListLoader(onFileListListener);
        this.remoteFileListLoader = remoteFileListLoader;
        remoteFileListLoader.getFileNum();
    }

    public void getFileDetail(RemoteFile remoteFile, IMediaInfoCallback iMediaInfoCallback) {
        if (remoteFile != null) {
            this.mediaInfoCallback = iMediaInfoCallback;
            this.requestDetailFileType = remoteFile.getFileTypeEnum();
            DDLog.m1684e("图库获取详情:" + remoteFile.getFileName());
            send(ParseUtil.concatAll(new byte[]{26}, remoteFile.getFileName().getBytes()));
        }
    }

    public void getThumbnails(FileTypeEnum fileTypeEnum, List<RemoteFile> list, int i, int i2, OnFileDownloadListener onFileDownloadListener) {
        RemoteFileThumbLoader remoteFileThumbLoader = new RemoteFileThumbLoader(onFileDownloadListener);
        this.fileThumbLoader = remoteFileThumbLoader;
        remoteFileThumbLoader.getThumbs(fileTypeEnum, list, i, i2);
    }

    public void downloadFile(RemoteFile remoteFile, File file, DownloadListener downloadListener) {
        RemoteFileDownloader remoteFileDownloader = new RemoteFileDownloader();
        this.downloadFile = remoteFileDownloader;
        try {
            remoteFileDownloader.downloadFile(remoteFile, file, downloadListener);
        } catch (Exception e) {
            DDLog.m1684e("图库下载出错:" + e.getMessage());
            interruptDownloadFile(new OnResponseListener() { // from class: com.logan.usb.gallery.UsbGalleryManager.1
                @Override // com.logan.camera.OnResponseListener
                public void onRequestFailed(int i, Exception exc) {
                }

                @Override // com.logan.camera.OnResponseListener
                public void onRequestSuccess(int i, Object obj) {
                }
            });
        }
    }

    public void downloadFiles(List<RemoteFile> list, DownloadListener downloadListener, OnFileDownloadListener onFileDownloadListener) {
        MultiUsbFileDownloader multiUsbFileDownloader = new MultiUsbFileDownloader();
        this.multiUsbFileDownloader = multiUsbFileDownloader;
        try {
            multiUsbFileDownloader.download(list, downloadListener, onFileDownloadListener);
        } catch (Exception e) {
            DDLog.m1684e("图库下载出错1:" + e.getMessage());
            interruptDownloadFile(new OnResponseListener() { // from class: com.logan.usb.gallery.UsbGalleryManager.2
                @Override // com.logan.camera.OnResponseListener
                public void onRequestFailed(int i, Exception exc) {
                }

                @Override // com.logan.camera.OnResponseListener
                public void onRequestSuccess(int i, Object obj) {
                }
            });
        }
    }

    public void deleteFile(List<RemoteFile> list, RemoteFileDelete.OnDeleteListener onDeleteListener) {
        RemoteFileDelete remoteFileDelete = new RemoteFileDelete(list, onDeleteListener);
        this.fileDelete = remoteFileDelete;
        remoteFileDelete.deleteNext();
    }

    public void interruptDownloadFile(OnResponseListener onResponseListener) {
        DDLog.m1684e("图库下载 中断");
        this.interruptDownloadFileListener = onResponseListener;
        RemoteFileDownloader remoteFileDownloader = this.downloadFile;
        if (remoteFileDownloader != null) {
            remoteFileDownloader.setCancel();
        }
        this.isCancel = false;
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.usb.gallery.UsbGalleryManager.3
            @Override // java.lang.Runnable
            public void run() {
                while (UsbConfig.isUsbConnected && !UsbGalleryManager.this.isCancel) {
                    UsbGalleryManager.this.send(new byte[]{30});
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void interruptGetFileThumbnail(OnResponseListener onResponseListener) {
        this.interruptDownloadFileListener = onResponseListener;
        send(new byte[31]);
    }

    public void enterGallery(OnResponseListener onResponseListener) {
        this.enterGalleryListener = onResponseListener;
        DDLog.m1684e("发送 进入图库");
        send(new byte[]{33});
    }

    public void setEnterGalleryFlag() {
        this.isEnterGallery.set(true);
    }

    public void setQuitGalleryFlag() {
        this.isEnterGallery.set(false);
        synchronized (this.getFileNameLock) {
            try {
                this.getFileNameLock.notify();
            } catch (Exception unused) {
            }
        }
    }

    public boolean isEnterGallery() {
        return this.isEnterGallery.get();
    }

    public void quitGallery(OnResponseListener onResponseListener) {
        this.quitGalleryListener = onResponseListener;
        DDLog.m1684e("发送 退出图库");
        send(new byte[]{34});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void send(byte[] bArr) {
        UsbCameraHandler.getInstance().sendGalleryData(bArr);
    }

    public void onReceived(byte[] bArr) {
        DDLog.m1684e("收到图库数据1:" + ParseUtil.byteToHexString(bArr, 20));
        int payloadIndex = UsbConfig.getPayloadIndex(0);
        switch (bArr[payloadIndex]) {
            case 24:
            case 25:
                RemoteFileListLoader remoteFileListLoader = this.remoteFileListLoader;
                if (remoteFileListLoader != null) {
                    remoteFileListLoader.onReceived(bArr);
                    break;
                }
                break;
            case 26:
                int length = bArr.length - (payloadIndex + 3);
                if (length > 0) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, payloadIndex + 2, bArr2, 0, length);
                    String trim = new String(bArr2, StandardCharsets.US_ASCII).trim();
                    try {
                        DDLog.m1691w("图库 获取文件信息:" + trim);
                        final MediaInfoData parseMediaInfo = JsonParser.parseMediaInfo(trim);
                        parseMediaInfo.setVideo(this.requestDetailFileType == FileTypeEnum.TYPE_VIDEO);
                        if (this.mediaInfoCallback != null) {
                            PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.UsbGalleryManager.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    UsbGalleryManager.this.mediaInfoCallback.onCallback(parseMediaInfo);
                                }
                            });
                            break;
                        }
                    } catch (Exception e) {
                        DDLog.m1684e("获取图库图片信息出错:" + e.getMessage());
                        return;
                    }
                } else if (this.mediaInfoCallback != null) {
                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.UsbGalleryManager.5
                        @Override // java.lang.Runnable
                        public void run() {
                            UsbGalleryManager.this.mediaInfoCallback.onCallback(null);
                        }
                    });
                    break;
                }
                break;
            case 27:
                RemoteFileDownloader remoteFileDownloader = this.downloadFile;
                if (remoteFileDownloader != null) {
                    remoteFileDownloader.onReceiveData(bArr);
                    break;
                }
                break;
            case 28:
            case 32:
                RemoteFileThumbLoader remoteFileThumbLoader = this.fileThumbLoader;
                if (remoteFileThumbLoader != null) {
                    remoteFileThumbLoader.onReceived(bArr);
                    break;
                }
                break;
            case 29:
                RemoteFileDelete remoteFileDelete = this.fileDelete;
                if (remoteFileDelete != null) {
                    remoteFileDelete.onReceived(bArr);
                    break;
                }
                break;
            case 30:
                DDLog.m1684e("下载已中断");
                FileReceiver fileReceiver = this.mediaFileReceiver;
                if (fileReceiver != null && !this.stopReceive) {
                    fileReceiver.interrupt();
                    this.mediaFileReceiver = null;
                }
                RemoteFileDownloader remoteFileDownloader2 = this.downloadFile;
                if (remoteFileDownloader2 != null) {
                    remoteFileDownloader2.cancelDownload();
                }
                this.isCancel = true;
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.UsbGalleryManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UsbGalleryManager.this.interruptDownloadFileListener != null) {
                            UsbGalleryManager.this.interruptDownloadFileListener.onRequestSuccess(0, null);
                        }
                    }
                });
                break;
            case 31:
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.UsbGalleryManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UsbGalleryManager.this.interruptGetFileThumbnailListener != null) {
                            UsbGalleryManager.this.interruptGetFileThumbnailListener.onRequestSuccess(0, null);
                        }
                    }
                });
                break;
            case 33:
                DDLog.m1684e("收到进入图库数据：" + ParseUtil.byteToHexString(bArr, 50));
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.UsbGalleryManager.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UsbGalleryManager.this.enterGalleryListener != null) {
                            UsbGalleryManager.this.enterGalleryListener.onRequestSuccess(0, null);
                        }
                    }
                });
                break;
            case 34:
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.usb.gallery.UsbGalleryManager.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UsbGalleryManager.this.quitGalleryListener != null) {
                            UsbGalleryManager.this.quitGalleryListener.onRequestSuccess(0, null);
                        }
                    }
                });
                break;
        }
    }
}