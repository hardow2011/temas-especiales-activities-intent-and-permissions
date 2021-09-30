package com.example.activities_intent_and_permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch storageSwitch;
    private Switch locationSwitch;
    private Switch cameraSwitch;
    private Switch phoneSwitch;
    private Switch contactsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageSwitch = findViewById(R.id.storageSwitch);
        locationSwitch = findViewById(R.id.locationSwitch);
        cameraSwitch = findViewById(R.id.cameraSwitch);
        phoneSwitch = findViewById(R.id.phoneSwitch);
        contactsSwitch = findViewById(R.id.contactsSwitch);

        final String[] perms = {"android.permissions.FINE_LOCATION, android.permissions.CAMERA"};
        final int permsRequestCode = 200;

    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId())
//    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200:
                boolean locationAndroidAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean cameraAndroidAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                break;
        }
    }

}