package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class SavedStateHandle {
    private static final Class[] ACCEPTABLE_CLASSES;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, SavingStateLiveData<?>> mLiveDatas;
    final Map<String, Object> mRegular;
    private final SavedStateRegistry.SavedStateProvider mSavedStateProvider;
    final Map<String, SavedStateRegistry.SavedStateProvider> mSavedStateProviders;

    public SavedStateHandle(Map<String, Object> initialState) {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle.1
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public Bundle saveState() {
                for (Map.Entry entry : new HashMap(SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                    SavedStateHandle.this.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
                }
                Set<String> keySet = SavedStateHandle.this.mRegular.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(SavedStateHandle.this.mRegular.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(SavedStateHandle.KEYS, arrayList);
                bundle.putParcelableArrayList(SavedStateHandle.VALUES, arrayList2);
                return bundle;
            }
        };
        this.mRegular = new HashMap(initialState);
    }

    public SavedStateHandle() {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle.1
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public Bundle saveState() {
                for (Map.Entry entry : new HashMap(SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                    SavedStateHandle.this.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
                }
                Set<String> keySet = SavedStateHandle.this.mRegular.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(SavedStateHandle.this.mRegular.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(SavedStateHandle.KEYS, arrayList);
                bundle.putParcelableArrayList(SavedStateHandle.VALUES, arrayList2);
                return bundle;
            }
        };
        this.mRegular = new HashMap();
    }

    static SavedStateHandle createHandle(Bundle restoredState, Bundle defaultState) {
        if (restoredState == null && defaultState == null) {
            return new SavedStateHandle();
        }
        HashMap hashMap = new HashMap();
        if (defaultState != null) {
            for (String str : defaultState.keySet()) {
                hashMap.put(str, defaultState.get(str));
            }
        }
        if (restoredState == null) {
            return new SavedStateHandle(hashMap);
        }
        ArrayList parcelableArrayList = restoredState.getParcelableArrayList(KEYS);
        ArrayList parcelableArrayList2 = restoredState.getParcelableArrayList(VALUES);
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new SavedStateHandle(hashMap);
    }

    SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.mSavedStateProvider;
    }

    public boolean contains(String key) {
        return this.mRegular.containsKey(key);
    }

    public <T> MutableLiveData<T> getLiveData(String key) {
        return getLiveDataInternal(key, false, null);
    }

    public <T> MutableLiveData<T> getLiveData(String key, T initialValue) {
        return getLiveDataInternal(key, true, initialValue);
    }

    private <T> MutableLiveData<T> getLiveDataInternal(String key, boolean hasInitialValue, T initialValue) {
        SavingStateLiveData<?> savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.mLiveDatas.get(key);
        if (savingStateLiveData2 != null) {
            return savingStateLiveData2;
        }
        if (this.mRegular.containsKey(key)) {
            savingStateLiveData = new SavingStateLiveData<>(this, key, this.mRegular.get(key));
        } else if (hasInitialValue) {
            savingStateLiveData = new SavingStateLiveData<>(this, key, initialValue);
        } else {
            savingStateLiveData = new SavingStateLiveData<>(this, key);
        }
        this.mLiveDatas.put(key, savingStateLiveData);
        return savingStateLiveData;
    }

    public Set<String> keys() {
        HashSet hashSet = new HashSet(this.mRegular.keySet());
        hashSet.addAll(this.mSavedStateProviders.keySet());
        hashSet.addAll(this.mLiveDatas.keySet());
        return hashSet;
    }

    public <T> T get(String str) {
        return (T) this.mRegular.get(str);
    }

    public <T> void set(String key, T value) {
        validateValue(value);
        SavingStateLiveData<?> savingStateLiveData = this.mLiveDatas.get(key);
        if (savingStateLiveData != null) {
            savingStateLiveData.setValue(value);
        } else {
            this.mRegular.put(key, value);
        }
    }

    private static void validateValue(Object value) {
        if (value == null) {
            return;
        }
        for (Class cls : ACCEPTABLE_CLASSES) {
            if (cls.isInstance(value)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + value.getClass() + " into saved state");
    }

    public <T> T remove(String str) {
        T t = (T) this.mRegular.remove(str);
        SavingStateLiveData<?> remove = this.mLiveDatas.remove(str);
        if (remove != null) {
            remove.detach();
        }
        return t;
    }

    public void setSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        this.mSavedStateProviders.put(key, provider);
    }

    public void clearSavedStateProvider(String key) {
        this.mSavedStateProviders.remove(key);
    }

    static class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle mHandle;
        private String mKey;

        SavingStateLiveData(SavedStateHandle handle, String key, T value) {
            super(value);
            this.mKey = key;
            this.mHandle = handle;
        }

        SavingStateLiveData(SavedStateHandle handle, String key) {
            this.mKey = key;
            this.mHandle = handle;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T value) {
            SavedStateHandle savedStateHandle = this.mHandle;
            if (savedStateHandle != null) {
                savedStateHandle.mRegular.put(this.mKey, value);
            }
            super.setValue(value);
        }

        void detach() {
            this.mHandle = null;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        clsArr[4] = Integer.TYPE;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        clsArr[27] = Build.VERSION.SDK_INT >= 21 ? Size.class : Integer.TYPE;
        clsArr[28] = Build.VERSION.SDK_INT >= 21 ? SizeF.class : Integer.TYPE;
        ACCEPTABLE_CLASSES = clsArr;
    }
}