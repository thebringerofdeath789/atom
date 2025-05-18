package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    private static final int COUNTRY_GROUP_INDEX_2G = 1;
    private static final int COUNTRY_GROUP_INDEX_3G = 2;
    private static final int COUNTRY_GROUP_INDEX_4G = 3;
    private static final int COUNTRY_GROUP_INDEX_5G_NSA = 4;
    private static final int COUNTRY_GROUP_INDEX_5G_SA = 5;
    private static final int COUNTRY_GROUP_INDEX_WIFI = 0;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private static DefaultBandwidthMeter singletonInstance;
    private long bitrateEstimate;
    private final Clock clock;
    private final BandwidthMeter.EventListener.EventDispatcher eventDispatcher;
    private final ImmutableMap<Integer, Long> initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private final boolean resetOnNetworkTypeChange;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;
    public static final ImmutableListMultimap<String, Integer> DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = createInitialBitrateCountryGroupAssignment();
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.m1546of(6200000L, 3900000L, 2300000L, 1300000L, 620000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.m1546of(248000L, 160000L, 142000L, 127000L, 113000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.m1546of(2200000L, 1300000L, 950000L, 760000L, 520000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.m1546of(4400000L, 2300000L, 1500000L, 1100000L, 640000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.m1546of(10000000L, 7200000L, 5000000L, 2700000L, 1600000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA = ImmutableList.m1546of(2600000L, 2200000L, 2000000L, 1500000L, 470000L);

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public TransferListener getTransferListener() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    public static final class Builder {
        private Clock clock;
        private final Context context;
        private Map<Integer, Long> initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context) {
            this.context = context == null ? null : context.getApplicationContext();
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.getCountryCode(context));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        public Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j) {
            Iterator<Integer> it = this.initialBitrateEstimates.keySet().iterator();
            while (it.hasNext()) {
                setInitialBitrateEstimate(it.next().intValue(), j);
            }
            return this;
        }

        public Builder setInitialBitrateEstimate(int i, long j) {
            this.initialBitrateEstimates.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Ascii.toUpperCase(str));
            return this;
        }

        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.resetOnNetworkTypeChange = z;
            return this;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange);
        }

        private static Map<Integer, Long> getInitialBitrateEstimatesForCountry(String str) {
            ImmutableList<Integer> countryGroupIndices = getCountryGroupIndices(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            hashMap.put(2, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI.get(countryGroupIndices.get(0).intValue()));
            hashMap.put(3, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(countryGroupIndices.get(1).intValue()));
            hashMap.put(4, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(countryGroupIndices.get(2).intValue()));
            hashMap.put(5, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(countryGroupIndices.get(3).intValue()));
            hashMap.put(10, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(countryGroupIndices.get(4).intValue()));
            hashMap.put(9, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA.get(countryGroupIndices.get(5).intValue()));
            hashMap.put(7, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI.get(countryGroupIndices.get(0).intValue()));
            return hashMap;
        }

        private static ImmutableList<Integer> getCountryGroupIndices(String str) {
            ImmutableList<Integer> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.get((ImmutableListMultimap<String, Integer>) str);
            return immutableList.isEmpty() ? ImmutableList.m1547of(2, 2, 2, 2, 2, 2) : immutableList;
        }
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context) {
        DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (DefaultBandwidthMeter.class) {
            if (singletonInstance == null) {
                singletonInstance = new Builder(context).build();
            }
            defaultBandwidthMeter = singletonInstance;
        }
        return defaultBandwidthMeter;
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, ImmutableMap.m1560of(), 2000, Clock.DEFAULT, false);
    }

    private DefaultBandwidthMeter(Context context, Map<Integer, Long> map, int i, Clock clock, boolean z) {
        this.initialBitrateEstimates = ImmutableMap.copyOf((Map) map);
        this.eventDispatcher = new BandwidthMeter.EventListener.EventDispatcher();
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock;
        this.resetOnNetworkTypeChange = z;
        if (context != null) {
            NetworkTypeObserver networkTypeObserver = NetworkTypeObserver.getInstance(context);
            int networkType = networkTypeObserver.getNetworkType();
            this.networkType = networkType;
            this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType);
            networkTypeObserver.register(new NetworkTypeObserver.Listener() { // from class: com.google.android.exoplayer2.upstream.-$$Lambda$DefaultBandwidthMeter$n4HgtxeYBFNUETYzdzpx6UkOs7c
                @Override // com.google.android.exoplayer2.util.NetworkTypeObserver.Listener
                public final void onNetworkTypeChanged(int i2) {
                    DefaultBandwidthMeter.this.onNetworkTypeChanged(i2);
                }
            });
            return;
        }
        this.networkType = 0;
        this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(0);
    }

    public synchronized void setNetworkTypeOverride(int i) {
        this.networkTypeOverride = i;
        this.networkTypeOverrideSet = true;
        onNetworkTypeChanged(i);
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.eventDispatcher.addListener(handler, eventListener);
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            this.sampleBytesTransferred += i;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            Assertions.checkState(this.streamCount > 0);
            long elapsedRealtime = this.clock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += i;
            long j = this.totalBytesTransferred;
            long j2 = this.sampleBytesTransferred;
            this.totalBytesTransferred = j + j2;
            if (i > 0) {
                this.slidingPercentile.addSample((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.totalElapsedTimeMs >= SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                }
                maybeNotifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = elapsedRealtime;
                this.sampleBytesTransferred = 0L;
            }
            this.streamCount--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onNetworkTypeChanged(int i) {
        int i2 = this.networkType;
        if (i2 == 0 || this.resetOnNetworkTypeChange) {
            if (this.networkTypeOverrideSet) {
                i = this.networkTypeOverride;
            }
            if (i2 == i) {
                return;
            }
            this.networkType = i;
            if (i != 1 && i != 0 && i != 8) {
                this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(i);
                long elapsedRealtime = this.clock.elapsedRealtime();
                maybeNotifyBandwidthSample(this.streamCount > 0 ? (int) (elapsedRealtime - this.sampleStartTimeMs) : 0, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = elapsedRealtime;
                this.sampleBytesTransferred = 0L;
                this.totalBytesTransferred = 0L;
                this.totalElapsedTimeMs = 0L;
                this.slidingPercentile.reset();
            }
        }
    }

    private void maybeNotifyBandwidthSample(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.lastReportedBitrateEstimate) {
            return;
        }
        this.lastReportedBitrateEstimate = j2;
        this.eventDispatcher.bandwidthSample(i, j, j2);
    }

    private long getInitialBitrateEstimateForNetworkType(int i) {
        Long l = this.initialBitrateEstimates.get(Integer.valueOf(i));
        if (l == null) {
            l = this.initialBitrateEstimates.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    private static ImmutableListMultimap<String, Integer> createInitialBitrateCountryGroupAssignment() {
        return ImmutableListMultimap.builder().putAll((ImmutableListMultimap.Builder) "AD", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "AE", (Object[]) new Integer[]{1, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "AF", (Object[]) new Integer[]{4, 4, 3, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "AG", (Object[]) new Integer[]{4, 2, 1, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "AI", (Object[]) new Integer[]{1, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "AL", (Object[]) new Integer[]{1, 1, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "AM", (Object[]) new Integer[]{2, 2, 1, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "AO", (Object[]) new Integer[]{3, 4, 3, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "AR", (Object[]) new Integer[]{2, 4, 2, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "AS", (Object[]) new Integer[]{2, 2, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "AT", (Object[]) new Integer[]{0, 1, 0, 0, 0, 2}).putAll((ImmutableListMultimap.Builder) "AU", (Object[]) new Integer[]{0, 2, 0, 1, 1, 2}).putAll((ImmutableListMultimap.Builder) "AW", (Object[]) new Integer[]{1, 2, 0, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "AX", (Object[]) new Integer[]{0, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "AZ", (Object[]) new Integer[]{3, 3, 3, 4, 4, 2}).putAll((ImmutableListMultimap.Builder) "BA", (Object[]) new Integer[]{1, 1, 0, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "BB", (Object[]) new Integer[]{0, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "BD", (Object[]) new Integer[]{2, 0, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "BE", (Object[]) new Integer[]{0, 0, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "BF", (Object[]) new Integer[]{4, 4, 4, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "BG", (Object[]) new Integer[]{0, 1, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "BH", (Object[]) new Integer[]{1, 0, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "BI", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "BJ", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "BL", (Object[]) new Integer[]{1, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "BM", (Object[]) new Integer[]{0, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "BN", (Object[]) new Integer[]{3, 2, 1, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "BO", (Object[]) new Integer[]{1, 2, 4, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "BQ", (Object[]) new Integer[]{1, 2, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "BR", (Object[]) new Integer[]{2, 4, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "BS", (Object[]) new Integer[]{2, 2, 1, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "BT", (Object[]) new Integer[]{3, 0, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "BW", (Object[]) new Integer[]{3, 4, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "BY", (Object[]) new Integer[]{1, 1, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "BZ", (Object[]) new Integer[]{2, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "CA", (Object[]) new Integer[]{0, 3, 1, 2, 4, 2}).putAll((ImmutableListMultimap.Builder) "CD", (Object[]) new Integer[]{4, 2, 2, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "CF", (Object[]) new Integer[]{4, 2, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "CG", (Object[]) new Integer[]{3, 4, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "CH", (Object[]) new Integer[]{0, 0, 0, 0, 1, 2}).putAll((ImmutableListMultimap.Builder) "CI", (Object[]) new Integer[]{3, 3, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "CK", (Object[]) new Integer[]{2, 2, 3, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "CL", (Object[]) new Integer[]{1, 1, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "CM", (Object[]) new Integer[]{3, 4, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "CN", (Object[]) new Integer[]{2, 2, 2, 1, 3, 2}).putAll((ImmutableListMultimap.Builder) "CO", (Object[]) new Integer[]{2, 3, 4, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "CR", (Object[]) new Integer[]{2, 3, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "CU", (Object[]) new Integer[]{4, 4, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "CV", (Object[]) new Integer[]{2, 3, 1, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "CW", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "CY", (Object[]) new Integer[]{1, 1, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "CZ", (Object[]) new Integer[]{0, 1, 0, 0, 1, 2}).putAll((ImmutableListMultimap.Builder) "DE", (Object[]) new Integer[]{0, 0, 1, 1, 0, 2}).putAll((ImmutableListMultimap.Builder) "DJ", (Object[]) new Integer[]{4, 0, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "DK", (Object[]) new Integer[]{0, 0, 1, 0, 0, 2}).putAll((ImmutableListMultimap.Builder) "DM", (Object[]) new Integer[]{1, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "DO", (Object[]) new Integer[]{3, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "DZ", (Object[]) new Integer[]{3, 3, 4, 4, 2, 4}).putAll((ImmutableListMultimap.Builder) "EC", (Object[]) new Integer[]{2, 4, 3, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "EE", (Object[]) new Integer[]{0, 1, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "EG", (Object[]) new Integer[]{3, 4, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "EH", (Object[]) new Integer[]{2, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "ER", (Object[]) new Integer[]{4, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "ES", (Object[]) new Integer[]{0, 1, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "ET", (Object[]) new Integer[]{4, 4, 4, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "FI", (Object[]) new Integer[]{0, 0, 0, 0, 0, 2}).putAll((ImmutableListMultimap.Builder) "FJ", (Object[]) new Integer[]{3, 0, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "FK", (Object[]) new Integer[]{4, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "FM", (Object[]) new Integer[]{3, 2, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "FO", (Object[]) new Integer[]{1, 2, 0, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "FR", (Object[]) new Integer[]{1, 1, 2, 0, 1, 2}).putAll((ImmutableListMultimap.Builder) "GA", (Object[]) new Integer[]{3, 4, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "GB", (Object[]) new Integer[]{0, 0, 1, 1, 1, 2}).putAll((ImmutableListMultimap.Builder) "GD", (Object[]) new Integer[]{1, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "GE", (Object[]) new Integer[]{1, 1, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "GF", (Object[]) new Integer[]{2, 2, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "GG", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "GH", (Object[]) new Integer[]{3, 1, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "GI", (Object[]) new Integer[]{0, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "GL", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "GM", (Object[]) new Integer[]{4, 3, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "GN", (Object[]) new Integer[]{4, 3, 4, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "GP", (Object[]) new Integer[]{2, 1, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "GQ", (Object[]) new Integer[]{4, 2, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "GR", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "GT", (Object[]) new Integer[]{3, 2, 3, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "GU", (Object[]) new Integer[]{1, 2, 3, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "GW", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "GY", (Object[]) new Integer[]{3, 3, 3, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "HK", (Object[]) new Integer[]{0, 1, 2, 3, 2, 0}).putAll((ImmutableListMultimap.Builder) "HN", (Object[]) new Integer[]{3, 1, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "HR", (Object[]) new Integer[]{1, 1, 0, 0, 3, 2}).putAll((ImmutableListMultimap.Builder) "HT", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "HU", (Object[]) new Integer[]{0, 0, 0, 0, 0, 2}).putAll((ImmutableListMultimap.Builder) "ID", (Object[]) new Integer[]{3, 2, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "IE", (Object[]) new Integer[]{0, 0, 1, 1, 3, 2}).putAll((ImmutableListMultimap.Builder) "IL", (Object[]) new Integer[]{1, 0, 2, 3, 4, 2}).putAll((ImmutableListMultimap.Builder) "IM", (Object[]) new Integer[]{0, 2, 0, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "IN", (Object[]) new Integer[]{2, 1, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "IO", (Object[]) new Integer[]{4, 2, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "IQ", (Object[]) new Integer[]{3, 3, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "IR", (Object[]) new Integer[]{3, 2, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "IS", (Object[]) new Integer[]{0, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "IT", (Object[]) new Integer[]{0, 4, 0, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "JE", (Object[]) new Integer[]{2, 2, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "JM", (Object[]) new Integer[]{3, 3, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "JO", (Object[]) new Integer[]{2, 2, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "JP", (Object[]) new Integer[]{0, 0, 0, 0, 2, 1}).putAll((ImmutableListMultimap.Builder) "KE", (Object[]) new Integer[]{3, 4, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) ExpandedProductParsedResult.KILOGRAM, (Object[]) new Integer[]{2, 0, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "KH", (Object[]) new Integer[]{1, 0, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "KI", (Object[]) new Integer[]{4, 2, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "KM", (Object[]) new Integer[]{4, 3, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "KN", (Object[]) new Integer[]{1, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "KP", (Object[]) new Integer[]{4, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "KR", (Object[]) new Integer[]{0, 0, 1, 3, 1, 2}).putAll((ImmutableListMultimap.Builder) "KW", (Object[]) new Integer[]{1, 3, 1, 1, 1, 2}).putAll((ImmutableListMultimap.Builder) "KY", (Object[]) new Integer[]{1, 2, 0, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "KZ", (Object[]) new Integer[]{2, 2, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "LA", (Object[]) new Integer[]{1, 2, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) ExpandedProductParsedResult.POUND, (Object[]) new Integer[]{3, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "LC", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "LI", (Object[]) new Integer[]{0, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "LK", (Object[]) new Integer[]{2, 0, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "LR", (Object[]) new Integer[]{3, 4, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "LS", (Object[]) new Integer[]{3, 3, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "LT", (Object[]) new Integer[]{0, 0, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "LU", (Object[]) new Integer[]{1, 0, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "LV", (Object[]) new Integer[]{0, 0, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "LY", (Object[]) new Integer[]{4, 2, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "MA", (Object[]) new Integer[]{3, 2, 2, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "MC", (Object[]) new Integer[]{0, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "MD", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "ME", (Object[]) new Integer[]{1, 2, 0, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "MF", (Object[]) new Integer[]{2, 2, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "MG", (Object[]) new Integer[]{3, 4, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "MH", (Object[]) new Integer[]{4, 2, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "MK", (Object[]) new Integer[]{1, 1, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "ML", (Object[]) new Integer[]{4, 4, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "MM", (Object[]) new Integer[]{2, 3, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "MN", (Object[]) new Integer[]{2, 4, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "MO", (Object[]) new Integer[]{0, 2, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "MP", (Object[]) new Integer[]{0, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "MQ", (Object[]) new Integer[]{2, 2, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "MR", (Object[]) new Integer[]{3, 0, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "MS", (Object[]) new Integer[]{1, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "MT", (Object[]) new Integer[]{0, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "MU", (Object[]) new Integer[]{2, 1, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "MV", (Object[]) new Integer[]{4, 3, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "MW", (Object[]) new Integer[]{4, 2, 1, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "MX", (Object[]) new Integer[]{2, 4, 4, 4, 4, 2}).putAll((ImmutableListMultimap.Builder) "MY", (Object[]) new Integer[]{1, 0, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "MZ", (Object[]) new Integer[]{3, 3, 2, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "NA", (Object[]) new Integer[]{4, 3, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "NC", (Object[]) new Integer[]{3, 0, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "NE", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "NF", (Object[]) new Integer[]{2, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "NG", (Object[]) new Integer[]{3, 3, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "NI", (Object[]) new Integer[]{2, 1, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "NL", (Object[]) new Integer[]{0, 2, 3, 2, 0, 2}).putAll((ImmutableListMultimap.Builder) "NO", (Object[]) new Integer[]{0, 1, 2, 0, 0, 2}).putAll((ImmutableListMultimap.Builder) "NP", (Object[]) new Integer[]{2, 0, 4, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "NR", (Object[]) new Integer[]{3, 2, 3, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "NU", (Object[]) new Integer[]{4, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "NZ", (Object[]) new Integer[]{0, 2, 1, 2, 4, 2}).putAll((ImmutableListMultimap.Builder) "OM", (Object[]) new Integer[]{2, 2, 1, 3, 3, 2}).putAll((ImmutableListMultimap.Builder) "PA", (Object[]) new Integer[]{1, 3, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "PE", (Object[]) new Integer[]{2, 3, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "PF", (Object[]) new Integer[]{2, 2, 2, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "PG", (Object[]) new Integer[]{4, 4, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "PH", (Object[]) new Integer[]{2, 1, 3, 3, 3, 2}).putAll((ImmutableListMultimap.Builder) "PK", (Object[]) new Integer[]{3, 2, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "PL", (Object[]) new Integer[]{1, 0, 1, 2, 3, 2}).putAll((ImmutableListMultimap.Builder) "PM", (Object[]) new Integer[]{0, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "PR", (Object[]) new Integer[]{2, 1, 2, 2, 4, 3}).putAll((ImmutableListMultimap.Builder) "PS", (Object[]) new Integer[]{3, 3, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "PT", (Object[]) new Integer[]{0, 1, 1, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "PW", (Object[]) new Integer[]{1, 2, 4, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "PY", (Object[]) new Integer[]{2, 0, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "QA", (Object[]) new Integer[]{2, 3, 1, 2, 3, 2}).putAll((ImmutableListMultimap.Builder) "RE", (Object[]) new Integer[]{1, 0, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "RO", (Object[]) new Integer[]{0, 1, 0, 1, 0, 2}).putAll((ImmutableListMultimap.Builder) "RS", (Object[]) new Integer[]{1, 2, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "RU", (Object[]) new Integer[]{0, 1, 0, 1, 4, 2}).putAll((ImmutableListMultimap.Builder) "RW", (Object[]) new Integer[]{3, 3, 3, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "SA", (Object[]) new Integer[]{2, 2, 2, 1, 1, 2}).putAll((ImmutableListMultimap.Builder) "SB", (Object[]) new Integer[]{4, 2, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "SC", (Object[]) new Integer[]{4, 2, 1, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "SD", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "SE", (Object[]) new Integer[]{0, 0, 0, 0, 0, 2}).putAll((ImmutableListMultimap.Builder) "SG", (Object[]) new Integer[]{1, 0, 1, 2, 3, 2}).putAll((ImmutableListMultimap.Builder) "SH", (Object[]) new Integer[]{4, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "SI", (Object[]) new Integer[]{0, 0, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "SJ", (Object[]) new Integer[]{2, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "SK", (Object[]) new Integer[]{0, 1, 0, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "SL", (Object[]) new Integer[]{4, 3, 4, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "SM", (Object[]) new Integer[]{0, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "SN", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "SO", (Object[]) new Integer[]{3, 3, 3, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "SR", (Object[]) new Integer[]{3, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "SS", (Object[]) new Integer[]{4, 4, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "ST", (Object[]) new Integer[]{2, 2, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "SV", (Object[]) new Integer[]{2, 1, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "SX", (Object[]) new Integer[]{2, 2, 1, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "SY", (Object[]) new Integer[]{4, 3, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "SZ", (Object[]) new Integer[]{3, 3, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "TC", (Object[]) new Integer[]{2, 2, 2, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "TD", (Object[]) new Integer[]{4, 3, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "TG", (Object[]) new Integer[]{3, 2, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "TH", (Object[]) new Integer[]{0, 3, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "TJ", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "TL", (Object[]) new Integer[]{4, 0, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "TM", (Object[]) new Integer[]{4, 2, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "TN", (Object[]) new Integer[]{2, 1, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "TO", (Object[]) new Integer[]{3, 3, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "TR", (Object[]) new Integer[]{1, 2, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "TT", (Object[]) new Integer[]{1, 4, 0, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "TV", (Object[]) new Integer[]{3, 2, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "TW", (Object[]) new Integer[]{0, 0, 0, 0, 1, 0}).putAll((ImmutableListMultimap.Builder) "TZ", (Object[]) new Integer[]{3, 3, 3, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "UA", (Object[]) new Integer[]{0, 3, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "UG", (Object[]) new Integer[]{3, 2, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "US", (Object[]) new Integer[]{1, 1, 2, 2, 4, 2}).putAll((ImmutableListMultimap.Builder) "UY", (Object[]) new Integer[]{2, 2, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "UZ", (Object[]) new Integer[]{2, 1, 3, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "VC", (Object[]) new Integer[]{1, 2, 2, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "VE", (Object[]) new Integer[]{4, 4, 4, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "VG", (Object[]) new Integer[]{2, 2, 1, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "VI", (Object[]) new Integer[]{1, 2, 1, 2, 2, 2}).putAll((ImmutableListMultimap.Builder) "VN", (Object[]) new Integer[]{0, 1, 3, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "VU", (Object[]) new Integer[]{4, 0, 3, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "WF", (Object[]) new Integer[]{4, 2, 2, 4, 2, 2}).putAll((ImmutableListMultimap.Builder) "WS", (Object[]) new Integer[]{3, 1, 3, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "XK", (Object[]) new Integer[]{0, 1, 1, 0, 2, 2}).putAll((ImmutableListMultimap.Builder) "YE", (Object[]) new Integer[]{4, 4, 4, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "YT", (Object[]) new Integer[]{4, 2, 2, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "ZA", (Object[]) new Integer[]{3, 3, 2, 1, 2, 2}).putAll((ImmutableListMultimap.Builder) "ZM", (Object[]) new Integer[]{3, 2, 3, 3, 2, 2}).putAll((ImmutableListMultimap.Builder) "ZW", (Object[]) new Integer[]{3, 2, 4, 3, 2, 2}).build();
    }
}