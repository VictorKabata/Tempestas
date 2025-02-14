# Tempestas

An android app built using Kotlin that consumes [Open Call API 2.5](https://openweathermap.org/api/one-call-api) to get current day and 5 day weather forecast. The application also supports Kotlin Multiplatform by sharing logic and UI code.

An android app built using Kotlin that consumes [Open Call API 2.5](https://openweathermap.org/api/one-call-api) to get current day and 5 day weather forecast. The application also supports Kotlin Multiplatform by sharing logic and UI code.

## Prerequisite

To run the app from Android Studio on your local machine you'll need to add `api_key` value in your `local.properties` file

```local.properties
api_key = <YOUR_API_KEY>
```

> You can download the android debug variant app from [Firebase App Distribution link]()

# Architecture
The app has two modules; `shared` and `app`.

The app module has Jetpack compose components involved in displaying information to the user and android specific code. The main part of this layer is the main activity.

The shared module has shared logic to fetch weather information from network source, caches the data and mapping data transfer object(DTOs) to domain data classes. The shared module has 4 main packages:

- __Domain__ :This is the core of the application. The domain package code is independent of any other layers thus domain models and business logic can be independent from other layers.This means that changes in other layers will have no effect on domain layer eg. screen UI (presentation layer) or changing database (data layer) will not result in any code change in domain layer.

- __Data__: The data package has logic for selecting the proper data source between network source and cached data.

- __UI__: The UI package houses the UI code(screens, themes, navigation etc.) to display the data from domain layer using Jetpack Compose.

- __DI__: The DI package has a class that creates a Koin module

# Libraries
- [Koin](https://github.com/google/hilt) - Dependency Injection framework
- [Jetpack compose](https://developer.android.com/jetpack/compose) - Modern toolkitfor building native UI.
- [Coil](https://coil-kt.github.io/coil/) - Load images from network source.
- [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) - Navigation to composables.
- [Ktor Client](https://ktor.io/)
- [KotlinX Serialization](https://github.com/Kotlin/kotlinx.serialization) - Serialization/Desirialization of JSON response from network.
- [Room Multiplatform](https://developer.android.com/kotlin/multiplatform/room) - Kotlin Multiplatform library for caching structured data.
- [jUnit](https://junit.org/junit4/)
- [Mockk](https://mockk.io/) - Mocking library for Kotlin.
- [Robolectric](https://robolectric.org/) - Framework used to quickly and reliably run unit tests quick using the JVM
- [KtLint](https://github.com/pinterest/ktlint) - Kotlin linter.
- [Detekt](https://github.com/detekt/detekt) - Static code analysis tool for the Kotlin programming language

This projects uses [GitHub actions](https://github.com/VictorKabata/Tempestas/actions) to run a build, execute all tests and deploy the application with Firebase app distribution.

# Screenshots
<img src="screenshots/img1.png" width="250"> <img src="screenshots/img2.png" width="250">
