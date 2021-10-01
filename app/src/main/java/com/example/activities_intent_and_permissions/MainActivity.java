package com.example.activities_intent_and_permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.view.View.OnClickListener;
import android.widget.Toast;


import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.WRITE_CONTACTS;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Switch storageSwitch;
    private Switch locationSwitch;
    private Switch cameraSwitch;
    private Switch phoneSwitch;
    private Switch contactsSwitch;

    private final int PERMISSION_REQUEST_CODE = 200;

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

    }

    private void checkAndrequestPermissions(List<String> permissionList) {
        String[] permissionArray = new String[permissionList.size()];
        permissionArray = permissionList.toArray(permissionArray);
        ActivityCompat.requestPermissions(this, permissionArray, 200);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        Intent intent = new Intent(this, PermissionsListActivity.class);
        startActivity(intent);
    }

//    @Override
//    protected void onResume()
//    {
//        super.onResume();
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//    }

    private void checkForGrantedPermissions() {
        int storagePermission = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        int locationPermission = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        int cameraPermission = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int phonePermission = ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE);
        int contactsPermission = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACTS);

        if(storagePermission == PackageManager.PERMISSION_GRANTED) {
            storageSwitch.setChecked(true);
            storageSwitch.setEnabled(false);
        }
        else {
            storageSwitch.setChecked(false);
            storageSwitch.setEnabled(true);
        }
    }

//    @Override
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        Toast.makeText(this, "Hi UI is fully loaded", Toast.LENGTH_SHORT).show();
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//        System.out.println("////////////////////////////////////////////////////");
//    }

    public void sendInfo(View v) {
        List<String > permissionList = new ArrayList<>();
        if (storageSwitch.isChecked()) {
            permissionList.add(READ_EXTERNAL_STORAGE);
        }
        if (locationSwitch.isChecked()) {
            permissionList.add(ACCESS_FINE_LOCATION);
        }
        if (cameraSwitch.isChecked()) {
            permissionList.add(CAMERA);
        }
        if (phoneSwitch.isChecked()) {
            permissionList.add(CALL_PHONE);
        }
        if (contactsSwitch.isChecked()) {
            permissionList.add(READ_CONTACTS);
        }

        if(permissionList.size() > 0) {
            checkAndrequestPermissions(permissionList);
        }


    }

}