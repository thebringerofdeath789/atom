package com.mapbox.android.telemetry;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.mapbox.android.telemetry.Event;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Attachment extends Event implements Parcelable {
    public static final Parcelable.Creator<Attachment> CREATOR = new Parcelable.Creator<Attachment>() { // from class: com.mapbox.android.telemetry.Attachment.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Attachment createFromParcel(Parcel parcel) {
            return new Attachment(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Attachment[] newArray(int i) {
            return new Attachment[i];
        }
    };
    private static final String VIS_ATTACHMENT = "vis.attachment";

    @SerializedName("files")
    private List<FileAttachment> attachments;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final String event;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    Attachment() {
        this.event = VIS_ATTACHMENT;
        this.attachments = new ArrayList();
    }

    protected Attachment(Parcel parcel) {
        this.event = parcel.readString();
    }

    public List<FileAttachment> getAttachments() {
        return this.attachments;
    }

    public void addAttachment(FileAttachment fileAttachment) {
        this.attachments.add(fileAttachment);
    }

    @Override // com.mapbox.android.telemetry.Event
    Event.Type obtainType() {
        return Event.Type.VIS_ATTACHMENT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.event);
    }
}
