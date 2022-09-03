dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-application"))
    implementation(project(":template-adapter"))
    implementation(project(":template-domain"))

    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}
