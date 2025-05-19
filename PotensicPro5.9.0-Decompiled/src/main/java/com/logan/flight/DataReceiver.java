package com.logan.flight;

/* loaded from: classes.dex */
public class DataReceiver {
    private static volatile DataReceiver instance;

    private DataReceiver() {
    }

    public static DataReceiver getInstance() {
        if (instance == null) {
            synchronized (DataReceiver.class) {
                if (instance == null) {
                    DataReceiver dataReceiver = new DataReceiver();
                    instance = dataReceiver;
                    return dataReceiver;
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0970 A[Catch: all -> 0x09f2, Exception -> 0x09f4, TryCatch #1 {Exception -> 0x09f4, blocks: (B:3:0x0001, B:5:0x000d, B:9:0x0019, B:10:0x001c, B:11:0x001f, B:12:0x0022, B:13:0x0025, B:14:0x0028, B:16:0x002d, B:17:0x006e, B:18:0x009e, B:19:0x00df, B:20:0x010c, B:21:0x011c, B:22:0x0155, B:23:0x018e, B:24:0x01ea, B:26:0x01f2, B:27:0x024e, B:29:0x0267, B:30:0x028a, B:31:0x02a4, B:32:0x02dd, B:34:0x02e5, B:35:0x030b, B:36:0x0367, B:37:0x03c3, B:38:0x041f, B:39:0x0460, B:40:0x04a1, B:41:0x04e2, B:42:0x053e, B:44:0x0544, B:45:0x0585, B:46:0x05c6, B:48:0x05df, B:49:0x0615, B:50:0x064b, B:51:0x0669, B:52:0x06aa, B:53:0x0706, B:54:0x0762, B:56:0x0782, B:57:0x07a0, B:58:0x07be, B:59:0x081a, B:60:0x0876, B:61:0x08d2, B:62:0x092e, B:63:0x0934, B:65:0x0937, B:67:0x0941, B:69:0x094b, B:71:0x0955, B:73:0x095f, B:75:0x096a, B:80:0x0970, B:81:0x09a8, B:90:0x09bc, B:96:0x09cb), top: B:2:0x0001, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x09a8 A[Catch: all -> 0x09f2, Exception -> 0x09f4, TryCatch #1 {Exception -> 0x09f4, blocks: (B:3:0x0001, B:5:0x000d, B:9:0x0019, B:10:0x001c, B:11:0x001f, B:12:0x0022, B:13:0x0025, B:14:0x0028, B:16:0x002d, B:17:0x006e, B:18:0x009e, B:19:0x00df, B:20:0x010c, B:21:0x011c, B:22:0x0155, B:23:0x018e, B:24:0x01ea, B:26:0x01f2, B:27:0x024e, B:29:0x0267, B:30:0x028a, B:31:0x02a4, B:32:0x02dd, B:34:0x02e5, B:35:0x030b, B:36:0x0367, B:37:0x03c3, B:38:0x041f, B:39:0x0460, B:40:0x04a1, B:41:0x04e2, B:42:0x053e, B:44:0x0544, B:45:0x0585, B:46:0x05c6, B:48:0x05df, B:49:0x0615, B:50:0x064b, B:51:0x0669, B:52:0x06aa, B:53:0x0706, B:54:0x0762, B:56:0x0782, B:57:0x07a0, B:58:0x07be, B:59:0x081a, B:60:0x0876, B:61:0x08d2, B:62:0x092e, B:63:0x0934, B:65:0x0937, B:67:0x0941, B:69:0x094b, B:71:0x0955, B:73:0x095f, B:75:0x096a, B:80:0x0970, B:81:0x09a8, B:90:0x09bc, B:96:0x09cb), top: B:2:0x0001, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void onDataParsed(com.logan.usb.parser_new.Frame r7) {
        /*
            Method dump skipped, instructions count: 2680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.logan.flight.DataReceiver.onDataParsed(com.logan.usb.parser_new.Frame):void");
    }
}
