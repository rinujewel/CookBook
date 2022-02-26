package com.cook.cookingassistant.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.widget.Button;

import com.cook.cookingassistant.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              //  _cheenivala.setVisibility(View.VISIBLE);
                //_cheenivala.startAnimation(animBounce);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      //  _title_kochi.setVisibility(View.VISIBLE);
                        //_title_kochi.startAnimation(animBounce1);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(SplashScreenActivity.this, NavigationActivity.class));
                                //openNextWindow();
                            }
                        }, 2000);
                    }
                }, 1000);
            }
        }, 500);

    }

    public void openNextWindow(){
        if(isNetworkAvailable()) {
            //if (new SessionManager(SplashScreenActivity.this).isPincodeSelected()){
            startActivity(new Intent(SplashScreenActivity.this, NavigationActivity.class));
           // overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            SplashScreenActivity.this.finish();
            /*}else {
            startActivity(new Intent(SplashScreenActivity.this, LocationVerifyActivity.class));
            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            SplashScreenActivity.this.finish();
        }           */
        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("No Internet Connection. Please check your internet conections")
                    .setCancelable(false);
            builder.setPositiveButton(Html.fromHtml("<font color='#ED3326'>Ok</font>"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    openNextWindow();
                }
            });
            AlertDialog alert = builder.create();

            alert.show();
            Button positiveButton = alert.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setTextColor(Color.parseColor("#918686"));// dark red color

        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}






