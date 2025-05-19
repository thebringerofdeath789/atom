package me.yokeyword.indexablerv;

import java.util.List;
import me.yokeyword.indexablerv.AbstractHeaderFooterAdapter;

/* loaded from: classes4.dex */
public abstract class IndexableFooterAdapter<T> extends AbstractHeaderFooterAdapter<T> {

    public interface OnItemFooterClickListener<T> extends AbstractHeaderFooterAdapter.OnItemClickListener<T> {
    }

    public interface OnItemFooterLongClickListener<T> extends AbstractHeaderFooterAdapter.OnItemLongClickListener<T> {
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    int getHeaderFooterType() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public /* bridge */ /* synthetic */ void addData(int i, Object obj) {
        super.addData(i, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public /* bridge */ /* synthetic */ void addData(Object obj) {
        super.addData(obj);
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public /* bridge */ /* synthetic */ void addDatas(int i, List list) {
        super.addDatas(i, list);
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public /* bridge */ /* synthetic */ void addDatas(List list) {
        super.addDatas(list);
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public /* bridge */ /* synthetic */ void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public /* bridge */ /* synthetic */ void removeData(Object obj) {
        super.removeData(obj);
    }

    public IndexableFooterAdapter(String str, String str2, List<T> list) {
        super(str, str2, list);
    }

    public void setOnItemFooterClickListener(OnItemFooterClickListener<T> onItemFooterClickListener) {
        this.mListener = onItemFooterClickListener;
    }

    public void setOnItemFooterLongClickListener(OnItemFooterLongClickListener<T> onItemFooterLongClickListener) {
        this.mLongListener = onItemFooterLongClickListener;
    }
}
