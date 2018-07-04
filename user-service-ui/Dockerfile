# Prepared by Ganesh Jadhav

FROM seeaganesh/java8-172-centos

MAINTAINER Ganesh Jadhav, ganesh.jadhav@mastek.com

ADD ./target/spring-boot-web-jsp-1.0.war /opt/ganesh-work

CMD /usr/java/latest/bin/java -Dlog.location=/opt/ganesh-work/log -jar /opt/ganesh-work/spring-boot-web-jsp-1.0.war