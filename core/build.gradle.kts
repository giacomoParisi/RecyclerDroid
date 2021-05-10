import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("maven-publish")

}
group = "com.github.giacomoparisi"

android {
    compileSdk = AndroidConfig.compile_sdk
    defaultConfig {
        minSdk = AndroidConfig.min_sdk
        targetSdk = AndroidConfig.target_sdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    /* --- kotlin --- */
    implementation(Kotlin.StdLib.get())

    /* --- android --- */
    implementation(AndroidX.RecyclerView.get())
    implementation(AndroidX.Paging.Runtime.get())

}

tasks {

    register("androidSourcesJar", Jar::class) {
        archiveClassifier.set("sources")
        from(project.android.sourceSets.getByName("main").java.name)
    }

}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {

                artifact("$buildDir/outputs/aar/${project.name}-release.aar")
                artifact(tasks.getByName("androidSourcesJar"))
                // You can then customize attributes of the publication as shown below.
                group = "com.github.giacomoparisi"
                artifactId = "recycler-droid"
                version = "1.8.0-beta13"
            }
        }
    }
}