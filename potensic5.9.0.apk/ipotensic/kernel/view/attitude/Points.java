package com.ipotensic.kernel.view.attitude;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.ipotensic.baselib.utils.compress.BitmapUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.MapUtil;
import com.ipotensic.kernel.utils.TriangleUtils;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;

/* loaded from: classes2.dex */
public class Points {
    private float bgRadius;
    private Context context;
    private Bitmap flightDisableBitmap;
    private LatLng flightLatLng;
    private Bitmap flightNormalBitmap;
    private Bitmap flightPairBitmap;
    private int height;
    private Bitmap homeBitmap;
    private LatLng homeLatLng;
    private Paint paint;
    private LatLng remoterLatLng;
    private Bitmap remoterNormalBitmap;
    private Bitmap remoterPairBitmap;
    private Paint testPaint;
    private int width;
    private boolean isConnect = false;
    private boolean isPair = false;
    private int remoterRotate = 0;
    private int rotate = 0;
    private Point remoterLocation = new Point();
    private Point homeLocation = new Point();

    public Points(Context context, int i, int i2, float f) {
        this.context = context;
        this.width = i;
        this.height = i2;
        this.bgRadius = f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.testPaint = paint2;
        paint2.setAntiAlias(true);
        this.testPaint.setStyle(Paint.Style.FILL);
        this.testPaint.setColor(context.getResources().getColor(R.color.color_connect_green_transparent));
    }

