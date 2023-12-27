plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = AppConfig.appNameSpace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.appNameSpace
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

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
}

dependencies {

    implementation(project(":presentation"))

    KTX.run {
        implementation(CORE)
    }

    AndroidX.run {
        implementation(APP_COMPAT)
        implementation(CONSTRAINT_LAYOUT)
        implementation(MATERIAL)
    }

    Test.run {
        implementation(JUNIT)
        androidTestImplementation(ANDROID_TEST)
        androidTestImplementation(ESPRESSO)
    }

}