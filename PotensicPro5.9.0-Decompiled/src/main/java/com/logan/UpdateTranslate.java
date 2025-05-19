package com.logan;

import com.lib.TranslateHandler;
import java.io.File;

/* loaded from: classes2.dex */
public class UpdateTranslate {
    public static final String SOURCE_PATH = "C:\\Users\\Administrator\\Downloads\\PotensicPro App多语言汇总表(4).xlsx";
    public static final File OLD_DEST_DIR = new File("Resource/src/main/res_old");
    public static final File NEW_DEST_DIR = new File("Resource/src/main/res_new");

    public static void updateByEasyExcel() throws Exception {
    }

    public static void execute() throws Exception {
        System.out.println("开始处理...");
        if (!new File(SOURCE_PATH).exists()) {
            System.out.println("源文件不存在!!");
            return;
        }
        TranslateHandler translateHandler = new TranslateHandler();
        System.out.println("开始处理旧翻译...");
        translateHandler.handle(SOURCE_PATH, OLD_DEST_DIR.getAbsolutePath(), 0);
        System.out.println("旧翻译处理完成 100%");
        System.out.println("开始处理新翻译...");
        translateHandler.handle(SOURCE_PATH, NEW_DEST_DIR.getAbsolutePath(), 3);
        System.out.println("新翻译处理完成 100%");
    }
}
