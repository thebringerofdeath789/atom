package com.bea.xml.stream.events;

import aavax.xml.stream.events.Characters;

/* loaded from: classes.dex */
public class CharactersEvent extends BaseEvent implements Characters {
    private String data;
    private boolean isCData;
    private boolean isIgnorable;
    private boolean isSpace;

    public CharactersEvent() {
        this.isCData = false;
        this.isSpace = false;
        this.isIgnorable = false;
        init();
    }

    public CharactersEvent(String str) {
        this.isCData = false;
        this.isSpace = false;
        this.isIgnorable = false;
        init();
        setData(str);
    }

    public CharactersEvent(String str, boolean z) {
        this.isCData = false;
        this.isSpace = false;
        this.isIgnorable = false;
        init();
        setData(str);
        this.isCData = z;
    }

    public void setSpace(boolean z) {
        this.isSpace = z;
    }

    @Override // aavax.xml.stream.events.Characters
    public boolean isWhiteSpace() {
        return this.isSpace;
    }

    @Override // aavax.xml.stream.events.Characters
    public boolean isIgnorableWhiteSpace() {
        return this.isIgnorable;
    }

    public void setIgnorable(boolean z) {
        this.isIgnorable = z;
    }

    protected void init() {
        setEventType(4);
    }

    @Override // aavax.xml.stream.events.Characters
    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public boolean hasData() {
        return this.data != null;
    }

    @Override // aavax.xml.stream.events.Characters
    public boolean isCData() {
        return this.isCData;
    }

    public char[] getDataAsArray() {
        return this.data.toCharArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r9.write(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    @Override // com.bea.xml.stream.events.BaseEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doWriteAsEncodedUnicode(java.io.Writer r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.isCData
            if (r0 == 0) goto L16
            java.lang.String r0 = "<![CDATA["
            r9.write(r0)
            java.lang.String r0 = r8.getData()
            r9.write(r0)
            java.lang.String r0 = "]]>"
            r9.write(r0)
            goto L66
        L16:
            java.lang.String r0 = r8.getData()
            int r1 = r0.length()
            if (r1 <= 0) goto L66
            r2 = 0
            r3 = r2
        L22:
            r4 = 62
            r5 = 60
            r6 = 38
            if (r3 >= r1) goto L37
            char r7 = r0.charAt(r3)
            if (r7 == r6) goto L37
            if (r7 == r5) goto L37
            if (r7 == r4) goto L37
            int r3 = r3 + 1
            goto L22
        L37:
            if (r3 != r1) goto L3d
            r9.write(r0)
            goto L66
        L3d:
            if (r3 <= 0) goto L42
            r9.write(r0, r2, r3)
        L42:
            if (r3 >= r1) goto L66
            char r2 = r0.charAt(r3)
            if (r2 == r6) goto L5e
            if (r2 == r5) goto L58
            if (r2 == r4) goto L52
            r9.write(r2)
            goto L63
        L52:
            java.lang.String r2 = "&gt;"
            r9.write(r2)
            goto L63
        L58:
            java.lang.String r2 = "&lt;"
            r9.write(r2)
            goto L63
        L5e:
            java.lang.String r2 = "&amp;"
            r9.write(r2)
        L63:
            int r3 = r3 + 1
            goto L42
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.events.CharactersEvent.doWriteAsEncodedUnicode(java.io.Writer):void");
    }
}
