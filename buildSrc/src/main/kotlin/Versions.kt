import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew syncLibs`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val recyclerview: String = "1.0.0" 

    const val aapt2: String = "3.2.1-4818971" 

    const val com_android_tools_build_gradle: String = "3.2.1" 

    const val lint_gradle: String = "26.2.1" 

    const val android_maven_gradle_plugin: String = "2.1" 

    const val gradle_bintray_plugin: String = "1.8.4" 

    const val jmfayard_github_io_gradle_kotlin_dsl_libs_gradle_plugin: String = "0.2.6" 

    const val org_jetbrains_dokka: String = "0.9.17" 

    const val org_jetbrains_kotlin: String = "1.3.10" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "4.10.2"

        const val currentVersion: String = "5.0"

        const val nightlyVersion: String = "5.1-20181127143359+0000"

        const val releaseCandidate: String = ""
    }
}
