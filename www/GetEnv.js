var exec = require('cordova/exec');

exports.getEnv = function(success, error) {
  exec(success, error, 'GetEnv', 'getEnv');
};
