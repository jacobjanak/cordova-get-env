# Check for power saving mode
Lean plugin to check if device is in power save mode.

Supports:
- Android
- iOS

## Usage
```
cordova.plugins.PowerSaveMode.isPowerSaveMode((flag) => {
    if (flag) {
      console.log('Device is in power save mode.');
    }
  });
```

## Maintainer
- Julian Scheuchenzuber <js@lvl51.de> (Android guy)
- Daniel Kliemsch <dk@lvl51.de> (iOS guy)