plugins {
    id(Plugins.library)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    namespace = AppConfig.dataNamespace
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
    implementation(projects.domain)

    implementation(Libraries.appLibraries)
    implementation(Libraries.coroutineLibraries)
    implementation(Libraries.roomLibraries)
    implementation(Libraries.networkLibraries)

    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompiler)
    kapt(Libraries.roomCompiler)

    testImplementation(Libraries.junit)
}
