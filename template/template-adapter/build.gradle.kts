tasks.bootJar { enabled = false }
tasks.jar { enabled = true }

apply(plugin = "kotlin-kapt")

dependencies {
    val querydslVersion = "5.0.0"

    implementation(project(":template:template-common"))
    implementation(project(":template:template-domain"))
    implementation(project(":template:template-application"))

    runtimeOnly("mysql:mysql-connector-java")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.h2database:h2")

    /* querydsl */
    implementation("com.querydsl:querydsl-jpa:$querydslVersion")
    implementation("com.querydsl:querydsl-core:$querydslVersion")
    implementation("com.querydsl:querydsl-apt:$querydslVersion")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jpa")

    /* querydsl */
    annotationProcessor("com.querydsl:querydsl-apt:$querydslVersion:jpa")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}
