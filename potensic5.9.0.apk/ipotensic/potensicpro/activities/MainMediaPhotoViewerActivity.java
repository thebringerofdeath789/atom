package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.content.res.Resources;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.MediaFileUtils;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.kernel.view.dialog.DeleteMediaDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.dialog.MediaInfoDialog;
import com.ipotensic.kernel.view.photoview.PhotoView;
import com.ipotensic.potensicpro.R;
import com.logan.camera.data.MediaInfoData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class MainMediaPhotoViewerActivity extends BaseActivity {
    private int curPosition;
    private CyclePagerAdapter cycleAdapter;
    private List files;
    private ImageView imgReturn;
    protected ConstraintLayout layoutBottom;
    protected ConstraintLayout layoutMain;
    protected ConstraintLayout layoutTop;
    private LooperViewPager mCycleViewPager;
    private TextView tvCurDate;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        this.curPosition = getIntent().getIntExtra("position", 0);
        DDLog.w("curPosition:" + this.curPosition);
        setContentView(R.layout.activity_main_photo_viewer);
        this.layoutTop = (ConstraintLayout) findViewById(R.id.layout_top);
        this.layoutBottom = (ConstraintLayout) findViewById(R.id.layout_bottom);
        this.layoutMain = (ConstraintLayout) findViewById(R.id.layout_main);
        this.imgReturn = (ImageView) findViewById(R.id.btn_back);
        this.tvCurDate = (TextView) findViewById(R.id.tv_date);
        this.imgReturn.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.1
            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainMediaPhotoViewerActivity.this.finishActivity();
            }
        });
        findViewById(R.id.btn_media_info).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.2
            AnonymousClass2() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainMediaPhotoViewerActivity.this.showMediaInfo();
            }
        });
        findViewById(R.id.btn_media_share).setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.3
            AnonymousClass3(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainMediaPhotoViewerActivity.this.share();
            }
        });
        findViewById(R.id.btn_delete).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.4
            AnonymousClass4() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainMediaPhotoViewerActivity.this.delete();
            }
        });
        refreshData(true);
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$1 */
    class AnonymousClass1 extends ScaleClickListener {
        AnonymousClass1() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainMediaPhotoViewerActivity.this.finishActivity();
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$2 */
    class AnonymousClass2 extends ScaleClickListener {
        AnonymousClass2() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainMediaPhotoViewerActivity.this.showMediaInfo();
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$3 */
    class AnonymousClass3 extends ScaleClickListener {
        AnonymousClass3(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainMediaPhotoViewerActivity.this.share();
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$4 */
    class AnonymousClass4 extends ScaleClickListener {
        AnonymousClass4() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainMediaPhotoViewerActivity.this.delete();
        }
    }

    private void refreshData(boolean z) {
        this.files = new ArrayList();
        int i = this.curPosition;
        for (int i2 = 0; i2 < LocalFileManager.getInstance().getPhotoList().size(); i2++) {
            LocalFile localFile = LocalFileManager.getInstance().getPhotoList().get(i2);
            if (localFile.getFileTypeEnum() != FileTypeEnum.TYPE_HEAD) {
                this.files.add(localFile);
            } else if (z && i >= i2) {
                DDLog.w("curPosition1:" + this.curPosition);
                DDLog.w("i:" + i2);
                int i3 = this.curPosition;
                if (i3 > 0) {
                    this.curPosition = i3 - 1;
                }
            }
        }
        LooperViewPager looperViewPager = (LooperViewPager) findViewById(R.id.loop_viewpager);
        this.mCycleViewPager = looperViewPager;
        CyclePagerAdapter cyclePagerAdapter = new CyclePagerAdapter(this);
        this.cycleAdapter = cyclePagerAdapter;
        looperViewPager.setAdapter(cyclePagerAdapter);
        this.mCycleViewPager.setOnPageChangeListener(new LooperViewPager.OnPageChangeListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.5
            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i4) {
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrolled(int i4, float f, int i5) {
            }

            AnonymousClass5() {
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageSelected(int i4) {
                DDLog.i("curindex :" + MainMediaPhotoViewerActivity.this.curPosition);
                MainMediaPhotoViewerActivity.this.curPosition = i4;
            }
        });
        this.mCycleViewPager.setCanTouch(this.files.size() > 1);
        this.mCycleViewPager.setCurrentItem(this.curPosition);
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$5 */
    class AnonymousClass5 implements LooperViewPager.OnPageChangeListener {
        @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i4) {
        }

        @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
        public void onPageScrolled(int i4, float f, int i5) {
        }

        AnonymousClass5() {
        }

        @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
        public void onPageSelected(int i4) {
            DDLog.i("curindex :" + MainMediaPhotoViewerActivity.this.curPosition);
            MainMediaPhotoViewerActivity.this.curPosition = i4;
        }
    }

    public void finishActivity() {
        setResult(-1);
        finish();
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$6 */
    class AnonymousClass6 implements DeleteMediaDialog.DeleteMediaListener {
        AnonymousClass6() {
        }

        @Override // com.ipotensic.kernel.view.dialog.DeleteMediaDialog.DeleteMediaListener
        public void delete() {
            LocalFile localFile = (LocalFile) MainMediaPhotoViewerActivity.this.files.get(MainMediaPhotoViewerActivity.this.curPosition);
            if (Build.VERSION.SDK_INT >= 30) {
                ArrayList<LocalFile> arrayList = new ArrayList<>();
                arrayList.add(localFile);
                LocalFileManager.getInstance().deleteFiles(MainMediaPhotoViewerActivity.this, arrayList, new MediaFileUtils.OnDeleteResultListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.6.1
                    final /* synthetic */ LocalFile val$file;

                    AnonymousClass1(LocalFile localFile2) {
                        r2 = localFile2;
                    }

                    @Override // com.ipotensic.baselib.utils.MediaFileUtils.OnDeleteResultListener
                    public void onResult(boolean z) {
                        if (z) {
                            MainMediaPhotoViewerActivity.this.refreshUIAfterDeleteFile(r2);
                        }
                    }
                });
            } else {
                LocalFileManager.getInstance().deleteFile(localFile2);
                MainMediaPhotoViewerActivity.this.refreshUIAfterDeleteFile(localFile2);
            }
        }

        /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$6$1 */
        class AnonymousClass1 implements MediaFileUtils.OnDeleteResultListener {
            final /* synthetic */ LocalFile val$file;

            AnonymousClass1(LocalFile localFile2) {
                r2 = localFile2;
            }

            @Override // com.ipotensic.baselib.utils.MediaFileUtils.OnDeleteResultListener
            public void onResult(boolean z) {
                if (z) {
                    MainMediaPhotoViewerActivity.this.refreshUIAfterDeleteFile(r2);
                }
            }
        }
    }

    public synchronized void delete() {
        new DeleteMediaDialog(this, getString(R.string.dialog_delete_this_file), new DeleteMediaDialog.DeleteMediaListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.6
            AnonymousClass6() {
            }

            @Override // com.ipotensic.kernel.view.dialog.DeleteMediaDialog.DeleteMediaListener
            public void delete() {
                LocalFile localFile2 = (LocalFile) MainMediaPhotoViewerActivity.this.files.get(MainMediaPhotoViewerActivity.this.curPosition);
                if (Build.VERSION.SDK_INT >= 30) {
                    ArrayList<LocalFile> arrayList = new ArrayList<>();
                    arrayList.add(localFile2);
                    LocalFileManager.getInstance().deleteFiles(MainMediaPhotoViewerActivity.this, arrayList, new MediaFileUtils.OnDeleteResultListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.6.1
                        final /* synthetic */ LocalFile val$file;

                        AnonymousClass1(LocalFile localFile22) {
                            r2 = localFile22;
                        }

                        @Override // com.ipotensic.baselib.utils.MediaFileUtils.OnDeleteResultListener
                        public void onResult(boolean z) {
                            if (z) {
                                MainMediaPhotoViewerActivity.this.refreshUIAfterDeleteFile(r2);
                            }
                        }
                    });
                } else {
                    LocalFileManager.getInstance().deleteFile(localFile22);
                    MainMediaPhotoViewerActivity.this.refreshUIAfterDeleteFile(localFile22);
                }
            }

            /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$6$1 */
            class AnonymousClass1 implements MediaFileUtils.OnDeleteResultListener {
                final /* synthetic */ LocalFile val$file;

                AnonymousClass1(LocalFile localFile22) {
                    r2 = localFile22;
                }

                @Override // com.ipotensic.baselib.utils.MediaFileUtils.OnDeleteResultListener
                public void onResult(boolean z) {
                    if (z) {
                        MainMediaPhotoViewerActivity.this.refreshUIAfterDeleteFile(r2);
                    }
                }
            }
        }).show();
    }

    public void refreshUIAfterDeleteFile(LocalFile localFile) {
        ArrayList<LocalFile> photoList = LocalFileManager.getInstance().getPhotoList();
        int i = 0;
        while (true) {
            if (i < photoList.size()) {
                if (photoList.get(i).getAbsPath() != null && photoList.get(i).getFileTypeEnum() == FileTypeEnum.TYPE_PHOTO && photoList.get(i).getAbsPath().equals(localFile.getAbsPath())) {
                    DDLog.e("remove photo file list");
                    LocalFileManager.getInstance().getPhotoList().remove(i);
                    removeHead();
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (LocalFileManager.getInstance().getPhotoList().size() == 0) {
            finishActivity();
            return;
        }
        int i2 = this.curPosition - 1;
        this.curPosition = i2;
        if (i2 < 0) {
            this.curPosition = 0;
        }
        refreshData(false);
    }

    private void removeHead() {
        Iterator<LocalFile> it = LocalFileManager.getInstance().getPhotoList().iterator();
        while (it.hasNext()) {
            LocalFile next = it.next();
            if (next.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                int indexOf = LocalFileManager.getInstance().getPhotoList().indexOf(next);
                if (indexOf == LocalFileManager.getInstance().getPhotoList().size() - 1) {
                    it.remove();
                } else {
                    int i = indexOf + 1;
                    if (i <= LocalFileManager.getInstance().getPhotoList().size() - 1 && LocalFileManager.getInstance().getPhotoList().get(i).getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void share() {
        List list = this.files;
        if (list == null || list.size() <= 0) {
            return;
        }
        if (PhoneConfig.isConnectFlightWifi() || NetworkUtils.getNetworkState(this) < 0) {
            new GeneralDialog(this, getResources().getString(R.string.txt_dialog_make_sure_internet_title), getResources().getString(R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.7
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }

                AnonymousClass7() {
                }
            }).show();
        } else {
            PermissionUtil.requestStoragePermissionInShareWithDialog(this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.8
                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDenied() {
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDeniedWithNeverAsk(String... strArr) {
                }

                AnonymousClass8() {
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onGrant() {
                    new Share2.Builder(MainMediaPhotoViewerActivity.this).setContentType(ShareContentType.IMAGE).setIsSingle(true).setShareFileUri(MainMediaPhotoViewerActivity.this.getShareFileUri()).setTitle("SHARE WITH FRIENDS").build().shareBySystem();
                }
            });
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$7 */
    class AnonymousClass7 implements GeneralDialog.ClickConfirmListener {
        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
        }

        AnonymousClass7() {
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$8 */
    class AnonymousClass8 implements PermissionUtil.OnPermissionListener {
        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass8() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            new Share2.Builder(MainMediaPhotoViewerActivity.this).setContentType(ShareContentType.IMAGE).setIsSingle(true).setShareFileUri(MainMediaPhotoViewerActivity.this.getShareFileUri()).setTitle("SHARE WITH FRIENDS").build().shareBySystem();
        }
    }

    public Uri getShareFileUri() {
        LocalFile localFile = (LocalFile) this.files.get(this.curPosition);
        DDLog.e("file name :" + localFile.getAbsPath());
        return FileUtil.getFileUri(this, ShareContentType.FILE, new File(localFile.getAbsPath()));
    }

    public void showMediaInfo() {
        MediaInfoData localMediaInfo;
        if (!(this.files.get(this.curPosition) instanceof LocalFile) || (localMediaInfo = getLocalMediaInfo((LocalFile) this.files.get(this.curPosition))) == null) {
            return;
        }
        MediaInfoDialog mediaInfoDialog = new MediaInfoDialog(this, 0);
        mediaInfoDialog.setMediaInfo(localMediaInfo);
        mediaInfoDialog.show();
    }

    private MediaInfoData getLocalMediaInfo(LocalFile localFile) {
        MediaInfoData mediaInfoData = new MediaInfoData();
        File file = new File(localFile.getAbsPath());
        mediaInfoData.setFilename(file.getName());
        mediaInfoData.setCreatetime(FormatUtil.formatCreateTime(file.lastModified()));
        mediaInfoData.setVideo(false);
        try {
            ExifInterface exifInterface = new ExifInterface(localFile.getAbsPath());
            String attribute = exifInterface.getAttribute("ImageWidth");
            String attribute2 = exifInterface.getAttribute("ImageLength");
            mediaInfoData.setWidth(Integer.valueOf(attribute).intValue());
            mediaInfoData.setHeight(Integer.valueOf(attribute2).intValue());
            mediaInfoData.setFilesize(file.length());
            return mediaInfoData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private class CyclePagerAdapter extends PagerAdapter {
        private Context context;
        private int mChildCount;
        private LinkedList<View> mViewCache;
        private View.OnClickListener photoClickListener;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* synthetic */ CyclePagerAdapter(MainMediaPhotoViewerActivity mainMediaPhotoViewerActivity, MainMediaPhotoViewerActivity mainMediaPhotoViewerActivity2, AnonymousClass1 anonymousClass1) {
            this(mainMediaPhotoViewerActivity2);
        }

        private CyclePagerAdapter(MainMediaPhotoViewerActivity mainMediaPhotoViewerActivity) {
            this.photoClickListener = new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity.CyclePagerAdapter.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Resources resources;
                    int i;
                    MainMediaPhotoViewerActivity.this.layoutTop.setVisibility(MainMediaPhotoViewerActivity.this.layoutTop.getVisibility() == 0 ? 8 : 0);
                    MainMediaPhotoViewerActivity.this.layoutBottom.setVisibility(MainMediaPhotoViewerActivity.this.layoutBottom.getVisibility() != 0 ? 0 : 8);
                    ConstraintLayout constraintLayout = MainMediaPhotoViewerActivity.this.layoutMain;
                    if (MainMediaPhotoViewerActivity.this.layoutTop.getVisibility() == 0) {
                        resources = CyclePagerAdapter.this.context.getResources();
                        i = R.color.colorWhite;
                    } else {
                        resources = CyclePagerAdapter.this.context.getResources();
                        i = R.color.black;
                    }
                    constraintLayout.setBackgroundColor(resources.getColor(i));
                }
            };
            this.mViewCache = new LinkedList<>();
            this.context = mainMediaPhotoViewerActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.mChildCount = getCount();
            super.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MainMediaPhotoViewerActivity.this.files.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int i = this.mChildCount;
            if (i > 0) {
                this.mChildCount = i - 1;
                return -2;
            }
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View removeFirst;
            if (MainMediaPhotoViewerActivity.this.curPosition >= MainMediaPhotoViewerActivity.this.files.size() || i >= MainMediaPhotoViewerActivity.this.files.size()) {
                return null;
            }
            long createTime = ((LocalFile) MainMediaPhotoViewerActivity.this.files.get(MainMediaPhotoViewerActivity.this.curPosition)).getCreateTime();
            DDLog.w("load image curposition:" + MainMediaPhotoViewerActivity.this.curPosition);
            MainMediaPhotoViewerActivity.this.tvCurDate.setText(FormatUtil.formatCreateTime(createTime));
            if (this.mViewCache.size() == 0) {
                removeFirst = new PhotoView(this.context);
            } else {
                removeFirst = this.mViewCache.removeFirst();
            }
            PhotoView photoView = (PhotoView) removeFirst;
            photoView.setOnClickListener(this.photoClickListener);
            Object obj = MainMediaPhotoViewerActivity.this.files.get(i);
            if (obj instanceof LocalFile) {
                Glide.with(this.context).load(Uri.parse("file://" + ((LocalFile) obj).getAbsPath())).into(photoView);
            }
            viewGroup.addView(removeFirst);
            return removeFirst;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof View) {
                View view = (View) obj;
                viewGroup.removeView(view);
                this.mViewCache.add(view);
            }
        }

        /* renamed from: com.ipotensic.potensicpro.activities.MainMediaPhotoViewerActivity$CyclePagerAdapter$1 */
        class AnonymousClass1 implements View.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Resources resources;
                int i;
                MainMediaPhotoViewerActivity.this.layoutTop.setVisibility(MainMediaPhotoViewerActivity.this.layoutTop.getVisibility() == 0 ? 8 : 0);
                MainMediaPhotoViewerActivity.this.layoutBottom.setVisibility(MainMediaPhotoViewerActivity.this.layoutBottom.getVisibility() != 0 ? 0 : 8);
                ConstraintLayout constraintLayout = MainMediaPhotoViewerActivity.this.layoutMain;
                if (MainMediaPhotoViewerActivity.this.layoutTop.getVisibility() == 0) {
                    resources = CyclePagerAdapter.this.context.getResources();
                    i = R.color.colorWhite;
                } else {
                    resources = CyclePagerAdapter.this.context.getResources();
                    i = R.color.black;
                }
                constraintLayout.setBackgroundColor(resources.getColor(i));
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishActivity();
    }
}