package com.ipotensic.potensicpro.activities;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LoadingDialog;
import com.ipotensic.baselib.bean.AlbumItem;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.mediadataretriever.MediaRetriever;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.okhttp.PicassoLoader;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.view.photoview.PhotoView;
import com.ipotensic.potensicpro.R;
import java.util.ArrayList;
import xyz.doikki.videocontroller.StandardVideoController;
import xyz.doikki.videocontroller.component.CompleteView;
import xyz.doikki.videocontroller.component.GestureView;
import xyz.doikki.videocontroller.component.PrepareView;
import xyz.doikki.videocontroller.component.VodControlView;
import xyz.doikki.videoplayer.exo.ExoMediaPlayer;
import xyz.doikki.videoplayer.exo.ExoMediaPlayerFactory;
import xyz.doikki.videoplayer.exo.ExoMediaSourceHelper;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public class FeedbackPreviewController extends BaseController {
    private int curPosition;
    private LoopPagerAdapter cycleAdapter;
    private ExitModeListener listener;
    private LoadingDialog loadingDialog;
    private LooperViewPager looperViewPager;
    private ArrayList<AlbumItem> sources;
    private VideoView<ExoMediaPlayer> videoPlayer;

    public interface ExitModeListener {
        void exitMode();
    }

    public FeedbackPreviewController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.sources = new ArrayList<>();
        this.curPosition = -1;
        this.loadingDialog = new LoadingDialog(appCompatActivity);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.looperViewPager = (LooperViewPager) getBaseView().findViewById(R.id.loop_viewpager);
        this.videoPlayer = (VideoView) getBaseView().findViewById(R.id.player);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackPreviewController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedbackPreviewController.this.setVisibility(8);
            }
        });
    }

    public void showSources(int i, ArrayList<AlbumItem> arrayList) {
        this.sources = arrayList;
        this.curPosition = i;
        LooperViewPager looperViewPager = this.looperViewPager;
        LoopPagerAdapter loopPagerAdapter = new LoopPagerAdapter();
        this.cycleAdapter = loopPagerAdapter;
        looperViewPager.setAdapter(loopPagerAdapter);
        this.looperViewPager.setOnPageChangeListener(new LooperViewPager.OnPageChangeListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackPreviewController.2
            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // com.ipotensic.baselib.views.LooperViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                DDLog.i("curPosition :" + FeedbackPreviewController.this.curPosition);
                DDLog.i("position :" + i2);
                FeedbackPreviewController.this.curPosition = i2;
            }
        });
        this.looperViewPager.setCurrentItem(this.curPosition);
        this.looperViewPager.setCanTouch(arrayList.size() != 1);
        setVisibility(0);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8) {
            release();
        }
    }

    private void release() {
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog != null && loadingDialog.isShowing()) {
            this.loadingDialog.dismiss();
        }
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FeedbackPreviewController.3
            @Override // java.lang.Runnable
            public void run() {
                OkHttpUtil.getInstance().cancelDownload();
            }
        }).start();
        ArrayList<AlbumItem> arrayList = this.sources;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.sources = new ArrayList<>();
        LoopPagerAdapter loopPagerAdapter = this.cycleAdapter;
        if (loopPagerAdapter != null) {
            loopPagerAdapter.notifyDataSetChanged();
            this.cycleAdapter = null;
        }
        stopPlay();
    }

    private class LoopPagerAdapter extends PagerAdapter {
        private int mChildCount;
        private View.OnClickListener photoClickListener;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private LoopPagerAdapter() {
            this.photoClickListener = new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackPreviewController.LoopPagerAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FeedbackPreviewController.this.setVisibility(8);
                    if (FeedbackPreviewController.this.listener != null) {
                        FeedbackPreviewController.this.listener.exitMode();
                    }
                }
            };
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.mChildCount = getCount();
            super.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (FeedbackPreviewController.this.sources == null) {
                return 0;
            }
            return FeedbackPreviewController.this.sources.size();
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PhotoView photoView;
            View view = null;
            if (FeedbackPreviewController.this.curPosition < FeedbackPreviewController.this.sources.size() && i < FeedbackPreviewController.this.sources.size()) {
                final AlbumItem albumItem = (AlbumItem) FeedbackPreviewController.this.sources.get(i);
                if (albumItem != null && albumItem.url != null) {
                    if (!albumItem.isVideo) {
                        PhotoView photoView2 = new PhotoView(FeedbackPreviewController.this.getContext());
                        photoView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        photoView2.setOnClickListener(this.photoClickListener);
                        photoView2.setTag(null);
                        PicassoLoader.with(FeedbackPreviewController.this.getContext()).load(albumItem.url).into(photoView2);
                        photoView = photoView2;
                    } else {
                        RelativeLayout relativeLayout = new RelativeLayout(FeedbackPreviewController.this.getContext());
                        PhotoView photoView3 = new PhotoView(FeedbackPreviewController.this.getContext());
                        photoView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        photoView3.setOnClickListener(this.photoClickListener);
                        photoView3.setTag(null);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams.addRule(13);
                        relativeLayout.addView(photoView3, layoutParams);
                        PhotoView photoView4 = new PhotoView(FeedbackPreviewController.this.getContext());
                        photoView4.setImageResource(R.mipmap.icon_feedback_play);
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(13);
                        relativeLayout.addView(photoView4, layoutParams2);
                        photoView4.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackPreviewController.LoopPagerAdapter.1
                            @Override // com.ipotensic.baselib.listener.ScaleClickListener
                            public void click(View view2) {
                                FeedbackPreviewController.this.playVideo(albumItem.url);
                            }
                        });
                        if (TextUtils.isEmpty(albumItem.videoThumbnailUrl)) {
                            MediaRetriever.withVideo(albumItem.url).thumbnailType(2).metaKeys(null).into(photoView3);
                            photoView = relativeLayout;
                        } else {
                            PicassoLoader.with(FeedbackPreviewController.this.getContext()).load(albumItem.videoThumbnailUrl).into(photoView3);
                            photoView = relativeLayout;
                        }
                    }
                    view = photoView;
                }
                viewGroup.addView(view);
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo(String str) {
        this.videoPlayer.setVisibility(0);
        DDLog.e("play video：" + str);
        StandardVideoController standardVideoController = new StandardVideoController(getContext());
        standardVideoController.setEnableOrientation(false);
        standardVideoController.addControlComponent(new PrepareView(getContext()));
        standardVideoController.addControlComponent(new CompleteView(getContext()));
        standardVideoController.addControlComponent(new GestureView(getContext()));
        standardVideoController.addControlComponent(new VodControlView(getContext()));
        standardVideoController.setGestureEnabled(true);
        this.videoPlayer.setVideoController(standardVideoController);
        this.videoPlayer.addOnStateChangeListener(new VideoView.OnStateChangeListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackPreviewController.4
            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayerStateChanged(int i) {
            }

            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayStateChanged(int i) {
                DDLog.e("player state:" + i);
                if (i == -1) {
                    ToastUtil.toast(FeedbackPreviewController.this.getContext(), FeedbackPreviewController.this.getContext().getResources().getString(R.string.please_check_the_network));
                }
            }
        });
        this.videoPlayer.setPlayerFactory(ExoMediaPlayerFactory.create());
        this.videoPlayer.setUrl(str);
        ExoMediaSourceHelper.isServerVideo = true;
        this.videoPlayer.start();
    }

    private void stopPlay() {
        VideoView<ExoMediaPlayer> videoView = this.videoPlayer;
        if (videoView != null) {
            videoView.setVisibility(8);
            this.videoPlayer.release();
        }
    }

    public void setExitModeListener(ExitModeListener exitModeListener) {
        this.listener = exitModeListener;
    }
}
