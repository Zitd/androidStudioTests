package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//Contiene la info de cuando se esta gruardando la app
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();//este elemento nos permite guaradar fdatos
        if (extras != null) {
            int edad = extras.getInt("edad");
            textView.setText(String.valueOf(edad));
        }
    }
    public void irActivity(View view) {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        intent.putExtra("clase","Va todo ok");
        setResult(RESULT_OK,intent);
        finish();
    }


}
