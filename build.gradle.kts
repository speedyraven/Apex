
import org.gradle.kotlin.dsl.debugImplementation
import org.gradle.kotlin.dsl.implementation
// App-level build.gradle.kts

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")

    id("org.jetbrains.kotlin.plugin.serialization")





    // Remove the duplicate declaration
    // id("kotlin-android") version "1.8.10"
    // id("kotlin-kapt") version "1.8.10"
}




android {
    namespace = "com.Zawadi.apex"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.Zawadi.apex"
        minSdk = 23
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        viewBinding=true
    }
}
repositories {
    google()
    mavenCentral()
}

dependencies {
    // AndroidX Dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.compose.material3)
    implementation(libs.zxing)

    // Jetpack Compose
    implementation(platform(libs.androidx.compose.bom)) // Compose BOM for version alignment
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material:material:1.6.0")
    implementation("androidx.compose.foundation:foundation:1.4.0")
    implementation("androidx.compose.material3:material3:1.0.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0")
    implementation("androidx.compose.material:material-icons-extended:1.4.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0")

    // Navigation
    implementation("androidx.navigation:navigation-runtime-ktx:2.8.9")
    implementation("androidx.navigation:navigation-compose:2.8.9")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.13.0"))
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation("com.google.firebase:firebase-auth:23.2.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)
    implementation("androidx.databinding:databinding-runtime:7.0.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")
    implementation ("com.stripe:stripe-android:20.9.0") // Check for the latest version
        implementation ("androidx.compose.ui:ui:1.5.0")
    // Compose UI library
        implementation ("androidx.compose.material:material:1.5.0")
    // Material design components
    implementation ("androidx.compose.compiler:compiler:1.4.3")

    // Kotlin standard library
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.10")

        implementation ("androidx.compose.material3:material3:1.0.0" )
    implementation("androidx.compose.material3:material3:1.2.1")

        implementation ("com.google.zxing:core:3.4.1") // Make sure the version matches the latest or the one you're using






// Add this line




        // Jetpack Compose UI toolkit
        implementation ("androidx.compose.ui:ui:1.4.3")
        implementation ("androidx.compose.material3:material3:1.0.0") // Material3 (if you are using it)
        implementation ("androidx.compose.material:material:1.4.3") // Material Design (if you're using Material2)

        // For images
        implementation ("androidx.compose.foundation:foundation:1.4.3")

        // For gradient backgrounds
        implementation ("androidx.compose.ui:ui-graphics:1.4.3") // Required for Brush
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation(libs.kotlinx.serialization.json)
    }






