package com.google.android.exoplayer2.source.mediaparser;

import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* loaded from: classes.dex */
public final class OutputConsumerAdapterV30 implements MediaParser.OutputConsumer {
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS = "chunk-index-long-us-durations";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS = "chunk-index-long-offsets";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES = "chunk-index-int-sizes";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES = "chunk-index-long-us-times";
    private static final String MEDIA_FORMAT_KEY_TRACK_TYPE = "track-type-string";
    private static final String TAG = "OutputConsumerAdapterV30";
    private String containerMimeType;
    private MediaParser.SeekMap dummySeekMap;
    private final boolean expectDummySeekMap;
    private ExtractorOutput extractorOutput;
    private ChunkIndex lastChunkIndex;
    private final ArrayList<TrackOutput.CryptoData> lastOutputCryptoDatas;
    private final ArrayList<MediaCodec.CryptoInfo> lastReceivedCryptoInfos;
    private MediaParser.SeekMap lastSeekMap;
    private List<Format> muxedCaptionFormats;
    private int primaryTrackIndex;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private long sampleTimestampUpperLimitFilterUs;
    private final DataReaderAdapter scratchDataReaderAdapter;
    private boolean seekingDisabled;
    private TimestampAdjuster timestampAdjuster;
    private final ArrayList<Format> trackFormats;
    private final ArrayList<TrackOutput> trackOutputs;
    private boolean tracksEnded;
    private boolean tracksFoundCalled;
    private static final Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> SEEK_POINT_PAIR_START = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);
    private static final Pattern REGEX_CRYPTO_INFO_PATTERN = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");

    public OutputConsumerAdapterV30() {
        this(null, 7, false);
    }

    public OutputConsumerAdapterV30(Format format, int i, boolean z) {
        this.expectDummySeekMap = z;
        this.primaryTrackManifestFormat = format;
        this.primaryTrackType = i;
        this.trackOutputs = new ArrayList<>();
        this.trackFormats = new ArrayList<>();
        this.lastReceivedCryptoInfos = new ArrayList<>();
        this.lastOutputCryptoDatas = new ArrayList<>();
        this.scratchDataReaderAdapter = new DataReaderAdapter();
        this.extractorOutput = new DummyExtractorOutput();
        this.sampleTimestampUpperLimitFilterUs = C.TIME_UNSET;
        this.muxedCaptionFormats = ImmutableList.of();
    }

    public void setSampleTimestampUpperLimitFilterUs(long j) {
        this.sampleTimestampUpperLimitFilterUs = j;
    }

    public void setTimestampAdjuster(TimestampAdjuster timestampAdjuster) {
        this.timestampAdjuster = timestampAdjuster;
    }

    public void setExtractorOutput(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    public void setMuxedCaptionFormats(List<Format> list) {
        this.muxedCaptionFormats = list;
    }

    public void disableSeeking() {
        this.seekingDisabled = true;
    }

    public MediaParser.SeekMap getDummySeekMap() {
        return this.dummySeekMap;
    }

    public ChunkIndex getChunkIndex() {
        return this.lastChunkIndex;
    }

    public Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> getSeekPoints(long j) {
        MediaParser.SeekMap seekMap = this.lastSeekMap;
        return seekMap != null ? seekMap.getSeekPoints(j) : SEEK_POINT_PAIR_START;
    }

    public void setSelectedParserName(String str) {
        this.containerMimeType = getMimeType(str);
    }

    public Format[] getSampleFormats() {
        if (!this.tracksFoundCalled) {
            return null;
        }
        Format[] formatArr = new Format[this.trackFormats.size()];
        for (int i = 0; i < this.trackFormats.size(); i++) {
            formatArr[i] = (Format) Assertions.checkNotNull(this.trackFormats.get(i));
        }
        return formatArr;
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onTrackCountFound(int i) {
        this.tracksFoundCalled = true;
        maybeEndTracks();
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        SeekMap seekMapAdapter;
        if (this.expectDummySeekMap && this.dummySeekMap == null) {
            this.dummySeekMap = seekMap;
            return;
        }
        this.lastSeekMap = seekMap;
        long durationMicros = seekMap.getDurationMicros();
        ExtractorOutput extractorOutput = this.extractorOutput;
        if (this.seekingDisabled) {
            if (durationMicros == -2147483648L) {
                durationMicros = C.TIME_UNSET;
            }
            seekMapAdapter = new SeekMap.Unseekable(durationMicros);
        } else {
            seekMapAdapter = new SeekMapAdapter(seekMap);
        }
        extractorOutput.seekMap(seekMapAdapter);
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onTrackDataFound(int i, MediaParser.TrackData trackData) {
        if (maybeObtainChunkIndex(trackData.mediaFormat)) {
            return;
        }
        ensureSpaceForTrackIndex(i);
        TrackOutput trackOutput = this.trackOutputs.get(i);
        if (trackOutput == null) {
            String string = trackData.mediaFormat.getString(MEDIA_FORMAT_KEY_TRACK_TYPE);
            int trackTypeConstant = toTrackTypeConstant(string != null ? string : trackData.mediaFormat.getString(IMediaFormat.KEY_MIME));
            if (trackTypeConstant == this.primaryTrackType) {
                this.primaryTrackIndex = i;
            }
            TrackOutput track = this.extractorOutput.track(i, trackTypeConstant);
            this.trackOutputs.set(i, track);
            if (string != null) {
                return;
            } else {
                trackOutput = track;
            }
        }
        Format exoPlayerFormat = toExoPlayerFormat(trackData);
        Format format = this.primaryTrackManifestFormat;
        trackOutput.format((format == null || i != this.primaryTrackIndex) ? exoPlayerFormat : exoPlayerFormat.withManifestFormatInfo(format));
        this.trackFormats.set(i, exoPlayerFormat);
        maybeEndTracks();
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSampleDataFound(int i, MediaParser.InputReader inputReader) throws IOException {
        ensureSpaceForTrackIndex(i);
        this.scratchDataReaderAdapter.input = inputReader;
        TrackOutput trackOutput = this.trackOutputs.get(i);
        if (trackOutput == null) {
            trackOutput = this.extractorOutput.track(i, -1);
            this.trackOutputs.set(i, trackOutput);
        }
        trackOutput.sampleData((DataReader) this.scratchDataReaderAdapter, (int) inputReader.getLength(), true);
    }

    @Override // android.media.MediaParser.OutputConsumer
    public void onSampleCompleted(int i, long j, int i2, int i3, int i4, MediaCodec.CryptoInfo cryptoInfo) {
        long j2 = this.sampleTimestampUpperLimitFilterUs;
        if (j2 == C.TIME_UNSET || j < j2) {
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster != null) {
                j = timestampAdjuster.adjustSampleTimestamp(j);
            }
            ((TrackOutput) Assertions.checkNotNull(this.trackOutputs.get(i))).sampleMetadata(j, i2, i3, i4, toExoPlayerCryptoData(i, cryptoInfo));
        }
    }

    private boolean maybeObtainChunkIndex(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES);
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer asIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer asLongBuffer = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS))).asLongBuffer();
        LongBuffer asLongBuffer2 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS))).asLongBuffer();
        LongBuffer asLongBuffer3 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES))).asLongBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        long[] jArr = new long[asLongBuffer.remaining()];
        long[] jArr2 = new long[asLongBuffer2.remaining()];
        long[] jArr3 = new long[asLongBuffer3.remaining()];
        asIntBuffer.get(iArr);
        asLongBuffer.get(jArr);
        asLongBuffer2.get(jArr2);
        asLongBuffer3.get(jArr3);
        ChunkIndex chunkIndex = new ChunkIndex(iArr, jArr, jArr2, jArr3);
        this.lastChunkIndex = chunkIndex;
        this.extractorOutput.seekMap(chunkIndex);
        return true;
    }

    private void ensureSpaceForTrackIndex(int i) {
        for (int size = this.trackOutputs.size(); size <= i; size++) {
            this.trackOutputs.add(null);
            this.trackFormats.add(null);
            this.lastReceivedCryptoInfos.add(null);
            this.lastOutputCryptoDatas.add(null);
        }
    }

    private TrackOutput.CryptoData toExoPlayerCryptoData(int i, MediaCodec.CryptoInfo cryptoInfo) {
        int i2;
        if (cryptoInfo == null) {
            return null;
        }
        if (this.lastReceivedCryptoInfos.get(i) == cryptoInfo) {
            return (TrackOutput.CryptoData) Assertions.checkNotNull(this.lastOutputCryptoDatas.get(i));
        }
        int i3 = 0;
        try {
            Matcher matcher = REGEX_CRYPTO_INFO_PATTERN.matcher(cryptoInfo.toString());
            matcher.find();
            int parseInt = Integer.parseInt((String) Util.castNonNull(matcher.group(1)));
            i2 = Integer.parseInt((String) Util.castNonNull(matcher.group(2)));
            i3 = parseInt;
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(cryptoInfo);
            Log.e(TAG, new StringBuilder(String.valueOf(valueOf).length() + 43).append("Unexpected error while parsing CryptoInfo: ").append(valueOf).toString(), e);
            i2 = 0;
        }
        TrackOutput.CryptoData cryptoData = new TrackOutput.CryptoData(cryptoInfo.mode, cryptoInfo.key, i3, i2);
        this.lastReceivedCryptoInfos.set(i, cryptoInfo);
        this.lastOutputCryptoDatas.set(i, cryptoData);
        return cryptoData;
    }

    private void maybeEndTracks() {
        if (!this.tracksFoundCalled || this.tracksEnded) {
            return;
        }
        int size = this.trackOutputs.size();
        for (int i = 0; i < size; i++) {
            if (this.trackOutputs.get(i) == null) {
                return;
            }
        }
        this.extractorOutput.endTracks();
        this.tracksEnded = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int toTrackTypeConstant(String str) {
        char c;
        if (str == null) {
            return -1;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -450004177:
                if (str.equals(TtmlNode.TAG_METADATA)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3556653:
                if (str.equals("text")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 93166550:
                if (str.equals("audio")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 5;
            case 1:
                return -1;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                return MimeTypes.getTrackType(str);
        }
    }

    private Format toExoPlayerFormat(MediaParser.TrackData trackData) {
        MediaFormat mediaFormat = trackData.mediaFormat;
        String string = mediaFormat.getString(IMediaFormat.KEY_MIME);
        int integer = mediaFormat.getInteger("caption-service-number", -1);
        int i = 0;
        Format.Builder accessibilityChannel = new Format.Builder().setDrmInitData(toExoPlayerDrmInitData(mediaFormat.getString("crypto-mode-fourcc"), trackData.drmInitData)).setContainerMimeType(this.containerMimeType).setPeakBitrate(mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE, -1)).setChannelCount(mediaFormat.getInteger("channel-count", -1)).setColorInfo(getColorInfo(mediaFormat)).setSampleMimeType(string).setCodecs(mediaFormat.getString("codecs-string")).setFrameRate(mediaFormat.getFloat("frame-rate", -1.0f)).setWidth(mediaFormat.getInteger("width", -1)).setHeight(mediaFormat.getInteger("height", -1)).setInitializationData(getInitializationData(mediaFormat)).setLanguage(mediaFormat.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE)).setMaxInputSize(mediaFormat.getInteger("max-input-size", -1)).setPcmEncoding(mediaFormat.getInteger("exo-pcm-encoding", -1)).setRotationDegrees(mediaFormat.getInteger("rotation-degrees", 0)).setSampleRate(mediaFormat.getInteger("sample-rate", -1)).setSelectionFlags(getSelectionFlags(mediaFormat)).setEncoderDelay(mediaFormat.getInteger("encoder-delay", 0)).setEncoderPadding(mediaFormat.getInteger("encoder-padding", 0)).setPixelWidthHeightRatio(mediaFormat.getFloat("pixel-width-height-ratio-float", 1.0f)).setSubsampleOffsetUs(mediaFormat.getLong("subsample-offset-us-long", Long.MAX_VALUE)).setAccessibilityChannel(integer);
        while (true) {
            if (i >= this.muxedCaptionFormats.size()) {
                break;
            }
            Format format = this.muxedCaptionFormats.get(i);
            if (Util.areEqual(format.sampleMimeType, string) && format.accessibilityChannel == integer) {
                accessibilityChannel.setLanguage(format.language).setRoleFlags(format.roleFlags).setSelectionFlags(format.selectionFlags).setLabel(format.label).setMetadata(format.metadata);
                break;
            }
            i++;
        }
        return accessibilityChannel.build();
    }

    private static DrmInitData toExoPlayerDrmInitData(String str, android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int schemeInitDataCount = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[schemeInitDataCount];
        for (int i = 0; i < schemeInitDataCount; i++) {
            DrmInitData.SchemeInitData schemeInitDataAt = drmInitData.getSchemeInitDataAt(i);
            schemeDataArr[i] = new DrmInitData.SchemeData(schemeInitDataAt.uuid, schemeInitDataAt.mimeType, schemeInitDataAt.data);
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str, schemeDataArr);
    }

    private static int getSelectionFlags(MediaFormat mediaFormat) {
        return getFlag(mediaFormat, "is-forced-subtitle", 2) | getFlag(mediaFormat, "is-autoselect", 4) | 0 | getFlag(mediaFormat, "is-default", 1);
    }

    private static int getFlag(MediaFormat mediaFormat, String str, int i) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i;
        }
        return 0;
    }

    private static List<byte[]> getInitializationData(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i + 1;
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(new StringBuilder(15).append("csd-").append(i).toString());
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(getArray(byteBuffer));
            i = i2;
        }
    }

    private static ColorInfo getColorInfo(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] array = byteBuffer != null ? getArray(byteBuffer) : null;
        int integer = mediaFormat.getInteger("color-transfer", -1);
        int integer2 = mediaFormat.getInteger("color-range", -1);
        int integer3 = mediaFormat.getInteger("color-standard", -1);
        if (array == null && integer == -1 && integer2 == -1 && integer3 == -1) {
            return null;
        }
        return new ColorInfo(integer3, integer2, integer, array);
    }

    private static byte[] getArray(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    private static String getMimeType(String str) {
        str.hashCode();
        switch (str) {
            case "android.media.mediaparser.Mp4Parser":
            case "android.media.mediaparser.FragmentedMp4Parser":
                return MimeTypes.VIDEO_MP4;
            case "android.media.mediaparser.OggParser":
                return MimeTypes.AUDIO_OGG;
            case "android.media.mediaparser.TsParser":
                return MimeTypes.VIDEO_MP2T;
            case "android.media.mediaparser.AdtsParser":
                return MimeTypes.AUDIO_AAC;
            case "android.media.mediaparser.WavParser":
                return MimeTypes.AUDIO_RAW;
            case "android.media.mediaparser.PsParser":
                return MimeTypes.VIDEO_PS;
            case "android.media.mediaparser.Ac3Parser":
                return MimeTypes.AUDIO_AC3;
            case "android.media.mediaparser.AmrParser":
                return MimeTypes.AUDIO_AMR;
            case "android.media.mediaparser.FlacParser":
                return MimeTypes.AUDIO_FLAC;
            case "android.media.mediaparser.MatroskaParser":
                return MimeTypes.VIDEO_WEBM;
            case "android.media.mediaparser.Ac4Parser":
                return MimeTypes.AUDIO_AC4;
            case "android.media.mediaparser.Mp3Parser":
                return MimeTypes.AUDIO_MPEG;
            case "android.media.mediaparser.FlvParser":
                return MimeTypes.VIDEO_FLV;
            default:
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Illegal parser name: ".concat(valueOf) : new String("Illegal parser name: "));
        }
    }

    private static final class SeekMapAdapter implements SeekMap {
        private final MediaParser.SeekMap adaptedSeekMap;

        public SeekMapAdapter(MediaParser.SeekMap seekMap) {
            this.adaptedSeekMap = seekMap;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return this.adaptedSeekMap.isSeekable();
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            long durationMicros = this.adaptedSeekMap.getDurationMicros();
            return durationMicros != -2147483648L ? durationMicros : C.TIME_UNSET;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j) {
            Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> seekPoints = this.adaptedSeekMap.getSeekPoints(j);
            if (seekPoints.first == seekPoints.second) {
                return new SeekMap.SeekPoints(asExoPlayerSeekPoint((MediaParser.SeekPoint) seekPoints.first));
            }
            return new SeekMap.SeekPoints(asExoPlayerSeekPoint((MediaParser.SeekPoint) seekPoints.first), asExoPlayerSeekPoint((MediaParser.SeekPoint) seekPoints.second));
        }

        private static SeekPoint asExoPlayerSeekPoint(MediaParser.SeekPoint seekPoint) {
            return new SeekPoint(seekPoint.timeMicros, seekPoint.position);
        }
    }

    private static final class DataReaderAdapter implements DataReader {
        public MediaParser.InputReader input;

        private DataReaderAdapter() {
        }

        @Override // com.google.android.exoplayer2.upstream.DataReader, com.google.android.exoplayer2.upstream.HttpDataSource
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return ((MediaParser.InputReader) Util.castNonNull(this.input)).read(bArr, i, i2);
        }
    }
}
