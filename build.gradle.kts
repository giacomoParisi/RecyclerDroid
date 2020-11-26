// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {
    val kotlin_version by extra("1.4.20")
    repositories {
        google()
        jcenter()
    }
    dependencies {

        classpath(GradlePlugins.android)

        classpath(GradlePlugins.kotlin)

        classpath(GradlePlugins.bintray)

        classpath(GradlePlugins.versions)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

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

    // optional parameters
    checkForGradleUpdate = true
    outputFormatter = "html"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"
}

