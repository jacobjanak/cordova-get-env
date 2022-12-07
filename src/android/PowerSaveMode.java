package de.lvl51.powersavemode;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.app.usage.UsageStatsManager;

public class PowerSaveMode extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isPowerSaveMode")) {
          this.isPowerSaveMode(callbackContext);
          return true;
        }

        if (action.equals("getLocationPowerSaveMode")) {
		  this.getLocationPowerSaveMode(callbackContext);
		  return true;
		}

		if (action.equals("isDeviceIdleMode")) {
		  this.isDeviceIdleMode(callbackContext);
		  return true;
		}

		if (action.equals("isIgnoringBatteryOptimizations")) {
		  this.isIgnoringBatteryOptimizations(callbackContext, args.getString(0));
		  return true;
		}

		if (action.equals("isInteractive")) {
		  this.isInteractive(callbackContext);
		  return true;
		}

		if (action.equals("getAppStandbyBucket")) {
		  this.getAppStandbyBucket(callbackContext);
		  return true;
		}

        return false;
    }

    private void isPowerSaveMode(CallbackContext callbackContext) {
        PowerManager powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);
        
        boolean powerSaveMode;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && powerManager.isPowerSaveMode()) {
          powerSaveMode = true;
        } else {
          powerSaveMode = false;
        }

        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, powerSaveMode));
    }

    private void getLocationPowerSaveMode(CallbackContext callbackContext) {
		PowerManager powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);

		int result;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
		  result = powerManager.getLocationPowerSaveMode();
		} else {
		  result = -1;
		}

		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
	}

	private void isDeviceIdleMode(CallbackContext callbackContext) {
		PowerManager powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);

		boolean result;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
		  result = powerManager.isDeviceIdleMode();
		} else {
		  result = false;
		}

		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
	}

	private void isIgnoringBatteryOptimizations(CallbackContext callbackContext, string packageName) {
		PowerManager powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);

		boolean result;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
		  result = powerManager.isIgnoringBatteryOptimizations(packageName);
		} else {
		  result = false;
		}

		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
	}

	private void isInteractive(CallbackContext callbackContext) {
		PowerManager powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);

		boolean result;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
		  result = powerManager.isInteractive();
		} else {
		  result = false;
		}

		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
	}

	private void getAppStandbyBucket(CallbackContext callbackContext) {
		UsageStatsManager usageStatsManager = (UsageStatsManager) cordova.getActivity().getSystemService(Context.USAGE_STATS_SERVICE);

		int result;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
		  result = usageStatsManager.getAppStandbyBucket();
		} else {
		  result = -1;
		}

		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
	}
}
