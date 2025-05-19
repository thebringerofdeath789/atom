package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.source.rtsp.RtpPacketReorderingQueue;
import java.util.Comparator;
import java.util.TreeSet;

/* loaded from: classes.dex */
final class RtpPacketReorderingQueue {
    static final int MAX_SEQUENCE_LEAP_ALLOWED = 1000;
    private static final int MAX_SEQUENCE_NUMBER = 65535;
    private int lastDequeuedSequenceNumber;
    private int lastReceivedSequenceNumber;
    private final TreeSet<RtpPacketContainer> packetQueue = new TreeSet<>(new Comparator() { // from class: com.google.android.exoplayer2.source.rtsp.-$$Lambda$RtpPacketReorderingQueue$t7Wc_OvLLR8nWyJTQZbD99p7yVk
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int calculateSequenceNumberShift;
            calculateSequenceNumberShift = RtpPacketReorderingQueue.calculateSequenceNumberShift(((RtpPacketReorderingQueue.RtpPacketContainer) obj).packet.sequenceNumber, ((RtpPacketReorderingQueue.RtpPacketContainer) obj2).packet.sequenceNumber);
            return calculateSequenceNumberShift;
        }
    });
    private boolean started;

    public RtpPacketReorderingQueue() {
        reset();
    }

    public synchronized void reset() {
        this.packetQueue.clear();
        this.started = false;
        this.lastDequeuedSequenceNumber = -1;
        this.lastReceivedSequenceNumber = -1;
    }

    public synchronized boolean offer(RtpPacket rtpPacket, long j) {
        int i = rtpPacket.sequenceNumber;
        if (!this.started) {
            reset();
            this.lastDequeuedSequenceNumber = prevSequenceNumber(i);
            this.started = true;
            addToQueue(new RtpPacketContainer(rtpPacket, j));
            return true;
        }
        if (Math.abs(calculateSequenceNumberShift(i, nextSequenceNumber(this.lastReceivedSequenceNumber))) < 1000) {
            if (calculateSequenceNumberShift(i, this.lastDequeuedSequenceNumber) <= 0) {
                return false;
            }
            addToQueue(new RtpPacketContainer(rtpPacket, j));
            return true;
        }
        this.lastDequeuedSequenceNumber = prevSequenceNumber(i);
        this.packetQueue.clear();
        addToQueue(new RtpPacketContainer(rtpPacket, j));
        return true;
    }

    public synchronized RtpPacket poll(long j) {
        if (this.packetQueue.isEmpty()) {
            return null;
        }
        RtpPacketContainer first = this.packetQueue.first();
        int i = first.packet.sequenceNumber;
        if (i != nextSequenceNumber(this.lastDequeuedSequenceNumber) && j < first.receivedTimestampMs) {
            return null;
        }
        this.packetQueue.pollFirst();
        this.lastDequeuedSequenceNumber = i;
        return first.packet;
    }

    private synchronized void addToQueue(RtpPacketContainer rtpPacketContainer) {
        this.lastReceivedSequenceNumber = rtpPacketContainer.packet.sequenceNumber;
        this.packetQueue.add(rtpPacketContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class RtpPacketContainer {
        public final RtpPacket packet;
        public final long receivedTimestampMs;

        public RtpPacketContainer(RtpPacket rtpPacket, long j) {
            this.packet = rtpPacket;
            this.receivedTimestampMs = j;
        }
    }

    private static int nextSequenceNumber(int i) {
        return (i + 1) % 65535;
    }

    private static int prevSequenceNumber(int i) {
        return i == 0 ? WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE : (i - 1) % 65535;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int calculateSequenceNumberShift(int i, int i2) {
        int min;
        int i3 = i - i2;
        return (Math.abs(i3) <= 1000 || (min = (Math.min(i, i2) - Math.max(i, i2)) + 65535) >= 1000) ? i3 : i < i2 ? min : -min;
    }
}
