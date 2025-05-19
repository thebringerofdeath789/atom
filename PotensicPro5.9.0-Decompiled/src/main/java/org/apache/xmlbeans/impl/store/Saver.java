package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlOptionCharEscapeMap;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.EncodingMap;
import org.apache.xmlbeans.impl.common.GenericXmlInputStream;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XmlEventBase;
import org.apache.xmlbeans.impl.common.XmlNameImpl;
import org.apache.xmlbeans.xml.stream.Attribute;
import org.apache.xmlbeans.xml.stream.AttributeIterator;
import org.apache.xmlbeans.xml.stream.ChangePrefixMapping;
import org.apache.xmlbeans.xml.stream.CharacterData;
import org.apache.xmlbeans.xml.stream.Comment;
import org.apache.xmlbeans.xml.stream.EndDocument;
import org.apache.xmlbeans.xml.stream.EndElement;
import org.apache.xmlbeans.xml.stream.EndPrefixMapping;
import org.apache.xmlbeans.xml.stream.Location;
import org.apache.xmlbeans.xml.stream.ProcessingInstruction;
import org.apache.xmlbeans.xml.stream.StartDocument;
import org.apache.xmlbeans.xml.stream.StartElement;
import org.apache.xmlbeans.xml.stream.StartPrefixMapping;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes5.dex */
abstract class Saver {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static final String _newLine;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Saver;
    private List _ancestorNamespaces;
    private ArrayList _attrNames;
    private ArrayList _attrValues;
    private SaveCur _cur;
    private int _currentMapping;
    private String _initialDefaultUri;
    private final Locale _locale;
    private ArrayList _namespaceStack;
    private Map _preComputedNamespaces;
    private HashMap _prefixMap;
    protected XmlOptionCharEscapeMap _replaceChar;
    private boolean _saveNamespacesFirst;
    private Map _suggestedPrefixes;
    private HashMap _uriMap;
    private boolean _useDefaultNamespace;
    private final long _version;

    protected abstract void emitComment(SaveCur saveCur);

    protected abstract void emitDocType(String str, String str2, String str3);

