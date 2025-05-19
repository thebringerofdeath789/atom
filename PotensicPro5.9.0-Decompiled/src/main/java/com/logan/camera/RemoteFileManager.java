package com.logan.camera;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.CommonUtil;
import com.logan.camera.data.BaseData;
import com.logan.camera.data.FileInfoData;
import com.logan.camera.data.FileListData;
import com.logan.camera.data.FileNumData;
import com.logan.camera.data.MediaInfoData;
import com.logan.camera.data.StatusData;
import com.logan.camera.data.UsbFileLenData;
import com.logan.camera.enums.StatusEnum;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.usb.gallery.OnFileDownloadListener;
import com.logan.usb.gallery.RemoteFileDelete;
import com.logan.usb.gallery.RemoteFileListLoader;
import com.logan.usb.gallery.UsbGalleryManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class RemoteFileManager {
    public static final String PHOTO_SUFFIX = ".JPG";
    public static final String THUMB_SUFFIX = ".THM";
    public static final String VIDEO_SUFFIX = ".MP4";
    private static volatile RemoteFileManager instance;
    private OnResponseListener getFileListListener;
    public List<RemoteFile> videoList = new ArrayList();
    public List<RemoteFile> photoList = new ArrayList();
    private CallBackString<BaseData> callback = new CallBackString<BaseData>() { // from class: com.logan.camera.RemoteFileManager.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public BaseData onParseResponse(int i, String str) throws Exception {
            if (i == 116) {
                FileNumData parseFileNum = JsonParser.parseFileNum(str);
                if (parseFileNum != null) {
                    OkHttpUtil.getInstance().get(127, String.format(CameraConstants.URL_GET_VIDEO_LIST, Integer.valueOf(parseFileNum.getVideo())), RemoteFileManager.this.callback);
                    OkHttpUtil.getInstance().get(128, String.format(CameraConstants.URL_GET_PHOTO_LIST, Integer.valueOf(parseFileNum.getPhoto())), RemoteFileManager.this.callback);
                }
                return parseFileNum;
            }
            if (i == 127) {
                FileListData parseFileList = JsonParser.parseFileList(str);
                if (parseFileList != null) {
                    RemoteFileManager.this.parseVideoFile(parseFileList.getFile());
                }
                return parseFileList;
            }
            if (i != 128) {
                return null;
            }
            FileListData parseFileList2 = JsonParser.parseFileList(str);
            if (parseFileList2 != null) {
                RemoteFileManager.this.parsePhotoFile(parseFileList2.getFile());
            }
            return parseFileList2;
        }

        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public void onResponse(int i, BaseData baseData) {
            if (i == 128 || i == 127) {
                RemoteFileManager.this.getFileListListener.onRequestSuccess(i, null);
            }
        }

        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public void onFailure(int i, Exception exc) {
            RemoteFileManager.this.getFileListListener.onRequestFailed(i, exc);
        }
    };

    private RemoteFileManager() {
    }

    public static RemoteFileManager getInstance() {
        if (instance == null) {
            synchronized (RemoteFileManager.class) {
                if (instance == null) {
                    RemoteFileManager remoteFileManager = new RemoteFileManager();
                    instance = remoteFileManager;
                    return remoteFileManager;
                }
            }
        }
        return instance;
    }

    public List<RemoteFile> getVideoList() {
        return this.videoList;
    }

    public List<RemoteFile> getPhotoList() {
        return this.photoList;
    }

    public void getFileList(final OnResponseListener onResponseListener) {
        this.getFileListListener = onResponseListener;
        UsbGalleryManager.getInstance().setEnterGalleryFlag();
        if (UsbConfig.isUsbConnected) {
            LocalFileManager.getInstance().clearThumbnails();
            UsbGalleryManager.getInstance().enterGallery(new OnResponseListener<BaseData>() { // from class: com.logan.camera.RemoteFileManager.1
                @Override // com.logan.camera.OnResponseListener
                public void onRequestFailed(int i, Exception exc) {
                }

                @Override // com.logan.camera.OnResponseListener
                public void onRequestSuccess(final int i, BaseData baseData) {
                    UsbGalleryManager.getInstance().getFileList(new RemoteFileListLoader.OnFileListListener() { // from class: com.logan.camera.RemoteFileManager.1.1
                        @Override // com.logan.usb.gallery.RemoteFileListLoader.OnFileListListener
                        public void onFileLoaded() {
                            onResponseListener.onRequestSuccess(i, null);
                        }
                    });
                }
            });
        } else {
            OkHttpUtil.getInstance().get(116, CameraConstants.URL_GET_FILE_NUM, this.callback);
        }
    }

    public void getUsbThumbnail(FileTypeEnum fileTypeEnum, List<RemoteFile> list, int i, int i2, OnFileDownloadListener onFileDownloadListener) {
        UsbGalleryManager.getInstance().getThumbnails(fileTypeEnum, list, i, i2, onFileDownloadListener);
    }

    public void downloadMultiFileForUsb(List<RemoteFile> list, DownloadListener downloadListener, OnFileDownloadListener onFileDownloadListener) throws Exception {
        UsbGalleryManager.getInstance().downloadFiles(list, downloadListener, onFileDownloadListener);
    }

    public void download(final RemoteFile remoteFile, String str, final DownloadListener downloadListener) throws Exception {
        File file;
        if (remoteFile.isFromUsb()) {
            if (remoteFile.getUsbFileLenData() != null) {
                if (remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO) {
                    file = new File(remoteFile.getUsbLrvPath());
                } else {
                    file = new File(remoteFile.getUsbPhotoPath());
                }
                if (remoteFile.isDownloaded()) {
                    downloadListener.onDownloadStart();
                    downloadListener.onDownloadEnd(file.getAbsolutePath());
                    return;
                } else {
                    UsbGalleryManager.getInstance().downloadFile(remoteFile, file, downloadListener);
                    return;
                }
            }
            UsbGalleryManager.getInstance().getFileDetail(remoteFile, new IMediaInfoCallback() { // from class: com.logan.camera.RemoteFileManager.2
                @Override // com.logan.camera.listeners.IMediaInfoCallback
                public void onCallback(MediaInfoData mediaInfoData) {
                    File file2;
                    if (mediaInfoData != null) {
                        UsbFileLenData usbFileLenData = new UsbFileLenData();
                        if (remoteFile.getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO) {
                            usbFileLenData.setLrv_len(mediaInfoData.getLrv_filesize());
                            file2 = new File(remoteFile.getUsbLrvPath());
                        } else {
                            usbFileLenData.setLen(mediaInfoData.getFilesize());
                            file2 = new File(remoteFile.getUsbPhotoPath());
                        }
                        remoteFile.setUsbFileLenData(usbFileLenData);
                        if (remoteFile.isDownloaded()) {
                            downloadListener.onDownloadStart();
                            downloadListener.onDownloadEnd(file2.getAbsolutePath());
                            return;
                        } else {
                            UsbGalleryManager.getInstance().downloadFile(remoteFile, file2, downloadListener);
                            return;
                        }
                    }
                    downloadListener.onDownloadError(new Exception("mediaInfoData = null"));
                }
            });
            return;
        }
        FileInfoData parseFileInfo = JsonParser.parseFileInfo(OkHttpUtil.getInstance().getSync(119, remoteFile.getGetInfoUrl()));
        File file2 = new File(str, remoteFile.getFileName());
        if (file2.exists() && isFileExist(parseFileInfo)) {
            downloadListener.onDownloadStart();
            downloadListener.onDownloadEnd(file2.getAbsolutePath());
        } else if (CommonUtil.getSDFreeSize() < (parseFileInfo.getSize() / 1024) / 1024) {
            downloadListener.notEnoughSpace();
        } else {
            OkHttpUtil.getInstance().downloadGalleryFileSync(118, remoteFile.getDownloadUrl(), str, remoteFile.getFileName(), parseFileInfo.getCreateTime(), downloadListener);
        }
    }

    public boolean isFileExist(FileInfoData fileInfoData) {
        Iterator<LocalFile> it = LocalFileManager.getInstance().getVideoList().iterator();
        while (it.hasNext()) {
            LocalFile next = it.next();
            if (next.getCreateTime() == fileInfoData.getCreateTime() && next.getSize() == fileInfoData.getSize()) {
                return true;
            }
        }
        Iterator<LocalFile> it2 = LocalFileManager.getInstance().getPhotoList().iterator();
        while (it2.hasNext()) {
            LocalFile next2 = it2.next();
            if (next2.getCreateTime() == fileInfoData.getCreateTime() && next2.getSize() == fileInfoData.getSize()) {
                return true;
            }
        }
        return false;
    }

    public void cancelDownload(OnResponseListener onResponseListener) {
        if (PhoneConfig.isConnectFlightWifi()) {
            OkHttpUtil.getInstance().cancelDownload();
            onResponseListener.onRequestSuccess(0, null);
        } else {
            UsbGalleryManager.getInstance().interruptDownloadFile(onResponseListener);
        }
    }

    public void deleteUsbFiles(List<RemoteFile> list, final OnResponseListener onResponseListener) {
        UsbGalleryManager.getInstance().deleteFile(list, new RemoteFileDelete.OnDeleteListener() { // from class: com.logan.camera.RemoteFileManager.3
            @Override // com.logan.usb.gallery.RemoteFileDelete.OnDeleteListener
            public void onDeleteSuccess() {
                onResponseListener.onRequestSuccess(0, null);
            }

            @Override // com.logan.usb.gallery.RemoteFileDelete.OnDeleteListener
            public void onDeleteFailed() {
                onResponseListener.onRequestFailed(0, new Exception());
            }
        });
    }

    public void deleteFile(RemoteFile remoteFile, OnResponseListener onResponseListener) throws Exception {
        if (remoteFile.isFromUsb()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(remoteFile);
            deleteUsbFiles(arrayList, onResponseListener);
        } else {
            StatusData parseStatusData = JsonParser.parseStatusData(OkHttpUtil.getInstance().getSync(120, remoteFile.getDeleteUrl()));
            if (parseStatusData != null && parseStatusData.getStatus() == StatusEnum.STATUS_SUCCESS) {
                onResponseListener.onRequestSuccess(0, null);
            } else {
                onResponseListener.onRequestFailed(0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseVideoFile(List<String> list) {
        this.videoList.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (str.endsWith(VIDEO_SUFFIX)) {
                this.videoList.add(new RemoteFile(FileTypeEnum.TYPE_VIDEO, str, String.format("http://%s/%s", "192.168.29.1", str.replace(VIDEO_SUFFIX, THUMB_SUFFIX)), String.format("http://%s/%s", "192.168.29.1", str), String.format(CameraConstants.URL_GET_FILE_INFO, str), String.format(CameraConstants.URL_GET_DELETE_FILE, str)));
            }
        }
        DDLog.i("videoList:" + this.videoList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parsePhotoFile(List<String> list) {
        this.photoList.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (str.endsWith(PHOTO_SUFFIX)) {
                this.photoList.add(new RemoteFile(FileTypeEnum.TYPE_PHOTO, str, String.format("http://%s/%s", "192.168.29.1", str.replace(PHOTO_SUFFIX, THUMB_SUFFIX)), String.format("http://%s/%s", "192.168.29.1", str), String.format(CameraConstants.URL_GET_FILE_INFO, str), String.format(CameraConstants.URL_GET_DELETE_FILE, str)));
            }
        }
        DDLog.i("photoList:" + this.photoList.size());
    }
}
