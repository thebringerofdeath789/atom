package com.logan.flight.enums;

import org.apache.commons.net.telnet.TelnetCommand;

/* loaded from: classes.dex */
public enum CtrlType {
    TYPE_CANCEL_VISION(1, 0),
    TYPE_UNLOCK(2, 85),
    TYPE_LOCK(2, 170),
    TYPE_TAKE_OFF(3, 0),
    TYPE_LAND(4, 85),
    TYPE_CANCEL_LAND(4, 170),
    TYPE_POINT_FLY(5, 0),
    TYPE_CIRCLE(6, 0),
    TYPE_FOLLOW(7, 0),
    TYPE_RETURN(8, 0),
    TYPE_NO_HEAD(9, 0),
    TYPE_SWITCH_ATTITUDE(12, 85),
    TYPE_SWITCH_GPS(12, 170),
    TYPE_LOST_RETURN(13, 1),
    TYPE_LOST_LAND(13, 2),
    TYPE_LOST_HOVER(13, 3),
    TYPE_LOST_RETURN_TO_120M(13, 257),
    TYPE_CANCEL_AUTO_FLY(99, 0),
    TYPE_SAVE_TO_FLASH(TelnetCommand.GA, 0);

    public short command;
    public int result_param2;

    CtrlType(int i, int i2) {
        this.command = (short) i;
        this.result_param2 = i2;
    }
}
