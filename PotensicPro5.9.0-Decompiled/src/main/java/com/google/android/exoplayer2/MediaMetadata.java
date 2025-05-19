package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaMetadata implements Bundleable {
    private static final int FIELD_ALBUM_ARTIST = 3;
    private static final int FIELD_ALBUM_TITLE = 2;
    private static final int FIELD_ARTIST = 1;
    private static final int FIELD_ARTWORK_DATA = 10;
    private static final int FIELD_ARTWORK_URI = 11;
    private static final int FIELD_DESCRIPTION = 6;
    private static final int FIELD_DISPLAY_TITLE = 4;
    private static final int FIELD_EXTRAS = 1000;
    private static final int FIELD_FOLDER_TYPE = 14;
    private static final int FIELD_IS_PLAYABLE = 15;
    private static final int FIELD_MEDIA_URI = 7;
    private static final int FIELD_OVERALL_RATING = 9;
    private static final int FIELD_SUBTITLE = 5;
    private static final int FIELD_TITLE = 0;
    private static final int FIELD_TOTAL_TRACK_COUNT = 13;
    private static final int FIELD_TRACK_NUMBER = 12;
    private static final int FIELD_USER_RATING = 8;
    private static final int FIELD_YEAR = 16;
    public static final int FOLDER_TYPE_ALBUMS = 2;
    public static final int FOLDER_TYPE_ARTISTS = 3;
    public static final int FOLDER_TYPE_GENRES = 4;
    public static final int FOLDER_TYPE_MIXED = 0;
    public static final int FOLDER_TYPE_PLAYLISTS = 5;
    public static final int FOLDER_TYPE_TITLES = 1;
    public static final int FOLDER_TYPE_YEARS = 6;
    public final CharSequence albumArtist;
    public final CharSequence albumTitle;
    public final CharSequence artist;
    public final byte[] artworkData;
    public final Uri artworkUri;
    public final CharSequence description;
    public final CharSequence displayTitle;
    public final Bundle extras;
    public final Integer folderType;
    public final Boolean isPlayable;
    public final Uri mediaUri;
    public final Rating overallRating;
    public final CharSequence subtitle;
    public final CharSequence title;
    public final Integer totalTrackCount;
    public final Integer trackNumber;
    public final Rating userRating;
    public final Integer year;
    public static final MediaMetadata EMPTY = new Builder().build();
    public static final Bundleable.Creator<MediaMetadata> CREATOR = new Bundleable.Creator() { // from class: com.google.android.exoplayer2.-$$Lambda$MediaMetadata$n4bc9ZFXKwAHBWPswIbYNYyZRds
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            MediaMetadata fromBundle;
            fromBundle = MediaMetadata.fromBundle(bundle);
            return fromBundle;
        }
    };

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FolderType {
    }

    public static final class Builder {
        private CharSequence albumArtist;
        private CharSequence albumTitle;
        private CharSequence artist;
        private byte[] artworkData;
        private Uri artworkUri;
        private CharSequence description;
        private CharSequence displayTitle;
        private Bundle extras;
        private Integer folderType;
        private Boolean isPlayable;
        private Uri mediaUri;
        private Rating overallRating;
        private CharSequence subtitle;
        private CharSequence title;
        private Integer totalTrackCount;
        private Integer trackNumber;
        private Rating userRating;
        private Integer year;

        public Builder() {
        }

        private Builder(MediaMetadata mediaMetadata) {
            this.title = mediaMetadata.title;
            this.artist = mediaMetadata.artist;
            this.albumTitle = mediaMetadata.albumTitle;
            this.albumArtist = mediaMetadata.albumArtist;
            this.displayTitle = mediaMetadata.displayTitle;
            this.subtitle = mediaMetadata.subtitle;
            this.description = mediaMetadata.description;
            this.mediaUri = mediaMetadata.mediaUri;
            this.userRating = mediaMetadata.userRating;
            this.overallRating = mediaMetadata.overallRating;
            this.artworkData = mediaMetadata.artworkData;
            this.artworkUri = mediaMetadata.artworkUri;
            this.trackNumber = mediaMetadata.trackNumber;
            this.totalTrackCount = mediaMetadata.totalTrackCount;
            this.folderType = mediaMetadata.folderType;
            this.isPlayable = mediaMetadata.isPlayable;
            this.year = mediaMetadata.year;
            this.extras = mediaMetadata.extras;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.title = charSequence;
            return this;
        }

        public Builder setArtist(CharSequence charSequence) {
            this.artist = charSequence;
            return this;
        }

        public Builder setAlbumTitle(CharSequence charSequence) {
            this.albumTitle = charSequence;
            return this;
        }

        public Builder setAlbumArtist(CharSequence charSequence) {
            this.albumArtist = charSequence;
            return this;
        }

        public Builder setDisplayTitle(CharSequence charSequence) {
            this.displayTitle = charSequence;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.subtitle = charSequence;
            return this;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.description = charSequence;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.mediaUri = uri;
            return this;
        }

        public Builder setUserRating(Rating rating) {
            this.userRating = rating;
            return this;
        }

        public Builder setOverallRating(Rating rating) {
            this.overallRating = rating;
            return this;
        }

        public Builder setArtworkData(byte[] bArr) {
            this.artworkData = bArr == null ? null : (byte[]) bArr.clone();
            return this;
        }

        public Builder setArtworkUri(Uri uri) {
            this.artworkUri = uri;
            return this;
        }

        public Builder setTrackNumber(Integer num) {
            this.trackNumber = num;
            return this;
        }

        public Builder setTotalTrackCount(Integer num) {
            this.totalTrackCount = num;
            return this;
        }

        public Builder setFolderType(Integer num) {
            this.folderType = num;
            return this;
        }

        public Builder setIsPlayable(Boolean bool) {
            this.isPlayable = bool;
            return this;
        }

        public Builder setYear(Integer num) {
            this.year = num;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder populateFromMetadata(Metadata metadata) {
            for (int i = 0; i < metadata.length(); i++) {
                metadata.get(i).populateMediaMetadata(this);
            }
            return this;
        }

        public Builder populateFromMetadata(List<Metadata> list) {
            for (int i = 0; i < list.size(); i++) {
                Metadata metadata = list.get(i);
                for (int i2 = 0; i2 < metadata.length(); i2++) {
                    metadata.get(i2).populateMediaMetadata(this);
                }
            }
            return this;
        }

        public MediaMetadata build() {
            return new MediaMetadata(this);
        }
    }

    private MediaMetadata(Builder builder) {
        this.title = builder.title;
        this.artist = builder.artist;
        this.albumTitle = builder.albumTitle;
        this.albumArtist = builder.albumArtist;
        this.displayTitle = builder.displayTitle;
        this.subtitle = builder.subtitle;
        this.description = builder.description;
        this.mediaUri = builder.mediaUri;
        this.userRating = builder.userRating;
        this.overallRating = builder.overallRating;
        this.artworkData = builder.artworkData;
        this.artworkUri = builder.artworkUri;
        this.trackNumber = builder.trackNumber;
        this.totalTrackCount = builder.totalTrackCount;
        this.folderType = builder.folderType;
        this.isPlayable = builder.isPlayable;
        this.year = builder.year;
        this.extras = builder.extras;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return Util.areEqual(this.title, mediaMetadata.title) && Util.areEqual(this.artist, mediaMetadata.artist) && Util.areEqual(this.albumTitle, mediaMetadata.albumTitle) && Util.areEqual(this.albumArtist, mediaMetadata.albumArtist) && Util.areEqual(this.displayTitle, mediaMetadata.displayTitle) && Util.areEqual(this.subtitle, mediaMetadata.subtitle) && Util.areEqual(this.description, mediaMetadata.description) && Util.areEqual(this.mediaUri, mediaMetadata.mediaUri) && Util.areEqual(this.userRating, mediaMetadata.userRating) && Util.areEqual(this.overallRating, mediaMetadata.overallRating) && Arrays.equals(this.artworkData, mediaMetadata.artworkData) && Util.areEqual(this.artworkUri, mediaMetadata.artworkUri) && Util.areEqual(this.trackNumber, mediaMetadata.trackNumber) && Util.areEqual(this.totalTrackCount, mediaMetadata.totalTrackCount) && Util.areEqual(this.folderType, mediaMetadata.folderType) && Util.areEqual(this.isPlayable, mediaMetadata.isPlayable) && Util.areEqual(this.year, mediaMetadata.year);
    }

    public int hashCode() {
        return Objects.hashCode(this.title, this.artist, this.albumTitle, this.albumArtist, this.displayTitle, this.subtitle, this.description, this.mediaUri, this.userRating, this.overallRating, Integer.valueOf(Arrays.hashCode(this.artworkData)), this.artworkUri, this.trackNumber, this.totalTrackCount, this.folderType, this.isPlayable, this.year);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(keyForField(0), this.title);
        bundle.putCharSequence(keyForField(1), this.artist);
        bundle.putCharSequence(keyForField(2), this.albumTitle);
        bundle.putCharSequence(keyForField(3), this.albumArtist);
        bundle.putCharSequence(keyForField(4), this.displayTitle);
        bundle.putCharSequence(keyForField(5), this.subtitle);
        bundle.putCharSequence(keyForField(6), this.description);
        bundle.putParcelable(keyForField(7), this.mediaUri);
        bundle.putByteArray(keyForField(10), this.artworkData);
        bundle.putParcelable(keyForField(11), this.artworkUri);
        if (this.userRating != null) {
            bundle.putBundle(keyForField(8), this.userRating.toBundle());
        }
        if (this.overallRating != null) {
            bundle.putBundle(keyForField(9), this.overallRating.toBundle());
        }
        if (this.trackNumber != null) {
            bundle.putInt(keyForField(12), this.trackNumber.intValue());
        }
        if (this.totalTrackCount != null) {
            bundle.putInt(keyForField(13), this.totalTrackCount.intValue());
        }
        if (this.folderType != null) {
            bundle.putInt(keyForField(14), this.folderType.intValue());
        }
        if (this.isPlayable != null) {
            bundle.putBoolean(keyForField(15), this.isPlayable.booleanValue());
        }
        if (this.year != null) {
            bundle.putInt(keyForField(16), this.year.intValue());
        }
        if (this.extras != null) {
            bundle.putBundle(keyForField(1000), this.extras);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaMetadata fromBundle(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        Builder builder = new Builder();
        builder.setTitle(bundle.getCharSequence(keyForField(0))).setArtist(bundle.getCharSequence(keyForField(1))).setAlbumTitle(bundle.getCharSequence(keyForField(2))).setAlbumArtist(bundle.getCharSequence(keyForField(3))).setDisplayTitle(bundle.getCharSequence(keyForField(4))).setSubtitle(bundle.getCharSequence(keyForField(5))).setDescription(bundle.getCharSequence(keyForField(6))).setMediaUri((Uri) bundle.getParcelable(keyForField(7))).setArtworkData(bundle.getByteArray(keyForField(10))).setArtworkUri((Uri) bundle.getParcelable(keyForField(11))).setExtras(bundle.getBundle(keyForField(1000)));
        if (bundle.containsKey(keyForField(8)) && (bundle3 = bundle.getBundle(keyForField(8))) != null) {
            builder.setUserRating(Rating.CREATOR.fromBundle(bundle3));
        }
        if (bundle.containsKey(keyForField(9)) && (bundle2 = bundle.getBundle(keyForField(9))) != null) {
            builder.setOverallRating(Rating.CREATOR.fromBundle(bundle2));
        }
        if (bundle.containsKey(keyForField(12))) {
            builder.setTrackNumber(Integer.valueOf(bundle.getInt(keyForField(12))));
        }
        if (bundle.containsKey(keyForField(13))) {
            builder.setTotalTrackCount(Integer.valueOf(bundle.getInt(keyForField(13))));
        }
        if (bundle.containsKey(keyForField(14))) {
            builder.setFolderType(Integer.valueOf(bundle.getInt(keyForField(14))));
        }
        if (bundle.containsKey(keyForField(15))) {
            builder.setIsPlayable(Boolean.valueOf(bundle.getBoolean(keyForField(15))));
        }
        if (bundle.containsKey(keyForField(16))) {
            builder.setYear(Integer.valueOf(bundle.getInt(keyForField(16))));
        }
        return builder.build();
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
