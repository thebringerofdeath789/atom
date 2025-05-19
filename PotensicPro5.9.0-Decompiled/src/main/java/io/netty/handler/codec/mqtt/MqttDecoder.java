package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttDecoder extends ReplayingDecoder<DecoderState> {
    private static final int DEFAULT_MAX_BYTES_IN_MESSAGE = 8092;
    private int bytesRemainingInVariablePart;
    private final int maxBytesInMessage;
    private MqttFixedHeader mqttFixedHeader;
    private Object variableHeader;

    enum DecoderState {
        READ_FIXED_HEADER,
        READ_VARIABLE_HEADER,
        READ_PAYLOAD,
        BAD_MESSAGE
    }

    public MqttDecoder() {
        this(DEFAULT_MAX_BYTES_IN_MESSAGE);
    }

    public MqttDecoder(int i) {
        super(DecoderState.READ_FIXED_HEADER);
        this.maxBytesInMessage = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072 A[Catch: Exception -> 0x00bd, TryCatch #1 {Exception -> 0x00bd, blocks: (B:15:0x0059, B:17:0x0072, B:19:0x008c, B:20:0x00bc), top: B:14:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c A[Catch: Exception -> 0x00bd, TryCatch #1 {Exception -> 0x00bd, blocks: (B:15:0x0059, B:17:0x0072, B:19:0x008c, B:20:0x00bc), top: B:14:0x0059 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            r2 = this;
            int[] r3 = io.netty.handler.codec.mqtt.MqttDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState
            java.lang.Object r0 = r2.state()
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r0 = (io.netty.handler.codec.mqtt.MqttDecoder.DecoderState) r0
            int r0 = r0.ordinal()
            r3 = r3[r0]
            r0 = 1
            if (r3 == r0) goto L28
            r0 = 2
            if (r3 == r0) goto L39
            r0 = 3
            if (r3 == r0) goto L59
            r5 = 4
            if (r3 != r5) goto L22
            int r3 = r2.actualReadableBytes()
            r4.skipBytes(r3)
            goto L8b
        L22:
            java.lang.Error r3 = new java.lang.Error
            r3.<init>()
            throw r3
        L28:
            io.netty.handler.codec.mqtt.MqttFixedHeader r3 = decodeFixedHeader(r4)     // Catch: java.lang.Exception -> Lf0
            r2.mqttFixedHeader = r3     // Catch: java.lang.Exception -> Lf0
            int r3 = r3.remainingLength()     // Catch: java.lang.Exception -> Lf0
            r2.bytesRemainingInVariablePart = r3     // Catch: java.lang.Exception -> Lf0
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r3 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_VARIABLE_HEADER     // Catch: java.lang.Exception -> Lf0
            r2.checkpoint(r3)     // Catch: java.lang.Exception -> Lf0
        L39:
            int r3 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Le7
            int r0 = r2.maxBytesInMessage     // Catch: java.lang.Exception -> Le7
            if (r3 > r0) goto Lc6
            io.netty.handler.codec.mqtt.MqttFixedHeader r3 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Le7
            io.netty.handler.codec.mqtt.MqttDecoder$Result r3 = decodeVariableHeader(r4, r3)     // Catch: java.lang.Exception -> Le7
            java.lang.Object r0 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$000(r3)     // Catch: java.lang.Exception -> Le7
            r2.variableHeader = r0     // Catch: java.lang.Exception -> Le7
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Le7
            int r3 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$100(r3)     // Catch: java.lang.Exception -> Le7
            int r0 = r0 - r3
            r2.bytesRemainingInVariablePart = r0     // Catch: java.lang.Exception -> Le7
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r3 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_PAYLOAD     // Catch: java.lang.Exception -> Le7
            r2.checkpoint(r3)     // Catch: java.lang.Exception -> Le7
        L59:
            io.netty.handler.codec.mqtt.MqttFixedHeader r3 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Lbd
            io.netty.handler.codec.mqtt.MqttMessageType r3 = r3.messageType()     // Catch: java.lang.Exception -> Lbd
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Lbd
            java.lang.Object r1 = r2.variableHeader     // Catch: java.lang.Exception -> Lbd
            io.netty.handler.codec.mqtt.MqttDecoder$Result r3 = decodePayload(r4, r3, r0, r1)     // Catch: java.lang.Exception -> Lbd
            int r4 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Lbd
            int r0 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$100(r3)     // Catch: java.lang.Exception -> Lbd
            int r4 = r4 - r0
            r2.bytesRemainingInVariablePart = r4     // Catch: java.lang.Exception -> Lbd
            if (r4 != 0) goto L8c
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r4 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_FIXED_HEADER     // Catch: java.lang.Exception -> Lbd
            r2.checkpoint(r4)     // Catch: java.lang.Exception -> Lbd
            io.netty.handler.codec.mqtt.MqttFixedHeader r4 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Lbd
            java.lang.Object r0 = r2.variableHeader     // Catch: java.lang.Exception -> Lbd
            java.lang.Object r3 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$000(r3)     // Catch: java.lang.Exception -> Lbd
            io.netty.handler.codec.mqtt.MqttMessage r3 = io.netty.handler.codec.mqtt.MqttMessageFactory.newMessage(r4, r0, r3)     // Catch: java.lang.Exception -> Lbd
            r4 = 0
            r2.mqttFixedHeader = r4     // Catch: java.lang.Exception -> Lbd
            r2.variableHeader = r4     // Catch: java.lang.Exception -> Lbd
            r5.add(r3)     // Catch: java.lang.Exception -> Lbd
        L8b:
            return
        L8c:
            io.netty.handler.codec.DecoderException r3 = new io.netty.handler.codec.DecoderException     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbd
            r4.<init>()     // Catch: java.lang.Exception -> Lbd
            java.lang.String r0 = "non-zero remaining payload bytes: "
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Lbd
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Lbd
            java.lang.String r0 = " ("
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Lbd
            io.netty.handler.codec.mqtt.MqttFixedHeader r0 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Lbd
            io.netty.handler.codec.mqtt.MqttMessageType r0 = r0.messageType()     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Lbd
            r0 = 41
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Lbd
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lbd
            r3.<init>(r4)     // Catch: java.lang.Exception -> Lbd
            throw r3     // Catch: java.lang.Exception -> Lbd
        Lbd:
            r3 = move-exception
            io.netty.handler.codec.mqtt.MqttMessage r3 = r2.invalidMessage(r3)
            r5.add(r3)
            return
        Lc6:
            io.netty.handler.codec.DecoderException r3 = new io.netty.handler.codec.DecoderException     // Catch: java.lang.Exception -> Le7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le7
            r4.<init>()     // Catch: java.lang.Exception -> Le7
            java.lang.String r0 = "too large message: "
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Le7
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Le7
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Le7
            java.lang.String r0 = " bytes"
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Exception -> Le7
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Le7
            r3.<init>(r4)     // Catch: java.lang.Exception -> Le7
            throw r3     // Catch: java.lang.Exception -> Le7
        Le7:
            r3 = move-exception
            io.netty.handler.codec.mqtt.MqttMessage r3 = r2.invalidMessage(r3)
            r5.add(r3)
            return
        Lf0:
            r3 = move-exception
            io.netty.handler.codec.mqtt.MqttMessage r3 = r2.invalidMessage(r3)
            r5.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    private MqttMessage invalidMessage(Throwable th) {
        checkpoint(DecoderState.BAD_MESSAGE);
        return MqttMessageFactory.newInvalidMessage(th);
    }

    private static MqttFixedHeader decodeFixedHeader(ByteBuf byteBuf) {
        int i;
        int i2;
        short readUnsignedByte = byteBuf.readUnsignedByte();
        MqttMessageType valueOf = MqttMessageType.valueOf(readUnsignedByte >> 4);
        int i3 = 0;
        boolean z = (readUnsignedByte & 8) == 8;
        int i4 = (readUnsignedByte & 6) >> 1;
        boolean z2 = (readUnsignedByte & 1) != 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            short readUnsignedByte2 = byteBuf.readUnsignedByte();
            i = ((readUnsignedByte2 & 127) * i6) + i3;
            i6 *= 128;
            i5++;
            i2 = readUnsignedByte2 & 128;
            if (i2 == 0 || i5 >= 4) {
                break;
            }
            i3 = i;
        }
        if (i5 == 4 && i2 != 0) {
            throw new DecoderException("remaining length exceeds 4 digits (" + valueOf + PropertyUtils.MAPPED_DELIM2);
        }
        return MqttCodecUtil.validateFixedHeader(MqttCodecUtil.resetUnusedFields(new MqttFixedHeader(valueOf, z, MqttQoS.valueOf(i4), z2, i)));
    }

    /* renamed from: io.netty.handler.codec.mqtt.MqttDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;

        static {
            int[] iArr = new int[MqttMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType = iArr;
            try {
                iArr[MqttMessageType.CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.CONNACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBSCRIBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBACK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBCOMP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBLISH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGREQ.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGRESP.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.DISCONNECT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr2 = new int[DecoderState.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState = iArr2;
            try {
                iArr2[DecoderState.READ_FIXED_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.READ_VARIABLE_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.READ_PAYLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.BAD_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    private static Result<?> decodeVariableHeader(ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()]) {
        }
        return new Result<>(null, 0);
    }

    private static Result<MqttConnectVariableHeader> decodeConnectionVariableHeader(ByteBuf byteBuf) {
        Result<String> decodeString = decodeString(byteBuf);
        int i = ((Result) decodeString).numberOfBytesConsumed;
        MqttVersion fromProtocolNameAndLevel = MqttVersion.fromProtocolNameAndLevel((String) ((Result) decodeString).value, byteBuf.readByte());
        short readUnsignedByte = byteBuf.readUnsignedByte();
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int i2 = i + 1 + 1 + ((Result) decodeMsbLsb).numberOfBytesConsumed;
        boolean z = (readUnsignedByte & 128) == 128;
        boolean z2 = (readUnsignedByte & 64) == 64;
        boolean z3 = (readUnsignedByte & 32) == 32;
        int i3 = (readUnsignedByte & 24) >> 3;
        boolean z4 = (readUnsignedByte & 4) == 4;
        boolean z5 = (readUnsignedByte & 2) == 2;
        if (fromProtocolNameAndLevel == MqttVersion.MQTT_3_1_1) {
            if (!((readUnsignedByte & 1) == 0)) {
                throw new DecoderException("non-zero reserved flag");
            }
        }
        return new Result<>(new MqttConnectVariableHeader(fromProtocolNameAndLevel.protocolName(), fromProtocolNameAndLevel.protocolLevel(), z, z2, z3, i3, z4, z5, ((Integer) ((Result) decodeMsbLsb).value).intValue()), i2);
    }

    private static Result<MqttConnAckVariableHeader> decodeConnAckVariableHeader(ByteBuf byteBuf) {
        return new Result<>(new MqttConnAckVariableHeader(MqttConnectReturnCode.valueOf(byteBuf.readByte()), (byteBuf.readUnsignedByte() & 1) == 1), 2);
    }

    private static Result<MqttMessageIdVariableHeader> decodeMessageIdVariableHeader(ByteBuf byteBuf) {
        Result<Integer> decodeMessageId = decodeMessageId(byteBuf);
        return new Result<>(MqttMessageIdVariableHeader.from(((Integer) ((Result) decodeMessageId).value).intValue()), ((Result) decodeMessageId).numberOfBytesConsumed);
    }

    private static Result<MqttPublishVariableHeader> decodePublishVariableHeader(ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader) {
        Result<String> decodeString = decodeString(byteBuf);
        if (!MqttCodecUtil.isValidPublishTopicName((String) ((Result) decodeString).value)) {
            throw new DecoderException("invalid publish topic name: " + ((String) ((Result) decodeString).value) + " (contains wildcards)");
        }
        int i = ((Result) decodeString).numberOfBytesConsumed;
        int i2 = -1;
        if (mqttFixedHeader.qosLevel().value() > 0) {
            Result<Integer> decodeMessageId = decodeMessageId(byteBuf);
            i2 = ((Integer) ((Result) decodeMessageId).value).intValue();
            i += ((Result) decodeMessageId).numberOfBytesConsumed;
        }
        return new Result<>(new MqttPublishVariableHeader((String) ((Result) decodeString).value, i2), i);
    }

    private static Result<Integer> decodeMessageId(ByteBuf byteBuf) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        if (MqttCodecUtil.isValidMessageId(((Integer) ((Result) decodeMsbLsb).value).intValue())) {
            return decodeMsbLsb;
        }
        throw new DecoderException("invalid messageId: " + ((Result) decodeMsbLsb).value);
    }

    private static Result<?> decodePayload(ByteBuf byteBuf, MqttMessageType mqttMessageType, int i, Object obj) {
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttMessageType.ordinal()];
        if (i2 == 1) {
            return decodeConnectionPayload(byteBuf, (MqttConnectVariableHeader) obj);
        }
        if (i2 == 11) {
            return decodePublishPayload(byteBuf, i);
        }
        if (i2 == 3) {
            return decodeSubscribePayload(byteBuf, i);
        }
        if (i2 == 4) {
            return decodeUnsubscribePayload(byteBuf, i);
        }
        if (i2 == 5) {
            return decodeSubackPayload(byteBuf, i);
        }
        return new Result<>(null, 0);
    }

    private static Result<MqttConnectPayload> decodeConnectionPayload(ByteBuf byteBuf, MqttConnectVariableHeader mqttConnectVariableHeader) {
        Result<String> result;
        Result<byte[]> result2;
        Result<String> result3;
        Result<byte[]> result4;
        Result<String> decodeString = decodeString(byteBuf);
        String str = (String) ((Result) decodeString).value;
        if (!MqttCodecUtil.isValidClientId(MqttVersion.fromProtocolNameAndLevel(mqttConnectVariableHeader.name(), (byte) mqttConnectVariableHeader.version()), str)) {
            throw new MqttIdentifierRejectedException("invalid clientIdentifier: " + str);
        }
        int i = ((Result) decodeString).numberOfBytesConsumed;
        if (mqttConnectVariableHeader.isWillFlag()) {
            result = decodeString(byteBuf, 0, 32767);
            int i2 = i + ((Result) result).numberOfBytesConsumed;
            result2 = decodeByteArray(byteBuf);
            i = i2 + ((Result) result2).numberOfBytesConsumed;
        } else {
            result = null;
            result2 = null;
        }
        if (mqttConnectVariableHeader.hasUserName()) {
            result3 = decodeString(byteBuf);
            i += ((Result) result3).numberOfBytesConsumed;
        } else {
            result3 = null;
        }
        if (mqttConnectVariableHeader.hasPassword()) {
            result4 = decodeByteArray(byteBuf);
            i += ((Result) result4).numberOfBytesConsumed;
        } else {
            result4 = null;
        }
        return new Result<>(new MqttConnectPayload((String) ((Result) decodeString).value, result != null ? (String) ((Result) result).value : null, result2 != null ? (byte[]) ((Result) result2).value : null, result3 != null ? (String) ((Result) result3).value : null, result4 != null ? (byte[]) ((Result) result4).value : null), i);
    }

    private static Result<MqttSubscribePayload> decodeSubscribePayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            Result<String> decodeString = decodeString(byteBuf);
            int i3 = i2 + ((Result) decodeString).numberOfBytesConsumed;
            i2 = i3 + 1;
            arrayList.add(new MqttTopicSubscription((String) ((Result) decodeString).value, MqttQoS.valueOf(byteBuf.readUnsignedByte() & 3)));
        }
        return new Result<>(new MqttSubscribePayload(arrayList), i2);
    }

    private static Result<MqttSubAckPayload> decodeSubackPayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            i2++;
            arrayList.add(Integer.valueOf(byteBuf.readUnsignedByte() & 3));
        }
        return new Result<>(new MqttSubAckPayload(arrayList), i2);
    }

    private static Result<MqttUnsubscribePayload> decodeUnsubscribePayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            Result<String> decodeString = decodeString(byteBuf);
            i2 += ((Result) decodeString).numberOfBytesConsumed;
            arrayList.add(((Result) decodeString).value);
        }
        return new Result<>(new MqttUnsubscribePayload(arrayList), i2);
    }

    private static Result<ByteBuf> decodePublishPayload(ByteBuf byteBuf, int i) {
        return new Result<>(byteBuf.readRetainedSlice(i), i);
    }

    private static Result<String> decodeString(ByteBuf byteBuf) {
        return decodeString(byteBuf, 0, Integer.MAX_VALUE);
    }

    private static Result<String> decodeString(ByteBuf byteBuf, int i, int i2) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int intValue = ((Integer) ((Result) decodeMsbLsb).value).intValue();
        int i3 = ((Result) decodeMsbLsb).numberOfBytesConsumed;
        if (intValue < i || intValue > i2) {
            byteBuf.skipBytes(intValue);
            return new Result<>(null, i3 + intValue);
        }
        String byteBuf2 = byteBuf.toString(byteBuf.readerIndex(), intValue, CharsetUtil.UTF_8);
        byteBuf.skipBytes(intValue);
        return new Result<>(byteBuf2, i3 + intValue);
    }

    private static Result<byte[]> decodeByteArray(ByteBuf byteBuf) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int intValue = ((Integer) ((Result) decodeMsbLsb).value).intValue();
        byte[] bArr = new byte[intValue];
        byteBuf.readBytes(bArr);
        return new Result<>(bArr, ((Result) decodeMsbLsb).numberOfBytesConsumed + intValue);
    }

    private static Result<Integer> decodeMsbLsb(ByteBuf byteBuf) {
        return decodeMsbLsb(byteBuf, 0, 65535);
    }

    private static Result<Integer> decodeMsbLsb(ByteBuf byteBuf, int i, int i2) {
        int readUnsignedByte = byteBuf.readUnsignedByte() | (byteBuf.readUnsignedByte() << 8);
        if (readUnsignedByte < i || readUnsignedByte > i2) {
            readUnsignedByte = -1;
        }
        return new Result<>(Integer.valueOf(readUnsignedByte), 2);
    }

    private static final class Result<T> {
        private final int numberOfBytesConsumed;
        private final T value;

        Result(T t, int i) {
            this.value = t;
            this.numberOfBytesConsumed = i;
        }
    }
}
