// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {

        classpath(GradlePlugin.Android.get())

        classpath(GradlePlugin.KotlinPlugin.get())

        classpath(GradlePlugin.Bintray.get())

        classpath(GradlePlugin.Versions.get())

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

apply(plugin = "com.github.ben-manes.versions")

allprojects {

    repositories {
        google()
        jcenter()
        mavenCentral()
    }



}

tasks {

    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}



tasks.named("dependencyUpdates", DependencyUpdatesTask::class.java).configure {

    //disallow release candidates as upgradable versions from stable versions
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }

    // optional parameters
    checkForGradleUpdate = true
    outputFormatter = "html"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"

}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
