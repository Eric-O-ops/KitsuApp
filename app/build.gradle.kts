import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")

    // Kapt
    id ("kotlin-kapt")
    // Hilt
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.kitsuapperic"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.kitsuapperic"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures.viewBinding = true
}

dependencies {

    // Core
    implementation("androidx.core:core-ktx:1.7.0")

    // Appcompat
    implementation("androidx.appcompat:appcompat:1.5.1")

    // Material
    implementation("com.google.android.material:material:1.7.0")

    // Constraint layout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // ViewBinding Property Delegate
    val view_binding_property_delegate = "1.4.7"
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    // Navigation
    val nav_version = "2.5.2"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")

    // Retrofit 2
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    // Glide
    val glide_version = "4.14.2"
    implementation("com.github.bumptech.glide:glide:$glide_version")
    annotationProcessor("com.github.bumptech.glide:compiler:$glide_version")

    // Kotlin_activity
    val activity_version = "1.3.0"
    implementation("androidx.activity:activity-ktx:$activity_version")

    // Kotlin_fragment
    val fragment_version = "1.3.6"
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.6")
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Paging 3
    implementation("androidx.paging:paging-runtime-ktx:3.1.1")

    // Hilt
    val hilt_version = "2.42"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
}