POTENSIC SE FIRMWARE AND SOME OF THE DECOMPILED APK (SEE COM.LOGAN, COM.IPOTENSIC)
 netcat and tcpdump compiled to run on the potensic atom se, with tcpdump of packets in pcap format

 note that some of the files are overlayed, for example the /app/sd directory doesnt exist but files from it are in /

You can login as root via UART and copy files to the FAT formatted drive, which means you lose symlinked files. I have copies of all the mtdblocks (1-14) but some are above the filesize limit for github so they arent here.
