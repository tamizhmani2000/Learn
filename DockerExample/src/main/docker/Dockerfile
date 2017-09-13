FROM java:8
EXPOSE 80
VOLUME /tmp
ADD build/libs/gs-spring-boot-0.1.0 app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
