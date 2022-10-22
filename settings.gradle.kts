
rootProject.name = "ForumiaBackend"

include(":core")
include(":data")


include(":auth:api")
include(":auth:impl:firebase")


dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}