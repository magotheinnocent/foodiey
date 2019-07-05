package com.rainowncorp.foodiey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
private TextView textView;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        Animation splashAnim = AnimationUtils.loadAnimation(this,R.anim.splash_transition);
        textView.startAnimation(splashAnim);
        imageView.startAnimation(splashAnim);
        final Intent i = new Intent(this, intro_screen.class );
        Thread timer = new Thread(){
            public void run (){
                try{
                    sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
