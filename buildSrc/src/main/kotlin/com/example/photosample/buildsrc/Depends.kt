package com.example.photosample.buildsrc

object Depends {

    object Versions {
        const val appVersionCode = 1
        const val appVersionName = "1.0.0"
        const val gradleVersion = "7.3.0"
        const val google_service = "4.3.15"
        const val firebase_bom = "31.2.3"
        const val fcm = "23.0.3"
        const val androidCompileSdkVersion = 32
        const val targetSdkVersion = 32
        const val minSdkVersion = 21
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val kotlinVersion = "1.7.20"
        const val rxKotlinVersion = "3.0.1"
        const val rxAndroidVersion = "3.0.0"
        const val rxJavaVersion = "3.1.5"
        const val rxBinding = "4.0.0"
        const val retrofit2Version = "2.9.0"
        const val glide = "4.15.1"

        const val okhttpLoggingVersion = "5.0.0-alpha.10"
        const val gsonVersion = "2.9.1"
        const val jetpack_room = "2.3.0"
        const val retrofitConverterGson = "2.9.0"
        const val lifecycleVersion = "2.5.1"
        const val constraintLayoutVersion = "2.1.3"
        const val supportVersion = "1.4.1"
        const val diskLrucache = "2.0.2"
        const val materialVersion = "1.4.0"
        const val viewPager2Version = "2:1.0.0"
        const val coreKtxVersion = "1.8.0"
        const val navigationVersion = "2.5.2"
        const val pagingVersion = "3.1.1"
        const val multidexVersion = "2.0.1"
        const val fragmentExtVersion = "1.4.0"
        const val recyclerviewVersion = "1.3.0-alpha02"
        const val hiltVersion = "2.44"
        const val hiltCompilerVersion = "1.0.0"
        const val hiltNavigationComposeVersion = "1.0.0-alpha03"
        const val javaxInjectVersion = "1"
        const val coroutinesAndroidVersion = "1.6.4"

        const val espressoVersion = "3.4.0"
        const val junitVersion = "4.13.2"
        const val supportTestVersion = "1.4.0"
        const val testCoreVersion = "1.4.0"
        const val testExtJunitVersion = "1.1.3"
    }

    object ClassPaths {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
        const val kotlin_gradle_plugin = "gradle-plugin"
        const val navigation_safe_args_gradle_plugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"

        const val hilt_android_gradle_plugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
        const val google_service = "com.google.gms:google-services:${Versions.google_service}"
    }

    object Libraries {
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
        const val kotlin_reflect =
            "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
        const val multidex = "androidx.multidex:multidex:${Versions.multidexVersion}"
        const val firebase_bom = "com.google.firebase:firebase-bom:${Versions.firebase_bom}"
        const val fcm = "com.google.firebase:firebase-messaging-ktx:${Versions.fcm}"
        const val firebase_analytics = "com.google.firebase:firebase-analytics-ktx"
        const val hilt_android =
            "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val hilt_android_compiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
        const val hilt_compiler =
            "androidx.hilt:hilt-compiler:${Versions.hiltCompilerVersion}"
        const val fragment_ktx =
            "androidx.fragment:fragment-ktx:${Versions.fragmentExtVersion}"
        const val android_core_ktx =
            "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val view_pager2 = "androidx.viewpager2:viewpager${Versions.viewPager2Version}"
        const val paging_runtime_ktx =
            "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}"
        const val paging_rx =
            "androidx.paging:paging-rxjava3:${Versions.pagingVersion}"
        const val java_inject = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
        const val retrofit_adapter_rx =
            "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit2Version}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2Version}"
        const val logging_interceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val test_runner = "androidx.test:runner:${Versions.supportTestVersion}"
        const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
        const val converter_gson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverterGson}"
        const val room = "androidx.room:room-runtime:${Versions.jetpack_room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.jetpack_room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.jetpack_room}"
        const val roomRx = "androidx.room:room-rxjava2:${Versions.jetpack_room}"
        const val roomTesting = "androidx.room:room-testing:${Versions.jetpack_room}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.supportVersion}"
        const val diskLruCache = "com.jakewharton:disklrucache:${Versions.diskLrucache}"
        const val rx_kotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxKotlinVersion}"
        const val rx_java = "io.reactivex.rxjava3:rxjava:${Versions.rxJavaVersion}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val lifecycle_livedata =
            "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycleVersion}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val navigation_fragment_ktx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
        const val navigation_ui_ktx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
        const val commonKtx_navigation = "androidx.navigation:navigation-common-ktx:${Versions.navigationVersion}"
        const val lifecycle_livedata_ktx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val lifecycle_common =
            "androidx.lifecycle:lifecycle-common:${Versions.lifecycleVersion}"
        const val lifecycle_viewmodel_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.recyclerviewVersion}"
        const val rx_java_android = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroidVersion}"
        const val rx_binding3 = "com.jakewharton.rxbinding4:rxbinding:${Versions.rxBinding}"
        const val coroutines_android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidVersion}"
    }
}