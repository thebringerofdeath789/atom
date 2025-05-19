package org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {
    private final Map<String, BackgroundInitializer<?>> childInitializers;

    public MultiBackgroundInitializer() {
        this.childInitializers = new HashMap();
    }

    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
        this.childInitializers = new HashMap();
    }

    public void addInitializer(String str, BackgroundInitializer<?> backgroundInitializer) {
        Validate.notNull(str, "name", new Object[0]);
        Validate.notNull(backgroundInitializer, "backgroundInitializer", new Object[0]);
        synchronized (this) {
            if (isStarted()) {
                throw new IllegalStateException("addInitializer() must not be called after start()!");
            }
            this.childInitializers.put(str, backgroundInitializer);
        }
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    protected int getTaskCount() {
        Iterator<BackgroundInitializer<?>> it = this.childInitializers.values().iterator();
        int i = 1;
        while (it.hasNext()) {
            i += it.next().getTaskCount();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    public MultiBackgroundInitializerResults initialize() throws Exception {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.childInitializers);
        }
        ExecutorService activeExecutor = getActiveExecutor();
        for (BackgroundInitializer backgroundInitializer : hashMap.values()) {
            if (backgroundInitializer.getExternalExecutor() == null) {
                backgroundInitializer.setExternalExecutor(activeExecutor);
            }
            backgroundInitializer.start();
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                hashMap2.put(entry.getKey(), ((BackgroundInitializer) entry.getValue()).get());
            } catch (ConcurrentException e) {
                hashMap3.put(entry.getKey(), e);
            }
        }
        return new MultiBackgroundInitializerResults(hashMap, hashMap2, hashMap3);
    }

    public static class MultiBackgroundInitializerResults {
        private final Map<String, ConcurrentException> exceptions;
        private final Map<String, BackgroundInitializer<?>> initializers;
        private final Map<String, Object> resultObjects;

        private MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            this.initializers = map;
            this.resultObjects = map2;
            this.exceptions = map3;
        }

        public BackgroundInitializer<?> getInitializer(String str) {
            return checkName(str);
        }

        public Object getResultObject(String str) {
            checkName(str);
            return this.resultObjects.get(str);
        }

        public boolean isException(String str) {
            checkName(str);
            return this.exceptions.containsKey(str);
        }

        public ConcurrentException getException(String str) {
            checkName(str);
            return this.exceptions.get(str);
        }

        public Set<String> initializerNames() {
            return Collections.unmodifiableSet(this.initializers.keySet());
        }

        public boolean isSuccessful() {
            return this.exceptions.isEmpty();
        }

        private BackgroundInitializer<?> checkName(String str) {
            BackgroundInitializer<?> backgroundInitializer = this.initializers.get(str);
            if (backgroundInitializer != null) {
                return backgroundInitializer;
            }
            throw new NoSuchElementException("No child initializer with name " + str);
        }
    }
}
