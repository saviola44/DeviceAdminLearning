package com.example.mariusz.deviceadminlearning;

import android.app.admin.DeviceAdminReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * Created by mariusz on 19.02.17.
 */


public class MyBroadcastDeviceAdminReceiver extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        PackageManager packageManager = context.getPackageManager();
        ComponentName deviceAdminService = new ComponentName(context, MyDeviceAdminService.class);
        packageManager.setComponentEnabledSetting(deviceAdminService, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, 0);
        context.startService(new Intent(context, MyDeviceAdminService.class));
    }
    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        context.stopService(new Intent(context, MyDeviceAdminService.class));
        PackageManager packageManager = context.getPackageManager();
        ComponentName deviceAdminService = new ComponentName(context, MyDeviceAdminService.class);
        packageManager.setComponentEnabledSetting(deviceAdminService, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, 0);
    }


}