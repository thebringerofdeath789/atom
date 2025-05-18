package com.logan.usb.gallery;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.camera.RemoteFile;
import com.logan.camera.RemoteFileManager;
import com.logan.camera.data.FileNumData;
import com.logan.usb.UsbCameraHandler;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class RemoteFileListLoader {
    private int downloadedPhotoPages;
    private int downloadedVideoPages;
    private OnFileListListener fileListListener;
    private int photoElseNum;
    private int videoElseNum;
    private final long REQUEST_GET_FILE_NUM_TIMEOUT = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private final long REQUEST_GET_FILE_LIST_TIMEOUT = RtspMediaSource.DEFAULT_TIMEOUT_MS;
    private final short NUM_ONE_PAGE = 50;
    private final byte TYPE_ALL = 0;
    private final byte TYPE_PICTURE = 1;
    private final byte TYPE_VIDEO = 2;
    private int videoNum = 0;
    private int picNum = 0;
    private final Runnable fileNumRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileListLoader.1
        @Override // java.lang.Runnable
        public void run() {
            if (UsbGalleryManager.getInstance().isEnterGallery()) {
                RemoteFileListLoader.this.getFileNum();
            }
        }
    };
    private final Runnable fileListRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileListLoader.2
        @Override // java.lang.Runnable
        public void run() {
            if (UsbGalleryManager.getInstance().isEnterGallery()) {
                RemoteFileListLoader.this.getFileList();
            }
        }
    };

    public interface OnFileListListener {
        void onFileLoaded();
    }

    public RemoteFileListLoader(OnFileListListener onFileListListener) {
        this.fileListListener = onFileListListener;
    }

    public void getFileNum() {
        RemoteFileManager.getInstance().photoList.clear();
        RemoteFileManager.getInstance().videoList.clear();
        UsbCameraHandler.getInstance().sendGalleryData(new byte[]{24});
        DDLog.m1684e("发送图库 获取数量");
        PhoneConfig.mainHandler.removeCallbacks(this.fileNumRunnable);
        PhoneConfig.mainHandler.postDelayed(this.fileNumRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFileList() {
        DDLog.m1684e("发送图库 获取文件名称");
        PhoneConfig.mainHandler.removeCallbacks(this.fileListRunnable);
        PhoneConfig.mainHandler.postDelayed(this.fileListRunnable, RtspMediaSource.DEFAULT_TIMEOUT_MS);
        RemoteFileManager.getInstance().photoList.clear();
        RemoteFileManager.getInstance().videoList.clear();
        int i = this.videoNum;
        this.videoElseNum = i;
        int i2 = this.picNum;
        this.photoElseNum = i2;
        this.downloadedVideoPages = 0;
        this.downloadedPhotoPages = 0;
        if (i + i2 <= 50) {
            UsbCameraHandler.getInstance().sendGalleryData(new byte[]{25, 0, 0, 0, 0, 0});
        } else {
            loadNextPage();
        }
    }

    private void loadNextPage() {
        if (UsbGalleryManager.getInstance().isEnterGallery()) {
            int i = this.videoElseNum;
            if (i > 0) {
                if (i <= 50) {
                    byte[] bArr = new byte[2];
                    ParseUtil.short2ByteArr((short) (this.downloadedVideoPages * 50), bArr, 0);
                    byte[] bArr2 = new byte[2];
                    ParseUtil.short2ByteArr((short) this.videoElseNum, bArr2, 0);
                    this.videoElseNum = 0;
                    UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{25, 2}, bArr, bArr2));
                    return;
                }
                byte[] bArr3 = new byte[2];
                ParseUtil.short2ByteArr((short) (this.downloadedVideoPages * 50), bArr3, 0);
                byte[] bArr4 = new byte[2];
                ParseUtil.short2ByteArr((short) 50, bArr4, 0);
                UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{25, 2}, bArr3, bArr4));
                this.downloadedVideoPages++;
                this.videoElseNum -= 50;
                return;
            }
            int i2 = this.photoElseNum;
            if (i2 > 0) {
                if (i2 <= 50) {
                    byte[] bArr5 = new byte[2];
                    ParseUtil.short2ByteArr((short) (this.downloadedPhotoPages * 50), bArr5, 0);
                    byte[] bArr6 = new byte[2];
                    ParseUtil.short2ByteArr((short) this.photoElseNum, bArr6, 0);
                    this.photoElseNum = 0;
                    UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{25, 1}, bArr5, bArr6));
                    return;
                }
                byte[] bArr7 = new byte[2];
                ParseUtil.short2ByteArr((short) (this.downloadedPhotoPages * 50), bArr7, 0);
                byte[] bArr8 = new byte[2];
                ParseUtil.short2ByteArr((short) 50, bArr8, 0);
                UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{25, 1}, bArr7, bArr8));
                this.downloadedPhotoPages++;
                this.photoElseNum -= 50;
            }
        }
    }

    public void onReceived(byte[] bArr) {
        int length;
        try {
            DDLog.m1684e("收到图库数据:" + ParseUtil.byteToHexString(bArr, 20));
            int payloadIndex = UsbConfig.getPayloadIndex(0);
            byte b = bArr[payloadIndex];
            if (b == 24) {
                PhoneConfig.mainHandler.removeCallbacks(this.fileNumRunnable);
                this.picNum = ParseUtil.getUnsignedShortFromByteArr(bArr, payloadIndex + 2);
                this.videoNum = ParseUtil.getUnsignedShortFromByteArr(bArr, payloadIndex + 4);
                DDLog.m1684e("图库视频数量：" + this.videoNum);
                DDLog.m1684e("图库图片数量：" + this.picNum);
                int i = this.videoNum;
                int i2 = this.picNum;
                if (new FileNumData(i + i2, i, i2).getCount() == 0) {
                    OnFileListListener onFileListListener = this.fileListListener;
                    if (onFileListListener != null) {
                        onFileListListener.onFileLoaded();
                        return;
                    }
                    return;
                }
                getFileList();
                return;
            }
            if (b == 25 && (length = bArr.length - (payloadIndex + 5)) > 0) {
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, payloadIndex + 4, bArr2, 0, length);
                String[] split = new String(bArr2, StandardCharsets.US_ASCII).trim().split("\u0000");
                if (split.length > 0) {
                    for (String str : split) {
                        if (str.toLowerCase().endsWith(RemoteFileManager.PHOTO_SUFFIX.toLowerCase())) {
                            RemoteFile remoteFile = new RemoteFile();
                            remoteFile.setFromUsb(true);
                            remoteFile.setFileName(str);
                            remoteFile.setFileTypeEnum(FileTypeEnum.TYPE_PHOTO);
                            RemoteFileManager.getInstance().photoList.add(remoteFile);
                        } else if (str.toLowerCase().endsWith(RemoteFileManager.VIDEO_SUFFIX.toLowerCase())) {
                            RemoteFile remoteFile2 = new RemoteFile();
                            remoteFile2.setFromUsb(true);
                            remoteFile2.setFileName(str);
                            remoteFile2.setFileTypeEnum(FileTypeEnum.TYPE_VIDEO);
                            RemoteFileManager.getInstance().videoList.add(remoteFile2);
                        }
                    }
                }
                DDLog.m1684e("图库 videoNum :" + this.videoNum);
                DDLog.m1684e("图库 picNum :" + this.picNum);
                DDLog.m1684e("图库 videoNum1 :" + RemoteFileManager.getInstance().videoList.size());
                DDLog.m1684e("图库 picNum1 :" + RemoteFileManager.getInstance().photoList.size());
                if (RemoteFileManager.getInstance().photoList.size() == this.picNum && RemoteFileManager.getInstance().videoList.size() == this.videoNum) {
                    PhoneConfig.mainHandler.removeCallbacks(this.fileListRunnable);
                    OnFileListListener onFileListListener2 = this.fileListListener;
                    if (onFileListListener2 != null) {
                        onFileListListener2.onFileLoaded();
                        return;
                    }
                    return;
                }
                loadNextPage();
            }
        } catch (Exception e) {
            DDLog.m1684e("图库解析失败:" + e);
        }
    }
}