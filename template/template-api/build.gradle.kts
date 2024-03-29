dependencies {
    val openapiVersion = "1.6.11"

    implementation(project(":template:template-common"))
    implementation(project(":template:template-application"))
    implementation(project(":template:template-adapter"))

    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("org.springdoc:springdoc-openapi-ui:$openapiVersion")
    implementation("org.springdoc:springdoc-openapi-kotlin:$openapiVersion")
}
