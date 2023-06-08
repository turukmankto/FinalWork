package com.example.finalwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Intent intent1 = new Intent(this, ExamActivity.class);
        intent1.putExtra("number", 1);
        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        };

        Button button1 = findViewById(R.id.buttonExam1);
        button1.setOnClickListener(listener1);

        Intent intent2 = new Intent(this, ExamActivity.class);
        intent2.putExtra("number", 2);
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        };

        Button button2 = findViewById(R.id.buttonExam2);
        button2.setOnClickListener(listener2);

        Intent intent3 = new Intent(this, ExamActivity.class);
        intent3.putExtra("number", 3);
        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        };

        Button button3 = findViewById(R.id.buttonExam3);
        button3.setOnClickListener(listener3);

        Intent intent4 = new Intent(this, ExamActivity.class);
        intent4.putExtra("number", 4);
        View.OnClickListener listener4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
            }
        };

        Button button4 = findViewById(R.id.buttonExam4);
        button4.setOnClickListener(listener4);

    }
}