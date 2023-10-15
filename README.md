# cordova-plugin-get-env

[![npm](https://img.shields.io/npm/v/cordova-plugin-get-env.svg)](https://www.npmjs.com/package/cordova-plugin-get-env)
[![npm](https://img.shields.io/npm/dt/cordova-plugin-get-env.svg)](https://www.npmjs.com/package/cordova-plugin-get-env)

A simple Cordova plugin for reading Android environment variables.

## Installation

To use this plugin in your Cordova project:

```shell
cordova plugin add cordova-plugin-get-env
```

## Usage

To read the value of an Android environment variable:

```javascript
// Get an environment variable
cordova.plugins.GetEnv.getEnv('ANDROID_HOME', (result) => {
    console.log('ANDROID_HOME: ' + value);
});
```
