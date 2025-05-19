package me.yokeyword.indexablerv.countrys;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ipotensic.baselib.utils.LanguageHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import me.yokeyword.indexablerv.IndexableEntity;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class CityEntity implements IndexableEntity {
    private static final String TAG = "CityEntity";
    private static ArrayList<CityEntity> countries;
    private int code;
    private long id;
    private String name;
    private String pinyin;

    public CityEntity() {
    }

    public CityEntity(int i, String str) {
        this.name = str;
        this.code = i;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    @Override // me.yokeyword.indexablerv.IndexableEntity
    public String getFieldIndexBy() {
        return this.name;
    }

    @Override // me.yokeyword.indexablerv.IndexableEntity
    public void setFieldIndexBy(String str) {
        this.name = str;
    }

    @Override // me.yokeyword.indexablerv.IndexableEntity
    public void setFieldPinyinIndexBy(String str) {
        this.pinyin = str;
    }

    public static ArrayList<CityEntity> getAll(Context context) {
        ArrayList<CityEntity> arrayList = countries;
        if (arrayList != null) {
            arrayList.clear();
            countries = null;
        }
        countries = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open("code.json")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            JSONArray jSONArray = new JSONArray(sb.toString());
            String key = getKey(context);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("locale");
                if (!TextUtils.isEmpty(optString)) {
                    context.getResources().getIdentifier("flag_" + optString.toLowerCase(), "drawable", context.getPackageName());
                }
                countries.add(new CityEntity(jSONObject.optInt("code"), jSONObject.optString(key)));
            }
            Log.i(TAG, countries.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    private static String getKey(Context context) {
        LanguageHelper.LANGUAGE_TYPE language = LanguageHelper.getLanguage(context);
        return (language.equals(LanguageHelper.LANGUAGE_TYPE.CHINESE) || language.equals(LanguageHelper.LANGUAGE_TYPE.CHINESETAIWAN)) ? "zh" : language.equals(LanguageHelper.LANGUAGE_TYPE.ENGLISH) ? "en" : language.equals(LanguageHelper.LANGUAGE_TYPE.GERMANY) ? "de" : language.equals(LanguageHelper.LANGUAGE_TYPE.FRENCH) ? "fr" : language.equals(LanguageHelper.LANGUAGE_TYPE.JAPAN) ? "ja" : language.equals(LanguageHelper.LANGUAGE_TYPE.ITALY) ? "it" : language.equals(LanguageHelper.LANGUAGE_TYPE.SPANISH) ? "sp" : "en";
    }
}
