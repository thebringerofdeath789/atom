package com.ipotensic.baselib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ipotensic.baselib.Token;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes2.dex */
public class SPHelper {
    private static final String CURRENT_SHOW_SD_CAPACITY = "key_show_sd_capacity";
    public static final String KEY_BATTERY_INSTALL_DIALOG_NO_LONGER_SHOW = "key_battery_install_dialog_no_longer_show";
    private static final String KEY_BIG_PACKAGE_CAMERA_VERSION = "key_big_package_camera_version";
    private static final String KEY_BIG_PACKAGE_FLIGHT_SN = "key_big_package_flight_sn";
    private static final String KEY_BIG_PACKAGE_NEW_VER = "key_big_package_new_ver";
    private static final String KEY_BIG_PACKAGE_REMOTE_SN = "key_big_package_remote_sn";
    public static final String KEY_CIRCLE_TEACH_VIDEO_PLAYED = "key_circle_teach_video_played";
    public static final String KEY_COMET_TEACH_VIDEO_PLAYED = "key_comet_teach_video_played";
    public static final String KEY_ENTER_KERNEL_ACTIVITY_FIRST_CONNECT = "key_enter_kernel_activity_first_connect";
    public static final String KEY_ENTER_MAIN_SECOND = "key_enter_main_second";
    public static final String KEY_FIRST_ENTER_ATOM_SETTINGS = "key_first_enter_atom_settings";
    public static final String KEY_FIRST_SEND_CLOSE_WATERMARK_COMMAND = "key_first_send_close_watermark_command";
    public static final String KEY_FOLLOW_TEACH_VIDEO_PLAYED = "key_follow_teach_video_played";
    public static final String KEY_FORCE_UNLOCK_DIALOG_NO_LONGER_SHOW = "key_force_unlock_dialog_no_longer_show";
    public static final String KEY_IS_FIRST_ALBUM_PERMISSION_SHOW = "key_is_first_album_permission_show";
    public static final String KEY_IS_FIRST_CAMERA_AND_STORAGE_PERMISSION_SHOW = "key_is_first_camera_and_storage_permission_show";
    public static final String KEY_IS_FIRST_DOWNLOAD_PERMISSION_SHOW = "key_is_first_camera_and_storage_permission_show";
    public static final String KEY_IS_FIRST_SHARE_PERMISSION_SHOW = "key_is_first_camera_and_storage_permission_show";
    private static final String KEY_IS_MANUAL_MODE = "key_is_manual_mode";
    public static final String KEY_MAINTAIN_TEST_TIME = "key_maintain_test_time";
    public static final String KEY_MAINTAIN_THRESHOLD = "key_maintain_threshold";
    private static final String KEY_PREVIEW_SHOW_CROSS = "key_preview_show_cross";
    private static final String KEY_PREVIEW_SHOW_DOT = "key_preview_show_dot";
    private static final String KEY_PREVIEW_SHOW_LINE = "key_preview_show_line";
    public static final String KEY_RECESS_TEACH_VIDEO_PLAYED = "key_recess_teach_video_played";
    public static final String KEY_SCREW_TEACH_VIDEO_PLAYED = "key_screw_teach_video_played";
    public static final String KEY_SILENT_RETURN = "key_silent_return";
    public static final String KEY_SILENT_RETURN_GUIDE = "key_silent_return_guide";
    public static final String KEY_SKYWARD_TEACH_VIDEO_PLAYED = "key_skyward_teach_video_played";
    public static final String KEY_TIMED_PHOTOGRAPHY = "key_timed_photography";
    private static final String KEY_UPGRADE_HANDSHAKE_PASS = "key_upgrade_handshake_pass";
    public static final String KEY_WEAK_SIGNAL_DIALOG_NO_LONGER_SHOW = "key_weak_signal_dialog_no_longer_show";
    public static final String KEY_WEB_SHOW_TIPS = "key_web_show_tips";
    public static final String KEY_ZOOM_SCALE = "key_zoom_scale";
    private static volatile SPHelper instance;
    private final String TAG = "DDLog-SPHelper";
    private final String SP_NAME = "MY_SP";
    private final String KEY_AUDIO_ENABLE = "key_audio_enable";
    private final String KEY_USB_RESOLUTION_WIDTH = "key_usb_resolution_width";
    private final String KEY_USB_RESOLUTION_HEIGHT = "key_usb_resolution_height";
    private final String KEY_WIFI_RESOLUTION_WIDTH = "key_wifi_resolution_width";
    private final String KEY_WIFI_RESOLUTION_HEIGHT = "key_wifi_resolution_height";
    private final String KEY_TOKEN = "key_token";
    private final String KEY_IS_REGISTERATION_ID_REGISTERED = "key_is_registeration_id_registered";
    private final String KEY_IS_PROTOCOL_AGREE = "key_is_protocol_agree";
    private final String KEY_LANGUAGE = "key_language";
    private final String KEY_COUNTRY = "key_country";
    private final String KEY_FLIGHT_RECORD = "key_flight_record";
    private final String KEY_LAST_LOCATION_LAT = "key_lase_location_lat";
    private final String KEY_LAST_LOCATION_LNG = "key_lase_location_lng";
    private final String KEY_CONNECT_TYPE = "key_connect_type";
    private final String KEY_RTH_GUIDE_VIDEO = "key_rth_guide_video";
    private final String KEY_REGISTER_FIRMWARE_INFO = "key_register_firmware_info";
    private final String KEY_UPGRADE_VERSIONS = "key_upgrade_versions";
    private final String KEY_BIG_PACKAGE_UPGRADE_VERSIONS = "key_big_package_upgrade_versions";
    private final String KEY_FLIGHT_CUR_VERSION = "key_flight_cur_version";
    private final String KEY_CAMERA_CUR_VERSION = "key_camera_cur_version";
    private final String KEY_GIMBAL_CUR_VERSION = "key_gimbal_cur_version";
    private final String KEY_REMOTER_CUR_VERSION = "key_remoter_cur_version";
    private final String KEY_FPV_CUR_VERSION = "key_fpv_cur_version";
    private final String KEY_BATTERY_CUR_VERSION = "key_battery_cur_version";
    private final String KEY_ESC_CUR_VERSION = "key_esc_cur_version";
    private final String KEY_TOF = "key_tof";
    private final String KEY_P1PRO_BATTERY_UPDATE = "key_p1pro_battery_update";
    private final String KEY_CAMERA_CLASS = "key_camera_class";
    private final String KEY_FLIGHT = "key_flight";
    private final String KEY_BIG_PACKAGE_FLIGHT = "key_big_package_flight";
    private final String KEY_APP_FIRST_INSTALL = "key_app_first_install";
    private final String KEY_FIRST_ENTER_MAIN_INTERFACE = "key_first_enter_main_interface";
    private final String KEY_USER_TERMS = "key_user_terms";
    private final String KEY_HARD_DECODE = "key_hard_decode";
    private final String KEY_PRODUCT_CLASS = "key_product_class";
    private final String KEY_FLIGHT_CODE = "key_flight_code";
    private final String KEY_CLASS_NAME = "key_class_name";
    private final String KEY_ALTITUDE_LIMIT_AGREE = "key_altitude_limit_agree";
    private final String KEY_NEED_DOWNLOAD_FIRMWARE = "key_need_download_fireware";
    private SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor = null;
    private final String KEY_GUIDE_CANCEL_ACTION = "key_guide_cancel_action";
    private final String KEY_TAKE_OFF = "key_take_off";
    private final String KEY_GO_HOME = "key_go_home";
    private final String KEY_INTELLIGENT_MODE = "key_intelligent_mode";
    private final String KEY_CAMERA_SETTING = "key_camera_setting";
    private final String KEY_AIRBORNE_GALLERY = "key_airborne_gallery";
    private final String KEY_SWITCH_STATUS = "key_switch_status";
    private final String KEY_MAIN_SETTIG = "key_main_setting";
    private final String KEY_FIRST_ENTER_MAP = "key_first_enter_map";
    private final String KEY_HEAD_MODE = "key_head_mode";
    private final String KEY_LOCK_MODE = "key_lock_mode";
    private final String KEY_GPS_MODE = "key_gps_mode";
    private final String KEY_HOT_CIRCLE_MODE = "key_hot_circle_mode";
    private final String KEY_WAYPOINT_MODE = "key_waypoint_mode";
    private final String KEY_FOLLOW_ME_MODE = "key_follow_me_mode";
    private final String KEY_REMOTE_CONTROL_MODE = "key_remote_control_mode";
    private final String KEY_ENTER_MAP_WAYPOINT = "key_enter_map_waypoint";
    private final String KEY_ENTER_MAIN = "key_enter_main";
    private final String KEY_DROP_DOWN_MENU = "key_drop_down_menu";
    private final String KEY_FORBID_LOCATION_PERMISSION = "key_forbid_location_permission";
    private final String KEY_FORBID_STORAGE_PERMISSION = "key_forbid_storage_permission";
    private final String KEY_UNITS_TYPE = "key_units_type";
    private final String KEY_IS_SHOW_FLIGHT_TIPS = "key_flight_tips";
    private final String KEY_FIRST_FOLLOW_ME = "key_first_follow_me";
    private final String KEY_FIRST_PHOTO_OR_VIDEO = "key_first_photo_or_video";
    private final String KEY_COUNTRY_CODE = "key_country_code";
    private final String KEY_FIRST_HEXAHEDRAL = "key_first_hexahedral";
    private final String KEY_PDF_INFO_P1SELF = "key_pdf_info_p1self";
    private final String KEY_PDF_INFO_P1PRO = "key_pdf_info_p1pro";
    private final String KEY_PDF_INFO_P3SE = "key_pdf_info_p3se";
    private final String KEY_PDF_INFO_P1A = "key_pdf_info_p1a";
    private final String KEY_PDF_INFO_P1B = "key_pdf_info_p1b";
    private final String KEY_PDF_INFO_MINISE = "key_pdf_info_minise";
    private final String KEY_LONGITUDE = "key_longitude";
    private final String KEY_LATITUDE = "key_latitude";
    private final String KEY_HOME_LONGITUDE = "key_home_longitude";
    private final String KEY_HOME_LATITUDE = "key_home_latitude";
    private final String KEY_FLIGHT_SN = "key_flight_sn";
    private final String KEY_REMOTE_SN = "key_remote_sn";
    private final String KEY_BIG_PACKAGE_VERSION = "key_big_package_version";
    private final String KEY_IS_BIG_PACKAGE = "key_is_big_package";
    private final String KEY_BIG_PACKAGE_UPGRADE_MEDIA_IS_SDCARD = "key_big_package_upgrade_media_is_sdcard";
    private final String KEY_SECURITY_TIPS = "key_security_tips";

