package com.mapbox.mapboxsdk.annotations;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.mapboxsdk.exceptions.InvalidMarkerPositionException;
import com.mapbox.mapboxsdk.geometry.LatLng;

@Deprecated
/* loaded from: classes3.dex */
public final class MarkerOptions extends BaseMarkerOptions<Marker, MarkerOptions> implements Parcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new Parcelable.Creator<MarkerOptions>() { // from class: com.mapbox.mapboxsdk.annotations.MarkerOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MarkerOptions createFromParcel(Parcel parcel) {
            return new MarkerOptions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MarkerOptions[] newArray(int i) {
            return new MarkerOptions[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.mapbox.mapboxsdk.annotations.BaseMarkerOptions
    public MarkerOptions getThis() {
        return this;
    }

    public MarkerOptions() {
    }

    protected MarkerOptions(Parcel parcel) {
        position((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()));
        snippet(parcel.readString());
        title(parcel.readString());
        if (parcel.readByte() != 0) {
            icon(new Icon(parcel.readString(), (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader())));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getPosition(), i);
        parcel.writeString(getSnippet());
        parcel.writeString(getTitle());
        Icon icon = getIcon();
        parcel.writeByte((byte) (icon != null ? 1 : 0));
        if (icon != null) {
            parcel.writeString(getIcon().getId());
            parcel.writeParcelable(getIcon().getBitmap(), i);
        }
    }

    @Override // com.mapbox.mapboxsdk.annotations.BaseMarkerOptions
    public Marker getMarker() {
        if (this.position == null) {
            throw new InvalidMarkerPositionException();
        }
        return new Marker(this.position, this.icon, this.title, this.snippet);
    }

    public LatLng getPosition() {
        return this.position;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getTitle() {
        return this.title;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MarkerOptions markerOptions = (MarkerOptions) obj;
        if (getPosition() == null ? markerOptions.getPosition() != null : !getPosition().equals(markerOptions.getPosition())) {
            return false;
        }
        if (getSnippet() == null ? markerOptions.getSnippet() != null : !getSnippet().equals(markerOptions.getSnippet())) {
            return false;
        }
        if (getIcon() == null ? markerOptions.getIcon() != null : !getIcon().equals(markerOptions.getIcon())) {
            return false;
        }
        if (getTitle() != null) {
            if (getTitle().equals(markerOptions.getTitle())) {
                return true;
            }
        } else if (markerOptions.getTitle() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((getPosition() != null ? getPosition().hashCode() : 0) + 31) * 31) + (getSnippet() != null ? getSnippet().hashCode() : 0)) * 31) + (getIcon() != null ? getIcon().hashCode() : 0)) * 31) + (getTitle() != null ? getTitle().hashCode() : 0);
    }
}
