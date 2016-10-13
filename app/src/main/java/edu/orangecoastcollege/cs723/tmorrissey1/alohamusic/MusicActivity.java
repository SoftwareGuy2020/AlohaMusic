package edu.orangecoastcollege.cs723.tmorrissey1.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Manages inputs/outputs from the view
 */
public class MusicActivity extends AppCompatActivity {

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;

    private Button hulaButton;
    private Button ukuleleButton;
    private Button ipuButton;

    private VideoView hulaVideoView;

    /**
     * Perform initialization of all fragments and loaders.
     * @param savedInstanceState last saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        hulaButton = (Button) findViewById(R.id.hulaButton);
        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);

        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);

        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.hula));
        hulaVideoView.setMediaController(new MediaController(this));

    }

    /**
     * Plays the media associated with the view that was clicked
     * @param v
     */
    public void playMedia(View v) {

        switch (v.getId()) {

            case R.id.ukuleleButton:
                if (ukuleleMP.isPlaying()) {
                    ukuleleMP.pause();
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }

                else {
                    ukuleleMP.start();

                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.ipuButton:

                if (ipuMP.isPlaying()) {
                    ipuMP.pause();

                    ipuButton.setText(R.string.ipu_button_play_text);
                    hulaButton.setVisibility(View.VISIBLE);
                    ukuleleButton.setVisibility(View.VISIBLE);
                }

                else {
                    ipuMP.start();

                    ipuButton.setText(R.string.ipu_button_pause_text);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                }

                break;

            case R.id.hulaButton :
                if (hulaVideoView.isPlaying()) {
                    hulaVideoView.pause();

                    hulaButton.setText(R.string.hula_button_watch_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }

                else {
                    hulaVideoView.start();

                    hulaButton.setText(R.string.hula_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }

                break;
        }
    }
}
