package com.logan.usb.gallery;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.camera.RemoteFile;
import com.logan.usb.UsbCameraHandler;
import java.util.List;

/* loaded from: classes3.dex */
public class RemoteFileDelete {
    private List<RemoteFile> deleteFiles;
    private OnDeleteListener deleteListener;
    private RemoteFile deletingFile;
    private final long REQUEST_DELETE_TIMEOUT = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private final Runnable deleteRunnable = new Runnable() { // from class: com.logan.usb.gallery.RemoteFileDelete.1
        @Override // java.lang.Runnable
        public void run() {
            if (UsbGalleryManager.getInstance().isEnterGallery()) {
                RemoteFileDelete.this.deleteNext();
            }
        }
    };

    public interface OnDeleteListener {
        void onDeleteFailed();

        void onDeleteSuccess();
    }

    public RemoteFileDelete(List<RemoteFile> list, OnDeleteListener onDeleteListener) {
        this.deleteListener = onDeleteListener;
        this.deleteFiles = list;
    }

    private RemoteFile getNextFile() {
        for (RemoteFile remoteFile : this.deleteFiles) {
            if (!remoteFile.isDelete()) {
                return remoteFile;
            }
        }
        return null;
    }

    public void deleteNext() {
        this.deletingFile = getNextFile();
        PhoneConfig.mainHandler.removeCallbacks(this.deleteRunnable);
        if (this.deletingFile != null) {
            DDLog.m1684e("图库发送删除指令:");
            UsbCameraHandler.getInstance().sendGalleryData(ParseUtil.concatAll(new byte[]{29, 0}, this.deletingFile.getFileName().getBytes()));
            PhoneConfig.mainHandler.postDelayed(this.deleteRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        } else {
            DDLog.m1684e("图库删除成功:");
            OnDeleteListener onDeleteListener = this.deleteListener;
            if (onDeleteListener != null) {
                onDeleteListener.onDeleteSuccess();
            }
        }
    }

    public void onReceived(byte[] bArr) {
        DDLog.m1684e("图库删除收到指令:" + ParseUtil.byteToHexString(bArr));
        if (bArr[UsbConfig.getPayloadIndex(0)] != 29) {
            return;
        }
        this.deletingFile.setDelete(true);
        deleteNext();
    }
}