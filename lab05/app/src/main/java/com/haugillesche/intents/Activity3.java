package com.haugillesche.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    private String strReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    /**
     * Open activity 4
     * @param v
     */
    public void openActivity4(View v) {
        Intent activity4Intent = new Intent(this, Activity4.class);
        startActivityForResult(activity4Intent, 4);
    }

    /**
     * Open activity 4
     * @param v
     */
    public void openActivity5(View v) {
        Intent activity5Intent = new Intent(this, Activity5.class);
        startActivityForResult(activity5Intent, 5);
    }

    /**
     * Get results from started activities
     * @param requestCode
     * @param resultCode
     * @param i
     */
    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 4) {
            if(resultCode == RESULT_OK){
                strReturn = i.getStringExtra("a4Return");
            }
        }
        else if (requestCode == 5) {
            if(resultCode == RESULT_OK){
                strReturn = i.getStringExtra("a5Return");
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("a3Return",strReturn);
        setResult(RESULT_OK, i);
        finish();
    }
}
