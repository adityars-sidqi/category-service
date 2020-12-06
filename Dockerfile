FROM java:8
EXPOSE 8081

VOLUME /tmp

COPY /target/category-service.jar app.jar

ENV JAVA_OPTS="-Xmx128m -Xms64m"
ENV SPRING_PROFILES_ACTIVE="docker"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]