package com.ipotensic.baselib.xtoast.draggable;

import android.view.MotionEvent;
import android.view.View;
import com.ipotensic.baselib.xtoast.BaseDraggable;

/* loaded from: classes2.dex */
public class MovingDraggable extends BaseDraggable {
    private float mViewDownX;
    private float mViewDownY;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mViewDownX = motionEvent.getX();
            this.mViewDownY = motionEvent.getY();
        } else {
            if (action == 1) {
                return (this.mViewDownX == motionEvent.getX() && this.mViewDownY == motionEvent.getY()) ? false : true;
            }
            if (action == 2) {
                updateLocation(motionEvent.getRawX() - this.mViewDownX, (motionEvent.getRawY() - getStatusBarHeight()) - this.mViewDownY);
            }
        }
        return false;
    }
}