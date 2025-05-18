package com.ipotensic.potensicpro.utils;

import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.camera.CameraActivity;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.views.dailog.CustomPermissionDialog;
import com.ipotensic.potensicpro.C2640R;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* loaded from: classes2.dex */
public class PhotoChooserUtil {
    public static final String PHOTO = "photo";
    public static final String VIDEO = "video";
    private String cachPath;
    private File cacheFile;
    private File cameraFile;
    private AppCompatActivity context;
    private String filePath;
    private Uri imageUri;
    private PermissionListener mListener;
    private OnChooseListener onChooseListener;
    private File videoFile;
    private String videoThumbPath;
    private Uri videoUri;
    private final int TAKE_PHOTO = 1;
    private final int CHOOSE_PHOTO = 2;
    private final int CHOOSE_PHOTO_NO_CROP = 3;
    private final int CROP_PHOTO = 4;
    private final int RECORD_VIDEO = 5;
    private final int CHOOSE_PHOTO_AND_VIDEO = 6;
    private boolean isLocalVideo = false;
    private final String[] photoFormat = {"bmp", ContentTypes.EXTENSION_JPG_1, ContentTypes.EXTENSION_JPG_2, ContentTypes.EXTENSION_PNG, "webp"};
    private final String[] VideoFormat = {"mp4", "avi", "rmvb", "wmv", "flv", "mov", "mkv"};
    private final int REQUEST_CAMERA_CODE = 101;
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                String str2 = (String) message.obj;
                if (PhotoChooserUtil.this.onChooseListener != null) {
                    PhotoChooserUtil.this.onChooseListener.onChooseImage(str2);
                    return;
                }
                return;
            }
            if (i == 3) {
                String str3 = (String) message.obj;
                if (PhotoChooserUtil.this.onChooseListener == null || str3 == null) {
                    return;
                }
                PhotoChooserUtil.this.onChooseListener.onChooseNoCrop(PhotoChooserUtil.PHOTO, str3);
                return;
            }
            if (i == 4) {
                String str4 = (String) message.obj;
                if (str4 != null) {
                    if (Arrays.asList(PhotoChooserUtil.this.photoFormat).contains(str4.substring(str4.length() - 3).toLowerCase()) && PhotoChooserUtil.this.onChooseListener != null) {
                        PhotoChooserUtil.this.onChooseListener.onChooseNoCrop(PhotoChooserUtil.PHOTO, str4);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 5 && (str = (String) message.obj) != null) {
                if (Arrays.asList(PhotoChooserUtil.this.VideoFormat).contains(str.substring(str.length() - 3).toLowerCase()) && PhotoChooserUtil.this.onChooseListener != null) {
                    if (PhotoChooserUtil.this.getFileSize(str)) {
                        PhotoChooserUtil.this.onChooseListener.onVideoResult(str);
                        PhotoChooserUtil.this.onChooseListener.onChooseNoCrop("video", PhotoChooserUtil.this.getVideoThumbnail(str));
                    } else {
                        PhotoChooserUtil.this.onChooseListener.onFileTooBig();
                    }
                }
            }
        }
    };

    public interface OnChooseListener {
        void onChooseCropResult(Bitmap bitmap);

        void onChooseImage(String str);

        void onChooseNoCrop(String str, String str2);

        void onFileTooBig();

        void onVideoResult(String str);
    }

    public interface PermissionListener {
        void onDenied(List<String> list);

        void onGranted();
    }

    public PhotoChooserUtil(AppCompatActivity appCompatActivity, OnChooseListener onChooseListener) {
        this.onChooseListener = onChooseListener;
        this.context = appCompatActivity;
        this.cachPath = getDiskCacheDir(appCompatActivity) + "/crop_image.jpg";
        this.cacheFile = getCacheFile(new File(getDiskCacheDir(appCompatActivity)), "crop_image.jpg");
    }

    public void takePhotoForCamera() {
        if (Build.VERSION.SDK_INT >= 23) {
            requestRuntimePermission(0, PermissionUtil.MEDIA_AND_CAMERA_PERMISSION, new PermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.1
                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onGranted() {
                    PhotoChooserUtil.this.openCamera();
                }

                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onDenied(List<String> list) {
                    DDLog.m1684e("权限被拒绝");
                }
            });
        } else {
            openCamera();
        }
    }

    public void takePhotoForAlbum(final boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            requestRuntimePermission(1, PermissionUtil.MEDIA_PERMISSION, new PermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.2
                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onDenied(List<String> list) {
                }

                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onGranted() {
                    PhotoChooserUtil.this.openAlbum(z);
                }
            });
        } else {
            openAlbum(z);
        }
    }

    public void photoAndVideoForAlbum() {
        if (Build.VERSION.SDK_INT >= 23) {
            requestRuntimePermission(1, PermissionUtil.MEDIA_PERMISSION, new PermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.3
                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onDenied(List<String> list) {
                }

                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onGranted() {
                    PhotoChooserUtil.this.openAlbum2();
                }
            });
        } else {
            openAlbum2();
        }
    }

    public void recordVideoForCamera(final int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            requestRuntimePermission(2, PermissionUtil.MEDIA_AND_RECORD_PERMISSION, new PermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.4
                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onGranted() {
                    PhotoChooserUtil.this.openVideo(i);
                }

                @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.PermissionListener
                public void onDenied(List<String> list) {
                    DDLog.m1684e("权限被拒绝");
                }
            });
        } else {
            openVideo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAlbum(boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(ShareContentType.IMAGE);
        this.context.startActivityForResult(intent, z ? 2 : 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAlbum2() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(ShareContentType.FILE);
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{ShareContentType.IMAGE, ShareContentType.VIDEO});
            DDLog.m1684e("----打开系统图库-----");
            this.context.startActivityForResult(intent, 6);
        } catch (Exception e) {
            DDLog.m1684e("----打开系统图库异常-----" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera() {
        this.cameraFile = getCacheFile(new File(getDiskCacheDir(this.context)), "output_image" + System.currentTimeMillis() + ".jpg");
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT < 24) {
            this.imageUri = Uri.fromFile(this.cameraFile);
        } else {
            intent.addFlags(1);
            this.imageUri = FileProvider.getUriForFile(this.context, PhoneConfig.fileProviderAuthority, this.cameraFile);
        }
        intent.putExtra("output", this.imageUri);
        this.context.startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo(final int i) {
        this.videoFile = getCacheFile(new File(getDiskCacheDir(this.context)), "output_video" + System.currentTimeMillis() + ".mp4");
        ActivityHelper.getInstance().makeActivityOnlyOne(CameraActivity.class, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.5
            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public void onResult(Boolean bool) {
                Intent intent = new Intent(PhotoChooserUtil.this.context, (Class<?>) CameraActivity.class);
                intent.putExtra("type", i);
                PhotoChooserUtil.this.context.startActivityForResult(intent, 101);
            }
        });
    }

    private String getDiskCacheDir(Context context) {
        return context.getCacheDir().getPath();
    }

    private File getCacheFile(File file, String str) {
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file2;
    }

    private void requestRuntimePermission(final int i, String[] strArr, PermissionListener permissionListener) {
        this.mListener = permissionListener;
        if (PermissionUtil.hasPermission(this.context, strArr)) {
            this.mListener.onGranted();
            return;
        }
        String string = this.context.getString(C2640R.string.button_refuse);
        String string2 = this.context.getString(C2640R.string.button_allow);
        if (!SPHelper.getInstance().getBoolean("key_is_first_camera_and_storage_permission_show", false)) {
            SPHelper.getInstance().putBoolean("key_is_first_camera_and_storage_permission_show", true);
        } else {
            string = this.context.getString(C2640R.string.dialog_cancel);
            string2 = this.context.getString(C2640R.string.dialog_location_confirm);
        }
        AppCompatActivity appCompatActivity = this.context;
        String string3 = appCompatActivity.getString(C2640R.string.feedback_or_avatar_upload_camera_and_photos_access_title);
        String string4 = this.context.getString(C2640R.string.feedback_or_avatar_upload_camera_and_photos_access_tips);
        new CustomPermissionDialog(appCompatActivity, string3, string4, string, string2, new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.6
            @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
            public void grantPermission() {
                int i2 = i;
                if (i2 == 0) {
                    PermissionUtil.requestCameraAndStoragePermission(PhotoChooserUtil.this.context, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.6.1
                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDenied() {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDeniedWithNeverAsk(String... strArr2) {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onGrant() {
                            PhotoChooserUtil.this.mListener.onGranted();
                        }
                    });
                } else if (i2 == 1) {
                    PermissionUtil.requestStoragePermission(PhotoChooserUtil.this.context, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.6.2
                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDenied() {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDeniedWithNeverAsk(String... strArr2) {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onGrant() {
                            PhotoChooserUtil.this.mListener.onGranted();
                        }
                    });
                } else if (i2 == 2) {
                    PermissionUtil.requestCameraAndAudioAndStoragePermission(PhotoChooserUtil.this.context, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.6.3
                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDenied() {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDeniedWithNeverAsk(String... strArr2) {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onGrant() {
                            PhotoChooserUtil.this.mListener.onGranted();
                        }
                    });
                }
            }
        }).show();
    }

    private void handleImageOnKitKat(Intent intent) {
        Log.d("TAG", "handleImageOnKitKat: uri is " + intent.getData());
    }

    private void uriToPath(final Uri uri, final int i) {
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.8
            @Override // java.lang.Runnable
            public void run() {
                long parseLong;
                String imagePath;
                try {
                    String str = null;
                    if (DocumentsContract.isDocumentUri(PhotoChooserUtil.this.context, uri)) {
                        String authority = uri.getAuthority();
                        String documentId = DocumentsContract.getDocumentId(uri);
                        DDLog.m1685e("反馈", "图片authority： " + authority + ", docId = " + documentId);
                        if ("com.android.providers.media.documents".equals(authority)) {
                            imagePath = PhotoChooserUtil.this.getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
                        } else if ("com.android.providers.downloads.documents".equals(authority)) {
                            try {
                                parseLong = Long.parseLong(documentId);
                            } catch (Exception unused) {
                                parseLong = Long.parseLong(documentId.split(":")[1]);
                            }
                            imagePath = PhotoChooserUtil.this.getImagePath(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), parseLong), null);
                        } else if ("com.android.externalstorage.documents".equals(authority)) {
                            String[] split = documentId.split(":");
                            String str2 = split[0];
                            if ("primary".equalsIgnoreCase(str2)) {
                                imagePath = Environment.getExternalStorageDirectory() + InternalZipConstants.ZIP_FILE_SEPARATOR + split[1];
                            } else if (Build.VERSION.SDK_INT > 19) {
                                File[] externalMediaDirs = PhotoChooserUtil.this.context.getExternalMediaDirs();
                                if (externalMediaDirs.length > 1) {
                                    str = externalMediaDirs[1].getAbsolutePath().substring(0, PhotoChooserUtil.this.filePath.indexOf("Android")) + split[1];
                                }
                            } else {
                                imagePath = "/storage/" + str2 + InternalZipConstants.ZIP_FILE_SEPARATOR + split[1];
                            }
                        }
                        str = imagePath;
                    } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                        str = PhotoChooserUtil.this.getImagePath(uri, null);
                    } else if (StringLookupFactory.KEY_FILE.equalsIgnoreCase(uri.getScheme())) {
                        str = uri.getPath();
                    }
                    DDLog.m1685e("反馈", " 照片 path = " + str);
                    PhotoChooserUtil.this.handler.sendMessage(PhotoChooserUtil.this.handler.obtainMessage(i, str));
                } catch (Exception unused2) {
                }
            }
        }).start();
    }

    private void uriToVideoPath(final Uri uri, final int i) {
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.utils.PhotoChooserUtil.9
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String str2 = null;
                if (DocumentsContract.isDocumentUri(PhotoChooserUtil.this.context, uri)) {
                    String authority = uri.getAuthority();
                    String documentId = DocumentsContract.getDocumentId(uri);
                    DDLog.m1685e("反馈", "authority： " + authority + ", docId = " + documentId);
                    if ("com.android.providers.media.documents".equals(authority)) {
                        String str3 = "_id=" + documentId.split(":")[1];
                        DDLog.m1684e("-------打开图库selection---------: " + str3);
                        str = PhotoChooserUtil.this.getVideoPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, str3);
                    } else if ("com.android.providers.downloads.documents".equals(authority)) {
                        str = PhotoChooserUtil.this.getVideoPath(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null);
                    } else if ("com.android.externalstorage.documents".equals(authority)) {
                        String[] split = documentId.split(":");
                        String str4 = split[0];
                        if ("primary".equalsIgnoreCase(str4)) {
                            str = Environment.getExternalStorageDirectory() + InternalZipConstants.ZIP_FILE_SEPARATOR + split[1];
                        } else if (Build.VERSION.SDK_INT > 19) {
                            File[] externalMediaDirs = PhotoChooserUtil.this.context.getExternalMediaDirs();
                            if (externalMediaDirs.length > 1) {
                                str2 = externalMediaDirs[1].getAbsolutePath().substring(0, PhotoChooserUtil.this.filePath.indexOf("Android")) + split[1];
                            }
                        } else {
                            str = "/storage/" + str4 + InternalZipConstants.ZIP_FILE_SEPARATOR + split[1];
                        }
                    }
                    str2 = str;
                } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                    str2 = PhotoChooserUtil.this.getVideoPath(uri, null);
                } else if (StringLookupFactory.KEY_FILE.equalsIgnoreCase(uri.getScheme())) {
                    str2 = uri.getPath();
                }
                DDLog.m1685e("反馈", " 视频 path = " + str2);
                PhotoChooserUtil.this.handler.sendMessage(PhotoChooserUtil.this.handler.obtainMessage(i, str2));
            }
        }).start();
    }

    private void handleImageBeforeKitKat(Intent intent) {
        Uri data = intent.getData();
        String imagePath = getImagePath(data, null);
        Log.i("TAG", "file://" + imagePath + "选择图片的URI" + data);
        startPhotoZoom(new File(imagePath), FTPReply.FILE_ACTION_PENDING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getImagePath(Uri uri, String str) {
        Cursor query = this.context.getContentResolver().query(uri, null, str, null, null);
        if (query != null) {
            r9 = query.moveToFirst() ? query.getString(query.getColumnIndex("_data")) : null;
            query.close();
        }
        return r9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVideoPath(Uri uri, String str) {
        Cursor query = this.context.getContentResolver().query(uri, null, str, null, null);
        if (query != null) {
            r9 = query.moveToFirst() ? query.getString(query.getColumnIndex("_data")) : null;
            query.close();
        }
        return r9;
    }

    private void startPhotoZoom(File file, int i) {
        DDLog.m1687i(getImageContentUri(this.context, file) + "裁剪照片的真实地址");
        try {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(getImageContentUri(this.context, file), ShareContentType.IMAGE);
            intent.putExtra("crop", BooleanUtils.TRUE);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 250);
            intent.putExtra("outputY", 250);
            intent.putExtra(RtspHeaders.SCALE, true);
            intent.putExtra("return-data", false);
            intent.putExtra("output", Uri.fromFile(this.cacheFile));
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            intent.putExtra("noFaceDetection", true);
            this.context.startActivityForResult(intent, 4);
        } catch (ActivityNotFoundException unused) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Uri getImageContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null && query.moveToFirst()) {
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + query.getInt(query.getColumnIndex("_id")));
        }
        if (!file.exists()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1 && iArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                String str = strArr[i2];
                if (i3 != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                this.mListener.onGranted();
            } else {
                this.mListener.onDenied(arrayList);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 0) {
            return;
        }
        if (i == 1) {
            if (i2 == -1) {
                try {
                    OnChooseListener onChooseListener = this.onChooseListener;
                    if (onChooseListener != null) {
                        onChooseListener.onChooseImage(this.cameraFile.getAbsolutePath());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            if (i2 == -1) {
                Uri data = intent.getData();
                Log.d("TAG", "handleImageOnKitKat: uri is " + data);
                if (Build.VERSION.SDK_INT >= 19) {
                    uriToPath(data, 2);
                    return;
                }
                String imagePath = getImagePath(data, null);
                OnChooseListener onChooseListener2 = this.onChooseListener;
                if (onChooseListener2 != null) {
                    onChooseListener2.onChooseImage(imagePath);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 3) {
            if (i2 == -1) {
                if (Build.VERSION.SDK_INT >= 19) {
                    uriToPath(intent.getData(), 3);
                    return;
                }
                String imagePath2 = getImagePath(intent.getData(), null);
                OnChooseListener onChooseListener3 = this.onChooseListener;
                if (onChooseListener3 != null) {
                    onChooseListener3.onChooseNoCrop(PHOTO, imagePath2);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            if (i2 == -1) {
                try {
                    BitmapFactory.decodeStream(this.context.getContentResolver().openInputStream(Uri.fromFile(this.cacheFile)));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (i != 6) {
            if (i != 101) {
                return;
            }
            if (i2 != 101) {
                if (i2 == 100) {
                    String stringExtra = intent.getStringExtra("path");
                    DDLog.m1691w("firstFramePath:" + stringExtra);
                    OnChooseListener onChooseListener4 = this.onChooseListener;
                    if (onChooseListener4 == null || stringExtra == null) {
                        return;
                    }
                    onChooseListener4.onChooseNoCrop(PHOTO, stringExtra);
                    return;
                }
                return;
            }
            String stringExtra2 = intent.getStringExtra("firstFrame");
            String stringExtra3 = intent.getStringExtra("videoPath");
            DDLog.m1691w("firstFramePath:" + stringExtra2);
            DDLog.m1691w("videoPath:" + stringExtra3);
            if (this.onChooseListener != null) {
                if (getFileSize(stringExtra3)) {
                    this.onChooseListener.onVideoResult(stringExtra3);
                    this.onChooseListener.onChooseNoCrop("video", stringExtra2);
                    return;
                } else {
                    this.onChooseListener.onFileTooBig();
                    return;
                }
            }
            return;
        }
        if (i2 == -1) {
            Uri data2 = intent.getData();
            DDLog.m1685e("反馈", "uri = " + data2);
            if (data2 != null) {
                String lowerCase = data2.toString().toLowerCase();
                if (lowerCase.contains("video")) {
                    uriToVideoPath(data2, 5);
                    return;
                }
                if (lowerCase.toLowerCase().contains("image")) {
                    uriToPath(data2, 4);
                    return;
                }
                String[] strArr = this.VideoFormat;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (lowerCase.contains(strArr[i3])) {
                        DDLog.m1685e("反馈", "视频url ： " + lowerCase);
                        uriToVideoPath(data2, 5);
                        break;
                    }
                    i3++;
                }
                for (String str : this.photoFormat) {
                    if (lowerCase.contains(str)) {
                        DDLog.m1685e("反馈", "图片url ： " + lowerCase);
                        uriToPath(data2, 4);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVideoThumbnail(String str) {
        String fromBitmapGetFilePath = FileUtil.fromBitmapGetFilePath(ThumbnailUtils.createVideoThumbnail(str, 1));
        this.videoThumbPath = fromBitmapGetFilePath;
        return fromBitmapGetFilePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getFileSize(String str) {
        if (str != null) {
            FileInputStream fileInputStream = null;
            try {
                File file = new File(str);
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        int available = fileInputStream2.available();
                        DDLog.m1685e("size", "视频文件大小size: " + ((available / 1024) / 1024));
                        fileInputStream2.close();
                        return available <= 104857600;
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return false;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }
}