package xyz.doikki.videoplayer.exo;

import android.content.Context;
import xyz.doikki.videoplayer.player.PlayerFactory;

/* loaded from: classes6.dex */
public class ExoMediaPlayerFactory extends PlayerFactory<ExoMediaPlayer> {
    public static ExoMediaPlayerFactory create() {
        return new ExoMediaPlayerFactory();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.doikki.videoplayer.player.PlayerFactory
    public ExoMediaPlayer createPlayer(Context context) {
        return new ExoMediaPlayer(context);
    }
}
