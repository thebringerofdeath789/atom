package com.ipotensic.kernel.view.deleteview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes2.dex */
public class SwipeItemLayout extends ViewGroup {
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.ipotensic.kernel.view.deleteview.SwipeItemLayout.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private boolean mInLayout;
    private boolean mIsLaidOut;
    private ViewGroup mMainView;
    private int mMaxScrollOffset;
    private int mScrollOffset;
    private ScrollRunnable mScrollRunnable;
    private ViewGroup mSideView;
    private Mode mTouchMode;

    enum Mode {
        RESET,
        DRAG,
        FLING,
        TAP
    }

    public SwipeItemLayout(Context context) {
        this(context, null);
    }

    public SwipeItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchMode = Mode.RESET;
        this.mScrollOffset = 0;
        this.mIsLaidOut = false;
        this.mScrollRunnable = new ScrollRunnable(context);
    }

    public boolean isOpen() {
        return this.mScrollOffset != 0;
    }

    Mode getTouchMode() {
        return this.mTouchMode;
    }

    /* renamed from: com.ipotensic.kernel.view.deleteview.SwipeItemLayout$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$kernel$view$deleteview$SwipeItemLayout$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$ipotensic$kernel$view$deleteview$SwipeItemLayout$Mode = iArr;
            try {
                iArr[Mode.FLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$view$deleteview$SwipeItemLayout$Mode[Mode.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    void setTouchMode(Mode mode) {
        if (AnonymousClass2.$SwitchMap$com$ipotensic$kernel$view$deleteview$SwipeItemLayout$Mode[this.mTouchMode.ordinal()] == 1) {
            this.mScrollRunnable.abort();
        }
        this.mTouchMode = mode;
    }

    public void open() {
        if (this.mScrollOffset != (-this.mMaxScrollOffset)) {
            if (this.mTouchMode == Mode.FLING && this.mScrollRunnable.isScrollToLeft()) {
                return;
            }
            if (this.mTouchMode == Mode.FLING) {
                this.mScrollRunnable.abort();
            }
            this.mScrollRunnable.startScroll(this.mScrollOffset, -this.mMaxScrollOffset);
        }
    }

    public void close() {
        if (this.mScrollOffset != 0) {
            if (this.mTouchMode != Mode.FLING || this.mScrollRunnable.isScrollToLeft()) {
                if (this.mTouchMode == Mode.FLING) {
                    this.mScrollRunnable.abort();
                }
                this.mScrollRunnable.startScroll(this.mScrollOffset, 0);
            }
        }
    }

    void fling(int i) {
        this.mScrollRunnable.startFling(this.mScrollOffset, i);
    }

    void revise() {
        if (this.mScrollOffset < (-this.mMaxScrollOffset) / 2) {
            open();
        } else {
            close();
        }
    }

    boolean trackMotionScroll(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        int i2 = this.mScrollOffset + i;
        if ((i > 0 && i2 > 0) || (i < 0 && i2 < (-this.mMaxScrollOffset))) {
            i2 = Math.max(Math.min(i2, 0), -this.mMaxScrollOffset);
            z = true;
        }
        offsetChildrenLeftAndRight(i2 - this.mScrollOffset);
        this.mScrollOffset = i2;
        return z;
    }

    private boolean ensureChildren() {
        if (getChildCount() != 2) {
            return false;
        }
        View childAt = getChildAt(0);
        if (!(childAt instanceof ViewGroup)) {
            return false;
        }
        this.mMainView = (ViewGroup) childAt;
        View childAt2 = getChildAt(1);
        if (!(childAt2 instanceof ViewGroup)) {
            return false;
        }
        this.mSideView = (ViewGroup) childAt2;
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!ensureChildren()) {
            throw new RuntimeException("SwipeItemLayout的子视图不符合规定");
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMainView.getLayoutParams();
        int i3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        int i4 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        measureChildWithMargins(this.mMainView, i, i3 + paddingLeft, i2, i4 + paddingTop);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, this.mMainView.getMeasuredWidth() + i3 + paddingLeft);
        } else if (mode == 0) {
            size = this.mMainView.getMeasuredWidth() + i3 + paddingLeft;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, this.mMainView.getMeasuredHeight() + i4 + paddingTop);
        } else if (mode2 == 0) {
            size2 = this.mMainView.getMeasuredHeight() + i4 + paddingTop;
        }
        setMeasuredDimension(size, size2);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mSideView.getLayoutParams();
        this.mSideView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - (marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin)) - paddingTop, 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!ensureChildren()) {
            throw new RuntimeException("SwipeItemLayout的子视图不符合规定");
        }
        this.mInLayout = true;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMainView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mSideView.getLayoutParams();
        int i5 = paddingLeft + marginLayoutParams.leftMargin;
        int i6 = marginLayoutParams.topMargin + paddingTop;
        int width = getWidth() - (paddingRight + marginLayoutParams.rightMargin);
        this.mMainView.layout(i5, i6, width, getHeight() - (marginLayoutParams.bottomMargin + paddingBottom));
        int i7 = width + marginLayoutParams2.leftMargin;
        this.mSideView.layout(i7, paddingTop + marginLayoutParams2.topMargin, marginLayoutParams2.leftMargin + i7 + marginLayoutParams2.rightMargin + this.mSideView.getMeasuredWidth(), getHeight() - (marginLayoutParams2.bottomMargin + paddingBottom));
        int width2 = this.mSideView.getWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
        this.mMaxScrollOffset = width2;
        int i8 = this.mScrollOffset < (-width2) / 2 ? -width2 : 0;
        this.mScrollOffset = i8;
        offsetChildrenLeftAndRight(i8);
        this.mInLayout = false;
        this.mIsLaidOut = true;
    }

    void offsetChildrenLeftAndRight(int i) {
        ViewCompat.offsetLeftAndRight(this.mMainView, i);
        ViewCompat.offsetLeftAndRight(this.mSideView, i);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? layoutParams : new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ViewGroup.MarginLayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.mScrollOffset;
        if (i != 0 && this.mIsLaidOut) {
            offsetChildrenLeftAndRight(-i);
            this.mScrollOffset = 0;
        } else {
            this.mScrollOffset = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = this.mScrollOffset;
        if (i != 0 && this.mIsLaidOut) {
            offsetChildrenLeftAndRight(-i);
            this.mScrollOffset = 0;
        } else {
            this.mScrollOffset = 0;
        }
        removeCallbacks(this.mScrollRunnable);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            return actionMasked == 1 && (findTopChildUnder = findTopChildUnder(this, (int) motionEvent.getX(), (int) motionEvent.getY())) != null && findTopChildUnder == this.mMainView && this.mTouchMode == Mode.TAP && this.mScrollOffset != 0;
        }
        View findTopChildUnder2 = findTopChildUnder(this, (int) motionEvent.getX(), (int) motionEvent.getY());
        return (findTopChildUnder2 == null || findTopChildUnder2 != this.mMainView || this.mScrollOffset == 0) ? false : true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            View findTopChildUnder2 = findTopChildUnder(this, (int) motionEvent.getX(), (int) motionEvent.getY());
            return (findTopChildUnder2 == null || findTopChildUnder2 != this.mMainView || this.mScrollOffset == 0) ? false : true;
        }
        if (actionMasked != 1 || (findTopChildUnder = findTopChildUnder(this, (int) motionEvent.getX(), (int) motionEvent.getY())) == null || findTopChildUnder != this.mMainView || this.mTouchMode != Mode.TAP || this.mScrollOffset == 0) {
            return false;
        }
        close();
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (getVisibility() != 0) {
            this.mScrollOffset = 0;
            invalidate();
        }
    }

    class ScrollRunnable implements Runnable {
        private static final int FLING_DURATION = 200;
        private int mMinVelocity;
        private Scroller mScroller;
        private boolean mAbort = false;
        private boolean mScrollToLeft = false;

        ScrollRunnable(Context context) {
            this.mScroller = new Scroller(context, SwipeItemLayout.sInterpolator);
            this.mMinVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        }

        void startScroll(int i, int i2) {
            if (i != i2) {
                Log.e("scroll - startX - endX", "" + i + StringUtils.SPACE + i2);
                SwipeItemLayout.this.setTouchMode(Mode.FLING);
                this.mAbort = false;
                this.mScrollToLeft = i2 < i;
                this.mScroller.startScroll(i, 0, i2 - i, 0, NNTPReply.SERVICE_DISCONTINUED);
                ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
            }
        }

        void startFling(int i, int i2) {
            Log.e("fling - startX", "" + i);
            int i3 = this.mMinVelocity;
            if (i2 <= i3 || i == 0) {
                if (i2 >= (-i3) || i == (-SwipeItemLayout.this.mMaxScrollOffset)) {
                    startScroll(i, i <= (-SwipeItemLayout.this.mMaxScrollOffset) / 2 ? -SwipeItemLayout.this.mMaxScrollOffset : 0);
                    return;
                } else {
                    startScroll(i, -SwipeItemLayout.this.mMaxScrollOffset);
                    return;
                }
            }
            startScroll(i, 0);
        }

        void abort() {
            if (this.mAbort) {
                return;
            }
            this.mAbort = true;
            if (this.mScroller.isFinished()) {
                return;
            }
            this.mScroller.abortAnimation();
            SwipeItemLayout.this.removeCallbacks(this);
        }

        boolean isScrollToLeft() {
            return this.mScrollToLeft;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.e("abort", Boolean.toString(this.mAbort));
            if (this.mAbort) {
                return;
            }
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            Log.e("curX", "" + currX);
            SwipeItemLayout swipeItemLayout = SwipeItemLayout.this;
            boolean trackMotionScroll = swipeItemLayout.trackMotionScroll(currX - swipeItemLayout.mScrollOffset);
            if (computeScrollOffset && !trackMotionScroll) {
                ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
                return;
            }
            if (trackMotionScroll) {
                SwipeItemLayout.this.removeCallbacks(this);
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                SwipeItemLayout.this.setTouchMode(Mode.RESET);
            }
            if (computeScrollOffset) {
                return;
            }
            SwipeItemLayout.this.setTouchMode(Mode.RESET);
            if (SwipeItemLayout.this.mScrollOffset != 0) {
                if (Math.abs(SwipeItemLayout.this.mScrollOffset) <= SwipeItemLayout.this.mMaxScrollOffset / 2) {
                    SwipeItemLayout.this.mScrollOffset = 0;
                } else {
                    SwipeItemLayout swipeItemLayout2 = SwipeItemLayout.this;
                    swipeItemLayout2.mScrollOffset = -swipeItemLayout2.mMaxScrollOffset;
                }
                ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
            }
        }
    }

    public static class OnSwipeItemTouchListener implements RecyclerView.OnItemTouchListener {
        private int mActivePointerId;
        private SwipeItemLayout mCaptureItem;
        private boolean mDealByParent;
        private boolean mIsProbeParent;
        private float mLastMotionX;
        private float mLastMotionY;
        private int mMaximumVelocity;
        private int mTouchSlop;
        private VelocityTracker mVelocityTracker;

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public OnSwipeItemTouchListener(Context context) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mActivePointerId = -1;
            this.mDealByParent = false;
            this.mIsProbeParent = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            boolean z;
            SwipeItemLayout swipeItemLayout;
            boolean z2;
            ViewParent parent;
            SwipeItemLayout swipeItemLayout2;
            boolean z3 = false;
            if (this.mIsProbeParent) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (actionMasked == 0) {
                this.mActivePointerId = motionEvent.getPointerId(0);
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mLastMotionX = x;
                this.mLastMotionY = y;
                View findTopChildUnder = SwipeItemLayout.findTopChildUnder(recyclerView, (int) x, (int) y);
                if (findTopChildUnder == null || !(findTopChildUnder instanceof SwipeItemLayout)) {
                    z = true;
                    swipeItemLayout = null;
                } else {
                    swipeItemLayout = (SwipeItemLayout) findTopChildUnder;
                    z = false;
                }
                if (!z && ((swipeItemLayout2 = this.mCaptureItem) == null || swipeItemLayout2 != swipeItemLayout)) {
                    z = true;
                }
                if (!z) {
                    if (this.mCaptureItem.getTouchMode() == Mode.FLING) {
                        this.mCaptureItem.setTouchMode(Mode.DRAG);
                        z2 = true;
                        z3 = true;
                    } else {
                        this.mCaptureItem.setTouchMode(Mode.TAP);
                        if (this.mCaptureItem.isOpen()) {
                            z2 = false;
                            z3 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z3 && (parent = recyclerView.getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    z3 = z2;
                } else {
                    SwipeItemLayout swipeItemLayout3 = this.mCaptureItem;
                    if (swipeItemLayout3 != null && swipeItemLayout3.isOpen()) {
                        this.mCaptureItem.close();
                        this.mCaptureItem = null;
                        z3 = true;
                    }
                    if (swipeItemLayout != null) {
                        this.mCaptureItem = swipeItemLayout;
                        swipeItemLayout.setTouchMode(Mode.TAP);
                    } else {
                        this.mCaptureItem = null;
                    }
                }
            } else {
                if (actionMasked == 1) {
                    SwipeItemLayout swipeItemLayout4 = this.mCaptureItem;
                    if (swipeItemLayout4 != null && swipeItemLayout4.getTouchMode() == Mode.DRAG) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        this.mCaptureItem.fling((int) velocityTracker.getXVelocity(this.mActivePointerId));
                        z3 = true;
                    }
                    cancel();
                    return z3;
                }
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    if (this.mDealByParent) {
                        SwipeItemLayout swipeItemLayout5 = this.mCaptureItem;
                        if (swipeItemLayout5 != null && swipeItemLayout5.isOpen()) {
                            this.mCaptureItem.close();
                        }
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (((int) motionEvent.getY(findPointerIndex)) + 0.5f);
                    float f = x2;
                    int i = (int) (f - this.mLastMotionX);
                    float f2 = y2;
                    int i2 = (int) (f2 - this.mLastMotionY);
                    int abs = Math.abs(i);
                    int abs2 = Math.abs(i2);
                    SwipeItemLayout swipeItemLayout6 = this.mCaptureItem;
                    if (swipeItemLayout6 == null || this.mDealByParent) {
                        return false;
                    }
                    if (swipeItemLayout6.getTouchMode() == Mode.TAP && abs > this.mTouchSlop && abs > abs2) {
                        this.mCaptureItem.setTouchMode(Mode.DRAG);
                        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                        int i3 = this.mTouchSlop;
                        i = i > 0 ? i - i3 : i + i3;
                    }
                    if (this.mCaptureItem.getTouchMode() != Mode.DRAG) {
                        return false;
                    }
                    this.mLastMotionX = f;
                    this.mLastMotionY = f2;
                    this.mCaptureItem.trackMotionScroll(i);
                    return true;
                }
                if (actionMasked == 3) {
                    SwipeItemLayout swipeItemLayout7 = this.mCaptureItem;
                    if (swipeItemLayout7 != null) {
                        swipeItemLayout7.revise();
                    }
                    cancel();
                    return false;
                }
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return false;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    if (motionEvent.getPointerId(actionIndex) != this.mActivePointerId) {
                        return false;
                    }
                    int i4 = actionIndex != 0 ? 0 : 1;
                    this.mActivePointerId = motionEvent.getPointerId(i4);
                    this.mLastMotionX = motionEvent.getX(i4);
                    this.mLastMotionY = motionEvent.getY(i4);
                    return false;
                }
            }
            int actionIndex2 = motionEvent.getActionIndex();
            this.mActivePointerId = motionEvent.getPointerId(actionIndex2);
            this.mLastMotionX = motionEvent.getX(actionIndex2);
            this.mLastMotionY = motionEvent.getY(actionIndex2);
            return z3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (actionMasked == 1) {
                SwipeItemLayout swipeItemLayout = this.mCaptureItem;
                if (swipeItemLayout != null && swipeItemLayout.getTouchMode() == Mode.DRAG) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    this.mCaptureItem.fling((int) velocityTracker.getXVelocity(this.mActivePointerId));
                }
                cancel();
                return;
            }
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    return;
                }
                float x = motionEvent.getX(findPointerIndex);
                float y = (int) motionEvent.getY(findPointerIndex);
                int i = (int) (x - this.mLastMotionX);
                SwipeItemLayout swipeItemLayout2 = this.mCaptureItem;
                if (swipeItemLayout2 == null || swipeItemLayout2.getTouchMode() != Mode.DRAG) {
                    return;
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
                this.mCaptureItem.trackMotionScroll(i);
                return;
            }
            if (actionMasked == 3) {
                SwipeItemLayout swipeItemLayout3 = this.mCaptureItem;
                if (swipeItemLayout3 != null) {
                    swipeItemLayout3.revise();
                }
                cancel();
                return;
            }
            if (actionMasked == 5) {
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                this.mLastMotionX = motionEvent.getX(actionIndex);
                this.mLastMotionY = motionEvent.getY(actionIndex);
            } else if (actionMasked == 6 && motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
                int i2 = actionIndex != 0 ? 0 : 1;
                this.mActivePointerId = motionEvent.getPointerId(i2);
                this.mLastMotionX = motionEvent.getX(i2);
                this.mLastMotionY = motionEvent.getY(i2);
            }
        }

        void cancel() {
            this.mDealByParent = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }
    }

    static View findTopChildUnder(ViewGroup viewGroup, int i, int i2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public static void closeAllItems(RecyclerView recyclerView) {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt instanceof SwipeItemLayout) {
                SwipeItemLayout swipeItemLayout = (SwipeItemLayout) childAt;
                if (swipeItemLayout.isOpen()) {
                    swipeItemLayout.close();
                }
            }
        }
    }
}
