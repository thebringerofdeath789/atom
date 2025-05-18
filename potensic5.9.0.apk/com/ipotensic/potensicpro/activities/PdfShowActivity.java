package com.ipotensic.potensicpro.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.C2640R;
import java.io.File;
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
        setContentView(C2640R.layout.activity_pdf);
        this.pdfFile = (File) getIntent().getSerializableExtra(FILE_PATH);
        initView();
        initData();
        setToolBar();
    }

    private void setToolBar() {
        setSupportActionBar((Toolbar) findViewById(C2640R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        this.btnBack = (ImageButton) findViewById(C2640R.id.btn_back);
        this.tvTitle = (TextView) findViewById(C2640R.id.tv_code_title);
        this.ivShare = (ImageView) findViewById(C2640R.id.iv_share);
        this.pdfView = (PDFView) findViewById(C2640R.id.pdfView);
        this.tvPageNum = (TextView) findViewById(C2640R.id.tv_page_num);
        this.recyclerView = (RecyclerView) findViewById(C2640R.id.recycler_view);
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
            @Override // com.ipotensic.potensicpro.activities.PdfShowActivity.OnItemClickListener
            public void onItemClick(int i) {
                DDLog.m1685e("PDF", "postion: " + i);
                PdfShowActivity.this.pdfView.jumpTo(i);
            }
        });
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                DDLog.m1685e("PDF", "onScrollStateChanged");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                DDLog.m1685e("PDF", "onScrolled");
            }
        });
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

    private void pdfToBitmaps(final File file) {
        PhoneConfig.schedule.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r10 = this;
                    java.lang.String r0 = "PDF"
                    com.ipotensic.potensicpro.activities.PdfShowActivity r1 = com.ipotensic.potensicpro.activities.PdfShowActivity.this
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    com.ipotensic.potensicpro.activities.PdfShowActivity.access$302(r1, r2)
                    r1 = 0
                    android.graphics.pdf.PdfRenderer r2 = new android.graphics.pdf.PdfRenderer     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
                    java.io.File r3 = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
                    r4 = 268435456(0x10000000, float:2.524355E-29)
                    android.os.ParcelFileDescriptor r3 = android.os.ParcelFileDescriptor.open(r3, r4)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
                    r2.<init>(r3)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
                    int r3 = r2.getPageCount()     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r4.<init>()     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    java.lang.String r5 = "pageCount = "
                    java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    java.lang.StringBuilder r4 = r4.append(r3)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    com.ipotensic.baselib.DDLog.m1685e(r0, r4)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r4 = 0
                L35:
                    if (r4 >= r3) goto L64
                    android.graphics.pdf.PdfRenderer$Page r5 = r2.openPage(r4)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    com.ipotensic.potensicpro.activities.PdfShowActivity r6 = com.ipotensic.potensicpro.activities.PdfShowActivity.this     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r7 = 1108869120(0x42180000, float:38.0)
                    int r6 = com.ipotensic.baselib.utils.ScreenUtils.dp2px(r6, r7)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    com.ipotensic.potensicpro.activities.PdfShowActivity r7 = com.ipotensic.potensicpro.activities.PdfShowActivity.this     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r8 = 1113325568(0x425c0000, float:55.0)
                    int r7 = com.ipotensic.baselib.utils.ScreenUtils.dp2px(r7, r8)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r6, r7, r8)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r7 = 1
                    r5.render(r6, r1, r1, r7)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    com.ipotensic.potensicpro.activities.PdfShowActivity r7 = com.ipotensic.potensicpro.activities.PdfShowActivity.this     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    java.util.List r7 = com.ipotensic.potensicpro.activities.PdfShowActivity.access$300(r7)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r7.add(r6)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r5.close()     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    int r4 = r4 + 1
                    goto L35
                L64:
                    android.os.Handler r1 = com.ipotensic.baselib.configs.PhoneConfig.mainHandler     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    com.ipotensic.potensicpro.activities.PdfShowActivity$3$1 r3 = new com.ipotensic.potensicpro.activities.PdfShowActivity$3$1     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r3.<init>()     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r1.post(r3)     // Catch: java.lang.Exception -> L72 java.lang.Throwable -> La2
                    r2.close()     // Catch: java.lang.Exception -> L9d
                    goto La1
                L72:
                    r1 = move-exception
                    goto L7a
                L74:
                    r0 = move-exception
                    goto La4
                L76:
                    r2 = move-exception
                    r9 = r2
                    r2 = r1
                    r1 = r9
                L7a:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La2
                    r3.<init>()     // Catch: java.lang.Throwable -> La2
                    java.lang.String r4 = " IOException = "
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> La2
                    java.lang.String r4 = r1.getMessage()     // Catch: java.lang.Throwable -> La2
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> La2
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La2
                    com.ipotensic.baselib.DDLog.m1685e(r0, r3)     // Catch: java.lang.Throwable -> La2
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> La2
                    if (r2 == 0) goto La1
                    r2.close()     // Catch: java.lang.Exception -> L9d
                    goto La1
                L9d:
                    r0 = move-exception
                    r0.printStackTrace()
                La1:
                    return
                La2:
                    r0 = move-exception
                    r1 = r2
                La4:
                    if (r1 == 0) goto Lae
                    r1.close()     // Catch: java.lang.Exception -> Laa
                    goto Lae
                Laa:
                    r1 = move-exception
                    r1.printStackTrace()
                Lae:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.potensicpro.activities.PdfShowActivity.RunnableC28063.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAdapter() {
        PdfAdapter pdfAdapter = this.pdfAdapter;
        if (pdfAdapter != null) {
            pdfAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C2640R.id.btn_back) {
            finish();
            return;
        }
        if (id == C2640R.id.iv_share) {
            if (PhoneConfig.isConnectFlightWifi() || NetworkUtils.getNetworkState(this) < 0) {
                new GeneralDialog(this, getResources().getString(C2640R.string.txt_dialog_make_sure_internet_title), getResources().getString(C2640R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.4
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
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

    @Override // com.github.barteksc.pdfviewer.listener.OnPageChangeListener
    public void onPageChanged(int i, int i2) {
        DDLog.m1685e("PDF", "onPageChanged: " + i);
        this.pageNumber = i;
        this.tvPageNum.setText(String.format("%d / %d", Integer.valueOf(i + 1), Integer.valueOf(i2)));
        refreshAdapter();
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
    public void loadComplete(int i) {
        DDLog.m1685e("PDF", "loadComplete = " + i);
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnPageErrorListener
    public void onPageError(int i, Throwable th) {
        DDLog.m1685e("PDF", "can't open file !!");
    }

    private class PdfAdapter extends RecyclerView.Adapter<ViewHolder> {
        private OnItemClickListener onItemClickListener;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        private PdfAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(PdfShowActivity.this).inflate(C2640R.layout.adapter_pdf_item, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {
            if (i > PdfShowActivity.this.list.size() - 1) {
                return;
            }
            Bitmap bitmap = (Bitmap) PdfShowActivity.this.list.get(i);
            if (bitmap != null) {
                viewHolder.imgPdf.setImageBitmap(bitmap);
            }
            viewHolder.viewLine.setVisibility(PdfShowActivity.this.pageNumber == i ? 0 : 8);
            viewHolder.imgPdf.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.PdfShowActivity.PdfAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PdfAdapter.this.onItemClickListener != null) {
                        PdfAdapter.this.onItemClickListener.onItemClick(i);
                    }
                }
            });
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
                this.imgPdf = (ImageView) view.findViewById(C2640R.id.img_pdf);
                this.viewLine = view.findViewById(C2640R.id.view_line);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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