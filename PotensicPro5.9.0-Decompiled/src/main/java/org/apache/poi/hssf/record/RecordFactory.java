package org.apache.poi.hssf.record;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.chart.BeginRecord;
import org.apache.poi.hssf.record.chart.CatLabRecord;
import org.apache.poi.hssf.record.chart.ChartEndBlockRecord;
import org.apache.poi.hssf.record.chart.ChartEndObjectRecord;
import org.apache.poi.hssf.record.chart.ChartFRTInfoRecord;
import org.apache.poi.hssf.record.chart.ChartRecord;
import org.apache.poi.hssf.record.chart.ChartStartBlockRecord;
import org.apache.poi.hssf.record.chart.ChartStartObjectRecord;
import org.apache.poi.hssf.record.chart.ChartTitleFormatRecord;
import org.apache.poi.hssf.record.chart.DataFormatRecord;
import org.apache.poi.hssf.record.chart.EndRecord;
import org.apache.poi.hssf.record.chart.LegendRecord;
import org.apache.poi.hssf.record.chart.LinkedDataRecord;
import org.apache.poi.hssf.record.chart.SeriesRecord;
import org.apache.poi.hssf.record.chart.SeriesTextRecord;
import org.apache.poi.hssf.record.chart.SeriesToChartGroupRecord;
import org.apache.poi.hssf.record.chart.ValueRangeRecord;
import org.apache.poi.hssf.record.pivottable.DataItemRecord;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.apache.poi.hssf.record.pivottable.PageItemRecord;
import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
import org.apache.poi.hssf.record.pivottable.ViewDefinitionRecord;
import org.apache.poi.hssf.record.pivottable.ViewFieldsRecord;
import org.apache.poi.hssf.record.pivottable.ViewSourceRecord;

/* loaded from: classes5.dex */
public final class RecordFactory {
    private static final Class<?>[] CONSTRUCTOR_ARGS = {RecordInputStream.class};
    private static final int NUM_RECORDS = 512;
    private static short[] _allKnownRecordSIDs;
    private static final Map<Integer, I_RecordCreator> _recordCreatorsById;
    private static final Class<? extends Record>[] recordClasses;

    private interface I_RecordCreator {
        Record create(RecordInputStream recordInputStream);

        Class<? extends Record> getRecordClass();
    }

    private static final class ReflectionConstructorRecordCreator implements I_RecordCreator {
        private final Constructor<? extends Record> _c;

        public ReflectionConstructorRecordCreator(Constructor<? extends Record> constructor) {
            this._c = constructor;
        }

        @Override // org.apache.poi.hssf.record.RecordFactory.I_RecordCreator
        public Record create(RecordInputStream recordInputStream) {
            try {
                return this._c.newInstance(recordInputStream);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                Throwable targetException = e4.getTargetException();
                if (targetException instanceof RecordFormatException) {
                    throw ((RecordFormatException) targetException);
                }
                if (targetException instanceof EncryptedDocumentException) {
                    throw ((EncryptedDocumentException) targetException);
                }
                throw new RecordFormatException("Unable to construct record instance", targetException);
            }
        }

        @Override // org.apache.poi.hssf.record.RecordFactory.I_RecordCreator
        public Class<? extends Record> getRecordClass() {
            return this._c.getDeclaringClass();
        }
    }

    private static final class ReflectionMethodRecordCreator implements I_RecordCreator {
        private final Method _m;

        public ReflectionMethodRecordCreator(Method method) {
            this._m = method;
        }

        @Override // org.apache.poi.hssf.record.RecordFactory.I_RecordCreator
        public Record create(RecordInputStream recordInputStream) {
            try {
                return (Record) this._m.invoke(null, recordInputStream);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RecordFormatException("Unable to construct record instance", e3.getTargetException());
            }
        }

        @Override // org.apache.poi.hssf.record.RecordFactory.I_RecordCreator
        public Class<? extends Record> getRecordClass() {
            return this._m.getDeclaringClass();
        }
    }

