package com.opencsv.bean.customconverter;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.apache.poi.p043ss.formula.functions.Complex;

/* loaded from: classes3.dex */
public class ConvertGermanToBoolean<T, I> extends ConverterLanguageToBoolean<T, I> {
    private static final String WAHR = "wahr";
    private static final String[] TRUE_STRINGS = {WAHR, "ja", Complex.SUPPORTED_SUFFIX, "1", "w"};
    private static final String FALSCH = "falsch";
    private static final String[] FALSE_STRINGS = {FALSCH, "nein", "n", SessionDescription.SUPPORTED_SDP_VERSION, "f"};

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    protected String getLocalizedFalse() {
        return FALSCH;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    protected String getLocalizedTrue() {
        return WAHR;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    protected String[] getAllLocalizedTrueValues() {
        return TRUE_STRINGS;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    protected String[] getAllLocalizedFalseValues() {
        return FALSE_STRINGS;
    }
}