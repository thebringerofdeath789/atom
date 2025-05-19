package me.yokeyword.indexablerv;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import me.yokeyword.indexablerecyclerview.R;
import me.yokeyword.indexablerv.database.DataObserver;
import me.yokeyword.indexablerv.database.HeaderFooterDataObserver;
import me.yokeyword.indexablerv.database.IndexBarDataObserver;

/* loaded from: classes4.dex */
public class IndexableLayout extends FrameLayout {
    static final String INDEX_SIGN = "#";
    public static final int MODE_ALL_LETTERS = 1;
    public static final int MODE_FAST = 0;
    public static final int MODE_NONE = 2;
    private static int PADDING_RIGHT_OVERLAY;
    private Drawable mBarBg;
    private int mBarFocusTextColor;
    private int mBarTextColor;
    private float mBarTextSize;
    private float mBarTextSpace;
    private float mBarWidth;
    private TextView mCenterOverlay;
    private Comparator mComparator;
    private int mCompareMode;
    private Context mContext;
    private DataObserver mDataSetObserver;
    private ExecutorService mExecutorService;
    private Future mFuture;
    private Handler mHandler;
    private HeaderFooterDataObserver<EntityWrapper> mHeaderFooterDataSetObserver;
    private IndexBar mIndexBar;
    private IndexBarDataObserver mIndexBarDataSetObserver;
    private IndexableAdapter mIndexableAdapter;
    private View mLastInvisibleRecyclerViewItemView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView mMDOverlay;
    private RealAdapter mRealAdapter;
    private RecyclerView mRecy;
    private boolean mShowAllLetter;
    private String mStickyTitle;
    private RecyclerView.ViewHolder mStickyViewHolder;
    private boolean mSticyEnable;

    @Retention(RetentionPolicy.SOURCE)
    @interface CompareMode {
    }

    public IndexableLayout(Context context) {
        this(context, null);
    }