    public void setCircleTeachVideoPlayed(boolean z) {
        this.editor.putBoolean(KEY_CIRCLE_TEACH_VIDEO_PLAYED, z);
        this.editor.commit();
    }

    public boolean isCircleTeachVideoPlayed() {
        return this.sharedPreferences.getBoolean(KEY_CIRCLE_TEACH_VIDEO_PLAYED, false);
    }

    public void setScrewTeachVideoPlayed(boolean z) {
        this.editor.putBoolean(KEY_SCREW_TEACH_VIDEO_PLAYED, z);
        this.editor.commit();
    }

    public boolean isScrewTeachVideoPlayed() {
        return this.sharedPreferences.getBoolean(KEY_SCREW_TEACH_VIDEO_PLAYED, false);
    }

    public void setCometTeachVideoPlayed(boolean z) {
        this.editor.putBoolean(KEY_COMET_TEACH_VIDEO_PLAYED, z);
        this.editor.commit();
    }

    public boolean isCometTeachVideoPlayed() {
        return this.sharedPreferences.getBoolean(KEY_COMET_TEACH_VIDEO_PLAYED, false);
    }

    public void setSkywardTeachVideoPlayed(boolean z) {
        this.editor.putBoolean(KEY_SKYWARD_TEACH_VIDEO_PLAYED, z);
        this.editor.commit();
    }

