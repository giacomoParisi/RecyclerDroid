object Config {
    const val min_sdk = 21
    const val target_sdk = 27
    const val compile_sdk = 27
    const val version_code = 1
    const val version_name = "0.1"
}

object Versions {
    //** KOTLIN **//
    const val kotlin = "1.2.51"
    //** NETWORKING **//
    const val retrofit = "2.4.0"
    const val retrofitOkHttpInterceptor = "3.8.1"
    //** RX **//
    const val rx = "2.1.16"
    //** ARROW **//
    const val arrow = "0.7.2"
    //** DAGGER **//
    const val dagger = "2.16"
}

object Deps {

    //** KOTLIN **//
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    //** NETWORKING **//
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retorfitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retorfitOkHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitOkHttpInterceptor}"

    //** RX **//
    const val rx = "io.reactivex.rxjava2:rxjava:${Versions.rx}"

    //** ARROW **//
    const val arrowCore = "io.arrow-kt:arrow-core:${Versions.arrow}"
    const val arrowSintax = "io.arrow-kt:arrow-syntax:${Versions.arrow}"
    const val arrowTypeclasses = "io.arrow-kt:arrow-typeclasses:${Versions.arrow}"
    const val arrowData = "io.arrow-kt:arrow-data:${Versions.arrow}"
    const val arrowInstancesCore = "io.arrow-kt:arrow-instances-core:${Versions.arrow}"
    const val arrowInstancesData = "io.arrow-kt:arrow-instances-data:${Versions.arrow}"
    const val arrowAnnotations = "io.arrow-kt:arrow-annotations-processor:${Versions.arrow}"

    //** DAGGER **//
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerRuntime = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidSupportCompiler = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}