package org.apache.xmlbeans.impl.validator;

import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import java.util.Collection;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;

/* loaded from: classes5.dex */
public class ValidatorUtil {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$validator$ValidatorUtil;

    static {
        if (class$org$apache$xmlbeans$impl$validator$ValidatorUtil == null) {
            class$org$apache$xmlbeans$impl$validator$ValidatorUtil = class$("org.apache.xmlbeans.impl.validator.ValidatorUtil");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static class EventImpl implements ValidatorListener.Event {
        PrefixResolver _prefixResolver;
        String _text;

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            return false;
        }

        EventImpl(PrefixResolver prefixResolver, String str) {
            this._prefixResolver = prefixResolver;
            this._text = str;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            return this._text;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i) {
            return XmlWhitespace.collapse(this._text, i);
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            return this._prefixResolver.getNamespaceForPrefix(str);
        }
    }

    public static boolean validateSimpleType(SchemaType schemaType, String str, Collection collection, PrefixResolver prefixResolver) {
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            if ($assertionsDisabled) {
                throw new RuntimeException("Not a simple type");
            }
            throw new AssertionError();
        }
        Validator validator = new Validator(schemaType, null, schemaType.getTypeSystem(), null, collection);
        EventImpl eventImpl = new EventImpl(prefixResolver, str);
        validator.nextEvent(1, eventImpl);
        validator.nextEvent(3, eventImpl);
        validator.nextEvent(2, eventImpl);
        return validator.isValid();
    }
}
