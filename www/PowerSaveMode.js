var exec = require('cordova/exec');

exports.isPowerSaveMode = function(success, error) {
  exec(success, error, 'PowerSaveMode', 'isPowerSaveMode');
};
