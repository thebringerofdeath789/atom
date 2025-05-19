package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ChannelGroupException extends ChannelException implements Iterable<Map.Entry<Channel, Throwable>> {
    private static final long serialVersionUID = -4093064295562629453L;
    private final Collection<Map.Entry<Channel, Throwable>> failed;

    public ChannelGroupException(Collection<Map.Entry<Channel, Throwable>> collection) {
        Objects.requireNonNull(collection, "causes");
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("causes must be non empty");
        }
        this.failed = Collections.unmodifiableCollection(collection);
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Channel, Throwable>> iterator() {
        return this.failed.iterator();
    }
}
