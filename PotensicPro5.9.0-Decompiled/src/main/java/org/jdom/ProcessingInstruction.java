package org.jdom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jdom.output.XMLOutputter;

/* loaded from: classes5.dex */
public class ProcessingInstruction extends Content {
    private static final String CVS_ID = "@(#) $RCSfile: ProcessingInstruction.java,v $ $Revision: 1.46 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";
    protected Map mapData;
    protected String rawData;
    protected String target;

    protected ProcessingInstruction() {
    }

    public ProcessingInstruction(String str, Map map) {
        setTarget(str);
        setData(map);
    }

    public ProcessingInstruction(String str, String str2) {
        setTarget(str);
        setData(str2);
    }

    public ProcessingInstruction setTarget(String str) {
        String checkProcessingInstructionTarget = Verifier.checkProcessingInstructionTarget(str);
        if (checkProcessingInstructionTarget != null) {
            throw new IllegalTargetException(str, checkProcessingInstructionTarget);
        }
        this.target = str;
        return this;
    }

    @Override // org.jdom.Content
    public String getValue() {
        return this.rawData;
    }

    public String getTarget() {
        return this.target;
    }

    public String getData() {
        return this.rawData;
    }

    public List getPseudoAttributeNames() {
        Set entrySet = this.mapData.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            String obj = it.next().toString();
            arrayList.add(obj.substring(0, obj.indexOf("=")));
        }
        return arrayList;
    }

    public ProcessingInstruction setData(String str) {
        String checkProcessingInstructionData = Verifier.checkProcessingInstructionData(str);
        if (checkProcessingInstructionData != null) {
            throw new IllegalDataException(str, checkProcessingInstructionData);
        }
        this.rawData = str;
        this.mapData = parseData(str);
        return this;
    }

    public ProcessingInstruction setData(Map map) {
        String processingInstruction = toString(map);
        String checkProcessingInstructionData = Verifier.checkProcessingInstructionData(processingInstruction);
        if (checkProcessingInstructionData != null) {
            throw new IllegalDataException(processingInstruction, checkProcessingInstructionData);
        }
        this.rawData = processingInstruction;
        this.mapData = map;
        return this;
    }

    public String getPseudoAttributeValue(String str) {
        return (String) this.mapData.get(str);
    }

    public ProcessingInstruction setPseudoAttribute(String str, String str2) {
        String checkProcessingInstructionData = Verifier.checkProcessingInstructionData(str);
        if (checkProcessingInstructionData != null) {
            throw new IllegalDataException(str, checkProcessingInstructionData);
        }
        String checkProcessingInstructionData2 = Verifier.checkProcessingInstructionData(str2);
        if (checkProcessingInstructionData2 != null) {
            throw new IllegalDataException(str2, checkProcessingInstructionData2);
        }
        this.mapData.put(str, str2);
        this.rawData = toString(this.mapData);
        return this;
    }

    public boolean removePseudoAttribute(String str) {
        if (this.mapData.remove(str) == null) {
            return false;
        }
        this.rawData = toString(this.mapData);
        return true;
    }

    private String toString(Map map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            stringBuffer.append(str).append("=\"").append((String) map.get(str)).append("\" ");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        r10 = r10.substring(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
    
        if (r2.length() <= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
    
        if (r1 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        r0.put(r2, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map parseData(java.lang.String r10) {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r10 = r10.trim()
        L9:
            java.lang.String r1 = r10.trim()
            java.lang.String r2 = ""
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L16
            return r0
        L16:
            r1 = 0
            char r3 = r10.charAt(r1)
            r4 = 1
            r6 = r1
            r5 = r4
        L1e:
            int r7 = r10.length()
            if (r5 < r7) goto L26
            r1 = r2
            goto L58
        L26:
            char r7 = r10.charAt(r5)
            r8 = 61
            if (r7 != r8) goto L68
            java.lang.String r2 = r10.substring(r6, r5)
            java.lang.String r2 = r2.trim()
            int r3 = r5 + 1
            java.lang.String r3 = r10.substring(r3)
            int[] r3 = extractQuotedString(r3)
            if (r3 != 0) goto L48
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            return r10
        L48:
            r1 = r3[r1]
            int r1 = r1 + r5
            int r1 = r1 + r4
            r6 = r3[r4]
            int r6 = r6 + r5
            int r6 = r6 + r4
            java.lang.String r1 = r10.substring(r1, r6)
            r3 = r3[r4]
            int r3 = r3 + r4
            int r5 = r5 + r3
        L58:
            java.lang.String r10 = r10.substring(r5)
            int r3 = r2.length()
            if (r3 <= 0) goto L9
            if (r1 == 0) goto L9
            r0.put(r2, r1)
            goto L9
        L68:
            boolean r3 = java.lang.Character.isWhitespace(r3)
            if (r3 == 0) goto L75
            boolean r3 = java.lang.Character.isWhitespace(r7)
            if (r3 != 0) goto L75
            r6 = r5
        L75:
            int r5 = r5 + 1
            r3 = r7
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.ProcessingInstruction.parseData(java.lang.String):java.util.Map");
    }

    private static int[] extractQuotedString(String str) {
        char c = '\"';
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\"' || charAt == '\'') {
                if (!z) {
                    i = i2 + 1;
                    c = charAt;
                    z = true;
                } else if (c == charAt) {
                    return new int[]{i, i2};
                }
            }
        }
        return null;
    }

    public String toString() {
        return new StringBuffer().append("[ProcessingInstruction: ").append(new XMLOutputter().outputString(this)).append("]").toString();
    }

    @Override // org.jdom.Content, org.jdom.Parent
    public Object clone() {
        ProcessingInstruction processingInstruction = (ProcessingInstruction) super.clone();
        if (this.mapData != null) {
            processingInstruction.mapData = parseData(this.rawData);
        }
        return processingInstruction;
    }
}
