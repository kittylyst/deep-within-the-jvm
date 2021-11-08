FROM docker.io/openjdk:11
RUN mkdir /app
COPY target/ /app
WORKDIR /app
CMD ["java", "-Xmx1G", "-XX:StartFlightRecording=duration=180s,filename=hyperalloc.jfr", "-jar", "HyperAlloc-1.0.jar", "-a", "128", "-h", "1024", "-d", "180"]