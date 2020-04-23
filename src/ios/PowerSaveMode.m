#import "PowerSaveMode.h"
#import <Cordova/CDV.h>

@implementation PowerSaveMode

- (void)isPowerSaveMode:(CDVInvokedUrlCommand*)command
{
    bool powerSaveModeStatus;
    
    if ([[NSProcessInfo processInfo] isLowPowerModeEnabled]) {
        powerSaveModeStatus = true;
    } else {
        powerSaveModeStatus = false;
    }
    
    CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:powerSaveModeStatus];

    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
