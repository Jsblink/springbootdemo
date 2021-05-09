#!/usr/bin/env bash

######################################
# 配置文件auto_clean.cfg 格式如下,即需要删除MYAPP应用下，7天前的/home/path/to/xx_yy_*.xml文件
# MYAPP,/home/path/to/*testa.xml  7
# MYAPP,/home/path/to/*testb.xml  5
# */5 * * * * cd /home/product/springdemo/script;./auto_clean.sh
######################################
if [ -f ../config/auto_clean.cfg ]; then
  FILE="../config/auto_clean.cfg"
else
  exit 1
fi
dos2unix $FILE > /dev/null

while read LINE
 do
  if [ "x$LINE" == "x" ];then
     continue
  fi
  if [ "${LINE:0:1}" == "#" -o "${LINE:0:1}" == "-" ];then
      continue
  fi
  CLEAN_FILE_PATH=$(echo "$LINE" | awk -F ',' '{print $2}' | awk '{print $1}')
  DEL_DATE=$(echo "$LINE" | awk -F ',' '{print $2}' | awk '{print $2}')
  CLEAN_FILE_PATH_DIR=$(dirname "$CLEAN_FILE_PATH")
  CLEAN_FILE_PATH_FILE=$(basename "$CLEAN_FILE_PATH")
  #rm 不带f，带f不好打印报错日志；
  # `cd $dir ; rm -f *` 如果cd 目录失败，会删除的当前目录的所有文件，这是很危险的；用if 或 &&控制，或者指定文件格式
  find "$CLEAN_FILE_PATH_DIR" -mtime "$DEL_DATE" -type f -name "$CLEAN_FILE_PATH_FILE" -exec rm  {} \;
done <"$FILE"
