# react-native-finosuvidha-account

This is a React Native module that provides a seamless integration of the Fino Suvidha Account Opening SDK into your React Native Android applications.

## Installation

### Step 1

```sh
npm  install  react-native-finosuvidha-account
```

### Step 2

#### Update `AndroidManifest.xml`

In the `<manifest>` tag, add the `tools` namespace:

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
```

In the `<application>` tag, add the `tools:replace` attribute:

```xml
<application
    ...
    tools:replace="android:allowBackup,android:theme">

    ...
</application>
```

**_Note: The `xmlns:tools` declaration must be in the root `<manifest>` tag
The `tools:replace` attribute is used to override `android:allowBackup` and `android:theme` values defined by libraries, which otherwise may cause manifest merge conflicts._**

## Usage

```js

import { startAccount } from  'react-native-finosuvidha-account';

// ...

  startAccount(
     encToken, // string
     lat, // string
     lng, // string
  )
	.then(res  =>  {
		console.log(res,  'Response');
	})
	.catch(e  =>  {
		console.log(e,  'Error');
	});

```

## Response JSON Object

`startAccount()` Method Reponse

| Key               | Type    | 
|-------------------|---------| 
| status            | boolean |  
| response          | number  |          |
| message           | string  |



### ⚠️ Common Error: Manifest Merger Failed

You might encounter the following error while building your project if you have installed the [react-native-paysprint-onboarding](https://www.npmjs.com/package/react-native-paysprint-onboarding)package:

```sh
Manifest merger failed : Attribute provider#androidx.core.content.FileProvider@authorities 
value=(<your_package_name>.provider) from [dmt_casa_uat-release.aar] AndroidManifest.xml:59:13-60 
is also present at [onboardinglib-release.aar] AndroidManifest.xml:58:13-64 
value=(<your_package_name>.fileprovider).
```


#### ✅ Solution

Add the following `provider` entry inside the `application` tag of your `AndroidManifest.xml` (usually located at `android/app/src/main/AndroidManifest.xml`):

```xml

<application>

     ...

<provider
    android:name="androidx.core.content.FileProvider"
    android:authorities="${applicationId}.fileprovider"
    android:exported="false"
    android:grantUriPermissions="true"
    tools:replace="android:authorities" />

</application>


```

This resolves the manifest conflict by overriding the duplicated authorities attribute.

## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)
- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)
- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT

---
