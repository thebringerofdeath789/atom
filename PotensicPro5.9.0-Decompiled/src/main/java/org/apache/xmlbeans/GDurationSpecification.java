package org.apache.xmlbeans;

import java.math.BigDecimal;

/* loaded from: classes5.dex */
public interface GDurationSpecification {
    int compareToGDuration(GDurationSpecification gDurationSpecification);

    int getDay();

    BigDecimal getFraction();

    int getHour();

    int getMinute();

    int getMonth();

    int getSecond();

    int getSign();

    int getYear();

    boolean isImmutable();

    boolean isValid();
}
