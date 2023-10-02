var exec = require('cordova/exec');

exports.getEnv = function(variableName, success, error) {
  exec(success, error, 'GetEnv', 'getEnv', [variableName]);
};
