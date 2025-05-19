package com.opencsv.bean.customconverter;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* loaded from: classes3.dex */
public class ConvertFrenchToBoolean<T, I> extends ConverterLanguageToBoolean<T, I> {
    private static final String VRAI = "vrai";
    private static final String[] TRUE_STRINGS = {VRAI, "oui", "o", "1", "v"};
    private static final String FAUX = "faux";
    private static final String[] FALSE_STRINGS = {FAUX, "non", "n", SessionDescription.SUPPORTED_SDP_VERSION, "f"};

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    protected String getLocalizedFalse() {
        return FAUX;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    protected String getLocalizedTrue() {
        return VRAI;
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
