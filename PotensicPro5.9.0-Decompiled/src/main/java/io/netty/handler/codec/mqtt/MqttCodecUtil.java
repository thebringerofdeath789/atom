package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

/* loaded from: classes3.dex */
final class MqttCodecUtil {
    private static final int MAX_CLIENT_ID_LENGTH = 23;
    private static final int MIN_CLIENT_ID_LENGTH = 1;
    private static final char[] TOPIC_WILDCARDS = {'#', '+'};

    static boolean isValidMessageId(int i) {
        return i != 0;
    }

    static boolean isValidPublishTopicName(String str) {
        for (char c : TOPIC_WILDCARDS) {
            if (str.indexOf(c) >= 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidClientId(MqttVersion mqttVersion, String str) {
        if (mqttVersion == MqttVersion.MQTT_3_1) {
            return str != null && str.length() >= 1 && str.length() <= 23;
        }
        if (mqttVersion == MqttVersion.MQTT_3_1_1) {
            return str != null;
        }
        throw new IllegalArgumentException(mqttVersion + " is unknown mqtt version");
    }

    /* renamed from: io.netty.handler.codec.mqtt.MqttCodecUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;

        static {
            int[] iArr = new int[MqttMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType = iArr;
            try {
                iArr[MqttMessageType.PUBREL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.CONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.CONNACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBCOMP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBACK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBACK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGREQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGRESP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.DISCONNECT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    static MqttFixedHeader validateFixedHeader(MqttFixedHeader mqttFixedHeader) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()];
        if ((i == 1 || i == 2 || i == 3) && mqttFixedHeader.qosLevel() != MqttQoS.AT_LEAST_ONCE) {
            throw new DecoderException(mqttFixedHeader.messageType().name() + " message must have QoS 1");
        }
        return mqttFixedHeader;
    }

    static MqttFixedHeader resetUnusedFields(MqttFixedHeader mqttFixedHeader) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (mqttFixedHeader.isRetain()) {
                    break;
                }
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                if (mqttFixedHeader.isDup() || mqttFixedHeader.qosLevel() != MqttQoS.AT_MOST_ONCE || mqttFixedHeader.isRetain()) {
                    break;
                }
                break;
        }
        return mqttFixedHeader;
    }

    private MqttCodecUtil() {
    }
}
