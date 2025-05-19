package org.apache.commons.lang3.time;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.xmlbeans.SchemaType;

/* loaded from: classes4.dex */
public class DurationUtils {
    static final Range<Long> LONG_TO_INT_RANGE = Range.between(NumberUtils.LONG_INT_MIN_VALUE, NumberUtils.LONG_INT_MAX_VALUE);

    public static <T extends Throwable> void accept(FailableBiConsumer<Long, Integer, T> failableBiConsumer, Duration duration) throws Throwable {
        if (failableBiConsumer == null || duration == null) {
            return;
        }
        failableBiConsumer.accept(Long.valueOf(duration.toMillis()), Integer.valueOf(getNanosOfMiili(duration)));
    }

    public static int getNanosOfMiili(Duration duration) {
        return duration.getNano() % SchemaType.SIZE_BIG_INTEGER;
    }

    public static boolean isPositive(Duration duration) {
        return (duration.isNegative() || duration.isZero()) ? false : true;
    }

    /* renamed from: org.apache.commons.lang3.time.DurationUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static ChronoUnit toChronoUnit(TimeUnit timeUnit) {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[((TimeUnit) Objects.requireNonNull(timeUnit)).ordinal()]) {
            case 1:
                return ChronoUnit.NANOS;
            case 2:
                return ChronoUnit.MICROS;
            case 3:
                return ChronoUnit.MILLIS;
            case 4:
                return ChronoUnit.SECONDS;
            case 5:
                return ChronoUnit.MINUTES;
            case 6:
                return ChronoUnit.HOURS;
            case 7:
                return ChronoUnit.DAYS;
            default:
                throw new IllegalArgumentException(timeUnit.toString());
        }
    }

    public static Duration toDuration(long j, TimeUnit timeUnit) {
        return Duration.of(j, toChronoUnit(timeUnit));
    }

    public static int toMillisInt(Duration duration) {
        Objects.requireNonNull(duration, "duration");
        return LONG_TO_INT_RANGE.fit(Long.valueOf(duration.toMillis())).intValue();
    }

    public static Duration zeroIfNull(Duration duration) {
        return (Duration) ObjectUtils.defaultIfNull(duration, Duration.ZERO);
    }
}
