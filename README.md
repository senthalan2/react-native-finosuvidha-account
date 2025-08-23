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

import { startAccountOpening } from  'react-native-finosuvidha-account';

// ...

startAccountOpening(<enc_token>, <latitude>, <longitude>)
	.then(res  =>  {
		console.log(res,  'RESPONSE');
	})
	.catch(e  =>  {
		console.log(e,  'ERROR');
	});

```

## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)
- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)
- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT

---
