package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.FileSystemChangeListener;
import com.ipotensic.baselib.utils.MediaFileUtils;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.views.dailog.PermissionDialog;
import com.ipotensic.kernel.activitys.VideoViewerPortActivity;
import com.ipotensic.kernel.adapter.MyGridLayoutManager;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.view.dialog.DeleteMediaDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.mediagallery.AlbumShowRvAdapter;
import com.ipotensic.mediagallery.DividerGridItemDecoration;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.TopTabView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MainMediaController extends BaseController implements AlbumShowRvAdapter.OnRecyclerViewItemClickListener {
    public final int REQUEST_CODE_REFRESH_PHOTO;
    public final int REQUEST_CODE_REFRESH_VIDEO;
    private AlbumShowRvAdapter albumShowRvAdapter;
    private ImageButton btnCloseNoPermissionTips;
    private ImageButton btnDelete;
    private ImageButton btnShare;
    private FileSystemChangeListener fileChangedListener;
    private String filePath;
    private GridLayoutManager gridLayoutManager;
    private boolean hasStoragePermissionOnPause;
    private ImageView imgNone;
    private boolean isFileChange;
    private boolean isNeverShowNoPermissionTips;
    private boolean isUserPause;
    private RelativeLayout layoutBottom;
    private LinearLayout layoutNoPermission;
    private MediaControllerListener mediaControllerListener;
    private int mode;
    private RecyclerView recyclerView;
    private TextView tvGoSetting;
    private TextView tvSelect;
    private ArrayList<Uri> urls;

    public interface MediaControllerListener {
        void setSelectUI(boolean z);
    }

    public MainMediaController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.mode = 0;
        this.REQUEST_CODE_REFRESH_VIDEO = 98;
        this.REQUEST_CODE_REFRESH_PHOTO = 99;
        this.urls = new ArrayList<>();
        this.isNeverShowNoPermissionTips = false;
        this.hasStoragePermissionOnPause = true;
        this.isUserPause = false;
        this.isFileChange = false;
        if (this.fileChangedListener == null) {
            FileSystemChangeListener fileSystemChangeListener = new FileSystemChangeListener(LocalFileManager.getInstance().getMediaDir(), new FileSystemChangeListener.OnFileChangeListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.1
                @Override // com.ipotensic.baselib.utils.FileSystemChangeListener.OnFileChangeListener
                public void onFileChanged() {
                    DDLog.e("\u6587\u4ef6\u53d8\u52a8........");
                    if (MainMediaController.this.isUserPause) {
                        MainMediaController.this.isFileChange = true;
                    }
                }
            });
            this.fileChangedListener = fileSystemChangeListener;
            fileSystemChangeListener.startWatching();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.layoutBottom = (RelativeLayout) view.findViewById(R.id.layout_bottom);
        this.tvGoSetting = (TextView) view.findViewById(R.id.tv_go_setting);
        this.layoutNoPermission = (LinearLayout) view.findViewById(R.id.layout_no_permission);
        this.btnCloseNoPermissionTips = (ImageButton) view.findViewById(R.id.btn_close_no_permission);
        this.imgNone = (ImageView) view.findViewById(R.id.img_none);
        TextView textView = (TextView) view.findViewById(R.id.tv_select);
        this.tvSelect = textView;
        textView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMediaController.this.setSelectUI(!r2.albumShowRvAdapter.isSelectMode());
                MainMediaController.this.checkAllDelete();
            }
        });
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_share);
        this.btnShare = imageButton;
        imageButton.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.potensicpro.activities.MainMediaController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMediaController.this.share();
            }
        });
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btn_delete);
        this.btnDelete = imageButton2;
        imageButton2.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMediaController.this.delete();
            }
        });
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.albumShowRvAdapter = new AlbumShowRvAdapter((BaseActivity) getContext());
        MyGridLayoutManager myGridLayoutManager = new MyGridLayoutManager(getContext(), 3);
        this.gridLayoutManager = myGridLayoutManager;
        this.recyclerView.setLayoutManager(myGridLayoutManager);
        this.gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (MainMediaController.this.albumShowRvAdapter.getItemViewType(i) == 0) {
                    return MainMediaController.this.gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
        this.recyclerView.setAdapter(this.albumShowRvAdapter);
        this.recyclerView.addItemDecoration(new DividerGridItemDecoration(getContext(), this.albumShowRvAdapter));
        this.albumShowRvAdapter.setOnItemClickListener(this);
        ((TopTabView) view.findViewById(R.id.view_top_tab)).setTabs(new TopTabView.OnTopIndicatorChangeListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.6
            @Override // com.ipotensic.potensicpro.view.TopTabView.OnTopIndicatorChangeListener
            public void onIndicatorChanged(int i) {
                DDLog.e("onIndicatorChanged");
                if (MainMediaController.this.albumShowRvAdapter.isSelectMode()) {
                    MainMediaController.this.setSelectUI(false);
                }
                MainMediaController.this.mode = i;
                if (i == 0) {
                    MainMediaController.this.albumShowRvAdapter.updateAdapterList(LocalFileManager.getInstance().getVideoList());
                } else {
                    MainMediaController.this.albumShowRvAdapter.updateAdapterList(LocalFileManager.getInstance().getPhotoList());
                }
                MainMediaController.this.checkNone();
            }
        }, getContext().getString(R.string.videos), getContext().getString(R.string.photos));
    }

    private void showNoPermissionTips() {
        try {
            if (this.isNeverShowNoPermissionTips) {
                return;
            }
            this.tvGoSetting.setOnClickListener(new AnonymousClass7());
            this.layoutNoPermission.setVisibility(0);
            this.btnCloseNoPermissionTips.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.8
                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    MainMediaController.this.isNeverShowNoPermissionTips = true;
                    MainMediaController.this.layoutNoPermission.setVisibility(8);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaController$7, reason: invalid class name */
    class AnonymousClass7 extends ScaleClickListener {
        AnonymousClass7() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            new PermissionDialog(MainMediaController.this.getContext(), MainMediaController.this.getContext().getString(R.string.android_allow_system_album_to_your_photos_for_saving_and_browsing_title), MainMediaController.this.getContext().getString(R.string.android_allow_system_album_to_your_photos_for_saving_and_browsing_tips), MainMediaController.this.getContext().getString(R.string.dialog_cancel), MainMediaController.this.getContext().getString(R.string.dialog_location_confirm), new PermissionDialog.OnGrantListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.7.1
                @Override // com.ipotensic.baselib.views.dailog.PermissionDialog.OnGrantListener
                public void onGrant(boolean z) {
                    if (z) {
                        PermissionUtil.requestStoragePermission(MainMediaController.this.getContext(), new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.7.1.1
                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onDenied() {
                            }

                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onDeniedWithNeverAsk(String... strArr) {
                            }

                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onGrant() {
                                MainMediaController.this.loadMediaFiles();
                                MainMediaController.this.layoutNoPermission.setVisibility(8);
                            }
                        });
                    }
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNone() {
        if (this.imgNone == null || this.tvSelect == null) {
            return;
        }
        int i = this.mode;
        if (i == 0) {
            DDLog.e("video.size:" + LocalFileManager.getInstance().getVideoList().size());
            if (LocalFileManager.getInstance().getVideoList().size() == 0) {
                this.imgNone.setVisibility(0);
                this.imgNone.setImageResource(R.mipmap.img_none_local_video);
                this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.color_gray));
                this.tvSelect.setText(getContext().getResources().getString(R.string.main_media_select));
                return;
            }
            this.imgNone.setVisibility(8);
            if (this.albumShowRvAdapter.isSelectMode()) {
                this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.color_gray));
                this.tvSelect.setText(getContext().getResources().getString(R.string.dialog_cancel));
                return;
            } else {
                this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.color_kernel_top_state_blue));
                this.tvSelect.setText(getContext().getResources().getString(R.string.main_media_select));
                return;
            }
        }
        if (i == 1) {
            DDLog.e("photo.size:" + LocalFileManager.getInstance().getPhotoList().size());
            if (LocalFileManager.getInstance().getPhotoList().size() == 0) {
                this.imgNone.setVisibility(0);
                this.imgNone.setImageResource(R.mipmap.img_none_local_pic);
                this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.color_gray));
                this.tvSelect.setText(getContext().getResources().getString(R.string.main_media_select));
                return;
            }
            this.imgNone.setVisibility(8);
            if (this.albumShowRvAdapter.isSelectMode()) {
                this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.color_gray));
                this.tvSelect.setText(getContext().getResources().getString(R.string.dialog_cancel));
            } else {
                this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.color_kernel_top_state_blue));
                this.tvSelect.setText(getContext().getResources().getString(R.string.main_media_select));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAllDelete() {
        if (this.btnDelete == null || this.btnShare == null) {
            return;
        }
        int i = this.mode;
        if (i == 0) {
            if (LocalFileManager.getInstance().getVideoList().size() == 0) {
                this.layoutBottom.setVisibility(8);
                setSelectUI(false);
            } else {
                this.layoutBottom.setVisibility(0);
            }
        } else if (i == 1) {
            if (LocalFileManager.getInstance().getPhotoList().size() == 0) {
                this.layoutBottom.setVisibility(8);
                setSelectUI(false);
            } else {
                this.layoutBottom.setVisibility(0);
            }
        }
        this.btnDelete.setImageResource(R.mipmap.icon_btn_media_delete_disable);
        this.btnShare.setImageResource(R.mipmap.icon_btn_media_share_disable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void share() {
        this.filePath = null;
        setSelectedFile();
        if (TextUtils.isEmpty(this.filePath)) {
            return;
        }
        if (PhoneConfig.isConnectFlightWifi() || NetworkUtils.getNetworkState(getContext()) < 0) {
            new GeneralDialog(getContext(), getContext().getResources().getString(R.string.txt_dialog_make_sure_internet_title), getContext().getResources().getString(R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.9
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }
            }).show();
            return;
        }
        if (this.albumShowRvAdapter.isPictureMode()) {
            if (this.urls.size() == 1) {
                new Share2.Builder((BaseActivity) getContext()).setContentType(ShareContentType.IMAGE).setIsSingle(true).setShareFileUri(this.urls.get(0)).setTitle("SHARE WITH FRIENDS").build().shareBySystem();
                return;
            } else {
                new Share2.Builder((BaseActivity) getContext()).setContentType(ShareContentType.IMAGE).setIsSingle(false).setShareFileUriList(this.urls).build().shareBySystem();
                return;
            }
        }
        if (this.urls.size() == 1) {
            new Share2.Builder((BaseActivity) getContext()).setContentType(ShareContentType.VIDEO).setTitle("SHARE WITH FRIENDS").setIsSingle(true).setShareFileUri(this.urls.get(0)).build().shareBySystem();
        } else {
            new Share2.Builder((BaseActivity) getContext()).setContentType(ShareContentType.VIDEO).setIsSingle(false).setShareFileUriList(this.urls).build().shareBySystem();
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaController$10, reason: invalid class name */
    class AnonymousClass10 implements DeleteMediaDialog.DeleteMediaListener {
        AnonymousClass10() {
        }

        @Override // com.ipotensic.kernel.view.dialog.DeleteMediaDialog.DeleteMediaListener
        public void delete() {
            ((BaseActivity) MainMediaController.this.getContext()).showLoadingDialog(false);
            final AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            PhoneConfig.isAppDeleteMultiFiles = true;
            if (Build.VERSION.SDK_INT >= 30) {
                DDLog.e("\u5f00\u59cb\u5220\u9664\u3002\u3002\u3002");
                MainMediaController.this.albumShowRvAdapter.deleteSelectedForAndroid11(new MediaFileUtils.OnDeleteResultListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.10.2
                    @Override // com.ipotensic.baselib.utils.MediaFileUtils.OnDeleteResultListener
                    public void onResult(boolean z) {
                        DDLog.e("\u5f00\u59cb\u5220\u96641\u3002\u3002\u3002\uff1a" + z);
                        if (z) {
                            MainMediaController.this.albumShowRvAdapter.deleteSelected(false, anonymousClass1);
                        } else {
                            ((BaseActivity) MainMediaController.this.getContext()).dismissLoadingDialog();
                            PhoneConfig.isAppDeleteMultiFiles = false;
                        }
                    }
                });
            } else {
                PhoneConfig.isAppDeleteMultiFiles = true;
                MainMediaController.this.albumShowRvAdapter.deleteSelected(true, anonymousClass1);
                PhoneConfig.isAppDeleteMultiFiles = false;
            }
        }

        /* renamed from: com.ipotensic.potensicpro.activities.MainMediaController$10$1, reason: invalid class name */
        class AnonymousClass1 implements SimpleResultListener<Boolean> {
            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public void onResult(Boolean bool) {
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.10.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DDLog.e("\u5f00\u59cb\u5220\u96642\u3002\u3002\u3002\uff1a");
                            MainMediaController.this.checkNone();
                            MainMediaController.this.checkAllDelete();
                            DDLog.e("\u5f00\u59cb\u5220\u96644\u3002\u3002\u3002\uff1a");
                            MainMediaController.this.albumShowRvAdapter.notifyDataSetChanged();
                            PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.10.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ((BaseActivity) MainMediaController.this.getContext()).dismissLoadingDialog();
                                    } catch (Exception unused) {
                                    }
                                    PhoneConfig.isAppDeleteMultiFiles = false;
                                }
                            }, 500L);
                        } catch (Exception e) {
                            DDLog.e("\u5220\u9664\u62a5\u9519\uff1a" + e.getMessage());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        if (this.albumShowRvAdapter.isSelectMode() && this.albumShowRvAdapter.hasPicSelected()) {
            new DeleteMediaDialog(getContext(), getContext().getString(R.string.dialog_delete_these_files), new AnonymousClass10()).show();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            checkNone();
            if (PermissionUtil.hasStoragePermission(getContext())) {
                LinearLayout linearLayout = this.layoutNoPermission;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            showNoPermissionTips();
        }
    }

    private void setSelectedFile() {
        ArrayList<Uri> arrayList = this.urls;
        if (arrayList != null && arrayList.size() > 0) {
            this.urls.clear();
        }
        for (LocalFile localFile : this.albumShowRvAdapter.getListFiles()) {
            if (localFile.isSelect()) {
                this.filePath = localFile.getAbsPath();
                this.urls.add(getShareFileUri());
            }
        }
    }

    public Uri getShareFileUri() {
        return FileUtil.getFileUri(getContext(), ShareContentType.FILE, new File(this.filePath));
    }

    public void refreshAdapter() {
        DDLog.e("refreshAdapter");
        AlbumShowRvAdapter albumShowRvAdapter = this.albumShowRvAdapter;
        if (albumShowRvAdapter == null) {
            return;
        }
        int i = this.mode;
        if (i == 0) {
            albumShowRvAdapter.updateAdapterList(LocalFileManager.getInstance().getVideoList());
        } else if (i == 1) {
            albumShowRvAdapter.updateAdapterList(LocalFileManager.getInstance().getPhotoList());
        }
        checkNone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectUI(boolean z) {
        this.albumShowRvAdapter.setSelectMode(z);
        MediaControllerListener mediaControllerListener = this.mediaControllerListener;
        if (mediaControllerListener != null) {
            mediaControllerListener.setSelectUI(this.albumShowRvAdapter.isSelectMode());
        }
        checkNone();
    }

    @Override // com.ipotensic.mediagallery.AlbumShowRvAdapter.OnRecyclerViewItemClickListener
    public void onItemClick(LocalFile localFile, int i) {
        int i2 = AnonymousClass12.$SwitchMap$com$ipotensic$baselib$enums$FileTypeEnum[localFile.getFileTypeEnum().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            Intent intent = new Intent(getContext(), (Class<?>) MainMediaPhotoViewerActivity.class);
            intent.putExtra("position", i);
            getContext().startActivityForResult(intent, 99);
            return;
        }
        Intent intent2 = new Intent(getContext(), (Class<?>) VideoViewerPortActivity.class);
        intent2.putExtra("data", LocalFileManager.getInstance().getVideoListNoHead());
        intent2.putExtra("type", 0);
        int i3 = 0;
        for (int i4 = 0; i4 < LocalFileManager.getInstance().getVideoListNoHead().size(); i4++) {
            try {
                if (LocalFileManager.getInstance().getVideoListNoHead().get(i4).getAbsPath().equals(localFile.getAbsPath())) {
                    i3 = i4;
                }
            } catch (Exception unused) {
            }
        }
        intent2.putExtra("position", i3);
        intent2.putExtra("isLocalVideo", true);
        getContext().startActivityForResult(intent2, 98);
    }

    @Override // com.ipotensic.mediagallery.AlbumShowRvAdapter.OnRecyclerViewItemClickListener
    public void onItemLongClick(int i) {
        setSelectUI(!this.albumShowRvAdapter.isSelectMode());
        this.albumShowRvAdapter.setItemSelected(i);
        checkAllDelete();
    }

    @Override // com.ipotensic.mediagallery.AlbumShowRvAdapter.OnRecyclerViewItemClickListener
    public void isHasItemSelected(List<LocalFile> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.btnDelete.setImageResource(R.mipmap.icon_btn_media_delete_disable);
        this.btnShare.setImageResource(R.mipmap.icon_btn_media_share_disable);
        this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.color_gray));
        Iterator<LocalFile> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isSelect()) {
                this.btnDelete.setImageResource(R.mipmap.icon_btn_media_delete);
                this.btnShare.setImageResource(R.mipmap.icon_btn_media_share);
                this.tvSelect.setTextColor(getContext().getResources().getColor(R.color.colorBlack));
                return;
            }
        }
    }

    public void setMediaControllerListener(MediaControllerListener mediaControllerListener) {
        this.mediaControllerListener = mediaControllerListener;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.albumShowRvAdapter != null) {
            if (i == 99) {
                DDLog.w("photo size:" + LocalFileManager.getInstance().getPhotoList().size());
                this.albumShowRvAdapter.updateAdapterList(LocalFileManager.getInstance().getPhotoList());
            } else if (i == 98) {
                DDLog.w("video size:" + LocalFileManager.getInstance().getVideoList().size());
                this.albumShowRvAdapter.updateAdapterList(LocalFileManager.getInstance().getVideoList());
            }
        }
        checkNone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMediaFiles() {
        ((BaseActivity) getContext()).showLoadingDialog(false);
        LocalFileManager.getInstance().scanAlbum(new OnResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.11
            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onFailed(Exception exc) {
            }

            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onSuccess(Boolean bool) {
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainMediaController.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ((BaseActivity) MainMediaController.this.getContext()).dismissLoadingDialog();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        });
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onPause() {
        super.onPause();
        this.isUserPause = true;
        this.hasStoragePermissionOnPause = PermissionUtil.hasStoragePermission(getContext());
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onResume() {
        LinearLayout linearLayout;
        super.onResume();
        boolean z = this.isUserPause;
        if (((z && this.isFileChange) || (z && !this.hasStoragePermissionOnPause && PermissionUtil.hasStoragePermission(getContext()))) && getVisibility() == 0) {
            loadMediaFiles();
        }
        this.isUserPause = false;
        this.isFileChange = false;
        if (!PermissionUtil.hasStoragePermission(getContext()) || (linearLayout = this.layoutNoPermission) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        FileSystemChangeListener fileSystemChangeListener = this.fileChangedListener;
        if (fileSystemChangeListener != null) {
            fileSystemChangeListener.stopWatching();
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaController$12, reason: invalid class name */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$enums$FileTypeEnum;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_MEDIA_FILE_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[FileTypeEnum.values().length];
            $SwitchMap$com$ipotensic$baselib$enums$FileTypeEnum = iArr2;
            try {
                iArr2[FileTypeEnum.TYPE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$FileTypeEnum[FileTypeEnum.TYPE_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (AnonymousClass12.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()] != 1) {
            return;
        }
        refreshAdapter();
    }
}