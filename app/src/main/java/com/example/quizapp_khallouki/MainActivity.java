package com.example.quizapp_khallouki;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText etLogin,etPassword;
    Button bLogin;
    TextView tvRegister;
    ImageView imageView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2-Recuperation des id
        etLogin=findViewById(R.id.ETEmail);
        etPassword=findViewById(R.id.ETPassword);
        bLogin=findViewById(R.id.BtnSignIn);
        tvRegister=findViewById(R.id.TvRegister);
        mAuth = FirebaseAuth.getInstance();
        imageView = findViewById(R.id.logoId);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/quizapp-hafsa.appspot.com/o/Chevrolet.jpeg?alt=media&token=e5d430b4-3368-481e-9123-e551de6b7754")
                .into(imageView );
        //3-Association de listners
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4-Traitement
//                if(etLogin.getText().toString().equals("toto")&& etPassword.getText().toString().equals("123")){
//                    startActivity(new Intent(MainActivity.this, Quizz1.class));
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"Login or Password incorrect!",Toast.LENGTH_SHORT).show();
//                }
                signIn(etLogin.getText().toString(), etPassword.getText().toString());


            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4-Traitement
                startActivity(new Intent(MainActivity.this,REGISTER.class));
            }
        });
    }
    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Sign in success!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, QUIZ.class));

                            // You can add code here to navigate to another activity
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Sign in failed. Please try again.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}