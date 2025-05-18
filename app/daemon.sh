#!/bin/sh
mainapp_lost_time=0
while true
do
    sleep 1
    if ps -ef | grep "main_app" | grep -v grep > /dev/null
    then
        mainapp_lost_time=0
    else
        let mainapp_lost_time+=1
    fi

    if [ $mainapp_lost_time -ge 5 ];then
        echo "main_app not exists, reboot system now!"
        reboot -f
        exit
    fi
done
