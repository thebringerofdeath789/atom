package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;

/* loaded from: classes5.dex */
final class OperandClassTransformer {
    private final int _formulaType;

    public OperandClassTransformer(int i) {
        this._formulaType = i;
    }

    public void transformFormula(ParseNode parseNode) {
        byte b;
        int i = this._formulaType;
        if (i == 0) {
            b = 32;
        } else if (i == 2) {
            b = 64;
        } else {
            if (i != 4 && i != 5) {
                throw new RuntimeException("Incomplete code - formula type (" + this._formulaType + ") not supported yet");
            }
            b = 0;
        }
        transformNode(parseNode, b, false);
    }

    private void transformNode(ParseNode parseNode, byte b, boolean z) {
        Ptg token = parseNode.getToken();
        ParseNode[] children = parseNode.getChildren();
        int i = 0;
        if (isSimpleValueFunction(token)) {
            boolean z2 = b == 64;
            while (i < children.length) {
                transformNode(children[i], b, z2);
                i++;
            }
            setSimpleValueFuncClass((AbstractFunctionPtg) token, b, z);
            return;
        }
        if (isSingleArgSum(token)) {
            token = FuncVarPtg.SUM;
        }
        if ((token instanceof ValueOperatorPtg) || (token instanceof ControlPtg) || (token instanceof MemFuncPtg) || (token instanceof MemAreaPtg) || (token instanceof UnionPtg)) {
            if (b == 0) {
                b = 32;
            }
            while (i < children.length) {
                transformNode(children[i], b, z);
                i++;
            }
            return;
        }
        if (token instanceof AbstractFunctionPtg) {
            transformFunctionNode((AbstractFunctionPtg) token, children, b, z);
            return;
        }
        if (children.length > 0) {
            if (token != RangePtg.instance) {
                throw new IllegalStateException("Node should not have any children");
            }
        } else {
            if (token.isBaseToken()) {
                return;
            }
            token.setClass(transformClass(token.getPtgClass(), b, z));
        }
    }

    private static boolean isSingleArgSum(Ptg ptg) {
        if (ptg instanceof AttrPtg) {
            return ((AttrPtg) ptg).isSum();
        }
        return false;
    }

    private static boolean isSimpleValueFunction(Ptg ptg) {
        if (!(ptg instanceof AbstractFunctionPtg)) {
            return false;
        }
        AbstractFunctionPtg abstractFunctionPtg = (AbstractFunctionPtg) ptg;
        if (abstractFunctionPtg.getDefaultOperandClass() != 32) {
            return false;
        }
        for (int numberOfOperands = abstractFunctionPtg.getNumberOfOperands() - 1; numberOfOperands >= 0; numberOfOperands--) {
            if (abstractFunctionPtg.getParameterClass(numberOfOperands) != 32) {
                return false;
            }
        }
        return true;
    }

    private byte transformClass(byte b, byte b2, boolean z) {
        if (b2 == 0) {
            if (z) {
                return (byte) 0;
            }
            return b;
        }
        if (b2 != 32) {
            if (b2 != 64) {
                throw new IllegalStateException("Unexpected operand class (" + ((int) b2) + ")");
            }
        } else if (!z) {
            return (byte) 32;
        }
        return (byte) 64;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        if (r0 == 32) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00c4 A[LOOP:0: B:9:0x00c1->B:11:0x00c4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void transformFunctionNode(org.apache.poi.ss.formula.ptg.AbstractFunctionPtg r8, org.apache.poi.ss.formula.ParseNode[] r9, byte r10, boolean r11) {
        /*
            r7 = this;
            byte r0 = r8.getDefaultOperandClass()
            r1 = 1
            java.lang.String r2 = ")"
            java.lang.String r3 = "Unexpected operand class ("
            r4 = 32
            r5 = 64
            r6 = 0
            if (r11 == 0) goto L44
            if (r0 == 0) goto L3a
            if (r0 == r4) goto L35
            if (r0 != r5) goto L1a
            r8.setClass(r5)
            goto L79
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r3)
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r9 = r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L35:
            r8.setClass(r5)
            goto Lc1
        L3a:
            if (r10 != 0) goto L40
            r8.setClass(r6)
            goto L79
        L40:
            r8.setClass(r5)
            goto L79
        L44:
            if (r0 != r10) goto L4a
            r8.setClass(r0)
            goto L79
        L4a:
            if (r10 == 0) goto L9a
            if (r10 == r4) goto L96
            if (r10 != r5) goto L7b
            if (r0 == 0) goto L73
            if (r0 != r4) goto L58
            r8.setClass(r5)
            goto L76
        L58:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r3)
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r9 = r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L73:
            r8.setClass(r6)
        L76:
            if (r0 != r4) goto L79
            goto Lc1
        L79:
            r1 = r6
            goto Lc1
        L7b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r3)
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L96:
            r8.setClass(r4)
            goto L79
        L9a:
            if (r0 == r4) goto Lbd
            if (r0 != r5) goto La2
            r8.setClass(r5)
            goto L79
        La2:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r3)
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r9 = r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        Lbd:
            r8.setClass(r4)
            goto L79
        Lc1:
            int r10 = r9.length
            if (r6 >= r10) goto Ld0
            r10 = r9[r6]
            byte r11 = r8.getParameterClass(r6)
            r7.transformNode(r10, r11, r1)
            int r6 = r6 + 1
            goto Lc1
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.OperandClassTransformer.transformFunctionNode(org.apache.poi.ss.formula.ptg.AbstractFunctionPtg, org.apache.poi.ss.formula.ParseNode[], byte, boolean):void");
    }

    private void setSimpleValueFuncClass(AbstractFunctionPtg abstractFunctionPtg, byte b, boolean z) {
        if (z || b == 64) {
            abstractFunctionPtg.setClass((byte) 64);
        } else {
            abstractFunctionPtg.setClass((byte) 32);
        }
    }
}
