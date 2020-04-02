#!/bin/sh

LIB=./lib
for jar in $LIB/*.*
do
CLASSPATH=$CLASSPATH:$jar
done

echo java -Xms128m -Xmx256m -cp ${CLASSPATH} com.yjcloud.discovery.ServiceDiscovery 192.168.100.113:2181,192.168.100.114:2181,192.168.100.115:2181 dc7727d07afc803b6fdbb06914fb52e014d6256e5e8711cf /yjcloud/serviceDiscovery /home/linux/serviceDiscovery/nginx.conf.tpl /etc/nginx/nginx.conf /usr/sbin/nginx /home/linux/serviceDiscovery/restartNginx.sh ip

java -Xms128m -Xmx256m -cp ${CLASSPATH} com.yjcloud.discovery.ServiceDiscovery 192.168.100.113:2181,192.168.100.114:2181,192.168.100.115:2181 dc7727d07afc803b6fdbb06914fb52e014d6256e5e8711cf /yjcloud/serviceDiscovery /home/linux/serviceDiscovery/nginx.conf.tpl /etc/nginx/nginx.conf /usr/sbin/nginx /home/linux/serviceDiscovery/restartNginx.sh ip