FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/phila-web-store.jar phila-web-store.jar
ENTRYPOINT ["java", "-jar", "phila-web-store.jar"]
