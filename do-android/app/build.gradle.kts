plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

@Suppress("UnstableApiUsage")
android {
    namespace = AppConfig.appNamespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName(AppConfig.buildTypeName) {
            isMinifyEnabled =  AppConfig.minifyEnabled
            proguardFiles(getDefaultProguardFile(AppConfig.defaultProguardFile), AppConfig.proguardConsumerRules)
        }
    }
    compileOptions {
        sourceCompatibility(AppConfig.javaVersion)
        targetCompatibility(AppConfig.javaVersion)
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    dataBinding {
        enable = AppConfig.enableDataBinding
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Libraries.androidLibraries)
    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.testLibraries)
}