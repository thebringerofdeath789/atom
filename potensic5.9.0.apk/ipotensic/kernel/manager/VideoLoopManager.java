package com.ipotensic.kernel.manager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.kernel.view.VideoItemView;
import com.logan.camera.RemoteFile;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class VideoLoopManager {
    private static volatile VideoLoopManager instance;
    private BaseActivity activity;
    private CyclePagerAdapter adapter;
    private int curIndex = 0;
    private OnPageLoopListener pageLoopListener;
    private List<Serializable> videoList;
    private LooperViewPager viewPager;

    public interface OnPageLoopListener {
        void onClickPlay(Serializable serializable);

        void onPageChanged(int i, int i2);

        void onScreenFull();
    }

    private VideoLoopManager() {
    }

    public static VideoLoopManager get() {
        if (instance == null) {
            synchronized (VideoLoopManager.class) {
                if (instance == null) {
                    VideoLoopManager videoLoopManager = new VideoLoopManager();
                    instance = videoLoopManager;
                    return videoLoopManager;
                }
            }
        }
        return instance;
    }

    public void init(BaseActivity baseActivity, LooperViewPager looperViewPager, List<Serializable> list, int i, OnPageLoopListener onPageLoopListener) {
        this.activity = baseActivity;
        this.viewPager = looperViewPager;
        this.videoList = list;
        this.curIndex = i;
        this.pageLoopListener = onPageLoopListener;
        initPager();
    }

    private void initPager() {
        CyclePagerAdapter cyclePagerAdapter = new CyclePagerAdapter(this.activity);
        this.adapter = cyclePagerAdapter;
        this.viewPager.setAdapter(cyclePagerAdapter);
        this.viewPager.setCurrentItem(this.curIndex);
        this.viewPager.setCanTouch(this.videoList.size() > 1);
        OnPageLoopListener onPageLoopListener = this.pageLoopListener;
        if (onPageLoopListener != null) {
            onPageLoopListener.onPageChanged(this.curIndex, this.videoList.size());
        }
        this.viewPager.setOnPageChangeListener(new LooperViewPager.OnPageChangeListener() { // from class: com.ipotensic.kernel.manager.VideoLoopManager.1
            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                DDLog.e("\u5f53\u524d\u9875\u97620\uff1a" + i);
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DDLog.e("\u5f53\u524d\u9875\u97621\uff1a" + i);
                VideoLoopManager.this.curIndex = i;
                if (VideoLoopManager.this.pageLoopListener != null) {
                    VideoLoopManager.this.pageLoopListener.onPageChanged(VideoLoopManager.this.curIndex, VideoLoopManager.this.videoList.size());
                }
            }
        });
    }

    private class CyclePagerAdapter extends PagerAdapter {
        private Context context;
        private int mChildCount;
        private LinkedList<View> mViewCache;
        private View.OnClickListener videoClickListener;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private CyclePagerAdapter(BaseActivity baseActivity) {
            this.videoClickListener = new View.OnClickListener() { // from class: com.ipotensic.kernel.manager.VideoLoopManager.CyclePagerAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (VideoLoopManager.this.pageLoopListener != null) {
                        VideoLoopManager.this.pageLoopListener.onScreenFull();
                    }
                }
            };
            this.mViewCache = new LinkedList<>();
            this.context = baseActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.mChildCount = getCount();
            super.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            VideoLoopManager.this.viewPager.setCanTouch(VideoLoopManager.this.videoList.size() > 1);
            return VideoLoopManager.this.videoList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int i = this.mChildCount;
            if (i > 0) {
                this.mChildCount = i - 1;
                return -2;
            }
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View removeFirst;
            if (this.mViewCache.size() == 0) {
                removeFirst = new VideoItemView(this.context);
            } else {
                removeFirst = this.mViewCache.removeFirst();
            }
            try {
                VideoItemView videoItemView = (VideoItemView) removeFirst;
                final Serializable serializable = (Serializable) VideoLoopManager.this.videoList.get(i);
                videoItemView.setOnClickListener(this.videoClickListener);
                videoItemView.imgPlay.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.manager.VideoLoopManager.CyclePagerAdapter.1
                    @Override // com.ipotensic.baselib.listener.ScaleClickListener
                    public void click(View view) {
                        if (VideoLoopManager.this.pageLoopListener != null) {
                            VideoLoopManager.this.pageLoopListener.onClickPlay(serializable);
                        }
                    }
                });
                if (serializable instanceof RemoteFile) {
                    if (((RemoteFile) serializable).getThumbnailUrl() != null) {
                        DDLog.w("\u7f29\u7565\u56fe\u5730\u57400:" + ((RemoteFile) serializable).getThumbnailUrl());
                        Glide.with(this.context).load(((RemoteFile) serializable).getThumbnailUrl()).into(videoItemView.imgThumbnail);
                    }
                } else if (serializable instanceof LocalFile) {
                    DDLog.w("\u7f29\u7565\u56fe\u5730\u57401:" + ((LocalFile) serializable).getAbsPath());
                    Glide.with(this.context).load(((LocalFile) serializable).getAbsPath()).into(videoItemView.imgThumbnail);
                }
            } catch (Exception unused) {
            }
            viewGroup.addView(removeFirst);
            return removeFirst;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof View) {
                View view = (View) obj;
                viewGroup.removeView(view);
                this.mViewCache.add(view);
            }
        }
    }

    public void release() {
        instance = null;
    }
}