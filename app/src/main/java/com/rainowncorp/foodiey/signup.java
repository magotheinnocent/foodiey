package com.rainowncorp.foodiey;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class signup extends AppCompatActivity {
    private final String TAG = signup.class.getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth= FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser User = firebaseAuth.getCurrentUser();
                if(User != null){
                    Log.d(TAG,"User was created, taking you to login activity");
                    Intent intent =  new Intent(signup.this,login.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    firebaseAuth.getInstance().signOut();
                    startActivity(intent);
                    finish();
                }
            }
        };

        findViewById(R.id.signupCardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupUser();
            }
        });

        findViewById(R.id.alreadyMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this, login.class));
                finish();
            }
        });
    }

    private void setupUser() {
        EditText usernameView=findViewById(R.id.usernameView);
        EditText passwordView=findViewById(R.id.passwordView);
        EditText passwordView2 = findViewById(R.id.passwordView2);

        String email = usernameView.getText().toString().trim();
        String password = passwordView.getText().toString().trim();
        String password2 = passwordView2.getText().toString().trim();

        if(!password.equals(password2)){
            passwordView2.setError("Passwords must match");
        }else{
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "authentication successful");
                        createFirebaseUserProfile(task.getResult().getUser());
                    }
                }
            });
        }
    }

    private void createFirebaseUserProfile(FirebaseUser user) {
        EditText nameView = findViewById(R.id.nameView);

        String name = nameView.getText().toString().trim();

        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
        user.updateProfile(addProfileName).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d(TAG, "Created new username");
                }
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener != null) mAuth.removeAuthStateListener(mAuthListener);
    }
}
