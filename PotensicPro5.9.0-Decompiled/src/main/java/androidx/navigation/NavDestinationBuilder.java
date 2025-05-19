package androidx.navigation;

import androidx.navigation.NavDestination;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavDestinationBuilder.kt */
@NavDestinationDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ'\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b!J'\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\r2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b!J\r\u0010&\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\rR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "D", "Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", TtmlNode.ATTR_ID, "", "(Landroidx/navigation/Navigator;I)V", "actions", "", "Landroidx/navigation/NavAction;", "arguments", "", "Landroidx/navigation/NavArgument;", "deepLinks", "", "getId", "()I", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "action", "", "actionId", "actionBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavActionBuilder;", "Lkotlin/ExtensionFunctionType;", "argument", "name", "argumentBuilder", "Landroidx/navigation/NavArgumentBuilder;", "build", "()Landroidx/navigation/NavDestination;", "deepLink", "uriPattern", "navigation-common-ktx_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes.dex */
public class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<String> deepLinks;
    private final int id;
    private CharSequence label;
    private final Navigator<? extends D> navigator;

    public NavDestinationBuilder(Navigator<? extends D> navigator, int i) {
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        this.navigator = navigator;
        this.id = i;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    protected final Navigator<? extends D> getNavigator() {
        return this.navigator;
    }

    public final int getId() {
        return this.id;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final void argument(String name, Function1<? super NavArgumentBuilder, Unit> argumentBuilder) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(argumentBuilder, "argumentBuilder");
        Map<String, NavArgument> map = this.arguments;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        argumentBuilder.invoke(navArgumentBuilder);
        map.put(name, navArgumentBuilder.build());
    }

    public final void deepLink(String uriPattern) {
        Intrinsics.checkParameterIsNotNull(uriPattern, "uriPattern");
        this.deepLinks.add(uriPattern);
    }

    public final void action(int actionId, Function1<? super NavActionBuilder, Unit> actionBuilder) {
        Intrinsics.checkParameterIsNotNull(actionBuilder, "actionBuilder");
        Map<Integer, NavAction> map = this.actions;
        Integer valueOf = Integer.valueOf(actionId);
        NavActionBuilder navActionBuilder = new NavActionBuilder();
        actionBuilder.invoke(navActionBuilder);
        map.put(valueOf, navActionBuilder.build$navigation_common_ktx_release());
    }

    public D build() {
        D createDestination = this.navigator.createDestination();
        createDestination.setId(this.id);
        createDestination.setLabel(this.label);
        for (Map.Entry<String, NavArgument> entry : this.arguments.entrySet()) {
            createDestination.addArgument(entry.getKey(), entry.getValue());
        }
        Iterator<T> it = this.deepLinks.iterator();
        while (it.hasNext()) {
            createDestination.addDeepLink((String) it.next());
        }
        for (Map.Entry<Integer, NavAction> entry2 : this.actions.entrySet()) {
            createDestination.putAction(entry2.getKey().intValue(), entry2.getValue());
        }
        return createDestination;
    }
}
