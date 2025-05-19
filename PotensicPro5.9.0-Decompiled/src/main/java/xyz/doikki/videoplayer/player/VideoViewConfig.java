package xyz.doikki.videoplayer.player;

import xyz.doikki.videoplayer.render.RenderViewFactory;
import xyz.doikki.videoplayer.render.TextureRenderViewFactory;

/* loaded from: classes6.dex */
public class VideoViewConfig {
    public final boolean mAdaptCutout;
    public final boolean mEnableAudioFocus;
    public final boolean mEnableOrientation;
    public final boolean mIsEnableLog;
    public final boolean mPlayOnMobileNetwork;
    public final PlayerFactory mPlayerFactory;
    public final ProgressManager mProgressManager;
    public final RenderViewFactory mRenderViewFactory;
    public final int mScreenScaleType;

    public static Builder newBuilder() {
        return new Builder();
    }

    private VideoViewConfig(Builder builder) {
        this.mIsEnableLog = builder.mIsEnableLog;
        this.mEnableOrientation = builder.mEnableOrientation;
        this.mPlayOnMobileNetwork = builder.mPlayOnMobileNetwork;
        this.mEnableAudioFocus = builder.mEnableAudioFocus;
        this.mProgressManager = builder.mProgressManager;
        this.mScreenScaleType = builder.mScreenScaleType;
        if (builder.mPlayerFactory == null) {
            this.mPlayerFactory = AndroidMediaPlayerFactory.create();
        } else {
            this.mPlayerFactory = builder.mPlayerFactory;
        }
        if (builder.mRenderViewFactory == null) {
            this.mRenderViewFactory = TextureRenderViewFactory.create();
        } else {
            this.mRenderViewFactory = builder.mRenderViewFactory;
        }
        this.mAdaptCutout = builder.mAdaptCutout;
    }

    public static final class Builder {
        private boolean mEnableOrientation;
        private boolean mIsEnableLog;
        private PlayerFactory mPlayerFactory;
        private ProgressManager mProgressManager;
        private RenderViewFactory mRenderViewFactory;
        private int mScreenScaleType;
        private boolean mPlayOnMobileNetwork = true;
        private boolean mEnableAudioFocus = true;
        private boolean mAdaptCutout = true;

        public Builder setEnableOrientation(boolean z) {
            this.mEnableOrientation = z;
            return this;
        }

        public Builder setPlayOnMobileNetwork(boolean z) {
            this.mPlayOnMobileNetwork = z;
            return this;
        }

        public Builder setEnableAudioFocus(boolean z) {
            this.mEnableAudioFocus = z;
            return this;
        }

        public Builder setProgressManager(ProgressManager progressManager) {
            this.mProgressManager = progressManager;
            return this;
        }

        public Builder setLogEnabled(boolean z) {
            this.mIsEnableLog = z;
            return this;
        }

        public Builder setPlayerFactory(PlayerFactory playerFactory) {
            this.mPlayerFactory = playerFactory;
            return this;
        }

        public Builder setScreenScaleType(int i) {
            this.mScreenScaleType = i;
            return this;
        }

        public Builder setRenderViewFactory(RenderViewFactory renderViewFactory) {
            this.mRenderViewFactory = renderViewFactory;
            return this;
        }

        public Builder setAdaptCutout(boolean z) {
            this.mAdaptCutout = z;
            return this;
        }

        public VideoViewConfig build() {
            return new VideoViewConfig(this);
        }
    }
}
