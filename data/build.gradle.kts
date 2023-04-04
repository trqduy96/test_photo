import com.example.photosample.buildsrc.Depends

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        multiDexEnabled = true
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
    testOptions.unitTests.isReturnDefaultValues = true
    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
    buildTypes {
        named("debug") {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api.thecatapi.com/\""
            )
            buildConfigField(
                "String",
                "API_KEY",
                "\"bbfb5b50-ec47-4276-8f08-71e3614acfed\""
            )
        }
        named("release") {
            isMinifyEnabled = true
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api.thecatapi.com/\""
            )
            buildConfigField(
                "String",
                "API_KEY",
                "\"bbfb5b50-ec47-4276-8f08-71e3614acfed\""
            )
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
    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.paging_runtime_ktx)
    implementation(Depends.Libraries.paging_rx)
    implementation(Depends.Libraries.multidex)
    //dependency injection
    implementation(Depends.Libraries.hilt_android)
    kapt(Depends.Libraries.hilt_android_compiler)
    kapt(Depends.Libraries.hilt_compiler)
    implementation(Depends.Libraries.java_inject)
    //parser
    implementation(Depends.Libraries.gson)
    api(Depends.Libraries.converter_gson)
    //network
    implementation(Depends.Libraries.retrofit)
    implementation(Depends.Libraries.retrofit_adapter_rx)
    implementation(Depends.Libraries.logging_interceptor)
    testImplementation(Depends.Libraries.junit)
    implementation(project(":domain"))
}