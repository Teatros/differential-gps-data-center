FROM openjdk:8-jdk-alpine
ADD differential-gps-data-center.jar /opt

ENTRYPOINT ["java","-jar","/opt/differential-gps-data-center.jar"]
