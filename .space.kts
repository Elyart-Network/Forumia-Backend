/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Hello World!") {
    host("Run Hello World") {
        shellScript {
        	content = """
                echo Hello World!
            """
        }
    }
}
