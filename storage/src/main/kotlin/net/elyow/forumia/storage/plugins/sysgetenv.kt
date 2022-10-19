package net.elyow.forumia.storage.plugins

import java.io.File

object sysgetenv {
    private fun isFileExists(file: File): Boolean {
        return file.exists() && !file.isDirectory
    }
    private fun dot(): Map<String, String>? {
        if(isFileExists(File(".env"))) {
            return File(".env").readLines()
                .filterNot { it.startsWith("#") }
                .associate { val (k, v) = it.split("="); k to v }
        } else return null
    }
    operator fun get(key: String): String = System.getenv(key) ?: (dot()?.get(key) ?: error("Can't find $key in environment variables"))
}