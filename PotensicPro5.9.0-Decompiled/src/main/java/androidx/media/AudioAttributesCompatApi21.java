package androidx.media;

import android.media.AudioAttributes;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class AudioAttributesCompatApi21 {
    private static final String TAG = "AudioAttributesCompat";
    private static Method sAudioAttributesToLegacyStreamType;

    public static int toLegacyStreamType(Wrapper wrapper) {
        AudioAttributes unwrap = wrapper.unwrap();
        try {
            if (sAudioAttributesToLegacyStreamType == null) {
                sAudioAttributesToLegacyStreamType = AudioAttributes.class.getMethod("toLegacyStreamType", AudioAttributes.class);
            }
            return ((Integer) sAudioAttributesToLegacyStreamType.invoke(null, unwrap)).intValue();
        } catch (ClassCastException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.w(TAG, "getLegacyStreamType() failed on API21+", e);
            return -1;
        }
    }

    static final class Wrapper {
        private AudioAttributes mWrapped;

        private Wrapper(AudioAttributes audioAttributes) {
            this.mWrapped = audioAttributes;
        }

        public static Wrapper wrap(AudioAttributes audioAttributes) {
            if (audioAttributes == null) {
                throw new IllegalArgumentException("AudioAttributesApi21.Wrapper cannot wrap null");
            }
            return new Wrapper(audioAttributes);
        }

        public AudioAttributes unwrap() {
            return this.mWrapped;
        }
    }

    private AudioAttributesCompatApi21() {
    }
}
