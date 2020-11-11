// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {

        classpath(GradlePlugins.android)

        classpath(GradlePlugins.kotlin)

        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")

        classpath(GradlePlugins.bintray)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

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

