package org.litepal.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.LitePal;
import org.litepal.annotation.Encrypt;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class UpdateHandler extends DataHandler {
    public UpdateHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    int onUpdate(LitePalSupport litePalSupport, long j) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Field> supportedFields = getSupportedFields(litePalSupport.getClassName());
        updateGenericTables(litePalSupport, getSupportedGenericFields(litePalSupport.getClassName()), j);
        ContentValues contentValues = new ContentValues();
        putFieldsValue(litePalSupport, supportedFields, contentValues);
        putFieldsToDefaultValue(litePalSupport, contentValues, j);
        if (contentValues.size() > 0) {
            return this.mDatabase.update(litePalSupport.getTableName(), contentValues, "id = " + j, null);
        }
        return 0;
    }

    public int onUpdate(Class<?> cls, long j, ContentValues contentValues) {
        if (contentValues.size() <= 0) {
            return 0;
        }
        convertContentValues(contentValues);
        return this.mDatabase.update(getTableName(cls), contentValues, "id = " + j, null);
    }

    int onUpdateAll(LitePalSupport litePalSupport, String... strArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        List<Field> supportedFields = getSupportedFields(litePalSupport.getClassName());
        List<Field> supportedGenericFields = getSupportedGenericFields(litePalSupport.getClassName());
        long[] jArr = null;
        if (!supportedGenericFields.isEmpty()) {
            List find = LitePal.select(TtmlNode.ATTR_ID).where(strArr).find(litePalSupport.getClass());
            if (find.size() > 0) {
                int size = find.size();
                long[] jArr2 = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr2[i] = ((LitePalSupport) find.get(i)).getBaseObjId();
                }
                updateGenericTables(litePalSupport, supportedGenericFields, jArr2);
                jArr = jArr2;
            }
        }
        ContentValues contentValues = new ContentValues();
        putFieldsValue(litePalSupport, supportedFields, contentValues);
        putFieldsToDefaultValue(litePalSupport, contentValues, jArr);
        return doUpdateAllAction(litePalSupport.getTableName(), contentValues, strArr);
    }

    public int onUpdateAll(String str, ContentValues contentValues, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        convertContentValues(contentValues);
        return doUpdateAllAction(str, contentValues, strArr);
    }

    private int doUpdateAllAction(String str, ContentValues contentValues, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (contentValues.size() > 0) {
            return this.mDatabase.update(str, contentValues, getWhereClause(strArr), getWhereArgs(strArr));
        }
        return 0;
    }

    private void putFieldsToDefaultValue(LitePalSupport litePalSupport, ContentValues contentValues, long... jArr) {
        String str = null;
        try {
            try {
                LitePalSupport emptyModel = getEmptyModel(litePalSupport);
                Class<?> cls = emptyModel.getClass();
                String str2 = null;
                for (String str3 : litePalSupport.getFieldsToSetToDefault()) {
                    try {
                        if (!isIdColumn(str3)) {
                            try {
                                Field declaredField = cls.getDeclaredField(str3);
                                if (isCollection(declaredField.getType())) {
                                    if (jArr != null && jArr.length > 0 && BaseUtility.isGenericTypeSupported(getGenericTypeName(declaredField))) {
                                        String genericTableName = DBUtility.getGenericTableName(litePalSupport.getClassName(), declaredField.getName());
                                        String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(litePalSupport.getClassName());
                                        StringBuilder sb = new StringBuilder();
                                        int length = jArr.length;
                                        int i = 0;
                                        boolean z = false;
                                        while (i < length) {
                                            long j = jArr[i];
                                            if (z) {
                                                sb.append(" or ");
                                            }
                                            sb.append(genericValueIdColumnName).append(" = ").append(j);
                                            i++;
                                            z = true;
                                        }
                                        this.mDatabase.delete(genericTableName, sb.toString(), null);
                                    }
                                } else {
                                    putContentValuesForUpdate(emptyModel, declaredField, contentValues);
                                }
                                str2 = str3;
                            } catch (NoSuchFieldException e) {
                                e = e;
                                str = str3;
                                throw new LitePalSupportException(LitePalSupportException.noSuchFieldExceptioin(litePalSupport.getClassName(), str), e);
                            }
                        }
                    } catch (NoSuchFieldException e2) {
                        e = e2;
                        str = str2;
                    }
                }
            } catch (NoSuchFieldException e3) {
                e = e3;
            }
        } catch (Exception e4) {
            throw new LitePalSupportException(e4.getMessage(), e4);
        }
    }

    private int doUpdateAssociations(LitePalSupport litePalSupport, long j, ContentValues contentValues) {
        analyzeAssociations(litePalSupport);
        updateSelfTableForeignKey(litePalSupport, contentValues);
        return updateAssociatedTableForeignKey(litePalSupport, j) + 0;
    }

    private void analyzeAssociations(LitePalSupport litePalSupport) {
        try {
            analyzeAssociatedModels(litePalSupport, getAssociationInfo(litePalSupport.getClassName()));
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    private void updateSelfTableForeignKey(LitePalSupport litePalSupport, ContentValues contentValues) {
        Map<String, Long> associatedModelsMapWithoutFK = litePalSupport.getAssociatedModelsMapWithoutFK();
        for (String str : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(getForeignKeyColumnName(str), associatedModelsMapWithoutFK.get(str));
        }
    }

    private int updateAssociatedTableForeignKey(LitePalSupport litePalSupport, long j) {
        Map<String, Set<Long>> associatedModelsMapWithFK = litePalSupport.getAssociatedModelsMapWithFK();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(getForeignKeyColumnName(litePalSupport.getTableName()), Long.valueOf(j));
            Set<Long> set = associatedModelsMapWithFK.get(str);
            if (set != null && !set.isEmpty()) {
                return this.mDatabase.update(str, contentValues, getWhereOfIdsWithOr(set), null);
            }
        }
        return 0;
    }

    private void updateGenericTables(LitePalSupport litePalSupport, List<Field> list, long... jArr) throws IllegalAccessException, InvocationTargetException {
        Iterator it;
        Iterator<Field> it2;
        long[] jArr2 = jArr;
        if (jArr2 == null || jArr2.length <= 0) {
            return;
        }
        Iterator<Field> it3 = list.iterator();
        while (it3.hasNext()) {
            Field next = it3.next();
            Encrypt encrypt = (Encrypt) next.getAnnotation(Encrypt.class);
            String genericTypeName = getGenericTypeName(next);
            String algorithm = (encrypt == null || !"java.lang.String".equals(genericTypeName)) ? null : encrypt.algorithm();
            next.setAccessible(true);
            Collection collection = (Collection) next.get(litePalSupport);
            if (collection != null && !collection.isEmpty()) {
                String genericTableName = DBUtility.getGenericTableName(litePalSupport.getClassName(), next.getName());
                String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(litePalSupport.getClassName());
                int length = jArr2.length;
                int i = 0;
                while (i < length) {
                    long j = jArr2[i];
                    this.mDatabase.delete(genericTableName, genericValueIdColumnName + " = ?", new String[]{String.valueOf(j)});
                    Iterator it4 = collection.iterator();
                    while (it4.hasNext()) {
                        Object next2 = it4.next();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(genericValueIdColumnName, Long.valueOf(j));
                        Object encryptValue = encryptValue(algorithm, next2);
                        if (litePalSupport.getClassName().equals(genericTypeName)) {
                            LitePalSupport litePalSupport2 = (LitePalSupport) encryptValue;
                            if (litePalSupport2 != null) {
                                long baseObjId = litePalSupport2.getBaseObjId();
                                if (baseObjId > 0) {
                                    contentValues.put(DBUtility.getM2MSelfRefColumnName(next), Long.valueOf(baseObjId));
                                    it = it4;
                                    it2 = it3;
                                }
                            }
                        } else {
                            it = it4;
                            it2 = it3;
                            DynamicExecutor.send(contentValues, "put", new Object[]{DBUtility.convertToValidColumnName(BaseUtility.changeCase(next.getName())), encryptValue}, contentValues.getClass(), new Class[]{String.class, getGenericTypeClass(next)});
                        }
                        this.mDatabase.insert(genericTableName, null, contentValues);
                        it4 = it;
                        it3 = it2;
                    }
                    i++;
                    jArr2 = jArr;
                    it3 = it3;
                }
            }
            jArr2 = jArr;
            it3 = it3;
        }
    }

    private void convertContentValues(ContentValues contentValues) {
        if (Build.VERSION.SDK_INT >= 11) {
            HashMap hashMap = new HashMap();
            for (String str : contentValues.keySet()) {
                if (DBUtility.isFieldNameConflictWithSQLiteKeywords(str)) {
                    hashMap.put(str, contentValues.get(str));
                }
            }
            for (String str2 : hashMap.keySet()) {
                String convertToValidColumnName = DBUtility.convertToValidColumnName(str2);
                Object obj = contentValues.get(str2);
                contentValues.remove(str2);
                if (obj == null) {
                    contentValues.putNull(convertToValidColumnName);
                } else {
                    String name = obj.getClass().getName();
                    if ("java.lang.Byte".equals(name)) {
                        contentValues.put(convertToValidColumnName, (Byte) obj);
                    } else if ("[B".equals(name)) {
                        contentValues.put(convertToValidColumnName, (byte[]) obj);
                    } else if ("java.lang.Boolean".equals(name)) {
                        contentValues.put(convertToValidColumnName, (Boolean) obj);
                    } else if ("java.lang.String".equals(name)) {
                        contentValues.put(convertToValidColumnName, (String) obj);
                    } else if ("java.lang.Float".equals(name)) {
                        contentValues.put(convertToValidColumnName, (Float) obj);
                    } else if ("java.lang.Long".equals(name)) {
                        contentValues.put(convertToValidColumnName, (Long) obj);
                    } else if ("java.lang.Integer".equals(name)) {
                        contentValues.put(convertToValidColumnName, (Integer) obj);
                    } else if ("java.lang.Short".equals(name)) {
                        contentValues.put(convertToValidColumnName, (Short) obj);
                    } else if ("java.lang.Double".equals(name)) {
                        contentValues.put(convertToValidColumnName, (Double) obj);
                    }
                }
            }
        }
    }
}
