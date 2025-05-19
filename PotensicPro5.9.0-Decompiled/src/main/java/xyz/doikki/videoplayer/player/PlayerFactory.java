package xyz.doikki.videoplayer.player;

import android.content.Context;
import xyz.doikki.videoplayer.player.AbstractPlayer;

/* loaded from: classes6.dex */
public abstract class PlayerFactory<P extends AbstractPlayer> {
    public abstract P createPlayer(Context context);
}
