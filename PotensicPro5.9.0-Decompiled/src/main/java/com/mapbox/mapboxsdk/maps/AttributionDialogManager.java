package com.mapbox.mapboxsdk.maps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.mapboxsdk.MapStrictMode;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.attribution.Attribution;
import com.mapbox.mapboxsdk.attribution.AttributionParser;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.style.sources.Source;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class AttributionDialogManager implements View.OnClickListener, DialogInterface.OnClickListener {
    private static final String MAP_FEEDBACK_STYLE_URI_REGEX = "^(.*://[^:^/]*)/(.*)/(.*)";
    private static final String MAP_FEEDBACK_URL = "https://apps.mapbox.com/feedback";
    private static final String MAP_FEEDBACK_URL_LOCATION_FRAGMENT_FORMAT = "/%f/%f/%f/%f/%d";
    private static final String MAP_FEEDBACK_URL_OLD = "https://www.mapbox.com/map-feedback";
    private Set<Attribution> attributionSet;
    private final Context context;
    private AlertDialog dialog;
    private final MapboxMap mapboxMap;

    public AttributionDialogManager(Context context, MapboxMap mapboxMap) {
        this.context = context;
        this.mapboxMap = mapboxMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.attributionSet = new AttributionBuilder(this.mapboxMap, view.getContext()).build();
        Context context = this.context;
        if (context instanceof Activity ? ((Activity) context).isFinishing() : false) {
            return;
        }
        showAttributionDialog(getAttributionTitles());
    }

    protected void showAttributionDialog(String[] strArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.mapbox_attributionsDialogTitle);
        builder.setAdapter(new ArrayAdapter(this.context, R.layout.mapbox_attribution_list_item, strArr), this);
        this.dialog = builder.show();
    }

    private String[] getAttributionTitles() {
        ArrayList arrayList = new ArrayList();
        Iterator<Attribution> it = this.attributionSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTitle());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (isLatestEntry(i)) {
            showTelemetryDialog();
        } else {
            showMapAttributionWebPage(i);
        }
    }

    public void onStop() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    private boolean isLatestEntry(int i) {
        return i == getAttributionTitles().length - 1;
    }

    private void showTelemetryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.mapbox_attributionTelemetryTitle);
        builder.setMessage(R.string.mapbox_attributionTelemetryMessage);
        builder.setPositiveButton(R.string.mapbox_attributionTelemetryPositive, new DialogInterface.OnClickListener() { // from class: com.mapbox.mapboxsdk.maps.AttributionDialogManager.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                TelemetryDefinition telemetry = Mapbox.getTelemetry();
                if (telemetry != null) {
                    telemetry.setUserTelemetryRequestState(true);
                }
                dialogInterface.cancel();
            }
        });
        builder.setNeutralButton(R.string.mapbox_attributionTelemetryNeutral, new DialogInterface.OnClickListener() { // from class: com.mapbox.mapboxsdk.maps.AttributionDialogManager.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AttributionDialogManager attributionDialogManager = AttributionDialogManager.this;
                attributionDialogManager.showWebPage(attributionDialogManager.context.getResources().getString(R.string.mapbox_telemetryLink));
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton(R.string.mapbox_attributionTelemetryNegative, new DialogInterface.OnClickListener() { // from class: com.mapbox.mapboxsdk.maps.AttributionDialogManager.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                TelemetryDefinition telemetry = Mapbox.getTelemetry();
                if (telemetry != null) {
                    telemetry.setUserTelemetryRequestState(false);
                }
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void showMapAttributionWebPage(int i) {
        Set<Attribution> set = this.attributionSet;
        String url = ((Attribution[]) set.toArray(new Attribution[set.size()]))[i].getUrl();
        if (url.contains(MAP_FEEDBACK_URL_OLD) || url.contains(MAP_FEEDBACK_URL)) {
            url = buildMapFeedbackMapUrl(Mapbox.getAccessToken());
        }
        showWebPage(url);
    }

    String buildMapFeedbackMapUrl(String str) {
        Uri.Builder buildUpon = Uri.parse(MAP_FEEDBACK_URL).buildUpon();
        CameraPosition cameraPosition = this.mapboxMap.getCameraPosition();
        if (cameraPosition != null) {
            buildUpon.encodedFragment(String.format(Locale.getDefault(), MAP_FEEDBACK_URL_LOCATION_FRAGMENT_FORMAT, Double.valueOf(cameraPosition.target.getLongitude()), Double.valueOf(cameraPosition.target.getLatitude()), Double.valueOf(cameraPosition.zoom), Double.valueOf(cameraPosition.bearing), Integer.valueOf((int) cameraPosition.tilt)));
        }
        String packageName = this.context.getApplicationContext().getPackageName();
        if (packageName != null) {
            buildUpon.appendQueryParameter("referrer", packageName);
        }
        if (str != null) {
            buildUpon.appendQueryParameter("access_token", str);
        }
        Style style = this.mapboxMap.getStyle();
        if (style != null) {
            Matcher matcher = Pattern.compile(MAP_FEEDBACK_STYLE_URI_REGEX).matcher(style.getUri());
            if (matcher.find()) {
                buildUpon.appendQueryParameter("owner", matcher.group(2)).appendQueryParameter(TtmlNode.ATTR_ID, matcher.group(3));
            }
        }
        return buildUpon.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebPage(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.context, R.string.mapbox_attributionErrorNoBrowser, 1).show();
            MapStrictMode.strictModeViolation(e);
        }
    }

    private static class AttributionBuilder {
        private final WeakReference<Context> context;
        private final MapboxMap mapboxMap;

        AttributionBuilder(MapboxMap mapboxMap, Context context) {
            this.mapboxMap = mapboxMap;
            this.context = new WeakReference<>(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Set<Attribution> build() {
            Context context = this.context.get();
            if (context == null) {
                return Collections.emptySet();
            }
            ArrayList arrayList = new ArrayList();
            Style style = this.mapboxMap.getStyle();
            if (style != null) {
                Iterator<Source> it = style.getSources().iterator();
                while (it.hasNext()) {
                    String attribution = it.next().getAttribution();
                    if (!attribution.isEmpty()) {
                        arrayList.add(attribution);
                    }
                }
            }
            return new AttributionParser.Options(context).withCopyrightSign(true).withImproveMap(true).withTelemetryAttribution(true).withAttributionData((String[]) arrayList.toArray(new String[arrayList.size()])).build().getAttributions();
        }
    }
}
