package com.ipotensic.kernel.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0000H&J\u0010\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u00100\u001a\u00020\u0006J\u0010\u00101\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H&J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u000fH\u0016J\u0014\u00106\u001a\u00020(2\n\b\u0001\u00107\u001a\u0004\u0018\u000108H\u0016J(\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0001\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0001\u00107\u001a\u0004\u0018\u000108H\u0017J\b\u0010>\u001a\u00020(H\u0016J\b\u0010?\u001a\u00020(H\u0016J\u000e\u0010@\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010A\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\u0015J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0015J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u001eJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u001eJ\u0016\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0006J\b\u0010M\u001a\u00020\u0006H&J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00068\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/BaseDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "destroyListener", "Lcom/ipotensic/kernel/view/dialog/BaseDialog$OnDialogDestroyListener;", "level", "", "mActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getMActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setMActivity", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mAnimStyle", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mDimAmount", "", "mHeight", "mLayoutResId", "getMLayoutResId", "()I", "setMLayoutResId", "(I)V", "mMargin", "mOutCancel", "", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mShowBottomEnable", "mWidth", "clearFocusNotAle", "", "window", "Landroid/view/Window;", "convertView", "holder", "Lcom/ipotensic/kernel/view/dialog/BaseDialogViewHolder;", "dialog", "focusNotAle", "getLevel", "hideNavigationBar", "initParams", "initSize", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDestroy", "onStart", "setDestroyListener", "setDimAmount", "dimAmount", "setLevel", "setMargin", "margin", "setOutCancel", "outCancel", "setShowBottom", "showBottom", "setSize", "width", "height", "setUpLayoutId", "show", "activity", "Companion", "OnDialogDestroyListener", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class BaseDialog extends DialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HashMap _$_findViewCache;
    private OnDialogDestroyListener destroyListener;
    private int level;
    public AppCompatActivity mActivity;
    private int mAnimStyle;
    public Context mContext;
    private int mHeight;
    private int mLayoutResId;
    private float mMargin;
    public View mRootView;
    private boolean mShowBottomEnable;
    private int mWidth;
    private float mDimAmount = 0.5f;
    private boolean mOutCancel = true;

    /* compiled from: BaseDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/BaseDialog$OnDialogDestroyListener;", "", "onDialogDestroy", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public interface OnDialogDestroyListener {
        void onDialogDestroy();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public abstract void convertView(BaseDialogViewHolder holder, BaseDialog dialog);

    public abstract void initSize();

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public abstract int setUpLayoutId();

    protected final int getMLayoutResId() {
        return this.mLayoutResId;
    }

    protected final void setMLayoutResId(int i) {
        this.mLayoutResId = i;
    }

    public final AppCompatActivity getMActivity() {
        AppCompatActivity appCompatActivity = this.mActivity;
        if (appCompatActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        }
        return appCompatActivity;
    }

    public final void setMActivity(AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "<set-?>");
        this.mActivity = appCompatActivity;
    }

    public final Context getMContext() {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public final View getMRootView() {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        return view;
    }

    public final void setMRootView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.mRootView = view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        this.mContext = context;
        this.mActivity = (AppCompatActivity) context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.CustomDialog);
        this.mLayoutResId = setUpLayoutId();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        View inflate = inflater.inflate(this.mLayoutResId, container, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "inflater.inflate(mLayoutResId, container, false)");
        this.mRootView = inflate;
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        convertView(new BaseDialogViewHolder(view), this);
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        return view2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window it;
        Dialog dialog = getDialog();
        if (dialog != null && (it = dialog.getWindow()) != null) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            focusNotAle(it);
            super.onStart();
            hideNavigationBar(it);
            clearFocusNotAle(it);
        }
        initParams();
    }

    private final void initParams() {
        initSize();
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = this.mDimAmount;
            if (this.mShowBottomEnable) {
                attributes.gravity = 80;
            } else {
                attributes.gravity = 17;
            }
            attributes.horizontalMargin = this.mMargin;
            int i = this.mWidth;
            if (i == 0) {
                Companion companion = INSTANCE;
                if (this.mContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                }
                attributes.width = (int) (companion.getScreenWidth(r3) * 0.45d);
            } else {
                attributes.width = i;
            }
            int i2 = this.mHeight;
            if (i2 == 0) {
                attributes.height = -2;
            } else {
                attributes.height = i2;
            }
            int i3 = this.mAnimStyle;
            if (i3 != 0) {
                window.setWindowAnimations(i3);
            }
            window.setAttributes(attributes);
        }
        setCancelable(this.mOutCancel);
    }

    public final BaseDialog setDimAmount(float dimAmount) {
        this.mDimAmount = dimAmount;
        return this;
    }

    public final BaseDialog setShowBottom(boolean showBottom) {
        this.mShowBottomEnable = showBottom;
        return this;
    }

    public final BaseDialog setSize(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
        return this;
    }

    public final BaseDialog setMargin(float margin) {
        this.mMargin = margin;
        return this;
    }

    public final BaseDialog setLevel(int level) {
        this.level = level;
        return this;
    }

    public final int getLevel() {
        return this.level;
    }

    public final BaseDialog setOutCancel(boolean outCancel) {
        this.mOutCancel = outCancel;
        return this;
    }

    public final BaseDialog show(AppCompatActivity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        super.show(activity.getSupportFragmentManager(), String.valueOf(System.currentTimeMillis()));
        return this;
    }

    public void hideNavigationBar(final Window window) {
        Intrinsics.checkParameterIsNotNull(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "window.decorView");
        decorView.setSystemUiVisibility(2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.ipotensic.kernel.view.dialog.BaseDialog$hideNavigationBar$1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                View decorView2 = window.getDecorView();
                Intrinsics.checkExpressionValueIsNotNull(decorView2, "window.decorView");
                decorView2.setSystemUiVisibility(5894);
            }
        });
    }

    public void focusNotAle(Window window) {
        Intrinsics.checkParameterIsNotNull(window, "window");
        window.setFlags(8, 8);
    }

    public void clearFocusNotAle(Window window) {
        Intrinsics.checkParameterIsNotNull(window, "window");
        window.clearFlags(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OnDialogDestroyListener onDialogDestroyListener = this.destroyListener;
        if (onDialogDestroyListener != null) {
            onDialogDestroyListener.onDialogDestroy();
        }
        DDLog.d("AppDialogManager", "onDestroy");
    }

    public final void setDestroyListener(OnDialogDestroyListener destroyListener) {
        Intrinsics.checkParameterIsNotNull(destroyListener, "destroyListener");
        this.destroyListener = destroyListener;
    }

    /* compiled from: BaseDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/BaseDialog$Companion;", "", "()V", "getScreenWidth", "", "context", "Landroid/content/Context;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getScreenWidth(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Resources resources = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Intrinsics.checkExpressionValueIsNotNull(displayMetrics, "context.resources.displayMetrics");
            return displayMetrics.widthPixels;
        }
    }
}
