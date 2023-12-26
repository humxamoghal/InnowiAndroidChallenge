# InnowiChallenge

## Overview
The InnowiChallenge Android app is developed as part of a coding challenge, showcasing the utilization of various tools and technologies to create a robust and efficient application.

### Technologies Used
- **Kotlin:** Primary programming language used for development.
- **Jetpack Compose:** UI toolkit used for building the app's UI.
- **MVVM:** Architecture pattern utilized for separating concerns.
- **Clean Architecture:** Ensuring separation of concerns and maintainability.
- **Flow & StateFlow:** Utilized for reactive streams and managing UI state.
- **Coroutines:** Used for asynchronous programming.
- **Hilt for DI:** Dependency injection framework for better code structure.
- **Configuration Changes Handled:** Managed configuration changes for a seamless user experience.
- **Room:** Local database implementation for data storage.
- **MockK| Mockito:** Libraries used for mocking objects in tests.

### App Features
- Handles error cases gracefully and supports offline mode.
- Creation of a Tabular View using Jetpack Compose.
- Handling large JSON responses by first saving them locally for subsequent offline use.

## Future Considerations
The following are planned improvements and enhancements for the project:
- Shifting the project to a multi-module architecture for better scalability and organization.
- Implementing navigation graph with Jetpack Compose for improved navigation structure.
- Adding custom pagination for lazy column to handle large local Room database efficiently.
- Implementing security measures within the app to prevent potential attacks.
- Incorporating Proguard rules for code obfuscation and enhanced security.
- Setting up CI/CD using GitHub Actions for automated builds and deployments.

Note: Due to time constraints, certain features like custom pagination for handling large data have been deferred for future development.

## How to Use
Intall latest stable build for android studio hedge hog and you are ready to go. 

## Contributions
You are welcome!

## License
This project is licensed.
