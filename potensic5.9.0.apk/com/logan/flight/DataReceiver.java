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

    /* JADX WARN: Removed duplicated region for block: B:83:0x0a2d A[Catch: all -> 0x0aaf, Exception -> 0x0ab1, TryCatch #0 {Exception -> 0x0ab1, blocks: (B:4:0x0001, B:6:0x000d, B:10:0x0019, B:11:0x001c, B:12:0x001f, B:13:0x0022, B:14:0x0025, B:16:0x002a, B:17:0x006b, B:18:0x009b, B:19:0x00dc, B:20:0x0109, B:21:0x0119, B:22:0x015a, B:23:0x019b, B:24:0x01d4, B:25:0x020d, B:26:0x0269, B:28:0x0271, B:29:0x02cd, B:31:0x02e6, B:32:0x0309, B:33:0x0323, B:34:0x035c, B:36:0x0364, B:37:0x038a, B:38:0x03e6, B:39:0x0442, B:40:0x049e, B:41:0x04df, B:42:0x0520, B:43:0x0561, B:44:0x05bd, B:46:0x05c3, B:47:0x0604, B:48:0x0645, B:50:0x065e, B:51:0x0694, B:52:0x083a, B:53:0x06ca, B:54:0x06e8, B:55:0x0729, B:56:0x0785, B:57:0x07e1, B:59:0x0801, B:60:0x081e, B:61:0x087b, B:62:0x08d7, B:63:0x0933, B:64:0x098f, B:65:0x09eb, B:66:0x09f1, B:68:0x09f4, B:70:0x09fe, B:72:0x0a08, B:74:0x0a12, B:76:0x0a1c, B:78:0x0a27, B:83:0x0a2d, B:84:0x0a65, B:93:0x0a79, B:99:0x0a88), top: B:3:0x0001, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0a65 A[Catch: all -> 0x0aaf, Exception -> 0x0ab1, TryCatch #0 {Exception -> 0x0ab1, blocks: (B:4:0x0001, B:6:0x000d, B:10:0x0019, B:11:0x001c, B:12:0x001f, B:13:0x0022, B:14:0x0025, B:16:0x002a, B:17:0x006b, B:18:0x009b, B:19:0x00dc, B:20:0x0109, B:21:0x0119, B:22:0x015a, B:23:0x019b, B:24:0x01d4, B:25:0x020d, B:26:0x0269, B:28:0x0271, B:29:0x02cd, B:31:0x02e6, B:32:0x0309, B:33:0x0323, B:34:0x035c, B:36:0x0364, B:37:0x038a, B:38:0x03e6, B:39:0x0442, B:40:0x049e, B:41:0x04df, B:42:0x0520, B:43:0x0561, B:44:0x05bd, B:46:0x05c3, B:47:0x0604, B:48:0x0645, B:50:0x065e, B:51:0x0694, B:52:0x083a, B:53:0x06ca, B:54:0x06e8, B:55:0x0729, B:56:0x0785, B:57:0x07e1, B:59:0x0801, B:60:0x081e, B:61:0x087b, B:62:0x08d7, B:63:0x0933, B:64:0x098f, B:65:0x09eb, B:66:0x09f1, B:68:0x09f4, B:70:0x09fe, B:72:0x0a08, B:74:0x0a12, B:76:0x0a1c, B:78:0x0a27, B:83:0x0a2d, B:84:0x0a65, B:93:0x0a79, B:99:0x0a88), top: B:3:0x0001, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void onDataParsed(com.logan.usb.parser_new.Frame r7) {
        /*
            Method dump skipped, instructions count: 2870
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.logan.flight.DataReceiver.onDataParsed(com.logan.usb.parser_new.Frame):void");
    }
}