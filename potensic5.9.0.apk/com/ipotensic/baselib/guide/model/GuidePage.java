package com.ipotensic.baselib.guide.model;

import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import com.ipotensic.baselib.guide.listener.OnHighlightClickListener;
import com.ipotensic.baselib.guide.listener.OnHighlightDrewListener;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.model.HighLight;
import com.ipotensic.baselib.guide.model.HighlightOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class GuidePage {
    private int backgroundColor;
    private int[] clickToDismissIds;
    private Animation enterAnimation;
    private Animation exitAnimation;
    private int layoutResId;
    private OnHighlightDrewListener onHighlightDrewListener;
    private OnLayoutInflatedListener onLayoutInflatedListener;
    private List<HighLight> highLights = new ArrayList();
    private boolean everywhereCancelable = true;
    private boolean isShowClick = false;
    private boolean isTopMenuDismiss = false;
    private boolean dismiss = false;

    static /* synthetic */ void lambda$addClickView$0(View view) {
    }

    public static GuidePage newInstance() {
        return new GuidePage();
    }

    public GuidePage addHighLight(View view) {
        return addHighLight(view, HighLight.Shape.RECTANGLE, 0, 0, null);
    }

    public GuidePage addClickView(View view) {
        HighlightView highlightView = new HighlightView(view, HighLight.Shape.RECTANGLE, 0, 0);
        highlightView.setOptions(new HighlightOptions.Builder().setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.guide.model.-$$Lambda$GuidePage$ZqS2Kb2ybVaZczr3-5_ZB3dDD8k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuidePage.lambda$addClickView$0(view2);
            }
        }).build());
        this.highLights.add(0, highlightView);
        return this;
    }

    public GuidePage addHighLight(View view, RelativeGuide relativeGuide) {
        return addHighLight(view, HighLight.Shape.RECTANGLE, 0, 0, relativeGuide);
    }

    public GuidePage addHighLight(View view, RelativeGuide relativeGuide, int i) {
        return addHighLight(view, HighLight.Shape.ROUND_RECTANGLE, i, 0, relativeGuide);
    }

    public GuidePage addHighLight(View view, RelativeGuide relativeGuide, int i, int i2) {
        return addHighLight(view, HighLight.Shape.ROUND_RECTANGLE, i, i2, relativeGuide);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape) {
        return addHighLight(view, shape, 0, 0, null);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, RelativeGuide relativeGuide) {
        return addHighLight(view, shape, 0, 0, relativeGuide);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, int i) {
        return addHighLight(view, shape, 0, i, null);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, int i, RelativeGuide relativeGuide) {
        return addHighLight(view, shape, 0, i, relativeGuide);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, int i, int i2, RelativeGuide relativeGuide) {
        HighlightView highlightView = new HighlightView(view, shape, i, i2);
        if (relativeGuide != null) {
            relativeGuide.highLight = highlightView;
            highlightView.setOptions(new HighlightOptions.Builder().setOnClickListener(new OnHighlightClickListener() { // from class: com.ipotensic.baselib.guide.model.GuidePage.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            }).setRelativeGuide(relativeGuide).build());
        }
        this.highLights.add(highlightView);
        return this;
    }

    public GuidePage addHighLight(RectF rectF) {
        return addHighLight(rectF, HighLight.Shape.RECTANGLE, 0, (RelativeGuide) null);
    }

    public GuidePage addHighLight(RectF rectF, RelativeGuide relativeGuide) {
        return addHighLight(rectF, HighLight.Shape.RECTANGLE, 0, relativeGuide);
    }

    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape) {
        return addHighLight(rectF, shape, 0, (RelativeGuide) null);
    }

    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape, RelativeGuide relativeGuide) {
        return addHighLight(rectF, shape, 0, relativeGuide);
    }

    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape, int i) {
        return addHighLight(rectF, shape, i, (RelativeGuide) null);
    }

    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape, int i, RelativeGuide relativeGuide) {
        HighlightRectF highlightRectF = new HighlightRectF(rectF, shape, i);
        if (relativeGuide != null) {
            relativeGuide.highLight = highlightRectF;
            highlightRectF.setOptions(new HighlightOptions.Builder().setRelativeGuide(relativeGuide).build());
        }
        this.highLights.add(highlightRectF);
        return this;
    }

    public GuidePage addHighLightWithOptions(View view, HighlightOptions highlightOptions) {
        return addHighLightWithOptions(view, HighLight.Shape.RECTANGLE, 0, 0, highlightOptions);
    }

    public GuidePage addHighLightWithOptions(View view, HighLight.Shape shape, HighlightOptions highlightOptions) {
        return addHighLightWithOptions(view, shape, 0, 0, highlightOptions);
    }

    public GuidePage addHighLightWithOptions(View view, HighLight.Shape shape, int i, int i2, HighlightOptions highlightOptions) {
        HighlightView highlightView = new HighlightView(view, shape, i, i2);
        if (highlightOptions != null && highlightOptions.relativeGuide != null) {
            highlightOptions.relativeGuide.highLight = highlightView;
        }
        highlightView.setOptions(highlightOptions);
        this.highLights.add(highlightView);
        return this;
    }

    public GuidePage addHighLightWithOptions(RectF rectF, HighlightOptions highlightOptions) {
        return addHighLightWithOptions(rectF, HighLight.Shape.RECTANGLE, 0, highlightOptions);
    }

    public GuidePage addHighLightWithOptions(RectF rectF, HighLight.Shape shape, HighlightOptions highlightOptions) {
        return addHighLightWithOptions(rectF, shape, 0, highlightOptions);
    }

    public GuidePage addHighLightWithOptions(RectF rectF, HighLight.Shape shape, int i, HighlightOptions highlightOptions) {
        HighlightRectF highlightRectF = new HighlightRectF(rectF, shape, i);
        if (highlightOptions != null && highlightOptions.relativeGuide != null) {
            highlightOptions.relativeGuide.highLight = highlightRectF;
        }
        highlightRectF.setOptions(highlightOptions);
        this.highLights.add(highlightRectF);
        return this;
    }

    public GuidePage setLayoutRes(int i, int... iArr) {
        this.layoutResId = i;
        this.clickToDismissIds = iArr;
        return this;
    }

    public GuidePage setEverywhereCancelable(boolean z) {
        this.everywhereCancelable = z;
        return this;
    }

    public GuidePage setShowCanClick(boolean z, boolean z2, boolean z3) {
        this.isShowClick = z;
        this.isTopMenuDismiss = z2;
        this.dismiss = z3;
        return this;
    }

    public boolean getShowCanClick() {
        return this.isShowClick;
    }

    public boolean getTopMenuDismiss() {
        return this.isTopMenuDismiss;
    }

    public boolean getDismiss() {
        return this.dismiss;
    }

    public GuidePage setBackgroundColor(int i) {
        this.backgroundColor = i;
        return this;
    }

    public GuidePage setOnLayoutInflatedListener(OnLayoutInflatedListener onLayoutInflatedListener) {
        this.onLayoutInflatedListener = onLayoutInflatedListener;
        return this;
    }

    public GuidePage setEnterAnimation(Animation animation) {
        this.enterAnimation = animation;
        return this;
    }

    public GuidePage setExitAnimation(Animation animation) {
        this.exitAnimation = animation;
        return this;
    }

    public boolean isEverywhereCancelable() {
        return this.everywhereCancelable;
    }

    public boolean isEmpty() {
        return this.layoutResId == 0 && this.highLights.size() == 0;
    }

    public List<HighLight> getHighLights() {
        return this.highLights;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getLayoutResId() {
        return this.layoutResId;
    }

    public int[] getClickToDismissIds() {
        return this.clickToDismissIds;
    }

    public OnLayoutInflatedListener getOnLayoutInflatedListener() {
        return this.onLayoutInflatedListener;
    }

    public Animation getEnterAnimation() {
        return this.enterAnimation;
    }

    public Animation getExitAnimation() {
        return this.exitAnimation;
    }

    public List<RelativeGuide> getRelativeGuides() {
        ArrayList arrayList = new ArrayList();
        Iterator<HighLight> it = this.highLights.iterator();
        while (it.hasNext()) {
            HighlightOptions options = it.next().getOptions();
            if (options != null && options.relativeGuide != null) {
                arrayList.add(options.relativeGuide);
            }
        }
        return arrayList;
    }
}