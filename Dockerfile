#FROM java:8 #java:8这个镜像体积有643MB,打包镜像后体积太大了,不建议使用
# openjdk:8-jre-alpine 体积最小,只有85MB
FROM openjdk:8-jre-alpine
# 以下2个RUN解决 java验证码接口报错的问题,
RUN echo -e "https://mirror.tuna.tsinghua.edu.cn/alpine/v3.4/main\n\
https://mirror.tuna.tsinghua.edu.cn/alpine/v3.4/community" > /etc/apk/repositories
RUN apk --update add curl bash ttf-dejavu && \
      rm -rf /var/cache/apk/*
COPY . /opt/app
WORKDIR /opt/app
