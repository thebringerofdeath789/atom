package com.logan.camera.data;

import com.logan.camera.enums.StatusEnum;

/* loaded from: classes2.dex */
public class StatusData extends BaseData {
    private String stateString;
    private StatusEnum status;

    public StatusData(String str) {
        this.stateString = str;
        if (equals(str, StatusEnum.STATUS_SUCCESS.getValue())) {
            this.status = StatusEnum.STATUS_SUCCESS;
        } else if (equals(str, StatusEnum.STATUS_NO_SD_CARD.getValue())) {
            this.status = StatusEnum.STATUS_NO_SD_CARD;
        } else if (equals(str, StatusEnum.STATUS_SD_CARD_FULL.getValue())) {
            this.status = StatusEnum.STATUS_SD_CARD_FULL;
        }
    }

    public StatusEnum getStatus() {
        return this.status;
    }

    public String getStateString() {
        return this.stateString;
    }
}
