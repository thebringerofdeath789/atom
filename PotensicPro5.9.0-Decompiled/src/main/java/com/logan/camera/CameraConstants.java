package com.logan.camera;

/* loaded from: classes2.dex */
public final class CameraConstants {
    public static final int PORT = 554;
    public static final int REQUEST_CODE_DELETE_FILE = 120;
    public static final int REQUEST_CODE_DOWNLOAD_FILE = 118;
    public static final int REQUEST_CODE_FORMAT_SD_CARD = 115;
    public static final int REQUEST_CODE_GET_CAMERA_STATUS = 103;
    public static final int REQUEST_CODE_GET_CAMERA_TIME = 107;
    public static final int REQUEST_CODE_GET_CONFIG_MENU = 123;
    public static final int REQUEST_CODE_GET_CUR_RECORD_SIZE = 111;
    public static final int REQUEST_CODE_GET_CUR_TAKE_PHOTO_SIZE = 112;
    public static final int REQUEST_CODE_GET_DEVICE_INFO = 106;
    public static final int REQUEST_CODE_GET_FILE_INFO = 119;
    public static final int REQUEST_CODE_GET_FILE_NUM = 116;
    public static final int REQUEST_CODE_GET_MEDIA_INFO = 131;
    public static final int REQUEST_CODE_GET_PHOTO_LIST = 128;
    public static final int REQUEST_CODE_GET_RECORD_EV = 126;
    public static final int REQUEST_CODE_GET_RECORD_SIZE = 121;
    public static final int REQUEST_CODE_GET_RECORD_SUPPORT_SIZE = 109;
    public static final int REQUEST_CODE_GET_SD_STATUS = 135;
    public static final int REQUEST_CODE_GET_TAKE_PHOTO_EV = 117;
    public static final int REQUEST_CODE_GET_TAKE_PHOTO_SIZE = 122;
    public static final int REQUEST_CODE_GET_TAKE_PHOTO_SUPPORT_SIZE = 110;
    public static final int REQUEST_CODE_GET_VIDEO_LIST = 127;
    public static final int REQUEST_CODE_GET_VIDEO_SEGMENT = 132;
    public static final int REQUEST_CODE_GET_VIDEO_SEGMENT_ITEM = 133;
    public static final int REQUEST_CODE_GET_WIFI_SIGNAL = 136;
    public static final int REQUEST_CODE_RESET_CAMERA = 105;
    public static final int REQUEST_CODE_SET_CAMERA_MODE = 104;
    public static final int REQUEST_CODE_SET_CAMERA_TIME = 108;
    public static final int REQUEST_CODE_SET_RECORD_EV = 124;
    public static final int REQUEST_CODE_SET_RECORD_SIZE = 113;
    public static final int REQUEST_CODE_SET_TAKE_PHOTO_EV = 125;
    public static final int REQUEST_CODE_SET_TAKE_PHOTO_SIZE = 114;
    public static final int REQUEST_CODE_SET_VIDEO_SEGMENT = 134;
    public static final int REQUEST_CODE_START_RECORD = 100;
    public static final int REQUEST_CODE_START_UPGRADE = 130;
    public static final int REQUEST_CODE_STOP_RECORD = 101;
    public static final int REQUEST_CODE_TAKE_PHOTO = 102;
    public static final int REQUEST_CODE_UPGRADE_CHECK = 129;
    public static final String URL_FORMAT_SD_CARD = "http://192.168.29.1/cgi-bin/hisnet/sdcommand.cgi?&-format";
    public static final String URL_GET_CAMERA_STATUS = "http://192.168.29.1/cgi-bin/hisnet/getworkstate.cgi?";
    public static final String URL_GET_CAMERA_TIME = "http://192.168.29.1/cgi-bin/hisnet/getsystime.cgi";
    public static final String URL_GET_CONFIG_MENU = "http://192.168.29.1/cgi-bin/hisnet/getmenu.cgi?&-act=get";
    public static final String URL_GET_CUR_RECORD_SIZE = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparam.cgi?&-workmode=NORM_REC&-type=MEDIAMODE";
    public static final String URL_GET_CUR_TAKE_PHOTO_SIZE = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparam.cgi?&-workmode=SING_PHOTO&-type=MEDIAMODE";
    public static final String URL_GET_DELETE_FILE = "http://192.168.29.1/cgi-bin/hisnet/deletefile.cgi?&-name=%s";
    public static final String URL_GET_DEVICE_INFO = "http://192.168.29.1/cgi-bin/hisnet/getdeviceattr.cgi";
    public static final String URL_GET_FILE_INFO = "http://192.168.29.1/cgi-bin/hisnet/getfileinfo.cgi?&-name=%s";
    public static final String URL_GET_FILE_NUM = "http://192.168.29.1/cgi-bin/hisnet/getfilecount.cgi";
    public static final String URL_GET_MEDIA_INFO = "http://192.168.29.1/cgi-bin/hisnet/getvideophotofileinfo.cgi?&-name=%s";
    public static final String URL_GET_PHOTO_LIST = "http://192.168.29.1/cgi-bin/hisnet/getphotofilelist.cgi?&-start=0&-end=%s";
    public static final String URL_GET_RECORD_EV = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparam.cgi?&-workmode=NORM_REC&-type=PROTUNE_EXP_EV";
    public static final String URL_GET_RECORD_SIZE = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparamcapability.cgi?&-workmode=NORM_REC&-type=MEDIAMODE";
    public static final String URL_GET_RECORD_SUPPORT_SIZE = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparamcapability.cgi?&-workmode=NORM_REC&-type=MEDIAMODE";
    public static final String URL_GET_SD_STATUS = "http://192.168.29.1/cgi-bin/hisnet/getsdstatus.cgi";
    public static final String URL_GET_TAKE_PHOTO_EV = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparam.cgi?&-workmode=SING_PHOTO&-type=PROTUNE_EXP_EV";
    public static final String URL_GET_TAKE_PHOTO_SIZE = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparamcapability.cgi?&-workmode=SING_PHOTO&-type=MEDIAMODE";
    public static final String URL_GET_TAKE_PHOTO_SUPPORT_SIZE = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparamcapability.cgi?&-workmode=SING_PHOTO&-type=MEDIAMODE";
    public static final String URL_GET_VIDEO_LIST = "http://192.168.29.1/cgi-bin/hisnet/getvideofilelist.cgi?&-start=0&-end=%s";
    public static final String URL_GET_VIDEO_SEGMENT = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparamcapability.cgi?&-workmode=NORM_REC&-type=Rec_Split_Time";
    public static final String URL_GET_VIDEO_SEGMENT_ITEM = "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparam.cgi?&-workmode=NORM_REC&-type=Rec_Split_Time";
    public static final String URL_GET_WIFI_SIGNAL = "http://192.168.29.1/cgi-bin/hisnet/getwifiStrength.cgi?";
    public static final String URL_PREVIEW = String.format("rtsp://%s:%s/livestream/12", "192.168.29.1", 554);
    public static final String URL_RESET_CAMERA = "http://192.168.29.1/cgi-bin/hisnet/reset.cgi";
    public static final String URL_SET_CAMERA_MODE = "http://192.168.29.1/cgi-bin/hisnet/setworkmode.cgi?-workmode=%s";
    public static final String URL_SET_CAMERA_TIME = "http://192.168.29.1/cgi-bin/hisnet/setsystime.cgi?[&-time=%s]";
    public static final String URL_SET_RECORD_EV = "http://192.168.29.1/cgi-bin/hisnet/setworkmodeparam.cgi?&-workmode=NORM_REC&-type=PROTUNE_EXP_EV&-value=%s";
    public static final String URL_SET_RECORD_SIZE = "http://192.168.29.1/cgi-bin/hisnet/setworkmodeparam.cgi?&-workmode=NORM_REC&-type=MEDIAMODE&-value=%s";
    public static final String URL_SET_TAKE_PHOTO_EV = "http://192.168.29.1/cgi-bin/hisnet/setworkmodeparam.cgi?&-workmode=SING_PHOTO&-type=PROTUNE_EXP_EV&-value=%s";
    public static final String URL_SET_TAKE_PHOTO_SIZE = "http://192.168.29.1/cgi-bin/hisnet/setworkmodeparam.cgi?&-workmode=SING_PHOTO&-type=MEDIAMODE&-value=%s";
    public static final String URL_SET_VIDEO_SEGMENT = "http://192.168.29.1/cgi-bin/hisnet/setworkmodeparam.cgi?&-workmode=NORM_REC&-type=Rec_Split_Time&-value=%s";
    public static final String URL_START_RECORD = "http://192.168.29.1/cgi-bin/hisnet/workmodecmd.cgi?&-act=set&-cmd=start";
    public static final String URL_START_UPGRADE = "http://192.168.29.1/cgi-bin/hisnet/firmwareupgrade.cgi?&-fileName=%s&-fileCRC=%s";
    public static final String URL_STOP_RECORD = "http://192.168.29.1/cgi-bin/hisnet/workmodecmd.cgi?&-act=set&-cmd=stop";
    public static final String URL_TAKE_PHOTO_56 = "http://192.168.29.1/cgi-bin/hisnet/workmodecmd.cgi?&-act=set&-cmd=trigger";
    public static final String URL_TAKE_PHOTO_59 = "http://192.168.29.1/cgi-bin/hisnet/workmodecmd.cgi?&-act=set&-cmd=start";
    public static final String URL_UPGRADE_CHECK = "http://192.168.29.1/cgi-bin/hisnet/sendBinFile.cgi?&-fileSize=%s&-fileVersion=%s";
}
