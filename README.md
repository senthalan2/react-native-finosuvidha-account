# react-native-finosuvidha-account

This is a React Native module that provides a seamless integration of the Fino Suvidha Account Opening SDK into your React Native Android applications.

## Installation

### Step 1

```sh
npm  install  react-native-finosuvidha-account
```

### Step 2

#### Update `AndroidManifest.xml`

In your `AndroidManifest.xml` (usually at `android/app/src/main/AndroidManifest.xml`):

1️⃣ Add the `tools` namespace inside the root `<manifest>` tag:

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
```

2️⃣ Add the `tools:replace` attribute inside the `<application>` tag:

```xml
<application
    ...
    tools:replace="android:allowBackup,android:theme">

    ...
</application>
```

**💡Note:**
 - `xmlns:tools` must be declared inside the root `<manifest>` tag.
 - `tools:replace` is used to override `android:allowBackup` and `android:theme` values defined by libraries, preventing manifest merge conflicts.

### Step 3

####  Create `file_paths.xml`

Create a new file named `file_paths.xml` at the following location: `android/app/src/main/res/xml/file_paths.xml`. If the `xml` folder doesn’t exist, create it manually.

Add the following content:

```xml
<?xml version="1.0" encoding="utf-8"?>
<paths xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Allow sharing of files from internal storage -->
    <files-path name="internal_files" path="." />

    <!-- Allow sharing of files from external app-specific storage -->
    <external-files-path name="external_files" path="." />

   <!-- Allow sharing specifically from Pictures directory -->
    <external-files-path name="pictures" path="Pictures/" />
</paths>

```

**💡 Note:** This file defines which directories your app can share files from through the `FileProvider`.

### Step 4

####  Add the `FileProvider` Entry

Now, add the following `<provider>` block inside the `<application>` tag of your `AndroidManifest.xml`:

```xml
<application
    ...
    tools:replace="android:allowBackup,android:theme">

    ...

    <provider
        android:name="androidx.core.content.FileProvider"
        android:authorities="${applicationId}.fileprovider"
        android:exported="false"
        android:grantUriPermissions="true">

        <meta-data
            android:name="android.support.FILE_PROVIDER_PATHS"
            android:resource="@xml/file_paths" />
    </provider>

</application>

```

**💡 Note:**
 - `${applicationId}` will automatically resolve to your app’s package name (e.g., `com.example.myapp`), so you don’t need to replace it manually.
 - The `<meta-data>` tag links your `FileProvider` to the `file_paths.xml` file, defining which files your app can share securely.

### Troubleshooting
- Manifest merge conflict on `android:allowBackup` or `android:theme`: 
  Ensure you added `tools:replace="android:allowBackup android:theme"` inside the `<application>` tag and `xmlns:tools="http://schemas.android.com tools"` in the `<manifest>` tag.
- FileProvider authority conflicts:  
  Make sure `${applicationId}.fileprovider` matches your app’s package name and that no other provider in your project uses the same authority.


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


## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)
- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)
- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT

---
