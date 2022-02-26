package com.cook.cookingassistant.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.cook.cookingassistant.R;

import java.io.FileNotFoundException;

public class AddRecipesActivity extends AppCompatActivity {
    EditText et_ingredientName,et_quantity,et_steps;
    TimePicker timePicker;
    TextView tv_addIngredients,tv_addSteps,tv_uploadImage;
    int stepsCount, ingre_count,add_count=4;
    LinearLayout layout_ingred;
    LayoutInflater layoutInflater;
    Spinner spinnerUnits;
    String[] data;
    LinearLayout layoutContainer;
    Button btSaveRecipe;
    FrameLayout frameLayout_image;
    ImageView iv_AddRecipeImage;
    // the activity result code
    int SELECT_PICTURE = 200;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Create Recipe");
        actionBar.setDisplayHomeAsUpEnabled(true);
        layout_ingred = findViewById(R.id.layout_ingr);
        tv_addIngredients = findViewById(R.id.tv_addIngredients);
        tv_addSteps = findViewById(R.id.tv_addSteps);
        btSaveRecipe=findViewById(R.id.bt_saveRecipe);
        layoutContainer=findViewById(R.id.layoutContainer);
        frameLayout_image=findViewById(R.id.frameLayout_image);
        iv_AddRecipeImage=findViewById(R.id.iv_AddRecipeImage);
        tv_uploadImage=findViewById(R.id.tv_uploadImage);

        //setting 4 rows for ingrdients by default
        for( ingre_count=0;ingre_count<3;ingre_count++)
        {
            addIngredientsRow(ingre_count);
        }

        //setting 4 rows for ingrdients by default
        for( stepsCount=0;stepsCount<3;stepsCount++)
        {
            addCookingSteps(stepsCount);
        }

        /*data = new String[]{"Kg", "Gm", "Mgm", "L", "Ml"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddRecipesActivity.this, android.R.layout.simple_spinner_item, data);
        spinnerUnits.setAdapter(adapter);
        adapter.notifyDataSetChanged();*/

        tv_addIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("IngrCount", String.valueOf(ingre_count));
               addIngredientsRow(ingre_count);
               ingre_count++;
                //  loadSpinner();
            }
        });

        tv_addSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addCookingSteps(stepsCount);
            }
        });
        btSaveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipesActivity.this, ProcedureActivity.class);
                //intent.setType("image/*");
                startActivity(intent);
            }
        });
        frameLayout_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });
    }

    private void imageChooser() {
        // this function is triggered when
        // the Select Image Button is clicked

            // create an instance of the intent of the type image
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);

            // pass the constant to compare it
            // with the returned requestCode
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    iv_AddRecipeImage.setImageURI(selectedImageUri);
                    tv_uploadImage.setVisibility(View.GONE);
                }
            }
        }
    }
    private void addCookingSteps(int stepscount) {
        LayoutInflater layoutInflater =
                (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // ingredients_count=ingredients_count+1;
        final View addView = layoutInflater.inflate(R.layout.row_cook_steps, null);
        layoutContainer.addView(addView, stepscount);
        et_steps=addView.findViewById(R.id.et_steps);
        stepscount++;
        et_steps.setHint("Step "+stepscount);
    }


    private void addIngredientsRow(int count) {
        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(R.layout.row_ingredients, null);

        et_ingredientName=addView.findViewById(R.id.et_ingredientName);
        et_quantity=addView.findViewById(R.id.et_ingredientQuantity);
        spinnerUnits =addView.findViewById(R.id.spinner_weightUnits);
        //loading spinner
        data = new String[]{"Kg", "Gm", "L", "Ml"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddRecipesActivity.this, android.R.layout.simple_spinner_item, data);
        spinnerUnits.setAdapter(adapter);
        layout_ingred.addView(addView,count);
        adapter.notifyDataSetChanged();
        count=count+1;
        et_ingredientName.setHint("Ingredient "+count);
        et_ingredientName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_ingredientName.setHint("");
            }
        });
        et_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_quantity.setText("");
            }
        });
        //loadSpinner();
    }
}
   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
            if (resultCode == Activity.RESULT_OK) {
                Uri selectedImage = data.getData();

                String filePath = getPath(selectedImage);
                String file_extn = filePath.substring(filePath.lastIndexOf(".") + 1);
                et_imagePath.setText(filePath);

                if (file_extn.equals("img") || file_extn.equals("jpg") || file_extn.equals("jpeg") || file_extn.equals("gif") || file_extn.equals("png")) {
                    //FINE
                } else {
                    //NOT IN REQUIRED FORMAT
                }
            }
    }*/


 /*   public String getPath(Uri uri) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        column_index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        imagePath = cursor.getString(column_index);

        return cursor.getString(column_index);
    }
}*/