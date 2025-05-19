package org.apache.commons.net;

import java.util.EventListener;

/* loaded from: classes4.dex */
public interface ProtocolCommandListener extends EventListener {
    void protocolCommandSent(ProtocolCommandEvent protocolCommandEvent);

    void protocolReplyReceived(ProtocolCommandEvent protocolCommandEvent);
}
