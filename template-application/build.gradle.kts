tasks.bootJar { enabled = false }
tasks.jar { enabled = true }

dependencies {
    implementation(project(":template-common"))
    implementation(project(":template-domain"))
}
