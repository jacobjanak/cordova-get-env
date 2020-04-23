package PowerSaveMode;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

public class PowerSaveMode extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isPowerSaveMode")) {
          this.isPowerSaveMode(callbackContext);

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
}
