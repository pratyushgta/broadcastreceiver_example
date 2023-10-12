/**
 * This class contains methods for handle broadcast responses when Airplane Mode is toggled
 * MAD-E8
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e7_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirModeChangedReceiver extends BroadcastReceiver {
    private MainActivity mainActivity;

    public AirModeChangedReceiver(MainActivity activity) {
        mainActivity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "Airplane mode turned ON!", Toast.LENGTH_SHORT).show();
            mainActivity.MediaManager(true);
        } else {
            Toast.makeText(context, "Airplane mode turned OFF!", Toast.LENGTH_SHORT).show();
            mainActivity.MediaManager(false);
        }
    }

    public static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
