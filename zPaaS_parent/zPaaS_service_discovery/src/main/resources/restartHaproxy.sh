#!/bin/sh

EXEC=$1
CFG=$2

ID=`ps -ef | grep haproxy | grep -v "$0" | grep -v "grep" | awk '{print $2}'`

if [ -z ${ID} ] ; then 
  ${EXEC} -f ${CFG}
else 
  ${EXEC} -f ${CFG} -sf ${ID}
fi 