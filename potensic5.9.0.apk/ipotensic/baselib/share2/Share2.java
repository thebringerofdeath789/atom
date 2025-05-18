package com.ipotensic.baselib.share2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.listener.SimpleResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes2.dex */
public class Share2 {
    private static final String TAG = "Share2";
    private BaseActivity activity;
    private String componentClassName;
    private String componentPackageName;
    private String contentText;
    private String contentType;
    private boolean forcedUseSystemChooser;
    private boolean isForcePortrait;
    private boolean isSingle;
    private int requestCode;
    private Uri shareFileUri;
    private String title;
    private ArrayList<Uri> uris;

    private Share2(Builder builder) {
        this.isForcePortrait = false;
        this.activity = builder.activity;
        this.contentType = builder.contentType;
        this.title = builder.title;
        this.shareFileUri = builder.shareFileUri;
        this.contentText = builder.textContent;
        this.componentPackageName = builder.componentPackageName;
        this.componentClassName = builder.componentClassName;
        this.requestCode = builder.requestCode;
        this.forcedUseSystemChooser = builder.forcedUseSystemChooser;
        this.isSingle = builder.isSingle;
        this.uris = builder.uris;
        this.isForcePortrait = builder.isForcePortrait;
    }

    public void shareBySystem() {
        if (checkShareParam()) {
            Intent createShareIntent = createShareIntent();
            if (createShareIntent == null) {
                DDLog.e(TAG, "shareBySystem cancel.");
                return;
            }
            if (this.title == null) {
                this.title = "";
            }
            if (this.forcedUseSystemChooser) {
                createShareIntent = Intent.createChooser(createShareIntent, this.title);
            }
            if (createShareIntent.resolveActivity(this.activity.getPackageManager()) != null) {
                try {
                    if (this.requestCode != -1) {
                        this.activity.registerActivityForResult(createShareIntent, new SimpleResultListener<ActivityResult>() { // from class: com.ipotensic.baselib.share2.Share2.1
                            @Override // com.ipotensic.baselib.listener.SimpleResultListener
                            public void onResult(ActivityResult activityResult) {
                                Share2.this.onShareFinished();
                            }
                        });
                    } else {
                        this.activity.registerActivityForResult(createShareIntent, new SimpleResultListener<ActivityResult>() { // from class: com.ipotensic.baselib.share2.Share2.2
                            @Override // com.ipotensic.baselib.listener.SimpleResultListener
                            public void onResult(ActivityResult activityResult) {
                                Share2.this.onShareFinished();
                            }
                        });
                    }
                } catch (Exception e) {
                    DDLog.e(TAG, Log.getStackTraceString(e));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareFinished() {
        BaseActivity baseActivity;
        if (!this.isForcePortrait || (baseActivity = this.activity) == null || baseActivity.isFinishing()) {
            return;
        }
        this.activity.setRequestedOrientation(0);
    }

    private Intent createShareIntent() {
        Intent intent;
        intent = new Intent();
        intent.setAction(this.isSingle ? "android.intent.action.SEND" : "android.intent.action.SEND_MULTIPLE");
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.DEFAULT");
        if (!TextUtils.isEmpty(this.componentPackageName) && !TextUtils.isEmpty(this.componentClassName)) {
            intent.setComponent(new ComponentName(this.componentPackageName, this.componentClassName));
        }
        String str = this.contentType;
        str.hashCode();
        switch (str) {
            case "audio/*":
            case "*/*":
            case "video/*":
            case "image/*":
                intent.setAction(this.isSingle ? "android.intent.action.SEND" : "android.intent.action.SEND_MULTIPLE");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setType(this.contentType);
                if (this.isSingle) {
                    intent.putExtra("android.intent.extra.STREAM", this.shareFileUri);
                    DDLog.e(StringLookupFactory.KEY_FILE, "shareFileUri: " + this.shareFileUri);
                } else {
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.uris);
                }
                intent.addFlags(268435456);
                intent.addFlags(1);
                if (Build.VERSION.SDK_INT > 19) {
                    return intent;
                }
                Iterator<ResolveInfo> it = this.activity.getPackageManager().queryIntentActivities(intent, 65536).iterator();
                while (it.hasNext()) {
                    String str2 = it.next().activityInfo.packageName;
                    if (this.isSingle) {
                        this.activity.grantUriPermission(str2, this.shareFileUri, 1);
                    } else {
                        for (int i = 0; i < this.uris.size(); i++) {
                            this.activity.grantUriPermission(str2, this.uris.get(i), 1);
                        }
                    }
                }
                return intent;
            case "text/plain":
                intent.putExtra("android.intent.extra.TEXT", this.contentText);
                intent.setType("text/plain");
                return intent;
            default:
                DDLog.e(TAG, this.contentType + " is not support share type.");
                return null;
        }
    }

    private boolean checkShareParam() {
        if (this.activity == null) {
            DDLog.e(TAG, "activity is null.");
            return false;
        }
        if (TextUtils.isEmpty(this.contentType)) {
            DDLog.e(TAG, "Share content type is empty.");
            return false;
        }
        if ("text/plain".equals(this.contentType)) {
            if (!TextUtils.isEmpty(this.contentText)) {
                return true;
            }
            DDLog.e(TAG, "Share text context is empty.");
            return false;
        }
        if (this.shareFileUri != null || this.uris != null) {
            return true;
        }
        DDLog.e(TAG, "Share file path is null.");
        return false;
    }

    public static class Builder {
        private final String MARK;
        private BaseActivity activity;
        private String componentClassName;
        private String componentPackageName;
        private boolean isForcePortrait;
        private boolean isSingle;
        private Uri shareFileUri;
        private String textContent;
        private String title;
        private String contentType = ShareContentType.FILE;
        private int requestCode = -1;
        private boolean forcedUseSystemChooser = true;
        private ArrayList<Uri> uris = new ArrayList<>();

        public Builder(BaseActivity baseActivity) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            this.MARK = lowerCase;
            this.isForcePortrait = false;
            this.activity = baseActivity;
            if ((lowerCase.contains("xiaomi") || lowerCase.contains("google")) && baseActivity.getResources().getConfiguration().orientation == 2) {
                this.isForcePortrait = true;
                baseActivity.setRequestedOrientation(1);
            }
        }

        public Builder setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setShareFileUri(Uri uri) {
            this.shareFileUri = uri;
            return this;
        }

        public Builder setShareFileUriList(ArrayList<Uri> arrayList) {
            this.uris = arrayList;
            return this;
        }

        public Builder setIsSingle(boolean z) {
            this.isSingle = z;
            return this;
        }

        public Builder setTextContent(String str) {
            this.textContent = str;
            return this;
        }

        public Builder setShareToComponent(String str, String str2) {
            this.componentPackageName = str;
            this.componentClassName = str2;
            return this;
        }

        public Builder setOnActivityResult(int i) {
            this.requestCode = i;
            return this;
        }

        public Builder forcedUseSystemChooser(boolean z) {
            this.forcedUseSystemChooser = z;
            return this;
        }

        public Share2 build() {
            return new Share2(this);
        }
    }
}