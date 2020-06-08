FROM java:8
VOLUME /tmp
EXPOSE 10001
ADD target/flug-services-0.0.1-SNAPSHOT.jar /flug-services-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","flug-services-0.0.1-SNAPSHOT.jar"]
