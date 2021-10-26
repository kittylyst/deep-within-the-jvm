plugins {
  `java`
}

repositories {
  mavenCentral()
}

java {
    modularity.inferModulePath.set(true)
}

sourceSets {
  main {
    java {
      setSrcDirs(listOf("src/main/java/"))
    }
  }
}

tasks.withType<JavaCompile> {
  options.compilerArgs = listOf()
}

tasks.jar {
  manifest {
    attributes("Main-Class" to "Foo")
  }
}