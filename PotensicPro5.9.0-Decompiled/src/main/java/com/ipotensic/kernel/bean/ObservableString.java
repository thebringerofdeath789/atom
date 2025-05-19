package com.ipotensic.kernel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.Observable;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ObservableString extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableString> CREATOR = new Parcelable.Creator<ObservableString>() { // from class: com.ipotensic.kernel.bean.ObservableString.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableString createFromParcel(Parcel parcel) {
            return new ObservableString(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableString[] newArray(int i) {
            return new ObservableString[i];
        }
    };
    static final long serialVersionUID = 1;
    private String mValue;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ObservableString(String str) {
        this.mValue = "";
        this.mValue = str;
    }

    public ObservableString() {
        this.mValue = "";
    }

    public ObservableString(Observable... observableArr) {
        super(observableArr);
        this.mValue = "";
    }

    public String get() {
        return this.mValue;
    }

    public void set(String str) {
        if (str.equals(this.mValue)) {
            return;
        }
        this.mValue = str;
        notifyChange();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mValue);
    }
}
