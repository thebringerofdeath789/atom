package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttConnectVariableHeader {
    private final boolean hasPassword;
    private final boolean hasUserName;
    private final boolean isCleanSession;
    private final boolean isWillFlag;
    private final boolean isWillRetain;
    private final int keepAliveTimeSeconds;
    private final String name;
    private final int version;
    private final int willQos;

    public MqttConnectVariableHeader(String str, int i, boolean z, boolean z2, boolean z3, int i2, boolean z4, boolean z5, int i3) {
        this.name = str;
        this.version = i;
        this.hasUserName = z;
        this.hasPassword = z2;
        this.isWillRetain = z3;
        this.willQos = i2;
        this.isWillFlag = z4;
        this.isCleanSession = z5;
        this.keepAliveTimeSeconds = i3;
    }

    public String name() {
        return this.name;
    }

    public int version() {
        return this.version;
    }

    public boolean hasUserName() {
        return this.hasUserName;
    }

    public boolean hasPassword() {
        return this.hasPassword;
    }

    public boolean isWillRetain() {
        return this.isWillRetain;
    }

    public int willQos() {
        return this.willQos;
    }

    public boolean isWillFlag() {
        return this.isWillFlag;
    }

    public boolean isCleanSession() {
        return this.isCleanSession;
    }

    public int keepAliveTimeSeconds() {
        return this.keepAliveTimeSeconds;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "name=" + this.name + ", version=" + this.version + ", hasUserName=" + this.hasUserName + ", hasPassword=" + this.hasPassword + ", isWillRetain=" + this.isWillRetain + ", isWillFlag=" + this.isWillFlag + ", isCleanSession=" + this.isCleanSession + ", keepAliveTimeSeconds=" + this.keepAliveTimeSeconds + PropertyUtils.INDEXED_DELIM2;
    }
}
