package com.example.quizapp_khallouki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class SCORE extends AppCompatActivity {
    Button bLogout, bTry;
    ProgressBar progressBar;
    TextView tvScore;

    ImageView imageView ;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvScore =(TextView) findViewById(R.id.tvScore);
        progressBar=(ProgressBar) findViewById(R.id.etprogress);
        bLogout=(Button) findViewById(R.id.bLogout);
        bTry=(Button) findViewById(R.id.bTry);
        imageView = findViewById(R.id.logoId);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/quizzappelkharrati.appspot.com/o/i2.PNG?alt=media&token=73b9e3d3-70e4-41fc-baeb-2fcbf94024d6")
                .into(imageView );
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;
        progressBar.setProgress(100*score/5);
        tvScore.setText(100*score/5+" %");
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Merci de votre Participation !", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SCORE.this,MainActivity.class));
                finish();
            }
        });
        bTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SCORE.this, QUIZ.class));
            }
        });

    }

}