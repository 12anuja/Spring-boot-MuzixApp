
FROM java:8-jre
WORKDIR usr/src
VOLUME /tmp
ADD ./target/MuzixApp--complete-on-desktop-0.0.1-SNAPSHOT.jar usr/src/MuzixApp--complete-on-desktop-0.0.1-SNAPSHOT.jar
EXPOSE 8080
RUN bash -c ‘touch /app.jar’
ENTRYPOINT [“java”,”-Dspring.data.mongodb.uri=mongodb://mongo/mongodb”, “-Djava.security.egd=file:/dev/./urandom”,”-jar”,”MuzixApp--complete-on-desktop-0.0.1-SNAPSHOT.jar”]

