package io.netty.handler.codec.compression;

import androidx.core.app.FrameMetricsAggregator;
import org.apache.commons.net.bsd.RCommandClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.nntp.NNTPReply;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.telnet.TelnetCommand;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.usermodel.HSSFShapeTypes;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
final class Bzip2Rand {
    private static final int[] RNUMS = {619, 720, 127, 481, 931, 816, 813, UnknownRecord.BITMAP_00E9, 566, TelnetCommand.EC, 985, 724, NNTPReply.CLOSING_CONNECTION, 454, 863, 491, 741, 242, 949, 214, 733, 859, 335, 708, 621, 574, 73, 654, 730, 472, 419, NNTPReply.TRANSFER_FAILED, 278, 496, 867, 210, 399, 680, NNTPReply.AUTHENTICATION_REQUIRED, 51, 878, 465, 811, 169, 869, 675, 611, 697, 867, 561, 862, 687, 507, 283, NNTPReply.AUTHENTICATION_REJECTED, 129, 807, 591, 733, 623, 150, TelnetCommand.ABORT, 59, 379, 684, 877, 625, 169, 643, 105, 170, 607, 520, 932, 727, 476, 693, FTPReply.CANNOT_OPEN_DATA_CONNECTION, 174, 647, 73, 122, 335, FTPReply.NOT_LOGGED_IN, UnknownRecord.CODENAME_1BA, 853, 695, TelnetCommand.GA, 445, 515, 909, 545, IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH, 919, 874, 474, 882, 500, 594, 612, 641, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, 220, 162, 819, 984, 589, 513, 495, 799, 161, 604, 958, FTPReply.DENIED_FOR_POLICY_REASONS, 221, NNTPReply.SERVICE_DISCONTINUED, 386, 867, IjkMediaCodecInfo.RANK_LAST_CHANCE, 782, 382, 596, 414, 171, 516, 375, 682, 485, 911, 276, 98, 553, 163, SMTPReply.START_MAIL_INPUT, 666, 933, 424, 341, FTPReply.DENIED_FOR_POLICY_REASONS, 870, FTPReply.ENTERING_PASSIVE_MODE, 730, 475, 186, 263, 647, 537, 686, IjkMediaCodecInfo.RANK_LAST_CHANCE, 224, 469, 68, 770, 919, 190, 373, 294, 822, 808, 206, 184, 943, 795, 384, 383, 461, 404, 758, 839, 887, 715, 67, 618, 276, 204, 918, 873, 777, 604, 560, 951, 160, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 722, 79, 804, 96, 409, 713, 940, 652, 934, 970, 447, 318, 353, 859, 672, 112, 785, 645, 863, 803, FTPReply.FILE_ACTION_PENDING, 139, 93, SMTPReply.START_MAIL_INPUT, 99, 820, 908, 609, 772, 154, 274, 580, 184, 79, 626, 630, 742, 653, 282, 762, 623, 680, 81, 927, 626, 789, 125, NNTPReply.NO_SUCH_NEWSGROUP, 521, 938, 300, 821, 78, 343, 175, 128, 250, 170, 774, 972, 275, 999, 639, 495, 78, 352, 126, 857, 956, 358, 619, 580, 124, 737, 594, 701, 612, 669, 112, 134, 694, 363, 992, 809, 743, 168, 974, 944, 375, 748, 52, IjkMediaCodecInfo.RANK_LAST_CHANCE, 747, 642, 182, 862, 81, 344, 805, 988, 739, FrameMetricsAggregator.EVERY_DURATION, 655, 814, FTPReply.SECURITY_MECHANISM_IS_OK, TelnetCommand.GA, 515, 897, 955, 664, 981, 649, 113, 974, 459, 893, 228, 433, 837, 553, 268, 926, 240, 102, 654, 459, 51, 686, 754, 806, 760, 493, 403, 415, 394, 687, 700, 946, 670, 656, 610, 738, 392, 760, 799, 887, 653, 978, 321, 576, 617, 626, 502, 894, 679, TelnetCommand.BREAK, NNTPReply.POSTING_NOT_ALLOWED, 680, 879, HSSFShapeTypes.ActionButtonBackPrevious, 572, 640, 724, 926, 56, 204, 700, 707, 151, 457, 449, 797, HSSFShapeTypes.ActionButtonEnd, 791, 558, 945, 679, 297, 59, 87, 824, 713, 663, NNTPReply.NO_NEWSGROUP_SELECTED, 693, 342, 606, 134, 108, 571, 364, 631, FTPReply.DIRECTORY_STATUS, 174, 643, 304, 329, 343, 97, NNTPReply.NO_SUCH_ARTICLE_FOUND, 751, 497, 314, 983, 374, 822, 928, 140, 206, 73, 263, 980, 736, 876, 478, NNTPReply.NO_SUCH_ARTICLE_FOUND, 305, 170, RCommandClient.DEFAULT_PORT, 364, 692, 829, 82, 855, 953, 676, TelnetCommand.AYT, 369, 970, 294, 750, 807, 827, 150, 790, 288, 923, 804, 378, FTPReply.NAME_SYSTEM_TYPE, 828, 592, NNTPReply.AUTHENTICATION_ACCEPTED, 565, 555, 710, 82, 896, 831, 547, 261, 524, 462, 293, 465, 502, 56, 661, 821, 976, 991, 658, 869, 905, 758, 745, 193, 768, 550, 608, 933, 378, 286, FTPReply.NAME_SYSTEM_TYPE, 979, 792, 961, 61, 688, 793, 644, 986, 403, 106, 366, 905, 644, 372, 567, 466, 434, 645, 210, 389, 550, 919, 135, 780, 773, 635, 389, 707, 100, 626, 958, 165, 504, 920, 176, 193, 713, 857, 265, 203, 50, 668, 108, 645, FTPSClient.DEFAULT_FTPS_PORT, 626, HSSFShapeTypes.ActionButtonReturn, 510, 357, 358, 850, 858, 364, 936, 638};

    static int rNums(int i) {
        return RNUMS[i];
    }

    private Bzip2Rand() {
    }
}
