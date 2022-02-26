package com.cook.cookingassistant.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cook.cookingassistant.R;

public class
ProcedureActivity extends AppCompatActivity {
    LinearLayout layoutContainer;
    Button btAdd;
    int ingredients_count=0,steps_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cooking Steps");
        actionBar.setDisplayHomeAsUpEnabled(true);

        btAdd=findViewById(R.id.btAdd);
        layoutContainer=findViewById(R.id.layoutContainer);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ingredients_count=ingredients_count+1;
                final View addView = layoutInflater.inflate(R.layout.row_cook_steps, null);
                layoutContainer.addView(addView, 0);
            }
        });
    }
}