    private void initBitmap() {
        Bitmap bitmap = this.flightDisableBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            this.flightDisableBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.icon_drone_disable);
        }
        Bitmap bitmap2 = this.flightNormalBitmap;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            this.flightNormalBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.icon_drone_enable_normal);
        }
        Bitmap bitmap3 = this.flightPairBitmap;
        if (bitmap3 == null || bitmap3.isRecycled()) {
            this.flightPairBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.icon_drone_enable_pair);
        }
        Bitmap bitmap4 = this.homeBitmap;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            this.homeBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.img_icon_atti_home);
        }
        Bitmap bitmap5 = this.remoterNormalBitmap;
        if (bitmap5 == null || bitmap5.isRecycled()) {
            this.remoterNormalBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.icon_remoter_point_normal);
        }
        Bitmap bitmap6 = this.remoterPairBitmap;
        if (bitmap6 == null || bitmap6.isRecycled()) {
            this.remoterPairBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.icon_remoter_point_pair);
        }
    }

    public void setConnect(boolean z) {
        this.isConnect = z;
        if (z) {
            return;
        }
        this.rotate = 0;
        this.remoterRotate = 0;
        this.flightLatLng = null;
        this.remoterLatLng = null;
        this.homeLocation = null;
    }

    public void setRotate(int i) {
        this.rotate = i;
    }

    public void setRemoterRotate(int i) {
        this.remoterRotate = i;
    }

    public void setFlightPosition(LatLng latLng) {
        this.flightLatLng = latLng;
        FlightRevHomePointData flightRevHomePointData = FlightRevData.get().getFlightRevHomePointData();
        if (flightRevHomePointData != null) {
            if (flightRevHomePointData.getLat() == 0.0d && flightRevHomePointData.getLng() == 0.0d) {
                return;
            }
            setHomePosition(new LatLng(flightRevHomePointData.getLat(), flightRevHomePointData.getLng()));
        }
    }

    public void setRemoterPosition(LatLng latLng) {
        this.remoterLatLng = latLng;
    }

    public void setHomePosition(LatLng latLng) {
        this.homeLatLng = latLng;
    }

    public void draw(Canvas canvas) throws Exception {
        Bitmap bitmap;
        LatLng latLng;
        double d;
        double d2;
        canvas.rotate(this.rotate, this.width / 2, this.height / 2);
        new Rect();
        Rect rect = new Rect();
        initBitmap();
        if (this.isConnect && (latLng = this.flightLatLng) != null) {
            com.mapbox.geojson.Point fromLngLat = com.mapbox.geojson.Point.fromLngLat(latLng.getLongitude(), this.flightLatLng.getLatitude());
            LatLng latLng2 = this.homeLatLng;
            if (latLng2 != null) {
                com.mapbox.geojson.Point fromLngLat2 = com.mapbox.geojson.Point.fromLngLat(latLng2.getLongitude(), this.homeLatLng.getLatitude());
                double distance = TurfMeasurement.distance(fromLngLat2, fromLngLat, TurfConstants.UNIT_METERS);
                double bearing = TurfMeasurement.bearing(fromLngLat2, fromLngLat);
                if (distance > 40.0d) {
                    d2 = this.bgRadius;
                } else {
                    d2 = (this.bgRadius * distance) / 40.0d;
                }
                Bitmap rotateBitmap = BitmapUtil.rotateBitmap(this.homeBitmap, -this.rotate);
                Rect rect2 = new Rect(0, 0, rotateBitmap.getWidth(), rotateBitmap.getHeight());
                while ((rect2.height() / 2) + d2 > this.width / 2) {
                    d2 -= 1.0d;
                }
                Point point = new Point();
                this.homeLocation = point;
                if (0.0d <= bearing && bearing <= 90.0d) {
                    point.x = (int) ((this.width / 2) - TriangleUtils.getSinALen(bearing, d2));
                    this.homeLocation.y = (int) ((this.height / 2) + TriangleUtils.getCosBLen(bearing, d2));
                } else if (90.0d < bearing && bearing <= 180.0d) {
                    double d3 = bearing - 90.0d;
                    point.x = (int) ((this.width / 2) - TriangleUtils.getCosBLen(d3, d2));
                    this.homeLocation.y = (int) ((this.height / 2) - TriangleUtils.getSinALen(d3, d2));
                } else if (-90.0d <= bearing && bearing < 0.0d) {
                    double d4 = -bearing;
                    point.x = (int) ((this.width / 2) + TriangleUtils.getSinALen(d4, d2));
                    this.homeLocation.y = (int) ((this.height / 2) + TriangleUtils.getCosBLen(d4, d2));
                } else if (-180.0d <= bearing && bearing < -90.0d) {
                    double d5 = (-bearing) - 90.0d;
                    point.x = (int) ((this.width / 2) + TriangleUtils.getCosBLen(d5, d2));
                    this.homeLocation.y = (int) ((this.height / 2) - TriangleUtils.getSinALen(d5, d2));
                }
                Rect rect3 = new Rect(this.homeLocation.x - (rect2.width() / 2), this.homeLocation.y - (rect2.height() / 2), this.homeLocation.x + (rect2.width() / 2), this.homeLocation.y + (rect2.height() / 2));
                canvas.drawBitmap(rotateBitmap, rect2, rect3, this.paint);
                BitmapUtil.recycle(rotateBitmap);
                rect = rect3;
            }
            LatLng latLng3 = this.remoterLatLng;
            if (latLng3 != null) {
                com.mapbox.geojson.Point fromLngLat3 = com.mapbox.geojson.Point.fromLngLat(latLng3.getLongitude(), this.remoterLatLng.getLatitude());
                double distance2 = TurfMeasurement.distance(fromLngLat3, fromLngLat, TurfConstants.UNIT_METERS);
                double bearing2 = TurfMeasurement.bearing(fromLngLat3, fromLngLat);
                if (distance2 > 40.0d) {
                    d = this.bgRadius;
                } else {
                    d = (this.bgRadius * distance2) / 40.0d;
                }
                boolean isPair = MapUtil.isPair(this.remoterLatLng, this.flightLatLng, this.remoterRotate);
                this.isPair = isPair;
                Bitmap rotateBitmap2 = BitmapUtil.rotateBitmap(isPair ? this.remoterPairBitmap : this.remoterNormalBitmap, this.remoterRotate);
                Rect rect4 = new Rect(0, 0, rotateBitmap2.getWidth(), rotateBitmap2.getHeight());
                while ((rect4.height() / 2) + d > this.width / 2) {
                    d -= 1.0d;
                }
                Point point2 = new Point();
                this.remoterLocation = point2;
                if (0.0d <= bearing2 && bearing2 <= 90.0d) {
                    point2.x = (int) ((this.width / 2) - TriangleUtils.getSinALen(bearing2, d));
                    this.remoterLocation.y = (int) ((this.height / 2) + TriangleUtils.getCosBLen(bearing2, d));
                } else if (90.0d < bearing2 && bearing2 <= 180.0d) {
                    double d6 = bearing2 - 90.0d;
                    point2.x = (int) ((this.width / 2) - TriangleUtils.getCosBLen(d6, d));
                    this.remoterLocation.y = (int) ((this.height / 2) - TriangleUtils.getSinALen(d6, d));
                } else if (-90.0d <= bearing2 && bearing2 < 0.0d) {
                    double d7 = -bearing2;
                    point2.x = (int) ((this.width / 2) + TriangleUtils.getSinALen(d7, d));
                    this.remoterLocation.y = (int) ((this.height / 2) + TriangleUtils.getCosBLen(d7, d));
                } else if (-180.0d <= bearing2 && bearing2 < -90.0d) {
                    double d8 = (-bearing2) - 90.0d;
                    point2.x = (int) ((this.width / 2) + TriangleUtils.getCosBLen(d8, d));
                    this.remoterLocation.y = (int) ((this.height / 2) - TriangleUtils.getSinALen(d8, d));
                }
                rect = new Rect(this.remoterLocation.x - (rect4.width() / 2), this.remoterLocation.y - (rect4.height() / 2), this.remoterLocation.x + (rect4.width() / 2), this.remoterLocation.y + (rect4.height() / 2));
                canvas.drawBitmap(rotateBitmap2, rect4, rect, this.paint);
                BitmapUtil.recycle(rotateBitmap2);
            }
        }
        canvas.rotate(-this.rotate, this.width / 2, this.height / 2);
        if (this.isConnect) {
            if (this.isPair) {
                bitmap = this.flightPairBitmap;
            } else {
                bitmap = this.flightNormalBitmap;
            }
        } else {
            bitmap = this.flightDisableBitmap;
        }
        Rect rect5 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = this.width;
        rect.left = (i / 2) - (((i * 40) / 110) / 2);
        int i2 = this.height;
        rect.top = (i2 / 2) - (((i2 * 40) / 110) / 2);
        int i3 = this.width;
        rect.right = (i3 / 2) + (((i3 * 40) / 110) / 2);
        int i4 = this.height;
        rect.bottom = (i4 / 2) + (((i4 * 40) / 110) / 2);
        canvas.drawBitmap(bitmap, rect5, rect, this.paint);
    }

    public void release() {
        BitmapUtil.recycle(this.flightDisableBitmap);
        BitmapUtil.recycle(this.flightNormalBitmap);
        BitmapUtil.recycle(this.flightPairBitmap);
        BitmapUtil.recycle(this.homeBitmap);
        BitmapUtil.recycle(this.remoterNormalBitmap);
        BitmapUtil.recycle(this.remoterPairBitmap);
    }
}