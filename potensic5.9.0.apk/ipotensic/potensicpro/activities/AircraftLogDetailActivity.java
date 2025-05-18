package com.ipotensic.potensicpro.activities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.okhttp.OnUploadProgressListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.adapter.MyLinearLayoutManager;
import com.ipotensic.kernel.view.DownloadFileDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IFlightLogView;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AircraftLogDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivEmptyLog;
    private AircraftLogAdapter logAdapter;
    private RecyclerView rv;
    private TextView tvLogTips;
    private TextView tvNoRecord;
    private List<LogBean> logs = new ArrayList();
    private final Object deleteLock = new Object();

    private class LogBean {
        private String filePath;
        private boolean isSubmitted;

        public LogBean(String str, boolean z) {
            this.filePath = str;
            this.isSubmitted = z;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public void setFilePath(String str) {
            this.filePath = str;
        }

        public boolean isSubmitted() {
            return this.isSubmitted;
        }

        public void setSubmitted(boolean z) {
            this.isSubmitted = z;
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_aircraft_log);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("files");
        if (stringArrayExtra != null) {
            for (String str : stringArrayExtra) {
                this.logs.add(new LogBean(str, false));
            }
        }
        initView();
        initData();
        setToolBar();
    }

    private void initView() {
        this.ivEmptyLog = (ImageView) findViewById(R.id.iv_empty_log);
        this.tvLogTips = (TextView) findViewById(R.id.tv_log_tips);
        this.rv = (RecyclerView) findViewById(R.id.rv);
        this.tvNoRecord = (TextView) findViewById(R.id.tv_no_record);
        MyLinearLayoutManager myLinearLayoutManager = new MyLinearLayoutManager(this, 1, false);
        this.rv.addItemDecoration(new DividerLineaItemDecoration());
        this.rv.setLayoutManager(myLinearLayoutManager);
        AircraftLogAdapter aircraftLogAdapter = new AircraftLogAdapter();
        this.logAdapter = aircraftLogAdapter;
        this.rv.setAdapter(aircraftLogAdapter);
    }

    private void initData() {
        if (this.logs.size() == 0) {
            this.ivEmptyLog.setVisibility(0);
            this.tvLogTips.setVisibility(8);
            this.rv.setVisibility(8);
            this.tvNoRecord.setVisibility(0);
        }
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        ((TextView) toolbar.findViewById(R.id.tv_code_title)).setText(getResources().getString(R.string.main_aircraft_log));
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            finish();
        }
    }

    private class AircraftLogAdapter extends RecyclerView.Adapter<ViewHolder> {
        private AircraftLogAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(AircraftLogDetailActivity.this).inflate(R.layout.view_adapter_aircraft_log, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (i >= AircraftLogDetailActivity.this.logs.size()) {
                return;
            }
            LogBean logBean = (LogBean) AircraftLogDetailActivity.this.logs.get(i);
            File file = new File(logBean.getFilePath());
            if (file.exists()) {
                viewHolder.tvName.setText(file.getName());
                viewHolder.ivUpload.setImageResource(logBean.isSubmitted ? R.mipmap.icon_aircraft_log_uploaded : R.mipmap.icon_aircraft_log_upload_nor);
                viewHolder.ivUpload.setEnabled(!logBean.isSubmitted);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (AircraftLogDetailActivity.this.logs == null) {
                return 0;
            }
            return AircraftLogDetailActivity.this.logs.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadLog(final LogBean logBean, final int i, String str, String str2) {
            if (logBean == null || PhoneConfig.usrToken == null) {
                return;
            }
            String[] strArr = {logBean.getFilePath()};
            final DownloadFileDialog downloadFileDialog = new DownloadFileDialog(AircraftLogDetailActivity.this, 1, new DownloadFileDialog.CancelListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogDetailActivity.AircraftLogAdapter.1
                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void noEnoughMemory() {
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onDownloadError(String str3) {
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onDownloadFinished() {
                }

                @Override // com.ipotensic.kernel.view.DownloadFileDialog.CancelListener
                public void onCancelClicked() {
                    OkHttpUtil.getInstance().cancelUpload();
                }
            });
            downloadFileDialog.setShowDownloadSuccess(false);
            downloadFileDialog.setTitleVisible(8);
            downloadFileDialog.show();
            UserRequestPresenter.getInstance().flightLogs(PhoneConfig.usrToken, strArr, str, str2, new IFlightLogView() { // from class: com.ipotensic.potensicpro.activities.AircraftLogDetailActivity.AircraftLogAdapter.2
                @Override // com.logan.user.view.IFlightLogView
                public void uploadSuccess() {
                    ToastUtil.toast(AircraftLogDetailActivity.this, AircraftLogDetailActivity.this.getString(R.string.toast_upload_success));
                    DDLog.e("flightLog", "\u4e0a\u4f20\u6210\u529f");
                    downloadFileDialog.dismiss();
                    logBean.setSubmitted(true);
                    AircraftLogDetailActivity.this.logAdapter.notifyItemChanged(i);
                }

                @Override // com.logan.user.view.IFlightLogView
                public void tokenError() {
                    DDLog.e("flightLog", "token error");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void uploadError(Exception exc) {
                    if (exc instanceof UnknownHostException) {
                        ToastUtil.toast(AircraftLogDetailActivity.this, PhoneConfig.applicationContext.getString(R.string.toast_no_network));
                    } else {
                        ToastUtil.toast(AircraftLogDetailActivity.this, AircraftLogDetailActivity.this.getString(R.string.toast_upload_fail));
                    }
                    DDLog.e("flightLog", "uploaded error");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void fileIsExist() {
                    ToastUtil.toast(AircraftLogDetailActivity.this, AircraftLogDetailActivity.this.getString(R.string.toast_upload_file_exist));
                    DDLog.e("flightLog", "The uploaded file already exists!");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void notFrequentlyUpload() {
                    ToastUtil.toast(AircraftLogDetailActivity.this, AircraftLogDetailActivity.this.getString(R.string.toast_upload_not_frequently));
                    DDLog.e("flightLog", "Do not upload frequently!");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void missFiles() {
                    ToastUtil.toast(AircraftLogDetailActivity.this, AircraftLogDetailActivity.this.getString(R.string.toast_upload_miss_parameters));
                    DDLog.e("flightLog", "\u6587\u4ef6\u4e22\u5931");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void someFileMd5Err(String str3) {
                    downloadFileDialog.dismiss();
                }
            }, new OnUploadProgressListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogDetailActivity.AircraftLogAdapter.3
                private int curProgress = 0;

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onError(Exception exc) {
                }

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onStart() {
                    downloadFileDialog.getDownloadListener().onDownloadStart();
                }

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onProgress(float f, long j) {
                    int i2 = (int) (f * 100.0f);
                    if (i2 != this.curProgress) {
                        DDLog.e("progress:" + i2 + ",totalLen:" + j);
                        this.curProgress = i2;
                        downloadFileDialog.getDownloadListener().onDownloadProgress(this.curProgress, j);
                    }
                }

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onEnd() {
                    downloadFileDialog.getDownloadListener().onDownloadEnd(null);
                    AircraftLogDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.AircraftLogDetailActivity.AircraftLogAdapter.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            downloadFileDialog.dismiss();
                        }
                    });
                }
            });
        }

        private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ImageView ivUpload;
            private TextView tvName;

            private ViewHolder(View view) {
                super(view);
                this.tvName = (TextView) view.findViewById(R.id.tv_name);
                this.ivUpload = (ImageView) view.findViewById(R.id.iv_upload);
                view.findViewById(R.id.iv_share).setOnClickListener(this);
                view.findViewById(R.id.iv_upload).setOnClickListener(this);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int id = view.getId();
                int adapterPosition = getAdapterPosition();
                if (adapterPosition >= AircraftLogDetailActivity.this.logs.size()) {
                    return;
                }
                LogBean logBean = (LogBean) AircraftLogDetailActivity.this.logs.get(adapterPosition);
                final String filePath = logBean.getFilePath();
                if (id == R.id.iv_upload) {
                    AircraftLogAdapter.this.loadLog(logBean, adapterPosition, "", "");
                    return;
                }
                if (id == R.id.iv_share) {
                    if (PhoneConfig.isConnectFlightWifi() || NetworkUtils.getNetworkState(AircraftLogDetailActivity.this) < 0) {
                        new GeneralDialog(AircraftLogDetailActivity.this, AircraftLogDetailActivity.this.getResources().getString(R.string.txt_dialog_make_sure_internet_title), AircraftLogDetailActivity.this.getResources().getString(R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogDetailActivity.AircraftLogAdapter.ViewHolder.2
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }
                        }).show();
                        return;
                    } else {
                        PermissionUtil.requestStoragePermissionInShareWithDialog(AircraftLogDetailActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogDetailActivity.AircraftLogAdapter.ViewHolder.3
                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onDenied() {
                            }

                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onDeniedWithNeverAsk(String... strArr) {
                            }

                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                            public void onGrant() {
                                new Share2.Builder(AircraftLogDetailActivity.this).setContentType(ShareContentType.FILE).setTitle("SHARE WITH FRIENDS").setIsSingle(true).setShareFileUri(FileUtil.getFileUri(AircraftLogDetailActivity.this, ShareContentType.FILE, new File(filePath))).build().shareBySystem();
                            }
                        });
                        return;
                    }
                }
                if (id == R.id.iv_delete) {
                    synchronized (AircraftLogDetailActivity.this.deleteLock) {
                        File file = new File(filePath);
                        if (file.exists()) {
                            boolean delete = file.delete();
                            DDLog.e("\u5220\u9664\u65e5\u5fd7\u6587\u4ef6:" + file.getAbsolutePath());
                            DDLog.e("\u65e5\u5fd7\u6587\u4ef6\u662f\u5426\u5220\u9664\u6210\u529f:" + delete);
                        }
                        if (adapterPosition >= AircraftLogDetailActivity.this.logs.size()) {
                            return;
                        }
                        ToastUtil.toast(AircraftLogDetailActivity.this, AircraftLogDetailActivity.this.getString(R.string.toast_delete_success));
                        AircraftLogDetailActivity.this.logs.remove(AircraftLogDetailActivity.this.logs.get(adapterPosition));
                        AircraftLogAdapter.this.notifyItemChanged(adapterPosition);
                        if (AircraftLogDetailActivity.this.logs.size() == 0) {
                            AircraftLogDetailActivity.this.rv.setVisibility(8);
                            AircraftLogDetailActivity.this.tvLogTips.setVisibility(8);
                            AircraftLogDetailActivity.this.ivEmptyLog.setVisibility(0);
                            AircraftLogDetailActivity.this.tvNoRecord.setVisibility(0);
                        }
                    }
                }
            }
        }
    }

    private class DividerLineaItemDecoration extends RecyclerView.ItemDecoration {
        private DividerLineaItemDecoration() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
            Paint paint = new Paint();
            paint.setColor(-1);
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                canvas.drawRect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom(), paint);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.set(0, 0, 0, 20);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LocalFileManager.getInstance().clearCacheDir();
    }
}