package com.ipotensic.kernel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.C1965R;
import com.logan.camera.data.CameraSetBean;
import com.logan.camera.data.CameraSupport;
import java.util.List;

/* loaded from: classes2.dex */
public class ImageGridViewAdapter extends BaseAdapter {
    private Context context;
    private OnItemClickedListener itemClickedListener;
    private LayoutInflater layoutInflater;
    private AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-2, -2);
    private List<CameraSetBean> list;
    private CameraSupport.SupportType supportType;

    public interface OnItemClickedListener {
        void onItemClicked(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public ImageGridViewAdapter(Context context, CameraSupport.SupportType supportType, List<CameraSetBean> list) {
        this.list = list;
        this.context = context;
        this.supportType = supportType;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CameraSetBean> list = this.list;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.list.size());
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View inflate;
        TextView textView;
        if (this.supportType == CameraSupport.SupportType.TYPE_PHOTO_SIZE || this.supportType == CameraSupport.SupportType.TYPE_SPLIT_VIDEO) {
            inflate = this.layoutInflater.inflate(C1965R.layout.view_layout_size_item1, (ViewGroup) null);
            textView = (TextView) inflate.findViewById(C1965R.id.txt);
            textView.setTypeface(PhoneConfig.sourceHanSansCN);
        } else {
            inflate = this.layoutInflater.inflate(C1965R.layout.view_layout_size_item2, (ViewGroup) null);
            textView = (TextView) inflate.findViewById(C1965R.id.txt);
            textView.setTypeface(PhoneConfig.typeface);
        }
        final CameraSetBean cameraSetBean = this.list.get(i);
        textView.setText("" + cameraSetBean.getShowString());
        inflate.setLayoutParams(this.layoutParams);
        inflate.findViewById(C1965R.id.iv_bg_select).setVisibility(cameraSetBean.isSelect() ? 0 : 4);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.adapter.ImageGridViewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (cameraSetBean.isSelect()) {
                    return;
                }
                ImageGridViewAdapter.this.setSelectUI(i);
                if (ImageGridViewAdapter.this.itemClickedListener != null) {
                    ImageGridViewAdapter.this.itemClickedListener.onItemClicked(i);
                }
            }
        });
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectUI(int i) {
        List<CameraSetBean> list = this.list;
        if (list == null || i > list.size() - 1) {
            return;
        }
        int i2 = 0;
        while (i2 < this.list.size()) {
            this.list.get(i2).setSelect(i == i2);
            i2++;
        }
        setCurIndex(this.list);
    }

    public void setCurIndex(List<CameraSetBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.itemClickedListener = onItemClickedListener;
    }
}