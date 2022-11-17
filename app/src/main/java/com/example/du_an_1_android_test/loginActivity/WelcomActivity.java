package com.example.du_an_1_android_test.loginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.du_an_1_android_test.R;

public class WelcomActivity extends AppCompatActivity {
    TextView txtlogin;
    Button btnres;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        txtlogin = findViewById(R.id.txtlogin);
        btnres = findViewById(R.id.btnres);
        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(WelcomActivity.this , ReginstrationActivity.class);
                startActivity(intent);

            }
        });
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomActivity.this , Login.class);
                startActivity(intent);
            }
        });


    }
}