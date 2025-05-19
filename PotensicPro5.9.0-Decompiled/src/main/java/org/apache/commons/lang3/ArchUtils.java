package org.apache.commons.lang3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.apache.commons.lang3.arch.Processor;

/* loaded from: classes4.dex */
public class ArchUtils {
    private static final Map<String, Processor> ARCH_TO_PROCESSOR = new HashMap();

    static {
        init();
    }

    private static void init() {
        init_X86_32Bit();
        init_X86_64Bit();
        init_IA64_32Bit();
        init_IA64_64Bit();
        init_PPC_32Bit();
        init_PPC_64Bit();
    }

    private static void init_X86_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.X86), "x86", "i386", "i486", "i586", "i686", "pentium");
    }

    private static void init_X86_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.X86), "x86_64", "amd64", "em64t", "universal");
    }

    private static void init_IA64_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64), "ia64_32", "ia64n");
    }

    private static void init_IA64_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64), "ia64", "ia64w");
    }

    private static void init_PPC_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.PPC), "ppc", "power", "powerpc", "power_pc", "power_rs");
    }

    private static void init_PPC_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.PPC), "ppc64", "power64", "powerpc64", "power_pc64", "power_rs64");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addProcessor(String str, Processor processor) {
        Map<String, Processor> map = ARCH_TO_PROCESSOR;
        if (map.containsKey(str)) {
            throw new IllegalStateException("Key " + str + " already exists in processor map");
        }
        map.put(str, processor);
    }

    private static void addProcessors(final Processor processor, String... strArr) {
        Stream.of((Object[]) strArr).forEach(new Consumer() { // from class: org.apache.commons.lang3.-$$Lambda$ArchUtils$GU7PuivOKi6_z_1oqZeauKxL3bY
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ArchUtils.addProcessor((String) obj, Processor.this);
            }
        });
    }

    public static Processor getProcessor() {
        return getProcessor(SystemUtils.OS_ARCH);
    }

    public static Processor getProcessor(String str) {
        return ARCH_TO_PROCESSOR.get(str);
    }
}
