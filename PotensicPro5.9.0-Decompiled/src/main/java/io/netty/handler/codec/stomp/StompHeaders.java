package io.netty.handler.codec.stomp;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.transform.OutputKeys;

/* loaded from: classes3.dex */
public interface StompHeaders extends Headers<CharSequence, CharSequence, StompHeaders> {
    public static final AsciiString ACCEPT_VERSION = AsciiString.cached("accept-version");
    public static final AsciiString HOST = AsciiString.cached("host");
    public static final AsciiString LOGIN = AsciiString.cached("login");
    public static final AsciiString PASSCODE = AsciiString.cached("passcode");
    public static final AsciiString HEART_BEAT = AsciiString.cached("heart-beat");
    public static final AsciiString VERSION = AsciiString.cached(OutputKeys.VERSION);
    public static final AsciiString SESSION = AsciiString.cached(RtspHeaders.SESSION);
    public static final AsciiString SERVER = AsciiString.cached("server");
    public static final AsciiString DESTINATION = AsciiString.cached(RtspHeaders.Values.DESTINATION);
    public static final AsciiString ID = AsciiString.cached(TtmlNode.ATTR_ID);
    public static final AsciiString ACK = AsciiString.cached("ack");
    public static final AsciiString TRANSACTION = AsciiString.cached("transaction");
    public static final AsciiString RECEIPT = AsciiString.cached("receipt");
    public static final AsciiString MESSAGE_ID = AsciiString.cached("message-id");
    public static final AsciiString SUBSCRIPTION = AsciiString.cached("subscription");
    public static final AsciiString RECEIPT_ID = AsciiString.cached("receipt-id");
    public static final AsciiString MESSAGE = AsciiString.cached("message");
    public static final AsciiString CONTENT_LENGTH = AsciiString.cached(com.google.android.exoplayer2.source.rtsp.RtspHeaders.CONTENT_LENGTH);
    public static final AsciiString CONTENT_TYPE = AsciiString.cached(com.google.android.exoplayer2.source.rtsp.RtspHeaders.CONTENT_TYPE);

    boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z);

    List<String> getAllAsString(CharSequence charSequence);

    String getAsString(CharSequence charSequence);

    Iterator<Map.Entry<String, String>> iteratorAsString();
}