    public boolean isSkywardTeachVideoPlayed() {
        return this.sharedPreferences.getBoolean(KEY_SKYWARD_TEACH_VIDEO_PLAYED, false);
    }

    public void setRecessTeachVideoPlayed(boolean z) {
        this.editor.putBoolean(KEY_RECESS_TEACH_VIDEO_PLAYED, z);
        this.editor.commit();
    }

    public boolean isRecessTeachVideoPlayed() {
        return this.sharedPreferences.getBoolean(KEY_RECESS_TEACH_VIDEO_PLAYED, false);
    }

    public void setFollowTeachVideoPlayed(boolean z) {
        this.editor.putBoolean(KEY_FOLLOW_TEACH_VIDEO_PLAYED, z);
        this.editor.commit();
    }

    public boolean isFollowTeachVideoPlayed() {
        return this.sharedPreferences.getBoolean(KEY_FOLLOW_TEACH_VIDEO_PLAYED, false);
    }

    public void setBigPackageUpgradeMediaIsSdcard(boolean z) {
        this.editor.putBoolean("key_big_package_upgrade_media_is_sdcard", z);
        this.editor.commit();
    }

    public boolean getBigPackageUpgradeMediaIsSdcard() {
        return this.sharedPreferences.getBoolean("key_big_package_upgrade_media_is_sdcard", false);
    }

    public void setIsBigPackage(boolean z) {
        this.editor.putBoolean("key_is_big_package", z);
        this.editor.commit();
    }

    public boolean getIsBigPackage() {
        return this.sharedPreferences.getBoolean("key_is_big_package", true);
    }

    public void setBigPackageVersion(String str) {
        this.editor.putString("key_big_package_version", str);
        this.editor.commit();
    }

    public String getBigPackageVersion() {
        return this.sharedPreferences.getString("key_big_package_version", null);
    }

