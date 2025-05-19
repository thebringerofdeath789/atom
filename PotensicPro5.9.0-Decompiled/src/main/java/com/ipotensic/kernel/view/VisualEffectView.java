package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;
import com.logan.camera.data.TrackTarget;

/* loaded from: classes2.dex */
public class VisualEffectView extends View {
    private final int DELETE_EXPAND_CLICK_AREA;
    private final int MIN_SLIDE_DISTANCE;
    private final int SELECT_EXPAND_CLICK_AREA;
    private Rect bitmapRect;
    private boolean canDraw;
    private final Point downPoint;
    private onDrawListener drawListener;
    private Rect drawRect;
    private int height;
    private boolean isFollowing;
    private boolean isPaintAble;
    private Paint paint;
    private Bitmap selectBitmapCenter;
    private Bitmap selectBitmapDelete;
    private NinePatchDrawable selectDrawableWrap;
    private TrackTarget trackTarget;
    private Bitmap trackTargetBitmap;
    private int videoHeight;
    private int videoWidth;
    private int width;

    public interface onDrawListener {
        void onDelete(TrackTarget.Box box);

        void onSelect(TrackTarget.Box box);

        void onSingleClick();
    }

    public VisualEffectView(Context context) {
        super(context);
        this.MIN_SLIDE_DISTANCE = 20;
        this.DELETE_EXPAND_CLICK_AREA = 100;
        this.SELECT_EXPAND_CLICK_AREA = 20;
        this.drawRect = new Rect();
        this.downPoint = new Point();
        this.isPaintAble = false;
        this.canDraw = true;
        this.isFollowing = false;
    }

