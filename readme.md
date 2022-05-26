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
<p>
<img src="https://github.com/NoGe4Ek/TestWaveAccess/blob/master/assets/scr1_UserListFragment.jpg" alt="drawing" width="260"/>
<img src="https://github.com/NoGe4Ek/TestWaveAccess/blob/master/assets/scr2_UserDetailsFragment.jpg" alt="drawing" width="260"/>
<img src="https://github.com/NoGe4Ek/TestWaveAccess/blob/master/assets/scr3_UserDetailsFragment_friends.jpg" alt="drawing" width="260"/>
</p>

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
