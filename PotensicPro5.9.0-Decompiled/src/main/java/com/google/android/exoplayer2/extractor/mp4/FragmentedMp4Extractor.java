package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Function;
import com.logan.flight.FlightConfig;
import com.logan.usb.UsbCameraHandler;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class FragmentedMp4Extractor implements Extractor {
    private static final int EXTRA_TRACKS_BASE_ID = 100;
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final int SAMPLE_GROUP_TYPE_seig = 1936025959;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] ceaTrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final EventMessageEncoder eventMessageEncoder;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final ParsableByteArray scratch;
    private final byte[] scratchBytes;
    private long segmentIndexEarliestPresentationTimeUs;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FragmentedMp4Extractor.lambda$static$0();
        }
    };
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {FlightConfig.P1_4K, 57, 79, 82, 90, -101, 79, 20, FlightConfig.P1_4K, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 108, 66, 124, 100, -115, -12};
    private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static boolean shouldParseContainerAtom(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    private static boolean shouldParseLeafAtom(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    protected Track modifyTrack(Track track) {
        return track;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FragmentedMp4Extractor()};
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int i) {
        this(i, null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster) {
        this(i, timestampAdjuster, null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster, Track track) {
        this(i, timestampAdjuster, track, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster, Track track, List<Format> list) {
        this(i, timestampAdjuster, track, list, null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster, Track track, List<Format> list, TrackOutput trackOutput) {
        this.flags = i;
        this.timestampAdjuster = timestampAdjuster;
        this.sideloadedTrack = track;
        this.closedCaptionFormats = Collections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.eventMessageEncoder = new EventMessageEncoder();
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.scratchBytes = bArr;
        this.scratch = new ParsableByteArray(bArr);
        this.containerAtoms = new ArrayDeque<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = C.TIME_UNSET;
        this.pendingSeekTimeUs = C.TIME_UNSET;
        this.segmentIndexEarliestPresentationTimeUs = C.TIME_UNSET;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.emsgTrackOutputs = new TrackOutput[0];
        this.ceaTrackOutputs = new TrackOutput[0];
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return Sniffer.sniffFragmented(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        enterReadingAtomHeaderState();
        initExtraTracks();
        if (this.sideloadedTrack != null) {
            this.trackBundles.put(0, new TrackBundle(extractorOutput.track(0, this.sideloadedTrack.type), new TrackSampleTable(this.sideloadedTrack, new long[0], new int[0], 0, new long[0], new int[0], 0L), new DefaultSampleValues(0, 0, 0, 0)));
            this.extractorOutput.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        int size = this.trackBundles.size();
        for (int i = 0; i < size; i++) {
            this.trackBundles.valueAt(i).resetFragmentInfo();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = j2;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i == 1) {
                    readAtomPayload(extractorInput);
                } else if (i == 2) {
                    readEncryptionData(extractorInput);
                } else if (readSample(extractorInput)) {
                    return 0;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.getData(), 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j = this.atomSize;
        if (j == 1) {
            extractorInput.readFully(this.atomHeader.getData(), 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + this.atomHeaderBytesRead;
            }
        }
        if (this.atomSize < this.atomHeaderBytesRead) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        long position = extractorInput.getPosition() - this.atomHeaderBytesRead;
        int i = this.atomType;
        if ((i == 1836019558 || i == 1835295092) && !this.haveOutputSeekMap) {
            this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
            this.haveOutputSeekMap = true;
        }
        if (this.atomType == 1836019558) {
            int size = this.trackBundles.size();
            for (int i2 = 0; i2 < size; i2++) {
                TrackFragment trackFragment = this.trackBundles.valueAt(i2).fragment;
                trackFragment.atomPosition = position;
                trackFragment.auxiliaryDataPosition = position;
                trackFragment.dataPosition = position;
            }
        }
        int i3 = this.atomType;
        if (i3 == 1835295092) {
            this.currentTrackBundle = null;
            this.endOfMdatPosition = position + this.atomSize;
            this.parserState = 2;
            return true;
        }
        if (shouldParseContainerAtom(i3)) {
            long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
            this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position2));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position2);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            if (this.atomHeaderBytesRead != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.atomSize > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
            System.arraycopy(this.atomHeader.getData(), 0, parsableByteArray.getData(), 0, 8);
            this.atomData = parsableByteArray;
            this.parserState = 1;
        } else {
            if (this.atomSize > 2147483647L) {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException {
        int i = ((int) this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.getData(), 8, i);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void processAtomEnded(long j) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
            return;
        }
        if (leafAtom.type == 1936286840) {
            Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) parseSidx.second);
            this.haveOutputSeekMap = true;
            return;
        }
        if (leafAtom.type == 1701671783) {
            onEmsgLeafAtomRead(leafAtom.data);
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        if (containerAtom.type == 1836019574) {
            onMoovContainerAtomRead(containerAtom);
        } else if (containerAtom.type == 1836019558) {
            onMoofContainerAtomRead(containerAtom);
        } else {
            if (this.containerAtoms.isEmpty()) {
                return;
            }
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        int i = 0;
        Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(Atom.TYPE_mvex));
        SparseArray<DefaultSampleValues> sparseArray = new SparseArray<>();
        int size = containerAtom2.leafChildren.size();
        long j = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = containerAtom2.leafChildren.get(i2);
            if (leafAtom.type == 1953654136) {
                Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) parseTrex.first).intValue(), (DefaultSampleValues) parseTrex.second);
            } else if (leafAtom.type == 1835362404) {
                j = parseMehd(leafAtom.data);
            }
        }
        List<TrackSampleTable> parseTraks = AtomParsers.parseTraks(containerAtom, new GaplessInfoHolder(), j, drmInitDataFromAtoms, (this.flags & 16) != 0, false, new Function() { // from class: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$Xle2kybCcBDfaYt4nAECb1zk9Sg
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return FragmentedMp4Extractor.this.modifyTrack((Track) obj);
            }
        });
        int size2 = parseTraks.size();
        if (this.trackBundles.size() == 0) {
            while (i < size2) {
                TrackSampleTable trackSampleTable = parseTraks.get(i);
                Track track = trackSampleTable.track;
                this.trackBundles.put(track.id, new TrackBundle(this.extractorOutput.track(i, track.type), trackSampleTable, getDefaultSampleValues(sparseArray, track.id)));
                this.durationUs = Math.max(this.durationUs, track.durationUs);
                i++;
            }
            this.extractorOutput.endTracks();
            return;
        }
        Assertions.checkState(this.trackBundles.size() == size2);
        while (i < size2) {
            TrackSampleTable trackSampleTable2 = parseTraks.get(i);
            Track track2 = trackSampleTable2.track;
            this.trackBundles.get(track2.id).reset(trackSampleTable2, getDefaultSampleValues(sparseArray, track2.id));
            i++;
        }
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray<DefaultSampleValues> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.checkNotNull(sparseArray.get(i));
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        parseMoof(containerAtom, this.trackBundles, this.sideloadedTrack != null, this.flags, this.scratchBytes);
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i = 0; i < size; i++) {
                this.trackBundles.valueAt(i).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
        if (this.pendingSeekTimeUs != C.TIME_UNSET) {
            int size2 = this.trackBundles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.trackBundles.valueAt(i2).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = C.TIME_UNSET;
        }
    }

    private void initExtraTracks() {
        int i;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.emsgTrackOutputs = trackOutputArr;
        TrackOutput trackOutput = this.additionalEmsgTrackOutput;
        int i2 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.flags & 4) != 0) {
            trackOutputArr[i] = this.extractorOutput.track(100, 5);
            i++;
            i3 = 101;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.nullSafeArrayCopy(this.emsgTrackOutputs, i);
        this.emsgTrackOutputs = trackOutputArr2;
        for (TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.format(EMSG_FORMAT);
        }
        this.ceaTrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
        while (i2 < this.ceaTrackOutputs.length) {
            TrackOutput track = this.extractorOutput.track(i3, 3);
            track.format(this.closedCaptionFormats.get(i2));
            this.ceaTrackOutputs[i2] = track;
            i2++;
            i3++;
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray) {
        long scaleLargeTimestamp;
        String str;
        long scaleLargeTimestamp2;
        String str2;
        long readUnsignedInt;
        long j;
        if (this.emsgTrackOutputs.length == 0) {
            return;
        }
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion == 0) {
            String str3 = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            String str4 = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
            scaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000L, readUnsignedInt2);
            long j2 = this.segmentIndexEarliestPresentationTimeUs;
            long j3 = j2 != C.TIME_UNSET ? j2 + scaleLargeTimestamp : -9223372036854775807L;
            str = str3;
            scaleLargeTimestamp2 = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, readUnsignedInt2);
            str2 = str4;
            readUnsignedInt = parsableByteArray.readUnsignedInt();
            j = j3;
        } else if (parseFullAtomVersion == 1) {
            long readUnsignedInt3 = parsableByteArray.readUnsignedInt();
            j = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedLongToLong(), 1000000L, readUnsignedInt3);
            long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, readUnsignedInt3);
            long readUnsignedInt4 = parsableByteArray.readUnsignedInt();
            str = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            scaleLargeTimestamp2 = scaleLargeTimestamp3;
            readUnsignedInt = readUnsignedInt4;
            str2 = (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            scaleLargeTimestamp = -9223372036854775807L;
        } else {
            Log.w(TAG, new StringBuilder(46).append("Skipping unsupported emsg version: ").append(parseFullAtomVersion).toString());
            return;
        }
        byte[] bArr = new byte[parsableByteArray.bytesLeft()];
        parsableByteArray.readBytes(bArr, 0, parsableByteArray.bytesLeft());
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.eventMessageEncoder.encode(new EventMessage(str, str2, scaleLargeTimestamp2, readUnsignedInt, bArr)));
        int bytesLeft = parsableByteArray2.bytesLeft();
        for (TrackOutput trackOutput : this.emsgTrackOutputs) {
            parsableByteArray2.setPosition(0);
            trackOutput.sampleData(parsableByteArray2, bytesLeft);
        }
        if (j == C.TIME_UNSET) {
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(scaleLargeTimestamp, bytesLeft));
            this.pendingMetadataSampleBytes += bytesLeft;
            return;
        }
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            j = timestampAdjuster.adjustSampleTimestamp(j);
        }
        for (TrackOutput trackOutput2 : this.emsgTrackOutputs) {
            trackOutput2.sampleMetadata(j, 1, bytesLeft, 0, null);
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readInt() - 1, parsableByteArray.readInt(), parsableByteArray.readInt(), parsableByteArray.readInt()));
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i2);
            if (containerAtom2.type == 1953653094) {
                parseTraf(containerAtom2, sparseArray, z, i, bArr);
            }
        }
    }

    private static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        TrackBundle parseTfhd = parseTfhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd))).data, sparseArray, z);
        if (parseTfhd == null) {
            return;
        }
        TrackFragment trackFragment = parseTfhd.fragment;
        long j = trackFragment.nextFragmentDecodeTime;
        boolean z2 = trackFragment.nextFragmentDecodeTimeIncludesMoov;
        parseTfhd.resetFragmentInfo();
        parseTfhd.currentlyInFragment = true;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt);
        if (leafAtomOfType != null && (i & 2) == 0) {
            trackFragment.nextFragmentDecodeTime = parseTfdt(leafAtomOfType.data);
            trackFragment.nextFragmentDecodeTimeIncludesMoov = true;
        } else {
            trackFragment.nextFragmentDecodeTime = j;
            trackFragment.nextFragmentDecodeTimeIncludesMoov = z2;
        }
        parseTruns(containerAtom, parseTfhd, i);
        TrackEncryptionBox sampleDescriptionEncryptionBox = parseTfhd.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Assertions.checkNotNull(trackFragment.header)).sampleDescriptionIndex);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
        if (leafAtomOfType2 != null) {
            parseSaiz((TrackEncryptionBox) Assertions.checkNotNull(sampleDescriptionEncryptionBox), leafAtomOfType2.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
        if (leafAtomOfType3 != null) {
            parseSaio(leafAtomOfType3.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
        if (leafAtomOfType4 != null) {
            parseSenc(leafAtomOfType4.data, trackFragment);
        }
        parseSampleGroups(containerAtom, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
        int size = containerAtom.leafChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i2);
            if (leafAtom.type == 1970628964) {
                parseUuid(leafAtom.data, trackFragment, bArr);
            }
        }
    }

    private static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, int i) throws ParserException {
        List<Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Atom.LeafAtom leafAtom = list.get(i4);
            if (leafAtom.type == 1953658222) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i3 += readUnsignedIntToInt;
                    i2++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i2, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Atom.LeafAtom leafAtom2 = list.get(i7);
            if (leafAtom2.type == 1953658222) {
                i6 = parseTrun(trackBundle, i5, i, leafAtom2.data, i6);
                i5++;
            }
        }
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i;
        int i2 = trackEncryptionBox.perSampleIvSize;
        parsableByteArray.setPosition(8);
        if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt > trackFragment.sampleCount) {
            throw new ParserException(new StringBuilder(78).append("Saiz sample count ").append(readUnsignedIntToInt).append(" is greater than fragment sample count").append(trackFragment.sampleCount).toString());
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
            i = 0;
            for (int i3 = 0; i3 < readUnsignedIntToInt; i3++) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                i += readUnsignedByte2;
                zArr[i3] = readUnsignedByte2 > i2;
            }
        } else {
            i = (readUnsignedByte * readUnsignedIntToInt) + 0;
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, readUnsignedByte > i2);
        }
        Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, readUnsignedIntToInt, trackFragment.sampleCount, false);
        if (i > 0) {
            trackFragment.initEncryptionData(i);
        }
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != 1) {
            throw new ParserException(new StringBuilder(40).append("Unexpected saio entry count: ").append(readUnsignedIntToInt).toString());
        }
        trackFragment.auxiliaryDataPosition += Atom.parseFullAtomVersion(readInt) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        TrackBundle valueAt = z ? sparseArray.valueAt(0) : sparseArray.get(parsableByteArray.readInt());
        if (valueAt == null) {
            return null;
        }
        if ((parseFullAtomFlags & 1) != 0) {
            long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            valueAt.fragment.dataPosition = readUnsignedLongToLong;
            valueAt.fragment.auxiliaryDataPosition = readUnsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = valueAt.defaultSampleValues;
        if ((parseFullAtomFlags & 2) != 0) {
            i = parsableByteArray.readInt() - 1;
        } else {
            i = defaultSampleValues.sampleDescriptionIndex;
        }
        if ((parseFullAtomFlags & 8) != 0) {
            i2 = parsableByteArray.readInt();
        } else {
            i2 = defaultSampleValues.duration;
        }
        if ((parseFullAtomFlags & 16) != 0) {
            i3 = parsableByteArray.readInt();
        } else {
            i3 = defaultSampleValues.size;
        }
        if ((parseFullAtomFlags & 32) != 0) {
            i4 = parsableByteArray.readInt();
        } else {
            i4 = defaultSampleValues.flags;
        }
        valueAt.fragment.header = new DefaultSampleValues(i, i2, i3, i4);
        return valueAt;
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
    }

    private static int parseTrun(TrackBundle trackBundle, int i, int i2, ParsableByteArray parsableByteArray, int i3) throws ParserException {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        TrackBundle trackBundle2 = trackBundle;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        Track track = trackBundle2.moovSampleTable.track;
        TrackFragment trackFragment = trackBundle2.fragment;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues) Util.castNonNull(trackFragment.header);
        trackFragment.trunLength[i] = parsableByteArray.readUnsignedIntToInt();
        trackFragment.trunDataPosition[i] = trackFragment.dataPosition;
        if ((parseFullAtomFlags & 1) != 0) {
            long[] jArr = trackFragment.trunDataPosition;
            jArr[i] = jArr[i] + parsableByteArray.readInt();
        }
        boolean z7 = (parseFullAtomFlags & 4) != 0;
        int i6 = defaultSampleValues.flags;
        if (z7) {
            i6 = parsableByteArray.readInt();
        }
        boolean z8 = (parseFullAtomFlags & 256) != 0;
        boolean z9 = (parseFullAtomFlags & 512) != 0;
        boolean z10 = (parseFullAtomFlags & 1024) != 0;
        boolean z11 = (parseFullAtomFlags & 2048) != 0;
        long j = 0;
        if (track.editListDurations != null && track.editListDurations.length == 1 && track.editListDurations[0] == 0) {
            j = Util.scaleLargeTimestamp(((long[]) Util.castNonNull(track.editListMediaTimes))[0], 1000000L, track.timescale);
        }
        int[] iArr = trackFragment.sampleSizeTable;
        int[] iArr2 = trackFragment.sampleCompositionTimeOffsetUsTable;
        long[] jArr2 = trackFragment.sampleDecodingTimeUsTable;
        boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
        int i7 = i6;
        boolean z12 = track.type == 2 && (i2 & 1) != 0;
        int i8 = i3 + trackFragment.trunLength[i];
        boolean z13 = z12;
        long j2 = track.timescale;
        long j3 = j;
        long j4 = trackFragment.nextFragmentDecodeTime;
        int i9 = i3;
        while (i9 < i8) {
            int checkNonNegative = checkNonNegative(z8 ? parsableByteArray.readInt() : defaultSampleValues.duration);
            if (z9) {
                z = z8;
                i4 = parsableByteArray.readInt();
            } else {
                z = z8;
                i4 = defaultSampleValues.size;
            }
            int checkNonNegative2 = checkNonNegative(i4);
            if (z10) {
                z2 = z7;
                i5 = parsableByteArray.readInt();
            } else if (i9 == 0 && z7) {
                z2 = z7;
                i5 = i7;
            } else {
                z2 = z7;
                i5 = defaultSampleValues.flags;
            }
            if (z11) {
                z3 = z11;
                z4 = z9;
                z5 = z10;
                iArr2[i9] = (int) ((parsableByteArray.readInt() * 1000000) / j2);
                z6 = false;
            } else {
                z3 = z11;
                z4 = z9;
                z5 = z10;
                z6 = false;
                iArr2[i9] = 0;
            }
            jArr2[i9] = Util.scaleLargeTimestamp(j4, 1000000L, j2) - j3;
            if (!trackFragment.nextFragmentDecodeTimeIncludesMoov) {
                jArr2[i9] = jArr2[i9] + trackBundle2.moovSampleTable.durationUs;
            }
            iArr[i9] = checkNonNegative2;
            zArr[i9] = (((i5 >> 16) & 1) != 0 || (z13 && i9 != 0)) ? z6 : true;
            j4 += checkNonNegative;
            i9++;
            trackBundle2 = trackBundle;
            z8 = z;
            j2 = j2;
            z7 = z2;
            z11 = z3;
            z9 = z4;
            z10 = z5;
        }
        trackFragment.nextFragmentDecodeTime = j4;
        return i8;
    }

    private static int checkNonNegative(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw new ParserException(new StringBuilder(38).append("Unexpected negative value: ").append(i).toString());
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((parseFullAtomFlags & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (parseFullAtomFlags & 2) != 0;
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 0) {
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, trackFragment.sampleCount, false);
        } else {
            if (readUnsignedIntToInt != trackFragment.sampleCount) {
                throw new ParserException(new StringBuilder(80).append("Senc sample count ").append(readUnsignedIntToInt).append(" is different from fragment sample count").append(trackFragment.sampleCount).toString());
            }
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z);
            trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
            trackFragment.fillEncryptionData(parsableByteArray);
        }
    }

    private static void parseSampleGroups(Atom.ContainerAtom containerAtom, String str, TrackFragment trackFragment) throws ParserException {
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i = 0; i < containerAtom.leafChildren.size(); i++) {
            Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i);
            ParsableByteArray parsableByteArray3 = leafAtom.data;
            if (leafAtom.type == 1935828848) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (leafAtom.type == 1936158820) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray == null || parsableByteArray2 == null) {
            return;
        }
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        if (parseFullAtomVersion == 1) {
            parsableByteArray.skipBytes(4);
        }
        if (parsableByteArray.readInt() != 1) {
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
        parsableByteArray2.setPosition(8);
        int parseFullAtomVersion2 = Atom.parseFullAtomVersion(parsableByteArray2.readInt());
        parsableByteArray2.skipBytes(4);
        if (parseFullAtomVersion2 == 1) {
            if (parsableByteArray2.readUnsignedInt() == 0) {
                throw new ParserException("Variable length description in sgpd found (unsupported)");
            }
        } else if (parseFullAtomVersion2 >= 2) {
            parsableByteArray2.skipBytes(4);
        }
        if (parsableByteArray2.readUnsignedInt() != 1) {
            throw new ParserException("Entry count in sgpd != 1 (unsupported).");
        }
        parsableByteArray2.skipBytes(1);
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        int i2 = (readUnsignedByte & 240) >> 4;
        int i3 = readUnsignedByte & 15;
        boolean z = parsableByteArray2.readUnsignedByte() == 1;
        if (z) {
            int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
            byte[] bArr2 = new byte[16];
            parsableByteArray2.readBytes(bArr2, 0, 16);
            if (readUnsignedByte2 == 0) {
                int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                bArr = new byte[readUnsignedByte3];
                parsableByteArray2.readBytes(bArr, 0, readUnsignedByte3);
            }
            trackFragment.definesEncryptionData = true;
            trackFragment.trackEncryptionBox = new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i2, i3, bArr);
        }
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j) throws ParserException {
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            readUnsignedLongToLong = parsableByteArray.readUnsignedInt();
            readUnsignedLongToLong2 = parsableByteArray.readUnsignedInt();
        } else {
            readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            readUnsignedLongToLong2 = parsableByteArray.readUnsignedLongToLong();
        }
        long j2 = readUnsignedLongToLong;
        long j3 = j + readUnsignedLongToLong2;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j2, 1000000L, readUnsignedInt);
        parsableByteArray.skipBytes(2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j4 = scaleLargeTimestamp;
        int i = 0;
        long j5 = j2;
        while (i < readUnsignedShort) {
            int readInt = parsableByteArray.readInt();
            if ((readInt & Integer.MIN_VALUE) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
            iArr[i] = readInt & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            long j6 = j5 + readUnsignedInt2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = readUnsignedShort;
            long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j6, 1000000L, readUnsignedInt);
            jArr4[i] = scaleLargeTimestamp2 - jArr5[i];
            parsableByteArray.skipBytes(4);
            j3 += r1[i];
            i++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            readUnsignedShort = i2;
            j5 = j6;
            j4 = scaleLargeTimestamp2;
        }
        return Pair.create(Long.valueOf(scaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException {
        int size = this.trackBundles.size();
        TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill && trackFragment.auxiliaryDataPosition < j) {
                long j2 = trackFragment.auxiliaryDataPosition;
                trackBundle = this.trackBundles.valueAt(i);
                j = j2;
            }
        }
        if (trackBundle == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j - extractorInput.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        extractorInput.skipFully(position);
        trackBundle.fragment.fillEncryptionData(extractorInput);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean readSample(ExtractorInput extractorInput) throws IOException {
        int sampleData;
        TrackBundle trackBundle = this.currentTrackBundle;
        if (trackBundle == null) {
            trackBundle = getNextTrackBundle(this.trackBundles);
            if (trackBundle == null) {
                int position = (int) (this.endOfMdatPosition - extractorInput.getPosition());
                if (position < 0) {
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                extractorInput.skipFully(position);
                enterReadingAtomHeaderState();
                return false;
            }
            int currentSampleOffset = (int) (trackBundle.getCurrentSampleOffset() - extractorInput.getPosition());
            if (currentSampleOffset < 0) {
                Log.w(TAG, "Ignoring negative offset to sample data.");
                currentSampleOffset = 0;
            }
            extractorInput.skipFully(currentSampleOffset);
            this.currentTrackBundle = trackBundle;
        }
        int i = 4;
        int i2 = 1;
        if (this.parserState == 3) {
            this.sampleSize = trackBundle.getCurrentSampleSize();
            if (trackBundle.currentSampleIndex < trackBundle.firstSampleToOutputIndex) {
                extractorInput.skipFully(this.sampleSize);
                trackBundle.skipSampleEncryptionData();
                if (!trackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = 3;
                return true;
            }
            if (trackBundle.moovSampleTable.track.sampleTransformation == 1) {
                this.sampleSize -= 8;
                extractorInput.skipFully(8);
            }
            if (MimeTypes.AUDIO_AC4.equals(trackBundle.moovSampleTable.track.format.sampleMimeType)) {
                this.sampleBytesWritten = trackBundle.outputSampleEncryptionData(this.sampleSize, 7);
                Ac4Util.getAc4SampleHeader(this.sampleSize, this.scratch);
                trackBundle.output.sampleData(this.scratch, 7);
                this.sampleBytesWritten += 7;
            } else {
                this.sampleBytesWritten = trackBundle.outputSampleEncryptionData(this.sampleSize, 0);
            }
            this.sampleSize += this.sampleBytesWritten;
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        Track track = trackBundle.moovSampleTable.track;
        TrackOutput trackOutput = trackBundle.output;
        long currentSamplePresentationTimeUs = trackBundle.getCurrentSamplePresentationTimeUs();
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            currentSamplePresentationTimeUs = timestampAdjuster.adjustSampleTimestamp(currentSamplePresentationTimeUs);
        }
        long j = currentSamplePresentationTimeUs;
        if (track.nalUnitLengthFieldLength == 0) {
            while (true) {
                int i3 = this.sampleBytesWritten;
                int i4 = this.sampleSize;
                if (i3 >= i4) {
                    break;
                }
                this.sampleBytesWritten += trackOutput.sampleData((DataReader) extractorInput, i4 - i3, false);
            }
        } else {
            byte[] data = this.nalPrefix.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i5 = track.nalUnitLengthFieldLength + 1;
            int i6 = 4 - track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < this.sampleSize) {
                int i7 = this.sampleCurrentNalBytesRemaining;
                if (i7 == 0) {
                    extractorInput.readFully(data, i6, i5);
                    this.nalPrefix.setPosition(0);
                    int readInt = this.nalPrefix.readInt();
                    if (readInt < i2) {
                        throw new ParserException("Invalid NAL length");
                    }
                    this.sampleCurrentNalBytesRemaining = readInt - 1;
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, i);
                    trackOutput.sampleData(this.nalPrefix, i2);
                    this.processSeiNalUnitPayload = (this.ceaTrackOutputs.length <= 0 || !NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, data[i])) ? 0 : i2;
                    this.sampleBytesWritten += 5;
                    this.sampleSize += i6;
                } else {
                    if (this.processSeiNalUnitPayload) {
                        this.nalBuffer.reset(i7);
                        extractorInput.readFully(this.nalBuffer.getData(), 0, this.sampleCurrentNalBytesRemaining);
                        trackOutput.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                        sampleData = this.sampleCurrentNalBytesRemaining;
                        int unescapeStream = NalUnitUtil.unescapeStream(this.nalBuffer.getData(), this.nalBuffer.limit());
                        this.nalBuffer.setPosition(MimeTypes.VIDEO_H265.equals(track.format.sampleMimeType) ? 1 : 0);
                        this.nalBuffer.setLimit(unescapeStream);
                        CeaUtil.consume(j, this.nalBuffer, this.ceaTrackOutputs);
                    } else {
                        sampleData = trackOutput.sampleData((DataReader) extractorInput, i7, false);
                    }
                    this.sampleBytesWritten += sampleData;
                    this.sampleCurrentNalBytesRemaining -= sampleData;
                    i = 4;
                    i2 = 1;
                }
            }
        }
        int currentSampleFlags = trackBundle.getCurrentSampleFlags();
        TrackEncryptionBox encryptionBoxIfEncrypted = trackBundle.getEncryptionBoxIfEncrypted();
        trackOutput.sampleMetadata(j, currentSampleFlags, this.sampleSize, 0, encryptionBoxIfEncrypted != null ? encryptionBoxIfEncrypted.cryptoData : null);
        outputPendingMetadataSamples(j);
        if (!trackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return true;
    }

    private void outputPendingMetadataSamples(long j) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo removeFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= removeFirst.size;
            long j2 = removeFirst.presentationTimeDeltaUs + j;
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster != null) {
                j2 = timestampAdjuster.adjustSampleTimestamp(j2);
            }
            for (TrackOutput trackOutput : this.emsgTrackOutputs) {
                trackOutput.sampleMetadata(j2, 1, removeFirst.size, this.pendingMetadataSampleBytes, null);
            }
        }
    }

    private static TrackBundle getNextTrackBundle(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            TrackBundle valueAt = sparseArray.valueAt(i);
            if ((valueAt.currentlyInFragment || valueAt.currentSampleIndex != valueAt.moovSampleTable.sampleCount) && (!valueAt.currentlyInFragment || valueAt.currentTrackRunIndex != valueAt.fragment.trunCount)) {
                long currentSampleOffset = valueAt.getCurrentSampleOffset();
                if (currentSampleOffset < j) {
                    trackBundle = valueAt;
                    j = currentSampleOffset;
                }
            }
        }
        return trackBundle;
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.LeafAtom leafAtom = list.get(i);
            if (leafAtom.type == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] data = leafAtom.data.getData();
                UUID parseUuid = PsshAtomUtil.parseUuid(data);
                if (parseUuid == null) {
                    Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, MimeTypes.VIDEO_MP4, data));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long j, int i) {
            this.presentationTimeDeltaUs = j;
            this.size = i;
        }
    }

    private static final class TrackBundle {
        private static final int SINGLE_SUBSAMPLE_ENCRYPTION_DATA_LENGTH = 8;
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        private boolean currentlyInFragment;
        public DefaultSampleValues defaultSampleValues;
        public int firstSampleToOutputIndex;
        public TrackSampleTable moovSampleTable;
        public final TrackOutput output;
        public final TrackFragment fragment = new TrackFragment();
        public final ParsableByteArray scratch = new ParsableByteArray();
        private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        private final ParsableByteArray defaultInitializationVector = new ParsableByteArray();

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.output = trackOutput;
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues;
            reset(trackSampleTable, defaultSampleValues);
        }

        public void reset(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues;
            this.output.format(trackSampleTable.track.format);
            resetFragmentInfo();
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex);
            this.output.format(this.moovSampleTable.track.format.buildUpon().setDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)).build());
        }

        public void resetFragmentInfo() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
            this.currentlyInFragment = false;
        }

        public void seek(long j) {
            for (int i = this.currentSampleIndex; i < this.fragment.sampleCount && this.fragment.getSamplePresentationTimeUs(i) < j; i++) {
                if (this.fragment.sampleIsSyncFrameTable[i]) {
                    this.firstSampleToOutputIndex = i;
                }
            }
        }

        public long getCurrentSamplePresentationTimeUs() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.timestampsUs[this.currentSampleIndex];
            }
            return this.fragment.getSamplePresentationTimeUs(this.currentSampleIndex);
        }

        public long getCurrentSampleOffset() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.offsets[this.currentSampleIndex];
            }
            return this.fragment.trunDataPosition[this.currentTrackRunIndex];
        }

        public int getCurrentSampleSize() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.sizes[this.currentSampleIndex];
            }
            return this.fragment.sampleSizeTable[this.currentSampleIndex];
        }

        public int getCurrentSampleFlags() {
            int i;
            if (!this.currentlyInFragment) {
                i = this.moovSampleTable.flags[this.currentSampleIndex];
            } else {
                i = this.fragment.sampleIsSyncFrameTable[this.currentSampleIndex] ? 1 : 0;
            }
            return getEncryptionBoxIfEncrypted() != null ? i | 1073741824 : i;
        }

        public boolean next() {
            this.currentSampleIndex++;
            if (!this.currentlyInFragment) {
                return false;
            }
            int i = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i;
            int[] iArr = this.fragment.trunLength;
            int i2 = this.currentTrackRunIndex;
            if (i != iArr[i2]) {
                return true;
            }
            this.currentTrackRunIndex = i2 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public int outputSampleEncryptionData(int i, int i2) {
            ParsableByteArray parsableByteArray;
            int length;
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return 0;
            }
            if (encryptionBoxIfEncrypted.perSampleIvSize != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
                length = encryptionBoxIfEncrypted.perSampleIvSize;
            } else {
                byte[] bArr = (byte[]) Util.castNonNull(encryptionBoxIfEncrypted.defaultInitializationVector);
                this.defaultInitializationVector.reset(bArr, bArr.length);
                parsableByteArray = this.defaultInitializationVector;
                length = bArr.length;
            }
            boolean sampleHasSubsampleEncryptionTable = this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex);
            boolean z = sampleHasSubsampleEncryptionTable || i2 != 0;
            this.encryptionSignalByte.getData()[0] = (byte) ((z ? 128 : 0) | length);
            this.encryptionSignalByte.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1, 1);
            this.output.sampleData(parsableByteArray, length, 1);
            if (!z) {
                return length + 1;
            }
            if (!sampleHasSubsampleEncryptionTable) {
                this.scratch.reset(8);
                byte[] data = this.scratch.getData();
                data[0] = 0;
                data[1] = 1;
                data[2] = (byte) ((i2 >> 8) & 255);
                data[3] = (byte) (i2 & 255);
                data[4] = (byte) ((i >> 24) & 255);
                data[5] = (byte) ((i >> 16) & 255);
                data[6] = (byte) ((i >> 8) & 255);
                data[7] = (byte) (i & 255);
                this.output.sampleData(this.scratch, 8, 1);
                return length + 1 + 8;
            }
            ParsableByteArray parsableByteArray2 = this.fragment.sampleEncryptionData;
            int readUnsignedShort = parsableByteArray2.readUnsignedShort();
            parsableByteArray2.skipBytes(-2);
            int i3 = (readUnsignedShort * 6) + 2;
            if (i2 != 0) {
                this.scratch.reset(i3);
                byte[] data2 = this.scratch.getData();
                parsableByteArray2.readBytes(data2, 0, i3);
                int i4 = (((data2[2] & 255) << 8) | (data2[3] & 255)) + i2;
                data2[2] = (byte) ((i4 >> 8) & 255);
                data2[3] = (byte) (i4 & 255);
                parsableByteArray2 = this.scratch;
            }
            this.output.sampleData(parsableByteArray2, i3, 1);
            return length + 1 + i3;
        }

        public void skipSampleEncryptionData() {
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return;
            }
            ParsableByteArray parsableByteArray = this.fragment.sampleEncryptionData;
            if (encryptionBoxIfEncrypted.perSampleIvSize != 0) {
                parsableByteArray.skipBytes(encryptionBoxIfEncrypted.perSampleIvSize);
            }
            if (this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex)) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
            }
        }

        public TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            TrackEncryptionBox sampleDescriptionEncryptionBox;
            if (!this.currentlyInFragment) {
                return null;
            }
            int i = ((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex;
            if (this.fragment.trackEncryptionBox != null) {
                sampleDescriptionEncryptionBox = this.fragment.trackEncryptionBox;
            } else {
                sampleDescriptionEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(i);
            }
            if (sampleDescriptionEncryptionBox == null || !sampleDescriptionEncryptionBox.isEncrypted) {
                return null;
            }
            return sampleDescriptionEncryptionBox;
        }
    }
}
