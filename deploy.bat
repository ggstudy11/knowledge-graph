@echo off

:: 构建镜像
echo Building Docker images...
docker-compose build

:: 推送镜像到 Docker Hub
echo Pushing gateway-service to Docker Hub...
docker push ggstudy11/kg-gateway:latest

echo Pushing user-service to Docker Hub...
docker push ggstudy11/kg-userservice:latest

echo Pushing file-service to Docker Hub...
docker push ggstudy11/kg-fileservice:latest

echo Pushing file-service to Docker Hub...
docker push ggstudy11/kg-blogservice:latest

echo All images have been successfully pushed to Docker Hub!

pause
