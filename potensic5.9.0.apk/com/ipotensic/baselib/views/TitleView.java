package com.ipotensic.baselib.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ipotensic.baselib.C1819R;
import com.ipotensic.baselib.bean.TitleBean;
import com.ipotensic.baselib.utils.UnitUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: TitleView.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010$\u001a\u00020\u00132\b\b\u0001\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u0013J\u0010\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0007J\u0010\u0010(\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010\u001aR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m2338d2 = {"Lcom/ipotensic/baselib/views/TitleView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivBack", "Landroid/widget/ImageView;", "getIvBack", "()Landroid/widget/ImageView;", "setIvBack", "(Landroid/widget/ImageView;)V", "llRight", "Landroid/widget/LinearLayout;", "onLeftClick", "Lkotlin/Function0;", "", "getOnLeftClick", "()Lkotlin/jvm/functions/Function0;", "setOnLeftClick", "(Lkotlin/jvm/functions/Function0;)V", "onRightClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "tag", "getOnRightClick", "()Lkotlin/jvm/functions/Function1;", "setOnRightClick", "(Lkotlin/jvm/functions/Function1;)V", "tvTitle", "Landroid/widget/TextView;", "addRightView", "resId", "removeRightView", "", "setTitle", "bean", "Lcom/ipotensic/baselib/bean/TitleBean;", MessageBundle.TITLE_ENTRY, "BaseLib_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TitleView extends RelativeLayout {
    private HashMap _$_findViewCache;
    private ImageView ivBack;
    private LinearLayout llRight;
    private Function0<Unit> onLeftClick;
    private Function1<? super String, Unit> onRightClick;
    private TextView tvTitle;

    public TitleView(Context context) {
        this(context, null, 0, 6, null);
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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

    public /* synthetic */ TitleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        View inflate = RelativeLayout.inflate(context, C1819R.layout.view_common_title, this);
        View findViewById = inflate.findViewById(C1819R.id.iv_back);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.iv_back)");
        this.ivBack = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(C1819R.id.tv_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "root.findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(C1819R.id.ll_right);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "root.findViewById(R.id.ll_right)");
        this.llRight = (LinearLayout) findViewById3;
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.TitleView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0<Unit> onLeftClick = TitleView.this.getOnLeftClick();
                if (onLeftClick != null) {
                    onLeftClick.invoke();
                }
            }
        });
    }

    public final ImageView getIvBack() {
        return this.ivBack;
    }

    public final void setIvBack(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.ivBack = imageView;
    }

    public final Function0<Unit> getOnLeftClick() {
        return this.onLeftClick;
    }

    public final void setOnLeftClick(Function0<Unit> function0) {
        this.onLeftClick = function0;
    }

    public final Function1<String, Unit> getOnRightClick() {
        return this.onRightClick;
    }

    public final void setOnRightClick(Function1<? super String, Unit> function1) {
        this.onRightClick = function1;
    }

    public final void setTitle(TitleBean bean) {
        removeRightView();
        if (bean != null) {
            if (bean.getLeftId() != 0) {
                this.ivBack.setImageResource(bean.getLeftId());
            }
            String titleName = bean.getTitleName();
            if (titleName != null) {
                setTitle(titleName);
            }
            String rightView = bean.getRightView();
            if (rightView != null) {
                for (String str : StringsKt.split$default((CharSequence) rightView, new String[]{","}, false, 0, 6, (Object) null)) {
                    addRightView(bean.getIdByTag(str), false, str);
                }
            }
        }
    }

    public final void setTitle(int title) {
        this.tvTitle.setText(title);
    }

    public final void setTitle(String title) {
        this.tvTitle.setText(title);
    }

    public final void removeRightView() {
        this.llRight.removeAllViews();
    }

    public static /* synthetic */ void addRightView$default(TitleView titleView, int i, boolean z, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        titleView.addRightView(i, z, str);
    }

    public final void addRightView(int resId, boolean removeRightView, final String tag) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (removeRightView) {
            removeRightView();
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(resId);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.TitleView$addRightView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1<String, Unit> onRightClick = TitleView.this.getOnRightClick();
                if (onRightClick != null) {
                    onRightClick.invoke(tag);
                }
            }
        });
        this.llRight.addView(imageView);
        imageView.setPadding(UnitUtil.dp2px(12), UnitUtil.dp2px(5), UnitUtil.dp2px(12), UnitUtil.dp2px(5));
    }
}