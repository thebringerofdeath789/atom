package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.Era;
import java.time.chrono.HijrahEra;
import java.time.chrono.IsoEra;
import java.time.chrono.JapaneseEra;
import java.time.chrono.MinguoEra;
import java.time.chrono.ThaiBuddhistEra;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BiFunction;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class ConverterDate extends AbstractCsvConverter {
    private static final String CSVDATE_NOT_DATE = "csvdate.not.date";
    private final DateTimeFormatter readDtf;
    private final SimpleDateFormat readSdf;
    private final BiFunction<DateTimeFormatter, String, TemporalAccessor> readTemporalConversionFunction;
    private final DateTimeFormatter writeDtf;
    private final SimpleDateFormat writeSdf;
    private final BiFunction<DateTimeFormatter, TemporalAccessor, String> writeTemporalConversionFunction;

    public ConverterDate(Class<?> cls, String str, String str2, Locale locale, String str3, String str4, String str5, String str6) {
        super(cls, str, str2, locale);
        Chronology chronology = getChronology(str5, this.locale);
        Chronology chronology2 = getChronology(str6, this.writeLocale);
        try {
            if (TemporalAccessor.class.isAssignableFrom(cls)) {
                this.readSdf = null;
                this.readDtf = setDateTimeFormatter(str3, this.locale).withChronology(chronology);
                this.readTemporalConversionFunction = determineReadTemporalConversionFunction(cls);
            } else {
                this.readDtf = null;
                this.readTemporalConversionFunction = null;
                this.readSdf = setDateFormat(str3, this.locale);
            }
            try {
                if (TemporalAccessor.class.isAssignableFrom(cls)) {
                    this.writeSdf = null;
                    this.writeDtf = setDateTimeFormatter(str4, this.writeLocale).withChronology(chronology2);
                    this.writeTemporalConversionFunction = determineWriteTemporalConversionFunction(cls);
                } else {
                    this.writeDtf = null;
                    this.writeTemporalConversionFunction = null;
                    this.writeSdf = setDateFormat(str4, this.writeLocale);
                }
            } catch (IllegalArgumentException e) {
                CsvBadConverterException csvBadConverterException = new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.date.format.string"), str4));
                csvBadConverterException.initCause(e);
                throw csvBadConverterException;
            }
        } catch (IllegalArgumentException e2) {
            CsvBadConverterException csvBadConverterException2 = new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.date.format.string"), str3));
            csvBadConverterException2.initCause(e2);
            throw csvBadConverterException2;
        }
    }

    private BiFunction<DateTimeFormatter, TemporalAccessor, String> determineWriteTemporalConversionFunction(Class<?> cls) {
        if (Instant.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$CM0Mr_7cG9lRtqGD0e04OReEhQs
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    String format;
                    format = ((DateTimeFormatter) obj).format(LocalDateTime.ofInstant((Instant) ((TemporalAccessor) obj2), ZoneId.of("UTC")));
                    return format;
                }
            };
        }
        return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$fkUDsB6umL5xIfYQrPANF4tvQAg
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                String format;
                format = ((DateTimeFormatter) obj).format((TemporalAccessor) obj2);
                return format;
            }
        };
    }

    private BiFunction<DateTimeFormatter, String, TemporalAccessor> determineReadTemporalConversionFunction(Class<?> cls) {
        if (TemporalAccessor.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$XWZEnKUEcU0fMlfWjqlS9BU4mZE
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    TemporalAccessor parse;
                    parse = ((DateTimeFormatter) obj).parse((String) obj2);
                    return parse;
                }
            };
        }
        if (ChronoLocalDateTime.class.equals(cls) || LocalDateTime.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$k2O9DrryiN4i4PiRRvOGblBl-9o
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$2((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (ChronoZonedDateTime.class.equals(cls) || ZonedDateTime.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$cJXjuCdELTTsbjsffFqwg-JlAcw
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$3((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (Temporal.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$-GEyVtFI4G2h_YlI7w2a-iGCnOI
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    TemporalAccessor parseBest;
                    parseBest = ((DateTimeFormatter) obj).parseBest((String) obj2, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$Z9h0KkR5ob63Rhjep_hd1TtDozs
                        @Override // java.time.temporal.TemporalQuery
                        public final Object queryFrom(TemporalAccessor temporalAccessor) {
                            ZonedDateTime from;
                            from = ZonedDateTime.from(temporalAccessor);
                            return from;
                        }
                    }, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$5Ao3A7GVHUbIVsionUYLvcAWXMY
                        @Override // java.time.temporal.TemporalQuery
                        public final Object queryFrom(TemporalAccessor temporalAccessor) {
                            OffsetDateTime from;
                            from = OffsetDateTime.from(temporalAccessor);
                            return from;
                        }
                    }, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$TqQ-ucMDDG8HLo-iTiWgQ8I72oQ
                        @Override // java.time.temporal.TemporalQuery
                        public final Object queryFrom(TemporalAccessor temporalAccessor) {
                            Instant from;
                            from = Instant.from(temporalAccessor);
                            return from;
                        }
                    }, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$Um1dw9-Pq48UfaThiKhJ9PV65fs
                        @Override // java.time.temporal.TemporalQuery
                        public final Object queryFrom(TemporalAccessor temporalAccessor) {
                            LocalDateTime from;
                            from = LocalDateTime.from(temporalAccessor);
                            return from;
                        }
                    }, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$ZzhYCDVA9YULuZ70faWnZKrrLFQ
                        @Override // java.time.temporal.TemporalQuery
                        public final Object queryFrom(TemporalAccessor temporalAccessor) {
                            LocalDate from;
                            from = LocalDate.from(temporalAccessor);
                            return from;
                        }
                    }, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$Iwkjj42MDNtTx2ctvgxvjLULy7Q
                        @Override // java.time.temporal.TemporalQuery
                        public final Object queryFrom(TemporalAccessor temporalAccessor) {
                            OffsetTime from;
                            from = OffsetTime.from(temporalAccessor);
                            return from;
                        }
                    }, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$s8T3Wy3CSRTJN_wu6Y_qp3wsdyM
                        @Override // java.time.temporal.TemporalQuery
                        public final Object queryFrom(TemporalAccessor temporalAccessor) {
                            LocalTime from;
                            from = LocalTime.from(temporalAccessor);
                            return from;
                        }
                    });
                    return parseBest;
                }
            };
        }
        if (Era.class.equals(cls) || IsoEra.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$k_opmNQbdEncGf5TpyxOC94sVvU
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    TemporalAccessor of;
                    of = IsoEra.of(((DateTimeFormatter) obj).parse((String) obj2).get(ChronoField.ERA));
                    return of;
                }
            };
        }
        if (DayOfWeek.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$x87WlofvnTDSgQZWB98bS74ORSg
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$6((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (HijrahEra.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$G22LVGaaf-nnVz5ZS6jyRB48vqQ
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    TemporalAccessor of;
                    of = HijrahEra.of(((DateTimeFormatter) obj).parse((String) obj2).get(ChronoField.ERA));
                    return of;
                }
            };
        }
        if (Instant.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$-ukbK3AjP0f3scYUAxVjJ1D0R6Y
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$8((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (ChronoLocalDate.class.isAssignableFrom(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$F37zKWLHLTjiW38DP3p4IyZv6Do
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$9((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (JapaneseEra.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$40mJZrT1YASpqPFvtuPYL2XRA_M
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    TemporalAccessor of;
                    of = JapaneseEra.of(((DateTimeFormatter) obj).parse((String) obj2).get(ChronoField.ERA));
                    return of;
                }
            };
        }
        if (LocalTime.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$46TzR_NBfAAor4u8WhLAlHEiuWM
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$11((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (MinguoEra.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$UDssrg8FAbCksPft37D2o0HDAt0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    TemporalAccessor of;
                    of = MinguoEra.of(((DateTimeFormatter) obj).parse((String) obj2).get(ChronoField.ERA));
                    return of;
                }
            };
        }
        if (Month.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$6e6aHuIMdY-S19Zx_j4N0r31wIE
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$13((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (MonthDay.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$0FcvlUj9a0WGsPaq4-G17F_Q3CQ
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$14((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (OffsetDateTime.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$DIaiGVOY2vVmgzfy5jGQgtvXF4w
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$15((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (OffsetTime.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$iR-UJOaos5TOvSf7OLsfe1JB4yo
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$16((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (ThaiBuddhistEra.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$7FY_b_LTe14jY4phl6QUWC0uxFk
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    TemporalAccessor of;
                    of = ThaiBuddhistEra.of(((DateTimeFormatter) obj).parse((String) obj2).get(ChronoField.ERA));
                    return of;
                }
            };
        }
        if (Year.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$at0jsNB5xde9ntI5eYZrPptYlSw
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$18((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (YearMonth.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$QRzaMnnqmn9kZgKMtTAYkKn1nVs
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$19((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        if (ZoneOffset.class.equals(cls)) {
            return new BiFunction() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$UiuvjcaBX4KsItjudXQc3P8IUzI
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ConverterDate.lambda$determineReadTemporalConversionFunction$20((DateTimeFormatter) obj, (String) obj2);
                }
            };
        }
        throw new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString(CSVDATE_NOT_DATE), cls));
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$2(DateTimeFormatter dateTimeFormatter, String str) {
        return (LocalDateTime) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$oFRjpPH-rmRBGQp9DzKnle_YSuM
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                LocalDateTime from;
                from = LocalDateTime.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$3(DateTimeFormatter dateTimeFormatter, String str) {
        return (ZonedDateTime) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$BwCzcqUqByI-sySvqu6-pez3opQ
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                ZonedDateTime from;
                from = ZonedDateTime.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$6(DateTimeFormatter dateTimeFormatter, String str) {
        return (DayOfWeek) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$dItsQvKsK6vtKR1GgX5gEfmoW7g
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                DayOfWeek from;
                from = DayOfWeek.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$8(DateTimeFormatter dateTimeFormatter, String str) {
        return (Instant) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$5bl1mH5sOy2qxCfIvc679Kdp9Ko
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                Instant from;
                from = Instant.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$9(DateTimeFormatter dateTimeFormatter, String str) {
        return (ChronoLocalDate) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$8LOkmqrfUZIVQ9vRfOX9QW6Lx24
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                ChronoLocalDate from;
                from = ChronoLocalDate.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$11(DateTimeFormatter dateTimeFormatter, String str) {
        return (LocalTime) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$kVIaOmyInOTncW9SayoZhKTsmhg
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                LocalTime from;
                from = LocalTime.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$13(DateTimeFormatter dateTimeFormatter, String str) {
        return (Month) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$C16LGBYwkvencU1xVxj4DtyvRKg
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                Month from;
                from = Month.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$14(DateTimeFormatter dateTimeFormatter, String str) {
        return (MonthDay) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$Htv8q-r9yP53ZNgOFp8EabPN8ZE
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                MonthDay from;
                from = MonthDay.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$15(DateTimeFormatter dateTimeFormatter, String str) {
        return (OffsetDateTime) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$VPr89HQOq67u9uM-TeQCxfrmwTA
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                OffsetDateTime from;
                from = OffsetDateTime.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$16(DateTimeFormatter dateTimeFormatter, String str) {
        return (OffsetTime) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$M-OcHB0MZSmB-SYRazGLxcI3VI4
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                OffsetTime from;
                from = OffsetTime.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$18(DateTimeFormatter dateTimeFormatter, String str) {
        return (Year) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$4NBeipImEoAVGID5OxXb3YbN1LU
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                Year from;
                from = Year.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$19(DateTimeFormatter dateTimeFormatter, String str) {
        return (YearMonth) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$7PHXR6ft5elBUCUaon2J9Hrkqkk
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                YearMonth from;
                from = YearMonth.from(temporalAccessor);
                return from;
            }
        });
    }

    static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$20(DateTimeFormatter dateTimeFormatter, String str) {
        return (ZoneOffset) dateTimeFormatter.parse(str, new TemporalQuery() { // from class: com.opencsv.bean.-$$Lambda$ConverterDate$duKZssHzuKXqmQjpCnIybUYVK_s
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                ZoneOffset from;
                from = ZoneOffset.from(temporalAccessor);
                return from;
            }
        });
    }

    private SimpleDateFormat setDateFormat(String str, Locale locale) {
        if (locale != null) {
            return new SimpleDateFormat(str, locale);
        }
        return new SimpleDateFormat(str);
    }

    private DateTimeFormatter setDateTimeFormatter(String str, Locale locale) {
        if (this.writeLocale != null) {
            return DateTimeFormatter.ofPattern(str, locale);
        }
        return DateTimeFormatter.ofPattern(str);
    }

    private Chronology getChronology(String str, Locale locale) {
        try {
            if (StringUtils.isNotBlank(str)) {
                return Chronology.of(str);
            }
            return Chronology.ofLocale(locale);
        } catch (DateTimeException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("chronology.not.found"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        Date parse;
        Date parse2;
        if (!StringUtils.isNotBlank(str)) {
            return null;
        }
        if (Date.class.isAssignableFrom(this.type)) {
            try {
                synchronized (this.readSdf) {
                    parse = this.readSdf.parse(str);
                }
                return this.type.getConstructor(Long.TYPE).newInstance(Long.valueOf(parse.getTime()));
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | ParseException e) {
                CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type);
                csvDataTypeMismatchException.initCause(e);
                throw csvDataTypeMismatchException;
            }
        }
        if (TemporalAccessor.class.isAssignableFrom(this.type)) {
            try {
                return this.type.cast(this.readTemporalConversionFunction.apply(this.readDtf, str));
            } catch (ArithmeticException | DateTimeException e2) {
                CsvDataTypeMismatchException csvDataTypeMismatchException2 = new CsvDataTypeMismatchException(str, this.type);
                csvDataTypeMismatchException2.initCause(e2);
                throw csvDataTypeMismatchException2;
            }
        }
        if (Calendar.class.isAssignableFrom(this.type) || XMLGregorianCalendar.class.isAssignableFrom(this.type)) {
            try {
                synchronized (this.readSdf) {
                    parse2 = this.readSdf.parse(str);
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(parse2);
                if (this.type == XMLGregorianCalendar.class) {
                    try {
                        return this.type.cast(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
                    } catch (DatatypeConfigurationException e3) {
                        CsvDataTypeMismatchException csvDataTypeMismatchException3 = new CsvDataTypeMismatchException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("xmlgregoriancalendar.impossible"));
                        csvDataTypeMismatchException3.initCause(e3);
                        throw csvDataTypeMismatchException3;
                    }
                }
                return this.type.cast(gregorianCalendar);
            } catch (ParseException e4) {
                CsvDataTypeMismatchException csvDataTypeMismatchException4 = new CsvDataTypeMismatchException(str, this.type);
                csvDataTypeMismatchException4.initCause(e4);
                throw csvDataTypeMismatchException4;
            }
        }
        throw new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString(CSVDATE_NOT_DATE), this.type));
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        Calendar calendar;
        String format;
        String format2;
        if (obj == null) {
            return null;
        }
        if (Date.class.isAssignableFrom(this.type)) {
            synchronized (this.writeSdf) {
                format2 = this.writeSdf.format((Date) obj);
            }
            return format2;
        }
        if (TemporalAccessor.class.isAssignableFrom(this.type)) {
            try {
                return this.writeTemporalConversionFunction.apply(this.writeDtf, (TemporalAccessor) obj);
            } catch (ArithmeticException | DateTimeException e) {
                CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(obj, this.type);
                csvDataTypeMismatchException.initCause(e);
                throw csvDataTypeMismatchException;
            }
        }
        if (Calendar.class.isAssignableFrom(this.type) || XMLGregorianCalendar.class.isAssignableFrom(this.type)) {
            if (obj instanceof XMLGregorianCalendar) {
                calendar = ((XMLGregorianCalendar) obj).toGregorianCalendar();
            } else {
                calendar = (Calendar) obj;
            }
            synchronized (this.writeSdf) {
                format = this.writeSdf.format(calendar.getTime());
            }
            return format;
        }
        throw new CsvDataTypeMismatchException(obj, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString(CSVDATE_NOT_DATE), this.type));
    }
}