var exec = require('cordova/exec');

exports.isPowerSaveMode = function(success, error) {
  exec(success, error, 'PowerSaveMode', 'isPowerSaveMode');
};

exports.getLocationPowerSaveMode = function(success, error) {
  exec(success, error, 'PowerSaveMode', 'getLocationPowerSaveMode');
};

exports.isDeviceIdleMode = function(success, error) {
  exec(success, error, 'PowerSaveMode', 'isDeviceIdleMode');
};

exports.isIgnoringBatteryOptimizations = function(packageName, success, error) {
  exec(success, error, 'PowerSaveMode', 'isIgnoringBatteryOptimizations', [packageName]);
};

exports.isInteractive = function(success, error) {
  exec(success, error, 'PowerSaveMode', 'isInteractive');
};

exports.getAppStandbyBucket = function(success, error) {
  exec(success, error, 'PowerSaveMode', 'getAppStandbyBucket');
};