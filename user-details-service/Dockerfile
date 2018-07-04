# Prepared by Ganesh Jadhav

FROM seeaganesh/java8-172-centos

MAINTAINER Ganesh Jadhav, ganesh.jadhav@mastek.com

ADD ./target/user-details-service-0.0.1-SNAPSHOT.jar /opt/ganesh-work

CMD /usr/java/latest/bin/java -Dlog.location=/opt/ganesh-work/log -jar /opt/ganesh-work/user-details-service-0.0.1-SNAPSHOT.jar