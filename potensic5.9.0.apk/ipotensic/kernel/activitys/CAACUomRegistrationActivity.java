package com.ipotensic.kernel.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
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
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.extensions.ViewExtends;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ActivityCaacUomRegistrationBinding;
import com.ipotensic.kernel.model.CAACUomRegistrationViewModel;
import com.ipotensic.kernel.view.blur.BlurView;
import com.ipotensic.kernel.view.blur.BlurViewFacade;
import com.logan.flight.type.Flight;
import com.logan.uom.utils.UomConvert;
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

/* compiled from: CAACUomRegistrationActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/ipotensic/kernel/activitys/CAACUomRegistrationActivity;", "Lcom/ipotensic/baselib/base/BaseActivity;", "()V", "caacUomViewModel", "Lcom/ipotensic/kernel/model/CAACUomRegistrationViewModel;", "getCaacUomViewModel", "()Lcom/ipotensic/kernel/model/CAACUomRegistrationViewModel;", "caacUomViewModel$delegate", "Lkotlin/Lazy;", "viewBinding", "Lcom/ipotensic/kernel/databinding/ActivityCaacUomRegistrationBinding;", "initData", "", "initListener", "initObserver", "isNewFullScreenPage", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showCaacTipDialog", "showDownloadQRCodeEnlarge", "showInfoQRCodeEnlarge", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CAACUomRegistrationActivity extends BaseActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CAACUomRegistrationActivity.class), "caacUomViewModel", "getCaacUomViewModel()Lcom/ipotensic/kernel/model/CAACUomRegistrationViewModel;"))};
    public static final String FLIGHT_SN_INTENT_KEY = "flightSN";
    public static final String FLIGHT_TYPE_INTENT_KEY = "flightType";
    private HashMap _$_findViewCache;

    /* renamed from: caacUomViewModel$delegate, reason: from kotlin metadata */
    private final Lazy caacUomViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CAACUomRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$$special$$inlined$viewModels$2
        public CAACUomRegistrationActivity$$special$$inlined$viewModels$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$$special$$inlined$viewModels$1
        public CAACUomRegistrationActivity$$special$$inlined$viewModels$1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
            Intrinsics.checkExpressionValueIsNotNull(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });
    private ActivityCaacUomRegistrationBinding viewBinding;

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
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ActivityCaacUomRegistrat\u2026ayoutInflater.from(this))");
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
            CAACUomRegistrationActivity$initListener$1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2(View view) {
                CAACUomRegistrationActivity.this.finish();
            }
        }, false, 2, null);
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding2 = this.viewBinding;
        if (activityCaacUomRegistrationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding2.layoutDownloadQRCodeEnlarge.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$2
            CAACUomRegistrationActivity$initListener$2() {
            }

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
            CAACUomRegistrationActivity$initListener$3() {
            }

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
            CAACUomRegistrationActivity$initListener$4() {
            }

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
            CAACUomRegistrationActivity$initListener$5() {
            }

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
            CAACUomRegistrationActivity$initListener$6() {
            }

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
            CAACUomRegistrationActivity$initListener$7() {
            }

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
            CAACUomRegistrationActivity$initListener$8() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContextExtends contextExtends = ContextExtends.INSTANCE;
                CAACUomRegistrationActivity cAACUomRegistrationActivity = CAACUomRegistrationActivity.this;
                TextView textView = CAACUomRegistrationActivity.access$getViewBinding$p(cAACUomRegistrationActivity).tvFlightSN;
                Intrinsics.checkExpressionValueIsNotNull(textView, "viewBinding.tvFlightSN");
                contextExtends.copyToBoard(cAACUomRegistrationActivity, textView.getText().toString());
                CAACUomRegistrationActivity cAACUomRegistrationActivity2 = CAACUomRegistrationActivity.this;
                ToastUtil.toast(cAACUomRegistrationActivity2, cAACUomRegistrationActivity2.getString(R.string.uom_toast_copy_success), SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        });
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding9 = this.viewBinding;
        if (activityCaacUomRegistrationBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        activityCaacUomRegistrationBinding9.btnUomRegisterTips.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initListener$9
            CAACUomRegistrationActivity$initListener$9() {
            }

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
            CAACUomRegistrationActivity$initListener$10() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CAACUomRegistrationActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(CAACUomRegistrationActivity.this.getString(R.string.caac_url))));
            }
        });
    }

    private final void initObserver() {
        getCaacUomViewModel().getFlightSN().observe(this, new Observer<Pair<? extends Flight, ? extends String>>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initObserver$1
            CAACUomRegistrationActivity$initObserver$1() {
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Pair<? extends Flight, ? extends String> pair) {
                onChanged2((Pair<? extends Flight, String>) pair);
            }

            /* renamed from: onChanged */
            public final void onChanged2(Pair<? extends Flight, String> pair) {
                CAACUomRegistrationViewModel caacUomViewModel;
                caacUomViewModel = CAACUomRegistrationActivity.this.getCaacUomViewModel();
                caacUomViewModel.generateQRCode(UomConvert.INSTANCE.convertQRCodeInfo(pair.getFirst(), pair.getSecond()), new SimpleResultListener<Bitmap>() { // from class: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initObserver$1.1
                    AnonymousClass1() {
                    }

                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public final void onResult(Bitmap bitmap) {
                        CAACUomRegistrationViewModel caacUomViewModel2;
                        CAACUomRegistrationActivity.access$getViewBinding$p(CAACUomRegistrationActivity.this).ivInfoQRCode.setImageBitmap(bitmap);
                        caacUomViewModel2 = CAACUomRegistrationActivity.this.getCaacUomViewModel();
                        caacUomViewModel2.setInfoQRCodeBitmap(bitmap);
                    }
                });
            }

            /* compiled from: CAACUomRegistrationActivity.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "bmp", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$initObserver$1$1 */
            static final class AnonymousClass1<T> implements SimpleResultListener<Bitmap> {
                AnonymousClass1() {
                }

                @Override // com.ipotensic.baselib.listener.SimpleResultListener
                public final void onResult(Bitmap bitmap) {
                    CAACUomRegistrationViewModel caacUomViewModel2;
                    CAACUomRegistrationActivity.access$getViewBinding$p(CAACUomRegistrationActivity.this).ivInfoQRCode.setImageBitmap(bitmap);
                    caacUomViewModel2 = CAACUomRegistrationActivity.this.getCaacUomViewModel();
                    caacUomViewModel2.setInfoQRCodeBitmap(bitmap);
                }
            }
        });
    }

    public final void showDownloadQRCodeEnlarge() {
        ActivityCaacUomRegistrationBinding activityCaacUomRegistrationBinding = this.viewBinding;
        if (activityCaacUomRegistrationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        RelativeLayout relativeLayout = activityCaacUomRegistrationBinding.layoutDownloadQRCodeDetail;
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "viewBinding.layoutDownloadQRCodeDetail");
        relativeLayout.setVisibility(0);
    }

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

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$showCaacTipDialog$1.<init>(com.ipotensic.kernel.activitys.CAACUomRegistrationActivity, java.lang.String):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public final void showCaacTipDialog() {
        /*
            r12 = this;
            android.text.SpannableString r3 = new android.text.SpannableString
            int r0 = com.ipotensic.kernel.R.string.uom_toast_aircraft_registration_tips
            java.lang.String r0 = r12.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.<init>(r0)
            int r0 = com.ipotensic.kernel.R.string.uom_interim_regulations_on_the_administration_of_unmanned_aerial_vehicle_flights     // Catch: java.lang.Exception -> L84
            java.lang.String r0 = r12.getString(r0)     // Catch: java.lang.Exception -> L84
            java.lang.String r1 = "getString(R.string.uom_i\u2026d_aerial_vehicle_flights)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)     // Catch: java.lang.Exception -> L84
            int r1 = com.ipotensic.kernel.R.string.uom_rules_for_the_operation_and_safety_management_of_civilian_unmanned_aerial_vehicles     // Catch: java.lang.Exception -> L84
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = "getString(R.string.uom_r\u2026unmanned_aerial_vehicles)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch: java.lang.Exception -> L84
            int r2 = com.ipotensic.kernel.R.string.uom_safety_requirements_for_civilian_unmanned_aerial_vehicle_systems     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = r12.getString(r2)     // Catch: java.lang.Exception -> L84
            java.lang.String r4 = "getString(R.string.uom_s\u2026d_aerial_vehicle_systems)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)     // Catch: java.lang.Exception -> L84
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Exception -> L84
            r4.<init>()     // Catch: java.lang.Exception -> L84
            r4.add(r0)     // Catch: java.lang.Exception -> L84
            r4.add(r1)     // Catch: java.lang.Exception -> L84
            r4.add(r2)     // Catch: java.lang.Exception -> L84
            r0 = 0
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Exception -> L84
            int r1 = r1.size()     // Catch: java.lang.Exception -> L84
        L44:
            if (r0 >= r1) goto L84
            java.lang.Object r2 = r4.get(r0)     // Catch: java.lang.Exception -> L84
            java.lang.String r5 = "webs[i]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L84
            if (r0 != 0) goto L56
            java.lang.String r5 = "https://www.caac.gov.cn/XXGK/XXGK/FLFG/202401/t20240115_222642.html"
            goto L5e
        L56:
            r5 = 1
            if (r0 != r5) goto L5c
            java.lang.String r5 = "https://www.caac.gov.cn/XXGK/XXGK/MHGZ/202401/t20240103_222566.html"
            goto L5e
        L5c:
            java.lang.String r5 = "https://std.samr.gov.cn/gb/search/gbDetailed?id=FC83293D549DB452E05397BE0A0A9309"
        L5e:
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Exception -> L84
            java.lang.String r7 = "uomReduceContentString.toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)     // Catch: java.lang.Exception -> L84
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch: java.lang.Exception -> L84
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r7 = r2
            int r6 = kotlin.text.StringsKt.indexOf$default(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L84
            int r2 = r2.length()     // Catch: java.lang.Exception -> L84
            int r2 = r2 + r6
            com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$showCaacTipDialog$1 r7 = new com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$showCaacTipDialog$1     // Catch: java.lang.Exception -> L84
            r7.<init>()     // Catch: java.lang.Exception -> L84
            r5 = 33
            r3.setSpan(r7, r6, r2, r5)     // Catch: java.lang.Exception -> L84
            int r0 = r0 + 1
            goto L44
        L84:
            com.ipotensic.kernel.view.dialog.AppDialogManager$Companion r0 = com.ipotensic.kernel.view.dialog.AppDialogManager.INSTANCE
            com.ipotensic.kernel.view.dialog.AppDialogManager r0 = r0.getInstance()
            r1 = r12
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            int r2 = com.ipotensic.kernel.R.string.uom_aircraft_registration
            java.lang.String r2 = r12.getString(r2)
            java.lang.String r4 = "getString(R.string.uom_aircraft_registration)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            int r4 = com.ipotensic.kernel.R.string.uom_button_ok
            java.lang.String r4 = r12.getString(r4)
            r5 = 0
            com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$showCaacTipDialog$2 r6 = com.ipotensic.kernel.activitys.CAACUomRegistrationActivity$showCaacTipDialog$2.INSTANCE
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r7 = 16
            r8 = 0
            com.ipotensic.kernel.view.dialog.AppDialogManager.showCommonOneButtonWithSpanContentDialog$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.activitys.CAACUomRegistrationActivity.showCaacTipDialog():void");
    }
}