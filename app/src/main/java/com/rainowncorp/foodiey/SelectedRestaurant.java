package com.rainowncorp.foodiey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

public class SelectedRestaurant extends AppCompatActivity {
    Dialog cartPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_restaurant);

        cartPopup= new Dialog(this);


        findViewById(R.id.card_view1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });

        findViewById(R.id.card_view2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });

        findViewById(R.id.card_view3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });

        findViewById(R.id.card_view4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });

        findViewById(R.id.card_view5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });

        findViewById(R.id.card_view6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });

        findViewById(R.id.card_view7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });

        findViewById(R.id.card_view8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,selectedMenuItem.class));
            }
        });
    }

    public void ShowPopup(View v){
        TextView textClose;
        Button buttonCheckOut;
        cartPopup.setContentView(R.layout.cartpopup);
        textClose = (TextView) cartPopup.findViewById(R.id.textClose);
        buttonCheckOut = (Button) cartPopup.findViewById(R.id.buttonCheckOut);
        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartPopup.dismiss();
            }
        });
        buttonCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectedRestaurant.this,checkout.class));
            }
        });
        cartPopup.show();
    }
}
