plugins {
    id(Plugins.library)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
    id(Plugins.hilt)
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
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.app)

    implementation(Libraries.appLibraries)

    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompiler)

    testImplementation(Libraries.junit)
}
