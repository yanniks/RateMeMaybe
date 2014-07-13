cd code
if [ ! -z $ANDROID_HOME ];then
mkdir -p libs
rm -f libs/android-support-v13.jar
cp $ANDROID_HOME/extras/android/support/v13/*.jar libs
ant debug
else
echo "No ANDROID_HOME set!"
exit 1
fi
cd ..
