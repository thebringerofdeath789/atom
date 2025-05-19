package com.ipotensic.potensicpro.view.dialog;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.kernel.adapter.MyLinearLayoutManager;
import com.ipotensic.mediagallery.ToastUtil;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.databinding.ViewDialogAppLogBinding;
import com.ipotensic.potensicpro.view.dialog.AppLogDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.text.lookup.StringLookupFactory;

/* compiled from: AppLogDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0016\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog;", "Landroid/app/Dialog;", "activity", "Lcom/ipotensic/baselib/base/BaseActivity;", "(Lcom/ipotensic/baselib/base/BaseActivity;)V", "getActivity", "()Lcom/ipotensic/baselib/base/BaseActivity;", "adapter", "Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog$LogAdapter;", "fileItems", "Ljava/util/ArrayList;", "Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog$FileItem;", "Lkotlin/collections/ArrayList;", "isSelectMode", "", "viewBinding", "Lcom/ipotensic/potensicpro/databinding/ViewDialogAppLogBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "scanLogDir", "BodyViewHolder", "FileItem", "LogAdapter", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AppLogDialog extends Dialog {
    private final BaseActivity activity;
    private final LogAdapter adapter;
    private final ArrayList<FileItem> fileItems;
    private boolean isSelectMode;
    private ViewDialogAppLogBinding viewBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLogDialog(BaseActivity activity) {
        super(activity, R.style.CustomDialog);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.activity = activity;
        this.fileItems = new ArrayList<>();
        this.adapter = new LogAdapter();
    }

    public final BaseActivity getActivity() {
        return this.activity;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        ViewDialogAppLogBinding inflate = ViewDialogAppLogBinding.inflate(getLayoutInflater());
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ViewDialogAppLogBinding.inflate(layoutInflater)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        setContentView(inflate.getRoot());
        Window window = getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        window.setLayout(-1, -1);
        ViewDialogAppLogBinding viewDialogAppLogBinding = this.viewBinding;
        if (viewDialogAppLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        viewDialogAppLogBinding.btnBack.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.AppLogDialog$onCreate$1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                AppLogDialog.this.dismiss();
            }
        });
        ViewDialogAppLogBinding viewDialogAppLogBinding2 = this.viewBinding;
        if (viewDialogAppLogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        viewDialogAppLogBinding2.btnSelect.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.AppLogDialog$onCreate$2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                AppLogDialog.LogAdapter logAdapter;
                AppLogDialog.this.isSelectMode = !r3.isSelectMode;
                if (!AppLogDialog.this.isSelectMode) {
                    Iterator it = AppLogDialog.this.fileItems.iterator();
                    while (it.hasNext()) {
                        ((AppLogDialog.FileItem) it.next()).setSelect(false);
                    }
                }
                logAdapter = AppLogDialog.this.adapter;
                logAdapter.notifyDataSetChanged();
            }
        });
        ViewDialogAppLogBinding viewDialogAppLogBinding3 = this.viewBinding;
        if (viewDialogAppLogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        viewDialogAppLogBinding3.btnShare.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.AppLogDialog$onCreate$3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Iterator it = AppLogDialog.this.fileItems.iterator();
                while (it.hasNext()) {
                    AppLogDialog.FileItem fileItem = (AppLogDialog.FileItem) it.next();
                    if (fileItem.isSelect()) {
                        arrayList.add(FileUtil.getFileUri(AppLogDialog.this.getContext(), ShareContentType.FILE, fileItem.getFile()));
                    }
                }
                if (arrayList.isEmpty()) {
                    ToastUtil.showToast(AppLogDialog.this.getContext(), "请选择需要分享的文件!!");
                } else {
                    new Share2.Builder(AppLogDialog.this.getActivity()).setContentType(ShareContentType.FILE).setIsSingle(false).setShareFileUriList(arrayList).setTitle("SHARE WITH FRIENDS").build().shareBySystem();
                }
            }
        });
        scanLogDir();
    }

    private final void scanLogDir() {
        File[] listFiles;
        LocalFileManager localFileManager = LocalFileManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
        File file = new File(localFileManager.getLogDir());
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        if (!(listFiles.length == 0)) {
            ArraysKt.reverse(listFiles);
            this.fileItems.clear();
            for (File file2 : listFiles) {
                ArrayList<FileItem> arrayList = this.fileItems;
                Intrinsics.checkExpressionValueIsNotNull(file2, "it[i]");
                arrayList.add(new FileItem(file2, false));
            }
            MyLinearLayoutManager myLinearLayoutManager = new MyLinearLayoutManager(getContext(), 1, false);
            ViewDialogAppLogBinding viewDialogAppLogBinding = this.viewBinding;
            if (viewDialogAppLogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            }
            RecyclerView recyclerView = viewDialogAppLogBinding.recyclerView;
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "viewBinding.recyclerView");
            recyclerView.setLayoutManager(myLinearLayoutManager);
            ViewDialogAppLogBinding viewDialogAppLogBinding2 = this.viewBinding;
            if (viewDialogAppLogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            }
            RecyclerView recyclerView2 = viewDialogAppLogBinding2.recyclerView;
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "viewBinding.recyclerView");
            recyclerView2.setAdapter(this.adapter);
        }
    }

    /* compiled from: AppLogDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog$LogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog$BodyViewHolder;", "(Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
    public final class LogAdapter extends RecyclerView.Adapter<BodyViewHolder> {
        public LogAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BodyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_app_log, parent, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…m_app_log, parent, false)");
            return new BodyViewHolder(inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(BodyViewHolder holder, final int position) {
            Intrinsics.checkParameterIsNotNull(holder, "holder");
            Object obj = AppLogDialog.this.fileItems.get(position);
            Intrinsics.checkExpressionValueIsNotNull(obj, "fileItems[position]");
            final FileItem fileItem = (FileItem) obj;
            holder.getTvLogName().setText(fileItem.getFile().getName());
            if (fileItem.isSelect()) {
                holder.getImgSelect().setImageResource(R.mipmap.icon_fb_checkbox_selected);
                holder.itemView.setBackgroundColor(AppLogDialog.this.getContext().getColor(R.color.color_kernel_top_state_green));
            } else {
                holder.getImgSelect().setImageResource(R.mipmap.icon_fb_checkbox_default);
                holder.itemView.setBackgroundColor(AppLogDialog.this.getContext().getColor(R.color.colorTransparent));
            }
            holder.getImgSelect().setSelected(fileItem.isSelect());
            final boolean z = false;
            holder.getImgSelect().setVisibility(AppLogDialog.this.isSelectMode ? 0 : 8);
            holder.itemView.setOnClickListener(new ScaleClickListener(z) { // from class: com.ipotensic.potensicpro.view.dialog.AppLogDialog$LogAdapter$onBindViewHolder$1
                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    if (AppLogDialog.this.isSelectMode) {
                        fileItem.setSelect(!r2.isSelect());
                        AppLogDialog.LogAdapter.this.notifyItemChanged(position);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AppLogDialog.this.fileItems.size();
        }
    }

    /* compiled from: AppLogDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog$BodyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imgSelect", "Landroid/widget/ImageView;", "getImgSelect", "()Landroid/widget/ImageView;", "tvLogName", "Landroid/widget/TextView;", "getTvLogName", "()Landroid/widget/TextView;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
    public static final class BodyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgSelect;
        private final TextView tvLogName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BodyViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "view");
            View findViewById = view.findViewById(R.id.tv_log_name);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.tv_log_name)");
            this.tvLogName = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.cb_select);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.cb_select)");
            this.imgSelect = (ImageView) findViewById2;
        }

        public final TextView getTvLogName() {
            return this.tvLogName;
        }

        public final ImageView getImgSelect() {
            return this.imgSelect;
        }
    }

    /* compiled from: AppLogDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/ipotensic/potensicpro/view/dialog/AppLogDialog$FileItem;", "", StringLookupFactory.KEY_FILE, "Ljava/io/File;", "isSelect", "", "(Ljava/io/File;Z)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "()Z", "setSelect", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
    public static final /* data */ class FileItem {
        private File file;
        private boolean isSelect;

        public static /* synthetic */ FileItem copy$default(FileItem fileItem, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                file = fileItem.file;
            }
            if ((i & 2) != 0) {
                z = fileItem.isSelect;
            }
            return fileItem.copy(file, z);
        }

        /* renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelect() {
            return this.isSelect;
        }

        public final FileItem copy(File file, boolean isSelect) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            return new FileItem(file, isSelect);
        }

        public boolean equals(Object other) {
            if (this != other) {
                if (other instanceof FileItem) {
                    FileItem fileItem = (FileItem) other;
                    if (Intrinsics.areEqual(this.file, fileItem.file)) {
                        if (this.isSelect == fileItem.isSelect) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            File file = this.file;
            int hashCode = (file != null ? file.hashCode() : 0) * 31;
            boolean z = this.isSelect;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "FileItem(file=" + this.file + ", isSelect=" + this.isSelect + ")";
        }

        public FileItem(File file, boolean z) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            this.file = file;
            this.isSelect = z;
        }

        public /* synthetic */ FileItem(File file, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(file, (i & 2) != 0 ? false : z);
        }

        public final File getFile() {
            return this.file;
        }

        public final boolean isSelect() {
            return this.isSelect;
        }

        public final void setFile(File file) {
            Intrinsics.checkParameterIsNotNull(file, "<set-?>");
            this.file = file;
        }

        public final void setSelect(boolean z) {
            this.isSelect = z;
        }
    }
}
