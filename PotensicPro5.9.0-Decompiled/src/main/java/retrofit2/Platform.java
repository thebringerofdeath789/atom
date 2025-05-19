package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes6.dex */
class Platform {
    private static final Platform PLATFORM = findPlatform();
    private final boolean hasJava8Types;

    @Nullable
    Executor defaultCallbackExecutor() {
        return null;
    }

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
        return new Platform(true);
    }

    Platform(boolean z) {
        this.hasJava8Types = z;
    }

    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        return this.hasJava8Types ? Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory);
    }

    int defaultCallAdapterFactoriesSize() {
        return this.hasJava8Types ? 2 : 1;
    }

    List<? extends Converter.Factory> defaultConverterFactories() {
        if (this.hasJava8Types) {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }
        return Collections.emptyList();
    }

    int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    boolean isDefaultMethod(Method method) {
        return this.hasJava8Types && method.isDefault();
    }

    @Nullable
    Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
        declaredConstructor.setAccessible(true);
        return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    static final class Android extends Platform {
        Android() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }
    }
}
