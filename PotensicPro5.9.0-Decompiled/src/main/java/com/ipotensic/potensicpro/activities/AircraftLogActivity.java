package com.ipotensic.potensicpro.activities;

import android.content.Intent;
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
import com.ipotensic.baselib.utils.DateUtils;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.adapter.MyLinearLayoutManager;
import com.ipotensic.kernel.view.DownloadFileDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import com.leo618.zip.IZipCallback;
import com.leo618.zip.ZipManager;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IFlightLogView;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class AircraftLogActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivEmptyLog;
    private AircraftLogAdapter logAdapter;
    private RecyclerView rv;
    private TextView tvLogTips;
    private TextView tvNoRecord;
    private List<LogBean> logs = new ArrayList();
    private HashMap<String, List<String>> fileList = new HashMap<>();
    private final Object deleteLock = new Object();

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_aircraft_log);
        initView();
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

    /* JADX INFO: Access modifiers changed from: private */
    public File[] getFiles() {
        File file = new File(LocalFileManager.getInstance().getFlightLogDir());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.1
            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return true;
            }

            @Override // java.util.Comparator
            public int compare(File file2, File file3) {
                long lastModified = file2.lastModified() - file3.lastModified();
                if (lastModified > 0) {
                    return -1;
                }
                return lastModified == 0 ? 0 : 1;
            }
        });
        return listFiles;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        showLoadingDialog();
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.2
            @Override // java.lang.Runnable
            public void run() {
                File[] files = AircraftLogActivity.this.getFiles();
                AircraftLogActivity.this.logs.clear();
                AircraftLogActivity.this.fileList.clear();
                DDLog.e("日志文件集合:" + files);
                if (files != null && files.length > 0) {
                    DDLog.e("日志文件集合1:" + files.length);
                    ArrayList arrayList = new ArrayList();
                    int length = files.length;
                    long j = 0;
                    int i = 0;
                    while (i < length) {
                        File file = files[i];
                        DDLog.e("日志文件:" + file.getAbsolutePath());
                        long lastModified = file.lastModified();
                        try {
                            if (!DateUtils.isSameDay(j, lastModified)) {
                                arrayList.add(file.getAbsolutePath());
                            }
                        } catch (Exception unused) {
                            DDLog.e("添加文件报错:" + file.getAbsolutePath());
                        }
                        i++;
                        j = lastModified;
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        try {
                            File file2 = new File((String) arrayList.get(i2));
                            ArrayList arrayList2 = new ArrayList();
                            for (File file3 : files) {
                                if (DateUtils.isSameDay(file3.lastModified(), file2.lastModified())) {
                                    arrayList2.add(file3.getAbsolutePath());
                                }
                            }
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                String flightTypeByFileName = AircraftLogActivity.this.getFlightTypeByFileName(new File((String) it.next()).getName());
                                boolean z = false;
                                for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                                    if (((String) arrayList3.get(i3)).equals(flightTypeByFileName)) {
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    arrayList3.add(flightTypeByFileName);
                                }
                            }
                            for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                                String str = (String) arrayList3.get(i4);
                                ArrayList arrayList4 = new ArrayList();
                                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                                    if (str.equals(AircraftLogActivity.this.getFlightTypeByFileName(new File((String) arrayList2.get(i5)).getName()))) {
                                        arrayList4.add(arrayList2.get(i5));
                                    }
                                }
                                String str2 = FormatUtil.formatCreateTime3(new File((String) arrayList4.get(arrayList4.size() - 1)).lastModified()) + "-" + str + "-Drone";
                                AircraftLogActivity.this.logs.add(AircraftLogActivity.this.new LogBean(str2, false));
                                AircraftLogActivity.this.fileList.put(str2, arrayList4);
                            }
                        } catch (Exception e) {
                            DDLog.e("解析日志出错:" + e.getMessage());
                        }
                    }
                    DDLog.e("fileList:" + AircraftLogActivity.this.fileList.size());
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (AircraftLogActivity.this.isFinishing()) {
                    return;
                }
                AircraftLogActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AircraftLogActivity.this.dismissLoadingDialog();
                            if (AircraftLogActivity.this.logs.size() == 0) {
                                AircraftLogActivity.this.ivEmptyLog.setVisibility(0);
                                AircraftLogActivity.this.tvLogTips.setVisibility(8);
                                AircraftLogActivity.this.rv.setVisibility(8);
                                AircraftLogActivity.this.tvNoRecord.setVisibility(0);
                            }
                            AircraftLogActivity.this.logAdapter.notifyDataSetChanged();
                        } catch (Exception unused2) {
                        }
                    }
                });
            }
        }).start();
    }

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

    /* JADX INFO: Access modifiers changed from: private */
    public String getFlightTypeByFileName(String str) {
        try {
            int i = 0;
            if (str.contains("(") && str.contains(")")) {
                str = str.substring(0, str.indexOf("(")) + str.substring(str.indexOf(")") + 2);
            }
            if (str.contains(LocalFileManager.ANDROID_TAG)) {
                str = str.substring(0, str.indexOf(LocalFileManager.ANDROID_TAG)) + str.substring(str.lastIndexOf("-"), str.length());
            }
            String[] split = str.split("-");
            int i2 = 0;
            while (true) {
                if (i2 >= split.length) {
                    i2 = 0;
                    break;
                }
                try {
                    Long.parseLong(split[i2]);
                    break;
                } catch (Exception unused) {
                    i2++;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (i2 == 0) {
                while (i < split.length) {
                    if (i != 0 && i != split.length - 1) {
                        sb.append(split[i]);
                        if (i != split.length - 2) {
                            sb.append("-");
                        }
                    }
                    i++;
                }
                return sb.toString();
            }
            while (i < split.length && i != i2) {
                sb.append(split[i]);
                i++;
            }
            return sb.toString();
        } catch (Exception unused2) {
            return "null";
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
            setResult(-1, new Intent());
            finish();
        }
    }

    private class AircraftLogAdapter extends RecyclerView.Adapter<ViewHolder> {
        private AircraftLogAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(AircraftLogActivity.this).inflate(R.layout.view_adapter_aircraft_log, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (i >= AircraftLogActivity.this.logs.size()) {
                return;
            }
            LogBean logBean = (LogBean) AircraftLogActivity.this.logs.get(i);
            viewHolder.tvName.setText(new File(logBean.getFilePath()).getName());
            viewHolder.ivUpload.setImageResource(logBean.isSubmitted ? R.mipmap.icon_aircraft_log_uploaded : R.mipmap.icon_aircraft_log_upload_nor);
            viewHolder.ivUpload.setEnabled(!logBean.isSubmitted);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (AircraftLogActivity.this.logs == null) {
                return 0;
            }
            return AircraftLogActivity.this.logs.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadLog(final LogBean logBean, final int i, String str, String str2) {
            List list = (List) AircraftLogActivity.this.fileList.get(logBean.getFilePath());
            if (list == null || PhoneConfig.usrToken == null) {
                return;
            }
            String[] strArr = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                strArr[i2] = (String) list.get(i2);
                try {
                    File file = new File(strArr[i2]);
                    if (file.exists()) {
                        DDLog.e("upload file len:" + file.length());
                    }
                    DDLog.e("upload files:" + strArr[i2]);
                } catch (Exception unused) {
                }
            }
            final DownloadFileDialog downloadFileDialog = new DownloadFileDialog(AircraftLogActivity.this, 1, new DownloadFileDialog.CancelListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.AircraftLogAdapter.1
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
            UserRequestPresenter.getInstance().flightLogs(PhoneConfig.usrToken, strArr, str, str2, new IFlightLogView() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.AircraftLogAdapter.2
                @Override // com.logan.user.view.IFlightLogView
                public void uploadSuccess() {
                    ToastUtil.toast(AircraftLogActivity.this, AircraftLogActivity.this.getString(R.string.toast_upload_success));
                    AircraftLogActivity.this.getFiles();
                    DDLog.e("flightLog", "保存成功");
                    downloadFileDialog.dismiss();
                    logBean.setSubmitted(true);
                    AircraftLogActivity.this.logAdapter.notifyItemChanged(i);
                }

                @Override // com.logan.user.view.IFlightLogView
                public void tokenError() {
                    DDLog.e("flightLog", "token error");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void uploadError(Exception exc) {
                    if (exc instanceof UnknownHostException) {
                        ToastUtil.toast(AircraftLogActivity.this, PhoneConfig.applicationContext.getString(R.string.toast_no_network));
                    } else {
                        ToastUtil.toast(AircraftLogActivity.this, AircraftLogActivity.this.getString(R.string.toast_upload_fail));
                    }
                    DDLog.e("flightLog", "uploaded error");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void fileIsExist() {
                    ToastUtil.toast(AircraftLogActivity.this, AircraftLogActivity.this.getString(R.string.toast_upload_file_exist));
                    DDLog.e("flightLog", "The uploaded file already exists!");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void notFrequentlyUpload() {
                    ToastUtil.toast(AircraftLogActivity.this, AircraftLogActivity.this.getString(R.string.toast_upload_not_frequently));
                    DDLog.e("flightLog", "Do not upload frequently!");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void missFiles() {
                    ToastUtil.toast(AircraftLogActivity.this, AircraftLogActivity.this.getString(R.string.toast_upload_miss_parameters));
                    DDLog.e("flightLog", "文件丢失");
                    downloadFileDialog.dismiss();
                }

                @Override // com.logan.user.view.IFlightLogView
                public void someFileMd5Err(String str3) {
                    downloadFileDialog.dismiss();
                }
            }, new OnUploadProgressListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.AircraftLogAdapter.3
                private int curProgress = 0;

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onStart() {
                    downloadFileDialog.getDownloadListener().onDownloadStart();
                }

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onProgress(float f, long j) {
                    int i3 = (int) (f * 100.0f);
                    if (i3 != this.curProgress) {
                        DDLog.e("progress:" + i3 + ",totalLen:" + j);
                        this.curProgress = i3;
                        downloadFileDialog.getDownloadListener().onDownloadProgress(this.curProgress, j);
                    }
                }

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onEnd() {
                    downloadFileDialog.getDownloadListener().onDownloadEnd(null);
                    AircraftLogActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.AircraftLogAdapter.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            downloadFileDialog.dismiss();
                        }
                    });
                }

                @Override // com.ipotensic.baselib.okhttp.OnUploadProgressListener
                public void onError(Exception exc) {
                    DDLog.e("flightLog", "上传失败:" + exc);
                }
            });
        }

        private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ImageView ivUpload;
            private TextView tvName;

            private ViewHolder(View view) {
                super(view);
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                this.tvName = textView;
                textView.setOnClickListener(this);
                this.ivUpload = (ImageView) view.findViewById(R.id.iv_upload);
                view.findViewById(R.id.iv_share).setOnClickListener(this);
                view.findViewById(R.id.iv_upload).setOnClickListener(this);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    int id = view.getId();
                    int adapterPosition = getAdapterPosition();
                    String charSequence = this.tvName.getText().toString();
                    if (id == R.id.iv_upload) {
                        DDLog.e("name:" + this.tvName.getText().toString());
                        AircraftLogAdapter aircraftLogAdapter = AircraftLogAdapter.this;
                        aircraftLogAdapter.loadLog((LogBean) AircraftLogActivity.this.logs.get(adapterPosition), adapterPosition, "", "");
                        return;
                    }
                    if (id == R.id.iv_share) {
                        if (!PhoneConfig.isConnectFlightWifi() && NetworkUtils.getNetworkState(AircraftLogActivity.this) >= 0) {
                            List list = (List) AircraftLogActivity.this.fileList.get(charSequence);
                            if (list == null) {
                                DDLog.e("日志文件为空");
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < list.size(); i++) {
                                File file = new File((String) list.get(i));
                                if (file.exists()) {
                                    arrayList.add(file);
                                }
                            }
                            final String str = LocalFileManager.getInstance().getCacheDir() + File.separator + charSequence + ".zip";
                            ZipManager.zip((ArrayList<File>) arrayList, str, new IZipCallback() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.AircraftLogAdapter.ViewHolder.2
                                @Override // com.leo618.zip.IZipCallback
                                public void onProgress(int i2) {
                                }

                                @Override // com.leo618.zip.IZipCallback
                                public void onStart() {
                                    AircraftLogActivity.this.showLoadingDialog();
                                }

                                @Override // com.leo618.zip.IZipCallback
                                public void onFinish(boolean z) {
                                    AircraftLogActivity.this.dismissLoadingDialog();
                                    if (z) {
                                        PermissionUtil.requestStoragePermissionInShareWithDialog(AircraftLogActivity.this, new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.AircraftLogAdapter.ViewHolder.2.1
                                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                                            public void onDenied() {
                                            }

                                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                                            public void onDeniedWithNeverAsk(String... strArr) {
                                            }

                                            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                                            public void onGrant() {
                                                new Share2.Builder(AircraftLogActivity.this).setContentType(ShareContentType.FILE).setTitle("SHARE WITH FRIENDS").setIsSingle(true).setShareFileUri(FileUtil.getFileUri(AircraftLogActivity.this, ShareContentType.FILE, new File(str))).build().shareBySystem();
                                            }
                                        });
                                    }
                                }
                            });
                            return;
                        }
                        new GeneralDialog(AircraftLogActivity.this, AircraftLogActivity.this.getResources().getString(R.string.txt_dialog_make_sure_internet_title), AircraftLogActivity.this.getResources().getString(R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.AircraftLogActivity.AircraftLogAdapter.ViewHolder.1
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }
                        }).show();
                        return;
                    }
                    if (id != R.id.tv_name && id == R.id.iv_delete) {
                        synchronized (AircraftLogActivity.this.deleteLock) {
                            try {
                                List list2 = (List) AircraftLogActivity.this.fileList.get(charSequence);
                                for (int i2 = 0; i2 < list2.size(); i2++) {
                                    new File((String) list2.get(i2)).delete();
                                }
                                AircraftLogActivity.this.fileList.remove(charSequence);
                            } catch (Exception unused) {
                            }
                            if (adapterPosition >= AircraftLogActivity.this.logs.size()) {
                                return;
                            }
                            ToastUtil.toast(AircraftLogActivity.this, AircraftLogActivity.this.getString(R.string.toast_delete_success));
                            AircraftLogActivity.this.logs.remove(AircraftLogActivity.this.logs.get(adapterPosition));
                            AircraftLogAdapter.this.notifyItemChanged(adapterPosition);
                            AircraftLogActivity.this.getFiles();
                            if (AircraftLogActivity.this.logs.size() == 0) {
                                AircraftLogActivity.this.rv.setVisibility(8);
                                AircraftLogActivity.this.tvLogTips.setVisibility(8);
                                AircraftLogActivity.this.ivEmptyLog.setVisibility(0);
                                AircraftLogActivity.this.tvNoRecord.setVisibility(0);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void toDetail(String str) {
        try {
            List<String> list = this.fileList.get(str);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i);
            }
            Intent intent = new Intent(this, (Class<?>) AircraftLogDetailActivity.class);
            intent.putExtra("files", strArr);
            startActivity(intent);
        } catch (Exception unused) {
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
