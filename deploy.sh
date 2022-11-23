#!/bin/sh
DATASOURCE_URL=$1
DATASOURCE_USERNAME=$2
DATASOURCE_PASSWORD=$3
PORT=$4
NAME=$5
VERSION=$6

if [ $# != 6 ];
then
	echo "파라미터를 확인해주세요."
	echo "DATASOURCE_URL:$1"
	echo "DATASOURCE_USERNAME:$2"
	echo "DATASOURCE_PASSWORD:$3"
	echo "ACCESS_PORT:$4"
	echo "IMAGE_NAME:$5"
	echo "IMAGE_VERSION:$6"
	exit
fi

CONTAINER=$(docker ps -aq --filter "name=$NAME")

if [ -n "$CONTAINER" ];
then
	echo "컨테이너 종료"

	docker stop $CONTAINER

	echo "컨테이너 삭제"

	docker rm $CONTAINER
fi

IMAGE=$(docker images --filter=reference="$NAME" -q)

if [ -n "$IMAGE" ];
then
	docker rmi $IMAGE
fi

echo "git pull start." &&
git pull &&
echo "git pull done." &&
echo "docker image build" &&
docker build -t $NAME . &&
echo "docker image build done." &&
echo "docker container run" &&
docker run --name $NAME -p $PORT:8080 -e SPRING_DATASOURCE_URL=$DATASOURCE_URL -e SPRING_DATASOURCE_PASSWORD=$DATASOURCE_PASSWORD -e SPRING_DATASOURCE_USERNAME=$DATASOURCE_USERNAME $NAME:$VERSION