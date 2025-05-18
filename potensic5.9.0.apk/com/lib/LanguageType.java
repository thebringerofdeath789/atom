package com.lib;

/* loaded from: classes2.dex */
public enum LanguageType {
    CN("CN", "/values-zh-rCN"),
    EN("EN", "/values"),
    DE("DE", "/values-de-rDE"),
    IT("IT", "/values-it-rIT"),
    FR("FR", "/values-fr-rFR"),
    ES("ES", "/values-es-rES"),
    JP("JP", "/values-ja-rJP"),
    TW("CHT", "/values-zh-rTW"),
    PT("PT", "/values-pt"),
    KR("KR", "/values-ko");

    public String excelHead;
    public String xmlName;

    LanguageType(String str, String str2) {
        this.excelHead = null;
        this.xmlName = null;
        this.excelHead = str;
        this.xmlName = str2;
    }
}