object GradlePlugins {

    const val android: String = "com.android.tools.build:gradle:4.1.1"

    const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    const val bintray: String = "com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.5"

    const val versions: String = "com.github.ben-manes:gradle-versions-plugin:0.36.0"

}

object Kotlin {

    internal const val version: String = "1.4.20"

    private const val kotlin: String = "org.jetbrains.kotlin:"

    const val stdLib: String = "${kotlin}kotlin-stdlib:$version"

    object Coroutines {

        private const val version: String = "1.4.1"

        private const val coroutine: String = "org.jetbrains.kotlinx:kotlinx-coroutines"

        const val core: String = "$coroutine-core:$version"

        const val android: String = "$coroutine-android:$version"

    }

}

object AndroidX {

    private const val androidX: String = "androidx"

    const val recyclerView: String = "$androidX.recyclerview:recyclerview:1.1.0"

    const val coreKtx: String = "$androidX.core:core-ktx:1.3.2"

    const val appCompat: String = "$androidX.appcompat:appcompat:1.2.0"

    const val constraintLayout: String = "$androidX.constraintlayout:constraintlayout:2.0.4"

    const val paging: String = "$androidX.paging:paging-runtime:3.0.0-alpha09"

    object Navigation {

        private const val navigation: String = "$androidX.navigation:navigation"

        private const val navigationVersion: String = "2.3.1"

        const val fragmentKtx: String = "$navigation-fragment-ktx:$navigationVersion"
        const val uiKtx: String = "$navigation-ui-ktx:$navigationVersion"

    }

    object Lifecycle {

        private const val version: String = "2.2.0"

        private const val lifecycle: String = "$androidX.lifecycle:lifecycle"

        const val viewModel: String = "$lifecycle-viewmodel-ktx:$version"

        const val liveData: String = "$lifecycle-livedata-ktx:$version"

    }

}

object Google {

    const val material: String = "com.google.android.material:material:1.2.1"

}




