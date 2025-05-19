package org.apache.xmlbeans.impl.common;

import aavax.xml.namespace.QName;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;

/* loaded from: classes5.dex */
public class XPath {
    public static final String _DEFAULT_ELT_NS = "$xmlbeans!default_uri";
    public static final String _NS_BOUNDARY = "$xmlbeans!ns_boundary";
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$XPath;
    private final boolean _sawDeepDot;
    private final Selector _selector;

    public static class XPathCompileException extends XmlException {
        XPathCompileException(XmlError xmlError) {
            super(xmlError.toString(), (Throwable) null, xmlError);
        }
    }

    public static class ExecutionContext {
        static final /* synthetic */ boolean $assertionsDisabled;
        public static final int ATTRS = 4;
        public static final int DESCEND = 2;
        public static final int HIT = 1;
        private PathContext[] _paths;
        private ArrayList _stack = new ArrayList();
        private XPath _xpath;

        static {
            if (XPath.class$org$apache$xmlbeans$impl$common$XPath == null) {
                XPath.class$org$apache$xmlbeans$impl$common$XPath = XPath.class$("org.apache.xmlbeans.impl.common.XPath");
            } else {
                Class cls = XPath.class$org$apache$xmlbeans$impl$common$XPath;
            }
            $assertionsDisabled = true;
        }

        public final void init(XPath xPath) {
            int i = 0;
            if (this._xpath != xPath) {
                this._xpath = xPath;
                this._paths = new PathContext[xPath._selector._paths.length];
                int i2 = 0;
                while (true) {
                    PathContext[] pathContextArr = this._paths;
                    if (i2 >= pathContextArr.length) {
                        break;
                    }
                    pathContextArr[i2] = new PathContext();
                    i2++;
                }
            }
            this._stack.clear();
            while (true) {
                PathContext[] pathContextArr2 = this._paths;
                if (i >= pathContextArr2.length) {
                    return;
                }
                pathContextArr2[i].init(xPath._selector._paths[i]);
                i++;
            }
        }

