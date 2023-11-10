plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
}

android {

    namespace = Config.packageName

    compileSdk = 31
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
    }

    buildTypes {

        named("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile(name = "proguard-android.txt"), "proguard-rules.pro")
        }

        named("debug") {
            isDebuggable = false
            isShrinkResources = false
            isMinifyEnabled = false

            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraint)
    implementation(Dependencies.coroutinesAndroid)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.dataStore)
    implementation(Dependencies.viewBinding)
    implementation(Dependencies.cicerone)
    implementation(Dependencies.lifecycleViewModel)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpInterceptor)
    implementation(Dependencies.serializationJson)
    implementation(Dependencies.serializationConverter)
    implementation(Dependencies.dagger)
    implementation(Dependencies.coil)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.activityKtx)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeConstraint)
    implementation(Dependencies.accompanist)

    kapt(Dependencies.daggerCompiler)
}