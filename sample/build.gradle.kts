plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(AndroidConfig.compile_sdk)
    defaultConfig {
        minSdkVersion(AndroidConfig.min_sdk)
        targetSdkVersion(AndroidConfig.target_sdk)
        versionCode = AndroidConfig.version_code
        versionName = AndroidConfig.version_name
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    /* --- kotlin --- */
    implementation(Kotlin.stdlib)

    /* --- android --- */
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.appCompat)
    implementation(Google.android.material)

    /* --- test --- */
    testImplementation(Kotlin.Test.junit)
    androidTestImplementation(AndroidX.Test.Ext.junitKtx)
    androidTestImplementation(AndroidX.Test.espresso.core)
}