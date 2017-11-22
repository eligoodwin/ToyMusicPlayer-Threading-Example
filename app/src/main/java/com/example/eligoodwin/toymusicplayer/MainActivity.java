package com.example.eligoodwin.toymusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button playMusic;
    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playMusic =(Button)findViewById(R.id.playMusic);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading the song", Toast.LENGTH_SHORT).show();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        downloadSong();
                    }
                };

                Thread thread = new Thread(runnable);
                thread.setName("Download Thread");
                thread.start();
            }
        });

    }

    private void downloadSong() {
        long endTime = System.currentTimeMillis() + 10*1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "Download complete");

    }
}