    public void setFlightControllerSN(String str) {
        this.editor.putString("key_flight_sn", str);
        this.editor.commit();
    }

    public String getFlightControllerSN() {
        return this.sharedPreferences.getString("key_flight_sn", null);
    }

    public void setRemoteControllerSN(String str) {
        this.editor.putString("key_remote_sn", str);
        this.editor.commit();
    }

    public String getRemoteControllerSN() {
        return this.sharedPreferences.getString("key_remote_sn", null);
    }

    public void setFirstEnterMain(boolean z) {
        this.editor.putBoolean("key_enter_main", z);
        this.editor.commit();
    }

    public void setShowFlightTips(boolean z) {
        this.editor.putBoolean("key_flight_tips", z);
        this.editor.commit();
    }

    public boolean isShowFlightTips() {
        return this.sharedPreferences.getBoolean("key_flight_tips", true);
    }

    public boolean getFirstEnterMain() {
        return this.sharedPreferences.getBoolean("key_enter_main", true);
    }

    public void setNeedDownloadFw(boolean z) {
        this.editor.putBoolean("key_need_download_fireware", z);
        this.editor.commit();
    }

    public boolean isNeedDownloadFw() {
        return this.sharedPreferences.getBoolean("key_need_download_fireware", false);
    }

    public void setProtocolAgree(boolean z) {
        this.editor.putBoolean("key_is_protocol_agree", z);
        this.editor.commit();
    }

    public boolean isProtocolAgree() {
        return this.sharedPreferences.getBoolean("key_is_protocol_agree", false);
    }

    public void setFirstOpenDownMenu(boolean z) {
        this.editor.putBoolean("key_drop_down_menu", z);
        this.editor.commit();
    }

    public boolean getFirstOpenDownMenu() {
        return this.sharedPreferences.getBoolean("key_drop_down_menu", true);
    }

    public void setLongitude(float f) {
        this.editor.putFloat("key_longitude", f);
        this.editor.commit();
    }

    public float getLongitude() {
        return this.sharedPreferences.getFloat("key_longitude", 0.0f);
    }

    public void setLatitude(float f) {
        this.editor.putFloat("key_latitude", f);
        this.editor.commit();
    }

    public float getLatitude() {
        return this.sharedPreferences.getFloat("key_latitude", 0.0f);
    }

    public void setTakeOff(boolean z) {
        this.editor.putBoolean("key_take_off", z);
        this.editor.commit();
    }

    public boolean getTakeOff() {
        return this.sharedPreferences.getBoolean("key_take_off", true);
    }

    public void setHardDecode(boolean z) {
        this.editor.putBoolean("key_hard_decode", z);
        this.editor.commit();
    }

    public boolean isHardDecode() {
        return this.sharedPreferences.getBoolean("key_hard_decode", false);
    }

    public void setGoHome(boolean z) {
        this.editor.putBoolean("key_go_home", z);
        this.editor.commit();
    }

    public boolean getGoHome() {
        return this.sharedPreferences.getBoolean("key_go_home", true);
    }

    public void setIntelligentMode(boolean z) {
        this.editor.putBoolean("key_intelligent_mode", z);
        this.editor.commit();
    }

    public boolean getIntelligentMode() {
        return this.sharedPreferences.getBoolean("key_intelligent_mode", true);
    }

    public void setCameraSetting(boolean z) {
        this.editor.putBoolean("key_camera_setting", z);
        this.editor.commit();
    }

    public boolean getCameraSetting() {
        return this.sharedPreferences.getBoolean("key_camera_setting", true);
    }

    public void setSwitchStatus(boolean z) {
        this.editor.putBoolean("key_switch_status", z);
        this.editor.commit();
    }

    public boolean getSwitchStatus() {
        return this.sharedPreferences.getBoolean("key_switch_status", true);
    }

    public void setAirborneGallery(boolean z) {
        this.editor.putBoolean("key_airborne_gallery", z);
        this.editor.commit();
    }

    public boolean getAirborneGallery() {
        return this.sharedPreferences.getBoolean("key_airborne_gallery", true);
    }

    public void putString(String str, String str2) {
        this.editor.putString(str, str2);
        this.editor.commit();
    }

    public String getString(String str) {
        return this.sharedPreferences.getString(str, "");
    }

    public void putFloat(String str, float f) {
        this.editor.putFloat(str, f);
        this.editor.commit();
    }

    public float getFloat(String str) {
        return this.sharedPreferences.getFloat(str, 0.0f);
    }

    public void putBoolean(String str, boolean z) {
        this.editor.putBoolean(str, z);
        this.editor.commit();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.sharedPreferences.getBoolean(str, z);
    }

