plugins {
    id(Plugins.library)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {
    namespace = AppConfig.diNamespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":app"))

    implementation(Libraries.appLibraries)
    testImplementation(Libraries.junit)
}
