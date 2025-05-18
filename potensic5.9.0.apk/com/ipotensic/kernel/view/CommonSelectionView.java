package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.C1965R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CommonSelectionView extends RelativeLayout {
    private List<Integer> iconList;
    private List<Integer> iconListSelect;
    private View lastSelectedView;
    private OnItemCheckedChangeListener listener;
    private RadioGroup radioGroup;
    private boolean singleSelection;
    private int size;

    public interface OnItemCheckedChangeListener {
        void changed(int i, View view);
    }

    public CommonSelectionView(Context context) {
        this(context, null);
    }

    public CommonSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonSelectionView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CommonSelectionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1965R.styleable.CommonSelectionView);
        this.singleSelection = obtainStyledAttributes.getBoolean(C1965R.styleable.CommonSelectionView_singleSelection, true);
        String string = obtainStyledAttributes.getString(C1965R.styleable.CommonSelectionView_childText1);
        String string2 = obtainStyledAttributes.getString(C1965R.styleable.CommonSelectionView_childText2);
        String string3 = obtainStyledAttributes.getString(C1965R.styleable.CommonSelectionView_childText3);
        String string4 = obtainStyledAttributes.getString(C1965R.styleable.CommonSelectionView_childText4);
        String string5 = obtainStyledAttributes.getString(C1965R.styleable.CommonSelectionView_childText5);
        String string6 = obtainStyledAttributes.getString(C1965R.styleable.CommonSelectionView_childText6);
        ArrayList arrayList = new ArrayList();
        filterEmptyString(arrayList, string, string2, string3, string4, string5, string6);
        if (arrayList.size() > 0) {
            setItems(arrayList);
        }
        obtainStyledAttributes.recycle();
    }

    private void filterEmptyString(List<String> list, String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                list.add(str);
            }
        }
    }

    private void init(Context context) {
        this.radioGroup = (RadioGroup) View.inflate(context, C1965R.layout.view_common_selection_view, this).findViewById(C1965R.id.f2126rg);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = this.radioGroup.getChildCount();
        this.radioGroup.setAlpha(z ? 1.0f : 0.5f);
        for (int i = 0; i < childCount; i++) {
            View childAt = this.radioGroup.getChildAt(i);
            childAt.setEnabled(z);
            setClickable(z);
            setFocusable(z);
            childAt.setAlpha(z ? 1.0f : 0.5f);
        }
    }

    public void setListener(OnItemCheckedChangeListener onItemCheckedChangeListener) {
        this.listener = onItemCheckedChangeListener;
    }

    public void setSingleSelection(boolean z) {
        this.singleSelection = z;
    }

    public void setItems(List<String> list) {
        this.radioGroup.removeAllViews();
        if (list != null) {
            this.size = list.size();
            for (int i = 0; i < this.size; i++) {
                addTextView(i, list.get(i), 0);
                if (i != list.size() - 1) {
                    addDividerLine();
                }
            }
        }
    }

    public void setItems(String... strArr) {
        this.radioGroup.removeAllViews();
        this.size = strArr.length;
        int i = 0;
        for (String str : strArr) {
            addTextView(i, str, 0);
            if (i != this.size - 1) {
                addDividerLine();
            }
            i++;
        }
    }

    public void setIconItems(List<Integer> list, List<Integer> list2) {
        this.radioGroup.removeAllViews();
        this.iconList = list;
        this.iconListSelect = list2;
        if (list != null) {
            this.size = list.size();
            for (int i = 0; i < this.size; i++) {
                addTextView(i, null, list.get(i).intValue());
                if (i != list.size() - 1) {
                    addDividerLine();
                }
            }
        }
    }

    public void setIconItems(int... iArr) {
        this.radioGroup.removeAllViews();
        this.size = iArr.length / 2;
        this.iconList = new ArrayList();
        this.iconListSelect = new ArrayList();
        int i = 0;
        for (int i2 : iArr) {
            if (i < this.size) {
                this.iconList.add(Integer.valueOf(i2));
                addTextView(i, null, i2);
                if (i != this.size - 1) {
                    addDividerLine();
                }
            } else {
                this.iconListSelect.add(Integer.valueOf(i2));
            }
            i++;
        }
    }

    private void addTextView(final int i, String str, int i2) {
        DrawableTextView drawableTextView = new DrawableTextView(getContext());
        drawableTextView.setId(View.generateViewId());
        drawableTextView.setTextColor(ContextCompat.getColor(getContext(), C1965R.color.white));
        drawableTextView.setTextSize(13.0f);
        drawableTextView.setGravity(17);
        drawableTextView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.-$$Lambda$CommonSelectionView$zgrzVSX1KN15kRMF4uL5kyHCSfY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonSelectionView.this.lambda$addTextView$0$CommonSelectionView(i, view);
            }
        });
        this.radioGroup.addView(drawableTextView);
        RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) drawableTextView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = 0;
        layoutParams.weight = 1.0f;
        drawableTextView.setTag(Integer.valueOf(i));
        drawableTextView.setText(str);
        if (i2 > 0) {
            drawableTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, 0, 0, 0);
        }
        drawableTextView.setLayoutParams(layoutParams);
    }

    public /* synthetic */ void lambda$addTextView$0$CommonSelectionView(int i, View view) {
        OnItemCheckedChangeListener onItemCheckedChangeListener = this.listener;
        if (onItemCheckedChangeListener != null) {
            if (this.singleSelection) {
                if (view != this.lastSelectedView) {
                    onItemCheckedChangeListener.changed(i, view);
                    return;
                }
                return;
            }
            onItemCheckedChangeListener.changed(i, view);
        }
    }

    private void addDividerLine() {
        View view = new View(getContext());
        view.setBackgroundColor(ContextCompat.getColor(getContext(), C1965R.color.color_gray));
        this.radioGroup.addView(view);
        RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) view.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = UnitUtil.dip2px(1.0f);
        view.setLayoutParams(layoutParams);
    }

    public void checked(int i) {
        for (int i2 = 0; i2 < this.radioGroup.getChildCount(); i2++) {
            View childAt = this.radioGroup.getChildAt(i2);
            if ((childAt instanceof TextView) && ((Integer) childAt.getTag()).intValue() == i) {
                if (this.singleSelection) {
                    setCheckChildBg(childAt, i);
                    View view = this.lastSelectedView;
                    if (view != null && view != childAt) {
                        view.setBackground(null);
                        setDrawView((TextView) this.lastSelectedView, false, i);
                    }
                    TextView textView = (TextView) childAt;
                    this.lastSelectedView = textView;
                    setDrawView(textView, true, i);
                } else if (childAt.isSelected()) {
                    childAt.setSelected(false);
                    childAt.setBackground(null);
                    setDrawView((TextView) childAt, false, i);
                } else {
                    childAt.setSelected(true);
                    setCheckChildBg(childAt, i);
                    setDrawView((TextView) childAt, true, i);
                }
            }
        }
    }

    public void setCheckState(int i, boolean z) {
        for (int i2 = 0; i2 < this.radioGroup.getChildCount(); i2++) {
            View childAt = this.radioGroup.getChildAt(i2);
            if ((childAt instanceof TextView) && ((Integer) childAt.getTag()).intValue() == i) {
                if (z) {
                    childAt.setSelected(true);
                    setCheckChildBg(childAt, i);
                    setDrawView((TextView) childAt, true, i);
                } else {
                    childAt.setSelected(false);
                    childAt.setBackground(null);
                    setDrawView((TextView) childAt, false, i);
                }
            }
        }
    }

    private void setCheckChildBg(View view, int i) {
        if (i == 0) {
            view.setBackground(ContextCompat.getDrawable(getContext(), C1965R.drawable.bg_flight_setting_check_select_left));
        } else if (i == this.size - 1) {
            view.setBackground(ContextCompat.getDrawable(getContext(), C1965R.drawable.bg_flight_setting_check_select_right));
        } else {
            view.setBackgroundColor(ContextCompat.getColor(getContext(), C1965R.color.colorSettingSelectBg));
        }
    }

    private void setDrawView(TextView textView, boolean z, int i) {
        List<Integer> list;
        List<Integer> list2 = this.iconListSelect;
        if (list2 == null || list2.size() <= 0 || (list = this.iconList) == null || list.size() <= 0) {
            return;
        }
        if (z) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(this.iconListSelect.get(i).intValue(), 0, 0, 0);
        } else {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(this.iconList.get(i).intValue(), 0, 0, 0);
        }
    }
}