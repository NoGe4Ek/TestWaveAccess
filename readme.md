# WaveAccess Test Project

## Requirements
- Language - kotlin
- Android version - 7.0+
- Design - compliance with guidelines of Material Design
- Architecture - MVP, MVVM or MVI; Clean Architecture
- DI (Dagger 2 / Kodein / Koin), Android Architecture Components, AndroidX

## Spec
Presented in [Junior_task_users.txt](https://github.com/NoGe4Ek/TestWaveAccess/blob/master/Junior_task_users.txt)

## Screenshots
![img1](https://github.com/NoGe4Ek/TestWaveAccess/blob/master/Screens/scr1_UserListFragment.png)
![img2](https://github.com/NoGe4Ek/TestWaveAccess/blob/master/Screens/scr2_UserDetailsFragment.png)
![img3](https://github.com/NoGe4Ek/TestWaveAccess/blob/master/Screens/scr3_UserDetailsFragment_friends.png)

## Used technologies
### Architecture
#### MVI
- In accordance with the simplified scheme [Badoo Mvi Core](https://badoo.github.io/MVICore/)
- [Scheme MVI](https://habr.com/ru/company/badoo/blog/429728/)
- Clean Arch

### DI
- Hilt

### Design
- Material Design Style; Theming

### Network module
- Retrofit
- OkHttp3

### Cache
- Room

### Navigation
- navigation-fragment-ktx
- navigation-ui-ktx
- navigation-safeargs-ktx
