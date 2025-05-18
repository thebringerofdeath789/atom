package com.logan.uom.utils;

import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.kernel.activitys.CAACUomRegistrationActivity;
import com.logan.flight.type.Flight;
import com.logan.uom.UomConfig;
import com.logan.uom.UomHandler;
import com.logan.uom.bean.UomUploadBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.impl.common.NameUtil;

/* compiled from: UomConvert.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u001f\u0010\b\u001a\u00020\u00042\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, m2338d2 = {"Lcom/logan/uom/utils/UomConvert;", "", "()V", "convertQRCodeInfo", "", "flight", "Lcom/logan/flight/type/Flight;", CAACUomRegistrationActivity.FLIGHT_SN_INTENT_KEY, "convertUomBodyToJson", TtmlNode.TAG_BODY, "", "Lcom/logan/uom/bean/UomUploadBody;", "([Lcom/logan/uom/bean/UomUploadBody;)Ljava/lang/String;", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class UomConvert {
    public static final UomConvert INSTANCE = new UomConvert();

    private UomConvert() {
    }

    public final String convertUomBodyToJson(UomUploadBody... body) {
        Intrinsics.checkParameterIsNotNull(body, "body");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (UomUploadBody uomUploadBody : body) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = linkedHashMap2;
            linkedHashMap3.put("orderID", uomUploadBody.getSn() + NameUtil.HYPHEN + FormatUtil.formatCurTime2(uomUploadBody.getTimeMillis()) + NameUtil.HYPHEN + StringsKt.padStart(String.valueOf(uomUploadBody.getFlightSorties()), 8, '0'));
            linkedHashMap3.put("sn", uomUploadBody.getSn());
            linkedHashMap3.put("flightStatus", uomUploadBody.getFlightStatusEnum().getValue());
            linkedHashMap3.put("manufacturerID", UomConfig.MAUNFACTURER_ID);
            linkedHashMap3.put("uasID", UomConfig.UAS_ID);
            String formatCurTime1 = FormatUtil.formatCurTime1(uomUploadBody.getTimeMillis());
            Intrinsics.checkExpressionValueIsNotNull(formatCurTime1, "FormatUtil.formatCurTime1(b.timeMillis)");
            linkedHashMap3.put("timeStamp", formatCurTime1);
            linkedHashMap3.put("uasModel", UomHandler.INSTANCE.getInstance().getUasModel(uomUploadBody.getFlightEnum()));
            linkedHashMap3.put("coordinate", 1);
            linkedHashMap3.put("longitude", Long.valueOf(uomUploadBody.getLongitude()));
            linkedHashMap3.put("latitude", Long.valueOf(uomUploadBody.getLatitude()));
            linkedHashMap3.put("heightType", 1);
            linkedHashMap3.put("height", Integer.valueOf(uomUploadBody.getHeight()));
            linkedHashMap3.put("altitude", Integer.valueOf(uomUploadBody.getAltitude()));
            linkedHashMap3.put("VS", Integer.valueOf(uomUploadBody.getVs()));
            linkedHashMap3.put("GS", Integer.valueOf(uomUploadBody.getGs()));
            linkedHashMap3.put("course", Integer.valueOf(uomUploadBody.getCourse()));
            arrayList.add(linkedHashMap2);
        }
        LinkedHashMap linkedHashMap4 = linkedHashMap;
        linkedHashMap4.put("appID", UomConfig.APP_ID);
        linkedHashMap4.put("paths", arrayList);
        String jSONString = JSON.toJSONString(linkedHashMap);
        Intrinsics.checkExpressionValueIsNotNull(jSONString, "JSON.toJSONString(allMap)");
        return jSONString;
    }

    public final String convertQRCodeInfo(Flight flight, String flightSN) {
        Intrinsics.checkParameterIsNotNull(flight, "flight");
        Intrinsics.checkParameterIsNotNull(flightSN, "flightSN");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = hashMap;
        hashMap2.put("type", "uom_product_info");
        hashMap2.put("usccode", UomConfig.MAUNFACTURER_ID);
        hashMap2.put("product_type", UomHandler.INSTANCE.getInstance().getUasModel(flight));
        hashMap2.put("product_id", flightSN);
        hashMap2.put("product_sn", flightSN);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("uom_properties", hashMap);
        String jSONString = JSON.toJSONString(hashMap3);
        Intrinsics.checkExpressionValueIsNotNull(jSONString, "JSON.toJSONString(map2)");
        return jSONString;
    }
}