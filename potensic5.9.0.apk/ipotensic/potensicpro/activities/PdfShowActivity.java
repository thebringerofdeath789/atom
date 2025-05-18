package com.ipotensic.potensicpro.activities;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PdfShowActivity extends BaseActivity implements View.OnClickListener, OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {
    public static final String FILE_PATH = "file_path";
    private ImageButton btnBack;
    private ImageView ivShare;
    private LinearLayoutManager linearLayoutManager;
    private List<Bitmap> list;
    private PdfAdapter pdfAdapter;
    private File pdfFile;
    private PDFView pdfView;
    private RecyclerView recyclerView;
    private TextView tvPageNum;
    private TextView tvTitle;
    private int pageNumber = 0;
    private final String TAG = "PDF";

    private interface OnItemClickListener {
        void onItemClick(int i);
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_pdf);
        this.pdfFile = (File) getIntent().getSerializableExtra(FILE_PATH);
        initView();
        initData();
        setToolBar();
    }

    private void setToolBar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        this.btnBack = (ImageButton) findViewById(R.id.btn_back);
        this.tvTitle = (TextView) findViewById(R.id.tv_code_title);
        this.ivShare = (ImageView) findViewById(R.id.iv_share);
        this.pdfView = (PDFView) findViewById(R.id.pdfView);
        this.tvPageNum = (TextView) findViewById(R.id.tv_page_num);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.btnBack.setOnClickListener(this);
        this.ivShare.setOnClickListener(this);
        this.pdfView.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        this.linearLayoutManager = linearLayoutManager;
        this.recyclerView.setLayoutManager(linearLayoutManager);
        PdfAdapter pdfAdapter = new PdfAdapter();
        this.pdfAdapter = pdfAdapter;
        this.recyclerView.setAdapter(pdfAdapter);
        this.pdfAdapter.setOnItemClickLister(new OnItemClickListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.1
            AnonymousClass1() {
            }

            @Override // com.ipotensic.potensicpro.activities.PdfShowActivity.OnItemClickListener
            public void onItemClick(int i) {
                DDLog.e("PDF", "postion: " + i);
                PdfShowActivity.this.pdfView.jumpTo(i);
            }
        });
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.2
            AnonymousClass2() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                DDLog.e("PDF", "onScrollStateChanged");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                DDLog.e("PDF", "onScrolled");
            }
        });
    }

    /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$1 */
    class AnonymousClass1 implements OnItemClickListener {
        AnonymousClass1() {
        }

        @Override // com.ipotensic.potensicpro.activities.PdfShowActivity.OnItemClickListener
        public void onItemClick(int i) {
            DDLog.e("PDF", "postion: " + i);
            PdfShowActivity.this.pdfView.jumpTo(i);
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$2 */
    class AnonymousClass2 extends RecyclerView.OnScrollListener {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            DDLog.e("PDF", "onScrollStateChanged");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DDLog.e("PDF", "onScrolled");
        }
    }

    private void initData() {
        File file = this.pdfFile;
        if (file != null) {
            displayFromFile(file);
            pdfToBitmaps(this.pdfFile);
        }
    }

    private void displayFromFile(File file) {
        this.pdfView.fromFile(file).defaultPage(this.pageNumber).onPageChange(this).swipeHorizontal(true).pageSnap(true).autoSpacing(true).pageFling(true).enableAnnotationRendering(true).onLoad(this).scrollHandle(new DefaultScrollHandle(this)).spacing(10).onPageError(this).pageFitPolicy(FitPolicy.BOTH).load();
    }

    /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ File val$pdfFile;

        AnonymousClass3(File file) {
            r2 = file;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            PdfRenderer pdfRenderer;
            Exception e;
            PdfShowActivity pdfShowActivity = PdfShowActivity.this;
            ArrayList arrayList = new ArrayList();
            pdfShowActivity.list = arrayList;
            PdfRenderer pdfRenderer2 = 0;
            try {
                try {
                    try {
                        pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(r2, 268435456));
                    } catch (Exception e2) {
                        pdfRenderer = null;
                        e = e2;
                    } catch (Throwable th) {
                        th = th;
                        if (pdfRenderer2 != 0) {
                        }
                        throw th;
                    }
                    try {
                        int pageCount = pdfRenderer.getPageCount();
                        DDLog.e("PDF", "pageCount = " + pageCount);
                        for (int i = 0; i < pageCount; i++) {
                            PdfRenderer.Page openPage = pdfRenderer.openPage(i);
                            Bitmap createBitmap = Bitmap.createBitmap(ScreenUtils.dp2px(PdfShowActivity.this, 38.0f), ScreenUtils.dp2px(PdfShowActivity.this, 55.0f), Bitmap.Config.ARGB_8888);
                            openPage.render(createBitmap, null, null, 1);
                            PdfShowActivity.this.list.add(createBitmap);
                            openPage.close();
                        }
                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.3.1
                            AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                PdfShowActivity.this.refreshAdapter();
                            }
                        });
                        pdfRenderer.close();
                    } catch (Exception e3) {
                        e = e3;
                        DDLog.e("PDF", " IOException = " + e.getMessage());
                        e.printStackTrace();
                        if (pdfRenderer != null) {
                            pdfRenderer.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    pdfRenderer2 = arrayList;
                    if (pdfRenderer2 != 0) {
                        try {
                            pdfRenderer2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$3$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PdfShowActivity.this.refreshAdapter();
            }
        }
    }

    private void pdfToBitmaps(File file) {
        PhoneConfig.schedule.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.3
            final /* synthetic */ File val$pdfFile;

            AnonymousClass3(File file2) {
                r2 = file2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                PdfRenderer pdfRenderer;
                Exception e;
                PdfShowActivity pdfShowActivity = PdfShowActivity.this;
                ArrayList arrayList = new ArrayList();
                pdfShowActivity.list = arrayList;
                PdfRenderer pdfRenderer2 = 0;
                try {
                    try {
                        try {
                            pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(r2, 268435456));
                        } catch (Exception e2) {
                            pdfRenderer = null;
                            e = e2;
                        } catch (Throwable th) {
                            th = th;
                            if (pdfRenderer2 != 0) {
                            }
                            throw th;
                        }
                        try {
                            int pageCount = pdfRenderer.getPageCount();
                            DDLog.e("PDF", "pageCount = " + pageCount);
                            for (int i = 0; i < pageCount; i++) {
                                PdfRenderer.Page openPage = pdfRenderer.openPage(i);
                                Bitmap createBitmap = Bitmap.createBitmap(ScreenUtils.dp2px(PdfShowActivity.this, 38.0f), ScreenUtils.dp2px(PdfShowActivity.this, 55.0f), Bitmap.Config.ARGB_8888);
                                openPage.render(createBitmap, null, null, 1);
                                PdfShowActivity.this.list.add(createBitmap);
                                openPage.close();
                            }
                            PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.3.1
                                AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    PdfShowActivity.this.refreshAdapter();
                                }
                            });
                            pdfRenderer.close();
                        } catch (Exception e3) {
                            e = e3;
                            DDLog.e("PDF", " IOException = " + e.getMessage());
                            e.printStackTrace();
                            if (pdfRenderer != null) {
                                pdfRenderer.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        pdfRenderer2 = arrayList;
                        if (pdfRenderer2 != 0) {
                            try {
                                pdfRenderer2.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }

            /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$3$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PdfShowActivity.this.refreshAdapter();
                }
            }
        });
    }

    public void refreshAdapter() {
        PdfAdapter pdfAdapter = this.pdfAdapter;
        if (pdfAdapter != null) {
            pdfAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            finish();
            return;
        }
        if (id == R.id.iv_share) {
            if (PhoneConfig.isConnectFlightWifi() || NetworkUtils.getNetworkState(this) < 0) {
                new GeneralDialog(this, getResources().getString(R.string.txt_dialog_make_sure_internet_title), getResources().getString(R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.4
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }

                    AnonymousClass4() {
                    }
                }).show();
            } else {
                PermissionUtil.requestStoragePermissionInShareWithDialog(this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.5
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    AnonymousClass5() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        Share2.Builder isSingle = new Share2.Builder(PdfShowActivity.this).setContentType(ShareContentType.VIDEO).setTitle("SHARE WITH FRIENDS").setIsSingle(true);
                        PdfShowActivity pdfShowActivity = PdfShowActivity.this;
                        isSingle.setShareFileUri(FileUtil.getFileUri(pdfShowActivity, ShareContentType.FILE, pdfShowActivity.pdfFile)).build().shareBySystem();
                    }
                });
            }
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$4 */
    class AnonymousClass4 implements GeneralDialog.ClickConfirmListener {
        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
        }

        AnonymousClass4() {
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$5 */
    class AnonymousClass5 implements PermissionUtil.OnPermissionListener {
        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass5() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            Share2.Builder isSingle = new Share2.Builder(PdfShowActivity.this).setContentType(ShareContentType.VIDEO).setTitle("SHARE WITH FRIENDS").setIsSingle(true);
            PdfShowActivity pdfShowActivity = PdfShowActivity.this;
            isSingle.setShareFileUri(FileUtil.getFileUri(pdfShowActivity, ShareContentType.FILE, pdfShowActivity.pdfFile)).build().shareBySystem();
        }
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnPageChangeListener
    public void onPageChanged(int i, int i2) {
        DDLog.e("PDF", "onPageChanged: " + i);
        this.pageNumber = i;
        this.tvPageNum.setText(String.format("%d / %d", Integer.valueOf(i + 1), Integer.valueOf(i2)));
        refreshAdapter();
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
    public void loadComplete(int i) {
        DDLog.e("PDF", "loadComplete = " + i);
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnPageErrorListener
    public void onPageError(int i, Throwable th) {
        DDLog.e("PDF", "can't open file !!");
    }

    private class PdfAdapter extends RecyclerView.Adapter<ViewHolder> {
        private OnItemClickListener onItemClickListener;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        private PdfAdapter() {
        }

        /* synthetic */ PdfAdapter(PdfShowActivity pdfShowActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(PdfShowActivity.this).inflate(R.layout.adapter_pdf_item, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (i > PdfShowActivity.this.list.size() - 1) {
                return;
            }
            Bitmap bitmap = (Bitmap) PdfShowActivity.this.list.get(i);
            if (bitmap != null) {
                viewHolder.imgPdf.setImageBitmap(bitmap);
            }
            viewHolder.viewLine.setVisibility(PdfShowActivity.this.pageNumber == i ? 0 : 8);
            viewHolder.imgPdf.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.PdfAdapter.1
                final /* synthetic */ int val$position;

                AnonymousClass1(int i2) {
                    r2 = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PdfAdapter.this.onItemClickListener != null) {
                        PdfAdapter.this.onItemClickListener.onItemClick(r2);
                    }
                }
            });
        }

        /* renamed from: com.ipotensic.potensicpro.activities.PdfShowActivity$PdfAdapter$1 */
        class AnonymousClass1 implements View.OnClickListener {
            final /* synthetic */ int val$position;

            AnonymousClass1(int i2) {
                r2 = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PdfAdapter.this.onItemClickListener != null) {
                    PdfAdapter.this.onItemClickListener.onItemClick(r2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (PdfShowActivity.this.list != null) {
                return PdfShowActivity.this.list.size();
            }
            return 0;
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imgPdf;
            private View viewLine;

            public ViewHolder(View view) {
                super(view);
                this.imgPdf = (ImageView) view.findViewById(R.id.img_pdf);
                this.viewLine = view.findViewById(R.id.view_line);
            }
        }

        public void setOnItemClickLister(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        PDFView pDFView = this.pdfView;
        if (pDFView != null) {
            pDFView.recycle();
        }
    }
}