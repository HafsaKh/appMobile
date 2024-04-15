package com.example.quizapp_khallouki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class REGISTER extends AppCompatActivity {

    EditText etMail, etPassword, etPassword1;
    Button bRegister;

    TextView tvResign;

    ImageView imageView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etMail=(EditText) findViewById(R.id.etMail);
        etPassword=(EditText) findViewById(R.id.etPassword);
        etPassword1=(EditText)findViewById(R.id.etPassword1);
        bRegister=(Button)findViewById(R.id.bRegister);
        tvResign= findViewById(R.id.TvResign);
        imageView = findViewById(R.id.logoId);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/quizapp-hafsa.appspot.com/o/Chevrolet.jpeg?alt=media&token=e5d430b4-3368-481e-9123-e551de6b7754")
                .into(imageView );

        mAuth = FirebaseAuth.getInstance();

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=etMail.getText().toString();
                String password=etPassword.getText().toString();
                String password1=etPassword1.getText().toString();
                signUp(etMail.getText().toString(), etPassword.getText().toString());
                Toast.makeText(getApplicationContext(),"Registration Successful!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(REGISTER.this,MainActivity.class));
                finish();
            }
        });
        tvResign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(REGISTER.this, MainActivity.class));
                finish();
            }
        });
    }

    private void signUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign up success, update UI with the signed-up user's information
                            Toast.makeText(REGISTER.this, "Sign up success!", Toast.LENGTH_SHORT).show();
                            // You can add code here to navigate to another activity
                        } else {
                            // If sign up fails, display a message to the user.
                            Toast.makeText(REGISTER.this, "Sign up failed. Please try again.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}