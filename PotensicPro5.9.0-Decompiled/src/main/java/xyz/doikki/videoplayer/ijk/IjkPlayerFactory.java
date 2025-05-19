package xyz.doikki.videoplayer.ijk;

import android.content.Context;
import xyz.doikki.videoplayer.player.PlayerFactory;

/* loaded from: classes6.dex */
public class IjkPlayerFactory extends PlayerFactory<IjkPlayer> {
    public static IjkPlayerFactory create() {
        return new IjkPlayerFactory();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.doikki.videoplayer.player.PlayerFactory
    public IjkPlayer createPlayer(Context context) {
        return new IjkPlayer(context);
    }
}
