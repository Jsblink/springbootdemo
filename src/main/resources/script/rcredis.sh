#! /bin/bash
#redis应用启动脚本，实现启动，停止，重新启动，状态查询和版本查询功能
CUR_DIR=$(cd $(dirname "$0");pwd)
REDIS_CONFIG=
APP_PORT="8200"
APP_IP="127.0.0.1"
LOG_FILE="/home/redis/redis/start.log"

USER=`whoami`
REDIS_PROCESS=`ps -ef|grep redis-server|grep -v grep|grep $APP_PORT|awk '{print $2}'`
##1:未启动 0：启动
STATUS_FLAG="1"

status()
{
        REDIS_PROCESS=`ps -ef|grep redis-server|grep -v grep|grep $APP_PORT|awk '{print $2}'`
        if [ -z $REDIS_PROCESS ];then
                STATUS_FLAG="1"
                echo "redis status is stopped"
        else
                STATUS_FLAG="0"
                echo "redis status is running"
        fi
}

start()
{
        status
        if [ "x$STATUS_FLAG" = "x0" ];then
                echo "redis is running,no need to start"
                return 0
        fi
        if [ "x$STATUS_FLAG" = "x1" ];then
            if [ "x$USER" = "xroot" ];then
                su - redis -c "cd $CUR_DIR;./redis-server ../redis.conf >> $LOG_FILE 2>&1"
                if [ "$?" -ne 0 ];then
					        echo "start redis failed please look log $LOG_FILE"
				        fi
            elif [ "x$USER" = "xredis" ];then
                cd "$CUR_DIR";./redis-server ../redis.conf >> "$LOG_FILE" 2>&1
				        if [ "$?" -ne 0 ];then
					        echo "start redis failed please look log $LOG_FILE"
					        return 1
				        fi
			      else
                echo "permisson denied,please start redis in root or redis"
                return 1
            fi
			  for _i in {0..20}
			  	do
			  		status
			  		 if [ "x$STATUS_FLAG" = "x1" ];then
			  			echo "starting redis...."
			  			sleep 10
			  		 else
			  			echo "starting redis success..."
			  			return 0
			  		fi
			  	done
      fi
}

stop()
{
        status
        if [ "x$STATUS_FLAG" = "x1" ];then
                echo "redis is stopped,no need to stop"
                return 0
        fi
        if [ "x$STATUS_FLAG" = "x0" ];then
            if [ "x$USER" = "xroot" ];then
                su - redis -c "cd $CUR_DIR;./redis-cli -p $APP_PORT  -h $APP_IP shutdown >> $LOG_FILE 2>&1"
                if [ "$?" -ne 0 ];then
					        echo "stop redis failed please look log $LOG_FILE"
					        exit 1
				        fi
            elif [ "x$USER" = "xredis" ];then
                cd $CUR_DIR;./redis-cli -p $APP_PORT  -h $APP_IP shutdown >> "$LOG_FILE" 2>&1
				        if [ "$?" -ne 0 ];then
					        echo "stop redis failed please look log $LOG_FILE"
					        exit 1
				        fi
			      else
                echo "permisson denied,please stop redis in user root or redis"
                exit 1
            fi
			for _i in {0..20}
				do
					status
					 if [ "x$STATUS_FLAG" = "x0" ];then
						echo "stopping redis...."
						sleep 10
					 else
						echo "stop redis success..."
						return 0
					fi
				done
        fi
}

restart()
{
        stop
        status
        start
}

version()
{
      if [ "x$USER" = "xroot" ];then
          su - redis -c "cd $CUR_DIR;./redis-server -v"

      elif [ "x$USER" = "xredis" ];then
          cd $CUR_DIR;./redis-server -v
			else
          echo "permisson denied,please query version in root or redis"
      fi
}
case "$1" in
        start)
                start
                ;;
        stop)
                stop
                ;;
        restart)
                restart
                ;;
        status)
                status
                ;;
        version)
                version
                ;;
        *)
                echo "use: rcredis {start|stop|restart|version}"
esac


