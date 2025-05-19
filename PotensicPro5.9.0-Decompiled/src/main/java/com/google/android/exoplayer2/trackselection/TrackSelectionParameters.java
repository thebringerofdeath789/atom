package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* loaded from: classes.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR;

    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;
    public final ImmutableList<String> preferredAudioLanguages;
    public final int preferredAudioRoleFlags;
    public final ImmutableList<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static class Builder {
        int disabledTextTrackSelectionFlags;
        ImmutableList<String> preferredAudioLanguages;
        int preferredAudioRoleFlags;
        ImmutableList<String> preferredTextLanguages;
        int preferredTextRoleFlags;
        boolean selectUndeterminedTextLanguage;

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
        }

        @Deprecated
        public Builder() {
            this.preferredAudioLanguages = ImmutableList.of();
            this.preferredAudioRoleFlags = 0;
            this.preferredTextLanguages = ImmutableList.of();
            this.preferredTextRoleFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.disabledTextTrackSelectionFlags = 0;
        }

        Builder(TrackSelectionParameters trackSelectionParameters) {
            this.preferredAudioLanguages = trackSelectionParameters.preferredAudioLanguages;
            this.preferredAudioRoleFlags = trackSelectionParameters.preferredAudioRoleFlags;
            this.preferredTextLanguages = trackSelectionParameters.preferredTextLanguages;
            this.preferredTextRoleFlags = trackSelectionParameters.preferredTextRoleFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = trackSelectionParameters.disabledTextTrackSelectionFlags;
        }

        public Builder setPreferredAudioLanguage(String str) {
            if (str == null) {
                return setPreferredAudioLanguages(new String[0]);
            }
            return setPreferredAudioLanguages(str);
        }

        public Builder setPreferredAudioLanguages(String... strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((ImmutableList.Builder) Util.normalizeLanguageCode((String) Assertions.checkNotNull(str)));
            }
            this.preferredAudioLanguages = builder.build();
            return this;
        }

        public Builder setPreferredAudioRoleFlags(int i) {
            this.preferredAudioRoleFlags = i;
            return this;
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            if (Util.SDK_INT >= 19) {
                setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context);
            }
            return this;
        }

        public Builder setPreferredTextLanguage(String str) {
            if (str == null) {
                return setPreferredTextLanguages(new String[0]);
            }
            return setPreferredTextLanguages(str);
        }

        public Builder setPreferredTextLanguages(String... strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((ImmutableList.Builder) Util.normalizeLanguageCode((String) Assertions.checkNotNull(str)));
            }
            this.preferredTextLanguages = builder.build();
            return this;
        }

        public Builder setPreferredTextRoleFlags(int i) {
            this.preferredTextRoleFlags = i;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.selectUndeterminedTextLanguage = z;
            return this;
        }

        public Builder setDisabledTextTrackSelectionFlags(int i) {
            this.disabledTextTrackSelectionFlags = i;
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this.preferredAudioLanguages, this.preferredAudioRoleFlags, this.preferredTextLanguages, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags);
        }

        private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context context) {
            CaptioningManager captioningManager;
            if ((Util.SDK_INT >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.preferredTextRoleFlags = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.preferredTextLanguages = ImmutableList.of(Util.getLocaleLanguageTag(locale));
                }
            }
        }
    }

    static {
        TrackSelectionParameters build = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
        CREATOR = new Parcelable.Creator<TrackSelectionParameters>() { // from class: com.google.android.exoplayer2.trackselection.TrackSelectionParameters.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackSelectionParameters createFromParcel(Parcel parcel) {
                return new TrackSelectionParameters(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackSelectionParameters[] newArray(int i) {
                return new TrackSelectionParameters[i];
            }
        };
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    TrackSelectionParameters(ImmutableList<String> immutableList, int i, ImmutableList<String> immutableList2, int i2, boolean z, int i3) {
        this.preferredAudioLanguages = immutableList;
        this.preferredAudioRoleFlags = i;
        this.preferredTextLanguages = immutableList2;
        this.preferredTextRoleFlags = i2;
        this.selectUndeterminedTextLanguage = z;
        this.disabledTextTrackSelectionFlags = i3;
    }

    TrackSelectionParameters(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.preferredAudioLanguages = ImmutableList.copyOf((Collection) arrayList);
        this.preferredAudioRoleFlags = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, null);
        this.preferredTextLanguages = ImmutableList.copyOf((Collection) arrayList2);
        this.preferredTextRoleFlags = parcel.readInt();
        this.selectUndeterminedTextLanguage = Util.readBoolean(parcel);
        this.disabledTextTrackSelectionFlags = parcel.readInt();
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == trackSelectionParameters.disabledTextTrackSelectionFlags;
    }

    public int hashCode() {
        return ((((((((((this.preferredAudioLanguages.hashCode() + 31) * 31) + this.preferredAudioRoleFlags) * 31) + this.preferredTextLanguages.hashCode()) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.preferredAudioLanguages);
        parcel.writeInt(this.preferredAudioRoleFlags);
        parcel.writeList(this.preferredTextLanguages);
        parcel.writeInt(this.preferredTextRoleFlags);
        Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
        parcel.writeInt(this.disabledTextTrackSelectionFlags);
    }
}
