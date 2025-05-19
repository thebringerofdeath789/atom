package com.ipotensic.potensicpro.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.potensicpro.R;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class LogFileDialog extends Dialog {
    private Activity context;
    private File[] logFiles;
    private MyLogAdapter myLogAdapter;
    private RecyclerView recyclerView;

    public LogFileDialog(Activity activity) {
        super(activity);
        this.myLogAdapter = null;
        this.logFiles = null;
        this.context = activity;
        setContentView(R.layout.view_dialog_share_log_file);
        initData();
        setWindow();
        initView();
    }

    private void setWindow() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        getWindow().setLayout(displayMetrics.widthPixels, (displayMetrics.heightPixels / 4) * 3);
        setCanceledOnTouchOutside(false);
    }

    private void initData() {
        File file = new File(LocalFileManager.getInstance().getLogDir());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            this.logFiles = listFiles;
            if (listFiles == null) {
                dismiss();
            }
            Arrays.sort(this.logFiles, new Comparator<File>() { // from class: com.ipotensic.potensicpro.view.dialog.LogFileDialog.1
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    if (file2.lastModified() == file3.lastModified()) {
                        return 0;
                    }
                    return file2.lastModified() < file3.lastModified() ? 1 : -1;
                }
            });
            return;
        }
        dismiss();
    }

    private void initView() {
        if (this.logFiles != null) {
            findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.LogFileDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LogFileDialog.this.dismiss();
                }
            });
            this.recyclerView = (RecyclerView) findViewById(R.id.list_log_file);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            MyLogAdapter myLogAdapter = new MyLogAdapter();
            this.myLogAdapter = myLogAdapter;
            this.recyclerView.setAdapter(myLogAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareFile(File file) {
        new Share2.Builder((BaseActivity) this.context).setContentType(ShareContentType.FILE).setIsSingle(true).setShareFileUri(FileUtil.getFileUri(getContext(), ShareContentType.FILE, new File(file.getAbsolutePath()))).setTitle("SHARE WITH FRIENDS").build().shareBySystem();
    }

    public class MyLogAdapter extends RecyclerView.Adapter<MyTVHolder> {
        public MyLogAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyTVHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            TextView textView = new TextView(LogFileDialog.this.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, UnitUtil.dp2px(45)));
            return new MyTVHolder(textView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyTVHolder myTVHolder, final int i) {
            myTVHolder.mTextView.setBackground(LogFileDialog.this.getContext().getResources().getDrawable(R.drawable.bg_strock_bottom_black));
            myTVHolder.mTextView.setPadding(10, 0, 0, 0);
            myTVHolder.mTextView.getPaint().setFakeBoldText(true);
            myTVHolder.mTextView.setGravity(16);
            myTVHolder.mTextView.setText(LogFileDialog.this.logFiles[i].getName());
            myTVHolder.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.LogFileDialog.MyLogAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LogFileDialog.this.shareFile(new File(LogFileDialog.this.logFiles[i].getAbsolutePath()));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (LogFileDialog.this.logFiles == null) {
                return 0;
            }
            return LogFileDialog.this.logFiles.length;
        }

        class MyTVHolder extends RecyclerView.ViewHolder {
            TextView mTextView;

            MyTVHolder(TextView textView) {
                super(textView);
                this.mTextView = textView;
            }
        }
    }
}
