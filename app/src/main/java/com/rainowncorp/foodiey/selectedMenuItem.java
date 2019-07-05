package com.rainowncorp.foodiey;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class selectedMenuItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_menu_item);

        loadFoodFromDatabase();
    }


    private void loadFoodFromDatabase(){
        Log.d("selectedMenuItem","loading data from firebase now");
        DatabaseReference loadFoodQuery = FirebaseDatabase.getInstance().getReference().child("food").child("coffee");

        loadFoodQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(getApplicationContext(),"its loaded",Toast.LENGTH_SHORT).show();
                for(DataSnapshot snap:dataSnapshot.getChildren()){
                    Food myCappuchino = snap.getValue(Food.class);

                    Log.d("selectedMenuItem",myCappuchino.getName());
                    Toast.makeText(getApplicationContext(),myCappuchino.getName(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_SHORT).show();
                Log.e("selectedmenuitem","error:"+databaseError.getDetails());
            }
        });
    }
}