    protected abstract boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2);

    protected abstract void emitEndDoc(SaveCur saveCur);

    protected abstract void emitFinish(SaveCur saveCur);

    protected abstract void emitProcinst(SaveCur saveCur);

    protected abstract void emitStartDoc(SaveCur saveCur);

    protected abstract void emitText(SaveCur saveCur);

    protected void syntheticNamespace(String str, String str2, boolean z) {
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$Saver == null) {
            class$org$apache$xmlbeans$impl$store$Saver = class$("org.apache.xmlbeans.impl.store.Saver");
        }
        $assertionsDisabled = true;
        _newLine = SystemProperties.getProperty("line.separator") == null ? "\n" : SystemProperties.getProperty("line.separator");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    Saver(Cur cur, XmlOptions xmlOptions) {
        if (!$assertionsDisabled && !cur._locale.entered()) {
            throw new AssertionError();
        }
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        this._cur = createSaveCur(cur, maskNull);
        Locale locale = cur._locale;
        this._locale = locale;
        this._version = locale.version();
        this._namespaceStack = new ArrayList();
        this._uriMap = new HashMap();
        this._prefixMap = new HashMap();
        this._attrNames = new ArrayList();
        this._attrValues = new ArrayList();
        addMapping("xml", "http://www.w3.org/XML/1998/namespace");
        if (maskNull.hasOption(XmlOptions.SAVE_IMPLICIT_NAMESPACES)) {
            Map map = (Map) maskNull.get(XmlOptions.SAVE_IMPLICIT_NAMESPACES);
            for (String str : map.keySet()) {
                addMapping(str, (String) map.get(str));
            }
        }
        if (maskNull.hasOption(XmlOptions.SAVE_SUBSTITUTE_CHARACTERS)) {
            this._replaceChar = (XmlOptionCharEscapeMap) maskNull.get(XmlOptions.SAVE_SUBSTITUTE_CHARACTERS);
        }
        if (getNamespaceForPrefix("") == null) {
            String str2 = new String("");
            this._initialDefaultUri = str2;
            addMapping("", str2);
        }
        if (maskNull.hasOption(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES) && !(this instanceof SynthNamespaceSaver)) {
            SynthNamespaceSaver synthNamespaceSaver = new SynthNamespaceSaver(cur, maskNull);
            while (synthNamespaceSaver.process()) {
            }
            if (!synthNamespaceSaver._synthNamespaces.isEmpty()) {
                this._preComputedNamespaces = synthNamespaceSaver._synthNamespaces;
            }
        }
        this._useDefaultNamespace = maskNull.hasOption(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        this._saveNamespacesFirst = maskNull.hasOption(XmlOptions.SAVE_NAMESPACES_FIRST);
        if (maskNull.hasOption(XmlOptions.SAVE_SUGGESTED_PREFIXES)) {
            this._suggestedPrefixes = (Map) maskNull.get(XmlOptions.SAVE_SUGGESTED_PREFIXES);
        }
        this._ancestorNamespaces = this._cur.getAncestorNamespaces();
    }

    private static SaveCur createSaveCur(Cur cur, XmlOptions xmlOptions) {
        QName qName;
        QName qName2 = (QName) xmlOptions.get(XmlOptions.SAVE_SYNTHETIC_DOCUMENT_ELEMENT);
        if (qName2 == null) {
            qName = xmlOptions.hasOption(XmlOptions.SAVE_USE_OPEN_FRAGMENT) ? Locale._openuriFragment : Locale._xmlFragment;
        } else {
            qName = qName2;
        }
        boolean z = xmlOptions.hasOption(XmlOptions.SAVE_INNER) && !xmlOptions.hasOption(XmlOptions.SAVE_OUTER);
        Cur tempCur = cur.tempCur();
        Cur tempCur2 = cur.tempCur();
        int kind = cur.kind();
        SaveCur saveCur = null;
        if (kind == 1) {
            positionToInner(cur, tempCur, tempCur2);
            if (Locale.isFragment(tempCur, tempCur2)) {
                saveCur = new FragSaveCur(tempCur, tempCur2, qName);
            } else if (qName2 != null) {
                saveCur = new FragSaveCur(tempCur, tempCur2, qName2);
            } else {
                saveCur = new DocSaveCur(cur);
            }
        } else if (kind == 2) {
            if (z) {
                positionToInner(cur, tempCur, tempCur2);
                if (Locale.isFragment(tempCur, tempCur2)) {
                    qName2 = qName;
                }
                saveCur = new FragSaveCur(tempCur, tempCur2, qName2);
            } else if (qName2 != null) {
                positionToInner(cur, tempCur, tempCur2);
                saveCur = new FragSaveCur(tempCur, tempCur2, qName2);
            } else {
                tempCur.moveToCur(cur);
                tempCur2.moveToCur(cur);
                tempCur2.skip();
                saveCur = new FragSaveCur(tempCur, tempCur2, null);
            }
        }
        if (saveCur == null) {
            boolean z2 = $assertionsDisabled;
            if (!z2 && kind >= 0 && kind != 3 && kind != 4 && kind != 5 && kind != 0) {
                throw new AssertionError();
            }
            if (kind < 0) {
                tempCur.moveToCur(cur);
                tempCur2.moveToCur(cur);
            } else if (kind == 0) {
                tempCur.moveToCur(cur);
                tempCur2.moveToCur(cur);
                tempCur2.next();
            } else if (z) {
                tempCur.moveToCur(cur);
                tempCur.next();
                tempCur2.moveToCur(cur);
                tempCur2.toEnd();
            } else if (kind == 3) {
                tempCur.moveToCur(cur);
                tempCur2.moveToCur(cur);
            } else {
                if (!z2 && kind != 4 && kind != 5) {
                    throw new AssertionError();
                }
                tempCur.moveToCur(cur);
                tempCur2.moveToCur(cur);
                tempCur2.skip();
            }
            saveCur = new FragSaveCur(tempCur, tempCur2, qName);
        }
        String str = (String) xmlOptions.get(XmlOptions.SAVE_FILTER_PROCINST);
        if (str != null) {
            saveCur = new FilterPiSaveCur(saveCur, str);
        }
        if (xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT)) {
            saveCur = new PrettySaveCur(saveCur, xmlOptions);
        }
        tempCur.release();
        tempCur2.release();
        return saveCur;
    }

    private static void positionToInner(Cur cur, Cur cur2, Cur cur3) {
        if (!$assertionsDisabled && !cur.isContainer()) {
            throw new AssertionError();
        }
        cur2.moveToCur(cur);
        if (!cur2.toFirstAttr()) {
            cur2.next();
        }
        cur3.moveToCur(cur);
        cur3.toEnd();
    }

    protected boolean saveNamespacesFirst() {
        return this._saveNamespacesFirst;
    }

    protected void enterLocale() {
        this._locale.enter();
    }

    protected void exitLocale() {
        this._locale.exit();
    }

    protected final boolean process() {
        if (!$assertionsDisabled && !this._locale.entered()) {
            throw new AssertionError();
        }
        if (this._cur == null) {
            return false;
        }
        if (this._version != this._locale.version()) {
            throw new ConcurrentModificationException("Document changed during save");
        }
        int kind = this._cur.kind();
        if (kind == -2) {
            processFinish();
        } else {
            if (kind == -1) {
                emitEndDoc(this._cur);
                this._cur.release();
                this._cur = null;
                return true;
            }
            if (kind == 0) {
                emitText(this._cur);
            } else if (kind == 1) {
                processRoot();
            } else if (kind == 2) {
                processElement();
            } else if (kind == 4) {
                emitComment(this._cur);
                this._cur.toEnd();
            } else if (kind == 5) {
                emitProcinst(this._cur);
                this._cur.toEnd();
            } else {
                throw new RuntimeException("Unexpected kind");
            }
        }
        this._cur.next();
        return true;
    }

    private final void processFinish() {
        emitFinish(this._cur);
        popMappings();
    }

    private final void processRoot() {
        String str;
        if (!$assertionsDisabled && !this._cur.isRoot()) {
            throw new AssertionError();
        }
        XmlDocumentProperties docProps = this._cur.getDocProps();
        String str2 = null;
        if (docProps != null) {
            str2 = docProps.getDoctypeSystemId();
            str = docProps.getDoctypeName();
        } else {
            str = null;
        }
        if (str2 != null || str != null) {
            if (str == null) {
                this._cur.push();
                while (!this._cur.isElem() && this._cur.next()) {
                }
                if (this._cur.isElem()) {
                    str = this._cur.getName().getLocalPart();
                }
                this._cur.pop();
            }
            String doctypePublicId = docProps.getDoctypePublicId();
            if (str != null) {
                QName name = this._cur.getName();
                if (name == null) {
                    this._cur.push();
                    while (true) {
                        if (this._cur.isFinish()) {
                            break;
                        }
                        if (this._cur.isElem()) {
                            name = this._cur.getName();
                            break;
                        }
                        this._cur.next();
                    }
                    this._cur.pop();
                }
                if (name != null && str.equals(name.getLocalPart())) {
                    emitDocType(str, doctypePublicId, str2);
                    return;
                }
            }
        }
        emitStartDoc(this._cur);
    }

    private final void processElement() {
        if (!$assertionsDisabled && (!this._cur.isElem() || this._cur.getName() == null)) {
            throw new AssertionError();
        }
        QName name = this._cur.getName();
        boolean z = name.getNamespaceURI().length() == 0;
        pushMappings(this._cur, z);
        ensureMapping(name.getNamespaceURI(), name.getPrefix(), !z, false);
        this._attrNames.clear();
        this._attrValues.clear();
        this._cur.push();
        boolean firstAttr = this._cur.toFirstAttr();
        while (firstAttr) {
            if (this._cur.isNormalAttr()) {
                QName name2 = this._cur.getName();
                this._attrNames.add(name2);
                int size = this._attrNames.size() - 2;
                while (true) {
                    if (size >= 0) {
                        if (this._attrNames.get(size).equals(name2)) {
                            ArrayList arrayList = this._attrNames;
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        }
                        size--;
                    } else {
                        this._attrValues.add(this._cur.getAttrValue());
                        ensureMapping(name2.getNamespaceURI(), name2.getPrefix(), false, true);
                        break;
                    }
                }
            }
            firstAttr = this._cur.toNextAttr();
        }
        this._cur.pop();
        Map map = this._preComputedNamespaces;
        if (map != null) {
            for (String str : map.keySet()) {
                String str2 = (String) this._preComputedNamespaces.get(str);
                ensureMapping(str, str2, str2.length() == 0 && !z, false);
            }
            this._preComputedNamespaces = null;
        }
        if (emitElement(this._cur, this._attrNames, this._attrValues)) {
            popMappings();
            this._cur.toEnd();
        }
    }

    boolean hasMappings() {
        int size = this._namespaceStack.size();
        return size > 0 && this._namespaceStack.get(size - 1) != null;
    }

    void iterateMappings() {
        this._currentMapping = this._namespaceStack.size();
        while (true) {
            int i = this._currentMapping;
            if (i <= 0 || this._namespaceStack.get(i - 1) == null) {
                return;
            } else {
                this._currentMapping -= 8;
            }
        }
    }

    boolean hasMapping() {
        return this._currentMapping < this._namespaceStack.size();
    }

    void nextMapping() {
        this._currentMapping += 8;
    }

    String mappingPrefix() {
        if ($assertionsDisabled || hasMapping()) {
            return (String) this._namespaceStack.get(this._currentMapping + 6);
        }
        throw new AssertionError();
    }

    String mappingUri() {
        if ($assertionsDisabled || hasMapping()) {
            return (String) this._namespaceStack.get(this._currentMapping + 7);
        }
        throw new AssertionError();
    }

    private final void pushMappings(SaveCur saveCur, boolean z) {
        if (!$assertionsDisabled && !saveCur.isContainer()) {
            throw new AssertionError();
        }
        this._namespaceStack.add(null);
        saveCur.push();
        boolean firstAttr = saveCur.toFirstAttr();
        while (firstAttr) {
            if (saveCur.isXmlns()) {
                addNewFrameMapping(saveCur.getXmlnsPrefix(), saveCur.getXmlnsUri(), z);
            }
            firstAttr = saveCur.toNextAttr();
        }
        saveCur.pop();
        if (this._ancestorNamespaces != null) {
            for (int i = 0; i < this._ancestorNamespaces.size(); i += 2) {
                addNewFrameMapping((String) this._ancestorNamespaces.get(i), (String) this._ancestorNamespaces.get(i + 1), z);
            }
            this._ancestorNamespaces = null;
        }
        if (z) {
            String str = (String) this._prefixMap.get("");
            if (!$assertionsDisabled && str == null) {
                throw new AssertionError();
            }
            if (str.length() > 0) {
                addMapping("", "");
            }
        }
    }

    private final void addNewFrameMapping(String str, String str2, boolean z) {
        if (str.length() == 0 || str2.length() > 0) {
            if (!z || str.length() > 0 || str2.length() == 0) {
                iterateMappings();
                while (hasMapping()) {
                    if (mappingPrefix().equals(str)) {
                        return;
                    } else {
                        nextMapping();
                    }
                }
                if (str2.equals(getNamespaceForPrefix(str))) {
                    return;
                }
                addMapping(str, str2);
            }
        }
    }

    private final void addMapping(String str, String str2) {
        String str3;
        boolean z = $assertionsDisabled;
        if (!z && str2 == null) {
            throw new AssertionError();
        }
        if (!z && str == null) {
            throw new AssertionError();
        }
        String str4 = (String) this._prefixMap.get(str);
        if (str4 == null) {
            str3 = null;
        } else if (str4.equals(str2)) {
            str4 = null;
            str3 = null;
        } else {
            int size = this._namespaceStack.size();
            str3 = null;
            while (size > 0) {
                if (this._namespaceStack.get(size - 1) != null) {
                    if (this._namespaceStack.get(size - 7).equals(str4) && ((str3 = (String) this._namespaceStack.get(size - 8)) == null || !str3.equals(str))) {
                        break;
                    } else {
                        size -= 8;
                    }
                } else {
                    size--;
                }
            }
            if (!$assertionsDisabled && size <= 0) {
                throw new AssertionError();
            }
        }
        this._namespaceStack.add(this._uriMap.get(str2));
        this._namespaceStack.add(str2);
        if (str4 != null) {
            this._namespaceStack.add(this._uriMap.get(str4));
            this._namespaceStack.add(str4);
        } else {
            this._namespaceStack.add(null);
            this._namespaceStack.add(null);
        }
        this._namespaceStack.add(str);
        this._namespaceStack.add(this._prefixMap.get(str));
        this._namespaceStack.add(str);
        this._namespaceStack.add(str2);
        this._uriMap.put(str2, str);
        this._prefixMap.put(str, str2);
        if (str4 != null) {
            this._uriMap.put(str4, str3);
        }
    }

    private final void popMappings() {
        while (true) {
            int size = this._namespaceStack.size();
            if (size == 0) {
                return;
            }
            int i = size - 1;
            if (this._namespaceStack.get(i) == null) {
                this._namespaceStack.remove(i);
                return;
            }
            int i2 = size - 7;
            Object obj = this._namespaceStack.get(i2);
            int i3 = size - 8;
            Object obj2 = this._namespaceStack.get(i3);
            if (obj2 == null) {
                this._uriMap.remove(obj);
            } else {
                this._uriMap.put(obj, obj2);
            }
            int i4 = size - 4;
            Object obj3 = this._namespaceStack.get(i4);
            int i5 = size - 3;
            Object obj4 = this._namespaceStack.get(i5);
            if (obj4 == null) {
                this._prefixMap.remove(obj3);
            } else {
                this._prefixMap.put(obj3, obj4);
            }
            int i6 = size - 5;
            String str = (String) this._namespaceStack.get(i6);
            if (str != null) {
                this._uriMap.put(str, this._namespaceStack.get(size - 6));
            }
            this._namespaceStack.remove(i);
            this._namespaceStack.remove(size - 2);
            this._namespaceStack.remove(i5);
            this._namespaceStack.remove(i4);
            this._namespaceStack.remove(i6);
            this._namespaceStack.remove(size - 6);
            this._namespaceStack.remove(i2);
            this._namespaceStack.remove(i3);
        }
    }

    private final void dumpMappings() {
        int size = this._namespaceStack.size();
        while (size > 0) {
            int i = size - 1;
            if (this._namespaceStack.get(i) == null) {
                System.out.println("----------------");
                size--;
            } else {
                System.out.print("Mapping: ");
                System.out.print(this._namespaceStack.get(size - 2));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(i));
                System.out.println();
                System.out.print("Prefix Undo: ");
                System.out.print(this._namespaceStack.get(size - 4));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(size - 3));
                System.out.println();
                System.out.print("Uri Rename: ");
                System.out.print(this._namespaceStack.get(size - 5));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(size - 6));
                System.out.println();
                System.out.print("UriUndo: ");
                System.out.print(this._namespaceStack.get(size - 7));
                System.out.print(" -> ");
                System.out.print(this._namespaceStack.get(size - 8));
                System.out.println();
                System.out.println();
                size -= 8;
            }
        }
    }

    private final String ensureMapping(String str, String str2, boolean z, boolean z2) {
        if (!$assertionsDisabled && str == null) {
            throw new AssertionError();
        }
        if (str.length() == 0) {
            return null;
        }
        String str3 = (String) this._uriMap.get(str);
        if (str3 != null && (str3.length() > 0 || !z2)) {
            return str3;
        }
        if (str2 != null && str2.length() == 0) {
            str2 = null;
        }
        if (str2 == null || !tryPrefix(str2)) {
            Map map = this._suggestedPrefixes;
            if (map != null && map.containsKey(str) && tryPrefix((String) this._suggestedPrefixes.get(str))) {
                str2 = (String) this._suggestedPrefixes.get(str);
            } else if (z && this._useDefaultNamespace && tryPrefix("")) {
                str2 = "";
            } else {
                String suggestPrefix = QNameHelper.suggestPrefix(str);
                String str4 = suggestPrefix;
                int i = 1;
                while (!tryPrefix(str4)) {
                    str4 = new StringBuffer().append(suggestPrefix).append(i).toString();
                    i++;
                }
                str2 = str4;
            }
        }
        if (!$assertionsDisabled && str2 == null) {
            throw new AssertionError();
        }
        syntheticNamespace(str2, str, z);
        addMapping(str2, str);
        return str2;
    }

    protected final String getUriMapping(String str) {
        if ($assertionsDisabled || this._uriMap.get(str) != null) {
            return (String) this._uriMap.get(str);
        }
        throw new AssertionError();
    }

    String getNonDefaultUriMapping(String str) {
        String str2 = (String) this._uriMap.get(str);
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String str3 : this._prefixMap.keySet()) {
            if (str3.length() > 0 && this._prefixMap.get(str3).equals(str)) {
                return str3;
            }
        }
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError("Could not find non-default mapping");
    }

    private final boolean tryPrefix(String str) {
        if (str == null || Locale.beginsWithXml(str)) {
            return false;
        }
        String str2 = (String) this._prefixMap.get(str);
        if (str2 != null) {
            return str.length() <= 0 && str2 == this._initialDefaultUri;
        }
        return true;
    }

    public final String getNamespaceForPrefix(String str) {
        if ($assertionsDisabled || !str.equals("xml") || this._prefixMap.get(str).equals("http://www.w3.org/XML/1998/namespace")) {
            return (String) this._prefixMap.get(str);
        }
        throw new AssertionError();
    }

    protected Map getPrefixMap() {
        return this._prefixMap;
    }

    static final class SynthNamespaceSaver extends Saver {
        LinkedHashMap _synthNamespaces;

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) {
        }

        SynthNamespaceSaver(Cur cur, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
            this._synthNamespaces = new LinkedHashMap();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void syntheticNamespace(String str, String str2, boolean z) {
            LinkedHashMap linkedHashMap = this._synthNamespaces;
            if (z) {
                str = "";
            }
            linkedHashMap.put(str2, str);
        }
    }

    static final class TextSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final int _initialBufSize = 4096;
        private char[] _buf;
        private int _cdataEntityCountThreshold;
        private int _cdataLengthThreshold;
        private int _free;
        private int _in;
        private boolean _isPrettyPrint;
        private int _lastEmitCch;
        private int _lastEmitIn;
        private int _out;
        private boolean _useCDataBookmarks;

        private boolean isBadChar(char c) {
            return (c < ' ' || c > 55295) && (c < 57344 || c > 65533) && !((c >= 0 && c <= 65535) || c == '\t' || c == '\n' || c == '\r');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        TextSaver(Cur cur, XmlOptions xmlOptions, String str) {
            super(cur, xmlOptions);
            char[] cArr;
            this._cdataLengthThreshold = 32;
            this._cdataEntityCountThreshold = 5;
            this._useCDataBookmarks = false;
            this._isPrettyPrint = false;
            boolean z = xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_NO_XML_DECL);
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_CDATA_LENGTH_THRESHOLD)) {
                this._cdataLengthThreshold = ((Integer) xmlOptions.get(XmlOptions.SAVE_CDATA_LENGTH_THRESHOLD)).intValue();
            }
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_CDATA_ENTITY_COUNT_THRESHOLD)) {
                this._cdataEntityCountThreshold = ((Integer) xmlOptions.get(XmlOptions.SAVE_CDATA_ENTITY_COUNT_THRESHOLD)).intValue();
            }
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.LOAD_SAVE_CDATA_BOOKMARKS)) {
                this._useCDataBookmarks = true;
            }
            if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT)) {
                this._isPrettyPrint = true;
            }
            this._out = 0;
            this._in = 0;
            this._free = 0;
            if (!$assertionsDisabled && (cArr = this._buf) != null) {
                int length = cArr.length;
            }
            if (str == null || z) {
                return;
            }
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            String version = docProps == null ? null : docProps.getVersion();
            version = version == null ? "1.0" : version;
            emit("<?xml version=\"");
            emit(version);
            emit(new StringBuffer().append("\" encoding=\"").append(str).append("\"?>").append(_newLine).toString());
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            if (!$assertionsDisabled && !saveCur.isElem()) {
                throw new AssertionError();
            }
            emit(Typography.less);
            emitName(saveCur.getName(), false);
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                emitAttrHelper((QName) arrayList.get(i), (String) arrayList2.get(i));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (!saveCur.hasChildren() && !saveCur.hasText()) {
                emit('/', Typography.greater);
                return true;
            }
            emit(Typography.greater);
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) {
            emit(Typography.less, '/');
            emitName(saveCur.getName(), false);
            emit(Typography.greater);
        }

        protected void emitXmlns(String str, String str2) {
            boolean z = $assertionsDisabled;
            if (!z && str == null) {
                throw new AssertionError();
            }
            if (!z && str2 == null) {
                throw new AssertionError();
            }
            emit("xmlns");
            if (str.length() > 0) {
                emit(NameUtil.COLON);
                emit(str);
            }
            emit('=', '\"');
            emit(str2);
            entitizeAttrValue(false);
            emit('\"');
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                emit(' ');
                emitXmlns(mappingPrefix(), mappingUri());
                nextMapping();
            }
        }

        private void emitAttrHelper(QName qName, String str) {
            emit(' ');
            emitName(qName, true);
            emit('=', '\"');
            emit(str);
            entitizeAttrValue(true);
            emit('\"');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isText()) {
                throw new AssertionError();
            }
            boolean z = this._useCDataBookmarks && saveCur.isTextCData();
            emit(saveCur);
            entitizeContent(z);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isComment()) {
                throw new AssertionError();
            }
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emit(saveCur);
            saveCur.pop();
            entitizeComment();
            emit("-->");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isProcinst()) {
                throw new AssertionError();
            }
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(StringUtils.SPACE);
                emit(saveCur);
                entitizeProcinst();
            }
            saveCur.pop();
            emit("?>");
        }

        private void emitLiteral(String str) {
            if (str.indexOf("\"") < 0) {
                emit('\"');
                emit(str);
                emit('\"');
            } else {
                emit('\'');
                emit(str);
                emit('\'');
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
            if (!$assertionsDisabled && str == null) {
                throw new AssertionError();
            }
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(StringUtils.SPACE);
                emitLiteral(str3);
            }
            emit(">");
            emit(_newLine);
        }

        private void emitName(QName qName, boolean z) {
            boolean z2 = $assertionsDisabled;
            if (!z2 && qName == null) {
                throw new AssertionError();
            }
            String namespaceURI = qName.getNamespaceURI();
            if (!z2 && namespaceURI == null) {
                throw new AssertionError();
            }
            if (namespaceURI.length() != 0) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z && prefix.length() == 0) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (prefix.length() > 0) {
                    emit(prefix);
                    emit(NameUtil.COLON);
                }
            }
            if (!z2 && qName.getLocalPart().length() <= 0) {
                throw new AssertionError();
            }
            emit(qName.getLocalPart());
        }

        private void emit(char c) {
            char[] cArr;
            int i;
            int i2;
            boolean z = $assertionsDisabled;
            if (!z && (cArr = this._buf) != null && (((i = this._out) >= (i2 = this._in) || this._free != cArr.length - (i2 - i)) && ((i <= i2 || this._free != i - i2) && ((i != i2 || this._free != cArr.length) && (i != i2 || this._free != 0))))) {
                throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
            }
            preEmit(1);
            char[] cArr2 = this._buf;
            int i3 = this._in;
            cArr2[i3] = c;
            int length = (i3 + 1) % cArr2.length;
            this._in = length;
            if (z || cArr2 == null) {
                return;
            }
            int i4 = this._out;
            if (i4 >= length || this._free != cArr2.length - (length - i4)) {
                if (i4 <= length || this._free != i4 - length) {
                    if (i4 == length && this._free == cArr2.length) {
                        return;
                    }
                    if (i4 != length || this._free != 0) {
                        throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
                    }
                }
            }
        }

        private void emit(char c, char c2) {
            if (preEmit(2)) {
                return;
            }
            char[] cArr = this._buf;
            int i = this._in;
            cArr[i] = c;
            int length = (i + 1) % cArr.length;
            this._in = length;
            cArr[length] = c2;
            int length2 = (length + 1) % cArr.length;
            this._in = length2;
            if ($assertionsDisabled || cArr == null) {
                return;
            }
            int i2 = this._out;
            if (i2 >= length2 || this._free != cArr.length - (length2 - i2)) {
                if (i2 <= length2 || this._free != i2 - length2) {
                    if (i2 == length2 && this._free == cArr.length) {
                        return;
                    }
                    if (i2 != length2 || this._free != 0) {
                        throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
                    }
                }
            }
        }

        private void emit(String str) {
            char[] cArr;
            char[] cArr2;
            int i;
            int i2;
            boolean z = $assertionsDisabled;
            if (!z && (cArr2 = this._buf) != null && (((i = this._out) >= (i2 = this._in) || this._free != cArr2.length - (i2 - i)) && ((i <= i2 || this._free != i - i2) && ((i != i2 || this._free != cArr2.length) && (i != i2 || this._free != 0))))) {
                throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
            }
            int length = str == null ? 0 : str.length();
            if (preEmit(length)) {
                return;
            }
            int i3 = this._in;
            if (i3 > this._out) {
                char[] cArr3 = this._buf;
                int length2 = cArr3.length - i3;
                if (length >= length2) {
                    str.getChars(0, length2, cArr3, i3);
                    str.getChars(length2, length, this._buf, 0);
                    this._in = (this._in + length) % this._buf.length;
                    if (!z || (cArr = this._buf) == null) {
                    }
                    int i4 = this._out;
                    int i5 = this._in;
                    if (i4 >= i5 || this._free != cArr.length - (i5 - i4)) {
                        if (i4 <= i5 || this._free != i4 - i5) {
                            if (i4 == i5 && this._free == cArr.length) {
                                return;
                            }
                            if (i4 != i5 || this._free != 0) {
                                throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            str.getChars(0, length, this._buf, i3);
            this._in += length;
            if (z) {
            }
        }

        private void emit(SaveCur saveCur) {
            if (saveCur.isText()) {
                Object chars = saveCur.getChars();
                int i = saveCur._cchSrc;
                if (preEmit(i)) {
                    return;
                }
                int i2 = this._in;
                if (i2 > this._out) {
                    char[] cArr = this._buf;
                    int length = cArr.length - i2;
                    if (i >= length) {
                        CharUtil.getChars(cArr, i2, chars, saveCur._offSrc, length);
                        CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc + length, i - length);
                        this._in = (this._in + i) % this._buf.length;
                        return;
                    }
                }
                CharUtil.getChars(this._buf, i2, chars, saveCur._offSrc, i);
                this._in += i;
                return;
            }
            preEmit(0);
        }

        private boolean preEmit(int i) {
            char[] cArr;
            int i2;
            char[] cArr2;
            char[] cArr3;
            int i3;
            int i4;
            boolean z = $assertionsDisabled;
            if (!z && i < 0) {
                throw new AssertionError();
            }
            if (!z && (cArr3 = this._buf) != null && (((i3 = this._out) >= (i4 = this._in) || this._free != cArr3.length - (i4 - i3)) && ((i3 <= i4 || this._free != i3 - i4) && ((i3 != i4 || this._free != cArr3.length) && (i3 != i4 || this._free != 0))))) {
                throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
            }
            this._lastEmitCch = i;
            if (i == 0) {
                return true;
            }
            if (this._free <= i) {
                resize(i, -1);
            }
            if (!z && i > this._free) {
                throw new AssertionError();
            }
            if (getAvailable() == 0) {
                if (!z && this._in != this._out) {
                    throw new AssertionError();
                }
                if (!z && this._free != this._buf.length) {
                    throw new AssertionError();
                }
                this._out = 0;
                this._in = 0;
            }
            int i5 = this._in;
            this._lastEmitIn = i5;
            int i6 = this._free - i;
            this._free = i6;
            if (!z && i6 < 0) {
                throw new AssertionError();
            }
            if (!z && (cArr2 = this._buf) != null) {
                int i7 = this._out;
                if (i6 != (i5 >= i7 ? cArr2.length - (i5 - i7) : i7 - i5) - i) {
                    throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
                }
            }
            if (z || (cArr = this._buf) == null || (((i2 = this._out) < i5 && i6 == (cArr.length - (i5 - i2)) - i) || ((i2 > i5 && i6 == (i2 - i5) - i) || ((i2 == i5 && i6 == cArr.length - i) || (i2 == i5 && i6 == 0))))) {
                return false;
            }
            throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
        }

        private void entitizeContent(boolean z) {
            int i;
            if (!$assertionsDisabled && this._free < 0) {
                throw new AssertionError();
            }
            int i2 = this._lastEmitCch;
            if (i2 == 0) {
                return;
            }
            int i3 = this._lastEmitIn;
            int length = this._buf.length;
            int i4 = 0;
            boolean z2 = false;
            char c = 0;
            char c2 = 0;
            while (i2 > 0) {
                char c3 = this._buf[i3];
                if (c3 == '<' || c3 == '&') {
                    i4++;
                } else if ((c == ']' && c2 == ']' && c3 == '>') || isBadChar(c3) || isEscapedChar(c3) || (!this._isPrettyPrint && c3 == '\r')) {
                    z2 = true;
                }
                i3++;
                if (i3 == length) {
                    i3 = 0;
                }
                i2--;
                c = c2;
                c2 = c3;
            }
            if (z || i4 != 0 || z2 || i4 >= this._cdataEntityCountThreshold) {
                int i5 = this._lastEmitIn;
                if (z || ((i = this._lastEmitCch) > this._cdataLengthThreshold && i4 > this._cdataEntityCountThreshold)) {
                    boolean z3 = this._buf[i5] == ']';
                    int replace = replace(i5, new StringBuffer().append("<![CDATA[").append(this._buf[i5]).toString());
                    char[] cArr = this._buf;
                    boolean z4 = cArr[replace] == ']';
                    int i6 = replace + 1;
                    if (i6 == cArr.length) {
                        i6 = 0;
                    }
                    int i7 = this._lastEmitCch;
                    while (i7 > 0) {
                        char c4 = this._buf[i6];
                        if (c4 == '>' && z3 && z4) {
                            i6 = replace(i6, "]]>><![CDATA[");
                        } else {
                            i6 = isBadChar(c4) ? replace(i6, "?") : i6 + 1;
                        }
                        boolean z5 = c4 == ']';
                        if (i6 == this._buf.length) {
                            i6 = 0;
                        }
                        i7--;
                        boolean z6 = z4;
                        z4 = z5;
                        z3 = z6;
                    }
                    emit("]]>");
                    return;
                }
                char c5 = 0;
                char c6 = 0;
                while (i > 0) {
                    char c7 = this._buf[i5];
                    if (c7 == '<') {
                        i5 = replace(i5, "&lt;");
                    } else if (c7 == '&') {
                        i5 = replace(i5, "&amp;");
                    } else if (c7 == '>' && c6 == ']' && c5 == ']') {
                        i5 = replace(i5, "&gt;");
                    } else if (isBadChar(c7)) {
                        i5 = replace(i5, "?");
                    } else if (!this._isPrettyPrint && c7 == '\r') {
                        i5 = replace(i5, "&#13;");
                    } else {
                        i5 = isEscapedChar(c7) ? replace(i5, this._replaceChar.getEscapedString(c7)) : i5 + 1;
                    }
                    if (i5 == this._buf.length) {
                        i5 = 0;
                    }
                    i--;
                    c5 = c6;
                    c6 = c7;
                }
            }
        }

        private void entitizeAttrValue(boolean z) {
            int i = this._lastEmitCch;
            if (i == 0) {
                return;
            }
            int i2 = this._lastEmitIn;
            while (i > 0) {
                char c = this._buf[i2];
                if (c == '<') {
                    i2 = replace(i2, "&lt;");
                } else if (c == '&') {
                    i2 = replace(i2, "&amp;");
                } else if (c == '\"') {
                    i2 = replace(i2, "&quot;");
                } else if (!isEscapedChar(c)) {
                    i2++;
                } else if (z) {
                    i2 = replace(i2, this._replaceChar.getEscapedString(c));
                }
                if (i2 == this._buf.length) {
                    i2 = 0;
                }
                i--;
            }
        }

        private void entitizeComment() {
            int i = this._lastEmitCch;
            if (i == 0) {
                return;
            }
            int i2 = this._lastEmitIn;
            boolean z = false;
            while (i > 0) {
                char c = this._buf[i2];
                if (isBadChar(c)) {
                    i2 = replace(i2, "?");
                } else {
                    if (c != '-') {
                        i2++;
                    } else if (z) {
                        i2 = replace(i2, StringUtils.SPACE);
                    } else {
                        i2++;
                        z = true;
                    }
                    z = false;
                }
                if (i2 == this._buf.length) {
                    i2 = 0;
                }
                i--;
            }
            int i3 = (this._lastEmitIn + this._lastEmitCch) - 1;
            char[] cArr = this._buf;
            int length = i3 % cArr.length;
            if (cArr[length] == '-') {
                replace(length, StringUtils.SPACE);
            }
        }

        private void entitizeProcinst() {
            int i = this._lastEmitCch;
            if (i == 0) {
                return;
            }
            int i2 = this._lastEmitIn;
            boolean z = false;
            while (i > 0) {
                char c = this._buf[i2];
                if (isBadChar(c)) {
                    i2 = replace(i2, "?");
                }
                if (c == '>') {
                    i2 = z ? replace(i2, StringUtils.SPACE) : i2 + 1;
                    z = false;
                } else {
                    z = c == '?';
                    i2++;
                }
                if (i2 == this._buf.length) {
                    i2 = 0;
                }
                i--;
            }
        }

        private boolean isEscapedChar(char c) {
            return this._replaceChar != null && this._replaceChar.containsChar(c);
        }

        private int replace(int i, String str) {
            char[] cArr;
            int i2;
            int i3;
            boolean z = $assertionsDisabled;
            if (!z && str.length() <= 0) {
                throw new AssertionError();
            }
            int length = str.length() - 1;
            if (length == 0) {
                this._buf[i] = str.charAt(0);
                return i + 1;
            }
            if (!z && this._free < 0) {
                throw new AssertionError();
            }
            if (length > this._free) {
                i = resize(length, i);
            }
            if (!z && this._free < 0) {
                throw new AssertionError();
            }
            if (!z && this._free < length) {
                throw new AssertionError();
            }
            if (!z && getAvailable() <= 0) {
                throw new AssertionError();
            }
            int i4 = length + 1;
            int i5 = this._out;
            int i6 = this._in;
            if (i5 > i6 && i >= i5) {
                char[] cArr2 = this._buf;
                System.arraycopy(cArr2, i5, cArr2, i5 - length, i - i5);
                this._out -= length;
                i -= length;
            } else {
                if (!z && i >= i6) {
                    throw new AssertionError();
                }
                char[] cArr3 = this._buf;
                int length2 = cArr3.length - i6;
                if (length <= length2) {
                    System.arraycopy(cArr3, i, cArr3, i + length, i6 - i);
                    this._in = (this._in + length) % this._buf.length;
                } else if (length <= ((length2 + i6) - i) - 1) {
                    int i7 = length - length2;
                    System.arraycopy(cArr3, i6 - i7, cArr3, 0, i7);
                    char[] cArr4 = this._buf;
                    int i8 = i + 1;
                    System.arraycopy(cArr4, i8, cArr4, i8 + length, ((this._in - i) - 1) - i7);
                    this._in = i7;
                } else {
                    int i9 = (i6 - i) - 1;
                    int i10 = (length2 + i6) - i;
                    System.arraycopy(cArr3, i6 - i9, cArr3, (length - i10) + 1, i9);
                    str.getChars(i10, i4, this._buf, 0);
                    this._in = ((i9 + length) - i10) + 1;
                    i4 = i10;
                }
            }
            str.getChars(0, i4, this._buf, i);
            int i11 = this._free - length;
            this._free = i11;
            if (!z && i11 < 0) {
                throw new AssertionError();
            }
            if (z || (cArr = this._buf) == null || (((i2 = this._out) < (i3 = this._in) && i11 == cArr.length - (i3 - i2)) || ((i2 > i3 && i11 == i2 - i3) || ((i2 == i3 && i11 == cArr.length) || (i2 == i3 && i11 == 0))))) {
                return ((i + length) + 1) % this._buf.length;
            }
            throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
        }

        private int ensure(int i) {
            if (i <= 0) {
                i = 1;
            }
            int available = getAvailable();
            while (available < i && process()) {
                available = getAvailable();
            }
            if ($assertionsDisabled || available == getAvailable()) {
                return available;
            }
            throw new AssertionError();
        }

        int getAvailable() {
            char[] cArr = this._buf;
            if (cArr == null) {
                return 0;
            }
            return cArr.length - this._free;
        }

        private int resize(int i, int i2) {
            int i3;
            int i4;
            int i5;
            char[] cArr;
            int i6;
            int i7;
            boolean z = $assertionsDisabled;
            if (!z && this._free < 0) {
                throw new AssertionError();
            }
            if (!z && i <= 0) {
                throw new AssertionError();
            }
            if (!z && i < this._free) {
                throw new AssertionError();
            }
            if (!z && (cArr = this._buf) != null && (((i6 = this._out) >= (i7 = this._in) || this._free != cArr.length - (i7 - i6)) && ((i6 <= i7 || this._free != i6 - i7) && ((i6 != i7 || this._free != cArr.length) && (i6 != i7 || this._free != 0))))) {
                throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
            }
            char[] cArr2 = this._buf;
            int length = cArr2 == null ? 4096 : cArr2.length * 2;
            int available = getAvailable();
            while (length - available < i) {
                length *= 2;
            }
            char[] cArr3 = new char[length];
            if (available > 0) {
                int i8 = this._in;
                int i9 = this._out;
                if (i8 > i9) {
                    if (!$assertionsDisabled && i2 != -1 && (i2 < i9 || i2 >= i8)) {
                        throw new AssertionError();
                    }
                    System.arraycopy(this._buf, i9, cArr3, 0, available);
                    i5 = this._out;
                } else {
                    if (!$assertionsDisabled && i2 != -1 && i2 < i9 && i2 >= i8) {
                        throw new AssertionError();
                    }
                    System.arraycopy(this._buf, i9, cArr3, 0, available - i8);
                    char[] cArr4 = this._buf;
                    int i10 = this._in;
                    System.arraycopy(cArr4, 0, cArr3, available - i10, i10);
                    i5 = this._out;
                    if (i2 < i5) {
                        i2 += i5;
                        this._out = 0;
                        this._in = available;
                        this._free += length - this._buf.length;
                    }
                }
                i2 -= i5;
                this._out = 0;
                this._in = available;
                this._free += length - this._buf.length;
            } else {
                this._free = length;
                boolean z2 = $assertionsDisabled;
                if (!z2 && (this._in != 0 || this._out != 0)) {
                    throw new AssertionError();
                }
                if (!z2 && i2 != -1) {
                    throw new AssertionError();
                }
            }
            this._buf = cArr3;
            boolean z3 = $assertionsDisabled;
            if (!z3 && this._free < 0) {
                throw new AssertionError();
            }
            if (z3 || (((i3 = this._out) < (i4 = this._in) && this._free == cArr3.length - (i4 - i3)) || ((i3 > i4 && this._free == i3 - i4) || ((i3 == i4 && this._free == cArr3.length) || (i3 == i4 && this._free == 0))))) {
                return i2;
            }
            throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
        }

        public int read() {
            int i;
            if (ensure(1) == 0) {
                return -1;
            }
            boolean z = $assertionsDisabled;
            if (!z && getAvailable() <= 0) {
                throw new AssertionError();
            }
            char[] cArr = this._buf;
            int i2 = this._out;
            char c = cArr[i2];
            int length = (i2 + 1) % cArr.length;
            this._out = length;
            int i3 = this._free + 1;
            this._free = i3;
            if (z || cArr == null || ((length < (i = this._in) && i3 == cArr.length - (i - length)) || ((length > i && i3 == length - i) || ((length == i && i3 == cArr.length) || (length == i && i3 == 0))))) {
                return c;
            }
            throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
        }

        public int read(char[] cArr, int i, int i2) {
            int i3;
            int ensure = ensure(i2);
            if (ensure == 0) {
                return -1;
            }
            if (cArr == null || i2 <= 0) {
                return 0;
            }
            if (ensure < i2) {
                i2 = ensure;
            }
            int i4 = this._out;
            if (i4 < this._in) {
                System.arraycopy(this._buf, i4, cArr, i, i2);
            } else {
                char[] cArr2 = this._buf;
                int length = cArr2.length - i4;
                if (length >= i2) {
                    System.arraycopy(cArr2, i4, cArr, i, i2);
                } else {
                    System.arraycopy(cArr2, i4, cArr, i, length);
                    System.arraycopy(this._buf, 0, cArr, i + length, i2 - length);
                }
            }
            int i5 = this._out + i2;
            char[] cArr3 = this._buf;
            int length2 = i5 % cArr3.length;
            this._out = length2;
            int i6 = this._free + i2;
            this._free = i6;
            boolean z = $assertionsDisabled;
            if (!z && cArr3 != null && ((length2 >= (i3 = this._in) || i6 != cArr3.length - (i3 - length2)) && ((length2 <= i3 || i6 != length2 - i3) && ((length2 != i3 || i6 != cArr3.length) && (length2 != i3 || i6 != 0))))) {
                throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
            }
            if (z || i6 >= 0) {
                return i2;
            }
            throw new AssertionError();
        }

        public int write(Writer writer, int i) {
            char[] cArr;
            int i2;
            int i3;
            while (getAvailable() < i && process()) {
            }
            int available = getAvailable();
            if (available > 0) {
                boolean z = $assertionsDisabled;
                if (!z && this._out != 0) {
                    throw new AssertionError();
                }
                if (!z && this._in < this._out) {
                    throw new AssertionError(new StringBuffer().append("_in:").append(this._in).append(" < _out:").append(this._out).toString());
                }
                if (!z && this._free != this._buf.length - this._in) {
                    throw new AssertionError();
                }
                try {
                    writer.write(this._buf, 0, available);
                    writer.flush();
                    int i4 = this._free + available;
                    this._free = i4;
                    if (!z && i4 < 0) {
                        throw new AssertionError();
                    }
                    this._in = 0;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if ($assertionsDisabled || (cArr = this._buf) == null || (((i2 = this._out) < (i3 = this._in) && this._free == cArr.length - (i3 - i2)) || ((i2 > i3 && this._free == i2 - i3) || ((i2 == i3 && this._free == cArr.length) || (i2 == i3 && this._free == 0))))) {
                return available;
            }
            throw new AssertionError(new StringBuffer().append("_buf.length:").append(this._buf.length).append(" _in:").append(this._in).append(" _out:").append(this._out).append(" _free:").append(this._free).toString());
        }

        public String saveToString() {
            while (process()) {
            }
            if (!$assertionsDisabled && this._out != 0) {
                throw new AssertionError();
            }
            int available = getAvailable();
            return available == 0 ? "" : new String(this._buf, this._out, available);
        }
    }

    static final class OptimizedForSpeedSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled;
        private char[] _buf;
        Writer _w;

        private boolean isBadChar(char c) {
            return (c < ' ' || c > 55295) && (c < 57344 || c > 65533) && !((c >= 0 && c <= 65535) || c == '\t' || c == '\n' || c == '\r');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        private static class SaverIOException extends RuntimeException {
            SaverIOException(IOException iOException) {
                super(iOException);
            }
        }

        OptimizedForSpeedSaver(Cur cur, Writer writer) {
            super(cur, XmlOptions.maskNull(null));
            this._buf = new char[1024];
            this._w = writer;
        }

        static void save(Cur cur, Writer writer) throws IOException {
            try {
                do {
                } while (new OptimizedForSpeedSaver(cur, writer).process());
            } catch (SaverIOException e) {
                throw ((IOException) e.getCause());
            }
        }

        private void emit(String str) {
            try {
                this._w.write(str);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char c) {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                this._w.write(cArr, 0, 1);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char c, char c2) {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                cArr[1] = c2;
                this._w.write(cArr, 0, 2);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char[] cArr, int i, int i2) {
            try {
                this._w.write(cArr, i, i2);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            if (!$assertionsDisabled && !saveCur.isElem()) {
                throw new AssertionError();
            }
            emit(Typography.less);
            emitName(saveCur.getName(), false);
            for (int i = 0; i < arrayList.size(); i++) {
                emitAttrHelper((QName) arrayList.get(i), (String) arrayList2.get(i));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (!saveCur.hasChildren() && !saveCur.hasText()) {
                emit('/', Typography.greater);
                return true;
            }
            emit(Typography.greater);
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) {
            emit(Typography.less, '/');
            emitName(saveCur.getName(), false);
            emit(Typography.greater);
        }

        protected void emitXmlns(String str, String str2) {
            boolean z = $assertionsDisabled;
            if (!z && str == null) {
                throw new AssertionError();
            }
            if (!z && str2 == null) {
                throw new AssertionError();
            }
            emit("xmlns");
            if (str.length() > 0) {
                emit(NameUtil.COLON);
                emit(str);
            }
            emit('=', '\"');
            emitAttrValue(str2);
            emit('\"');
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                emit(' ');
                emitXmlns(mappingPrefix(), mappingUri());
                nextMapping();
            }
        }

        private void emitAttrHelper(QName qName, String str) {
            emit(' ');
            emitName(qName, true);
            emit('=', '\"');
            emitAttrValue(str);
            emit('\"');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isComment()) {
                throw new AssertionError();
            }
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emitCommentText(saveCur);
            saveCur.pop();
            emit("-->");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isProcinst()) {
                throw new AssertionError();
            }
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(' ');
                emitPiText(saveCur);
            }
            saveCur.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
            if (!$assertionsDisabled && str == null) {
                throw new AssertionError();
            }
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(' ');
                emitLiteral(str3);
            }
            emit(Typography.greater);
            emit(_newLine);
        }

        private void emitName(QName qName, boolean z) {
            boolean z2 = $assertionsDisabled;
            if (!z2 && qName == null) {
                throw new AssertionError();
            }
            String namespaceURI = qName.getNamespaceURI();
            if (!z2 && namespaceURI == null) {
                throw new AssertionError();
            }
            if (namespaceURI.length() != 0) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z && prefix.length() == 0) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (prefix.length() > 0) {
                    emit(prefix);
                    emit(NameUtil.COLON);
                }
            }
            if (!z2 && qName.getLocalPart().length() <= 0) {
                throw new AssertionError();
            }
            emit(qName.getLocalPart());
        }

        private void emitAttrValue(CharSequence charSequence) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                char charAt = charSequence.charAt(i);
                if (charAt == '<') {
                    emit("&lt;");
                } else if (charAt == '&') {
                    emit("&amp;");
                } else if (charAt == '\"') {
                    emit("&quot;");
                } else {
                    emit(charAt);
                }
            }
        }

        private void emitLiteral(String str) {
            if (str.indexOf("\"") < 0) {
                emit('\"');
                emit(str);
                emit('\"');
            } else {
                emit('\'');
                emit(str);
                emit('\'');
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isText()) {
                throw new AssertionError();
            }
            Object chars = saveCur.getChars();
            int i = saveCur._cchSrc;
            int i2 = saveCur._offSrc;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 512;
                if (i4 > i) {
                    i4 = i;
                }
                int i5 = i2 + i3;
                int i6 = i4 - i3;
                CharUtil.getChars(this._buf, 0, chars, i5, i6);
                entitizeAndWriteText(i6);
                i3 = i4;
            }
        }

        protected void emitPiText(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isText()) {
                throw new AssertionError();
            }
            Object chars = saveCur.getChars();
            int i = saveCur._cchSrc;
            int i2 = saveCur._offSrc;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 512 > i ? i : 512;
                CharUtil.getChars(this._buf, 0, chars, i2 + i3, i4);
                entitizeAndWritePIText(i4 - i3);
                i3 = i4;
            }
        }

        protected void emitCommentText(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isText()) {
                throw new AssertionError();
            }
            Object chars = saveCur.getChars();
            int i = saveCur._cchSrc;
            int i2 = saveCur._offSrc;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 512 > i ? i : 512;
                CharUtil.getChars(this._buf, 0, chars, i2 + i3, i4);
                entitizeAndWriteCommentText(i4 - i3);
                i3 = i4;
            }
        }

        private void entitizeAndWriteText(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                char[] cArr = this._buf;
                char c = cArr[i3];
                if (c == '&') {
                    emit(cArr, i2, i3 - i2);
                    emit("&amp;");
                } else if (c == '<') {
                    emit(cArr, i2, i3 - i2);
                    emit("&lt;");
                }
                i2 = i3 + 1;
            }
            emit(this._buf, i2, i - i2);
        }

        private void entitizeAndWriteCommentText(int i) {
            int i2 = 0;
            boolean z = false;
            while (i2 < i) {
                char c = this._buf[i2];
                if (isBadChar(c)) {
                    this._buf[i2] = '?';
                } else {
                    if (c == '-') {
                        if (z) {
                            this._buf[i2] = ' ';
                        } else {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (i2 == this._buf.length) {
                    i2 = 0;
                }
                i2++;
            }
            char[] cArr = this._buf;
            int i3 = i - 1;
            if (cArr[i3] == '-') {
                cArr[i3] = ' ';
            }
            emit(cArr, 0, i);
        }

        private void entitizeAndWritePIText(int i) {
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                char c = this._buf[i2];
                if (isBadChar(c)) {
                    this._buf[i2] = '?';
                    c = '?';
                }
                if (c == '>') {
                    if (z) {
                        this._buf[i2] = ' ';
                    }
                } else if (c == '?') {
                    z = true;
                }
                z = false;
            }
            emit(this._buf, 0, i);
        }
    }

    static final class TextReader extends Reader {
        private boolean _closed = false;
        private Locale _locale;
        private TextSaver _textSaver;

        TextReader(Cur cur, XmlOptions xmlOptions) {
            this._textSaver = new TextSaver(cur, xmlOptions, null);
            this._locale = cur._locale;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this._closed = true;
        }

        @Override // java.io.Reader
        public boolean ready() throws IOException {
            return !this._closed;
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            int read;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._textSaver.read();
                } finally {
                }
            }
            synchronized (this._locale) {
                this._locale.enter();
                try {
                    read = this._textSaver.read();
                } finally {
                }
            }
            return read;
        }

        @Override // java.io.Reader
        public int read(char[] cArr) throws IOException {
            int read;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._textSaver.read(cArr, 0, cArr == null ? 0 : cArr.length);
                } finally {
                }
            }
            synchronized (this._locale) {
                this._locale.enter();
                try {
                    read = this._textSaver.read(cArr, 0, cArr == null ? 0 : cArr.length);
                } finally {
                }
            }
            return read;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            int read;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._textSaver.read(cArr, i, i2);
                } finally {
                }
            }
            synchronized (this._locale) {
                this._locale.enter();
                try {
                    read = this._textSaver.read(cArr, i, i2);
                } finally {
                }
            }
            return read;
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Reader has been closed");
            }
        }
    }

    static final class InputStreamSaver extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled;
        private boolean _closed;
        private OutputStreamWriter _converter;
        private Locale _locale;
        private OutputStreamImpl _outStreamImpl;
        private TextSaver _textSaver;

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.StringBuffer] */
        InputStreamSaver(Cur cur, XmlOptions xmlOptions) {
            String java2IANAMapping;
            Locale locale = cur._locale;
            this._locale = locale;
            this._closed = false;
            if (!$assertionsDisabled && !locale.entered()) {
                throw new AssertionError();
            }
            XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
            AnonymousClass1 anonymousClass1 = null;
            anonymousClass1 = null;
            this._outStreamImpl = new OutputStreamImpl();
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            if (docProps != null && docProps.getEncoding() != null) {
                anonymousClass1 = EncodingMap.getIANA2JavaMapping(docProps.getEncoding());
            }
            ?? r2 = maskNull.hasOption(XmlOptions.CHARACTER_ENCODING) ? (String) maskNull.get(XmlOptions.CHARACTER_ENCODING) : anonymousClass1;
            if (r2 != 0 && (java2IANAMapping = EncodingMap.getJava2IANAMapping(r2)) != null) {
                r2 = java2IANAMapping;
            }
            r2 = r2 == 0 ? EncodingMap.getJava2IANAMapping(InternalZipConstants.CHARSET_UTF8) : r2;
            String iANA2JavaMapping = EncodingMap.getIANA2JavaMapping(r2);
            if (iANA2JavaMapping == null) {
                throw new IllegalStateException(new StringBuffer().append("Unknown encoding: ").append(r2).toString());
            }
            try {
                this._converter = new OutputStreamWriter(this._outStreamImpl, iANA2JavaMapping);
                this._textSaver = new TextSaver(cur, maskNull, r2);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this._closed = true;
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Stream closed");
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._outStreamImpl.read();
                } finally {
                }
            }
            synchronized (this._locale) {
                this._locale.enter();
                try {
                    read = this._outStreamImpl.read();
                } finally {
                }
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            checkClosed();
            Objects.requireNonNull(bArr, "buf to read into is null");
            if (i < 0 || i > bArr.length) {
                throw new IndexOutOfBoundsException("Offset is not within buf");
            }
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._outStreamImpl.read(bArr, i, i2);
                } finally {
                }
            }
            synchronized (this._locale) {
                this._locale.enter();
                try {
                    read = this._outStreamImpl.read(bArr, i, i2);
                } finally {
                }
            }
            return read;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int ensure(int i) {
            if (i <= 0) {
                i = 1;
            }
            int available = this._outStreamImpl.getAvailable();
            while (available < i && this._textSaver.write(this._converter, 2048) >= 2048) {
                available = this._outStreamImpl.getAvailable();
            }
            return this._outStreamImpl.getAvailable();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int ensure;
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return ensure(1024);
                } finally {
                }
            }
            synchronized (this._locale) {
                this._locale.enter();
                try {
                    ensure = ensure(1024);
                } finally {
                }
            }
            return ensure;
        }

        private final class OutputStreamImpl extends OutputStream {
            static final /* synthetic */ boolean $assertionsDisabled;
            private static final int _initialBufSize = 4096;
            private byte[] _buf;
            private int _free;
            private int _in;
            private int _out;

            static {
                if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                    Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
                } else {
                    Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
                }
                $assertionsDisabled = true;
            }

            private OutputStreamImpl() {
            }

            int read() {
                if (InputStreamSaver.this.ensure(1) == 0) {
                    return -1;
                }
                if (!$assertionsDisabled && getAvailable() <= 0) {
                    throw new AssertionError();
                }
                byte[] bArr = this._buf;
                int i = this._out;
                byte b = bArr[i];
                this._out = (i + 1) % bArr.length;
                this._free++;
                return b;
            }

            int read(byte[] bArr, int i, int i2) {
                int ensure = InputStreamSaver.this.ensure(i2);
                if (ensure == 0) {
                    return -1;
                }
                if (bArr == null || i2 <= 0) {
                    return 0;
                }
                if (ensure < i2) {
                    i2 = ensure;
                }
                int i3 = this._out;
                if (i3 < this._in) {
                    System.arraycopy(this._buf, i3, bArr, i, i2);
                } else {
                    byte[] bArr2 = this._buf;
                    int length = bArr2.length - i3;
                    if (length >= i2) {
                        System.arraycopy(bArr2, i3, bArr, i, i2);
                    } else {
                        System.arraycopy(bArr2, i3, bArr, i, length);
                        System.arraycopy(this._buf, 0, bArr, i + length, i2 - length);
                    }
                }
                this._out = (this._out + i2) % this._buf.length;
                this._free += i2;
                return i2;
            }

            int getAvailable() {
                byte[] bArr = this._buf;
                if (bArr == null) {
                    return 0;
                }
                return bArr.length - this._free;
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                if (this._free == 0) {
                    resize(1);
                }
                if (!$assertionsDisabled && this._free <= 0) {
                    throw new AssertionError();
                }
                byte[] bArr = this._buf;
                int i2 = this._in;
                bArr[i2] = (byte) i;
                this._in = (i2 + 1) % bArr.length;
                this._free--;
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                boolean z = $assertionsDisabled;
                if (!z && i2 < 0) {
                    throw new AssertionError();
                }
                if (i2 == 0) {
                    return;
                }
                if (this._free < i2) {
                    resize(i2);
                }
                if (this._in == this._out) {
                    if (!z && getAvailable() != 0) {
                        throw new AssertionError();
                    }
                    if (!z && this._free != this._buf.length - getAvailable()) {
                        throw new AssertionError();
                    }
                    this._out = 0;
                    this._in = 0;
                }
                byte[] bArr2 = this._buf;
                int length = bArr2.length;
                int i3 = this._in;
                int i4 = length - i3;
                if (i3 <= this._out || i2 < i4) {
                    System.arraycopy(bArr, i, bArr2, i3, i2);
                    this._in += i2;
                } else {
                    System.arraycopy(bArr, i, bArr2, i3, i4);
                    System.arraycopy(bArr, i + i4, this._buf, 0, i2 - i4);
                    this._in = (this._in + i2) % this._buf.length;
                }
                this._free -= i2;
            }

            void resize(int i) {
                if (!$assertionsDisabled && i <= this._free) {
                    throw new AssertionError(new StringBuffer().append(i).append(" !> ").append(this._free).toString());
                }
                byte[] bArr = this._buf;
                int length = bArr == null ? 4096 : bArr.length * 2;
                int available = getAvailable();
                while (length - available < i) {
                    length *= 2;
                }
                byte[] bArr2 = new byte[length];
                if (available > 0) {
                    int i2 = this._in;
                    int i3 = this._out;
                    if (i2 > i3) {
                        System.arraycopy(this._buf, i3, bArr2, 0, available);
                    } else {
                        System.arraycopy(this._buf, i3, bArr2, 0, available - i2);
                        byte[] bArr3 = this._buf;
                        int i4 = this._in;
                        System.arraycopy(bArr3, 0, bArr2, available - i4, i4);
                    }
                    this._out = 0;
                    this._in = available;
                    this._free += length - this._buf.length;
                } else {
                    this._free = length;
                    if (!$assertionsDisabled && this._in != this._out) {
                        throw new AssertionError();
                    }
                }
                this._buf = bArr2;
            }
        }
    }

    static final class XmlInputStreamSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled;
        private XmlEventImpl _in;
        private XmlEventImpl _out;

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        XmlInputStreamSaver(Cur cur, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            if (!$assertionsDisabled && !saveCur.isElem()) {
                throw new AssertionError();
            }
            iterateMappings();
            while (hasMapping()) {
                enqueue(new StartPrefixMappingImpl(mappingPrefix(), mappingUri()));
                nextMapping();
            }
            StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl = null;
            int i = 0;
            StartElementImpl.NormalAttributeImpl normalAttributeImpl = null;
            StartElementImpl.NormalAttributeImpl normalAttributeImpl2 = null;
            while (i < arrayList.size()) {
                StartElementImpl.NormalAttributeImpl normalAttributeImpl3 = new StartElementImpl.NormalAttributeImpl(computeName((QName) arrayList.get(i), this, true), (String) arrayList2.get(i));
                if (normalAttributeImpl == null) {
                    normalAttributeImpl = normalAttributeImpl3;
                } else {
                    normalAttributeImpl2._next = normalAttributeImpl3;
                }
                i++;
                normalAttributeImpl2 = normalAttributeImpl3;
            }
            iterateMappings();
            StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl2 = null;
            while (hasMapping()) {
                StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl3 = new StartElementImpl.XmlnsAttributeImpl(mappingPrefix(), mappingUri());
                if (xmlnsAttributeImpl == null) {
                    xmlnsAttributeImpl = xmlnsAttributeImpl3;
                } else {
                    xmlnsAttributeImpl2._next = xmlnsAttributeImpl3;
                }
                nextMapping();
                xmlnsAttributeImpl2 = xmlnsAttributeImpl3;
            }
            enqueue(new StartElementImpl(computeName(saveCur.getName(), this, false), normalAttributeImpl, xmlnsAttributeImpl, getPrefixMap()));
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) {
            if (saveCur.isRoot()) {
                enqueue(new EndDocumentImpl());
            } else {
                enqueue(new EndElementImpl(computeName(saveCur.getName(), this, false)));
            }
            emitEndPrefixMappings();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isText()) {
                throw new AssertionError();
            }
            enqueue(new CharacterDataImpl(saveCur.getChars(), saveCur._cchSrc, saveCur._offSrc));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) {
            enqueue(new CommentImpl(saveCur.getChars(), saveCur._cchSrc, saveCur._offSrc));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) {
            QName name = saveCur.getName();
            enqueue(new ProcessingInstructionImpl(name != null ? name.getLocalPart() : null, saveCur.getChars(), saveCur._cchSrc, saveCur._offSrc));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
            enqueue(new StartDocumentImpl(str3, null, true, null));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
            emitDocType(null, null, null);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
            enqueue(new EndDocumentImpl());
        }

        XMLEvent dequeue() {
            if (this._out == null) {
                enterLocale();
                try {
                    if (!process()) {
                        return null;
                    }
                } finally {
                    exitLocale();
                }
            }
            XmlEventImpl xmlEventImpl = this._out;
            if (xmlEventImpl == null) {
                return null;
            }
            XmlEventImpl xmlEventImpl2 = xmlEventImpl._next;
            this._out = xmlEventImpl2;
            if (xmlEventImpl2 == null) {
                this._in = null;
            }
            return xmlEventImpl;
        }

        private void enqueue(XmlEventImpl xmlEventImpl) {
            boolean z = $assertionsDisabled;
            if (!z && xmlEventImpl._next != null) {
                throw new AssertionError();
            }
            XmlEventImpl xmlEventImpl2 = this._in;
            if (xmlEventImpl2 == null) {
                if (!z && this._out != null) {
                    throw new AssertionError();
                }
                this._in = xmlEventImpl;
                this._out = xmlEventImpl;
                return;
            }
            xmlEventImpl2._next = xmlEventImpl;
            this._in = xmlEventImpl;
        }

        protected void emitEndPrefixMappings() {
            iterateMappings();
            while (hasMapping()) {
                String mappingPrefix = mappingPrefix();
                mappingUri();
                enqueue(new EndPrefixMappingImpl(mappingPrefix));
                nextMapping();
            }
        }

        private static XMLName computeName(QName qName, Saver saver, boolean z) {
            String namespaceURI = qName.getNamespaceURI();
            String localPart = qName.getLocalPart();
            boolean z2 = $assertionsDisabled;
            if (!z2 && namespaceURI == null) {
                throw new AssertionError();
            }
            if (!z2 && localPart.length() <= 0) {
                throw new AssertionError();
            }
            String str = null;
            if (namespaceURI != null && namespaceURI.length() != 0) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = saver.getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = saver.getUriMapping(namespaceURI);
                }
                str = prefix;
                if (z && str.length() == 0) {
                    str = saver.getNonDefaultUriMapping(namespaceURI);
                }
            }
            return new XmlNameImpl(namespaceURI, localPart, str);
        }

        private static abstract class XmlEventImpl extends XmlEventBase {
            XmlEventImpl _next;

            @Override // org.apache.xmlbeans.xml.stream.XMLEvent
            public final Location getLocation() {
                return null;
            }

            @Override // org.apache.xmlbeans.xml.stream.XMLEvent
            public XMLName getName() {
                return null;
            }

            @Override // org.apache.xmlbeans.xml.stream.XMLEvent
            public boolean hasName() {
                return false;
            }

            XmlEventImpl(int i) {
                super(i);
            }

            @Override // org.apache.xmlbeans.xml.stream.XMLEvent
            public XMLName getSchemaType() {
                throw new RuntimeException("NYI");
            }
        }

        private static class StartDocumentImpl extends XmlEventImpl implements StartDocument {
            String _encoding;
            boolean _standAlone;
            String _systemID;
            String _version;

            StartDocumentImpl(String str, String str2, boolean z, String str3) {
                super(256);
                this._systemID = str;
                this._encoding = str2;
                this._standAlone = z;
                this._version = str3;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartDocument
            public String getSystemId() {
                return this._systemID;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartDocument
            public String getCharacterEncodingScheme() {
                return this._encoding;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartDocument
            public boolean isStandalone() {
                return this._standAlone;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartDocument
            public String getVersion() {
                return this._version;
            }
        }

        private static class StartElementImpl extends XmlEventImpl implements StartElement {
            private AttributeImpl _attributes;
            private XMLName _name;
            private AttributeImpl _namespaces;
            private Map _prefixMap;

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl, org.apache.xmlbeans.xml.stream.XMLEvent
            public boolean hasName() {
                return true;
            }

            StartElementImpl(XMLName xMLName, AttributeImpl attributeImpl, AttributeImpl attributeImpl2, Map map) {
                super(2);
                this._name = xMLName;
                this._attributes = attributeImpl;
                this._namespaces = attributeImpl2;
                this._prefixMap = map;
            }

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl, org.apache.xmlbeans.xml.stream.XMLEvent
            public XMLName getName() {
                return this._name;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartElement
            public AttributeIterator getAttributes() {
                return new AttributeIteratorImpl(this._attributes, null);
            }

            @Override // org.apache.xmlbeans.xml.stream.StartElement
            public AttributeIterator getNamespaces() {
                return new AttributeIteratorImpl(null, this._namespaces);
            }

            @Override // org.apache.xmlbeans.xml.stream.StartElement
            public AttributeIterator getAttributesAndNamespaces() {
                return new AttributeIteratorImpl(this._attributes, this._namespaces);
            }

            @Override // org.apache.xmlbeans.xml.stream.StartElement
            public Attribute getAttributeByName(XMLName xMLName) {
                for (AttributeImpl attributeImpl = this._attributes; attributeImpl != null; attributeImpl = attributeImpl._next) {
                    if (xMLName.equals(attributeImpl.getName())) {
                        return attributeImpl;
                    }
                }
                return null;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartElement
            public String getNamespaceUri(String str) {
                Map map = this._prefixMap;
                if (str == null) {
                    str = "";
                }
                return (String) map.get(str);
            }

            @Override // org.apache.xmlbeans.xml.stream.StartElement
            public Map getNamespaceMap() {
                return this._prefixMap;
            }

            private static class AttributeIteratorImpl implements AttributeIterator {
                private AttributeImpl _attributes;
                private AttributeImpl _namespaces;

                private final void checkVersion() {
                }

                public Object monitor() {
                    return this;
                }

                AttributeIteratorImpl(AttributeImpl attributeImpl, AttributeImpl attributeImpl2) {
                    this._attributes = attributeImpl;
                    this._namespaces = attributeImpl2;
                }

                @Override // org.apache.xmlbeans.xml.stream.AttributeIterator
                public Attribute next() {
                    AttributeImpl attributeImpl;
                    synchronized (monitor()) {
                        checkVersion();
                        attributeImpl = null;
                        AttributeImpl attributeImpl2 = this._attributes;
                        if (attributeImpl2 != null) {
                            this._attributes = attributeImpl2._next;
                        } else {
                            attributeImpl2 = this._namespaces;
                            if (attributeImpl2 != null) {
                                this._namespaces = attributeImpl2._next;
                            }
                        }
                        attributeImpl = attributeImpl2;
                    }
                    return attributeImpl;
                }

                @Override // org.apache.xmlbeans.xml.stream.AttributeIterator
                public boolean hasNext() {
                    boolean z;
                    synchronized (monitor()) {
                        checkVersion();
                        z = (this._attributes == null && this._namespaces == null) ? false : true;
                    }
                    return z;
                }

                @Override // org.apache.xmlbeans.xml.stream.AttributeIterator
                public Attribute peek() {
                    synchronized (monitor()) {
                        checkVersion();
                        AttributeImpl attributeImpl = this._attributes;
                        if (attributeImpl != null) {
                            return attributeImpl;
                        }
                        AttributeImpl attributeImpl2 = this._namespaces;
                        if (attributeImpl2 != null) {
                            return attributeImpl2;
                        }
                        return null;
                    }
                }

                @Override // org.apache.xmlbeans.xml.stream.AttributeIterator
                public void skip() {
                    synchronized (monitor()) {
                        checkVersion();
                        AttributeImpl attributeImpl = this._attributes;
                        if (attributeImpl != null) {
                            this._attributes = attributeImpl._next;
                        } else {
                            AttributeImpl attributeImpl2 = this._namespaces;
                            if (attributeImpl2 != null) {
                                this._namespaces = attributeImpl2._next;
                            }
                        }
                    }
                }
            }

            private static abstract class AttributeImpl implements Attribute {
                protected XMLName _name;
                AttributeImpl _next;

                @Override // org.apache.xmlbeans.xml.stream.Attribute
                public XMLName getSchemaType() {
                    return null;
                }

                @Override // org.apache.xmlbeans.xml.stream.Attribute
                public String getType() {
                    return "CDATA";
                }

                AttributeImpl() {
                }

                @Override // org.apache.xmlbeans.xml.stream.Attribute
                public XMLName getName() {
                    return this._name;
                }
            }

            private static class XmlnsAttributeImpl extends AttributeImpl {
                private String _uri;

                XmlnsAttributeImpl(String str, String str2) {
                    this._uri = str2;
                    String str3 = "xmlns";
                    if (str.length() == 0) {
                        str = "xmlns";
                        str3 = null;
                    }
                    this._name = new XmlNameImpl(null, str, str3);
                }

                @Override // org.apache.xmlbeans.xml.stream.Attribute
                public String getValue() {
                    return this._uri;
                }
            }

            private static class NormalAttributeImpl extends AttributeImpl {
                private String _value;

                NormalAttributeImpl(XMLName xMLName, String str) {
                    this._name = xMLName;
                    this._value = str;
                }

                @Override // org.apache.xmlbeans.xml.stream.Attribute
                public String getValue() {
                    return this._value;
                }
            }
        }

        private static class StartPrefixMappingImpl extends XmlEventImpl implements StartPrefixMapping {
            private String _prefix;
            private String _uri;

            StartPrefixMappingImpl(String str, String str2) {
                super(1024);
                this._prefix = str;
                this._uri = str2;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartPrefixMapping
            public String getNamespaceUri() {
                return this._uri;
            }

            @Override // org.apache.xmlbeans.xml.stream.StartPrefixMapping
            public String getPrefix() {
                return this._prefix;
            }
        }

        private static class ChangePrefixMappingImpl extends XmlEventImpl implements ChangePrefixMapping {
            private String _newUri;
            private String _oldUri;
            private String _prefix;

            ChangePrefixMappingImpl(String str, String str2, String str3) {
                super(4096);
                this._oldUri = str2;
                this._newUri = str3;
                this._prefix = str;
            }

            @Override // org.apache.xmlbeans.xml.stream.ChangePrefixMapping
            public String getOldNamespaceUri() {
                return this._oldUri;
            }

            @Override // org.apache.xmlbeans.xml.stream.ChangePrefixMapping
            public String getNewNamespaceUri() {
                return this._newUri;
            }

            @Override // org.apache.xmlbeans.xml.stream.ChangePrefixMapping
            public String getPrefix() {
                return this._prefix;
            }
        }

        private static class EndPrefixMappingImpl extends XmlEventImpl implements EndPrefixMapping {
            private String _prefix;

            EndPrefixMappingImpl(String str) {
                super(2048);
                this._prefix = str;
            }

            @Override // org.apache.xmlbeans.xml.stream.EndPrefixMapping
            public String getPrefix() {
                return this._prefix;
            }
        }

        private static class EndElementImpl extends XmlEventImpl implements EndElement {
            private XMLName _name;

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl, org.apache.xmlbeans.xml.stream.XMLEvent
            public boolean hasName() {
                return true;
            }

            EndElementImpl(XMLName xMLName) {
                super(4);
                this._name = xMLName;
            }

            @Override // org.apache.xmlbeans.impl.store.Saver.XmlInputStreamSaver.XmlEventImpl, org.apache.xmlbeans.xml.stream.XMLEvent
            public XMLName getName() {
                return this._name;
            }
        }

        private static class EndDocumentImpl extends XmlEventImpl implements EndDocument {
            EndDocumentImpl() {
                super(512);
            }
        }

        private static class TripletEventImpl extends XmlEventImpl implements CharacterData {
            private int _cch;
            private Object _obj;
            private int _off;

            TripletEventImpl(int i, Object obj, int i2, int i3) {
                super(i);
                this._obj = obj;
                this._cch = i2;
                this._off = i3;
            }

            @Override // org.apache.xmlbeans.xml.stream.CharacterData
            public String getContent() {
                return CharUtil.getString(this._obj, this._off, this._cch);
            }

            @Override // org.apache.xmlbeans.xml.stream.CharacterData
            public boolean hasContent() {
                return this._cch > 0;
            }
        }

        private static class CharacterDataImpl extends TripletEventImpl implements CharacterData {
            CharacterDataImpl(Object obj, int i, int i2) {
                super(16, obj, i, i2);
            }
        }

        private static class CommentImpl extends TripletEventImpl implements Comment {
            CommentImpl(Object obj, int i, int i2) {
                super(32, obj, i, i2);
            }
        }

        private static class ProcessingInstructionImpl extends TripletEventImpl implements ProcessingInstruction {
            private String _target;

            ProcessingInstructionImpl(String str, Object obj, int i, int i2) {
                super(8, obj, i, i2);
                this._target = str;
            }

            @Override // org.apache.xmlbeans.xml.stream.ProcessingInstruction
            public String getTarget() {
                return this._target;
            }

            @Override // org.apache.xmlbeans.xml.stream.ProcessingInstruction
            public String getData() {
                return getContent();
            }
        }
    }

    static final class XmlInputStreamImpl extends GenericXmlInputStream {
        private XmlInputStreamSaver _xmlInputStreamSaver;

        XmlInputStreamImpl(Cur cur, XmlOptions xmlOptions) {
            XmlInputStreamSaver xmlInputStreamSaver = new XmlInputStreamSaver(cur, xmlOptions);
            this._xmlInputStreamSaver = xmlInputStreamSaver;
            xmlInputStreamSaver.process();
        }

        @Override // org.apache.xmlbeans.impl.common.GenericXmlInputStream
        protected XMLEvent nextEvent() throws XMLStreamException {
            return this._xmlInputStreamSaver.dequeue();
        }
    }

    static final class SaxSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled;
        private AttributesImpl _attributes;
        private char[] _buf;
        private ContentHandler _contentHandler;
        private LexicalHandler _lexicalHandler;
        private boolean _nsAsAttrs;

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        SaxSaver(Cur cur, XmlOptions xmlOptions, ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
            super(cur, xmlOptions);
            this._contentHandler = contentHandler;
            this._lexicalHandler = lexicalHandler;
            this._attributes = new AttributesImpl();
            this._nsAsAttrs = !xmlOptions.hasOption(XmlOptions.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
            this._contentHandler.startDocument();
            do {
                try {
                } catch (SaverSAXException e) {
                    throw e._saxException;
                }
            } while (process());
            this._contentHandler.endDocument();
        }

        private class SaverSAXException extends RuntimeException {
            SAXException _saxException;

            SaverSAXException(SAXException sAXException) {
                this._saxException = sAXException;
            }
        }

        private String getPrefixedName(QName qName) {
            String namespaceURI = qName.getNamespaceURI();
            String localPart = qName.getLocalPart();
            if (namespaceURI.length() == 0) {
                return localPart;
            }
            String uriMapping = getUriMapping(namespaceURI);
            return uriMapping.length() == 0 ? localPart : new StringBuffer().append(uriMapping).append(":").append(localPart).toString();
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                String mappingPrefix = mappingPrefix();
                String mappingUri = mappingUri();
                try {
                    this._contentHandler.startPrefixMapping(mappingPrefix, mappingUri);
                    if (this._nsAsAttrs) {
                        if (mappingPrefix == null || mappingPrefix.length() == 0) {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", "xmlns", "xmlns", "CDATA", mappingUri);
                        } else {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", mappingPrefix, new StringBuffer().append(Sax2Dom.XMLNS_STRING).append(mappingPrefix).toString(), "CDATA", mappingUri);
                        }
                    }
                    nextMapping();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            this._attributes.clear();
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                QName qName = (QName) arrayList.get(i);
                this._attributes.addAttribute(qName.getNamespaceURI(), qName.getLocalPart(), getPrefixedName(qName), "CDATA", (String) arrayList2.get(i));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            QName name = saveCur.getName();
            try {
                this._contentHandler.startElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name), this._attributes);
                return false;
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) {
            QName name = saveCur.getName();
            try {
                this._contentHandler.endElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name));
                iterateMappings();
                while (hasMapping()) {
                    this._contentHandler.endPrefixMapping(mappingPrefix());
                    nextMapping();
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isText()) {
                throw new AssertionError();
            }
            Object chars = saveCur.getChars();
            try {
                if (chars instanceof char[]) {
                    this._contentHandler.characters((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                    return;
                }
                if (this._buf == null) {
                    this._buf = new char[1024];
                }
                while (saveCur._cchSrc > 0) {
                    int min = Math.min(this._buf.length, saveCur._cchSrc);
                    CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, min);
                    this._contentHandler.characters(this._buf, 0, min);
                    saveCur._offSrc += min;
                    saveCur._cchSrc -= min;
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) {
            if (this._lexicalHandler != null) {
                saveCur.push();
                saveCur.next();
                try {
                    if (!saveCur.isText()) {
                        this._lexicalHandler.comment(null, 0, 0);
                    } else {
                        Object chars = saveCur.getChars();
                        if (chars instanceof char[]) {
                            this._lexicalHandler.comment((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                        } else {
                            char[] cArr = this._buf;
                            if (cArr == null || cArr.length < saveCur._cchSrc) {
                                this._buf = new char[Math.max(1024, saveCur._cchSrc)];
                            }
                            CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, saveCur._cchSrc);
                            this._lexicalHandler.comment(this._buf, 0, saveCur._cchSrc);
                        }
                    }
                    saveCur.pop();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) {
            saveCur.getName().getLocalPart();
            saveCur.push();
            saveCur.next();
            String string = CharUtil.getString(saveCur.getChars(), saveCur._offSrc, saveCur._cchSrc);
            saveCur.pop();
            try {
                this._contentHandler.processingInstruction(saveCur.getName().getLocalPart(), string);
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
            LexicalHandler lexicalHandler = this._lexicalHandler;
            if (lexicalHandler != null) {
                try {
                    lexicalHandler.startDTD(str, str2, str3);
                    this._lexicalHandler.endDTD();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }
    }

    static abstract class SaveCur {
        int _cchSrc;
        int _offSrc;

        abstract List getAncestorNamespaces();

        abstract String getAttrValue();

        abstract Object getChars();

        abstract XmlDocumentProperties getDocProps();

        abstract QName getName();

        abstract String getXmlnsPrefix();

        abstract String getXmlnsUri();

        abstract boolean hasChildren();

        abstract boolean hasText();

        abstract boolean isTextCData();

        abstract boolean isXmlns();

        abstract int kind();

        abstract boolean next();

        abstract void pop();

        abstract void push();

        abstract void release();

        abstract void toEnd();

        abstract boolean toFirstAttr();

        abstract boolean toNextAttr();

        SaveCur() {
        }

        final boolean isRoot() {
            return kind() == 1;
        }

        final boolean isElem() {
            return kind() == 2;
        }

        final boolean isAttr() {
            return kind() == 3;
        }

        final boolean isText() {
            return kind() == 0;
        }

        final boolean isComment() {
            return kind() == 4;
        }

        final boolean isProcinst() {
            return kind() == 5;
        }

        final boolean isFinish() {
            return Cur.kindIsFinish(kind());
        }

        final boolean isContainer() {
            return Cur.kindIsContainer(kind());
        }

        final boolean isNormalAttr() {
            return kind() == 3 && !isXmlns();
        }

        final boolean skip() {
            toEnd();
            return next();
        }
    }

    private static final class DocSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Cur _cur;

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List getAncestorNamespaces() {
            return null;
        }

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        DocSaveCur(Cur cur) {
            if (!$assertionsDisabled && !cur.isRoot()) {
                throw new AssertionError();
            }
            this._cur = cur.weakCur(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            if ($assertionsDisabled || this._cur.isAttr()) {
                return this._cur.getValueAsString();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            return this._cur.next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object chars = this._cur.getChars(-1);
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }
    }

    private static abstract class FilterSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled;
        private SaveCur _cur;

        protected abstract boolean filter();

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        FilterSaveCur(SaveCur saveCur) {
            if (!$assertionsDisabled && !saveCur.isRoot()) {
                throw new AssertionError();
            }
            this._cur = saveCur;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            if (!this._cur.next()) {
                return false;
            }
            if (!filter()) {
                return true;
            }
            if (!$assertionsDisabled && (isRoot() || isText() || isAttr())) {
                throw new AssertionError();
            }
            toEnd();
            return next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object chars = this._cur.getChars();
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }
    }

    private static final class FilterPiSaveCur extends FilterSaveCur {
        private String _piTarget;

        FilterPiSaveCur(SaveCur saveCur, String str) {
            super(saveCur);
            this._piTarget = str;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.FilterSaveCur
        protected boolean filter() {
            return kind() == 5 && getName().getLocalPart().equals(this._piTarget);
        }
    }

    private static final class FragSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final int CUR = 5;
        private static final int ELEM_END = 4;
        private static final int ELEM_START = 2;
        private static final int ROOT_END = 3;
        private static final int ROOT_START = 1;
        private ArrayList _ancestorNamespaces;
        private Cur _cur;
        private QName _elem;
        private Cur _end;
        private boolean _saveAttr;
        private int _state;
        private int[] _stateStack;
        private int _stateStackSize;

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        FragSaveCur(Cur cur, Cur cur2, QName qName) {
            this._saveAttr = cur.isAttr() && cur.isSamePos(cur2);
            this._cur = cur.weakCur(this);
            this._end = cur2.weakCur(this);
            this._elem = qName;
            this._state = 1;
            this._stateStack = new int[8];
            cur.push();
            computeAncestorNamespaces(cur);
            cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List getAncestorNamespaces() {
            return this._ancestorNamespaces;
        }

        private void computeAncestorNamespaces(Cur cur) {
            this._ancestorNamespaces = new ArrayList();
            while (cur.toParentRaw()) {
                if (cur.toFirstAttr()) {
                    do {
                        if (cur.isXmlns()) {
                            String xmlnsPrefix = cur.getXmlnsPrefix();
                            if (cur.getXmlnsUri().length() > 0 || xmlnsPrefix.length() == 0) {
                                this._ancestorNamespaces.add(cur.getXmlnsPrefix());
                                this._ancestorNamespaces.add(cur.getXmlnsUri());
                            }
                        }
                    } while (cur.toNextAttr());
                    cur.toParent();
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
            this._end.release();
            this._end = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            int i = this._state;
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    if (i == 3) {
                        return -1;
                    }
                    if (i == 4) {
                        return -2;
                    }
                    if ($assertionsDisabled || i == 5) {
                        return this._cur.kind();
                    }
                    throw new AssertionError();
                }
            }
            return i2;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            int i = this._state;
            if (i == 1) {
                return null;
            }
            if (i != 2) {
                if (i == 3) {
                    return null;
                }
                if (i != 4) {
                    if ($assertionsDisabled || i == 5) {
                        return this._cur.getName();
                    }
                    throw new AssertionError();
                }
            }
            return this._elem;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            if ($assertionsDisabled || (this._state == 5 && this._cur.isAttr())) {
                return this._cur.getXmlnsPrefix();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            if ($assertionsDisabled || (this._state == 5 && this._cur.isAttr())) {
                return this._cur.getXmlnsUri();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            if ($assertionsDisabled || (this._state == 5 && this._cur.isAttr())) {
                return this._cur.isXmlns();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            boolean z = false;
            if (isContainer()) {
                push();
                next();
                if (!isText() && !isFinish()) {
                    z = true;
                }
                pop();
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            if (!isContainer()) {
                return false;
            }
            push();
            next();
            boolean isText = isText();
            pop();
            return isText;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            if (!$assertionsDisabled && (this._state != 5 || !this._cur.isText())) {
                throw new AssertionError();
            }
            Object chars = this._cur.getChars(-1);
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            int i = this._state;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return false;
                    }
                    if (i == 4) {
                        this._state = 3;
                    } else if (i == 5) {
                        if (!$assertionsDisabled && this._cur.isAttr()) {
                            throw new AssertionError();
                        }
                        this._cur.next();
                        if (this._cur.isSamePos(this._end)) {
                            this._state = this._elem == null ? 3 : 4;
                        }
                    }
                } else if (this._saveAttr) {
                    this._state = 4;
                } else {
                    if (this._cur.isAttr()) {
                        this._cur.toParent();
                        this._cur.next();
                    }
                    if (this._cur.isSamePos(this._end)) {
                        this._state = 4;
                    } else {
                        this._state = 5;
                    }
                }
            } else {
                this._state = this._elem == null ? 5 : 2;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            int i = this._state;
            if (i == 1) {
                this._state = 3;
                return;
            }
            if (i == 2) {
                this._state = 4;
                return;
            }
            if (i == 3 || i == 4) {
                return;
            }
            if (!$assertionsDisabled && (i != 5 || this._cur.isAttr() || this._cur.isText())) {
                throw new AssertionError();
            }
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            int i = this._state;
            if (i == 1 || i == 3 || i == 4) {
                return false;
            }
            if (i == 5) {
                return this._cur.toFirstAttr();
            }
            if (!$assertionsDisabled && i != 2) {
                throw new AssertionError();
            }
            if (!this._cur.isAttr()) {
                return false;
            }
            this._state = 5;
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            if ($assertionsDisabled || this._state == 5) {
                return !this._saveAttr && this._cur.toNextAttr();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            if ($assertionsDisabled || (this._state == 5 && this._cur.isAttr())) {
                return this._cur.getValueAsString();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            int i = this._stateStackSize;
            int[] iArr = this._stateStack;
            if (i == iArr.length) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this._stateStack = iArr2;
            }
            int[] iArr3 = this._stateStack;
            int i2 = this._stateStackSize;
            this._stateStackSize = i2 + 1;
            iArr3[i2] = this._state;
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
            int[] iArr = this._stateStack;
            int i = this._stateStackSize - 1;
            this._stateStackSize = i;
            this._state = iArr[i];
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }
    }

    private static final class PrettySaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled;
        private SaveCur _cur;
        private int _depth;
        private int _prettyIndent;
        private int _prettyOffset;
        private String _txt;
        private boolean _useCDataBookmarks;
        private boolean _isTextCData = false;
        private StringBuffer _sb = new StringBuffer();
        private ArrayList _stack = new ArrayList();

        static {
            if (Saver.class$org$apache$xmlbeans$impl$store$Saver == null) {
                Saver.class$org$apache$xmlbeans$impl$store$Saver = Saver.class$("org.apache.xmlbeans.impl.store.Saver");
            } else {
                Class cls = Saver.class$org$apache$xmlbeans$impl$store$Saver;
            }
            $assertionsDisabled = true;
        }

        PrettySaveCur(SaveCur saveCur, XmlOptions xmlOptions) {
            this._useCDataBookmarks = false;
            this._cur = saveCur;
            if (!$assertionsDisabled && xmlOptions == null) {
                throw new AssertionError();
            }
            this._prettyIndent = 2;
            if (xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT_INDENT)) {
                this._prettyIndent = ((Integer) xmlOptions.get(XmlOptions.SAVE_PRETTY_PRINT_INDENT)).intValue();
            }
            if (xmlOptions.hasOption(XmlOptions.SAVE_PRETTY_PRINT_OFFSET)) {
                this._prettyOffset = ((Integer) xmlOptions.get(XmlOptions.SAVE_PRETTY_PRINT_OFFSET)).intValue();
            }
            if (xmlOptions.hasOption(XmlOptions.LOAD_SAVE_CDATA_BOOKMARKS)) {
                this._useCDataBookmarks = true;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            if (this._txt == null) {
                return this._cur.kind();
            }
            return 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            if ($assertionsDisabled || this._txt == null) {
                return this._cur.getName();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            if ($assertionsDisabled || this._txt == null) {
                return this._cur.getXmlnsPrefix();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            if ($assertionsDisabled || this._txt == null) {
                return this._cur.getXmlnsUri();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            if (this._txt == null) {
                return this._cur.isXmlns();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            if (this._txt == null) {
                return this._cur.hasChildren();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            if (this._txt == null) {
                return this._cur.hasText();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._txt == null ? this._useCDataBookmarks && this._cur.isTextCData() : this._isTextCData;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            if ($assertionsDisabled || this._txt == null) {
                return this._cur.toFirstAttr();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            if ($assertionsDisabled || this._txt == null) {
                return this._cur.toNextAttr();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            if ($assertionsDisabled || this._txt == null) {
                return this._cur.getAttrValue();
            }
            throw new AssertionError();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            if (!$assertionsDisabled && this._txt != null) {
                throw new AssertionError();
            }
            this._cur.toEnd();
            if (this._cur.kind() == -2) {
                this._depth--;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            String str = this._txt;
            int i = 0;
            if (str != null) {
                boolean z = $assertionsDisabled;
                if (!z && str.length() <= 0) {
                    throw new AssertionError();
                }
                if (!z && this._cur.isText()) {
                    throw new AssertionError();
                }
                this._txt = null;
                this._isTextCData = false;
                i = this._cur.kind();
            } else {
                int kind = this._cur.kind();
                if (!this._cur.next()) {
                    return false;
                }
                StringBuffer stringBuffer = this._sb;
                stringBuffer.delete(0, stringBuffer.length());
                if (!$assertionsDisabled && this._txt != null) {
                    throw new AssertionError();
                }
                if (this._cur.isText()) {
                    this._isTextCData = this._useCDataBookmarks && this._cur.isTextCData();
                    CharUtil.getString(this._sb, this._cur.getChars(), this._cur._offSrc, this._cur._cchSrc);
                    this._cur.next();
                    trim(this._sb);
                }
                int kind2 = this._cur.kind();
                if (this._prettyIndent >= 0 && kind != 4 && kind != 5 && (kind != 2 || kind2 != -2)) {
                    if (this._sb.length() > 0) {
                        this._sb.insert(0, Saver._newLine);
                        spaces(this._sb, Saver._newLine.length(), this._prettyOffset + (this._prettyIndent * this._depth));
                    }
                    if (kind2 != -1) {
                        if (kind != 1) {
                            this._sb.append(Saver._newLine);
                        }
                        int i2 = this._depth;
                        if (kind2 < 0) {
                            i2--;
                        }
                        StringBuffer stringBuffer2 = this._sb;
                        spaces(stringBuffer2, stringBuffer2.length(), this._prettyOffset + (this._prettyIndent * i2));
                    }
                }
                if (this._sb.length() > 0) {
                    this._txt = this._sb.toString();
                } else {
                    i = kind2;
                }
            }
            if (i == 2) {
                this._depth++;
            } else if (i == -2) {
                this._depth--;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
            this._stack.add(this._txt);
            this._stack.add(new Integer(this._depth));
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
            this._depth = ((Integer) this._stack.remove(r0.size() - 1)).intValue();
            this._txt = (String) this._stack.remove(r0.size() - 1);
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            if (this._txt != null) {
                this._offSrc = 0;
                this._cchSrc = this._txt.length();
                return this._txt;
            }
            Object chars = this._cur.getChars();
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        static void spaces(StringBuffer stringBuffer, int i, int i2) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    return;
                }
                stringBuffer.insert(i, ' ');
                i2 = i3;
            }
        }

        static void trim(StringBuffer stringBuffer) {
            int i = 0;
            while (i < stringBuffer.length() && CharUtil.isWhiteSpace(stringBuffer.charAt(i))) {
                i++;
            }
            stringBuffer.delete(0, i);
            int length = stringBuffer.length();
            while (length > 0 && CharUtil.isWhiteSpace(stringBuffer.charAt(length - 1))) {
                length--;
            }
            stringBuffer.delete(length, stringBuffer.length());
        }
    }
}
