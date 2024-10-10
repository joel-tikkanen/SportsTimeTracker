FROM ubuntu:latest
LABEL authors="joeltikkanen"

WORKDIR /app

COPY target/SportsTimeTracker-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["top", "-b"]