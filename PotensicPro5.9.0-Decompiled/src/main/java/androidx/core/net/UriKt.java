package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.text.lookup.StringLookupFactory;

/* compiled from: Uri.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class UriKt {
    public static final Uri toUri(String toUri) {
        Intrinsics.checkParameterIsNotNull(toUri, "$this$toUri");
        Uri parse = Uri.parse(toUri);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        return parse;
    }

    public static final Uri toUri(File toUri) {
        Intrinsics.checkParameterIsNotNull(toUri, "$this$toUri");
        Uri fromFile = Uri.fromFile(toUri);
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }

    public static final File toFile(Uri toFile) {
        Intrinsics.checkParameterIsNotNull(toFile, "$this$toFile");
        if (!Intrinsics.areEqual(toFile.getScheme(), StringLookupFactory.KEY_FILE)) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + toFile).toString());
        }
        String path = toFile.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + toFile).toString());
    }
}
