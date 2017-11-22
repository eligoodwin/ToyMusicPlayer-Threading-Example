package com.example.eligoodwin.toymusicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by eligoodwin on 11/22/17.
 */

public class DownloadService extends Service {
    private final String TAG = DownloadService.class.getSimpleName();
    private DownloadHandler handler;

    @Override
    public void onCreate() {
        DownloadThread thread = new DownloadThread();
        thread.setName("downloadThread");
        thread.start();
        while(thread.handler == null){

        }
        handler = thread.handler;
        handler.setService(this);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        Message message = Message.obtain();
        message.obj = song;
        message.arg1 = startId;
        handler.sendMessage(message);
        return Service.START_REDELIVER_INTENT;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
