package org.apache.xmlbeans.impl.jam.mutable;

import java.net.URI;
import org.apache.xmlbeans.impl.jam.JSourcePosition;

/* loaded from: classes5.dex */
public interface MSourcePosition extends JSourcePosition {
    void setColumn(int i);

    void setLine(int i);

    void setSourceURI(URI uri);
}
