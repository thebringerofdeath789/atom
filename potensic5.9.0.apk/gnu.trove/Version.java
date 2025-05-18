package gnu.trove;

/* loaded from: classes3.dex */
public class Version {
    public static void main(String[] strArr) {
        System.out.println(getVersion());
    }

    public static String getVersion() {
        String implementationVersion = Version.class.getPackage().getImplementationVersion();
        return implementationVersion != null ? "trove4j version " + implementationVersion : "Sorry no Implementation-Version manifest attribute available";
    }
}