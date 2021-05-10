object GradlePlugin {

    object Android : Dependency(
            "com.android.tools.build",
            "gradle",
            "7.0.0-alpha15"
    )

    object KotlinPlugin : Dependency(
            "org.jetbrains.kotlin",
            "kotlin-gradle-plugin",
            Kotlin.version
    )

    object Versions :
            Dependency(
                    "com.github.ben-manes",
                    "gradle-versions-plugin",
                    "0.36.0"
            )

}