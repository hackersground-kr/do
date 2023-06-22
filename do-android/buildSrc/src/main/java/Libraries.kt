import org.gradle.api.artifacts.dsl.DependencyHandler

object Libraries {

    // ui
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val material = "com.google.android.material:material:${Versions.material}"
    private val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    private val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navSafeArgs}"
    private val nav = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private val navCompose = "androidx.navigation:navigation-compose:2.5.3"
    private val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"
    private val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
    private val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"
    private val indicator = "com.tbuonomo:dotsindicator:${Versions.indicator}"
    private val viewPager = "androidx.viewpager2:viewpager2:${Versions.viewPager}"
    private val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    private val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}" // *
    private val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.4"

    // room
    private val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    private val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}" // *

    // network
    private val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    private val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    private val gson = "com.google.code.gson:gson:${Versions.gson}"

    // hilt
    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}" // *
    val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    // map
    private val googleLocation = "com.google.android.gms:play-services-location:${Versions.googleLocation}"
    val googleGms = "com.google.gms:google-services:${Versions.googleGms}"
    private val naverMap = "com.naver.maps:map-sdk:${Versions.naverMap}"
    private val clustering = "io.github.ParkSangGwon:tedclustering-naver:1.0.2"

    // coroutine
    private val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    private val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    // test
    val junit = "junit:junit:${Versions.junit}"
    private val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    val androidLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(material)
        add(constraint)
        add(lottie)
        add(nav)
        add(navUiKtx)
        add(navCompose)
        add(splashScreen)
        add(swipeRefreshLayout)
        add(circleImageView)
        add(indicator)
        add(viewPager)
        add(glide)
        add(fragmentKtx)
    }

    val coroutineLibraries = arrayListOf<String>().apply {
        add(coroutineCore)
        add(coroutineAndroid)
    }

    val roomLibraries = arrayListOf<String>().apply {
        add(roomRuntime)
    }

    val networkLibraries = arrayListOf<String>().apply {
        add(retrofit)
        add(gsonConverter)
        add(okhttp)
        add(loggingInterceptor)
        add(gson)
    }

    val mapLibraries = arrayListOf<String>().apply {
        add(naverMap)
        add(googleLocation)
        add(clustering)
    }

    val appLibraries = arrayListOf<String>().apply {
        add(coreKtx)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(extJunit)
        add(espressoCore)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}