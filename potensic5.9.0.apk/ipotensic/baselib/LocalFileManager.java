package com.ipotensic.baselib;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Environment;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.DateUtils;
import com.ipotensic.baselib.utils.LogSaveManager;
import com.ipotensic.baselib.utils.MediaFileUtils;
import com.logan.camera.RemoteFileManager;
import com.logan.uom.UomConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class LocalFileManager {
    public static final String ANDROID_TAG = "-Android-";
    public static final String LOG_TAIL = ".bin";
    private static volatile LocalFileManager instance;
    private String CACHE_DIR;
    private String FW_DIR;
    private String HEADER_DIR;
    private String HEADER_IMAGE_PATH;
    private String PDF_DIR;
    private String UPGRADE_DIR;
    private String cacheDir;
    private final String[] VIDEO_SUFFIX = {RemoteFileManager.VIDEO_SUFFIX, ".LRV"};
    private final String[] PHOTO_SUFFIX = {RemoteFileManager.PHOTO_SUFFIX, ".JPEG", ".PNG"};
    private final String CRASH_LOG_NAME_PERIOD = "android-crashLog-";
    private String MAIN_DIR = PhoneConfig.applicationContext.getExternalFilesDir(null) + File.separator + UomConfig.HTTP_HEAD_PLATFORM;
    private String DCIM_DIR = Environment.getExternalStorageDirectory() + File.separator + "DCIM";
    private String MEDIA_DIR = this.DCIM_DIR + File.separator + UomConfig.HTTP_HEAD_PLATFORM;
    private String LOG_DIR = this.MAIN_DIR + File.separator + "Logs";
    private String FLIGHT_RECORD_DIR = this.MAIN_DIR + File.separator + "FlightRecords";
    private String FLIGHT_LOG_DIR = this.MAIN_DIR + File.separator + "FlightLog";
    private String THUMBNAIL_DIR = this.MAIN_DIR + File.separator + "thumbnail";
    private String GEO_DIR = this.MAIN_DIR + File.separator + "GeoLog";
    private String GPS_DIR = this.MAIN_DIR + File.separator + "GpsData";
    private volatile ArrayList<LocalFile> videoList = new ArrayList<>();
    private volatile ArrayList<LocalFile> videoListNoHead = new ArrayList<>();
    private volatile ArrayList<LocalFile> photoList = new ArrayList<>();
    private boolean isScanning = false;
    private OnResultListener<Boolean> scanningListener = null;

    public String getCrashLogNamePeriod() {
        return "android-crashLog-";
    }

    private LocalFileManager() {
        this.cacheDir = null;
        this.FW_DIR = this.MAIN_DIR + File.separator + "Firmware";
        this.HEADER_DIR = this.MAIN_DIR + File.separator + "Header";
        this.HEADER_IMAGE_PATH = this.HEADER_DIR + File.separator + "Header.jpg";
        this.PDF_DIR = this.MAIN_DIR + File.separator + "Pdfs";
        this.UPGRADE_DIR = this.MAIN_DIR + File.separator + "Upgrade";
        this.CACHE_DIR = this.MAIN_DIR + File.separator + "cache";
        this.cacheDir = PhoneConfig.applicationContext.getCacheDir().toString();
        this.FW_DIR = this.cacheDir + File.separator + "Firmware";
        this.HEADER_DIR = this.cacheDir + File.separator + "Header";
        this.HEADER_IMAGE_PATH = this.HEADER_DIR + File.separator + "Header.jpg";
        this.PDF_DIR = this.cacheDir + File.separator + "Pdfs";
        this.UPGRADE_DIR = this.cacheDir + File.separator + "Upgrade";
        this.CACHE_DIR = this.cacheDir + File.separator + "cache";
    }

    public static LocalFileManager getInstance() {
        if (instance == null) {
            synchronized (LocalFileManager.class) {
                if (instance == null) {
                    LocalFileManager localFileManager = new LocalFileManager();
                    instance = localFileManager;
                    return localFileManager;
                }
            }
        }
        return instance;
    }

    public void initExternalDir() {
        File file = new File(this.MAIN_DIR);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(this.FW_DIR);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(this.HEADER_DIR);
        if (!file3.exists()) {
            file3.mkdir();
        }
        File file4 = new File(this.LOG_DIR);
        if (!file4.exists()) {
            file4.mkdir();
        }
        File file5 = new File(this.PDF_DIR);
        if (!file5.exists()) {
            file5.mkdir();
        }
        File file6 = new File(this.FLIGHT_RECORD_DIR);
        if (!file6.exists()) {
            file6.mkdir();
        }
        File file7 = new File(this.UPGRADE_DIR);
        if (!file7.exists()) {
            file7.mkdir();
        }
        File file8 = new File(this.FLIGHT_LOG_DIR);
        if (!file8.exists()) {
            file8.mkdir();
        }
        File file9 = new File(this.THUMBNAIL_DIR);
        if (!file9.exists()) {
            file9.mkdir();
        }
        File file10 = new File(this.CACHE_DIR);
        if (!file10.exists()) {
            file10.mkdir();
        }
        File file11 = new File(this.GEO_DIR);
        if (!file11.exists()) {
            file11.mkdir();
        }
        if (LogSaveManager.getInstance().isRunning()) {
            return;
        }
        LogSaveManager.getInstance().start();
    }

    public void initMediaDir() {
        File file = new File(this.DCIM_DIR);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(this.MEDIA_DIR);
        if (!file2.exists()) {
            file2.mkdir();
        }
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.baselib.LocalFileManager.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LocalFileManager.this.scanVideos();
                LocalFileManager.this.scanPhotos();
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.LocalFileManager$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LocalFileManager.this.scanVideos();
            LocalFileManager.this.scanPhotos();
        }
    }

    public String getLogDir() {
        return this.LOG_DIR;
    }

    public String getFwDir() {
        return this.FW_DIR;
    }

    public String getPDF_DIR() {
        return this.PDF_DIR;
    }

    public String getFlightRecordDir() {
        return this.FLIGHT_RECORD_DIR;
    }

    public String getCacheDir() {
        return this.CACHE_DIR;
    }

    public String getGeoLogDir() {
        return this.GEO_DIR;
    }

    public String getGpsLogDir() {
        return this.GPS_DIR;
    }

    public ArrayList<LocalFile> getVideoList() {
        return this.videoList;
    }

    public ArrayList<LocalFile> getVideoListNoHead() {
        return this.videoListNoHead;
    }

    public ArrayList<LocalFile> getPhotoList() {
        return this.photoList;
    }

    public String getUpgradeDir() {
        return this.UPGRADE_DIR;
    }

    public String getFlightLogDir() {
        return this.FLIGHT_LOG_DIR;
    }

    public String getThumbnailDir() {
        return this.THUMBNAIL_DIR;
    }

    public String getMediaDir() {
        return this.MEDIA_DIR;
    }

    public void clearOldLogFile() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - 7776000000L;
            File file = new File(this.FLIGHT_LOG_DIR);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.lastModified() < currentTimeMillis) {
                        DDLog.e("file delete:" + file2.lastModified() + ",old time:" + currentTimeMillis);
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void clearThumbnails() {
        try {
            File file = new File(this.THUMBNAIL_DIR);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void clearCacheDir() {
        try {
            DDLog.e("\u6e05\u9664\u7f13\u5b58");
            File file = new File(this.CACHE_DIR);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void scanVideos() {
        boolean z;
        File file = new File(getMediaDir());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            this.videoList.clear();
            this.videoListNoHead.clear();
            if (listFiles != null) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.ipotensic.baselib.LocalFileManager.2
                    AnonymousClass2() {
                    }

                    @Override // java.util.Comparator
                    public int compare(File file2, File file3) {
                        long lastModified = file2.lastModified();
                        long lastModified2 = file3.lastModified();
                        if (lastModified > lastModified2) {
                            return -1;
                        }
                        return lastModified < lastModified2 ? 1 : 0;
                    }
                });
                long j = 0;
                int i = -1;
                int i2 = 0;
                for (File file2 : listFiles) {
                    String[] strArr = this.VIDEO_SUFFIX;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        if (file2.getName().toLowerCase().endsWith(strArr[i3].toLowerCase())) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (file2.getName().contains("trash")) {
                        z = false;
                    }
                    if (z) {
                        long length2 = file2.length();
                        long lastModified = file2.lastModified();
                        long videoDuration = getVideoDuration(file2.getAbsolutePath());
                        if (videoDuration != -1) {
                            if (!DateUtils.isSameDay(j, lastModified)) {
                                this.videoList.add(new LocalFile(FileTypeEnum.TYPE_HEAD, lastModified));
                                if (i != -1 && i < this.videoList.size()) {
                                    this.videoList.get(i).setChildNum(i2);
                                }
                                i = this.videoList.size() - 1;
                                i2 = 0;
                            }
                            LocalFile localFile = new LocalFile(FileTypeEnum.TYPE_VIDEO, file2.getAbsolutePath(), length2, videoDuration, lastModified);
                            this.videoList.add(localFile);
                            this.videoListNoHead.add(localFile);
                            i2++;
                            j = lastModified;
                        }
                    }
                }
                if (i != -1) {
                    this.videoList.get(i).setChildNum(i2);
                }
            }
        }
    }

    /* renamed from: com.ipotensic.baselib.LocalFileManager$2 */
    class AnonymousClass2 implements Comparator<File> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(File file2, File file3) {
            long lastModified = file2.lastModified();
            long lastModified2 = file3.lastModified();
            if (lastModified > lastModified2) {
                return -1;
            }
            return lastModified < lastModified2 ? 1 : 0;
        }
    }

    public void sortChildNum(List<Long> list) throws Exception {
        if (this.videoList != null) {
            DDLog.e("video \u6392\u5e8f");
            for (int i = 0; i < this.videoList.size(); i++) {
                LocalFile localFile = this.videoList.get(i);
                if (localFile.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                    boolean z = false;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (localFile.getCreateTime() == list.get(i2).longValue()) {
                            z = true;
                        }
                    }
                    if (z) {
                        int i3 = -1;
                        for (int i4 = 0; i4 < this.videoList.size(); i4++) {
                            if (DateUtils.isSameDay(localFile.getCreateTime(), this.videoList.get(i4).getCreateTime())) {
                                i3++;
                            }
                        }
                        this.videoList.get(i).setChildNum(i3);
                    }
                }
            }
        }
        DDLog.e("photo \u6392\u5e8f");
        if (this.photoList != null) {
            for (int i5 = 0; i5 < this.photoList.size(); i5++) {
                LocalFile localFile2 = this.photoList.get(i5);
                if (localFile2.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                    boolean z2 = false;
                    for (int i6 = 0; i6 < list.size(); i6++) {
                        if (localFile2.getCreateTime() == list.get(i6).longValue()) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        int i7 = -1;
                        for (int i8 = 0; i8 < this.photoList.size(); i8++) {
                            if (DateUtils.isSameDay(localFile2.getCreateTime(), this.photoList.get(i8).getCreateTime())) {
                                i7++;
                            }
                        }
                        this.photoList.get(i5).setChildNum(i7);
                    }
                }
            }
        }
        DDLog.e(" \u6392\u5e8f\u5b8c\u6210");
    }

    public LocalFile getLocalFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        String[] strArr = this.VIDEO_SUFFIX;
        int length = strArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (file.getName().toLowerCase().endsWith(strArr[i].toLowerCase())) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return null;
        }
        return new LocalFile(FileTypeEnum.TYPE_VIDEO, str, file.length(), getVideoDuration(file.getAbsolutePath()), file.lastModified());
    }

    public String saveHeaderBitmap(Bitmap bitmap, String str) {
        try {
            File file = new File(this.HEADER_DIR);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(this.HEADER_IMAGE_PATH);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            ExifInterface exifInterface = new ExifInterface(this.HEADER_IMAGE_PATH);
            exifInterface.setAttribute("Make", str);
            exifInterface.saveAttributes();
            return file2.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> get12HoursLogs() {
        File[] listFiles;
        long currentTimeMillis = System.currentTimeMillis() - 43200000;
        File file = new File(this.LOG_DIR);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (File file2 : listFiles) {
            if (file2.isFile() && file2.lastModified() > currentTimeMillis) {
                arrayList.add(file2.getAbsolutePath());
            }
        }
        return arrayList;
    }

    public String getHeadImageDescription() throws IOException {
        if (new File(this.HEADER_IMAGE_PATH).exists()) {
            return new ExifInterface(this.HEADER_IMAGE_PATH).getAttribute("Make");
        }
        return null;
    }

    public String getHeadImageLocalPath() {
        return this.HEADER_IMAGE_PATH;
    }

    public synchronized void scanPhotos() {
        boolean z;
        File file = new File(getMediaDir());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.ipotensic.baselib.LocalFileManager.3
                    AnonymousClass3() {
                    }

                    @Override // java.util.Comparator
                    public int compare(File file2, File file3) {
                        long lastModified = file2.lastModified();
                        long lastModified2 = file3.lastModified();
                        if (lastModified > lastModified2) {
                            return -1;
                        }
                        return lastModified < lastModified2 ? 1 : 0;
                    }
                });
                this.photoList.clear();
                int length = listFiles.length;
                long j = 0;
                long j2 = 0;
                int i = -1;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    String[] strArr = this.PHOTO_SUFFIX;
                    int length2 = strArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            z = false;
                            break;
                        }
                        String str = strArr[i4];
                        if (file2.length() != j && file2.getName().toLowerCase().endsWith(str.toLowerCase())) {
                            z = true;
                            break;
                        } else {
                            i4++;
                            j = 0;
                        }
                    }
                    if (file2.getName().contains("trash")) {
                        z = false;
                    }
                    if (z) {
                        long length3 = file2.length();
                        long lastModified = file2.lastModified();
                        if (!DateUtils.isSameDay(j2, lastModified)) {
                            this.photoList.add(new LocalFile(FileTypeEnum.TYPE_HEAD, lastModified));
                            if (i != -1 && i < this.photoList.size()) {
                                this.photoList.get(i).setChildNum(i3);
                            }
                            i = this.photoList.size() - 1;
                            i3 = 0;
                        }
                        this.photoList.add(new LocalFile(FileTypeEnum.TYPE_PHOTO, file2.getAbsolutePath(), length3, lastModified));
                        i3++;
                        j2 = lastModified;
                    }
                    i2++;
                    j = 0;
                }
                if (i != -1) {
                    this.photoList.get(i).setChildNum(i3);
                }
            }
        }
    }

    /* renamed from: com.ipotensic.baselib.LocalFileManager$3 */
    class AnonymousClass3 implements Comparator<File> {
        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        public int compare(File file2, File file3) {
            long lastModified = file2.lastModified();
            long lastModified2 = file3.lastModified();
            if (lastModified > lastModified2) {
                return -1;
            }
            return lastModified < lastModified2 ? 1 : 0;
        }
    }

    public boolean deleteFile(LocalFile localFile) {
        File file = new File(localFile.getAbsPath());
        if (!file.exists()) {
            return true;
        }
        boolean delete = file.delete();
        MediaScannerConnection.scanFile(PhoneConfig.applicationContext, new String[]{localFile.getAbsPath()}, null, null);
        return delete;
    }

    public void deleteFiles(BaseActivity baseActivity, ArrayList<LocalFile> arrayList, MediaFileUtils.OnDeleteResultListener onDeleteResultListener) {
        if (Build.VERSION.SDK_INT >= 30) {
            ArrayList arrayList2 = new ArrayList();
            FileTypeEnum fileTypeEnum = FileTypeEnum.TYPE_PHOTO;
            Iterator<LocalFile> it = arrayList.iterator();
            while (it.hasNext()) {
                LocalFile next = it.next();
                if (fileTypeEnum != FileTypeEnum.TYPE_HEAD) {
                    fileTypeEnum = next.getFileTypeEnum();
                }
                if (new File(next.getAbsPath()).exists()) {
                    arrayList2.add(next.getAbsPath());
                }
            }
            if (fileTypeEnum == FileTypeEnum.TYPE_PHOTO) {
                MediaFileUtils.deleteImageForAndroid11(baseActivity, arrayList2, onDeleteResultListener);
            } else if (fileTypeEnum == FileTypeEnum.TYPE_VIDEO) {
                MediaFileUtils.deleteVideoForAndroid11(baseActivity, arrayList2, onDeleteResultListener);
            }
        }
    }

    public long getVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e) {
                DDLog.e("\u83b7\u53d6\u89c6\u9891\u4fe1\u606f\u51fa\u9519 \uff1a" + e.getMessage());
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused) {
                }
                return -1L;
            }
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException unused2) {
            }
        }
    }

    public void setScanningListener(OnResultListener<Boolean> onResultListener) {
        this.scanningListener = onResultListener;
    }

    public boolean isScanning() {
        return this.isScanning;
    }

    /* renamed from: com.ipotensic.baselib.LocalFileManager$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocalFileManager.class) {
                LocalFileManager.this.isScanning = true;
                DDLog.e("\u5f00\u59cb\u626b\u63cf\u5a92\u4f53\u6587\u4ef6");
                LocalFileManager.this.scanVideos();
                DDLog.e("\u5a92\u4f53\u89c6\u9891\u626b\u63cf\u5b8c\u6210");
                LocalFileManager.this.scanPhotos();
                DDLog.e("\u5a92\u4f53\u56fe\u7247\u626b\u63cf\u5b8c\u6210");
                EventDispatcher.get().sendEvent(EventID.EVENT_MEDIA_FILE_UPDATE);
                LocalFileManager.this.isScanning = false;
                if (LocalFileManager.this.scanningListener != null) {
                    LocalFileManager.this.scanningListener.onSuccess(true);
                    LocalFileManager.this.scanningListener = null;
                }
            }
        }
    }

    public void scanAlbum(OnResultListener<Boolean> onResultListener) {
        this.scanningListener = onResultListener;
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.baselib.LocalFileManager.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (LocalFileManager.class) {
                    LocalFileManager.this.isScanning = true;
                    DDLog.e("\u5f00\u59cb\u626b\u63cf\u5a92\u4f53\u6587\u4ef6");
                    LocalFileManager.this.scanVideos();
                    DDLog.e("\u5a92\u4f53\u89c6\u9891\u626b\u63cf\u5b8c\u6210");
                    LocalFileManager.this.scanPhotos();
                    DDLog.e("\u5a92\u4f53\u56fe\u7247\u626b\u63cf\u5b8c\u6210");
                    EventDispatcher.get().sendEvent(EventID.EVENT_MEDIA_FILE_UPDATE);
                    LocalFileManager.this.isScanning = false;
                    if (LocalFileManager.this.scanningListener != null) {
                        LocalFileManager.this.scanningListener.onSuccess(true);
                        LocalFileManager.this.scanningListener = null;
                    }
                }
            }
        });
    }

    public void deleteOldLogFiles(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.isFile() && file2.getName().contains(LOG_TAIL) && System.currentTimeMillis() - file2.lastModified() > 2592000000L) {
                    DDLog.e("file delete1:" + file2.lastModified() + ",old time:" + System.currentTimeMillis());
                    file2.delete();
                }
            }
        }
    }
}