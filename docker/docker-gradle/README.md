## Building

To build the images follow these steps:

```
./gradlew installDist
docker build -t docker-gradle .
```

The image may be run then with this command:

```
docker run docker-gradle
```

To poke around in the container, we can start up a shell instead of the default `CMD`

```
docker run -it docker-gradle bash
```

## Ports

With an HTTP server, we can access it from outside the container if we share the port and use bridged networking.

```
docker run -p 8080:8080 --network bridge docker-gradle
```

```
curl http://localhost:8080/hello

Hello from HttpServer
```

## Debugging with IDE

This relies on the `JAVA_OPTS` environment variable that's part of the Gradle
startup scripts

For IntelliJ, this then requires setting up a Remote JVM Debug run configuration
pointed to port 8090.

```
docker run \
  -p 8090:8090 --network bridge \
  -e JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8090 \
  docker-gradle
```

Should see this in the output when starting when it worked correctly in container:

```
Listening for transport dt_socket at address: 8090
```
