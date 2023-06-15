package com.example.internetprojectpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckedTextView ctv_text = findViewById(R.id.ctv_text);
        ctv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctv_text.toggle();
            }
        });
    }
}