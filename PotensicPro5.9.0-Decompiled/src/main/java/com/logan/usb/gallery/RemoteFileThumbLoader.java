package com.logan.usb.gallery;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.camera.JsonParser;
import com.logan.camera.RemoteFile;
import com.logan.camera.RemoteFileManager;
import com.logan.camera.data.UsbFileLenData;
import com.logan.camera.listeners.OnFileCallback;
import com.logan.flight.R;
import com.logan.usb.UsbCameraHandler;
import com.logan.usb.utils.FileReceiver;
import com.logan.usb.utils.Md5Util;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes3.dex */
public class RemoteFileThumbLoader {
    private int downloadIndex;
    private int end;
    private OnFileCallback fileCallback;
    private List<RemoteFile> list;
    private int start;
    private OnFileDownloadListener thumbListener;
    private FileReceiver thumbnailFileReceiver;
    private FileTypeEnum typeEnum;
    private final long REQUEST_DOWNLOAD_ALL_TIMEOUT = SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
    private final long REQUEST_FILE_META_TIMEOUT = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private final long REQUEST_FILE_THUMBNAIL_TIMEOUT = 4000;
    private final Runnable fileMetaRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileThumbLoader.2
        @Override // java.lang.Runnable
        public void run() {
            if (UsbGalleryManager.getInstance().isEnterGallery()) {
                RemoteFileThumbLoader.this.getFileMeta();
            }
        }
    };
    private final Runnable fileThumbRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileThumbLoader.3
        @Override // java.lang.Runnable
        public void run() {
            if (UsbGalleryManager.getInstance().isEnterGallery()) {
                try {
                    RemoteFileThumbLoader.this.downloadNextThumb();
                } catch (Exception e) {
                    DDLog.e("图库加载缩略图失败:" + e);
                }
            }
        }
    };
    private final Runnable allFileRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileThumbLoader.4
        @Override // java.lang.Runnable
        public void run() {
            PhoneConfig.mainHandler.removeCallbacks(RemoteFileThumbLoader.this.fileThumbRunnable);
            PhoneConfig.mainHandler.removeCallbacks(RemoteFileThumbLoader.this.fileMetaRunnable);
            if (RemoteFileThumbLoader.this.thumbListener != null) {
                RemoteFileThumbLoader.this.thumbListener.onRequestFailed();
            }
        }
    };

    static /* synthetic */ int access$108(RemoteFileThumbLoader remoteFileThumbLoader) {
        int i = remoteFileThumbLoader.downloadIndex;
        remoteFileThumbLoader.downloadIndex = i + 1;
        return i;
    }

    public RemoteFileThumbLoader(OnFileDownloadListener onFileDownloadListener) {
        this.thumbListener = onFileDownloadListener;
    }

    public void getThumbs(FileTypeEnum fileTypeEnum, List<RemoteFile> list, int i, int i2) {
        this.typeEnum = fileTypeEnum;
        this.list = list;
        this.start = i;
        this.end = i2;
        PhoneConfig.mainHandler.postDelayed(this.allFileRunnable, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        getFileMeta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFileMeta() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"filelist\":[");
        for (int i = this.start; i < this.end; i++) {
            sb.append("\"" + this.list.get(i).getFileName() + "\"");
            if (i < this.end - 1) {
                sb.append(",");
            }
        }
        sb.append("]}");
        String sb2 = sb.toString();
        sb.reverse();
        UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{32}, sb2.getBytes()));
        PhoneConfig.mainHandler.removeCallbacks(this.fileMetaRunnable);
        PhoneConfig.mainHandler.postDelayed(this.fileMetaRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    private void download(RemoteFile remoteFile, OnFileCallback onFileCallback) {
        this.fileCallback = onFileCallback;
        FileReceiver fileReceiver = this.thumbnailFileReceiver;
        if (fileReceiver != null) {
            fileReceiver.finish();
            this.thumbnailFileReceiver = null;
        }
        this.thumbnailFileReceiver = new FileReceiver(new File(LocalFileManager.getInstance().getThumbnailDir(), remoteFile.getFileName().replace(InternalZipConstants.ZIP_FILE_SEPARATOR, "_") + RemoteFileManager.THUMB_SUFFIX));
        DDLog.e("图库创建 thumbnailFileReceiver  :" + this.thumbnailFileReceiver);
        UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{28}, remoteFile.getFileName().getBytes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadNextThumb() throws Exception {
        if (UsbGalleryManager.getInstance().isEnterGallery()) {
            if (this.list.get(this.downloadIndex).getThumbnailUrl() != null) {
                DDLog.e("缩略图已存在 ：" + this.list.get(this.downloadIndex).getThumbnailUrl());
                OnFileDownloadListener onFileDownloadListener = this.thumbListener;
                if (onFileDownloadListener != null) {
                    onFileDownloadListener.onItemDownloaded(this.downloadIndex);
                }
                int i = this.downloadIndex;
                if (i != this.end - 1) {
                    this.downloadIndex = i + 1;
                    downloadNextThumb();
                    return;
                } else {
                    onAllDone();
                    return;
                }
            }
            final RemoteFile remoteFile = this.list.get(this.downloadIndex);
            DDLog.e("图库缩略图：" + remoteFile.getFileName());
            download(remoteFile, new OnFileCallback() { // from class: com.logan.usb.gallery.RemoteFileThumbLoader.1
                @Override // com.logan.camera.listeners.OnFileCallback
                public void onFile(File file, boolean z) {
                    try {
                        if (z) {
                            DDLog.e("图库缩略图 损坏：" + remoteFile.getFileName());
                        } else {
                            DDLog.e("图库缩略图 完整：" + remoteFile.getFileName());
                        }
                        PhoneConfig.mainHandler.removeCallbacks(RemoteFileThumbLoader.this.fileThumbRunnable);
                        if (z) {
                            ((RemoteFile) RemoteFileThumbLoader.this.list.get(RemoteFileThumbLoader.this.downloadIndex)).setBroken(true);
                        } else {
                            ((RemoteFile) RemoteFileThumbLoader.this.list.get(RemoteFileThumbLoader.this.downloadIndex)).setThumbnailUrl(file.getAbsolutePath());
                        }
                        if (RemoteFileThumbLoader.this.thumbListener != null) {
                            RemoteFileThumbLoader.this.thumbListener.onItemDownloaded(RemoteFileThumbLoader.this.downloadIndex);
                        }
                        if (RemoteFileThumbLoader.this.downloadIndex == RemoteFileThumbLoader.this.end - 1) {
                            RemoteFileThumbLoader.this.onAllDone();
                            return;
                        }
                        RemoteFileThumbLoader.access$108(RemoteFileThumbLoader.this);
                        try {
                            RemoteFileThumbLoader.this.downloadNextThumb();
                        } catch (Exception e) {
                            DDLog.e("图库加载缩略图失败:" + e);
                        }
                    } catch (Exception e2) {
                        DDLog.e("图库下载缩略图报错:" + e2.getMessage());
                        RemoteFileThumbLoader.this.onAllDone();
                    }
                }

                @Override // com.logan.camera.listeners.OnFileCallback
                public void onFailed() {
                    try {
                        DDLog.e("图库缩略图 下载失败：" + remoteFile.getFileName());
                        RemoteFileThumbLoader.this.downloadNextThumb();
                    } catch (Exception e) {
                        DDLog.e("图库加载缩略图失败:" + e);
                    }
                }
            });
            PhoneConfig.mainHandler.removeCallbacks(this.fileThumbRunnable);
            PhoneConfig.mainHandler.postDelayed(this.fileThumbRunnable, 4000L);
        }
    }

    public void onReceived(byte[] bArr) {
        int payloadIndex = UsbConfig.getPayloadIndex(0);
        byte b = bArr[payloadIndex];
        if (b != 28) {
            if (b != 32) {
                return;
            }
            PhoneConfig.mainHandler.removeCallbacks(this.fileMetaRunnable);
            int length = bArr.length - (payloadIndex + 3);
            DDLog.e("文件长度:" + length);
            if (length > 0) {
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, payloadIndex + 2, bArr2, 0, length);
                String trim = new String(bArr2, StandardCharsets.US_ASCII).trim();
                DDLog.e("result123:" + trim);
                try {
                    List<UsbFileLenData> usbFileLenList = JsonParser.getUsbFileLenList(trim);
                    if (UsbGalleryManager.getInstance().isEnterGallery()) {
                        for (int i = 0; i < usbFileLenList.size(); i++) {
                            UsbFileLenData usbFileLenData = usbFileLenList.get(i);
                            if (this.typeEnum == FileTypeEnum.TYPE_VIDEO) {
                                for (int i2 = this.start; i2 < this.end; i2++) {
                                    if (RemoteFileManager.getInstance().getVideoList().get(i2).getFileName().trim().equals(usbFileLenData.getFile().trim())) {
                                        RemoteFileManager.getInstance().getVideoList().get(i2).setUsbFileLenData(usbFileLenData);
                                        File file = new File(RemoteFileManager.getInstance().getVideoList().get(i2).getUsbLrvPath());
                                        RemoteFileManager.getInstance().getVideoList().get(i2).setDownloaded(file.exists() && usbFileLenData.getLrv_len() == file.length());
                                    }
                                }
                            } else {
                                for (int i3 = this.start; i3 < this.end; i3++) {
                                    if (RemoteFileManager.getInstance().getPhotoList().get(i3).getFileName().trim().equals(usbFileLenData.getFile().trim())) {
                                        RemoteFileManager.getInstance().getPhotoList().get(i3).setUsbFileLenData(usbFileLenData);
                                        File file2 = new File(RemoteFileManager.getInstance().getPhotoList().get(i3).getUsbPhotoPath());
                                        RemoteFileManager.getInstance().getPhotoList().get(i3).setDownloaded(file2.exists() && usbFileLenData.getLen() == file2.length());
                                    }
                                }
                            }
                        }
                        this.downloadIndex = this.start;
                        downloadNextThumb();
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    OnFileDownloadListener onFileDownloadListener = this.thumbListener;
                    if (onFileDownloadListener != null) {
                        onFileDownloadListener.onRequestFailed();
                        return;
                    }
                    return;
                }
            }
            OnFileDownloadListener onFileDownloadListener2 = this.thumbListener;
            if (onFileDownloadListener2 != null) {
                onFileDownloadListener2.onRequestFailed();
                return;
            }
            return;
        }
        if (this.thumbnailFileReceiver == null) {
            return;
        }
        if (bArr[payloadIndex + 1] != 0) {
            if (this.fileCallback != null) {
                try {
                    File file3 = new File(LocalFileManager.getInstance().getThumbnailDir(), "broken_thumbnail.png");
                    if (!file3.exists()) {
                        ((BitmapDrawable) ResourcesCompat.getDrawable(PhoneConfig.applicationContext.getResources(), R.mipmap.img_bg_thumbnail_broken, null)).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file3.getAbsolutePath()));
                    }
                    this.fileCallback.onFile(file3, true);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            return;
        }
        int i4 = payloadIndex + 3;
        if (bArr.length < i4) {
            return;
        }
        if (!(bArr[payloadIndex + 2] == 2)) {
            int unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(bArr, payloadIndex + 7);
            int i5 = payloadIndex + 9;
            if (bArr.length > i5 + unsignedShortFromByteArr) {
                try {
                    this.thumbnailFileReceiver.receive(bArr, i5, unsignedShortFromByteArr);
                    return;
                } catch (Exception e) {
                    DDLog.e("图库接收数据出错1" + e.getMessage());
                    return;
                }
            }
            return;
        }
        int unsignedShortFromByteArr2 = ParseUtil.getUnsignedShortFromByteArr(bArr, payloadIndex + 7 + 32);
        DDLog.e("图库最后一帧长度:" + unsignedShortFromByteArr2);
        int i6 = payloadIndex + 9 + 32;
        if (bArr.length > i6 + unsignedShortFromByteArr2) {
            try {
                this.thumbnailFileReceiver.receive(bArr, i6, unsignedShortFromByteArr2);
            } catch (Exception e2) {
                DDLog.e("P1PRO 图库接收数据出错2:" + e2.getMessage());
            }
        }
        FileReceiver fileReceiver = this.thumbnailFileReceiver;
        if (fileReceiver != null) {
            fileReceiver.finish();
            DDLog.e("图库缩略图接收完成");
            byte[] fileMD5 = Md5Util.getFileMD5(this.thumbnailFileReceiver.getFile());
            DDLog.e("本地图库 MD5:" + ParseUtil.byteToHexString(fileMD5));
            if (fileMD5 != null) {
                byte[] bArr3 = new byte[32];
                System.arraycopy(bArr, i4, bArr3, 0, 32);
                DDLog.e("远程图库 MD5:" + ParseUtil.byteToHexString(bArr3));
                if (this.fileCallback == null || this.thumbnailFileReceiver == null) {
                    return;
                }
                if (Arrays.equals(fileMD5, bArr3)) {
                    this.fileCallback.onFile(this.thumbnailFileReceiver.getFile(), false);
                } else {
                    this.fileCallback.onFailed();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAllDone() {
        PhoneConfig.mainHandler.removeCallbacks(this.allFileRunnable);
        OnFileDownloadListener onFileDownloadListener = this.thumbListener;
        if (onFileDownloadListener != null) {
            onFileDownloadListener.onAllDone();
        }
    }
}
