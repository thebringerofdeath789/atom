package org.apache.commons.lang3.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.stream.Streams;

/* loaded from: classes4.dex */
public class Streams {

    public static class ArrayCollector<O> implements Collector<O, List<O>, O[]> {
        private static final Set<Collector.Characteristics> characteristics = Collections.emptySet();
        private final Class<O> elementType;

        public static /* synthetic */ ArrayList lambda$gDKEcGxnaIgU7sqXbIS8kj9NQtE() {
            return new ArrayList();
        }

        public ArrayCollector(Class<O> cls) {
            this.elementType = cls;
        }

        @Override // java.util.stream.Collector
        public BiConsumer<List<O>, O> accumulator() {
            return new BiConsumer() { // from class: org.apache.commons.lang3.stream.-$$Lambda$I4culQbRd0-rjXdb6TS5OWvOlKc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((List) obj).add(obj2);
                }
            };
        }

        @Override // java.util.stream.Collector
        public Set<Collector.Characteristics> characteristics() {
            return characteristics;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator<List<O>> combiner() {
            return new BinaryOperator() { // from class: org.apache.commons.lang3.stream.-$$Lambda$Streams$ArrayCollector$tuzaNJ424RGGy-rRxmY5_cBxxCc
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Streams.ArrayCollector.lambda$combiner$0((List) obj, (List) obj2);
                }
            };
        }

        static /* synthetic */ List lambda$combiner$0(List list, List list2) {
            list.addAll(list2);
            return list;
        }

        @Override // java.util.stream.Collector
        public Function<List<O>, O[]> finisher() {
            return new Function() { // from class: org.apache.commons.lang3.stream.-$$Lambda$Streams$ArrayCollector$s1PoueMZ7kzelINTIqI11UshIrE
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Streams.ArrayCollector.this.lambda$finisher$1$Streams$ArrayCollector((List) obj);
                }
            };
        }

        public /* synthetic */ Object[] lambda$finisher$1$Streams$ArrayCollector(List list) {
            return list.toArray((Object[]) Array.newInstance((Class<?>) this.elementType, list.size()));
        }

        @Override // java.util.stream.Collector
        public Supplier<List<O>> supplier() {
            return new Supplier() { // from class: org.apache.commons.lang3.stream.-$$Lambda$Streams$ArrayCollector$gDKEcGxnaIgU7sqXbIS8kj9NQtE
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Streams.ArrayCollector.lambda$gDKEcGxnaIgU7sqXbIS8kj9NQtE();
                }
            };
        }
    }

    public static class FailableStream<O> {
        private Stream<O> stream;
        private boolean terminated;

        public FailableStream(Stream<O> stream) {
            this.stream = stream;
        }

        public boolean allMatch(FailablePredicate<O, ?> failablePredicate) {
            assertNotTerminated();
            return stream().allMatch(Failable.asPredicate(failablePredicate));
        }

        public boolean anyMatch(FailablePredicate<O, ?> failablePredicate) {
            assertNotTerminated();
            return stream().anyMatch(Failable.asPredicate(failablePredicate));
        }

        protected void assertNotTerminated() {
            if (this.terminated) {
                throw new IllegalStateException("This stream is already terminated.");
            }
        }

        public <A, R> R collect(Collector<? super O, A, R> collector) {
            makeTerminated();
            return (R) stream().collect(collector);
        }

        public <A, R> R collect(Supplier<R> supplier, BiConsumer<R, ? super O> biConsumer, BiConsumer<R, R> biConsumer2) {
            makeTerminated();
            return (R) stream().collect(supplier, biConsumer, biConsumer2);
        }

        public FailableStream<O> filter(FailablePredicate<O, ?> failablePredicate) {
            assertNotTerminated();
            this.stream = this.stream.filter(Failable.asPredicate(failablePredicate));
            return this;
        }

        public void forEach(FailableConsumer<O, ?> failableConsumer) {
            makeTerminated();
            stream().forEach(Failable.asConsumer(failableConsumer));
        }

        protected void makeTerminated() {
            assertNotTerminated();
            this.terminated = true;
        }

        public <R> FailableStream<R> map(FailableFunction<O, R, ?> failableFunction) {
            assertNotTerminated();
            return new FailableStream<>(this.stream.map(Failable.asFunction(failableFunction)));
        }

        public O reduce(O o, BinaryOperator<O> binaryOperator) {
            makeTerminated();
            return stream().reduce(o, binaryOperator);
        }

        public Stream<O> stream() {
            return this.stream;
        }
    }

    public static <O> FailableStream<O> stream(Collection<O> collection) {
        return stream(collection.stream());
    }

    public static <O> FailableStream<O> stream(Stream<O> stream) {
        return new FailableStream<>(stream);
    }

    public static <O> Collector<O, ?, O[]> toArray(Class<O> cls) {
        return new ArrayCollector(cls);
    }
}