    public IndexableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndexableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShowAllLetter = true;
        this.mSticyEnable = true;
        this.mCompareMode = 0;
        this.mHeaderFooterDataSetObserver = new HeaderFooterDataObserver<EntityWrapper>() { // from class: me.yokeyword.indexablerv.IndexableLayout.1
            @Override // me.yokeyword.indexablerv.database.HeaderFooterDataObserver
            public void onChanged() {
                if (IndexableLayout.this.mRealAdapter == null) {
                    return;
                }
                IndexableLayout.this.mRealAdapter.notifyDataSetChanged();
            }

            @Override // me.yokeyword.indexablerv.database.HeaderFooterDataObserver
            public void onAdd(boolean z, EntityWrapper entityWrapper, EntityWrapper entityWrapper2) {
                if (IndexableLayout.this.mRealAdapter == null) {
                    return;
                }
                IndexableLayout.this.mRealAdapter.addHeaderFooterData(z, entityWrapper, entityWrapper2);
            }

            @Override // me.yokeyword.indexablerv.database.HeaderFooterDataObserver
            public void onRemove(boolean z, EntityWrapper entityWrapper) {
                if (IndexableLayout.this.mRealAdapter == null) {
                    return;
                }
                IndexableLayout.this.mRealAdapter.removeHeaderFooterData(z, entityWrapper);
            }
        };
        this.mIndexBarDataSetObserver = new IndexBarDataObserver() { // from class: me.yokeyword.indexablerv.IndexableLayout.2
            @Override // me.yokeyword.indexablerv.database.IndexBarDataObserver
            public void onChanged() {
                IndexableLayout.this.mIndexBar.setDatas(IndexableLayout.this.mShowAllLetter, IndexableLayout.this.mRealAdapter.getItems());
            }
        };
        init(context, attributeSet);
    }

    public <T extends IndexableEntity> void setAdapter(final IndexableAdapter<T> indexableAdapter) {
        Objects.requireNonNull(this.mLayoutManager, "You must set the LayoutManager first");
        this.mIndexableAdapter = indexableAdapter;
        DataObserver dataObserver = this.mDataSetObserver;
        if (dataObserver != null) {
            indexableAdapter.unregisterDataSetObserver(dataObserver);
        }
        DataObserver dataObserver2 = new DataObserver() { // from class: me.yokeyword.indexablerv.IndexableLayout.3
            @Override // me.yokeyword.indexablerv.database.DataObserver
            public void onInited() {
                onSetListener(0);
                IndexableLayout.this.onDataChanged();
            }

            @Override // me.yokeyword.indexablerv.database.DataObserver
            public void onChanged() {
                if (IndexableLayout.this.mRealAdapter != null) {
                    IndexableLayout.this.mRealAdapter.notifyDataSetChanged();
                }
            }

            @Override // me.yokeyword.indexablerv.database.DataObserver
            public void onSetListener(int i) {
                if ((i == 1 || i == 0) && indexableAdapter.getOnItemTitleClickListener() != null) {
                    IndexableLayout.this.mRealAdapter.setOnItemTitleClickListener(indexableAdapter.getOnItemTitleClickListener());
                }
                if ((i == 3 || i == 0) && indexableAdapter.getOnItemTitleLongClickListener() != null) {
                    IndexableLayout.this.mRealAdapter.setOnItemTitleLongClickListener(indexableAdapter.getOnItemTitleLongClickListener());
                }
                if ((i == 2 || i == 0) && indexableAdapter.getOnItemContentClickListener() != null) {
                    IndexableLayout.this.mRealAdapter.setOnItemContentClickListener(indexableAdapter.getOnItemContentClickListener());
                }
                if ((i == 4 || i == 0) && indexableAdapter.getOnItemContentLongClickListener() != null) {
                    IndexableLayout.this.mRealAdapter.setOnItemContentLongClickListener(indexableAdapter.getOnItemContentLongClickListener());
                }
            }
        };
        this.mDataSetObserver = dataObserver2;
        indexableAdapter.registerDataSetObserver(dataObserver2);
        this.mRealAdapter.setIndexableAdapter(indexableAdapter);
        if (this.mSticyEnable) {
            initStickyView(indexableAdapter);
        }
    }

    public <T> void addHeaderAdapter(IndexableHeaderAdapter<T> indexableHeaderAdapter) {
        indexableHeaderAdapter.registerDataSetObserver(this.mHeaderFooterDataSetObserver);
        indexableHeaderAdapter.registerIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
        this.mRealAdapter.addIndexableHeaderAdapter(indexableHeaderAdapter);
    }

    public <T> void removeHeaderAdapter(IndexableHeaderAdapter<T> indexableHeaderAdapter) {
        try {
            indexableHeaderAdapter.unregisterDataSetObserver(this.mHeaderFooterDataSetObserver);
            indexableHeaderAdapter.unregisterIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
            this.mRealAdapter.removeIndexableHeaderAdapter(indexableHeaderAdapter);
        } catch (Exception unused) {
        }
    }

    public <T> void addFooterAdapter(IndexableFooterAdapter<T> indexableFooterAdapter) {
        indexableFooterAdapter.registerDataSetObserver(this.mHeaderFooterDataSetObserver);
        indexableFooterAdapter.registerIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
        this.mRealAdapter.addIndexableFooterAdapter(indexableFooterAdapter);
    }

    public <T> void removeFooterAdapter(IndexableFooterAdapter<T> indexableFooterAdapter) {
        try {
            indexableFooterAdapter.unregisterDataSetObserver(this.mHeaderFooterDataSetObserver);
            indexableFooterAdapter.unregisterIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
            this.mRealAdapter.removeIndexableFooterAdapter(indexableFooterAdapter);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public void setFastCompare(boolean z) {
        setCompareMode(!z ? 1 : 0);
    }

    public void setCompareMode(int i) {
        this.mCompareMode = i;
    }

    public <T extends IndexableEntity> void setComparator(Comparator<EntityWrapper<T>> comparator) {
        this.mComparator = comparator;
    }

    public void setStickyEnable(boolean z) {
        this.mSticyEnable = z;
    }

    public void showAllLetter(boolean z) {
        this.mShowAllLetter = z;
    }

    public void setOverlayStyle_MaterialDesign(int i) {
        TextView textView = this.mMDOverlay;
        if (textView == null) {
            initMDOverlay(i);
        } else {
            ViewCompat.setBackgroundTintList(textView, ColorStateList.valueOf(i));
        }
        this.mCenterOverlay = null;
    }

    public void setOverlayStyle_Center() {
        if (this.mCenterOverlay == null) {
            initCenterOverlay();
        }
        this.mMDOverlay = null;
    }

    public TextView getOverlayView() {
        TextView textView = this.mMDOverlay;
        return textView != null ? textView : this.mCenterOverlay;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecy;
    }

    public void setIndexBarVisibility(boolean z) {
        this.mIndexBar.setVisibility(z ? 0 : 8);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        this.mExecutorService = Executors.newSingleThreadExecutor();
        PADDING_RIGHT_OVERLAY = (int) TypedValue.applyDimension(1, 80.0f, getResources().getDisplayMetrics());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndexableRecyclerView);
            this.mBarTextColor = obtainStyledAttributes.getColor(R.styleable.IndexableRecyclerView_indexBar_textColor, ContextCompat.getColor(context, R.color.default_indexBar_textColor));
            this.mBarTextSize = obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_textSize, getResources().getDimension(R.dimen.default_indexBar_textSize));
            this.mBarFocusTextColor = obtainStyledAttributes.getColor(R.styleable.IndexableRecyclerView_indexBar_selectedTextColor, ContextCompat.getColor(context, R.color.default_indexBar_selectedTextColor));
            this.mBarTextSpace = obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_textSpace, getResources().getDimension(R.dimen.default_indexBar_textSpace));
            this.mBarBg = obtainStyledAttributes.getDrawable(R.styleable.IndexableRecyclerView_indexBar_background);
            this.mBarWidth = obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_layout_width, getResources().getDimension(R.dimen.default_indexBar_layout_width));
            obtainStyledAttributes.recycle();
        }
        Context context2 = this.mContext;
        if (context2 instanceof Activity) {
            ((Activity) context2).getWindow().setSoftInputMode(32);
        }
        RecyclerView recyclerView = new RecyclerView(context);
        this.mRecy = recyclerView;
        recyclerView.setVerticalScrollBarEnabled(false);
        this.mRecy.setOverScrollMode(2);
        addView(this.mRecy, new FrameLayout.LayoutParams(-1, -1));
        IndexBar indexBar = new IndexBar(context);
        this.mIndexBar = indexBar;
        indexBar.init(this.mBarBg, this.mBarTextColor, this.mBarFocusTextColor, this.mBarTextSize, this.mBarTextSpace);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mBarWidth, -2);
        layoutParams.gravity = 8388629;
        addView(this.mIndexBar, layoutParams);
        this.mRealAdapter = new RealAdapter();
        this.mRecy.setHasFixedSize(true);
        this.mRecy.setAdapter(this.mRealAdapter);
        initListener();
    }

    public void setLayoutManager(LinearLayoutManager linearLayoutManager) {
        Objects.requireNonNull(linearLayoutManager, "LayoutManager == null");
        this.mLayoutManager = linearLayoutManager;
        if (linearLayoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) linearLayoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: me.yokeyword.indexablerv.IndexableLayout.4
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    if (IndexableLayout.this.mRealAdapter.getItemViewType(i) == 2147483646) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return IndexableLayout.this.mRealAdapter.getItemViewType(i) == Integer.MAX_VALUE ? 1 : 0;
                }
            });
        }
        this.mRecy.setLayoutManager(this.mLayoutManager);
    }

    private void initListener() {
        this.mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: me.yokeyword.indexablerv.IndexableLayout.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                IndexableLayout.this.processScrollListener();
            }
        });
        this.mIndexBar.setOnTouchListener(new View.OnTouchListener() { // from class: me.yokeyword.indexablerv.IndexableLayout.6
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
            
                if (r2 != 3) goto L28;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
                /*
                    r4 = this;
                    me.yokeyword.indexablerv.IndexableLayout r5 = me.yokeyword.indexablerv.IndexableLayout.this
                    me.yokeyword.indexablerv.IndexBar r5 = me.yokeyword.indexablerv.IndexableLayout.access$200(r5)
                    float r0 = r6.getY()
                    int r5 = r5.getPositionForPointY(r0)
                    r0 = 1
                    if (r5 >= 0) goto L12
                    return r0
                L12:
                    me.yokeyword.indexablerv.IndexableLayout r1 = me.yokeyword.indexablerv.IndexableLayout.this
                    androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = me.yokeyword.indexablerv.IndexableLayout.access$400(r1)
                    boolean r1 = r1 instanceof androidx.recyclerview.widget.LinearLayoutManager
                    if (r1 != 0) goto L1d
                    return r0
                L1d:
                    me.yokeyword.indexablerv.IndexableLayout r1 = me.yokeyword.indexablerv.IndexableLayout.this
                    androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = me.yokeyword.indexablerv.IndexableLayout.access$400(r1)
                    androidx.recyclerview.widget.LinearLayoutManager r1 = (androidx.recyclerview.widget.LinearLayoutManager) r1
                    int r2 = r6.getAction()
                    if (r2 == 0) goto L59
                    if (r2 == r0) goto L34
                    r3 = 2
                    if (r2 == r3) goto L59
                    r5 = 3
                    if (r2 == r5) goto L34
                    goto L8b
                L34:
                    me.yokeyword.indexablerv.IndexableLayout r5 = me.yokeyword.indexablerv.IndexableLayout.this
                    android.widget.TextView r5 = me.yokeyword.indexablerv.IndexableLayout.access$600(r5)
                    r6 = 8
                    if (r5 == 0) goto L47
                    me.yokeyword.indexablerv.IndexableLayout r5 = me.yokeyword.indexablerv.IndexableLayout.this
                    android.widget.TextView r5 = me.yokeyword.indexablerv.IndexableLayout.access$600(r5)
                    r5.setVisibility(r6)
                L47:
                    me.yokeyword.indexablerv.IndexableLayout r5 = me.yokeyword.indexablerv.IndexableLayout.this
                    android.widget.TextView r5 = me.yokeyword.indexablerv.IndexableLayout.access$700(r5)
                    if (r5 == 0) goto L8b
                    me.yokeyword.indexablerv.IndexableLayout r5 = me.yokeyword.indexablerv.IndexableLayout.this
                    android.widget.TextView r5 = me.yokeyword.indexablerv.IndexableLayout.access$700(r5)
                    r5.setVisibility(r6)
                    goto L8b
                L59:
                    me.yokeyword.indexablerv.IndexableLayout r2 = me.yokeyword.indexablerv.IndexableLayout.this
                    float r6 = r6.getY()
                    me.yokeyword.indexablerv.IndexableLayout.access$500(r2, r6, r5)
                    me.yokeyword.indexablerv.IndexableLayout r6 = me.yokeyword.indexablerv.IndexableLayout.this
                    me.yokeyword.indexablerv.IndexBar r6 = me.yokeyword.indexablerv.IndexableLayout.access$200(r6)
                    int r6 = r6.getSelectionPosition()
                    if (r5 == r6) goto L8b
                    me.yokeyword.indexablerv.IndexableLayout r6 = me.yokeyword.indexablerv.IndexableLayout.this
                    me.yokeyword.indexablerv.IndexBar r6 = me.yokeyword.indexablerv.IndexableLayout.access$200(r6)
                    r6.setSelectionPosition(r5)
                    r6 = 0
                    if (r5 != 0) goto L7e
                    r1.scrollToPositionWithOffset(r6, r6)
                    goto L8b
                L7e:
                    me.yokeyword.indexablerv.IndexableLayout r5 = me.yokeyword.indexablerv.IndexableLayout.this
                    me.yokeyword.indexablerv.IndexBar r5 = me.yokeyword.indexablerv.IndexableLayout.access$200(r5)
                    int r5 = r5.getFirstRecyclerViewPositionBySelection()
                    r1.scrollToPositionWithOffset(r5, r6)
                L8b:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: me.yokeyword.indexablerv.IndexableLayout.AnonymousClass6.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processScrollListener() {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        if ((layoutManager instanceof LinearLayoutManager) && (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) != -1) {
            this.mIndexBar.setSelection(findFirstVisibleItemPosition);
            if (this.mSticyEnable) {
                ArrayList<EntityWrapper> items = this.mRealAdapter.getItems();
                if (this.mStickyViewHolder == null || items.size() <= findFirstVisibleItemPosition) {
                    return;
                }
                EntityWrapper entityWrapper = items.get(findFirstVisibleItemPosition);
                String indexTitle = entityWrapper.getIndexTitle();
                if (2147483646 == entityWrapper.getItemType()) {
                    View view = this.mLastInvisibleRecyclerViewItemView;
                    if (view != null && view.getVisibility() == 4) {
                        this.mLastInvisibleRecyclerViewItemView.setVisibility(0);
                        this.mLastInvisibleRecyclerViewItemView = null;
                    }
                    View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    this.mLastInvisibleRecyclerViewItemView = findViewByPosition;
                    if (findViewByPosition != null) {
                        findViewByPosition.setVisibility(4);
                    }
                }
                if (indexTitle == null && this.mStickyViewHolder.itemView.getVisibility() == 0) {
                    this.mStickyTitle = null;
                    this.mStickyViewHolder.itemView.setVisibility(4);
                } else {
                    stickyNewViewHolder(indexTitle);
                }
                RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
                if (layoutManager2 instanceof GridLayoutManager) {
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager2;
                    if (gridLayoutManager.getSpanCount() + findFirstVisibleItemPosition < items.size()) {
                        for (int i = findFirstVisibleItemPosition + 1; i <= gridLayoutManager.getSpanCount() + findFirstVisibleItemPosition; i++) {
                            processScroll(linearLayoutManager, items, i, indexTitle);
                        }
                        return;
                    }
                    return;
                }
                int i2 = findFirstVisibleItemPosition + 1;
                if (i2 < items.size()) {
                    processScroll(linearLayoutManager, items, i2, indexTitle);
                }
            }
        }
    }

    private void processScroll(LinearLayoutManager linearLayoutManager, ArrayList<EntityWrapper> arrayList, int i, String str) {
        EntityWrapper entityWrapper = arrayList.get(i);
        View findViewByPosition = linearLayoutManager.findViewByPosition(i);
        if (findViewByPosition == null) {
            return;
        }
        if (entityWrapper.getItemType() != 2147483646) {
            if (this.mStickyViewHolder.itemView.getTranslationY() != 0.0f) {
                this.mStickyViewHolder.itemView.setTranslationY(0.0f);
            }
        } else {
            if (findViewByPosition.getTop() <= this.mStickyViewHolder.itemView.getHeight() && str != null) {
                this.mStickyViewHolder.itemView.setTranslationY(findViewByPosition.getTop() - this.mStickyViewHolder.itemView.getHeight());
            }
            if (4 == findViewByPosition.getVisibility()) {
                findViewByPosition.setVisibility(0);
            }
        }
    }

    private void stickyNewViewHolder(String str) {
        if (str == null || str.equals(this.mStickyTitle)) {
            return;
        }
        if (this.mStickyViewHolder.itemView.getVisibility() != 0) {
            this.mStickyViewHolder.itemView.setVisibility(0);
        }
        this.mStickyTitle = str;
        this.mIndexableAdapter.onBindTitleViewHolder(this.mStickyViewHolder, str);
    }

    private <T extends IndexableEntity> void initStickyView(final IndexableAdapter<T> indexableAdapter) {
        RecyclerView.ViewHolder onCreateTitleViewHolder = indexableAdapter.onCreateTitleViewHolder(this.mRecy);
        this.mStickyViewHolder = onCreateTitleViewHolder;
        onCreateTitleViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: me.yokeyword.indexablerv.IndexableLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (indexableAdapter.getOnItemTitleClickListener() != null) {
                    int firstRecyclerViewPositionBySelection = IndexableLayout.this.mIndexBar.getFirstRecyclerViewPositionBySelection();
                    ArrayList items = IndexableLayout.this.mRealAdapter.getItems();
                    if (items.size() <= firstRecyclerViewPositionBySelection || firstRecyclerViewPositionBySelection < 0) {
                        return;
                    }
                    indexableAdapter.getOnItemTitleClickListener().onItemClick(view, firstRecyclerViewPositionBySelection, ((EntityWrapper) items.get(firstRecyclerViewPositionBySelection)).getIndexTitle());
                }
            }
        });
        this.mStickyViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: me.yokeyword.indexablerv.IndexableLayout.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (indexableAdapter.getOnItemTitleLongClickListener() == null) {
                    return false;
                }
                int firstRecyclerViewPositionBySelection = IndexableLayout.this.mIndexBar.getFirstRecyclerViewPositionBySelection();
                ArrayList items = IndexableLayout.this.mRealAdapter.getItems();
                if (items.size() <= firstRecyclerViewPositionBySelection || firstRecyclerViewPositionBySelection < 0) {
                    return false;
                }
                return indexableAdapter.getOnItemTitleLongClickListener().onItemLongClick(view, firstRecyclerViewPositionBySelection, ((EntityWrapper) items.get(firstRecyclerViewPositionBySelection)).getIndexTitle());
            }
        });
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == this.mRecy) {
                this.mStickyViewHolder.itemView.setVisibility(4);
                addView(this.mStickyViewHolder.itemView, i + 1);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void showOverlayView(float r5, int r6) {
        /*
            r4 = this;
            me.yokeyword.indexablerv.IndexBar r0 = r4.mIndexBar
            java.util.List r0 = r0.getIndexList()
            int r0 = r0.size()
            if (r0 > r6) goto Ld
            return
        Ld:
            android.widget.TextView r0 = r4.mMDOverlay
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La2
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L1e
            android.widget.TextView r0 = r4.mMDOverlay
            r0.setVisibility(r2)
        L1e:
            int r0 = me.yokeyword.indexablerv.IndexableLayout.PADDING_RIGHT_OVERLAY
            me.yokeyword.indexablerv.IndexBar r3 = r4.mIndexBar
            int r3 = r3.getTop()
            int r0 = r0 - r3
            float r0 = (float) r0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r3 = 0
            if (r0 >= 0) goto L3c
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L3c
            int r5 = me.yokeyword.indexablerv.IndexableLayout.PADDING_RIGHT_OVERLAY
            me.yokeyword.indexablerv.IndexBar r0 = r4.mIndexBar
            int r0 = r0.getTop()
            int r5 = r5 - r0
        L3a:
            float r5 = (float) r5
            goto L67
        L3c:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L55
            me.yokeyword.indexablerv.IndexBar r5 = r4.mIndexBar
            int r5 = r5.getTop()
            int r0 = me.yokeyword.indexablerv.IndexableLayout.PADDING_RIGHT_OVERLAY
            if (r5 <= r0) goto L4c
            r5 = r3
            goto L67
        L4c:
            me.yokeyword.indexablerv.IndexBar r5 = r4.mIndexBar
            int r5 = r5.getTop()
            int r0 = r0 - r5
            float r5 = (float) r0
            goto L67
        L55:
            me.yokeyword.indexablerv.IndexBar r0 = r4.mIndexBar
            int r0 = r0.getHeight()
            float r0 = (float) r0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L67
            me.yokeyword.indexablerv.IndexBar r5 = r4.mIndexBar
            int r5 = r5.getHeight()
            goto L3a
        L67:
            android.widget.TextView r0 = r4.mMDOverlay
            me.yokeyword.indexablerv.IndexBar r3 = r4.mIndexBar
            int r3 = r3.getTop()
            float r3 = (float) r3
            float r3 = r3 + r5
            int r5 = me.yokeyword.indexablerv.IndexableLayout.PADDING_RIGHT_OVERLAY
            float r5 = (float) r5
            float r3 = r3 - r5
            r0.setY(r3)
            me.yokeyword.indexablerv.IndexBar r5 = r4.mIndexBar
            java.util.List r5 = r5.getIndexList()
            java.lang.Object r5 = r5.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            android.widget.TextView r0 = r4.mMDOverlay
            java.lang.CharSequence r0 = r0.getText()
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto La2
            int r0 = r5.length()
            if (r0 <= r1) goto L9d
            android.widget.TextView r0 = r4.mMDOverlay
            r3 = 1106247680(0x41f00000, float:30.0)
            r0.setTextSize(r3)
        L9d:
            android.widget.TextView r0 = r4.mMDOverlay
            r0.setText(r5)
        La2:
            android.widget.TextView r5 = r4.mCenterOverlay
            if (r5 == 0) goto Ldb
            int r5 = r5.getVisibility()
            if (r5 == 0) goto Lb1
            android.widget.TextView r5 = r4.mCenterOverlay
            r5.setVisibility(r2)
        Lb1:
            me.yokeyword.indexablerv.IndexBar r5 = r4.mIndexBar
            java.util.List r5 = r5.getIndexList()
            java.lang.Object r5 = r5.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            android.widget.TextView r6 = r4.mCenterOverlay
            java.lang.CharSequence r6 = r6.getText()
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto Ldb
            int r6 = r5.length()
            if (r6 <= r1) goto Ld6
            android.widget.TextView r6 = r4.mCenterOverlay
            r0 = 1107296256(0x42000000, float:32.0)
            r6.setTextSize(r0)
        Ld6:
            android.widget.TextView r6 = r4.mCenterOverlay
            r6.setText(r5)
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.yokeyword.indexablerv.IndexableLayout.showOverlayView(float, int):void");
    }

    private void initCenterOverlay() {
        TextView textView = new TextView(this.mContext);
        this.mCenterOverlay = textView;
        textView.setBackgroundResource(R.drawable.indexable_bg_center_overlay);
        this.mCenterOverlay.setTextColor(-1);
        this.mCenterOverlay.setTextSize(40.0f);
        this.mCenterOverlay.setGravity(17);
        int applyDimension = (int) TypedValue.applyDimension(1, 70.0f, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.gravity = 17;
        this.mCenterOverlay.setLayoutParams(layoutParams);
        this.mCenterOverlay.setVisibility(4);
        addView(this.mCenterOverlay);
    }

    private void initMDOverlay(int i) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(this.mContext);
        this.mMDOverlay = appCompatTextView;
        appCompatTextView.setBackgroundResource(R.drawable.indexable_bg_md_overlay);
        ((AppCompatTextView) this.mMDOverlay).setSupportBackgroundTintList(ColorStateList.valueOf(i));
        this.mMDOverlay.setSingleLine();
        this.mMDOverlay.setTextColor(-1);
        this.mMDOverlay.setTextSize(38.0f);
        this.mMDOverlay.setGravity(17);
        int applyDimension = (int) TypedValue.applyDimension(1, 72.0f, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 33.0f, getResources().getDisplayMetrics());
        layoutParams.gravity = GravityCompat.END;
        this.mMDOverlay.setLayoutParams(layoutParams);
        this.mMDOverlay.setVisibility(4);
        addView(this.mMDOverlay);
    }

    void onDataChanged() {
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
        }
        this.mFuture = this.mExecutorService.submit(new Runnable() { // from class: me.yokeyword.indexablerv.IndexableLayout.9
            @Override // java.lang.Runnable
            public void run() {
                IndexableLayout indexableLayout = IndexableLayout.this;
                final ArrayList transform = indexableLayout.transform(indexableLayout.mIndexableAdapter.getItems());
                if (transform == null) {
                    return;
                }
                IndexableLayout.this.getSafeHandler().post(new Runnable() { // from class: me.yokeyword.indexablerv.IndexableLayout.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IndexableLayout.this.mRealAdapter.setDatas(transform);
                        IndexableLayout.this.mIndexBar.setDatas(IndexableLayout.this.mShowAllLetter, IndexableLayout.this.mRealAdapter.getItems());
                        if (IndexableLayout.this.mIndexableAdapter.getIndexCallback() != null) {
                            IndexableLayout.this.mIndexableAdapter.getIndexCallback().onFinished(transform);
                        }
                        IndexableLayout.this.processScrollListener();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends IndexableEntity> ArrayList<EntityWrapper<T>> transform(List<T> list) {
        List list2;
        try {
            TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: me.yokeyword.indexablerv.IndexableLayout.10
                @Override // java.util.Comparator
                public int compare(String str, String str2) {
                    if (str.equals(IndexableLayout.INDEX_SIGN)) {
                        return !str2.equals(IndexableLayout.INDEX_SIGN) ? 1 : 0;
                    }
                    if (str2.equals(IndexableLayout.INDEX_SIGN)) {
                        return -1;
                    }
                    return str.compareTo(str2);
                }
            });
            for (int i = 0; i < list.size(); i++) {
                EntityWrapper entityWrapper = new EntityWrapper();
                T t = list.get(i);
                String fieldIndexBy = t.getFieldIndexBy();
                String pingYin = PinyinUtil.getPingYin(fieldIndexBy);
                entityWrapper.setPinyin(pingYin);
                if (PinyinUtil.matchingLetter(pingYin)) {
                    entityWrapper.setIndex(pingYin.substring(0, 1).toUpperCase());
                    entityWrapper.setIndexByField(t.getFieldIndexBy());
                } else if (PinyinUtil.matchingPolyphone(pingYin)) {
                    entityWrapper.setIndex(PinyinUtil.gePolyphoneInitial(pingYin).toUpperCase());
                    entityWrapper.setPinyin(PinyinUtil.getPolyphoneRealPinyin(pingYin));
                    String polyphoneRealHanzi = PinyinUtil.getPolyphoneRealHanzi(fieldIndexBy);
                    entityWrapper.setIndexByField(polyphoneRealHanzi);
                    t.setFieldIndexBy(polyphoneRealHanzi);
                } else {
                    entityWrapper.setIndex(INDEX_SIGN);
                    entityWrapper.setIndexByField(t.getFieldIndexBy());
                }
                entityWrapper.setIndexTitle(entityWrapper.getIndex());
                entityWrapper.setData(t);
                entityWrapper.setOriginalPosition(i);
                t.setFieldPinyinIndexBy(entityWrapper.getPinyin());
                String index = entityWrapper.getIndex();
                if (!treeMap.containsKey(index)) {
                    list2 = new ArrayList();
                    list2.add(new EntityWrapper(entityWrapper.getIndex(), 2147483646));
                    treeMap.put(index, list2);
                } else {
                    list2 = (List) treeMap.get(index);
                }
                list2.add(entityWrapper);
            }
            ArrayList<EntityWrapper<T>> arrayList = new ArrayList<>();
            for (List list3 : treeMap.values()) {
                Comparator comparator = this.mComparator;
                if (comparator != null) {
                    Collections.sort(list3, comparator);
                } else {
                    int i2 = this.mCompareMode;
                    if (i2 == 0) {
                        Collections.sort(list3, new InitialComparator());
                    } else if (i2 == 1) {
                        Collections.sort(list3, new PinyinComparator());
                    }
                }
                arrayList.addAll(list3);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getSafeHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }
}
