package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManager;

/* loaded from: classes.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.mObject = (android.media.session.MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        if (remoteUserInfoImpl instanceof RemoteUserInfo) {
            return this.mObject.isTrustedForMediaControl(((RemoteUserInfo) remoteUserInfoImpl).mObject);
        }
        return false;
    }

    static final class RemoteUserInfo implements MediaSessionManager.RemoteUserInfoImpl {
        MediaSessionManager.RemoteUserInfo mObject;

        RemoteUserInfo(String str, int i, int i2) {
            this.mObject = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.mObject.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.mObject.getPid();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.mObject.getUid();
        }
    }
}