    public void putInt(String str, int i) {
        this.editor.putInt(str, i);
        this.editor.commit();
    }

    public int getInt(String str, int i) {
        return this.sharedPreferences.getInt(str, i);
    }

    public void setMainSetting(boolean z) {
        this.editor.putBoolean("key_main_setting", z);
        this.editor.commit();
    }

    public boolean getMainSetting() {
        return this.sharedPreferences.getBoolean("key_main_setting", true);
    }

    public void setFirstEnterMap(boolean z) {
        this.editor.putBoolean("key_first_enter_map", z);
        this.editor.commit();
    }

    public boolean getFirstEnterMap() {
        return this.sharedPreferences.getBoolean("key_first_enter_map", true);
    }

    public void setHeadMode(boolean z) {
        this.editor.putBoolean("key_head_mode", z);
        this.editor.commit();
    }

    public boolean getHeadMode() {
        return this.sharedPreferences.getBoolean("key_head_mode", true);
    }

    public void setLockMode(boolean z) {
        this.editor.putBoolean("key_lock_mode", z);
        this.editor.commit();
    }

    public boolean getLockMode() {
        return this.sharedPreferences.getBoolean("key_lock_mode", true);
    }

    public void setGpsMode(boolean z) {
        this.editor.putBoolean("key_gps_mode", z);
        this.editor.commit();
    }

    public boolean getGpsMode() {
        return this.sharedPreferences.getBoolean("key_gps_mode", true);
    }

    public void setHotCircleMode(boolean z) {
        this.editor.putBoolean("key_hot_circle_mode", z);
        this.editor.commit();
    }

    public boolean getHotCircleMode() {
        return this.sharedPreferences.getBoolean("key_hot_circle_mode", true);
    }

    public void setWaypointMode(boolean z) {
        this.editor.putBoolean("key_waypoint_mode", z);
        this.editor.commit();
    }

    public boolean getWaypointMode() {
        return this.sharedPreferences.getBoolean("key_waypoint_mode", true);
    }

    public void setFollowMeMode(boolean z) {
        this.editor.putBoolean("key_follow_me_mode", z);
        this.editor.commit();
    }

    public boolean getFollowMeMode() {
        return this.sharedPreferences.getBoolean("key_follow_me_mode", true);
    }

    public void setRemoteControlMode(boolean z) {
        this.editor.putBoolean("key_remote_control_mode", z);
        this.editor.commit();
    }

    public boolean getRemoteControlMode() {
        return this.sharedPreferences.getBoolean("key_remote_control_mode", true);
    }

    public void setEnterMapOfWaypoint(boolean z) {
        this.editor.putBoolean("key_enter_map_waypoint", z);
        this.editor.commit();
    }

    public boolean getEnterMapOfWaypoint() {
        return this.sharedPreferences.getBoolean("key_enter_map_waypoint", true);
    }

    public boolean isFt() {
        return this.sharedPreferences.getBoolean("key_units_type", false);
    }

    public void setFt(boolean z) {
        this.editor.putBoolean("key_units_type", z);
        this.editor.commit();
    }

    public boolean getFirstFollowMe() {
        return this.sharedPreferences.getBoolean("key_first_follow_me", true);
    }

    public void setFirstFollowMe(boolean z) {
        this.editor.putBoolean("key_first_follow_me", z);
        this.editor.commit();
    }

    public boolean getFirstPhotoOrVideo() {
        return this.sharedPreferences.getBoolean("key_first_photo_or_video", true);
    }

    public void setFirstPhotoOrVideo(boolean z) {
        this.editor.putBoolean("key_first_photo_or_video", z);
        this.editor.commit();
    }

    public boolean isP1ProBatteryUpdate() {
        return this.sharedPreferences.getBoolean("key_p1pro_battery_update", false);
    }

    public void setP1ProBatteryUpdate(boolean z) {
        this.editor.putBoolean("key_p1pro_battery_update", z);
        this.editor.commit();
    }

    public void setFirstGuideCancelAction(boolean z) {
        this.editor.putBoolean("key_guide_cancel_action", z);
        this.editor.commit();
    }

    public boolean getFirstGuideCancelAction() {
        return this.sharedPreferences.getBoolean("key_guide_cancel_action", true);
    }

    public void setRthGuideVideoShown(boolean z) {
        this.editor.putBoolean("key_rth_guide_video", z);
        this.editor.commit();
    }

    public boolean isRthGuideVideoShown() {
        return this.sharedPreferences.getBoolean("key_rth_guide_video", false);
    }

    private SPHelper() {
    }

