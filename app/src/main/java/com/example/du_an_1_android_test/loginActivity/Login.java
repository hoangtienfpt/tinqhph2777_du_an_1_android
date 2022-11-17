package com.example.du_an_1_android_test.loginActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.du_an_1_android_test.MainActivity;
import com.example.du_an_1_android_test.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText edtmail , edtpass ;
    Button btnloin;
    TextView txtdangki;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtmail = findViewById(R.id.edtemail);
        edtpass   =findViewById(R.id.edtpass);
        btnloin = findViewById(R.id.btn_singin);
        txtdangki = findViewById(R.id.txtdangkitaikhoan);
        txtdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , ReginstrationActivity.class);
                startActivity(intent);
            }
        });
        btnloin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtmail.getText().toString().trim();
                String pass = edtpass.getText().toString().trim();
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(email , pass).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(Login.this , MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Login.this, "Đăng nhập thất bại.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

    }
}