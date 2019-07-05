package com.rainowncorp.foodiey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class personal_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile);

        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView nameEditText = findViewById(R.id.nameEditText);

        try {
            emailTextView.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
            nameEditText.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        }catch (Exception e){

        }
    }
}
