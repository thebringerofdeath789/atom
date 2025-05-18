package com.lib;

import com.lib.bean.LanguageWriter;
import com.lib.bean.TranslateItem;
import com.lib.bean.XlsxExcelReader;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public class TranslateHandler {
    public int handle(String str, String str2, int i) throws Exception {
        int i2 = -1;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!new File(str).exists() && !new File(str2).exists()) {
            return -2;
        }
        List<TranslateItem> items = new XlsxExcelReader(str, i).getItems();
        for (LanguageWriter languageWriter : Config.LANGUAGE_WRITERS) {
            languageWriter.init(str2);
        }
        for (int i3 = 0; i3 < items.size(); i3++) {
            TranslateItem translateItem = items.get(i3);
            for (LanguageWriter languageWriter2 : Config.LANGUAGE_WRITERS) {
                String str3 = translateItem.content.get(languageWriter2.getType());
                if (str3 != null && !str3.isEmpty()) {
                    languageWriter2.write(translateItem.key, str3);
                }
            }
            int size = (i3 * 10) / items.size();
            if (size != i2) {
                System.out.println("进度 ：" + (size * 10) + "%");
                i2 = size;
            }
        }
        return 0;
    }
}