    public static SPHelper getInstance() {
        if (instance == null) {
            synchronized (SPHelper.class) {
                if (instance == null) {
                    SPHelper sPHelper = new SPHelper();
                    instance = sPHelper;
                    return sPHelper;
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_SP", 0);
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public void setAudioEnable(boolean z) {
        this.editor.putBoolean("key_audio_enable", z);
        this.editor.commit();
    }

    public boolean isAudioEnable() {
        return this.sharedPreferences.getBoolean("key_audio_enable", false);
    }

    public void setUsbResolution(int i, int i2) {
        this.editor.putInt("key_usb_resolution_width", i);
        this.editor.putInt("key_usb_resolution_height", i2);
        this.editor.commit();
    }

    public int[] getUsbResolution() {
        return new int[]{this.sharedPreferences.getInt("key_usb_resolution_width", 640), this.sharedPreferences.getInt("key_usb_resolution_height", NNTPReply.AUTHENTICATION_REQUIRED)};
    }

    public void setLanguage(String str) {
        this.editor.putString("key_language", str);
        this.editor.commit();
    }

    public void setCountry(String str) {
        this.editor.putString("key_country", str);
        this.editor.commit();
    }

    public String getLanguage() {
        return this.sharedPreferences.getString("key_language", "");
    }

    public String getCountry() {
        return this.sharedPreferences.getString("key_country", "");
    }

    public void setAppFirstInstall(boolean z) {
        this.editor.putBoolean("key_app_first_install", z);
        this.editor.commit();
    }

    public boolean getAppFirstInstall() {
        return this.sharedPreferences.getBoolean("key_app_first_install", true);
    }

    public void setAppFirstEnterMain(boolean z) {
        this.editor.putBoolean("key_first_enter_main_interface", z);
        this.editor.commit();
    }

    public boolean getAppFirstEnterMain() {
        return this.sharedPreferences.getBoolean("key_first_enter_main_interface", true);
    }

    public void setUserTerms(boolean z) {
        this.editor.putBoolean("key_user_terms", z);
        this.editor.commit();
    }

    public boolean getUserTerms() {
        return this.sharedPreferences.getBoolean("key_user_terms", true);
    }

    public void setToken(Token token) {
        this.editor.putString("key_token", JSON.toJSONString(token));
        this.editor.commit();
    }

    public Token getToken() {
        String string = this.sharedPreferences.getString("key_token", null);
        if (string == null) {
            return null;
        }
        return (Token) JSONObject.parseObject(string, Token.class);
    }

    public void setNickName(String str, String str2) {
        this.editor.putString(str, str2);
        this.editor.commit();
    }

    public String getNickName(String str) {
        return (String) Objects.requireNonNull(this.sharedPreferences.getString(str, ""));
    }

    public void setRegisterFirmwareInfo(Set<String> set) {
        this.editor.putStringSet("key_register_firmware_info", set);
        this.editor.commit();
    }

    public Set<String> getRegisterFirmwareInfo() {
        return this.sharedPreferences.getStringSet("key_register_firmware_info", null);
    }

    public void setLocalBigPackageVersion(String str) {
        this.editor.putString("key_big_package_upgrade_versions", str);
        this.editor.commit();
    }

    public String getLocalBigPackageVersion() {
        return this.sharedPreferences.getString("key_big_package_upgrade_versions", null);
    }

    public void setUpgradeVersions(Set<String> set) {
        this.editor.putStringSet("key_upgrade_versions", set);
        this.editor.commit();
    }

    public Set<String> getUpgradeVersions() {
        return this.sharedPreferences.getStringSet("key_upgrade_versions", null);
    }

    public void setCameraClass(String str) {
        this.editor.putString("key_camera_class", str);
        this.editor.commit();
    }

    public String getCameraClass() {
        return this.sharedPreferences.getString("key_camera_class", null);
    }

    public void setCountryCode(String str) {
        this.editor.putString("key_country_code", str);
        this.editor.commit();
    }

    public String getCountryCode() {
        return this.sharedPreferences.getString("key_country_code", null);
    }

    public void setFirstHexahedralCalibration(boolean z) {
        this.editor.putBoolean("key_first_hexahedral", z);
        this.editor.commit();
    }

    public String getPdfInfo(String str) {
        str.hashCode();
        switch (str) {
            case "MiniSE":
                return this.sharedPreferences.getString("key_pdf_info_minise", null);
            case "p1self":
                return this.sharedPreferences.getString("key_pdf_info_p1self", null);
            case "P3SE_V0":
            case "P3-SE":
                return this.sharedPreferences.getString("key_pdf_info_p3se", null);
            case "P1A":
                return this.sharedPreferences.getString("key_pdf_info_p1a", null);
            case "P1B":
                return this.sharedPreferences.getString("key_pdf_info_p1b", null);
            case "p1pro":
                return this.sharedPreferences.getString("key_pdf_info_p1pro", null);
            default:
                return null;
        }
    }

    public void setPdfInfo(String str, String str2) {
        str.hashCode();
        switch (str) {
            case "MiniSE":
                this.editor.putString("key_pdf_info_minise", str2);
                break;
            case "p1self":
                this.editor.putString("key_pdf_info_p1self", str2);
                break;
            case "P3SE_V0":
            case "P3-SE":
                this.editor.putString("key_pdf_info_p3se", str2);
                break;
            case "P1A":
                this.editor.putString("key_pdf_info_p1a", str2);
                break;
            case "P1B":
                this.editor.putString("key_pdf_info_p1b", str2);
                break;
            case "p1pro":
                this.editor.putString("key_pdf_info_p1pro", str2);
                break;
        }
        this.editor.commit();
    }

    public boolean getFirstHexahedralCalibration() {
        return this.sharedPreferences.getBoolean("key_first_hexahedral", true);
    }

    public void setFlightCurVersion(String str) {
        this.editor.putString("key_flight_cur_version", str);
        this.editor.commit();
    }

    public String getFlightCurVersion() {
        return this.sharedPreferences.getString("key_flight_cur_version", null);
    }

    public void setCameraCurVersion(String str) {
        this.editor.putString("key_camera_cur_version", str);
        this.editor.commit();
    }

    public String getCameraCurVersion() {
        return this.sharedPreferences.getString("key_camera_cur_version", null);
    }

    public void setGimbalCurVersion(String str) {
        this.editor.putString("key_gimbal_cur_version", str);
        this.editor.commit();
    }

    public String getGimbalCurVersion() {
        return this.sharedPreferences.getString("key_gimbal_cur_version", null);
    }

    public void setRemoterCurVersion(String str) {
        this.editor.putString("key_remoter_cur_version", str);
        this.editor.commit();
    }

    public String getRemoterCurVersion() {
        return this.sharedPreferences.getString("key_remoter_cur_version", null);
    }

    public void setFpvCurVersion(String str) {
        this.editor.putString("key_fpv_cur_version", str);
        this.editor.commit();
    }

    public String getFpvCurVersion() {
        return this.sharedPreferences.getString("key_fpv_cur_version", null);
    }

    public String getBatteryCurVersion() {
        return this.sharedPreferences.getString("key_battery_cur_version", null);
    }

    public void setBatteryCurVersion(String str) {
        this.editor.putString("key_battery_cur_version", str);
        this.editor.commit();
    }

    public void setTofCurVersion(String str) {
        this.editor.putString("key_tof", str);
        this.editor.commit();
    }

    public String getTofCurVersion() {
        return this.sharedPreferences.getString("key_tof", null);
    }

    public void setFlight(String str) {
        this.editor.putString("key_flight", str);
        this.editor.commit();
    }

    public String getFlight() {
        return this.sharedPreferences.getString("key_flight", null);
    }

    public void setBigPackageFlight(String str) {
        this.editor.putString("key_big_package_flight", str);
        this.editor.apply();
    }

    public String getBigPackageFlight() {
        return this.sharedPreferences.getString("key_big_package_flight", null);
    }

    public void clearFlight() {
        this.editor.remove("key_flight");
        this.editor.commit();
    }

    public void setLastLocation(double d, double d2) {
        this.editor.putString("key_lase_location_lat", "" + d);
        this.editor.putString("key_lase_location_lng", "" + d2);
        this.editor.commit();
    }

    public double[] getLastLocation() {
        try {
            return new double[]{Double.valueOf((String) Objects.requireNonNull(this.sharedPreferences.getString("key_lase_location_lat", null))).doubleValue(), Double.valueOf((String) Objects.requireNonNull(this.sharedPreferences.getString("key_lase_location_lng", null))).doubleValue()};
        } catch (Exception unused) {
            return null;
        }
    }

    public void clearToken() {
        this.editor.remove("key_token");
        this.editor.commit();
    }

    public void clearUpgradeVersions() {
        this.editor.remove("key_upgrade_versions");
        this.editor.commit();
    }

    public void setCurrentShowSdCapacity(boolean z) {
        this.editor.putBoolean(CURRENT_SHOW_SD_CAPACITY, z);
        this.editor.commit();
    }

    public boolean showSdCapacity() {
        return this.sharedPreferences.getBoolean(CURRENT_SHOW_SD_CAPACITY, false);
    }

    public void setManualMode(boolean z) {
        this.editor.putBoolean(KEY_IS_MANUAL_MODE, z);
        this.editor.commit();
    }

    public boolean isManualMode() {
        return this.sharedPreferences.getBoolean(KEY_IS_MANUAL_MODE, false);
    }

    public void setPreviewShowLine(boolean z) {
        this.editor.putBoolean(KEY_PREVIEW_SHOW_LINE, z);
        this.editor.commit();
    }

    public boolean isPreviewShowLine() {
        return this.sharedPreferences.getBoolean(KEY_PREVIEW_SHOW_LINE, false);
    }

    public void setPreviewShowDot(boolean z) {
        this.editor.putBoolean(KEY_PREVIEW_SHOW_DOT, z);
        this.editor.commit();
    }

    public boolean isPreviewShowDot() {
        return this.sharedPreferences.getBoolean(KEY_PREVIEW_SHOW_DOT, false);
    }

    public void setPreviewShowCross(boolean z) {
        this.editor.putBoolean(KEY_PREVIEW_SHOW_CROSS, z);
        this.editor.commit();
    }

    public boolean isPreviewShowCross() {
        return this.sharedPreferences.getBoolean(KEY_PREVIEW_SHOW_CROSS, false);
    }

    public void setHomeLongitude(float f) {
        this.editor.putFloat("key_home_longitude", f);
        this.editor.commit();
    }

    public float getHomeLongitude() {
        return this.sharedPreferences.getFloat("key_home_longitude", 0.0f);
    }

    public void setHomeLatitude(float f) {
        this.editor.putFloat("key_home_latitude", f);
        this.editor.commit();
    }

    public float getHomeLatitude() {
        return this.sharedPreferences.getFloat("key_home_latitude", 0.0f);
    }

    public void setSecurityTips(String str) {
        this.editor.putString("key_security_tips", str);
        this.editor.commit();
    }

    public String getSecurityTips() {
        return this.sharedPreferences.getString("key_security_tips", null);
    }

    public void setSilentReturn(boolean z) {
        this.editor.putBoolean(KEY_SILENT_RETURN, z);
        this.editor.commit();
    }

    public boolean isSilentReturn() {
        return this.sharedPreferences.getBoolean(KEY_SILENT_RETURN, false);
    }

    public void setSilentReturnGuide(boolean z) {
        this.editor.putBoolean(KEY_SILENT_RETURN_GUIDE, z);
        this.editor.commit();
    }

    public boolean isSilentReturnGuide() {
        return this.sharedPreferences.getBoolean(KEY_SILENT_RETURN_GUIDE, true);
    }

    public void setEnterKernelActivityFirstConnected(boolean z) {
        this.editor.putBoolean(KEY_ENTER_KERNEL_ACTIVITY_FIRST_CONNECT, z);
        this.editor.apply();
    }

    public boolean isEnterKernelActivityFirstConnected() {
        return this.sharedPreferences.getBoolean(KEY_ENTER_KERNEL_ACTIVITY_FIRST_CONNECT, true);
    }

    public void setEscCurVersion(String str) {
        this.editor.putString("key_esc_cur_version", str);
        this.editor.apply();
    }

    public String getEscCurVersion() {
        return this.sharedPreferences.getString("key_esc_cur_version", null);
    }

    public void setBigPackageCameraVersion(String str) {
        this.editor.putString(KEY_BIG_PACKAGE_CAMERA_VERSION, str);
        this.editor.apply();
    }

    public String getBigPackageCameraVersion() {
        return this.sharedPreferences.getString(KEY_BIG_PACKAGE_CAMERA_VERSION, "");
    }

    public void setBigPackageRemoteSn(String str) {
        this.editor.putString(KEY_BIG_PACKAGE_REMOTE_SN, str);
        this.editor.apply();
    }

    public String getBigPackageRemoteSn() {
        return this.sharedPreferences.getString(KEY_BIG_PACKAGE_REMOTE_SN, "");
    }

    public void setBigPackageFlightSn(String str) {
        this.editor.putString(KEY_BIG_PACKAGE_FLIGHT_SN, str);
        this.editor.apply();
    }

    public String getBigPackageFlightSn() {
        return this.sharedPreferences.getString(KEY_BIG_PACKAGE_FLIGHT_SN, "");
    }

    public void setBigPackageNewVersion(String str) {
        this.editor.putString(KEY_BIG_PACKAGE_NEW_VER, str);
        this.editor.apply();
    }

    public String getBigPackageNewVersion() {
        return this.sharedPreferences.getString(KEY_BIG_PACKAGE_NEW_VER, "");
    }

    public void setUpgradeHandshakePass(boolean z) {
        this.editor.putBoolean(KEY_UPGRADE_HANDSHAKE_PASS, z);
        this.editor.apply();
    }

    public boolean isUpgradeHandshakePass() {
        return this.sharedPreferences.getBoolean(KEY_UPGRADE_HANDSHAKE_PASS, true);
    }
}
