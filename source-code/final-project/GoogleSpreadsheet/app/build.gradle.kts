plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
}

fun getField(field: String): String {
	val items = HashMap<String, String>()
	val file = rootProject.file("apikey.properties")
	(file.exists()).let {
		file.forEachLine {
			items[it.split("=")[0]] = it.split("=")[1]
		}
	}
	return items[field]!!
}

android {
	namespace = "com.droidcon.googlespreadsheet"
	compileSdk = 33

	defaultConfig {
		applicationId = "com.droidcon.googlespreadsheet"
		minSdk = 24
		targetSdk = 33
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}

		buildConfigField("String", "SHEET_ID", getField("SHEET_ID"))
		buildConfigField("String", "RANGE", getField("RANGE"))
		buildConfigField("String", "API_KEY", getField("API_KEY"))
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
	buildFeatures {
		compose = true
		buildConfig = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.4.3"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation("androidx.core:core-ktx:1.9.0")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
	implementation("androidx.activity:activity-compose:1.7.2")
	implementation(platform("androidx.compose:compose-bom:2023.03.00"))
	implementation("androidx.compose.ui:ui")
	implementation("androidx.compose.ui:ui-graphics")
	implementation("androidx.compose.ui:ui-tooling-preview")
	implementation("androidx.compose.material3:material3")
	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.5")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
	androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
	androidTestImplementation("androidx.compose.ui:ui-test-junit4")
	debugImplementation("androidx.compose.ui:ui-tooling")
	debugImplementation("androidx.compose.ui:ui-test-manifest")

	// Retrofit for network requests
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")

	// Import okHttp dependencies
	implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")
	implementation("com.squareup.okhttp3:okhttp:3.4.1")

	// Jetpack Compose
	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
	implementation("androidx.compose.runtime:runtime-livedata:1.0.4")
	implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")

	// Coroutines for asynchronous programming
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
}