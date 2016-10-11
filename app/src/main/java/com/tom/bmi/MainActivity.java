package com.tom.bmi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI 說明")
                        .setMessage("體重(kg)/身高的平方(m)")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
        bHelp = (Button) findViewById(R.id.b_help);
    }


    public void bmi(View v){
        String sWeight = edWeight.getText().toString();
        String sHeight = edHeight.getText().toString();
        Float weight = Float.parseFloat(sWeight);
        Float height = Float.parseFloat(sHeight);
        Float bmi = weight / (height*height);

        /*Log.d(TAG,"BMI:" + bmi.toString());
        Toast.makeText(this,bmi.toString(),Toast.LENGTH_LONG).show();

        new AlertDialog.Builder(this)
                .setMessage(bmi + "")
                .setTitle("BMI")
                .setPositiveButton("OK",null)
                .show();
        */

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.bmi_extra),bmi);
        startActivity(intent);


    }
}
