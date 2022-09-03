tasks.bootJar { enabled = false }
tasks.jar { enabled = true }

dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-domain"))
    implementation(project(":template-application"))

    runtimeOnly("mysql:mysql-connector-java")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.h2database:h2")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}
