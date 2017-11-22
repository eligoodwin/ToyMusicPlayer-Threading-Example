package com.example.eligoodwin.toymusicplayer;

import android.os.Looper;
import android.util.Log;

/**
 * Created by eligoodwin on 11/22/17.
 */

public class DownloadThread extends Thread {
    private final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler handler;

    @Override
    public void run(){
        Looper.prepare(); //creates the message quueue
        handler = new DownloadHandler();
        Looper.loop();
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
