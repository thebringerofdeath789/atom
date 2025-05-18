package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class PositionToBeanField<T> extends AbstractFieldMapEntry<String, Integer, T> implements Iterable<FieldMapByPositionEntry<T>> {
    private final String initializer;
    private final List<Range<Integer>> ranges;

    public PositionToBeanField(String str, int i, BeanField<T, Integer> beanField, Locale locale) {
        super(beanField, locale);
        Range<Integer> m2378is;
        Range<Integer> between;
        this.initializer = str;
        this.ranges = new LinkedList();
        int i2 = 0;
        if (StringUtils.isBlank(str)) {
            throw new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.range.definition"), str));
        }
        String[] split = str.split(",");
        try {
            int length = split.length;
            int i3 = 0;
            while (i3 < length) {
                String str2 = split[i3];
                if (StringUtils.isNotEmpty(str2)) {
                    if (str2.contains("-")) {
                        String[] split2 = str2.split("-", 2);
                        Integer valueOf = StringUtils.isEmpty(split2[i2]) ? Integer.valueOf(i2) : Integer.valueOf(split2[i2].trim());
                        Integer valueOf2 = Integer.valueOf(i);
                        if (split2.length == 2 && StringUtils.isNotEmpty(split2[1])) {
                            valueOf2 = Integer.valueOf(split2[1].trim());
                        }
                        m2378is = Range.between(valueOf, valueOf2.intValue() >= i ? valueOf.intValue() >= i ? valueOf : Integer.valueOf(i) : valueOf2);
                    } else {
                        m2378is = Range.m2378is(Integer.valueOf(str2));
                    }
                    ListIterator<Range<Integer>> listIterator = this.ranges.listIterator();
                    int i4 = i2;
                    while (listIterator.hasNext() && i4 == 0) {
                        Range<Integer> next = listIterator.next();
                        if (next.containsRange(m2378is)) {
                            i4 = 1;
                        } else {
                            if (next.isOverlappedBy(m2378is)) {
                                between = Range.between(Integer.valueOf(Math.min(next.getMinimum().intValue(), m2378is.getMinimum().intValue())), Integer.valueOf(Math.max(next.getMaximum().intValue(), m2378is.getMaximum().intValue())));
                                listIterator.remove();
                            } else if (next.getMaximum().intValue() + 1 == m2378is.getMinimum().intValue()) {
                                between = Range.between(next.getMinimum(), m2378is.getMaximum());
                            } else if (m2378is.getMaximum().intValue() + 1 == next.getMinimum().intValue()) {
                                between = Range.between(m2378is.getMinimum(), next.getMaximum());
                            }
                            m2378is = between;
                        }
                    }
                    if (i4 == 0) {
                        this.ranges.add(m2378is);
                    }
                }
                i3++;
                i2 = 0;
            }
        } catch (NumberFormatException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.range.definition"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    public void attenuateRanges(int i) {
        ListIterator<Range<Integer>> listIterator = this.ranges.listIterator();
        while (listIterator.hasNext()) {
            Range<Integer> next = listIterator.next();
            if (next.getMaximum().intValue() > i) {
                if (next.getMinimum().intValue() > i) {
                    listIterator.set(Range.m2378is(next.getMinimum()));
                } else {
                    listIterator.set(Range.between(next.getMinimum(), Integer.valueOf(i)));
                }
            }
        }
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public boolean contains(final Integer num) {
        return this.ranges.stream().anyMatch(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$PositionToBeanField$NEEamaNkUyAj74I24D2DUb2OyuU
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean contains;
                contains = ((Range) obj).contains(num);
                return contains;
            }
        });
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public String getInitializer() {
        return this.initializer;
    }

    @Override // java.lang.Iterable
    public Iterator<FieldMapByPositionEntry<T>> iterator() {
        return new PositionIterator();
    }

    private class PositionIterator implements Iterator<FieldMapByPositionEntry<T>> {
        private Range<Integer> currentRange;
        private int position;
        private ListIterator<Range<Integer>> rangeIterator;

        PositionIterator() {
            if (!PositionToBeanField.this.ranges.isEmpty()) {
                ListIterator<Range<Integer>> listIterator = PositionToBeanField.this.ranges.listIterator();
                this.rangeIterator = listIterator;
                Range<Integer> next = listIterator.next();
                this.currentRange = next;
                this.position = next.getMinimum().intValue();
                return;
            }
            this.position = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position != -1;
        }

        @Override // java.util.Iterator
        public FieldMapByPositionEntry<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            FieldMapByPositionEntry<T> fieldMapByPositionEntry = new FieldMapByPositionEntry<>(this.position, PositionToBeanField.this.field);
            if (this.position == this.currentRange.getMaximum().intValue() || Integer.MAX_VALUE == this.currentRange.getMaximum().intValue()) {
                if (!this.rangeIterator.hasNext()) {
                    this.position = -1;
                } else {
                    Range<Integer> next = this.rangeIterator.next();
                    this.currentRange = next;
                    this.position = next.getMinimum().intValue();
                }
            } else {
                this.position++;
            }
            return fieldMapByPositionEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}