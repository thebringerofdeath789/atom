package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.LitePal;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class DeleteHandler extends DataHandler {
    private List<String> foreignKeyTableToDelete;

    public DeleteHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    int onDelete(LitePalSupport litePalSupport) {
        if (!litePalSupport.isSaved()) {
            return 0;
        }
        deleteGenericData(litePalSupport.getClass(), getSupportedGenericFields(litePalSupport.getClassName()), litePalSupport.getBaseObjId());
        Collection<AssociationsInfo> analyzeAssociations = analyzeAssociations(litePalSupport);
        int deleteCascade = deleteCascade(litePalSupport) + this.mDatabase.delete(litePalSupport.getTableName(), "id = " + litePalSupport.getBaseObjId(), null);
        clearAssociatedModelSaveState(litePalSupport, analyzeAssociations);
        return deleteCascade;
    }

    public int onDelete(Class<?> cls, long j) {
        deleteGenericData(cls, getSupportedGenericFields(cls.getName()), j);
        analyzeAssociations(cls);
        int deleteCascade = deleteCascade(cls, j) + this.mDatabase.delete(getTableName(cls), "id = " + j, null);
        getForeignKeyTableToDelete().clear();
        return deleteCascade;
    }

    public int onDeleteAll(String str, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        return this.mDatabase.delete(str, getWhereClause(strArr), getWhereArgs(strArr));
    }

    public int onDeleteAll(Class<?> cls, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        List<Field> supportedGenericFields = getSupportedGenericFields(cls.getName());
        if (!supportedGenericFields.isEmpty()) {
            List find = LitePal.select(TtmlNode.ATTR_ID).where(strArr).find(cls);
            if (find.size() > 0) {
                int size = find.size();
                long[] jArr = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = ((LitePalSupport) find.get(i)).getBaseObjId();
                }
                deleteGenericData(cls, supportedGenericFields, jArr);
            }
        }
        analyzeAssociations(cls);
        int deleteAllCascade = deleteAllCascade(cls, strArr) + this.mDatabase.delete(getTableName(cls), getWhereClause(strArr), getWhereArgs(strArr));
        getForeignKeyTableToDelete().clear();
        return deleteAllCascade;
    }

    private void analyzeAssociations(Class<?> cls) {
        for (AssociationsInfo associationsInfo : getAssociationInfo(cls.getName())) {
            String tableNameByClassName = DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName());
            if (associationsInfo.getAssociationType() == 2 || associationsInfo.getAssociationType() == 1) {
                if (!cls.getName().equals(associationsInfo.getClassHoldsForeignKey())) {
                    getForeignKeyTableToDelete().add(tableNameByClassName);
                }
            } else if (associationsInfo.getAssociationType() == 3) {
                getForeignKeyTableToDelete().add(BaseUtility.changeCase(DBUtility.getIntermediateTableName(getTableName(cls), tableNameByClassName)));
            }
        }
    }

    private int deleteCascade(Class<?> cls, long j) {
        Iterator<String> it = getForeignKeyTableToDelete().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += this.mDatabase.delete(it.next(), getForeignKeyColumnName(getTableName(cls)) + " = " + j, null);
        }
        return i;
    }

    private int deleteAllCascade(Class<?> cls, String... strArr) {
        int i = 0;
        for (String str : getForeignKeyTableToDelete()) {
            String tableName = getTableName(cls);
            String foreignKeyColumnName = getForeignKeyColumnName(tableName);
            StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName).append(" in (select id from ");
            sb.append(tableName);
            if (strArr != null && strArr.length > 0) {
                sb.append(" where ").append(buildConditionString(strArr));
            }
            sb.append(")");
            i += this.mDatabase.delete(str, BaseUtility.changeCase(sb.toString()), null);
        }
        return i;
    }

    private String buildConditionString(String... strArr) {
        int length = strArr.length - 1;
        int i = 0;
        String str = strArr[0];
        while (i < length) {
            i++;
            str = str.replaceFirst("\\?", "'" + strArr[i] + "'");
        }
        return str;
    }

    private Collection<AssociationsInfo> analyzeAssociations(LitePalSupport litePalSupport) {
        try {
            Collection<AssociationsInfo> associationInfo = getAssociationInfo(litePalSupport.getClassName());
            analyzeAssociatedModels(litePalSupport, associationInfo);
            return associationInfo;
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    private void clearAssociatedModelSaveState(LitePalSupport litePalSupport, Collection<AssociationsInfo> collection) {
        LitePalSupport associatedModel;
        try {
            for (AssociationsInfo associationsInfo : collection) {
                if (associationsInfo.getAssociationType() == 2 && !litePalSupport.getClassName().equals(associationsInfo.getClassHoldsForeignKey())) {
                    Collection<LitePalSupport> associatedModels = getAssociatedModels(litePalSupport, associationsInfo);
                    if (associatedModels != null && !associatedModels.isEmpty()) {
                        for (LitePalSupport litePalSupport2 : associatedModels) {
                            if (litePalSupport2 != null) {
                                litePalSupport2.clearSavedState();
                            }
                        }
                    }
                } else if (associationsInfo.getAssociationType() == 1 && (associatedModel = getAssociatedModel(litePalSupport, associationsInfo)) != null) {
                    associatedModel.clearSavedState();
                }
            }
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    private int deleteCascade(LitePalSupport litePalSupport) {
        return deleteAssociatedForeignKeyRows(litePalSupport) + deleteAssociatedJoinTableRows(litePalSupport);
    }

    private int deleteAssociatedForeignKeyRows(LitePalSupport litePalSupport) {
        Iterator<String> it = litePalSupport.getAssociatedModelsMapWithFK().keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += this.mDatabase.delete(it.next(), getForeignKeyColumnName(litePalSupport.getTableName()) + " = " + litePalSupport.getBaseObjId(), null);
        }
        return i;
    }

    private int deleteAssociatedJoinTableRows(LitePalSupport litePalSupport) {
        Iterator<String> it = litePalSupport.getAssociatedModelsMapForJoinTable().keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += this.mDatabase.delete(DBUtility.getIntermediateTableName(litePalSupport.getTableName(), it.next()), getForeignKeyColumnName(litePalSupport.getTableName()) + " = " + litePalSupport.getBaseObjId(), null);
        }
        return i;
    }

    private List<String> getForeignKeyTableToDelete() {
        if (this.foreignKeyTableToDelete == null) {
            this.foreignKeyTableToDelete = new ArrayList();
        }
        return this.foreignKeyTableToDelete;
    }

    private void deleteGenericData(Class<?> cls, List<Field> list, long... jArr) {
        int i;
        Iterator<Field> it = list.iterator();
        while (it.hasNext()) {
            String genericTableName = DBUtility.getGenericTableName(cls.getName(), it.next().getName());
            String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(cls.getName());
            int length = jArr.length;
            int i2 = (length - 1) / 500;
            int i3 = 0;
            while (i3 <= i2) {
                StringBuilder sb = new StringBuilder();
                int i4 = 500 * i3;
                boolean z = false;
                while (true) {
                    i = i3 + 1;
                    if (i4 >= 500 * i || i4 >= length) {
                        break;
                    }
                    long j = jArr[i4];
                    if (z) {
                        sb.append(" or ");
                    }
                    sb.append(genericValueIdColumnName).append(" = ").append(j);
                    i4++;
                    z = true;
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    this.mDatabase.delete(genericTableName, sb.toString(), null);
                }
                i3 = i;
            }
        }
    }
}
