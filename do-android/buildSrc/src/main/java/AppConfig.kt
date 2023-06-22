import org.gradle.api.JavaVersion

object AppConfig {
    const val appNamespace = "kr.hackersground.wsi.dodo"
    const val domainNamespace = "kr.hackersground.wsi.domain"
    const val dataNamespace = "kr.hackersground.wsi.data"
    const val diNamespace = "kr.hackersground.wsi.di"

    const val compileSdk = 33
    const val applicationId = "kr.hackersground.wsi.dodo"
    const val minSdk = 26
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val useSupportLibrary = true
    const val buildTypeName = "release"
    const val minifyEnabled = false
    const val defaultProguardFile = "proguard-android-optimize.txt"
    const val proguardConsumerRules =  "consumer-rules.pro"

    @JvmField val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.3.2"
    const val packagingOption = "/META-INF/{AL2.0,LGPL2.1}"
    const val enableDataBinding = true
}