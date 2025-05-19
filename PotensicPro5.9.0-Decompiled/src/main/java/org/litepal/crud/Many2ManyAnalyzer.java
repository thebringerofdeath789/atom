package org.litepal.crud;

import android.database.Cursor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class Many2ManyAnalyzer extends AssociationsAnalyzer {
    void analyze(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Collection<LitePalSupport> associatedModels = getAssociatedModels(litePalSupport, associationsInfo);
        declareAssociations(litePalSupport, associationsInfo);
        if (associatedModels != null) {
            for (LitePalSupport litePalSupport2 : associatedModels) {
                Collection<LitePalSupport> checkAssociatedModelCollection = checkAssociatedModelCollection(getReverseAssociatedModels(litePalSupport2, associationsInfo), associationsInfo.getAssociateSelfFromOtherModel());
                addNewModelForAssociatedModel(checkAssociatedModelCollection, litePalSupport);
                setReverseAssociatedModels(litePalSupport2, associationsInfo, checkAssociatedModelCollection);
                dealAssociatedModel(litePalSupport, litePalSupport2);
            }
        }
    }

    private void declareAssociations(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) {
        litePalSupport.addEmptyModelForJoinTable(getAssociatedTableName(associationsInfo));
    }

    private void addNewModelForAssociatedModel(Collection<LitePalSupport> collection, LitePalSupport litePalSupport) {
        if (collection.contains(litePalSupport)) {
            return;
        }
        collection.add(litePalSupport);
    }

    private void dealAssociatedModel(LitePalSupport litePalSupport, LitePalSupport litePalSupport2) {
        if (litePalSupport2.isSaved()) {
            litePalSupport.addAssociatedModelForJoinTable(litePalSupport2.getTableName(), litePalSupport2.getBaseObjId());
        }
    }

    private String getAssociatedTableName(AssociationsInfo associationsInfo) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()));
    }

    @Deprecated
    private boolean isDataExists(LitePalSupport litePalSupport, LitePalSupport litePalSupport2) {
        Cursor cursor = null;
        try {
            cursor = Connector.getDatabase().query(getJoinTableName(litePalSupport, litePalSupport2), null, getSelection(litePalSupport, litePalSupport2), getSelectionArgs(litePalSupport, litePalSupport2), null, null, null);
            return cursor.getCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        } finally {
            cursor.close();
        }
    }

    private String getSelection(LitePalSupport litePalSupport, LitePalSupport litePalSupport2) {
        return getForeignKeyColumnName(litePalSupport.getTableName()) + " = ? and " + getForeignKeyColumnName(litePalSupport2.getTableName()) + " = ?";
    }

    private String[] getSelectionArgs(LitePalSupport litePalSupport, LitePalSupport litePalSupport2) {
        return new String[]{String.valueOf(litePalSupport.getBaseObjId()), String.valueOf(litePalSupport2.getBaseObjId())};
    }

    private String getJoinTableName(LitePalSupport litePalSupport, LitePalSupport litePalSupport2) {
        return getIntermediateTableName(litePalSupport, litePalSupport2.getTableName());
    }
}
