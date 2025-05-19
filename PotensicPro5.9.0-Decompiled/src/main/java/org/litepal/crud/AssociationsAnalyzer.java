package org.litepal.crud;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
abstract class AssociationsAnalyzer extends DataHandler {
    AssociationsAnalyzer() {
    }

    protected Collection<LitePalSupport> getReverseAssociatedModels(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (Collection) getFieldValue(litePalSupport, associationsInfo.getAssociateSelfFromOtherModel());
    }

    protected void setReverseAssociatedModels(LitePalSupport litePalSupport, AssociationsInfo associationsInfo, Collection<LitePalSupport> collection) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        setFieldValue(litePalSupport, associationsInfo.getAssociateSelfFromOtherModel(), collection);
    }

    protected Collection<LitePalSupport> checkAssociatedModelCollection(Collection<LitePalSupport> collection, Field field) {
        Collection<LitePalSupport> hashSet;
        if (isList(field.getType())) {
            hashSet = new ArrayList<>();
        } else if (isSet(field.getType())) {
            hashSet = new HashSet<>();
        } else {
            throw new LitePalSupportException(LitePalSupportException.WRONG_FIELD_TYPE_FOR_ASSOCIATIONS);
        }
        if (collection != null) {
            hashSet.addAll(collection);
        }
        return hashSet;
    }

    protected void buildBidirectionalAssociations(LitePalSupport litePalSupport, LitePalSupport litePalSupport2, AssociationsInfo associationsInfo) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        setFieldValue(litePalSupport2, associationsInfo.getAssociateSelfFromOtherModel(), litePalSupport);
    }

    protected void dealsAssociationsOnTheSideWithoutFK(LitePalSupport litePalSupport, LitePalSupport litePalSupport2) {
        if (litePalSupport2 != null) {
            if (litePalSupport2.isSaved()) {
                litePalSupport.addAssociatedModelWithFK(litePalSupport2.getTableName(), litePalSupport2.getBaseObjId());
            } else if (litePalSupport.isSaved()) {
                litePalSupport2.addAssociatedModelWithoutFK(litePalSupport.getTableName(), litePalSupport.getBaseObjId());
            }
        }
    }

    protected void mightClearFKValue(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) {
        litePalSupport.addFKNameToClearSelf(getForeignKeyName(associationsInfo));
    }

    private String getForeignKeyName(AssociationsInfo associationsInfo) {
        return getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()));
    }
}
