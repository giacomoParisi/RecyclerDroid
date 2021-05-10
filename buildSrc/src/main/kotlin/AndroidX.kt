object AndroidX {

    object AppCompat : Dependency("androidx.appcompat", "appcompat", "1.2.0")

    object RecyclerView : Dependency("androidx.recyclerview", "recyclerview", "1.1.0")

    object FragmentKtx : Dependency("androidx.fragment", "fragment-ktx", "1.2.5")

    object Core : DependencyGroup("androidx.core", "1.3.2") {

        object CoreKtx : Dependency(Core.group, "core-ktx", Core.version)

    }

    object ConstraintLayout : Dependency("androidx.constraintlayout", "constraintlayout", "2.0.4")

    object Paging : DependencyGroup("androidx.paging", "3.0.0-alpha11") {

        object Runtime : Dependency(Paging.group, "paging-runtime", Paging.version)

    }

    object Navigation : DependencyGroup("androidx.navigation", "2.2.2") {

        object FragmentKtx :
            Dependency(Navigation.group, "navigation-fragment-ktx", Navigation.version)

        object UIKtx : Dependency(Navigation.group, "navigation-ui-ktx", Navigation.version)

    }

    object Lifecycle : DependencyGroup("androidx.lifecycle", "2.2.0") {

        object ViewModelKtx :
            Dependency(Lifecycle.group, "lifecycle-viewmodel-ktx", Lifecycle.version)


        object LiveDataKtx :
            Dependency(Lifecycle.group, "lifecycle-livedata-ktx", Lifecycle.version)


    }

}
