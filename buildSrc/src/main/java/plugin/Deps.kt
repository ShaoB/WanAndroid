package plugin

object Versions {

    const val material = "1.2.1"
    const val okhttp = "4.9.1"
    const val retrofit = "2.9.0"
    const val adapter_retrofit = "2.9.0"
    const val retrofit_converter_gson = "2.9.0"
    const val retrofit_converter_moshi = "2.9.0"
    const val retrofit_converter_simplexml = "2.9.0"
    const val okhttp_logging_interceptor = "4.9.0"

    const val rxjava3 = "3.0.13"
    const val rxandroid = "3.0.0"

    const val glide = "4.12.0"
    const val glideCompiler = "4.12.0"

    const val gson = "2.8.7"

    const val util_code = "1.31.0"

}

/**
 * 一些常用的第三方依赖
 */
object Deps {

    val materia = "com.google.android.material:material:${Versions.material}"

    //okhttp
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    //retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val adapter_rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:${Versions.adapter_retrofit}"
    val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_converter_gson}"
    val converter_moshi =
        "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_converter_moshi}"
    val converter_simplexml =
        "com.squareup.retrofit2:converter-simplexml:${Versions.retrofit_converter_simplexml}"
    val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor}"

    //rxjava
    val rxjava3 = "io.reactivex.rxjava3:rxjava:${Versions.rxjava3}"

    //rxandroid
    val rxandroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxandroid}"

    //glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"

    //gson
    val gson = "com.google.code.gson:gson:${Versions.gson}"

    //util_codex
    var util_code = "com.blankj:utilcodex:${Versions.util_code}"

    //阿里路由 组件
    val aroute = "com.alibaba:arouter-api:1.5.2"
    val aroute_processor = "com.alibaba:arouter-compiler:1.5.2"

    //微信mmkv
    val mmkv = "com.tencent:mmkv-static:1.2.11"
}