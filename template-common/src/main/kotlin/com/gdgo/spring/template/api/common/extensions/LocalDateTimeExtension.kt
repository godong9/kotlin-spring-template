package com.gdgo.spring.template.api.common.extensions

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

// LocalDateTime -> UTC Unix Timestamp Milliseconds
fun LocalDateTime.toMillis(): Long = this.toInstant(ZoneOffset.UTC).toEpochMilli()

// Unix Timestamp Milliseconds -> UTC LocalDateTime
fun Long.toLocalDateTime(): LocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneOffset.UTC)
