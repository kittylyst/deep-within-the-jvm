plugins {
  `java`
  `application`
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

dependencies {
  implementation("org.ow2.asm:asm:9.2")
  implementation("org.ow2.asm:asm-commons:9.2")
  implementation("org.slf4j:slf4j-api:1.7.32")


  // NOTE The use of implementation() rather than testImplementation() here...
  implementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}

tasks.withType<JavaCompile> {
  options.compilerArgs = listOf()
}

tasks.jar {
  manifest {
    attributes("Main-Class" to "Foo")
  }
}