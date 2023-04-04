import com.example.photosample.buildsrc.Depends

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        minSdk = Depends.Versions.minSdkVersion
        targetSdk = Depends.Versions.targetSdkVersion
        testInstrumentationRunner =
            Depends.Versions.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    sourceSets {
        val test by getting

        map {
            it.java.srcDir("src/${it.name}/kotlin")
            test.java.srcDir("${project(":domain").projectDir}/src/test/java")
        }
    }
    buildTypes {
        named("debug") { }
        named("release") {
            isMinifyEnabled = true
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
}

dependencies {

    implementation(Depends.Libraries.kotlin)
    implementation(Depends.Libraries.kotlin_reflect)

    //dependency injection
    implementation(Depends.Libraries.hilt_android)
    kapt(Depends.Libraries.hilt_android_compiler)
    kapt(Depends.Libraries.hilt_compiler)
    implementation(Depends.Libraries.java_inject)
    implementation(Depends.Libraries.glide)
    //android
    implementation(Depends.Libraries.appcompat)
    implementation(Depends.Libraries.constraintlayout)
    implementation(Depends.Libraries.material)
    implementation(Depends.Libraries.view_pager2)
    implementation(Depends.Libraries.navigation_fragment_ktx)
    implementation(Depends.Libraries.navigation_ui_ktx)
    implementation(Depends.Libraries.commonKtx_navigation)
    implementation(Depends.Libraries.paging_runtime_ktx)
    implementation(Depends.Libraries.paging_rx)
    implementation(Depends.Libraries.lifecycle_livedata_ktx)
    implementation(Depends.Libraries.lifecycle_runtime_ktx)
    implementation(Depends.Libraries.lifecycle_common)
    implementation(Depends.Libraries.lifecycle_viewmodel_ktx)
    implementation(Depends.Libraries.multidex)
    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.fragment_ktx)
    implementation(Depends.Libraries.recyclerview)
    implementation(Depends.Libraries.coroutines_android)
    //reactive
    implementation(Depends.Libraries.rx_java_android)
    implementation(Depends.Libraries.rx_binding3)
    implementation(Depends.Libraries.rx_kotlin)
    testImplementation(Depends.Libraries.junit)

    implementation(project(":domain"))
    implementation(project(":data"))
}