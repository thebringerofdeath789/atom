package com.ipotensic.kernel.manager;

import com.ipotensic.baselib.DDLog;
import com.logan.flight.data.recv.FlightRevGpsTestData;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class TestGpsProductionCache {
    private static final int CACHE_NUM = 300;
    private static long UPLOAD_TIME = 30000;
    private OnCacheListener cacheListener;
    private long startTime = 0;
    private final ConcurrentLinkedQueue<FlightRevGpsTestData> dataQueue = new ConcurrentLinkedQueue<>();

    public interface OnCacheListener {
        void cacheRemainTime(int i);

        void calRealtime(long j, int i, float f, float f2);

        void calResult(long j, int i, float f, float f2);

        void longTimeGpsNotOpen();
    }

    public TestGpsProductionCache(long j, OnCacheListener onCacheListener) {
        UPLOAD_TIME = j;
        this.cacheListener = onCacheListener;
    }

    public void onRevGpsData(FlightRevGpsTestData flightRevGpsTestData) {
        if (flightRevGpsTestData != null) {
            try {
                if (flightRevGpsTestData.isGpsReady()) {
                    FlightRevGpsTestData m27clone = flightRevGpsTestData.m27clone();
                    while (this.dataQueue.size() > 300) {
                        this.dataQueue.poll();
                    }
                    if (this.dataQueue.size() == 300) {
                        this.dataQueue.poll();
                        this.dataQueue.offer(m27clone);
                        long currentTimeMillis = System.currentTimeMillis();
                        float average = getAverage();
                        float variance = getVariance();
                        int gpsNum = flightRevGpsTestData.getGpsNum();
                        long timeStamp = m27clone.getTimeStamp();
                        OnCacheListener onCacheListener = this.cacheListener;
                        if (onCacheListener != null) {
                            onCacheListener.calRealtime(timeStamp, gpsNum, average, variance);
                        }
                        long j = this.startTime;
                        if (j == 0 || currentTimeMillis - j >= UPLOAD_TIME) {
                            this.startTime = currentTimeMillis;
                            OnCacheListener onCacheListener2 = this.cacheListener;
                            if (onCacheListener2 != null) {
                                onCacheListener2.calResult(timeStamp, gpsNum, average, variance);
                            }
                        }
                    }
                    if (this.dataQueue.size() < 300) {
                        this.dataQueue.offer(m27clone);
                        int size = 300 - this.dataQueue.size();
                        OnCacheListener onCacheListener3 = this.cacheListener;
                        if (onCacheListener3 != null) {
                            onCacheListener3.cacheRemainTime(size / 10);
                        }
                    }
                }
            } catch (Exception e) {
                DDLog.e("\u7f13\u5b58\u5931\u8d25:" + e.getMessage());
            }
        }
    }

    private float getAverage() {
        Iterator<FlightRevGpsTestData> it = this.dataQueue.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f += it.next().getGps_sacc();
        }
        return f / 300.0f;
    }

    public float getVariance() {
        int size = this.dataQueue.size();
        float average = getAverage();
        Iterator<FlightRevGpsTestData> it = this.dataQueue.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            FlightRevGpsTestData next = it.next();
            f += (next.getGps_sacc() - average) * (next.getGps_sacc() - average);
        }
        return (float) Math.sqrt(f / size);
    }
}