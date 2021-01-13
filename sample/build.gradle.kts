plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    /* --- recycler droid --- */
    implementation(project(":core"))

    /* --- kotlin --- */
    implementation(Kotlin.StdLib.get())
    implementation(KotlinX.Coroutines.Core.get())
    implementation(KotlinX.Coroutines.Android.get())

    /* --- android --- */
    implementation(AndroidX.Core.CoreKtx.get())
    implementation(AndroidX.AppCompat.get())
    implementation(AndroidX.ConstraintLayout.get())
    implementation(AndroidX.RecyclerView.get())
    implementation(Google.Material.get())
    implementation(AndroidX.Navigation.FragmentKtx.get())
    implementation(AndroidX.Navigation.UIKtx.get())
    implementation(AndroidX.Paging.Runtime.get())
    implementation(AndroidX.Lifecycle.ViewModelKtx.get())
    implementation(AndroidX.Lifecycle.LiveDataKtx.get())


}