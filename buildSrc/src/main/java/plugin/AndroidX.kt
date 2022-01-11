package plugin

private object AndroidXVersion {
    const val annotation = "1.2.0"
    const val appcompat = "1.2.0"
    const val card_view = "1.0.0"
    const val drawer_layout = "1.1.1"
    const val constraint_layout = "2.0.4"
    const val recyclerview = "1.2.0"
    const val multidex = "2.0.1"
    const val core_version = "1.3.2"
    const val lifecycle_version = "2.3.1"
    const val nav_version = "2.3.5"
    const val paging_version = "3.0.0"
    const val room_version = "2.3.0"
    const val work_version = "2.5.0"
    const val fragment = "1.3.4"
    const val hint = "2.36"
    const val startup = "1.0.0"
    const val swipe_refresh_layout = "1.1.0"
    const val viewpager2 = "1.0.0"
    const val webkit = "1.4.0"
}

/**
 * AndroidX 相关依赖
 * 最新版本可参考：https://developer.android.com/jetpack/androidx/versions?hl=zh-cn
 */
object AndroidX {
    val annotation = "androidx.annotation:annotation:${AndroidXVersion.annotation}"
    val appcompat = "androidx.appcompat:appcompat:${AndroidXVersion.appcompat}"
    val card_view = "androidx.cardview:cardview:${AndroidXVersion.card_view}"
    val drawer_layout = "androidx.drawerlayout:drawerlayout:${AndroidXVersion.drawer_layout}"
    val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${AndroidXVersion.constraint_layout}"
    val recyclerview = "androidx.recyclerview:recyclerview:${AndroidXVersion.recyclerview}"

    val multidex = "androidx.multidex:multidex:${AndroidXVersion.multidex}"

    //core
    val core = "androidx.core:core:${AndroidXVersion.core_version}"
    val core_ktx = "androidx.core:core-ktx:${AndroidXVersion.core_version}"

    //fragment
    val fragment = "androidx.fragment:fragment:${AndroidXVersion.fragment}"
    val fragment_ktx = "androidx.fragment:fragment-ktx:${AndroidXVersion.fragment}"

    //hilt
    val hilt_android = "com.google.dagger:hilt-android:${AndroidXVersion.hint}"
    val hilt_compiler = "com.google.dagger:hilt-compiler:${AndroidXVersion.hint}"

    //lifecycle kotlin版本
    val lifecycle_viewmodel_ktx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidXVersion.lifecycle_version}"
    val lifecycle_livedata_ktx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${AndroidXVersion.lifecycle_version}"
    val lifecycle_runtime_ktx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidXVersion.lifecycle_version}"
    val lifecycle_compiler =
        "androidx.lifecycle:lifecycle-compiler:${AndroidXVersion.lifecycle_version}"
    val lifecycle_common_java8 =
        "androidx.lifecycle:lifecycle-common-java8:${AndroidXVersion.lifecycle_version}"
    val lifecycle_service =
        "androidx.lifecycle:lifecycle-service:${AndroidXVersion.lifecycle_version}"
    val lifecycle_process =
        "androidx.lifecycle:lifecycle-process:${AndroidXVersion.lifecycle_version}"
    val lifecycle_reactivestreams_ktx =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${AndroidXVersion.lifecycle_version}"

    //lifecycle java版本
    val lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel:${AndroidXVersion.lifecycle_version}"
    val lifecycle_livedata =
        "androidx.lifecycle:lifecycle-livedata:${AndroidXVersion.lifecycle_version}"
    val lifecycle_runtime =
        "androidx.lifecycle:lifecycle-runtime:${AndroidXVersion.lifecycle_version}"


    // navigation java
    val navigation_fragment =
        "androidx.navigation:navigation-fragment:${AndroidXVersion.nav_version}"
    val navigation_ui = "androidx.navigation:navigation-ui:${AndroidXVersion.nav_version}"

    // navigation Kotlin
    val navigation_fragment_ktx =
        "androidx.navigation:navigation-fragment-ktx:${AndroidXVersion.nav_version}"
    val navigation_ui_ktx =
        "androidx.navigation:navigation-ui-ktx:${AndroidXVersion.nav_version}"

    //paging
    val paging_runtime = "androidx.paging:paging-runtime:${AndroidXVersion.paging_version}"
    val paging_rxjava2 = "androidx.paging:paging-rxjava2:${AndroidXVersion.paging_version}"
    val paging_rxjava3 = "androidx.paging:paging-rxjava3:${AndroidXVersion.paging_version}"

    //room
    val room_runtime = "androidx.room:room-runtime:${AndroidXVersion.room_version}"
    val room_compiler = "androidx.room:room-compiler:${AndroidXVersion.room_version}"
    val room_common = "androidx.room:room-common:${AndroidXVersion.room_version}"
    val room_ktx = "androidx.room:room-ktx:${AndroidXVersion.room_version}"
    val room_rxjava2 = "androidx.room:room-rxjava2:${AndroidXVersion.room_version}"
    val room_rxjava3 = "androidx.room:room-rxjava3:${AndroidXVersion.room_version}"

    val startup_runtime = "androidx.startup:startup-runtime:${AndroidXVersion.startup}"
    val swipe_refresh_layout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${AndroidXVersion.swipe_refresh_layout}"
    val viewpager2 = "androidx.viewpager2:viewpager2:${AndroidXVersion.viewpager2}"
    val webkit = "androidx.webkit:webkit:${AndroidXVersion.webkit}"

    //work
    val work_runtime = "androidx.work:work-runtime:${AndroidXVersion.work_version}"
    val work_runtime_ktx = "androidx.work:work-runtime-ktx:${AndroidXVersion.work_version}"
    val work_rxjava2 = "androidx.work:work-rxjava2:${AndroidXVersion.work_version}"
}