#!/bin/sh

EXEC=$1
CFG=$2

ID=`ps -ef | grep nginx | grep -v "$0" | grep -v "grep" | awk '{print $2}'`

if [ -z ${ID} ] ; then 
  ${EXEC} -c ${CFG}
else 
  ${EXEC} -c ${CFG} -s reload
fi 