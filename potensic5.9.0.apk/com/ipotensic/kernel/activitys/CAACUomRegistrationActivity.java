package com.ipotensic.kernel.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.atom.common.extensions.ContextExtends;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.extensions.ViewExtends;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ActivityCaacUomRegistrationBinding;
import com.ipotensic.kernel.model.CAACUomRegistrationViewModel;
import com.ipotensic.kernel.view.blur.BlurView;
import com.ipotensic.kernel.view.blur.BlurViewFacade;
import com.ipotensic.kernel.view.dialog.AppDialogManager;
import com.logan.flight.type.Flight;
import com.logan.uom.UomConfig;
import com.logan.uom.utils.UomConvert;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: CAACUomRegistrationActivity.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m2338d2 = {"Lcom/ipotensic/kernel/activitys/CAACUomRegistrationActivity;", "Lcom/ipotensic/baselib/base/BaseActivity;", "()V", "caacUomViewModel", "Lcom/ipotensic/kernel/model/CAACUomRegistrationViewModel;", "getCaacUomViewModel", "()Lcom/ipotensic/kernel/model/CAACUomRegistrationViewModel;", "caacUomViewModel$delegate", "Lkotlin/Lazy;", "viewBinding", "Lcom/ipotensic/kernel/databinding/ActivityCaacUomRegistrationBinding;", "initData", "", "initListener", "initObserver", "isNewFullScreenPage", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showCaacTipDialog", "showDownloadQRCodeEnlarge", "showInfoQRCodeEnlarge", "Companion", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CAACUomRegistrationActivity extends BaseActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CAACUomRegistrationActivity.class), "caacUomViewModel", "getCaacUomViewModel()Lcom/ipotensic/kernel/model/CAACUomRegistrationViewModel;"))};
    public static final String FLIGHT_SN_INTENT_KEY = "flightSN";
    public static final String FLIGHT_TYPE_INTENT_KEY = "flightType";
    private HashMap _$_findViewCache;

    /* renamed from: caacUomViewModel$delegate, reason: from kotlin metadata */
    private final Lazy caacUomViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CAACUomRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$$special$$inlined$viewModels$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$$special$$inlined$viewModels$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
            Intrinsics.checkExpressionValueIsNotNull(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });
    private ActivityCaacUomRegistrationBinding viewBinding;

    /* JADX INFO: Access modifiers changed from: private */
    public final CAACUomRegistrationViewModel getCaacUomViewModel() {
        Lazy lazy = this.caacUomViewModel;
        KProperty kProperty = $$delegatedProperties[0];
        return (CAACUomRegistrationViewModel) lazy.getValue();
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity
    public boolean isNewFullScreenPage() {
        return true;
    }

    public CAACUomRegistrationActivity() {
    }

    public static final /* synthetic */ ActivityCaacUomRegistrationBinding access$getViewBinding$p(CAACUomRegistrationActivity cAACUomRegistrationActivity) {
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding = cAACUomRegistrationActivity.viewBinding;
        if (activityCaacUomRegistrationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        return activityCaacUomRegistrationBinding;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullscreen();
        ActivityCaacUomRegistrationBinding inflate = ActivityCaacUomRegistrationBinding.inflate(LayoutInflater.from(this));
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ActivityCaacUomRegistrat…ayoutInflater.from(this))");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        setContentView(inflate.getRoot());
        initData();
        initListener();
        initObserver();
    }

    private final void initData() {
        String stringExtra = getIntent().getStringExtra(FLIGHT_TYPE_INTENT_KEY);
        String stringExtra2 = getIntent().getStringExtra(FLIGHT_SN_INTENT_KEY);
        if (stringExtra != null && stringExtra2 != null) {
            getCaacUomViewModel().getFlightSN().setValue(new Pair<>(Flight.valueOf(stringExtra), stringExtra2));
        }
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding = this.viewBinding;
        if (activityCaacUomRegistrationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        BlurView blurView = activityCaacUomRegistrationBinding.downloadBlurView;
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding2 = this.viewBinding;
        if (activityCaacUomRegistrationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        BlurViewFacade blurRadius = blurView.setupWith(activityCaacUomRegistrationBinding2.getRoot()).setBlurRadius(15.0f);
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding3 = this.viewBinding;
        if (activityCaacUomRegistrationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        RelativeLayout root = activityCaacUomRegistrationBinding3.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "viewBinding.root");
        blurRadius.setFrameClearDrawable(root.getBackground());
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding4 = this.viewBinding;
        if (activityCaacUomRegistrationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        BlurView blurView2 = activityCaacUomRegistrationBinding4.infoBlurView;
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding5 = this.viewBinding;
        if (activityCaacUomRegistrationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        BlurViewFacade blurRadius2 = blurView2.setupWith(activityCaacUomRegistrationBinding5.getRoot()).setBlurRadius(15.0f);
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding6 = this.viewBinding;
        if (activityCaacUomRegistrationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        RelativeLayout root2 = activityCaacUomRegistrationBinding6.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root2, "viewBinding.root");
        blurRadius2.setFrameClearDrawable(root2.getBackground());
    }

    private final void initListener() {
        ViewExtends viewExtends = ViewExtends.INSTANCE;
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding = this.viewBinding;
        if (activityCaacUomRegistrationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        ImageButton imageButton = activityCaacUomRegistrationBinding.btnBack;
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "viewBinding.btnBack");
        ViewExtends.setOnScaleClickListener$default(viewExtends, imageButton, new Function1<View, Unit>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                CAACUomRegistrationActivity.this.finish();
            }
        }, false, 2, null);
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding2 = this.viewBinding;
        if (activityCaacUomRegistrationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding2.layoutDownloadQRCodeEnlarge.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CAACUomRegistrationActivity.this.showDownloadQRCodeEnlarge();
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding3 = this.viewBinding;
        if (activityCaacUomRegistrationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding3.tvDownloadQRCodeEnlarge.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CAACUomRegistrationActivity.this.showDownloadQRCodeEnlarge();
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding4 = this.viewBinding;
        if (activityCaacUomRegistrationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding4.layoutDownloadQRCodeDetail.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RelativeLayout relativeLayout = CAACUomRegistrationActivity.access$getViewBinding$p(CAACUomRegistrationActivity.this).layoutDownloadQRCodeDetail;
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "viewBinding.layoutDownloadQRCodeDetail");
                relativeLayout.setVisibility(8);
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding5 = this.viewBinding;
        if (activityCaacUomRegistrationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding5.layoutInfoQRCodeDetail.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConstraintLayout constraintLayout = CAACUomRegistrationActivity.access$getViewBinding$p(CAACUomRegistrationActivity.this).layoutInfoQRCodeDetail;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "viewBinding.layoutInfoQRCodeDetail");
                constraintLayout.setVisibility(8);
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding6 = this.viewBinding;
        if (activityCaacUomRegistrationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding6.layoutInfoQRCodeEnlarge.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CAACUomRegistrationActivity.this.showInfoQRCodeEnlarge();
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding7 = this.viewBinding;
        if (activityCaacUomRegistrationBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding7.tvInfoQRCodeEnlarge.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CAACUomRegistrationActivity.this.showInfoQRCodeEnlarge();
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding8 = this.viewBinding;
        if (activityCaacUomRegistrationBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding8.btnCopy.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContextExtends contextExtends = ContextExtends.INSTANCE;
                CAACUomRegistrationActivity cAACUomRegistrationActivity = CAACUomRegistrationActivity.this;
                TextView textView = CAACUomRegistrationActivity.access$getViewBinding$p(cAACUomRegistrationActivity).tvFlightSN;
                Intrinsics.checkExpressionValueIsNotNull(textView, "viewBinding.tvFlightSN");
                contextExtends.copyToBoard(cAACUomRegistrationActivity, textView.getText().toString());
                CAACUomRegistrationActivity cAACUomRegistrationActivity2 = CAACUomRegistrationActivity.this;
                ToastUtil.toast(cAACUomRegistrationActivity2, cAACUomRegistrationActivity2.getString(C1965R.string.uom_toast_copy_success), SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding9 = this.viewBinding;
        if (activityCaacUomRegistrationBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding9.btnUomRegisterTips.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CAACUomRegistrationActivity.this.showCaacTipDialog();
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding10 = this.viewBinding;
        if (activityCaacUomRegistrationBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding10.tvOrder1Url.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CAACUomRegistrationActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(CAACUomRegistrationActivity.this.getString(C1965R.string.caac_url))));
            }
        });
    }

    private final void initObserver() {
        getCaacUomViewModel().getFlightSN().observe(this, new Observer<Pair<? extends Flight, ? extends String>>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initObserver$1
            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Pair<? extends Flight, ? extends String> pair) {
                onChanged2((Pair<? extends Flight, String>) pair);
            }

            /* renamed from: onChanged, reason: avoid collision after fix types in other method */
            public final void onChanged2(Pair<? extends Flight, String> pair) {
                CAACUomRegistrationViewModel caacUomViewModel;
                caacUomViewModel = CAACUomRegistrationActivity.this.getCaacUomViewModel();
                caacUomViewModel.generateQRCode(UomConvert.INSTANCE.convertQRCodeInfo(pair.getFirst(), pair.getSecond()), new SimpleResultListener<Bitmap>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initObserver$1.1
                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public final void onResult(Bitmap bitmap) {
                        CAACUomRegistrationViewModel caacUomViewModel2;
                        CAACUomRegistrationActivity.access$getViewBinding$p(CAACUomRegistrationActivity.this).ivInfoQRCode.setImageBitmap(bitmap);
                        caacUomViewModel2 = CAACUomRegistrationActivity.this.getCaacUomViewModel();
                        caacUomViewModel2.setInfoQRCodeBitmap(bitmap);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDownloadQRCodeEnlarge() {
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding = this.viewBinding;
        if (activityCaacUomRegistrationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        RelativeLayout relativeLayout = activityCaacUomRegistrationBinding.layoutDownloadQRCodeDetail;
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "viewBinding.layoutDownloadQRCodeDetail");
        relativeLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInfoQRCodeEnlarge() {
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding = this.viewBinding;
        if (activityCaacUomRegistrationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        ConstraintLayout constraintLayout = activityCaacUomRegistrationBinding.layoutInfoQRCodeDetail;
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "viewBinding.layoutInfoQRCodeDetail");
        constraintLayout.setVisibility(0);
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding2 = this.viewBinding;
        if (activityCaacUomRegistrationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding2.ivInfoQRCodeDetail.setImageBitmap(getCaacUomViewModel().getInfoQRCodeBitmap());
        Pair<Flight, String> value = getCaacUomViewModel().getFlightSN().getValue();
        if (value != null) {
            ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding3 = this.viewBinding;
            if (activityCaacUomRegistrationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            }
            TextView textView = activityCaacUomRegistrationBinding3.tvProductName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "viewBinding.tvProductName");
            textView.setText("Potensic " + value.getFirst().getFlightTypeString());
            ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding4 = this.viewBinding;
            if (activityCaacUomRegistrationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            }
            TextView textView2 = activityCaacUomRegistrationBinding4.tvFlightSN;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "viewBinding.tvFlightSN");
            textView2.setText(value.getSecond());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCaacTipDialog() {
        SpannableString spannableString = new SpannableString(getString(C1965R.string.uom_toast_aircraft_registration_tips));
        try {
            String string = getString(C1965R.string.f2151xc14339b6);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.uom_i…d_aerial_vehicle_flights)");
            String string2 = getString(C1965R.string.f2154x2a559788);
            Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.uom_r…unmanned_aerial_vehicles)");
            String string3 = getString(C1965R.string.f2155xa7a5ea33);
            Intrinsics.checkExpressionValueIsNotNull(string3, "getString(R.string.uom_s…d_aerial_vehicle_systems)");
            ArrayList arrayList = new ArrayList();
            arrayList.add(string);
            arrayList.add(string2);
            arrayList.add(string3);
            int i = 0;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                Intrinsics.checkExpressionValueIsNotNull(obj, "webs[i]");
                String str = (String) obj;
                final String str2 = i == 0 ? UomConfig.URL_UOM_WEBSITE1 : i == 1 ? UomConfig.URL_UOM_WEBSITE2 : UomConfig.URL_UOM_WEBSITE3;
                String spannableString2 = spannableString.toString();
                Intrinsics.checkExpressionValueIsNotNull(spannableString2, "uomReduceContentString.toString()");
                int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableString2, str, 0, false, 6, (Object) null);
                spannableString.setSpan(new ClickableSpan() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$showCaacTipDialog$1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        Intrinsics.checkParameterIsNotNull(widget, "widget");
                        try {
                            CAACUomRegistrationActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                        } catch (Exception e) {
                            DDLog.m1684e("跳转报错 :" + e);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds) {
                        Intrinsics.checkParameterIsNotNull(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                        ds.setColor(CAACUomRegistrationActivity.this.getColor(C1965R.color.color_dialog_blue_bg));
                    }
                }, indexOf$default, str.length() + indexOf$default, 33);
                i++;
            }
        } catch (Exception unused) {
        }
        String string4 = getString(C1965R.string.uom_aircraft_registration);
        Intrinsics.checkExpressionValueIsNotNull(string4, "getString(R.string.uom_aircraft_registration)");
        AppDialogManager.showCommonOneButtonWithSpanContentDialog$default(AppDialogManager.INSTANCE.getInstance(), this, string4, spannableString, getString(C1965R.string.uom_button_ok), null, new Function0<Unit>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$showCaacTipDialog$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, 16, null);
    }
}