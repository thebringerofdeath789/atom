package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* compiled from: Channel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final int CONFLATED = -1;

    /* renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int RENDEZVOUS = 0;
    public static final int UNLIMITED = Integer.MAX_VALUE;

    /* compiled from: Channel.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left here for binary compatibility")
        public static /* synthetic */ <E> boolean cancel(Channel<E> channel) {
            boolean cancel;
            cancel = channel.cancel(null);
            return cancel;
        }
    }

    /* compiled from: Channel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/Channel$Factory;", "", "()V", "CONFLATED", "", "RENDEZVOUS", "UNLIMITED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    /* renamed from: kotlinx.coroutines.channels.Channel$Factory, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CONFLATED = -1;
        public static final int RENDEZVOUS = 0;
        public static final int UNLIMITED = Integer.MAX_VALUE;

        private Companion() {
        }
    }
}
