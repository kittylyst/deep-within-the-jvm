To build the images follow these steps:

```
mvn package dependency:copy-dependencies
podman build -t docker-maven .
```

The image may be run then with this command:

```
podman run docker-maven
```

To poke around in the container, we can start up a shell instead of the default `CMD`

```
podman run -it docker-maven bash
```
