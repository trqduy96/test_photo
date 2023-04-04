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
        freeCompilerArgs = freeCompilerArgs + listOf("-XXLanguage:+InlineClasses")
    }
    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
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
    //android
    implementation(Depends.Libraries.appcompat)
    implementation(Depends.Libraries.diskLruCache)
    implementation(Depends.Libraries.paging_runtime_ktx)
    implementation(Depends.Libraries.paging_rx)
    implementation(Depends.Libraries.fragment_ktx)
    implementation(Depends.Libraries.material)
    implementation(Depends.Libraries.view_pager2)
    implementation(Depends.Libraries.lifecycle_viewmodel_ktx)
    implementation(Depends.Libraries.multidex)

    //reactive
    implementation(Depends.Libraries.rx_kotlin)
    implementation(Depends.Libraries.rx_java)
    //dependency injection
    implementation(Depends.Libraries.java_inject)
    testImplementation(Depends.Libraries.junit)
}

repositories {
    mavenCentral()
}
