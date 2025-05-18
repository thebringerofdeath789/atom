package com.logan.camera.data;

import android.graphics.Point;
import android.graphics.Rect;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class TrackTarget extends BaseData {
    public static final int TARGET_SELECT = 0;
    public static final int TARGET_UNSELECT = -1;
    private int selected_id = -1;
    private List<Box> bboxes = new ArrayList();

    public int getSelected_id() {
        return this.selected_id;
    }

    public void setSelected_id(int i) {
        this.selected_id = i;
    }

    public List<Box> getBboxes() {
        return this.bboxes;
    }

    public void setBboxes(List<Box> list) {
        this.bboxes = list;
    }

    public boolean isSelected() {
        return this.selected_id == 0;
    }

    public static class Box implements Cloneable {
        private int bbox_id;
        private int class_id;
        private Rect clickDeleteRect;
        private Rect clickSelectRect;
        private Rect deleteRect;
        private Rect drawRect;
        private int height;
        private int mode;
        private int width;

        /* renamed from: x */
        private int f2421x;

        /* renamed from: y */
        private int f2422y;

        public int getBbox_id() {
            return this.bbox_id;
        }

        public void setBbox_id(int i) {
            this.bbox_id = i;
        }

        public int getClass_id() {
            return this.class_id;
        }

        public void setClass_id(int i) {
            this.class_id = i;
        }

        public int getX() {
            return this.f2421x;
        }

        public void setX(int i) {
            this.f2421x = i;
        }

        public int getY() {
            return this.f2422y;
        }

        public void setY(int i) {
            this.f2422y = i;
        }

        public int getWidth() {
            return this.width;
        }

        public int getMode() {
            return this.mode;
        }

        public void setMode(int i) {
            this.mode = i;
        }

        public void setWidth(int i) {
            this.width = i;
        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public void setDrawRect(Rect rect) {
            this.drawRect = rect;
        }

        public Rect getDrawRect() {
            return this.drawRect;
        }

        public void setDeleteRect(Rect rect) {
            this.deleteRect = rect;
        }

        public Rect getDeleteRect() {
            return this.deleteRect;
        }

        public void setClickSelectRect(Rect rect) {
            this.clickSelectRect = rect;
        }

        public void setClickDeleteRect(Rect rect) {
            this.clickDeleteRect = rect;
        }

        public boolean isDrawRectContain(Point point) {
            Rect rect = this.clickSelectRect;
            return rect != null && rect.contains(point.x, point.y);
        }

        public boolean isDeleteRectContain(Point point) {
            Rect rect = this.clickDeleteRect;
            return rect != null && rect.contains(point.x, point.y);
        }

        public String toJson() {
            return JSON.toJSONString(this);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Box m2616clone() {
            try {
                return (Box) super.clone();
            } catch (Exception unused) {
                return this;
            }
        }

        public String toString() {
            return "bbox{class_id=" + this.class_id + ", x=" + this.f2421x + ", y=" + this.f2422y + ", width=" + this.width + ", height=" + this.height + '}';
        }
    }
}