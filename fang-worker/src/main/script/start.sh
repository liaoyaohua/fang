baseDir=`dirname "$0"`
cd $baseDir
cd ..
echo `pwd`
nohup java -Xmx3072M -cp .:conf/*:lib/* com.jieduo.fang.worker.start.Start 1>/dev/null 2>&1 &