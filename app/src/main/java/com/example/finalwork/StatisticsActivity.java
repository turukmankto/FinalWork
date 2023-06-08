package com.example.finalwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Intent intent = getIntent();
        boolean[] answers = intent.getBooleanArrayExtra("answers");

        List<View> textList = new ArrayList<View>(){{
            add(findViewById(R.id.textQuestion1));
            add(findViewById(R.id.textQuestion2));
            add(findViewById(R.id.textQuestion3));
            add(findViewById(R.id.textQuestion4));
            add(findViewById(R.id.textQuestion5));
            add(findViewById(R.id.textQuestion6));
            add(findViewById(R.id.textQuestion7));
            add(findViewById(R.id.textQuestion8));
            add(findViewById(R.id.textQuestion9));
            add(findViewById(R.id.textQuestion10));
        }};

        for (int i = 0; i < textList.size(); i++) {
            if (answers[i]) {
                textList.get(i).setBackgroundResource(R.color.green);
            } else {
                textList.get(i).setBackgroundResource(R.color.red);
            }
        }

        Button button = findViewById(R.id.toMain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}