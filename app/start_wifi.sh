#!/bin/sh

debug_mode=0

normal_channel=11
debug_channel=1

ssid_prefix=$1

update_ssid()
{
    suffix=`ifconfig wlan0|sed -n 's/.* HWaddr *//p'|awk -F: '{print $4 $5 $6}'|tr -d [:space:]`
    ssid=${ssid_prefix}${suffix}
    sed -i "s/^ *ssid *=.*/ssid=${ssid}/" /dev/hostapd.conf
    echo "SSID set to ${ssid}"
    echo "[deasea_test]=SSID:${ssid}" # this is used by factory tool
}

load_wifi_ko_yunwang()
{
    if [ ${debug_mode} -eq 0 ];then
        echo set wifi in normal mode.
        insmod /app/komod/csw2201.ko
        channel=${normal_channel}
    else
        echo set wifi in debug mode.
        insmod /app/komod/csw2201.ko csw_config_p=0
        channel=${debug_channel}
    fi
}

load_wifi_ko_deepsea()
{
    if [ ${debug_mode} -eq 0 ];then
        echo set wifi in normal mode.
        insmod /app/komod/px007.ko
        channel=${normal_channel}
    else
        echo set wifi in debug mode.
        insmod /app/komod/px007.ko rtw_nb_config=0
        channel=${debug_channel}
    fi
}

load_wifi_ko()
{
    vendor_id=$1
    echo wifi vendor id: ${vendor_id}

    if [ "${vendor_id}" = "2201" ];then
        echo 'using yunwang wifi.'
        load_wifi_ko_yunwang
    else
        echo 'using deepsea wifi.'
        load_wifi_ko_deepsea
    fi
}


# insert ko
#insmod /app/komod/xhci-hcd.ko
#insmod /app/komod/xhci-plat-hcd.ko

for i in `seq 50`
do
    vendor_id=`lsusb|grep 'Bus 001 Device 002'|awk -F: '{print $3}'`
    if [ "${vendor_id}" != "" ];then
        break
    fi
    echo 'wait for usb ready...'
    sleep 0.1
done

load_wifi_ko ${vendor_id}

sed -i "s/^ *channel *=.*/channel=${channel}/" /dev/hostapd.conf

sleep 0.5
update_ssid

sync && sync && sync

/app/bin/hostapd -B /dev/hostapd.conf 

#util 

PIDS=`ps aux | grep hostapd.conf | awk '$4~/^\/app/{print $4}'`
sleep 0.5
until [ $PIDS = "/app/bin/hostapd" ]
do
    sleep 0.5
    PIDS=`ps aux | grep hostapd.conf | awk '$4~/^\/app/{print $4}'`
    echo "pids read hostapd!"
    /app/bin/hostapd -B /dev/hostapd.conf 
done
echo $PIDS

mkdir -p /dev/misc
touch /dev/misc/udhcpd.leases
ifconfig wlan0 down
sleep 0.3
ifconfig wlan0 192.168.29.1
sleep 0.1
udhcpd -fS /app/udhcpd.conf&
ifconfig lo up
/app/bin/rtwpriv wlan0 efuse_set wmap,10f,43
echo "start wifi finish!"
