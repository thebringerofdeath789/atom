package repackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class Repackager {
    private Matcher[] _fromMatchers;
    private String[] _toPackageNames;
    private List _fromPackages = new ArrayList();
    private List _toPackages = new ArrayList();

    public Repackager(String str) {
        boolean z;
        ArrayList splitPath = splitPath(str, ';');
        do {
            z = false;
            for (int i = 1; i < splitPath.size(); i++) {
                int i2 = i - 1;
                String str2 = (String) splitPath.get(i2);
                String str3 = (String) splitPath.get(i);
                if (str2.indexOf(58) < str3.indexOf(58)) {
                    splitPath.set(i2, str3);
                    splitPath.set(i, str2);
                    z = true;
                }
            }
        } while (z);
        for (int i3 = 0; i3 < splitPath.size(); i3++) {
            String str4 = (String) splitPath.get(i3);
            int indexOf = str4.indexOf(58);
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                if (str4.indexOf(58, i4) < 0) {
                    String substring = str4.substring(0, indexOf);
                    String substring2 = str4.substring(i4);
                    this._fromPackages.add(splitPath(substring, '.'));
                    this._toPackages.add(splitPath(substring2, '.'));
                }
            }
            throw new RuntimeException(new StringBuffer().append("Illegal repackage specification: ").append(str4).toString());
        }
        this._fromMatchers = new Matcher[this._fromPackages.size() * 2];
        this._toPackageNames = new String[this._fromPackages.size() * 2];
        addPatterns('.', 0);
        addPatterns('/', this._fromPackages.size());
    }

    void addPatterns(char c, int i) {
        for (int i2 = 0; i2 < this._fromPackages.size(); i2++) {
            List list = (List) this._fromPackages.get(i2);
            List list2 = (List) this._toPackages.get(i2);
            String str = "";
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 > 0) {
                    str = new StringBuffer().append(str).append("\\").append(c).toString();
                }
                str = new StringBuffer().append(str).append(list.get(i3)).toString();
            }
            String str2 = "";
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (i4 > 0) {
                    str2 = new StringBuffer().append(str2).append(c).toString();
                }
                str2 = new StringBuffer().append(str2).append(list2.get(i4)).toString();
            }
            int i5 = i + i2;
            this._fromMatchers[i5] = Pattern.compile(str).matcher("");
            this._toPackageNames[i5] = str2;
        }
    }

    public StringBuffer repackage(StringBuffer stringBuffer) {
        int i = 0;
        StringBuffer stringBuffer2 = null;
        while (true) {
            Matcher[] matcherArr = this._fromMatchers;
            if (i >= matcherArr.length) {
                return stringBuffer;
            }
            Matcher matcher = matcherArr[i];
            matcher.reset(stringBuffer);
            while (matcher.find()) {
                if (stringBuffer2 == null) {
                    stringBuffer2 = new StringBuffer();
                }
                matcher.appendReplacement(stringBuffer2, this._toPackageNames[i]);
            }
            if (stringBuffer2 != null) {
                matcher.appendTail(stringBuffer2);
                stringBuffer = stringBuffer2;
                stringBuffer2 = null;
            }
            i++;
        }
    }

    public List getFromPackages() {
        return this._fromPackages;
    }

    public List getToPackages() {
        return this._toPackages;
    }

    public static ArrayList splitPath(String str, char c) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int indexOf = str.indexOf(c);
            if (indexOf < 0) {
                break;
            }
            arrayList.add(str.substring(0, indexOf));
            str = str.substring(indexOf + 1);
        }
        if (str.length() > 0) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static String dirForPath(String str) {
        return new File(str).getParent();
    }
}