    public VisualEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MIN_SLIDE_DISTANCE = 20;
        this.DELETE_EXPAND_CLICK_AREA = 100;
        this.SELECT_EXPAND_CLICK_AREA = 20;
        this.drawRect = new Rect();
        this.downPoint = new Point();
        this.isPaintAble = false;
        this.canDraw = true;
        this.isFollowing = false;
    }

    public VisualEffectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MIN_SLIDE_DISTANCE = 20;
        this.DELETE_EXPAND_CLICK_AREA = 100;
        this.SELECT_EXPAND_CLICK_AREA = 20;
        this.drawRect = new Rect();
        this.downPoint = new Point();
        this.isPaintAble = false;
        this.canDraw = true;
        this.isFollowing = false;
    }

    public VisualEffectView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.MIN_SLIDE_DISTANCE = 20;
        this.DELETE_EXPAND_CLICK_AREA = 100;
        this.SELECT_EXPAND_CLICK_AREA = 20;
        this.drawRect = new Rect();
        this.downPoint = new Point();
        this.isPaintAble = false;
        this.canDraw = true;
        this.isFollowing = false;
    }

    public void init(onDrawListener ondrawlistener) {
        this.drawListener = ondrawlistener;
        this.trackTargetBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_icon_track_target);
        this.selectDrawableWrap = (NinePatchDrawable) getResources().getDrawable(R.mipmap.icon_target_select_wrap);
        this.selectBitmapCenter = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_target_select_center);
        this.selectBitmapDelete = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_target_delete);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-16711936);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(2.0f);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    public void setPreviewVideoSize(int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
        int screenHeight = ScreenUtils.getScreenHeight(getContext());
        this.width = (i * screenHeight) / i2;
        this.height = screenHeight;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.width;
        layoutParams.height = -1;
        setLayoutParams(layoutParams);
        postInvalidate();
    }

    public void setPaintAble(boolean z) {
        this.isPaintAble = z;
    }

    public void setCanDraw(boolean z) {
        this.canDraw = z;
    }

    public void setFollowing(boolean z) {
        this.isFollowing = z;
    }

    public boolean isInit() {
        return (this.videoWidth == 0 || this.videoHeight == 0) ? false : true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isPaintAble) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < 0) {
                x = 0;
            }
            int i = this.width;
            if (x > i) {
                x = i;
            }
            if (y < 0) {
                y = 0;
            }
            int i2 = this.height;
            if (y > i2) {
                y = i2;
            }
            DDLog.e("event.getaction:" + motionEvent.getAction());
            int action = motionEvent.getAction();
            if (action == 0) {
                this.downPoint.x = x;
                this.downPoint.y = y;
            } else if (action != 1) {
                if (action == 2 && this.canDraw) {
                    if (x < this.downPoint.x) {
                        this.drawRect.left = x;
                        this.drawRect.right = this.downPoint.x;
                    } else {
                        this.drawRect.right = x;
                        this.drawRect.left = this.downPoint.x;
                    }
                    if (y < this.downPoint.y) {
                        this.drawRect.top = y;
                        this.drawRect.bottom = this.downPoint.y;
                    } else {
                        this.drawRect.bottom = y;
                        this.drawRect.top = this.downPoint.y;
                    }
                    postInvalidate();
                }
            } else {
                int abs = Math.abs(this.downPoint.x - x);
                int abs2 = Math.abs(this.downPoint.y - y);
                if (abs < 20 && abs2 < 20) {
                    DDLog.e("点击 ： 点击1");
                    checkTarget(x, y);
                } else {
                    DDLog.e("点击 ： 画框");
                    if (this.canDraw) {
                        sendTarget(toVideoX(this.drawRect.left), toVideoY(this.drawRect.top), toVideoX(this.drawRect.width()), toVideoY(this.drawRect.height()));
                    }
                }
                postDelayed(new Runnable() { // from class: com.ipotensic.kernel.view.VisualEffectView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VisualEffectView.this.drawRect != null) {
                            VisualEffectView.this.drawRect = new Rect();
                            VisualEffectView.this.postInvalidate();
                        }
                    }
                }, 100L);
                onDrawListener ondrawlistener = this.drawListener;
                if (ondrawlistener != null) {
                    ondrawlistener.onSingleClick();
                }
            }
        }
        return true;
    }

    private void sendTarget(int i, int i2, int i3, int i4) {
        TrackTarget.Box box = new TrackTarget.Box();
        box.setBbox_id(0);
        box.setClass_id(0);
        box.setX(i);
        box.setY(i2);
        box.setWidth(i3);
        box.setHeight(i4);
        DDLog.e("发送box:" + box.toJson());
        onDrawListener ondrawlistener = this.drawListener;
        if (ondrawlistener != null) {
            ondrawlistener.onSelect(box);
        }
    }

    private void checkTarget(int i, int i2) {
        if (this.trackTarget != null) {
            for (int i3 = 0; i3 < this.trackTarget.getBboxes().size(); i3++) {
                TrackTarget.Box box = this.trackTarget.getBboxes().get(i3);
                if (box != null) {
                    Point point = new Point(i, i2);
                    if (this.trackTarget.isSelected()) {
                        DDLog.e("点击 ： 删除1");
                        if (box.isDeleteRectContain(point)) {
                            DDLog.e("点击 ： 删除2");
                            TrackTarget.Box m22clone = box.m22clone();
                            m22clone.setBbox_id(-1);
                            m22clone.setClass_id(-1);
                            onDrawListener ondrawlistener = this.drawListener;
                            if (ondrawlistener != null) {
                                ondrawlistener.onDelete(m22clone);
                                return;
                            }
                            return;
                        }
                    } else {
                        DDLog.e("点击 ： 选择1");
                        if (box.isDrawRectContain(point)) {
                            DDLog.e("点击 ： 选择2");
                            onDrawListener ondrawlistener2 = this.drawListener;
                            if (ondrawlistener2 != null) {
                                ondrawlistener2.onSelect(box);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    private int toVideoX(int i) {
        return (i * this.videoWidth) / this.width;
    }

    private int toVideoY(int i) {
        return (i * this.videoHeight) / this.height;
    }

    private int toViewX(int i) {
        return (i * this.width) / this.videoWidth;
    }

    private int toViewY(int i) {
        return (i * this.height) / this.videoHeight;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInit()) {
            drawBoxes(canvas);
            drawSelfBox(canvas);
        }
    }

    private void drawSelectBox(Canvas canvas, TrackTarget.Box box) {
        Rect rect = new Rect(toViewX(box.getX()), toViewY(box.getY()), toViewX(box.getX() + box.getWidth()), toViewY(box.getY() + box.getHeight()));
        if (this.isFollowing) {
            int width = this.selectBitmapCenter.getWidth() / 2;
            int height = this.selectBitmapCenter.getHeight() / 2;
            canvas.drawBitmap(this.selectBitmapCenter, new Rect(0, 0, this.selectBitmapCenter.getWidth(), this.selectBitmapCenter.getHeight()), new Rect(rect.centerX() - width, rect.centerY() - height, rect.centerX() + width, rect.centerY() + height), this.paint);
            return;
        }
        NinePatchDrawable ninePatchDrawable = this.selectDrawableWrap;
        if (ninePatchDrawable != null) {
            ninePatchDrawable.setBounds(rect);
            this.selectDrawableWrap.draw(canvas);
        }
        if (box.getDeleteRect() != null) {
            canvas.drawBitmap(this.selectBitmapDelete, box.getDeleteRect().left, box.getDeleteRect().top, this.paint);
        }
    }

    private void drawBoxes(Canvas canvas) {
        TrackTarget trackTarget;
        if (this.trackTargetBitmap == null || (trackTarget = this.trackTarget) == null || trackTarget.getBboxes() == null) {
            return;
        }
        if (this.trackTarget.isSelected()) {
            if (this.trackTarget.getBboxes().size() >= 1) {
                drawSelectBox(canvas, this.trackTarget.getBboxes().get(0));
                return;
            }
            return;
        }
        int width = this.trackTargetBitmap.getWidth();
        int height = this.trackTargetBitmap.getHeight();
        if (this.bitmapRect == null) {
            this.bitmapRect = new Rect(0, 0, width, height);
        }
        for (int i = 0; i < this.trackTarget.getBboxes().size(); i++) {
            canvas.drawBitmap(this.trackTargetBitmap, this.bitmapRect, this.trackTarget.getBboxes().get(i).getDrawRect(), this.paint);
        }
    }

    private void drawSelfBox(Canvas canvas) {
        NinePatchDrawable ninePatchDrawable = this.selectDrawableWrap;
        if (ninePatchDrawable != null) {
            ninePatchDrawable.setBounds(this.drawRect);
            this.selectDrawableWrap.draw(canvas);
        }
    }

    public void clear() {
        this.trackTarget = null;
        postInvalidate();
    }

    public void setTrackTarget(TrackTarget trackTarget) {
        if (trackTarget != null) {
            this.trackTarget = trackTarget;
            if (trackTarget.getBboxes() != null) {
                if (trackTarget.isSelected()) {
                    if (trackTarget.getBboxes().size() >= 1) {
                        TrackTarget.Box box = trackTarget.getBboxes().get(0);
                        if (this.isFollowing) {
                            box.setDeleteRect(null);
                        } else {
                            Rect rect = new Rect(toViewX(box.getX()), toViewY(box.getY()), toViewX(box.getX() + box.getWidth()), toViewY(box.getY() + box.getHeight()));
                            Rect rect2 = new Rect(rect.right - (this.selectBitmapDelete.getWidth() / 2), rect.top - (this.selectBitmapDelete.getHeight() / 2), rect.right + (this.selectBitmapDelete.getWidth() / 2), rect.top + (this.selectBitmapDelete.getHeight() / 2));
                            box.setDeleteRect(rect2);
                            box.setClickDeleteRect(new Rect(rect2.left - 100, rect2.top - 100, rect2.right + 100, rect2.bottom + 100));
                        }
                    }
                } else {
                    int width = this.trackTargetBitmap.getWidth();
                    int height = this.trackTargetBitmap.getHeight();
                    for (int i = 0; i < trackTarget.getBboxes().size(); i++) {
                        TrackTarget.Box box2 = trackTarget.getBboxes().get(i);
                        Rect rect3 = new Rect(toViewX(box2.getX()), toViewY(box2.getY()), toViewX(box2.getX() + box2.getWidth()), toViewY(box2.getY() + box2.getHeight()));
                        int i2 = width / 2;
                        int i3 = height / 2;
                        Rect rect4 = new Rect(rect3.centerX() - i2, rect3.centerY() - i3, rect3.centerX() + i2, rect3.centerY() + i3);
                        box2.setDrawRect(rect4);
                        box2.setClickSelectRect(new Rect(rect4.left - 20, rect4.top - 20, rect4.right + 20, rect4.bottom + 20));
                    }
                }
            }
            postInvalidate();
        }
    }
}
