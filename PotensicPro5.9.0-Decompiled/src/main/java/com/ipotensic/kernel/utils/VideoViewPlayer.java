package com.ipotensic.kernel.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.kernel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lingala.zip4j.util.InternalZipConstants;
import xyz.doikki.videoplayer.exo.ExoMediaPlayer;
import xyz.doikki.videoplayer.exo.ExoMediaPlayerFactory;
import xyz.doikki.videoplayer.exo.ExoMediaSourceHelper;
import xyz.doikki.videoplayer.player.VideoView;

/* compiled from: VideoViewPlayer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/ipotensic/kernel/utils/VideoViewPlayer;", "", "videoView", "Lxyz/doikki/videoplayer/player/VideoView;", "Lxyz/doikki/videoplayer/exo/ExoMediaPlayer;", "tvTips", "Landroid/widget/TextView;", "(Lxyz/doikki/videoplayer/player/VideoView;Landroid/widget/TextView;)V", "NONE", "", "isPlaying", "", "getTvTips", "()Landroid/widget/TextView;", "getVideoView", "()Lxyz/doikki/videoplayer/player/VideoView;", "getRawRes", "visionExecuteType", "Lcom/ipotensic/baselib/enums/VisionExecuteType;", "getStringRes", "oncePlay", "", "context", "Landroid/content/Context;", "onCompletionListener", "Landroid/media/MediaPlayer$OnCompletionListener;", "repeatPlay", "stop", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class VideoViewPlayer {
    private final int NONE;
    private boolean isPlaying;
    private final TextView tvTips;
    private final VideoView<ExoMediaPlayer> videoView;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[VisionExecuteType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VisionExecuteType.TYPE_VISION_FOLLOW.ordinal()] = 1;
            iArr[VisionExecuteType.TYPE_CIRCLE.ordinal()] = 2;
            iArr[VisionExecuteType.TYPE_SCREW.ordinal()] = 3;
            iArr[VisionExecuteType.TYPE_COMET.ordinal()] = 4;
            iArr[VisionExecuteType.TYPE_SKYWARD.ordinal()] = 5;
            iArr[VisionExecuteType.TYPE_RECESS.ordinal()] = 6;
            int[] iArr2 = new int[VisionExecuteType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[VisionExecuteType.TYPE_VISION_FOLLOW.ordinal()] = 1;
            iArr2[VisionExecuteType.TYPE_CIRCLE.ordinal()] = 2;
            iArr2[VisionExecuteType.TYPE_SCREW.ordinal()] = 3;
            iArr2[VisionExecuteType.TYPE_COMET.ordinal()] = 4;
            iArr2[VisionExecuteType.TYPE_SKYWARD.ordinal()] = 5;
            iArr2[VisionExecuteType.TYPE_RECESS.ordinal()] = 6;
        }
    }

    public VideoViewPlayer(VideoView<ExoMediaPlayer> videoView, TextView tvTips) {
        Intrinsics.checkParameterIsNotNull(videoView, "videoView");
        Intrinsics.checkParameterIsNotNull(tvTips, "tvTips");
        this.videoView = videoView;
        this.tvTips = tvTips;
        this.NONE = -1;
    }

    public final TextView getTvTips() {
        return this.tvTips;
    }

    public final VideoView<ExoMediaPlayer> getVideoView() {
        return this.videoView;
    }

    public final void oncePlay(Context context, VisionExecuteType visionExecuteType, final MediaPlayer.OnCompletionListener onCompletionListener) {
        int stringRes;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(visionExecuteType, "visionExecuteType");
        Intrinsics.checkParameterIsNotNull(onCompletionListener, "onCompletionListener");
        int rawRes = getRawRes(visionExecuteType);
        if (rawRes == this.NONE || (stringRes = getStringRes(visionExecuteType)) == this.NONE) {
            return;
        }
        this.tvTips.setText(context.getText(stringRes));
        stop();
        this.isPlaying = true;
        this.videoView.setPlayerFactory(ExoMediaPlayerFactory.create());
        this.videoView.setOnStateChangeListener(new VideoView.OnStateChangeListener() { // from class: com.ipotensic.kernel.utils.VideoViewPlayer$oncePlay$1
            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayerStateChanged(int playerState) {
            }

            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayStateChanged(int playState) {
                boolean z;
                if (playState == 5) {
                    z = VideoViewPlayer.this.isPlaying;
                    if (z) {
                        onCompletionListener.onCompletion(null);
                    }
                }
            }
        });
        String str = "android.resource://" + context.getPackageName() + InternalZipConstants.ZIP_FILE_SEPARATOR + rawRes;
        ExoMediaSourceHelper.isServerVideo = false;
        this.videoView.setUrl(str);
        this.videoView.start();
    }

    public final void repeatPlay(Context context, VisionExecuteType visionExecuteType) {
        int stringRes;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(visionExecuteType, "visionExecuteType");
        int rawRes = getRawRes(visionExecuteType);
        if (rawRes == this.NONE || (stringRes = getStringRes(visionExecuteType)) == this.NONE) {
            return;
        }
        this.tvTips.setText(context.getText(stringRes));
        stop();
        this.isPlaying = true;
        String str = "android.resource://" + context.getPackageName() + InternalZipConstants.ZIP_FILE_SEPARATOR + rawRes;
        this.videoView.setPlayerFactory(ExoMediaPlayerFactory.create());
        this.videoView.setOnStateChangeListener(new VideoView.OnStateChangeListener() { // from class: com.ipotensic.kernel.utils.VideoViewPlayer$repeatPlay$1
            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayStateChanged(int playState) {
            }

            @Override // xyz.doikki.videoplayer.player.VideoView.OnStateChangeListener
            public void onPlayerStateChanged(int playerState) {
            }
        });
        this.videoView.setLooping(true);
        ExoMediaSourceHelper.isServerVideo = false;
        this.videoView.setUrl(str);
        this.videoView.start();
    }

    public final void stop() {
        try {
            this.isPlaying = false;
            this.videoView.release();
        } catch (Exception e) {
            DDLog.e("停止失败1 ：" + e.getMessage());
        }
    }

    public final int getRawRes(VisionExecuteType visionExecuteType) {
        Intrinsics.checkParameterIsNotNull(visionExecuteType, "visionExecuteType");
        switch (WhenMappings.$EnumSwitchMapping$0[visionExecuteType.ordinal()]) {
            case 1:
                return R.raw.video_quick_shot_follow;
            case 2:
                return R.raw.video_quick_shot_circle;
            case 3:
                return R.raw.video_quick_shot_screw;
            case 4:
                return R.raw.video_quick_shot_comet;
            case 5:
                return R.raw.video_quick_shot_skyward;
            case 6:
                return R.raw.video_quick_shot_recess;
            default:
                return this.NONE;
        }
    }

    public final int getStringRes(VisionExecuteType visionExecuteType) {
        Intrinsics.checkParameterIsNotNull(visionExecuteType, "visionExecuteType");
        switch (WhenMappings.$EnumSwitchMapping$1[visionExecuteType.ordinal()]) {
            case 1:
                return R.string.visual_tracking_instructional_animations_guide;
            case 2:
                return R.string.quickshots_circle_instructional_animations_guide;
            case 3:
                return R.string.quickshots_spiral_instructional_animations_guide;
            case 4:
                return R.string.quickshots_boomerang_instructional_animations_guide;
            case 5:
                return R.string.quickshots_rocket_instructional_animations_guide;
            case 6:
                return R.string.quickshots_pull_away_instructional_animations_guide;
            default:
                return this.NONE;
        }
    }
}
