#!/bin/sh

# Setup variables
EXEC=/Users/chende/Documents/jsvc
JAVA_HOME=/Users/chende/Documents/zulu8.50.0.1017-ca-jdk8.0.275-macos_aarch64/zulu-8.jdk/Contents/Home
CLASS_PATH="/Users/chende/Documents/commons-daemon-1.2.3.jar":"/Users/chende/Documents/dir/jsvc-demo-1.0.0.jar"
CLASS=top.chende.Application
USER=chende
PID=/Users/chende/Documents/temp.pid
LOG_OUT=/Users/chende/Documents/tmp.out
LOG_ERR=/Users/chende/Documents/temp.err
ARGS="$*"

do_exec()
{
    $EXEC -home "$JAVA_HOME" -cp $CLASS_PATH -user $USER -outfile $LOG_OUT -errfile $LOG_ERR -pidfile $PID $1 $CLASS $ARGS
}

case "$1" in
    start)
        do_exec
            ;;
    stop)
        do_exec "-stop"
            ;;
    restart)
        if [ -f "$PID" ]; then
            do_exec "-stop"
            do_exec
        else
            echo "service not running, will do nothing"
            exit 1
        fi
            ;;
    *)
            echo "usage: luckyelephant {start|stop|restart}" >&2
            exit 3
            ;;
esac