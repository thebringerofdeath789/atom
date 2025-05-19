package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

/* loaded from: classes.dex */
public interface ActivityResultCaller {
    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> contract, ActivityResultCallback<O> callback);

    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> contract, ActivityResultRegistry registry, ActivityResultCallback<O> callback);
}
