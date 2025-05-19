package com.ipotensic.baselib;

import com.ipotensic.baselib.utils.FormatUtil;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class Token implements Serializable {
    private String avatar;
    private int brandcode;
    private String countryname;
    private String email;
    private String firmwareClass;
    private int id;
    private String intime;
    private String location;
    private String nicname;
    private String productClass;
    private String regtime;
    private int status;
    private String timeout;
    private String token;
    private String userdevice;

    public String getCountryname() {
        return this.countryname;
    }

    public void setCountryname(String str) {
        this.countryname = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getNicname() {
        return this.nicname;
    }

    public void setNicname(String str) {
        this.nicname = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getRegtime() {
        return this.regtime;
    }

    public void setRegtime(String str) {
        this.regtime = str;
    }

    public String getIntime() {
        return this.intime;
    }

    public void setIntime(String str) {
        this.intime = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }

    public String getUserdevice() {
        return this.userdevice;
    }

    public void setUserdevice(String str) {
        this.userdevice = str;
    }

    public int getBrandcode() {
        return this.brandcode;
    }

    public void setBrandcode(int i) {
        this.brandcode = i;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public boolean isTokenValid() {
        String str = this.timeout;
        if (str == null) {
            return false;
        }
        try {
            return FormatUtil.getMillisTime(str) > System.currentTimeMillis();
        } catch (Exception unused) {
            return false;
        }
    }

    public String getProductClass() {
        return this.productClass;
    }

    public void setProductClass(String str) {
        this.productClass = str;
    }

    public String getFirmwareClass() {
        return this.firmwareClass;
    }

    public void setFirmwareClass(String str) {
        this.firmwareClass = str;
    }

    public String toString() {
        return "Token{id=" + this.id + ", email='" + this.email + "', nicname='" + this.nicname + "', location='" + this.location + "', regtime='" + this.regtime + "', intime='" + this.intime + "', status=" + this.status + ", token='" + this.token + "', timeout='" + this.timeout + "', userdevice='" + this.userdevice + "', brandcode=" + this.brandcode + ", avatar='" + this.avatar + "'}";
    }
}
