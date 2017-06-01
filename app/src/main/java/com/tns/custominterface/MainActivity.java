package com.tns.custominterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CustomModel.CustomInterfeceListner{

    TextView text_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomModel.getGetCustomModelInstance().setCustomInterfeceListner(this);
           text_tv=(TextView)findViewById(R.id.text_tv);

        boolean modelState = CustomModel.getGetCustomModelInstance().getstate();
        Log.d("MainActivity", "Current state: " + String.valueOf(modelState));

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void statechanged(String s) {
        boolean modelState = CustomModel.getGetCustomModelInstance().getstate();
        Log.d("MainActivity", "MainActivity says: Model state changed: " +
                String.valueOf(modelState));
        Log.d("MainActivity", "MainActivity says: GetValue " +s);
        text_tv.setText(s);
    }


}
