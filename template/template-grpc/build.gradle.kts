import com.google.protobuf.gradle.id

plugins {
    id("java")
    id("com.google.protobuf")
}

dependencies {
    val grpcSpringBootStarterVersion = "5.0.0"
    val protobufJavaVersion = "3.21.12"
    val ioGrpcVersion = "1.53.0"

    // grpc
    implementation("io.github.lognet:grpc-spring-boot-starter:$grpcSpringBootStarterVersion")
    implementation("com.google.protobuf:protobuf-java:$protobufJavaVersion")
    implementation("io.grpc:grpc-stub:$ioGrpcVersion")
    implementation("io.grpc:grpc-protobuf:$ioGrpcVersion")

    if (JavaVersion.current().isJava9Compatible) {
        // Workaround for @javax.annotation.Generated
        // see: https://github.com/grpc/grpc-java/issues/3633
        implementation("javax.annotation:javax.annotation-api:1.3.2")
    }
}

protobuf {
    val protocVersion = "3.21.12"
    val protocGenGrpcJavaVersion = "1.52.0"

    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:$protocVersion"
    }

    plugins {
        // Optional: an artifact spec for a protoc plugin, with "grpc" as
        // the identifier, which can be referred to in the "plugins"
        // container of the "generateProtoTasks" closure.
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$protocGenGrpcJavaVersion"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                // Apply the "grpc" plugin whose spec is defined above, without
                // options. Note the braces cannot be omitted, otherwise the
                // plugin will not be added. This is because of the implicit way
                // NamedDomainObjectContainer binds the methods.
                id("grpc") { }
            }
        }
    }
}
