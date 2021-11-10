FROM eclipse-temurin:11-jdk

# /opt/app is where we'll place all of our stuff to run
RUN mkdir /opt/app

# We grab all our contents from where Maven puts them
# This assumes that we've run `mvn package dependency:copy-dependencies`
COPY target/*.jar /opt/app/
COPY target/dependency/*.jar /opt/app/

# Runs our application directly from the directory we copied our JAR files to
WORKDIR /opt/app
CMD ["java", "-cp", "./*", "com.wellgrounded.Main"]
