# 📸 ImageCropLib

**ImageCropLib** is a lightweight Android image cropping library that wraps the popular [uCrop](https://github.com/Yalantis/uCrop) under the hood for ease of use.  
Built with Kotlin and Jetpack APIs, this library allows Android developers to quickly add image cropping features to their apps with minimal setup.

---

## 🚀 Features

- 🔍 Pick and crop images from gallery
- 🖼️ Supports square cropping out-of-the-box (1:1 aspect ratio)
- ⚙️ Clean wrapper around uCrop — users don’t need to write crop logic
- 💡 Easy integration in just a few lines
- 🧩 Modular: use as a library via JitPack

---

## 📦 Installation

### Add JitPack to your root `build.gradle`

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

## 🔗 JitPack Link

### Dependency:
```gradle
implementation 'com.github.shivam1814:ImageCropLib:v1.0.0'
```

## 🛠️ Usage
### Step 1: Start the Crop `Activity`

```kotlin
val intent = Intent(this, com.shivam.imagecrop.ImageCropperActivity::class.java)
startActivityForResult(intent, 101) // or use the Activity Result API
```

### Step 2: Handle the Cropped Image Result

```kotlin
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 101 && resultCode == RESULT_OK) {
        val croppedUri = data?.getStringExtra("result_uri")
        croppedUri?.let {
            val uri = Uri.parse(it)
            imageView.setImageURI(uri) // or handle the image as needed
        }
    }
}
```

## 📌 Permissions

This library does not require permissions directly. However, if you combine it with camera access or file system operations, consider adding:

```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.CAMERA" />
```

## 📷 Why Crop Images?

- Creating profile pictures or avatars
- Reducing file size and UI load
- Allowing users to focus on key parts of the image
- Preparing consistent image dimensions for galleries and thumbnails

## 🧭 Coming Soon

- 📐 Custom aspect ratio support (16:9, 4:3, etc.)
- 🔵 Circular crop mode
- 📸 Direct integration with camera capture
- 🗜️ Image compression options
- 🌙 Dark mode support
