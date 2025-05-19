package me.yokeyword.indexablerv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import me.yokeyword.indexablerecyclerview.R;

/* loaded from: classes4.dex */
class IndexBar extends View {
    private ArrayList<EntityWrapper> mDatas;
    private Paint mFocusPaint;
    private float mIndexHeight;
    private List<String> mIndexList;
    private HashMap<String, Integer> mMapping;
    private Paint mPaint;
    private int mSelectionPosition;
    private float mTextSpace;
    private int mTotalHeight;

    public IndexBar(Context context) {
        super(context);
        this.mIndexList = new ArrayList();
        this.mMapping = new HashMap<>();
        this.mPaint = new Paint(1);
        this.mFocusPaint = new Paint(1);
    }

    void init(Drawable drawable, int i, int i2, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
        this.mTextSpace = f2;
        this.mPaint.setColor(i);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(f);
        this.mFocusPaint.setTextAlign(Paint.Align.CENTER);
        this.mFocusPaint.setTextSize(f + ((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics())));
        this.mFocusPaint.setColor(i2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        if (this.mIndexList.size() > 0) {
            this.mTotalHeight = (int) (((this.mIndexList.size() - 1) * this.mPaint.getTextSize()) + this.mFocusPaint.getTextSize() + ((this.mIndexList.size() + 1) * this.mTextSpace));
        }
        if (this.mTotalHeight > size) {
            this.mTotalHeight = size;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mTotalHeight, 1073741824));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIndexList.size() == 0) {
            return;
        }
        this.mIndexHeight = getHeight() / this.mIndexList.size();
        for (int i = 0; i < this.mIndexList.size(); i++) {
            if (this.mSelectionPosition == i) {
                String str = this.mIndexList.get(i);
                float width = getWidth() / 2;
                float f = this.mIndexHeight;
                canvas.drawText(str, width, (0.85f * f) + (f * i), this.mFocusPaint);
            } else {
                String str2 = this.mIndexList.get(i);
                float width2 = getWidth() / 2;
                float f2 = this.mIndexHeight;
                canvas.drawText(str2, width2, (0.85f * f2) + (f2 * i), this.mPaint);
            }
        }
    }

    int getPositionForPointY(float f) {
        if (this.mIndexList.size() <= 0) {
            return -1;
        }
        int i = (int) (f / this.mIndexHeight);
        if (i < 0) {
            return 0;
        }
        return i > this.mIndexList.size() + (-1) ? this.mIndexList.size() - 1 : i;
    }

    int getSelectionPosition() {
        return this.mSelectionPosition;
    }

    void setSelectionPosition(int i) {
        this.mSelectionPosition = i;
        invalidate();
    }

    int getFirstRecyclerViewPositionBySelection() {
        String str = this.mIndexList.get(this.mSelectionPosition);
        if (this.mMapping.containsKey(str)) {
            return this.mMapping.get(str).intValue();
        }
        return -1;
    }

    List<String> getIndexList() {
        return this.mIndexList;
    }

    void setDatas(boolean z, ArrayList<EntityWrapper> arrayList) {
        ArrayList arrayList2;
        this.mDatas = arrayList;
        this.mIndexList.clear();
        this.mMapping.clear();
        if (z) {
            this.mIndexList = Arrays.asList(getResources().getStringArray(R.array.indexable_letter));
            this.mIndexList = new ArrayList(this.mIndexList);
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = null;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            EntityWrapper entityWrapper = arrayList.get(i);
            if (entityWrapper.getItemType() == 2147483646 || entityWrapper.getIndexTitle() == null) {
                String index = entityWrapper.getIndex();
                if (!TextUtils.isEmpty(index)) {
                    if (!z) {
                        this.mIndexList.add(index);
                    } else if ("#".equals(index)) {
                        this.mIndexList.add("#");
                    } else if (this.mIndexList.indexOf(index) < 0) {
                        if (entityWrapper.getHeaderFooterType() == 1 && arrayList2.indexOf(index) < 0) {
                            arrayList2.add(index);
                        } else if (entityWrapper.getHeaderFooterType() == 2) {
                            this.mIndexList.add(index);
                        }
                    }
                    if (!this.mMapping.containsKey(index)) {
                        this.mMapping.put(index, Integer.valueOf(i));
                    }
                }
            }
        }
        if (z) {
            this.mIndexList.addAll(0, arrayList2);
        }
        requestLayout();
    }

    void setSelection(int i) {
        ArrayList<EntityWrapper> arrayList = this.mDatas;
        if (arrayList == null || arrayList.size() <= i || i < 0) {
            return;
        }
        int indexOf = this.mIndexList.indexOf(this.mDatas.get(i).getIndex());
        if (this.mSelectionPosition == indexOf || indexOf < 0) {
            return;
        }
        this.mSelectionPosition = indexOf;
        invalidate();
    }
}
