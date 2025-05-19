package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.NavArgument;
import androidx.navigation.NavOptions;
import java.io.IOException;
import org.apache.xmlbeans.XmlErrorCodes;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class NavInflater {
    private static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    private Context mContext;
    private NavigatorProvider mNavigatorProvider;

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        this.mContext = context;
        this.mNavigatorProvider = navigatorProvider;
    }

    public NavGraph inflate(int i) {
        int next;
        Resources resources = this.mContext.getResources();
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        NavDestination inflate = inflate(resources, xml, asAttributeSet, i);
        if (!(inflate instanceof NavGraph)) {
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        return (NavGraph) inflate;
    }

    private NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        NavDestination createDestination = this.mNavigatorProvider.getNavigator(xmlResourceParser.getName()).createDestination();
        createDestination.onInflate(this.mContext, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if (TAG_ARGUMENT.equals(name)) {
                    inflateArgumentForDestination(resources, createDestination, attributeSet, i);
                } else if (TAG_DEEP_LINK.equals(name)) {
                    inflateDeepLink(resources, createDestination, attributeSet);
                } else if (TAG_ACTION.equals(name)) {
                    inflateAction(resources, createDestination, attributeSet, xmlResourceParser, i);
                } else if (TAG_INCLUDE.equals(name) && (createDestination instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                    obtainAttributes.recycle();
                } else if (createDestination instanceof NavGraph) {
                    ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return createDestination;
    }

    private void inflateArgumentForDestination(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i));
        obtainAttributes.recycle();
    }

    private void inflateArgumentForBundle(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i);
        if (inflateArgument.isDefaultValuePresent()) {
            inflateArgument.putDefaultValue(string, bundle);
        }
        obtainAttributes.recycle();
    }

    private NavArgument inflateArgument(TypedArray typedArray, Resources resources, int i) throws XmlPullParserException {
        NavArgument.Builder builder = new NavArgument.Builder();
        builder.setIsNullable(typedArray.getBoolean(R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = sTmpValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(R.styleable.NavArgument_argType);
        Object obj = null;
        NavType<?> fromArgType = string != null ? NavType.fromArgType(string, resources.getResourcePackageName(i)) : null;
        if (typedArray.getValue(R.styleable.NavArgument_android_defaultValue, typedValue)) {
            if (fromArgType == NavType.ReferenceType) {
                if (typedValue.resourceId != 0) {
                    obj = Integer.valueOf(typedValue.resourceId);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    obj = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fromArgType.getName() + ". Must be a reference to a resource.");
                }
            } else if (typedValue.resourceId != 0) {
                if (fromArgType == null) {
                    fromArgType = NavType.ReferenceType;
                    obj = Integer.valueOf(typedValue.resourceId);
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fromArgType.getName() + ". You must use a \"" + NavType.ReferenceType.getName() + "\" type to reference other resources.");
                }
            } else if (fromArgType == NavType.StringType) {
                obj = typedArray.getString(R.styleable.NavArgument_android_defaultValue);
            } else {
                int i2 = typedValue.type;
                if (i2 == 3) {
                    String charSequence = typedValue.string.toString();
                    if (fromArgType == null) {
                        fromArgType = NavType.inferFromValue(charSequence);
                    }
                    obj = fromArgType.parseValue(charSequence);
                } else if (i2 == 4) {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.FloatType, string, XmlErrorCodes.FLOAT);
                    obj = Float.valueOf(typedValue.getFloat());
                } else if (i2 == 5) {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.IntType, string, "dimension");
                    obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                } else if (i2 == 18) {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.BoolType, string, XmlErrorCodes.BOOLEAN);
                    obj = Boolean.valueOf(typedValue.data != 0);
                } else if (typedValue.type >= 16 && typedValue.type <= 31) {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.IntType, string, XmlErrorCodes.INTEGER);
                    obj = Integer.valueOf(typedValue.data);
                } else {
                    throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                }
            }
        }
        if (obj != null) {
            builder.setDefaultValue(obj);
        }
        if (fromArgType != null) {
            builder.setType(fromArgType);
        }
        return builder.build();
    }

    private static NavType checkNavType(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType == null || navType == navType2) {
            return navType != null ? navType : navType2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private void inflateDeepLink(Resources resources, NavDestination navDestination, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavDeepLink);
        String string = obtainAttributes.getString(R.styleable.NavDeepLink_uri);
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException("Every <deepLink> must include an app:uri");
        }
        navDestination.addDeepLink(string.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
        obtainAttributes.recycle();
    }

    private void inflateAction(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavAction);
        int resourceId = obtainAttributes.getResourceId(R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainAttributes.getResourceId(R.styleable.NavAction_destination, 0));
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainAttributes.getBoolean(R.styleable.NavAction_launchSingleTop, false));
        builder.setPopUpTo(obtainAttributes.getResourceId(R.styleable.NavAction_popUpTo, -1), obtainAttributes.getBoolean(R.styleable.NavAction_popUpToInclusive, false));
        builder.setEnterAnim(obtainAttributes.getResourceId(R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainAttributes.getResourceId(R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainAttributes.getResourceId(R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainAttributes.getResourceId(R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && TAG_ARGUMENT.equals(xmlResourceParser.getName())) {
                inflateArgumentForBundle(resources, bundle, attributeSet, i);
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainAttributes.recycle();
    }
}
