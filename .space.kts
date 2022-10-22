/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Build and run tests") {
    container(displayName = "Gradle build", image = "openjdk:18") {
        kotlinScript { api ->
            // here goes complex logic
            api.gradlew("build")
        }
    }
    startOn {
        gitPush {
            enabled = true
        }
    }
}
