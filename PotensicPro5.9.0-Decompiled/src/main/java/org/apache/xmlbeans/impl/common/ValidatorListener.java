package org.apache.xmlbeans.impl.common;

import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import org.apache.xmlbeans.XmlCursor;

/* loaded from: classes5.dex */
public interface ValidatorListener {
    public static final int ATTR = 4;
    public static final int BEGIN = 1;
    public static final int END = 2;
    public static final int ENDATTRS = 5;
    public static final int TEXT = 3;

    public interface Event extends PrefixResolver {
        public static final int COLLAPSE = 3;
        public static final int PRESERVE = 1;
        public static final int REPLACE = 2;

        Location getLocation();

        XmlCursor getLocationAsCursor();

        QName getName();

        String getText();

        String getText(int i);

        String getXsiLoc();

        String getXsiNil();

        String getXsiNoLoc();

        String getXsiType();

        boolean textIsWhitespace();
    }

    void nextEvent(int i, Event event);
}