        public final int start() {
            int i = 0;
            int i2 = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return i2;
                }
                i2 |= pathContextArr[i].start();
                i++;
            }
        }

        public final int element(QName qName) {
            if (!$assertionsDisabled && qName == null) {
                throw new AssertionError();
            }
            this._stack.add(qName);
            int i = 0;
            int i2 = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return i2;
                }
                i2 |= pathContextArr[i].element(qName);
                i++;
            }
        }

        public final boolean attr(QName qName) {
            int i = 0;
            boolean z = false;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return z;
                }
                z |= pathContextArr[i].attr(qName);
                i++;
            }
        }

        public final void end() {
            this._stack.remove(r0.size() - 1);
            int i = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return;
                }
                pathContextArr[i].end();
                i++;
            }
        }

        private final class PathContext {
            static final /* synthetic */ boolean $assertionsDisabled;
            private Step _curr;
            private List _prev = new ArrayList();

            static {
                if (XPath.class$org$apache$xmlbeans$impl$common$XPath == null) {
                    XPath.class$org$apache$xmlbeans$impl$common$XPath = XPath.class$("org.apache.xmlbeans.impl.common.XPath");
                } else {
                    Class cls = XPath.class$org$apache$xmlbeans$impl$common$XPath;
                }
                $assertionsDisabled = true;
            }

            PathContext() {
            }

            void init(Step step) {
                this._curr = step;
                this._prev.clear();
            }

            private QName top(int i) {
                return (QName) ExecutionContext.this._stack.get((ExecutionContext.this._stack.size() - 1) - i);
            }

            /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
            
                r3._curr = r3._curr._prev;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void backtrack() {
                /*
                    r3 = this;
                    boolean r0 = org.apache.xmlbeans.impl.common.XPath.ExecutionContext.PathContext.$assertionsDisabled
                    if (r0 != 0) goto Lf
                    org.apache.xmlbeans.impl.common.XPath$Step r1 = r3._curr
                    if (r1 == 0) goto L9
                    goto Lf
                L9:
                    java.lang.AssertionError r0 = new java.lang.AssertionError
                    r0.<init>()
                    throw r0
                Lf:
                    org.apache.xmlbeans.impl.common.XPath$Step r1 = r3._curr
                    boolean r1 = r1._hasBacktrack
                    if (r1 == 0) goto L1c
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r3._curr
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r0._backtrack
                    r3._curr = r0
                    return
                L1c:
                    if (r0 != 0) goto L2b
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r3._curr
                    boolean r0 = r0._deep
                    if (r0 != 0) goto L25
                    goto L2b
                L25:
                    java.lang.AssertionError r0 = new java.lang.AssertionError
                    r0.<init>()
                    throw r0
                L2b:
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r3._curr
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r0._prev
                    r3._curr = r0
                L31:
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r3._curr
                    boolean r0 = r0._deep
                    if (r0 != 0) goto L55
                    r0 = 0
                    org.apache.xmlbeans.impl.common.XPath$Step r1 = r3._curr
                L3a:
                    boolean r2 = r1._deep
                    if (r2 != 0) goto L55
                    int r2 = r0 + 1
                    aavax.xml.namespace.QName r0 = r3.top(r0)
                    boolean r0 = r1.match(r0)
                    if (r0 != 0) goto L51
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r3._curr
                    org.apache.xmlbeans.impl.common.XPath$Step r0 = r0._prev
                    r3._curr = r0
                    goto L31
                L51:
                    org.apache.xmlbeans.impl.common.XPath$Step r1 = r1._prev
                    r0 = r2
                    goto L3a
                L55:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.common.XPath.ExecutionContext.PathContext.backtrack():void");
            }

            int start() {
                boolean z = $assertionsDisabled;
                if (!z && this._curr == null) {
                    throw new AssertionError();
                }
                if (!z && this._curr._prev != null) {
                    throw new AssertionError();
                }
                if (this._curr._name != null) {
                    return this._curr._flags;
                }
                this._curr = null;
                return 1;
            }

            int element(QName qName) {
                this._prev.add(this._curr);
                Step step = this._curr;
                if (step == null) {
                    return 0;
                }
                if (!$assertionsDisabled && step._name == null) {
                    throw new AssertionError();
                }
                if (!this._curr._attr && this._curr.match(qName)) {
                    Step step2 = this._curr._next;
                    this._curr = step2;
                    if (step2._name != null) {
                        return this._curr._flags;
                    }
                    backtrack();
                    Step step3 = this._curr;
                    if (step3 == null) {
                        return 1;
                    }
                    return 1 | step3._flags;
                }
                while (true) {
                    backtrack();
                    Step step4 = this._curr;
                    if (step4 == null) {
                        return 0;
                    }
                    if (step4.match(qName)) {
                        this._curr = this._curr._next;
                        break;
                    }
                    if (this._curr._deep) {
                        break;
                    }
                }
                return this._curr._flags;
            }

            boolean attr(QName qName) {
                Step step = this._curr;
                return step != null && step._attr && this._curr.match(qName);
            }

            void end() {
                this._curr = (Step) this._prev.remove(r0.size() - 1);
            }
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static XPath compileXPath(String str) throws XPathCompileException {
        return compileXPath(str, "$this", null);
    }

    public static XPath compileXPath(String str, String str2) throws XPathCompileException {
        return compileXPath(str, str2, null);
    }

    public static XPath compileXPath(String str, Map map) throws XPathCompileException {
        return compileXPath(str, "$this", map);
    }

    public static XPath compileXPath(String str, String str2, Map map) throws XPathCompileException {
        return new CompilationContext(map, str2).compile(str);
    }

    private static class CompilationContext {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int _column;
        private String _currentNodeVar;
        private String _expr;
        private Map _externalNamespaces;
        private boolean _lastDeepDot;
        private int _line;
        protected Map _namespaces;
        private int _offset;
        private boolean _sawDeepDot;

        private void processNonXpathDecls() {
        }

        static {
            if (XPath.class$org$apache$xmlbeans$impl$common$XPath == null) {
                XPath.class$org$apache$xmlbeans$impl$common$XPath = XPath.class$("org.apache.xmlbeans.impl.common.XPath");
            } else {
                Class cls = XPath.class$org$apache$xmlbeans$impl$common$XPath;
            }
            $assertionsDisabled = true;
        }

        CompilationContext(Map map, String str) {
            String str2;
            if (!$assertionsDisabled && (str2 = this._currentNodeVar) != null && !str2.startsWith("$")) {
                throw new AssertionError();
            }
            if (str == null) {
                this._currentNodeVar = "$this";
            } else {
                this._currentNodeVar = str;
            }
            this._namespaces = new HashMap();
            this._externalNamespaces = map == null ? new HashMap() : map;
        }

        XPath compile(String str) throws XPathCompileException {
            this._offset = 0;
            this._line = 1;
            this._column = 1;
            this._expr = str;
            return tokenizeXPath();
        }

        int currChar() {
            return currChar(0);
        }

        int currChar(int i) {
            if (this._offset + i >= this._expr.length()) {
                return -1;
            }
            return this._expr.charAt(this._offset + i);
        }

        void advance() {
            if (this._offset < this._expr.length()) {
                char charAt = this._expr.charAt(this._offset);
                int i = this._offset + 1;
                this._offset = i;
                this._column++;
                if (charAt == '\r' || charAt == '\n') {
                    this._line++;
                    this._column = 1;
                    if (i + 1 < this._expr.length()) {
                        char charAt2 = this._expr.charAt(this._offset + 1);
                        if ((charAt2 == '\r' || charAt2 == '\n') && charAt != charAt2) {
                            this._offset++;
                        }
                    }
                }
            }
        }

        void advance(int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return;
                }
                advance();
                i = i2;
            }
        }

        boolean isWhitespace() {
            return isWhitespace(0);
        }

        boolean isWhitespace(int i) {
            int currChar = currChar(i);
            return currChar == 32 || currChar == 9 || currChar == 10 || currChar == 13;
        }

        boolean isNCNameStart() {
            if (currChar() == -1) {
                return false;
            }
            return XMLChar.isNCNameStart(currChar());
        }

        boolean isNCName() {
            if (currChar() == -1) {
                return false;
            }
            return XMLChar.isNCName(currChar());
        }

        boolean startsWith(String str) {
            return startsWith(str, 0);
        }

        boolean startsWith(String str, int i) {
            if (this._offset + i >= this._expr.length()) {
                return false;
            }
            return this._expr.startsWith(str, this._offset + i);
        }

        private XPathCompileException newError(String str) {
            return new XPathCompileException(XmlError.forLocation(str, 0, null, this._line, this._column, this._offset));
        }

        String lookupPrefix(String str) throws XPathCompileException {
            if (this._namespaces.containsKey(str)) {
                return (String) this._namespaces.get(str);
            }
            if (this._externalNamespaces.containsKey(str)) {
                return (String) this._externalNamespaces.get(str);
            }
            if (str.equals("xml")) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            if (str.equals("xs")) {
                return "http://www.w3.org/2001/XMLSchema";
            }
            if (str.equals("xsi")) {
                return "http://www.w3.org/2001/XMLSchema-instance";
            }
            if (str.equals("fn")) {
                return "http://www.w3.org/2002/11/xquery-functions";
            }
            if (str.equals("xdt")) {
                return "http://www.w3.org/2003/11/xpath-datatypes";
            }
            if (str.equals("local")) {
                return "http://www.w3.org/2003/11/xquery-local-functions";
            }
            throw newError(new StringBuffer().append("Undefined prefix: ").append(str).toString());
        }

        private boolean parseWhitespace() throws XPathCompileException {
            boolean z = false;
            while (isWhitespace()) {
                advance();
                z = true;
            }
            return z;
        }

        private boolean tokenize(String str) {
            if (!$assertionsDisabled && str.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            advance(i + str.length());
            return true;
        }

        private boolean tokenize(String str, String str2) {
            boolean z = $assertionsDisabled;
            if (!z && str.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str2.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = i + str.length();
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            advance(length + str2.length());
            return true;
        }

        private boolean tokenize(String str, String str2, String str3) {
            boolean z = $assertionsDisabled;
            if (!z && str.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str2.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str3.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = i + str.length();
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            int length2 = length + str2.length();
            while (isWhitespace(length2)) {
                length2++;
            }
            if (!startsWith(str3, length2)) {
                return false;
            }
            int length3 = length2 + str3.length();
            while (isWhitespace(length3)) {
                length3++;
            }
            advance(length3);
            return true;
        }

        private boolean tokenize(String str, String str2, String str3, String str4) {
            boolean z = $assertionsDisabled;
            if (!z && str.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str2.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str3.length() <= 0) {
                throw new AssertionError();
            }
            if (!z && str4.length() <= 0) {
                throw new AssertionError();
            }
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = i + str.length();
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            int length2 = length + str2.length();
            while (isWhitespace(length2)) {
                length2++;
            }
            if (!startsWith(str3, length2)) {
                return false;
            }
            int length3 = length2 + str3.length();
            while (isWhitespace(length3)) {
                length3++;
            }
            if (!startsWith(str4, length3)) {
                return false;
            }
            advance(length3 + str4.length());
            return true;
        }

        private String tokenizeNCName() throws XPathCompileException {
            parseWhitespace();
            if (!isNCNameStart()) {
                throw newError("Expected non-colonized name");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((char) currChar());
            while (true) {
                advance();
                if (isNCName()) {
                    stringBuffer.append((char) currChar());
                } else {
                    return stringBuffer.toString();
                }
            }
        }

        private QName getAnyQName() {
            return new QName("", "");
        }

        private QName tokenizeQName() throws XPathCompileException {
            if (tokenize(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                return getAnyQName();
            }
            String str = tokenizeNCName();
            if (!tokenize(":")) {
                return new QName(lookupPrefix(""), str);
            }
            return new QName(lookupPrefix(str), tokenize(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) ? "" : tokenizeNCName());
        }

        private String tokenizeQuotedUri() throws XPathCompileException {
            int i;
            if (tokenize("\"")) {
                i = 34;
            } else {
                if (!tokenize("'")) {
                    throw newError("Expected quote (\" or ')");
                }
                i = 39;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (currChar() != -1) {
                if (currChar() == i) {
                    advance();
                    if (currChar() != i) {
                        return stringBuffer.toString();
                    }
                }
                stringBuffer.append((char) currChar());
                advance();
            }
            throw newError("Path terminated in URI literal");
        }

        private Step addStep(boolean z, boolean z2, QName qName, Step step) {
            Step step2 = new Step(z, z2, qName);
            if (step == null) {
                return step2;
            }
            Step step3 = step;
            while (step3._next != null) {
                step3 = step3._next;
            }
            step3._next = step2;
            step2._prev = step3;
            return step;
        }

        private Step tokenizeSteps() throws XPathCompileException {
            boolean z;
            boolean z2;
            if (tokenize(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                throw newError("Absolute paths unsupported");
            }
            if (tokenize("$", this._currentNodeVar, "//") || tokenize(".", "//")) {
                z = true;
            } else {
                if (!tokenize("$", this._currentNodeVar, InternalZipConstants.ZIP_FILE_SEPARATOR) && !tokenize(".", InternalZipConstants.ZIP_FILE_SEPARATOR) && (tokenize("$", this._currentNodeVar) || tokenize("."))) {
                    return addStep(false, false, null, null);
                }
                z = false;
            }
            Step step = null;
            loop0: while (true) {
                z2 = false;
                while (!tokenize("attribute", "::") && !tokenize("@")) {
                    if (tokenize(".")) {
                        z2 = z2 || z;
                    } else {
                        tokenize("child", "::");
                        QName qName = tokenizeQName();
                        if (qName != null) {
                            step = addStep(z, false, qName, step);
                            z = false;
                        }
                    }
                    if (!tokenize("//")) {
                        if (!tokenize(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                            break loop0;
                        }
                        if (z2) {
                            z = true;
                        }
                    } else {
                        break;
                    }
                }
                z = true;
            }
            step = addStep(z, true, tokenizeQName(), step);
            this._lastDeepDot = z2;
            if (z2) {
                this._lastDeepDot = true;
                step = addStep(true, false, getAnyQName(), step);
            }
            return addStep(false, false, null, step);
        }

        private void computeBacktrack(Step step) throws XPathCompileException {
            Step step2;
            while (step != null) {
                Step step3 = step._next;
                while (step3 != null && !step3._deep) {
                    step3 = step3._next;
                }
                if (step._deep) {
                    int i = 0;
                    Step step4 = step;
                    int i2 = 0;
                    while (step4 != step3 && step4._name != null && !step4.isWild() && !step4._attr) {
                        i2++;
                        step4 = step4._next;
                    }
                    int i3 = i2 + 1;
                    Object[] objArr = new QName[i3];
                    int[] iArr = new int[i3];
                    Step step5 = step;
                    for (int i4 = 0; i4 < i2; i4++) {
                        objArr[i4] = step5._name;
                        step5 = step5._next;
                    }
                    objArr[i2] = getAnyQName();
                    iArr[0] = -1;
                    int i5 = 0;
                    int i6 = -1;
                    while (i5 < i2) {
                        while (i6 > -1 && !objArr[i5].equals(objArr[i6])) {
                            i6 = iArr[i6];
                        }
                        i5++;
                        i6++;
                        if (objArr[i5].equals(objArr[i6])) {
                            iArr[i5] = iArr[i6];
                        } else {
                            iArr[i5] = i6;
                        }
                    }
                    for (Step step6 = step; step6 != step4; step6 = step6._next) {
                        step6._hasBacktrack = true;
                        step6._backtrack = step;
                        for (int i7 = iArr[i]; i7 > 0; i7--) {
                            step6._backtrack = step6._backtrack._next;
                        }
                        i++;
                    }
                    if (i2 > 1) {
                        step2 = step;
                        for (int i8 = iArr[i2 - 1]; i8 > 0; i8--) {
                            step2 = step2._next;
                        }
                    } else {
                        step2 = step;
                    }
                    if (step4 != step3 && step4._attr) {
                        step4._hasBacktrack = true;
                        step4._backtrack = step2;
                        step4 = step4._next;
                    }
                    if (step4 != step3 && step4._name == null) {
                        step4._hasBacktrack = true;
                        step4._backtrack = step2;
                    }
                    if (!$assertionsDisabled && !step._deep) {
                        throw new AssertionError();
                    }
                    step._hasBacktrack = true;
                    step._backtrack = step;
                } else {
                    while (step != step3) {
                        step._hasBacktrack = true;
                        step = step._next;
                    }
                }
                step = step3;
            }
        }

        private void tokenizePath(ArrayList arrayList) throws XPathCompileException {
            this._lastDeepDot = false;
            Step step = tokenizeSteps();
            computeBacktrack(step);
            arrayList.add(step);
            if (this._lastDeepDot) {
                this._sawDeepDot = true;
                Step step2 = null;
                while (step != null) {
                    if (step._next != null && step._next._next == null) {
                        step2 = addStep(step._deep, true, step._name, step2);
                    } else {
                        step2 = addStep(step._deep, step._attr, step._name, step2);
                    }
                    step = step._next;
                }
                computeBacktrack(step2);
                arrayList.add(step2);
            }
        }

        private Selector tokenizeSelector() throws XPathCompileException {
            ArrayList arrayList = new ArrayList();
            tokenizePath(arrayList);
            while (tokenize("|")) {
                tokenizePath(arrayList);
            }
            return new Selector((Step[]) arrayList.toArray(new Step[0]));
        }

        private XPath tokenizeXPath() throws XPathCompileException {
            while (true) {
                if (tokenize("declare", "namespace")) {
                    if (!parseWhitespace()) {
                        throw newError("Expected prefix after 'declare namespace'");
                    }
                    String str = tokenizeNCName();
                    if (!tokenize("=")) {
                        throw newError("Expected '='");
                    }
                    String str2 = tokenizeQuotedUri();
                    if (this._namespaces.containsKey(str)) {
                        throw newError(new StringBuffer().append("Redefinition of namespace prefix: ").append(str).toString());
                    }
                    this._namespaces.put(str, str2);
                    if (this._externalNamespaces.containsKey(str)) {
                        throw newError(new StringBuffer().append("Redefinition of namespace prefix: ").append(str).toString());
                    }
                    this._externalNamespaces.put(str, str2);
                    tokenize(";");
                    this._externalNamespaces.put(XPath._NS_BOUNDARY, new Integer(this._offset));
                } else if (tokenize("declare", "default", "element", "namespace")) {
                    String str3 = tokenizeQuotedUri();
                    if (this._namespaces.containsKey("")) {
                        throw newError("Redefinition of default element namespace");
                    }
                    this._namespaces.put("", str3);
                    if (this._externalNamespaces.containsKey(XPath._DEFAULT_ELT_NS)) {
                        throw newError("Redefinition of default element namespace : ");
                    }
                    this._externalNamespaces.put(XPath._DEFAULT_ELT_NS, str3);
                    if (!tokenize(";")) {
                        throw newError("Default Namespace declaration must end with ;");
                    }
                    this._externalNamespaces.put(XPath._NS_BOUNDARY, new Integer(this._offset));
                } else {
                    if (!this._namespaces.containsKey("")) {
                        this._namespaces.put("", "");
                    }
                    Selector selector = tokenizeSelector();
                    parseWhitespace();
                    if (currChar() != -1) {
                        throw newError(new StringBuffer().append("Unexpected char '").append((char) currChar()).append("'").toString());
                    }
                    return new XPath(selector, this._sawDeepDot);
                }
            }
        }
    }

    private static final class Step {
        final boolean _attr;
        Step _backtrack;
        final boolean _deep;
        int _flags;
        boolean _hasBacktrack;
        final QName _name;
        Step _next;
        Step _prev;

        Step(boolean z, boolean z2, QName qName) {
            this._name = qName;
            this._deep = z;
            this._attr = z2;
            int i = (z || !z2) ? 2 : 0;
            this._flags = z2 ? i | 4 : i;
        }

        boolean isWild() {
            return this._name.getLocalPart().length() == 0;
        }

        boolean match(QName qName) {
            String localPart = this._name.getLocalPart();
            String localPart2 = qName.getLocalPart();
            int length = localPart.length();
            if (length == 0) {
                String namespaceURI = this._name.getNamespaceURI();
                if (namespaceURI.length() == 0) {
                    return true;
                }
                return namespaceURI.equals(qName.getNamespaceURI());
            }
            if (length != localPart2.length()) {
                return false;
            }
            String namespaceURI2 = this._name.getNamespaceURI();
            String namespaceURI3 = qName.getNamespaceURI();
            if (namespaceURI2.length() != namespaceURI3.length()) {
                return false;
            }
            return localPart.equals(localPart2) && namespaceURI2.equals(namespaceURI3);
        }
    }

    private static final class Selector {
        final Step[] _paths;

        Selector(Step[] stepArr) {
            this._paths = stepArr;
        }
    }

    private XPath(Selector selector, boolean z) {
        this._selector = selector;
        this._sawDeepDot = z;
    }

    public boolean sawDeepDot() {
        return this._sawDeepDot;
    }
}
