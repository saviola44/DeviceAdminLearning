package com.example.mariusz.deviceadminlearning;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getCanonicalName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.enableAdmin)
    public void enableDeviceAdmin() {
        Intent enableDeviceAdmin = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        ComponentName deviceAdminReceiver = new ComponentName(this,
                MyBroadcastDeviceAdminReceiver.class);
        enableDeviceAdmin.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdminReceiver);
        enableDeviceAdmin.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                getString(R.string.device_admin_description));
        startActivity(enableDeviceAdmin);
    }

    public void disabeDeviceAdmin() {
        Intent enableDeviceAdmin = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        ComponentName deviceAdminReceiver = new ComponentName(this,
                MyBroadcastDeviceAdminReceiver.class);
        enableDeviceAdmin.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdminReceiver);
        enableDeviceAdmin.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                getString(R.string.device_admin_description));
        startActivity(enableDeviceAdmin);
    }

    @OnClick(R.id.changepass)
    public void changePassword() {
        DevicePolicyManager mDevicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        ComponentName deviceAdminReceiver = new ComponentName(this,
                MyBroadcastDeviceAdminReceiver.class);
        boolean isAdminActive = mDevicePolicyManager.isAdminActive(deviceAdminReceiver);
        Log.d("jestem", "changePassword method, is admin active = " + isAdminActive );

        /*if(mDevicePolicyManager.resetPassword("123456", 0)) {
            mDevicePolicyManager.lockNow();
        }*/
    }


}
