/**
 * This class contains methods for handling a Broadcast Receiver used to notify changes in Airplane Mode toggling
 * MAD-E8
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e7_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.mad_e7_broadcastreceiver.AirModeChangedReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView home_toggleText;
    ImageView home_image;
    AirModeChangedReceiver ob = new AirModeChangedReceiver(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home_toggleText = findViewById(R.id.home_textview);
        home_image = findViewById(R.id.home_image);
        MediaManager(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(ob, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(ob);
    }

    // EXTRA QoL improvements
    // to update homepage image and text whenever Airplane mode is toggled
    void MediaManager(boolean isAirplaneModeOn) {
        if (isAirplaneModeOn) {
            home_toggleText.setText("Bravo 6 Online!");
            home_toggleText.setBackgroundColor(ContextCompat.getColor(this, R.color.piper_teal));
            home_image.setImageResource(R.drawable.airmode_on);
        } else {
            home_toggleText.setText("Bravo 6 Offline...");
            home_toggleText.setBackgroundColor(ContextCompat.getColor(this, R.color.piper_red));
            home_image.setImageResource(R.drawable.airmode_off);
        }
    }
}