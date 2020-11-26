object GradlePlugins {

    const val android: String = "com.android.tools.build:gradle:4.1.1"

    const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    const val bintray: String = "com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.5"

    const val versions: String = "com.github.ben-manes:gradle-versions-plugin:0.36.0"

}

object Kotlin {

    internal const val version: String = "1.4.20"

    const val stdLib: String = "org.jetbrains.kotlin:kotlin-stdlib:$version"

}

object AndroidX {

    private const val androidX: String = "androidx"

    const val recyclerView: String = "$androidX.recyclerview:recyclerview:1.1.0"

    const val coreKtx: String = "$androidX.core:core-ktx:1.3.2"

    const val appCompat: String = "$androidX.appcompat:appcompat:1.2.0"

}

object Google {

    const val material: String = "com.google.android.material:material:1.2.1"

}




