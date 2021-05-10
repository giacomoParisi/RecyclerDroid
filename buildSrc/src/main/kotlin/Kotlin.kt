object Kotlin : DependencyGroup("org.jetbrains.kotlin", "1.4.32") {

    object StdLib : Dependency(Kotlin.group, "kotlin-stdlib", Kotlin.version)

}