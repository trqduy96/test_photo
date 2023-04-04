buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(com.example.photosample.buildsrc.Depends.ClassPaths.gradle)
        classpath(
            kotlin(
                com.example.photosample.buildsrc.Depends.ClassPaths.kotlin_gradle_plugin,
                version = com.example.photosample.buildsrc.Depends.Versions.kotlinVersion
            )
        )
        classpath(com.example.photosample.buildsrc.Depends.ClassPaths.navigation_safe_args_gradle_plugin)
        classpath(com.example.photosample.buildsrc.Depends.ClassPaths.hilt_android_gradle_plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.google.com/")
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}
