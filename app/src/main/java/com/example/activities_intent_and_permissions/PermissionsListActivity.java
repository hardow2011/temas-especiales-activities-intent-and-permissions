package com.example.activities_intent_and_permissions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.WRITE_CONTACTS;

import java.io.File;

public class PermissionsListActivity extends AppCompatActivity {

    int storagePermission;
    int locationPermission;
    int cameraPermission;
    int phonePermission;
    int contactsPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions_list);

        int storagePermission = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        int locationPermission = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        int cameraPermission = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int phonePermission = ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE);
        int contactsPermission = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACTS);

        Intent intent = getIntent();

        findViewById(R.id.storageButton).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                if (checkPermission(storagePermission)) {

                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivity(intent);
                    return;
                }
                Toast.makeText(PermissionsListActivity.this, "You need storage permissions", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.locationButton).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                if (checkPermission(locationPermission)) {

                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                    startActivity(intent);
                    return;
                }
                Toast.makeText(PermissionsListActivity.this, "You need location permissions", Toast.LENGTH_LONG).show();
            }
        });



    }

    public boolean checkPermission(int permission) {
        if (permission == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }
}