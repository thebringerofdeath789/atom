package org.apache.commons.collections4.list;

import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3677737457567429713L;
    private final Factory<? extends E> factory;
    private final Transformer<Integer, ? extends E> transformer;

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    public static <E> LazyList<E> lazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        return new LazyList<>(list, transformer);
    }

    protected LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        this.factory = (Factory) Objects.requireNonNull(factory);
        this.transformer = null;
    }

    protected LazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        super(list);
        this.factory = null;
        this.transformer = (Transformer) Objects.requireNonNull(transformer);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i) {
        int size = decorated().size();
        if (i < size) {
            E e = (E) decorated().get(i);
            if (e != null) {
                return e;
            }
            E element = element(i);
            decorated().set(i, element);
            return element;
        }
        while (size < i) {
            decorated().add(null);
            size++;
        }
        E element2 = element(i);
        decorated().add(element2);
        return element2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i, int i2) {
        List<E> subList = decorated().subList(i, i2);
        if (this.factory != null) {
            return new LazyList(subList, this.factory);
        }
        if (this.transformer != null) {
            return new LazyList(subList, this.transformer);
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }

    private E element(int i) {
        Factory<? extends E> factory = this.factory;
        if (factory != null) {
            return factory.create();
        }
        Transformer<Integer, ? extends E> transformer = this.transformer;
        if (transformer != null) {
            return transformer.transform(Integer.valueOf(i));
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }
}
