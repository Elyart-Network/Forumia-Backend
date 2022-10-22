package net.elyow.forumia.storage.plugins

import java.io.File

object sysgetenv {
    private val dotEnv = runCatching {
        File(".env").readLines()
            .filterNot { it.startsWith("#") }
            .associate { val (k, v) = it.split("="); k to v }
    }.getOrElse { emptyMap() }

    operator fun get(key: String) = dotEnv[key] ?: System.getenv(key) ?: error("Can't find $key in environment variables")

}