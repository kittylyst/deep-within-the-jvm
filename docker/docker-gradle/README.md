To build the images follow these steps:

```
./gradlew installDist
podman build -t docker-gradle .
```

The image may be run then with this command:

```
podman run docker-gradle
```

To poke around in the container, we can start up a shell instead of the default `CMD`

```
podman run -it docker-gradle bash
```
