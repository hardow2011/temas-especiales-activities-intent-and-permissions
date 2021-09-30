package com.example.activities_intent_and_permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}