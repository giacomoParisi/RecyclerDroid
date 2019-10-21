import kotlin.String
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version.
 */
object Versions {
    const val org_jetbrains_kotlin: String = "1.3.50"

    const val org_jetbrains_dokka: String = "0.9.18"

    const val com_android_tools_build_gradle: String = "3.5.1"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.7.0"

    const val android_maven_gradle_plugin: String = "2.1"

    const val gradle_bintray_plugin: String = "1.8.4"

    const val recyclerview: String = "1.0.0"

    const val lint_gradle: String = "26.5.1"

    const val aapt2: String = "3.5.1-5435860"

    /**
     * Current version: "5.6.3"
     * See issue 19: How to update Gradle itself?
     * https://github.com/jmfayard/buildSrcVersions/issues/19
     */
    const val gradleLatestVersion: String = "5.6.3"
}

/**
 * See issue #47: how to update buildSrcVersions itself
 * https://github.com/jmfayard/buildSrcVersions/issues/47
 */
val PluginDependenciesSpec.buildSrcVersions: PluginDependencySpec
    inline get() =
            id("de.fayard.buildSrcVersions").version(Versions.de_fayard_buildsrcversions_gradle_plugin)
