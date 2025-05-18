package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class NavController {
    private static final String KEY_BACK_STACK_ARGS = "android-support-nav:controller:backStackArgs";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private Activity mActivity;
    private Parcelable[] mBackStackArgsToRestore;
    private int[] mBackStackIdsToRestore;
    final Context mContext;
    private NavGraph mGraph;
    private NavInflater mInflater;
    private Bundle mNavigatorStateToRestore;
    final Deque<NavBackStackEntry> mBackStack = new ArrayDeque();
    private final NavigatorProvider mNavigatorProvider = new NavigatorProvider() { // from class: androidx.navigation.NavController.1
        @Override // androidx.navigation.NavigatorProvider
        public Navigator<? extends NavDestination> addNavigator(String str, Navigator<? extends NavDestination> navigator) {
            Navigator<? extends NavDestination> addNavigator = super.addNavigator(str, navigator);
            if (addNavigator != navigator) {
                if (addNavigator != null) {
                    addNavigator.removeOnNavigatorBackPressListener(NavController.this.mOnBackPressListener);
                }
                navigator.addOnNavigatorBackPressListener(NavController.this.mOnBackPressListener);
            }
            return addNavigator;
        }
    };
    final Navigator.OnNavigatorBackPressListener mOnBackPressListener = new Navigator.OnNavigatorBackPressListener() { // from class: androidx.navigation.NavController.2
        @Override // androidx.navigation.Navigator.OnNavigatorBackPressListener
        public void onPopBackStack(Navigator navigator) {
            NavDestination navDestination;
            Iterator<NavBackStackEntry> descendingIterator = NavController.this.mBackStack.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    navDestination = null;
                    break;
                } else {
                    navDestination = descendingIterator.next().getDestination();
                    if (NavController.this.getNavigatorProvider().getNavigator(navDestination.getNavigatorName()) == navigator) {
                        break;
                    }
                }
            }
            if (navDestination == null) {
                throw new IllegalArgumentException("Navigator " + navigator + " reported pop but did not have any destinations on the NavController back stack");
            }
            NavController.this.popBackStackInternal(navDestination.getId(), false);
            if (!NavController.this.mBackStack.isEmpty()) {
                NavController.this.mBackStack.removeLast();
            }
            NavController.this.dispatchOnDestinationChanged();
        }
    };
    private final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList<>();

    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    public NavController(Context context) {
        this.mContext = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        this.mNavigatorProvider.addNavigator(new NavGraphNavigator(this.mNavigatorProvider));
        this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
    }

    Context getContext() {
        return this.mContext;
    }

    public NavigatorProvider getNavigatorProvider() {
        return this.mNavigatorProvider;
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        if (!this.mBackStack.isEmpty()) {
            NavBackStackEntry peekLast = this.mBackStack.peekLast();
            onDestinationChangedListener.onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        this.mOnDestinationChangedListeners.add(onDestinationChangedListener);
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        this.mOnDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    public boolean popBackStack() {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        return popBackStack(getCurrentDestination().getId(), true);
    }

    public boolean popBackStack(int i, boolean z) {
        return popBackStackInternal(i, z) && dispatchOnDestinationChanged();
    }

    boolean popBackStackInternal(int i, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            NavDestination destination = descendingIterator.next().getDestination();
            Navigator navigator = this.mNavigatorProvider.getNavigator(destination.getNavigatorName());
            if (z || destination.getId() != i) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.getDisplayName(this.mContext, i) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            this.mBackStack.removeLast();
            z3 = true;
        }
        return z3;
    }

    public boolean navigateUp() {
        if (getDestinationCountOnBackStack() == 1) {
            NavDestination currentDestination = getCurrentDestination();
            int id = currentDestination.getId();
            for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
                if (parent.getStartDestination() != id) {
                    new NavDeepLinkBuilder(this).setDestination(parent.getId()).createTaskStackBuilder().startActivities();
                    Activity activity = this.mActivity;
                    if (activity != null) {
                        activity.finish();
                    }
                    return true;
                }
                id = parent.getId();
            }
            return false;
        }
        return popBackStack();
    }

    private int getDestinationCountOnBackStack() {
        Iterator<NavBackStackEntry> it = this.mBackStack.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!(it.next().getDestination() instanceof NavGraph)) {
                i++;
            }
        }
        return i;
    }

    boolean dispatchOnDestinationChanged() {
        while (!this.mBackStack.isEmpty() && (this.mBackStack.peekLast().getDestination() instanceof NavGraph) && popBackStackInternal(this.mBackStack.peekLast().getDestination().getId(), true)) {
        }
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        NavBackStackEntry peekLast = this.mBackStack.peekLast();
        Iterator<OnDestinationChangedListener> it = this.mOnDestinationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        return true;
    }

    public NavInflater getNavInflater() {
        if (this.mInflater == null) {
            this.mInflater = new NavInflater(this.mContext, this.mNavigatorProvider);
        }
        return this.mInflater;
    }

    public void setGraph(int i) {
        setGraph(i, (Bundle) null);
    }

    public void setGraph(int i, Bundle bundle) {
        setGraph(getNavInflater().inflate(i), bundle);
    }

    public void setGraph(NavGraph navGraph) {
        setGraph(navGraph, (Bundle) null);
    }

    public void setGraph(NavGraph navGraph, Bundle bundle) {
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 != null) {
            popBackStackInternal(navGraph2.getId(), true);
        }
        this.mGraph = navGraph;
        onGraphCreated(bundle);
    }

    private void onGraphCreated(Bundle bundle) {
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.mNavigatorStateToRestore;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Navigator navigator = this.mNavigatorProvider.getNavigator(next);
                Bundle bundle3 = this.mNavigatorStateToRestore.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        boolean z = false;
        if (this.mBackStackIdsToRestore != null) {
            int i = 0;
            while (true) {
                int[] iArr = this.mBackStackIdsToRestore;
                if (i < iArr.length) {
                    int i2 = iArr[i];
                    Bundle bundle4 = (Bundle) this.mBackStackArgsToRestore[i];
                    NavDestination findDestination = findDestination(i2);
                    if (findDestination == null) {
                        throw new IllegalStateException("unknown destination during restore: " + this.mContext.getResources().getResourceName(i2));
                    }
                    if (bundle4 != null) {
                        bundle4.setClassLoader(this.mContext.getClassLoader());
                    }
                    this.mBackStack.add(new NavBackStackEntry(findDestination, bundle4));
                    i++;
                } else {
                    this.mBackStackIdsToRestore = null;
                    this.mBackStackArgsToRestore = null;
                    break;
                }
            }
        }
        if (this.mGraph == null || !this.mBackStack.isEmpty()) {
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && handleDeepLink(activity.getIntent())) {
            z = true;
        }
        if (z) {
            return;
        }
        navigate(this.mGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
    }

    public boolean handleDeepLink(Intent intent) {
        NavDestination.DeepLinkMatch matchDeepLink;
        NavGraph navGraph;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray(KEY_DEEP_LINK_IDS) : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle(KEY_DEEP_LINK_EXTRAS) : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (matchDeepLink = this.mGraph.matchDeepLink(intent.getData())) != null) {
            intArray = matchDeepLink.getDestination().buildDeepLinkIds();
            bundle.putAll(matchDeepLink.getMatchingArgs());
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String findInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(intArray);
        if (findInvalidDestinationDisplayNameInDeepLink != null) {
            Log.i(TAG, "Could not find destination " + findInvalidDestinationDisplayNameInDeepLink + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int flags = intent.getFlags();
        int i = 268435456 & flags;
        if (i != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(intent).startActivities();
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.finish();
            }
            return true;
        }
        if (i != 0) {
            if (!this.mBackStack.isEmpty()) {
                popBackStackInternal(this.mGraph.getId(), true);
            }
            int i2 = 0;
            while (i2 < intArray.length) {
                int i3 = i2 + 1;
                int i4 = intArray[i2];
                NavDestination findDestination = findDestination(i4);
                if (findDestination == null) {
                    throw new IllegalStateException("unknown destination during deep link: " + NavDestination.getDisplayName(this.mContext, i4));
                }
                navigate(findDestination, bundle, new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
                i2 = i3;
            }
            return true;
        }
        NavGraph navGraph2 = this.mGraph;
        int i5 = 0;
        while (i5 < intArray.length) {
            int i6 = intArray[i5];
            NavDestination findNode = i5 == 0 ? this.mGraph : navGraph2.findNode(i6);
            if (findNode == null) {
                throw new IllegalStateException("unknown destination during deep link: " + NavDestination.getDisplayName(this.mContext, i6));
            }
            if (i5 != intArray.length - 1) {
                while (true) {
                    navGraph = (NavGraph) findNode;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    findNode = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            } else {
                navigate(findNode, findNode.addInDefaultArgs(bundle), new NavOptions.Builder().setPopUpTo(this.mGraph.getId(), true).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
            }
            i5++;
        }
        return true;
    }

    private String findInvalidDestinationDisplayNameInDeepLink(int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            NavDestination findNode = i == 0 ? this.mGraph : navGraph2.findNode(i2);
            if (findNode == null) {
                return NavDestination.getDisplayName(this.mContext, i2);
            }
            if (i != iArr.length - 1) {
                while (true) {
                    navGraph = (NavGraph) findNode;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    findNode = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
        return null;
    }

    public NavGraph getGraph() {
        NavGraph navGraph = this.mGraph;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    public NavDestination getCurrentDestination() {
        if (this.mBackStack.isEmpty()) {
            return null;
        }
        return this.mBackStack.getLast().getDestination();
    }

    NavDestination findDestination(int i) {
        NavGraph navGraph = this.mGraph;
        if (navGraph == null) {
            return null;
        }
        if (navGraph.getId() == i) {
            return this.mGraph;
        }
        NavGraph destination = this.mBackStack.isEmpty() ? this.mGraph : this.mBackStack.getLast().getDestination();
        return (destination instanceof NavGraph ? destination : destination.getParent()).findNode(i);
    }

    public void navigate(int i) {
        navigate(i, (Bundle) null);
    }

    public void navigate(int i, Bundle bundle) {
        navigate(i, bundle, null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions) {
        navigate(i, bundle, navOptions, (Navigator.Extras) null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        int i2;
        NavDestination destination = this.mBackStack.isEmpty() ? this.mGraph : this.mBackStack.getLast().getDestination();
        if (destination == null) {
            throw new IllegalStateException("no current navigation node");
        }
        NavAction action = destination.getAction(i);
        Bundle bundle2 = null;
        if (action != null) {
            if (navOptions == null) {
                navOptions = action.getNavOptions();
            }
            i2 = action.getDestinationId();
            Bundle defaultArguments = action.getDefaultArguments();
            if (defaultArguments != null) {
                bundle2 = new Bundle();
                bundle2.putAll(defaultArguments);
            }
        } else {
            i2 = i;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putAll(bundle);
        }
        if (i2 == 0 && navOptions != null && navOptions.getPopUpTo() != -1) {
            popBackStack(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        } else {
            if (i2 == 0) {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
            NavDestination findDestination = findDestination(i2);
            if (findDestination == null) {
                throw new IllegalArgumentException("navigation destination " + NavDestination.getDisplayName(this.mContext, i2) + (action != null ? " referenced from action " + NavDestination.getDisplayName(this.mContext, i) : "") + " is unknown to this NavController");
            }
            navigate(findDestination, bundle2, navOptions, extras);
        }
    }

    private void navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        boolean popBackStackInternal = (navOptions == null || navOptions.getPopUpTo() == -1) ? false : popBackStackInternal(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        Navigator navigator = this.mNavigatorProvider.getNavigator(navDestination.getNavigatorName());
        Bundle addInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        NavDestination navigate = navigator.navigate(navDestination, addInDefaultArgs, navOptions, extras);
        if (navigate != null) {
            ArrayDeque arrayDeque = new ArrayDeque();
            for (NavGraph parent = navigate.getParent(); parent != null; parent = parent.getParent()) {
                arrayDeque.addFirst(new NavBackStackEntry(parent, addInDefaultArgs));
            }
            Iterator<NavBackStackEntry> it = this.mBackStack.iterator();
            while (it.hasNext() && !arrayDeque.isEmpty()) {
                if (it.next().getDestination().equals(((NavBackStackEntry) arrayDeque.getFirst()).getDestination())) {
                    arrayDeque.removeFirst();
                }
            }
            this.mBackStack.addAll(arrayDeque);
            this.mBackStack.add(new NavBackStackEntry(navigate, addInDefaultArgs));
        }
        if (popBackStackInternal || navigate != null) {
            dispatchOnDestinationChanged();
        }
    }

    public void navigate(NavDirections navDirections) {
        navigate(navDirections.getActionId(), navDirections.getArguments());
    }

    public void navigate(NavDirections navDirections, NavOptions navOptions) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(NavDirections navDirections, Navigator.Extras extras) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this.mNavigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        }
        if (!this.mBackStack.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.mBackStack.size()];
            Parcelable[] parcelableArr = new Parcelable[this.mBackStack.size()];
            int i = 0;
            for (NavBackStackEntry navBackStackEntry : this.mBackStack) {
                iArr[i] = navBackStackEntry.getDestination().getId();
                parcelableArr[i] = navBackStackEntry.getArguments();
                i++;
            }
            bundle.putIntArray(KEY_BACK_STACK_IDS, iArr);
            bundle.putParcelableArray(KEY_BACK_STACK_ARGS, parcelableArr);
        }
        return bundle;
    }

    public void restoreState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.mContext.getClassLoader());
        this.mNavigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
        this.mBackStackIdsToRestore = bundle.getIntArray(KEY_BACK_STACK_IDS);
        this.mBackStackArgsToRestore = bundle.getParcelableArray(KEY_BACK_STACK_ARGS);
    }
}