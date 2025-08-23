# react-native-finosuvidha-account

This is a React Native module that provides a seamless integration of the Fino Suvidha Account Opening SDK into your React Native Android applications.

## Installation

```sh

npm  install  react-native-finosuvidha-account

```

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
