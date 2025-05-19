package com.ipotensic.baselib.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LoadingDialog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseKFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0006\u0010\u001b\u001a\u00020\u0016J\b\u0010\u001c\u001a\u00020\u0016H&J\b\u0010\u001d\u001a\u00020\u0016H&J\b\u0010\u001e\u001a\u00020\u0016H&J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\u001c\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J\u001c\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010 2\b\u0010+\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00104\u001a\u00020\u0016H\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00065"}, d2 = {"Lcom/ipotensic/baselib/base/BaseKFragment;", "VB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnTouchListener;", "Lcom/ipotensic/baselib/dispatcher/EventDispatcher$OnEventListener;", "()V", "loadingDialog", "Lcom/ipotensic/baselib/LoadingDialog;", "mBind", "getMBind", "()Landroidx/databinding/ViewDataBinding;", "setMBind", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", RtspHeaders.Values.TIME, "", "getTime", "()J", "setTime", "(J)V", "dismissLoadingDialog", "", "getLayoutId", "", "getLoadingDialog", "Landroid/app/Dialog;", "hideSoftKeyboard", "initData", "initListener", "initObserver", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEvent", "what", "Lcom/ipotensic/baselib/dispatcher/EventID;", NotificationCompat.CATEGORY_EVENT, "Lcom/ipotensic/baselib/dispatcher/Event;", "onResume", "onTouch", "", "v", "Landroid/view/MotionEvent;", "onViewCreated", "view", "showLoadingDialog", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class BaseKFragment<VB extends ViewDataBinding> extends Fragment implements View.OnTouchListener, EventDispatcher.OnEventListener {
    private HashMap _$_findViewCache;
    private LoadingDialog loadingDialog;
    protected VB mBind;
    private long time;

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

    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initListener();

    public abstract void initObserver();

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID what, Event event) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

    protected final VB getMBind() {
        VB vb = this.mBind;
        if (vb == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBind");
        }
        return vb;
    }

    protected final void setMBind(VB vb) {
        Intrinsics.checkParameterIsNotNull(vb, "<set-?>");
        this.mBind = vb;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        this.time = System.currentTimeMillis();
        EventDispatcher.get().registerEvent(getLifecycle(), this);
        VB vb = (VB) DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        Intrinsics.checkExpressionValueIsNotNull(vb, "DataBindingUtil.inflate(…utId(), container, false)");
        this.mBind = vb;
        if (vb == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBind");
        }
        return vb.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener(this);
        initData();
        initListener();
        initObserver();
    }

    protected void showLoadingDialog() {
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog == null && loadingDialog == null) {
            this.loadingDialog = new LoadingDialog(requireContext());
        }
        LoadingDialog loadingDialog2 = this.loadingDialog;
        if (loadingDialog2 == null) {
            Intrinsics.throwNpe();
        }
        if (loadingDialog2.isShowing()) {
            return;
        }
        LoadingDialog loadingDialog3 = this.loadingDialog;
        if (loadingDialog3 == null) {
            Intrinsics.throwNpe();
        }
        loadingDialog3.show();
    }

    protected Dialog getLoadingDialog() {
        return this.loadingDialog;
    }

    protected void dismissLoadingDialog() {
        LoadingDialog loadingDialog;
        LoadingDialog loadingDialog2 = this.loadingDialog;
        if (loadingDialog2 != null) {
            if (loadingDialog2 == null) {
                Intrinsics.throwNpe();
            }
            if (!loadingDialog2.isShowing() || (loadingDialog = this.loadingDialog) == null) {
                return;
            }
            loadingDialog.dismiss();
        }
    }

    public final void hideSoftKeyboard() {
        Object systemService = requireActivity().getSystemService("input_method");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        View requireView = requireView();
        Intrinsics.checkExpressionValueIsNotNull(requireView, "requireView()");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(requireView.getWindowToken(), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DDLog.d("BaseKFragment onResume:" + getClass().getCanonicalName() + " time=" + (System.currentTimeMillis() - this.time));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
    }
}