    static {
        Class<? extends Record>[] clsArr = {ArrayRecord.class, AutoFilterInfoRecord.class, BackupRecord.class, BlankRecord.class, BOFRecord.class, BookBoolRecord.class, BoolErrRecord.class, BottomMarginRecord.class, BoundSheetRecord.class, CalcCountRecord.class, CalcModeRecord.class, CFHeaderRecord.class, CFRuleRecord.class, ChartRecord.class, ChartTitleFormatRecord.class, CodepageRecord.class, ColumnInfoRecord.class, ContinueRecord.class, CountryRecord.class, CRNCountRecord.class, CRNRecord.class, DateWindow1904Record.class, DBCellRecord.class, DConRefRecord.class, DefaultColWidthRecord.class, DefaultRowHeightRecord.class, DeltaRecord.class, DimensionsRecord.class, DrawingGroupRecord.class, DrawingRecord.class, DrawingSelectionRecord.class, DSFRecord.class, DVALRecord.class, DVRecord.class, EOFRecord.class, ExtendedFormatRecord.class, ExternalNameRecord.class, ExternSheetRecord.class, ExtSSTRecord.class, FeatRecord.class, FeatHdrRecord.class, FilePassRecord.class, FileSharingRecord.class, FnGroupCountRecord.class, FontRecord.class, FooterRecord.class, FormatRecord.class, FormulaRecord.class, GridsetRecord.class, GutsRecord.class, HCenterRecord.class, HeaderRecord.class, HeaderFooterRecord.class, HideObjRecord.class, HorizontalPageBreakRecord.class, HyperlinkRecord.class, IndexRecord.class, InterfaceEndRecord.class, InterfaceHdrRecord.class, IterationRecord.class, LabelRecord.class, LabelSSTRecord.class, LeftMarginRecord.class, LegendRecord.class, MergeCellsRecord.class, MMSRecord.class, MulBlankRecord.class, MulRKRecord.class, NameRecord.class, NameCommentRecord.class, NoteRecord.class, NumberRecord.class, ObjectProtectRecord.class, ObjRecord.class, PaletteRecord.class, PaneRecord.class, PasswordRecord.class, PasswordRev4Record.class, PrecisionRecord.class, PrintGridlinesRecord.class, PrintHeadersRecord.class, PrintSetupRecord.class, ProtectionRev4Record.class, ProtectRecord.class, RecalcIdRecord.class, RefModeRecord.class, RefreshAllRecord.class, RightMarginRecord.class, RKRecord.class, RowRecord.class, SaveRecalcRecord.class, ScenarioProtectRecord.class, SelectionRecord.class, SeriesRecord.class, SeriesTextRecord.class, SharedFormulaRecord.class, SSTRecord.class, StringRecord.class, StyleRecord.class, SupBookRecord.class, TabIdRecord.class, TableRecord.class, TableStylesRecord.class, TextObjectRecord.class, TopMarginRecord.class, UncalcedRecord.class, UseSelFSRecord.class, UserSViewBegin.class, UserSViewEnd.class, ValueRangeRecord.class, VCenterRecord.class, VerticalPageBreakRecord.class, WindowOneRecord.class, WindowProtectRecord.class, WindowTwoRecord.class, WriteAccessRecord.class, WriteProtectRecord.class, WSBoolRecord.class, BeginRecord.class, ChartFRTInfoRecord.class, ChartStartBlockRecord.class, ChartEndBlockRecord.class, ChartStartObjectRecord.class, ChartEndObjectRecord.class, CatLabRecord.class, DataFormatRecord.class, EndRecord.class, LinkedDataRecord.class, SeriesToChartGroupRecord.class, DataItemRecord.class, ExtendedPivotTableViewFieldsRecord.class, PageItemRecord.class, StreamIDRecord.class, ViewDefinitionRecord.class, ViewFieldsRecord.class, ViewSourceRecord.class};
        recordClasses = clsArr;
        _recordCreatorsById = recordsToMap(clsArr);
    }

    public static Class<? extends Record> getRecordClass(int i) {
        I_RecordCreator i_RecordCreator = _recordCreatorsById.get(Integer.valueOf(i));
        if (i_RecordCreator == null) {
            return null;
        }
        return i_RecordCreator.getRecordClass();
    }

    public static Record[] createRecord(RecordInputStream recordInputStream) {
        Record createSingleRecord = createSingleRecord(recordInputStream);
        return createSingleRecord instanceof DBCellRecord ? new Record[]{null} : createSingleRecord instanceof RKRecord ? new Record[]{convertToNumberRecord((RKRecord) createSingleRecord)} : createSingleRecord instanceof MulRKRecord ? convertRKRecords((MulRKRecord) createSingleRecord) : new Record[]{createSingleRecord};
    }

    public static Record createSingleRecord(RecordInputStream recordInputStream) {
        I_RecordCreator i_RecordCreator = _recordCreatorsById.get(Integer.valueOf(recordInputStream.getSid()));
        if (i_RecordCreator == null) {
            return new UnknownRecord(recordInputStream);
        }
        return i_RecordCreator.create(recordInputStream);
    }

