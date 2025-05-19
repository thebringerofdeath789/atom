package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.LitePal;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class LitePalSupport {
    protected static final String AES = "AES";
    protected static final String MD5 = "MD5";
    Map<String, List<Long>> associatedModelsMapForJoinTable;
    private Map<String, Set<Long>> associatedModelsMapWithFK;
    private Map<String, Long> associatedModelsMapWithoutFK;
    long baseObjId;
    private List<String> fieldsToSetToDefault;
    private List<String> listToClearAssociatedFK;
    private List<String> listToClearSelfFK;

    public int delete() {
        int onDelete;
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                onDelete = new DeleteHandler(database).onDelete(this);
                this.baseObjId = 0L;
                database.setTransactionSuccessful();
            } finally {
                database.endTransaction();
            }
        }
        return onDelete;
    }

    public UpdateOrDeleteExecutor deleteAsync() {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int delete = LitePalSupport.this.delete();
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(delete);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    public int update(long j) {
        int onUpdate;
        synchronized (LitePalSupport.class) {
            try {
                try {
                    onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(this, j);
                    getFieldsToSetToDefault().clear();
                } catch (Exception e) {
                    throw new LitePalSupportException(e.getMessage(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return onUpdate;
    }

    public UpdateOrDeleteExecutor updateAsync(final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int update = LitePalSupport.this.update(j);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(update);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    public int updateAll(String... strArr) {
        int onUpdateAll;
        synchronized (LitePalSupport.class) {
            try {
                try {
                    onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, strArr);
                    getFieldsToSetToDefault().clear();
                } catch (Exception e) {
                    throw new LitePalSupportException(e.getMessage(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return onUpdateAll;
    }

    public UpdateOrDeleteExecutor updateAllAsync(final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int updateAll = LitePalSupport.this.updateAll(strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(updateAll);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    public boolean save() {
        try {
            saveThrows();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SaveExecutor saveAsync() {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final boolean save = LitePalSupport.this.save();
                    if (saveExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(save);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    public void saveThrows() {
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                try {
                    new SaveHandler(database).onSave(this);
                    clearAssociatedData();
                    database.setTransactionSuccessful();
                } catch (Exception e) {
                    throw new LitePalSupportException(e.getMessage(), e);
                }
            } finally {
                database.endTransaction();
            }
        }
    }

    @Deprecated
    public boolean saveIfNotExist(String... strArr) {
        if (LitePal.isExist(getClass(), strArr)) {
            return false;
        }
        return save();
    }

    public boolean saveOrUpdate(String... strArr) {
        synchronized (LitePalSupport.class) {
            if (strArr == null) {
                return save();
            }
            List find = LitePal.where(strArr).find(getClass());
            if (find.isEmpty()) {
                return save();
            }
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                Iterator it = find.iterator();
                while (it.hasNext()) {
                    this.baseObjId = ((LitePalSupport) it.next()).getBaseObjId();
                    new SaveHandler(database).onSave(this);
                    clearAssociatedData();
                }
                database.setTransactionSuccessful();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                database.endTransaction();
            }
        }
    }

    public SaveExecutor saveOrUpdateAsync(final String... strArr) {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final boolean saveOrUpdate = LitePalSupport.this.saveOrUpdate(strArr);
                    if (saveExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(saveOrUpdate);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    public void clearSavedState() {
        this.baseObjId = 0L;
    }

    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    public void assignBaseObjId(int i) {
        this.baseObjId = i;
    }

    protected LitePalSupport() {
    }

    protected long getBaseObjId() {
        return this.baseObjId;
    }

    protected String getClassName() {
        return getClass().getName();
    }

    protected String getTableName() {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(getClassName()));
    }

    List<String> getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }

    void addAssociatedModelWithFK(String str, long j) {
        Set<Long> set = getAssociatedModelsMapWithFK().get(str);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j));
            this.associatedModelsMapWithFK.put(str, hashSet);
            return;
        }
        set.add(Long.valueOf(j));
    }

    Map<String, Set<Long>> getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }

    void addAssociatedModelForJoinTable(String str, long j) {
        List<Long> list = getAssociatedModelsMapForJoinTable().get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            this.associatedModelsMapForJoinTable.put(str, arrayList);
            return;
        }
        list.add(Long.valueOf(j));
    }

    void addEmptyModelForJoinTable(String str) {
        if (getAssociatedModelsMapForJoinTable().get(str) == null) {
            this.associatedModelsMapForJoinTable.put(str, new ArrayList());
        }
    }

    Map<String, List<Long>> getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }

    void addAssociatedModelWithoutFK(String str, long j) {
        getAssociatedModelsMapWithoutFK().put(str, Long.valueOf(j));
    }

    Map<String, Long> getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }

    void addFKNameToClearSelf(String str) {
        List<String> listToClearSelfFK = getListToClearSelfFK();
        if (listToClearSelfFK.contains(str)) {
            return;
        }
        listToClearSelfFK.add(str);
    }

    List<String> getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }

    void addAssociatedTableNameToClearFK(String str) {
        List<String> listToClearAssociatedFK = getListToClearAssociatedFK();
        if (listToClearAssociatedFK.contains(str)) {
            return;
        }
        listToClearAssociatedFK.add(str);
    }

    List<String> getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }

    void clearAssociatedData() {
        clearIdOfModelWithFK();
        clearIdOfModelWithoutFK();
        clearIdOfModelForJoinTable();
        clearFKNameList();
    }

    private void clearIdOfModelWithFK() {
        Iterator<String> it = getAssociatedModelsMapWithFK().keySet().iterator();
        while (it.hasNext()) {
            this.associatedModelsMapWithFK.get(it.next()).clear();
        }
        this.associatedModelsMapWithFK.clear();
    }

    private void clearIdOfModelWithoutFK() {
        getAssociatedModelsMapWithoutFK().clear();
    }

    private void clearIdOfModelForJoinTable() {
        Iterator<String> it = getAssociatedModelsMapForJoinTable().keySet().iterator();
        while (it.hasNext()) {
            this.associatedModelsMapForJoinTable.get(it.next()).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
    }

    private void clearFKNameList() {
        getListToClearSelfFK().clear();
        getListToClearAssociatedFK().clear();
    }
}
