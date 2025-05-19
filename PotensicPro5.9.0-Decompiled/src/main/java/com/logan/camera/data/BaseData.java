package com.logan.camera.data;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class BaseData implements Serializable {
    public boolean equals(String str, String str2) {
        return str.trim().toLowerCase().equals(str2.trim().toLowerCase());
    }
}
