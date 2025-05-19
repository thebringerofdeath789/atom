package com.logan.camera;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.camera.data.UsbFileLenData;
import java.io.File;
import java.io.Serializable;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class RemoteFile implements Serializable {
    private String deleteUrl;
    private String downloadUrl;
    private String fileName;
    private FileTypeEnum fileTypeEnum;
    private String getInfoUrl;
    private int height;
    private String localPath;
    private String remotePath;
    private String thumbnailUrl;
    private UsbFileLenData usbFileLenData;
    private int width;
    private boolean isSelected = false;
    private boolean isDownloaded = false;
    private boolean isFromUsb = false;
    private boolean isDelete = false;
    private boolean isBroken = false;

    public RemoteFile() {
    }

    public RemoteFile(FileTypeEnum fileTypeEnum, String str, String str2, String str3, String str4, String str5) {
        this.fileTypeEnum = fileTypeEnum;
        this.remotePath = str;
        this.thumbnailUrl = str2;
        this.downloadUrl = str3;
        this.getInfoUrl = str4;
        this.deleteUrl = str5;
        setFileName();
    }

    private void setFileName() {
        String[] split;
        this.fileName = System.currentTimeMillis() + RemoteFileManager.VIDEO_SUFFIX;
        String str = this.remotePath;
        if (str == null || (split = str.split(InternalZipConstants.ZIP_FILE_SEPARATOR)) == null || split.length <= 0) {
            return;
        }
        this.fileName = split[split.length - 1];
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getLrvFileName() {
        return this.fileName.substring(0, r0.length() - 3) + "LRV";
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getRemotePath() {
        return this.remotePath;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getGetInfoUrl() {
        return this.getInfoUrl;
    }

    public String getDeleteUrl() {
        return this.deleteUrl;
    }

    public FileTypeEnum getFileTypeEnum() {
        return this.fileTypeEnum;
    }

    public void setFileTypeEnum(FileTypeEnum fileTypeEnum) {
        this.fileTypeEnum = fileTypeEnum;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isDownloaded() {
        if (this.isFromUsb) {
            File file = new File(getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO ? getUsbLrvPath() : getUsbPhotoPath());
            return file.exists() && this.usbFileLenData != null && (getFileTypeEnum() != FileTypeEnum.TYPE_VIDEO ? this.usbFileLenData.getLen() == file.length() : this.usbFileLenData.getLrv_len() == file.length());
        }
        return this.isDownloaded;
    }

    public void setDownloaded(boolean z) {
        this.isDownloaded = z;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public void setDelete(boolean z) {
        this.isDelete = z;
    }

    public boolean isFromUsb() {
        return this.isFromUsb;
    }

    public void setFromUsb(boolean z) {
        this.isFromUsb = z;
    }

    public boolean isBroken() {
        return this.isBroken;
    }

    public void setBroken(boolean z) {
        this.isBroken = z;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setUsbFileLenData(UsbFileLenData usbFileLenData) {
        this.usbFileLenData = usbFileLenData;
    }

    public UsbFileLenData getUsbFileLenData() {
        return this.usbFileLenData;
    }

    public String getUsbLrvPath() {
        String formatCurTime;
        String str;
        String substring = getFileName().replace(InternalZipConstants.ZIP_FILE_SEPARATOR, "_").substring(0, r1.length() - 4);
        UsbFileLenData usbFileLenData = this.usbFileLenData;
        if (usbFileLenData != null) {
            try {
                formatCurTime = usbFileLenData.getCreatetime().trim().replace(InternalZipConstants.ZIP_FILE_SEPARATOR, "").replace(StringUtils.SPACE, "").replace(":", "");
            } catch (Exception e) {
                DDLog.e("获取文件时间报错:" + e.getMessage());
                formatCurTime = FormatUtil.formatCurTime();
            }
            str = substring + "_" + formatCurTime + ".mp4";
        } else {
            str = substring + ".mp4";
        }
        return new File(LocalFileManager.getInstance().getMediaDir(), str).getAbsolutePath();
    }

    public String getUsbPhotoPath() {
        String formatCurTime;
        UsbFileLenData usbFileLenData = this.usbFileLenData;
        if (usbFileLenData != null) {
            try {
                formatCurTime = usbFileLenData.getCreatetime().trim().replace(InternalZipConstants.ZIP_FILE_SEPARATOR, "").replace(StringUtils.SPACE, "").replace(":", "");
            } catch (Exception e) {
                DDLog.e("获取文件时间报错1:" + e.getMessage());
                formatCurTime = FormatUtil.formatCurTime();
            }
            return new File(LocalFileManager.getInstance().getMediaDir(), getFileName().replace(InternalZipConstants.ZIP_FILE_SEPARATOR, "_").substring(0, r1.length() - 4) + "_" + formatCurTime + RemoteFileManager.PHOTO_SUFFIX).getAbsolutePath();
        }
        return new File(LocalFileManager.getInstance().getMediaDir(), getFileName().replace(InternalZipConstants.ZIP_FILE_SEPARATOR, "_")).getAbsolutePath();
    }

    public String toString() {
        return "RemoteFile{width=" + this.width + ", height=" + this.height + ", fileName='" + this.fileName + "', remotePath='" + this.remotePath + "', localPath='" + this.localPath + "', thumbnailUrl='" + this.thumbnailUrl + "', downloadUrl='" + this.downloadUrl + "', getInfoUrl='" + this.getInfoUrl + "', deleteUrl='" + this.deleteUrl + "', fileTypeEnum=" + this.fileTypeEnum + ", isSelected=" + this.isSelected + ", isDownloaded=" + this.isDownloaded + ", isFromUsb=" + this.isFromUsb + ", usbFileLenData=" + this.usbFileLenData + '}';
    }
}
