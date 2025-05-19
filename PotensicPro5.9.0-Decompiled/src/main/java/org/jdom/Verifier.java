package org.jdom;

import java.util.Iterator;
import java.util.List;
import okio.Utf8;

/* loaded from: classes5.dex */
public final class Verifier {
    private static final String CVS_ID = "@(#) $RCSfile: Verifier.java,v $ $Revision: 1.51 $ $Date: 2004/08/31 21:58:55 $ $Name: jdom_1_0 $";

    public static boolean isHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'F') {
            return c >= 'a' && c <= 'f';
        }
        return true;
    }

    public static boolean isURICharacter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c < 'A' || c > 'Z') {
            return (c >= '0' && c <= '9') || c == '/' || c == '-' || c == '.' || c == '?' || c == ':' || c == '@' || c == '&' || c == '=' || c == '+' || c == '$' || c == ',' || c == '%' || c == '_' || c == '!' || c == '~' || c == '*' || c == '\'' || c == '(' || c == ')';
        }
        return true;
    }

    public static boolean isXMLCharacter(int i) {
        if (i == 10 || i == 13 || i == 9) {
            return true;
        }
        if (i < 32) {
            return false;
        }
        if (i <= 55295) {
            return true;
        }
        if (i < 57344) {
            return false;
        }
        if (i <= 65533) {
            return true;
        }
        return i >= 65536 && i <= 1114111;
    }

    public static boolean isXMLCombiningChar(char c) {
        if (c < 768) {
            return false;
        }
        if (c <= 837) {
            return true;
        }
        if (c < 864) {
            return false;
        }
        if (c <= 865) {
            return true;
        }
        if (c < 1155) {
            return false;
        }
        if (c <= 1158) {
            return true;
        }
        if (c < 1425) {
            return false;
        }
        if (c <= 1441) {
            return true;
        }
        if (c < 1443) {
            return false;
        }
        if (c <= 1465) {
            return true;
        }
        if (c < 1467) {
            return false;
        }
        if (c <= 1469 || c == 1471) {
            return true;
        }
        if (c < 1473) {
            return false;
        }
        if (c <= 1474 || c == 1476) {
            return true;
        }
        if (c < 1611) {
            return false;
        }
        if (c <= 1618 || c == 1648) {
            return true;
        }
        if (c < 1750) {
            return false;
        }
        if (c <= 1756) {
            return true;
        }
        if (c < 1757) {
            return false;
        }
        if (c <= 1759) {
            return true;
        }
        if (c < 1760) {
            return false;
        }
        if (c <= 1764) {
            return true;
        }
        if (c < 1767) {
            return false;
        }
        if (c <= 1768) {
            return true;
        }
        if (c < 1770) {
            return false;
        }
        if (c <= 1773) {
            return true;
        }
        if (c < 2305) {
            return false;
        }
        if (c <= 2307 || c == 2364) {
            return true;
        }
        if (c < 2366) {
            return false;
        }
        if (c <= 2380 || c == 2381) {
            return true;
        }
        if (c < 2385) {
            return false;
        }
        if (c <= 2388) {
            return true;
        }
        if (c < 2402) {
            return false;
        }
        if (c <= 2403) {
            return true;
        }
        if (c < 2433) {
            return false;
        }
        if (c <= 2435 || c == 2492 || c == 2494 || c == 2495) {
            return true;
        }
        if (c < 2496) {
            return false;
        }
        if (c <= 2500) {
            return true;
        }
        if (c < 2503) {
            return false;
        }
        if (c <= 2504) {
            return true;
        }
        if (c < 2507) {
            return false;
        }
        if (c <= 2509 || c == 2519) {
            return true;
        }
        if (c < 2530) {
            return false;
        }
        if (c <= 2531 || c == 2562 || c == 2620 || c == 2622 || c == 2623) {
            return true;
        }
        if (c < 2624) {
            return false;
        }
        if (c <= 2626) {
            return true;
        }
        if (c < 2631) {
            return false;
        }
        if (c <= 2632) {
            return true;
        }
        if (c < 2635) {
            return false;
        }
        if (c <= 2637) {
            return true;
        }
        if (c < 2672) {
            return false;
        }
        if (c <= 2673) {
            return true;
        }
        if (c < 2689) {
            return false;
        }
        if (c <= 2691 || c == 2748) {
            return true;
        }
        if (c < 2750) {
            return false;
        }
        if (c <= 2757) {
            return true;
        }
        if (c < 2759) {
            return false;
        }
        if (c <= 2761) {
            return true;
        }
        if (c < 2763) {
            return false;
        }
        if (c <= 2765) {
            return true;
        }
        if (c < 2817) {
            return false;
        }
        if (c <= 2819 || c == 2876) {
            return true;
        }
        if (c < 2878) {
            return false;
        }
        if (c <= 2883) {
            return true;
        }
        if (c < 2887) {
            return false;
        }
        if (c <= 2888) {
            return true;
        }
        if (c < 2891) {
            return false;
        }
        if (c <= 2893) {
            return true;
        }
        if (c < 2902) {
            return false;
        }
        if (c <= 2903) {
            return true;
        }
        if (c < 2946) {
            return false;
        }
        if (c <= 2947) {
            return true;
        }
        if (c < 3006) {
            return false;
        }
        if (c <= 3010) {
            return true;
        }
        if (c < 3014) {
            return false;
        }
        if (c <= 3016) {
            return true;
        }
        if (c < 3018) {
            return false;
        }
        if (c <= 3021 || c == 3031) {
            return true;
        }
        if (c < 3073) {
            return false;
        }
        if (c <= 3075) {
            return true;
        }
        if (c < 3134) {
            return false;
        }
        if (c <= 3140) {
            return true;
        }
        if (c < 3142) {
            return false;
        }
        if (c <= 3144) {
            return true;
        }
        if (c < 3146) {
            return false;
        }
        if (c <= 3149) {
            return true;
        }
        if (c < 3157) {
            return false;
        }
        if (c <= 3158) {
            return true;
        }
        if (c < 3202) {
            return false;
        }
        if (c <= 3203) {
            return true;
        }
        if (c < 3262) {
            return false;
        }
        if (c <= 3268) {
            return true;
        }
        if (c < 3270) {
            return false;
        }
        if (c <= 3272) {
            return true;
        }
        if (c < 3274) {
            return false;
        }
        if (c <= 3277) {
            return true;
        }
        if (c < 3285) {
            return false;
        }
        if (c <= 3286) {
            return true;
        }
        if (c < 3330) {
            return false;
        }
        if (c <= 3331) {
            return true;
        }
        if (c < 3390) {
            return false;
        }
        if (c <= 3395) {
            return true;
        }
        if (c < 3398) {
            return false;
        }
        if (c <= 3400) {
            return true;
        }
        if (c < 3402) {
            return false;
        }
        if (c <= 3405 || c == 3415 || c == 3633) {
            return true;
        }
        if (c < 3636) {
            return false;
        }
        if (c <= 3642) {
            return true;
        }
        if (c < 3655) {
            return false;
        }
        if (c <= 3662 || c == 3761) {
            return true;
        }
        if (c < 3764) {
            return false;
        }
        if (c <= 3769) {
            return true;
        }
        if (c < 3771) {
            return false;
        }
        if (c <= 3772) {
            return true;
        }
        if (c < 3784) {
            return false;
        }
        if (c <= 3789) {
            return true;
        }
        if (c < 3864) {
            return false;
        }
        if (c <= 3865 || c == 3893 || c == 3895 || c == 3897 || c == 3902 || c == 3903) {
            return true;
        }
        if (c < 3953) {
            return false;
        }
        if (c <= 3972) {
            return true;
        }
        if (c < 3974) {
            return false;
        }
        if (c <= 3979) {
            return true;
        }
        if (c < 3984) {
            return false;
        }
        if (c <= 3989 || c == 3991) {
            return true;
        }
        if (c < 3993) {
            return false;
        }
        if (c <= 4013) {
            return true;
        }
        if (c < 4017) {
            return false;
        }
        if (c <= 4023 || c == 4025) {
            return true;
        }
        if (c < 8400) {
            return false;
        }
        if (c <= 8412 || c == 8417) {
            return true;
        }
        if (c < 12330) {
            return false;
        }
        return c <= 12335 || c == 12441 || c == 12442;
    }

    public static boolean isXMLDigit(char c) {
        if (c < '0') {
            return false;
        }
        if (c <= '9') {
            return true;
        }
        if (c < 1632) {
            return false;
        }
        if (c <= 1641) {
            return true;
        }
        if (c < 1776) {
            return false;
        }
        if (c <= 1785) {
            return true;
        }
        if (c < 2406) {
            return false;
        }
        if (c <= 2415) {
            return true;
        }
        if (c < 2534) {
            return false;
        }
        if (c <= 2543) {
            return true;
        }
        if (c < 2662) {
            return false;
        }
        if (c <= 2671) {
            return true;
        }
        if (c < 2790) {
            return false;
        }
        if (c <= 2799) {
            return true;
        }
        if (c < 2918) {
            return false;
        }
        if (c <= 2927) {
            return true;
        }
        if (c < 3047) {
            return false;
        }
        if (c <= 3055) {
            return true;
        }
        if (c < 3174) {
            return false;
        }
        if (c <= 3183) {
            return true;
        }
        if (c < 3302) {
            return false;
        }
        if (c <= 3311) {
            return true;
        }
        if (c < 3430) {
            return false;
        }
        if (c <= 3439) {
            return true;
        }
        if (c < 3664) {
            return false;
        }
        if (c <= 3673) {
            return true;
        }
        if (c < 3792) {
            return false;
        }
        if (c <= 3801) {
            return true;
        }
        return c >= 3872 && c <= 3881;
    }

    public static boolean isXMLExtender(char c) {
        if (c < 182) {
            return false;
        }
        if (c == 183 || c == 720 || c == 721 || c == 903 || c == 1600 || c == 3654 || c == 3782 || c == 12293) {
            return true;
        }
        if (c < 12337) {
            return false;
        }
        if (c <= 12341) {
            return true;
        }
        if (c < 12445) {
            return false;
        }
        if (c <= 12446) {
            return true;
        }
        return c >= 12540 && c <= 12542;
    }

    public static boolean isXMLLetter(char c) {
        if (c < 'A') {
            return false;
        }
        if (c <= 'Z') {
            return true;
        }
        if (c < 'a') {
            return false;
        }
        if (c <= 'z') {
            return true;
        }
        if (c < 192) {
            return false;
        }
        if (c <= 214) {
            return true;
        }
        if (c < 216) {
            return false;
        }
        if (c <= 246) {
            return true;
        }
        if (c < 248) {
            return false;
        }
        if (c <= 255) {
            return true;
        }
        if (c < 256) {
            return false;
        }
        if (c <= 305) {
            return true;
        }
        if (c < 308) {
            return false;
        }
        if (c <= 318) {
            return true;
        }
        if (c < 321) {
            return false;
        }
        if (c <= 328) {
            return true;
        }
        if (c < 330) {
            return false;
        }
        if (c <= 382) {
            return true;
        }
        if (c < 384) {
            return false;
        }
        if (c <= 451) {
            return true;
        }
        if (c < 461) {
            return false;
        }
        if (c <= 496) {
            return true;
        }
        if (c < 500) {
            return false;
        }
        if (c <= 501) {
            return true;
        }
        if (c < 506) {
            return false;
        }
        if (c <= 535) {
            return true;
        }
        if (c < 592) {
            return false;
        }
        if (c <= 680) {
            return true;
        }
        if (c < 699) {
            return false;
        }
        if (c <= 705 || c == 902) {
            return true;
        }
        if (c < 904) {
            return false;
        }
        if (c <= 906 || c == 908) {
            return true;
        }
        if (c < 910) {
            return false;
        }
        if (c <= 929) {
            return true;
        }
        if (c < 931) {
            return false;
        }
        if (c <= 974) {
            return true;
        }
        if (c < 976) {
            return false;
        }
        if (c <= 982 || c == 986 || c == 988 || c == 990 || c == 992) {
            return true;
        }
        if (c < 994) {
            return false;
        }
        if (c <= 1011) {
            return true;
        }
        if (c < 1025) {
            return false;
        }
        if (c <= 1036) {
            return true;
        }
        if (c < 1038) {
            return false;
        }
        if (c <= 1103) {
            return true;
        }
        if (c < 1105) {
            return false;
        }
        if (c <= 1116) {
            return true;
        }
        if (c < 1118) {
            return false;
        }
        if (c <= 1153) {
            return true;
        }
        if (c < 1168) {
            return false;
        }
        if (c <= 1220) {
            return true;
        }
        if (c < 1223) {
            return false;
        }
        if (c <= 1224) {
            return true;
        }
        if (c < 1227) {
            return false;
        }
        if (c <= 1228) {
            return true;
        }
        if (c < 1232) {
            return false;
        }
        if (c <= 1259) {
            return true;
        }
        if (c < 1262) {
            return false;
        }
        if (c <= 1269) {
            return true;
        }
        if (c < 1272) {
            return false;
        }
        if (c <= 1273) {
            return true;
        }
        if (c < 1329) {
            return false;
        }
        if (c <= 1366 || c == 1369) {
            return true;
        }
        if (c < 1377) {
            return false;
        }
        if (c <= 1414) {
            return true;
        }
        if (c < 1488) {
            return false;
        }
        if (c <= 1514) {
            return true;
        }
        if (c < 1520) {
            return false;
        }
        if (c <= 1522) {
            return true;
        }
        if (c < 1569) {
            return false;
        }
        if (c <= 1594) {
            return true;
        }
        if (c < 1601) {
            return false;
        }
        if (c <= 1610) {
            return true;
        }
        if (c < 1649) {
            return false;
        }
        if (c <= 1719) {
            return true;
        }
        if (c < 1722) {
            return false;
        }
        if (c <= 1726) {
            return true;
        }
        if (c < 1728) {
            return false;
        }
        if (c <= 1742) {
            return true;
        }
        if (c < 1744) {
            return false;
        }
        if (c <= 1747 || c == 1749) {
            return true;
        }
        if (c < 1765) {
            return false;
        }
        if (c <= 1766) {
            return true;
        }
        if (c < 2309) {
            return false;
        }
        if (c <= 2361 || c == 2365) {
            return true;
        }
        if (c < 2392) {
            return false;
        }
        if (c <= 2401) {
            return true;
        }
        if (c < 2437) {
            return false;
        }
        if (c <= 2444) {
            return true;
        }
        if (c < 2447) {
            return false;
        }
        if (c <= 2448) {
            return true;
        }
        if (c < 2451) {
            return false;
        }
        if (c <= 2472) {
            return true;
        }
        if (c < 2474) {
            return false;
        }
        if (c <= 2480 || c == 2482) {
            return true;
        }
        if (c < 2486) {
            return false;
        }
        if (c <= 2489) {
            return true;
        }
        if (c < 2524) {
            return false;
        }
        if (c <= 2525) {
            return true;
        }
        if (c < 2527) {
            return false;
        }
        if (c <= 2529) {
            return true;
        }
        if (c < 2544) {
            return false;
        }
        if (c <= 2545) {
            return true;
        }
        if (c < 2565) {
            return false;
        }
        if (c <= 2570) {
            return true;
        }
        if (c < 2575) {
            return false;
        }
        if (c <= 2576) {
            return true;
        }
        if (c < 2579) {
            return false;
        }
        if (c <= 2600) {
            return true;
        }
        if (c < 2602) {
            return false;
        }
        if (c <= 2608) {
            return true;
        }
        if (c < 2610) {
            return false;
        }
        if (c <= 2611) {
            return true;
        }
        if (c < 2613) {
            return false;
        }
        if (c <= 2614) {
            return true;
        }
        if (c < 2616) {
            return false;
        }
        if (c <= 2617) {
            return true;
        }
        if (c < 2649) {
            return false;
        }
        if (c <= 2652 || c == 2654) {
            return true;
        }
        if (c < 2674) {
            return false;
        }
        if (c <= 2676) {
            return true;
        }
        if (c < 2693) {
            return false;
        }
        if (c <= 2699 || c == 2701) {
            return true;
        }
        if (c < 2703) {
            return false;
        }
        if (c <= 2705) {
            return true;
        }
        if (c < 2707) {
            return false;
        }
        if (c <= 2728) {
            return true;
        }
        if (c < 2730) {
            return false;
        }
        if (c <= 2736) {
            return true;
        }
        if (c < 2738) {
            return false;
        }
        if (c <= 2739) {
            return true;
        }
        if (c < 2741) {
            return false;
        }
        if (c <= 2745 || c == 2749 || c == 2784) {
            return true;
        }
        if (c < 2821) {
            return false;
        }
        if (c <= 2828) {
            return true;
        }
        if (c < 2831) {
            return false;
        }
        if (c <= 2832) {
            return true;
        }
        if (c < 2835) {
            return false;
        }
        if (c <= 2856) {
            return true;
        }
        if (c < 2858) {
            return false;
        }
        if (c <= 2864) {
            return true;
        }
        if (c < 2866) {
            return false;
        }
        if (c <= 2867) {
            return true;
        }
        if (c < 2870) {
            return false;
        }
        if (c <= 2873 || c == 2877) {
            return true;
        }
        if (c < 2908) {
            return false;
        }
        if (c <= 2909) {
            return true;
        }
        if (c < 2911) {
            return false;
        }
        if (c <= 2913) {
            return true;
        }
        if (c < 2949) {
            return false;
        }
        if (c <= 2954) {
            return true;
        }
        if (c < 2958) {
            return false;
        }
        if (c <= 2960) {
            return true;
        }
        if (c < 2962) {
            return false;
        }
        if (c <= 2965) {
            return true;
        }
        if (c < 2969) {
            return false;
        }
        if (c <= 2970 || c == 2972) {
            return true;
        }
        if (c < 2974) {
            return false;
        }
        if (c <= 2975) {
            return true;
        }
        if (c < 2979) {
            return false;
        }
        if (c <= 2980) {
            return true;
        }
        if (c < 2984) {
            return false;
        }
        if (c <= 2986) {
            return true;
        }
        if (c < 2990) {
            return false;
        }
        if (c <= 2997) {
            return true;
        }
        if (c < 2999) {
            return false;
        }
        if (c <= 3001) {
            return true;
        }
        if (c < 3077) {
            return false;
        }
        if (c <= 3084) {
            return true;
        }
        if (c < 3086) {
            return false;
        }
        if (c <= 3088) {
            return true;
        }
        if (c < 3090) {
            return false;
        }
        if (c <= 3112) {
            return true;
        }
        if (c < 3114) {
            return false;
        }
        if (c <= 3123) {
            return true;
        }
        if (c < 3125) {
            return false;
        }
        if (c <= 3129) {
            return true;
        }
        if (c < 3168) {
            return false;
        }
        if (c <= 3169) {
            return true;
        }
        if (c < 3205) {
            return false;
        }
        if (c <= 3212) {
            return true;
        }
        if (c < 3214) {
            return false;
        }
        if (c <= 3216) {
            return true;
        }
        if (c < 3218) {
            return false;
        }
        if (c <= 3240) {
            return true;
        }
        if (c < 3242) {
            return false;
        }
        if (c <= 3251) {
            return true;
        }
        if (c < 3253) {
            return false;
        }
        if (c <= 3257 || c == 3294) {
            return true;
        }
        if (c < 3296) {
            return false;
        }
        if (c <= 3297) {
            return true;
        }
        if (c < 3333) {
            return false;
        }
        if (c <= 3340) {
            return true;
        }
        if (c < 3342) {
            return false;
        }
        if (c <= 3344) {
            return true;
        }
        if (c < 3346) {
            return false;
        }
        if (c <= 3368) {
            return true;
        }
        if (c < 3370) {
            return false;
        }
        if (c <= 3385) {
            return true;
        }
        if (c < 3424) {
            return false;
        }
        if (c <= 3425) {
            return true;
        }
        if (c < 3585) {
            return false;
        }
        if (c <= 3630 || c == 3632) {
            return true;
        }
        if (c < 3634) {
            return false;
        }
        if (c <= 3635) {
            return true;
        }
        if (c < 3648) {
            return false;
        }
        if (c <= 3653) {
            return true;
        }
        if (c < 3713) {
            return false;
        }
        if (c <= 3714 || c == 3716) {
            return true;
        }
        if (c < 3719) {
            return false;
        }
        if (c <= 3720 || c == 3722 || c == 3725) {
            return true;
        }
        if (c < 3732) {
            return false;
        }
        if (c <= 3735) {
            return true;
        }
        if (c < 3737) {
            return false;
        }
        if (c <= 3743) {
            return true;
        }
        if (c < 3745) {
            return false;
        }
        if (c <= 3747 || c == 3749 || c == 3751) {
            return true;
        }
        if (c < 3754) {
            return false;
        }
        if (c <= 3755) {
            return true;
        }
        if (c < 3757) {
            return false;
        }
        if (c <= 3758 || c == 3760) {
            return true;
        }
        if (c < 3762) {
            return false;
        }
        if (c <= 3763 || c == 3773) {
            return true;
        }
        if (c < 3776) {
            return false;
        }
        if (c <= 3780) {
            return true;
        }
        if (c < 3904) {
            return false;
        }
        if (c <= 3911) {
            return true;
        }
        if (c < 3913) {
            return false;
        }
        if (c <= 3945) {
            return true;
        }
        if (c < 4256) {
            return false;
        }
        if (c <= 4293) {
            return true;
        }
        if (c < 4304) {
            return false;
        }
        if (c <= 4342 || c == 4352) {
            return true;
        }
        if (c < 4354) {
            return false;
        }
        if (c <= 4355) {
            return true;
        }
        if (c < 4357) {
            return false;
        }
        if (c <= 4359 || c == 4361) {
            return true;
        }
        if (c < 4363) {
            return false;
        }
        if (c <= 4364) {
            return true;
        }
        if (c < 4366) {
            return false;
        }
        if (c <= 4370 || c == 4412 || c == 4414 || c == 4416 || c == 4428 || c == 4430 || c == 4432) {
            return true;
        }
        if (c < 4436) {
            return false;
        }
        if (c <= 4437 || c == 4441) {
            return true;
        }
        if (c < 4447) {
            return false;
        }
        if (c <= 4449 || c == 4451 || c == 4453 || c == 4455 || c == 4457) {
            return true;
        }
        if (c < 4461) {
            return false;
        }
        if (c <= 4462) {
            return true;
        }
        if (c < 4466) {
            return false;
        }
        if (c <= 4467 || c == 4469 || c == 4510 || c == 4520 || c == 4523) {
            return true;
        }
        if (c < 4526) {
            return false;
        }
        if (c <= 4527) {
            return true;
        }
        if (c < 4535) {
            return false;
        }
        if (c <= 4536 || c == 4538) {
            return true;
        }
        if (c < 4540) {
            return false;
        }
        if (c <= 4546 || c == 4587 || c == 4592 || c == 4601) {
            return true;
        }
        if (c < 7680) {
            return false;
        }
        if (c <= 7835) {
            return true;
        }
        if (c < 7840) {
            return false;
        }
        if (c <= 7929) {
            return true;
        }
        if (c < 7936) {
            return false;
        }
        if (c <= 7957) {
            return true;
        }
        if (c < 7960) {
            return false;
        }
        if (c <= 7965) {
            return true;
        }
        if (c < 7968) {
            return false;
        }
        if (c <= 8005) {
            return true;
        }
        if (c < 8008) {
            return false;
        }
        if (c <= 8013) {
            return true;
        }
        if (c < 8016) {
            return false;
        }
        if (c <= 8023 || c == 8025 || c == 8027 || c == 8029) {
            return true;
        }
        if (c < 8031) {
            return false;
        }
        if (c <= 8061) {
            return true;
        }
        if (c < 8064) {
            return false;
        }
        if (c <= 8116) {
            return true;
        }
        if (c < 8118) {
            return false;
        }
        if (c <= 8124 || c == 8126) {
            return true;
        }
        if (c < 8130) {
            return false;
        }
        if (c <= 8132) {
            return true;
        }
        if (c < 8134) {
            return false;
        }
        if (c <= 8140) {
            return true;
        }
        if (c < 8144) {
            return false;
        }
        if (c <= 8147) {
            return true;
        }
        if (c < 8150) {
            return false;
        }
        if (c <= 8155) {
            return true;
        }
        if (c < 8160) {
            return false;
        }
        if (c <= 8172) {
            return true;
        }
        if (c < 8178) {
            return false;
        }
        if (c <= 8180) {
            return true;
        }
        if (c < 8182) {
            return false;
        }
        if (c <= 8188 || c == 8486) {
            return true;
        }
        if (c < 8490) {
            return false;
        }
        if (c <= 8491 || c == 8494) {
            return true;
        }
        if (c < 8576) {
            return false;
        }
        if (c <= 8578 || c == 12295) {
            return true;
        }
        if (c < 12321) {
            return false;
        }
        if (c <= 12329) {
            return true;
        }
        if (c < 12353) {
            return false;
        }
        if (c <= 12436) {
            return true;
        }
        if (c < 12449) {
            return false;
        }
        if (c <= 12538) {
            return true;
        }
        if (c < 12549) {
            return false;
        }
        if (c <= 12588) {
            return true;
        }
        if (c < 19968) {
            return false;
        }
        if (c <= 40869) {
            return true;
        }
        return c >= 44032 && c <= 55203;
    }

    public static boolean isXMLPublicIDCharacter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c < '?' || c > 'Z') {
            return (c >= '\'' && c <= ';') || c == ' ' || c == '!' || c == '=' || c == '#' || c == '$' || c == '_' || c == '%' || c == '\n' || c == '\r' || c == '\t';
        }
        return true;
    }

    private Verifier() {
    }

    public static String checkElementName(String str) {
        String checkXMLName = checkXMLName(str);
        if (checkXMLName != null) {
            return checkXMLName;
        }
        if (str.indexOf(":") != -1) {
            return "Element names cannot contain colons";
        }
        return null;
    }

    public static String checkAttributeName(String str) {
        String checkXMLName = checkXMLName(str);
        if (checkXMLName != null) {
            return checkXMLName;
        }
        if (str.indexOf(":") != -1) {
            return "Attribute names cannot contain colons";
        }
        if (str.equals("xmlns")) {
            return "An Attribute name may not be \"xmlns\"; use the Namespace class to manage namespaces";
        }
        return null;
    }

    public static String checkCharacterData(String str) {
        if (str == null) {
            return "A null is not a legal XML value";
        }
        int i = 0;
        int length = str.length();
        while (i < length) {
            int charAt = str.charAt(i);
            if (charAt >= 55296 && charAt <= 56319) {
                i++;
                if (i >= length) {
                    return "Surrogate Pair Truncated";
                }
                char charAt2 = str.charAt(i);
                if (charAt2 < 56320 || charAt2 > 57343) {
                    return "Illegal Surrogate Pair";
                }
                charAt = ((charAt - 55296) * 1024) + 65536 + (charAt2 - Utf8.LOG_SURROGATE_HEADER);
            }
            if (!isXMLCharacter(charAt)) {
                return new StringBuffer("0x").append(Integer.toHexString(charAt)).append(" is not a legal XML character").toString();
            }
            i++;
        }
        return null;
    }

    public static String checkCDATASection(String str) {
        String checkCharacterData = checkCharacterData(str);
        if (checkCharacterData != null) {
            return checkCharacterData;
        }
        if (str.indexOf("]]>") != -1) {
            return "CDATA cannot internally contain a CDATA ending delimiter (]]>)";
        }
        return null;
    }

    public static String checkNamespacePrefix(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        char charAt = str.charAt(0);
        if (isXMLDigit(charAt)) {
            return "Namespace prefixes cannot begin with a number";
        }
        if (charAt == '$') {
            return "Namespace prefixes cannot begin with a dollar sign ($)";
        }
        if (charAt == '-') {
            return "Namespace prefixes cannot begin with a hyphen (-)";
        }
        if (charAt == '.') {
            return "Namespace prefixes cannot begin with a period (.)";
        }
        if (str.toLowerCase().startsWith("xml")) {
            return "Namespace prefixes cannot begin with \"xml\" in any combination of case";
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt2 = str.charAt(i);
            if (!isXMLNameCharacter(charAt2)) {
                return new StringBuffer("Namespace prefixes cannot contain the character \"").append(charAt2).append("\"").toString();
            }
        }
        if (str.indexOf(":") != -1) {
            return "Namespace prefixes cannot contain colons";
        }
        return null;
    }

    public static String checkNamespaceURI(String str) {
        if (str != null && !str.equals("")) {
            char charAt = str.charAt(0);
            if (Character.isDigit(charAt)) {
                return "Namespace URIs cannot begin with a number";
            }
            if (charAt == '$') {
                return "Namespace URIs cannot begin with a dollar sign ($)";
            }
            if (charAt == '-') {
                return "Namespace URIs cannot begin with a hyphen (-)";
            }
        }
        return null;
    }

    public static String checkNamespaceCollision(Namespace namespace, Namespace namespace2) {
        String prefix = namespace.getPrefix();
        String uri = namespace.getURI();
        String prefix2 = namespace2.getPrefix();
        String uri2 = namespace2.getURI();
        if (!prefix.equals(prefix2) || uri.equals(uri2)) {
            return null;
        }
        return new StringBuffer("The namespace prefix \"").append(prefix).append("\" collides").toString();
    }

    public static String checkNamespaceCollision(Attribute attribute, Element element) {
        Namespace namespace = attribute.getNamespace();
        if ("".equals(namespace.getPrefix())) {
            return null;
        }
        return checkNamespaceCollision(namespace, element);
    }

    public static String checkNamespaceCollision(Namespace namespace, Element element) {
        String checkNamespaceCollision = checkNamespaceCollision(namespace, element.getNamespace());
        if (checkNamespaceCollision != null) {
            return new StringBuffer(String.valueOf(checkNamespaceCollision)).append(" with the element namespace prefix").toString();
        }
        String checkNamespaceCollision2 = checkNamespaceCollision(namespace, element.getAdditionalNamespaces());
        if (checkNamespaceCollision2 != null) {
            return checkNamespaceCollision2;
        }
        String checkNamespaceCollision3 = checkNamespaceCollision(namespace, element.getAttributes());
        if (checkNamespaceCollision3 != null) {
            return checkNamespaceCollision3;
        }
        return null;
    }

    public static String checkNamespaceCollision(Namespace namespace, Attribute attribute) {
        String checkNamespaceCollision = checkNamespaceCollision(namespace, attribute.getNamespace());
        return checkNamespaceCollision != null ? new StringBuffer(String.valueOf(checkNamespaceCollision)).append(" with an attribute namespace prefix on the element").toString() : checkNamespaceCollision;
    }

    public static String checkNamespaceCollision(Namespace namespace, List list) {
        String str = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (str == null && it.hasNext()) {
            Object next = it.next();
            if (next instanceof Attribute) {
                str = checkNamespaceCollision(namespace, (Attribute) next);
            } else if (next instanceof Element) {
                str = checkNamespaceCollision(namespace, (Element) next);
            } else if ((next instanceof Namespace) && (str = checkNamespaceCollision(namespace, (Namespace) next)) != null) {
                str = new StringBuffer(String.valueOf(str)).append(" with an additional namespace declared by the element").toString();
            }
        }
        return str;
    }

    public static String checkProcessingInstructionTarget(String str) {
        String checkXMLName = checkXMLName(str);
        if (checkXMLName != null) {
            return checkXMLName;
        }
        if (str.indexOf(":") != -1) {
            return "Processing instruction targets cannot contain colons";
        }
        if (str.equalsIgnoreCase("xml")) {
            return "Processing instructions cannot have a target of \"xml\" in any combination of case. (Note that the \"<?xml ... ?>\" declaration at the beginning of a document is not a processing instruction and should not be added as one; it is written automatically during output, e.g. by XMLOutputter.)";
        }
        return null;
    }

    public static String checkProcessingInstructionData(String str) {
        String checkCharacterData = checkCharacterData(str);
        return (checkCharacterData != null || str.indexOf("?>") < 0) ? checkCharacterData : "Processing instructions cannot contain the string \"?>\"";
    }

    public static String checkCommentData(String str) {
        String checkCharacterData = checkCharacterData(str);
        if (checkCharacterData != null) {
            return checkCharacterData;
        }
        if (str.indexOf("--") != -1) {
            return "Comments cannot contain double hyphens (--)";
        }
        if (str.startsWith("-")) {
            return "Comment data cannot start with a hyphen.";
        }
        if (str.endsWith("-")) {
            return "Comment data cannot end with a hyphen.";
        }
        return null;
    }

    public static String checkPublicID(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!isXMLPublicIDCharacter(charAt)) {
                return new StringBuffer(String.valueOf(charAt)).append(" is not a legal character in public IDs").toString();
            }
        }
        return null;
    }

    public static String checkSystemLiteral(String str) {
        if (str == null) {
            return null;
        }
        return (str.indexOf(39) == -1 || str.indexOf(34) == -1) ? checkCharacterData(str) : "System literals cannot simultaneously contain both single and double quotes.";
    }

    public static String checkXMLName(String str) {
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return "XML names cannot be null or empty";
        }
        char charAt = str.charAt(0);
        if (!isXMLNameStartCharacter(charAt)) {
            return new StringBuffer("XML names cannot begin with the character \"").append(charAt).append("\"").toString();
        }
        int length = str.length();
        for (int i = 1; i < length; i++) {
            char charAt2 = str.charAt(i);
            if (!isXMLNameCharacter(charAt2)) {
                return new StringBuffer("XML names cannot contain the character \"").append(charAt2).append("\"").toString();
            }
        }
        return null;
    }

    public static String checkURI(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!isURICharacter(charAt)) {
                String stringBuffer = new StringBuffer("0x").append(Integer.toHexString(charAt)).toString();
                if (charAt <= '\t') {
                    stringBuffer = new StringBuffer("0x0").append(Integer.toHexString(charAt)).toString();
                }
                return new StringBuffer("URIs cannot contain ").append(stringBuffer).toString();
            }
            if (charAt == '%') {
                try {
                    char charAt2 = str.charAt(i + 1);
                    char charAt3 = str.charAt(i + 2);
                    if (isHexDigit(charAt2) && isHexDigit(charAt3)) {
                    }
                } catch (StringIndexOutOfBoundsException unused) {
                }
                return "Percent signs in URIs must be followed by exactly two hexadecimal digits.";
            }
        }
        return null;
    }

    public static boolean isXMLNameCharacter(char c) {
        return isXMLLetter(c) || isXMLDigit(c) || c == '.' || c == '-' || c == '_' || c == ':' || isXMLCombiningChar(c) || isXMLExtender(c);
    }

    public static boolean isXMLNameStartCharacter(char c) {
        return isXMLLetter(c) || c == '_' || c == ':';
    }

    public static boolean isXMLLetterOrDigit(char c) {
        return isXMLLetter(c) || isXMLDigit(c);
    }
}
