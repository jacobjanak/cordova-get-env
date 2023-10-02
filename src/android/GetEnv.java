package en.jacobjanak.getenv;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

public class GetEnv extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getEnv")) {
            this.getEnv(callbackContext, args.getString(0));
            return true;
        }

        return false;
    }

    private void getEnv(CallbackContext callbackContext, String variableName) {
        String variableValue = System.getenv(variableName);
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, variableValue));
    }
}
