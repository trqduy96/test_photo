import com.example.photosample.buildsrc.Depends
plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        multiDexEnabled = true
        applicationId = "com.example.photosample"
        minSdk = Depends.Versions.minSdkVersion
        targetSdk = Depends.Versions.targetSdkVersion
        versionCode = Depends.Versions.appVersionCode
        versionName = Depends.Versions.appVersionName
        testInstrumentationRunner =
            Depends.Versions.testInstrumentationRunner
        javaCompileOptions.annotationProcessorOptions.arguments += mapOf(
            "room.schemaLocation" to "$projectDir/schemas"
        )
    }
    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
    buildTypes {
        named("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
            signingConfig = signingConfigs.getByName("debug")
        }
        named("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    viewBinding.isEnabled = true
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    lintOptions {
        isAbortOnError = false
    }
    //testOptions.unitTests.returnDefaultValues = true
    packagingOptions {
        exclude("META-INF/rxjava.properties")
        exclude("META-INF/proguard/androidx-annotations.pro")
        resources.excludes += "DebugProbesKt.bin"
    }
}

dependencies {
    implementation(Depends.Libraries.kotlin)
    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.multidex)
    implementation(Depends.Libraries.fragment_ktx)
    implementation(Depends.Libraries.paging_runtime_ktx)
    implementation(Depends.Libraries.paging_rx)
    implementation(Depends.Libraries.coroutines_android)
    implementation(Depends.Libraries.material)
    //dependency injection
    implementation(Depends.Libraries.hilt_android)
    kapt(Depends.Libraries.hilt_android_compiler)
    kapt(Depends.Libraries.hilt_compiler)
    implementation(Depends.Libraries.java_inject)
    //network
    implementation(Depends.Libraries.retrofit)
    implementation(Depends.Libraries.retrofit_adapter_rx)
    implementation(Depends.Libraries.logging_interceptor)

    testImplementation(Depends.Libraries.junit)
    androidTestImplementation(Depends.Libraries.test_runner)
    androidTestImplementation(Depends.Libraries.espresso_core)

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))
}