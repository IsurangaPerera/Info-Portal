#!/usr/bin/env bash

PRE_REQ=1
HOME=`pwd`
MODEL_HOME="../../Info-Model/"

# Checking prerequisites for the build
command -v docker >/dev/null 2>&1 || { echo >&2 "Missing Docker!!! Build required docker install in the host. Try 'curl -sSL https://get.docker.com/ | sh' "; $PRE_REQ=1; }

if [ $PRE_REQ -eq 0 ];then
    echo "--------------------------------------------------------------"
    echo "All prerequisite not met. Existing build..."
    echo "--------------------------------------------------------------"
    exit;
fi

echo "--------------------------------------------------------------"
echo "Building information portal"
echo "--------------------------------------------------------------"
cd $HOME
cd $MODEL_HOME
mvn clean install -Dmaven.test.skip=true

# copy Info-Model
echo "--------------------------------------------------------------"
echo "Copy Info-Model"
echo "--------------------------------------------------------------"
cd $HOME
[ ! -d $HOME/portal ] && mkdir -p $HOME/portal
cp -f $MODEL_HOME/target/Info-Model-*.jar $HOME/packages/info-model.jar
#copy Dockerfile
cp -f ../../microservices/pet/container/docker/Dockerfile $HOME/portal/

docker-compose up --build
