package com.example.eligoodwin.toymusicplayer;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by eligoodwin on 11/22/17.
 */

public class DownloadHandler extends Handler {
    private DownloadService service;

    @Override
    public void handleMessage(Message msg) {
        downloadSong(msg.obj.toString());
        service.stopSelf(msg.arg1);

    }

    private void downloadSong(String song) {
        long endTime = System.currentTimeMillis() + 10*1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.d(TAG, "Download complete: " + song);

    }

    public void setService(DownloadService service) {
        this.service = service;
    }
}


