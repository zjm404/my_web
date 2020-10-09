FROM openjdk:8-jdk-alpine
#MAINTAINER myweb <zjm404@foxmail.com>
RUN apk update
RUN apk upgrade
EXPOSE 80
VOLUME /tmp/my_web
ADD my_web-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=prod"]