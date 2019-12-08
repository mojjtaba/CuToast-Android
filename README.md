CuToast
=====
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)


<p align="center"><img src="http://gapgame.ir/CuToast/CuToast1.png"></p>

<p align="center"><img src="https://b2n.ir/024263"></p>
You can watch the demo from
[YouTube](https://github.com/square/picasso)

Custom Toast Library for Android
----
A great library for making beautiful toast in the Android app, with lots of customization and multiple toast ready

Prerequisites
-----
Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Dependency
----

Add this to your module's build.gradle file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.mojjtaba:CuToast-Android:0.2.0'
}
```
Usage
 -----
A simple example to use this library:
```java
CuToast.showSuccess(this,"message text");
CuToast.showError(this,"message text");
CuToast.showWarning(this,"message text");

CuToast.showCustom(this,"title text","message text",Toast.LENGTH_SHORT
,getResources().getColor(R.color.red)
,R.drawable.icon);
```


 Additional explanation
 -----
**success Toast :**
```java
CuToast.showSuccess(this
,"title text"
,"message text"
,Toast.LENGTH_SHORT);
```

|  CuToast.showSuccess(  | Activity         |  Title              |  Message            |  Duration                                          | ) |
| -----------------------| ---------------- | ------------------- | ------------------- | -------------------------------------------------- |--- |
|************************| required-Context |  Optional-String    |  required-String    |  Optional-Toast.LENGTH_SHORT or Toast.LENGTH_LONG  |*** |

**warning Toast :**
```java
CuToast.showWarning(this
,"title text"
,"message text"
,Toast.LENGTH_SHORT);
```

|   CuToast.showWarning(    |  Activity         |  Title              |  Message            | Duration                                          |  )  |
| ------------------------- | ----------------- | ------------------- | ------------------- |-------------------------------------------------- | --- |
| ************************* |  required-Context |  Optional-String    |  required-String    | Optional-Toast.LENGTH_SHORT or Toast.LENGTH_LONG  | *** |

**error Toast :**
```java
CuToast.showError(this
,"title text"
,"message text"
,Toast.LENGTH_SHORT);
```

|   CuToast.showError(      | Activity         |  Title             | Message           | Duration                                         |  )  |
| ------------------------- | ---------------- | ------------------ | ----------------- | ------------------------------------------------ | --- |
| ************************* | required-Context |  Optional-String   | required-String   | Optional-Toast.LENGTH_SHORT or Toast.LENGTH_LONG | *** |

But if you want to do more personalization you can use custom mode

# Custom Toast
```java
CuToast.showCustom(this,"title text"
,"message text"
,Toast.LENGTH_SHORT,getResources().getColor(R.color.red)
,R.drawable.icon);
```
|   CuToast.showCustom(     |  Activity         |  Title             | Message           |  Duration                                          | color              |  res(icon)         |  )  |
| ------------------------- | ----------------- | ------------------ | ----------------- | -------------------------------------------------- | ------------------ | ------------------ | --- |
| ************************* |  required-Context |  Optional-String   | required-String   |  Optional-Toast.LENGTH_SHORT or Toast.LENGTH_LONG  | required-res color |  Optional-int res  | *** |

General settings
------
Sound
You can use the following command to enable or disable toast sound:
```java
CuToast.sound= true ;//or false
```

Dark Mode
Use the following command to enable or disable dark mode:

```java
CuToast.darkMode= true ;//or false
```

rtl
If your language is right-to-left, use the following command (Farsi and Arabic):

```java
CuToast.rtl= true ;//or false
```

title size
The following command can be used to change the font size of the title: The default value is 16 sp:

```java
CuToast.titleSize= 18 ;//16 default
```

message size
The following command can be used to change the font size of the message: The default value is 14 sp:

```java
CuToast.messageSize= 16 ;//14 default
```



image scayle
To change your Icon Scale you need to use the following command:

```java
CuToast.scaleType = ImageView.ScaleType.CENTER ;
```




:heart: Donations
------


This project needs you! If you would like to support this project's further development, the creator of this project or the continuous maintenance of this project, feel free to donate. Your donation is highly appreciated  . Thank you!

If you like the project you can support us by purchasing a PlayStation Store Gift Card [Digital Code] (3$ to 100$) and emailing us mojapk74@gmail.com.