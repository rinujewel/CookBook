package com.cook.cookingassistant.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cook.cookingassistant.R;

public class RecipesDetailViewActivity extends AppCompatActivity {
    ImageView iv_recipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("-----");
        actionBar.setDisplayHomeAsUpEnabled(true);

        iv_recipe=findViewById(R.id.iv_rowReceipe);
        iv_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecipesDetailViewActivity.this,ProcedureActivity.class);
                startActivity(intent);

            }
        });
    }
}