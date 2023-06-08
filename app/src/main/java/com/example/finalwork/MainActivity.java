package com.example.finalwork;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SelectionActivity.class);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        };

        Button buttonMain = findViewById(R.id.mainButton1);
        buttonMain.setOnClickListener(listener);

    }
}