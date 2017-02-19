package com.example.mariusz.deviceadminlearning;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by mariusz on 19.02.17.
 */
public class MyDeviceAdminService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("jestem", "no elo co tam jak tam?");
        return super.onStartCommand(intent, flags, startId);
    }
}
