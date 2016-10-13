package edu.orangecoastcollege.cs723.tmorrissey1.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller for activity_splash.xml
 *
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Loads the view to display a splash screen when the app first starts
     * @param savedInstanceState last saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask mediaTask = new TimerTask() {
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MusicActivity.class));
            }
        };
        Timer timer = new Timer();
        timer.schedule(mediaTask, 3000);


    }
}
