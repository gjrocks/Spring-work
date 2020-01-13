# Prepared by Ganesh Jadhav

FROM seeaganesh/gj-ubuntu16-openjdk8

MAINTAINER Ganesh Jadhav, ganesh.jadhav@mastek.com

#mkdir /opt/ganesh-work

WORKDIR /opt/ganesh-work

COPY ./target/user-details-service-0.0.1-SNAPSHOT.jar .

EXPOSE 7000/tcp

CMD java -Dlog.location=/opt/ganesh-work/log -jar /opt/ganesh-work/user-details-service-0.0.1-SNAPSHOT.jar
