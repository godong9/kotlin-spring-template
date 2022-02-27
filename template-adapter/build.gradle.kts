tasks.bootJar { enabled = false }
tasks.jar { enabled = true }

dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-domain"))
    implementation(project(":template-application"))
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}
