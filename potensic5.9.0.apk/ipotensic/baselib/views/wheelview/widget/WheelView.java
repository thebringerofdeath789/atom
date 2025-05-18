package com.ipotensic.baselib.views.wheelview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.ipotensic.baselib.R;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener;
import com.ipotensic.baselib.views.wheelview.contract.TextProvider;
import com.ipotensic.baselib.views.wheelview.contract.WheelFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class WheelView extends View implements Runnable {

    @Deprecated
    public static final int SCROLL_STATE_DRAGGING = 1;

    @Deprecated
    public static final int SCROLL_STATE_IDLE = 0;

    @Deprecated
    public static final int SCROLL_STATE_SCROLLING = 2;
    protected boolean atmosphericEnabled;
    private final Camera camera;
    protected int currentPosition;
    protected int curtainColor;
    protected int curtainCorner;
    protected boolean curtainEnabled;
    protected float curtainRadius;
    protected boolean curvedEnabled;
    protected int curvedIndicatorSpace;
    protected int curvedMaxAngle;
    protected boolean cyclicEnabled;
    protected List<?> data;
    protected Object defaultItem;
    protected int defaultItemPosition;
    private int downPointYCoordinate;
    private int drawnCenterXCoordinate;
    private int drawnCenterYCoordinate;
    private int drawnItemCount;
    protected WheelFormatter formatter;
    private int halfDrawnItemCount;
    private int halfItemHeight;
    private int halfWheelHeight;
    private final Handler handler;
    protected int indicatorColor;
    protected boolean indicatorEnabled;
    protected float indicatorSize;
    private boolean isClick;
    private boolean isForceFinishScroll;
    private int itemHeight;
    protected int itemSpace;
    private int lastPointYCoordinate;
    private int lastScrollPosition;
    private final Matrix matrixDepth;
    private final Matrix matrixRotate;
    private int maxFlingYCoordinate;
    protected String maxWidthText;
    private final int maximumVelocity;
    private int minFlingYCoordinate;
    private final int minimumVelocity;
    private OnWheelChangedListener onWheelChangedListener;
    private final Paint paint;
    private final Rect rectCurrentItem;
    private final Rect rectDrawn;
    private final Rect rectIndicatorFoot;
    private final Rect rectIndicatorHead;
    protected boolean sameWidthEnabled;
    private int scrollOffsetYCoordinate;
    private final Scroller scroller;
    protected boolean selectedTextBold;
    protected int selectedTextColor;
    protected float selectedTextSize;
    protected int textAlign;
    protected int textColor;
    private int textMaxHeight;
    private int textMaxWidth;
    protected float textSize;
    private final int touchSlop;
    private VelocityTracker tracker;
    protected int visibleItemCount;
    private int wheelCenterXCoordinate;
    private int wheelCenterYCoordinate;

    private boolean isPositionInRange(int i, int i2) {
        return i >= 0 && i < i2;
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.WheelStyle);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.data = new ArrayList();
        this.curvedMaxAngle = 90;
        this.handler = new Handler();
        this.paint = new Paint(69);
        this.rectDrawn = new Rect();
        this.rectIndicatorHead = new Rect();
        this.rectIndicatorFoot = new Rect();
        this.rectCurrentItem = new Rect();
        this.camera = new Camera();
        this.matrixRotate = new Matrix();
        this.matrixDepth = new Matrix();
        initAttrs(context, attributeSet, i, R.style.WheelDefault);
        initTextPaint();
        updateVisibleItemCount();
        this.scroller = new Scroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.minimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        if (isInEditMode()) {
            setData(generatePreviewData());
        }
    }

    private void initTextPaint() {
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setFakeBoldText(false);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setTypeface(PhoneConfig.typeface);
    }

    public void setStyle(int i) {
        initAttrs(getContext(), null, R.attr.WheelStyle, i);
        initTextPaint();
        updatePaintTextAlign();
        computeTextWidthAndHeight();
        computeFlingLimitYCoordinate();
        computeIndicatorRect();
        computeCurrentItemRect();
        requestLayout();
        invalidate();
    }

    private void initAttrs(Context context, AttributeSet attributeSet, int i, int i2) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().scaledDensity;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelView, i, i2);
        this.visibleItemCount = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_visibleItemCount, 5);
        this.sameWidthEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_sameWidthEnabled, false);
        this.maxWidthText = obtainStyledAttributes.getString(R.styleable.WheelView_wheel_maxWidthText);
        this.textColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_itemTextColor, -7829368);
        this.selectedTextColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK);
        this.textSize = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_itemTextSize, f2 * 15.0f);
        this.selectedTextSize = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_itemTextSizeSelected, this.textSize);
        this.selectedTextBold = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_itemTextBoldSelected, false);
        this.textAlign = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_itemTextAlign, 0);
        this.itemSpace = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheel_itemSpace, (int) (20.0f * f));
        this.cyclicEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_cyclicEnabled, false);
        this.indicatorEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_indicatorEnabled, true);
        this.indicatorColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_indicatorColor, -3552823);
        float f3 = f * 1.0f;
        this.indicatorSize = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_indicatorSize, f3);
        this.curvedIndicatorSpace = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheel_curvedIndicatorSpace, (int) f3);
        this.curtainEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_curtainEnabled, false);
        this.curtainColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_curtainColor, -1);
        this.curtainCorner = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_curtainCorner, 0);
        this.curtainRadius = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_curtainRadius, 0.0f);
        this.atmosphericEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_atmosphericEnabled, false);
        this.curvedEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_curvedEnabled, false);
        this.curvedMaxAngle = obtainStyledAttributes.getInteger(R.styleable.WheelView_wheel_curvedMaxAngle, 90);
        obtainStyledAttributes.recycle();
    }

    protected List<?> generatePreviewData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("aaaaaaaa");
        arrayList.add("bbbbbbbb");
        arrayList.add("cccccccc");
        arrayList.add("dddddddd");
        arrayList.add("eeeeeeee");
        arrayList.add("ffffffff");
        return arrayList;
    }

    private void updateVisibleItemCount() {
        int i = this.visibleItemCount;
        if (i < 2) {
            throw new ArithmeticException("Visible item count can not be less than 2");
        }
        if (i % 2 == 0) {
            this.visibleItemCount = i + 1;
        }
        int i2 = this.visibleItemCount + 2;
        this.drawnItemCount = i2;
        this.halfDrawnItemCount = i2 / 2;
    }

    private void computeTextWidthAndHeight() {
        this.textMaxHeight = 0;
        this.textMaxWidth = 0;
        if (this.sameWidthEnabled) {
            this.textMaxWidth = (int) this.paint.measureText(formatItem(0));
        } else if (!TextUtils.isEmpty(this.maxWidthText)) {
            this.textMaxWidth = (int) this.paint.measureText(this.maxWidthText);
        } else {
            int itemCount = getItemCount();
            for (int i = 0; i < itemCount; i++) {
                this.textMaxWidth = Math.max(this.textMaxWidth, (int) this.paint.measureText(formatItem(i)));
            }
        }
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        this.textMaxHeight = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    public int getItemCount() {
        return this.data.size();
    }

    public <T> T getItem(int i) {
        int i2;
        int size = this.data.size();
        if (size != 0 && (i2 = (i + size) % size) >= 0 && i2 <= size - 1) {
            return (T) this.data.get(i2);
        }
        return null;
    }

    public int getPosition(Object obj) {
        if (obj == null) {
            return 0;
        }
        return this.data.indexOf(obj);
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public <T> T getCurrentItem() {
        return (T) getItem(this.currentPosition);
    }

    public int getVisibleItemCount() {
        return this.visibleItemCount;
    }

    public void setVisibleItemCount(int i) {
        this.visibleItemCount = i;
        updateVisibleItemCount();
        requestLayout();
    }

    public boolean isCyclicEnabled() {
        return this.cyclicEnabled;
    }

    public void setCyclicEnabled(boolean z) {
        this.cyclicEnabled = z;
        computeFlingLimitYCoordinate();
        invalidate();
    }

    public void setOnWheelChangedListener(OnWheelChangedListener onWheelChangedListener) {
        this.onWheelChangedListener = onWheelChangedListener;
    }

    public void setFormatter(WheelFormatter wheelFormatter) {
        this.formatter = wheelFormatter;
    }

    public List<?> getData() {
        return this.data;
    }

    public void setData(List<?> list) {
        setData(list, 0);
    }

    public void setData(List<?> list, Object obj) {
        setData(list, findPosition(obj));
    }

    public void setData(List<?> list, int i) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data = list;
        notifyDataSetChanged(i);
    }

    public void setDefaultValue(Object obj) {
        setDefaultPosition(findPosition(obj));
    }

    public void setDefaultPosition(int i) {
        notifyDataSetChanged(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int findPosition(Object obj) {
        WheelFormatter wheelFormatter;
        if (obj == null) {
            return 0;
        }
        Iterator<?> it = this.data.iterator();
        int i = 0;
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Object next = it.next();
            if (next != null) {
                if (next.equals(obj) || (((wheelFormatter = this.formatter) != null && wheelFormatter.formatItem(next).equals(this.formatter.formatItem(obj))) || (((next instanceof TextProvider) && ((TextProvider) next).provideText().equals(obj.toString())) || next.toString().equals(obj.toString())))) {
                    break;
                }
                i++;
            }
        }
        return i;
    }

    public boolean isSameWidthEnabled() {
        return this.sameWidthEnabled;
    }

    public void setSameWidthEnabled(boolean z) {
        this.sameWidthEnabled = z;
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    public String getMaxWidthText() {
        return this.maxWidthText;
    }

    public void setMaxWidthText(String str) {
        Objects.requireNonNull(str, "Maximum width text can not be null!");
        this.maxWidthText = str;
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
        invalidate();
    }

    public int getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public void setSelectedTextColor(int i) {
        this.selectedTextColor = i;
        computeCurrentItemRect();
        invalidate();
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    public float getSelectedTextSize() {
        return this.selectedTextSize;
    }

    public void setSelectedTextSize(float f) {
        this.selectedTextSize = f;
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    public boolean getSelectedTextBold() {
        return this.selectedTextBold;
    }

    public void setSelectedTextBold(boolean z) {
        this.selectedTextBold = z;
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    public int getItemSpace() {
        return this.itemSpace;
    }

    public void setItemSpace(int i) {
        this.itemSpace = i;
        requestLayout();
        invalidate();
    }

    public boolean isIndicatorEnabled() {
        return this.indicatorEnabled;
    }

    public void setIndicatorEnabled(boolean z) {
        this.indicatorEnabled = z;
        computeIndicatorRect();
        invalidate();
    }

    public float getIndicatorSize() {
        return this.indicatorSize;
    }

    public void setIndicatorSize(float f) {
        this.indicatorSize = f;
        computeIndicatorRect();
        invalidate();
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public void setIndicatorColor(int i) {
        this.indicatorColor = i;
        invalidate();
    }

    public int getCurvedIndicatorSpace() {
        return this.curvedIndicatorSpace;
    }

    public void setCurvedIndicatorSpace(int i) {
        this.curvedIndicatorSpace = i;
        computeIndicatorRect();
        invalidate();
    }

    public boolean isCurtainEnabled() {
        return this.curtainEnabled;
    }

    public void setCurtainEnabled(boolean z) {
        this.curtainEnabled = z;
        if (z) {
            this.indicatorEnabled = false;
        }
        computeCurrentItemRect();
        invalidate();
    }

    public int getCurtainColor() {
        return this.curtainColor;
    }

    public void setCurtainColor(int i) {
        this.curtainColor = i;
        invalidate();
    }

    public int getCurtainCorner() {
        return this.curtainCorner;
    }

    public void setCurtainCorner(int i) {
        this.curtainCorner = i;
        invalidate();
    }

    public float getCurtainRadius() {
        return this.curtainRadius;
    }

    public void setCurtainRadius(float f) {
        this.curtainRadius = f;
        invalidate();
    }

    public boolean isAtmosphericEnabled() {
        return this.atmosphericEnabled;
    }

    public void setAtmosphericEnabled(boolean z) {
        this.atmosphericEnabled = z;
        invalidate();
    }

    public boolean isCurvedEnabled() {
        return this.curvedEnabled;
    }

    public void setCurvedEnabled(boolean z) {
        this.curvedEnabled = z;
        requestLayout();
        invalidate();
    }

    public int getCurvedMaxAngle() {
        return this.curvedMaxAngle;
    }

    public void setCurvedMaxAngle(int i) {
        this.curvedMaxAngle = i;
        requestLayout();
        invalidate();
    }

    public int getTextAlign() {
        return this.textAlign;
    }

    public void setTextAlign(int i) {
        this.textAlign = i;
        updatePaintTextAlign();
        computeDrawnCenterCoordinate();
        invalidate();
    }

    private void updatePaintTextAlign() {
        int i = this.textAlign;
        if (i == 1) {
            this.paint.setTextAlign(Paint.Align.LEFT);
        } else if (i == 2) {
            this.paint.setTextAlign(Paint.Align.RIGHT);
        } else {
            this.paint.setTextAlign(Paint.Align.CENTER);
        }
    }

    public Typeface getTypeface() {
        return this.paint.getTypeface();
    }

    public void setTypeface(Typeface typeface) {
        if (typeface == null) {
            return;
        }
        this.paint.setTypeface(typeface);
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged(int i) {
        int max = Math.max(Math.min(i, getItemCount() - 1), 0);
        this.scrollOffsetYCoordinate = 0;
        this.defaultItem = getItem(max);
        this.defaultItemPosition = max;
        this.currentPosition = max;
        updatePaintTextAlign();
        computeFlingLimitYCoordinate();
        computeIndicatorRect();
        computeCurrentItemRect();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.textMaxWidth;
        int i4 = this.textMaxHeight;
        int i5 = this.visibleItemCount;
        int i6 = (i4 * i5) + (this.itemSpace * (i5 - 1));
        if (this.curvedEnabled) {
            i6 = (int) ((i6 * 2) / 3.141592653589793d);
        }
        setMeasuredDimension(measureSize(mode, size, i3 + getPaddingLeft() + getPaddingRight()), measureSize(mode2, size2, i6 + getPaddingTop() + getPaddingBottom()));
    }

    private int measureSize(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.rectDrawn.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.wheelCenterXCoordinate = this.rectDrawn.centerX();
        this.wheelCenterYCoordinate = this.rectDrawn.centerY();
        computeDrawnCenterCoordinate();
        this.halfWheelHeight = this.rectDrawn.height() / 2;
        int height = this.rectDrawn.height() / this.visibleItemCount;
        this.itemHeight = height;
        this.halfItemHeight = height / 2;
        computeFlingLimitYCoordinate();
        computeIndicatorRect();
        computeCurrentItemRect();
    }

    private void computeDrawnCenterCoordinate() {
        int i = this.textAlign;
        if (i == 1) {
            this.drawnCenterXCoordinate = this.rectDrawn.left;
        } else if (i == 2) {
            this.drawnCenterXCoordinate = this.rectDrawn.right;
        } else {
            this.drawnCenterXCoordinate = this.wheelCenterXCoordinate;
        }
        this.drawnCenterYCoordinate = (int) (this.wheelCenterYCoordinate - ((this.paint.ascent() + this.paint.descent()) / 2.0f));
    }

    private void computeFlingLimitYCoordinate() {
        int i = this.defaultItemPosition;
        int i2 = this.itemHeight;
        int i3 = i * i2;
        this.minFlingYCoordinate = this.cyclicEnabled ? Integer.MIN_VALUE : ((-i2) * (getItemCount() - 1)) + i3;
        if (this.cyclicEnabled) {
            i3 = Integer.MAX_VALUE;
        }
        this.maxFlingYCoordinate = i3;
    }

    private void computeIndicatorRect() {
        if (this.indicatorEnabled) {
            int i = this.curvedEnabled ? this.curvedIndicatorSpace : 0;
            int i2 = (int) (this.indicatorSize / 2.0f);
            int i3 = this.wheelCenterYCoordinate;
            int i4 = this.halfItemHeight;
            int i5 = i3 + i4 + i;
            int i6 = (i3 - i4) - i;
            this.rectIndicatorHead.set(this.rectDrawn.left, i5 - i2, this.rectDrawn.right, i5 + i2);
            this.rectIndicatorFoot.set(this.rectDrawn.left, i6 - i2, this.rectDrawn.right, i6 + i2);
        }
    }

    private void computeCurrentItemRect() {
        if (this.curtainEnabled || this.selectedTextColor != 0) {
            this.rectCurrentItem.set(this.rectDrawn.left, this.wheelCenterYCoordinate - this.halfItemHeight, this.rectDrawn.right, this.wheelCenterYCoordinate + this.halfItemHeight);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        OnWheelChangedListener onWheelChangedListener = this.onWheelChangedListener;
        if (onWheelChangedListener != null) {
            onWheelChangedListener.onWheelScrolled(this, this.scrollOffsetYCoordinate);
        }
        if (this.itemHeight - this.halfDrawnItemCount <= 0) {
            return;
        }
        drawCurtain(canvas);
        drawIndicator(canvas);
        drawAllItem(canvas);
    }

    private void drawAllItem(Canvas canvas) {
        int i = (this.scrollOffsetYCoordinate * (-1)) / this.itemHeight;
        int i2 = this.halfDrawnItemCount;
        int i3 = i - i2;
        int i4 = this.defaultItemPosition + i3;
        int i5 = i2 * (-1);
        while (i4 < this.defaultItemPosition + i3 + this.drawnItemCount) {
            initTextPaint();
            boolean z = i4 == (this.defaultItemPosition + i3) + (this.drawnItemCount / 2);
            int i6 = this.drawnCenterYCoordinate;
            int i7 = this.itemHeight;
            int i8 = (i5 * i7) + i6 + (this.scrollOffsetYCoordinate % i7);
            int abs = Math.abs(i6 - i8);
            float computeDegree = computeDegree(i8, (((this.drawnCenterYCoordinate - abs) - this.rectDrawn.top) * 1.0f) / (this.drawnCenterYCoordinate - this.rectDrawn.top));
            float computeYCoordinateAtAngle = computeYCoordinateAtAngle(computeDegree);
            if (this.curvedEnabled) {
                int i9 = this.wheelCenterXCoordinate;
                int i10 = this.textAlign;
                if (i10 == 1) {
                    i9 = this.rectDrawn.left;
                } else if (i10 == 2) {
                    i9 = this.rectDrawn.right;
                }
                float f = this.wheelCenterYCoordinate - computeYCoordinateAtAngle;
                this.camera.save();
                this.camera.rotateX(computeDegree);
                this.camera.getMatrix(this.matrixRotate);
                this.camera.restore();
                float f2 = -i9;
                float f3 = -f;
                this.matrixRotate.preTranslate(f2, f3);
                float f4 = i9;
                this.matrixRotate.postTranslate(f4, f);
                this.camera.save();
                this.camera.translate(0.0f, 0.0f, computeDepth(computeDegree));
                this.camera.getMatrix(this.matrixDepth);
                this.camera.restore();
                this.matrixDepth.preTranslate(f2, f3);
                this.matrixDepth.postTranslate(f4, f);
                this.matrixRotate.postConcat(this.matrixDepth);
            }
            computeAndSetAtmospheric(abs);
            drawItemRect(canvas, i4, z, this.curvedEnabled ? this.drawnCenterYCoordinate - computeYCoordinateAtAngle : i8);
            i4++;
            i5++;
        }
    }

    private void drawItemRect(Canvas canvas, int i, boolean z, float f) {
        int i2 = this.selectedTextColor;
        if (i2 == 0) {
            canvas.save();
            canvas.clipRect(this.rectDrawn);
            if (this.curvedEnabled) {
                canvas.concat(this.matrixRotate);
            }
            drawItemText(canvas, i, f);
            canvas.restore();
            return;
        }
        if (this.textSize != this.selectedTextSize || this.selectedTextBold) {
            if (!z) {
                canvas.save();
                if (this.curvedEnabled) {
                    canvas.concat(this.matrixRotate);
                }
                drawItemText(canvas, i, f);
                canvas.restore();
                return;
            }
            this.paint.setColor(i2);
            this.paint.setTextSize(this.selectedTextSize);
            this.paint.setFakeBoldText(this.selectedTextBold);
            canvas.save();
            if (this.curvedEnabled) {
                canvas.concat(this.matrixRotate);
            }
            drawItemText(canvas, i, f);
            canvas.restore();
            return;
        }
        canvas.save();
        if (this.curvedEnabled) {
            canvas.concat(this.matrixRotate);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.rectCurrentItem);
        } else {
            canvas.clipRect(this.rectCurrentItem, Region.Op.DIFFERENCE);
        }
        drawItemText(canvas, i, f);
        canvas.restore();
        this.paint.setColor(this.selectedTextColor);
        canvas.save();
        if (this.curvedEnabled) {
            canvas.concat(this.matrixRotate);
        }
        canvas.clipRect(this.rectCurrentItem);
        drawItemText(canvas, i, f);
        canvas.restore();
    }

    private void drawItemText(Canvas canvas, int i, float f) {
        int length;
        int measuredWidth = getMeasuredWidth();
        float measureText = this.paint.measureText("...");
        String obtainItemText = obtainItemText(i);
        boolean z = false;
        while ((this.paint.measureText(obtainItemText) + measureText) - measuredWidth > 0.0f && (length = obtainItemText.length()) > 1) {
            obtainItemText = obtainItemText.substring(0, length - 1);
            z = true;
        }
        if (z) {
            obtainItemText = obtainItemText + "...";
        }
        canvas.drawText(obtainItemText, this.drawnCenterXCoordinate, f, this.paint);
    }

    private float computeDegree(int i, float f) {
        int i2 = this.drawnCenterYCoordinate;
        int i3 = i > i2 ? 1 : i < i2 ? -1 : 0;
        float f2 = -(1.0f - f);
        int i4 = this.curvedMaxAngle;
        return clamp(f2 * i4 * i3, -i4, i4);
    }

    private float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : Math.min(f, f3);
    }

    private String obtainItemText(int i) {
        int itemCount = getItemCount();
        if (this.cyclicEnabled) {
            if (itemCount != 0) {
                int i2 = i % itemCount;
                if (i2 < 0) {
                    i2 += itemCount;
                }
                return formatItem(i2);
            }
        } else if (isPositionInRange(i, itemCount)) {
            return formatItem(i);
        }
        return "";
    }

    public String formatItem(int i) {
        return formatItem(getItem(i));
    }

    public String formatItem(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof TextProvider) {
            return ((TextProvider) obj).provideText();
        }
        WheelFormatter wheelFormatter = this.formatter;
        if (wheelFormatter != null) {
            return wheelFormatter.formatItem(obj);
        }
        return obj.toString();
    }

    private void computeAndSetAtmospheric(int i) {
        if (this.atmosphericEnabled) {
            this.paint.setAlpha(Math.max((int) ((((r0 - i) * 1.0f) / this.drawnCenterYCoordinate) * 255.0f), 0));
        }
    }

    private void drawCurtain(Canvas canvas) {
        float[] fArr;
        float[] fArr2;
        if (this.curtainEnabled) {
            this.paint.setColor(this.curtainColor);
            this.paint.setStyle(Paint.Style.FILL);
            if (this.curtainRadius > 0.0f) {
                Path path = new Path();
                int i = this.curtainCorner;
                if (i != 1) {
                    if (i == 2) {
                        float f = this.curtainRadius;
                        fArr2 = new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f};
                    } else if (i == 3) {
                        float f2 = this.curtainRadius;
                        fArr2 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, f2, f2};
                    } else if (i == 4) {
                        float f3 = this.curtainRadius;
                        fArr2 = new float[]{f3, f3, 0.0f, 0.0f, 0.0f, 0.0f, f3, f3};
                    } else if (i != 5) {
                        fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    } else {
                        float f4 = this.curtainRadius;
                        fArr2 = new float[]{0.0f, 0.0f, f4, f4, f4, f4, 0.0f, 0.0f};
                    }
                    fArr = fArr2;
                } else {
                    float f5 = this.curtainRadius;
                    fArr = new float[]{f5, f5, f5, f5, f5, f5, f5, f5};
                }
                path.addRoundRect(new RectF(this.rectCurrentItem), fArr, Path.Direction.CCW);
                canvas.drawPath(path, this.paint);
                return;
            }
            canvas.drawRect(this.rectCurrentItem, this.paint);
        }
    }

    private void drawIndicator(Canvas canvas) {
        if (this.indicatorEnabled) {
            this.paint.setColor(this.indicatorColor);
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.rectIndicatorHead, this.paint);
            canvas.drawRect(this.rectIndicatorFoot, this.paint);
        }
    }

    private float computeYCoordinateAtAngle(float f) {
        return (sinDegree(f) / sinDegree(this.curvedMaxAngle)) * this.halfWheelHeight;
    }

    private float sinDegree(float f) {
        return (float) Math.sin(Math.toRadians(f));
    }

    private int computeDepth(float f) {
        return (int) (this.halfWheelHeight - (Math.cos(Math.toRadians(f)) * this.halfWheelHeight));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                handleActionDown(motionEvent);
            } else if (action == 1) {
                handleActionUp(motionEvent);
            } else if (action == 2) {
                handleActionMove(motionEvent);
            } else if (action == 3) {
                handleActionCancel(motionEvent);
            }
        }
        if (this.isClick) {
            performClick();
        }
        return true;
    }

    private void handleActionDown(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        obtainOrClearTracker();
        this.tracker.addMovement(motionEvent);
        if (!this.scroller.isFinished()) {
            this.scroller.abortAnimation();
            this.isForceFinishScroll = true;
        }
        int y = (int) motionEvent.getY();
        this.lastPointYCoordinate = y;
        this.downPointYCoordinate = y;
    }

    private void handleActionMove(MotionEvent motionEvent) {
        int computeDistanceToEndPoint = computeDistanceToEndPoint(this.scroller.getFinalY() % this.itemHeight);
        if (Math.abs(this.downPointYCoordinate - motionEvent.getY()) < this.touchSlop && computeDistanceToEndPoint > 0) {
            this.isClick = true;
            return;
        }
        this.isClick = false;
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        OnWheelChangedListener onWheelChangedListener = this.onWheelChangedListener;
        if (onWheelChangedListener != null) {
            onWheelChangedListener.onWheelScrollStateChanged(this, 1);
        }
        float y = motionEvent.getY() - this.lastPointYCoordinate;
        if (Math.abs(y) < 1.0f) {
            return;
        }
        this.scrollOffsetYCoordinate = (int) (this.scrollOffsetYCoordinate + y);
        this.lastPointYCoordinate = (int) motionEvent.getY();
        invalidate();
    }

    private void handleActionUp(MotionEvent motionEvent) {
        int i;
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (this.isClick) {
            return;
        }
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
            this.tracker.computeCurrentVelocity(1000, this.maximumVelocity);
            i = (int) this.tracker.getYVelocity();
        } else {
            i = 0;
        }
        this.isForceFinishScroll = false;
        if (Math.abs(i) > this.minimumVelocity) {
            this.scroller.fling(0, this.scrollOffsetYCoordinate, 0, i, 0, 0, this.minFlingYCoordinate, this.maxFlingYCoordinate);
            int computeDistanceToEndPoint = computeDistanceToEndPoint(this.scroller.getFinalY() % this.itemHeight);
            Scroller scroller = this.scroller;
            scroller.setFinalY(scroller.getFinalY() + computeDistanceToEndPoint);
        } else {
            this.scroller.startScroll(0, this.scrollOffsetYCoordinate, 0, computeDistanceToEndPoint(this.scrollOffsetYCoordinate % this.itemHeight));
        }
        if (!this.cyclicEnabled) {
            int finalY = this.scroller.getFinalY();
            int i2 = this.maxFlingYCoordinate;
            if (finalY > i2) {
                this.scroller.setFinalY(i2);
            } else {
                int finalY2 = this.scroller.getFinalY();
                int i3 = this.minFlingYCoordinate;
                if (finalY2 < i3) {
                    this.scroller.setFinalY(i3);
                }
            }
        }
        this.handler.post(this);
        cancelTracker();
    }

    private void handleActionCancel(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        cancelTracker();
    }

    private void obtainOrClearTracker() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker == null) {
            this.tracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void cancelTracker() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.tracker = null;
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private int computeDistanceToEndPoint(int i) {
        int i2;
        if (Math.abs(i) <= this.halfItemHeight) {
            return i * (-1);
        }
        if (this.scrollOffsetYCoordinate < 0) {
            i2 = -this.itemHeight;
        } else {
            i2 = this.itemHeight;
        }
        return i2 - i;
    }

    @Override // java.lang.Runnable
    public void run() {
        OnWheelChangedListener onWheelChangedListener;
        if (this.itemHeight == 0) {
            return;
        }
        int itemCount = getItemCount();
        if (itemCount == 0) {
            OnWheelChangedListener onWheelChangedListener2 = this.onWheelChangedListener;
            if (onWheelChangedListener2 != null) {
                onWheelChangedListener2.onWheelScrollStateChanged(this, 0);
                return;
            }
            return;
        }
        if (this.scroller.isFinished() && !this.isForceFinishScroll) {
            int computePosition = computePosition(itemCount);
            if (computePosition < 0) {
                computePosition += itemCount;
            }
            this.currentPosition = computePosition;
            OnWheelChangedListener onWheelChangedListener3 = this.onWheelChangedListener;
            if (onWheelChangedListener3 != null) {
                onWheelChangedListener3.onWheelSelected(this, computePosition);
                this.onWheelChangedListener.onWheelScrollStateChanged(this, 0);
            }
            postInvalidate();
            return;
        }
        if (this.scroller.computeScrollOffset()) {
            OnWheelChangedListener onWheelChangedListener4 = this.onWheelChangedListener;
            if (onWheelChangedListener4 != null) {
                onWheelChangedListener4.onWheelScrollStateChanged(this, 2);
            }
            this.scrollOffsetYCoordinate = this.scroller.getCurrY();
            int computePosition2 = computePosition(itemCount);
            int i = this.lastScrollPosition;
            if (i != computePosition2) {
                if (computePosition2 == 0 && i == itemCount - 1 && (onWheelChangedListener = this.onWheelChangedListener) != null) {
                    onWheelChangedListener.onWheelLoopFinished(this);
                }
                this.lastScrollPosition = computePosition2;
            }
            postInvalidate();
            this.handler.postDelayed(this, 20L);
        }
    }

    private int computePosition(int i) {
        return (((this.scrollOffsetYCoordinate * (-1)) / this.itemHeight) + this.defaultItemPosition) % i;
    }

    public void scrollTo(final int i) {
        post(new Runnable() { // from class: com.ipotensic.baselib.views.wheelview.widget.WheelView.1
            @Override // java.lang.Runnable
            public void run() {
                WheelView.this.notifyDataSetChanged(i);
            }
        });
    }

    public final void smoothScrollTo(final int i) {
        if (isInEditMode()) {
            scrollTo(i);
            return;
        }
        int i2 = this.currentPosition - i;
        int i3 = this.scrollOffsetYCoordinate;
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, (i2 * this.itemHeight) + i3);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.baselib.views.wheelview.widget.WheelView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WheelView.this.scrollOffsetYCoordinate = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                WheelView.this.invalidate();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.ipotensic.baselib.views.wheelview.widget.WheelView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WheelView.this.scrollTo(i);
            }
        });
        ofInt.start();
    }
}