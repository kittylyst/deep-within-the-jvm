FROM eclipse-temurin:11-jdk

# /opt/app is where we'll place all of our stuff to run
RUN mkdir /opt/app

# We grab all our contents from the location Gradle's installDist places them
COPY build/install/docker-gradle /opt/app/

# Uses the generated startup script Gradle creates for us
WORKDIR /opt/app/bin
CMD ["./docker-gradle"]
