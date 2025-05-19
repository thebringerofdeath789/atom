package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.TextInformationFrame.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }
    };
    public final String description;
    public final String value;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super((String) Util.castNonNull(parcel.readString()));
        this.description = parcel.readString();
        this.value = (String) Util.castNonNull(parcel.readString());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.id;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 0;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 1;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 2;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = 3;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 4;
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = 5;
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = 6;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 7;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = '\b';
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = '\t';
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = '\n';
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 11;
                    break;
                }
                break;
        }
        try {
            switch (c) {
                case 0:
                case 6:
                    builder.setAlbumTitle(this.value);
                    break;
                case 1:
                case '\b':
                    builder.setArtist(this.value);
                    break;
                case 2:
                case '\t':
                    builder.setAlbumArtist(this.value);
                    break;
                case 3:
                case '\n':
                    String[] split = Util.split(this.value, InternalZipConstants.ZIP_FILE_SEPARATOR);
                    builder.setTrackNumber(Integer.valueOf(Integer.parseInt(split[0]))).setTotalTrackCount(split.length > 1 ? Integer.valueOf(Integer.parseInt(split[1])) : null);
                    break;
                case 4:
                case 7:
                    builder.setTitle(this.value);
                    break;
                case 5:
                case 11:
                    builder.setYear(Integer.valueOf(Integer.parseInt(this.value)));
                    break;
            }
        } catch (NumberFormatException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return Util.areEqual(this.id, textInformationFrame.id) && Util.areEqual(this.description, textInformationFrame.description) && Util.areEqual(this.value, textInformationFrame.value);
    }

    public int hashCode() {
        int hashCode = (527 + this.id.hashCode()) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.id;
        String str2 = this.description;
        String str3 = this.value;
        return new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append(": description=").append(str2).append(": value=").append(str3).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
