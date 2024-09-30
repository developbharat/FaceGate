plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinx.serialization)
    id("app.cash.sqldelight") version "2.0.2"
}

android {
    namespace = "com.developbharat.facegate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.developbharat.facegate"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true // enable support for modern apis
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // core library desugaring
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    // core androidx + compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // material3
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)


    // compose navigation
    implementation(libs.compose.navigation)
    implementation(libs.compose.hilt.navigation)
    implementation(libs.kotlinx.serialization.json)

    // di - dagger hilt
    implementation(libs.javax.inject)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    kspAndroidTest(libs.hilt.compiler)

    // retrofit + gson
//    implementation(libs.retrofit)
//    implementation(libs.retrofit.gson)
//    implementation(libs.okhttp.interceptor)
    implementation(libs.gson)

    // camera
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.video)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.extensions)

    // sqlite database + sqldelight
    implementation(libs.sqlcipher)
    implementation(libs.sqldelight.android.driver)

    // TODO: Replace with custom build of onnxruntime to reduce and optimise performance
    // https://onnxruntime.ai/docs/build/custom.html
    // https://onnxruntime.ai/docs/tutorials/mobile/#optimize-your-application
    implementation(libs.onnxruntime.android)
}

sqldelight {
    databases {
        create("Database") {
            packageName.set(android.defaultConfig.applicationId)
        }
    }
}
