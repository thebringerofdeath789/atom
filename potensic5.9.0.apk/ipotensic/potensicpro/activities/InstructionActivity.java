package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.view.DownloadFileDialog;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.InstructionActivity;
import com.ipotensic.potensicpro.view.DividerLineaItemDecoration;
import com.ipotensic.potensicpro.view.PDFDownloadProgressView;
import com.logan.flight.FlightConfig;
import com.logan.user.model.UserConstants;
import com.logan.user.model.rev.RevUserGetPdfResult;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IGetPdfView;
import java.io.File;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class InstructionActivity extends BaseActivity implements View.OnClickListener, IGetPdfView {
    private InstructionAdapter adapter;
    private DownloadFileDialog downloadDialog;
    private String flightModel;
    private ImageView ivBlank;
    private String language;
    private TextView tvNoNetWork;
    private List<RevUserGetPdfResult.Document> documents = new ArrayList();
    private List<FileItem> localFiles = new ArrayList();
    private List<RevUserGetPdfResult.Document> localDocuments = new ArrayList();
    private DecimalFormat dif = new DecimalFormat("0.00");
    private boolean isDownloading = false;
    private final String localPdfPath = LocalFileManager.getInstance().getPDF_DIR();

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_instruction);
        initView();
        try {
            getLocalPdfFile();
        } catch (Exception e) {
            DDLog.e("\u83b7\u53d6\u672c\u5730pdf\u62a5\u9519:" + e.getMessage());
        }
        getPdfFilesFromServer();
        setToolBar();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        ((TextView) toolbar.findViewById(R.id.tv_code_title)).setText(getResources().getString(R.string.main_instructions));
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        InstructionAdapter instructionAdapter = new InstructionAdapter();
        this.adapter = instructionAdapter;
        instructionAdapter.setHasStableIds(true);
        recyclerView.setAdapter(this.adapter);
        recyclerView.addItemDecoration(new DividerLineaItemDecoration(50));
        this.ivBlank = (ImageView) findViewById(R.id.iv_blank);
        this.tvNoNetWork = (TextView) findViewById(R.id.tv_no_network);
    }

    private void getPdfFilesFromServer() {
        if (PhoneConfig.usrToken != null) {
            showLoadingDialog();
            UserRequestPresenter.getInstance().getPdfList(PhoneConfig.usrToken, LanguageHelper.getLanguageType(this), this);
        }
    }

    private void getLocalPdfFile() throws Exception {
        File[] listFiles;
        File file = new File(getLocalPdfPath());
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                DDLog.e("pdf", " pdf \u6587\u4ef6\u540d name: " + file2.getName() + ", \u6587\u4ef6\u5927\u5c0f\uff1a " + file2.length());
                this.localFiles.add(new FileItem(file2.getName(), file2.length()));
            }
            String pdfInfo = SPHelper.getInstance().getPdfInfo(this.flightModel);
            if (pdfInfo != null) {
                this.localDocuments = (List) new Gson().fromJson(pdfInfo, new TypeToken<List<RevUserGetPdfResult.Document>>() { // from class: com.ipotensic.potensicpro.activities.InstructionActivity.1
                }.getType());
                DDLog.e("pdf", " SP \u4fdd\u5b58\u5728\u672c\u5730\u7684\u6587\u4ef6: " + this.localDocuments.toString());
            }
            if (this.localFiles.size() > 0 && this.localDocuments.size() > 0) {
                for (int i = 0; i < this.localFiles.size(); i++) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.localDocuments.size()) {
                            break;
                        }
                        if (this.localFiles.get(i).fileName.equals(getFileName(this.localDocuments.get(i2)))) {
                            DDLog.e("pdf", "\u672c\u5730\u6587\u4ef6\u5927\u5c0f\uff1a " + this.localFiles.get(i).fileSize + ", \u670d\u52a1\u5668\u6587\u4ef6\u5927\u5c0f\uff1a" + this.localDocuments.get(i2).getFilesize());
                            if (this.localFiles.get(i).fileSize == this.localDocuments.get(i2).getFilesize()) {
                                this.documents.add(this.localDocuments.get(i2));
                            } else {
                                DDLog.e("pdf", "\u6587\u4ef6\u5220\u9664\u6210\u529f\uff1a " + new File(getLocalPdfPath(), this.localFiles.get(i).fileName).delete());
                            }
                        } else {
                            i2++;
                        }
                    }
                }
                InstructionAdapter instructionAdapter = this.adapter;
                if (instructionAdapter != null) {
                    instructionAdapter.notifyDataSetChanged();
                }
            }
            DDLog.e("pdf", " localDocuments\u7684\u5927\u5c0f: " + this.localDocuments.size() + ", documents\u7684\u5927\u5c0f: " + this.documents.size());
        }
        if (this.documents.size() > 0) {
            this.ivBlank.setVisibility(8);
            this.tvNoNetWork.setVisibility(8);
        }
    }

    private class FileItem {
        private String fileName;
        private long fileSize;

        public FileItem(String str, long j) {
            this.fileName = str;
            this.fileSize = j;
        }
    }

    private boolean compareSize(String str, String str2) {
        try {
            return (str.contains(".") ? str.substring(0, str.indexOf(".")) : str).equals(str2.contains(".") ? str2.substring(0, str2.indexOf(".")) : str2);
        } catch (Exception e) {
            DDLog.e("\u5bf9\u6bd4\u51fa\u9519:" + e.getMessage());
            DDLog.e("file1:" + str);
            DDLog.e("file2:" + str2);
            return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            OkHttpUtil.getInstance().cancelDownload();
            setResult(-1, new Intent());
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        OkHttpUtil.getInstance().cancelDownload();
    }

    @Override // com.logan.user.view.IGetPdfView
    public void onGetPdfSuccess(List<RevUserGetPdfResult.Document> list) {
        if (list != null) {
            dismissLoadingDialog();
            this.documents = list;
            String json = new Gson().toJson(list);
            if (FlightConfig.getLastFlight() != null) {
                SPHelper.getInstance().setPdfInfo(FlightConfig.getLastFlightModel(), json);
            }
        }
        InstructionAdapter instructionAdapter = this.adapter;
        if (instructionAdapter != null) {
            instructionAdapter.notifyDataSetChanged();
        }
        if (list != null && list.size() > 0) {
            this.ivBlank.setVisibility(8);
            this.tvNoNetWork.setVisibility(8);
        } else {
            setNoContentUI();
        }
    }

    @Override // com.logan.user.view.IGetPdfView
    public void onGetPdfFailed(String str) {
        dismissLoadingDialog();
        InstructionAdapter instructionAdapter = this.adapter;
        if (instructionAdapter != null) {
            instructionAdapter.notifyDataSetChanged();
        }
        setNoNetworkUI();
    }

    @Override // com.logan.user.view.IGetPdfView
    public void onTokenError() {
        dismissLoadingDialog();
        setNoContentUI();
    }

    @Override // com.logan.user.view.IGetPdfView
    public void onProductNotFind() {
        dismissLoadingDialog();
        InstructionAdapter instructionAdapter = this.adapter;
        if (instructionAdapter != null) {
            instructionAdapter.notifyDataSetChanged();
        }
        setNoContentUI();
    }

    private void setNoContentUI() {
        this.ivBlank.setVisibility(0);
        this.tvNoNetWork.setVisibility(0);
        this.ivBlank.setImageResource(R.mipmap.icon_no_content);
        this.tvNoNetWork.setText(getText(R.string.txt_no_content));
    }

    private void setNoNetworkUI() {
        this.ivBlank.setVisibility(0);
        this.tvNoNetWork.setVisibility(0);
        this.ivBlank.setImageResource(R.mipmap.icon_no_network);
        this.tvNoNetWork.setText(getText(R.string.no_net_work));
    }

    private class InstructionAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        private InstructionAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(InstructionActivity.this).inflate(R.layout.view_adapter_instruction, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
            final RevUserGetPdfResult.Document document = (RevUserGetPdfResult.Document) InstructionActivity.this.documents.get(i);
            viewHolder.tvTitle.setText(document.getName());
            viewHolder.tvMessage.setText(document.getDetail());
            final boolean isDownloaded = InstructionActivity.this.isDownloaded(document);
            viewHolder.progressView.setTag(false);
            if (isDownloaded) {
                viewHolder.progressView.setText(InstructionActivity.this.getString(R.string.end_download));
            } else {
                viewHolder.progressView.setText(InstructionActivity.this.getString(R.string.start_download));
                viewHolder.progressView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.InstructionActivity.InstructionAdapter.1
                    @Override // com.ipotensic.baselib.listener.ScaleClickListener
                    public void click(View view) {
                        InstructionActivity.this.download(i, document, viewHolder.progressView);
                    }
                });
            }
            viewHolder.progressView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.InstructionActivity.InstructionAdapter.2
                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    if (!isDownloaded || ((Boolean) viewHolder.progressView.getTag()).booleanValue()) {
                        InstructionActivity.this.download(i, document, viewHolder.progressView);
                        return;
                    }
                    Intent intent = new Intent(InstructionActivity.this, (Class<?>) PdfShowActivity.class);
                    intent.putExtra(PdfShowActivity.FILE_PATH, new File(InstructionActivity.this.getLocalPdfPath(), InstructionActivity.this.getFileName(document)));
                    InstructionActivity.this.startActivity(intent);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return InstructionActivity.this.documents.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;
            private PDFDownloadProgressView progressView;
            private TextView tvMessage;
            private TextView tvTitle;

            private ViewHolder(View view) {
                super(view);
                this.tvTitle = (TextView) view.findViewById(R.id.tv_code_title);
                this.tvMessage = (TextView) view.findViewById(R.id.tv_message);
                this.imageView = (ImageView) view.findViewById(R.id.iv_img);
                this.progressView = (PDFDownloadProgressView) view.findViewById(R.id.progressView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDownloaded(RevUserGetPdfResult.Document document) {
        return new File(getLocalPdfPath(), getFileName(document)).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocalPdfPath() {
        this.flightModel = FlightConfig.getLastFlightModel();
        File file = new File(this.localPdfPath);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, this.flightModel);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download(int i, RevUserGetPdfResult.Document document, PDFDownloadProgressView pDFDownloadProgressView) {
        if (((Boolean) pDFDownloadProgressView.getTag()).booleanValue()) {
            return;
        }
        new Thread(new AnonymousClass2(document, pDFDownloadProgressView, i)).start();
    }

    /* renamed from: com.ipotensic.potensicpro.activities.InstructionActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ RevUserGetPdfResult.Document val$document;
        final /* synthetic */ int val$position;
        final /* synthetic */ PDFDownloadProgressView val$progressView;

        AnonymousClass2(RevUserGetPdfResult.Document document, PDFDownloadProgressView pDFDownloadProgressView, int i) {
            this.val$document = document;
            this.val$progressView = pDFDownloadProgressView;
            this.val$position = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DDLog.w("\u5f00\u59cb\u4e0b\u8f7d...");
                OkHttpUtil.getInstance().downloadFileSync(UserConstants.REQUEST_CODE_DOWNLOAD_PDF_FILE, this.val$document.getDownloadurl(), InstructionActivity.this.getLocalPdfPath(), InstructionActivity.this.getFileName(this.val$document), System.currentTimeMillis(), new AnonymousClass1());
            } catch (Exception e) {
                InstructionActivity.this.isDownloading = false;
                InstructionActivity instructionActivity = InstructionActivity.this;
                final PDFDownloadProgressView pDFDownloadProgressView = this.val$progressView;
                instructionActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$InstructionActivity$2$Eu2LRqvj0YZXMHh8l6nzcGgnCYA
                    @Override // java.lang.Runnable
                    public final void run() {
                        InstructionActivity.AnonymousClass2.this.lambda$run$0$InstructionActivity$2(pDFDownloadProgressView, e);
                    }
                });
            }
        }

        /* renamed from: com.ipotensic.potensicpro.activities.InstructionActivity$2$1, reason: invalid class name */
        class AnonymousClass1 implements DownloadListener {
            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void notEnoughSpace() {
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadEnd(String str, String str2) {
            }

            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadStart() {
                AnonymousClass2.this.val$progressView.setTag(true);
                InstructionActivity.this.isDownloading = true;
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadProgress(final float f, final long j) {
                InstructionActivity instructionActivity = InstructionActivity.this;
                final PDFDownloadProgressView pDFDownloadProgressView = AnonymousClass2.this.val$progressView;
                instructionActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$InstructionActivity$2$1$WF2tpgLMjHN5THu0na8BSyBFUis
                    @Override // java.lang.Runnable
                    public final void run() {
                        InstructionActivity.AnonymousClass2.AnonymousClass1.this.lambda$onDownloadProgress$0$InstructionActivity$2$1(f, j, pDFDownloadProgressView);
                    }
                });
            }

            public /* synthetic */ void lambda$onDownloadProgress$0$InstructionActivity$2$1(float f, long j, PDFDownloadProgressView pDFDownloadProgressView) {
                int i = (int) f;
                DDLog.e("pdf", "onDownloadProgress......" + i + ", \u4e0b\u8f7d\u603b\u5927\u5c0ftotal: " + j);
                pDFDownloadProgressView.setProgress(i);
                pDFDownloadProgressView.setText(InstructionActivity.this.getString(R.string.pdf_downloading) + "(" + i + "%)");
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadEnd(String str) {
                InstructionActivity instructionActivity = InstructionActivity.this;
                final PDFDownloadProgressView pDFDownloadProgressView = AnonymousClass2.this.val$progressView;
                final int i = AnonymousClass2.this.val$position;
                instructionActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$InstructionActivity$2$1$CBh0qNUiNehcY5UDZYX50x7YuHo
                    @Override // java.lang.Runnable
                    public final void run() {
                        InstructionActivity.AnonymousClass2.AnonymousClass1.this.lambda$onDownloadEnd$1$InstructionActivity$2$1(pDFDownloadProgressView, i);
                    }
                });
            }

            public /* synthetic */ void lambda$onDownloadEnd$1$InstructionActivity$2$1(PDFDownloadProgressView pDFDownloadProgressView, int i) {
                DDLog.e("pdf", "onDownloadFinished......");
                InstructionActivity.this.isDownloading = false;
                pDFDownloadProgressView.setTag(false);
                pDFDownloadProgressView.setText(InstructionActivity.this.getString(R.string.end_download));
                pDFDownloadProgressView.setProgress(0);
                ToastUtil.showImageTop(InstructionActivity.this, InstructionActivity.this.getResources().getString(R.string.toast_download_success), R.mipmap.icon_toast_successful);
                InstructionActivity.this.adapter.notifyItemChanged(i);
            }

            @Override // com.ipotensic.baselib.okhttp.DownloadListener
            public void onDownloadError(Exception exc) {
                InstructionActivity instructionActivity = InstructionActivity.this;
                final PDFDownloadProgressView pDFDownloadProgressView = AnonymousClass2.this.val$progressView;
                final RevUserGetPdfResult.Document document = AnonymousClass2.this.val$document;
                instructionActivity.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$InstructionActivity$2$1$CT-DSy2QNdsQ5gqiBjAqROV9uTU
                    @Override // java.lang.Runnable
                    public final void run() {
                        InstructionActivity.AnonymousClass2.AnonymousClass1.this.lambda$onDownloadError$2$InstructionActivity$2$1(pDFDownloadProgressView, document);
                    }
                });
            }

            public /* synthetic */ void lambda$onDownloadError$2$InstructionActivity$2$1(PDFDownloadProgressView pDFDownloadProgressView, RevUserGetPdfResult.Document document) {
                DDLog.e("pdf", "onDownloadError\u4e0b\u8f7d\u51fa\u9519......");
                InstructionActivity.this.isDownloading = false;
                pDFDownloadProgressView.setTag(false);
                pDFDownloadProgressView.setText(InstructionActivity.this.getString(R.string.start_download));
                pDFDownloadProgressView.setProgress(0);
                OkHttpUtil.getInstance().cancelDownload();
                File file = new File(InstructionActivity.this.localPdfPath, InstructionActivity.this.getFileName(document));
                if (file.exists()) {
                    file.delete();
                }
                ToastUtil.toast(InstructionActivity.this, InstructionActivity.this.getResources().getString(R.string.dialog_download_failure));
            }
        }

        public /* synthetic */ void lambda$run$0$InstructionActivity$2(PDFDownloadProgressView pDFDownloadProgressView, Exception exc) {
            pDFDownloadProgressView.setTag(false);
            if (exc instanceof UnknownHostException) {
                InstructionActivity instructionActivity = InstructionActivity.this;
                ToastUtil.toast(instructionActivity, instructionActivity.getString(R.string.toast_no_network));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFileName(RevUserGetPdfResult.Document document) {
        return document.getName() + ".pdf";
    }
}