    public static NumberRecord convertToNumberRecord(RKRecord rKRecord) {
        NumberRecord numberRecord = new NumberRecord();
        numberRecord.setColumn(rKRecord.getColumn());
        numberRecord.setRow(rKRecord.getRow());
        numberRecord.setXFIndex(rKRecord.getXFIndex());
        numberRecord.setValue(rKRecord.getRKNumber());
        return numberRecord;
    }

    public static NumberRecord[] convertRKRecords(MulRKRecord mulRKRecord) {
        NumberRecord[] numberRecordArr = new NumberRecord[mulRKRecord.getNumColumns()];
        for (int i = 0; i < mulRKRecord.getNumColumns(); i++) {
            NumberRecord numberRecord = new NumberRecord();
            numberRecord.setColumn((short) (mulRKRecord.getFirstColumn() + i));
            numberRecord.setRow(mulRKRecord.getRow());
            numberRecord.setXFIndex(mulRKRecord.getXFAt(i));
            numberRecord.setValue(mulRKRecord.getRKNumberAt(i));
            numberRecordArr[i] = numberRecord;
        }
        return numberRecordArr;
    }

    public static BlankRecord[] convertBlankRecords(MulBlankRecord mulBlankRecord) {
        BlankRecord[] blankRecordArr = new BlankRecord[mulBlankRecord.getNumColumns()];
        for (int i = 0; i < mulBlankRecord.getNumColumns(); i++) {
            BlankRecord blankRecord = new BlankRecord();
            blankRecord.setColumn((short) (mulBlankRecord.getFirstColumn() + i));
            blankRecord.setRow(mulBlankRecord.getRow());
            blankRecord.setXFIndex(mulBlankRecord.getXFAt(i));
            blankRecordArr[i] = blankRecord;
        }
        return blankRecordArr;
    }

    public static short[] getAllKnownRecordSIDs() {
        if (_allKnownRecordSIDs == null) {
            Map<Integer, I_RecordCreator> map = _recordCreatorsById;
            short[] sArr = new short[map.size()];
            int i = 0;
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                sArr[i] = it.next().shortValue();
                i++;
            }
            Arrays.sort(sArr);
            _allKnownRecordSIDs = sArr;
        }
        return (short[]) _allKnownRecordSIDs.clone();
    }

    private static Map<Integer, I_RecordCreator> recordsToMap(Class<? extends Record>[] clsArr) {
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet((clsArr.length * 3) / 2);
        for (Class<? extends Record> cls : clsArr) {
            if (!Record.class.isAssignableFrom(cls)) {
                throw new RuntimeException("Invalid record sub-class (" + cls.getName() + ")");
            }
            if (Modifier.isAbstract(cls.getModifiers())) {
                throw new RuntimeException("Invalid record class (" + cls.getName() + ") - must not be abstract");
            }
            if (!hashSet.add(cls)) {
                throw new RuntimeException("duplicate record class (" + cls.getName() + ")");
            }
            try {
                short s = cls.getField("sid").getShort(null);
                Integer valueOf = Integer.valueOf(s);
                if (hashMap.containsKey(valueOf)) {
                    throw new RuntimeException("duplicate record sid 0x" + Integer.toHexString(s).toUpperCase() + " for classes (" + cls.getName() + ") and (" + ((I_RecordCreator) hashMap.get(valueOf)).getRecordClass().getName() + ")");
                }
                hashMap.put(valueOf, getRecordCreator(cls));
            } catch (Exception unused) {
                throw new RecordFormatException("Unable to determine record types");
            }
        }
        return hashMap;
    }

    private static I_RecordCreator getRecordCreator(Class<? extends Record> cls) {
        try {
            try {
                return new ReflectionConstructorRecordCreator(cls.getConstructor(CONSTRUCTOR_ARGS));
            } catch (NoSuchMethodException unused) {
                return new ReflectionMethodRecordCreator(cls.getDeclaredMethod("create", CONSTRUCTOR_ARGS));
            }
        } catch (NoSuchMethodException unused2) {
            throw new RuntimeException("Failed to find constructor or create method for (" + cls.getName() + ").");
        }
    }

    public static List<Record> createRecords(InputStream inputStream) throws RecordFormatException {
        ArrayList arrayList = new ArrayList(512);
        RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(inputStream, true);
        while (true) {
            Record nextRecord = recordFactoryInputStream.nextRecord();
            if (nextRecord == null) {
                return arrayList;
            }
            arrayList.add(nextRecord);
        }
    }
}
